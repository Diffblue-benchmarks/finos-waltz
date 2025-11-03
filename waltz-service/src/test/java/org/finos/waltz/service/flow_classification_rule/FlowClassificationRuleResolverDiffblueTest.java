package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowClassificationRuleResolverDiffblueTest {
  /**
   * Test {@link FlowClassificationRuleResolver#FlowClassificationRuleResolver(FlowDirection, List)}.
   * <ul>
   *   <li>Then calls {@link FlowClassificationRuleVantagePoint#dataTypeId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowClassificationRuleResolver#FlowClassificationRuleResolver(FlowDirection, List)}
   */
  @Test
  @DisplayName("Test new FlowClassificationRuleResolver(FlowDirection, List); then calls dataTypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FlowClassificationRuleResolver.<init>(FlowDirection, List)"})
  void testNewFlowClassificationRuleResolver_thenCallsDataTypeId() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationVantagePoints = new ArrayList<>();
    flowClassificationVantagePoints.add(flowClassificationRuleVantagePoint);

    // Act
    new FlowClassificationRuleResolver(FlowDirection.INBOUND, flowClassificationVantagePoints);

    // Assert
    verify(flowClassificationRuleVantagePoint).dataTypeId();
    verify(flowClassificationRuleVantagePoint).subjectReference();
    verify(flowClassificationRuleVantagePoint).vantagePoint();
  }

  /**
   * Test {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}.
   * <ul>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}
   */
  @Test
  @DisplayName("Test getMostSpecificRanked(Collection); then return Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional FlowClassificationRuleResolver.getMostSpecificRanked(Collection)"})
  void testGetMostSpecificRanked_thenReturnPresent() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> vantagePoints = new ArrayList<>();
    vantagePoints.add(mock(FlowClassificationRuleVantagePoint.class));

    // Act
    Optional<FlowClassificationRuleVantagePoint> actualMostSpecificRanked = FlowClassificationRuleResolver
        .getMostSpecificRanked(vantagePoints);

    // Assert
    assertTrue(actualMostSpecificRanked.isPresent());
  }

  /**
   * Test {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}
   */
  @Test
  @DisplayName("Test getMostSpecificRanked(Collection); when ArrayList(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional FlowClassificationRuleResolver.getMostSpecificRanked(Collection)"})
  void testGetMostSpecificRanked_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<FlowClassificationRuleVantagePoint> actualMostSpecificRanked = FlowClassificationRuleResolver
        .getMostSpecificRanked(new ArrayList<>());

    // Assert
    assertFalse(actualMostSpecificRanked.isPresent());
  }

  /**
   * Test {@link FlowClassificationRuleResolver#resolve(EntityReference, EntityReference, EntityReference, Long)}.
   * <p>
   * Method under test: {@link FlowClassificationRuleResolver#resolve(EntityReference, EntityReference, EntityReference, Long)}
   */
  @Test
  @DisplayName("Test resolve(EntityReference, EntityReference, EntityReference, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Tuple2 FlowClassificationRuleResolver.resolve(EntityReference, EntityReference, EntityReference, Long)"})
  void testResolve() {
    // Arrange and Act
    Tuple2<AuthoritativenessRatingValue, Optional<FlowClassificationRuleVantagePoint>> actualResolveResult = (new FlowClassificationRuleResolver(
        FlowDirection.INBOUND, new ArrayList<>())).resolve(mock(EntityReference.class), mock(EntityReference.class),
            mock(EntityReference.class), 1L);

    // Assert
    List<?> toListResult = actualResolveResult.toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(1);
    assertTrue(getResult instanceof Optional);
    Object getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof AuthoritativenessRatingValue);
    assertEquals("NO_OPINION", ((AuthoritativenessRatingValue) getResult2).value());
    assertFalse(((Optional<Object>) getResult).isPresent());
    assertSame(actualResolveResult.v1, getResult2);
    assertSame(actualResolveResult.v2, getResult);
  }
}
