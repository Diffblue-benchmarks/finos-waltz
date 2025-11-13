package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.streaming.DeferredSXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.finos.waltz.common.hierarchy.FlatNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DomainRowDiffblueTest {
  /**
   * Test {@link DomainRow#categoryCode()}.
   *
   * <p>Method under test: {@link DomainRow#categoryCode()}
   */
  @Test
  @DisplayName("Test categoryCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DomainRow.categoryCode()"})
  void testCategoryCode() {
    // Arrange, Act and Assert
    assertNull(
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build()
            .categoryCode());
  }

  /**
   * Test {@link DomainRow#categoryCode()}.
   *
   * <p>Method under test: {@link DomainRow#categoryCode()}
   */
  @Test
  @DisplayName("Test categoryCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DomainRow.categoryCode()"})
  void testCategoryCode2() {
    // Arrange, Act and Assert
    assertNull(
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId(null)
            .build()
            .categoryCode());
  }

  /**
   * Test {@link DomainRow#categoryCode()}.
   *
   * <ul>
   *   <li>Then return {@code K}.
   * </ul>
   *
   * <p>Method under test: {@link DomainRow#categoryCode()}
   */
  @Test
  @DisplayName("Test categoryCode(); then return 'K'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DomainRow.categoryCode()"})
  void testCategoryCode_thenReturnK() {
    // Arrange, Act and Assert
    assertEquals(
        "K",
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("K")
            .build()
            .categoryCode());
  }

  /**
   * Test {@link DomainRow#categoryCode()}.
   *
   * <ul>
   *   <li>Then return {@code Par}.
   * </ul>
   *
   * <p>Method under test: {@link DomainRow#categoryCode()}
   */
  @Test
  @DisplayName("Test categoryCode(); then return 'Par'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DomainRow.categoryCode()"})
  void testCategoryCode_thenReturnPar() {
    // Arrange, Act and Assert
    assertEquals(
        "Par",
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("Parent Ext Id")
            .build()
            .categoryCode());
  }

  /**
   * Test {@link DomainRow#toFlatNode()}.
   *
   * <p>Method under test: {@link DomainRow#toFlatNode()}
   */
  @Test
  @DisplayName("Test toFlatNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlatNode DomainRow.toFlatNode()"})
  void testToFlatNode() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("")
            .parentExtId("42")
            .build();

    // Act
    FlatNode<DomainRow, String> actualToFlatNodeResult = immutableDomainRow.toFlatNode();

    // Assert
    assertEquals("42", actualToFlatNodeResult.getId());
    assertFalse(actualToFlatNodeResult.getParentId().isPresent());
    assertSame(immutableDomainRow, actualToFlatNodeResult.getData());
  }

  /**
   * Test {@link DomainRow#toFlatNode()}.
   *
   * <p>Method under test: {@link DomainRow#toFlatNode()}
   */
  @Test
  @DisplayName("Test toFlatNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlatNode DomainRow.toFlatNode()"})
  void testToFlatNode2() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId(null)
            .parentExtId("42")
            .build();

    // Act
    FlatNode<DomainRow, String> actualToFlatNodeResult = immutableDomainRow.toFlatNode();

    // Assert
    assertEquals("42", actualToFlatNodeResult.getId());
    assertFalse(actualToFlatNodeResult.getParentId().isPresent());
    assertSame(immutableDomainRow, actualToFlatNodeResult.getData());
  }

  /**
   * Test {@link DomainRow#toFlatNode()}.
   *
   * <ul>
   *   <li>Then Data return {@link ImmutableDomainRow}.
   * </ul>
   *
   * <p>Method under test: {@link DomainRow#toFlatNode()}
   */
  @Test
  @DisplayName("Test toFlatNode(); then Data return ImmutableDomainRow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlatNode DomainRow.toFlatNode()"})
  void testToFlatNode_thenDataReturnImmutableDomainRow() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    FlatNode<DomainRow, String> actualToFlatNodeResult = immutableDomainRow.toFlatNode();

    // Assert
    DomainRow data = actualToFlatNodeResult.getData();
    assertTrue(data instanceof ImmutableDomainRow);
    Optional<String> parentId = actualToFlatNodeResult.getParentId();
    assertEquals("42", parentId.get());
    assertEquals("42", data.parentDomainObjectId());
    assertTrue(parentId.isPresent());
    assertSame(immutableDomainRow, data);
  }

  /**
   * Test {@link DomainRow#fromRow(Row)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableDomainRow}.
   * </ul>
   *
   * <p>Method under test: {@link DomainRow#fromRow(Row)}
   */
  @Test
  @DisplayName("Test fromRow(Row); then return ImmutableDomainRow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DomainRow DomainRow.fromRow(Row)"})
  void testFromRow_thenReturnImmutableDomainRow() {
    // Arrange
    SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
    sxssfWorkbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);

    DeferredSXSSFSheet sheet = mock(DeferredSXSSFSheet.class);
    when(sheet.getWorkbook()).thenReturn(sxssfWorkbook);
    SXSSFRow row = new SXSSFRow(sheet);

    // Act
    DomainRow actualFromRowResult = DomainRow.fromRow(row);

    // Assert
    verify(sheet, atLeast(1)).getWorkbook();
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
