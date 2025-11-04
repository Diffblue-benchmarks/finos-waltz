package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.datatype.FlowDataType;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchy;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;

class FlowClassificationRuleUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  void testApplyVantagePoints() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();
    HashSet<FlowDataType> population = new HashSet<>();

    // Act
    Map<Long, Tuple2<Long, FlowClassificationRuleUtilities.MatchOutcome>> actualApplyVantagePointsResult = FlowClassificationRuleUtilities
        .applyVantagePoints(FlowDirection.INBOUND, ruleVantagePoints, population, null, null, new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  void testApplyVantagePoints2() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();
    HashSet<FlowDataType> population = new HashSet<>();

    // Act
    Map<Long, Tuple2<Long, FlowClassificationRuleUtilities.MatchOutcome>> actualApplyVantagePointsResult = FlowClassificationRuleUtilities
        .applyVantagePoints(FlowDirection.OUTBOUND, ruleVantagePoints, population, null, null, new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  void testApplyVantagePoints3() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);

    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();
    ruleVantagePoints.add(flowClassificationRuleVantagePoint);
    HashSet<FlowDataType> population = new HashSet<>();

    // Act
    Map<Long, Tuple2<Long, FlowClassificationRuleUtilities.MatchOutcome>> actualApplyVantagePointsResult = FlowClassificationRuleUtilities
        .applyVantagePoints(FlowDirection.INBOUND, ruleVantagePoints, population, null, null, new HashMap<>());

    // Assert
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  void testApplyVantagePoints4() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint2 = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint2.dataTypeId()).thenReturn(1L);

    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();
    ruleVantagePoints.add(flowClassificationRuleVantagePoint2);
    ruleVantagePoints.add(flowClassificationRuleVantagePoint);
    HashSet<FlowDataType> population = new HashSet<>();

    // Act
    Map<Long, Tuple2<Long, FlowClassificationRuleUtilities.MatchOutcome>> actualApplyVantagePointsResult = FlowClassificationRuleUtilities
        .applyVantagePoints(FlowDirection.INBOUND, ruleVantagePoints, population, null, null, new HashMap<>());

    // Assert
    verify(flowClassificationRuleVantagePoint2, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }
}
