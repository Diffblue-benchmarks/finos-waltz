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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ComponentRowDiffblueTest {
  /**
   * Test {@link ComponentRow#fromRow(Row)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableComponentRow}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentRow#fromRow(Row)}
   */
  @Test
  @DisplayName("Test fromRow(Row); then return ImmutableComponentRow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComponentRow ComponentRow.fromRow(Row)"})
  void testFromRow_thenReturnImmutableComponentRow() {
    // Arrange
    SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
    sxssfWorkbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);

    DeferredSXSSFSheet sheet = mock(DeferredSXSSFSheet.class);
    when(sheet.getWorkbook()).thenReturn(sxssfWorkbook);
    SXSSFRow row = new SXSSFRow(sheet);

    // Act
    ComponentRow actualFromRowResult = ComponentRow.fromRow(row);

    // Assert
    verify(sheet, atLeast(1)).getWorkbook();
    assertTrue(actualFromRowResult instanceof ImmutableComponentRow);
    assertEquals("", actualFromRowResult.category());
    assertEquals("", actualFromRowResult.endDate());
    assertEquals("", actualFromRowResult.internalId());
    assertEquals("", actualFromRowResult.layer());
    assertEquals("", actualFromRowResult.name());
    assertEquals("", actualFromRowResult.owner());
    assertEquals("", actualFromRowResult.reviewDate());
    assertEquals("", actualFromRowResult.tier());
    assertEquals("", actualFromRowResult.version());
    assertEquals(10, row.getPhysicalNumberOfCells());
    assertEquals((short) 15, row.getLastCellNum());
    assertEquals((short) 5, row.getFirstCellNum());
    assertEquals(MaintenanceStatus.SELF, actualFromRowResult.maintenanceStatus());
  }
}
