package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.finos.waltz.model.bulk_upload.ChangeOperation;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyValidatedItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkTaxonomyChangeServiceDiffblueTest {
  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_thenReturnTrue() {
    // Arrange
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem.changedFields()).thenReturn(new HashSet<>());
    when(bulkTaxonomyValidatedItem.changeOperation()).thenReturn(ChangeOperation.ADD);

    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();
    items.add(bulkTaxonomyValidatedItem);

    // Act
    boolean actualRequiresHierarchyRebuildResult = BulkTaxonomyChangeService.requiresHierarchyRebuild(items);

    // Assert
    verify(bulkTaxonomyValidatedItem, atLeast(1)).changeOperation();
    verify(bulkTaxonomyValidatedItem).changedFields();
    assertTrue(actualRequiresHierarchyRebuildResult);
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_thenReturnTrue2() {
    // Arrange
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem.changedFields()).thenReturn(new HashSet<>());
    when(bulkTaxonomyValidatedItem.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem2 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem2.changedFields()).thenReturn(new HashSet<>());
    when(bulkTaxonomyValidatedItem2.changeOperation()).thenReturn(ChangeOperation.ADD);

    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();
    items.add(bulkTaxonomyValidatedItem2);
    items.add(bulkTaxonomyValidatedItem);

    // Act
    boolean actualRequiresHierarchyRebuildResult = BulkTaxonomyChangeService.requiresHierarchyRebuild(items);

    // Assert
    verify(bulkTaxonomyValidatedItem2, atLeast(1)).changeOperation();
    verify(bulkTaxonomyValidatedItem2).changedFields();
    assertTrue(actualRequiresHierarchyRebuildResult);
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_thenThrowUnsupportedOperationException() {
    // Arrange
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem2 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem2.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem3 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem3.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem4 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem4.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem5 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem5.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem6 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem6.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem7 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem7.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem8 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem8.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem9 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem9.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem10 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem10.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem11 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem11.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem12 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem12.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem13 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem13.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem14 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem14.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem15 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem15.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem16 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem16.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem17 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem17.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem18 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem18.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem19 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem19.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem20 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem20.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem21 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem21.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem22 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem22.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem23 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem23.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem24 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem24.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem25 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem25.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem26 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem26.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem27 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem27.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem28 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem28.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem29 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem29.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem30 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem30.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem31 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem31.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem32 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem32.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem33 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem33.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem34 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem34.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem35 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem35.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem36 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem36.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem37 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem37.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem38 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem38.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem39 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem39.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem40 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem40.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem41 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem41.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem42 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem42.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem43 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem43.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem44 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem44.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem45 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem45.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem46 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem46.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem47 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem47.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem48 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem48.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem49 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem49.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem50 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem50.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem51 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem51.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem52 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem52.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem53 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem53.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem54 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem54.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem55 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem55.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem56 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem56.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem57 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem57.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem58 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem58.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem59 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem59.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem60 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem60.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem61 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem61.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem62 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem62.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem63 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem63.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem64 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem64.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem65 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem65.changeOperation()).thenReturn(ChangeOperation.ADD);
    BulkTaxonomyValidatedItem bulkTaxonomyValidatedItem66 = mock(BulkTaxonomyValidatedItem.class);
    when(bulkTaxonomyValidatedItem66.changeOperation()).thenThrow(new UnsupportedOperationException("foo"));

    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();
    items.add(bulkTaxonomyValidatedItem66);
    items.add(bulkTaxonomyValidatedItem65);
    items.add(bulkTaxonomyValidatedItem64);
    items.add(bulkTaxonomyValidatedItem63);
    items.add(bulkTaxonomyValidatedItem62);
    items.add(bulkTaxonomyValidatedItem61);
    items.add(bulkTaxonomyValidatedItem60);
    items.add(bulkTaxonomyValidatedItem59);
    items.add(bulkTaxonomyValidatedItem58);
    items.add(bulkTaxonomyValidatedItem57);
    items.add(bulkTaxonomyValidatedItem56);
    items.add(bulkTaxonomyValidatedItem55);
    items.add(bulkTaxonomyValidatedItem54);
    items.add(bulkTaxonomyValidatedItem53);
    items.add(bulkTaxonomyValidatedItem52);
    items.add(bulkTaxonomyValidatedItem51);
    items.add(bulkTaxonomyValidatedItem50);
    items.add(bulkTaxonomyValidatedItem49);
    items.add(bulkTaxonomyValidatedItem48);
    items.add(bulkTaxonomyValidatedItem47);
    items.add(bulkTaxonomyValidatedItem46);
    items.add(bulkTaxonomyValidatedItem45);
    items.add(bulkTaxonomyValidatedItem44);
    items.add(bulkTaxonomyValidatedItem43);
    items.add(bulkTaxonomyValidatedItem42);
    items.add(bulkTaxonomyValidatedItem41);
    items.add(bulkTaxonomyValidatedItem40);
    items.add(bulkTaxonomyValidatedItem39);
    items.add(bulkTaxonomyValidatedItem38);
    items.add(bulkTaxonomyValidatedItem37);
    items.add(bulkTaxonomyValidatedItem36);
    items.add(bulkTaxonomyValidatedItem35);
    items.add(bulkTaxonomyValidatedItem34);
    items.add(bulkTaxonomyValidatedItem33);
    items.add(bulkTaxonomyValidatedItem32);
    items.add(bulkTaxonomyValidatedItem31);
    items.add(bulkTaxonomyValidatedItem30);
    items.add(bulkTaxonomyValidatedItem29);
    items.add(bulkTaxonomyValidatedItem28);
    items.add(bulkTaxonomyValidatedItem27);
    items.add(bulkTaxonomyValidatedItem26);
    items.add(bulkTaxonomyValidatedItem25);
    items.add(bulkTaxonomyValidatedItem24);
    items.add(bulkTaxonomyValidatedItem23);
    items.add(bulkTaxonomyValidatedItem22);
    items.add(bulkTaxonomyValidatedItem21);
    items.add(bulkTaxonomyValidatedItem20);
    items.add(bulkTaxonomyValidatedItem19);
    items.add(bulkTaxonomyValidatedItem18);
    items.add(bulkTaxonomyValidatedItem17);
    items.add(bulkTaxonomyValidatedItem16);
    items.add(bulkTaxonomyValidatedItem15);
    items.add(bulkTaxonomyValidatedItem14);
    items.add(bulkTaxonomyValidatedItem13);
    items.add(bulkTaxonomyValidatedItem12);
    items.add(bulkTaxonomyValidatedItem11);
    items.add(bulkTaxonomyValidatedItem10);
    items.add(bulkTaxonomyValidatedItem9);
    items.add(bulkTaxonomyValidatedItem8);
    items.add(bulkTaxonomyValidatedItem7);
    items.add(bulkTaxonomyValidatedItem6);
    items.add(bulkTaxonomyValidatedItem5);
    items.add(bulkTaxonomyValidatedItem4);
    items.add(bulkTaxonomyValidatedItem3);
    items.add(bulkTaxonomyValidatedItem2);
    items.add(bulkTaxonomyValidatedItem);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
    verify(bulkTaxonomyValidatedItem66).changeOperation();
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection); when ArrayList(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BulkTaxonomyChangeService.requiresHierarchyRebuild(new ArrayList<>()));
  }
}
