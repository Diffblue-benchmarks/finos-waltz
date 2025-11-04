package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ImmutableGridDiffblueTest {
  @InjectMocks
  private ImmutableGrid immutableGrid;

  /**
   * Method under test: {@link ImmutableGrid.Builder#addAllRows(Iterable)}
   */
  @Test
  void testBuilderAddAllRows() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRows(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableGrid.Builder#addRows(Row)}
   */
  @Test
  void testBuilderAddRows() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableRow.Json element = new ImmutableRow.Json();

    // Act
    ImmutableGrid.Builder actualAddRowsResult = builderResult.addRows(element);

    // Assert
    List<Row> rowsResult = builderResult.build().rows();
    assertEquals(1, rowsResult.size());
    assertSame(element, rowsResult.get(0));
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test: {@link ImmutableGrid.Builder#addRows(Row[])}
   */
  @Test
  void testBuilderAddRows2() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableRow.Json json = new ImmutableRow.Json();

    // Act
    ImmutableGrid.Builder actualAddRowsResult = builderResult.addRows(json);

    // Assert
    List<Row> rowsResult = builderResult.build().rows();
    assertEquals(1, rowsResult.size());
    assertSame(json, rowsResult.get(0));
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableGrid.Builder#build()}
   *   <li>{@link ImmutableGrid.Builder#columnDescriptors(List)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid.Builder columnDescriptorsResult = builderResult.columnDescriptors(new ArrayList<>());
    Optional<? extends List<ColumnDescriptor>> columnDescriptors = Optional.of(new ArrayList<>());

    // Act and Assert
    assertTrue(columnDescriptorsResult.columnDescriptors(columnDescriptors).build().rows().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableGrid.Builder#from(Grid)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    Grid instance = mock(Grid.class);
    when(instance.rows()).thenReturn(new ArrayList<>());
    Optional<List<ColumnDescriptor>> ofResult = Optional.of(new ArrayList<>());
    when(instance.columnDescriptors()).thenReturn(ofResult);

    // Act
    ImmutableGrid.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnDescriptors();
    verify(instance).rows();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableGrid.Builder#from(Grid)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    ArrayList<Row> rowList = new ArrayList<>();
    ImmutableRow.Json json = new ImmutableRow.Json();
    rowList.add(json);
    Grid instance = mock(Grid.class);
    when(instance.rows()).thenReturn(rowList);
    Optional<List<ColumnDescriptor>> ofResult = Optional.of(new ArrayList<>());
    when(instance.columnDescriptors()).thenReturn(ofResult);

    // Act
    ImmutableGrid.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnDescriptors();
    verify(instance).rows();
    List<Row> rowsResult = builderResult.build().rows();
    assertEquals(1, rowsResult.size());
    assertSame(json, rowsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableGrid.Builder#from(Grid)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    Grid instance = mock(Grid.class);
    when(instance.rows()).thenReturn(new ArrayList<>());
    Optional<List<ColumnDescriptor>> emptyResult = Optional.empty();
    when(instance.columnDescriptors()).thenReturn(emptyResult);

    // Act
    ImmutableGrid.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnDescriptors();
    verify(instance).rows();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableGrid.Builder#rows(Iterable)}
   */
  @Test
  void testBuilderRows() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rows(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableGrid#copyOf(Grid)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Grid instance = mock(Grid.class);
    when(instance.rows()).thenReturn(new ArrayList<>());
    Optional<List<ColumnDescriptor>> ofResult = Optional.of(new ArrayList<>());
    when(instance.columnDescriptors()).thenReturn(ofResult);

    // Act
    ImmutableGrid actualCopyOfResult = ImmutableGrid.copyOf(instance);

    // Assert
    verify(instance).columnDescriptors();
    verify(instance).rows();
    assertTrue(actualCopyOfResult.rows().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableGrid#copyOf(Grid)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Row> rowList = new ArrayList<>();
    rowList.add(new ImmutableRow.Json());
    Grid instance = mock(Grid.class);
    when(instance.rows()).thenReturn(rowList);
    Optional<List<ColumnDescriptor>> ofResult = Optional.of(new ArrayList<>());
    when(instance.columnDescriptors()).thenReturn(ofResult);

    // Act
    ImmutableGrid actualCopyOfResult = ImmutableGrid.copyOf(instance);

    // Assert
    verify(instance).columnDescriptors();
    verify(instance).rows();
    assertEquals(rowList, actualCopyOfResult.rows());
  }

  /**
   * Method under test: {@link ImmutableGrid#copyOf(Grid)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Row> rowList = new ArrayList<>();
    rowList.add(new ImmutableRow.Json());
    rowList.add(new ImmutableRow.Json());
    Grid instance = mock(Grid.class);
    when(instance.rows()).thenReturn(rowList);
    Optional<List<ColumnDescriptor>> ofResult = Optional.of(new ArrayList<>());
    when(instance.columnDescriptors()).thenReturn(ofResult);

    // Act
    ImmutableGrid actualCopyOfResult = ImmutableGrid.copyOf(instance);

    // Assert
    verify(instance).columnDescriptors();
    verify(instance).rows();
    assertEquals(rowList, actualCopyOfResult.rows());
  }

  /**
   * Method under test: {@link ImmutableGrid#copyOf(Grid)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    Grid instance = mock(Grid.class);
    when(instance.rows()).thenReturn(new ArrayList<>());
    Optional<List<ColumnDescriptor>> emptyResult = Optional.empty();
    when(instance.columnDescriptors()).thenReturn(emptyResult);

    // Act
    ImmutableGrid actualCopyOfResult = ImmutableGrid.copyOf(instance);

    // Assert
    verify(instance).columnDescriptors();
    verify(instance).rows();
    assertTrue(actualCopyOfResult.rows().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableGrid#fromJson(ImmutableGrid.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableGrid.Json json = new ImmutableGrid.Json();

    // Act and Assert
    List<Row> rowsResult = ImmutableGrid.fromJson(json).rows();
    assertTrue(rowsResult.isEmpty());
    assertSame(json.rows, rowsResult);
  }

  /**
   * Method under test: {@link ImmutableGrid#fromJson(ImmutableGrid.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableGrid.Json json = new ImmutableGrid.Json();
    json.setColumnDescriptors(null);
    json.setRows(null);

    // Act and Assert
    assertTrue(ImmutableGrid.fromJson(json).rows().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableGrid#fromJson(ImmutableGrid.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Row> rows = new ArrayList<>();
    rows.add(new ImmutableRow.Json());

    ImmutableGrid.Json json = new ImmutableGrid.Json();
    json.setColumnDescriptors(null);
    json.setRows(rows);

    // Act and Assert
    assertEquals(rows, ImmutableGrid.fromJson(json).rows());
  }

  /**
   * Method under test: {@link ImmutableGrid#fromJson(ImmutableGrid.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    COWArrayList<Row> rows = mock(COWArrayList.class);

    ArrayList<Row> rowList = new ArrayList<>();
    when(rows.iterator()).thenReturn(rowList.iterator());

    ImmutableGrid.Json json = new ImmutableGrid.Json();
    json.setColumnDescriptors(null);
    json.setRows(rows);

    // Act
    ImmutableGrid actualFromJsonResult = ImmutableGrid.fromJson(json);

    // Assert
    verify(rows).iterator();
    assertTrue(actualFromJsonResult.rows().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableGrid#fromJson(ImmutableGrid.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<Row> rowList = new ArrayList<>();
    rowList.add(new ImmutableRow.Json());
    rowList.add(new ImmutableRow.Json());
    COWArrayList<Row> rows = mock(COWArrayList.class);
    when(rows.iterator()).thenReturn(rowList.iterator());

    ImmutableGrid.Json json = new ImmutableGrid.Json();
    json.setColumnDescriptors(null);
    json.setRows(rows);

    // Act
    ImmutableGrid actualFromJsonResult = ImmutableGrid.fromJson(json);

    // Assert
    verify(rows).iterator();
    assertEquals(rowList, actualFromJsonResult.rows());
  }

  /**
   * Method under test: {@link ImmutableGrid.Json#columnDescriptors()}
   */
  @Test
  void testJsonColumnDescriptors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableGrid.Json()).columnDescriptors());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableGrid.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableGrid.Json actualJson = new ImmutableGrid.Json();

    // Assert
    assertFalse(actualJson.columnDescriptors.isPresent());
    assertTrue(actualJson.rows.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableGrid.Json#rows()}
   */
  @Test
  void testJsonRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableGrid.Json()).rows());
  }

  /**
   * Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  void testWithColumnDescriptors() {
    // Arrange, Act and Assert
    assertNull(immutableGrid.withColumnDescriptors(new ArrayList<>()).rows());
  }

  /**
   * Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  void testWithColumnDescriptors2() {
    // Arrange
    ArrayList<ColumnDescriptor> value = new ArrayList<>();
    value.add(new ImmutableColumnDescriptor.Json());

    // Act and Assert
    assertNull(immutableGrid.withColumnDescriptors(value).rows());
  }

  /**
   * Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  void testWithColumnDescriptors3() {
    // Arrange
    ArrayList<ColumnDescriptor> value = new ArrayList<>();
    value.add(new ImmutableColumnDescriptor.Json());
    value.add(new ImmutableColumnDescriptor.Json());

    // Act and Assert
    assertNull(immutableGrid.withColumnDescriptors(value).rows());
  }

  /**
   * Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  void testWithColumnDescriptors4() {
    // Arrange
    ArrayList<ColumnDescriptor> value = new ArrayList<>();
    value.add(mock(ColumnDescriptor.class));

    // Act and Assert
    assertNull(immutableGrid.withColumnDescriptors(value).rows());
  }
}
