package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllLogicalFlowAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllLogicalFlowAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllLogicalFlowAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllLogicalFlowDataTypeDecorators(Iterable)}
   */
  @Test
  void testBuilderAddAllLogicalFlowDataTypeDecorators() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllLogicalFlowDataTypeDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllLogicalFlowRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllLogicalFlowRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllLogicalFlowRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllLogicalFlows(Iterable)}
   */
  @Test
  void testBuilderAddAllLogicalFlows() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllLogicalFlows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllLogicalFlows(Iterable)}
   */
  @Test
  void testBuilderAddAllLogicalFlows2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalFlows(mock(PhysicalFlow.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllLogicalFlows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllPhysicalFlowAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllPhysicalFlowAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPhysicalFlowAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllPhysicalFlowRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllPhysicalFlowRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPhysicalFlowRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllPhysicalFlows(Iterable)}
   */
  @Test
  void testBuilderAddAllPhysicalFlows() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPhysicalFlows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllPhysicalSpecificationAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllPhysicalSpecificationAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPhysicalSpecificationAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllPhysicalSpecificationDataTypeDecorators(Iterable)}
   */
  @Test
  void testBuilderAddAllPhysicalSpecificationDataTypeDecorators() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPhysicalSpecificationDataTypeDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllPhysicalSpecificationRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllPhysicalSpecificationRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPhysicalSpecificationRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllPhysicalSpecifications(Iterable)}
   */
  @Test
  void testBuilderAddAllPhysicalSpecifications() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPhysicalSpecifications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingSchemeItems() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  void testBuilderAddLogicalFlowAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowAssessmentDefinitionsResult = builderResult
        .addLogicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddLogicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  void testBuilderAddLogicalFlowAssessmentDefinitions2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowAssessmentDefinitionsResult = builderResult
        .addLogicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddLogicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  void testBuilderAddLogicalFlowDataTypeDecorators() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowDataTypeDecoratorsResult = builderResult
        .addLogicalFlowDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowDataTypeDecorators().size());
    assertSame(builderResult, actualAddLogicalFlowDataTypeDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  void testBuilderAddLogicalFlowDataTypeDecorators2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowDataTypeDecoratorsResult = builderResult
        .addLogicalFlowDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowDataTypeDecorators().size());
    assertSame(builderResult, actualAddLogicalFlowDataTypeDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlowRatings(AssessmentRating)}
   */
  @Test
  void testBuilderAddLogicalFlowRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowRatingsResult = builderResult
        .addLogicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowRatings().size());
    assertSame(builderResult, actualAddLogicalFlowRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlowRatings(AssessmentRating[])}
   */
  @Test
  void testBuilderAddLogicalFlowRatings2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowRatingsResult = builderResult
        .addLogicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowRatings().size());
    assertSame(builderResult, actualAddLogicalFlowRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlows(LogicalFlow)}
   */
  @Test
  void testBuilderAddLogicalFlows() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowsResult = builderResult
        .addLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualAddLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlows(LogicalFlow)}
   */
  @Test
  void testBuilderAddLogicalFlows2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalFlows(mock(PhysicalFlow.class));

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowsResult = builderResult
        .addLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualAddLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlows(LogicalFlow[])}
   */
  @Test
  void testBuilderAddLogicalFlows3() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowsResult = builderResult
        .addLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualAddLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addLogicalFlows(LogicalFlow[])}
   */
  @Test
  void testBuilderAddLogicalFlows4() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalFlows(mock(PhysicalFlow.class));

    // Act
    ImmutableLogicalFlowView.Builder actualAddLogicalFlowsResult = builderResult
        .addLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualAddLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  void testBuilderAddPhysicalFlowAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalFlowAssessmentDefinitionsResult = builderResult
        .addPhysicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  void testBuilderAddPhysicalFlowAssessmentDefinitions2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalFlowAssessmentDefinitionsResult = builderResult
        .addPhysicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalFlowRatings(AssessmentRating)}
   */
  @Test
  void testBuilderAddPhysicalFlowRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalFlowRatingsResult = builderResult
        .addPhysicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlowRatings().size());
    assertSame(builderResult, actualAddPhysicalFlowRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalFlowRatings(AssessmentRating[])}
   */
  @Test
  void testBuilderAddPhysicalFlowRatings2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalFlowRatingsResult = builderResult
        .addPhysicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlowRatings().size());
    assertSame(builderResult, actualAddPhysicalFlowRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalFlows(PhysicalFlow)}
   */
  @Test
  void testBuilderAddPhysicalFlows() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalFlowsResult = builderResult
        .addPhysicalFlows(mock(PhysicalFlow.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlows().size());
    assertSame(builderResult, actualAddPhysicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalFlows(PhysicalFlow[])}
   */
  @Test
  void testBuilderAddPhysicalFlows2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalFlowsResult = builderResult
        .addPhysicalFlows(mock(PhysicalFlow.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlows().size());
    assertSame(builderResult, actualAddPhysicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  void testBuilderAddPhysicalSpecificationAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalSpecificationAssessmentDefinitionsResult = builderResult
        .addPhysicalSpecificationAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalSpecificationAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  void testBuilderAddPhysicalSpecificationAssessmentDefinitions2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalSpecificationAssessmentDefinitionsResult = builderResult
        .addPhysicalSpecificationAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalSpecificationAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  void testBuilderAddPhysicalSpecificationDataTypeDecorators() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalSpecificationDataTypeDecoratorsResult = builderResult
        .addPhysicalSpecificationDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationDataTypeDecorators().size());
    assertSame(builderResult, actualAddPhysicalSpecificationDataTypeDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  void testBuilderAddPhysicalSpecificationDataTypeDecorators2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalSpecificationDataTypeDecoratorsResult = builderResult
        .addPhysicalSpecificationDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationDataTypeDecorators().size());
    assertSame(builderResult, actualAddPhysicalSpecificationDataTypeDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalSpecificationRatings(AssessmentRating)}
   */
  @Test
  void testBuilderAddPhysicalSpecificationRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalSpecificationRatingsResult = builderResult
        .addPhysicalSpecificationRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationRatings().size());
    assertSame(builderResult, actualAddPhysicalSpecificationRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalSpecificationRatings(AssessmentRating[])}
   */
  @Test
  void testBuilderAddPhysicalSpecificationRatings2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalSpecificationRatingsResult = builderResult
        .addPhysicalSpecificationRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationRatings().size());
    assertSame(builderResult, actualAddPhysicalSpecificationRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalSpecifications(PhysicalSpecification)}
   */
  @Test
  void testBuilderAddPhysicalSpecifications() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalSpecificationsResult = builderResult
        .addPhysicalSpecifications(mock(PhysicalSpecification.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecifications().size());
    assertSame(builderResult, actualAddPhysicalSpecificationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addPhysicalSpecifications(PhysicalSpecification[])}
   */
  @Test
  void testBuilderAddPhysicalSpecifications2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddPhysicalSpecificationsResult = builderResult
        .addPhysicalSpecifications(mock(PhysicalSpecification.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecifications().size());
    assertSame(builderResult, actualAddPhysicalSpecificationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  void testBuilderAddRatingSchemeItems() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  void testBuilderAddRatingSchemeItems2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    ImmutableLogicalFlowView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableLogicalFlowView.builder().build().logicalFlowAssessmentDefinitions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().logicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<DataTypeDecorator> dataTypeDecoratorSet = new HashSet<>();
    dataTypeDecoratorSet.add(mock(DataTypeDecorator.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(dataTypeDecoratorSet);
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().logicalFlowDataTypeDecorators().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(assessmentRatingSet);
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().logicalFlowRatings().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<LogicalFlow> logicalFlowSet = new HashSet<>();
    logicalFlowSet.add(new ImmutableLogicalFlow.Json());
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(logicalFlowSet);
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().physicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(assessmentRatingSet);
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().physicalFlowRatings().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<PhysicalFlow> physicalFlowSet = new HashSet<>();
    physicalFlowSet.add(mock(PhysicalFlow.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(physicalFlowSet);
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().physicalFlows().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().physicalSpecificationAssessmentDefinitions().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<DataTypeDecorator> dataTypeDecoratorSet = new HashSet<>();
    dataTypeDecoratorSet.add(mock(DataTypeDecorator.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(dataTypeDecoratorSet);
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().physicalSpecificationDataTypeDecorators().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(assessmentRatingSet);
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().physicalSpecificationRatings().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    physicalSpecificationSet.add(mock(PhysicalSpecification.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(physicalSpecificationSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().physicalSpecifications().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#from(LogicalFlowView)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableLogicalFlowView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#logicalFlowAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderLogicalFlowAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#logicalFlowDataTypeDecorators(Iterable)}
   */
  @Test
  void testBuilderLogicalFlowDataTypeDecorators() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowDataTypeDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#logicalFlowRatings(Iterable)}
   */
  @Test
  void testBuilderLogicalFlowRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#logicalFlows(Iterable)}
   */
  @Test
  void testBuilderLogicalFlows() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#logicalFlows(Iterable)}
   */
  @Test
  void testBuilderLogicalFlows2() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalFlows(mock(PhysicalFlow.class));

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#physicalFlowAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderPhysicalFlowAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalFlowAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#physicalFlowRatings(Iterable)}
   */
  @Test
  void testBuilderPhysicalFlowRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalFlowRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#physicalFlows(Iterable)}
   */
  @Test
  void testBuilderPhysicalFlows() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalFlows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#physicalSpecificationAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderPhysicalSpecificationAssessmentDefinitions() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalSpecificationAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#physicalSpecificationDataTypeDecorators(Iterable)}
   */
  @Test
  void testBuilderPhysicalSpecificationDataTypeDecorators() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalSpecificationDataTypeDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#physicalSpecificationRatings(Iterable)}
   */
  @Test
  void testBuilderPhysicalSpecificationRatings() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalSpecificationRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#physicalSpecifications(Iterable)}
   */
  @Test
  void testBuilderPhysicalSpecifications() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalSpecifications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderRatingSchemeItems() {
    // Arrange
    ImmutableLogicalFlowView.Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.logicalFlowAssessmentDefinitions().size());
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult = actualCopyOfResult.logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult = actualCopyOfResult.logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertEquals(assessmentDefinitionSet, actualCopyOfResult.logicalFlowAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<DataTypeDecorator> dataTypeDecoratorSet = new HashSet<>();
    dataTypeDecoratorSet.add(mock(DataTypeDecorator.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(dataTypeDecoratorSet);
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.logicalFlowDataTypeDecorators().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(assessmentRatingSet);
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.logicalFlowRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<LogicalFlow> logicalFlowSet = new HashSet<>();
    logicalFlowSet.add(new ImmutableLogicalFlow.Json());
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(logicalFlowSet);
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.logicalFlows().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.physicalFlowAssessmentDefinitions().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(assessmentRatingSet);
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.physicalFlowRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
    HashSet<PhysicalFlow> physicalFlowSet = new HashSet<>();
    physicalFlowSet.add(mock(PhysicalFlow.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(physicalFlowSet);
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.physicalFlows().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf10() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.physicalSpecificationAssessmentDefinitions().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf11() {
    // Arrange
    HashSet<DataTypeDecorator> dataTypeDecoratorSet = new HashSet<>();
    dataTypeDecoratorSet.add(mock(DataTypeDecorator.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(dataTypeDecoratorSet);
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.physicalSpecificationDataTypeDecorators().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf12() {
    // Arrange
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(assessmentRatingSet);
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.physicalSpecificationRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf13() {
    // Arrange
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    physicalSpecificationSet.add(mock(PhysicalSpecification.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(physicalSpecificationSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.physicalSpecifications().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  void testCopyOf14() {
    // Arrange
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    LogicalFlowView instance = mock(LogicalFlowView.class);
    when(instance.logicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.logicalFlowDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.logicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.logicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalFlowAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalFlowRatings()).thenReturn(new HashSet<>());
    when(instance.physicalFlows()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationAssessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationDataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.physicalSpecificationRatings()).thenReturn(new HashSet<>());
    when(instance.physicalSpecifications()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    verify(instance).logicalFlowAssessmentDefinitions();
    verify(instance).logicalFlowDataTypeDecorators();
    verify(instance).logicalFlowRatings();
    verify(instance).logicalFlows();
    verify(instance).physicalFlowAssessmentDefinitions();
    verify(instance).physicalFlowRatings();
    verify(instance).physicalFlows();
    verify(instance).physicalSpecificationAssessmentDefinitions();
    verify(instance).physicalSpecificationDataTypeDecorators();
    verify(instance).physicalSpecificationRatings();
    verify(instance).physicalSpecifications();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.ratingSchemeItems().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualCopyOfResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView#fromJson(ImmutableLogicalFlowView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLogicalFlowView.Json json = new ImmutableLogicalFlowView.Json();

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualFromJsonResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, logicalFlowAssessmentDefinitionsResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlows());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlows());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView#fromJson(ImmutableLogicalFlowView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    HashSet<LogicalFlow> logicalFlows = new HashSet<>();
    logicalFlows.add(new ImmutableLogicalFlow.Json());

    ImmutableLogicalFlowView.Json json = new ImmutableLogicalFlowView.Json();
    json.setLogicalFlows(logicalFlows);

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.logicalFlows().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualFromJsonResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, logicalFlowAssessmentDefinitionsResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlows());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView#fromJson(ImmutableLogicalFlowView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    HashSet<LogicalFlow> logicalFlows = new HashSet<>();
    logicalFlows.add(new ImmutableLogicalFlow.Json());
    logicalFlows.add(new ImmutableLogicalFlow.Json());

    ImmutableLogicalFlowView.Json json = new ImmutableLogicalFlowView.Json();
    json.setLogicalFlows(logicalFlows);

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualFromJsonResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertEquals(logicalFlows, actualFromJsonResult.logicalFlows());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, logicalFlowAssessmentDefinitionsResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlows());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView#fromJson(ImmutableLogicalFlowView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableLogicalFlow.Json json = new ImmutableLogicalFlow.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    HashSet<LogicalFlow> logicalFlows = new HashSet<>();
    logicalFlows.add(json);

    ImmutableLogicalFlowView.Json json2 = new ImmutableLogicalFlowView.Json();
    json2.setLogicalFlows(logicalFlows);

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.logicalFlows().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualFromJsonResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json2.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, logicalFlowAssessmentDefinitionsResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlows());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Json#logicalFlowAssessmentDefinitions()}
   */
  @Test
  void testJsonLogicalFlowAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowView.Json()).logicalFlowAssessmentDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Json#logicalFlowDataTypeDecorators()}
   */
  @Test
  void testJsonLogicalFlowDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowView.Json()).logicalFlowDataTypeDecorators());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView.Json#logicalFlowRatings()}
   */
  @Test
  void testJsonLogicalFlowRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowView.Json()).logicalFlowRatings());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView.Json#logicalFlows()}
   */
  @Test
  void testJsonLogicalFlows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowView.Json()).logicalFlows());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLogicalFlowView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLogicalFlowView.Json actualJson = new ImmutableLogicalFlowView.Json();

    // Assert
    assertTrue(actualJson.logicalFlowAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.logicalFlowDataTypeDecorators.isEmpty());
    assertTrue(actualJson.logicalFlowRatings.isEmpty());
    assertTrue(actualJson.logicalFlows.isEmpty());
    assertTrue(actualJson.physicalFlowAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.physicalFlowRatings.isEmpty());
    assertTrue(actualJson.physicalFlows.isEmpty());
    assertTrue(actualJson.physicalSpecificationAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.physicalSpecificationDataTypeDecorators.isEmpty());
    assertTrue(actualJson.physicalSpecificationRatings.isEmpty());
    assertTrue(actualJson.physicalSpecifications.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Json#physicalFlowAssessmentDefinitions()}
   */
  @Test
  void testJsonPhysicalFlowAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowView.Json()).physicalFlowAssessmentDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Json#physicalFlowRatings()}
   */
  @Test
  void testJsonPhysicalFlowRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowView.Json()).physicalFlowRatings());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView.Json#physicalFlows()}
   */
  @Test
  void testJsonPhysicalFlows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowView.Json()).physicalFlows());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Json#physicalSpecificationAssessmentDefinitions()}
   */
  @Test
  void testJsonPhysicalSpecificationAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowView.Json()).physicalSpecificationAssessmentDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Json#physicalSpecificationDataTypeDecorators()}
   */
  @Test
  void testJsonPhysicalSpecificationDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowView.Json()).physicalSpecificationDataTypeDecorators());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Json#physicalSpecificationRatings()}
   */
  @Test
  void testJsonPhysicalSpecificationRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowView.Json()).physicalSpecificationRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowView.Json#physicalSpecifications()}
   */
  @Test
  void testJsonPhysicalSpecifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowView.Json()).physicalSpecifications());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowView.Json#ratingSchemeItems()}
   */
  @Test
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowView.Json()).ratingSchemeItems());
  }
}
