package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.application.ImmutableAssessmentsView.Builder;
import org.finos.waltz.model.application.ImmutableAssessmentsView.Json;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessmentDefinitions(Iterable)"})
  void testBuilderAddAllAssessmentDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllAssessmentRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentRatings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessmentRatings(Iterable)"})
  void testBuilderAddAllAssessmentRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentRatings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRatingSchemeItems(Iterable)}.
   * <ul>
   *   <li>Then return build ratingSchemeItemsById Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingSchemeItems(Iterable); then return build ratingSchemeItemsById Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingSchemeItems(Iterable)"})
  void testBuilderAddAllRatingSchemeItems_thenReturnBuildRatingSchemeItemsByIdEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertTrue(builderResult.addAllRatingSchemeItems(new ArrayList<>()).build().ratingSchemeItemsById().isEmpty());
    assertTrue(builderResult.build().ratingSchemeItemsById().isEmpty());
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
    Builder builderResult = ImmutableAssessmentsView.builder();

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
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAssessmentDefinitionsResult = builderResult
        .addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentRating)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addAssessmentRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentRatings(AssessmentRating) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentRating)"})
  void testBuilderAddAssessmentRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAssessmentRatingsResult = builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentRating[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentRatings(AssessmentRating[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentRating[])"})
  void testBuilderAddAssessmentRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddAssessmentRatingsResult = builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
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
    Builder builderResult = ImmutableAssessmentsView.builder();
    RatingSchemeItem element = mock(RatingSchemeItem.class);

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(element);

    // Assert
    ImmutableAssessmentsView buildResult = builderResult.build();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = buildResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, buildResult.ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
    assertSame(element, ratingSchemeItemsByIdResult.get(null));
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
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    ImmutableAssessmentsView buildResult = builderResult.build();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = buildResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, buildResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(null));
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentDefinitions(Iterable)"})
  void testBuilderAssessmentDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#assessmentRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentRatings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentRatings(Iterable)"})
  void testBuilderAssessmentRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentRatings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentsView actualBuildResult = ImmutableAssessmentsView.builder().build();

    // Assert
    assertTrue(actualBuildResult.ratingSchemeItemsById().isEmpty());
    assertTrue(actualBuildResult.assessmentDefinitions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentsView)}.
   * <ul>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentsView); then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentsView)"})
  void testBuilderFrom_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
    Builder builderResult2 = ImmutableAssessmentsView.builder();
    builderResult2.addAssessmentRatings(mock(AssessmentRating.class));
    ImmutableAssessmentsView instance = builderResult2.build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentsView)}.
   * <ul>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentsView); then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentsView)"})
  void testBuilderFrom_thenReturnBuildIsBuilderBuild2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    Builder builderResult2 = ImmutableAssessmentsView.builder();
    builderResult2.addRatingSchemeItems(ratingSchemeItem);
    builderResult2.addAssessmentRatings(mock(AssessmentRating.class));
    ImmutableAssessmentsView instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(ratingSchemeItem).id();
    assertEquals(instance, actualFromResult.build());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentsView)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentsView); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentsView)"})
  void testBuilderFrom_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    Builder builderResult2 = ImmutableAssessmentsView.builder();
    builderResult2.addAssessmentDefinitions(mock(AssessmentDefinition.class));
    builderResult2.addRatingSchemeItems(ratingSchemeItem);
    builderResult2.addAssessmentRatings(mock(AssessmentRating.class));
    ImmutableAssessmentsView instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(ratingSchemeItem).id();
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentsView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build ratingSchemeItemsById Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentsView); when builder build; then return build ratingSchemeItemsById Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentsView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildRatingSchemeItemsByIdEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
    ImmutableAssessmentsView instance = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertTrue(builderResult.from(instance).build().ratingSchemeItemsById().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#ratingSchemeItems(Iterable)}.
   * <ul>
   *   <li>Then return build ratingSchemeItemsById Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeItems(Iterable); then return build ratingSchemeItemsById Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeItems(Iterable)"})
  void testBuilderRatingSchemeItems_thenReturnBuildRatingSchemeItemsByIdEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertTrue(builderResult.ratingSchemeItems(new ArrayList<>()).build().ratingSchemeItemsById().isEmpty());
    assertTrue(builderResult.build().ratingSchemeItemsById().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return ratingSchemeItemsById Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentsView); when builder build; then return ratingSchemeItemsById Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.copyOf(AssessmentsView)"})
  void testCopyOf_whenBuilderBuild_thenReturnRatingSchemeItemsByIdEmpty() {
    // Arrange
    ImmutableAssessmentsView instance = ImmutableAssessmentsView.builder().build();

    // Act
    ImmutableAssessmentsView actualCopyOfResult = ImmutableAssessmentsView.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}, and {@link ImmutableAssessmentsView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentsView#equals(Object)}
   *   <li>{@link ImmutableAssessmentsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentsView.equals(Object)", "int ImmutableAssessmentsView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentsView buildResult = ImmutableAssessmentsView.builder().build();
    ImmutableAssessmentsView buildResult2 = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}, and {@link ImmutableAssessmentsView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentsView#equals(Object)}
   *   <li>{@link ImmutableAssessmentsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentsView.equals(Object)", "int ImmutableAssessmentsView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentsView buildResult = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentsView.equals(Object)", "int ImmutableAssessmentsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentsView.builder();
    builderResult.addAssessmentRatings(mock(AssessmentRating.class));
    ImmutableAssessmentsView buildResult = builderResult.build();
    ImmutableAssessmentsView buildResult2 = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentsView.equals(Object)", "int ImmutableAssessmentsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RatingSchemeItem element = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(element.id()).thenReturn(ofResult);
    Builder builderResult = ImmutableAssessmentsView.builder();
    builderResult.addRatingSchemeItems(element);
    ImmutableAssessmentsView buildResult = builderResult.build();
    ImmutableAssessmentsView buildResult2 = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentsView.equals(Object)", "int ImmutableAssessmentsView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableAssessmentsView buildResult = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableAssessmentsView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentsView.equals(Object)", "int ImmutableAssessmentsView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableAssessmentsView buildResult = ImmutableAssessmentsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableAssessmentsView");
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return assessmentDefinitions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentDefinitions size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return assessmentRatings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentRatings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.fromJson(Json)"})
  void testFromJson_thenReturnAssessmentRatingsSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentRating> assessmentRatings = new LinkedHashSet<>();
    assessmentRatings.add(mock(AssessmentRating.class));

    Json json = new Json();
    json.setAssessmentRatings(assessmentRatings);
    json.setRatingSchemeItems(null);
    json.setAssessmentDefinitions(null);

    // Act and Assert
    assertEquals(1, ImmutableAssessmentsView.fromJson(json).assessmentRatings().size());
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return ratingSchemeItemsById Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItemsById Empty")
  @Tag("MaintainedByDiffblue")
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
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return ratingSchemeItemsById size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItemsById size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.fromJson(Json)"})
  void testFromJson_thenReturnRatingSchemeItemsByIdSizeIsOne() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(ratingSchemeItem);

    Json json = new Json();
    json.setAssessmentRatings(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setAssessmentDefinitions(null);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    verify(ratingSchemeItem).id();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualFromJsonResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
  }

  /**
   * Test {@link ImmutableAssessmentsView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return assessmentRatings is {@link Json} (default constructor) {@link Json#ratingSchemeItems}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return assessmentRatings is Json (default constructor) ratingSchemeItems")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableAssessmentsView.assessmentDefinitions()",
      "Set ImmutableAssessmentsView.assessmentRatings()", "Set ImmutableAssessmentsView.ratingSchemeItems()",
      "Map ImmutableAssessmentsView.ratingSchemeItemsById()", "String ImmutableAssessmentsView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentsView buildResult = ImmutableAssessmentsView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<AssessmentDefinition> actualAssessmentDefinitionsResult = buildResult.assessmentDefinitions();
    Set<AssessmentRating> actualAssessmentRatingsResult = buildResult.assessmentRatings();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult = buildResult.ratingSchemeItems();

    // Assert
    assertEquals(
        "AssessmentsView{assessmentRatings=[], ratingSchemeItems=[], assessmentDefinitions=[], ratingSchemeItemsById"
            + "={}}",
        actualToStringResult);
    assertTrue(buildResult.ratingSchemeItemsById().isEmpty());
    assertTrue(actualAssessmentDefinitionsResult.isEmpty());
    assertSame(actualAssessmentDefinitionsResult, actualAssessmentRatingsResult);
    assertSame(actualAssessmentDefinitionsResult, actualRatingSchemeItemsResult);
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
   * Test Json {@link Json#assessmentRatings()}.
   * <p>
   * Method under test: {@link Json#assessmentRatings()}
   */
  @Test
  @DisplayName("Test Json assessmentRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.assessmentRatings()"})
  void testJsonAssessmentRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentRatings());
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
    assertTrue(actualJson.assessmentRatings.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
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
   * Test Json {@link Json#ratingSchemeItemsById()}.
   * <p>
   * Method under test: {@link Json#ratingSchemeItemsById()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItemsById()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map Json.ratingSchemeItemsById()"})
  void testJsonRatingSchemeItemsById() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeItemsById());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])} with {@code AssessmentDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentDefinitions(AssessmentDefinition[])"})
  void testWithAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableAssessmentsView buildResult = ImmutableAssessmentsView.builder().build();

    // Act
    ImmutableAssessmentsView actualWithAssessmentDefinitionsResult = buildResult
        .withAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, actualWithAssessmentDefinitionsResult.assessmentDefinitions().size());
    assertTrue(actualWithAssessmentDefinitionsResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentRating> assessmentRatingsResult = actualWithAssessmentDefinitionsResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])} with {@code AssessmentDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentDefinitions(AssessmentDefinition[])"})
  void testWithAssessmentDefinitionsWithAssessmentDefinition2() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    Builder builderResult = ImmutableAssessmentsView.builder();
    builderResult.addRatingSchemeItems(ratingSchemeItem);
    ImmutableAssessmentsView buildResult = builderResult.build();

    // Act
    ImmutableAssessmentsView actualWithAssessmentDefinitionsResult = buildResult
        .withAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    verify(ratingSchemeItem, atLeast(1)).id();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualWithAssessmentDefinitionsResult
        .ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, actualWithAssessmentDefinitionsResult.assessmentDefinitions().size());
    assertEquals(1, actualWithAssessmentDefinitionsResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    assertTrue(actualWithAssessmentDefinitionsResult.assessmentRatings().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])} with {@code AssessmentDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#withAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentDefinitions(AssessmentDefinition[])"})
  void testWithAssessmentDefinitionsWithAssessmentDefinition3() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    RatingSchemeItem ratingSchemeItem2 = mock(RatingSchemeItem.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(ratingSchemeItem2.id()).thenReturn(ofResult2);
    Builder builderResult = ImmutableAssessmentsView.builder();
    builderResult.addRatingSchemeItems(ratingSchemeItem2);
    builderResult.addRatingSchemeItems(ratingSchemeItem);
    ImmutableAssessmentsView buildResult = builderResult.build();

    // Act
    ImmutableAssessmentsView actualWithAssessmentDefinitionsResult = buildResult
        .withAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    verify(ratingSchemeItem2, atLeast(1)).id();
    verify(ratingSchemeItem, atLeast(1)).id();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualWithAssessmentDefinitionsResult
        .ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, actualWithAssessmentDefinitionsResult.assessmentDefinitions().size());
    assertEquals(2, actualWithAssessmentDefinitionsResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    assertTrue(actualWithAssessmentDefinitionsResult.assessmentRatings().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])} with {@code AssessmentRating[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withAssessmentRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentRatings(AssessmentRating[])"})
  void testWithAssessmentRatingsWithAssessmentRating() {
    // Arrange
    ImmutableAssessmentsView buildResult = ImmutableAssessmentsView.builder().build();

    // Act
    ImmutableAssessmentsView actualWithAssessmentRatingsResult = buildResult
        .withAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, actualWithAssessmentRatingsResult.assessmentRatings().size());
    assertTrue(actualWithAssessmentRatingsResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualWithAssessmentRatingsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithAssessmentRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])} with {@code AssessmentRating[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withAssessmentRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentRatings(AssessmentRating[])"})
  void testWithAssessmentRatingsWithAssessmentRating2() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    Builder builderResult = ImmutableAssessmentsView.builder();
    builderResult.addRatingSchemeItems(ratingSchemeItem);
    ImmutableAssessmentsView buildResult = builderResult.build();

    // Act
    ImmutableAssessmentsView actualWithAssessmentRatingsResult = buildResult
        .withAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    verify(ratingSchemeItem, atLeast(1)).id();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualWithAssessmentRatingsResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, actualWithAssessmentRatingsResult.assessmentRatings().size());
    assertEquals(1, actualWithAssessmentRatingsResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    assertTrue(actualWithAssessmentRatingsResult.assessmentDefinitions().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])} with {@code AssessmentRating[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#withAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withAssessmentRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.withAssessmentRatings(AssessmentRating[])"})
  void testWithAssessmentRatingsWithAssessmentRating3() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    RatingSchemeItem ratingSchemeItem2 = mock(RatingSchemeItem.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(ratingSchemeItem2.id()).thenReturn(ofResult2);
    Builder builderResult = ImmutableAssessmentsView.builder();
    builderResult.addRatingSchemeItems(ratingSchemeItem2);
    builderResult.addRatingSchemeItems(ratingSchemeItem);
    ImmutableAssessmentsView buildResult = builderResult.build();

    // Act
    ImmutableAssessmentsView actualWithAssessmentRatingsResult = buildResult
        .withAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    verify(ratingSchemeItem2, atLeast(1)).id();
    verify(ratingSchemeItem, atLeast(1)).id();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualWithAssessmentRatingsResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, actualWithAssessmentRatingsResult.assessmentRatings().size());
    assertEquals(2, actualWithAssessmentRatingsResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    assertTrue(actualWithAssessmentRatingsResult.assessmentDefinitions().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentsView#withRatingSchemeItems(RatingSchemeItem[])} with {@code RatingSchemeItem[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentsView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentsView ImmutableAssessmentsView.withRatingSchemeItems(RatingSchemeItem[])"})
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableAssessmentsView buildResult = ImmutableAssessmentsView.builder().build();
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);

    // Act
    ImmutableAssessmentsView actualWithRatingSchemeItemsResult = buildResult.withRatingSchemeItems(ratingSchemeItem);

    // Assert
    verify(ratingSchemeItem).id();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualWithRatingSchemeItemsResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualWithRatingSchemeItemsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualWithRatingSchemeItemsResult.assessmentRatings());
  }
}
