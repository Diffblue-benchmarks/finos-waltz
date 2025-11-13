package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView.Builder;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView.Json;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchy;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable.MeasurableHierarchy;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllMeasurableCategories(Iterable)}.
   *
   * <ul>
   *   <li>Then return build measurableCategories Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllMeasurableCategories(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllMeasurableCategories(Iterable); then return build measurableCategories Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllMeasurableCategories(Iterable)"})
  void testBuilderAddAllMeasurableCategories_thenReturnBuildMeasurableCategoriesEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        builderResult.addAllMeasurableCategories(new ArrayList<>()).build();
    Set<MeasurableCategory> measurableCategoriesResult =
        immutableMeasurableRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, immutableMeasurableRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, immutableMeasurableRatingsView.measurableRatings());
    assertSame(measurableCategoriesResult, immutableMeasurableRatingsView.measurables());
    assertSame(measurableCategoriesResult, immutableMeasurableRatingsView.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#addMeasurableCategories(MeasurableCategory)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addMeasurableCategories(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder addMeasurableCategories(MeasurableCategory) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableCategories(MeasurableCategory)"})
  void testBuilderAddMeasurableCategoriesWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableCategoriesResult =
        builderResult.addMeasurableCategories(
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
    assertEquals(1, builderResult.build().measurableCategories().size());
    assertSame(builderResult, actualAddMeasurableCategoriesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableCategories(MeasurableCategory[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addMeasurableCategories(MeasurableCategory[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurableCategories(MeasurableCategory[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableCategories(MeasurableCategory[])"})
  void testBuilderAddMeasurableCategoriesWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableCategoriesResult =
        builderResult.addMeasurableCategories(
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
    assertEquals(1, builderResult.build().measurableCategories().size());
    assertSame(builderResult, actualAddMeasurableCategoriesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableHierarchy(MeasurableHierarchy)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addMeasurableHierarchy(MeasurableHierarchy)}
   */
  @Test
  @DisplayName("Test Builder addMeasurableHierarchy(MeasurableHierarchy) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableHierarchy(MeasurableHierarchy)"})
  void testBuilderAddMeasurableHierarchyWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableHierarchyResult =
        builderResult.addMeasurableHierarchy(
            ImmutableMeasurableHierarchy.builder().measurableId(1L).build());

    // Assert
    assertEquals(1, builderResult.build().measurableHierarchy().size());
    assertSame(builderResult, actualAddMeasurableHierarchyResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableHierarchy(MeasurableHierarchy[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addMeasurableHierarchy(MeasurableHierarchy[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurableHierarchy(MeasurableHierarchy[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableHierarchy(MeasurableHierarchy[])"})
  void testBuilderAddMeasurableHierarchyWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableHierarchyResult =
        builderResult.addMeasurableHierarchy(
            ImmutableMeasurableHierarchy.builder().measurableId(1L).build());

    // Assert
    assertEquals(1, builderResult.build().measurableHierarchy().size());
    assertSame(builderResult, actualAddMeasurableHierarchyResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableRatings(MeasurableRating)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addMeasurableRatings(MeasurableRating)}
   */
  @Test
  @DisplayName("Test Builder addMeasurableRatings(MeasurableRating) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableRatings(MeasurableRating)"})
  void testBuilderAddMeasurableRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act
    Builder actualAddMeasurableRatingsResult =
        builderResult.addMeasurableRatings(
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

    // Assert
    assertEquals(1, builderResult.build().measurableRatings().size());
    assertSame(builderResult, actualAddMeasurableRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableRatings(MeasurableRating[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addMeasurableRatings(MeasurableRating[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurableRatings(MeasurableRating[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableRatings(MeasurableRating[])"})
  void testBuilderAddMeasurableRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act
    Builder actualAddMeasurableRatingsResult =
        builderResult.addMeasurableRatings(
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

    // Assert
    assertEquals(1, builderResult.build().measurableRatings().size());
    assertSame(builderResult, actualAddMeasurableRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurables(Measurable)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMeasurables(Measurable)}
   */
  @Test
  @DisplayName(
      "Test Builder addMeasurables(Measurable) with 'element'; then builder build measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurables(Measurable)"})
  void testBuilderAddMeasurablesWithElement_thenBuilderBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurablesResult =
        builderResult.addMeasurables(
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
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurables(Measurable[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMeasurables(Measurable[])}
   */
  @Test
  @DisplayName(
      "Test Builder addMeasurables(Measurable[]) with 'elements'; then builder build measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurables(Measurable[])"})
  void testBuilderAddMeasurablesWithElements_thenBuilderBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurablesResult =
        builderResult.addMeasurables(
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
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem)"})
  void testBuilderAddRatingSchemeItemsWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
        builderResult.addRatingSchemeItems(
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
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem[])"})
  void testBuilderAddRatingSchemeItemsWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
        builderResult.addRatingSchemeItems(
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
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableMeasurableRatingsView.builder().build().measurableCategories().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingsView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingsView); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingsView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualFromResult = builderResult.from(ImmutableMeasurableRatingsView.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableCategories(Iterable)}.
   *
   * <ul>
   *   <li>Then return build measurableCategories Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableCategories(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder measurableCategories(Iterable); then return build measurableCategories Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableCategories(Iterable)"})
  void testBuilderMeasurableCategories_thenReturnBuildMeasurableCategoriesEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        builderResult.measurableCategories(new ArrayList<>()).build();
    Set<MeasurableCategory> measurableCategoriesResult =
        immutableMeasurableRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, immutableMeasurableRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, immutableMeasurableRatingsView.measurableRatings());
    assertSame(measurableCategoriesResult, immutableMeasurableRatingsView.measurables());
    assertSame(measurableCategoriesResult, immutableMeasurableRatingsView.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return measurableCategories Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingsView); when builder build; then return measurableCategories Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.copyOf(MeasurableRatingsView)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnMeasurableCategoriesEmpty() {
    // Arrange
    ImmutableMeasurableRatingsView instance = ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult =
        ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    Set<MeasurableCategory> measurableCategoriesResult = actualCopyOfResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurables());
    assertSame(measurableCategoriesResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}, and {@link
   * ImmutableMeasurableRatingsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingsView#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        ImmutableMeasurableRatingsView.builder().build();
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView2 =
        ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingsView, immutableMeasurableRatingsView2);
    assertEquals(
        immutableMeasurableRatingsView.hashCode(), immutableMeasurableRatingsView2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}, and {@link
   * ImmutableMeasurableRatingsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingsView#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingsView, immutableMeasurableRatingsView);
    int expectedHashCodeResult = immutableMeasurableRatingsView.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingsView.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addMeasurableCategories(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableMeasurableRatingsView.builder().build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addMeasurables(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableMeasurableRatingsView.builder().build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    builderResult.addMeasurableRatings(
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
    assertNotEquals(builderResult.build(), ImmutableMeasurableRatingsView.builder().build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addRatingSchemeItems(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableMeasurableRatingsView.builder().build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addMeasurableHierarchy(
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableMeasurableRatingsView.builder().build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableMeasurableRatingsView.builder().build(), null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingsView.equals(Object)",
    "int ImmutableMeasurableRatingsView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingsView.builder().build(),
        "Different type to ImmutableMeasurableRatingsView");
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return measurableCategories size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return measurableCategories size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"
  })
  void testFromJson_thenReturnMeasurableCategoriesSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableCategory> measurableCategories = new LinkedHashSet<>();
    measurableCategories.add(
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

    LinkedHashSet<Measurable> measurables = new LinkedHashSet<>();
    measurables.add(
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

    LinkedHashSet<MeasurableRating> measurableRatings = new LinkedHashSet<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatings.add(
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

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    LinkedHashSet<MeasurableHierarchy> measurableHierarchy = new LinkedHashSet<>();
    measurableHierarchy.add(ImmutableMeasurableHierarchy.builder().measurableId(1L).build());

    Json json = new Json();
    json.setMeasurableCategories(measurableCategories);
    json.setMeasurables(measurables);
    json.setMeasurableRatings(measurableRatings);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setMeasurableHierarchy(measurableHierarchy);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult =
        ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableCategories().size());
    assertEquals(1, actualFromJsonResult.measurableHierarchy().size());
    assertEquals(1, actualFromJsonResult.measurableRatings().size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return measurableCategories size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return measurableCategories size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"
  })
  void testFromJson_thenReturnMeasurableCategoriesSizeIsTwo() {
    // Arrange
    LinkedHashSet<MeasurableCategory> measurableCategories = new LinkedHashSet<>();
    measurableCategories.add(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(false)
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
    measurableCategories.add(
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

    LinkedHashSet<Measurable> measurables = new LinkedHashSet<>();
    measurables.add(
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

    LinkedHashSet<MeasurableRating> measurableRatings = new LinkedHashSet<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatings.add(
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

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    LinkedHashSet<MeasurableHierarchy> measurableHierarchy = new LinkedHashSet<>();
    measurableHierarchy.add(ImmutableMeasurableHierarchy.builder().measurableId(1L).build());

    Json json = new Json();
    json.setMeasurableCategories(measurableCategories);
    json.setMeasurables(measurables);
    json.setMeasurableRatings(measurableRatings);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setMeasurableHierarchy(measurableHierarchy);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult =
        ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableHierarchy().size());
    assertEquals(1, actualFromJsonResult.measurableRatings().size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertEquals(2, actualFromJsonResult.measurableCategories().size());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return measurableHierarchy Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return measurableHierarchy Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"
  })
  void testFromJson_thenReturnMeasurableHierarchyEmpty() {
    // Arrange
    LinkedHashSet<MeasurableCategory> measurableCategories = new LinkedHashSet<>();
    measurableCategories.add(
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

    LinkedHashSet<Measurable> measurables = new LinkedHashSet<>();
    measurables.add(
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

    LinkedHashSet<MeasurableRating> measurableRatings = new LinkedHashSet<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatings.add(
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

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    Json json = new Json();
    json.setMeasurableCategories(measurableCategories);
    json.setMeasurables(measurables);
    json.setMeasurableRatings(measurableRatings);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setMeasurableHierarchy(null);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult =
        ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableCategories().size());
    assertEquals(1, actualFromJsonResult.measurableRatings().size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertTrue(actualFromJsonResult.measurableHierarchy().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) MeasurableRatings is {@code null}.
   *   <li>Then return measurableRatings Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) MeasurableRatings is 'null'; then return measurableRatings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"
  })
  void testFromJson_whenJsonMeasurableRatingsIsNull_thenReturnMeasurableRatingsEmpty() {
    // Arrange
    LinkedHashSet<MeasurableCategory> measurableCategories = new LinkedHashSet<>();
    measurableCategories.add(
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

    LinkedHashSet<Measurable> measurables = new LinkedHashSet<>();
    measurables.add(
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

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    LinkedHashSet<MeasurableHierarchy> measurableHierarchy = new LinkedHashSet<>();
    measurableHierarchy.add(ImmutableMeasurableHierarchy.builder().measurableId(1L).build());

    Json json = new Json();
    json.setMeasurableCategories(measurableCategories);
    json.setMeasurables(measurables);
    json.setMeasurableRatings(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setMeasurableHierarchy(measurableHierarchy);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult =
        ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableCategories().size());
    assertEquals(1, actualFromJsonResult.measurableHierarchy().size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertTrue(actualFromJsonResult.measurableRatings().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) RatingSchemeItems is {@code null}.
   *   <li>Then return ratingSchemeItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) RatingSchemeItems is 'null'; then return ratingSchemeItems Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"
  })
  void testFromJson_whenJsonRatingSchemeItemsIsNull_thenReturnRatingSchemeItemsEmpty() {
    // Arrange
    LinkedHashSet<MeasurableCategory> measurableCategories = new LinkedHashSet<>();
    measurableCategories.add(
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

    LinkedHashSet<Measurable> measurables = new LinkedHashSet<>();
    measurables.add(
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

    LinkedHashSet<MeasurableRating> measurableRatings = new LinkedHashSet<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatings.add(
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

    LinkedHashSet<MeasurableHierarchy> measurableHierarchy = new LinkedHashSet<>();
    measurableHierarchy.add(ImmutableMeasurableHierarchy.builder().measurableId(1L).build());

    Json json = new Json();
    json.setMeasurableCategories(measurableCategories);
    json.setMeasurables(measurables);
    json.setMeasurableRatings(measurableRatings);
    json.setRatingSchemeItems(null);
    json.setMeasurableHierarchy(measurableHierarchy);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult =
        ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableCategories().size());
    assertEquals(1, actualFromJsonResult.measurableHierarchy().size());
    assertEquals(1, actualFromJsonResult.measurableRatings().size());
    assertTrue(actualFromJsonResult.ratingSchemeItems().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return measurableCategories Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return measurableCategories Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnMeasurableCategoriesEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult =
        ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.measurableCategories().isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurableHierarchy());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurableRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurables());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingsView#toString()}
   *   <li>{@link ImmutableMeasurableRatingsView#measurableCategories()}
   *   <li>{@link ImmutableMeasurableRatingsView#measurableHierarchy()}
   *   <li>{@link ImmutableMeasurableRatingsView#measurableRatings()}
   *   <li>{@link ImmutableMeasurableRatingsView#measurables()}
   *   <li>{@link ImmutableMeasurableRatingsView#ratingSchemeItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableMeasurableRatingsView.measurableCategories()",
    "Set ImmutableMeasurableRatingsView.measurableHierarchy()",
    "Set ImmutableMeasurableRatingsView.measurableRatings()",
    "Set ImmutableMeasurableRatingsView.measurables()",
    "Set ImmutableMeasurableRatingsView.ratingSchemeItems()",
    "String ImmutableMeasurableRatingsView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        ImmutableMeasurableRatingsView.builder().build();

    // Act
    String actualToStringResult = immutableMeasurableRatingsView.toString();
    Set<MeasurableCategory> actualMeasurableCategoriesResult =
        immutableMeasurableRatingsView.measurableCategories();
    Set<MeasurableHierarchy> actualMeasurableHierarchyResult =
        immutableMeasurableRatingsView.measurableHierarchy();
    Set<MeasurableRating> actualMeasurableRatingsResult =
        immutableMeasurableRatingsView.measurableRatings();
    Set<Measurable> actualMeasurablesResult = immutableMeasurableRatingsView.measurables();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult =
        immutableMeasurableRatingsView.ratingSchemeItems();

    // Assert
    assertEquals(
        "MeasurableRatingsView{measurableCategories=[], measurables=[], measurableRatings=[], ratingSchemeItems=[],"
            + " measurableHierarchy=[]}",
        actualToStringResult);
    assertTrue(actualMeasurableCategoriesResult.isEmpty());
    assertSame(actualMeasurableCategoriesResult, actualMeasurableHierarchyResult);
    assertSame(actualMeasurableCategoriesResult, actualMeasurableRatingsResult);
    assertSame(actualMeasurableCategoriesResult, actualMeasurablesResult);
    assertSame(actualMeasurableCategoriesResult, actualRatingSchemeItemsResult);
  }

  /**
   * Test Json {@link Json#measurableCategories()}.
   *
   * <p>Method under test: {@link Json#measurableCategories()}
   */
  @Test
  @DisplayName("Test Json measurableCategories()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.measurableCategories()"})
  void testJsonMeasurableCategories() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableCategories());
  }

  /**
   * Test Json {@link Json#measurableHierarchy()}.
   *
   * <p>Method under test: {@link Json#measurableHierarchy()}
   */
  @Test
  @DisplayName("Test Json measurableHierarchy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.measurableHierarchy()"})
  void testJsonMeasurableHierarchy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableHierarchy());
  }

  /**
   * Test Json {@link Json#measurableRatings()}.
   *
   * <p>Method under test: {@link Json#measurableRatings()}
   */
  @Test
  @DisplayName("Test Json measurableRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.measurableRatings()"})
  void testJsonMeasurableRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableRatings());
  }

  /**
   * Test Json {@link Json#measurables()}.
   *
   * <p>Method under test: {@link Json#measurables()}
   */
  @Test
  @DisplayName("Test Json measurables()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.measurables()"})
  void testJsonMeasurables() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurables());
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
    assertTrue(actualJson.measurableCategories.isEmpty());
    assertTrue(actualJson.measurableHierarchy.isEmpty());
    assertTrue(actualJson.measurableRatings.isEmpty());
    assertTrue(actualJson.measurables.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingSchemeItems()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeItems()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ratingSchemeItems()"})
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withMeasurableCategories(MeasurableCategory[])} with
   * {@code MeasurableCategory[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingsView#withMeasurableCategories(MeasurableCategory[])}
   */
  @Test
  @DisplayName("Test withMeasurableCategories(MeasurableCategory[]) with 'MeasurableCategory[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withMeasurableCategories(MeasurableCategory[])"
  })
  void testWithMeasurableCategoriesWithMeasurableCategory() {
    // Arrange
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithMeasurableCategoriesResult =
        immutableMeasurableRatingsView.withMeasurableCategories(
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
    assertEquals(1, actualWithMeasurableCategoriesResult.measurableCategories().size());
    Set<MeasurableHierarchy> measurableHierarchyResult =
        actualWithMeasurableCategoriesResult.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertSame(measurableHierarchyResult, actualWithMeasurableCategoriesResult.measurableRatings());
    assertSame(measurableHierarchyResult, actualWithMeasurableCategoriesResult.measurables());
    assertSame(measurableHierarchyResult, actualWithMeasurableCategoriesResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withMeasurableHierarchy(MeasurableHierarchy[])} with
   * {@code MeasurableHierarchy[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingsView#withMeasurableHierarchy(MeasurableHierarchy[])}
   */
  @Test
  @DisplayName("Test withMeasurableHierarchy(MeasurableHierarchy[]) with 'MeasurableHierarchy[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withMeasurableHierarchy(MeasurableHierarchy[])"
  })
  void testWithMeasurableHierarchyWithMeasurableHierarchy() {
    // Arrange
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithMeasurableHierarchyResult =
        immutableMeasurableRatingsView.withMeasurableHierarchy(
            ImmutableMeasurableHierarchy.builder().measurableId(1L).build());

    // Assert
    assertEquals(1, actualWithMeasurableHierarchyResult.measurableHierarchy().size());
    Set<MeasurableCategory> measurableCategoriesResult =
        actualWithMeasurableHierarchyResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualWithMeasurableHierarchyResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualWithMeasurableHierarchyResult.measurables());
    assertSame(measurableCategoriesResult, actualWithMeasurableHierarchyResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withMeasurableRatings(MeasurableRating[])} with
   * {@code MeasurableRating[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingsView#withMeasurableRatings(MeasurableRating[])}
   */
  @Test
  @DisplayName("Test withMeasurableRatings(MeasurableRating[]) with 'MeasurableRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withMeasurableRatings(MeasurableRating[])"
  })
  void testWithMeasurableRatingsWithMeasurableRating() {
    // Arrange
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        ImmutableMeasurableRatingsView.builder().build();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableMeasurableRatingsView actualWithMeasurableRatingsResult =
        immutableMeasurableRatingsView.withMeasurableRatings(
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

    // Assert
    assertEquals(1, actualWithMeasurableRatingsResult.measurableRatings().size());
    Set<MeasurableCategory> measurableCategoriesResult =
        actualWithMeasurableRatingsResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualWithMeasurableRatingsResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualWithMeasurableRatingsResult.measurables());
    assertSame(measurableCategoriesResult, actualWithMeasurableRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withMeasurables(Measurable[])} with {@code
   * Measurable[]}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingsView#withMeasurables(Measurable[])}
   */
  @Test
  @DisplayName("Test withMeasurables(Measurable[]) with 'Measurable[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withMeasurables(Measurable[])"
  })
  void testWithMeasurablesWithMeasurable() {
    // Arrange
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithMeasurablesResult =
        immutableMeasurableRatingsView.withMeasurables(
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
    assertEquals(1, actualWithMeasurablesResult.measurables().size());
    Set<MeasurableCategory> measurableCategoriesResult =
        actualWithMeasurablesResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualWithMeasurablesResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualWithMeasurablesResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualWithMeasurablesResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withRatingSchemeItems(RatingSchemeItem[])} with
   * {@code RatingSchemeItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingsView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withRatingSchemeItems(RatingSchemeItem[])"
  })
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableMeasurableRatingsView immutableMeasurableRatingsView =
        ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithRatingSchemeItemsResult =
        immutableMeasurableRatingsView.withRatingSchemeItems(
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
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    Set<MeasurableCategory> measurableCategoriesResult =
        actualWithRatingSchemeItemsResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualWithRatingSchemeItemsResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualWithRatingSchemeItemsResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualWithRatingSchemeItemsResult.measurables());
  }
}
