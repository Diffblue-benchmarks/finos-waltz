package org.finos.waltz.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.DeferredSXSSFSheet;
import org.apache.poi.xssf.streaming.DeferredSXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class XlsUtilitiesDiffblueTest {
  /**
   * Test {@link XlsUtilities#mapStrCell(Row, int, Function)}.
   *
   * <p>Method under test: {@link XlsUtilities#mapStrCell(Row, int, Function)}
   */
  @Test
  @DisplayName("Test mapStrCell(Row, int, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object XlsUtilities.mapStrCell(Row, int, Function)"})
  void testMapStrCell() {
    // Arrange
    SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
    sxssfWorkbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);

    DeferredSXSSFSheet sheet = mock(DeferredSXSSFSheet.class);
    when(sheet.getWorkbook()).thenReturn(sxssfWorkbook);
    SXSSFRow row = new SXSSFRow(sheet);

    Function<String, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    Object actualMapStrCellResult = XlsUtilities.mapStrCell(row, 1, mapper);

    // Assert
    verify(mapper).apply("");
    verify(sheet).getWorkbook();
    assertEquals("Apply", actualMapStrCellResult);
    assertEquals(1, row.getPhysicalNumberOfCells());
    assertEquals((short) 1, row.getFirstCellNum());
    assertEquals((short) 2, row.getLastCellNum());
  }

  /**
   * Test {@link XlsUtilities#mapStrCell(Row, int, Function)}.
   *
   * <ul>
   *   <li>Then {@link SXSSFRow#SXSSFRow(SXSSFSheet)} with sheet is {@link DeferredSXSSFSheet}
   *       FirstCellNum is minus one.
   * </ul>
   *
   * <p>Method under test: {@link XlsUtilities#mapStrCell(Row, int, Function)}
   */
  @Test
  @DisplayName(
      "Test mapStrCell(Row, int, Function); then SXSSFRow(SXSSFSheet) with sheet is DeferredSXSSFSheet FirstCellNum is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object XlsUtilities.mapStrCell(Row, int, Function)"})
  void testMapStrCell_thenSXSSFRowWithSheetIsDeferredSXSSFSheetFirstCellNumIsMinusOne() {
    // Arrange
    DeferredSXSSFSheet sheet = mock(DeferredSXSSFSheet.class);
    when(sheet.getWorkbook()).thenReturn(new SXSSFWorkbook());
    SXSSFRow row = new SXSSFRow(sheet);

    Function<String, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    Object actualMapStrCellResult = XlsUtilities.mapStrCell(row, 1, mapper);

    // Assert
    verify(mapper).apply(null);
    verify(sheet).getWorkbook();
    assertEquals("Apply", actualMapStrCellResult);
    assertEquals((short) -1, row.getFirstCellNum());
    assertEquals((short) -1, row.getLastCellNum());
    assertEquals(0, row.getPhysicalNumberOfCells());
  }

  /**
   * Test {@link XlsUtilities#strVal(Row, int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XlsUtilities#strVal(Row, int)}
   */
  @Test
  @DisplayName("Test strVal(Row, int); given ArrayList() iterator; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XlsUtilities.strVal(Row, int)"})
  void testStrVal_givenArrayListIterator_thenReturnNull() throws IOException {
    // Arrange
    XSSFSheet xSheet = mock(XSSFSheet.class);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());
    DeferredSXSSFSheet sheet = new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet);

    // Act
    String actualStrValResult = XlsUtilities.strVal(new SXSSFRow(sheet), 2);

    // Assert
    verify(xSheet).iterator();
    assertNull(actualStrValResult);
  }

  /**
   * Test {@link XlsUtilities#streamRows(Sheet)} with {@code sheet}.
   *
   * <ul>
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link XlsUtilities#streamRows(Sheet)}
   */
  @Test
  @DisplayName("Test streamRows(Sheet) with 'sheet'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream XlsUtilities.streamRows(Sheet)"})
  void testStreamRowsWithSheet_thenReturnLimitFiveCollectToListEmpty() throws IOException {
    // Arrange
    XSSFSheet xSheet = mock(XSSFSheet.class);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());
    DeferredSXSSFSheet sheet = new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet);

    // Act
    Stream<Row> actualStreamRowsResult = XlsUtilities.streamRows(sheet);

    // Assert
    verify(xSheet).iterator();
    assertTrue(actualStreamRowsResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link XlsUtilities#streamRows(Workbook, SheetNumProvider)} with {@code workbook}, {@code
   * sheetDefinition}.
   *
   * <ul>
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link XlsUtilities#streamRows(Workbook, SheetNumProvider)}
   */
  @Test
  @DisplayName(
      "Test streamRows(Workbook, SheetNumProvider) with 'workbook', 'sheetDefinition'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream XlsUtilities.streamRows(Workbook, SheetNumProvider)"})
  void testStreamRowsWithWorkbookSheetDefinition_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    HSSFWorkbook workbook = new HSSFWorkbook();
    workbook.createSheet("Sheetname");

    SheetNumProvider sheetDefinition = mock(SheetNumProvider.class);
    when(sheetDefinition.sheetNum()).thenReturn(0);

    // Act
    Stream<Row> actualStreamRowsResult = XlsUtilities.streamRows(workbook, sheetDefinition);

    // Assert
    verify(sheetDefinition).sheetNum();
    assertTrue(actualStreamRowsResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
