package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.DeferredSXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class ApplicationRowDiffblueTest {
  /**
   * Method under test: {@link ApplicationRow#fromRow(Row)}
   */
  @Test
  void testFromRow() throws IOException {
    // Arrange
    DeferredSXSSFWorkbook workbook = mock(DeferredSXSSFWorkbook.class);
    when(workbook.getMissingCellPolicy()).thenReturn(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
    when(workbook.getFontAt(anyInt())).thenReturn(new XSSFFont());
    when(workbook.getRandomAccessWindowSize()).thenReturn(3);
    SXSSFRow row = new SXSSFRow(new SXSSFSheet(workbook, null));

    // Act
    ApplicationRow actualFromRowResult = ApplicationRow.fromRow(row);

    // Assert
    verify(workbook).getFontAt(eq(0));
    verify(workbook, atLeast(1)).getMissingCellPolicy();
    verify(workbook).getRandomAccessWindowSize();
    assertTrue(actualFromRowResult instanceof ImmutableApplicationRow);
    assertEquals("", actualFromRowResult.externalId());
    assertEquals("", actualFromRowResult.internalId());
    assertEquals("", actualFromRowResult.name());
    assertEquals("", actualFromRowResult.version());
    assertNull(actualFromRowResult.endDate());
    assertNull(actualFromRowResult.startDate());
    assertEquals((short) 0, row.getFirstCellNum());
    assertEquals(6, row.getPhysicalNumberOfCells());
    assertEquals((short) 6, row.getLastCellNum());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromRowResult.lifecyclePhase());
    assertFalse(actualFromRowResult.businessCritical());
  }
}
