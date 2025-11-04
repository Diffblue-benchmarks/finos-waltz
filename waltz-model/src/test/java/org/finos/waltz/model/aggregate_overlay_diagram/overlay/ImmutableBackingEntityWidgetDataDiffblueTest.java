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

class ImmutableBackingEntityWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableBackingEntityWidgetData.Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    // Act
    ImmutableBackingEntityWidgetData.Builder actualAddAllCellDataResult = builderResult
        .addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData.Builder#addCellData(BackingEntityWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableBackingEntityWidgetData.Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    // Act
    ImmutableBackingEntityWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableBackingEntityWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData.Builder#addCellData(BackingEntityWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableBackingEntityWidgetData.Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    // Act
    ImmutableBackingEntityWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableBackingEntityWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test: {@link ImmutableBackingEntityWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableBackingEntityWidgetData.builder().build().cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableBackingEntityWidgetData.Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    // Act
    ImmutableBackingEntityWidgetData.Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData.Builder#from(BackingEntityWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBackingEntityWidgetData.Builder builderResult = ImmutableBackingEntityWidgetData.builder();
    BackingEntityWidgetData instance = mock(BackingEntityWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableBackingEntityWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData.Builder#from(BackingEntityWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBackingEntityWidgetData.Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    HashSet<BackingEntityWidgetDatum> backingEntityWidgetDatumSet = new HashSet<>();
    backingEntityWidgetDatumSet.add(new ImmutableBackingEntityWidgetDatum.Json());
    BackingEntityWidgetData instance = mock(BackingEntityWidgetData.class);
    when(instance.cellData()).thenReturn(backingEntityWidgetDatumSet);

    // Act
    ImmutableBackingEntityWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData#copyOf(BackingEntityWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BackingEntityWidgetData instance = mock(BackingEntityWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableBackingEntityWidgetData actualCopyOfResult = ImmutableBackingEntityWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertTrue(actualCopyOfResult.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData#copyOf(BackingEntityWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<BackingEntityWidgetDatum> backingEntityWidgetDatumSet = new HashSet<>();
    backingEntityWidgetDatumSet.add(new ImmutableBackingEntityWidgetDatum.Json());
    BackingEntityWidgetData instance = mock(BackingEntityWidgetData.class);
    when(instance.cellData()).thenReturn(backingEntityWidgetDatumSet);

    // Act
    ImmutableBackingEntityWidgetData actualCopyOfResult = ImmutableBackingEntityWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, actualCopyOfResult.cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData#copyOf(BackingEntityWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<BackingEntityWidgetDatum> backingEntityWidgetDatumSet = new HashSet<>();
    backingEntityWidgetDatumSet.add(new ImmutableBackingEntityWidgetDatum.Json());
    backingEntityWidgetDatumSet.add(new ImmutableBackingEntityWidgetDatum.Json());
    BackingEntityWidgetData instance = mock(BackingEntityWidgetData.class);
    when(instance.cellData()).thenReturn(backingEntityWidgetDatumSet);

    // Act
    ImmutableBackingEntityWidgetData actualCopyOfResult = ImmutableBackingEntityWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(backingEntityWidgetDatumSet, actualCopyOfResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData#fromJson(ImmutableBackingEntityWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBackingEntityWidgetData.Json json = new ImmutableBackingEntityWidgetData.Json();

    // Act and Assert
    Set<BackingEntityWidgetDatum> cellDataResult = ImmutableBackingEntityWidgetData.fromJson(json).cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(json.cellData, cellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData#fromJson(ImmutableBackingEntityWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableBackingEntityWidgetData.Json json = new ImmutableBackingEntityWidgetData.Json();
    json.setCellData(null);

    // Act and Assert
    assertTrue(ImmutableBackingEntityWidgetData.fromJson(json).cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData#fromJson(ImmutableBackingEntityWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<BackingEntityWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableBackingEntityWidgetDatum.Json());

    ImmutableBackingEntityWidgetData.Json json = new ImmutableBackingEntityWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(1, ImmutableBackingEntityWidgetData.fromJson(json).cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetData#fromJson(ImmutableBackingEntityWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<BackingEntityWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableBackingEntityWidgetDatum.Json());
    cellData.add(new ImmutableBackingEntityWidgetDatum.Json());

    ImmutableBackingEntityWidgetData.Json json = new ImmutableBackingEntityWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(cellData, ImmutableBackingEntityWidgetData.fromJson(json).cellData());
  }

  /**
   * Method under test: {@link ImmutableBackingEntityWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBackingEntityWidgetData.Json()).cellData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBackingEntityWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableBackingEntityWidgetData.Json()).cellData.isEmpty());
  }
}
