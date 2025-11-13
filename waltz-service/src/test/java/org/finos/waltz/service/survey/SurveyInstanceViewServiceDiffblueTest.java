package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.survey.SurveyInstanceDao;
import org.finos.waltz.data.survey.SurveyQuestionDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.data.survey.SurveyViewDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.survey.ImmutableSurveyInstance;
import org.finos.waltz.model.survey.ImmutableSurveyInstance.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceFormDetails;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceInfo;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyRun;
import org.finos.waltz.model.survey.SurveyInstanceFormDetails;
import org.finos.waltz.model.survey.SurveyInstanceInfo;
import org.finos.waltz.model.survey.SurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.model.survey.SurveyInstanceUserInvolvement;
import org.finos.waltz.model.survey.SurveyIssuanceKind;
import org.finos.waltz.model.survey.SurveyRunStatus;
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
class SurveyInstanceViewServiceDiffblueTest {
  @Mock private PersonDao personDao;

  @Mock private SurveyInstanceEvaluator surveyInstanceEvaluator;

  @InjectMocks private SurveyInstanceViewService surveyInstanceViewService;

  @Mock private SurveyViewDao surveyViewDao;

  /**
   * Test {@link SurveyInstanceViewService#getInfoById(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceViewService#getInfoById(long)}
   */
  @Test
  @DisplayName("Test getInfoById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceInfo SurveyInstanceViewService.getInfoById(long)"})
  void testGetInfoById() {
    // Arrange
    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);

    ImmutableSurveyInstanceInfo.Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    ImmutableSurveyInstanceInfo.Builder surveyInstanceResult =
        historicalVersionsCountResult.surveyInstance(
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

    ImmutableSurveyInstanceInfo.Builder surveyRunResult =
        surveyInstanceResult.surveyRun(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(surveyViewDao.getById(anyLong()))
        .thenReturn(
            surveyRunResult
                .surveyTemplateRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(personDao, instanceEvaluator, surveyViewDao);

    // Act
    SurveyInstanceInfo actualInfoById = surveyInstanceViewService.getInfoById(1L);

    // Assert
    verify(surveyViewDao).getById(1L);
    assertTrue(actualInfoById.surveyTemplateRef() instanceof ImmutableEntityReference);
    assertTrue(actualInfoById.surveyInstance() instanceof ImmutableSurveyInstance);
    assertTrue(actualInfoById instanceof ImmutableSurveyInstanceInfo);
    assertTrue(actualInfoById.surveyRun() instanceof ImmutableSurveyRun);
    assertEquals(3, actualInfoById.historicalVersionsCount().intValue());
  }

  /**
   * Test {@link SurveyInstanceViewService#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link SurveyInstanceViewService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceViewService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() {
    // Arrange
    when(surveyViewDao.findBySurveyInstanceIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<SurveyInstanceInfo> actualFindByEntityReferenceResult =
        surveyInstanceViewService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Assert
    verify(surveyViewDao).findBySurveyInstanceIdSelector(isA(Select.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceViewService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntityReference} {@link EntityReference#id()} return one.
   *   <li>Then calls {@link EntityReference#id()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceViewService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByEntityReference(EntityReference); given one; when EntityReference id() return one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceViewService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_givenOne_whenEntityReferenceIdReturnOne_thenCallsId() {
    // Arrange
    when(surveyViewDao.findBySurveyInstanceIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ORG_UNIT);

    // Act
    Set<SurveyInstanceInfo> actualFindByEntityReferenceResult =
        surveyInstanceViewService.findByEntityReference(ref);

    // Assert
    verify(surveyViewDao).findBySurveyInstanceIdSelector(isA(Select.class));
    verify(ref).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceViewService#findByPersonId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceViewService#findByPersonId(long)}
   */
  @Test
  @DisplayName("Test findByPersonId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceViewService.findByPersonId(long)"})
  void testFindByPersonId_thenReturnEmpty() {
    // Arrange
    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(new HashSet<>());
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(personDao, instanceEvaluator, surveyViewDao);

    // Act
    Set<SurveyInstanceInfo> actualFindByPersonIdResult =
        surveyInstanceViewService.findByPersonId(1L);

    // Assert
    verify(surveyViewDao).findForOwner(1L);
    verify(surveyViewDao).findForRecipient(1L);
    assertTrue(actualFindByPersonIdResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceViewService#findByPersonId(long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceViewService#findByPersonId(long)}
   */
  @Test
  @DisplayName("Test findByPersonId(long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceViewService.findByPersonId(long)"})
  void testFindByPersonId_thenReturnSizeIsOne() {
    // Arrange
    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();

    ImmutableSurveyInstanceInfo.Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    ImmutableSurveyInstanceInfo.Builder surveyInstanceResult =
        historicalVersionsCountResult.surveyInstance(
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

    ImmutableSurveyInstanceInfo.Builder surveyRunResult =
        surveyInstanceResult.surveyRun(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    surveyInstanceInfoSet.add(
        surveyRunResult
            .surveyTemplateRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(surveyInstanceInfoSet);
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(personDao, instanceEvaluator, surveyViewDao);

    // Act
    Set<SurveyInstanceInfo> actualFindByPersonIdResult =
        surveyInstanceViewService.findByPersonId(1L);

    // Assert
    verify(surveyViewDao).findForOwner(1L);
    verify(surveyViewDao).findForRecipient(1L);
    assertEquals(1, actualFindByPersonIdResult.size());
  }

  /**
   * Test {@link SurveyInstanceViewService#findByPersonId(long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceViewService#findByPersonId(long)}
   */
  @Test
  @DisplayName("Test findByPersonId(long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceViewService.findByPersonId(long)"})
  void testFindByPersonId_thenReturnSizeIsOne2() {
    // Arrange
    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();

    ImmutableSurveyInstanceInfo.Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    ImmutableSurveyInstanceInfo.Builder surveyInstanceResult =
        historicalVersionsCountResult.surveyInstance(
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

    ImmutableSurveyInstanceInfo.Builder surveyRunResult =
        surveyInstanceResult.surveyRun(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    surveyInstanceInfoSet.add(
        surveyRunResult
            .surveyTemplateRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet2 = new HashSet<>();

    ImmutableSurveyInstanceInfo.Builder historicalVersionsCountResult2 =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    ImmutableSurveyInstanceInfo.Builder surveyInstanceResult2 =
        historicalVersionsCountResult2.surveyInstance(
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

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    ImmutableSurveyInstanceInfo.Builder surveyRunResult2 =
        surveyInstanceResult2.surveyRun(
            ownerIdResult2
                .selectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    surveyInstanceInfoSet2.add(
        surveyRunResult2
            .surveyTemplateRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(surveyInstanceInfoSet);
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(surveyInstanceInfoSet2);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(personDao, instanceEvaluator, surveyViewDao);

    // Act
    Set<SurveyInstanceInfo> actualFindByPersonIdResult =
        surveyInstanceViewService.findByPersonId(1L);

    // Assert
    verify(surveyViewDao).findForOwner(1L);
    verify(surveyViewDao).findForRecipient(1L);
    assertEquals(1, actualFindByPersonIdResult.size());
  }

  /**
   * Test {@link SurveyInstanceViewService#getFormDetailsById(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceViewService#getFormDetailsById(long)}
   */
  @Test
  @DisplayName("Test getFormDetailsById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceFormDetails SurveyInstanceViewService.getFormDetailsById(long)"
  })
  void testGetFormDetailsById() {
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

    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(
            mock(PersonDao.class), instanceEvaluator, mock(SurveyViewDao.class));

    // Act
    SurveyInstanceFormDetails actualFormDetailsById =
        surveyInstanceViewService.getFormDetailsById(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualFormDetailsById instanceof ImmutableSurveyInstanceFormDetails);
    assertTrue(actualFormDetailsById.activeQuestions().isEmpty());
    assertTrue(actualFormDetailsById.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link SurveyInstanceViewService#getFormDetailsById(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceViewService#getFormDetailsById(long)}
   */
  @Test
  @DisplayName("Test getFormDetailsById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceFormDetails SurveyInstanceViewService.getFormDetailsById(long)"
  })
  void testGetFormDetailsById2() {
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

    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(
            mock(PersonDao.class), instanceEvaluator, mock(SurveyViewDao.class));

    // Act
    SurveyInstanceFormDetails actualFormDetailsById =
        surveyInstanceViewService.getFormDetailsById(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualFormDetailsById instanceof ImmutableSurveyInstanceFormDetails);
    assertTrue(actualFormDetailsById.activeQuestions().isEmpty());
    assertTrue(actualFormDetailsById.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link SurveyInstanceViewService#getFormDetailsById(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceViewService#getFormDetailsById(long)}
   */
  @Test
  @DisplayName("Test getFormDetailsById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceFormDetails SurveyInstanceViewService.getFormDetailsById(long)"
  })
  void testGetFormDetailsById3() {
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

    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(
            mock(PersonDao.class), instanceEvaluator, mock(SurveyViewDao.class));

    // Act
    SurveyInstanceFormDetails actualFormDetailsById =
        surveyInstanceViewService.getFormDetailsById(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualFormDetailsById instanceof ImmutableSurveyInstanceFormDetails);
    assertTrue(actualFormDetailsById.activeQuestions().isEmpty());
    assertTrue(actualFormDetailsById.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link SurveyInstanceViewService#getFormDetailsById(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceViewService#getFormDetailsById(long)}
   */
  @Test
  @DisplayName("Test getFormDetailsById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceFormDetails SurveyInstanceViewService.getFormDetailsById(long)"
  })
  void testGetFormDetailsById4() {
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
                        .kind(EntityKind.APPLICATION)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(
            mock(PersonDao.class), instanceEvaluator, mock(SurveyViewDao.class));

    // Act
    SurveyInstanceFormDetails actualFormDetailsById =
        surveyInstanceViewService.getFormDetailsById(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualFormDetailsById instanceof ImmutableSurveyInstanceFormDetails);
    assertTrue(actualFormDetailsById.activeQuestions().isEmpty());
    assertTrue(actualFormDetailsById.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link SurveyInstanceViewService#getFormDetailsById(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceEvaluator#eval(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceViewService#getFormDetailsById(long)}
   */
  @Test
  @DisplayName("Test getFormDetailsById(long); then calls eval(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceFormDetails SurveyInstanceViewService.getFormDetailsById(long)"
  })
  void testGetFormDetailsById_thenCallsEval() {
    // Arrange
    SurveyInstanceEvaluator instanceEvaluator = mock(SurveyInstanceEvaluator.class);
    when(instanceEvaluator.eval(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());
    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(
            mock(PersonDao.class), instanceEvaluator, mock(SurveyViewDao.class));

    // Act
    SurveyInstanceFormDetails actualFormDetailsById =
        surveyInstanceViewService.getFormDetailsById(1L);

    // Assert
    verify(instanceEvaluator).eval(1L);
    assertTrue(actualFormDetailsById instanceof ImmutableSurveyInstanceFormDetails);
    assertTrue(actualFormDetailsById.activeQuestions().isEmpty());
    assertTrue(actualFormDetailsById.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link SurveyInstanceViewService#findForUser(String)}.
   *
   * <p>Method under test: {@link SurveyInstanceViewService#findForUser(String)}
   */
  @Test
  @DisplayName("Test findForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceViewService.findForUser(String)"})
  void testFindForUser() {
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

    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(new HashSet<>());
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(personDao, instanceEvaluator, surveyViewDao);

    // Act
    Set<SurveyInstanceUserInvolvement> actualFindForUserResult =
        surveyInstanceViewService.findForUser("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyViewDao).findForOwner(1L);
    verify(surveyViewDao).findForRecipient(1L);
    assertEquals(2, actualFindForUserResult.size());
  }

  /**
   * Test {@link SurveyInstanceViewService#findForUser(String)}.
   *
   * <p>Method under test: {@link SurveyInstanceViewService#findForUser(String)}
   */
  @Test
  @DisplayName("Test findForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceViewService.findForUser(String)"})
  void testFindForUser2() {
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

    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();

    ImmutableSurveyInstanceInfo.Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    ImmutableSurveyInstanceInfo.Builder surveyInstanceResult =
        historicalVersionsCountResult.surveyInstance(
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

    ImmutableSurveyInstanceInfo.Builder surveyRunResult =
        surveyInstanceResult.surveyRun(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    surveyInstanceInfoSet.add(
        surveyRunResult
            .surveyTemplateRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(surveyInstanceInfoSet);
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());
    SurveyInstanceEvaluator instanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyInstanceViewService surveyInstanceViewService =
        new SurveyInstanceViewService(personDao, instanceEvaluator, surveyViewDao);

    // Act
    Set<SurveyInstanceUserInvolvement> actualFindForUserResult =
        surveyInstanceViewService.findForUser("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyViewDao).findForOwner(1L);
    verify(surveyViewDao).findForRecipient(1L);
    assertEquals(2, actualFindForUserResult.size());
  }
}
