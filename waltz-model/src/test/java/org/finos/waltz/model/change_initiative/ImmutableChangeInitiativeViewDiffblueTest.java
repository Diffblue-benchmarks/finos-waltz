package org.finos.waltz.model.change_initiative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiativeView.Builder;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiativeView.Json;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeInitiativeViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentDefinitions(Iterable)}.
   * <ul>
   *   <li>Then return build assessmentDefinitions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentDefinitions(Iterable); then return build assessmentDefinitions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessmentDefinitions(Iterable)"})
  void testBuilderAddAllAssessmentDefinitions_thenReturnBuildAssessmentDefinitionsEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    ImmutableChangeInitiativeView buildResult = builderResult.addAllAssessmentDefinitions(new ArrayList<>()).build();
    Set<AssessmentDefinition> assessmentDefinitionsResult = buildResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, buildResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, buildResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, buildResult.ratings());
  }

  /**
   * Test Builder {@link Builder#addAllChangeInitiatives(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChangeInitiatives(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangeInitiatives(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChangeInitiatives(Iterable)"})
  void testBuilderAddAllChangeInitiatives_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangeInitiatives(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRatingSchemeItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingSchemeItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingSchemeItems(Iterable)"})
  void testBuilderAddAllRatingSchemeItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingSchemeItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatings(Iterable)"})
  void testBuilderAddAllRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAssessmentDefinitions(AssessmentDefinition)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddAssessmentDefinitionsResult = builderResult
        .addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentDefinitions(AssessmentDefinition[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentDefinitions(AssessmentDefinition[])"})
  void testBuilderAddAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddAssessmentDefinitionsResult = builderResult
        .addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addChangeInitiatives(ChangeInitiative)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addChangeInitiatives(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiatives(ChangeInitiative) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChangeInitiatives(ChangeInitiative)"})
  void testBuilderAddChangeInitiativesWithElement() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddChangeInitiativesResult = builderResult.addChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#addChangeInitiatives(ChangeInitiative[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addChangeInitiatives(ChangeInitiative[])}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiatives(ChangeInitiative[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChangeInitiatives(ChangeInitiative[])"})
  void testBuilderAddChangeInitiativesWithElements() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddChangeInitiativesResult = builderResult.addChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem)"})
  void testBuilderAddRatingSchemeItemsWithElement() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem[])"})
  void testBuilderAddRatingSchemeItemsWithElements() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(AssessmentRating)} with {@code element}.
   * <ul>
   *   <li>Then builder build ratings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addRatings(AssessmentRating) with 'element'; then builder build ratings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatings(AssessmentRating)"})
  void testBuilderAddRatingsWithElement_thenBuilderBuildRatingsSizeIsOne() {
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
   * <ul>
   *   <li>Then builder build ratings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addRatings(AssessmentRating[]) with 'elements'; then builder build ratings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatings(AssessmentRating[])"})
  void testBuilderAddRatingsWithElements_thenBuilderBuildRatingsSizeIsOne() {
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
   * <ul>
   *   <li>Then return build assessmentDefinitions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitions(Iterable); then return build assessmentDefinitions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentDefinitions(Iterable)"})
  void testBuilderAssessmentDefinitions_thenReturnBuildAssessmentDefinitionsEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    ImmutableChangeInitiativeView buildResult = builderResult.assessmentDefinitions(new ArrayList<>()).build();
    Set<AssessmentDefinition> assessmentDefinitionsResult = buildResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, buildResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, buildResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, buildResult.ratings());
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeInitiativeView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableChangeInitiativeView.builder().build().assessmentDefinitions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#changeInitiatives(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changeInitiatives(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changeInitiatives(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeInitiatives(Iterable)"})
  void testBuilderChangeInitiatives_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiatives(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiativeView)}.
   * <ul>
   *   <li>Then return build assessmentDefinitions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiativeView)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiativeView); then return build assessmentDefinitions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiativeView)"})
  void testBuilderFrom_thenReturnBuildAssessmentDefinitionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    Builder builderResult2 = ImmutableChangeInitiativeView.builder();
    builderResult2.addAssessmentDefinitions(mock(AssessmentDefinition.class));
    builderResult2.addChangeInitiatives(new ImmutableChangeInitiative.Json());
    ImmutableChangeInitiativeView instance = builderResult2.build();

    // Act and Assert
    ImmutableChangeInitiativeView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.assessmentDefinitions().size());
    assertEquals(1, buildResult.changeInitiatives().size());
    Set<RatingSchemeItem> ratingSchemeItemsResult = buildResult.ratingSchemeItems();
    assertTrue(ratingSchemeItemsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(ratingSchemeItemsResult, buildResult.ratings());
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiativeView)}.
   * <ul>
   *   <li>Then return build ratingSchemeItems is build assessmentDefinitions.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiativeView)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiativeView); then return build ratingSchemeItems is build assessmentDefinitions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiativeView)"})
  void testBuilderFrom_thenReturnBuildRatingSchemeItemsIsBuildAssessmentDefinitions() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    Builder builderResult2 = ImmutableChangeInitiativeView.builder();
    builderResult2.addChangeInitiatives(new ImmutableChangeInitiative.Json());
    ImmutableChangeInitiativeView instance = builderResult2.build();

    // Act and Assert
    ImmutableChangeInitiativeView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = buildResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(assessmentDefinitionsResult, buildResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, buildResult.ratings());
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiativeView)}.
   * <ul>
   *   <li>Then return build ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiativeView)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiativeView); then return build ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiativeView)"})
  void testBuilderFrom_thenReturnBuildRatingSchemeItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    Builder builderResult2 = ImmutableChangeInitiativeView.builder();
    builderResult2.addRatingSchemeItems(mock(RatingSchemeItem.class));
    builderResult2.addChangeInitiatives(new ImmutableChangeInitiative.Json());
    ImmutableChangeInitiativeView instance = builderResult2.build();

    // Act and Assert
    ImmutableChangeInitiativeView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.changeInitiatives().size());
    assertEquals(1, buildResult.ratingSchemeItems().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = buildResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(assessmentDefinitionsResult, buildResult.ratings());
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiativeView)}.
   * <ul>
   *   <li>Then return build ratings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiativeView)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiativeView); then return build ratings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiativeView)"})
  void testBuilderFrom_thenReturnBuildRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    Builder builderResult2 = ImmutableChangeInitiativeView.builder();
    builderResult2.addRatings(mock(AssessmentRating.class));
    builderResult2.addChangeInitiatives(new ImmutableChangeInitiative.Json());
    ImmutableChangeInitiativeView instance = builderResult2.build();

    // Act and Assert
    ImmutableChangeInitiativeView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.changeInitiatives().size());
    assertEquals(1, buildResult.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = buildResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(assessmentDefinitionsResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiativeView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiativeView)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiativeView); when builder build; then builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiativeView)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    ImmutableChangeInitiativeView instance = ImmutableChangeInitiativeView.builder().build();

    // Act
    builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#ratingSchemeItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeItems(Iterable)"})
  void testBuilderRatingSchemeItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#ratings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratings(Iterable)"})
  void testBuilderRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return assessmentDefinitions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}
   */
  @Test
  @DisplayName("Test copyOf(ChangeInitiativeView); when builder build; then return assessmentDefinitions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.copyOf(ChangeInitiativeView)"})
  void testCopyOf_whenBuilderBuild_thenReturnAssessmentDefinitionsEmpty() {
    // Arrange
    ImmutableChangeInitiativeView instance = ImmutableChangeInitiativeView.builder().build();

    // Act
    ImmutableChangeInitiativeView actualCopyOfResult = ImmutableChangeInitiativeView.copyOf(instance);

    // Assert
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}, and {@link ImmutableChangeInitiativeView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeInitiativeView#equals(Object)}
   *   <li>{@link ImmutableChangeInitiativeView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableChangeInitiativeView.equals(Object)",
      "int ImmutableChangeInitiativeView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();
    ImmutableChangeInitiativeView buildResult2 = ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}, and {@link ImmutableChangeInitiativeView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeInitiativeView#equals(Object)}
   *   <li>{@link ImmutableChangeInitiativeView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableChangeInitiativeView.equals(Object)",
      "int ImmutableChangeInitiativeView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableChangeInitiativeView.equals(Object)",
      "int ImmutableChangeInitiativeView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    builderResult.addChangeInitiatives(new ImmutableChangeInitiative.Json());
    ImmutableChangeInitiativeView buildResult = builderResult.build();
    ImmutableChangeInitiativeView buildResult2 = ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableChangeInitiativeView.equals(Object)",
      "int ImmutableChangeInitiativeView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    builderResult.addAssessmentDefinitions(mock(AssessmentDefinition.class));
    ImmutableChangeInitiativeView buildResult = builderResult.build();
    ImmutableChangeInitiativeView buildResult2 = ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableChangeInitiativeView.equals(Object)",
      "int ImmutableChangeInitiativeView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));
    ImmutableChangeInitiativeView buildResult = builderResult.build();
    ImmutableChangeInitiativeView buildResult2 = ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableChangeInitiativeView.equals(Object)",
      "int ImmutableChangeInitiativeView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiativeView.builder();
    builderResult.addRatings(mock(AssessmentRating.class));
    ImmutableChangeInitiativeView buildResult = builderResult.build();
    ImmutableChangeInitiativeView buildResult2 = ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableChangeInitiativeView.equals(Object)",
      "int ImmutableChangeInitiativeView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableChangeInitiativeView.equals(Object)",
      "int ImmutableChangeInitiativeView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableChangeInitiativeView");
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableChangeInitiative.Json} (default constructor).</li>
   *   <li>Then return changeInitiatives is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet() add Json (default constructor); then return changeInitiatives is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_givenHashSetAddJson_thenReturnChangeInitiativesIsHashSet() {
    // Arrange
    HashSet<ChangeInitiative> changeInitiatives = new HashSet<>();
    changeInitiatives.add(new ImmutableChangeInitiative.Json());
    changeInitiatives.add(new ImmutableChangeInitiative.Json());

    Json json = new Json();
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(changeInitiatives, actualFromJsonResult.changeInitiatives());
    Set<AssessmentRating> assessmentRatingSet = json.ratings;
    assertSame(assessmentRatingSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentRatingSet, actualFromJsonResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableChangeInitiative.Json} (default constructor).</li>
   *   <li>Then return changeInitiatives size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet() add Json (default constructor); then return changeInitiatives size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_givenHashSetAddJson_thenReturnChangeInitiativesSizeIsOne() {
    // Arrange
    HashSet<ChangeInitiative> changeInitiatives = new HashSet<>();
    changeInitiatives.add(new ImmutableChangeInitiative.Json());

    Json json = new Json();
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.changeInitiatives().size());
    Set<AssessmentRating> assessmentRatingSet = json.ratings;
    assertSame(assessmentRatingSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentRatingSet, actualFromJsonResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link AssessmentRating}.</li>
   *   <li>Then return ratings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add AssessmentRating; then return ratings size is one")
  @Tag("MaintainedByDiffblue")
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

    // Act and Assert
    assertEquals(1, ImmutableChangeInitiativeView.fromJson(json).ratings().size());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   * <ul>
   *   <li>Then return assessmentDefinitions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentDefinitions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_thenReturnAssessmentDefinitionsEmpty() {
    // Arrange
    Json json = new Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setRatings(null);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   * <ul>
   *   <li>Then return assessmentDefinitions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentDefinitions size is one")
  @Tag("MaintainedByDiffblue")
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
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentDefinitions().size());
    Set<ChangeInitiative> changeInitiativesResult = actualFromJsonResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualFromJsonResult.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualFromJsonResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
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

    // Act and Assert
    assertEquals(1, ImmutableChangeInitiativeView.fromJson(json).ratingSchemeItems().size());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return ratingSchemeItems is {@link Json} (default constructor) {@link Json#changeInitiatives}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return ratingSchemeItems is Json (default constructor) changeInitiatives")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnRatingSchemeItemsIsJsonChangeInitiatives() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    Set<ChangeInitiative> changeInitiativeSet = json.changeInitiatives;
    assertSame(changeInitiativeSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(changeInitiativeSet, actualFromJsonResult.ratings());
    Set<AssessmentRating> expectedChangeInitiativesResult = json.ratings;
    assertSame(expectedChangeInitiativesResult, actualFromJsonResult.changeInitiatives());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableChangeInitiativeView.assessmentDefinitions()",
      "Set ImmutableChangeInitiativeView.changeInitiatives()", "Set ImmutableChangeInitiativeView.ratingSchemeItems()",
      "Set ImmutableChangeInitiativeView.ratings()", "String ImmutableChangeInitiativeView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<AssessmentDefinition> actualAssessmentDefinitionsResult = buildResult.assessmentDefinitions();
    Set<ChangeInitiative> actualChangeInitiativesResult = buildResult.changeInitiatives();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult = buildResult.ratingSchemeItems();
    Set<AssessmentRating> actualRatingsResult = buildResult.ratings();

    // Assert
    assertEquals(
        "ChangeInitiativeView{changeInitiatives=[], assessmentDefinitions=[], ratingSchemeItems=[]," + " ratings=[]}",
        actualToStringResult);
    assertTrue(actualAssessmentDefinitionsResult.isEmpty());
    assertSame(actualAssessmentDefinitionsResult, actualChangeInitiativesResult);
    assertSame(actualAssessmentDefinitionsResult, actualRatingSchemeItemsResult);
    assertSame(actualAssessmentDefinitionsResult, actualRatingsResult);
  }

  /**
   * Test Json {@link Json#assessmentDefinitions()}.
   * <p>
   * Method under test: {@link Json#assessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.assessmentDefinitions()"})
  void testJsonAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentDefinitions());
  }

  /**
   * Test Json {@link Json#changeInitiatives()}.
   * <p>
   * Method under test: {@link Json#changeInitiatives()}
   */
  @Test
  @DisplayName("Test Json changeInitiatives()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.changeInitiatives()"})
  void testJsonChangeInitiatives() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeInitiatives());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#ratingSchemeItems()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.ratingSchemeItems()"})
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeItems());
  }

  /**
   * Test Json {@link Json#ratings()}.
   * <p>
   * Method under test: {@link Json#ratings()}
   */
  @Test
  @DisplayName("Test Json ratings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.ratings()"})
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#withAssessmentDefinitions(AssessmentDefinition[])} with {@code AssessmentDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#withAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableChangeInitiativeView ImmutableChangeInitiativeView.withAssessmentDefinitions(AssessmentDefinition[])"})
  void testWithAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();

    // Act
    ImmutableChangeInitiativeView actualWithAssessmentDefinitionsResult = buildResult
        .withAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, actualWithAssessmentDefinitionsResult.assessmentDefinitions().size());
    Set<ChangeInitiative> changeInitiativesResult = actualWithAssessmentDefinitionsResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualWithAssessmentDefinitionsResult.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualWithAssessmentDefinitionsResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#withChangeInitiatives(ChangeInitiative[])} with {@code ChangeInitiative[]}.
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#withChangeInitiatives(ChangeInitiative[])}
   */
  @Test
  @DisplayName("Test withChangeInitiatives(ChangeInitiative[]) with 'ChangeInitiative[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableChangeInitiativeView ImmutableChangeInitiativeView.withChangeInitiatives(ChangeInitiative[])"})
  void testWithChangeInitiativesWithChangeInitiative() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();

    // Act
    ImmutableChangeInitiativeView actualWithChangeInitiativesResult = buildResult
        .withChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, actualWithChangeInitiativesResult.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualWithChangeInitiativesResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithChangeInitiativesResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualWithChangeInitiativesResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#withRatingSchemeItems(RatingSchemeItem[])} with {@code RatingSchemeItem[]}.
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableChangeInitiativeView ImmutableChangeInitiativeView.withRatingSchemeItems(RatingSchemeItem[])"})
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();

    // Act
    ImmutableChangeInitiativeView actualWithRatingSchemeItemsResult = buildResult
        .withRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualWithRatingSchemeItemsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithRatingSchemeItemsResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualWithRatingSchemeItemsResult.ratings());
  }

  /**
   * Test {@link ImmutableChangeInitiativeView#withRatings(AssessmentRating[])} with {@code AssessmentRating[]}.
   * <ul>
   *   <li>Then return ratings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableChangeInitiativeView#withRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withRatings(AssessmentRating[]) with 'AssessmentRating[]'; then return ratings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeInitiativeView ImmutableChangeInitiativeView.withRatings(AssessmentRating[])"})
  void testWithRatingsWithAssessmentRating_thenReturnRatingsSizeIsOne() {
    // Arrange
    ImmutableChangeInitiativeView buildResult = ImmutableChangeInitiativeView.builder().build();

    // Act
    ImmutableChangeInitiativeView actualWithRatingsResult = buildResult.withRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, actualWithRatingsResult.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualWithRatingsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithRatingsResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualWithRatingsResult.ratingSchemeItems());
  }
}
