package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentRatings() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAllDataTypes(Iterable)}
   */
  @Test
  void testBuilderAddAllDataTypes() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAllFlowClassificationRules(Iterable)}
   */
  @Test
  void testBuilderAddAllFlowClassificationRules() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFlowClassificationRules(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAllFlowClassificationRules(Iterable)}
   */
  @Test
  void testBuilderAddAllFlowClassificationRules2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFlowClassificationRules(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAllFlowClassifications(Iterable)}
   */
  @Test
  void testBuilderAddAllFlowClassifications() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFlowClassifications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAllPrimaryAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllPrimaryAssessmentDefinitions() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPrimaryAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingSchemeItems() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAssessmentRatings(AssessmentRating)}
   */
  @Test
  void testBuilderAddAssessmentRatings() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddAssessmentRatingsResult = builderResult
        .addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addAssessmentRatings(AssessmentRating[])}
   */
  @Test
  void testBuilderAddAssessmentRatings2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddAssessmentRatingsResult = builderResult
        .addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addDataTypes(DataType)}
   */
  @Test
  void testBuilderAddDataTypes() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddDataTypesResult = builderResult
        .addDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addDataTypes(DataType[])}
   */
  @Test
  void testBuilderAddDataTypes2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddDataTypesResult = builderResult
        .addDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addFlowClassificationRules(FlowClassificationRule)}
   */
  @Test
  void testBuilderAddFlowClassificationRules() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addFlowClassificationRules(FlowClassificationRule)}
   */
  @Test
  void testBuilderAddFlowClassificationRules2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  void testBuilderAddFlowClassificationRules3() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  void testBuilderAddFlowClassificationRules4() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addFlowClassifications(FlowClassification)}
   */
  @Test
  void testBuilderAddFlowClassifications() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddFlowClassificationsResult = builderResult
        .addFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addFlowClassifications(FlowClassification[])}
   */
  @Test
  void testBuilderAddFlowClassifications2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddFlowClassificationsResult = builderResult
        .addFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  void testBuilderAddPrimaryAssessmentDefinitions() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddPrimaryAssessmentDefinitionsResult = builderResult
        .addPrimaryAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().primaryAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPrimaryAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  void testBuilderAddPrimaryAssessmentDefinitions2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddPrimaryAssessmentDefinitionsResult = builderResult
        .addPrimaryAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().primaryAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPrimaryAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  void testBuilderAddRatingSchemeItems() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  void testBuilderAddRatingSchemeItems2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    ImmutableFlowClassificationRuleView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#assessmentRatings(Iterable)}
   */
  @Test
  void testBuilderAssessmentRatings() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableFlowClassificationRuleView.builder().build().assessmentRatings().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#dataTypes(Iterable)}
   */
  @Test
  void testBuilderDataTypes() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#flowClassificationRules(Iterable)}
   */
  @Test
  void testBuilderFlowClassificationRules() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRules(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#flowClassificationRules(Iterable)}
   */
  @Test
  void testBuilderFlowClassificationRules2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addAssessmentRatings(mock(AssessmentRating.class));

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRules(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#flowClassifications(Iterable)}
   */
  @Test
  void testBuilderFlowClassifications() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassifications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#from(FlowClassificationRuleView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#from(FlowClassificationRuleView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(assessmentRatingSet);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#from(FlowClassificationRuleView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(mock(DataType.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(dataTypeSet);
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#from(FlowClassificationRuleView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(new ImmutableFlowClassificationRule.Json());
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(flowClassificationRuleSet);
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#from(FlowClassificationRuleView)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(mock(FlowClassification.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(flowClassificationSet);
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#from(FlowClassificationRuleView)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().primaryAssessmentDefinitions().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#from(FlowClassificationRuleView)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableFlowClassificationRuleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#primaryAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderPrimaryAssessmentDefinitions() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderRatingSchemeItems() {
    // Arrange
    ImmutableFlowClassificationRuleView.Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.dataTypes());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualCopyOfResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(assessmentRatingSet);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualCopyOfResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassificationRules());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassifications());
    assertSame(dataTypesResult, actualCopyOfResult.primaryAssessmentDefinitions());
    assertSame(dataTypesResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    assessmentRatingSet.add(mock(AssessmentRating.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(assessmentRatingSet);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    Set<DataType> dataTypesResult = actualCopyOfResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertEquals(assessmentRatingSet, actualCopyOfResult.assessmentRatings());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassificationRules());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassifications());
    assertSame(dataTypesResult, actualCopyOfResult.primaryAssessmentDefinitions());
    assertSame(dataTypesResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(mock(DataType.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(dataTypeSet);
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.dataTypes().size());
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualCopyOfResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(new ImmutableFlowClassificationRule.Json());
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(flowClassificationRuleSet);
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.flowClassificationRules().size());
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.dataTypes());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualCopyOfResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(mock(FlowClassification.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(flowClassificationSet);
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.flowClassifications().size());
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.dataTypes());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualCopyOfResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.primaryAssessmentDefinitions().size());
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.dataTypes());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    FlowClassificationRuleView instance = mock(FlowClassificationRuleView.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult = ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    verify(instance).primaryAssessmentDefinitions();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.ratingSchemeItems().size());
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.dataTypes());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualCopyOfResult.primaryAssessmentDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#fromJson(ImmutableFlowClassificationRuleView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableFlowClassificationRuleView.Json json = new ImmutableFlowClassificationRuleView.Json();

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, assessmentRatingsResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.dataTypes());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.flowClassificationRules());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.flowClassifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#fromJson(ImmutableFlowClassificationRuleView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableFlowClassificationRuleView.Json json = new ImmutableFlowClassificationRuleView.Json();
    json.setFlowClassificationRules(null);
    json.setAssessmentRatings(null);
    json.setPrimaryAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setDataTypes(null);
    json.setFlowClassifications(null);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualFromJsonResult.dataTypes());
    assertSame(assessmentRatingsResult, actualFromJsonResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualFromJsonResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#fromJson(ImmutableFlowClassificationRuleView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<FlowClassification> flowClassifications = new LinkedHashSet<>();
    flowClassifications.add(mock(FlowClassification.class));

    ImmutableFlowClassificationRuleView.Json json = new ImmutableFlowClassificationRuleView.Json();
    json.setFlowClassificationRules(null);
    json.setAssessmentRatings(null);
    json.setPrimaryAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setDataTypes(null);
    json.setFlowClassifications(flowClassifications);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.flowClassifications().size());
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualFromJsonResult.dataTypes());
    assertSame(assessmentRatingsResult, actualFromJsonResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#fromJson(ImmutableFlowClassificationRuleView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<DataType> dataTypes = new LinkedHashSet<>();
    dataTypes.add(mock(DataType.class));

    ImmutableFlowClassificationRuleView.Json json = new ImmutableFlowClassificationRuleView.Json();
    json.setFlowClassificationRules(null);
    json.setAssessmentRatings(null);
    json.setPrimaryAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setDataTypes(dataTypes);
    json.setFlowClassifications(null);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypes().size());
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualFromJsonResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualFromJsonResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#fromJson(ImmutableFlowClassificationRuleView.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(mock(RatingSchemeItem.class));

    ImmutableFlowClassificationRuleView.Json json = new ImmutableFlowClassificationRuleView.Json();
    json.setFlowClassificationRules(null);
    json.setAssessmentRatings(null);
    json.setPrimaryAssessmentDefinitions(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setDataTypes(null);
    json.setFlowClassifications(null);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualFromJsonResult.dataTypes());
    assertSame(assessmentRatingsResult, actualFromJsonResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualFromJsonResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualFromJsonResult.primaryAssessmentDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#fromJson(ImmutableFlowClassificationRuleView.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRules = new HashSet<>();
    flowClassificationRules.add(new ImmutableFlowClassificationRule.Json());

    ImmutableFlowClassificationRuleView.Json json = new ImmutableFlowClassificationRuleView.Json();
    json.setFlowClassificationRules(flowClassificationRules);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.flowClassificationRules().size());
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, assessmentRatingsResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.dataTypes());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.flowClassifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView#fromJson(ImmutableFlowClassificationRuleView.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRules = new HashSet<>();
    flowClassificationRules.add(new ImmutableFlowClassificationRule.Json());
    flowClassificationRules.add(new ImmutableFlowClassificationRule.Json());

    ImmutableFlowClassificationRuleView.Json json = new ImmutableFlowClassificationRuleView.Json();
    json.setFlowClassificationRules(flowClassificationRules);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult = ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertEquals(flowClassificationRules, actualFromJsonResult.flowClassificationRules());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, assessmentRatingsResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.dataTypes());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.flowClassifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Json#assessmentRatings()}
   */
  @Test
  void testJsonAssessmentRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleView.Json()).assessmentRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Json#dataTypes()}
   */
  @Test
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleView.Json()).dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Json#flowClassificationRules()}
   */
  @Test
  void testJsonFlowClassificationRules() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleView.Json()).flowClassificationRules());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Json#flowClassifications()}
   */
  @Test
  void testJsonFlowClassifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleView.Json()).flowClassifications());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowClassificationRuleView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowClassificationRuleView.Json actualJson = new ImmutableFlowClassificationRuleView.Json();

    // Assert
    assertTrue(actualJson.assessmentRatings.isEmpty());
    assertTrue(actualJson.dataTypes.isEmpty());
    assertTrue(actualJson.flowClassificationRules.isEmpty());
    assertTrue(actualJson.flowClassifications.isEmpty());
    assertTrue(actualJson.primaryAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Json#primaryAssessmentDefinitions()}
   */
  @Test
  void testJsonPrimaryAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleView.Json()).primaryAssessmentDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleView.Json#ratingSchemeItems()}
   */
  @Test
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleView.Json()).ratingSchemeItems());
  }
}
