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

class BusinessSupportRowDiffblueTest {
  /**
   * Test {@link BusinessSupportRow#fromRow(Row)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableBusinessSupportRow}.
   * </ul>
   *
   * <p>Method under test: {@link BusinessSupportRow#fromRow(Row)}
   */
  @Test
  @DisplayName("Test fromRow(Row); then return ImmutableBusinessSupportRow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BusinessSupportRow BusinessSupportRow.fromRow(Row)"})
  void testFromRow_thenReturnImmutableBusinessSupportRow() {
    // Arrange
    SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
    sxssfWorkbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);

    DeferredSXSSFSheet sheet = mock(DeferredSXSSFSheet.class);
    when(sheet.getWorkbook()).thenReturn(sxssfWorkbook);
    SXSSFRow r = new SXSSFRow(sheet);

    // Act
    BusinessSupportRow actualFromRowResult = BusinessSupportRow.fromRow(r);

    // Assert
    verify(sheet, atLeast(1)).getWorkbook();
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
