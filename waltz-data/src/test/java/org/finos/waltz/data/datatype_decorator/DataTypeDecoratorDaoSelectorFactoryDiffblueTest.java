package org.finos.waltz.data.datatype_decorator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class DataTypeDecoratorDaoSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link DataTypeDecoratorDaoSelectorFactory#getDao(EntityKind)}
   */
  @Test
  void testGetDao() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new DataTypeDecoratorDaoSelectorFactory(mock(PhysicalSpecDecoratorDao.class),
            mock(LogicalFlowDecoratorDao.class))).getDao(EntityKind.ALL));
  }
}
