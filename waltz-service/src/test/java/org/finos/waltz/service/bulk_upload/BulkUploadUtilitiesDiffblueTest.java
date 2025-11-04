package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class BulkUploadUtilitiesDiffblueTest {
  /**
   * Method under test: {@link BulkUploadUtilities#streamRowData(String)}
   */
  @Test
  void testStreamRowData() {
    // Arrange and Act
    Stream<TabularRow> actualStreamRowDataResult = BulkUploadUtilities.streamRowData("Input String");

    // Assert
    List<TabularRow> collectResult = actualStreamRowDataResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    TabularRow getResult = collectResult.get(0);
    assertTrue(getResult instanceof ImmutableTabularRow);
    assertEquals(1, getResult.rowNumber());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  void testGetColumnValuesFromInputString() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString = BulkUploadUtilities.getColumnValuesFromInputString("Input String",
        1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  void testGetColumnValuesFromInputString2() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString = BulkUploadUtilities.getColumnValuesFromInputString("Input String",
        0);

    // Assert
    assertEquals(1, actualColumnValuesFromInputString.size());
    assertTrue(actualColumnValuesFromInputString.contains("Input String"));
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  void testGetColumnValuesFromInputString3() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString = BulkUploadUtilities.getColumnValuesFromInputString("#", 1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  void testGetColumnValuesFromInputString4() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString = BulkUploadUtilities.getColumnValuesFromInputString("", 1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  void testGetColumnValuesFromRows() {
    // Arrange and Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(new HashSet<>(),
        "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  void testGetColumnValuesFromRows2() {
    // Arrange
    HashSet<TabularDataUtilities.Row> rows = new HashSet<>();
    rows.add(new TabularDataUtilities.Row(null, new HashMap<>()));

    // Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(rows, "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  void testGetColumnValuesFromRows3() {
    // Arrange
    HashSet<TabularDataUtilities.Row> rows = new HashSet<>();
    rows.add(new TabularDataUtilities.Row(null, new HashMap<>()));
    rows.add(new TabularDataUtilities.Row(null, new HashMap<>()));

    // Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(rows, "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  void testGetColumnValuesFromRows4() {
    // Arrange
    HashSet<TabularDataUtilities.Row> rows = new HashSet<>();
    TabularRow inputRow = mock(TabularRow.class);
    rows.add(new TabularDataUtilities.Row(inputRow, new HashMap<>()));

    // Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(rows, "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  void testGetColumnValuesFromRows5() {
    // Arrange
    TabularRow inputRow = mock(TabularRow.class);
    when(inputRow.values()).thenReturn(new String[]{"42"});

    HashMap<String, Integer> colIdxByName = new HashMap<>();
    colIdxByName.put("", -1);
    TabularDataUtilities.Row row = new TabularDataUtilities.Row(inputRow, colIdxByName);

    HashSet<TabularDataUtilities.Row> rows = new HashSet<>();
    rows.add(row);

    // Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(rows, "");

    // Assert
    verify(inputRow).values();
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  void testGetColumnValuesFromRows6() {
    // Arrange
    TabularRow inputRow = mock(TabularRow.class);
    when(inputRow.values()).thenReturn(new String[]{"42"});

    HashMap<String, Integer> colIdxByName = new HashMap<>();
    colIdxByName.put("", 0);
    TabularDataUtilities.Row row = new TabularDataUtilities.Row(inputRow, colIdxByName);

    HashSet<TabularDataUtilities.Row> rows = new HashSet<>();
    rows.add(row);

    // Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(rows, "");

    // Assert
    verify(inputRow).values();
    assertEquals(1, actualColumnValuesFromRows.size());
    assertTrue(actualColumnValuesFromRows.contains("42"));
  }
}
