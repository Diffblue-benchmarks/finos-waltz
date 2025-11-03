package org.finos.waltz.model.flow_classification_rule;

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
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleView.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleView.Json;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentRatings(Iterable)}.
   * <ul>
   *   <li>Then return build assessmentRatings Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentRatings(Iterable); then return build assessmentRatings Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessmentRatings(Iterable)"})
  void testBuilderAddAllAssessmentRatings_thenReturnBuildAssessmentRatingsEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    ImmutableFlowClassificationRuleView buildResult = builderResult.addAllAssessmentRatings(new ArrayList<>()).build();
    Set<AssessmentRating> assessmentRatingsResult = buildResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, buildResult.dataTypes());
    assertSame(assessmentRatingsResult, buildResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, buildResult.flowClassifications());
    assertSame(assessmentRatingsResult, buildResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, buildResult.ratingSchemeItems());
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
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

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
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddAssessmentRatingsResult = builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType)} with {@code element}.
   * <ul>
   *   <li>Then builder build dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypes(DataType)}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(DataType) with 'element'; then builder build dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType)"})
  void testBuilderAddDataTypesWithElement_thenBuilderBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddDataTypesResult = builderResult.addDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(DataType[]) with 'elements'; then builder build dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType[])"})
  void testBuilderAddDataTypesWithElements_thenBuilderBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddDataTypesResult = builderResult.addDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassificationRules(FlowClassificationRule)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addFlowClassificationRules(FlowClassificationRule)}
   */
  @Test
  @DisplayName("Test Builder addFlowClassificationRules(FlowClassificationRule) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFlowClassificationRules(FlowClassificationRule)"})
  void testBuilderAddFlowClassificationRulesWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassificationRules(FlowClassificationRule[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  @DisplayName("Test Builder addFlowClassificationRules(FlowClassificationRule[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFlowClassificationRules(FlowClassificationRule[])"})
  void testBuilderAddFlowClassificationRulesWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassifications(FlowClassification)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addFlowClassifications(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder addFlowClassifications(FlowClassification) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFlowClassifications(FlowClassification)"})
  void testBuilderAddFlowClassificationsWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddFlowClassificationsResult = builderResult.addFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassifications(FlowClassification[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addFlowClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test Builder addFlowClassifications(FlowClassification[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFlowClassifications(FlowClassification[])"})
  void testBuilderAddFlowClassificationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddFlowClassificationsResult = builderResult.addFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder addPrimaryAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPrimaryAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddPrimaryAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddPrimaryAssessmentDefinitionsResult = builderResult
        .addPrimaryAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().primaryAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPrimaryAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addPrimaryAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPrimaryAssessmentDefinitions(AssessmentDefinition[])"})
  void testBuilderAddPrimaryAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddPrimaryAssessmentDefinitionsResult = builderResult
        .addPrimaryAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().primaryAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPrimaryAssessmentDefinitionsResult);
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
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

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
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build assessmentRatings Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentRatings(Iterable); when ArrayList(); then return build assessmentRatings Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentRatings(Iterable)"})
  void testBuilderAssessmentRatings_whenArrayList_thenReturnBuildAssessmentRatingsEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    ImmutableFlowClassificationRuleView buildResult = builderResult.assessmentRatings(new ArrayList<>()).build();
    Set<AssessmentRating> assessmentRatingsResult = buildResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, buildResult.dataTypes());
    assertSame(assessmentRatingsResult, buildResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, buildResult.flowClassifications());
    assertSame(assessmentRatingsResult, buildResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableFlowClassificationRuleView.builder().build().assessmentRatings().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleView)}.
   * <ul>
   *   <li>Then return build assessmentRatings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleView); then return build assessmentRatings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleView)"})
  void testBuilderFrom_thenReturnBuildAssessmentRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    Builder builderResult2 = ImmutableFlowClassificationRuleView.builder();
    builderResult2.addAssessmentRatings(mock(AssessmentRating.class));
    builderResult2.addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());
    ImmutableFlowClassificationRuleView instance = builderResult2.build();

    // Act and Assert
    ImmutableFlowClassificationRuleView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.assessmentRatings().size());
    Set<DataType> dataTypesResult = buildResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, buildResult.flowClassifications());
    assertSame(dataTypesResult, buildResult.primaryAssessmentDefinitions());
    assertSame(dataTypesResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleView)}.
   * <ul>
   *   <li>Then return build dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleView); then return build dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleView)"})
  void testBuilderFrom_thenReturnBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    Builder builderResult2 = ImmutableFlowClassificationRuleView.builder();
    builderResult2.addDataTypes(mock(DataType.class));
    builderResult2.addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());
    ImmutableFlowClassificationRuleView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().dataTypes().size());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleView)}.
   * <ul>
   *   <li>Then return build flowClassifications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleView); then return build flowClassifications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleView)"})
  void testBuilderFrom_thenReturnBuildFlowClassificationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    Builder builderResult2 = ImmutableFlowClassificationRuleView.builder();
    builderResult2.addFlowClassifications(mock(FlowClassification.class));
    builderResult2.addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());
    ImmutableFlowClassificationRuleView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().flowClassifications().size());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleView)}.
   * <ul>
   *   <li>Then return build primaryAssessmentDefinitions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleView); then return build primaryAssessmentDefinitions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleView)"})
  void testBuilderFrom_thenReturnBuildPrimaryAssessmentDefinitionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    Builder builderResult2 = ImmutableFlowClassificationRuleView.builder();
    builderResult2.addPrimaryAssessmentDefinitions(mock(AssessmentDefinition.class));
    builderResult2.addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());
    ImmutableFlowClassificationRuleView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().primaryAssessmentDefinitions().size());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleView)}.
   * <ul>
   *   <li>Then return build ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleView); then return build ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleView)"})
  void testBuilderFrom_thenReturnBuildRatingSchemeItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    Builder builderResult2 = ImmutableFlowClassificationRuleView.builder();
    builderResult2.addRatingSchemeItems(mock(RatingSchemeItem.class));
    builderResult2.addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());
    ImmutableFlowClassificationRuleView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().ratingSchemeItems().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return assessmentRatings Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  @DisplayName("Test copyOf(FlowClassificationRuleView); when builder build; then return assessmentRatings Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.copyOf(FlowClassificationRuleView)"})
  void testCopyOf_whenBuilderBuild_thenReturnAssessmentRatingsEmpty() {
    // Arrange
    ImmutableFlowClassificationRuleView instance = ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.dataTypes());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualCopyOfResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}, and {@link ImmutableFlowClassificationRuleView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleView#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();
    ImmutableFlowClassificationRuleView buildResult2 = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}, and {@link ImmutableFlowClassificationRuleView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleView#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());
    ImmutableFlowClassificationRuleView buildResult = builderResult.build();
    ImmutableFlowClassificationRuleView buildResult2 = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addAssessmentRatings(mock(AssessmentRating.class));
    ImmutableFlowClassificationRuleView buildResult = builderResult.build();
    ImmutableFlowClassificationRuleView buildResult2 = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addPrimaryAssessmentDefinitions(mock(AssessmentDefinition.class));
    ImmutableFlowClassificationRuleView buildResult = builderResult.build();
    ImmutableFlowClassificationRuleView buildResult2 = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));
    ImmutableFlowClassificationRuleView buildResult = builderResult.build();
    ImmutableFlowClassificationRuleView buildResult2 = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addDataTypes(mock(DataType.class));
    ImmutableFlowClassificationRuleView buildResult = builderResult.build();
    ImmutableFlowClassificationRuleView buildResult2 = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addFlowClassifications(mock(FlowClassification.class));
    ImmutableFlowClassificationRuleView buildResult = builderResult.build();
    ImmutableFlowClassificationRuleView buildResult2 = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRuleView.equals(Object)",
      "int ImmutableFlowClassificationRuleView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableFlowClassificationRuleView");
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableFlowClassificationRule.Json} (default constructor).</li>
   *   <li>Then return flowClassificationRules is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet() add Json (default constructor); then return flowClassificationRules is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"})
  void testFromJson_givenHashSetAddJson_thenReturnFlowClassificationRulesIsHashSet() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRules = new HashSet<>();
    flowClassificationRules.add(new ImmutableFlowClassificationRule.Json());
    flowClassificationRules.add(new ImmutableFlowClassificationRule.Json());

    Json json = new Json();
    json.setFlowClassificationRules(flowClassificationRules);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(flowClassificationRules, actualFromJsonResult.flowClassificationRules());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, actualFromJsonResult.dataTypes());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.flowClassifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableFlowClassificationRule.Json} (default constructor).</li>
   *   <li>Then return flowClassificationRules size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet() add Json (default constructor); then return flowClassificationRules size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"})
  void testFromJson_givenHashSetAddJson_thenReturnFlowClassificationRulesSizeIsOne() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRules = new HashSet<>();
    flowClassificationRules.add(new ImmutableFlowClassificationRule.Json());

    Json json = new Json();
    json.setFlowClassificationRules(flowClassificationRules);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.flowClassificationRules().size());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, actualFromJsonResult.dataTypes());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.flowClassifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link DataType}.</li>
   *   <li>Then return dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add DataType; then return dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddDataType_thenReturnDataTypesSizeIsOne() {
    // Arrange
    LinkedHashSet<DataType> dataTypes = new LinkedHashSet<>();
    dataTypes.add(mock(DataType.class));

    Json json = new Json();
    json.setFlowClassificationRules(null);
    json.setAssessmentRatings(null);
    json.setPrimaryAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setDataTypes(dataTypes);
    json.setFlowClassifications(null);

    // Act and Assert
    assertEquals(1, ImmutableFlowClassificationRuleView.fromJson(json).dataTypes().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   * <ul>
   *   <li>Then return flowClassifications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return flowClassifications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"})
  void testFromJson_thenReturnFlowClassificationsSizeIsOne() {
    // Arrange
    LinkedHashSet<FlowClassification> flowClassifications = new LinkedHashSet<>();
    flowClassifications.add(mock(FlowClassification.class));

    Json json = new Json();
    json.setFlowClassificationRules(null);
    json.setAssessmentRatings(null);
    json.setPrimaryAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setDataTypes(null);
    json.setFlowClassifications(flowClassifications);

    // Act and Assert
    assertEquals(1, ImmutableFlowClassificationRuleView.fromJson(json).flowClassifications().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"})
  void testFromJson_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(mock(RatingSchemeItem.class));

    Json json = new Json();
    json.setFlowClassificationRules(null);
    json.setAssessmentRatings(null);
    json.setPrimaryAssessmentDefinitions(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setDataTypes(null);
    json.setFlowClassifications(null);

    // Act and Assert
    assertEquals(1, ImmutableFlowClassificationRuleView.fromJson(json).ratingSchemeItems().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return dataTypes is {@link Json} (default constructor) {@link Json#flowClassificationRules}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return dataTypes is Json (default constructor) flowClassificationRules")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnDataTypesIsJsonFlowClassificationRules() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    Set<FlowClassificationRule> flowClassificationRuleSet = json.flowClassificationRules;
    assertSame(flowClassificationRuleSet, actualFromJsonResult.dataTypes());
    assertSame(flowClassificationRuleSet, actualFromJsonResult.flowClassifications());
    assertSame(flowClassificationRuleSet, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(flowClassificationRuleSet, actualFromJsonResult.ratingSchemeItems());
    Set<RatingSchemeItem> expectedFlowClassificationRulesResult = json.ratingSchemeItems;
    assertSame(expectedFlowClassificationRulesResult, actualFromJsonResult.flowClassificationRules());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleView#toString()}
   *   <li>{@link ImmutableFlowClassificationRuleView#assessmentRatings()}
   *   <li>{@link ImmutableFlowClassificationRuleView#dataTypes()}
   *   <li>{@link ImmutableFlowClassificationRuleView#flowClassificationRules()}
   *   <li>{@link ImmutableFlowClassificationRuleView#flowClassifications()}
   *   <li>{@link ImmutableFlowClassificationRuleView#primaryAssessmentDefinitions()}
   *   <li>{@link ImmutableFlowClassificationRuleView#ratingSchemeItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableFlowClassificationRuleView.assessmentRatings()",
      "Set ImmutableFlowClassificationRuleView.dataTypes()",
      "Set ImmutableFlowClassificationRuleView.flowClassificationRules()",
      "Set ImmutableFlowClassificationRuleView.flowClassifications()",
      "Set ImmutableFlowClassificationRuleView.primaryAssessmentDefinitions()",
      "Set ImmutableFlowClassificationRuleView.ratingSchemeItems()",
      "String ImmutableFlowClassificationRuleView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<AssessmentRating> actualAssessmentRatingsResult = buildResult.assessmentRatings();
    Set<DataType> actualDataTypesResult = buildResult.dataTypes();
    Set<FlowClassificationRule> actualFlowClassificationRulesResult = buildResult.flowClassificationRules();
    Set<FlowClassification> actualFlowClassificationsResult = buildResult.flowClassifications();
    Set<AssessmentDefinition> actualPrimaryAssessmentDefinitionsResult = buildResult.primaryAssessmentDefinitions();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult = buildResult.ratingSchemeItems();

    // Assert
    assertEquals(
        "FlowClassificationRuleView{flowClassificationRules=[], assessmentRatings=[], primaryAssessmentDefinitions=[],"
            + " ratingSchemeItems=[], dataTypes=[], flowClassifications=[]}",
        actualToStringResult);
    assertTrue(actualAssessmentRatingsResult.isEmpty());
    assertSame(actualAssessmentRatingsResult, actualDataTypesResult);
    assertSame(actualAssessmentRatingsResult, actualFlowClassificationRulesResult);
    assertSame(actualAssessmentRatingsResult, actualFlowClassificationsResult);
    assertSame(actualAssessmentRatingsResult, actualPrimaryAssessmentDefinitionsResult);
    assertSame(actualAssessmentRatingsResult, actualRatingSchemeItemsResult);
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
   * Test Json {@link Json#dataTypes()}.
   * <p>
   * Method under test: {@link Json#dataTypes()}
   */
  @Test
  @DisplayName("Test Json dataTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.dataTypes()"})
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypes());
  }

  /**
   * Test Json {@link Json#flowClassificationRules()}.
   * <p>
   * Method under test: {@link Json#flowClassificationRules()}
   */
  @Test
  @DisplayName("Test Json flowClassificationRules()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.flowClassificationRules()"})
  void testJsonFlowClassificationRules() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowClassificationRules());
  }

  /**
   * Test Json {@link Json#flowClassifications()}.
   * <p>
   * Method under test: {@link Json#flowClassifications()}
   */
  @Test
  @DisplayName("Test Json flowClassifications()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.flowClassifications()"})
  void testJsonFlowClassifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowClassifications());
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
    assertTrue(actualJson.assessmentRatings.isEmpty());
    assertTrue(actualJson.dataTypes.isEmpty());
    assertTrue(actualJson.flowClassificationRules.isEmpty());
    assertTrue(actualJson.flowClassifications.isEmpty());
    assertTrue(actualJson.primaryAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Test Json {@link Json#primaryAssessmentDefinitions()}.
   * <p>
   * Method under test: {@link Json#primaryAssessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json primaryAssessmentDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.primaryAssessmentDefinitions()"})
  void testJsonPrimaryAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).primaryAssessmentDefinitions());
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
   * Test {@link ImmutableFlowClassificationRuleView#withAssessmentRatings(AssessmentRating[])} with {@code AssessmentRating[]}.
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#withAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withAssessmentRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withAssessmentRatings(AssessmentRating[])"})
  void testWithAssessmentRatingsWithAssessmentRating() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithAssessmentRatingsResult = buildResult
        .withAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, actualWithAssessmentRatingsResult.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualWithAssessmentRatingsResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualWithAssessmentRatingsResult.flowClassificationRules());
    assertSame(dataTypesResult, actualWithAssessmentRatingsResult.flowClassifications());
    assertSame(dataTypesResult, actualWithAssessmentRatingsResult.primaryAssessmentDefinitions());
    assertSame(dataTypesResult, actualWithAssessmentRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withDataTypes(DataType[])} with {@code DataType[]}.
   * <ul>
   *   <li>When {@link DataType}.</li>
   *   <li>Then return dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#withDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test withDataTypes(DataType[]) with 'DataType[]'; when DataType; then return dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withDataTypes(DataType[])"})
  void testWithDataTypesWithDataType_whenDataType_thenReturnDataTypesSizeIsOne() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithDataTypesResult = buildResult.withDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, actualWithDataTypesResult.dataTypes().size());
    Set<AssessmentRating> assessmentRatingsResult = actualWithDataTypesResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithDataTypesResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualWithDataTypesResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualWithDataTypesResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualWithDataTypesResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withFlowClassificationRules(FlowClassificationRule[])} with {@code FlowClassificationRule[]}.
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#withFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  @DisplayName("Test withFlowClassificationRules(FlowClassificationRule[]) with 'FlowClassificationRule[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withFlowClassificationRules(FlowClassificationRule[])"})
  void testWithFlowClassificationRulesWithFlowClassificationRule() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithFlowClassificationRulesResult = buildResult
        .withFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, actualWithFlowClassificationRulesResult.flowClassificationRules().size());
    Set<AssessmentRating> assessmentRatingsResult = actualWithFlowClassificationRulesResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationRulesResult.dataTypes());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationRulesResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationRulesResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationRulesResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withFlowClassifications(FlowClassification[])} with {@code FlowClassification[]}.
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#withFlowClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test withFlowClassifications(FlowClassification[]) with 'FlowClassification[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withFlowClassifications(FlowClassification[])"})
  void testWithFlowClassificationsWithFlowClassification() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithFlowClassificationsResult = buildResult
        .withFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, actualWithFlowClassificationsResult.flowClassifications().size());
    Set<AssessmentRating> assessmentRatingsResult = actualWithFlowClassificationsResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationsResult.dataTypes());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationsResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationsResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withPrimaryAssessmentDefinitions(AssessmentDefinition[])} with {@code AssessmentDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#withPrimaryAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test withPrimaryAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withPrimaryAssessmentDefinitions(AssessmentDefinition[])"})
  void testWithPrimaryAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithPrimaryAssessmentDefinitionsResult = buildResult
        .withPrimaryAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, actualWithPrimaryAssessmentDefinitionsResult.primaryAssessmentDefinitions().size());
    Set<AssessmentRating> assessmentRatingsResult = actualWithPrimaryAssessmentDefinitionsResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithPrimaryAssessmentDefinitionsResult.dataTypes());
    assertSame(assessmentRatingsResult, actualWithPrimaryAssessmentDefinitionsResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualWithPrimaryAssessmentDefinitionsResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualWithPrimaryAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withRatingSchemeItems(RatingSchemeItem[])} with {@code RatingSchemeItem[]}.
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRuleView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withRatingSchemeItems(RatingSchemeItem[])"})
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableFlowClassificationRuleView buildResult = ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithRatingSchemeItemsResult = buildResult
        .withRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    Set<AssessmentRating> assessmentRatingsResult = actualWithRatingSchemeItemsResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithRatingSchemeItemsResult.dataTypes());
    assertSame(assessmentRatingsResult, actualWithRatingSchemeItemsResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualWithRatingSchemeItemsResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualWithRatingSchemeItemsResult.primaryAssessmentDefinitions());
  }
}
