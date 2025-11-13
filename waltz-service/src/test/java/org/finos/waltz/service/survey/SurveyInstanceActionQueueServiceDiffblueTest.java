package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.survey.ImmutableSurveyInstance;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionParams;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionQueueItem;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionQueueItem.Builder;
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
import org.jooq.TransactionalRunnable;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.postgresql.jdbc.PSQLSavepoint;

@ExtendWith(MockitoExtension.class)
class SurveyInstanceActionQueueServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private DSLContext dSLContext;

  @Mock private SurveyInstanceActionQueueDao surveyInstanceActionQueueDao;

  @InjectMocks private SurveyInstanceActionQueueService surveyInstanceActionQueueService;

  @Mock private SurveyInstanceService surveyInstanceService;

  /**
   * Test {@link SurveyInstanceActionQueueService#performActions()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueService#performActions()}
   */
  @Test
  @DisplayName("Test performActions(); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueService.performActions()"})
  void testPerformActions_givenDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        mock(SurveyInstanceActionQueueDao.class);
    when(surveyInstanceActionQueueDao.findPendingActions()).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
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
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            mock(SurveyTemplateDao.class));
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SurveyInstanceActionQueueService surveyInstanceActionQueueService =
        new SurveyInstanceActionQueueService(
            surveyInstanceActionQueueDao,
            surveyInstanceService,
            changeLogService3,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    surveyInstanceActionQueueService.performActions();

    // Assert
    verify(surveyInstanceActionQueueDao).findPendingActions();
  }

  /**
   * Test {@link SurveyInstanceActionQueueService#performActions()}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceService}.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueService#performActions()}
   */
  @Test
  @DisplayName(
      "Test performActions(); given SurveyInstanceService; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueService.performActions()"})
  void testPerformActions_givenSurveyInstanceService_thenCallsTransaction() {
    // Arrange
    ArrayList<SurveyInstanceActionQueueItem> surveyInstanceActionQueueItemList = new ArrayList<>();

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    surveyInstanceActionQueueItemList.add(
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
    when(surveyInstanceActionQueueDao.findPendingActions())
        .thenReturn(surveyInstanceActionQueueItemList);
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    surveyInstanceActionQueueService.performActions();

    // Assert
    verify(surveyInstanceActionQueueDao).findPendingActions();
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueService#performActions()}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#commit()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueService#performActions()}
   */
  @Test
  @DisplayName("Test performActions(); then calls commit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueService.performActions()"})
  void testPerformActions_thenCallsCommit() throws SQLException {
    // Arrange
    ArrayList<SurveyInstanceActionQueueItem> surveyInstanceActionQueueItemList = new ArrayList<>();

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    surveyInstanceActionQueueItemList.add(
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());

    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        mock(SurveyInstanceActionQueueDao.class);
    doNothing()
        .when(surveyInstanceActionQueueDao)
        .markActionInProgress(Mockito.<DSLContext>any(), Mockito.<Long>any());
    doNothing()
        .when(surveyInstanceActionQueueDao)
        .updateActionStatus(
            Mockito.<DSLContext>any(),
            Mockito.<Long>any(),
            Mockito.<SurveyInstanceActionStatus>any(),
            Mockito.<String>any());
    when(surveyInstanceActionQueueDao.findPendingActions())
        .thenReturn(surveyInstanceActionQueueItemList);

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    ImmutableSurveyInstance.Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");
    when(surveyInstanceDao.getById(anyLong()))
        .thenReturn(
            submittedByResult
                .surveyEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            mock(SurveyTemplateDao.class));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).rollback(Mockito.<Savepoint>any());
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.setSavepoint()).thenReturn(new PSQLSavepoint(1));
    DefaultDSLContext dslContext = new DefaultDSLContext(connection, SQLDialect.SQL99);

    SurveyInstanceActionQueueService surveyInstanceActionQueueService =
        new SurveyInstanceActionQueueService(
            surveyInstanceActionQueueDao, surveyInstanceService, changeLogService3, dslContext);

    // Act
    surveyInstanceActionQueueService.performActions();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).rollback(isA(Savepoint.class));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(connection).setSavepoint();
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceActionQueueDao).findPendingActions();
    verify(surveyInstanceActionQueueDao).markActionInProgress(isA(DSLContext.class), eq(1L));
    verify(surveyInstanceActionQueueDao)
        .updateActionStatus(
            isA(DSLContext.class),
            eq(1L),
            eq(SurveyInstanceActionStatus.EXECUTION_FAILURE),
            eq(
                "Failed to apply queued action: SUBMITTING to survey: 1. Error when updating: You can only update the status of the most recent version of a survey"));
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceActionQueueService#performActions()}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#commit()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueService#performActions()}
   */
  @Test
  @DisplayName("Test performActions(); then calls commit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueService.performActions()"})
  void testPerformActions_thenCallsCommit2() throws SQLException {
    // Arrange
    ArrayList<SurveyInstanceActionQueueItem> surveyInstanceActionQueueItemList = new ArrayList<>();

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    surveyInstanceActionQueueItemList.add(
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);
    surveyInstanceActionQueueItemList.add(
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());

    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        mock(SurveyInstanceActionQueueDao.class);
    doNothing()
        .when(surveyInstanceActionQueueDao)
        .markActionInProgress(Mockito.<DSLContext>any(), Mockito.<Long>any());
    doNothing()
        .when(surveyInstanceActionQueueDao)
        .updateActionStatus(
            Mockito.<DSLContext>any(),
            Mockito.<Long>any(),
            Mockito.<SurveyInstanceActionStatus>any(),
            Mockito.<String>any());
    when(surveyInstanceActionQueueDao.findPendingActions())
        .thenReturn(surveyInstanceActionQueueItemList);

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    ImmutableSurveyInstance.Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");
    when(surveyInstanceDao.getById(anyLong()))
        .thenReturn(
            submittedByResult
                .surveyEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            mock(SurveyTemplateDao.class));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).rollback(Mockito.<Savepoint>any());
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.setSavepoint()).thenReturn(new PSQLSavepoint(1));
    DefaultDSLContext dslContext = new DefaultDSLContext(connection, SQLDialect.SQL99);

    SurveyInstanceActionQueueService surveyInstanceActionQueueService =
        new SurveyInstanceActionQueueService(
            surveyInstanceActionQueueDao, surveyInstanceService, changeLogService3, dslContext);

    // Act
    surveyInstanceActionQueueService.performActions();

    // Assert
    verify(connection, atLeast(1)).commit();
    verify(connection, atLeast(1)).getAutoCommit();
    verify(connection, atLeast(1)).rollback(isA(Savepoint.class));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(connection, atLeast(1)).setSavepoint();
    verify(changeLogDao, atLeast(1))
        .write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any());
    verify(surveyInstanceActionQueueDao).findPendingActions();
    verify(surveyInstanceActionQueueDao, atLeast(1))
        .markActionInProgress(Mockito.<DSLContext>any(), eq(1L));
    verify(surveyInstanceActionQueueDao, atLeast(1))
        .updateActionStatus(
            Mockito.<DSLContext>any(),
            eq(1L),
            eq(SurveyInstanceActionStatus.EXECUTION_FAILURE),
            eq(
                "Failed to apply queued action: SUBMITTING to survey: 1. Error when updating: You can only update the status of the most recent version of a survey"));
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceActionQueueService#findPendingActions()}.
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueService#findPendingActions()}
   */
  @Test
  @DisplayName("Test findPendingActions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceActionQueueService.findPendingActions()"})
  void testFindPendingActions() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        mock(SurveyInstanceActionQueueDao.class);
    when(surveyInstanceActionQueueDao.findPendingActions()).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
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
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            mock(SurveyTemplateDao.class));
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SurveyInstanceActionQueueService surveyInstanceActionQueueService =
        new SurveyInstanceActionQueueService(
            surveyInstanceActionQueueDao,
            surveyInstanceService,
            changeLogService3,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    List<SurveyInstanceActionQueueItem> actualFindPendingActionsResult =
        surveyInstanceActionQueueService.findPendingActions();

    // Assert
    verify(surveyInstanceActionQueueDao).findPendingActions();
    assertTrue(actualFindPendingActionsResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceActionQueueService#getById(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceActionQueueItem SurveyInstanceActionQueueService.getById(long)"
  })
  void testGetById() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        mock(SurveyInstanceActionQueueDao.class);

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(surveyInstanceActionQueueDao.getById(anyLong()))
        .thenReturn(
            actionResult
                .actionParams(actionParams)
                .actionedAt(ofResult.atStartOfDay())
                .id(1L)
                .initialState(SurveyInstanceStatus.NOT_STARTED)
                .message("Not all who wander are lost")
                .provenance("Provenance")
                .status(SurveyInstanceActionStatus.PENDING)
                .submittedAt(ofResult2.atStartOfDay())
                .submittedBy("Submitted By")
                .surveyInstanceId(1L)
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
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
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            null,
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            mock(SurveyTemplateDao.class));
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SurveyInstanceActionQueueService surveyInstanceActionQueueService =
        new SurveyInstanceActionQueueService(
            surveyInstanceActionQueueDao,
            surveyInstanceService,
            changeLogService3,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    SurveyInstanceActionQueueItem actualById = surveyInstanceActionQueueService.getById(1L);

    // Assert
    verify(surveyInstanceActionQueueDao).getById(1L);
    assertTrue(actualById instanceof ImmutableSurveyInstanceActionQueueItem);
    assertEquals("Not all who wander are lost", actualById.message());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("Submitted By", actualById.submittedBy());
    assertEquals(1L, actualById.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualById.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, actualById.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualById.initialState());
    assertSame(ofResult, actualById.actionedAt().toLocalDate());
    assertSame(ofResult2, actualById.submittedAt().toLocalDate());
  }
}
