package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ImmutableTargetCostWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableTargetCostWidgetDatum.Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Builder#currentStateCost(BigDecimal)}
   */
  @Test
  void testBuilderCurrentStateCost() {
    // Arrange
    ImmutableTargetCostWidgetDatum.Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.currentStateCost(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTargetCostWidgetDatum.Builder builderResult = ImmutableTargetCostWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableTargetCostWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Builder#from(TargetCostWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTargetCostWidgetDatum.Builder builderResult = ImmutableTargetCostWidgetDatum.builder();
    TargetCostWidgetDatum instance = mock(TargetCostWidgetDatum.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.targetStateCost()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.currentStateCost()).thenReturn(bigDecimal2);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableTargetCostWidgetDatum.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Builder#from(TargetCostWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableTargetCostWidgetDatum.Builder builderResult = ImmutableTargetCostWidgetDatum.builder();
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
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Builder#targetStateCost(BigDecimal)}
   */
  @Test
  void testBuilderTargetStateCost() {
    // Arrange
    ImmutableTargetCostWidgetDatum.Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetStateCost(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum#copyOf(TargetCostWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TargetCostWidgetDatum instance = mock(TargetCostWidgetDatum.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.targetStateCost()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.currentStateCost()).thenReturn(bigDecimal2);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableTargetCostWidgetDatum actualCopyOfResult = ImmutableTargetCostWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).currentStateCost();
    verify(instance).targetStateCost();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    BigDecimal expectedCurrentStateCostResult = new BigDecimal("2.3");
    BigDecimal currentStateCostResult = actualCopyOfResult.currentStateCost();
    assertEquals(expectedCurrentStateCostResult, currentStateCostResult);
    BigDecimal expectedTargetStateCostResult = new BigDecimal("2.3");
    BigDecimal targetStateCostResult = actualCopyOfResult.targetStateCost();
    assertEquals(expectedTargetStateCostResult, targetStateCostResult);
    assertSame(bigDecimal2, currentStateCostResult);
    assertSame(bigDecimal, targetStateCostResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum#fromJson(ImmutableTargetCostWidgetDatum.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableTargetCostWidgetDatum.Json json = new ImmutableTargetCostWidgetDatum.Json();
    json.setCellExternalId("Json");
    BigDecimal currentStateCost = new BigDecimal("2.3");
    json.setCurrentStateCost(currentStateCost);
    BigDecimal targetStateCost = new BigDecimal("2.3");
    json.setTargetStateCost(targetStateCost);

    // Act
    ImmutableTargetCostWidgetDatum actualFromJsonResult = ImmutableTargetCostWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    BigDecimal expectedCurrentStateCostResult = new BigDecimal("2.3");
    BigDecimal currentStateCostResult = actualFromJsonResult.currentStateCost();
    assertEquals(expectedCurrentStateCostResult, currentStateCostResult);
    BigDecimal expectedTargetStateCostResult = new BigDecimal("2.3");
    BigDecimal targetStateCostResult = actualFromJsonResult.targetStateCost();
    assertEquals(expectedTargetStateCostResult, targetStateCostResult);
    assertSame(currentStateCost, currentStateCostResult);
    assertSame(targetStateCost, targetStateCostResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableTargetCostWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Json#currentStateCost()}
   */
  @Test
  void testJsonCurrentStateCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableTargetCostWidgetDatum.Json()).currentStateCost());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableTargetCostWidgetDatum.Json}
   *   <li>{@link ImmutableTargetCostWidgetDatum.Json#setCellExternalId(String)}
   *   <li>
   * {@link ImmutableTargetCostWidgetDatum.Json#setCurrentStateCost(BigDecimal)}
   *   <li>
   * {@link ImmutableTargetCostWidgetDatum.Json#setTargetStateCost(BigDecimal)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableTargetCostWidgetDatum.Json actualJson = new ImmutableTargetCostWidgetDatum.Json();
    actualJson.setCellExternalId("42");
    actualJson.setCurrentStateCost(new BigDecimal("2.3"));
    actualJson.setTargetStateCost(new BigDecimal("2.3"));

    // Assert
    assertEquals("42", actualJson.cellExternalId);
    assertEquals(new BigDecimal("2.3"), actualJson.currentStateCost);
    assertEquals(new BigDecimal("2.3"), actualJson.targetStateCost);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetDatum.Json#targetStateCost()}
   */
  @Test
  void testJsonTargetStateCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableTargetCostWidgetDatum.Json()).targetStateCost());
  }
}
