package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowView.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowView.Json;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllLogicalFlowAssessmentDefinitions(Iterable)}.
   * <p>
   * Method under test: {@link Builder#addAllLogicalFlowAssessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllLogicalFlowAssessmentDefinitions(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllLogicalFlowAssessmentDefinitions(Iterable)"})
  void testBuilderAddAllLogicalFlowAssessmentDefinitions() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    ImmutableLogicalFlowView buildResult = builderResult.addAllLogicalFlowAssessmentDefinitions(new ArrayList<>())
        .build();
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = buildResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLogicalFlowAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddLogicalFlowAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowAssessmentDefinitionsResult = builderResult
        .addLogicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddLogicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLogicalFlowAssessmentDefinitions(AssessmentDefinition[])"})
  void testBuilderAddLogicalFlowAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowAssessmentDefinitionsResult = builderResult
        .addLogicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddLogicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowDataTypeDecorators(DataTypeDecorator) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLogicalFlowDataTypeDecorators(DataTypeDecorator)"})
  void testBuilderAddLogicalFlowDataTypeDecoratorsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowDataTypeDecoratorsResult = builderResult
        .addLogicalFlowDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowDataTypeDecorators().size());
    assertSame(builderResult, actualAddLogicalFlowDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowDataTypeDecorators(DataTypeDecorator[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLogicalFlowDataTypeDecorators(DataTypeDecorator[])"})
  void testBuilderAddLogicalFlowDataTypeDecoratorsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowDataTypeDecoratorsResult = builderResult
        .addLogicalFlowDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowDataTypeDecorators().size());
    assertSame(builderResult, actualAddLogicalFlowDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowRatings(AssessmentRating)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addLogicalFlowRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowRatings(AssessmentRating) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLogicalFlowRatings(AssessmentRating)"})
  void testBuilderAddLogicalFlowRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowRatingsResult = builderResult.addLogicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowRatings().size());
    assertSame(builderResult, actualAddLogicalFlowRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowRatings(AssessmentRating[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addLogicalFlowRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowRatings(AssessmentRating[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLogicalFlowRatings(AssessmentRating[])"})
  void testBuilderAddLogicalFlowRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowRatingsResult = builderResult.addLogicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().logicalFlowRatings().size());
    assertSame(builderResult, actualAddLogicalFlowRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlows(LogicalFlow)} with {@code element}.
   * <ul>
   *   <li>Then builder build logicalFlows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addLogicalFlows(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlows(LogicalFlow) with 'element'; then builder build logicalFlows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLogicalFlows(LogicalFlow)"})
  void testBuilderAddLogicalFlowsWithElement_thenBuilderBuildLogicalFlowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowsResult = builderResult.addLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualAddLogicalFlowsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlows(LogicalFlow[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build logicalFlows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addLogicalFlows(LogicalFlow[])}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlows(LogicalFlow[]) with 'elements'; then builder build logicalFlows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLogicalFlows(LogicalFlow[])"})
  void testBuilderAddLogicalFlowsWithElements_thenBuilderBuildLogicalFlowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowsResult = builderResult.addLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualAddLogicalFlowsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalFlowAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalFlowAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddPhysicalFlowAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalFlowAssessmentDefinitionsResult = builderResult
        .addPhysicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])"})
  void testBuilderAddPhysicalFlowAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalFlowAssessmentDefinitionsResult = builderResult
        .addPhysicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlowRatings(AssessmentRating)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPhysicalFlowRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalFlowRatings(AssessmentRating) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalFlowRatings(AssessmentRating)"})
  void testBuilderAddPhysicalFlowRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalFlowRatingsResult = builderResult.addPhysicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlowRatings().size());
    assertSame(builderResult, actualAddPhysicalFlowRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlowRatings(AssessmentRating[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPhysicalFlowRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalFlowRatings(AssessmentRating[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalFlowRatings(AssessmentRating[])"})
  void testBuilderAddPhysicalFlowRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalFlowRatingsResult = builderResult.addPhysicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlowRatings().size());
    assertSame(builderResult, actualAddPhysicalFlowRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlows(PhysicalFlow)} with {@code element}.
   * <ul>
   *   <li>Then builder build physicalFlows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addPhysicalFlows(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalFlows(PhysicalFlow) with 'element'; then builder build physicalFlows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalFlows(PhysicalFlow)"})
  void testBuilderAddPhysicalFlowsWithElement_thenBuilderBuildPhysicalFlowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalFlowsResult = builderResult.addPhysicalFlows(mock(PhysicalFlow.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlows().size());
    assertSame(builderResult, actualAddPhysicalFlowsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlows(PhysicalFlow[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build physicalFlows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addPhysicalFlows(PhysicalFlow[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalFlows(PhysicalFlow[]) with 'elements'; then builder build physicalFlows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalFlows(PhysicalFlow[])"})
  void testBuilderAddPhysicalFlowsWithElements_thenBuilderBuildPhysicalFlowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalFlowsResult = builderResult.addPhysicalFlows(mock(PhysicalFlow.class));

    // Assert
    assertEquals(1, builderResult.build().physicalFlows().size());
    assertSame(builderResult, actualAddPhysicalFlowsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddPhysicalSpecificationAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalSpecificationAssessmentDefinitionsResult = builderResult
        .addPhysicalSpecificationAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalSpecificationAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])"})
  void testBuilderAddPhysicalSpecificationAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalSpecificationAssessmentDefinitionsResult = builderResult
        .addPhysicalSpecificationAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalSpecificationAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator)"})
  void testBuilderAddPhysicalSpecificationDataTypeDecoratorsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalSpecificationDataTypeDecoratorsResult = builderResult
        .addPhysicalSpecificationDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationDataTypeDecorators().size());
    assertSame(builderResult, actualAddPhysicalSpecificationDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])"})
  void testBuilderAddPhysicalSpecificationDataTypeDecoratorsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalSpecificationDataTypeDecoratorsResult = builderResult
        .addPhysicalSpecificationDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationDataTypeDecorators().size());
    assertSame(builderResult, actualAddPhysicalSpecificationDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationRatings(AssessmentRating)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPhysicalSpecificationRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecificationRatings(AssessmentRating) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecificationRatings(AssessmentRating)"})
  void testBuilderAddPhysicalSpecificationRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalSpecificationRatingsResult = builderResult
        .addPhysicalSpecificationRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationRatings().size());
    assertSame(builderResult, actualAddPhysicalSpecificationRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationRatings(AssessmentRating[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPhysicalSpecificationRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecificationRatings(AssessmentRating[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecificationRatings(AssessmentRating[])"})
  void testBuilderAddPhysicalSpecificationRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalSpecificationRatingsResult = builderResult
        .addPhysicalSpecificationRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationRatings().size());
    assertSame(builderResult, actualAddPhysicalSpecificationRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecifications(PhysicalSpecification)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPhysicalSpecifications(PhysicalSpecification)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecifications(PhysicalSpecification) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecifications(PhysicalSpecification)"})
  void testBuilderAddPhysicalSpecificationsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalSpecificationsResult = builderResult
        .addPhysicalSpecifications(mock(PhysicalSpecification.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecifications().size());
    assertSame(builderResult, actualAddPhysicalSpecificationsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecifications(PhysicalSpecification[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPhysicalSpecifications(PhysicalSpecification[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecifications(PhysicalSpecification[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecifications(PhysicalSpecification[])"})
  void testBuilderAddPhysicalSpecificationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddPhysicalSpecificationsResult = builderResult
        .addPhysicalSpecifications(mock(PhysicalSpecification.class));

    // Assert
    assertEquals(1, builderResult.build().physicalSpecifications().size());
    assertSame(builderResult, actualAddPhysicalSpecificationsResult);
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
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableLogicalFlowView.builder().build().logicalFlowAssessmentDefinitions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addPhysicalSpecificationAssessmentDefinitions(mock(AssessmentDefinition.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().physicalSpecificationAssessmentDefinitions().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build logicalFlowAssessmentDefinitions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build logicalFlowAssessmentDefinitions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildLogicalFlowAssessmentDefinitionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addLogicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    ImmutableLogicalFlowView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.logicalFlowAssessmentDefinitions().size());
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult = buildResult.logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.logicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.physicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.physicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.physicalSpecificationRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.physicalSpecifications());
    assertSame(logicalFlowDataTypeDecoratorsResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build logicalFlowDataTypeDecorators size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build logicalFlowDataTypeDecorators size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildLogicalFlowDataTypeDecoratorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addLogicalFlowDataTypeDecorators(mock(DataTypeDecorator.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().logicalFlowDataTypeDecorators().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build logicalFlowRatings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build logicalFlowRatings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildLogicalFlowRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addLogicalFlowRatings(mock(AssessmentRating.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().logicalFlowRatings().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build physicalFlowAssessmentDefinitions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build physicalFlowAssessmentDefinitions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildPhysicalFlowAssessmentDefinitionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addPhysicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().physicalFlowAssessmentDefinitions().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build physicalFlowRatings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build physicalFlowRatings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildPhysicalFlowRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addPhysicalFlowRatings(mock(AssessmentRating.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().physicalFlowRatings().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build physicalFlows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build physicalFlows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildPhysicalFlowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addPhysicalFlows(mock(PhysicalFlow.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().physicalFlows().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build physicalSpecificationDataTypeDecorators size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build physicalSpecificationDataTypeDecorators size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildPhysicalSpecificationDataTypeDecoratorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addPhysicalSpecificationDataTypeDecorators(mock(DataTypeDecorator.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().physicalSpecificationDataTypeDecorators().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build physicalSpecificationRatings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build physicalSpecificationRatings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildPhysicalSpecificationRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addPhysicalSpecificationRatings(mock(AssessmentRating.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().physicalSpecificationRatings().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build physicalSpecifications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build physicalSpecifications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildPhysicalSpecificationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addPhysicalSpecifications(mock(PhysicalSpecification.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().physicalSpecifications().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   * <ul>
   *   <li>Then return build ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); then return build ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_thenReturnBuildRatingSchemeItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    Builder builderResult2 = ImmutableLogicalFlowView.builder();
    builderResult2.addRatingSchemeItems(mock(RatingSchemeItem.class));
    builderResult2.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView instance = builderResult2.build();

    // Act and Assert
    assertEquals(1, builderResult.from(instance).build().ratingSchemeItems().size());
  }

  /**
   * Test Builder {@link Builder#logicalFlowAssessmentDefinitions(Iterable)}.
   * <p>
   * Method under test: {@link Builder#logicalFlowAssessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowAssessmentDefinitions(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.logicalFlowAssessmentDefinitions(Iterable)"})
  void testBuilderLogicalFlowAssessmentDefinitions() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    ImmutableLogicalFlowView buildResult = builderResult.logicalFlowAssessmentDefinitions(new ArrayList<>()).build();
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = buildResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return logicalFlowAssessmentDefinitions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test copyOf(LogicalFlowView); when builder build; then return logicalFlowAssessmentDefinitions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.copyOf(LogicalFlowView)"})
  void testCopyOf_whenBuilderBuild_thenReturnLogicalFlowAssessmentDefinitionsEmpty() {
    // Arrange
    ImmutableLogicalFlowView instance = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
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
   * Test {@link ImmutableLogicalFlowView#equals(Object)}, and {@link ImmutableLogicalFlowView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalFlowView#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}, and {@link ImmutableLogicalFlowView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalFlowView#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addLogicalFlows(new ImmutableLogicalFlow.Json());
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalFlows(mock(PhysicalFlow.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalSpecifications(mock(PhysicalSpecification.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addLogicalFlowDataTypeDecorators(mock(DataTypeDecorator.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalSpecificationDataTypeDecorators(mock(DataTypeDecorator.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addLogicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalSpecificationAssessmentDefinitions(mock(AssessmentDefinition.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addLogicalFlowRatings(mock(AssessmentRating.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalFlowRatings(mock(AssessmentRating.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
    builderResult.addPhysicalSpecificationRatings(mock(AssessmentRating.class));
    ImmutableLogicalFlowView buildResult = builderResult.build();
    ImmutableLogicalFlowView buildResult2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowView.equals(Object)", "int ImmutableLogicalFlowView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableLogicalFlowView");
  }

  /**
   * Test {@link ImmutableLogicalFlowView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableLogicalFlow.Json} (default constructor).</li>
   *   <li>Then return logicalFlows is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet() add Json (default constructor); then return logicalFlows is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.fromJson(Json)"})
  void testFromJson_givenHashSetAddJson_thenReturnLogicalFlowsIsHashSet() {
    // Arrange
    HashSet<LogicalFlow> logicalFlows = new HashSet<>();
    logicalFlows.add(new ImmutableLogicalFlow.Json());
    logicalFlows.add(new ImmutableLogicalFlow.Json());

    Json json = new Json();
    json.setLogicalFlows(logicalFlows);

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.logicalFlowAssessmentDefinitions().isEmpty());
    assertEquals(logicalFlows, actualFromJsonResult.logicalFlows());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
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
   * Test {@link ImmutableLogicalFlowView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableLogicalFlow.Json} (default constructor).</li>
   *   <li>Then return logicalFlows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet() add Json (default constructor); then return logicalFlows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.fromJson(Json)"})
  void testFromJson_givenHashSetAddJson_thenReturnLogicalFlowsSizeIsOne() {
    // Arrange
    HashSet<LogicalFlow> logicalFlows = new HashSet<>();
    logicalFlows.add(new ImmutableLogicalFlow.Json());

    Json json = new Json();
    json.setLogicalFlows(logicalFlows);

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.logicalFlows().size());
    assertTrue(actualFromJsonResult.logicalFlowAssessmentDefinitions().isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
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
   * Test {@link ImmutableLogicalFlowView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return logicalFlowDataTypeDecorators is {@link Json} (default constructor) {@link Json#logicalFlows}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return logicalFlowDataTypeDecorators is Json (default constructor) logicalFlows")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnLogicalFlowDataTypeDecoratorsIsJsonLogicalFlows() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    Set<LogicalFlow> logicalFlowSet = json.logicalFlows;
    assertSame(logicalFlowSet, actualFromJsonResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowSet, actualFromJsonResult.logicalFlowRatings());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalFlowRatings());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalFlows());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalSpecificationRatings());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalSpecifications());
    assertSame(logicalFlowSet, actualFromJsonResult.ratingSchemeItems());
    Set<RatingSchemeItem> expectedLogicalFlowsResult = json.ratingSchemeItems;
    assertSame(expectedLogicalFlowsResult, actualFromJsonResult.logicalFlows());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalFlowView#toString()}
   *   <li>{@link ImmutableLogicalFlowView#logicalFlowAssessmentDefinitions()}
   *   <li>{@link ImmutableLogicalFlowView#logicalFlowDataTypeDecorators()}
   *   <li>{@link ImmutableLogicalFlowView#logicalFlowRatings()}
   *   <li>{@link ImmutableLogicalFlowView#logicalFlows()}
   *   <li>{@link ImmutableLogicalFlowView#physicalFlowAssessmentDefinitions()}
   *   <li>{@link ImmutableLogicalFlowView#physicalFlowRatings()}
   *   <li>{@link ImmutableLogicalFlowView#physicalFlows()}
   *   <li>{@link ImmutableLogicalFlowView#physicalSpecificationAssessmentDefinitions()}
   *   <li>{@link ImmutableLogicalFlowView#physicalSpecificationDataTypeDecorators()}
   *   <li>{@link ImmutableLogicalFlowView#physicalSpecificationRatings()}
   *   <li>{@link ImmutableLogicalFlowView#physicalSpecifications()}
   *   <li>{@link ImmutableLogicalFlowView#ratingSchemeItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableLogicalFlowView.logicalFlowAssessmentDefinitions()",
      "Set ImmutableLogicalFlowView.logicalFlowDataTypeDecorators()",
      "Set ImmutableLogicalFlowView.logicalFlowRatings()", "Set ImmutableLogicalFlowView.logicalFlows()",
      "Set ImmutableLogicalFlowView.physicalFlowAssessmentDefinitions()",
      "Set ImmutableLogicalFlowView.physicalFlowRatings()", "Set ImmutableLogicalFlowView.physicalFlows()",
      "Set ImmutableLogicalFlowView.physicalSpecificationAssessmentDefinitions()",
      "Set ImmutableLogicalFlowView.physicalSpecificationDataTypeDecorators()",
      "Set ImmutableLogicalFlowView.physicalSpecificationRatings()",
      "Set ImmutableLogicalFlowView.physicalSpecifications()", "Set ImmutableLogicalFlowView.ratingSchemeItems()",
      "String ImmutableLogicalFlowView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<AssessmentDefinition> actualLogicalFlowAssessmentDefinitionsResult = buildResult
        .logicalFlowAssessmentDefinitions();
    Set<DataTypeDecorator> actualLogicalFlowDataTypeDecoratorsResult = buildResult.logicalFlowDataTypeDecorators();
    Set<AssessmentRating> actualLogicalFlowRatingsResult = buildResult.logicalFlowRatings();
    Set<LogicalFlow> actualLogicalFlowsResult = buildResult.logicalFlows();
    Set<AssessmentDefinition> actualPhysicalFlowAssessmentDefinitionsResult = buildResult
        .physicalFlowAssessmentDefinitions();
    Set<AssessmentRating> actualPhysicalFlowRatingsResult = buildResult.physicalFlowRatings();
    Set<PhysicalFlow> actualPhysicalFlowsResult = buildResult.physicalFlows();
    Set<AssessmentDefinition> actualPhysicalSpecificationAssessmentDefinitionsResult = buildResult
        .physicalSpecificationAssessmentDefinitions();
    Set<DataTypeDecorator> actualPhysicalSpecificationDataTypeDecoratorsResult = buildResult
        .physicalSpecificationDataTypeDecorators();
    Set<AssessmentRating> actualPhysicalSpecificationRatingsResult = buildResult.physicalSpecificationRatings();
    Set<PhysicalSpecification> actualPhysicalSpecificationsResult = buildResult.physicalSpecifications();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult = buildResult.ratingSchemeItems();

    // Assert
    assertEquals("LogicalFlowView{logicalFlows=[], physicalFlows=[], physicalSpecifications=[], ratingSchemeItems=[],"
        + " logicalFlowDataTypeDecorators=[], physicalSpecificationDataTypeDecorators=[], logicalFlowAssessment"
        + "Definitions=[], physicalFlowAssessmentDefinitions=[], physicalSpecificationAssessmentDefinitions=[],"
        + " logicalFlowRatings=[], physicalFlowRatings=[], physicalSpecificationRatings=[]}", actualToStringResult);
    assertTrue(actualLogicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualLogicalFlowDataTypeDecoratorsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualLogicalFlowRatingsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualLogicalFlowsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalFlowAssessmentDefinitionsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalFlowRatingsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalFlowsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalSpecificationAssessmentDefinitionsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalSpecificationDataTypeDecoratorsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalSpecificationRatingsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalSpecificationsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualRatingSchemeItemsResult);
  }

  /**
   * Test Json {@link Json#logicalFlowAssessmentDefinitions()}.
   * <p>
   * Method under test: {@link Json#logicalFlowAssessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json logicalFlowAssessmentDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.logicalFlowAssessmentDefinitions()"})
  void testJsonLogicalFlowAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlowAssessmentDefinitions());
  }

  /**
   * Test Json {@link Json#logicalFlowDataTypeDecorators()}.
   * <p>
   * Method under test: {@link Json#logicalFlowDataTypeDecorators()}
   */
  @Test
  @DisplayName("Test Json logicalFlowDataTypeDecorators()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.logicalFlowDataTypeDecorators()"})
  void testJsonLogicalFlowDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlowDataTypeDecorators());
  }

  /**
   * Test Json {@link Json#logicalFlowRatings()}.
   * <p>
   * Method under test: {@link Json#logicalFlowRatings()}
   */
  @Test
  @DisplayName("Test Json logicalFlowRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.logicalFlowRatings()"})
  void testJsonLogicalFlowRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlowRatings());
  }

  /**
   * Test Json {@link Json#logicalFlows()}.
   * <p>
   * Method under test: {@link Json#logicalFlows()}
   */
  @Test
  @DisplayName("Test Json logicalFlows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.logicalFlows()"})
  void testJsonLogicalFlows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlows());
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
   * Test Json {@link Json#physicalFlowAssessmentDefinitions()}.
   * <p>
   * Method under test: {@link Json#physicalFlowAssessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json physicalFlowAssessmentDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.physicalFlowAssessmentDefinitions()"})
  void testJsonPhysicalFlowAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalFlowAssessmentDefinitions());
  }

  /**
   * Test Json {@link Json#physicalFlowRatings()}.
   * <p>
   * Method under test: {@link Json#physicalFlowRatings()}
   */
  @Test
  @DisplayName("Test Json physicalFlowRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.physicalFlowRatings()"})
  void testJsonPhysicalFlowRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalFlowRatings());
  }

  /**
   * Test Json {@link Json#physicalFlows()}.
   * <p>
   * Method under test: {@link Json#physicalFlows()}
   */
  @Test
  @DisplayName("Test Json physicalFlows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.physicalFlows()"})
  void testJsonPhysicalFlows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalFlows());
  }

  /**
   * Test Json {@link Json#physicalSpecificationAssessmentDefinitions()}.
   * <p>
   * Method under test: {@link Json#physicalSpecificationAssessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json physicalSpecificationAssessmentDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.physicalSpecificationAssessmentDefinitions()"})
  void testJsonPhysicalSpecificationAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalSpecificationAssessmentDefinitions());
  }

  /**
   * Test Json {@link Json#physicalSpecificationDataTypeDecorators()}.
   * <p>
   * Method under test: {@link Json#physicalSpecificationDataTypeDecorators()}
   */
  @Test
  @DisplayName("Test Json physicalSpecificationDataTypeDecorators()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.physicalSpecificationDataTypeDecorators()"})
  void testJsonPhysicalSpecificationDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalSpecificationDataTypeDecorators());
  }

  /**
   * Test Json {@link Json#physicalSpecificationRatings()}.
   * <p>
   * Method under test: {@link Json#physicalSpecificationRatings()}
   */
  @Test
  @DisplayName("Test Json physicalSpecificationRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.physicalSpecificationRatings()"})
  void testJsonPhysicalSpecificationRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalSpecificationRatings());
  }

  /**
   * Test Json {@link Json#physicalSpecifications()}.
   * <p>
   * Method under test: {@link Json#physicalSpecifications()}
   */
  @Test
  @DisplayName("Test Json physicalSpecifications()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.physicalSpecifications()"})
  void testJsonPhysicalSpecifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalSpecifications());
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
   * Test {@link ImmutableLogicalFlowView#withLogicalFlowAssessmentDefinitions(AssessmentDefinition[])} with {@code AssessmentDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withLogicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test withLogicalFlowAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowView ImmutableLogicalFlowView.withLogicalFlowAssessmentDefinitions(AssessmentDefinition[])"})
  void testWithLogicalFlowAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithLogicalFlowAssessmentDefinitionsResult = buildResult
        .withLogicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, actualWithLogicalFlowAssessmentDefinitionsResult.logicalFlowAssessmentDefinitions().size());
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult = actualWithLogicalFlowAssessmentDefinitionsResult
        .logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertSame(logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.logicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualWithLogicalFlowAssessmentDefinitionsResult.logicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualWithLogicalFlowAssessmentDefinitionsResult.physicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalSpecificationRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalSpecifications());
    assertSame(logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withLogicalFlowDataTypeDecorators(DataTypeDecorator[])} with {@code DataTypeDecorator[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withLogicalFlowDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName("Test withLogicalFlowDataTypeDecorators(DataTypeDecorator[]) with 'DataTypeDecorator[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowView ImmutableLogicalFlowView.withLogicalFlowDataTypeDecorators(DataTypeDecorator[])"})
  void testWithLogicalFlowDataTypeDecoratorsWithDataTypeDecorator() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithLogicalFlowDataTypeDecoratorsResult = buildResult
        .withLogicalFlowDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1, actualWithLogicalFlowDataTypeDecoratorsResult.logicalFlowDataTypeDecorators().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithLogicalFlowDataTypeDecoratorsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowDataTypeDecoratorsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowDataTypeDecoratorsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withLogicalFlowRatings(AssessmentRating[])} with {@code AssessmentRating[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withLogicalFlowRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withLogicalFlowRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.withLogicalFlowRatings(AssessmentRating[])"})
  void testWithLogicalFlowRatingsWithAssessmentRating() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithLogicalFlowRatingsResult = buildResult
        .withLogicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, actualWithLogicalFlowRatingsResult.logicalFlowRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithLogicalFlowRatingsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowRatingsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowRatingsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowRatingsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowRatingsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withLogicalFlows(LogicalFlow[])} with {@code LogicalFlow[]}.
   * <ul>
   *   <li>When {@link ImmutableLogicalFlow.Json} (default constructor).</li>
   *   <li>Then return logicalFlows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withLogicalFlows(LogicalFlow[])}
   */
  @Test
  @DisplayName("Test withLogicalFlows(LogicalFlow[]) with 'LogicalFlow[]'; when Json (default constructor); then return logicalFlows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.withLogicalFlows(LogicalFlow[])"})
  void testWithLogicalFlowsWithLogicalFlow_whenJson_thenReturnLogicalFlowsSizeIsOne() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithLogicalFlowsResult = buildResult
        .withLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, actualWithLogicalFlowsResult.logicalFlows().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithLogicalFlowsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])} with {@code AssessmentDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test withPhysicalFlowAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])"})
  void testWithPhysicalFlowAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithPhysicalFlowAssessmentDefinitionsResult = buildResult
        .withPhysicalFlowAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, actualWithPhysicalFlowAssessmentDefinitionsResult.physicalFlowAssessmentDefinitions().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithPhysicalFlowAssessmentDefinitionsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalFlowRatings(AssessmentRating[])} with {@code AssessmentRating[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withPhysicalFlowRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withPhysicalFlowRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalFlowRatings(AssessmentRating[])"})
  void testWithPhysicalFlowRatingsWithAssessmentRating() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithPhysicalFlowRatingsResult = buildResult
        .withPhysicalFlowRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, actualWithPhysicalFlowRatingsResult.physicalFlowRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithPhysicalFlowRatingsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowRatingsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowRatingsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowRatingsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowRatingsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalFlows(PhysicalFlow[])} with {@code PhysicalFlow[]}.
   * <ul>
   *   <li>Then return physicalFlows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withPhysicalFlows(PhysicalFlow[])}
   */
  @Test
  @DisplayName("Test withPhysicalFlows(PhysicalFlow[]) with 'PhysicalFlow[]'; then return physicalFlows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalFlows(PhysicalFlow[])"})
  void testWithPhysicalFlowsWithPhysicalFlow_thenReturnPhysicalFlowsSizeIsOne() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithPhysicalFlowsResult = buildResult.withPhysicalFlows(mock(PhysicalFlow.class));

    // Assert
    assertEquals(1, actualWithPhysicalFlowsResult.physicalFlows().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithPhysicalFlowsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])} with {@code AssessmentDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName("Test withPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])"})
  void testWithPhysicalSpecificationAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithPhysicalSpecificationAssessmentDefinitionsResult = buildResult
        .withPhysicalSpecificationAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalSpecificationAssessmentDefinitions().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithPhysicalSpecificationAssessmentDefinitionsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])} with {@code DataTypeDecorator[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName("Test withPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[]) with 'DataTypeDecorator[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])"})
  void testWithPhysicalSpecificationDataTypeDecoratorsWithDataTypeDecorator() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithPhysicalSpecificationDataTypeDecoratorsResult = buildResult
        .withPhysicalSpecificationDataTypeDecorators(mock(DataTypeDecorator.class));

    // Assert
    assertEquals(1,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalSpecificationDataTypeDecorators().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithPhysicalSpecificationDataTypeDecoratorsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalSpecificationRatings(AssessmentRating[])} with {@code AssessmentRating[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withPhysicalSpecificationRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withPhysicalSpecificationRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalSpecificationRatings(AssessmentRating[])"})
  void testWithPhysicalSpecificationRatingsWithAssessmentRating() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithPhysicalSpecificationRatingsResult = buildResult
        .withPhysicalSpecificationRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, actualWithPhysicalSpecificationRatingsResult.physicalSpecificationRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithPhysicalSpecificationRatingsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalSpecificationRatingsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalSpecificationRatingsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalSpecifications(PhysicalSpecification[])} with {@code PhysicalSpecification[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withPhysicalSpecifications(PhysicalSpecification[])}
   */
  @Test
  @DisplayName("Test withPhysicalSpecifications(PhysicalSpecification[]) with 'PhysicalSpecification[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalSpecifications(PhysicalSpecification[])"})
  void testWithPhysicalSpecificationsWithPhysicalSpecification() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithPhysicalSpecificationsResult = buildResult
        .withPhysicalSpecifications(mock(PhysicalSpecification.class));

    // Assert
    assertEquals(1, actualWithPhysicalSpecificationsResult.physicalSpecifications().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithPhysicalSpecificationsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalSpecificationsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalSpecificationsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalSpecificationsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalSpecificationsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithPhysicalSpecificationsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withRatingSchemeItems(RatingSchemeItem[])} with {@code RatingSchemeItem[]}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.withRatingSchemeItems(RatingSchemeItem[])"})
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableLogicalFlowView buildResult = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithRatingSchemeItemsResult = buildResult
        .withRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult = actualWithRatingSchemeItemsResult
        .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithRatingSchemeItemsResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithRatingSchemeItemsResult.logicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithRatingSchemeItemsResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithRatingSchemeItemsResult.physicalFlows());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualWithRatingSchemeItemsResult.physicalSpecifications());
  }
}
