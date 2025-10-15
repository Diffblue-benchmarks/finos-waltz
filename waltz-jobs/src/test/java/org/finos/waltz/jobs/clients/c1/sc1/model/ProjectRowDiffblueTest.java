package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class ProjectRowDiffblueTest {
  /**
   * Test {@link ProjectRow#fromRow(Row)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableProjectRow}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectRow#fromRow(Row)}
   */
  @Test
  @DisplayName("Test fromRow(Row); then return ImmutableProjectRow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProjectRow ProjectRow.fromRow(Row)"})
  void testFromRow_thenReturnImmutableProjectRow() {
    // Arrange
    SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
    sxssfWorkbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);

    DeferredSXSSFSheet sheet = mock(DeferredSXSSFSheet.class);
    when(sheet.getWorkbook()).thenReturn(sxssfWorkbook);
    SXSSFRow row = new SXSSFRow(sheet);

    // Act
    ProjectRow actualFromRowResult = ProjectRow.fromRow(row);

    // Assert
    verify(sheet, atLeast(1)).getWorkbook();
    assertTrue(actualFromRowResult instanceof ImmutableProjectRow);
    assertEquals("", actualFromRowResult.applicationId());
    assertEquals("", actualFromRowResult.applicationName());
    assertEquals("", actualFromRowResult.projectName());
    assertEquals("", actualFromRowResult.projectObjectId());
    assertNull(actualFromRowResult.endDate());
    assertNull(actualFromRowResult.startDate());
    assertEquals((short) 0, row.getFirstCellNum());
    assertEquals(7, row.getPhysicalNumberOfCells());
    assertEquals((short) 9, row.getLastCellNum());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromRowResult.lifecyclePhase());
  }
}
