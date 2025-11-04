package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableRowDiffblueTest {
  /**
   * Method under test: {@link ImmutableRow.Builder#addAllCells(Iterable)}
   */
  @Test
  void testBuilderAddAllCells() {
    // Arrange
    ImmutableRow.Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCells(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableRow.Builder#addCells(CellValue)}
   */
  @Test
  void testBuilderAddCells() {
    // Arrange
    ImmutableRow.Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCells(new ImmutableCellValue.Json()));
  }

  /**
   * Method under test: {@link ImmutableRow.Builder#addCells(CellValue[])}
   */
  @Test
  void testBuilderAddCells2() {
    // Arrange
    ImmutableRow.Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCells(new ImmutableCellValue.Json()));
  }

  /**
   * Method under test: {@link ImmutableRow.Builder#cells(Iterable)}
   */
  @Test
  void testBuilderCells() {
    // Arrange
    ImmutableRow.Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cells(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableRow.Builder#from(Row)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRow.Builder builderResult = ImmutableRow.builder();
    Row instance = mock(Row.class);
    when(instance.cells()).thenReturn(new ArrayList<>());
    ImmutableKeyCell.Json json = new ImmutableKeyCell.Json();
    when(instance.id()).thenReturn(json);

    // Act
    ImmutableRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cells();
    verify(instance).id();
    assertSame(json, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRow.Builder#from(Row)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRow.Builder builderResult = ImmutableRow.builder();
    Row instance = mock(Row.class);
    when(instance.cells()).thenThrow(new IllegalStateException("instance"));
    when(instance.id()).thenReturn(new ImmutableKeyCell.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cells();
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableRow.Builder#from(Row)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRow.Builder builderResult = ImmutableRow.builder();

    ArrayList<CellValue> cellValueList = new ArrayList<>();
    ImmutableCellValue.Json json = new ImmutableCellValue.Json();
    cellValueList.add(json);
    Row instance = mock(Row.class);
    when(instance.cells()).thenReturn(cellValueList);
    ImmutableKeyCell.Json json2 = new ImmutableKeyCell.Json();
    when(instance.id()).thenReturn(json2);

    // Act
    ImmutableRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cells();
    verify(instance).id();
    ImmutableRow buildResult = builderResult.build();
    List<CellValue> cellsResult = buildResult.cells();
    assertEquals(1, cellsResult.size());
    assertSame(json, cellsResult.get(0));
    assertSame(json2, buildResult.id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRow.Builder#id(KeyCell)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableRow.Builder builderResult = ImmutableRow.builder();
    ImmutableKeyCell.Json id = new ImmutableKeyCell.Json();

    // Act
    ImmutableRow.Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(id, builderResult.build().id());
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Method under test: {@link ImmutableRow#copyOf(Row)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Row instance = mock(Row.class);
    when(instance.cells()).thenReturn(new ArrayList<>());
    ImmutableKeyCell.Json json = new ImmutableKeyCell.Json();
    when(instance.id()).thenReturn(json);

    // Act
    ImmutableRow actualCopyOfResult = ImmutableRow.copyOf(instance);

    // Assert
    verify(instance).cells();
    verify(instance).id();
    assertTrue(actualCopyOfResult.cells().isEmpty());
    assertSame(json, actualCopyOfResult.id());
  }

  /**
   * Method under test: {@link ImmutableRow#copyOf(Row)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<CellValue> cellValueList = new ArrayList<>();
    cellValueList.add(new ImmutableCellValue.Json());
    Row instance = mock(Row.class);
    when(instance.cells()).thenReturn(cellValueList);
    ImmutableKeyCell.Json json = new ImmutableKeyCell.Json();
    when(instance.id()).thenReturn(json);

    // Act
    ImmutableRow actualCopyOfResult = ImmutableRow.copyOf(instance);

    // Assert
    verify(instance).cells();
    verify(instance).id();
    assertEquals(cellValueList, actualCopyOfResult.cells());
    assertSame(json, actualCopyOfResult.id());
  }

  /**
   * Method under test: {@link ImmutableRow#copyOf(Row)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<CellValue> cellValueList = new ArrayList<>();
    cellValueList.add(new ImmutableCellValue.Json());
    cellValueList.add(new ImmutableCellValue.Json());
    Row instance = mock(Row.class);
    when(instance.cells()).thenReturn(cellValueList);
    ImmutableKeyCell.Json json = new ImmutableKeyCell.Json();
    when(instance.id()).thenReturn(json);

    // Act
    ImmutableRow actualCopyOfResult = ImmutableRow.copyOf(instance);

    // Assert
    verify(instance).cells();
    verify(instance).id();
    assertEquals(cellValueList, actualCopyOfResult.cells());
    assertSame(json, actualCopyOfResult.id());
  }

  /**
   * Method under test: {@link ImmutableRow#fromJson(ImmutableRow.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableRow.Json json = new ImmutableRow.Json();
    ImmutableKeyCell.Json id = new ImmutableKeyCell.Json();
    json.setId(id);
    json.setCells(null);

    // Act
    ImmutableRow actualFromJsonResult = ImmutableRow.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.cells().isEmpty());
    assertSame(id, actualFromJsonResult.id());
  }

  /**
   * Method under test: {@link ImmutableRow#fromJson(ImmutableRow.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<CellValue> cells = new ArrayList<>();
    cells.add(new ImmutableCellValue.Json());

    ImmutableRow.Json json = new ImmutableRow.Json();
    ImmutableKeyCell.Json id = new ImmutableKeyCell.Json();
    json.setId(id);
    json.setCells(cells);

    // Act
    ImmutableRow actualFromJsonResult = ImmutableRow.fromJson(json);

    // Assert
    assertEquals(cells, actualFromJsonResult.cells());
    assertSame(id, actualFromJsonResult.id());
  }

  /**
   * Method under test: {@link ImmutableRow#fromJson(ImmutableRow.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<CellValue> cells = new ArrayList<>();
    cells.add(new ImmutableCellValue.Json());
    cells.add(new ImmutableCellValue.Json());

    ImmutableRow.Json json = new ImmutableRow.Json();
    ImmutableKeyCell.Json id = new ImmutableKeyCell.Json();
    json.setId(id);
    json.setCells(cells);

    // Act
    ImmutableRow actualFromJsonResult = ImmutableRow.fromJson(json);

    // Assert
    assertEquals(cells, actualFromJsonResult.cells());
    assertSame(id, actualFromJsonResult.id());
  }

  /**
   * Method under test: {@link ImmutableRow.Json#cells()}
   */
  @Test
  void testJsonCells() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRow.Json()).cells());
  }

  /**
   * Method under test: {@link ImmutableRow.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRow.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRow.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRow.Json actualJson = new ImmutableRow.Json();

    // Assert
    assertNull(actualJson.id);
    assertTrue(actualJson.cells.isEmpty());
  }
}
