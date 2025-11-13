package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.finos.waltz.service.bulk_upload.TabularDataUtilities.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkUploadUtilitiesDiffblueTest {
  /**
   * Test {@link BulkUploadUtilities#streamRowData(String)}.
   *
   * <p>Method under test: {@link BulkUploadUtilities#streamRowData(String)}
   */
  @Test
  @DisplayName("Test streamRowData(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream BulkUploadUtilities.streamRowData(String)"})
  void testStreamRowData() {
    // Arrange and Act
    Stream<TabularRow> actualStreamRowDataResult =
        BulkUploadUtilities.streamRowData("Input String");

    // Assert
    List<TabularRow> collectResult =
        actualStreamRowDataResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    TabularRow getResult = collectResult.get(0);
    assertTrue(getResult instanceof ImmutableTabularRow);
    assertEquals(1, getResult.rowNumber());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  @DisplayName(
      "Test getColumnValuesFromInputString(String, int); when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromInputString(String, int)"})
  void testGetColumnValuesFromInputString_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString =
        BulkUploadUtilities.getColumnValuesFromInputString("", 1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}.
   *
   * <ul>
   *   <li>When {@code Input String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  @DisplayName(
      "Test getColumnValuesFromInputString(String, int); when 'Input String'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromInputString(String, int)"})
  void testGetColumnValuesFromInputString_whenInputString_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString =
        BulkUploadUtilities.getColumnValuesFromInputString("Input String", 1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}.
   *
   * <ul>
   *   <li>When {@code #}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromInputString(String, int); when '#'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromInputString(String, int)"})
  void testGetColumnValuesFromInputString_whenNumberSign_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString =
        BulkUploadUtilities.getColumnValuesFromInputString("#", 1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  @DisplayName(
      "Test getColumnValuesFromInputString(String, int); when zero; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromInputString(String, int)"})
  void testGetColumnValuesFromInputString_whenZero_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString =
        BulkUploadUtilities.getColumnValuesFromInputString("Input String", 0);

    // Assert
    assertEquals(1, actualColumnValuesFromInputString.size());
    assertTrue(actualColumnValuesFromInputString.contains("Input String"));
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows() {
    // Arrange
    LinkedHashSet<Row> rows = new LinkedHashSet<>();
    ImmutableTabularRow inputRow = ImmutableTabularRow.builder().rowNumber(10).values("42").build();
    Row row = new Row(inputRow, new HashMap<>());
    rows.add(row);

    // Act
    Set<String> actualColumnValuesFromRows =
        BulkUploadUtilities.getColumnValuesFromRows(rows, "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows2() {
    // Arrange
    HashSet<Row> rows = new HashSet<>();
    ImmutableTabularRow inputRow = ImmutableTabularRow.builder().rowNumber(10).values("42").build();
    Row row = new Row(inputRow, new HashMap<>());
    rows.add(row);
    ImmutableTabularRow inputRow2 =
        ImmutableTabularRow.builder().rowNumber(10).values("42").build();
    Row row2 = new Row(inputRow2, new HashMap<>());
    rows.add(row2);

    // Act
    Set<String> actualColumnValuesFromRows =
        BulkUploadUtilities.getColumnValuesFromRows(rows, "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows3() {
    // Arrange
    HashMap<String, Integer> colIdxByName = new HashMap<>();
    colIdxByName.put("42", 1);
    ImmutableTabularRow inputRow = ImmutableTabularRow.builder().rowNumber(10).values("42").build();

    Row row = new Row(inputRow, colIdxByName);

    LinkedHashSet<Row> rows = new LinkedHashSet<>();
    rows.add(row);

    // Act
    Set<String> actualColumnValuesFromRows =
        BulkUploadUtilities.getColumnValuesFromRows(rows, "42");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows4() {
    // Arrange
    HashMap<String, Integer> colIdxByName = new HashMap<>();
    colIdxByName.put("42", 1);
    ImmutableTabularRow inputRow =
        ImmutableTabularRow.builder().rowNumber(10).values("42", "").build();

    Row row = new Row(inputRow, colIdxByName);

    LinkedHashSet<Row> rows = new LinkedHashSet<>();
    rows.add(row);

    // Act
    Set<String> actualColumnValuesFromRows =
        BulkUploadUtilities.getColumnValuesFromRows(rows, "42");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TabularRow#values()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String); then calls values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows_thenCallsValues() {
    // Arrange
    TabularRow inputRow = mock(TabularRow.class);
    when(inputRow.values()).thenReturn(new String[] {"42"});

    HashMap<String, Integer> colIdxByName = new HashMap<>();
    colIdxByName.put("42", 1);

    Row row = new Row(inputRow, colIdxByName);

    LinkedHashSet<Row> rows = new LinkedHashSet<>();
    rows.add(row);

    // Act
    Set<String> actualColumnValuesFromRows =
        BulkUploadUtilities.getColumnValuesFromRows(rows, "42");

    // Assert
    verify(inputRow).values();
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Integer> colIdxByName = new HashMap<>();
    colIdxByName.put("42", 1);
    ImmutableTabularRow inputRow =
        ImmutableTabularRow.builder().rowNumber(10).values("42", "Values").build();

    Row row = new Row(inputRow, colIdxByName);

    LinkedHashSet<Row> rows = new LinkedHashSet<>();
    rows.add(row);

    // Act
    Set<String> actualColumnValuesFromRows =
        BulkUploadUtilities.getColumnValuesFromRows(rows, "42");

    // Assert
    assertEquals(1, actualColumnValuesFromRows.size());
    assertTrue(actualColumnValuesFromRows.contains("Values"));
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows_whenHashSet_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualColumnValuesFromRows =
        BulkUploadUtilities.getColumnValuesFromRows(new HashSet<>(), "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }
}
