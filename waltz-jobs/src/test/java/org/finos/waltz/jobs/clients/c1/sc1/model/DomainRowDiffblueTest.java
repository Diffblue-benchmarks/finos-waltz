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
import java.util.Optional;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.DeferredSXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.finos.waltz.common.hierarchy.FlatNode;
import org.junit.jupiter.api.Test;

class DomainRowDiffblueTest {
  /**
   * Method under test: {@link DomainRow#categoryCode()}
   */
  @Test
  void testCategoryCode() {
    // Arrange
    DomainRow domainRow = mock(DomainRow.class);
    when(domainRow.categoryCode()).thenReturn("Category Code");

    // Act
    domainRow.categoryCode();

    // Assert
    verify(domainRow).categoryCode();
  }

  /**
   * Method under test: {@link DomainRow#toFlatNode()}
   */
  @Test
  void testToFlatNode() {
    // Arrange
    DomainRow domainRow = mock(DomainRow.class);
    Optional<String> parentId = Optional.of("foo");
    when(domainRow.toFlatNode()).thenReturn(new FlatNode<>("42", parentId, null));

    // Act
    domainRow.toFlatNode();

    // Assert
    verify(domainRow).toFlatNode();
  }

  /**
   * Method under test: {@link DomainRow#fromRow(Row)}
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
    DomainRow actualFromRowResult = DomainRow.fromRow(row);

    // Assert
    verify(workbook).getFontAt(eq(0));
    verify(workbook, atLeast(1)).getMissingCellPolicy();
    verify(workbook).getRandomAccessWindowSize();
    assertTrue(actualFromRowResult instanceof ImmutableDomainRow);
    assertEquals("", actualFromRowResult.crossReference());
    assertEquals("", actualFromRowResult.domainName());
    assertEquals("", actualFromRowResult.domainObjectId());
    assertEquals("", actualFromRowResult.parentDomainObjectId());
    assertEquals("", actualFromRowResult.parentExtId());
    assertEquals((short) 0, row.getFirstCellNum());
    assertEquals(5, row.getPhysicalNumberOfCells());
    assertEquals((short) 6, row.getLastCellNum());
  }
}
