package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.ImmutableAssessmentsView.Builder;
import org.finos.waltz.model.application.ImmutableAssessmentsView.Json;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessmentDefinitions(Iterable)"})
  void testBuilderAddAllAssessmentDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAllAssessmentDefinitionsResult =
        builderResult.addAllAssessmentDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllAssessmentRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentRatings(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessmentRatings(Iterable)"})
  void testBuilderAddAllAssessmentRatings_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAllAssessmentRatingsResult =
        builderResult.addAllAssessmentRatings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRatingSchemeItems(Iterable)}.
   *
   * <ul>
   *   <li>Then return build ratingSchemeItemsById Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRatingSchemeItems(Iterable); then return build ratingSchemeItemsById Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingSchemeItems(Iterable)"})
  void testBuilderAddAllRatingSchemeItems_thenReturnBuildRatingSchemeItemsByIdEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertTrue(
        builderResult
            .addAllRatingSchemeItems(new ArrayList<>())
            .build()
            .ratingSchemeItemsById()
            .isEmpty());
    assertTrue(builderResult.build().ratingSchemeItemsById().isEmpty());
  }

  /**
   * Test Builder {@link Builder#addAssessmentDefinitions(AssessmentDefinition)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAssessmentDefinitionsResult =
        builderResult.addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentDefinitions(AssessmentDefinition[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentDefinitions(AssessmentDefinition[])"})
  void testBuilderAddAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAssessmentDefinitionsResult =
        builderResult.addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentRating)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addAssessmentRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentRatings(AssessmentRating) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentRating)"})
  void testBuilderAddAssessmentRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAssessmentRatingsResult =
        builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentRating[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentRatings(AssessmentRating[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentRating[])"})
  void testBuilderAddAssessmentRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAssessmentRatingsResult =
        builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
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
    Builder builderResult = ImmutableAssessmentsView.builder();
    RatingSchemeItem element = mock(RatingSchemeItem.class);

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(element);

    // Assert
    ImmutableAssessmentsView immutableAssessmentsView = builderResult.build();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        immutableAssessmentsView.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, immutableAssessmentsView.ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
    assertSame(element, ratingSchemeItemsByIdResult.get(null));
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
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
        builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    ImmutableAssessmentsView immutableAssessmentsView = builderResult.build();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        immutableAssessmentsView.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, immutableAssessmentsView.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(null));
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentDefinitions(Iterable)"})
  void testBuilderAssessmentDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAssessmentDefinitionsResult =
        builderResult.assessmentDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentRatings(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentRatings(Iterable)"})
  void testBuilderAssessmentRatings_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAssessmentRatingsResult = builderResult.assessmentRatings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentRatingsResult);
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
  @MethodsUnderTest({"ImmutableAssessmentsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentsView actualImmutableAssessmentsView =
        ImmutableAssessmentsView.builder().build();

    // Assert
    assertTrue(actualImmutableAssessmentsView.ratingSchemeItemsById().isEmpty());
    assertTrue(actualImmutableAssessmentsView.assessmentDefinitions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentsView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentsView); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentsView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualFromResult = builderResult.from(ImmutableAssessmentsView.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeItems(Iterable)}.
   *
   * <ul>
   *   <li>Then return build ratingSchemeItemsById Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder ratingSchemeItems(Iterable); then return build ratingSchemeItemsById Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeItems(Iterable)"})
  void testBuilderRatingSchemeItems_thenReturnBuildRatingSchemeItemsByIdEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertTrue(
        builderResult
            .ratingSchemeItems(new ArrayList<>())
            .build()
            .ratingSchemeItemsById()
            .isEmpty());
    assertTrue(builderResult.build().ratingSchemeItemsById().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return ratingSchemeItemsById Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentsView); when builder build; then return ratingSchemeItemsById Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.copyOf(AssessmentsView)"})
  void testCopyOf_whenBuilderBuild_thenReturnRatingSchemeItemsByIdEmpty() {
    // Arrange
    ImmutableAssessmentsView instance = ImmutableAssessmentsView.builder().build();

    // Act
    ImmutableAssessmentsView actualCopyOfResult = ImmutableAssessmentsView.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}, and {@link
   * ImmutableAssessmentsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentsView#equals(Object)}
   *   <li>{@link ImmutableAssessmentsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentsView.equals(Object)",
    "int ImmutableAssessmentsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentsView immutableAssessmentsView = ImmutableAssessmentsView.builder().build();
    ImmutableAssessmentsView immutableAssessmentsView2 = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertEquals(immutableAssessmentsView, immutableAssessmentsView2);
    assertEquals(immutableAssessmentsView.hashCode(), immutableAssessmentsView2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}, and {@link
   * ImmutableAssessmentsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentsView#equals(Object)}
   *   <li>{@link ImmutableAssessmentsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentsView.equals(Object)",
    "int ImmutableAssessmentsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentsView immutableAssessmentsView = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertEquals(immutableAssessmentsView, immutableAssessmentsView);
    int expectedHashCodeResult = immutableAssessmentsView.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentsView.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentsView.equals(Object)",
    "int ImmutableAssessmentsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    builderResult.addAssessmentRatings(
        commentResult
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAssessmentsView.builder().build());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentsView.equals(Object)",
    "int ImmutableAssessmentsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
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
    assertNotEquals(builderResult.build(), ImmutableAssessmentsView.builder().build());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentsView.equals(Object)",
    "int ImmutableAssessmentsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    builderResult.addAssessmentDefinitions(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAssessmentsView.builder().build());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentsView.equals(Object)",
    "int ImmutableAssessmentsView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAssessmentsView.builder().build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentsView.equals(Object)",
    "int ImmutableAssessmentsView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentsView.builder().build(), "Different type to ImmutableAssessmentsView");
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then ratingSchemeItemsById one return {@link ImmutableRatingSchemeItem}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then ratingSchemeItemsById one return ImmutableRatingSchemeItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.fromJson(Json)"})
  void testFromJson_thenRatingSchemeItemsByIdOneReturnImmutableRatingSchemeItem() {
    // Arrange
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
    json.setAssessmentRatings(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setAssessmentDefinitions(null);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        actualFromJsonResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentDefinitions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.fromJson(Json)"})
  void testFromJson_thenReturnAssessmentDefinitionsSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentDefinition> assessmentDefinitions = new LinkedHashSet<>();
    assessmentDefinitions.add(mock(AssessmentDefinition.class));

    Json json = new Json();
    json.setAssessmentRatings(null);
    json.setRatingSchemeItems(null);
    json.setAssessmentDefinitions(assessmentDefinitions);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentDefinitions().size());
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentRatings size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentRatings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.fromJson(Json)"})
  void testFromJson_thenReturnAssessmentRatingsSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentRating> assessmentRatings = new LinkedHashSet<>();
    assessmentRatings.add(mock(AssessmentRating.class));

    Json json = new Json();
    json.setAssessmentRatings(assessmentRatings);
    json.setRatingSchemeItems(null);
    json.setAssessmentDefinitions(null);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentRatings().size());
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItemsById containsKey one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItemsById containsKey one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.fromJson(Json)"})
  void testFromJson_thenReturnRatingSchemeItemsByIdContainsKeyOne() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);

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
    ratingSchemeItems.add(ratingSchemeItem);

    Json json = new Json();
    json.setAssessmentRatings(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setAssessmentDefinitions(null);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    verify(ratingSchemeItem).id();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        actualFromJsonResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    assertEquals(ratingSchemeItems, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItemsById Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItemsById Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.fromJson(Json)"})
  void testFromJson_thenReturnRatingSchemeItemsByIdEmpty() {
    // Arrange
    Json json = new Json();
    json.setAssessmentRatings(null);
    json.setRatingSchemeItems(null);
    json.setAssessmentDefinitions(null);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return assessmentRatings is {@link Json} (default constructor) {@link
   *       Json#ratingSchemeItems}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return assessmentRatings is Json (default constructor) ratingSchemeItems")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnAssessmentRatingsIsJsonRatingSchemeItems() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, actualFromJsonResult.assessmentRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentsView#toString()}
   *   <li>{@link ImmutableAssessmentsView#assessmentDefinitions()}
   *   <li>{@link ImmutableAssessmentsView#assessmentRatings()}
   *   <li>{@link ImmutableAssessmentsView#ratingSchemeItems()}
   *   <li>{@link ImmutableAssessmentsView#ratingSchemeItemsById()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAssessmentsView.assessmentDefinitions()",
    "Set ImmutableAssessmentsView.assessmentRatings()",
    "Set ImmutableAssessmentsView.ratingSchemeItems()",
    "Map ImmutableAssessmentsView.ratingSchemeItemsById()",
    "String ImmutableAssessmentsView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentsView immutableAssessmentsView = ImmutableAssessmentsView.builder().build();

    // Act
    String actualToStringResult = immutableAssessmentsView.toString();
    Set<AssessmentDefinition> actualAssessmentDefinitionsResult =
        immutableAssessmentsView.assessmentDefinitions();
    Set<AssessmentRating> actualAssessmentRatingsResult =
        immutableAssessmentsView.assessmentRatings();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult =
        immutableAssessmentsView.ratingSchemeItems();

    // Assert
    assertEquals(
        "AssessmentsView{assessmentRatings=[], ratingSchemeItems=[], assessmentDefinitions=[], ratingSchemeItemsById"
            + "={}}",
        actualToStringResult);
    assertTrue(immutableAssessmentsView.ratingSchemeItemsById().isEmpty());
    assertTrue(actualAssessmentDefinitionsResult.isEmpty());
    assertSame(actualAssessmentDefinitionsResult, actualAssessmentRatingsResult);
    assertSame(actualAssessmentDefinitionsResult, actualRatingSchemeItemsResult);
  }

  /**
   * Test Json {@link Json#assessmentDefinitions()}.
   *
   * <p>Method under test: {@link Json#assessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.assessmentDefinitions()"})
  void testJsonAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentDefinitions());
  }

  /**
   * Test Json {@link Json#assessmentRatings()}.
   *
   * <p>Method under test: {@link Json#assessmentRatings()}
   */
  @Test
  @DisplayName("Test Json assessmentRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.assessmentRatings()"})
  void testJsonAssessmentRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentRatings());
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
    assertTrue(actualJson.assessmentDefinitions.isEmpty());
    assertTrue(actualJson.assessmentRatings.isEmpty());
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
   * Test Json {@link Json#ratingSchemeItemsById()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeItemsById()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItemsById()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Json.ratingSchemeItemsById()"})
  void testJsonRatingSchemeItemsById() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeItemsById());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])} with
   * {@code AssessmentDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testWithAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableAssessmentsView immutableAssessmentsView = ImmutableAssessmentsView.builder().build();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    ImmutableAssessmentsView actualWithAssessmentDefinitionsResult =
        immutableAssessmentsView.withAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, actualWithAssessmentDefinitionsResult.assessmentDefinitions().size());
    assertTrue(actualWithAssessmentDefinitionsResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentRating> assessmentRatingsResult =
        actualWithAssessmentDefinitionsResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])} with
   * {@code AssessmentDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testWithAssessmentDefinitionsWithAssessmentDefinition2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
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
    ImmutableAssessmentsView immutableAssessmentsView = builderResult.build();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    ImmutableAssessmentsView actualWithAssessmentDefinitionsResult =
        immutableAssessmentsView.withAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        actualWithAssessmentDefinitionsResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1, actualWithAssessmentDefinitionsResult.ratingSchemeItems().size());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])} with
   * {@code AssessmentDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testWithAssessmentDefinitionsWithAssessmentDefinition3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
    builderResult.addRatingSchemeItems(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
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
    ImmutableAssessmentsView immutableAssessmentsView = builderResult.build();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    ImmutableAssessmentsView actualWithAssessmentDefinitionsResult =
        immutableAssessmentsView.withAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        actualWithAssessmentDefinitionsResult.ratingSchemeItemsById();
    assertEquals(2, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(2L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertEquals(2, actualWithAssessmentDefinitionsResult.ratingSchemeItems().size());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])} with {@code
   * AssessmentRating[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withAssessmentRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentRatings(AssessmentRating[])"
  })
  void testWithAssessmentRatingsWithAssessmentRating() {
    // Arrange
    ImmutableAssessmentsView immutableAssessmentsView = ImmutableAssessmentsView.builder().build();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableAssessmentsView actualWithAssessmentRatingsResult =
        immutableAssessmentsView.withAssessmentRatings(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Assert
    assertEquals(1, actualWithAssessmentRatingsResult.assessmentRatings().size());
    assertTrue(actualWithAssessmentRatingsResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualWithAssessmentRatingsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithAssessmentRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])} with {@code
   * AssessmentRating[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withAssessmentRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentRatings(AssessmentRating[])"
  })
  void testWithAssessmentRatingsWithAssessmentRating2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
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
    ImmutableAssessmentsView immutableAssessmentsView = builderResult.build();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableAssessmentsView actualWithAssessmentRatingsResult =
        immutableAssessmentsView.withAssessmentRatings(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Assert
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        actualWithAssessmentRatingsResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1, actualWithAssessmentRatingsResult.ratingSchemeItems().size());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])} with {@code
   * AssessmentRating[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withAssessmentRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentRatings(AssessmentRating[])"
  })
  void testWithAssessmentRatingsWithAssessmentRating3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
    builderResult.addRatingSchemeItems(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
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
    ImmutableAssessmentsView immutableAssessmentsView = builderResult.build();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableAssessmentsView actualWithAssessmentRatingsResult =
        immutableAssessmentsView.withAssessmentRatings(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Assert
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        actualWithAssessmentRatingsResult.ratingSchemeItemsById();
    assertEquals(2, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(2L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertEquals(2, actualWithAssessmentRatingsResult.ratingSchemeItems().size());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withRatingSchemeItems(RatingSchemeItem[])} with {@code
   * RatingSchemeItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentsView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentsView ImmutableAssessmentsView.withRatingSchemeItems(RatingSchemeItem[])"
  })
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableAssessmentsView immutableAssessmentsView = ImmutableAssessmentsView.builder().build();

    // Act
    ImmutableAssessmentsView actualWithRatingSchemeItemsResult =
        immutableAssessmentsView.withRatingSchemeItems(
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
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        actualWithRatingSchemeItemsResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualWithRatingSchemeItemsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertTrue(getResult.userSelectable());
    assertSame(assessmentDefinitionsResult, actualWithRatingSchemeItemsResult.assessmentRatings());
  }
}
