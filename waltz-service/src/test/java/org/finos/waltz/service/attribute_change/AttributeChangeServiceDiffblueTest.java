package org.finos.waltz.service.attribute_change;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.attribute_change.AttributeChangeDao;
import org.finos.waltz.model.attribute_change.AttributeChange;
import org.junit.jupiter.api.Test;

class AttributeChangeServiceDiffblueTest {
  /**
   * Method under test: {@link AttributeChangeService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    AttributeChangeDao dao = mock(AttributeChangeDao.class);
    when(dao.getById(anyLong())).thenReturn(null);

    // Act
    AttributeChange actualById = (new AttributeChangeService(dao)).getById(1L);

    // Assert
    verify(dao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link AttributeChangeService#findByChangeUnitId(long)}
   */
  @Test
  void testFindByChangeUnitId() {
    // Arrange
    AttributeChangeDao dao = mock(AttributeChangeDao.class);
    ArrayList<AttributeChange> attributeChangeList = new ArrayList<>();
    when(dao.findByChangeUnitId(anyLong())).thenReturn(attributeChangeList);

    // Act
    List<AttributeChange> actualFindByChangeUnitIdResult = (new AttributeChangeService(dao)).findByChangeUnitId(1L);

    // Assert
    verify(dao).findByChangeUnitId(eq(1L));
    assertTrue(actualFindByChangeUnitIdResult.isEmpty());
    assertSame(attributeChangeList, actualFindByChangeUnitIdResult);
  }
}
