package org.finos.waltz.service.enum_value;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.enum_value.EnumValueDao;
import org.finos.waltz.model.EnumValue;
import org.junit.jupiter.api.Test;

class EnumValueServiceDiffblueTest {
  /**
   * Method under test: {@link EnumValueService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    EnumValueDao enumValueDao = mock(EnumValueDao.class);
    ArrayList<EnumValue> enumValueList = new ArrayList<>();
    when(enumValueDao.findAll()).thenReturn(enumValueList);

    // Act
    List<EnumValue> actualFindAllResult = (new EnumValueService(enumValueDao)).findAll();

    // Assert
    verify(enumValueDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(enumValueList, actualFindAllResult);
  }
}
