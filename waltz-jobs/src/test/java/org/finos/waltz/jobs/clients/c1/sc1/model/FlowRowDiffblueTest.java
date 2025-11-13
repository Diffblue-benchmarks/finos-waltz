package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowRowDiffblueTest {
  /**
   * Test {@link FlowRow#fromRow(Row)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableFlowRow}.
   * </ul>
   *
   * <p>Method under test: {@link FlowRow#fromRow(Row)}
   */
  @Test
  @DisplayName("Test fromRow(Row); then return ImmutableFlowRow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowRow FlowRow.fromRow(Row)"})
  void testFromRow_thenReturnImmutableFlowRow() {
    // Arrange
    SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
    sxssfWorkbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);

    DeferredSXSSFSheet sheet = mock(DeferredSXSSFSheet.class);
    when(sheet.getWorkbook()).thenReturn(sxssfWorkbook);
    SXSSFRow row = new SXSSFRow(sheet);

    // Act
    FlowRow actualFromRowResult = FlowRow.fromRow(row);

    // Assert
    verify(sheet, atLeast(1)).getWorkbook();
    assertTrue(actualFromRowResult instanceof ImmutableFlowRow);
    assertEquals("", actualFromRowResult.endDate());
    assertEquals("", actualFromRowResult.sourceAppName());
    assertEquals("", actualFromRowResult.startDate());
    assertEquals("", actualFromRowResult.targetAppName());
    assertEquals((short) 0, row.getFirstCellNum());
    assertEquals((short) 13, row.getLastCellNum());
    assertEquals(5, row.getPhysicalNumberOfCells());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromRowResult.status());
  }
}
