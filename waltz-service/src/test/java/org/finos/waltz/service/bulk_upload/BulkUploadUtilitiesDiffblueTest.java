package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
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
   * <p>
   * Method under test: {@link BulkUploadUtilities#streamRowData(String)}
   */
  @Test
  @DisplayName("Test streamRowData(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream BulkUploadUtilities.streamRowData(String)"})
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
   * Test {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromInputString(String, int); when empty string; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromInputString(String, int)"})
  void testGetColumnValuesFromInputString_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString = BulkUploadUtilities.getColumnValuesFromInputString("", 1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}.
   * <ul>
   *   <li>When {@code Input String}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromInputString(String, int); when 'Input String'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromInputString(String, int)"})
  void testGetColumnValuesFromInputString_whenInputString_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString = BulkUploadUtilities.getColumnValuesFromInputString("Input String",
        1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromInputString(String, int); when '#'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromInputString(String, int)"})
  void testGetColumnValuesFromInputString_whenNumberSign_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString = BulkUploadUtilities.getColumnValuesFromInputString("#", 1);

    // Assert
    assertTrue(actualColumnValuesFromInputString.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadUtilities#getColumnValuesFromInputString(String, int)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromInputString(String, int); when zero; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromInputString(String, int)"})
  void testGetColumnValuesFromInputString_whenZero_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<String> actualColumnValuesFromInputString = BulkUploadUtilities.getColumnValuesFromInputString("Input String",
        0);

    // Assert
    assertEquals(1, actualColumnValuesFromInputString.size());
    assertTrue(actualColumnValuesFromInputString.contains("Input String"));
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows_thenReturnEmpty() {
    // Arrange
    HashSet<Row> rows = new HashSet<>();
    rows.add(new Row(null, new HashMap<>()));

    // Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(rows, "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows_thenReturnEmpty2() {
    // Arrange
    HashSet<Row> rows = new HashSet<>();
    rows.add(new Row(null, new HashMap<>()));
    rows.add(new Row(null, new HashMap<>()));

    // Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(rows, "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }

  /**
   * Test {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadUtilities#getColumnValuesFromRows(Set, String)}
   */
  @Test
  @DisplayName("Test getColumnValuesFromRows(Set, String); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set BulkUploadUtilities.getColumnValuesFromRows(Set, String)"})
  void testGetColumnValuesFromRows_whenHashSet_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualColumnValuesFromRows = BulkUploadUtilities.getColumnValuesFromRows(new HashSet<>(),
        "Column Header");

    // Assert
    assertTrue(actualColumnValuesFromRows.isEmpty());
  }
}
