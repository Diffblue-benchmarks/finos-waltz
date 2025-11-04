package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.report_grid.GridFilter;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.junit.jupiter.api.Test;

class ReportGridUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  void testParseGridFilterNoteText() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("Note Text"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(null));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(" "));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|--"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("|Cannot parse empty note"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|Note Text"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |;"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id | "));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |Note Text"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |\\r?\\n"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id || Grid Name | Grid Identifier"
                + " | Vantage Point Kind | Vantage Point Id |"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |[:;*?!/\\\\]"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |java.util.List"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |42"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |\\s+"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |java.util.Optional"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id ||"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |org.finos.waltz.service.report"
                + "_grid.ReportGridUtilities"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id || Filter Column | Filter Operator"
                + " | Value/s |"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |Incorrect number of header rows"
                + " found [%d], ensure there are blank rows between tables"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id ||--"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|;"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("| "));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|\\r?\\n"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("|| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|[:;*?!/\\\\]"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|\\s+"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("|| Filter Column | Filter Operator | Value/s |"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "|Incorrect number of header rows found [%d], ensure there are blank rows between tables"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |;"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s | "));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |Note Text"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |\\r?\\n"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Filter Column | Filter Operator | Value/s || Grid Name | Grid Identifier | Vantage Point Kind |"
                + " Vantage Point Id |"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |[:;*?!/\\\\]"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |java.util.List"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |42"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |\\s+"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |java.util.Optional"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s ||"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Filter Column | Filter Operator | Value/s |org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Filter Column | Filter Operator | Value/s || Filter Column | Filter Operator | Value/s |"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Filter Column | Filter Operator | Value/s |Incorrect number of header rows found [%d], ensure there"
                + " are blank rows between tables"));
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s ||--"));
  }

  /**
   * Method under test: {@link ReportGridUtilities#getFilterValues(String)}
   */
  @Test
  void testGetFilterValues() {
    // Arrange and Act
    Set<String> actualFilterValues = ReportGridUtilities.getFilterValues("String");

    // Assert
    assertEquals(1, actualFilterValues.size());
    assertTrue(actualFilterValues.contains("String"));
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"},
        "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData2() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(null, null);

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData3() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"}, null);

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData4() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{" "},
        "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData5() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"|"},
        "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData6() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{}, "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData7() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{";", " "},
        "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData8() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"}, ";");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData9() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"}, " ");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData10() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"},
        "[:;*?!/\\\\]");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData11() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"}, "\\s+");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData12() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"|"}, ";");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData13() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"|"}, "| --");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData14() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"|--"}, ";");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  void testParseTableData15() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"| --"}, ";");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  void testParseGridFilters() {
    // Arrange and Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(new ArrayList<>(), null);

    // Assert
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  void testParseGridFilters2() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, null);

    // Assert
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  void testParseGridFilters3() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(new ArrayList<>());
    filterRows.add(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, null);

    // Assert
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  void testParseGridFilters4() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  void testParseGridFilters5() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(new ArrayList<>());
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  void testParseGridFilters6() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDerivedColumnDefinition.externalId()).thenReturn(ofResult);

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridDerivedColumnDefinition).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  void testParseGridFilters7() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDerivedColumnDefinition.externalId()).thenReturn(ofResult);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult2 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition2.externalId()).thenReturn(ofResult2);

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition2);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridDerivedColumnDefinition2).externalId();
    verify(reportGridDerivedColumnDefinition).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition2).gridColumnId();
    verify(reportGridDerivedColumnDefinition).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  void testParseGridFilters8() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDerivedColumnDefinition.externalId()).thenReturn(ofResult);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult2 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition2.externalId()).thenReturn(ofResult2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition3 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition3.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult3 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition3.externalId()).thenReturn(ofResult3);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition4 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition4.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult4 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition4.externalId()).thenReturn(ofResult4);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition5 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition5.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult5 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition5.externalId()).thenReturn(ofResult5);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition6 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition6.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult6 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition6.externalId()).thenReturn(ofResult6);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition7 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition7.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult7 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition7.externalId()).thenReturn(ofResult7);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition8 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition8.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult8 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition8.externalId()).thenReturn(ofResult8);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition9 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition9.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult9 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition9.externalId()).thenReturn(ofResult9);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition10 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition10.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult10 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition10.externalId()).thenReturn(ofResult10);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition11 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition11.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult11 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition11.externalId()).thenReturn(ofResult11);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition12 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition12.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult12 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition12.externalId()).thenReturn(ofResult12);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition13 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition13.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult13 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition13.externalId()).thenReturn(ofResult13);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition14 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition14.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult14 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition14.externalId()).thenReturn(ofResult14);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition15 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition15.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult15 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition15.externalId()).thenReturn(ofResult15);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition16 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition16.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult16 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition16.externalId()).thenReturn(ofResult16);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition17 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition17.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult17 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition17.externalId()).thenReturn(ofResult17);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition18 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition18.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult18 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition18.externalId()).thenReturn(ofResult18);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition19 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition19.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult19 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition19.externalId()).thenReturn(ofResult19);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition20 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition20.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult20 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition20.externalId()).thenReturn(ofResult20);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition21 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition21.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult21 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition21.externalId()).thenReturn(ofResult21);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition22 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition22.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult22 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition22.externalId()).thenReturn(ofResult22);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition23 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition23.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult23 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition23.externalId()).thenReturn(ofResult23);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition24 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition24.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult24 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition24.externalId()).thenReturn(ofResult24);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition25 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition25.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult25 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition25.externalId()).thenReturn(ofResult25);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition26 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition26.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult26 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition26.externalId()).thenReturn(ofResult26);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition27 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition27.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult27 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition27.externalId()).thenReturn(ofResult27);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition28 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition28.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult28 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition28.externalId()).thenReturn(ofResult28);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition29 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition29.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult29 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition29.externalId()).thenReturn(ofResult29);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition30 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition30.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult30 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition30.externalId()).thenReturn(ofResult30);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition31 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition31.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult31 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition31.externalId()).thenReturn(ofResult31);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition32 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition32.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult32 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition32.externalId()).thenReturn(ofResult32);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition33 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition33.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult33 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition33.externalId()).thenReturn(ofResult33);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition34 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition34.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult34 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition34.externalId()).thenReturn(ofResult34);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition35 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition35.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult35 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition35.externalId()).thenReturn(ofResult35);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition36 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition36.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult36 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition36.externalId()).thenReturn(ofResult36);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition37 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition37.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult37 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition37.externalId()).thenReturn(ofResult37);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition38 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition38.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult38 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition38.externalId()).thenReturn(ofResult38);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition39 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition39.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult39 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition39.externalId()).thenReturn(ofResult39);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition40 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition40.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult40 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition40.externalId()).thenReturn(ofResult40);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition41 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition41.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult41 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition41.externalId()).thenReturn(ofResult41);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition42 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition42.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult42 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition42.externalId()).thenReturn(ofResult42);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition43 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition43.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult43 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition43.externalId()).thenReturn(ofResult43);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition44 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition44.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult44 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition44.externalId()).thenReturn(ofResult44);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition45 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition45.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult45 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition45.externalId()).thenReturn(ofResult45);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition46 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition46.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult46 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition46.externalId()).thenReturn(ofResult46);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition47 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition47.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult47 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition47.externalId()).thenReturn(ofResult47);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition48 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition48.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult48 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition48.externalId()).thenReturn(ofResult48);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition49 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition49.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult49 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition49.externalId()).thenReturn(ofResult49);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition50 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition50.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult50 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition50.externalId()).thenReturn(ofResult50);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition51 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition51.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult51 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition51.externalId()).thenReturn(ofResult51);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition52 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition52.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult52 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition52.externalId()).thenReturn(ofResult52);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition53 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition53.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult53 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition53.externalId()).thenReturn(ofResult53);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition54 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition54.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult54 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition54.externalId()).thenReturn(ofResult54);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition55 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition55.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult55 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition55.externalId()).thenReturn(ofResult55);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition56 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition56.gridColumnId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(reportGridDerivedColumnDefinition56.externalId()).thenReturn(emptyResult);

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition56);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition55);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition54);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition53);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition52);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition51);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition50);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition49);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition48);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition47);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition46);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition45);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition44);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition43);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition42);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition41);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition40);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition39);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition38);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition37);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition36);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition35);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition34);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition33);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition32);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition31);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition30);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition29);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition28);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition27);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition26);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition25);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition24);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition23);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition22);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition21);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition20);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition19);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition18);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition17);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition16);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition15);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition14);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition13);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition12);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition11);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition10);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition9);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition8);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition7);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition6);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition5);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition4);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition3);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition2);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridDerivedColumnDefinition56).externalId();
    verify(reportGridDerivedColumnDefinition55).externalId();
    verify(reportGridDerivedColumnDefinition54).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition56).gridColumnId();
    verify(reportGridDerivedColumnDefinition55).gridColumnId();
    verify(reportGridDerivedColumnDefinition54).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  void testSanitizeString() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString("Name"));
    assertEquals("", ReportGridUtilities.sanitizeString(null));
    assertEquals("", ReportGridUtilities.sanitizeString(";"));
    assertEquals("", ReportGridUtilities.sanitizeString(" "));
    assertEquals("[]", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]"));
    assertEquals("s+", ReportGridUtilities.sanitizeString("\\s+"));
    assertEquals("", ReportGridUtilities.sanitizeString(";;"));
    assertEquals("", ReportGridUtilities.sanitizeString("; "));
    assertEquals("[]", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]"));
    assertEquals("s+", ReportGridUtilities.sanitizeString(";\\s+"));
    assertEquals("name", ReportGridUtilities.sanitizeString(";Name"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(";java.util.List"));
    assertEquals("42", ReportGridUtilities.sanitizeString(";42"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(";java.util.Optional"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|", ReportGridUtilities.sanitizeString(";|"));
    assertEquals("|--", ReportGridUtilities.sanitizeString(";|--"));
    assertEquals("", ReportGridUtilities.sanitizeString(" ;"));
    assertEquals("", ReportGridUtilities.sanitizeString("  "));
    assertEquals("[]", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]"));
    assertEquals("s+", ReportGridUtilities.sanitizeString(" \\s+"));
    assertEquals("name", ReportGridUtilities.sanitizeString(" Name"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(" java.util.List"));
    assertEquals("42", ReportGridUtilities.sanitizeString(" 42"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(" java.util.Optional"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|", ReportGridUtilities.sanitizeString(" |"));
    assertEquals("|--", ReportGridUtilities.sanitizeString(" |--"));
    assertEquals("[]", ReportGridUtilities.sanitizeString("[:;*?!/\\\\];"));
    assertEquals("[]", ReportGridUtilities.sanitizeString("[:;*?!/\\\\] "));
    assertEquals("[][]", ReportGridUtilities.sanitizeString("[:;*?!/\\\\][:;*?!/\\\\]"));
    assertEquals("[]s+", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]\\s+"));
    assertEquals("[]name", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]Name"));
    assertEquals("[]java.util.list", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]java.util.List"));
    assertEquals("[]42", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]42"));
    assertEquals("[]java.util.optional", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]java.util.Optional"));
    assertEquals("[]org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("[]|", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]|"));
    assertEquals("[]|--", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]|--"));
    assertEquals("s+", ReportGridUtilities.sanitizeString("\\s+;"));
    assertEquals("s+", ReportGridUtilities.sanitizeString("\\s+ "));
    assertEquals("s+[]", ReportGridUtilities.sanitizeString("\\s+[:;*?!/\\\\]"));
    assertEquals("s+s+", ReportGridUtilities.sanitizeString("\\s+\\s+"));
    assertEquals("s+name", ReportGridUtilities.sanitizeString("\\s+Name"));
    assertEquals("s+java.util.list", ReportGridUtilities.sanitizeString("\\s+java.util.List"));
    assertEquals("s+42", ReportGridUtilities.sanitizeString("\\s+42"));
    assertEquals("s+java.util.optional", ReportGridUtilities.sanitizeString("\\s+java.util.Optional"));
    assertEquals("s+org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("\\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("s+|", ReportGridUtilities.sanitizeString("\\s+|"));
    assertEquals("s+|--", ReportGridUtilities.sanitizeString("\\s+|--"));
    assertEquals("name", ReportGridUtilities.sanitizeString("Name;"));
    assertEquals("name", ReportGridUtilities.sanitizeString("Name "));
    assertEquals("name[]", ReportGridUtilities.sanitizeString("Name[:;*?!/\\\\]"));
    assertEquals("names+", ReportGridUtilities.sanitizeString("Name\\s+"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString("java.util.List;"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString("java.util.List "));
    assertEquals("java.util.list[]", ReportGridUtilities.sanitizeString("java.util.List[:;*?!/\\\\]"));
    assertEquals("java.util.lists+", ReportGridUtilities.sanitizeString("java.util.List\\s+"));
    assertEquals("42", ReportGridUtilities.sanitizeString("42;"));
    assertEquals("42", ReportGridUtilities.sanitizeString("42 "));
    assertEquals("42[]", ReportGridUtilities.sanitizeString("42[:;*?!/\\\\]"));
    assertEquals("42s+", ReportGridUtilities.sanitizeString("42\\s+"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString("java.util.Optional;"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString("java.util.Optional "));
    assertEquals("java.util.optional[]", ReportGridUtilities.sanitizeString("java.util.Optional[:;*?!/\\\\]"));
    assertEquals("java.util.optionals+", ReportGridUtilities.sanitizeString("java.util.Optional\\s+"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("org.finos.waltz.service.report_grid.ReportGridUtilities;"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("org.finos.waltz.service.report_grid.ReportGridUtilities "));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities[]",
        ReportGridUtilities.sanitizeString("org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiess+",
        ReportGridUtilities.sanitizeString("org.finos.waltz.service.report_grid.ReportGridUtilities\\s+"));
    assertEquals("|", ReportGridUtilities.sanitizeString("|;"));
    assertEquals("|", ReportGridUtilities.sanitizeString("| "));
    assertEquals("|[]", ReportGridUtilities.sanitizeString("|[:;*?!/\\\\]"));
    assertEquals("|s+", ReportGridUtilities.sanitizeString("|\\s+"));
    assertEquals("|--", ReportGridUtilities.sanitizeString("|--;"));
    assertEquals("|--", ReportGridUtilities.sanitizeString("|-- "));
    assertEquals("|--[]", ReportGridUtilities.sanitizeString("|--[:;*?!/\\\\]"));
    assertEquals("|--s+", ReportGridUtilities.sanitizeString("|--\\s+"));
    assertEquals("", ReportGridUtilities.sanitizeString(";;;"));
    assertEquals("", ReportGridUtilities.sanitizeString(";; "));
    assertEquals("[]", ReportGridUtilities.sanitizeString(";;[:;*?!/\\\\]"));
    assertEquals("s+", ReportGridUtilities.sanitizeString(";;\\s+"));
    assertEquals("name", ReportGridUtilities.sanitizeString(";;Name"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(";;java.util.List"));
    assertEquals("42", ReportGridUtilities.sanitizeString(";;42"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(";;java.util.Optional"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";;org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|", ReportGridUtilities.sanitizeString(";;|"));
    assertEquals("|--", ReportGridUtilities.sanitizeString(";;|--"));
    assertEquals("", ReportGridUtilities.sanitizeString("; ;"));
    assertEquals("", ReportGridUtilities.sanitizeString(";  "));
    assertEquals("[]", ReportGridUtilities.sanitizeString("; [:;*?!/\\\\]"));
    assertEquals("s+", ReportGridUtilities.sanitizeString("; \\s+"));
    assertEquals("name", ReportGridUtilities.sanitizeString("; Name"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString("; java.util.List"));
    assertEquals("42", ReportGridUtilities.sanitizeString("; 42"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString("; java.util.Optional"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("; org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|", ReportGridUtilities.sanitizeString("; |"));
    assertEquals("|--", ReportGridUtilities.sanitizeString("; |--"));
    assertEquals("[]", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\];"));
    assertEquals("[]", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\] "));
    assertEquals("[][]", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\][:;*?!/\\\\]"));
    assertEquals("[]s+", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]\\s+"));
    assertEquals("[]name", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]Name"));
    assertEquals("[]java.util.list", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]java.util.List"));
    assertEquals("[]42", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]42"));
    assertEquals("[]java.util.optional", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]java.util.Optional"));
    assertEquals("[]org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("[]|", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]|"));
    assertEquals("[]|--", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]|--"));
    assertEquals("s+", ReportGridUtilities.sanitizeString(";\\s+;"));
    assertEquals("s+", ReportGridUtilities.sanitizeString(";\\s+ "));
    assertEquals("s+[]", ReportGridUtilities.sanitizeString(";\\s+[:;*?!/\\\\]"));
    assertEquals("s+s+", ReportGridUtilities.sanitizeString(";\\s+\\s+"));
    assertEquals("s+name", ReportGridUtilities.sanitizeString(";\\s+Name"));
    assertEquals("s+java.util.list", ReportGridUtilities.sanitizeString(";\\s+java.util.List"));
    assertEquals("s+42", ReportGridUtilities.sanitizeString(";\\s+42"));
    assertEquals("s+java.util.optional", ReportGridUtilities.sanitizeString(";\\s+java.util.Optional"));
    assertEquals("s+org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";\\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("s+|", ReportGridUtilities.sanitizeString(";\\s+|"));
    assertEquals("s+|--", ReportGridUtilities.sanitizeString(";\\s+|--"));
    assertEquals("name", ReportGridUtilities.sanitizeString(";Name;"));
    assertEquals("name", ReportGridUtilities.sanitizeString(";Name "));
    assertEquals("name[]", ReportGridUtilities.sanitizeString(";Name[:;*?!/\\\\]"));
    assertEquals("names+", ReportGridUtilities.sanitizeString(";Name\\s+"));
    assertEquals("namename", ReportGridUtilities.sanitizeString(";NameName"));
    assertEquals("namejava.util.list", ReportGridUtilities.sanitizeString(";Namejava.util.List"));
    assertEquals("name42", ReportGridUtilities.sanitizeString(";Name42"));
    assertEquals("namejava.util.optional", ReportGridUtilities.sanitizeString(";Namejava.util.Optional"));
    assertEquals("nameorg.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";Nameorg.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("name|", ReportGridUtilities.sanitizeString(";Name|"));
    assertEquals("name|--", ReportGridUtilities.sanitizeString(";Name|--"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(";java.util.List;"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(";java.util.List "));
    assertEquals("java.util.list[]", ReportGridUtilities.sanitizeString(";java.util.List[:;*?!/\\\\]"));
    assertEquals("java.util.lists+", ReportGridUtilities.sanitizeString(";java.util.List\\s+"));
    assertEquals("java.util.listname", ReportGridUtilities.sanitizeString(";java.util.ListName"));
    assertEquals("java.util.listjava.util.list", ReportGridUtilities.sanitizeString(";java.util.Listjava.util.List"));
    assertEquals("java.util.list42", ReportGridUtilities.sanitizeString(";java.util.List42"));
    assertEquals("java.util.listjava.util.optional",
        ReportGridUtilities.sanitizeString(";java.util.Listjava.util.Optional"));
    assertEquals("java.util.listorg.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";java.util.Listorg.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("java.util.list|", ReportGridUtilities.sanitizeString(";java.util.List|"));
    assertEquals("java.util.list|--", ReportGridUtilities.sanitizeString(";java.util.List|--"));
    assertEquals("42", ReportGridUtilities.sanitizeString(";42;"));
    assertEquals("42", ReportGridUtilities.sanitizeString(";42 "));
    assertEquals("42[]", ReportGridUtilities.sanitizeString(";42[:;*?!/\\\\]"));
    assertEquals("42s+", ReportGridUtilities.sanitizeString(";42\\s+"));
    assertEquals("42name", ReportGridUtilities.sanitizeString(";42Name"));
    assertEquals("42java.util.list", ReportGridUtilities.sanitizeString(";42java.util.List"));
    assertEquals("4242", ReportGridUtilities.sanitizeString(";4242"));
    assertEquals("42java.util.optional", ReportGridUtilities.sanitizeString(";42java.util.Optional"));
    assertEquals("42org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";42org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("42|", ReportGridUtilities.sanitizeString(";42|"));
    assertEquals("42|--", ReportGridUtilities.sanitizeString(";42|--"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(";java.util.Optional;"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(";java.util.Optional "));
    assertEquals("java.util.optional[]", ReportGridUtilities.sanitizeString(";java.util.Optional[:;*?!/\\\\]"));
    assertEquals("java.util.optionals+", ReportGridUtilities.sanitizeString(";java.util.Optional\\s+"));
    assertEquals("java.util.optionalname", ReportGridUtilities.sanitizeString(";java.util.OptionalName"));
    assertEquals("java.util.optionaljava.util.list",
        ReportGridUtilities.sanitizeString(";java.util.Optionaljava.util.List"));
    assertEquals("java.util.optional42", ReportGridUtilities.sanitizeString(";java.util.Optional42"));
    assertEquals("java.util.optionaljava.util.optional",
        ReportGridUtilities.sanitizeString(";java.util.Optionaljava.util.Optional"));
    assertEquals("java.util.optionalorg.finos.waltz.service.report_grid.reportgridutilities", ReportGridUtilities
        .sanitizeString(";java.util.Optionalorg.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("java.util.optional|", ReportGridUtilities.sanitizeString(";java.util.Optional|"));
    assertEquals("java.util.optional|--", ReportGridUtilities.sanitizeString(";java.util.Optional|--"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities;"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities "));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities[]",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiess+",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities\\s+"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiesname",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilitiesName"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiesjava.util.list",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilitiesjava.util.List"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities42",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities42"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiesjava.util.optional", ReportGridUtilities
        .sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilitiesjava.util.Optional"));
    assertEquals(
        "org.finos.waltz.service.report_grid.reportgridutilitiesorg.finos.waltz.service.report_grid.reportgri"
            + "dutilities",
        ReportGridUtilities.sanitizeString(
            ";org.finos.waltz.service.report_grid.ReportGridUtilitiesorg.finos.waltz.service.report_grid"
                + ".ReportGridUtilities"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities|",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities|"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities|--",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities|--"));
    assertEquals("|", ReportGridUtilities.sanitizeString(";|;"));
    assertEquals("|", ReportGridUtilities.sanitizeString(";| "));
    assertEquals("|[]", ReportGridUtilities.sanitizeString(";|[:;*?!/\\\\]"));
    assertEquals("|s+", ReportGridUtilities.sanitizeString(";|\\s+"));
    assertEquals("|name", ReportGridUtilities.sanitizeString(";|Name"));
    assertEquals("|java.util.list", ReportGridUtilities.sanitizeString(";|java.util.List"));
    assertEquals("|42", ReportGridUtilities.sanitizeString(";|42"));
    assertEquals("|java.util.optional", ReportGridUtilities.sanitizeString(";|java.util.Optional"));
    assertEquals("|org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";|org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("||", ReportGridUtilities.sanitizeString(";||"));
    assertEquals("||--", ReportGridUtilities.sanitizeString(";||--"));
    assertEquals("|--", ReportGridUtilities.sanitizeString(";|--;"));
    assertEquals("|--", ReportGridUtilities.sanitizeString(";|-- "));
    assertEquals("|--[]", ReportGridUtilities.sanitizeString(";|--[:;*?!/\\\\]"));
    assertEquals("|--s+", ReportGridUtilities.sanitizeString(";|--\\s+"));
    assertEquals("|--name", ReportGridUtilities.sanitizeString(";|--Name"));
    assertEquals("|--java.util.list", ReportGridUtilities.sanitizeString(";|--java.util.List"));
    assertEquals("|--42", ReportGridUtilities.sanitizeString(";|--42"));
    assertEquals("|--java.util.optional", ReportGridUtilities.sanitizeString(";|--java.util.Optional"));
    assertEquals("|--org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";|--org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|--|", ReportGridUtilities.sanitizeString(";|--|"));
    assertEquals("|--|--", ReportGridUtilities.sanitizeString(";|--|--"));
    assertEquals("", ReportGridUtilities.sanitizeString(" ;;"));
    assertEquals("", ReportGridUtilities.sanitizeString(" ; "));
    assertEquals("[]", ReportGridUtilities.sanitizeString(" ;[:;*?!/\\\\]"));
    assertEquals("s+", ReportGridUtilities.sanitizeString(" ;\\s+"));
    assertEquals("name", ReportGridUtilities.sanitizeString(" ;Name"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(" ;java.util.List"));
    assertEquals("42", ReportGridUtilities.sanitizeString(" ;42"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(" ;java.util.Optional"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" ;org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|", ReportGridUtilities.sanitizeString(" ;|"));
    assertEquals("|--", ReportGridUtilities.sanitizeString(" ;|--"));
    assertEquals("", ReportGridUtilities.sanitizeString("  ;"));
    assertEquals("", ReportGridUtilities.sanitizeString("   "));
    assertEquals("[]", ReportGridUtilities.sanitizeString("  [:;*?!/\\\\]"));
    assertEquals("s+", ReportGridUtilities.sanitizeString("  \\s+"));
    assertEquals("name", ReportGridUtilities.sanitizeString("  Name"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString("  java.util.List"));
    assertEquals("42", ReportGridUtilities.sanitizeString("  42"));
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString("  java.util.Optional"));
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("  org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|", ReportGridUtilities.sanitizeString("  |"));
    assertEquals("|--", ReportGridUtilities.sanitizeString("  |--"));
    assertEquals("[]", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\];"));
    assertEquals("[]", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\] "));
    assertEquals("[][]", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\][:;*?!/\\\\]"));
    assertEquals("[]s+", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]\\s+"));
    assertEquals("[]name", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]Name"));
    assertEquals("[]java.util.list", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]java.util.List"));
    assertEquals("[]42", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]42"));
    assertEquals("[]java.util.optional", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]java.util.Optional"));
    assertEquals("[]org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("[]|", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]|"));
    assertEquals("[]|--", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]|--"));
    assertEquals("s+", ReportGridUtilities.sanitizeString(" \\s+;"));
    assertEquals("s+", ReportGridUtilities.sanitizeString(" \\s+ "));
    assertEquals("s+[]", ReportGridUtilities.sanitizeString(" \\s+[:;*?!/\\\\]"));
    assertEquals("s+s+", ReportGridUtilities.sanitizeString(" \\s+\\s+"));
    assertEquals("s+name", ReportGridUtilities.sanitizeString(" \\s+Name"));
    assertEquals("s+java.util.list", ReportGridUtilities.sanitizeString(" \\s+java.util.List"));
    assertEquals("s+42", ReportGridUtilities.sanitizeString(" \\s+42"));
    assertEquals("s+java.util.optional", ReportGridUtilities.sanitizeString(" \\s+java.util.Optional"));
    assertEquals("s+org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" \\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("s+|", ReportGridUtilities.sanitizeString(" \\s+|"));
    assertEquals("s+|--", ReportGridUtilities.sanitizeString(" \\s+|--"));
    assertEquals("name", ReportGridUtilities.sanitizeString(" Name;"));
    assertEquals("name", ReportGridUtilities.sanitizeString(" Name "));
    assertEquals("name[]", ReportGridUtilities.sanitizeString(" Name[:;*?!/\\\\]"));
    assertEquals("names+", ReportGridUtilities.sanitizeString(" Name\\s+"));
    assertEquals("namename", ReportGridUtilities.sanitizeString(" NameName"));
    assertEquals("namejava.util.list", ReportGridUtilities.sanitizeString(" Namejava.util.List"));
    assertEquals("name42", ReportGridUtilities.sanitizeString(" Name42"));
    assertEquals("namejava.util.optional", ReportGridUtilities.sanitizeString(" Namejava.util.Optional"));
    assertEquals("nameorg.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" Nameorg.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("name|", ReportGridUtilities.sanitizeString(" Name|"));
    assertEquals("name|--", ReportGridUtilities.sanitizeString(" Name|--"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(" java.util.List;"));
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(" java.util.List "));
    assertEquals("java.util.list[]", ReportGridUtilities.sanitizeString(" java.util.List[:;*?!/\\\\]"));
  }

  /**
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  void testMkOptionCode() {
    // Arrange, Act and Assert
    assertEquals("NAME", ReportGridUtilities.mkOptionCode("Name"));
    assertEquals("", ReportGridUtilities.mkOptionCode(null));
    assertEquals("", ReportGridUtilities.mkOptionCode(";"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(" "));
    assertEquals("[]", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]"));
    assertEquals("S+", ReportGridUtilities.mkOptionCode("\\s+"));
    assertEquals("", ReportGridUtilities.mkOptionCode(";;"));
    assertEquals("_", ReportGridUtilities.mkOptionCode("; "));
    assertEquals("[]", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]"));
    assertEquals("S+", ReportGridUtilities.mkOptionCode(";\\s+"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(";_"));
    assertEquals("NAME", ReportGridUtilities.mkOptionCode(";Name"));
    assertEquals("JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";java.util.List"));
    assertEquals("42", ReportGridUtilities.mkOptionCode(";42"));
    assertEquals("JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";java.util.Optional"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|", ReportGridUtilities.mkOptionCode(";|"));
    assertEquals("|--", ReportGridUtilities.mkOptionCode(";|--"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(" ;"));
    assertEquals("_", ReportGridUtilities.mkOptionCode("  "));
    assertEquals("_[]", ReportGridUtilities.mkOptionCode(" [:;*?!/\\\\]"));
    assertEquals("_S+", ReportGridUtilities.mkOptionCode(" \\s+"));
    assertEquals("__", ReportGridUtilities.mkOptionCode(" _"));
    assertEquals("_NAME", ReportGridUtilities.mkOptionCode(" Name"));
    assertEquals("_JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(" java.util.List"));
    assertEquals("_42", ReportGridUtilities.mkOptionCode(" 42"));
    assertEquals("_JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(" java.util.Optional"));
    assertEquals("_ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(" org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("_|", ReportGridUtilities.mkOptionCode(" |"));
    assertEquals("_|--", ReportGridUtilities.mkOptionCode(" |--"));
    assertEquals("[]", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\];"));
    assertEquals("[]_", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\] "));
    assertEquals("[][]", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\][:;*?!/\\\\]"));
    assertEquals("[]S+", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]\\s+"));
    assertEquals("[]_", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]_"));
    assertEquals("[]NAME", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]Name"));
    assertEquals("[]JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]java.util.List"));
    assertEquals("[]42", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]42"));
    assertEquals("[]JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]java.util.Optional"));
    assertEquals("[]ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("[]|", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]|"));
    assertEquals("[]|--", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]|--"));
    assertEquals("S+", ReportGridUtilities.mkOptionCode("\\s+;"));
    assertEquals("S+_", ReportGridUtilities.mkOptionCode("\\s+ "));
    assertEquals("S+[]", ReportGridUtilities.mkOptionCode("\\s+[:;*?!/\\\\]"));
    assertEquals("S+S+", ReportGridUtilities.mkOptionCode("\\s+\\s+"));
    assertEquals("S+_", ReportGridUtilities.mkOptionCode("\\s+_"));
    assertEquals("S+NAME", ReportGridUtilities.mkOptionCode("\\s+Name"));
    assertEquals("S+JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode("\\s+java.util.List"));
    assertEquals("S+42", ReportGridUtilities.mkOptionCode("\\s+42"));
    assertEquals("S+JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode("\\s+java.util.Optional"));
    assertEquals("S+ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode("\\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("S+|", ReportGridUtilities.mkOptionCode("\\s+|"));
    assertEquals("S+|--", ReportGridUtilities.mkOptionCode("\\s+|--"));
    assertEquals("_", ReportGridUtilities.mkOptionCode("_;"));
    assertEquals("__", ReportGridUtilities.mkOptionCode("_ "));
    assertEquals("_[]", ReportGridUtilities.mkOptionCode("_[:;*?!/\\\\]"));
    assertEquals("_S+", ReportGridUtilities.mkOptionCode("_\\s+"));
    assertEquals("NAME", ReportGridUtilities.mkOptionCode("Name;"));
    assertEquals("NAME_", ReportGridUtilities.mkOptionCode("Name "));
    assertEquals("NAME[]", ReportGridUtilities.mkOptionCode("Name[:;*?!/\\\\]"));
    assertEquals("NAMES+", ReportGridUtilities.mkOptionCode("Name\\s+"));
    assertEquals("JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode("java.util.List;"));
    assertEquals("JAVA.UTIL.LIST_", ReportGridUtilities.mkOptionCode("java.util.List "));
    assertEquals("JAVA.UTIL.LIST[]", ReportGridUtilities.mkOptionCode("java.util.List[:;*?!/\\\\]"));
    assertEquals("JAVA.UTIL.LISTS+", ReportGridUtilities.mkOptionCode("java.util.List\\s+"));
    assertEquals("42", ReportGridUtilities.mkOptionCode("42;"));
    assertEquals("42_", ReportGridUtilities.mkOptionCode("42 "));
    assertEquals("42[]", ReportGridUtilities.mkOptionCode("42[:;*?!/\\\\]"));
    assertEquals("42S+", ReportGridUtilities.mkOptionCode("42\\s+"));
    assertEquals("JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode("java.util.Optional;"));
    assertEquals("JAVA.UTIL.OPTIONAL_", ReportGridUtilities.mkOptionCode("java.util.Optional "));
    assertEquals("JAVA.UTIL.OPTIONAL[]", ReportGridUtilities.mkOptionCode("java.util.Optional[:;*?!/\\\\]"));
    assertEquals("JAVA.UTIL.OPTIONALS+", ReportGridUtilities.mkOptionCode("java.util.Optional\\s+"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode("org.finos.waltz.service.report_grid.ReportGridUtilities;"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES_",
        ReportGridUtilities.mkOptionCode("org.finos.waltz.service.report_grid.ReportGridUtilities "));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES[]",
        ReportGridUtilities.mkOptionCode("org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESS+",
        ReportGridUtilities.mkOptionCode("org.finos.waltz.service.report_grid.ReportGridUtilities\\s+"));
    assertEquals("|", ReportGridUtilities.mkOptionCode("|;"));
    assertEquals("|_", ReportGridUtilities.mkOptionCode("| "));
    assertEquals("|[]", ReportGridUtilities.mkOptionCode("|[:;*?!/\\\\]"));
    assertEquals("|S+", ReportGridUtilities.mkOptionCode("|\\s+"));
    assertEquals("|--", ReportGridUtilities.mkOptionCode("|--;"));
    assertEquals("|--_", ReportGridUtilities.mkOptionCode("|-- "));
    assertEquals("|--[]", ReportGridUtilities.mkOptionCode("|--[:;*?!/\\\\]"));
    assertEquals("|--S+", ReportGridUtilities.mkOptionCode("|--\\s+"));
    assertEquals("", ReportGridUtilities.mkOptionCode(";;;"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(";; "));
    assertEquals("[]", ReportGridUtilities.mkOptionCode(";;[:;*?!/\\\\]"));
    assertEquals("S+", ReportGridUtilities.mkOptionCode(";;\\s+"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(";;_"));
    assertEquals("NAME", ReportGridUtilities.mkOptionCode(";;Name"));
    assertEquals("JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";;java.util.List"));
    assertEquals("42", ReportGridUtilities.mkOptionCode(";;42"));
    assertEquals("JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";;java.util.Optional"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";;org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|", ReportGridUtilities.mkOptionCode(";;|"));
    assertEquals("|--", ReportGridUtilities.mkOptionCode(";;|--"));
    assertEquals("_", ReportGridUtilities.mkOptionCode("; ;"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(";  "));
    assertEquals("_[]", ReportGridUtilities.mkOptionCode("; [:;*?!/\\\\]"));
    assertEquals("_S+", ReportGridUtilities.mkOptionCode("; \\s+"));
    assertEquals("__", ReportGridUtilities.mkOptionCode("; _"));
    assertEquals("_NAME", ReportGridUtilities.mkOptionCode("; Name"));
    assertEquals("_JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode("; java.util.List"));
    assertEquals("_42", ReportGridUtilities.mkOptionCode("; 42"));
    assertEquals("_JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode("; java.util.Optional"));
    assertEquals("_ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode("; org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("_|", ReportGridUtilities.mkOptionCode("; |"));
    assertEquals("_|--", ReportGridUtilities.mkOptionCode("; |--"));
    assertEquals("[]", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\];"));
    assertEquals("[]_", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\] "));
    assertEquals("[][]", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\][:;*?!/\\\\]"));
    assertEquals("[]S+", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]\\s+"));
    assertEquals("[]_", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]_"));
    assertEquals("[]NAME", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]Name"));
    assertEquals("[]JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]java.util.List"));
    assertEquals("[]42", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]42"));
    assertEquals("[]JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]java.util.Optional"));
    assertEquals("[]ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("[]|", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]|"));
    assertEquals("[]|--", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]|--"));
    assertEquals("S+", ReportGridUtilities.mkOptionCode(";\\s+;"));
    assertEquals("S+_", ReportGridUtilities.mkOptionCode(";\\s+ "));
    assertEquals("S+[]", ReportGridUtilities.mkOptionCode(";\\s+[:;*?!/\\\\]"));
    assertEquals("S+S+", ReportGridUtilities.mkOptionCode(";\\s+\\s+"));
    assertEquals("S+_", ReportGridUtilities.mkOptionCode(";\\s+_"));
    assertEquals("S+NAME", ReportGridUtilities.mkOptionCode(";\\s+Name"));
    assertEquals("S+JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";\\s+java.util.List"));
    assertEquals("S+42", ReportGridUtilities.mkOptionCode(";\\s+42"));
    assertEquals("S+JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";\\s+java.util.Optional"));
    assertEquals("S+ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";\\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("S+|", ReportGridUtilities.mkOptionCode(";\\s+|"));
    assertEquals("S+|--", ReportGridUtilities.mkOptionCode(";\\s+|--"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(";_;"));
    assertEquals("__", ReportGridUtilities.mkOptionCode(";_ "));
    assertEquals("_[]", ReportGridUtilities.mkOptionCode(";_[:;*?!/\\\\]"));
    assertEquals("_S+", ReportGridUtilities.mkOptionCode(";_\\s+"));
    assertEquals("__", ReportGridUtilities.mkOptionCode(";__"));
    assertEquals("_NAME", ReportGridUtilities.mkOptionCode(";_Name"));
    assertEquals("_JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";_java.util.List"));
    assertEquals("_42", ReportGridUtilities.mkOptionCode(";_42"));
    assertEquals("_JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";_java.util.Optional"));
    assertEquals("_ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";_org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("_|", ReportGridUtilities.mkOptionCode(";_|"));
    assertEquals("_|--", ReportGridUtilities.mkOptionCode(";_|--"));
    assertEquals("NAME", ReportGridUtilities.mkOptionCode(";Name;"));
    assertEquals("NAME_", ReportGridUtilities.mkOptionCode(";Name "));
    assertEquals("NAME[]", ReportGridUtilities.mkOptionCode(";Name[:;*?!/\\\\]"));
    assertEquals("NAMES+", ReportGridUtilities.mkOptionCode(";Name\\s+"));
    assertEquals("NAME_", ReportGridUtilities.mkOptionCode(";Name_"));
    assertEquals("NAMENAME", ReportGridUtilities.mkOptionCode(";NameName"));
    assertEquals("NAMEJAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";Namejava.util.List"));
    assertEquals("NAME42", ReportGridUtilities.mkOptionCode(";Name42"));
    assertEquals("NAMEJAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";Namejava.util.Optional"));
    assertEquals("NAMEORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";Nameorg.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("NAME|", ReportGridUtilities.mkOptionCode(";Name|"));
    assertEquals("NAME|--", ReportGridUtilities.mkOptionCode(";Name|--"));
    assertEquals("JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";java.util.List;"));
    assertEquals("JAVA.UTIL.LIST_", ReportGridUtilities.mkOptionCode(";java.util.List "));
    assertEquals("JAVA.UTIL.LIST[]", ReportGridUtilities.mkOptionCode(";java.util.List[:;*?!/\\\\]"));
    assertEquals("JAVA.UTIL.LISTS+", ReportGridUtilities.mkOptionCode(";java.util.List\\s+"));
    assertEquals("JAVA.UTIL.LIST_", ReportGridUtilities.mkOptionCode(";java.util.List_"));
    assertEquals("JAVA.UTIL.LISTNAME", ReportGridUtilities.mkOptionCode(";java.util.ListName"));
    assertEquals("JAVA.UTIL.LISTJAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";java.util.Listjava.util.List"));
    assertEquals("JAVA.UTIL.LIST42", ReportGridUtilities.mkOptionCode(";java.util.List42"));
    assertEquals("JAVA.UTIL.LISTJAVA.UTIL.OPTIONAL",
        ReportGridUtilities.mkOptionCode(";java.util.Listjava.util.Optional"));
    assertEquals("JAVA.UTIL.LISTORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";java.util.Listorg.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("JAVA.UTIL.LIST|", ReportGridUtilities.mkOptionCode(";java.util.List|"));
    assertEquals("JAVA.UTIL.LIST|--", ReportGridUtilities.mkOptionCode(";java.util.List|--"));
    assertEquals("42", ReportGridUtilities.mkOptionCode(";42;"));
    assertEquals("42_", ReportGridUtilities.mkOptionCode(";42 "));
    assertEquals("42[]", ReportGridUtilities.mkOptionCode(";42[:;*?!/\\\\]"));
    assertEquals("42S+", ReportGridUtilities.mkOptionCode(";42\\s+"));
    assertEquals("42_", ReportGridUtilities.mkOptionCode(";42_"));
    assertEquals("42NAME", ReportGridUtilities.mkOptionCode(";42Name"));
    assertEquals("42JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";42java.util.List"));
    assertEquals("4242", ReportGridUtilities.mkOptionCode(";4242"));
    assertEquals("42JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";42java.util.Optional"));
    assertEquals("42ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";42org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("42|", ReportGridUtilities.mkOptionCode(";42|"));
    assertEquals("42|--", ReportGridUtilities.mkOptionCode(";42|--"));
    assertEquals("JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";java.util.Optional;"));
    assertEquals("JAVA.UTIL.OPTIONAL_", ReportGridUtilities.mkOptionCode(";java.util.Optional "));
    assertEquals("JAVA.UTIL.OPTIONAL[]", ReportGridUtilities.mkOptionCode(";java.util.Optional[:;*?!/\\\\]"));
    assertEquals("JAVA.UTIL.OPTIONALS+", ReportGridUtilities.mkOptionCode(";java.util.Optional\\s+"));
    assertEquals("JAVA.UTIL.OPTIONAL_", ReportGridUtilities.mkOptionCode(";java.util.Optional_"));
    assertEquals("JAVA.UTIL.OPTIONALNAME", ReportGridUtilities.mkOptionCode(";java.util.OptionalName"));
    assertEquals("JAVA.UTIL.OPTIONALJAVA.UTIL.LIST",
        ReportGridUtilities.mkOptionCode(";java.util.Optionaljava.util.List"));
    assertEquals("JAVA.UTIL.OPTIONAL42", ReportGridUtilities.mkOptionCode(";java.util.Optional42"));
    assertEquals("JAVA.UTIL.OPTIONALJAVA.UTIL.OPTIONAL",
        ReportGridUtilities.mkOptionCode(";java.util.Optionaljava.util.Optional"));
    assertEquals("JAVA.UTIL.OPTIONALORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";java.util.Optionalorg.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("JAVA.UTIL.OPTIONAL|", ReportGridUtilities.mkOptionCode(";java.util.Optional|"));
    assertEquals("JAVA.UTIL.OPTIONAL|--", ReportGridUtilities.mkOptionCode(";java.util.Optional|--"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities;"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES_",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities "));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES[]",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESS+",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities\\s+"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES_",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities_"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESNAME",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilitiesName"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESJAVA.UTIL.LIST",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilitiesjava.util.List"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES42",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities42"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESJAVA.UTIL.OPTIONAL",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilitiesjava.util.Optional"));
    assertEquals(
        "ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRI"
            + "DUTILITIES",
        ReportGridUtilities
            .mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilitiesorg.finos.waltz.service.report_grid"
                + ".ReportGridUtilities"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES|",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities|"));
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES|--",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities|--"));
    assertEquals("|", ReportGridUtilities.mkOptionCode(";|;"));
    assertEquals("|_", ReportGridUtilities.mkOptionCode(";| "));
    assertEquals("|[]", ReportGridUtilities.mkOptionCode(";|[:;*?!/\\\\]"));
    assertEquals("|S+", ReportGridUtilities.mkOptionCode(";|\\s+"));
    assertEquals("|_", ReportGridUtilities.mkOptionCode(";|_"));
    assertEquals("|NAME", ReportGridUtilities.mkOptionCode(";|Name"));
    assertEquals("|JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";|java.util.List"));
    assertEquals("|42", ReportGridUtilities.mkOptionCode(";|42"));
    assertEquals("|JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";|java.util.Optional"));
    assertEquals("|ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";|org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("||", ReportGridUtilities.mkOptionCode(";||"));
    assertEquals("||--", ReportGridUtilities.mkOptionCode(";||--"));
    assertEquals("|--", ReportGridUtilities.mkOptionCode(";|--;"));
    assertEquals("|--_", ReportGridUtilities.mkOptionCode(";|-- "));
    assertEquals("|--[]", ReportGridUtilities.mkOptionCode(";|--[:;*?!/\\\\]"));
    assertEquals("|--S+", ReportGridUtilities.mkOptionCode(";|--\\s+"));
    assertEquals("|--_", ReportGridUtilities.mkOptionCode(";|--_"));
    assertEquals("|--NAME", ReportGridUtilities.mkOptionCode(";|--Name"));
    assertEquals("|--JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";|--java.util.List"));
    assertEquals("|--42", ReportGridUtilities.mkOptionCode(";|--42"));
    assertEquals("|--JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";|--java.util.Optional"));
    assertEquals("|--ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";|--org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("|--|", ReportGridUtilities.mkOptionCode(";|--|"));
    assertEquals("|--|--", ReportGridUtilities.mkOptionCode(";|--|--"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(" ;;"));
    assertEquals("_", ReportGridUtilities.mkOptionCode(" ; "));
    assertEquals("_[]", ReportGridUtilities.mkOptionCode(" ;[:;*?!/\\\\]"));
    assertEquals("_S+", ReportGridUtilities.mkOptionCode(" ;\\s+"));
    assertEquals("__", ReportGridUtilities.mkOptionCode(" ;_"));
    assertEquals("_NAME", ReportGridUtilities.mkOptionCode(" ;Name"));
    assertEquals("_JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(" ;java.util.List"));
    assertEquals("_42", ReportGridUtilities.mkOptionCode(" ;42"));
    assertEquals("_JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(" ;java.util.Optional"));
    assertEquals("_ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(" ;org.finos.waltz.service.report_grid.ReportGridUtilities"));
    assertEquals("_|", ReportGridUtilities.mkOptionCode(" ;|"));
    assertEquals("_|--", ReportGridUtilities.mkOptionCode(" ;|--"));
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#modifySelectionOptionsForGrid(IdSelectionOptions)}
   */
  @Test
  void testModifySelectionOptionsForGrid() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    ReportGridUtilities.modifySelectionOptionsForGrid(idSelectionOptions);

    // Assert
    verify(entityReference).kind();
    verify(idSelectionOptions).entityReference();
  }

  /**
   * Method under test:
   * {@link ReportGridUtilities#modifySelectionOptionsForGrid(IdSelectionOptions)}
   */
  @Test
  void testModifySelectionOptionsForGrid2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new IllegalStateException("foo"));
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.modifySelectionOptionsForGrid(idSelectionOptions));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityReference();
  }
}
