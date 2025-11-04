package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowMeasuresDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLogicalFlowMeasures.Builder#from(LogicalFlowMeasures)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalFlowMeasures.Builder builderResult = ImmutableLogicalFlowMeasures.builder();
    LogicalFlowMeasures instance = mock(LogicalFlowMeasures.class);
    when(instance.inbound()).thenReturn(10.0d);
    when(instance.intra()).thenReturn(10.0d);
    when(instance.outbound()).thenReturn(10.0d);

    // Act
    ImmutableLogicalFlowMeasures.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inbound();
    verify(instance).intra();
    verify(instance).outbound();
    ImmutableLogicalFlowMeasures buildResult = builderResult.build();
    assertEquals(10.0d, buildResult.inbound());
    assertEquals(10.0d, buildResult.intra());
    assertEquals(10.0d, buildResult.outbound());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowMeasures.Builder#inbound(double)}
   */
  @Test
  void testBuilderInbound() {
    // Arrange
    ImmutableLogicalFlowMeasures.Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inbound(10.0d));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowMeasures.Builder#intra(double)}
   */
  @Test
  void testBuilderIntra() {
    // Arrange
    ImmutableLogicalFlowMeasures.Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.intra(10.0d));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowMeasures.Builder#outbound(double)}
   */
  @Test
  void testBuilderOutbound() {
    // Arrange
    ImmutableLogicalFlowMeasures.Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.outbound(10.0d));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowMeasures#copyOf(LogicalFlowMeasures)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalFlowMeasures instance = mock(LogicalFlowMeasures.class);
    when(instance.inbound()).thenReturn(10.0d);
    when(instance.intra()).thenReturn(10.0d);
    when(instance.outbound()).thenReturn(10.0d);

    // Act
    ImmutableLogicalFlowMeasures actualCopyOfResult = ImmutableLogicalFlowMeasures.copyOf(instance);

    // Assert
    verify(instance).inbound();
    verify(instance).intra();
    verify(instance).outbound();
    assertEquals(10.0d, actualCopyOfResult.inbound());
    assertEquals(10.0d, actualCopyOfResult.intra());
    assertEquals(10.0d, actualCopyOfResult.outbound());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowMeasures.Json#inbound()}
   */
  @Test
  void testJsonInbound() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowMeasures.Json()).inbound());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowMeasures.Json#intra()}
   */
  @Test
  void testJsonIntra() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowMeasures.Json()).intra());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLogicalFlowMeasures.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLogicalFlowMeasures.Json actualJson = new ImmutableLogicalFlowMeasures.Json();

    // Assert
    assertEquals(0.0d, actualJson.inbound);
    assertEquals(0.0d, actualJson.intra);
    assertEquals(0.0d, actualJson.outbound);
    assertFalse(actualJson.inboundIsSet);
    assertFalse(actualJson.intraIsSet);
    assertFalse(actualJson.outboundIsSet);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowMeasures.Json#outbound()}
   */
  @Test
  void testJsonOutbound() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowMeasures.Json()).outbound());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowMeasures.Json#setInbound(double)}
   */
  @Test
  void testJsonSetInbound() {
    // Arrange
    ImmutableLogicalFlowMeasures.Json json = new ImmutableLogicalFlowMeasures.Json();

    // Act
    json.setInbound(10.0d);

    // Assert
    assertEquals(10.0d, json.inbound);
    assertTrue(json.inboundIsSet);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowMeasures.Json#setIntra(double)}
   */
  @Test
  void testJsonSetIntra() {
    // Arrange
    ImmutableLogicalFlowMeasures.Json json = new ImmutableLogicalFlowMeasures.Json();

    // Act
    json.setIntra(10.0d);

    // Assert
    assertEquals(10.0d, json.intra);
    assertTrue(json.intraIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowMeasures.Json#setOutbound(double)}
   */
  @Test
  void testJsonSetOutbound() {
    // Arrange
    ImmutableLogicalFlowMeasures.Json json = new ImmutableLogicalFlowMeasures.Json();

    // Act
    json.setOutbound(10.0d);

    // Assert
    assertEquals(10.0d, json.outbound);
    assertTrue(json.outboundIsSet);
  }
}
