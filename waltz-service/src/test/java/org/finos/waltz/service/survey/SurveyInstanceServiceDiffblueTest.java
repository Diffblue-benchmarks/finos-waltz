package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse;
import org.finos.waltz.model.attestation.SyncRecipientsResponse;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.survey.CopySurveyResponsesCommand;
import org.finos.waltz.model.survey.ImmutableCopySurveyResponsesCommand;
import org.finos.waltz.model.survey.ImmutableSurveyInstance;
import org.finos.waltz.model.survey.ImmutableSurveyInstance.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceFormDetails;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwnerCreateCommand;
import org.finos.waltz.model.survey.ImmutableSurveyInstancePermissions;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientCreateCommand;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceStatusChangeCommand;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyRun;
import org.finos.waltz.model.survey.ImmutableSurveyTemplate;
import org.finos.waltz.model.survey.SurveyInstance;
import org.finos.waltz.model.survey.SurveyInstanceAction;
import org.finos.waltz.model.survey.SurveyInstanceOwnerCreateCommand;
import org.finos.waltz.model.survey.SurveyInstancePermissions;
import org.finos.waltz.model.survey.SurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.SurveyInstanceRecipientCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.model.survey.SurveyInstanceStatusChangeCommand;
import org.finos.waltz.model.survey.SurveyIssuanceKind;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey.SurveyQuestionResponse;
import org.finos.waltz.model.survey.SurveyRunStatus;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyInstanceServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private PersonDao personDao;

  @Mock private SurveyInstanceDao surveyInstanceDao;

  @Mock private SurveyInstanceOwnerDao surveyInstanceOwnerDao;

  @Mock private SurveyInstanceRecipientDao surveyInstanceRecipientDao;

  @InjectMocks private SurveyInstanceService surveyInstanceService;

  @Mock private SurveyInstanceViewService surveyInstanceViewService;

  @Mock private SurveyQuestionResponseDao surveyQuestionResponseDao;

  @Mock private SurveyQuestionService surveyQuestionService;

  @Mock private SurveyRunDao surveyRunDao;

  @Mock private SurveyTemplateDao surveyTemplateDao;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link SurveyInstanceService#getById(long)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstance SurveyInstanceService.getById(long)"})
  void testGetById_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    Builder submittedByResult =
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

    // Act
    SurveyInstance actualById = surveyInstanceService.getById(1L);

    // Assert
    verify(surveyInstanceDao).getById(1L);
    EntityReference qualifierEntityResult = actualById.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualById.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableSurveyInstance);
    assertEquals("42", actualById.surveyEntityExternalId());
    assertEquals("Approved By", actualById.approvedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Owning Role", actualById.owningRole());
    assertEquals("Submitted By", actualById.submittedBy());
    assertEquals(1L, actualById.originalInstanceId().longValue());
    assertEquals(1L, actualById.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualById.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualById.approvalDueDate());
    assertSame(dueDate, actualById.dueDate());
    assertSame(issuedOn, actualById.issuedOn());
  }

  /**
   * Test {@link SurveyInstanceService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstance SurveyInstanceService.getById(long)"})
  void testGetById_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.getById(1L));
    verify(surveyInstanceDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findForRecipient(Long)} with {@code personId}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findForRecipient(Long)}
   */
  @Test
  @DisplayName("Test findForRecipient(Long) with 'personId'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findForRecipient(Long)"})
  void testFindForRecipientWithPersonId_thenReturnEmpty() {
    // Arrange
    when(surveyInstanceDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<SurveyInstance> actualFindForRecipientResult = surveyInstanceService.findForRecipient(1L);

    // Assert
    verify(surveyInstanceDao).findForRecipient(1L);
    assertTrue(actualFindForRecipientResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findForRecipient(Long)} with {@code personId}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findForRecipient(Long)}
   */
  @Test
  @DisplayName("Test findForRecipient(Long) with 'personId'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findForRecipient(Long)"})
  void testFindForRecipientWithPersonId_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.findForRecipient(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.findForRecipient(1L));
    verify(surveyInstanceDao).findForRecipient(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findForRecipient(String)} with {@code userName}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findForRecipient(String)}
   */
  @Test
  @DisplayName("Test findForRecipient(String) with 'userName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findForRecipient(String)"})
  void testFindForRecipientWithUserName() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.findForRecipient("janedoe"));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#findForRecipient(String)} with {@code userName}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findForRecipient(String)}
   */
  @Test
  @DisplayName("Test findForRecipient(String) with 'userName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findForRecipient(String)"})
  void testFindForRecipientWithUserName2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.findForRecipient(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.findForRecipient("janedoe"));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForRecipient(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findForRecipient(String)} with {@code userName}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findForRecipient(String)}
   */
  @Test
  @DisplayName("Test findForRecipient(String) with 'userName'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findForRecipient(String)"})
  void testFindForRecipientWithUserName_thenReturnEmpty() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<SurveyInstance> actualFindForRecipientResult =
        surveyInstanceService.findForRecipient("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForRecipient(1L);
    assertTrue(actualFindForRecipientResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findForSurveyRun(long)}
   */
  @Test
  @DisplayName("Test findForSurveyRun(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findForSurveyRun(long)"})
  void testFindForSurveyRun_thenReturnEmpty() {
    // Arrange
    when(surveyInstanceDao.findForSurveyRun(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<SurveyInstance> actualFindForSurveyRunResult = surveyInstanceService.findForSurveyRun(1L);

    // Assert
    verify(surveyInstanceDao).findForSurveyRun(1L);
    assertTrue(actualFindForSurveyRunResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findForSurveyRun(long)}
   */
  @Test
  @DisplayName("Test findForSurveyRun(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findForSurveyRun(long)"})
  void testFindForSurveyRun_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.findForSurveyRun(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.findForSurveyRun(1L));
    verify(surveyInstanceDao).findForSurveyRun(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findResponses(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findResponses(long)}
   */
  @Test
  @DisplayName("Test findResponses(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findResponses(long)"})
  void testFindResponses_thenReturnEmpty() {
    // Arrange
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<SurveyInstanceQuestionResponse> actualFindResponsesResult =
        surveyInstanceService.findResponses(1L);

    // Assert
    verify(surveyQuestionResponseDao).findForInstance(1L);
    assertTrue(actualFindResponsesResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findResponses(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findResponses(long)}
   */
  @Test
  @DisplayName("Test findResponses(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findResponses(long)"})
  void testFindResponses_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.findResponses(1L));
    verify(surveyQuestionResponseDao).findForInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findRecipients(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findRecipients(long)}
   */
  @Test
  @DisplayName("Test findRecipients(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findRecipients(long)"})
  void testFindRecipients_thenReturnEmpty() {
    // Arrange
    when(surveyInstanceRecipientDao.findPeopleForSurveyInstance(anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Person> actualFindRecipientsResult = surveyInstanceService.findRecipients(1L);

    // Assert
    verify(surveyInstanceRecipientDao).findPeopleForSurveyInstance(1L);
    assertTrue(actualFindRecipientsResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findRecipients(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findRecipients(long)}
   */
  @Test
  @DisplayName("Test findRecipients(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findRecipients(long)"})
  void testFindRecipients_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceRecipientDao.findPeopleForSurveyInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.findRecipients(1L));
    verify(surveyInstanceRecipientDao).findPeopleForSurveyInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findOwners(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findOwners(long)}
   */
  @Test
  @DisplayName("Test findOwners(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findOwners(long)"})
  void testFindOwners_thenReturnEmpty() {
    // Arrange
    when(surveyInstanceOwnerDao.findPeopleForSurveyInstance(anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Person> actualFindOwnersResult = surveyInstanceService.findOwners(1L);

    // Assert
    verify(surveyInstanceOwnerDao).findPeopleForSurveyInstance(1L);
    assertTrue(actualFindOwnersResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findOwners(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findOwners(long)}
   */
  @Test
  @DisplayName("Test findOwners(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findOwners(long)"})
  void testFindOwners_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceOwnerDao.findPeopleForSurveyInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.findOwners(1L));
    verify(surveyInstanceOwnerDao).findPeopleForSurveyInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#reassignRecipients()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSyncRecipientsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reassignRecipients()}
   */
  @Test
  @DisplayName("Test reassignRecipients(); then return ImmutableSyncRecipientsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse SurveyInstanceService.reassignRecipients()"})
  void testReassignRecipients_thenReturnImmutableSyncRecipientsResponse() {
    // Arrange
    when(surveyInstanceDao.reassignRecipients())
        .thenReturn(
            ImmutableSyncRecipientsResponse.builder()
                .recipientsCreatedCount(3L)
                .recipientsRemovedCount(3L)
                .build());

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult =
        surveyInstanceService.reassignRecipients();

    // Assert
    verify(surveyInstanceDao).reassignRecipients();
    assertTrue(actualReassignRecipientsResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(3L, actualReassignRecipientsResult.recipientsCreatedCount().longValue());
    assertEquals(3L, actualReassignRecipientsResult.recipientsRemovedCount().longValue());
  }

  /**
   * Test {@link SurveyInstanceService#reassignRecipients()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reassignRecipients()}
   */
  @Test
  @DisplayName("Test reassignRecipients(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse SurveyInstanceService.reassignRecipients()"})
  void testReassignRecipients_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.reassignRecipients()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.reassignRecipients());
    verify(surveyInstanceDao).reassignRecipients();
  }

  /**
   * Test {@link SurveyInstanceService#reassignOwners()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSyncRecipientsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reassignOwners()}
   */
  @Test
  @DisplayName("Test reassignOwners(); then return ImmutableSyncRecipientsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse SurveyInstanceService.reassignOwners()"})
  void testReassignOwners_thenReturnImmutableSyncRecipientsResponse() {
    // Arrange
    when(surveyInstanceDao.reassignOwners())
        .thenReturn(
            ImmutableSyncRecipientsResponse.builder()
                .recipientsCreatedCount(3L)
                .recipientsRemovedCount(3L)
                .build());

    // Act
    SyncRecipientsResponse actualReassignOwnersResult = surveyInstanceService.reassignOwners();

    // Assert
    verify(surveyInstanceDao).reassignOwners();
    assertTrue(actualReassignOwnersResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(3L, actualReassignOwnersResult.recipientsCreatedCount().longValue());
    assertEquals(3L, actualReassignOwnersResult.recipientsRemovedCount().longValue());
  }

  /**
   * Test {@link SurveyInstanceService#reassignOwners()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reassignOwners()}
   */
  @Test
  @DisplayName("Test reassignOwners(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse SurveyInstanceService.reassignOwners()"})
  void testReassignOwners_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.reassignOwners()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceService.reassignOwners());
    verify(surveyInstanceDao).reassignOwners();
  }

  /**
   * Test {@link SurveyInstanceService#getReassignRecipientsCounts()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSyncRecipientsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getReassignRecipientsCounts()}
   */
  @Test
  @DisplayName("Test getReassignRecipientsCounts(); then return ImmutableSyncRecipientsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse SurveyInstanceService.getReassignRecipientsCounts()"})
  void testGetReassignRecipientsCounts_thenReturnImmutableSyncRecipientsResponse() {
    // Arrange
    when(surveyInstanceDao.getReassignRecipientsCounts())
        .thenReturn(
            ImmutableSyncRecipientsResponse.builder()
                .recipientsCreatedCount(3L)
                .recipientsRemovedCount(3L)
                .build());

    // Act
    SyncRecipientsResponse actualReassignRecipientsCounts =
        surveyInstanceService.getReassignRecipientsCounts();

    // Assert
    verify(surveyInstanceDao).getReassignRecipientsCounts();
    assertTrue(actualReassignRecipientsCounts instanceof ImmutableSyncRecipientsResponse);
    assertEquals(3L, actualReassignRecipientsCounts.recipientsCreatedCount().longValue());
    assertEquals(3L, actualReassignRecipientsCounts.recipientsRemovedCount().longValue());
  }

  /**
   * Test {@link SurveyInstanceService#getReassignRecipientsCounts()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getReassignRecipientsCounts()}
   */
  @Test
  @DisplayName("Test getReassignRecipientsCounts(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse SurveyInstanceService.getReassignRecipientsCounts()"})
  void testGetReassignRecipientsCounts_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.getReassignRecipientsCounts()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.getReassignRecipientsCounts());
    verify(surveyInstanceDao).getReassignRecipientsCounts();
  }

  /**
   * Test {@link SurveyInstanceService#getReassignOwnersCounts()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSyncRecipientsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getReassignOwnersCounts()}
   */
  @Test
  @DisplayName("Test getReassignOwnersCounts(); then return ImmutableSyncRecipientsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse SurveyInstanceService.getReassignOwnersCounts()"})
  void testGetReassignOwnersCounts_thenReturnImmutableSyncRecipientsResponse() {
    // Arrange
    when(surveyInstanceDao.getReassignOwnersCounts())
        .thenReturn(
            ImmutableSyncRecipientsResponse.builder()
                .recipientsCreatedCount(3L)
                .recipientsRemovedCount(3L)
                .build());

    // Act
    SyncRecipientsResponse actualReassignOwnersCounts =
        surveyInstanceService.getReassignOwnersCounts();

    // Assert
    verify(surveyInstanceDao).getReassignOwnersCounts();
    assertTrue(actualReassignOwnersCounts instanceof ImmutableSyncRecipientsResponse);
    assertEquals(3L, actualReassignOwnersCounts.recipientsCreatedCount().longValue());
    assertEquals(3L, actualReassignOwnersCounts.recipientsRemovedCount().longValue());
  }

  /**
   * Test {@link SurveyInstanceService#getReassignOwnersCounts()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getReassignOwnersCounts()}
   */
  @Test
  @DisplayName("Test getReassignOwnersCounts(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse SurveyInstanceService.getReassignOwnersCounts()"})
  void testGetReassignOwnersCounts_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.getReassignOwnersCounts()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.getReassignOwnersCounts());
    verify(surveyInstanceDao).getReassignOwnersCounts();
  }

  /**
   * Test {@link SurveyInstanceService#saveResponse(String, long, SurveyQuestionResponse)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#saveResponse(String, long,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test saveResponse(String, long, SurveyQuestionResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.saveResponse(String, long, SurveyQuestionResponse)"
  })
  void testSaveResponse() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.saveResponse(
                "janedoe",
                1L,
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
  }

  /**
   * Test {@link SurveyInstanceService#saveResponse(String, long, SurveyQuestionResponse)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#saveResponse(String, long,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test saveResponse(String, long, SurveyQuestionResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.saveResponse(String, long, SurveyQuestionResponse)"
  })
  void testSaveResponse2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    doThrow(new IllegalArgumentException())
        .when(surveyQuestionResponseDao)
        .saveResponse(Mockito.<SurveyInstanceQuestionResponse>any());

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.saveResponse(
                "janedoe",
                1L,
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyQuestionResponseDao).saveResponse(isA(SurveyInstanceQuestionResponse.class));
  }

  /**
   * Test {@link SurveyInstanceService#saveResponse(String, long, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#getActiveByUserEmail(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#saveResponse(String, long,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test saveResponse(String, long, SurveyQuestionResponse); given PersonDao getActiveByUserEmail(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.saveResponse(String, long, SurveyQuestionResponse)"
  })
  void testSaveResponse_givenPersonDaoGetActiveByUserEmailThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.saveResponse(
                "janedoe",
                1L,
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#saveResponse(String, long, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceDao} {@link SurveyInstanceDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#saveResponse(String, long,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test saveResponse(String, long, SurveyQuestionResponse); given SurveyInstanceDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.saveResponse(String, long, SurveyQuestionResponse)"
  })
  void testSaveResponse_givenSurveyInstanceDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.saveResponse(
                "janedoe",
                1L,
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
  }

  /**
   * Test {@link SurveyInstanceService#saveResponse(String, long, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#saveResponse(String, long,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test saveResponse(String, long, SurveyQuestionResponse); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.saveResponse(String, long, SurveyQuestionResponse)"
  })
  void testSaveResponse_thenReturnTrue() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    doNothing()
        .when(surveyQuestionResponseDao)
        .saveResponse(Mockito.<SurveyInstanceQuestionResponse>any());

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);

    // Act
    boolean actualSaveResponseResult =
        surveyInstanceService.saveResponse(
            "janedoe",
            1L,
            entityResponseResult
                .listResponse(new ArrayList<>())
                .numberResponse(10.0d)
                .questionId(1L)
                .stringResponse("String Response")
                .build());

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyQuestionResponseDao).saveResponse(isA(SurveyInstanceQuestionResponse.class));
    assertTrue(actualSaveResponseResult);
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String,
   * long)}
   */
  @Test
  @DisplayName("Test checkPersonIsRecipientOrOwnerOrAdmin(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Person SurveyInstanceService.checkPersonIsRecipientOrOwnerOrAdmin(String, long)"
  })
  void testCheckPersonIsRecipientOrOwnerOrAdmin() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.checkPersonIsRecipientOrOwnerOrAdmin("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String,
   * long)}
   */
  @Test
  @DisplayName("Test checkPersonIsRecipientOrOwnerOrAdmin(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Person SurveyInstanceService.checkPersonIsRecipientOrOwnerOrAdmin(String, long)"
  })
  void testCheckPersonIsRecipientOrOwnerOrAdmin2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.checkPersonIsRecipientOrOwnerOrAdmin("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String, long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsRecipientOrOwnerOrAdmin(String,
   * long)}
   */
  @Test
  @DisplayName(
      "Test checkPersonIsRecipientOrOwnerOrAdmin(String, long); then return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Person SurveyInstanceService.checkPersonIsRecipientOrOwnerOrAdmin(String, long)"
  })
  void testCheckPersonIsRecipientOrOwnerOrAdmin_thenReturnImmutablePerson() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    // Act
    Person actualCheckPersonIsRecipientOrOwnerOrAdminResult =
        surveyInstanceService.checkPersonIsRecipientOrOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    assertTrue(actualCheckPersonIsRecipientOrOwnerOrAdminResult instanceof ImmutablePerson);
    assertEquals("42", actualCheckPersonIsRecipientOrOwnerOrAdminResult.employeeId());
    assertEquals("42", actualCheckPersonIsRecipientOrOwnerOrAdminResult.userId());
    assertEquals("Display Name", actualCheckPersonIsRecipientOrOwnerOrAdminResult.displayName());
    assertEquals("Display Name", actualCheckPersonIsRecipientOrOwnerOrAdminResult.name());
    assertEquals("jane.doe@example.org", actualCheckPersonIsRecipientOrOwnerOrAdminResult.email());
    assertEquals(EntityKind.ALL, actualCheckPersonIsRecipientOrOwnerOrAdminResult.kind());
    assertEquals(
        PersonKind.EMPLOYEE, actualCheckPersonIsRecipientOrOwnerOrAdminResult.personKind());
    assertTrue(actualCheckPersonIsRecipientOrOwnerOrAdminResult.isRemoved());
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}
   */
  @Test
  @DisplayName("Test checkPersonIsOwnerOrAdmin(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsOwnerOrAdmin(String, long)"})
  void testCheckPersonIsOwnerOrAdmin() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.checkPersonIsOwnerOrAdmin("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}
   */
  @Test
  @DisplayName("Test checkPersonIsOwnerOrAdmin(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsOwnerOrAdmin(String, long)"})
  void testCheckPersonIsOwnerOrAdmin2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.checkPersonIsOwnerOrAdmin("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}
   */
  @Test
  @DisplayName("Test checkPersonIsOwnerOrAdmin(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsOwnerOrAdmin(String, long)"})
  void testCheckPersonIsOwnerOrAdmin3() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService, personService, settingsService);
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
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService2,
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.checkPersonIsOwnerOrAdmin("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(userRoleDao).getUserRoles("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}
   */
  @Test
  @DisplayName(
      "Test checkPersonIsOwnerOrAdmin(String, long); given UserRoleService hasRole(String, SystemRole[]) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsOwnerOrAdmin(String, long)"})
  void testCheckPersonIsOwnerOrAdmin_givenUserRoleServiceHasRoleReturnFalse() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(false);

    // Act
    Person actualCheckPersonIsOwnerOrAdminResult =
        surveyInstanceService.checkPersonIsOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertTrue(actualCheckPersonIsOwnerOrAdminResult instanceof ImmutablePerson);
    assertEquals("42", actualCheckPersonIsOwnerOrAdminResult.employeeId());
    assertEquals("42", actualCheckPersonIsOwnerOrAdminResult.userId());
    assertEquals("Display Name", actualCheckPersonIsOwnerOrAdminResult.displayName());
    assertEquals("Display Name", actualCheckPersonIsOwnerOrAdminResult.name());
    assertEquals("jane.doe@example.org", actualCheckPersonIsOwnerOrAdminResult.email());
    assertEquals(EntityKind.ALL, actualCheckPersonIsOwnerOrAdminResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCheckPersonIsOwnerOrAdminResult.personKind());
    assertTrue(actualCheckPersonIsOwnerOrAdminResult.isRemoved());
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}
   */
  @Test
  @DisplayName(
      "Test checkPersonIsOwnerOrAdmin(String, long); given UserRoleService hasRole(String, SystemRole[]) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsOwnerOrAdmin(String, long)"})
  void testCheckPersonIsOwnerOrAdmin_givenUserRoleServiceHasRoleReturnTrue() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    Person actualCheckPersonIsOwnerOrAdminResult =
        surveyInstanceService.checkPersonIsOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertTrue(actualCheckPersonIsOwnerOrAdminResult instanceof ImmutablePerson);
    assertEquals("42", actualCheckPersonIsOwnerOrAdminResult.employeeId());
    assertEquals("42", actualCheckPersonIsOwnerOrAdminResult.userId());
    assertEquals("Display Name", actualCheckPersonIsOwnerOrAdminResult.displayName());
    assertEquals("Display Name", actualCheckPersonIsOwnerOrAdminResult.name());
    assertEquals("jane.doe@example.org", actualCheckPersonIsOwnerOrAdminResult.email());
    assertEquals(EntityKind.ALL, actualCheckPersonIsOwnerOrAdminResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCheckPersonIsOwnerOrAdminResult.personKind());
    assertTrue(actualCheckPersonIsOwnerOrAdminResult.isRemoved());
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}.
   *
   * <ul>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsOwnerOrAdmin(String, long)}
   */
  @Test
  @DisplayName("Test checkPersonIsOwnerOrAdmin(String, long); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsOwnerOrAdmin(String, long)"})
  void testCheckPersonIsOwnerOrAdmin_thenCallsGetUserRoles() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService, personService, settingsService);
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
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService2,
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

    // Act
    Person actualCheckPersonIsOwnerOrAdminResult =
        surveyInstanceService.checkPersonIsOwnerOrAdmin("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualCheckPersonIsOwnerOrAdminResult instanceof ImmutablePerson);
    assertEquals("42", actualCheckPersonIsOwnerOrAdminResult.employeeId());
    assertEquals("42", actualCheckPersonIsOwnerOrAdminResult.userId());
    assertEquals("Display Name", actualCheckPersonIsOwnerOrAdminResult.displayName());
    assertEquals("Display Name", actualCheckPersonIsOwnerOrAdminResult.name());
    assertEquals("jane.doe@example.org", actualCheckPersonIsOwnerOrAdminResult.email());
    assertEquals(EntityKind.ALL, actualCheckPersonIsOwnerOrAdminResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCheckPersonIsOwnerOrAdminResult.personKind());
    assertTrue(actualCheckPersonIsOwnerOrAdminResult.isRemoved());
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsRecipient(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsRecipient(String, long)}
   */
  @Test
  @DisplayName("Test checkPersonIsRecipient(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsRecipient(String, long)"})
  void testCheckPersonIsRecipient() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.checkPersonIsRecipient("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsRecipient(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsRecipient(String, long)}
   */
  @Test
  @DisplayName("Test checkPersonIsRecipient(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsRecipient(String, long)"})
  void testCheckPersonIsRecipient2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.checkPersonIsRecipient("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
  }

  /**
   * Test {@link SurveyInstanceService#checkPersonIsRecipient(String, long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#checkPersonIsRecipient(String, long)}
   */
  @Test
  @DisplayName("Test checkPersonIsRecipient(String, long); then return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person SurveyInstanceService.checkPersonIsRecipient(String, long)"})
  void testCheckPersonIsRecipient_thenReturnImmutablePerson() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    // Act
    Person actualCheckPersonIsRecipientResult =
        surveyInstanceService.checkPersonIsRecipient("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    assertTrue(actualCheckPersonIsRecipientResult instanceof ImmutablePerson);
    assertEquals("42", actualCheckPersonIsRecipientResult.employeeId());
    assertEquals("42", actualCheckPersonIsRecipientResult.userId());
    assertEquals("Display Name", actualCheckPersonIsRecipientResult.displayName());
    assertEquals("Display Name", actualCheckPersonIsRecipientResult.name());
    assertEquals("jane.doe@example.org", actualCheckPersonIsRecipientResult.email());
    assertEquals(EntityKind.ALL, actualCheckPersonIsRecipientResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCheckPersonIsRecipientResult.personKind());
    assertTrue(actualCheckPersonIsRecipientResult.isRemoved());
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyInstanceViewService.getFormDetailsById(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(surveyInstanceViewService).getFormDetailsById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyInstanceViewService.getFormDetailsById(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());
    when(surveyQuestionService.findForSurveyInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(surveyInstanceViewService).getFormDetailsById(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus3() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyInstanceViewService.getFormDetailsById(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(surveyInstanceViewService).getFormDetailsById(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus4() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    when(surveyQuestionResponseDao.deletePreviousResponse(
            Mockito.<Optional<DSLContext>>any(),
            Mockito.<List<SurveyInstanceQuestionResponse>>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyInstanceViewService.getFormDetailsById(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyQuestionResponseDao).deletePreviousResponse(isA(Optional.class), isA(List.class));
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(surveyInstanceViewService).getFormDetailsById(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus5() {
    // Arrange
    when(changeLogService.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.markSubmitted(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyInstanceViewService.getFormDetailsById(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference2);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    SurveyInstanceStatus actualUpdateStatusResult =
        surveyInstanceService.updateStatus(
            tx,
            "janedoe",
            1L,
            ImmutableSurveyInstanceStatusChangeCommand.builder()
                .action(SurveyInstanceAction.SUBMITTING)
                .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                .newDueDate(LocalDate.of(1970, 1, 1))
                .reason("Just cause")
                .build());

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao).markSubmitted(isA(Optional.class), eq(1L), eq("janedoe"));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(changeLogService).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceViewService).getFormDetailsById(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(SurveyInstanceStatus.COMPLETED, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus6() {
    // Arrange
    when(changeLogService.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.markSubmitted(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyInstanceViewService.getFormDetailsById(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference2);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    ImmutableSurveyQuestion.Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference3);
    surveyQuestionList.add(
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    SurveyInstanceStatus actualUpdateStatusResult =
        surveyInstanceService.updateStatus(
            tx,
            "janedoe",
            1L,
            ImmutableSurveyInstanceStatusChangeCommand.builder()
                .action(SurveyInstanceAction.SUBMITTING)
                .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                .newDueDate(LocalDate.of(1970, 1, 1))
                .reason("Just cause")
                .build());

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao).markSubmitted(isA(Optional.class), eq(1L), eq("janedoe"));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(changeLogService).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceViewService).getFormDetailsById(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(SurveyInstanceStatus.COMPLETED, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateStatus(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<SurveyInstanceStatus>any()))
        .thenReturn(1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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
            surveyTemplateDao);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    SurveyInstanceStatus actualUpdateStatusResult =
        surveyInstanceService.updateStatus(
            tx,
            "janedoe",
            1L,
            ImmutableSurveyInstanceStatusChangeCommand.builder()
                .action(SurveyInstanceAction.WITHDRAWING)
                .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                .newDueDate(LocalDate.of(1970, 1, 1))
                .reason("Just cause")
                .build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao)
        .updateStatus(isA(Optional.class), eq(1L), eq(SurveyInstanceStatus.WITHDRAWN));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleDao, atLeast(1)).getUserRoles("janedoe");
    assertEquals(SurveyInstanceStatus.WITHDRAWN, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#getActiveByUserEmail(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); given PersonDao getActiveByUserEmail(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_givenPersonDaoGetActiveByUserEmailThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceDao} {@link SurveyInstanceDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); given SurveyInstanceDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_givenSurveyInstanceDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(surveyInstanceDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceDao} {@link SurveyInstanceDao#updateStatus(Optional, long,
   *       SurveyInstanceStatus)} return one.
   *   <li>Then return {@code WITHDRAWN}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); given SurveyInstanceDao updateStatus(Optional, long, SurveyInstanceStatus) return one; then return 'WITHDRAWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_givenSurveyInstanceDaoUpdateStatusReturnOne_thenReturnWithdrawn() {
    // Arrange
    when(changeLogService.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.updateStatus(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<SurveyInstanceStatus>any()))
        .thenReturn(1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    SurveyInstanceStatus actualUpdateStatusResult =
        surveyInstanceService.updateStatus(
            tx,
            "janedoe",
            1L,
            ImmutableSurveyInstanceStatusChangeCommand.builder()
                .action(SurveyInstanceAction.WITHDRAWING)
                .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                .newDueDate(LocalDate.of(1970, 1, 1))
                .reason("Just cause")
                .build());

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao)
        .updateStatus(isA(Optional.class), eq(1L), eq(SurveyInstanceStatus.WITHDRAWN));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(changeLogService).write(isA(Optional.class), isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(SurveyInstanceStatus.WITHDRAWN, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceDao} {@link SurveyInstanceDao#updateStatus(Optional, long,
   *       SurveyInstanceStatus)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); given SurveyInstanceDao updateStatus(Optional, long, SurveyInstanceStatus) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_givenSurveyInstanceDaoUpdateStatusThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.updateStatus(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<SurveyInstanceStatus>any()))
        .thenThrow(new IllegalArgumentException());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.WITHDRAWING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao)
        .updateStatus(isA(Optional.class), eq(1L), eq(SurveyInstanceStatus.WITHDRAWN));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyRunDao} {@link SurveyRunDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); given SurveyRunDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_givenSurveyRunDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyRunDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); given SurveyTemplateDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_givenSurveyTemplateDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasAnyRole(String, Set)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); given UserRoleService hasAnyRole(String, Set) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_givenUserRoleServiceHasAnyRoleThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.SUBMITTING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); then calls deletePreviousResponse(Optional, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_thenCallsDeletePreviousResponse() {
    // Arrange
    when(changeLogService.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.markSubmitted(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    when(surveyQuestionResponseDao.deletePreviousResponse(
            Mockito.<Optional<DSLContext>>any(),
            Mockito.<List<SurveyInstanceQuestionResponse>>any()))
        .thenReturn(1);
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyInstanceViewService.getFormDetailsById(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    SurveyInstanceStatus actualUpdateStatusResult =
        surveyInstanceService.updateStatus(
            tx,
            "janedoe",
            1L,
            ImmutableSurveyInstanceStatusChangeCommand.builder()
                .action(SurveyInstanceAction.SUBMITTING)
                .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                .newDueDate(LocalDate.of(1970, 1, 1))
                .reason("Just cause")
                .build());

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao).markSubmitted(isA(Optional.class), eq(1L), eq("janedoe"));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyQuestionResponseDao).deletePreviousResponse(isA(Optional.class), isA(List.class));
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(changeLogService).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceViewService).getFormDetailsById(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(SurveyInstanceStatus.COMPLETED, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_thenCallsGetUserRoles() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateStatus(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<SurveyInstanceStatus>any()))
        .thenThrow(new IllegalArgumentException());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService, personService, settingsService);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService2,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            surveyTemplateDao);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateStatus(
                tx,
                "janedoe",
                1L,
                ImmutableSurveyInstanceStatusChangeCommand.builder()
                    .action(SurveyInstanceAction.WITHDRAWING)
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao)
        .updateStatus(isA(Optional.class), eq(1L), eq(SurveyInstanceStatus.WITHDRAWN));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleDao, atLeast(1)).getUserRoles("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Then return {@code COMPLETED}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateStatus(Optional, String, long,
   * SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand); then return 'COMPLETED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceService.updateStatus(Optional, String, long, SurveyInstanceStatusChangeCommand)"
  })
  void testUpdateStatus_thenReturnCompleted() {
    // Arrange
    when(changeLogService.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.markSubmitted(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyInstanceViewService.getFormDetailsById(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    SurveyInstanceStatus actualUpdateStatusResult =
        surveyInstanceService.updateStatus(
            tx,
            "janedoe",
            1L,
            ImmutableSurveyInstanceStatusChangeCommand.builder()
                .action(SurveyInstanceAction.SUBMITTING)
                .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                .newDueDate(LocalDate.of(1970, 1, 1))
                .reason("Just cause")
                .build());

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao).markSubmitted(isA(Optional.class), eq(1L), eq("janedoe"));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(changeLogService).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceViewService).getFormDetailsById(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(SurveyInstanceStatus.COMPLETED, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses() {
    // Arrange
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.removeUnnecessaryResponses(tx, 1L));
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses2() {
    // Arrange
    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    when(surveyQuestionResponseDao.deletePreviousResponse(
            Mockito.<Optional<DSLContext>>any(),
            Mockito.<List<SurveyInstanceQuestionResponse>>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.removeUnnecessaryResponses(tx, 1L));
    verify(surveyQuestionResponseDao).deletePreviousResponse(isA(Optional.class), isA(List.class));
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses3() {
    // Arrange
    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference2);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult =
        surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    assertEquals(0, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses4() {
    // Arrange
    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference2);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    ImmutableSurveyQuestion.Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference3);
    surveyQuestionList.add(
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult =
        surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    assertEquals(0, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionResponseDao}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long); given SurveyQuestionResponseDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses_givenSurveyQuestionResponseDao() {
    // Arrange
    when(surveyQuestionService.findForSurveyInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.removeUnnecessaryResponses(tx, 1L));
    verify(surveyQuestionService).findForSurveyInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceEvaluator#eval(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long); then calls eval(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses_thenCallsEval() {
    // Arrange
    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deletePreviousResponse(
            Mockito.<Optional<DSLContext>>any(),
            Mockito.<List<SurveyInstanceQuestionResponse>>any()))
        .thenReturn(1);
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    SurveyInstanceEvaluator evaluator = mock(SurveyInstanceEvaluator.class);
    when(evaluator.eval(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);
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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult =
        surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(surveyQuestionResponseDao).deletePreviousResponse(isA(Optional.class), isA(List.class));
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(evaluator).eval(1L);
    assertEquals(1, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses_thenCallsGetById() {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(instanceDao.getById(anyLong()))
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

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);
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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult =
        surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertEquals(0, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses_thenCallsGetById2() {
    // Arrange
    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deletePreviousResponse(
            Mockito.<Optional<DSLContext>>any(),
            Mockito.<List<SurveyInstanceQuestionResponse>>any()))
        .thenReturn(1);
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(instanceDao.getById(anyLong()))
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

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList2 =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult2 =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult2 =
        dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult2 =
        entityListResponseResult2.entityResponse(entityResponse2);
    surveyInstanceQuestionResponseList2.add(
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList2);

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);
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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult =
        surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(surveyQuestionResponseDao).deletePreviousResponse(isA(Optional.class), isA(List.class));
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertEquals(1, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses_thenCallsGetById3() {
    // Arrange
    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deletePreviousResponse(
            Mockito.<Optional<DSLContext>>any(),
            Mockito.<List<SurveyInstanceQuestionResponse>>any()))
        .thenReturn(1);
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);

    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(instanceDao.getById(anyLong()))
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

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList2 =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult2 =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult2 =
        dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult2 =
        entityListResponseResult2.entityResponse(entityResponse2);
    surveyInstanceQuestionResponseList2.add(
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult3 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult3 =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse3 = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult3 =
        builderResult3
            .booleanResponse(booleanResponse3)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult3 =
        dateResponseResult3.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse3 = Optional.of(immutableEntityReference3);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult3 =
        entityListResponseResult3.entityResponse(entityResponse3);
    surveyInstanceQuestionResponseList2.add(
        personIdResult3
            .questionResponse(
                entityResponseResult3
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList2);

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);
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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult =
        surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(surveyQuestionResponseDao).deletePreviousResponse(isA(Optional.class), isA(List.class));
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertEquals(1, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses_thenReturnOne() {
    // Arrange
    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
    when(surveyQuestionResponseDao.deletePreviousResponse(
            Mockito.<Optional<DSLContext>>any(),
            Mockito.<List<SurveyInstanceQuestionResponse>>any()))
        .thenReturn(1);
    when(surveyQuestionResponseDao.findForInstance(anyLong()))
        .thenReturn(surveyInstanceQuestionResponseList);
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult =
        surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(surveyQuestionResponseDao).deletePreviousResponse(isA(Optional.class), isA(List.class));
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    assertEquals(1, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#removeUnnecessaryResponses(Optional, long)}
   */
  @Test
  @DisplayName("Test removeUnnecessaryResponses(Optional, long); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.removeUnnecessaryResponses(Optional, long)"})
  void testRemoveUnnecessaryResponses_thenReturnZero() {
    // Arrange
    when(surveyQuestionResponseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualRemoveUnnecessaryResponsesResult =
        surveyInstanceService.removeUnnecessaryResponses(tx, 1L);

    // Assert
    verify(surveyQuestionResponseDao).findForInstance(1L);
    verify(surveyQuestionService).findForSurveyInstance(1L);
    assertEquals(0, actualRemoveUnnecessaryResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateSubmissionDueDate(String, long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateSubmissionDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateSubmissionDueDate(String, long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateSubmissionDueDate(String, long, LocalDate)"})
  void testUpdateSubmissionDueDate() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateSubmissionDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1)));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#updateSubmissionDueDate(String, long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateSubmissionDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateSubmissionDueDate(String, long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateSubmissionDueDate(String, long, LocalDate)"})
  void testUpdateSubmissionDueDate2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateSubmissionDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1)));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateSubmissionDueDate(String, long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateSubmissionDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateSubmissionDueDate(String, long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateSubmissionDueDate(String, long, LocalDate)"})
  void testUpdateSubmissionDueDate3() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.updateSubmissionDueDate(anyLong(), Mockito.<LocalDate>any()))
        .thenThrow(new IllegalArgumentException());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.updateSubmissionDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1)));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceDao).updateSubmissionDueDate(eq(1L), isA(LocalDate.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateSubmissionDueDate(String, long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateSubmissionDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateSubmissionDueDate(String, long, LocalDate); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateSubmissionDueDate(String, long, LocalDate)"})
  void testUpdateSubmissionDueDate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateSubmissionDueDate(anyLong(), Mockito.<LocalDate>any()))
        .thenReturn(1);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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

    // Act
    int actualUpdateSubmissionDueDateResult =
        surveyInstanceService.updateSubmissionDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceDao).updateSubmissionDueDate(eq(1L), isA(LocalDate.class));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(userRoleDao).getUserRoles("janedoe");
    assertEquals(1, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateSubmissionDueDate(String, long, LocalDate)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateSubmissionDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateSubmissionDueDate(String, long, LocalDate); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateSubmissionDueDate(String, long, LocalDate)"})
  void testUpdateSubmissionDueDate_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.updateSubmissionDueDate(anyLong(), Mockito.<LocalDate>any()))
        .thenReturn(1);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    int actualUpdateSubmissionDueDateResult =
        surveyInstanceService.updateSubmissionDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceDao).updateSubmissionDueDate(eq(1L), isA(LocalDate.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertEquals(1, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateApprovalDueDate(String, long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateApprovalDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDate(String, long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateApprovalDueDate(String, long, LocalDate)"})
  void testUpdateApprovalDueDate() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.updateApprovalDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1)));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#updateApprovalDueDate(String, long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateApprovalDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDate(String, long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateApprovalDueDate(String, long, LocalDate)"})
  void testUpdateApprovalDueDate2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.updateApprovalDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1)));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateApprovalDueDate(String, long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#updateApprovalDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDate(String, long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateApprovalDueDate(String, long, LocalDate)"})
  void testUpdateApprovalDueDate3() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.updateApprovalDueDate(anyLong(), Mockito.<LocalDate>any()))
        .thenThrow(new IllegalArgumentException());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.updateApprovalDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1)));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceDao).updateApprovalDueDate(eq(1L), isA(LocalDate.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#updateApprovalDueDate(String, long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateApprovalDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateApprovalDueDate(String, long, LocalDate); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateApprovalDueDate(String, long, LocalDate)"})
  void testUpdateApprovalDueDate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateApprovalDueDate(anyLong(), Mockito.<LocalDate>any()))
        .thenReturn(42);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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

    // Act
    int actualUpdateApprovalDueDateResult =
        surveyInstanceService.updateApprovalDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceDao).updateApprovalDueDate(eq(1L), isA(LocalDate.class));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(userRoleDao).getUserRoles("janedoe");
    assertEquals(42, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceService#updateApprovalDueDate(String, long, LocalDate)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#updateApprovalDueDate(String, long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDate(String, long, LocalDate); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceService.updateApprovalDueDate(String, long, LocalDate)"})
  void testUpdateApprovalDueDate_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.updateApprovalDueDate(anyLong(), Mockito.<LocalDate>any()))
        .thenReturn(42);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    int actualUpdateApprovalDueDateResult =
        surveyInstanceService.updateApprovalDueDate("janedoe", 1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceDao).updateApprovalDueDate(eq(1L), isA(LocalDate.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertEquals(42, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceService#findBySurveyInstanceIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * SurveyInstanceService#findBySurveyInstanceIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySurveyInstanceIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceService.findBySurveyInstanceIdSelector(IdSelectionOptions)"
  })
  void testFindBySurveyInstanceIdSelector() {
    // Arrange
    when(surveyInstanceDao.findBySurveyInstanceIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<SurveyInstance> actualFindBySurveyInstanceIdSelectorResult =
        surveyInstanceService.findBySurveyInstanceIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(surveyInstanceDao).findBySurveyInstanceIdSelector(isA(Select.class));
    assertTrue(actualFindBySurveyInstanceIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findBySurveyInstanceIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyInstanceService#findBySurveyInstanceIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySurveyInstanceIdSelector(IdSelectionOptions); given EXACT; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceService.findBySurveyInstanceIdSelector(IdSelectionOptions)"
  })
  void testFindBySurveyInstanceIdSelector_givenExact_thenReturnEmpty() {
    // Arrange
    when(surveyInstanceDao.findBySurveyInstanceIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    List<SurveyInstance> actualFindBySurveyInstanceIdSelectorResult =
        surveyInstanceService.findBySurveyInstanceIdSelector(idSelectionOptions);

    // Assert
    verify(surveyInstanceDao).findBySurveyInstanceIdSelector(isA(Select.class));
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySurveyInstanceIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findBySurveyInstanceIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyInstanceService#findBySurveyInstanceIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySurveyInstanceIdSelector(IdSelectionOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceService.findBySurveyInstanceIdSelector(IdSelectionOptions)"
  })
  void testFindBySurveyInstanceIdSelector_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.findBySurveyInstanceIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.findBySurveyInstanceIdSelector(idSelectionOptions));
    verify(surveyInstanceDao).findBySurveyInstanceIdSelector(isA(Select.class));
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).scope();
  }

  /**
   * Test {@link SurveyInstanceService#findPreviousVersionsForInstance(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPreviousVersionsForInstance(long)}
   */
  @Test
  @DisplayName("Test findPreviousVersionsForInstance(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPreviousVersionsForInstance(long)"})
  void testFindPreviousVersionsForInstance_thenReturnEmpty() {
    // Arrange
    when(surveyInstanceDao.findPreviousVersionsForInstance(anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SurveyInstance> actualFindPreviousVersionsForInstanceResult =
        surveyInstanceService.findPreviousVersionsForInstance(1L);

    // Assert
    verify(surveyInstanceDao).findPreviousVersionsForInstance(1L);
    assertTrue(actualFindPreviousVersionsForInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findPreviousVersionsForInstance(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPreviousVersionsForInstance(long)}
   */
  @Test
  @DisplayName("Test findPreviousVersionsForInstance(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPreviousVersionsForInstance(long)"})
  void testFindPreviousVersionsForInstance_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.findPreviousVersionsForInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.findPreviousVersionsForInstance(1L));
    verify(surveyInstanceDao).findPreviousVersionsForInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findVersionsForInstance(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findVersionsForInstance(long)}
   */
  @Test
  @DisplayName("Test findVersionsForInstance(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findVersionsForInstance(long)"})
  void testFindVersionsForInstance_thenReturnEmpty() {
    // Arrange
    when(surveyInstanceDao.findVersionsForInstance(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<SurveyInstance> actualFindVersionsForInstanceResult =
        surveyInstanceService.findVersionsForInstance(1L);

    // Assert
    verify(surveyInstanceDao).findVersionsForInstance(1L);
    assertTrue(actualFindVersionsForInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findVersionsForInstance(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findVersionsForInstance(long)}
   */
  @Test
  @DisplayName("Test findVersionsForInstance(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findVersionsForInstance(long)"})
  void testFindVersionsForInstance_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.findVersionsForInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.findVersionsForInstance(1L));
    verify(surveyInstanceDao).findVersionsForInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#addRecipient(String,
   * SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  @DisplayName("Test addRecipient(String, SurveyInstanceRecipientCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addRecipient(String, SurveyInstanceRecipientCreateCommand)"
  })
  void testAddRecipient() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any()))
        .thenThrow(new IllegalArgumentException());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.addRecipient(
                "janedoe",
                ImmutableSurveyInstanceRecipientCreateCommand.builder()
                    .personId(1L)
                    .surveyInstanceId(1L)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addRecipient(String,
   * SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addRecipient(String, SurveyInstanceRecipientCreateCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addRecipient(String, SurveyInstanceRecipientCreateCommand)"
  })
  void testAddRecipient_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any()))
        .thenReturn(1L);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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

    // Act
    long actualAddRecipientResult =
        surveyInstanceService.addRecipient(
            "janedoe",
            ImmutableSurveyInstanceRecipientCreateCommand.builder()
                .personId(1L)
                .surveyInstanceId(1L)
                .build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(userRoleDao).getUserRoles("janedoe");
    assertEquals(1L, actualAddRecipientResult);
  }

  /**
   * Test {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addRecipient(String,
   * SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addRecipient(String, SurveyInstanceRecipientCreateCommand); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addRecipient(String, SurveyInstanceRecipientCreateCommand)"
  })
  void testAddRecipient_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any()))
        .thenReturn(1L);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    long actualAddRecipientResult =
        surveyInstanceService.addRecipient(
            "janedoe",
            ImmutableSurveyInstanceRecipientCreateCommand.builder()
                .personId(1L)
                .surveyInstanceId(1L)
                .build());

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertEquals(1L, actualAddRecipientResult);
  }

  /**
   * Test {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#getActiveByUserEmail(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addRecipient(String,
   * SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addRecipient(String, SurveyInstanceRecipientCreateCommand); given PersonDao getActiveByUserEmail(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addRecipient(String, SurveyInstanceRecipientCreateCommand)"
  })
  void testAddRecipient_givenPersonDaoGetActiveByUserEmailThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.addRecipient(
                "janedoe",
                ImmutableSurveyInstanceRecipientCreateCommand.builder()
                    .personId(1L)
                    .surveyInstanceId(1L)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#addRecipient(String, SurveyInstanceRecipientCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addRecipient(String,
   * SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addRecipient(String, SurveyInstanceRecipientCreateCommand); given UserRoleService hasRole(String, SystemRole[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addRecipient(String, SurveyInstanceRecipientCreateCommand)"
  })
  void testAddRecipient_givenUserRoleServiceHasRoleThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.addRecipient(
                "janedoe",
                ImmutableSurveyInstanceRecipientCreateCommand.builder()
                    .personId(1L)
                    .surveyInstanceId(1L)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addOwner(String,
   * SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, SurveyInstanceOwnerCreateCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addOwner(String, SurveyInstanceOwnerCreateCommand)"
  })
  void testAddOwner_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any()))
        .thenReturn(1L);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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

    // Act
    long actualAddOwnerResult =
        surveyInstanceService.addOwner(
            "janedoe",
            ImmutableSurveyInstanceOwnerCreateCommand.builder()
                .personId(1L)
                .surveyInstanceId(1L)
                .build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(userRoleDao).getUserRoles("janedoe");
    assertEquals(1L, actualAddOwnerResult);
  }

  /**
   * Test {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addOwner(String,
   * SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, SurveyInstanceOwnerCreateCommand); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addOwner(String, SurveyInstanceOwnerCreateCommand)"
  })
  void testAddOwner_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any()))
        .thenReturn(1L);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    long actualAddOwnerResult =
        surveyInstanceService.addOwner(
            "janedoe",
            ImmutableSurveyInstanceOwnerCreateCommand.builder()
                .personId(1L)
                .surveyInstanceId(1L)
                .build());

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertEquals(1L, actualAddOwnerResult);
  }

  /**
   * Test {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#getActiveByUserEmail(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addOwner(String,
   * SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, SurveyInstanceOwnerCreateCommand); given PersonDao getActiveByUserEmail(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addOwner(String, SurveyInstanceOwnerCreateCommand)"
  })
  void testAddOwner_givenPersonDaoGetActiveByUserEmailThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.addOwner(
                "janedoe",
                ImmutableSurveyInstanceOwnerCreateCommand.builder()
                    .personId(1L)
                    .surveyInstanceId(1L)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceOwnerDao} {@link
   *       SurveyInstanceOwnerDao#create(SurveyInstanceOwnerCreateCommand)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addOwner(String,
   * SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, SurveyInstanceOwnerCreateCommand); given SurveyInstanceOwnerDao create(SurveyInstanceOwnerCreateCommand) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addOwner(String, SurveyInstanceOwnerCreateCommand)"
  })
  void testAddOwner_givenSurveyInstanceOwnerDaoCreateThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any()))
        .thenThrow(new IllegalArgumentException());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.addOwner(
                "janedoe",
                ImmutableSurveyInstanceOwnerCreateCommand.builder()
                    .personId(1L)
                    .surveyInstanceId(1L)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#addOwner(String, SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#addOwner(String,
   * SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, SurveyInstanceOwnerCreateCommand); given UserRoleService hasRole(String, SystemRole[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long SurveyInstanceService.addOwner(String, SurveyInstanceOwnerCreateCommand)"
  })
  void testAddOwner_givenUserRoleServiceHasRoleThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.addOwner(
                "janedoe",
                ImmutableSurveyInstanceOwnerCreateCommand.builder()
                    .personId(1L)
                    .surveyInstanceId(1L)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#deleteRecipient(String, long, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  @DisplayName("Test deleteRecipient(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteRecipient(String, long, long)"})
  void testDeleteRecipient() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.deleteRecipient("janedoe", 1L, 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#deleteRecipient(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteRecipient(String, long, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteRecipient(String, long, long)"})
  void testDeleteRecipient_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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

    // Act
    boolean actualDeleteRecipientResult = surveyInstanceService.deleteRecipient("janedoe", 1L, 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(1L, 1L);
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualDeleteRecipientResult);
  }

  /**
   * Test {@link SurveyInstanceService#deleteRecipient(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteRecipient(String, long, long); given UserRoleService hasRole(String, SystemRole[]) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteRecipient(String, long, long)"})
  void testDeleteRecipient_givenUserRoleServiceHasRoleReturnFalse() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(false);

    // Act
    boolean actualDeleteRecipientResult = surveyInstanceService.deleteRecipient("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(1L, 1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertTrue(actualDeleteRecipientResult);
  }

  /**
   * Test {@link SurveyInstanceService#deleteRecipient(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteRecipient(String, long, long); given UserRoleService hasRole(String, SystemRole[]) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteRecipient(String, long, long)"})
  void testDeleteRecipient_givenUserRoleServiceHasRoleReturnTrue_thenReturnTrue() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    boolean actualDeleteRecipientResult = surveyInstanceService.deleteRecipient("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(1L, 1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertTrue(actualDeleteRecipientResult);
  }

  /**
   * Test {@link SurveyInstanceService#deleteRecipient(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteRecipient(String, long, long); given UserRoleService hasRole(String, SystemRole[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteRecipient(String, long, long)"})
  void testDeleteRecipient_givenUserRoleServiceHasRoleThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.deleteRecipient("janedoe", 1L, 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#deleteRecipient(String, long, long)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteRecipient(String, long, long)}
   */
  @Test
  @DisplayName("Test deleteRecipient(String, long, long); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteRecipient(String, long, long)"})
  void testDeleteRecipient_thenReturnFalse() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.deleteByInstanceAndPerson(anyLong(), anyLong()))
        .thenReturn(false);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    boolean actualDeleteRecipientResult = surveyInstanceService.deleteRecipient("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceRecipientDao).deleteByInstanceAndPerson(1L, 1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertFalse(actualDeleteRecipientResult);
  }

  /**
   * Test {@link SurveyInstanceService#deleteOwner(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteOwner(String, long, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteOwner(String, long, long)"})
  void testDeleteOwner_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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

    // Act
    boolean actualDeleteOwnerResult = surveyInstanceService.deleteOwner("janedoe", 1L, 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).delete(1L, 1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualDeleteOwnerResult);
  }

  /**
   * Test {@link SurveyInstanceService#deleteOwner(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#getActiveByUserEmail(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteOwner(String, long, long); given PersonDao getActiveByUserEmail(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteOwner(String, long, long)"})
  void testDeleteOwner_givenPersonDaoGetActiveByUserEmailThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.deleteOwner("janedoe", 1L, 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#deleteOwner(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceOwnerDao} {@link SurveyInstanceOwnerDao#delete(long, long)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteOwner(String, long, long); given SurveyInstanceOwnerDao delete(long, long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteOwner(String, long, long)"})
  void testDeleteOwner_givenSurveyInstanceOwnerDaoDeleteReturnFalse_thenReturnFalse() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(false);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    boolean actualDeleteOwnerResult = surveyInstanceService.deleteOwner("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).delete(1L, 1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertFalse(actualDeleteOwnerResult);
  }

  /**
   * Test {@link SurveyInstanceService#deleteOwner(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteOwner(String, long, long); given UserRoleService hasRole(String, SystemRole[]) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteOwner(String, long, long)"})
  void testDeleteOwner_givenUserRoleServiceHasRoleReturnFalse() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(false);

    // Act
    boolean actualDeleteOwnerResult = surveyInstanceService.deleteOwner("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).delete(1L, 1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertTrue(actualDeleteOwnerResult);
  }

  /**
   * Test {@link SurveyInstanceService#deleteOwner(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteOwner(String, long, long); given UserRoleService hasRole(String, SystemRole[]) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteOwner(String, long, long)"})
  void testDeleteOwner_givenUserRoleServiceHasRoleReturnTrue_thenReturnTrue() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceOwnerDao.delete(anyLong(), anyLong())).thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    boolean actualDeleteOwnerResult = surveyInstanceService.deleteOwner("janedoe", 1L, 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(personDao).getById(1L);
    verify(surveyInstanceOwnerDao).delete(1L, 1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertTrue(actualDeleteOwnerResult);
  }

  /**
   * Test {@link SurveyInstanceService#deleteOwner(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, SystemRole[])} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#deleteOwner(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteOwner(String, long, long); given UserRoleService hasRole(String, SystemRole[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceService.deleteOwner(String, long, long)"})
  void testDeleteOwner_givenUserRoleServiceHasRoleThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.deleteOwner("janedoe", 1L, 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyRunDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance3() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance4() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance5() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(3, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.SAVING, actualFindPossibleActionsForInstanceResult.get(2));
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualFindPossibleActionsForInstanceResult.get(1));
    assertEquals(
        SurveyInstanceAction.WITHDRAWING, actualFindPossibleActionsForInstanceResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance6() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(false);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(3, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.SAVING, actualFindPossibleActionsForInstanceResult.get(2));
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualFindPossibleActionsForInstanceResult.get(1));
    assertEquals(
        SurveyInstanceAction.WITHDRAWING, actualFindPossibleActionsForInstanceResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance7() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(false);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(3, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.SAVING, actualFindPossibleActionsForInstanceResult.get(2));
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualFindPossibleActionsForInstanceResult.get(1));
    assertEquals(
        SurveyInstanceAction.WITHDRAWING, actualFindPossibleActionsForInstanceResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long); given PersonDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance_givenPersonDao() {
    // Arrange
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L));
    verify(surveyInstanceDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasAnyRole(String, Set)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName(
      "Test findPossibleActionsForInstance(String, long); given UserRoleService hasAnyRole(String, Set) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance_givenUserRoleServiceHasAnyRoleReturnFalse() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(false);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(3, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.SAVING, actualFindPossibleActionsForInstanceResult.get(2));
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualFindPossibleActionsForInstanceResult.get(1));
    assertEquals(
        SurveyInstanceAction.WITHDRAWING, actualFindPossibleActionsForInstanceResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <ul>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance_thenCallsGetUserRoles() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService, personService, settingsService);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService2,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            surveyTemplateDao);

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleDao, atLeast(1)).getUserRoles("janedoe");
    assertEquals(3, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.SAVING, actualFindPossibleActionsForInstanceResult.get(2));
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualFindPossibleActionsForInstanceResult.get(1));
    assertEquals(
        SurveyInstanceAction.WITHDRAWING, actualFindPossibleActionsForInstanceResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <ul>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance_thenCallsGetUserRoles2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService, personService, settingsService);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService2,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            surveyTemplateDao);

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleDao, atLeast(1)).getUserRoles("janedoe");
    assertEquals(3, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.SAVING, actualFindPossibleActionsForInstanceResult.get(2));
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualFindPossibleActionsForInstanceResult.get(1));
    assertEquals(
        SurveyInstanceAction.WITHDRAWING, actualFindPossibleActionsForInstanceResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <ul>
   *   <li>Then return first is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName(
      "Test findPossibleActionsForInstance(String, long); then return first is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance_thenReturnFirstIsSubmitting() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
            .status(SurveyInstanceStatus.IN_PROGRESS)
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(3, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.SAVING, actualFindPossibleActionsForInstanceResult.get(2));
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualFindPossibleActionsForInstanceResult.get(0));
    assertEquals(
        SurveyInstanceAction.WITHDRAWING, actualFindPossibleActionsForInstanceResult.get(1));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <ul>
   *   <li>Then return second is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName(
      "Test findPossibleActionsForInstance(String, long); then return second is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance_thenReturnSecondIsSubmitting() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(3, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.SAVING, actualFindPossibleActionsForInstanceResult.get(2));
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualFindPossibleActionsForInstanceResult.get(1));
    assertEquals(
        SurveyInstanceAction.WITHDRAWING, actualFindPossibleActionsForInstanceResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceService#findPossibleActionsForInstance(String, long)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findPossibleActionsForInstance(String,
   * long)}
   */
  @Test
  @DisplayName("Test findPossibleActionsForInstance(String, long); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceService.findPossibleActionsForInstance(String, long)"})
  void testFindPossibleActionsForInstance_thenReturnSizeIsTwo() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
            .status(SurveyInstanceStatus.COMPLETED)
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    List<SurveyInstanceAction> actualFindPossibleActionsForInstanceResult =
        surveyInstanceService.findPossibleActionsForInstance("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(2, actualFindPossibleActionsForInstanceResult.size());
    assertEquals(SurveyInstanceAction.APPROVING, actualFindPossibleActionsForInstanceResult.get(0));
    assertEquals(SurveyInstanceAction.REJECTING, actualFindPossibleActionsForInstanceResult.get(1));
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName("Test getPermissions(String, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.getPermissions("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName("Test getPermissions(String, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.getPermissions("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName("Test getPermissions(String, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions3() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
            .status(SurveyInstanceStatus.IN_PROGRESS)
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    SurveyInstancePermissions actualPermissions =
        surveyInstanceService.getPermissions("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertTrue(actualPermissions instanceof ImmutableSurveyInstancePermissions);
    assertFalse(actualPermissions.canEdit());
    assertFalse(actualPermissions.isMetaEdit());
    assertTrue(actualPermissions.hasOwnerRole());
    assertTrue(actualPermissions.hasOwnership());
    assertTrue(actualPermissions.isAdmin());
    assertTrue(actualPermissions.isOwner());
    assertTrue(actualPermissions.isParticipant());
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName("Test getPermissions(String, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions4() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
            .status(SurveyInstanceStatus.COMPLETED)
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    SurveyInstancePermissions actualPermissions =
        surveyInstanceService.getPermissions("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertTrue(actualPermissions instanceof ImmutableSurveyInstancePermissions);
    assertFalse(actualPermissions.canEdit());
    assertFalse(actualPermissions.isMetaEdit());
    assertTrue(actualPermissions.hasOwnerRole());
    assertTrue(actualPermissions.hasOwnership());
    assertTrue(actualPermissions.isAdmin());
    assertTrue(actualPermissions.isOwner());
    assertTrue(actualPermissions.isParticipant());
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceDao} {@link SurveyInstanceDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName(
      "Test getPermissions(String, Long); given SurveyInstanceDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_givenSurveyInstanceDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.getPermissions("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceOwnerDao} {@link
   *       SurveyInstanceOwnerDao#isPersonInstanceOwner(long, long)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName(
      "Test getPermissions(String, Long); given SurveyInstanceOwnerDao isPersonInstanceOwner(long, long) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_givenSurveyInstanceOwnerDaoIsPersonInstanceOwnerReturnFalse() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(false);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    SurveyInstancePermissions actualPermissions =
        surveyInstanceService.getPermissions("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertTrue(actualPermissions instanceof ImmutableSurveyInstancePermissions);
    assertFalse(actualPermissions.canEdit());
    assertFalse(actualPermissions.isMetaEdit());
    assertTrue(actualPermissions.hasOwnerRole());
    assertTrue(actualPermissions.hasOwnership());
    assertTrue(actualPermissions.isAdmin());
    assertTrue(actualPermissions.isOwner());
    assertTrue(actualPermissions.isParticipant());
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyRunDao} {@link SurveyRunDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName(
      "Test getPermissions(String, Long); given SurveyRunDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_givenSurveyRunDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyRunDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.getPermissions("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyRunDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName(
      "Test getPermissions(String, Long); given SurveyTemplateDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_givenSurveyTemplateDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.getPermissions("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasAnyRole(String, Set)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName(
      "Test getPermissions(String, Long); given UserRoleService hasAnyRole(String, Set) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_givenUserRoleServiceHasAnyRoleThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.getPermissions("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, String[])} return
   *       {@code true}.
   *   <li>Then return not canEdit.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName(
      "Test getPermissions(String, Long); given UserRoleService hasRole(String, String[]) return 'true'; then return not canEdit")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_givenUserRoleServiceHasRoleReturnTrue_thenReturnNotCanEdit() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    SurveyInstancePermissions actualPermissions =
        surveyInstanceService.getPermissions("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertTrue(actualPermissions instanceof ImmutableSurveyInstancePermissions);
    assertFalse(actualPermissions.canEdit());
    assertFalse(actualPermissions.isMetaEdit());
    assertTrue(actualPermissions.hasOwnerRole());
    assertTrue(actualPermissions.hasOwnership());
    assertTrue(actualPermissions.isAdmin());
    assertTrue(actualPermissions.isOwner());
    assertTrue(actualPermissions.isParticipant());
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Then return canEdit.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName("Test getPermissions(String, Long); then return canEdit")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_thenReturnCanEdit() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    SurveyInstancePermissions actualPermissions =
        surveyInstanceService.getPermissions("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertTrue(actualPermissions instanceof ImmutableSurveyInstancePermissions);
    assertTrue(actualPermissions.canEdit());
    assertTrue(actualPermissions.hasOwnerRole());
    assertTrue(actualPermissions.hasOwnership());
    assertTrue(actualPermissions.isAdmin());
    assertTrue(actualPermissions.isMetaEdit());
    assertTrue(actualPermissions.isOwner());
    assertTrue(actualPermissions.isParticipant());
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Then return not hasOwnerRole.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName("Test getPermissions(String, Long); then return not hasOwnerRole")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_thenReturnNotHasOwnerRole() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService, personService, settingsService);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService2,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            surveyTemplateDao);

    // Act
    SurveyInstancePermissions actualPermissions =
        surveyInstanceService.getPermissions("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleDao, atLeast(1)).getUserRoles("janedoe");
    assertTrue(actualPermissions instanceof ImmutableSurveyInstancePermissions);
    assertFalse(actualPermissions.canEdit());
    assertFalse(actualPermissions.hasOwnerRole());
    assertFalse(actualPermissions.isAdmin());
    assertFalse(actualPermissions.isMetaEdit());
    assertTrue(actualPermissions.hasOwnership());
    assertTrue(actualPermissions.isOwner());
    assertTrue(actualPermissions.isParticipant());
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Then return not hasOwnerRole.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName("Test getPermissions(String, Long); then return not hasOwnerRole")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_thenReturnNotHasOwnerRole2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult =
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

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService, personService, settingsService);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    SurveyInstanceService surveyInstanceService =
        new SurveyInstanceService(
            changeLogService2,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyQuestionResponseDao,
            surveyRunDao,
            userRoleService,
            instanceViewService,
            surveyQuestionService,
            surveyTemplateDao);

    // Act
    SurveyInstancePermissions actualPermissions =
        surveyInstanceService.getPermissions("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleDao, atLeast(1)).getUserRoles("janedoe");
    assertTrue(actualPermissions instanceof ImmutableSurveyInstancePermissions);
    assertFalse(actualPermissions.hasOwnerRole());
    assertFalse(actualPermissions.isAdmin());
    assertTrue(actualPermissions.canEdit());
    assertTrue(actualPermissions.hasOwnership());
    assertTrue(actualPermissions.isMetaEdit());
    assertTrue(actualPermissions.isOwner());
    assertTrue(actualPermissions.isParticipant());
  }

  /**
   * Test {@link SurveyInstanceService#getPermissions(String, Long)}.
   *
   * <ul>
   *   <li>Then return not Participant.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#getPermissions(String, Long)}
   */
  @Test
  @DisplayName("Test getPermissions(String, Long); then return not Participant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstancePermissions SurveyInstanceService.getPermissions(String, Long)"
  })
  void testGetPermissions_thenReturnNotParticipant() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(false);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    SurveyInstancePermissions actualPermissions =
        surveyInstanceService.getPermissions("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertTrue(actualPermissions instanceof ImmutableSurveyInstancePermissions);
    assertFalse(actualPermissions.canEdit());
    assertFalse(actualPermissions.isMetaEdit());
    assertFalse(actualPermissions.isParticipant());
    assertTrue(actualPermissions.hasOwnerRole());
    assertTrue(actualPermissions.hasOwnership());
    assertTrue(actualPermissions.isAdmin());
    assertTrue(actualPermissions.isOwner());
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName("Test reportProblemWithQuestionResponse(Long, Long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse() {
    // Arrange
    when(surveyQuestionService.findForSurveyInstance(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.reportProblemWithQuestionResponse(
                1L, 1L, "Not all who wander are lost", "janedoe"));
    verify(surveyQuestionService).findForSurveyInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName("Test reportProblemWithQuestionResponse(Long, Long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse2() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.reportProblemWithQuestionResponse(
                1L, 1L, "Not all who wander are lost", "janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(surveyQuestionService).findForSurveyInstance(1L);
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName("Test reportProblemWithQuestionResponse(Long, Long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse3() {
    // Arrange
    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(instanceDao.getById(anyLong()))
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

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList);

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);
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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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

    // Act
    boolean actualReportProblemWithQuestionResponseResult =
        surveyInstanceService.reportProblemWithQuestionResponse(
            1L, 1L, "Not all who wander are lost", "janedoe");

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertFalse(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName("Test reportProblemWithQuestionResponse(Long, Long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse4() {
    // Arrange
    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(instanceDao.getById(anyLong()))
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

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    ImmutableSurveyQuestionResponse.Builder builderResult2 =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult2 =
        dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    ImmutableSurveyQuestionResponse.Builder entityResponseResult2 =
        entityListResponseResult2.entityResponse(entityResponse2);
    surveyInstanceQuestionResponseList.add(
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList);

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);
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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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

    // Act
    boolean actualReportProblemWithQuestionResponseResult =
        surveyInstanceService.reportProblemWithQuestionResponse(
            1L, 1L, "Not all who wander are lost", "janedoe");

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertFalse(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName(
      "Test reportProblemWithQuestionResponse(Long, Long, String, String); given ChangeLogService write(ChangeLog) return '19088743'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse_givenChangeLogServiceWriteReturn19088743() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionList);

    // Act
    boolean actualReportProblemWithQuestionResponseResult =
        surveyInstanceService.reportProblemWithQuestionResponse(
            1L, 1L, "Not all who wander are lost", "janedoe");

    // Assert
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(surveyQuestionService).findForSurveyInstance(1L);
    assertTrue(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName(
      "Test reportProblemWithQuestionResponse(Long, Long, String, String); given ChangeLogService; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse_givenChangeLogService_thenReturnFalse() {
    // Arrange
    when(surveyQuestionService.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    // Act
    boolean actualReportProblemWithQuestionResponseResult =
        surveyInstanceService.reportProblemWithQuestionResponse(
            1L, 1L, "Not all who wander are lost", "janedoe");

    // Assert
    verify(surveyQuestionService).findForSurveyInstance(1L);
    assertFalse(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceEvaluator#eval(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName(
      "Test reportProblemWithQuestionResponse(Long, Long, String, String); then calls eval(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse_thenCallsEval() {
    // Arrange
    SurveyInstanceEvaluator evaluator = mock(SurveyInstanceEvaluator.class);
    when(evaluator.eval(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);
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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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

    // Act
    boolean actualReportProblemWithQuestionResponseResult =
        surveyInstanceService.reportProblemWithQuestionResponse(
            1L, 1L, "Not all who wander are lost", "janedoe");

    // Assert
    verify(evaluator).eval(1L);
    assertFalse(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName(
      "Test reportProblemWithQuestionResponse(Long, Long, String, String); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse_thenCallsGetById() {
    // Arrange
    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    when(instanceDao.getById(anyLong()))
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

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);
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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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

    // Act
    boolean actualReportProblemWithQuestionResponseResult =
        surveyInstanceService.reportProblemWithQuestionResponse(
            1L, 1L, "Not all who wander are lost", "janedoe");

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertFalse(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Test {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long, Long, String,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#reportProblemWithQuestionResponse(Long,
   * Long, String, String)}
   */
  @Test
  @DisplayName(
      "Test reportProblemWithQuestionResponse(Long, Long, String, String); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceService.reportProblemWithQuestionResponse(Long, Long, String, String)"
  })
  void testReportProblemWithQuestionResponse_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

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
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));

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

    // Act
    boolean actualReportProblemWithQuestionResponseResult =
        surveyInstanceService.reportProblemWithQuestionResponse(
            1L, 1L, "Not all who wander are lost", "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyQuestionService).findForSurveyInstance(1L);
    assertTrue(actualReportProblemWithQuestionResponseResult);
  }

  /**
   * Test {@link SurveyInstanceService#copyResponses(long, CopySurveyResponsesCommand, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#copyResponses(long,
   * CopySurveyResponsesCommand, String)}
   */
  @Test
  @DisplayName("Test copyResponses(long, CopySurveyResponsesCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyInstanceService.copyResponses(long, CopySurveyResponsesCommand, String)"
  })
  void testCopyResponses() {
    // Arrange
    when(personDao.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyQuestionResponseDao.copyResponses(
            Mockito.<Long>any(), Mockito.<CopySurveyResponsesCommand>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.copyResponses(
                1L, ImmutableCopySurveyResponsesCommand.builder().build(), "janedoe"));
    verify(personDao).getByUserEmail("janedoe");
    verify(surveyQuestionResponseDao)
        .copyResponses(eq(1L), isA(CopySurveyResponsesCommand.class), eq(1L));
  }

  /**
   * Test {@link SurveyInstanceService#copyResponses(long, CopySurveyResponsesCommand, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#copyResponses(long,
   * CopySurveyResponsesCommand, String)}
   */
  @Test
  @DisplayName("Test copyResponses(long, CopySurveyResponsesCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyInstanceService.copyResponses(long, CopySurveyResponsesCommand, String)"
  })
  void testCopyResponses2() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableCopySurveyResponsesCommand.Builder builderResult =
        ImmutableCopySurveyResponsesCommand.builder();
    builderResult.addTargetSurveyInstanceIds(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.copyResponses(1L, builderResult.build(), "janedoe"));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#copyResponses(long, CopySurveyResponsesCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#getByUserEmail(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#copyResponses(long,
   * CopySurveyResponsesCommand, String)}
   */
  @Test
  @DisplayName(
      "Test copyResponses(long, CopySurveyResponsesCommand, String); given PersonDao getByUserEmail(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyInstanceService.copyResponses(long, CopySurveyResponsesCommand, String)"
  })
  void testCopyResponses_givenPersonDaoGetByUserEmailThrowIllegalArgumentException() {
    // Arrange
    when(personDao.getByUserEmail(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyInstanceService.copyResponses(
                1L, ImmutableCopySurveyResponsesCommand.builder().build(), "janedoe"));
    verify(personDao).getByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyInstanceService#copyResponses(long, CopySurveyResponsesCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceRecipientDao#isPersonInstanceRecipient(long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#copyResponses(long,
   * CopySurveyResponsesCommand, String)}
   */
  @Test
  @DisplayName(
      "Test copyResponses(long, CopySurveyResponsesCommand, String); then calls isPersonInstanceRecipient(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyInstanceService.copyResponses(long, CopySurveyResponsesCommand, String)"
  })
  void testCopyResponses_thenCallsIsPersonInstanceRecipient() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    ImmutableCopySurveyResponsesCommand.Builder builderResult =
        ImmutableCopySurveyResponsesCommand.builder();
    builderResult.addTargetSurveyInstanceIds(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.copyResponses(1L, builderResult.build(), "janedoe"));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
  }

  /**
   * Test {@link SurveyInstanceService#copyResponses(long, CopySurveyResponsesCommand, String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#copyResponses(long,
   * CopySurveyResponsesCommand, String)}
   */
  @Test
  @DisplayName("Test copyResponses(long, CopySurveyResponsesCommand, String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyInstanceService.copyResponses(long, CopySurveyResponsesCommand, String)"
  })
  void testCopyResponses_thenReturnOne() {
    // Arrange
    when(personDao.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyQuestionResponseDao.copyResponses(
            Mockito.<Long>any(), Mockito.<CopySurveyResponsesCommand>any(), Mockito.<Long>any()))
        .thenReturn(1);

    // Act
    int actualCopyResponsesResult =
        surveyInstanceService.copyResponses(
            1L, ImmutableCopySurveyResponsesCommand.builder().build(), "janedoe");

    // Assert
    verify(personDao).getByUserEmail("janedoe");
    verify(surveyQuestionResponseDao)
        .copyResponses(eq(1L), isA(CopySurveyResponsesCommand.class), eq(1L));
    assertEquals(1, actualCopyResponsesResult);
  }

  /**
   * Test {@link SurveyInstanceService#findGroupApprovers(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findGroupApprovers(long)}
   */
  @Test
  @DisplayName("Test findGroupApprovers(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findGroupApprovers(long)"})
  void testFindGroupApprovers() {
    // Arrange
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.findGroupApprovers(1L));
    verify(surveyInstanceDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findGroupApprovers(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findGroupApprovers(long)}
   */
  @Test
  @DisplayName("Test findGroupApprovers(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findGroupApprovers(long)"})
  void testFindGroupApprovers2() {
    // Arrange
    when(personDao.findActivePeopleByUserRole(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyInstanceService.findGroupApprovers(1L));
    verify(personDao).findActivePeopleByUserRole("Owning Role");
    verify(surveyInstanceDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#findGroupApprovers(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findGroupApprovers(long)}
   */
  @Test
  @DisplayName("Test findGroupApprovers(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findGroupApprovers(long)"})
  void testFindGroupApprovers3() {
    // Arrange
    Builder owningRoleResult =
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
            .owningRole("");

    Builder submittedByResult =
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

    // Act
    Set<Person> actualFindGroupApproversResult = surveyInstanceService.findGroupApprovers(1L);

    // Assert
    verify(surveyInstanceDao).getById(1L);
    assertTrue(actualFindGroupApproversResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findGroupApprovers(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#findGroupApprovers(long)}
   */
  @Test
  @DisplayName("Test findGroupApprovers(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findGroupApprovers(long)"})
  void testFindGroupApprovers4() {
    // Arrange
    Builder owningRoleResult =
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
            .owningRole(null);

    Builder submittedByResult =
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

    // Act
    Set<Person> actualFindGroupApproversResult = surveyInstanceService.findGroupApprovers(1L);

    // Assert
    verify(surveyInstanceDao).getById(1L);
    assertTrue(actualFindGroupApproversResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#findGroupApprovers(long)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#findActivePeopleByUserRole(String)} return
   *       {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#findGroupApprovers(long)}
   */
  @Test
  @DisplayName(
      "Test findGroupApprovers(long); given PersonDao findActivePeopleByUserRole(String) return HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceService.findGroupApprovers(long)"})
  void testFindGroupApprovers_givenPersonDaoFindActivePeopleByUserRoleReturnHashSet() {
    // Arrange
    when(personDao.findActivePeopleByUserRole(Mockito.<String>any())).thenReturn(new HashSet<>());

    Builder owningRoleResult =
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

    Builder submittedByResult =
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

    // Act
    Set<Person> actualFindGroupApproversResult = surveyInstanceService.findGroupApprovers(1L);

    // Assert
    verify(personDao).findActivePeopleByUserRole("Owning Role");
    verify(surveyInstanceDao).getById(1L);
    assertTrue(actualFindGroupApproversResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun() {
    // Arrange
    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun2() {
    // Arrange
    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun3() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun4() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyRunDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun5() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun6() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun7() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName(
      "Test withdrawOpenSurveysForRun(long, String); given PersonDao; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun_givenPersonDao_thenReturnIntValueIsZero() {
    // Arrange
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(new HashSet<>());

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    assertEquals(0, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName(
      "Test withdrawOpenSurveysForRun(long, String); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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
    when(surveyInstanceDao.updateStatus(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<SurveyInstanceStatus>any()))
        .thenReturn(1);

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao)
        .updateStatus(isA(Optional.class), eq(1L), eq(SurveyInstanceStatus.WITHDRAWN));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(changeLogService).write(isA(Optional.class), isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(1, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName(
      "Test withdrawOpenSurveysForRun(long, String); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun_thenCallsWrite2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateStatus(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<SurveyInstanceStatus>any()))
        .thenReturn(1);

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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
            surveyTemplateDao);

    // Act
    Integer actualWithdrawOpenSurveysForRunResult =
        surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao)
        .updateStatus(isA(Optional.class), eq(1L), eq(SurveyInstanceStatus.WITHDRAWN));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    verify(userRoleDao, atLeast(1)).getUserRoles("janedoe");
    assertEquals(1, actualWithdrawOpenSurveysForRunResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForRun(long, String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForRun(long, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForRun(long, String)"})
  void testWithdrawOpenSurveysForRun_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceDao.findForSurveyRun(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.withdrawOpenSurveysForRun(1L, "janedoe"));
    verify(surveyInstanceDao).findForSurveyRun(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForTemplate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate() {
    // Arrange
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe"));
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForTemplate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate2() {
    // Arrange
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe"));
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForTemplate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate3() {
    // Arrange
    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForTemplate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate4() {
    // Arrange
    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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
    when(surveyInstanceDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForTemplate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate5() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForTemplate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate6() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyRunDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForTemplate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate7() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    assertEquals(0, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName("Test withdrawOpenSurveysForTemplate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate8() {
    // Arrange
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    assertEquals(0, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test withdrawOpenSurveysForTemplate(long, String); given PersonDao; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate_givenPersonDao_thenReturnIntValueIsZero() {
    // Arrange
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(new HashSet<>());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyTemplateDao).getById(1L);
    assertEquals(0, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test withdrawOpenSurveysForTemplate(long, String); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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
    when(surveyInstanceDao.updateStatus(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<SurveyInstanceStatus>any()))
        .thenReturn(1);

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao)
        .updateStatus(isA(Optional.class), eq(1L), eq(SurveyInstanceStatus.WITHDRAWN));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    verify(changeLogService).write(isA(Optional.class), isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), isA(Set.class));
    verify(userRoleService).hasRole(eq("janedoe"), (String[]) Mockito.any());
    assertEquals(1, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }

  /**
   * Test {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceService#withdrawOpenSurveysForTemplate(long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test withdrawOpenSurveysForTemplate(long, String); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SurveyInstanceService.withdrawOpenSurveysForTemplate(long, String)"})
  void testWithdrawOpenSurveysForTemplate_thenCallsWrite2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    HashSet<SurveyInstance> surveyInstanceSet = new HashSet<>();

    Builder owningRoleResult =
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

    Builder submittedByResult =
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
    surveyInstanceSet.add(
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateStatus(
            Mockito.<Optional<DSLContext>>any(), anyLong(), Mockito.<SurveyInstanceStatus>any()))
        .thenReturn(1);

    Builder owningRoleResult2 =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(null)
            .owningRole("Owning Role");

    Builder submittedByResult2 =
        owningRoleResult2
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
            submittedByResult2
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
    when(surveyInstanceDao.findForSurveyTemplate(anyLong(), (SurveyInstanceStatus[]) Mockito.any()))
        .thenReturn(surveyInstanceSet);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.isPersonInstanceRecipient(anyLong(), anyLong()))
        .thenReturn(true);

    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    when(surveyInstanceOwnerDao.isPersonInstanceOwner(anyLong(), anyLong())).thenReturn(true);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.OBSOLETE)
                .targetEntityKind(EntityKind.ALL)
                .build());
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService instanceViewService =
        new SurveyInstanceViewService(personDao3, instanceEvaluator, mock(SurveyViewDao.class));
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
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
            surveyTemplateDao);

    // Act
    Integer actualWithdrawOpenSurveysForTemplateResult =
        surveyInstanceService.withdrawOpenSurveysForTemplate(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).findForSurveyTemplate(eq(1L), (SurveyInstanceStatus[]) Mockito.any());
    verify(surveyInstanceDao, atLeast(1)).getById(1L);
    verify(surveyInstanceDao)
        .updateStatus(isA(Optional.class), eq(1L), eq(SurveyInstanceStatus.WITHDRAWN));
    verify(surveyInstanceOwnerDao).isPersonInstanceOwner(1L, 1L);
    verify(surveyInstanceRecipientDao).isPersonInstanceRecipient(1L, 1L);
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    verify(userRoleDao, atLeast(1)).getUserRoles("janedoe");
    assertEquals(1, actualWithdrawOpenSurveysForTemplateResult.intValue());
  }
}
