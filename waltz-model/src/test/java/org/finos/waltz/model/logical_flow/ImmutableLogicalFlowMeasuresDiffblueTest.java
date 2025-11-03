package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowMeasures.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowMeasures.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowMeasuresDiffblueTest {
  /**
   * Test Builder {@link Builder#from(LogicalFlowMeasures)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then builder build inbound is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowMeasures); given ten; then builder build inbound is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowMeasures)"})
  void testBuilderFrom_givenTen_thenBuilderBuildInboundIsTen() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowMeasures.builder();
    LogicalFlowMeasures instance = mock(LogicalFlowMeasures.class);
    when(instance.inbound()).thenReturn(10.0d);
    when(instance.intra()).thenReturn(10.0d);
    when(instance.outbound()).thenReturn(10.0d);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#inbound(double)}.
   * <p>
   * Method under test: {@link Builder#inbound(double)}
   */
  @Test
  @DisplayName("Test Builder inbound(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inbound(double)"})
  void testBuilderInbound() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inbound(10.0d));
  }

  /**
   * Test Builder {@link Builder#intra(double)}.
   * <p>
   * Method under test: {@link Builder#intra(double)}
   */
  @Test
  @DisplayName("Test Builder intra(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.intra(double)"})
  void testBuilderIntra() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.intra(10.0d));
  }

  /**
   * Test Builder {@link Builder#outbound(double)}.
   * <p>
   * Method under test: {@link Builder#outbound(double)}
   */
  @Test
  @DisplayName("Test Builder outbound(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.outbound(double)"})
  void testBuilderOutbound() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.outbound(10.0d));
  }

  /**
   * Test Json {@link Json#inbound()}.
   * <p>
   * Method under test: {@link Json#inbound()}
   */
  @Test
  @DisplayName("Test Json inbound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Json.inbound()"})
  void testJsonInbound() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inbound());
  }

  /**
   * Test Json {@link Json#intra()}.
   * <p>
   * Method under test: {@link Json#intra()}
   */
  @Test
  @DisplayName("Test Json intra()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Json.intra()"})
  void testJsonIntra() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).intra());
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
    assertEquals(0.0d, actualJson.inbound);
    assertEquals(0.0d, actualJson.intra);
    assertEquals(0.0d, actualJson.outbound);
    assertFalse(actualJson.inboundIsSet);
    assertFalse(actualJson.intraIsSet);
    assertFalse(actualJson.outboundIsSet);
  }

  /**
   * Test Json {@link Json#outbound()}.
   * <p>
   * Method under test: {@link Json#outbound()}
   */
  @Test
  @DisplayName("Test Json outbound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Json.outbound()"})
  void testJsonOutbound() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).outbound());
  }

  /**
   * Test Json {@link Json#setInbound(double)}.
   * <p>
   * Method under test: {@link Json#setInbound(double)}
   */
  @Test
  @DisplayName("Test Json setInbound(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setInbound(double)"})
  void testJsonSetInbound() {
    // Arrange
    Json json = new Json();

    // Act
    json.setInbound(10.0d);

    // Assert
    assertEquals(10.0d, json.inbound);
    assertTrue(json.inboundIsSet);
  }

  /**
   * Test Json {@link Json#setIntra(double)}.
   * <p>
   * Method under test: {@link Json#setIntra(double)}
   */
  @Test
  @DisplayName("Test Json setIntra(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIntra(double)"})
  void testJsonSetIntra() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIntra(10.0d);

    // Assert
    assertEquals(10.0d, json.intra);
    assertTrue(json.intraIsSet);
  }

  /**
   * Test Json {@link Json#setOutbound(double)}.
   * <p>
   * Method under test: {@link Json#setOutbound(double)}
   */
  @Test
  @DisplayName("Test Json setOutbound(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setOutbound(double)"})
  void testJsonSetOutbound() {
    // Arrange
    Json json = new Json();

    // Act
    json.setOutbound(10.0d);

    // Assert
    assertEquals(10.0d, json.outbound);
    assertTrue(json.outboundIsSet);
  }
}
