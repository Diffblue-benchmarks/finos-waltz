package org.finos.waltz.data.datatype_decorator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataTypeDecoratorDaoSelectorFactoryDiffblueTest {
  /**
   * Test {@link DataTypeDecoratorDaoSelectorFactory#getDao(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorDaoSelectorFactory#getDao(EntityKind)}
   */
  @Test
  @DisplayName("Test getDao(EntityKind); when 'ALL'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.data.datatype_decorator.DataTypeDecoratorDao DataTypeDecoratorDaoSelectorFactory.getDao(EntityKind)"
  })
  void testGetDao_whenAll_thenThrowIllegalArgumentException() {
    // Arrange
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory =
        new DataTypeDecoratorDaoSelectorFactory(
            mock(PhysicalSpecDecoratorDao.class), mock(LogicalFlowDecoratorDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataTypeDecoratorDaoSelectorFactory.getDao(EntityKind.ALL));
  }

  /**
   * Test {@link DataTypeDecoratorDaoSelectorFactory#getDao(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorDaoSelectorFactory#getDao(EntityKind)}
   */
  @Test
  @DisplayName("Test getDao(EntityKind); when 'LOGICAL_DATA_FLOW'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.data.datatype_decorator.DataTypeDecoratorDao DataTypeDecoratorDaoSelectorFactory.getDao(EntityKind)"
  })
  void testGetDao_whenLogicalDataFlow_thenDoesNotThrow() {
    // Arrange
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory =
        new DataTypeDecoratorDaoSelectorFactory(
            mock(PhysicalSpecDecoratorDao.class), mock(LogicalFlowDecoratorDao.class));

    // Act
    assertDoesNotThrow(
        () -> dataTypeDecoratorDaoSelectorFactory.getDao(EntityKind.LOGICAL_DATA_FLOW));
  }

  /**
   * Test {@link DataTypeDecoratorDaoSelectorFactory#getDao(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code PHYSICAL_SPECIFICATION}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorDaoSelectorFactory#getDao(EntityKind)}
   */
  @Test
  @DisplayName("Test getDao(EntityKind); when 'PHYSICAL_SPECIFICATION'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.data.datatype_decorator.DataTypeDecoratorDao DataTypeDecoratorDaoSelectorFactory.getDao(EntityKind)"
  })
  void testGetDao_whenPhysicalSpecification_thenDoesNotThrow() {
    // Arrange
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory =
        new DataTypeDecoratorDaoSelectorFactory(
            mock(PhysicalSpecDecoratorDao.class), mock(LogicalFlowDecoratorDao.class));

    // Act
    assertDoesNotThrow(
        () -> dataTypeDecoratorDaoSelectorFactory.getDao(EntityKind.PHYSICAL_SPECIFICATION));
  }
}
