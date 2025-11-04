package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
import org.finos.waltz.data.survey.SurveyInstanceDao;
import org.finos.waltz.data.survey.SurveyInstanceOwnerDao;
import org.finos.waltz.data.survey.SurveyInstanceRecipientDao;
import org.finos.waltz.data.survey.SurveyQuestionDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.data.survey.SurveyRunDao;
import org.finos.waltz.data.survey.SurveyTemplateDao;
import org.finos.waltz.data.survey.SurveyViewDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.attestation.SyncRecipientsResponse;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.survey.SurveyInstance;
import org.finos.waltz.model.survey.SurveyInstanceOwnerCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.SurveyInstanceRecipientCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.model.survey.SurveyInstanceStatusChangeCommand;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionResponse;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyInstanceServiceDiffblueTest {
  /**
   * Method under test: {@link SurveyInstanceService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    SurveyInstance actualById = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).getById(1L);

    // Assert
    verify(surveyInstanceDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link SurveyInstanceService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).getById(1L));
    verify(surveyInstanceDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link SurveyInstanceService#findForRecipient(Long)}
   */
  @Test
  void testFindForRecipient() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();
    when(surveyInstanceDao.findForRecipient(anyLong())).thenReturn(surveyInstanceSet);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    Set<SurveyInstance> actualFindForRecipientResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).findForRecipient(1L);

    // Assert
    verify(surveyInstanceDao).findForRecipient(eq(1L));
    assertTrue(actualFindForRecipientResult.isEmpty());
    assertSame(surveyInstanceSet, actualFindForRecipientResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#findForRecipient(Long)}
   */
  @Test
  void testFindForRecipient2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findForRecipient(anyLong()))
        .thenThrow(new IllegalArgumentException("personId cannot be null"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findForRecipient(1L));
    verify(surveyInstanceDao).findForRecipient(eq(1L));
  }

  /**
   * Method under test: {@link SurveyInstanceService#findForRecipient(String)}
   */
  @Test
  void testFindForRecipient3() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();
    when(surveyInstanceDao.findForRecipient(anyLong())).thenReturn(surveyInstanceSet);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    Set<SurveyInstance> actualFindForRecipientResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).findForRecipient("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceDao).findForRecipient(eq(1L));
    verify(person).id();
    assertTrue(actualFindForRecipientResult.isEmpty());
    assertSame(surveyInstanceSet, actualFindForRecipientResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#findForRecipient(String)}
   */
  @Test
  void testFindForRecipient4() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findForRecipient(anyLong()))
        .thenThrow(new IllegalArgumentException("userName cannot be null"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findForRecipient("janedoe"));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceDao).findForRecipient(eq(1L));
    verify(person).id();
  }

  /**
   * Method under test: {@link SurveyInstanceService#findForSurveyRun(long)}
   */
  @Test
  void testFindForSurveyRun() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();
    when(surveyInstanceDao.findForSurveyRun(anyLong())).thenReturn(surveyInstanceSet);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    Set<SurveyInstance> actualFindForSurveyRunResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).findForSurveyRun(1L);

    // Assert
    verify(surveyInstanceDao).findForSurveyRun(eq(1L));
    assertTrue(actualFindForSurveyRunResult.isEmpty());
    assertSame(surveyInstanceSet, actualFindForSurveyRunResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#findForSurveyRun(long)}
   */
  @Test
  void testFindForSurveyRun2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findForSurveyRun(anyLong())).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findForSurveyRun(1L));
    verify(surveyInstanceDao).findForSurveyRun(eq(1L));
  }

  /**
   * Method under test: {@link SurveyInstanceService#findResponses(long)}
   */
  @Test
  void testFindResponses() {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList = new ArrayList<>();
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    List<SurveyInstanceQuestionResponse> actualFindResponsesResult = (new SurveyInstanceService(changeLogService,
        personDao, surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao,
        surveyRunDao, userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).findResponses(1L);

    // Assert
    verify(surveyQuestionResponseDao).findForInstance(eq(1L));
    assertTrue(actualFindResponsesResult.isEmpty());
    assertSame(surveyInstanceQuestionResponseList, actualFindResponsesResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#findResponses(long)}
   */
  @Test
  void testFindResponses2() {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findResponses(1L));
    verify(surveyQuestionResponseDao).findForInstance(eq(1L));
  }

  /**
   * Method under test: {@link SurveyInstanceService#findRecipients(long)}
   */
  @Test
  void testFindRecipients() {
    // Arrange
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(surveyInstanceRecipientDao.findPeopleForSurveyInstance(anyLong())).thenReturn(personList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    List<Person> actualFindRecipientsResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).findRecipients(1L);

    // Assert
    verify(surveyInstanceRecipientDao).findPeopleForSurveyInstance(eq(1L));
    assertTrue(actualFindRecipientsResult.isEmpty());
    assertSame(personList, actualFindRecipientsResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#findRecipients(long)}
   */
  @Test
  void testFindRecipients2() {
    // Arrange
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.findPeopleForSurveyInstance(anyLong()))
        .thenThrow(new IllegalArgumentException("foo"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findRecipients(1L));
    verify(surveyInstanceRecipientDao).findPeopleForSurveyInstance(eq(1L));
  }

  /**
   * Method under test: {@link SurveyInstanceService#findOwners(long)}
   */
  @Test
  void testFindOwners() {
    // Arrange
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(surveyInstanceOwnerDao.findPeopleForSurveyInstance(anyLong())).thenReturn(personList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    List<Person> actualFindOwnersResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).findOwners(1L);

    // Assert
    verify(surveyInstanceOwnerDao).findPeopleForSurveyInstance(eq(1L));
    assertTrue(actualFindOwnersResult.isEmpty());
    assertSame(personList, actualFindOwnersResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#findOwners(long)}
   */
  @Test
  void testFindOwners2() {
    // Arrange
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.findPeopleForSurveyInstance(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findOwners(1L));
    verify(surveyInstanceOwnerDao).findPeopleForSurveyInstance(eq(1L));
  }

  /**
   * Method under test: {@link SurveyInstanceService#reassignRecipients()}
   */
  @Test
  void testReassignRecipients() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.reassignRecipients()).thenReturn(null);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).reassignRecipients();

    // Assert
    verify(surveyInstanceDao).reassignRecipients();
    assertNull(actualReassignRecipientsResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#reassignRecipients()}
   */
  @Test
  void testReassignRecipients2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.reassignRecipients()).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).reassignRecipients());
    verify(surveyInstanceDao).reassignRecipients();
  }

  /**
   * Method under test: {@link SurveyInstanceService#reassignOwners()}
   */
  @Test
  void testReassignOwners() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.reassignOwners()).thenReturn(null);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    SyncRecipientsResponse actualReassignOwnersResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).reassignOwners();

    // Assert
    verify(surveyInstanceDao).reassignOwners();
    assertNull(actualReassignOwnersResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#reassignOwners()}
   */
  @Test
  void testReassignOwners2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.reassignOwners()).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).reassignOwners());
    verify(surveyInstanceDao).reassignOwners();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#getReassignRecipientsCounts()}
   */
  @Test
  void testGetReassignRecipientsCounts() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getReassignRecipientsCounts()).thenReturn(null);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    SyncRecipientsResponse actualReassignRecipientsCounts = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).getReassignRecipientsCounts();

    // Assert
    verify(surveyInstanceDao).getReassignRecipientsCounts();
    assertNull(actualReassignRecipientsCounts);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#getReassignRecipientsCounts()}
   */
  @Test
  void testGetReassignRecipientsCounts2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getReassignRecipientsCounts()).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).getReassignRecipientsCounts());
    verify(surveyInstanceDao).getReassignRecipientsCounts();
  }

  /**
   * Method under test: {@link SurveyInstanceService#getReassignOwnersCounts()}
   */
  @Test
  void testGetReassignOwnersCounts() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getReassignOwnersCounts()).thenReturn(null);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    SyncRecipientsResponse actualReassignOwnersCounts = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).getReassignOwnersCounts();

    // Assert
    verify(surveyInstanceDao).getReassignOwnersCounts();
    assertNull(actualReassignOwnersCounts);
  }

  /**
   * Method under test: {@link SurveyInstanceService#getReassignOwnersCounts()}
   */
  @Test
  void testGetReassignOwnersCounts2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getReassignOwnersCounts()).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).getReassignOwnersCounts());
    verify(surveyInstanceDao).getReassignOwnersCounts();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#saveResponse(String, long, SurveyQuestionResponse)}
   */
  @Test
  void testSaveResponse() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException("userName cannot be null"));
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong())).thenReturn(true);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).saveResponse("janedoe", 1L, mock(SurveyQuestionResponse.class)));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceDao).getById(eq(1L));
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(eq(1L), eq(1L));
    verify(person).id();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String, long)}
   */
  @Test
  void testCheckPersonIsRecipientOrOwnerOrAdmin() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong())).thenReturn(true);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
        surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).checkPersonIsRecipientOrOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(eq(1L), eq(1L));
    verify(person).id();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String, long)}
   */
  @Test
  void testCheckPersonIsRecipientOrOwnerOrAdmin2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException("userName %s cannot be resolved"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).checkPersonIsRecipientOrOwnerOrAdmin("janedoe", 1L));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(eq(1L), eq(1L));
    verify(person).id();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String, long)}
   */
  @Test
  void testCheckPersonIsRecipientOrOwnerOrAdmin3() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong())).thenReturn(false);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    (new SurveyInstanceService(changeLogService2, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
        surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).checkPersonIsRecipientOrOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person, atLeast(1)).id();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String, long)}
   */
  @Test
  void testCheckPersonIsRecipientOrOwnerOrAdmin4() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong())).thenReturn(false);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao2,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
        surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).checkPersonIsRecipientOrOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(eq(1L), eq(1L));
    verify(person).id();
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String, long)}
   */
  @Test
  void testCheckPersonIsRecipientOrOwnerOrAdmin5() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong())).thenReturn(false);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any()))
        .thenThrow(new IllegalArgumentException("userName %s cannot be resolved"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao2,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).checkPersonIsRecipientOrOwnerOrAdmin("janedoe", 1L));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(eq(1L), eq(1L));
    verify(person).id();
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}
   */
  @Test
  void testCheckPersonIsOwnerOrAdmin() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    (new SurveyInstanceService(changeLogService2, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
        surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).checkPersonIsOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}
   */
  @Test
  void testCheckPersonIsOwnerOrAdmin2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(mock(Person.class));
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao2,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
        surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).checkPersonIsOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsRecipient(String, long)}
   */
  @Test
  void testCheckPersonIsRecipient() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong())).thenReturn(true);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
        surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).checkPersonIsRecipient("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(eq(1L), eq(1L));
    verify(person).id();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#checkPersonIsRecipient(String, long)}
   */
  @Test
  void testCheckPersonIsRecipient2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException("userName %s cannot be resolved"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).checkPersonIsRecipient("janedoe", 1L));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(eq(1L), eq(1L));
    verify(person).id();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException("command cannot be null"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> surveyInstanceService.updateStatus(tx, "janedoe", 1L, mock(SurveyInstanceStatusChangeCommand.class)));
    verify(surveyInstanceDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  void testRemoveUnnecessaryResponses() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
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
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService,
        new SurveyInstanceViewService(personDao3,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
            mock(SurveyViewDao.class)),
        surveyQuestionService, mock(SurveyTemplateDao.class));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult = surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(surveyQuestionResponseDao).findForInstance(eq(1L));
    verify(surveyQuestionService).findForSurveyInstance(eq(1L));
    assertEquals(0, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  void testRemoveUnnecessaryResponses2() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    SurveyInstanceQuestionResponse surveyInstanceQuestionResponse = mock(SurveyInstanceQuestionResponse.class);
    when(surveyInstanceQuestionResponse.questionResponse()).thenReturn(null);
    SurveyInstanceQuestionResponse surveyInstanceQuestionResponse2 = mock(SurveyInstanceQuestionResponse.class);
    when(surveyInstanceQuestionResponse2.questionResponse())
        .thenThrow(new IllegalArgumentException("xs cannot be null"));

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList = new ArrayList<>();
    surveyInstanceQuestionResponseList.add(surveyInstanceQuestionResponse2);
    surveyInstanceQuestionResponseList.add(surveyInstanceQuestionResponse);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList);
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
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
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService,
        new SurveyInstanceViewService(personDao3,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
            mock(SurveyViewDao.class)),
        surveyQuestionService, mock(SurveyTemplateDao.class));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.removeUnnecessaryResponses(tx, 1L));
    verify(surveyQuestionResponseDao).findForInstance(eq(1L));
    verify(surveyInstanceQuestionResponse2).questionResponse();
    verify(surveyQuestionService).findForSurveyInstance(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  void testRemoveUnnecessaryResponses3() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    SurveyInstanceQuestionResponse surveyInstanceQuestionResponse = mock(SurveyInstanceQuestionResponse.class);
    when(surveyInstanceQuestionResponse.questionResponse()).thenReturn(null);
    SurveyInstanceQuestionResponse surveyInstanceQuestionResponse2 = mock(SurveyInstanceQuestionResponse.class);
    when(surveyInstanceQuestionResponse2.questionResponse())
        .thenThrow(new IllegalArgumentException("xs cannot be null"));

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList = new ArrayList<>();
    surveyInstanceQuestionResponseList.add(surveyInstanceQuestionResponse2);
    surveyInstanceQuestionResponseList.add(surveyInstanceQuestionResponse);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(surveyQuestion);
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
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
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService,
        new SurveyInstanceViewService(personDao3,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
            mock(SurveyViewDao.class)),
        surveyQuestionService, mock(SurveyTemplateDao.class));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.removeUnnecessaryResponses(tx, 1L));
    verify(surveyQuestionResponseDao).findForInstance(eq(1L));
    verify(surveyQuestion).id();
    verify(surveyInstanceQuestionResponse2).questionResponse();
    verify(surveyQuestionService).findForSurveyInstance(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  void testRemoveUnnecessaryResponses4() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    SurveyInstanceQuestionResponse surveyInstanceQuestionResponse = mock(SurveyInstanceQuestionResponse.class);
    when(surveyInstanceQuestionResponse.questionResponse()).thenReturn(null);
    SurveyInstanceQuestionResponse surveyInstanceQuestionResponse2 = mock(SurveyInstanceQuestionResponse.class);
    when(surveyInstanceQuestionResponse2.questionResponse())
        .thenThrow(new IllegalArgumentException("xs cannot be null"));

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList = new ArrayList<>();
    surveyInstanceQuestionResponseList.add(surveyInstanceQuestionResponse2);
    surveyInstanceQuestionResponseList.add(surveyInstanceQuestionResponse);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    SurveyQuestion surveyQuestion2 = mock(SurveyQuestion.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestion2.id()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(surveyQuestion2);
    surveyQuestionList.add(surveyQuestion);
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
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
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService,
        new SurveyInstanceViewService(personDao3,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
            mock(SurveyViewDao.class)),
        surveyQuestionService, mock(SurveyTemplateDao.class));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.removeUnnecessaryResponses(tx, 1L));
    verify(surveyQuestionResponseDao).findForInstance(eq(1L));
    verify(surveyQuestion2).id();
    verify(surveyQuestion).id();
    verify(surveyInstanceQuestionResponse2).questionResponse();
    verify(surveyQuestionService).findForSurveyInstance(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#findPreviousVersionsForInstance(long)}
   */
  @Test
  void testFindPreviousVersionsForInstance() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    ArrayList<SurveyInstance> surveyInstanceList = new ArrayList<>();
    when(surveyInstanceDao.findPreviousVersionsForInstance(anyLong())).thenReturn(surveyInstanceList);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    List<SurveyInstance> actualFindPreviousVersionsForInstanceResult = (new SurveyInstanceService(changeLogService,
        personDao, surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao,
        surveyRunDao, userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).findPreviousVersionsForInstance(1L);

    // Assert
    verify(surveyInstanceDao).findPreviousVersionsForInstance(eq(1L));
    assertTrue(actualFindPreviousVersionsForInstanceResult.isEmpty());
    assertSame(surveyInstanceList, actualFindPreviousVersionsForInstanceResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#findPreviousVersionsForInstance(long)}
   */
  @Test
  void testFindPreviousVersionsForInstance2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findPreviousVersionsForInstance(anyLong())).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findPreviousVersionsForInstance(1L));
    verify(surveyInstanceDao).findPreviousVersionsForInstance(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#findVersionsForInstance(long)}
   */
  @Test
  void testFindVersionsForInstance() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    ArrayList<SurveyInstance> surveyInstanceList = new ArrayList<>();
    when(surveyInstanceDao.findVersionsForInstance(anyLong())).thenReturn(surveyInstanceList);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    List<SurveyInstance> actualFindVersionsForInstanceResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).findVersionsForInstance(1L);

    // Assert
    verify(surveyInstanceDao).findVersionsForInstance(eq(1L));
    assertTrue(actualFindVersionsForInstanceResult.isEmpty());
    assertSame(surveyInstanceList, actualFindVersionsForInstanceResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#findVersionsForInstance(long)}
   */
  @Test
  void testFindVersionsForInstance2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findVersionsForInstance(anyLong())).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findVersionsForInstance(1L));
    verify(surveyInstanceDao).findVersionsForInstance(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  void testAddRecipient() {
    // Arrange
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceRecipientCreateCommand command = mock(SurveyInstanceRecipientCreateCommand.class);
    when(command.surveyInstanceId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.addRecipient("janedoe", command));
    verify(command).surveyInstanceId();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  void testAddRecipient2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any())).thenReturn(1L);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService2, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceRecipientCreateCommand command = mock(SurveyInstanceRecipientCreateCommand.class);
    when(command.personId()).thenThrow(new IllegalArgumentException("command cannot be null"));
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.addRecipient("janedoe", command));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(command).personId();
    verify(command, atLeast(1)).surveyInstanceId();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  void testAddRecipient3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any())).thenReturn(1L);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceRecipientCreateCommand command = mock(SurveyInstanceRecipientCreateCommand.class);
    when(command.personId()).thenReturn(1L);
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act
    long actualAddRecipientResult = surveyInstanceService.addRecipient("janedoe", command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    verify(command).personId();
    verify(command, atLeast(1)).surveyInstanceId();
    assertEquals(1L, actualAddRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  void testAddRecipient4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any())).thenReturn(1L);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceRecipientCreateCommand command = mock(SurveyInstanceRecipientCreateCommand.class);
    when(command.personId()).thenReturn(1L);
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act
    long actualAddRecipientResult = surveyInstanceService.addRecipient("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    verify(command).personId();
    verify(command, atLeast(1)).surveyInstanceId();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualAddRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  void testAddRecipient5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    when(person.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(mock(Person.class));
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao2,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceRecipientCreateCommand command = mock(SurveyInstanceRecipientCreateCommand.class);
    when(command.personId()).thenReturn(1L);
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act
    long actualAddRecipientResult = surveyInstanceService.addRecipient("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(person).name();
    verify(command).personId();
    verify(command, atLeast(1)).surveyInstanceId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualAddRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  void testAddOwner() {
    // Arrange
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceOwnerCreateCommand command = mock(SurveyInstanceOwnerCreateCommand.class);
    when(command.surveyInstanceId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.addOwner("janedoe", command));
    verify(command).surveyInstanceId();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  void testAddOwner2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any())).thenReturn(1L);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService2, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceOwnerCreateCommand command = mock(SurveyInstanceOwnerCreateCommand.class);
    when(command.personId()).thenThrow(new IllegalArgumentException("command cannot be null"));
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.addOwner("janedoe", command));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(command).personId();
    verify(command, atLeast(1)).surveyInstanceId();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  void testAddOwner3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any())).thenReturn(1L);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceOwnerCreateCommand command = mock(SurveyInstanceOwnerCreateCommand.class);
    when(command.personId()).thenReturn(1L);
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act
    long actualAddOwnerResult = surveyInstanceService.addOwner("janedoe", command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    verify(command).personId();
    verify(command, atLeast(1)).surveyInstanceId();
    assertEquals(1L, actualAddOwnerResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  void testAddOwner4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any())).thenReturn(1L);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceOwnerCreateCommand command = mock(SurveyInstanceOwnerCreateCommand.class);
    when(command.personId()).thenReturn(1L);
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act
    long actualAddOwnerResult = surveyInstanceService.addOwner("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    verify(command).personId();
    verify(command, atLeast(1)).surveyInstanceId();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualAddOwnerResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  void testAddOwner5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    when(person.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(mock(Person.class));
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao2,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceService surveyInstanceService = new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class));
    SurveyInstanceOwnerCreateCommand command = mock(SurveyInstanceOwnerCreateCommand.class);
    when(command.personId()).thenReturn(1L);
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act
    long actualAddOwnerResult = surveyInstanceService.addOwner("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(person).name();
    verify(command).personId();
    verify(command, atLeast(1)).surveyInstanceId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualAddOwnerResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  void testDeleteRecipient() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong())).thenReturn(true);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    boolean actualDeleteRecipientResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).deleteRecipient("janedoe", 1L, 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    assertTrue(actualDeleteRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  void testDeleteRecipient2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenThrow(new IllegalArgumentException("userName %s cannot be resolved"));
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong())).thenReturn(true);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService2, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).deleteRecipient("janedoe", 1L, 1L));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  void testDeleteRecipient3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong())).thenReturn(true);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    boolean actualDeleteRecipientResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).deleteRecipient("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  void testDeleteRecipient4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong())).thenReturn(false);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    boolean actualDeleteRecipientResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).deleteRecipient("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualDeleteRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  void testDeleteRecipient5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    when(person.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(mock(Person.class));
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong())).thenReturn(true);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao2,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    boolean actualDeleteRecipientResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).deleteRecipient("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(eq(1L), eq(1L));
    verify(person).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
    assertTrue(actualDeleteRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  void testDeleteOwner() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    boolean actualDeleteOwnerResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).deleteOwner("janedoe", 1L, 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).delete(eq(1L), eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    assertTrue(actualDeleteOwnerResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  void testDeleteOwner2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenThrow(new IllegalArgumentException("userName %s cannot be resolved"));
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService2, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).deleteOwner("janedoe", 1L, 1L));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).delete(eq(1L), eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  void testDeleteOwner3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    boolean actualDeleteOwnerResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).deleteOwner("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).delete(eq(1L), eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteOwnerResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  void testDeleteOwner4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    when(person2.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person2);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(false);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao3,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    boolean actualDeleteOwnerResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).deleteOwner("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).delete(eq(1L), eq(1L));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(eq(1L), eq(1L));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    verify(person).id();
    verify(person2).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualDeleteOwnerResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  void testDeleteOwner5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    when(person.name()).thenReturn("Name");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(mock(Person.class));
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(true);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceViewService instanceViewService = new SurveyInstanceViewService(personDao2,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    boolean actualDeleteOwnerResult = (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
        instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).deleteOwner("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(personDao).getById(eq(1L));
    verify(surveyInstanceOwnerDao).delete(eq(1L), eq(1L));
    verify(person).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
    assertTrue(actualDeleteOwnerResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}
   */
  @Test
  void testFindPossibleActionsForInstance() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findPossibleActionsForInstance("janedoe", 1L));
    verify(surveyInstanceDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  void testGetPermissions() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(null);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).getPermissions("janedoe", 1L));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String, String)}
   */
  @Test
  void testReportProblemWithQuestionResponse() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
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

    // Act
    boolean actualReportProblemWithQuestionResponseResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService,
        new SurveyInstanceViewService(personDao3,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
            mock(SurveyViewDao.class)),
        surveyQuestionService, mock(SurveyTemplateDao.class))).reportProblemWithQuestionResponse(1L, 1L,
            "Not all who wander are lost", "janedoe");

    // Assert
    verify(surveyQuestionService).findForSurveyInstance(eq(1L));
    assertFalse(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String, String)}
   */
  @Test
  void testReportProblemWithQuestionResponse2() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(surveyQuestion);
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
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

    // Act
    boolean actualReportProblemWithQuestionResponseResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService,
        new SurveyInstanceViewService(personDao3,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
            mock(SurveyViewDao.class)),
        surveyQuestionService, mock(SurveyTemplateDao.class))).reportProblemWithQuestionResponse(1L, 1L,
            "Not all who wander are lost", "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyQuestion).id();
    verify(surveyQuestion).questionText();
    verify(surveyQuestionService).findForSurveyInstance(eq(1L));
    assertTrue(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String, String)}
   */
  @Test
  void testReportProblemWithQuestionResponse3() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.questionText()).thenThrow(new IllegalArgumentException("collection must not be null"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(surveyQuestion);
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService,
            new SurveyInstanceViewService(personDao3,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
                mock(SurveyViewDao.class)),
            surveyQuestionService, mock(SurveyTemplateDao.class))).reportProblemWithQuestionResponse(1L, 1L,
                "Not all who wander are lost", "janedoe"));
    verify(surveyQuestion).id();
    verify(surveyQuestion).questionText();
    verify(surveyQuestionService).findForSurveyInstance(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String, String)}
   */
  @Test
  void testReportProblemWithQuestionResponse4() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(surveyQuestion);
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
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

    // Act
    boolean actualReportProblemWithQuestionResponseResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService,
        new SurveyInstanceViewService(personDao3,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
            mock(SurveyViewDao.class)),
        surveyQuestionService, mock(SurveyTemplateDao.class))).reportProblemWithQuestionResponse(1L, 1L,
            "Not all who wander are lost", "janedoe");

    // Assert
    verify(surveyQuestion).id();
    verify(surveyQuestion).questionText();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(surveyQuestionService).findForSurveyInstance(eq(1L));
    assertTrue(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Method under test: {@link SurveyInstanceService#findGroupApprovers(long)}
   */
  @Test
  void testFindGroupApprovers() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            mock(SurveyTemplateDao.class))).findGroupApprovers(1L));
    verify(surveyInstanceDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  void testWithdrawOpenSurveysForRun() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) any())).thenReturn(new HashSet<>());
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    Integer actualWithdrawOpenSurveysForRunResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) any());
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  void testWithdrawOpenSurveysForRun2() {
    // Arrange
    SurveyInstance surveyInstance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyInstance.id()).thenReturn(ofResult);

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();
    surveyInstanceSet.add(surveyInstance);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException("action"));
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) any())).thenReturn(surveyInstanceSet);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    Integer actualWithdrawOpenSurveysForRunResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) any());
    verify(surveyInstanceDao).getById(eq(1L));
    verify(surveyInstance, atLeast(1)).id();
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  void testWithdrawOpenSurveysForRun3() {
    // Arrange
    SurveyInstance surveyInstance = mock(SurveyInstance.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyInstance.id()).thenReturn(ofResult);
    SurveyInstance surveyInstance2 = mock(SurveyInstance.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyInstance2.id()).thenReturn(ofResult2);

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();
    surveyInstanceSet.add(surveyInstance2);
    surveyInstanceSet.add(surveyInstance);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException("action"));
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) any())).thenReturn(surveyInstanceSet);
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act
    Integer actualWithdrawOpenSurveysForRunResult = (new SurveyInstanceService(changeLogService, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao,
        userRoleService, instanceViewService,
        new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
        mock(SurveyTemplateDao.class))).withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) any());
    verify(surveyInstanceDao, atLeast(1)).getById(eq(1L));
    verify(surveyInstance2, atLeast(1)).id();
    verify(surveyInstance, atLeast(1)).id();
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}
   */
  @Test
  void testWithdrawOpenSurveysForTemplate() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
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
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        mock(SurveyViewDao.class));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyInstanceService(changeLogService, personDao, surveyInstanceDao, surveyInstanceRecipientDao,
            surveyInstanceOwnerDao, surveyQuestionResponseDao, surveyRunDao, userRoleService, instanceViewService,
            new SurveyQuestionService(surveyQuestionDao,
                new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                    mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))),
            surveyTemplateDao)).withdrawOpenSurveysForTemplate(1L, "janedoe"));
    verify(surveyTemplateDao).getById(eq(1L));
  }
}
