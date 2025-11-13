package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_group.InvolvementGroupDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.survey.SurveyInstanceDao;
import org.finos.waltz.data.survey.SurveyInstanceOwnerDao;
import org.finos.waltz.data.survey.SurveyInstanceRecipientDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.data.survey.SurveyRunDao;
import org.finos.waltz.data.survey.SurveyTemplateDao;
import org.finos.waltz.model.DateChangeCommand;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdCommandResponse;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableDateChangeCommand;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdCommandResponse;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.involvement_group.InvolvementGroupCreateCommand;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.survey.ImmutableInstancesAndRecipientsCreateCommand;
import org.finos.waltz.model.survey.ImmutableSurveyInstance;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwningRoleSaveCommand;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipient;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientsAndOwners;
import org.finos.waltz.model.survey.ImmutableSurveyRun;
import org.finos.waltz.model.survey.ImmutableSurveyRunChangeCommand;
import org.finos.waltz.model.survey.ImmutableSurveyRunCompletionRate;
import org.finos.waltz.model.survey.ImmutableSurveyRunCreateCommand;
import org.finos.waltz.model.survey.ImmutableSurveyRunWithOwnerAndStats;
import org.finos.waltz.model.survey.ImmutableSurveyTemplate;
import org.finos.waltz.model.survey.InstancesAndRecipientsCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceOwner;
import org.finos.waltz.model.survey.SurveyInstanceOwnerCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceOwningRoleSaveCommand;
import org.finos.waltz.model.survey.SurveyInstanceRecipient;
import org.finos.waltz.model.survey.SurveyInstanceRecipientCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceRecipientsAndOwners;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.model.survey.SurveyIssuanceKind;
import org.finos.waltz.model.survey.SurveyRun;
import org.finos.waltz.model.survey.SurveyRunChangeCommand;
import org.finos.waltz.model.survey.SurveyRunCompletionRate;
import org.finos.waltz.model.survey.SurveyRunCreateCommand;
import org.finos.waltz.model.survey.SurveyRunStatus;
import org.finos.waltz.model.survey.SurveyRunWithOwnerAndStats;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_group.InvolvementGroupService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyRunServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private InvolvementDao involvementDao;

  @Mock private InvolvementGroupService involvementGroupService;

  @Mock private PersonDao personDao;

  @Mock private SurveyInstanceDao surveyInstanceDao;

  @Mock private SurveyInstanceOwnerDao surveyInstanceOwnerDao;

  @Mock private SurveyInstanceRecipientDao surveyInstanceRecipientDao;

  @Mock private SurveyQuestionResponseDao surveyQuestionResponseDao;

  @Mock private SurveyRunDao surveyRunDao;

  @InjectMocks private SurveyRunService surveyRunService;

  @Mock private SurveyTemplateDao surveyTemplateDao;

  /**
   * Test {@link SurveyRunService#getById(long)}.
   *
   * <p>Method under test: {@link SurveyRunService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyRun SurveyRunService.getById(long)"})
  void testGetById() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    SurveyRun actualById = surveyRunService.getById(1L);

    // Assert
    verify(surveyRunDao).getById(1L);
    assertTrue(actualById.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertTrue(actualById instanceof ImmutableSurveyRun);
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals("jane.doe@example.org", actualById.contactEmail());
    assertEquals(1L, actualById.ownerId().longValue());
    assertEquals(1L, actualById.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualById.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualById.status());
    assertFalse(actualById.isDefault());
    Set<Long> involvementKindIdsResult = actualById.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualById.ownerInvKindIds());
    assertSame(approvalDueDate, actualById.approvalDueDate());
    assertSame(dueDate, actualById.dueDate());
  }

  /**
   * Test {@link SurveyRunService#findForRecipient(Long)} with {@code personId}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#findForRecipient(Long)}
   */
  @Test
  @DisplayName("Test findForRecipient(Long) with 'personId'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findForRecipient(Long)"})
  void testFindForRecipientWithPersonId_thenReturnEmpty() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findForRecipient(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyRun> actualFindForRecipientResult = surveyRunService.findForRecipient(1L);

    // Assert
    verify(surveyRunDao).findForRecipient(1L);
    assertTrue(actualFindForRecipientResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunService#findForRecipient(String)} with {@code userName}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#findForRecipient(String)}
   */
  @Test
  @DisplayName("Test findForRecipient(String) with 'userName'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findForRecipient(String)"})
  void testFindForRecipientWithUserName_thenReturnEmpty() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findForRecipient(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyRun> actualFindForRecipientResult = surveyRunService.findForRecipient("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).findForRecipient(1L);
    assertTrue(actualFindForRecipientResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}.
   *
   * <p>Method under test: {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyRun(String, SurveyRunCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdCommandResponse SurveyRunService.createSurveyRun(String, SurveyRunCreateCommand)"
  })
  void testCreateSurveyRun() throws InsufficientPrivelegeException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(surveyRunDao.create(
            anyLong(),
            Mockito.<SurveyRunCreateCommand>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Optional<Long>>any()))
        .thenReturn(1L);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            surveyTemplateDao,
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    ImmutableSurveyRunCreateCommand.Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSurveyRunCreateCommand command =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    IdCommandResponse actualCreateSurveyRunResult =
        surveyRunService.createSurveyRun("janedoe", command);

    // Assert
    verify(involvementGroupDao, atLeast(1))
        .createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao)
        .create(
            eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(1L, "janedoe");
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
    assertTrue(command.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", command.name());
    assertEquals("The characteristics of someone or something", command.description());
    assertEquals("jane.doe@example.org", command.contactEmail());
    assertEquals(1L, command.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, command.issuanceKind());
    Set<Long> involvementKindIdsResult = command.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, command.ownerInvKindIds());
    assertSame(approvalDueDate, command.approvalDueDate());
    assertSame(dueDate, command.dueDate());
  }

  /**
   * Test {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test createSurveyRun(String, SurveyRunCreateCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdCommandResponse SurveyRunService.createSurveyRun(String, SurveyRunCreateCommand)"
  })
  void testCreateSurveyRun_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(surveyRunDao.create(
            anyLong(),
            Mockito.<SurveyRunCreateCommand>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Optional<Long>>any()))
        .thenReturn(1L);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            surveyTemplateDao,
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    ImmutableSurveyRunCreateCommand.Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSurveyRunCreateCommand command =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    IdCommandResponse actualCreateSurveyRunResult =
        surveyRunService.createSurveyRun("janedoe", command);

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(involvementGroupDao, atLeast(1))
        .createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao)
        .create(
            eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(1L, "janedoe");
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
    assertTrue(command.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", command.name());
    assertEquals("The characteristics of someone or something", command.description());
    assertEquals("jane.doe@example.org", command.contactEmail());
    assertEquals(1L, command.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, command.issuanceKind());
    Set<Long> involvementKindIdsResult = command.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, command.ownerInvKindIds());
    assertSame(approvalDueDate, command.approvalDueDate());
    assertSame(dueDate, command.dueDate());
  }

  /**
   * Test {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementGroupService#createGroup(InvolvementGroupCreateCommand,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test createSurveyRun(String, SurveyRunCreateCommand); then calls createGroup(InvolvementGroupCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdCommandResponse SurveyRunService.createSurveyRun(String, SurveyRunCreateCommand)"
  })
  void testCreateSurveyRun_thenCallsCreateGroup() throws InsufficientPrivelegeException {
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
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(surveyRunDao.create(
            anyLong(),
            Mockito.<SurveyRunCreateCommand>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Optional<Long>>any()))
        .thenReturn(1L);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    ImmutableSurveyRunCreateCommand.Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSurveyRunCreateCommand command =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    IdCommandResponse actualCreateSurveyRunResult =
        surveyRunService.createSurveyRun("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao)
        .create(
            eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(1L, "janedoe");
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(involvementGroupService, atLeast(1))
        .createGroup(Mockito.<InvolvementGroupCreateCommand>any(), eq("janedoe"));
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
    assertTrue(command.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", command.name());
    assertEquals("The characteristics of someone or something", command.description());
    assertEquals("jane.doe@example.org", command.contactEmail());
    assertEquals(1L, command.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, command.issuanceKind());
    Set<Long> involvementKindIdsResult = command.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, command.ownerInvKindIds());
    assertSame(approvalDueDate, command.approvalDueDate());
    assertSame(dueDate, command.dueDate());
  }

  /**
   * Test {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}.
   *
   * <ul>
   *   <li>Then return id longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test createSurveyRun(String, SurveyRunCreateCommand); then return id longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdCommandResponse SurveyRunService.createSurveyRun(String, SurveyRunCreateCommand)"
  })
  void testCreateSurveyRun_thenReturnIdLongValueIsOne() throws InsufficientPrivelegeException {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(surveyRunDao.create(
            anyLong(),
            Mockito.<SurveyRunCreateCommand>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Optional<Long>>any()))
        .thenReturn(1L);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            surveyTemplateDao,
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    ImmutableSurveyRunCreateCommand.Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSurveyRunCreateCommand command =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    IdCommandResponse actualCreateSurveyRunResult =
        surveyRunService.createSurveyRun("janedoe", command);
    Optional<Long> actualIdResult = actualCreateSurveyRunResult.id();

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(involvementGroupDao, atLeast(1))
        .createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao)
        .create(
            eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(1L, "janedoe");
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
    assertTrue(command.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", command.name());
    assertEquals("The characteristics of someone or something", command.description());
    assertEquals("jane.doe@example.org", command.contactEmail());
    assertEquals(1L, actualIdResult.get().longValue());
    assertEquals(1L, command.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, command.issuanceKind());
    assertTrue(actualIdResult.isPresent());
    Set<Long> involvementKindIdsResult = command.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, command.ownerInvKindIds());
    assertSame(approvalDueDate, command.approvalDueDate());
    assertSame(dueDate, command.dueDate());
  }

  /**
   * Test {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link HashSet#HashSet()} add three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}
   */
  @Test
  @DisplayName(
      "Test createOwnersGroup(long, String, Set, String); given three; when HashSet() add three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyRunService.createOwnersGroup(long, String, Set, String)"})
  void testCreateOwnersGroup_givenThree_whenHashSetAddThree() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            mock(PersonDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(3L);

    // Act
    surveyRunService.createOwnersGroup(1L, "Doe", involvementKindIds, "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
  }

  /**
   * Test {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}
   */
  @Test
  @DisplayName(
      "Test createOwnersGroup(long, String, Set, String); given two; when HashSet() add two; then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyRunService.createOwnersGroup(long, String, Set, String)"})
  void testCreateOwnersGroup_givenTwo_whenHashSetAddTwo_thenCallsCreateInvolvementGroup() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            mock(PersonDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(2L);
    involvementKindIds.add(3L);

    // Act
    surveyRunService.createOwnersGroup(1L, "Doe", involvementKindIds, "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
  }

  /**
   * Test {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementGroupService#createGroup(InvolvementGroupCreateCommand,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}
   */
  @Test
  @DisplayName(
      "Test createOwnersGroup(long, String, Set, String); then calls createGroup(InvolvementGroupCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyRunService.createOwnersGroup(long, String, Set, String)"})
  void testCreateOwnersGroup_thenCallsCreateGroup() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);

    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            mock(PersonDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    // Act
    surveyRunService.createOwnersGroup(1L, "Doe", new HashSet<>(), "janedoe");

    // Assert
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}
   */
  @Test
  @DisplayName(
      "Test createOwnersGroup(long, String, Set, String); when HashSet(); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyRunService.createOwnersGroup(long, String, Set, String)"})
  void testCreateOwnersGroup_whenHashSet_thenCallsCreateInvolvementGroup() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            mock(PersonDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    // Act
    surveyRunService.createOwnersGroup(1L, "Doe", new HashSet<>(), "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
  }

  /**
   * Test {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link HashSet#HashSet()} add three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  @DisplayName(
      "Test createRecipientsGroup(long, String, Set, String); given three; when HashSet() add three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup_givenThree_whenHashSetAddThree() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            mock(PersonDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(3L);

    // Act
    surveyRunService.createRecipientsGroup(1L, "Doe", involvementKindIds, "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
  }

  /**
   * Test {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  @DisplayName(
      "Test createRecipientsGroup(long, String, Set, String); given two; when HashSet() add two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup_givenTwo_whenHashSetAddTwo() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            mock(PersonDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(2L);
    involvementKindIds.add(3L);

    // Act
    surveyRunService.createRecipientsGroup(1L, "Doe", involvementKindIds, "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
  }

  /**
   * Test {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementGroupService#createGroup(InvolvementGroupCreateCommand,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  @DisplayName(
      "Test createRecipientsGroup(long, String, Set, String); then calls createGroup(InvolvementGroupCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup_thenCallsCreateGroup() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);

    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            mock(PersonDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    // Act
    surveyRunService.createRecipientsGroup(1L, "Doe", new HashSet<>(), "janedoe");

    // Assert
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  @DisplayName(
      "Test createRecipientsGroup(long, String, Set, String); when HashSet(); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup_whenHashSet_thenCallsCreateInvolvementGroup() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            mock(PersonDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    // Act
    surveyRunService.createRecipientsGroup(1L, "Doe", new HashSet<>(), "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
  }

  /**
   * Test {@link SurveyRunService#deleteSurveyRun(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#deleteSurveyRun(String, long)}
   */
  @Test
  @DisplayName(
      "Test deleteSurveyRun(String, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyRunService.deleteSurveyRun(String, long)"})
  void testDeleteSurveyRun_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.delete(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    boolean actualDeleteSurveyRunResult = surveyRunService.deleteSurveyRun("janedoe", 1L);

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyQuestionResponseDao).deleteForSurveyRun(1L);
    verify(surveyRunDao).delete(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    assertTrue(actualDeleteSurveyRunResult);
  }

  /**
   * Test {@link SurveyRunService#deleteSurveyRun(String, long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyRunDao} {@link SurveyRunDao#delete(long)} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#deleteSurveyRun(String, long)}
   */
  @Test
  @DisplayName(
      "Test deleteSurveyRun(String, long); given SurveyRunDao delete(long) return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyRunService.deleteSurveyRun(String, long)"})
  void testDeleteSurveyRun_givenSurveyRunDaoDeleteReturnZero_thenReturnFalse() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.delete(anyLong())).thenReturn(0);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    boolean actualDeleteSurveyRunResult = surveyRunService.deleteSurveyRun("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyQuestionResponseDao).deleteForSurveyRun(1L);
    verify(surveyRunDao).delete(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertFalse(actualDeleteSurveyRunResult);
  }

  /**
   * Test {@link SurveyRunService#deleteSurveyRun(String, long)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#deleteSurveyRun(String, long)}
   */
  @Test
  @DisplayName("Test deleteSurveyRun(String, long); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyRunService.deleteSurveyRun(String, long)"})
  void testDeleteSurveyRun_thenReturnTrue() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.delete(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    boolean actualDeleteSurveyRunResult = surveyRunService.deleteSurveyRun("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyQuestionResponseDao).deleteForSurveyRun(1L);
    verify(surveyRunDao).delete(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualDeleteSurveyRunResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link SurveyRunChangeCommand#involvementKindIds()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRun(String, long,
   * SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRun(String, long, SurveyRunChangeCommand); given HashSet(); then calls involvementKindIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunService.updateSurveyRun(String, long, SurveyRunChangeCommand)"})
  void testUpdateSurveyRun_givenHashSet_thenCallsInvolvementKindIds() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing()
        .when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(personDao, atLeast(1)).getActiveByUserEmail("janedoe");
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService, atLeast(1))
        .updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementGroupService#createGroup(InvolvementGroupCreateCommand,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRun(String, long,
   * SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRun(String, long, SurveyRunChangeCommand); then calls createGroup(InvolvementGroupCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunService.updateSurveyRun(String, long, SurveyRunChangeCommand)"})
  void testUpdateSurveyRun_thenCallsCreateGroup() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    ImmutableSurveyRunChangeCommand.Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    int actualUpdateSurveyRunResult =
        surveyRunService.updateSurveyRun(
            "janedoe",
            1L,
            nameResult
                .selectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(personDao, atLeast(1)).getActiveByUserEmail("janedoe");
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService, atLeast(1))
        .createGroup(Mockito.<InvolvementGroupCreateCommand>any(), eq("janedoe"));
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRun(String, long,
   * SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRun(String, long, SurveyRunChangeCommand); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunService.updateSurveyRun(String, long, SurveyRunChangeCommand)"})
  void testUpdateSurveyRun_thenCallsCreateInvolvementGroup() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    doNothing()
        .when(involvementGroupDao)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    ImmutableSurveyRunChangeCommand.Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    int actualUpdateSurveyRunResult =
        surveyRunService.updateSurveyRun(
            "janedoe",
            1L,
            nameResult
                .selectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
    verify(personDao, atLeast(1)).getActiveByUserEmail("janedoe");
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRun(String, long,
   * SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRun(String, long, SurveyRunChangeCommand); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunService.updateSurveyRun(String, long, SurveyRunChangeCommand)"})
  void testUpdateSurveyRun_thenCallsCreateInvolvementGroup2() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    ImmutableSurveyRunChangeCommand.Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    int actualUpdateSurveyRunResult =
        surveyRunService.updateSurveyRun(
            "janedoe",
            1L,
            nameResult
                .selectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(involvementGroupDao, atLeast(1))
        .createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao, atLeast(1)).getActiveByUserEmail("janedoe");
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRun(String, long,
   * SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRun(String, long, SurveyRunChangeCommand); then calls updateInvolvements(Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunService.updateSurveyRun(String, long, SurveyRunChangeCommand)"})
  void testUpdateSurveyRun_thenCallsUpdateInvolvements() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing()
        .when(involvementGroupDao)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    ImmutableSurveyRunChangeCommand.Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    int actualUpdateSurveyRunResult =
        surveyRunService.updateSurveyRun(
            "janedoe",
            1L,
            nameResult
                .selectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(involvementGroupDao, atLeast(1)).updateInvolvements(eq(1L), isA(Set.class));
    verify(personDao, atLeast(1)).getActiveByUserEmail("janedoe");
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link SurveyRunChangeCommand#involvementKindIds()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunInvolvements(long,
   * SurveyRunChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String); given HashSet(); then calls involvementKindIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyRunService.updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)"
  })
  void testUpdateSurveyRunInvolvements_givenHashSet_thenCallsInvolvementKindIds() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing()
        .when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService, atLeast(1))
        .updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementGroupService#createGroup(InvolvementGroupCreateCommand,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunInvolvements(long,
   * SurveyRunChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String); then calls createGroup(InvolvementGroupCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyRunService.updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)"
  })
  void testUpdateSurveyRunInvolvements_thenCallsCreateGroup() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    ImmutableSurveyRunChangeCommand.Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    surveyRunService.updateSurveyRunInvolvements(
        1L,
        nameResult
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build(),
        "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService, atLeast(1))
        .createGroup(Mockito.<InvolvementGroupCreateCommand>any(), eq("janedoe"));
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunInvolvements(long,
   * SurveyRunChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyRunService.updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)"
  })
  void testUpdateSurveyRunInvolvements_thenCallsCreateInvolvementGroup() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    doNothing()
        .when(involvementGroupDao)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    ImmutableSurveyRunChangeCommand.Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    surveyRunService.updateSurveyRunInvolvements(
        1L,
        nameResult
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build(),
        "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunInvolvements(long,
   * SurveyRunChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyRunService.updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)"
  })
  void testUpdateSurveyRunInvolvements_thenCallsCreateInvolvementGroup2() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    ImmutableSurveyRunChangeCommand.Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    surveyRunService.updateSurveyRunInvolvements(
        1L,
        nameResult
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build(),
        "janedoe");

    // Assert
    verify(involvementGroupDao, atLeast(1))
        .createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
    verify(surveyRunDao).updateOwnerInvolvementGroupId(1L, 1L);
    verify(surveyRunDao).updateRecipientInvolvementGroupId(1L, 1L);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunInvolvements(long,
   * SurveyRunChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String); then calls updateInvolvements(Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyRunService.updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)"
  })
  void testUpdateSurveyRunInvolvements_thenCallsUpdateInvolvements() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing()
        .when(involvementGroupDao)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);
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

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            mock(InvolvementDao.class),
            personDao,
            mock(SurveyInstanceDao.class),
            mock(SurveyInstanceRecipientDao.class),
            mock(SurveyInstanceOwnerDao.class),
            surveyRunDao,
            mock(SurveyTemplateDao.class),
            mock(SurveyQuestionResponseDao.class),
            involvementGroupService);

    ImmutableSurveyRunChangeCommand.Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    surveyRunService.updateSurveyRunInvolvements(
        1L,
        nameResult
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build(),
        "janedoe");

    // Assert
    verify(involvementGroupDao, atLeast(1)).updateInvolvements(eq(1L), isA(Set.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).getOwnerInvolvementGroupId(1L);
    verify(surveyRunDao).getRecipientInvolvementGroupId(1L);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunStatus(String, long, SurveyRunStatus)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunStatus(String, long,
   * SurveyRunStatus)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunStatus(String, long, SurveyRunStatus); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunService.updateSurveyRunStatus(String, long, SurveyRunStatus)"})
  void testUpdateSurveyRunStatus_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateStatus(anyLong(), Mockito.<SurveyRunStatus>any())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    int actualUpdateSurveyRunStatusResult =
        surveyRunService.updateSurveyRunStatus("janedoe", 1L, SurveyRunStatus.DRAFT);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).updateStatus(1L, SurveyRunStatus.DRAFT);
    assertEquals(1, actualUpdateSurveyRunStatusResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunStatus(String, long, SurveyRunStatus)}.
   *
   * <ul>
   *   <li>Given {@link SurveyRunDao} {@link SurveyRunDao#issue(long)} return one.
   *   <li>Then calls {@link SurveyRunDao#issue(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunStatus(String, long,
   * SurveyRunStatus)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunStatus(String, long, SurveyRunStatus); given SurveyRunDao issue(long) return one; then calls issue(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunService.updateSurveyRunStatus(String, long, SurveyRunStatus)"})
  void testUpdateSurveyRunStatus_givenSurveyRunDaoIssueReturnOne_thenCallsIssue() {
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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.issue(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    int actualUpdateSurveyRunStatusResult =
        surveyRunService.updateSurveyRunStatus("janedoe", 1L, SurveyRunStatus.ISSUED);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).issue(1L);
    assertEquals(1, actualUpdateSurveyRunStatusResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunStatus(String, long, SurveyRunStatus)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunStatus(String, long,
   * SurveyRunStatus)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunStatus(String, long, SurveyRunStatus); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunService.updateSurveyRunStatus(String, long, SurveyRunStatus)"})
  void testUpdateSurveyRunStatus_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateStatus(anyLong(), Mockito.<SurveyRunStatus>any())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    int actualUpdateSurveyRunStatusResult =
        surveyRunService.updateSurveyRunStatus("janedoe", 1L, SurveyRunStatus.DRAFT);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).updateStatus(1L, SurveyRunStatus.DRAFT);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateSurveyRunStatusResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunDueDate(String, long, DateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunDueDate(String, long,
   * DateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunDueDate(String, long, DateChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyRunService.updateSurveyRunDueDate(String, long, DateChangeCommand)"
  })
  void testUpdateSurveyRunDueDate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateDueDateForSurveyRun(anyLong(), Mockito.<LocalDate>any()))
        .thenReturn(1);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateDueDate(anyLong(), Mockito.<LocalDate>any())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    int actualUpdateSurveyRunDueDateResult =
        surveyRunService.updateSurveyRunDueDate(
            "janedoe",
            1L,
            ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceDao).updateDueDateForSurveyRun(eq(1L), isA(LocalDate.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).updateDueDate(eq(1L), isA(LocalDate.class));
    assertEquals(2, actualUpdateSurveyRunDueDateResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunDueDate(String, long, DateChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunDueDate(String, long,
   * DateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunDueDate(String, long, DateChangeCommand); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyRunService.updateSurveyRunDueDate(String, long, DateChangeCommand)"
  })
  void testUpdateSurveyRunDueDate_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateDueDateForSurveyRun(anyLong(), Mockito.<LocalDate>any()))
        .thenReturn(1);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateDueDate(anyLong(), Mockito.<LocalDate>any())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    int actualUpdateSurveyRunDueDateResult =
        surveyRunService.updateSurveyRunDueDate(
            "janedoe",
            1L,
            ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());

    // Assert
    verify(surveyInstanceDao).updateDueDateForSurveyRun(eq(1L), isA(LocalDate.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).updateDueDate(eq(1L), isA(LocalDate.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(2, actualUpdateSurveyRunDueDateResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunApprovalDueDate(String, long, DateChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunApprovalDueDate(String, long,
   * DateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunApprovalDueDate(String, long, DateChangeCommand); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyRunService.updateSurveyRunApprovalDueDate(String, long, DateChangeCommand)"
  })
  void testUpdateSurveyRunApprovalDueDate_thenCallsWrite() {
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

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateApprovalDueDateForSurveyRun(anyLong(), Mockito.<LocalDate>any()))
        .thenReturn(42);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateApprovalDueDate(anyLong(), Mockito.<LocalDate>any())).thenReturn(42);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    int actualUpdateSurveyRunApprovalDueDateResult =
        surveyRunService.updateSurveyRunApprovalDueDate(
            "janedoe",
            1L,
            ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceDao).updateApprovalDueDateForSurveyRun(eq(1L), isA(LocalDate.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).updateApprovalDueDate(eq(1L), isA(LocalDate.class));
    assertEquals(84, actualUpdateSurveyRunApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyRunApprovalDueDate(String, long, DateChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyRunApprovalDueDate(String, long,
   * DateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyRunApprovalDueDate(String, long, DateChangeCommand); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyRunService.updateSurveyRunApprovalDueDate(String, long, DateChangeCommand)"
  })
  void testUpdateSurveyRunApprovalDueDate_thenCallsWrite2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateApprovalDueDateForSurveyRun(anyLong(), Mockito.<LocalDate>any()))
        .thenReturn(42);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateApprovalDueDate(anyLong(), Mockito.<LocalDate>any())).thenReturn(42);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    int actualUpdateSurveyRunApprovalDueDateResult =
        surveyRunService.updateSurveyRunApprovalDueDate(
            "janedoe",
            1L,
            ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());

    // Assert
    verify(surveyInstanceDao).updateApprovalDueDateForSurveyRun(eq(1L), isA(LocalDate.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyRunDao).updateApprovalDueDate(eq(1L), isA(LocalDate.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(84, actualUpdateSurveyRunApprovalDueDateResult);
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceRecipients() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    entityReferenceListMap.put(immutableEntityReference, new ArrayList<>());

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(entityReferenceListMap);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult =
        surveyRunService.generateSurveyInstanceRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceRecipients2() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyRun.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .contactEmail("jane.doe@example.org")
                .description("The characteristics of someone or something")
                .dueDate(LocalDate.of(1970, 1, 1))
                .id(1L)
                .issuanceKind(SurveyIssuanceKind.GROUP)
                .issuedOn(LocalDate.of(1970, 1, 1))
                .name("Name")
                .ownerId(1L)
                .selectionOptions(selectionOptions)
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult =
        surveyRunService.generateSurveyInstanceRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceRecipients3() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult =
        surveyRunService.generateSurveyInstanceRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceRecipients4() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyRun.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .contactEmail("jane.doe@example.org")
                .description("The characteristics of someone or something")
                .dueDate(LocalDate.of(1970, 1, 1))
                .id(1L)
                .issuanceKind(SurveyIssuanceKind.GROUP)
                .issuedOn(LocalDate.of(1970, 1, 1))
                .name("Name")
                .ownerId(1L)
                .selectionOptions(selectionOptions)
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult =
        surveyRunService.generateSurveyInstanceRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceRecipients_thenReturnEmpty() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult =
        surveyRunService.generateSurveyInstanceRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceOwners() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    entityReferenceListMap.put(immutableEntityReference, new ArrayList<>());

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(entityReferenceListMap);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult =
        surveyRunService.generateSurveyInstanceOwners(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceOwners2() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult =
        surveyRunService.generateSurveyInstanceOwners(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceOwners3() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyRun.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .contactEmail("jane.doe@example.org")
                .description("The characteristics of someone or something")
                .dueDate(LocalDate.of(1970, 1, 1))
                .id(1L)
                .issuanceKind(SurveyIssuanceKind.GROUP)
                .issuedOn(LocalDate.of(1970, 1, 1))
                .name("Name")
                .ownerId(1L)
                .selectionOptions(selectionOptions)
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult =
        surveyRunService.generateSurveyInstanceOwners(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}.
   *
   * <ul>
   *   <li>Given builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand); given builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceOwners_givenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyRun.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .contactEmail("jane.doe@example.org")
                .description("The characteristics of someone or something")
                .dueDate(LocalDate.of(1970, 1, 1))
                .id(1L)
                .issuanceKind(SurveyIssuanceKind.GROUP)
                .issuedOn(LocalDate.of(1970, 1, 1))
                .name("Name")
                .ownerId(1L)
                .selectionOptions(selectionOptions)
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult =
        surveyRunService.generateSurveyInstanceOwners(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyRunService.generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)"
  })
  void testGenerateSurveyInstanceOwners_thenReturnEmpty() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult =
        surveyRunService.generateSurveyInstanceOwners(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyRunDao).getById(1L);
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients2() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    entityReferenceListMap.put(immutableEntityReference, new ArrayList<>());

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(entityReferenceListMap);

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients3() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyRun.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .contactEmail("jane.doe@example.org")
                .description("The characteristics of someone or something")
                .dueDate(LocalDate.of(1970, 1, 1))
                .id(1L)
                .issuanceKind(SurveyIssuanceKind.GROUP)
                .issuedOn(LocalDate.of(1970, 1, 1))
                .name("Name")
                .ownerId(1L)
                .selectionOptions(selectionOptions)
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

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
                .targetEntityKind(EntityKind.APPLICATION)
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
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients4() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients5() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyRun.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .contactEmail("jane.doe@example.org")
                .description("The characteristics of someone or something")
                .dueDate(LocalDate.of(1970, 1, 1))
                .id(1L)
                .issuanceKind(SurveyIssuanceKind.GROUP)
                .issuedOn(LocalDate.of(1970, 1, 1))
                .name("Name")
                .ownerId(1L)
                .selectionOptions(selectionOptions)
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

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
                .targetEntityKind(EntityKind.APPLICATION)
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
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients6() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);

    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
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
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    ImmutableInstancesAndRecipientsCreateCommand.Builder builderResult2 =
        ImmutableInstancesAndRecipientsCreateCommand.builder();

    ImmutableSurveyInstanceRecipient.Builder idResult =
        ImmutableSurveyInstanceRecipient.builder().id(1L);

    ImmutableSurveyInstanceRecipient.Builder personResult =
        idResult.person(
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
    builderResult2.addExcludedRecipients(
        personResult
            .surveyInstance(
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
                    .build())
            .build());

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            builderResult2
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients7() {
    // Arrange
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
                .build());

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients8() {
    // Arrange
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
                .build());

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceDao#create(SurveyInstanceCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand); then calls create(SurveyInstanceCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients_thenCallsCreate() {
    // Arrange
    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
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

    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    entityReferenceListMap.put(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        personList);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(entityReferenceListMap);
    when(surveyInstanceDao.create(Mockito.<SurveyInstanceCreateCommand>any())).thenReturn(1L);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any()))
        .thenReturn(1L);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any()))
        .thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
                .build());

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).create(isA(SurveyInstanceCreateCommand.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceDao#create(SurveyInstanceCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand); then calls create(SurveyInstanceCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)"
  })
  void testCreateSurveyInstancesAndRecipients_thenCallsCreate2() {
    // Arrange
    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
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
    personList.add(
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

    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    entityReferenceListMap.put(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        personList);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(entityReferenceListMap);
    when(surveyInstanceDao.create(Mockito.<SurveyInstanceCreateCommand>any())).thenReturn(1L);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    when(surveyInstanceRecipientDao.create(Mockito.<SurveyInstanceRecipientCreateCommand>any()))
        .thenReturn(1L);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    when(surveyInstanceOwnerDao.create(Mockito.<SurveyInstanceOwnerCreateCommand>any()))
        .thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
                .targetEntityKind(EntityKind.APPLICATION)
                .build());

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult =
        surveyRunService.createSurveyInstancesAndRecipients(
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(LocalDate.of(1970, 1, 1))
                .dueDate(LocalDate.of(1970, 1, 1))
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build());

    // Assert
    verify(involvementDao, atLeast(1))
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).create(isA(SurveyInstanceCreateCommand.class));
    verify(surveyInstanceDao).deleteForSurveyRun(1L);
    verify(surveyInstanceOwnerDao).create(isA(SurveyInstanceOwnerCreateCommand.class));
    verify(surveyInstanceRecipientDao).create(isA(SurveyInstanceRecipientCreateCommand.class));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(1L);
    verify(surveyRunDao, atLeast(1)).getById(1L);
    verify(surveyTemplateDao, atLeast(1)).getById(1L);
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Test {@link SurveyRunService#findBySurveyInstanceIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * SurveyRunService#findBySurveyInstanceIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySurveyInstanceIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findBySurveyInstanceIdSelector(IdSelectionOptions)"})
  void testFindBySurveyInstanceIdSelector() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findBySurveyInstanceIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<SurveyRun> actualFindBySurveyInstanceIdSelectorResult =
        surveyRunService.findBySurveyInstanceIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(surveyRunDao).findBySurveyInstanceIdSelector(isA(Select.class));
    assertTrue(actualFindBySurveyInstanceIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunService#findBySurveyInstanceIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#entityReference()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyRunService#findBySurveyInstanceIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySurveyInstanceIdSelector(IdSelectionOptions); given EXACT; then calls entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findBySurveyInstanceIdSelector(IdSelectionOptions)"})
  void testFindBySurveyInstanceIdSelector_givenExact_thenCallsEntityReference() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findBySurveyInstanceIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

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
    List<SurveyRun> actualFindBySurveyInstanceIdSelectorResult =
        surveyRunService.findBySurveyInstanceIdSelector(idSelectionOptions);

    // Assert
    verify(surveyRunDao).findBySurveyInstanceIdSelector(isA(Select.class));
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySurveyInstanceIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunService#findByTemplateId(long)}.
   *
   * <p>Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  @DisplayName("Test findByTemplateId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findByTemplateId(long)"})
  void testFindByTemplateId() {
    // Arrange
    HashSet<Person> personSet = new HashSet<>();
    personSet.add(
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(personSet);

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult =
        surveyRunService.findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunService#findByTemplateId(long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add builder surveyRunId one build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  @DisplayName(
      "Test findByTemplateId(long); given ArrayList() add builder surveyRunId one build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findByTemplateId(long)"})
  void testFindByTemplateId_givenArrayListAddBuilderSurveyRunIdOneBuild_thenReturnEmpty() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    ArrayList<SurveyRunCompletionRate> surveyRunCompletionRateList = new ArrayList<>();
    surveyRunCompletionRateList.add(
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(surveyRunCompletionRateList);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult =
        surveyRunService.findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunService#findByTemplateId(long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add builder surveyRunId one build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  @DisplayName(
      "Test findByTemplateId(long); given ArrayList() add builder surveyRunId one build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findByTemplateId(long)"})
  void testFindByTemplateId_givenArrayListAddBuilderSurveyRunIdOneBuild_thenReturnEmpty2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    ArrayList<SurveyRunCompletionRate> surveyRunCompletionRateList = new ArrayList<>();
    surveyRunCompletionRateList.add(
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());
    surveyRunCompletionRateList.add(
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(surveyRunCompletionRateList);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult =
        surveyRunService.findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunService#findByTemplateId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  @DisplayName("Test findByTemplateId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findByTemplateId(long)"})
  void testFindByTemplateId_thenReturnEmpty() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult =
        surveyRunService.findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunService#findByTemplateId(long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  @DisplayName("Test findByTemplateId(long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findByTemplateId(long)"})
  void testFindByTemplateId_thenReturnSizeIsOne() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    surveyRunList.add(
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(surveyRunList);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult =
        surveyRunService.findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    assertEquals(1, actualFindByTemplateIdResult.size());
    SurveyRunWithOwnerAndStats getResult = actualFindByTemplateIdResult.get(0);
    assertTrue(getResult.surveyRun() instanceof ImmutableSurveyRun);
    assertTrue(getResult.completionRateStats() instanceof ImmutableSurveyRunCompletionRate);
    assertTrue(getResult instanceof ImmutableSurveyRunWithOwnerAndStats);
    assertNull(getResult.owner());
  }

  /**
   * Test {@link SurveyRunService#findByTemplateId(long)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  @DisplayName("Test findByTemplateId(long); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunService.findByTemplateId(long)"})
  void testFindByTemplateId_thenReturnSizeIsTwo() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    surveyRunList.add(
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());

    ImmutableSurveyRun.Builder ownerIdResult2 =
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

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);
    surveyRunList.add(
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(surveyRunList);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult =
        surveyRunService.findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    assertEquals(2, actualFindByTemplateIdResult.size());
    SurveyRunWithOwnerAndStats getResult = actualFindByTemplateIdResult.get(1);
    assertTrue(getResult instanceof ImmutableSurveyRunWithOwnerAndStats);
    assertEquals(actualFindByTemplateIdResult.get(0), getResult);
  }

  /**
   * Test {@link SurveyRunService#getCompletionRate(long)}.
   *
   * <p>Method under test: {@link SurveyRunService#getCompletionRate(long)}
   */
  @Test
  @DisplayName("Test getCompletionRate(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyRunCompletionRate SurveyRunService.getCompletionRate(long)"})
  void testGetCompletionRate() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getCompletionRateForSurveyRun(Mockito.<Long>any()))
        .thenReturn(ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    SurveyRunCompletionRate actualCompletionRate = surveyRunService.getCompletionRate(1L);

    // Assert
    verify(surveyInstanceDao).getCompletionRateForSurveyRun(1L);
    assertTrue(actualCompletionRate instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, actualCompletionRate.completedCount());
    assertEquals(0, actualCompletionRate.inProgressCount());
    assertEquals(0, actualCompletionRate.notStartedCount());
    assertEquals(0, actualCompletionRate.totalCount());
    assertEquals(1L, actualCompletionRate.surveyRunId());
  }

  /**
   * Test {@link SurveyRunService#createDirectSurveyInstances(long,
   * SurveyInstanceRecipientsAndOwners)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#createDirectSurveyInstances(long,
   * SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  @DisplayName(
      "Test createDirectSurveyInstances(long, SurveyInstanceRecipientsAndOwners); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyRunService.createDirectSurveyInstances(long, SurveyInstanceRecipientsAndOwners)"
  })
  void testCreateDirectSurveyInstances_thenReturnTrue() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.createInstanceOwners(
            Mockito.<Long>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(surveyInstanceDao.createInstanceRecipients(
            Mockito.<Long>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(surveyInstanceDao.create(Mockito.<SurveyInstanceCreateCommand>any())).thenReturn(1L);

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

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult2 =
        ImmutableSurveyInstanceRecipientsAndOwners.builder();
    builderResult2.addRecipientPersonIds(1L);

    // Act
    boolean actualCreateDirectSurveyInstancesResult =
        surveyRunService.createDirectSurveyInstances(
            1L, builderResult2.ownerId("42").owningRole("Owning Role").build());

    // Assert
    verify(surveyInstanceDao).create(isA(SurveyInstanceCreateCommand.class));
    verify(surveyInstanceDao).createInstanceOwners(eq(1L), isA(Collection.class));
    verify(surveyInstanceDao).createInstanceRecipients(eq(1L), isA(Collection.class));
    verify(surveyRunDao).getById(1L);
    assertTrue(actualCreateDirectSurveyInstancesResult);
  }

  /**
   * Test {@link SurveyRunService#updateSurveyInstanceOwningRoles(String, long,
   * SurveyInstanceOwningRoleSaveCommand)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunService#updateSurveyInstanceOwningRoles(String, long,
   * SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSurveyInstanceOwningRoles(String, long, SurveyInstanceOwningRoleSaveCommand); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyRunService.updateSurveyInstanceOwningRoles(String, long, SurveyInstanceOwningRoleSaveCommand)"
  })
  void testUpdateSurveyInstanceOwningRoles_thenReturnOne() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateOwningRoleForSurveyRun(anyLong(), Mockito.<String>any()))
        .thenReturn(1);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    // Act
    int actualUpdateSurveyInstanceOwningRolesResult =
        surveyRunService.updateSurveyInstanceOwningRoles(
            "janedoe",
            1L,
            ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
                .owningRole("Owning Role")
                .build());

    // Assert
    verify(surveyInstanceDao).updateOwningRoleForSurveyRun(1L, "Owning Role");
    assertEquals(1, actualUpdateSurveyInstanceOwningRolesResult);
  }
}
