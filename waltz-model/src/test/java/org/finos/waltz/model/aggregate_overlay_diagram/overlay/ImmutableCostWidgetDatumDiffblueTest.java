package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class ImmutableCostWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#addAllMeasurableCosts(Iterable)}
   */
  @Test
  void testBuilderAddAllMeasurableCosts() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMeasurableCosts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#addMeasurableCosts(MeasurableCostEntry)}
   */
  @Test
  void testBuilderAddMeasurableCosts() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMeasurableCosts(new ImmutableMeasurableCostEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#addMeasurableCosts(MeasurableCostEntry[])}
   */
  @Test
  void testBuilderAddMeasurableCosts2() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMeasurableCosts(new ImmutableMeasurableCostEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act
    ImmutableCostWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableCostWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0L, buildResult.appCount());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableCostWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    ImmutableCostWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0L, buildResult.appCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#from(CostWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();
    CostWidgetDatum instance = mock(CostWidgetDatum.class);
    when(instance.measurableCosts()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableCostWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).measurableCosts();
    ImmutableCostWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0L, buildResult.appCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#from(CostWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();
    CostWidgetDatum instance = mock(CostWidgetDatum.class);
    when(instance.measurableCosts()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).measurableCosts();
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#from(CostWidgetDatum)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();

    HashSet<MeasurableCostEntry> measurableCostEntrySet = new HashSet<>();
    measurableCostEntrySet.add(new ImmutableMeasurableCostEntry.Json());
    CostWidgetDatum instance = mock(CostWidgetDatum.class);
    when(instance.measurableCosts()).thenReturn(measurableCostEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableCostWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).measurableCosts();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum.Builder#measurableCosts(Iterable)}
   */
  @Test
  void testBuilderMeasurableCosts() {
    // Arrange
    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCosts(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableCostWidgetDatum#copyOf(CostWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CostWidgetDatum instance = mock(CostWidgetDatum.class);
    when(instance.measurableCosts()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableCostWidgetDatum actualCopyOfResult = ImmutableCostWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).measurableCosts();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(0L, actualCopyOfResult.appCount());
    assertTrue(actualCopyOfResult.measurableCosts().isEmpty());
    BigDecimal expectedTotalCostResult = new BigDecimal("0");
    assertEquals(expectedTotalCostResult, actualCopyOfResult.totalCost());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetDatum#fromJson(ImmutableCostWidgetDatum.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setMeasurableCosts(null);

    // Act
    ImmutableCostWidgetDatum actualFromJsonResult = ImmutableCostWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(0L, actualFromJsonResult.appCount());
    assertTrue(actualFromJsonResult.measurableCosts().isEmpty());
    BigDecimal expectedTotalCostResult = new BigDecimal("0");
    assertEquals(expectedTotalCostResult, actualFromJsonResult.totalCost());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetDatum.Json#appCount()}
   */
  @Test
  void testJsonAppCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostWidgetDatum.Json()).appCount());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetDatum.Json#measurableCosts()}
   */
  @Test
  void testJsonMeasurableCosts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostWidgetDatum.Json()).measurableCosts());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCostWidgetDatum.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCostWidgetDatum.Json actualJson = new ImmutableCostWidgetDatum.Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.measurableCosts.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetDatum.Json#totalCost()}
   */
  @Test
  void testJsonTotalCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostWidgetDatum.Json()).totalCost());
  }
}
