package org.finos.waltz.model.change_initiative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiativeView.Builder;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiativeView.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeInitiativeViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>Then return build assessmentDefinitions Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentDefinitions(Iterable); then return build assessmentDefinitions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessmentDefinitions(Iterable)"})
  void testBuilderAddAllAssessmentDefinitions_thenReturnBuildAssessmentDefinitionsEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        builderResult.addAllAssessmentDefinitions(new ArrayList<>()).build();
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        immutableChangeInitiativeView.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, immutableChangeInitiativeView.changeInitiatives());
    assertSame(assessmentDefinitionsResult, immutableChangeInitiativeView.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, immutableChangeInitiativeView.ratings());
  }

  /**
   * Test Builder {@link Builder#addAllChangeInitiatives(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangeInitiatives(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllChangeInitiatives(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangeInitiatives(Iterable)"})
  void testBuilderAddAllChangeInitiatives_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddAllChangeInitiativesResult =
        builderResult.addAllChangeInitiatives(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#addAllRatingSchemeItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRatingSchemeItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingSchemeItems(Iterable)"})
  void testBuilderAddAllRatingSchemeItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddAllRatingSchemeItemsResult =
        builderResult.addAllRatingSchemeItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatings(Iterable)"})
  void testBuilderAddAllRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddAllRatingsResult = builderResult.addAllRatings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingsResult);
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
    Builder builderResult = ImmutableChangeInitiativeView.builder();

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
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddAssessmentDefinitionsResult =
        builderResult.addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addChangeInitiatives(ChangeInitiative)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addChangeInitiatives(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiatives(ChangeInitiative) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangeInitiatives(ChangeInitiative)"})
  void testBuilderAddChangeInitiativesWithElement() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddChangeInitiativesResult =
        builderResult.addChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#addChangeInitiatives(ChangeInitiative[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addChangeInitiatives(ChangeInitiative[])}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiatives(ChangeInitiative[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangeInitiatives(ChangeInitiative[])"})
  void testBuilderAddChangeInitiativesWithElements() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddChangeInitiativesResult =
        builderResult.addChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualAddChangeInitiativesResult);
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
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
        builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

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
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
        builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(AssessmentRating)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addRatings(AssessmentRating) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatings(AssessmentRating)"})
  void testBuilderAddRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddRatingsResult = builderResult.addRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().ratings().size());
    assertSame(builderResult, actualAddRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(AssessmentRating[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addRatings(AssessmentRating[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatings(AssessmentRating[])"})
  void testBuilderAddRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddRatingsResult = builderResult.addRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().ratings().size());
    assertSame(builderResult, actualAddRatingsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>Then return build assessmentDefinitions Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentDefinitions(Iterable); then return build assessmentDefinitions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentDefinitions(Iterable)"})
  void testBuilderAssessmentDefinitions_thenReturnBuildAssessmentDefinitionsEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        builderResult.assessmentDefinitions(new ArrayList<>()).build();
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        immutableChangeInitiativeView.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, immutableChangeInitiativeView.changeInitiatives());
    assertSame(assessmentDefinitionsResult, immutableChangeInitiativeView.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, immutableChangeInitiativeView.ratings());
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
  @MethodsUnderTest({"ImmutableChangeInitiativeView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableChangeInitiativeView.builder().build().assessmentDefinitions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#changeInitiatives(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changeInitiatives(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changeInitiatives(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeInitiatives(Iterable)"})
  void testBuilderChangeInitiatives_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualChangeInitiativesResult = builderResult.changeInitiatives(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiativeView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ChangeInitiativeView)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiativeView); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiativeView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualFromResult = builderResult.from(ImmutableChangeInitiativeView.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeItems(Iterable)"})
  void testBuilderRatingSchemeItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualRatingSchemeItemsResult = builderResult.ratingSchemeItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#ratings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratings(Iterable)"})
  void testBuilderRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualRatingsResult = builderResult.ratings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingsResult);
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return assessmentDefinitions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ChangeInitiativeView); when builder build; then return assessmentDefinitions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiativeView ImmutableChangeInitiativeView.copyOf(ChangeInitiativeView)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnAssessmentDefinitionsEmpty() {
    // Arrange
    ImmutableChangeInitiativeView instance = ImmutableChangeInitiativeView.builder().build();

    // Act
    ImmutableChangeInitiativeView actualCopyOfResult =
        ImmutableChangeInitiativeView.copyOf(instance);

    // Assert
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}, and {@link
   * ImmutableChangeInitiativeView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeInitiativeView#equals(Object)}
   *   <li>{@link ImmutableChangeInitiativeView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiativeView.equals(Object)",
    "int ImmutableChangeInitiativeView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        ImmutableChangeInitiativeView.builder().build();
    ImmutableChangeInitiativeView immutableChangeInitiativeView2 =
        ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertEquals(immutableChangeInitiativeView, immutableChangeInitiativeView2);
    assertEquals(
        immutableChangeInitiativeView.hashCode(), immutableChangeInitiativeView2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}, and {@link
   * ImmutableChangeInitiativeView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeInitiativeView#equals(Object)}
   *   <li>{@link ImmutableChangeInitiativeView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiativeView.equals(Object)",
    "int ImmutableChangeInitiativeView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertEquals(immutableChangeInitiativeView, immutableChangeInitiativeView);
    int expectedHashCodeResult = immutableChangeInitiativeView.hashCode();
    assertEquals(expectedHashCodeResult, immutableChangeInitiativeView.hashCode());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiativeView.equals(Object)",
    "int ImmutableChangeInitiativeView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    ImmutableChangeInitiative.Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    ImmutableChangeInitiative.Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    ImmutableChangeInitiative.Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    builderResult.addChangeInitiatives(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableChangeInitiativeView.builder().build());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiativeView.equals(Object)",
    "int ImmutableChangeInitiativeView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

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
    assertNotEquals(builderResult.build(), ImmutableChangeInitiativeView.builder().build());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiativeView.equals(Object)",
    "int ImmutableChangeInitiativeView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
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
    assertNotEquals(builderResult.build(), ImmutableChangeInitiativeView.builder().build());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiativeView.equals(Object)",
    "int ImmutableChangeInitiativeView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    builderResult.addRatings(
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
    assertNotEquals(builderResult.build(), ImmutableChangeInitiativeView.builder().build());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiativeView.equals(Object)",
    "int ImmutableChangeInitiativeView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableChangeInitiativeView.builder().build(), null);
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiativeView.equals(Object)",
    "int ImmutableChangeInitiativeView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableChangeInitiativeView.builder().build(),
        "Different type to ImmutableChangeInitiativeView");
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link AssessmentRating}.
   *   <li>Then return ratings size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add AssessmentRating; then return ratings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddAssessmentRating_thenReturnRatingsSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentRating> ratings = new LinkedHashSet<>();
    ratings.add(mock(AssessmentRating.class));

    Json json = new Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setRatings(ratings);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult =
        ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratings().size());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentDefinitions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_thenReturnAssessmentDefinitionsEmpty() {
    // Arrange
    Json json = new Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setRatings(null);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult =
        ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentDefinitions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_thenReturnAssessmentDefinitionsSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentDefinition> assessmentDefinitions = new LinkedHashSet<>();
    assessmentDefinitions.add(mock(AssessmentDefinition.class));

    Json json = new Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(assessmentDefinitions);
    json.setRatingSchemeItems(null);
    json.setRatings(null);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult =
        ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentDefinitions().size());
    Set<ChangeInitiative> changeInitiativesResult = actualFromJsonResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualFromJsonResult.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualFromJsonResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return changeInitiatives size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_thenReturnChangeInitiativesSizeIsOne() {
    // Arrange
    HashSet<ChangeInitiative> changeInitiatives = new HashSet<>();

    ImmutableChangeInitiative.Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    ImmutableChangeInitiative.Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    ImmutableChangeInitiative.Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiatives.add(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    Json json = new Json();
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult =
        ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.changeInitiatives().size());
    Set<AssessmentRating> assessmentRatingSet = json.ratings;
    assertSame(assessmentRatingSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentRatingSet, actualFromJsonResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(mock(RatingSchemeItem.class));

    Json json = new Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setRatings(null);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult =
        ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratings is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratings is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_thenReturnRatingsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AssessmentRating> ratings = new LinkedHashSet<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ratings.add(
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
    ratings.add(mock(AssessmentRating.class));

    Json json = new Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setRatings(ratings);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult =
        ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(ratings, actualFromJsonResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return ratingSchemeItems is {@link Json} (default constructor) {@link
   *       Json#changeInitiatives}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return ratingSchemeItems is Json (default constructor) changeInitiatives")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnRatingSchemeItemsIsJsonChangeInitiatives() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult =
        ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    Set<ChangeInitiative> changeInitiativeSet = json.changeInitiatives;
    assertSame(changeInitiativeSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(changeInitiativeSet, actualFromJsonResult.ratings());
    Set<AssessmentRating> expectedChangeInitiativesResult = json.ratings;
    assertSame(expectedChangeInitiativesResult, actualFromJsonResult.changeInitiatives());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeInitiativeView#toString()}
   *   <li>{@link ImmutableChangeInitiativeView#assessmentDefinitions()}
   *   <li>{@link ImmutableChangeInitiativeView#changeInitiatives()}
   *   <li>{@link ImmutableChangeInitiativeView#ratingSchemeItems()}
   *   <li>{@link ImmutableChangeInitiativeView#ratings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableChangeInitiativeView.assessmentDefinitions()",
    "Set ImmutableChangeInitiativeView.changeInitiatives()",
    "Set ImmutableChangeInitiativeView.ratingSchemeItems()",
    "Set ImmutableChangeInitiativeView.ratings()",
    "String ImmutableChangeInitiativeView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        ImmutableChangeInitiativeView.builder().build();

    // Act
    String actualToStringResult = immutableChangeInitiativeView.toString();
    Set<AssessmentDefinition> actualAssessmentDefinitionsResult =
        immutableChangeInitiativeView.assessmentDefinitions();
    Set<ChangeInitiative> actualChangeInitiativesResult =
        immutableChangeInitiativeView.changeInitiatives();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult =
        immutableChangeInitiativeView.ratingSchemeItems();
    Set<AssessmentRating> actualRatingsResult = immutableChangeInitiativeView.ratings();

    // Assert
    assertEquals(
        "ChangeInitiativeView{changeInitiatives=[], assessmentDefinitions=[], ratingSchemeItems=[],"
            + " ratings=[]}",
        actualToStringResult);
    assertTrue(actualAssessmentDefinitionsResult.isEmpty());
    assertSame(actualAssessmentDefinitionsResult, actualChangeInitiativesResult);
    assertSame(actualAssessmentDefinitionsResult, actualRatingSchemeItemsResult);
    assertSame(actualAssessmentDefinitionsResult, actualRatingsResult);
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
   * Test Json {@link Json#changeInitiatives()}.
   *
   * <p>Method under test: {@link Json#changeInitiatives()}
   */
  @Test
  @DisplayName("Test Json changeInitiatives()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.changeInitiatives()"})
  void testJsonChangeInitiatives() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeInitiatives());
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
    assertTrue(actualJson.changeInitiatives.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
    assertTrue(actualJson.ratings.isEmpty());
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
   * Test Json {@link Json#ratings()}.
   *
   * <p>Method under test: {@link Json#ratings()}
   */
  @Test
  @DisplayName("Test Json ratings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ratings()"})
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#withAssessmentDefinitions(AssessmentDefinition[])}
   * with {@code AssessmentDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableChangeInitiativeView#withAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiativeView ImmutableChangeInitiativeView.withAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testWithAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        ImmutableChangeInitiativeView.builder().build();

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
    ImmutableChangeInitiativeView actualWithAssessmentDefinitionsResult =
        immutableChangeInitiativeView.withAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, actualWithAssessmentDefinitionsResult.assessmentDefinitions().size());
    Set<ChangeInitiative> changeInitiativesResult =
        actualWithAssessmentDefinitionsResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualWithAssessmentDefinitionsResult.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualWithAssessmentDefinitionsResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#withChangeInitiatives(ChangeInitiative[])} with
   * {@code ChangeInitiative[]}.
   *
   * <p>Method under test: {@link
   * ImmutableChangeInitiativeView#withChangeInitiatives(ChangeInitiative[])}
   */
  @Test
  @DisplayName("Test withChangeInitiatives(ChangeInitiative[]) with 'ChangeInitiative[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiativeView ImmutableChangeInitiativeView.withChangeInitiatives(ChangeInitiative[])"
  })
  void testWithChangeInitiativesWithChangeInitiative() {
    // Arrange
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        ImmutableChangeInitiativeView.builder().build();

    ImmutableChangeInitiative.Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    ImmutableChangeInitiative.Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    ImmutableChangeInitiative.Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiativeView actualWithChangeInitiativesResult =
        immutableChangeInitiativeView.withChangeInitiatives(
            provenanceResult
                .startDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());

    // Assert
    assertEquals(1, actualWithChangeInitiativesResult.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualWithChangeInitiativesResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithChangeInitiativesResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualWithChangeInitiativesResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#withRatingSchemeItems(RatingSchemeItem[])} with
   * {@code RatingSchemeItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableChangeInitiativeView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiativeView ImmutableChangeInitiativeView.withRatingSchemeItems(RatingSchemeItem[])"
  })
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        ImmutableChangeInitiativeView.builder().build();

    // Act
    ImmutableChangeInitiativeView actualWithRatingSchemeItemsResult =
        immutableChangeInitiativeView.withRatingSchemeItems(
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
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualWithRatingSchemeItemsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithRatingSchemeItemsResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualWithRatingSchemeItemsResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#withRatings(AssessmentRating[])} with {@code
   * AssessmentRating[]}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiativeView#withRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiativeView ImmutableChangeInitiativeView.withRatings(AssessmentRating[])"
  })
  void testWithRatingsWithAssessmentRating() {
    // Arrange
    ImmutableChangeInitiativeView immutableChangeInitiativeView =
        ImmutableChangeInitiativeView.builder().build();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableChangeInitiativeView actualWithRatingsResult =
        immutableChangeInitiativeView.withRatings(
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
    assertEquals(1, actualWithRatingsResult.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualWithRatingsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithRatingsResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualWithRatingsResult.ratingSchemeItems());
  }
}
