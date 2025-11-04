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

class ImmutableTargetCostWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableTargetCostWidgetData.Builder builderResult = ImmutableTargetCostWidgetData.builder();

    // Act
    ImmutableTargetCostWidgetData.Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData.Builder#addCellData(TargetCostWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableTargetCostWidgetData.Builder builderResult = ImmutableTargetCostWidgetData.builder();

    // Act
    ImmutableTargetCostWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableTargetCostWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData.Builder#addCellData(TargetCostWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableTargetCostWidgetData.Builder builderResult = ImmutableTargetCostWidgetData.builder();

    // Act
    ImmutableTargetCostWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableTargetCostWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test: {@link ImmutableTargetCostWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableTargetCostWidgetData.builder().build().cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableTargetCostWidgetData.Builder builderResult = ImmutableTargetCostWidgetData.builder();

    // Act
    ImmutableTargetCostWidgetData.Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData.Builder#from(TargetCostWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTargetCostWidgetData.Builder builderResult = ImmutableTargetCostWidgetData.builder();
    TargetCostWidgetData instance = mock(TargetCostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableTargetCostWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData.Builder#from(TargetCostWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTargetCostWidgetData.Builder builderResult = ImmutableTargetCostWidgetData.builder();

    HashSet<TargetCostWidgetDatum> targetCostWidgetDatumSet = new HashSet<>();
    targetCostWidgetDatumSet.add(new ImmutableTargetCostWidgetDatum.Json());
    TargetCostWidgetData instance = mock(TargetCostWidgetData.class);
    when(instance.cellData()).thenReturn(targetCostWidgetDatumSet);

    // Act
    ImmutableTargetCostWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData#copyOf(TargetCostWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TargetCostWidgetData instance = mock(TargetCostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableTargetCostWidgetData actualCopyOfResult = ImmutableTargetCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertTrue(actualCopyOfResult.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData#copyOf(TargetCostWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<TargetCostWidgetDatum> targetCostWidgetDatumSet = new HashSet<>();
    targetCostWidgetDatumSet.add(new ImmutableTargetCostWidgetDatum.Json());
    TargetCostWidgetData instance = mock(TargetCostWidgetData.class);
    when(instance.cellData()).thenReturn(targetCostWidgetDatumSet);

    // Act
    ImmutableTargetCostWidgetData actualCopyOfResult = ImmutableTargetCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, actualCopyOfResult.cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData#copyOf(TargetCostWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<TargetCostWidgetDatum> targetCostWidgetDatumSet = new HashSet<>();
    targetCostWidgetDatumSet.add(new ImmutableTargetCostWidgetDatum.Json());
    targetCostWidgetDatumSet.add(new ImmutableTargetCostWidgetDatum.Json());
    TargetCostWidgetData instance = mock(TargetCostWidgetData.class);
    when(instance.cellData()).thenReturn(targetCostWidgetDatumSet);

    // Act
    ImmutableTargetCostWidgetData actualCopyOfResult = ImmutableTargetCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(targetCostWidgetDatumSet, actualCopyOfResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData#fromJson(ImmutableTargetCostWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableTargetCostWidgetData.Json json = new ImmutableTargetCostWidgetData.Json();

    // Act and Assert
    Set<TargetCostWidgetDatum> cellDataResult = ImmutableTargetCostWidgetData.fromJson(json).cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(json.cellData, cellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData#fromJson(ImmutableTargetCostWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableTargetCostWidgetData.Json json = new ImmutableTargetCostWidgetData.Json();
    json.setCellData(null);

    // Act and Assert
    assertTrue(ImmutableTargetCostWidgetData.fromJson(json).cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData#fromJson(ImmutableTargetCostWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<TargetCostWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableTargetCostWidgetDatum.Json());

    ImmutableTargetCostWidgetData.Json json = new ImmutableTargetCostWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(1, ImmutableTargetCostWidgetData.fromJson(json).cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableTargetCostWidgetData#fromJson(ImmutableTargetCostWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<TargetCostWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableTargetCostWidgetDatum.Json());
    cellData.add(new ImmutableTargetCostWidgetDatum.Json());

    ImmutableTargetCostWidgetData.Json json = new ImmutableTargetCostWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(cellData, ImmutableTargetCostWidgetData.fromJson(json).cellData());
  }

  /**
   * Method under test: {@link ImmutableTargetCostWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTargetCostWidgetData.Json()).cellData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableTargetCostWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableTargetCostWidgetData.Json()).cellData.isEmpty());
  }
}
