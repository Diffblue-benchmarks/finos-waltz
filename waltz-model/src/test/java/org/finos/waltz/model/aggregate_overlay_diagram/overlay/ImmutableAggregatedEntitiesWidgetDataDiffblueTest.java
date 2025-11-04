package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

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
import org.junit.jupiter.api.Test;

class ImmutableAggregatedEntitiesWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData.Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    // Act
    ImmutableAggregatedEntitiesWidgetData.Builder actualAddAllCellDataResult = builderResult
        .addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData.Builder#addCellData(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData.Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    // Act
    ImmutableAggregatedEntitiesWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableAggregatedEntitiesWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData.Builder#addCellData(AggregatedEntitiesWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData.Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    // Act
    ImmutableAggregatedEntitiesWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableAggregatedEntitiesWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAggregatedEntitiesWidgetData.builder().build().cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData.Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    // Act
    ImmutableAggregatedEntitiesWidgetData.Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData.Builder#from(AggregatedEntitiesWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData.Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();
    AggregatedEntitiesWidgetData instance = mock(AggregatedEntitiesWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAggregatedEntitiesWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData.Builder#from(AggregatedEntitiesWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData.Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    HashSet<AggregatedEntitiesWidgetDatum> aggregatedEntitiesWidgetDatumSet = new HashSet<>();
    aggregatedEntitiesWidgetDatumSet.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());
    AggregatedEntitiesWidgetData instance = mock(AggregatedEntitiesWidgetData.class);
    when(instance.cellData()).thenReturn(aggregatedEntitiesWidgetDatumSet);

    // Act
    ImmutableAggregatedEntitiesWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData#copyOf(AggregatedEntitiesWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AggregatedEntitiesWidgetData instance = mock(AggregatedEntitiesWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAggregatedEntitiesWidgetData actualCopyOfResult = ImmutableAggregatedEntitiesWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertTrue(actualCopyOfResult.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData#copyOf(AggregatedEntitiesWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AggregatedEntitiesWidgetDatum> aggregatedEntitiesWidgetDatumSet = new HashSet<>();
    aggregatedEntitiesWidgetDatumSet.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());
    AggregatedEntitiesWidgetData instance = mock(AggregatedEntitiesWidgetData.class);
    when(instance.cellData()).thenReturn(aggregatedEntitiesWidgetDatumSet);

    // Act
    ImmutableAggregatedEntitiesWidgetData actualCopyOfResult = ImmutableAggregatedEntitiesWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, actualCopyOfResult.cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData#copyOf(AggregatedEntitiesWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AggregatedEntitiesWidgetDatum> aggregatedEntitiesWidgetDatumSet = new HashSet<>();
    aggregatedEntitiesWidgetDatumSet.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());
    aggregatedEntitiesWidgetDatumSet.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());
    AggregatedEntitiesWidgetData instance = mock(AggregatedEntitiesWidgetData.class);
    when(instance.cellData()).thenReturn(aggregatedEntitiesWidgetDatumSet);

    // Act
    ImmutableAggregatedEntitiesWidgetData actualCopyOfResult = ImmutableAggregatedEntitiesWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(aggregatedEntitiesWidgetDatumSet, actualCopyOfResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData#fromJson(ImmutableAggregatedEntitiesWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData.Json json = new ImmutableAggregatedEntitiesWidgetData.Json();

    // Act and Assert
    Set<AggregatedEntitiesWidgetDatum> cellDataResult = ImmutableAggregatedEntitiesWidgetData.fromJson(json).cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(json.cellData, cellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData#fromJson(ImmutableAggregatedEntitiesWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData.Json json = new ImmutableAggregatedEntitiesWidgetData.Json();
    json.setCellData(null);

    // Act and Assert
    assertTrue(ImmutableAggregatedEntitiesWidgetData.fromJson(json).cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData#fromJson(ImmutableAggregatedEntitiesWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AggregatedEntitiesWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());

    ImmutableAggregatedEntitiesWidgetData.Json json = new ImmutableAggregatedEntitiesWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(1, ImmutableAggregatedEntitiesWidgetData.fromJson(json).cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData#fromJson(ImmutableAggregatedEntitiesWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<AggregatedEntitiesWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());
    cellData.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());

    ImmutableAggregatedEntitiesWidgetData.Json json = new ImmutableAggregatedEntitiesWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(cellData, ImmutableAggregatedEntitiesWidgetData.fromJson(json).cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregatedEntitiesWidgetData.Json()).cellData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAggregatedEntitiesWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableAggregatedEntitiesWidgetData.Json()).cellData.isEmpty());
  }
}
