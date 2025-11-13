package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.survey.ImmutableSurveyRunWithOwnerAndStats.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunWithOwnerAndStats.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunWithOwnerAndStatsDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#owner(Person)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunWithOwnerAndStats Builder.build()",
    "Builder Builder.owner(Person)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    ImmutableSurveyRunCompletionRate completionRateStats =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();
    Builder actualCompletionRateStatsResult =
        actualBuilderResult.completionRateStats(completionRateStats);
    ImmutablePerson owner =
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
            .build();
    Builder actualOwnerResult = actualCompletionRateStatsResult.owner(owner);
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
    ImmutableSurveyRunWithOwnerAndStats actualImmutableSurveyRunWithOwnerAndStats =
        actualOwnerResult.surveyRun(surveyRun).build();

    // Assert
    assertSame(owner, actualImmutableSurveyRunWithOwnerAndStats.owner());
    assertSame(surveyRun, actualImmutableSurveyRunWithOwnerAndStats.surveyRun());
    assertSame(
        completionRateStats, actualImmutableSurveyRunWithOwnerAndStats.completionRateStats());
  }

  /**
   * Test Builder {@link Builder#completionRateStats(SurveyRunCompletionRate)}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyRunCompletionRate.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#completionRateStats(SurveyRunCompletionRate)}
   */
  @Test
  @DisplayName(
      "Test Builder completionRateStats(SurveyRunCompletionRate); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.completionRateStats(SurveyRunCompletionRate)"})
  void testBuilderCompletionRateStats_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    // Act
    Builder actualCompletionRateStatsResult =
        builderResult.completionRateStats(new ImmutableSurveyRunCompletionRate.Json());

    // Assert
    assertSame(builderResult, actualCompletionRateStatsResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunWithOwnerAndStats)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRunWithOwnerAndStats)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunWithOwnerAndStats)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunWithOwnerAndStats)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder builderResult2 = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult2.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSurveyRunWithOwnerAndStats instance =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyRunWithOwnerAndStats actualImmutableSurveyRunWithOwnerAndStats =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunWithOwnerAndStats);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    // Act
    Builder actualSurveyRunResult = builderResult.surveyRun(new ImmutableSurveyRun.Json());

    // Assert
    assertSame(builderResult, actualSurveyRunResult);
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#copyOf(SurveyRunWithOwnerAndStats)}.
   *
   * <ul>
   *   <li>Then owner return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunWithOwnerAndStats#copyOf(SurveyRunWithOwnerAndStats)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyRunWithOwnerAndStats); then owner return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunWithOwnerAndStats ImmutableSurveyRunWithOwnerAndStats.copyOf(SurveyRunWithOwnerAndStats)"
  })
  void testCopyOf_thenOwnerReturnImmutablePerson() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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
    ImmutableSurveyRunWithOwnerAndStats instance =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualCopyOfResult =
        ImmutableSurveyRunWithOwnerAndStats.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.owner() instanceof ImmutablePerson);
    assertTrue(actualCopyOfResult.surveyRun() instanceof ImmutableSurveyRun);
    assertTrue(
        actualCopyOfResult.completionRateStats() instanceof ImmutableSurveyRunCompletionRate);
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}, and {@link
   * ImmutableSurveyRunWithOwnerAndStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunWithOwnerAndStats.equals(Object)",
    "int ImmutableSurveyRunWithOwnerAndStats.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    Builder builderResult3 = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult2 =
        builderResult3.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult2 =
        completionRateStatsResult2.owner(
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

    ImmutableIdSelectionOptions.Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult4
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats2 =
        ownerResult2
            .surveyRun(
                ownerIdResult2
                    .selectionOptions(
                        joiningEntityKindResult2
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSurveyRunWithOwnerAndStats, immutableSurveyRunWithOwnerAndStats2);
    assertEquals(
        immutableSurveyRunWithOwnerAndStats.hashCode(),
        immutableSurveyRunWithOwnerAndStats2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}, and {@link
   * ImmutableSurveyRunWithOwnerAndStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunWithOwnerAndStats.equals(Object)",
    "int ImmutableSurveyRunWithOwnerAndStats.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSurveyRunWithOwnerAndStats, immutableSurveyRunWithOwnerAndStats);
    int expectedHashCodeResult = immutableSurveyRunWithOwnerAndStats.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyRunWithOwnerAndStats.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunWithOwnerAndStats.equals(Object)",
    "int ImmutableSurveyRunWithOwnerAndStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(2L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    Builder builderResult3 = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult2 =
        builderResult3.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult2 =
        completionRateStatsResult2.owner(
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

    ImmutableIdSelectionOptions.Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult4
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyRunWithOwnerAndStats,
        ownerResult2
            .surveyRun(
                ownerIdResult2
                    .selectionOptions(
                        joiningEntityKindResult2
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunWithOwnerAndStats.equals(Object)",
    "int ImmutableSurveyRunWithOwnerAndStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
            ImmutablePerson.builder()
                .departmentName("Name")
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    Builder builderResult3 = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult2 =
        builderResult3.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult2 =
        completionRateStatsResult2.owner(
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

    ImmutableIdSelectionOptions.Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult4
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyRunWithOwnerAndStats,
        ownerResult2
            .surveyRun(
                ownerIdResult2
                    .selectionOptions(
                        joiningEntityKindResult2
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunWithOwnerAndStats.equals(Object)",
    "int ImmutableSurveyRunWithOwnerAndStats.hashCode()"
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

    Builder builderResult3 = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult3.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        completionRateStatsResult
            .owner(
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
                    .build())
            .surveyRun(surveyRun)
            .build();

    Builder builderResult4 = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult2 =
        builderResult4.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult2.owner(
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

    ImmutableIdSelectionOptions.Builder builderResult5 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult5
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyRunWithOwnerAndStats,
        ownerResult
            .surveyRun(
                ownerIdResult2
                    .selectionOptions(
                        joiningEntityKindResult2
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunWithOwnerAndStats.equals(Object)",
    "int ImmutableSurveyRunWithOwnerAndStats.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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

    // Act and Assert
    assertNotEquals(
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunWithOwnerAndStats.equals(Object)",
    "int ImmutableSurveyRunWithOwnerAndStats.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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

    // Act and Assert
    assertNotEquals(
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build(),
        "Different type to ImmutableSurveyRunWithOwnerAndStats");
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableSurveyRun.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) SurveyRun is {@link ImmutableSurveyRun.Json}
   *       (default constructor).
   *   <li>Then surveyRun return {@link ImmutableSurveyRun.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) SurveyRun is Json (default constructor); then surveyRun return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunWithOwnerAndStats ImmutableSurveyRunWithOwnerAndStats.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonSurveyRunIsJson_thenSurveyRunReturnJson() {
    // Arrange
    Json json = new Json();
    ImmutableSurveyRun.Json surveyRun = new ImmutableSurveyRun.Json();
    json.setSurveyRun(surveyRun);
    json.setOwner(null);
    ImmutableSurveyRunCompletionRate.Json completionRateStats =
        new ImmutableSurveyRunCompletionRate.Json();
    json.setCompletionRateStats(completionRateStats);

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualFromJsonResult =
        ImmutableSurveyRunWithOwnerAndStats.fromJson(json);

    // Assert
    SurveyRun surveyRunResult = actualFromJsonResult.surveyRun();
    assertTrue(surveyRunResult instanceof ImmutableSurveyRun.Json);
    SurveyRunCompletionRate completionRateStatsResult = actualFromJsonResult.completionRateStats();
    assertTrue(completionRateStatsResult instanceof ImmutableSurveyRunCompletionRate.Json);
    assertNull(actualFromJsonResult.owner());
    assertSame(surveyRun, surveyRunResult);
    assertSame(completionRateStats, completionRateStatsResult);
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then owner return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then owner return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunWithOwnerAndStats ImmutableSurveyRunWithOwnerAndStats.fromJson(Json)"
  })
  void testFromJson_thenOwnerReturnImmutablePerson() {
    // Arrange
    Json json = new Json();

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
    json.setOwner(
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
    json.setCompletionRateStats(ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualFromJsonResult =
        ImmutableSurveyRunWithOwnerAndStats.fromJson(json);

    // Assert
    Person ownerResult = actualFromJsonResult.owner();
    assertTrue(ownerResult instanceof ImmutablePerson);
    assertTrue(actualFromJsonResult.surveyRun() instanceof ImmutableSurveyRun);
    assertTrue(
        actualFromJsonResult.completionRateStats() instanceof ImmutableSurveyRunCompletionRate);
    assertSame(json.owner, ownerResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#toString()}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#completionRateStats()}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#owner()}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#surveyRun()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyRunCompletionRate ImmutableSurveyRunWithOwnerAndStats.completionRateStats()",
    "Person ImmutableSurveyRunWithOwnerAndStats.owner()",
    "SurveyRun ImmutableSurveyRunWithOwnerAndStats.surveyRun()",
    "String ImmutableSurveyRunWithOwnerAndStats.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableSurveyRunWithOwnerAndStats.toString();
    SurveyRunCompletionRate actualCompletionRateStatsResult =
        immutableSurveyRunWithOwnerAndStats.completionRateStats();
    Person actualOwnerResult = immutableSurveyRunWithOwnerAndStats.owner();

    // Assert
    assertTrue(actualOwnerResult instanceof ImmutablePerson);
    assertTrue(immutableSurveyRunWithOwnerAndStats.surveyRun() instanceof ImmutableSurveyRun);
    assertTrue(actualCompletionRateStatsResult instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(
        "SurveyRunWithOwnerAndStats{surveyRun=SurveyRun{id=1, name=Name, surveyTemplateId=1, selectionOptions"
            + "=IdSelectionOptions{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses=[], filters=SelectionFilters{omitApplic"
            + "ationKinds=[]}}, involvementKindIds=[], issuedOn=1970-01-01, dueDate=1970-01-01, approvalDueDate=1970-01-01,"
            + " issuanceKind=GROUP, ownerId=1, contactEmail=jane.doe@example.org, status=DRAFT, ownerInvKindIds=[],"
            + " isDefault=false}, owner=Person{id=1, employeeId=42, displayName=Display Name, email=jane.doe@example.org,"
            + " isRemoved=true, personKind=EMPLOYEE, title=Dr, mobilePhone=6625550144, officePhone=6625550144,"
            + " userPrincipalName=User Principal Name, managerEmployeeId=42, departmentName=Department Name,"
            + " organisationalUnitId=1, name=Display Name, userId=42, kind=ALL}, completionRateStats=SurveyRunCompletionRate"
            + "{surveyRunId=1, notStartedCount=0, inProgressCount=0, completedCount=0, totalCount=0}}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#completionRateStats()}.
   *
   * <p>Method under test: {@link Json#completionRateStats()}
   */
  @Test
  @DisplayName("Test Json completionRateStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyRunCompletionRate Json.completionRateStats()"})
  void testJsonCompletionRateStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().completionRateStats());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCompletionRateStats(SurveyRunCompletionRate)}
   *   <li>{@link Json#setOwner(Person)}
   *   <li>{@link Json#setSurveyRun(SurveyRun)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCompletionRateStats(SurveyRunCompletionRate)",
    "void Json.setOwner(Person)",
    "void Json.setSurveyRun(SurveyRun)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCompletionRateStats(
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());
    actualJson.setOwner(
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

    // Assert
    SurveyRun surveyRun = actualJson.surveyRun;
    IdSelectionOptions selectionOptionsResult = surveyRun.selectionOptions();
    EntityReference entityReferenceResult = selectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = selectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    Person person = actualJson.owner;
    assertTrue(person instanceof ImmutablePerson);
    assertTrue(surveyRun instanceof ImmutableSurveyRun);
    SurveyRunCompletionRate surveyRunCompletionRate = actualJson.completionRateStats;
    assertTrue(surveyRunCompletionRate instanceof ImmutableSurveyRunCompletionRate);
    LocalDate approvalDueDateResult = surveyRun.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = surveyRun.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("42", person.employeeId());
    assertEquals("42", person.userId());
    assertEquals("Display Name", person.displayName());
    assertEquals("Display Name", person.name());
    assertEquals("Name", surveyRun.name());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", surveyRun.description());
    assertEquals("jane.doe@example.org", person.email());
    assertEquals("jane.doe@example.org", surveyRun.contactEmail());
    assertEquals(0, surveyRunCompletionRate.completedCount());
    assertEquals(0, surveyRunCompletionRate.inProgressCount());
    assertEquals(0, surveyRunCompletionRate.notStartedCount());
    assertEquals(0, surveyRunCompletionRate.totalCount());
    assertEquals(1L, surveyRun.ownerId().longValue());
    assertEquals(1L, surveyRun.surveyTemplateId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, surveyRunCompletionRate.surveyRunId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, person.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(PersonKind.EMPLOYEE, person.personKind());
    assertEquals(SurveyIssuanceKind.GROUP, surveyRun.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, surveyRun.status());
    assertFalse(surveyRun.isDefault());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    Set<Long> involvementKindIdsResult = surveyRun.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertTrue(person.isRemoved());
    assertSame(involvementKindIdsResult, surveyRun.ownerInvKindIds());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test Json {@link Json#owner()}.
   *
   * <p>Method under test: {@link Json#owner()}
   */
  @Test
  @DisplayName("Test Json owner()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person Json.owner()"})
  void testJsonOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().owner());
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
   * Test {@link
   * ImmutableSurveyRunWithOwnerAndStats#withCompletionRateStats(SurveyRunCompletionRate)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunWithOwnerAndStats#withCompletionRateStats(SurveyRunCompletionRate)}
   */
  @Test
  @DisplayName("Test withCompletionRateStats(SurveyRunCompletionRate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunWithOwnerAndStats ImmutableSurveyRunWithOwnerAndStats.withCompletionRateStats(SurveyRunCompletionRate)"
  })
  void testWithCompletionRateStats() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualWithCompletionRateStatsResult =
        immutableSurveyRunWithOwnerAndStats.withCompletionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    // Assert
    assertEquals(immutableSurveyRunWithOwnerAndStats, actualWithCompletionRateStatsResult);
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#withOwner(Person)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#withOwner(Person)}
   */
  @Test
  @DisplayName("Test withOwner(Person)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunWithOwnerAndStats ImmutableSurveyRunWithOwnerAndStats.withOwner(Person)"
  })
  void testWithOwner() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualWithOwnerResult =
        immutableSurveyRunWithOwnerAndStats.withOwner(
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

    // Assert
    assertEquals(immutableSurveyRunWithOwnerAndStats, actualWithOwnerResult);
  }

  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#withSurveyRun(SurveyRun)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunWithOwnerAndStats#withSurveyRun(SurveyRun)}
   */
  @Test
  @DisplayName("Test withSurveyRun(SurveyRun)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunWithOwnerAndStats ImmutableSurveyRunWithOwnerAndStats.withSurveyRun(SurveyRun)"
  })
  void testWithSurveyRun() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    Builder completionRateStatsResult =
        builderResult.completionRateStats(
            ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    Builder ownerResult =
        completionRateStatsResult.owner(
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
    ImmutableSurveyRunWithOwnerAndStats immutableSurveyRunWithOwnerAndStats =
        ownerResult
            .surveyRun(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
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

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualWithSurveyRunResult =
        immutableSurveyRunWithOwnerAndStats.withSurveyRun(
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
    assertEquals(immutableSurveyRunWithOwnerAndStats, actualWithSurveyRunResult);
  }
}
