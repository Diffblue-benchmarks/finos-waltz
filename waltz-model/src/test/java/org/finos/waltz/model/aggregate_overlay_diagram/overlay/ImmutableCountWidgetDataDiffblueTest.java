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

class ImmutableCountWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCountWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableCountWidgetData.Builder builderResult = ImmutableCountWidgetData.builder();

    // Act
    ImmutableCountWidgetData.Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData.Builder#addCellData(CountWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableCountWidgetData.Builder builderResult = ImmutableCountWidgetData.builder();

    // Act
    ImmutableCountWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableCountWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData.Builder#addCellData(CountWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableCountWidgetData.Builder builderResult = ImmutableCountWidgetData.builder();

    // Act
    ImmutableCountWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableCountWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test: {@link ImmutableCountWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableCountWidgetData.builder().build().cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableCountWidgetData.Builder builderResult = ImmutableCountWidgetData.builder();

    // Act
    ImmutableCountWidgetData.Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData.Builder#from(CountWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCountWidgetData.Builder builderResult = ImmutableCountWidgetData.builder();
    CountWidgetData instance = mock(CountWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableCountWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData.Builder#from(CountWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCountWidgetData.Builder builderResult = ImmutableCountWidgetData.builder();

    HashSet<CountWidgetDatum> countWidgetDatumSet = new HashSet<>();
    countWidgetDatumSet.add(new ImmutableCountWidgetDatum.Json());
    CountWidgetData instance = mock(CountWidgetData.class);
    when(instance.cellData()).thenReturn(countWidgetDatumSet);

    // Act
    ImmutableCountWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCountWidgetData#copyOf(CountWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CountWidgetData instance = mock(CountWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableCountWidgetData actualCopyOfResult = ImmutableCountWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertTrue(actualCopyOfResult.cellData().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableCountWidgetData#copyOf(CountWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<CountWidgetDatum> countWidgetDatumSet = new HashSet<>();
    countWidgetDatumSet.add(new ImmutableCountWidgetDatum.Json());
    CountWidgetData instance = mock(CountWidgetData.class);
    when(instance.cellData()).thenReturn(countWidgetDatumSet);

    // Act
    ImmutableCountWidgetData actualCopyOfResult = ImmutableCountWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, actualCopyOfResult.cellData().size());
  }

  /**
   * Method under test: {@link ImmutableCountWidgetData#copyOf(CountWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<CountWidgetDatum> countWidgetDatumSet = new HashSet<>();
    countWidgetDatumSet.add(new ImmutableCountWidgetDatum.Json());
    countWidgetDatumSet.add(new ImmutableCountWidgetDatum.Json());
    CountWidgetData instance = mock(CountWidgetData.class);
    when(instance.cellData()).thenReturn(countWidgetDatumSet);

    // Act
    ImmutableCountWidgetData actualCopyOfResult = ImmutableCountWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(countWidgetDatumSet, actualCopyOfResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData#fromJson(ImmutableCountWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCountWidgetData.Json json = new ImmutableCountWidgetData.Json();

    // Act and Assert
    Set<CountWidgetDatum> cellDataResult = ImmutableCountWidgetData.fromJson(json).cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(json.cellData, cellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData#fromJson(ImmutableCountWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableCountWidgetData.Json json = new ImmutableCountWidgetData.Json();
    json.setCellData(null);

    // Act and Assert
    assertTrue(ImmutableCountWidgetData.fromJson(json).cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData#fromJson(ImmutableCountWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<CountWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableCountWidgetDatum.Json());

    ImmutableCountWidgetData.Json json = new ImmutableCountWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(1, ImmutableCountWidgetData.fromJson(json).cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetData#fromJson(ImmutableCountWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<CountWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableCountWidgetDatum.Json());
    cellData.add(new ImmutableCountWidgetDatum.Json());

    ImmutableCountWidgetData.Json json = new ImmutableCountWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(cellData, ImmutableCountWidgetData.fromJson(json).cellData());
  }

  /**
   * Method under test: {@link ImmutableCountWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCountWidgetData.Json()).cellData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCountWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableCountWidgetData.Json()).cellData.isEmpty());
  }
}
