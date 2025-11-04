package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.survey.SurveyInstanceActionQueueDao;
import org.finos.waltz.data.survey.SurveyInstanceDao;
import org.finos.waltz.data.survey.SurveyInstanceOwnerDao;
import org.finos.waltz.data.survey.SurveyInstanceRecipientDao;
import org.finos.waltz.data.survey.SurveyQuestionDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.data.survey.SurveyRunDao;
import org.finos.waltz.data.survey.SurveyTemplateDao;
import org.finos.waltz.data.survey.SurveyViewDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.survey.SurveyInstance;
import org.finos.waltz.model.survey.SurveyInstanceAction;
import org.finos.waltz.model.survey.SurveyInstanceActionParams;
import org.finos.waltz.model.survey.SurveyInstanceActionQueueItem;
import org.finos.waltz.model.survey.SurveyInstanceActionStatus;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyInstanceActionQueueServiceDiffblueTest {
  /**
   * Method under test: {@link SurveyInstanceActionQueueService#performActions()}
   */
  @Test
  void testPerformActions() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = mock(SurveyInstanceActionQueueDao.class);
    when(surveyInstanceActionQueueDao.findPendingActions()).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class), mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao, new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act
    (new SurveyInstanceActionQueueService(surveyInstanceActionQueueDao, surveyInstanceService, changeLogService3,
        new DefaultDSLContext(SQLDialect.SQL99))).performActions();

    // Assert
    verify(surveyInstanceActionQueueDao).findPendingActions();
  }

  /**
   * Method under test: {@link SurveyInstanceActionQueueService#performActions()}
   */
  @Test
  void testPerformActions2() throws SQLException {
    // Arrange
    SurveyInstanceActionQueueItem surveyInstanceActionQueueItem = mock(SurveyInstanceActionQueueItem.class);
    when(surveyInstanceActionQueueItem.submittedBy()).thenReturn("Submitted By");
    when(surveyInstanceActionQueueItem.surveyInstanceId()).thenReturn(1L);
    when(surveyInstanceActionQueueItem.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyInstanceActionQueueItem.id()).thenReturn(ofResult);

    ArrayList<SurveyInstanceActionQueueItem> surveyInstanceActionQueueItemList = new ArrayList<>();
    surveyInstanceActionQueueItemList.add(surveyInstanceActionQueueItem);
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = mock(SurveyInstanceActionQueueDao.class);
    doNothing().when(surveyInstanceActionQueueDao)
        .updateActionStatus(Mockito.<DSLContext>any(), Mockito.<Long>any(), Mockito.<SurveyInstanceActionStatus>any(),
            Mockito.<String>any());
    doNothing().when(surveyInstanceActionQueueDao).markActionInProgress(Mockito.<DSLContext>any(), Mockito.<Long>any());
    when(surveyInstanceActionQueueDao.findPendingActions()).thenReturn(surveyInstanceActionQueueItemList);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class), mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao, new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService3 = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();

    // Act
    (new SurveyInstanceActionQueueService(surveyInstanceActionQueueDao, surveyInstanceService, changeLogService3,
        new DefaultDSLContext(connection, SQLDialect.SQL99))).performActions();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceActionQueueDao).findPendingActions();
    verify(surveyInstanceActionQueueDao).markActionInProgress(isA(DSLContext.class), eq(1L));
    verify(surveyInstanceActionQueueDao).updateActionStatus(isA(DSLContext.class), eq(1L),
        eq(SurveyInstanceActionStatus.PRECONDITION_FAILURE),
        eq("Failed to apply queued action: SUBMITTING. Could not find survey instance with id: 1"));
    verify(surveyInstanceDao).getById(eq(1L));
    verify(surveyInstanceActionQueueItem).id();
    verify(surveyInstanceActionQueueItem).action();
    verify(surveyInstanceActionQueueItem).submittedBy();
    verify(surveyInstanceActionQueueItem, atLeast(1)).surveyInstanceId();
  }

  /**
   * Method under test: {@link SurveyInstanceActionQueueService#performActions()}
   */
  @Test
  void testPerformActions3() throws SQLException {
    // Arrange
    SurveyInstanceActionQueueItem surveyInstanceActionQueueItem = mock(SurveyInstanceActionQueueItem.class);
    when(surveyInstanceActionQueueItem.submittedBy()).thenReturn("Submitted By");
    when(surveyInstanceActionQueueItem.surveyInstanceId()).thenReturn(1L);
    when(surveyInstanceActionQueueItem.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyInstanceActionQueueItem.id()).thenReturn(ofResult);
    SurveyInstanceActionQueueItem surveyInstanceActionQueueItem2 = mock(SurveyInstanceActionQueueItem.class);
    when(surveyInstanceActionQueueItem2.submittedBy()).thenReturn("Submitted By");
    when(surveyInstanceActionQueueItem2.surveyInstanceId()).thenReturn(1L);
    when(surveyInstanceActionQueueItem2.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyInstanceActionQueueItem2.id()).thenReturn(ofResult2);

    ArrayList<SurveyInstanceActionQueueItem> surveyInstanceActionQueueItemList = new ArrayList<>();
    surveyInstanceActionQueueItemList.add(surveyInstanceActionQueueItem2);
    surveyInstanceActionQueueItemList.add(surveyInstanceActionQueueItem);
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = mock(SurveyInstanceActionQueueDao.class);
    doNothing().when(surveyInstanceActionQueueDao)
        .updateActionStatus(Mockito.<DSLContext>any(), Mockito.<Long>any(), Mockito.<SurveyInstanceActionStatus>any(),
            Mockito.<String>any());
    doNothing().when(surveyInstanceActionQueueDao).markActionInProgress(Mockito.<DSLContext>any(), Mockito.<Long>any());
    when(surveyInstanceActionQueueDao.findPendingActions()).thenReturn(surveyInstanceActionQueueItemList);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class), mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao, new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService3 = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();

    // Act
    (new SurveyInstanceActionQueueService(surveyInstanceActionQueueDao, surveyInstanceService, changeLogService3,
        new DefaultDSLContext(connection, SQLDialect.SQL99))).performActions();

    // Assert
    verify(connection, atLeast(1)).commit();
    verify(connection, atLeast(1)).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(changeLogDao, atLeast(1)).write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any());
    verify(surveyInstanceActionQueueDao).findPendingActions();
    verify(surveyInstanceActionQueueDao, atLeast(1)).markActionInProgress(Mockito.<DSLContext>any(), eq(1L));
    verify(surveyInstanceActionQueueDao, atLeast(1)).updateActionStatus(Mockito.<DSLContext>any(), eq(1L),
        eq(SurveyInstanceActionStatus.PRECONDITION_FAILURE),
        eq("Failed to apply queued action: SUBMITTING. Could not find survey instance with id: 1"));
    verify(surveyInstanceDao, atLeast(1)).getById(eq(1L));
    verify(surveyInstanceActionQueueItem2).id();
    verify(surveyInstanceActionQueueItem).id();
    verify(surveyInstanceActionQueueItem2).action();
    verify(surveyInstanceActionQueueItem).action();
    verify(surveyInstanceActionQueueItem2).submittedBy();
    verify(surveyInstanceActionQueueItem).submittedBy();
    verify(surveyInstanceActionQueueItem2, atLeast(1)).surveyInstanceId();
    verify(surveyInstanceActionQueueItem, atLeast(1)).surveyInstanceId();
  }

  /**
   * Method under test: {@link SurveyInstanceActionQueueService#performActions()}
   */
  @Test
  void testPerformActions4() throws SQLException {
    // Arrange
    SurveyInstanceActionParams surveyInstanceActionParams = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(surveyInstanceActionParams.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(surveyInstanceActionParams.newDueDate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyInstanceActionParams.reason()).thenReturn(ofResult3);
    Optional<SurveyInstanceActionParams> ofResult4 = Optional.of(surveyInstanceActionParams);
    SurveyInstanceActionQueueItem surveyInstanceActionQueueItem = mock(SurveyInstanceActionQueueItem.class);
    when(surveyInstanceActionQueueItem.actionParams()).thenReturn(ofResult4);
    when(surveyInstanceActionQueueItem.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(surveyInstanceActionQueueItem.submittedBy()).thenReturn("Submitted By");
    when(surveyInstanceActionQueueItem.surveyInstanceId()).thenReturn(1L);
    when(surveyInstanceActionQueueItem.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(surveyInstanceActionQueueItem.id()).thenReturn(ofResult5);
    SurveyInstanceActionParams surveyInstanceActionParams2 = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> ofResult6 = Optional.of(LocalDate.of(1970, 1, 1));
    when(surveyInstanceActionParams2.newApprovalDueDate()).thenReturn(ofResult6);
    Optional<LocalDate> ofResult7 = Optional.of(LocalDate.of(1970, 1, 1));
    when(surveyInstanceActionParams2.newDueDate()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(surveyInstanceActionParams2.reason()).thenReturn(ofResult8);
    Optional<SurveyInstanceActionParams> ofResult9 = Optional.of(surveyInstanceActionParams2);
    SurveyInstanceActionQueueItem surveyInstanceActionQueueItem2 = mock(SurveyInstanceActionQueueItem.class);
    when(surveyInstanceActionQueueItem2.actionParams()).thenReturn(ofResult9);
    when(surveyInstanceActionQueueItem2.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(surveyInstanceActionQueueItem2.submittedBy()).thenReturn("Submitted By");
    when(surveyInstanceActionQueueItem2.surveyInstanceId()).thenReturn(1L);
    when(surveyInstanceActionQueueItem2.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    Optional<Long> ofResult10 = Optional.<Long>of(1L);
    when(surveyInstanceActionQueueItem2.id()).thenReturn(ofResult10);

    ArrayList<SurveyInstanceActionQueueItem> surveyInstanceActionQueueItemList = new ArrayList<>();
    surveyInstanceActionQueueItemList.add(surveyInstanceActionQueueItem2);
    surveyInstanceActionQueueItemList.add(surveyInstanceActionQueueItem);
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = mock(SurveyInstanceActionQueueDao.class);
    doNothing().when(surveyInstanceActionQueueDao)
        .updateActionStatus(Mockito.<DSLContext>any(), Mockito.<Long>any(), Mockito.<SurveyInstanceActionStatus>any(),
            Mockito.<String>any());
    doNothing().when(surveyInstanceActionQueueDao).markActionInProgress(Mockito.<DSLContext>any(), Mockito.<Long>any());
    when(surveyInstanceActionQueueDao.findPendingActions()).thenReturn(surveyInstanceActionQueueItemList);
    SurveyInstance surveyInstance = mock(SurveyInstance.class);
    when(surveyInstance.originalInstanceId()).thenReturn(1L);
    when(surveyInstance.status()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenReturn(surveyInstance);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class), mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao, new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService3 = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Connection connection = mock(Connection.class);
    doNothing().when(connection).rollback(Mockito.<Savepoint>any());
    when(connection.setSavepoint()).thenReturn(mock(Savepoint.class));
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();

    // Act
    (new SurveyInstanceActionQueueService(surveyInstanceActionQueueDao, surveyInstanceService, changeLogService3,
        new DefaultDSLContext(connection, SQLDialect.SQL99))).performActions();

    // Assert
    verify(connection, atLeast(1)).commit();
    verify(connection, atLeast(1)).getAutoCommit();
    verify(connection, atLeast(1)).rollback(isA(Savepoint.class));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(connection, atLeast(1)).setSavepoint();
    verify(changeLogDao, atLeast(1)).write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any());
    verify(surveyInstanceActionQueueDao).findPendingActions();
    verify(surveyInstanceActionQueueDao, atLeast(1)).markActionInProgress(Mockito.<DSLContext>any(), eq(1L));
    verify(surveyInstanceActionQueueDao, atLeast(1)).updateActionStatus(Mockito.<DSLContext>any(), eq(1L),
        eq(SurveyInstanceActionStatus.EXECUTION_FAILURE),
        eq("Failed to apply queued action: SUBMITTING to survey: 1. Error when updating: You can only update the status of the most recent version of a survey"));
    verify(surveyInstanceDao, atLeast(1)).getById(eq(1L));
    verify(surveyInstanceActionQueueItem2).id();
    verify(surveyInstanceActionQueueItem).id();
    verify(surveyInstance, atLeast(1)).originalInstanceId();
    verify(surveyInstance, atLeast(1)).status();
    verify(surveyInstanceActionParams2).newApprovalDueDate();
    verify(surveyInstanceActionParams).newApprovalDueDate();
    verify(surveyInstanceActionParams2).newDueDate();
    verify(surveyInstanceActionParams).newDueDate();
    verify(surveyInstanceActionParams2).reason();
    verify(surveyInstanceActionParams).reason();
    verify(surveyInstanceActionQueueItem2, atLeast(1)).action();
    verify(surveyInstanceActionQueueItem, atLeast(1)).action();
    verify(surveyInstanceActionQueueItem2, atLeast(1)).actionParams();
    verify(surveyInstanceActionQueueItem, atLeast(1)).actionParams();
    verify(surveyInstanceActionQueueItem2).initialState();
    verify(surveyInstanceActionQueueItem).initialState();
    verify(surveyInstanceActionQueueItem2, atLeast(1)).submittedBy();
    verify(surveyInstanceActionQueueItem, atLeast(1)).submittedBy();
    verify(surveyInstanceActionQueueItem2, atLeast(1)).surveyInstanceId();
    verify(surveyInstanceActionQueueItem, atLeast(1)).surveyInstanceId();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceActionQueueService#findPendingActions()}
   */
  @Test
  void testFindPendingActions() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = mock(SurveyInstanceActionQueueDao.class);
    ArrayList<SurveyInstanceActionQueueItem> surveyInstanceActionQueueItemList = new ArrayList<>();
    when(surveyInstanceActionQueueDao.findPendingActions()).thenReturn(surveyInstanceActionQueueItemList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class), mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao, new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act
    List<SurveyInstanceActionQueueItem> actualFindPendingActionsResult = (new SurveyInstanceActionQueueService(
        surveyInstanceActionQueueDao, surveyInstanceService, changeLogService3,
        new DefaultDSLContext(SQLDialect.SQL99))).findPendingActions();

    // Assert
    verify(surveyInstanceActionQueueDao).findPendingActions();
    assertTrue(actualFindPendingActionsResult.isEmpty());
    assertSame(surveyInstanceActionQueueItemList, actualFindPendingActionsResult);
  }

  /**
   * Method under test: {@link SurveyInstanceActionQueueService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = mock(SurveyInstanceActionQueueDao.class);
    when(surveyInstanceActionQueueDao.getById(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class), mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao, new SurveyInstanceEvaluator(null, mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act
    SurveyInstanceActionQueueItem actualById = (new SurveyInstanceActionQueueService(surveyInstanceActionQueueDao,
        surveyInstanceService, changeLogService3, new DefaultDSLContext(SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(surveyInstanceActionQueueDao).getById(eq(1L));
    assertNull(actualById);
  }
}
