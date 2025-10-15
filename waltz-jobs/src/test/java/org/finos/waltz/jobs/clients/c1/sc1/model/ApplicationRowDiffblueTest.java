package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.streaming.DeferredSXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApplicationRowDiffblueTest {
  /**
   * Test {@link ApplicationRow#fromRow(Row)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableApplicationRow}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationRow#fromRow(Row)}
   */
  @Test
  @DisplayName("Test fromRow(Row); then return ImmutableApplicationRow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApplicationRow ApplicationRow.fromRow(Row)"})
  void testFromRow_thenReturnImmutableApplicationRow() {
    // Arrange
    SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
    sxssfWorkbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);

    DeferredSXSSFSheet sheet = mock(DeferredSXSSFSheet.class);
    when(sheet.getWorkbook()).thenReturn(sxssfWorkbook);
    SXSSFRow row = new SXSSFRow(sheet);

    // Act
    ApplicationRow actualFromRowResult = ApplicationRow.fromRow(row);

    // Assert
    verify(sheet, atLeast(1)).getWorkbook();
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
