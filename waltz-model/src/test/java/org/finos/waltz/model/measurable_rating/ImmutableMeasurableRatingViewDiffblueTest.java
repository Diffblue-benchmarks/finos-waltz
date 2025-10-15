package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation.ImmutableAllocation;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingView.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingView.Json;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAllocationSchemes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAllocationSchemes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAllocationSchemes(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAllocationSchemes(Iterable)"})
  void testBuilderAddAllAllocationSchemes_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddAllAllocationSchemesResult =
        builderResult.addAllAllocationSchemes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#addAllAllocations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAllocations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAllocations(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAllocations(Iterable)"})
  void testBuilderAddAllAllocations_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddAllAllocationsResult = builderResult.addAllAllocations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAllocationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllReplacements(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllReplacements(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllReplacements(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllReplacements(Iterable)"})
  void testBuilderAddAllReplacements_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddAllReplacementsResult = builderResult.addAllReplacements(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#addAllocationSchemes(AllocationScheme)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllocationSchemes(AllocationScheme)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllocationSchemes(AllocationScheme) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllocationSchemes(AllocationScheme)"})
  void testBuilderAddAllocationSchemesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddAllocationSchemesResult =
        builderResult.addAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertSame(builderResult, actualAddAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#addAllocationSchemes(AllocationScheme[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllocationSchemes(AllocationScheme[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAllocationSchemes(AllocationScheme[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllocationSchemes(AllocationScheme[])"})
  void testBuilderAddAllocationSchemesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddAllocationSchemesResult =
        builderResult.addAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertSame(builderResult, actualAddAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#addAllocations(Allocation)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link Allocation}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllocations(Allocation)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllocations(Allocation) with 'element'; when Allocation; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllocations(Allocation)"})
  void testBuilderAddAllocationsWithElement_whenAllocation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddAllocationsResult = builderResult.addAllocations(mock(Allocation.class));

    // Assert
    assertSame(builderResult, actualAddAllocationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllocations(Allocation[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link Allocation}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllocations(Allocation[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAllocations(Allocation[]) with 'elements'; when Allocation; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllocations(Allocation[])"})
  void testBuilderAddAllocationsWithElements_whenAllocation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddAllocationsResult = builderResult.addAllocations(mock(Allocation.class));

    // Assert
    assertSame(builderResult, actualAddAllocationsResult);
  }

  /**
   * Test Builder {@link Builder#addReplacements(MeasurableRatingReplacement)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addReplacements(MeasurableRatingReplacement)}
   */
  @Test
  @DisplayName(
      "Test Builder addReplacements(MeasurableRatingReplacement) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addReplacements(MeasurableRatingReplacement)"})
  void testBuilderAddReplacementsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddReplacementsResult =
        builderResult.addReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertSame(builderResult, actualAddReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#addReplacements(MeasurableRatingReplacement[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  @DisplayName(
      "Test Builder addReplacements(MeasurableRatingReplacement[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addReplacements(MeasurableRatingReplacement[])"})
  void testBuilderAddReplacementsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAddReplacementsResult =
        builderResult.addReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertSame(builderResult, actualAddReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#allocationSchemes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allocationSchemes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder allocationSchemes(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allocationSchemes(Iterable)"})
  void testBuilderAllocationSchemes_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAllocationSchemesResult = builderResult.allocationSchemes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#allocations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allocations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder allocations(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allocations(Iterable)"})
  void testBuilderAllocations_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualAllocationsResult = builderResult.allocations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAllocationsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#category(MeasurableCategory)}
   *   <li>{@link Builder#decommission(MeasurableRatingPlannedDecommission)}
   *   <li>{@link Builder#measurable(Measurable)}
   *   <li>{@link Builder#rating(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView Builder.build()",
    "Builder Builder.category(MeasurableCategory)",
    "Builder Builder.decommission(MeasurableRatingPlannedDecommission)",
    "Builder Builder.measurable(Measurable)",
    "Builder Builder.rating(RatingSchemeItem)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableRatingView.builder();
    ImmutableMeasurableCategory category =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();
    Builder actualCategoryResult = actualBuilderResult.category(category);
    ImmutableMeasurableRatingPlannedDecommission decommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();
    Builder actualDecommissionResult = actualCategoryResult.decommission(decommission);
    ImmutableMeasurable measurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Builder actualMeasurableResult = actualDecommissionResult.measurable(measurable);
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRating measurableRating =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build();
    Builder actualMeasurableRatingResult =
        actualMeasurableResult.measurableRating(measurableRating);
    ImmutableRatingSchemeItem rating =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    ImmutableMeasurableRatingView actualImmutableMeasurableRatingView =
        actualMeasurableRatingResult.rating(rating).build();

    // Assert
    assertTrue(actualImmutableMeasurableRatingView.allocationSchemes().isEmpty());
    assertTrue(actualImmutableMeasurableRatingView.allocations().isEmpty());
    assertSame(measurable, actualImmutableMeasurableRatingView.measurable());
    assertSame(category, actualImmutableMeasurableRatingView.category());
    assertSame(measurableRating, actualImmutableMeasurableRatingView.measurableRating());
    assertSame(decommission, actualImmutableMeasurableRatingView.decommission());
    assertSame(rating, actualImmutableMeasurableRatingView.rating());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder builderResult2 = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult2.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView instance =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRatingView actualImmutableMeasurableRatingView = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableRating(MeasurableRating)}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableRating.Json} (default constructor).
   *   <li>Then builder build measurable is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableRating(MeasurableRating)}
   */
  @Test
  @DisplayName(
      "Test Builder measurableRating(MeasurableRating); when Json (default constructor); then builder build measurable is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableRating(MeasurableRating)"})
  void testBuilderMeasurableRating_whenJson_thenBuilderBuildMeasurableIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    ImmutableMeasurableRating.Json measurableRating = new ImmutableMeasurableRating.Json();

    // Act
    Builder actualMeasurableRatingResult = builderResult.measurableRating(measurableRating);

    // Assert
    ImmutableMeasurableRatingView immutableMeasurableRatingView = builderResult.build();
    assertNull(immutableMeasurableRatingView.measurable());
    assertNull(immutableMeasurableRatingView.category());
    assertNull(immutableMeasurableRatingView.decommission());
    assertNull(immutableMeasurableRatingView.rating());
    assertSame(measurableRating, immutableMeasurableRatingView.measurableRating());
    assertSame(builderResult, actualMeasurableRatingResult);
  }

  /**
   * Test Builder {@link Builder#replacements(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#replacements(Iterable)}
   */
  @Test
  @DisplayName("Test Builder replacements(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.replacements(Iterable)"})
  void testBuilderReplacements_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act
    Builder actualReplacementsResult = builderResult.replacements(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualReplacementsResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}.
   *
   * <ul>
   *   <li>Then measurable return {@link ImmutableMeasurable}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test copyOf(MeasurableRatingView); then measurable return ImmutableMeasurable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.copyOf(MeasurableRatingView)"
  })
  void testCopyOf_thenMeasurableReturnImmutableMeasurable() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView instance =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult =
        ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualCopyOfResult.category() instanceof ImmutableMeasurableCategory);
    assertTrue(actualCopyOfResult.measurableRating() instanceof ImmutableMeasurableRating);
    assertTrue(
        actualCopyOfResult.decommission() instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertTrue(actualCopyOfResult.rating() instanceof ImmutableRatingSchemeItem);
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualCopyOfResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(allocationsResult, actualCopyOfResult.replacements());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#equals(Object)}, and {@link
   * ImmutableMeasurableRatingView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingView#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingView.equals(Object)",
    "int ImmutableMeasurableRatingView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingView.builder();

    Builder categoryResult2 =
        builderResult2.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult2 =
        categoryResult2.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult2 =
        decommissionResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult2 =
        measurableResult2.measurableRating(
            descriptionResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView2 =
        measurableRatingResult2
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingView, immutableMeasurableRatingView2);
    assertEquals(
        immutableMeasurableRatingView.hashCode(), immutableMeasurableRatingView2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#equals(Object)}, and {@link
   * ImmutableMeasurableRatingView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingView#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingView.equals(Object)",
    "int ImmutableMeasurableRatingView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingView, immutableMeasurableRatingView);
    int expectedHashCodeResult = immutableMeasurableRatingView.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingView.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingView.equals(Object)",
    "int ImmutableMeasurableRatingView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    builderResult.addReplacements(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingView.builder();

    Builder categoryResult2 =
        builderResult2.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult2 =
        categoryResult2.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult2 =
        decommissionResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult2 =
        measurableResult2.measurableRating(
            descriptionResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingView,
        measurableRatingResult2
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingView.equals(Object)",
    "int ImmutableMeasurableRatingView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    builderResult.addAllocations(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingView.builder();

    Builder categoryResult2 =
        builderResult2.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult2 =
        categoryResult2.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult2 =
        decommissionResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult2 =
        measurableResult2.measurableRating(
            descriptionResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingView,
        measurableRatingResult2
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingView.equals(Object)",
    "int ImmutableMeasurableRatingView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    builderResult.addAllocationSchemes(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingView.builder();

    Builder categoryResult2 =
        builderResult2.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult2 =
        categoryResult2.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult2 =
        decommissionResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult2 =
        measurableResult2.measurableRating(
            descriptionResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingView,
        measurableRatingResult2
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingView.equals(Object)",
    "int ImmutableMeasurableRatingView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingView.equals(Object)",
    "int ImmutableMeasurableRatingView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build(),
        "Different type to ImmutableMeasurableRatingView");
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Allocation}.
   *   <li>Then return allocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Allocation; then return allocations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddAllocation_thenReturnAllocationsSizeIsOne() {
    // Arrange
    LinkedHashSet<Allocation> allocations = new LinkedHashSet<>();
    allocations.add(mock(Allocation.class));

    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(allocations);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.allocations().size());
    assertTrue(actualFromJsonResult.replacements().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return allocationSchemes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocationSchemes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnAllocationSchemesEmpty() {
    // Arrange
    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(null);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    MeasurableRating measurableRatingResult = actualFromJsonResult.measurableRating();
    assertTrue(measurableRatingResult instanceof ImmutableMeasurableRating);
    assertEquals("00:00", measurableRatingResult.lastUpdatedAt().toLocalTime().toString());
    assertTrue(actualFromJsonResult.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualFromJsonResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(allocationsResult, actualFromJsonResult.replacements());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return allocationSchemes size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocationSchemes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnAllocationSchemesSizeIsOne() {
    // Arrange
    ArrayList<AllocationScheme> allocationSchemes = new ArrayList<>();
    allocationSchemes.add(mock(AllocationScheme.class));

    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(null);
    json.setAllocationSchemes(allocationSchemes);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.allocationSchemes().size());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return allocationSchemes size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocationSchemes size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnAllocationSchemesSizeIsTwo() {
    // Arrange
    ArrayList<AllocationScheme> allocationSchemes = new ArrayList<>();
    allocationSchemes.add(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    allocationSchemes.add(mock(AllocationScheme.class));

    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(null);
    json.setAllocationSchemes(allocationSchemes);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    List<AllocationScheme> allocationSchemesResult = actualFromJsonResult.allocationSchemes();
    assertEquals(2, allocationSchemesResult.size());
    AllocationScheme getResult = allocationSchemesResult.get(0);
    assertTrue(getResult instanceof ImmutableAllocationScheme);
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.measurableCategoryId());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return allocations is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocations is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnAllocationsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Allocation> allocations = new LinkedHashSet<>();
    allocations.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
    allocations.add(mock(Allocation.class));

    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(allocations);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.replacements().isEmpty());
    assertEquals(allocations, actualFromJsonResult.allocations());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return category is {@link Json} (default constructor) {@link Json#category}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return category is Json (default constructor) category")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnCategoryIsJsonCategory() {
    // Arrange
    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(null);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    MeasurableCategory expectedCategoryResult = json.category;
    assertSame(expectedCategoryResult, actualFromJsonResult.category());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return decommission is {@link Json} (default constructor) {@link Json#decommission}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return decommission is Json (default constructor) decommission")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnDecommissionIsJsonDecommission() {
    // Arrange
    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
    json.setReplacements(null);
    json.setAllocations(null);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    MeasurableRatingPlannedDecommission expectedDecommissionResult = json.decommission;
    assertSame(expectedDecommissionResult, actualFromJsonResult.decommission());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return measurable is {@link Json} (default constructor) {@link Json#measurable}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return measurable is Json (default constructor) measurable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnMeasurableIsJsonMeasurable() {
    // Arrange
    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(null);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    Measurable expectedMeasurableResult = json.measurable;
    assertSame(expectedMeasurableResult, actualFromJsonResult.measurable());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return rating is {@link Json} (default constructor) {@link Json#rating}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return rating is Json (default constructor) rating")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnRatingIsJsonRating() {
    // Arrange
    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(null);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    RatingSchemeItem expectedRatingResult = json.rating;
    assertSame(expectedRatingResult, actualFromJsonResult.rating());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return replacements is {@link Json} (default constructor) {@link Json#replacements}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return replacements is Json (default constructor) replacements")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnReplacementsIsJsonReplacements() {
    // Arrange
    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    MeasurableRating measurableRatingResult = actualFromJsonResult.measurableRating();
    assertTrue(measurableRatingResult instanceof ImmutableMeasurableRating);
    assertEquals("00:00", measurableRatingResult.lastUpdatedAt().toLocalTime().toString());
    Set<MeasurableRatingReplacement> expectedReplacementsResult = json.replacements;
    assertSame(expectedReplacementsResult, actualFromJsonResult.replacements());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return replacements size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return replacements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingView ImmutableMeasurableRatingView.fromJson(Json)"})
  void testFromJson_thenReturnReplacementsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableRatingReplacement> replacements = new LinkedHashSet<>();
    replacements.add(mock(MeasurableRatingReplacement.class));

    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(replacements);
    json.setAllocations(null);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult =
        ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    MeasurableRating measurableRatingResult = actualFromJsonResult.measurableRating();
    assertTrue(measurableRatingResult instanceof ImmutableMeasurableRating);
    assertEquals("00:00", measurableRatingResult.lastUpdatedAt().toLocalTime().toString());
    assertEquals(1, actualFromJsonResult.replacements().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingView#toString()}
   *   <li>{@link ImmutableMeasurableRatingView#allocationSchemes()}
   *   <li>{@link ImmutableMeasurableRatingView#allocations()}
   *   <li>{@link ImmutableMeasurableRatingView#category()}
   *   <li>{@link ImmutableMeasurableRatingView#decommission()}
   *   <li>{@link ImmutableMeasurableRatingView#measurable()}
   *   <li>{@link ImmutableMeasurableRatingView#measurableRating()}
   *   <li>{@link ImmutableMeasurableRatingView#rating()}
   *   <li>{@link ImmutableMeasurableRatingView#replacements()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableMeasurableRatingView.allocationSchemes()",
    "Set ImmutableMeasurableRatingView.allocations()",
    "MeasurableCategory ImmutableMeasurableRatingView.category()",
    "MeasurableRatingPlannedDecommission ImmutableMeasurableRatingView.decommission()",
    "Measurable ImmutableMeasurableRatingView.measurable()",
    "MeasurableRating ImmutableMeasurableRatingView.measurableRating()",
    "RatingSchemeItem ImmutableMeasurableRatingView.rating()",
    "Set ImmutableMeasurableRatingView.replacements()",
    "String ImmutableMeasurableRatingView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableMeasurableRatingView.toString();
    List<AllocationScheme> actualAllocationSchemesResult =
        immutableMeasurableRatingView.allocationSchemes();
    Set<Allocation> actualAllocationsResult = immutableMeasurableRatingView.allocations();
    MeasurableCategory actualCategoryResult = immutableMeasurableRatingView.category();
    MeasurableRatingPlannedDecommission actualDecommissionResult =
        immutableMeasurableRatingView.decommission();
    Measurable actualMeasurableResult = immutableMeasurableRatingView.measurable();
    MeasurableRating actualMeasurableRatingResult =
        immutableMeasurableRatingView.measurableRating();
    RatingSchemeItem actualRatingResult = immutableMeasurableRatingView.rating();
    Set<MeasurableRatingReplacement> actualReplacementsResult =
        immutableMeasurableRatingView.replacements();

    // Assert
    assertTrue(actualMeasurableResult instanceof ImmutableMeasurable);
    assertTrue(actualCategoryResult instanceof ImmutableMeasurableCategory);
    assertTrue(actualMeasurableRatingResult instanceof ImmutableMeasurableRating);
    assertTrue(actualDecommissionResult instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertTrue(actualRatingResult instanceof ImmutableRatingSchemeItem);
    assertEquals(
        "MeasurableRatingView{measurableRating=MeasurableRating{id=1, lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, provenance=Provenance, entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, measurableId=1, rating=A, isReadOnly=false, isPrimary=false, ratingId=1},"
            + " measurable=Measurable{id=1, name=Name, parentId=1, externalId=42, entityLifecycleStatus=ACTIVE,"
            + " externalParentId=42, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " position=0, categoryId=1, concrete=true, organisationalUnitId=1, kind=ALL}, category=MeasurableCategory"
            + "{id=1, name=Name, externalId=42, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, icon=Icon,"
            + " position=0, kind=ALL, editable=false, isDeprecated=false, ratingEditorRole=Rating Editor Role,"
            + " ratingSchemeId=1, constrainingAssessmentDefinitionId=1, allowPrimaryRatings=true}, rating=RatingSchemeItem"
            + "{id=1, name=Name, position=0, externalId=42, rating=Rating, color=Color, ratingSchemeId=1, userSelectable"
            + "=true, isRestricted=false, ratingGroup=Rating Group, requiresComment=false}, decommission=Measurable"
            + "RatingPlannedDecommission{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, createdAt=1970-01"
            + "-01T00:00, createdBy=Jan 1, 2020 8:00am GMT+0100, id=1, measurableRatingId=1, plannedDecommissionDate"
            + "=1970-01-01, subjectDecommissionDate=1970-01-01, isValid=true}, replacements=[], allocations=[],"
            + " allocationSchemes=[]}",
        actualToStringResult);
    assertTrue(actualAllocationSchemesResult.isEmpty());
    assertTrue(actualAllocationsResult.isEmpty());
    assertSame(actualAllocationsResult, actualReplacementsResult);
  }

  /**
   * Test Json {@link Json#allocationSchemes()}.
   *
   * <p>Method under test: {@link Json#allocationSchemes()}
   */
  @Test
  @DisplayName("Test Json allocationSchemes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.allocationSchemes()"})
  void testJsonAllocationSchemes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocationSchemes());
  }

  /**
   * Test Json {@link Json#allocations()}.
   *
   * <p>Method under test: {@link Json#allocations()}
   */
  @Test
  @DisplayName("Test Json allocations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.allocations()"})
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocations());
  }

  /**
   * Test Json {@link Json#category()}.
   *
   * <p>Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableCategory Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().category());
  }

  /**
   * Test Json {@link Json#decommission()}.
   *
   * <p>Method under test: {@link Json#decommission()}
   */
  @Test
  @DisplayName("Test Json decommission()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingPlannedDecommission Json.decommission()"})
  void testJsonDecommission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().decommission());
  }

  /**
   * Test Json {@link Json#measurable()}.
   *
   * <p>Method under test: {@link Json#measurable()}
   */
  @Test
  @DisplayName("Test Json measurable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable Json.measurable()"})
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurable());
  }

  /**
   * Test Json {@link Json#measurableRating()}.
   *
   * <p>Method under test: {@link Json#measurableRating()}
   */
  @Test
  @DisplayName("Test Json measurableRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating Json.measurableRating()"})
  void testJsonMeasurableRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableRating());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.measurable);
    assertNull(actualJson.category);
    assertNull(actualJson.measurableRating);
    assertNull(actualJson.decommission);
    assertNull(actualJson.rating);
    assertTrue(actualJson.allocationSchemes.isEmpty());
    assertTrue(actualJson.allocations.isEmpty());
    assertTrue(actualJson.replacements.isEmpty());
  }

  /**
   * Test Json {@link Json#rating()}.
   *
   * <p>Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSchemeItem Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#replacements()}.
   *
   * <p>Method under test: {@link Json#replacements()}
   */
  @Test
  @DisplayName("Test Json replacements()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.replacements()"})
  void testJsonReplacements() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().replacements());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#withAllocationSchemes(AllocationScheme[])} with
   * {@code AllocationScheme[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingView#withAllocationSchemes(AllocationScheme[])}
   */
  @Test
  @DisplayName("Test withAllocationSchemes(AllocationScheme[]) with 'AllocationScheme[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.withAllocationSchemes(AllocationScheme[])"
  })
  void testWithAllocationSchemesWithAllocationScheme() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingView actualWithAllocationSchemesResult =
        immutableMeasurableRatingView.withAllocationSchemes(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    // Assert
    assertTrue(actualWithAllocationSchemesResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualWithAllocationSchemesResult.category() instanceof ImmutableMeasurableCategory);
    assertTrue(
        actualWithAllocationSchemesResult.measurableRating() instanceof ImmutableMeasurableRating);
    assertTrue(
        actualWithAllocationSchemesResult.decommission()
            instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertTrue(actualWithAllocationSchemesResult.rating() instanceof ImmutableRatingSchemeItem);
    assertEquals(1, actualWithAllocationSchemesResult.allocationSchemes().size());
    Set<Allocation> allocationsResult = actualWithAllocationSchemesResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(allocationsResult, actualWithAllocationSchemesResult.replacements());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#withAllocations(Allocation[])} with {@code
   * Allocation[]}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#withAllocations(Allocation[])}
   */
  @Test
  @DisplayName("Test withAllocations(Allocation[]) with 'Allocation[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.withAllocations(Allocation[])"
  })
  void testWithAllocationsWithAllocation() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingView actualWithAllocationsResult =
        immutableMeasurableRatingView.withAllocations(
            ImmutableAllocation.builder()
                .externalId("42")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .percentage(1)
                .provenance("Provenance")
                .schemeId(1L)
                .build());

    // Assert
    assertTrue(actualWithAllocationsResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualWithAllocationsResult.category() instanceof ImmutableMeasurableCategory);
    assertTrue(actualWithAllocationsResult.measurableRating() instanceof ImmutableMeasurableRating);
    assertTrue(
        actualWithAllocationsResult.decommission()
            instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertTrue(actualWithAllocationsResult.rating() instanceof ImmutableRatingSchemeItem);
    assertEquals(1, actualWithAllocationsResult.allocations().size());
    assertTrue(actualWithAllocationsResult.allocationSchemes().isEmpty());
    assertTrue(actualWithAllocationsResult.replacements().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#withCategory(MeasurableCategory)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#withCategory(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test withCategory(MeasurableCategory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.withCategory(MeasurableCategory)"
  })
  void testWithCategory() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingView actualWithCategoryResult =
        immutableMeasurableRatingView.withCategory(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingView, actualWithCategoryResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingView#withDecommission(MeasurableRatingPlannedDecommission)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingView#withDecommission(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName("Test withDecommission(MeasurableRatingPlannedDecommission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.withDecommission(MeasurableRatingPlannedDecommission)"
  })
  void testWithDecommission() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingView actualWithDecommissionResult =
        immutableMeasurableRatingView.withDecommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingView, actualWithDecommissionResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#withMeasurable(Measurable)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#withMeasurable(Measurable)}
   */
  @Test
  @DisplayName("Test withMeasurable(Measurable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.withMeasurable(Measurable)"
  })
  void testWithMeasurable() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingView actualWithMeasurableResult =
        immutableMeasurableRatingView.withMeasurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingView, actualWithMeasurableResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#withMeasurableRating(MeasurableRating)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingView#withMeasurableRating(MeasurableRating)}
   */
  @Test
  @DisplayName("Test withMeasurableRating(MeasurableRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.withMeasurableRating(MeasurableRating)"
  })
  void testWithMeasurableRating() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableMeasurableRatingView actualWithMeasurableRatingResult =
        immutableMeasurableRatingView.withMeasurableRating(
            descriptionResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingView, actualWithMeasurableRatingResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#withRating(RatingSchemeItem)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingView#withRating(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test withRating(RatingSchemeItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.withRating(RatingSchemeItem)"
  })
  void testWithRating() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingView actualWithRatingResult =
        immutableMeasurableRatingView.withRating(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingView, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingView#withReplacements(MeasurableRatingReplacement[])} with
   * {@code MeasurableRatingReplacement[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingView#withReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  @DisplayName(
      "Test withReplacements(MeasurableRatingReplacement[]) with 'MeasurableRatingReplacement[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingView ImmutableMeasurableRatingView.withReplacements(MeasurableRatingReplacement[])"
  })
  void testWithReplacementsWithMeasurableRatingReplacement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    Builder categoryResult =
        builderResult.category(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    Builder decommissionResult =
        categoryResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder measurableResult =
        decommissionResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    Builder measurableRatingResult =
        measurableResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    ImmutableMeasurableRatingView immutableMeasurableRatingView =
        measurableRatingResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableMeasurableRatingView actualWithReplacementsResult =
        immutableMeasurableRatingView.withReplacements(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());

    // Assert
    assertTrue(actualWithReplacementsResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualWithReplacementsResult.category() instanceof ImmutableMeasurableCategory);
    assertTrue(
        actualWithReplacementsResult.measurableRating() instanceof ImmutableMeasurableRating);
    assertTrue(
        actualWithReplacementsResult.decommission()
            instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertTrue(actualWithReplacementsResult.rating() instanceof ImmutableRatingSchemeItem);
    assertEquals(1, actualWithReplacementsResult.replacements().size());
    assertTrue(actualWithReplacementsResult.allocationSchemes().isEmpty());
    assertTrue(actualWithReplacementsResult.allocations().isEmpty());
  }
}
