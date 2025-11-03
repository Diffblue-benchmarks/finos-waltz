package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableTargetCostWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableTargetCostWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTargetCostWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#currentStateCost(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#currentStateCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test Builder currentStateCost(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.currentStateCost(BigDecimal)"})
  void testBuilderCurrentStateCost_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.currentStateCost(new BigDecimal("2.3")));
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; given '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_given42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TargetCostWidgetDatum)} with {@code TargetCostWidgetDatum}.
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TargetCostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(TargetCostWidgetDatum) with 'TargetCostWidgetDatum'; then builder build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TargetCostWidgetDatum)"})
  void testBuilderFromWithTargetCostWidgetDatum_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();
    TargetCostWidgetDatum instance = mock(TargetCostWidgetDatum.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.targetStateCost()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.currentStateCost()).thenReturn(bigDecimal2);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).currentStateCost();
    verify(instance).targetStateCost();
    ImmutableTargetCostWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertSame(bigDecimal2, buildResult.currentStateCost());
    assertSame(bigDecimal, buildResult.targetStateCost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TargetCostWidgetDatum)} with {@code TargetCostWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TargetCostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(TargetCostWidgetDatum) with 'TargetCostWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TargetCostWidgetDatum)"})
  void testBuilderFromWithTargetCostWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();
    TargetCostWidgetDatum instance = mock(TargetCostWidgetDatum.class);
    when(instance.targetStateCost()).thenThrow(new IllegalStateException("instance"));
    when(instance.currentStateCost()).thenReturn(new BigDecimal("2.3"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).currentStateCost();
    verify(instance).targetStateCost();
  }

  /**
   * Test Builder {@link Builder#targetStateCost(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#targetStateCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test Builder targetStateCost(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetStateCost(BigDecimal)"})
  void testBuilderTargetStateCost_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetStateCost(new BigDecimal("2.3")));
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   * <p>
   * Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellExternalId());
  }

  /**
   * Test Json {@link Json#currentStateCost()}.
   * <p>
   * Method under test: {@link Json#currentStateCost()}
   */
  @Test
  @DisplayName("Test Json currentStateCost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.currentStateCost()"})
  void testJsonCurrentStateCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).currentStateCost());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCellExternalId(String)}
   *   <li>{@link Json#setCurrentStateCost(BigDecimal)}
   *   <li>{@link Json#setTargetStateCost(BigDecimal)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCellExternalId(String)",
      "void Json.setCurrentStateCost(BigDecimal)", "void Json.setTargetStateCost(BigDecimal)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCellExternalId("42");
    actualJson.setCurrentStateCost(new BigDecimal("2.3"));
    actualJson.setTargetStateCost(new BigDecimal("2.3"));

    // Assert
    assertEquals("42", actualJson.cellExternalId);
    assertEquals(new BigDecimal("2.3"), actualJson.currentStateCost);
    assertEquals(new BigDecimal("2.3"), actualJson.targetStateCost);
  }

  /**
   * Test Json {@link Json#targetStateCost()}.
   * <p>
   * Method under test: {@link Json#targetStateCost()}
   */
  @Test
  @DisplayName("Test Json targetStateCost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.targetStateCost()"})
  void testJsonTargetStateCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetStateCost());
  }
}
