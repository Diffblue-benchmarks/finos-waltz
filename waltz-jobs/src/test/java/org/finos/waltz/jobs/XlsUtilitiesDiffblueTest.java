package org.finos.waltz.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.DeferredSXSSFSheet;
import org.apache.poi.xssf.streaming.DeferredSXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class XlsUtilitiesDiffblueTest {
  /**
   * Method under test: {@link XlsUtilities#mapStrCell(Row, int, Function)}
   */
  @Test
  void testMapStrCell() throws IOException {
    // Arrange
    XSSFSheet xSheet = mock(XSSFSheet.class);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());
    SXSSFRow row = new SXSSFRow(new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet));
    Function<String, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    Object actualMapStrCellResult = XlsUtilities.mapStrCell(row, 1, mapper);

    // Assert
    verify(mapper).apply(isNull());
    verify(xSheet).iterator();
    assertEquals("Apply", actualMapStrCellResult);
  }

  /**
   * Method under test: {@link XlsUtilities#strVal(Row, int)}
   */
  @Test
  void testStrVal() throws IOException {
    // Arrange
    XSSFSheet xSheet = mock(XSSFSheet.class);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());

    // Act
    String actualStrValResult = XlsUtilities
        .strVal(new SXSSFRow(new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet)), 2);

    // Assert
    verify(xSheet).iterator();
    assertNull(actualStrValResult);
  }

  /**
   * Method under test: {@link XlsUtilities#streamRows(Sheet)}
   */
  @Test
  void testStreamRows() throws IOException {
    // Arrange
    XSSFSheet xSheet = mock(XSSFSheet.class);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());

    // Act
    Stream<Row> actualStreamRowsResult = XlsUtilities
        .streamRows(new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet));

    // Assert
    verify(xSheet).iterator();
    assertTrue(actualStreamRowsResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
