package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceInfo.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualHistoricalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);
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
    ImmutableSurveyInstance surveyInstance =
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
            .build();
    Builder actualSurveyInstanceResult =
        actualHistoricalVersionsCountResult.surveyInstance(surveyInstance);
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSurveyRun surveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();
    Builder actualSurveyRunResult = actualSurveyInstanceResult.surveyRun(surveyRun);
    ImmutableEntityReference surveyTemplateRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableSurveyInstanceInfo actualImmutableSurveyInstanceInfo =
        actualSurveyRunResult.surveyTemplateRef(surveyTemplateRef).build();

    // Assert
    assertEquals(3, actualImmutableSurveyInstanceInfo.historicalVersionsCount().intValue());
    assertSame(surveyTemplateRef, actualImmutableSurveyInstanceInfo.surveyTemplateRef());
    assertSame(surveyInstance, actualImmutableSurveyInstanceInfo.surveyInstance());
    assertSame(surveyRun, actualImmutableSurveyInstanceInfo.surveyRun());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceInfo)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceInfo actualImmutableSurveyInstanceInfo = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#historicalVersionsCount(Integer)}.
   *
   * <p>Method under test: {@link Builder#historicalVersionsCount(Integer)}
   */
  @Test
  @DisplayName("Test Builder historicalVersionsCount(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.historicalVersionsCount(Integer)"})
  void testBuilderHistoricalVersionsCount() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act
    Builder actualHistoricalVersionsCountResult = builderResult.historicalVersionsCount(3);

    // Assert
    assertSame(builderResult, actualHistoricalVersionsCountResult);
  }

  /**
   * Test Builder {@link Builder#surveyInstance(SurveyInstance)}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyInstance.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  @DisplayName(
      "Test Builder surveyInstance(SurveyInstance); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyInstance(SurveyInstance)"})
  void testBuilderSurveyInstance_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act
    Builder actualSurveyInstanceResult =
        builderResult.surveyInstance(new ImmutableSurveyInstance.Json());

    // Assert
    assertSame(builderResult, actualSurveyInstanceResult);
  }

  /**
   * Test Builder {@link Builder#surveyRun(SurveyRun)}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyRun.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#surveyRun(SurveyRun)}
   */
  @Test
  @DisplayName(
      "Test Builder surveyRun(SurveyRun); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyRun(SurveyRun)"})
  void testBuilderSurveyRun_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act
    Builder actualSurveyRunResult = builderResult.surveyRun(new ImmutableSurveyRun.Json());

    // Assert
    assertSame(builderResult, actualSurveyRunResult);
  }

  /**
   * Test Builder {@link Builder#surveyTemplateRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#surveyTemplateRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder surveyTemplateRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyTemplateRef(EntityReference)"})
  void testBuilderSurveyTemplateRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act
    Builder actualSurveyTemplateRefResult =
        builderResult.surveyTemplateRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualSurveyTemplateRefResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#copyOf(SurveyInstanceInfo)}.
   *
   * <ul>
   *   <li>Then surveyTemplateRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#copyOf(SurveyInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceInfo); then surveyTemplateRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceInfo ImmutableSurveyInstanceInfo.copyOf(SurveyInstanceInfo)"
  })
  void testCopyOf_thenSurveyTemplateRefReturnImmutableEntityReference() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo instance =
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
            .build();

    // Act
    ImmutableSurveyInstanceInfo actualCopyOfResult = ImmutableSurveyInstanceInfo.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.surveyTemplateRef() instanceof ImmutableEntityReference);
    assertTrue(actualCopyOfResult.surveyInstance() instanceof ImmutableSurveyInstance);
    assertTrue(actualCopyOfResult.surveyRun() instanceof ImmutableSurveyRun);
    assertEquals(3, actualCopyOfResult.historicalVersionsCount().intValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#equals(Object)}, and {@link
   * ImmutableSurveyInstanceInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceInfo#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceInfo.equals(Object)",
    "int ImmutableSurveyInstanceInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

    Builder historicalVersionsCountResult2 =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

    ImmutableSurveyInstance.Builder owningRoleResult2 =
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

    ImmutableSurveyInstance.Builder submittedByResult2 =
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

    Builder surveyInstanceResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    Builder surveyRunResult2 =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo2 =
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
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceInfo, immutableSurveyInstanceInfo2);
    assertEquals(immutableSurveyInstanceInfo.hashCode(), immutableSurveyInstanceInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#equals(Object)}, and {@link
   * ImmutableSurveyInstanceInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceInfo#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceInfo.equals(Object)",
    "int ImmutableSurveyInstanceInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceInfo, immutableSurveyInstanceInfo);
    int expectedHashCodeResult = immutableSurveyInstanceInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceInfo.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceInfo.equals(Object)",
    "int ImmutableSurveyInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(1);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

    Builder historicalVersionsCountResult2 =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

    ImmutableSurveyInstance.Builder owningRoleResult2 =
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

    ImmutableSurveyInstance.Builder submittedByResult2 =
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

    Builder surveyInstanceResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    Builder surveyRunResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceInfo,
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
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceInfo.equals(Object)",
    "int ImmutableSurveyInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.now())
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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

    Builder historicalVersionsCountResult2 =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

    ImmutableSurveyInstance.Builder owningRoleResult2 =
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

    ImmutableSurveyInstance.Builder submittedByResult2 =
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

    Builder surveyInstanceResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    Builder surveyRunResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceInfo,
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
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceInfo.equals(Object)",
    "int ImmutableSurveyInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyRun.Builder builderResult = ImmutableSurveyRun.builder();
    builderResult.addInvolvementKindIds(1L);

    ImmutableSurveyRun.Builder ownerIdResult =
        builderResult
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSurveyRun surveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyRunResult =
        historicalVersionsCountResult
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
            .surveyRun(surveyRun);
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

    Builder historicalVersionsCountResult2 =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

    ImmutableSurveyInstance.Builder owningRoleResult2 =
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

    ImmutableSurveyInstance.Builder submittedByResult2 =
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

    Builder surveyInstanceResult =
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

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    Builder surveyRunResult2 =
        surveyInstanceResult.surveyRun(
            ownerIdResult2
                .selectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceInfo,
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
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceInfo.equals(Object)",
    "int ImmutableSurveyInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
        surveyRunResult
            .surveyTemplateRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder historicalVersionsCountResult2 =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

    ImmutableSurveyInstance.Builder owningRoleResult2 =
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

    ImmutableSurveyInstance.Builder submittedByResult2 =
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

    Builder surveyInstanceResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    Builder surveyRunResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceInfo,
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
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceInfo.equals(Object)",
    "int ImmutableSurveyInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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

    // Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceInfo.equals(Object)",
    "int ImmutableSurveyInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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

    // Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableSurveyInstanceInfo");
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then surveyTemplateRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then surveyTemplateRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceInfo ImmutableSurveyInstanceInfo.fromJson(Json)"})
  void testFromJson_thenSurveyTemplateRefReturnImmutableEntityReference() {
    // Arrange
    Json json = new Json();

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
    json.setSurveyInstance(
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    json.setSurveyRun(
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
    json.setSurveyTemplateRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setHistoricalVersionsCount(1);

    // Act
    ImmutableSurveyInstanceInfo actualFromJsonResult = ImmutableSurveyInstanceInfo.fromJson(json);

    // Assert
    EntityReference surveyTemplateRefResult = actualFromJsonResult.surveyTemplateRef();
    assertTrue(surveyTemplateRefResult instanceof ImmutableEntityReference);
    SurveyInstance surveyInstanceResult = actualFromJsonResult.surveyInstance();
    assertTrue(surveyInstanceResult instanceof ImmutableSurveyInstance);
    SurveyRun surveyRunResult = actualFromJsonResult.surveyRun();
    assertTrue(surveyRunResult instanceof ImmutableSurveyRun);
    assertEquals(1, actualFromJsonResult.historicalVersionsCount().intValue());
    assertSame(json.surveyInstance, surveyInstanceResult);
    assertSame(json.surveyRun, surveyRunResult);
    assertSame(json.surveyTemplateRef, surveyTemplateRefResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceInfo#toString()}
   *   <li>{@link ImmutableSurveyInstanceInfo#historicalVersionsCount()}
   *   <li>{@link ImmutableSurveyInstanceInfo#surveyInstance()}
   *   <li>{@link ImmutableSurveyInstanceInfo#surveyRun()}
   *   <li>{@link ImmutableSurveyInstanceInfo#surveyTemplateRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableSurveyInstanceInfo.historicalVersionsCount()",
    "SurveyInstance ImmutableSurveyInstanceInfo.surveyInstance()",
    "SurveyRun ImmutableSurveyInstanceInfo.surveyRun()",
    "EntityReference ImmutableSurveyInstanceInfo.surveyTemplateRef()",
    "String ImmutableSurveyInstanceInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

    // Act
    String actualToStringResult = immutableSurveyInstanceInfo.toString();
    Integer actualHistoricalVersionsCountResult =
        immutableSurveyInstanceInfo.historicalVersionsCount();
    SurveyInstance actualSurveyInstanceResult = immutableSurveyInstanceInfo.surveyInstance();
    SurveyRun actualSurveyRunResult = immutableSurveyInstanceInfo.surveyRun();
    EntityReference actualSurveyTemplateRefResult = immutableSurveyInstanceInfo.surveyTemplateRef();

    // Assert
    assertTrue(actualSurveyTemplateRefResult instanceof ImmutableEntityReference);
    assertTrue(actualSurveyInstanceResult instanceof ImmutableSurveyInstance);
    assertTrue(actualSurveyRunResult instanceof ImmutableSurveyRun);
    assertEquals(
        "SurveyInstanceInfo{surveyInstance=SurveyInstance{id=1, surveyRunId=1, surveyEntity=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, surveyEntityExternalId=42, status=NOT_STARTED, dueDate=1970-01-01, approvalDueDate=1970-01-01,"
            + " submittedAt=1970-01-01T00:00, submittedBy=Submitted By, approvedAt=1970-01-01T00:00, approvedBy=Approved"
            + " By, originalInstanceId=1, owningRole=Owning Role, name=Name, kind=ALL, issuedOn=1970-01-01},"
            + " surveyRun=SurveyRun{id=1, name=Name, surveyTemplateId=1, selectionOptions=IdSelectionOptions"
            + "{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT,"
            + " joiningEntityKind=ALL, entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}},"
            + " involvementKindIds=[], issuedOn=1970-01-01, dueDate=1970-01-01, approvalDueDate=1970-01-01,"
            + " issuanceKind=GROUP, ownerId=1, contactEmail=jane.doe@example.org, status=DRAFT, ownerInvKindIds=[],"
            + " isDefault=false}, surveyTemplateRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " historicalVersionsCount=3}",
        actualToStringResult);
    assertEquals(3, actualHistoricalVersionsCountResult.intValue());
    assertEquals(actualSurveyInstanceResult.qualifierEntity(), actualSurveyTemplateRefResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setHistoricalVersionsCount(Integer)}
   *   <li>{@link Json#setSurveyInstance(SurveyInstance)}
   *   <li>{@link Json#setSurveyRun(SurveyRun)}
   *   <li>{@link Json#setSurveyTemplateRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setHistoricalVersionsCount(Integer)",
    "void Json.setSurveyInstance(SurveyInstance)",
    "void Json.setSurveyRun(SurveyRun)",
    "void Json.setSurveyTemplateRef(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setHistoricalVersionsCount(3);
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
    actualJson.setSurveyInstance(
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    actualJson.setSurveyRun(
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
    actualJson.setSurveyTemplateRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    assertEquals(3, actualJson.historicalVersionsCount.intValue());
  }

  /**
   * Test Json {@link Json#historicalVersionsCount()}.
   *
   * <p>Method under test: {@link Json#historicalVersionsCount()}
   */
  @Test
  @DisplayName("Test Json historicalVersionsCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.historicalVersionsCount()"})
  void testJsonHistoricalVersionsCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().historicalVersionsCount());
  }

  /**
   * Test Json {@link Json#surveyInstance()}.
   *
   * <p>Method under test: {@link Json#surveyInstance()}
   */
  @Test
  @DisplayName("Test Json surveyInstance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstance Json.surveyInstance()"})
  void testJsonSurveyInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyInstance());
  }

  /**
   * Test Json {@link Json#surveyRun()}.
   *
   * <p>Method under test: {@link Json#surveyRun()}
   */
  @Test
  @DisplayName("Test Json surveyRun()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyRun Json.surveyRun()"})
  void testJsonSurveyRun() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyRun());
  }

  /**
   * Test Json {@link Json#surveyTemplateRef()}.
   *
   * <p>Method under test: {@link Json#surveyTemplateRef()}
   */
  @Test
  @DisplayName("Test Json surveyTemplateRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.surveyTemplateRef()"})
  void testJsonSurveyTemplateRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyTemplateRef());
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#withHistoricalVersionsCount(Integer)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#withHistoricalVersionsCount(Integer)}
   */
  @Test
  @DisplayName("Test withHistoricalVersionsCount(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceInfo ImmutableSurveyInstanceInfo.withHistoricalVersionsCount(Integer)"
  })
  void testWithHistoricalVersionsCount() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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

    // Act
    ImmutableSurveyInstanceInfo actualWithHistoricalVersionsCountResult =
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
            .build()
            .withHistoricalVersionsCount(42);

    // Assert
    assertTrue(
        actualWithHistoricalVersionsCountResult.surveyTemplateRef()
            instanceof ImmutableEntityReference);
    assertTrue(
        actualWithHistoricalVersionsCountResult.surveyInstance()
            instanceof ImmutableSurveyInstance);
    assertTrue(actualWithHistoricalVersionsCountResult.surveyRun() instanceof ImmutableSurveyRun);
    assertEquals(42, actualWithHistoricalVersionsCountResult.historicalVersionsCount().intValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#withSurveyInstance(SurveyInstance)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#withSurveyInstance(SurveyInstance)}
   */
  @Test
  @DisplayName("Test withSurveyInstance(SurveyInstance)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceInfo ImmutableSurveyInstanceInfo.withSurveyInstance(SurveyInstance)"
  })
  void testWithSurveyInstance() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

    ImmutableSurveyInstance.Builder owningRoleResult2 =
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

    ImmutableSurveyInstance.Builder submittedByResult2 =
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

    // Act
    ImmutableSurveyInstanceInfo actualWithSurveyInstanceResult =
        immutableSurveyInstanceInfo.withSurveyInstance(
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

    // Assert
    assertEquals(immutableSurveyInstanceInfo, actualWithSurveyInstanceResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#withSurveyRun(SurveyRun)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceInfo#withSurveyRun(SurveyRun)}
   */
  @Test
  @DisplayName("Test withSurveyRun(SurveyRun)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceInfo ImmutableSurveyInstanceInfo.withSurveyRun(SurveyRun)"
  })
  void testWithSurveyRun() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    ImmutableSurveyInstanceInfo actualWithSurveyRunResult =
        immutableSurveyInstanceInfo.withSurveyRun(
            ownerIdResult2
                .selectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    // Assert
    assertEquals(immutableSurveyInstanceInfo, actualWithSurveyRunResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceInfo#withSurveyTemplateRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceInfo#withSurveyTemplateRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withSurveyTemplateRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceInfo ImmutableSurveyInstanceInfo.withSurveyTemplateRef(EntityReference)"
  })
  void testWithSurveyTemplateRef() {
    // Arrange
    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
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
    ImmutableSurveyInstanceInfo immutableSurveyInstanceInfo =
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
            .build();

    // Act
    ImmutableSurveyInstanceInfo actualWithSurveyTemplateRefResult =
        immutableSurveyInstanceInfo.withSurveyTemplateRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSurveyInstanceInfo, actualWithSurveyTemplateRefResult);
  }
}
