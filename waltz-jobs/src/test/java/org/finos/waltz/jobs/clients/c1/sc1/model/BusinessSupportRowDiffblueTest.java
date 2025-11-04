package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.Test;

class BusinessSupportRowDiffblueTest {
  /**
   * Method under test: {@link BusinessSupportRow#fromRow(Row)}
   */
  @Test
  void testFromRow() throws IOException {
    // Arrange
    DeferredSXSSFWorkbook workbook = mock(DeferredSXSSFWorkbook.class);
    when(workbook.getMissingCellPolicy()).thenReturn(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
    when(workbook.getFontAt(anyInt())).thenReturn(new XSSFFont());
    when(workbook.getRandomAccessWindowSize()).thenReturn(3);
    SXSSFRow r = new SXSSFRow(new SXSSFSheet(workbook, null));

    // Act
    BusinessSupportRow actualFromRowResult = BusinessSupportRow.fromRow(r);

    // Assert
    verify(workbook).getFontAt(eq(0));
    verify(workbook, atLeast(1)).getMissingCellPolicy();
    verify(workbook).getRandomAccessWindowSize();
    assertTrue(actualFromRowResult instanceof ImmutableBusinessSupportRow);
    assertEquals("", actualFromRowResult.applicationId());
    assertEquals("", actualFromRowResult.applicationName());
    assertEquals("", actualFromRowResult.domainObjectId());
    assertEquals("", actualFromRowResult.domainObjectName());
    assertEquals("", actualFromRowResult.endDate());
    assertEquals("", actualFromRowResult.internalId());
    assertEquals("", actualFromRowResult.orgObjectId());
    assertEquals("", actualFromRowResult.orgObjectName());
    assertEquals("", actualFromRowResult.startDate());
    assertEquals((short) 0, r.getFirstCellNum());
    assertEquals(10, r.getPhysicalNumberOfCells());
    assertEquals((short) 10, r.getLastCellNum());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromRowResult.status());
  }
}
