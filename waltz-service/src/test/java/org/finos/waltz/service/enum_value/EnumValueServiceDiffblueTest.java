package org.finos.waltz.service.enum_value;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.enum_value.EnumValueDao;
import org.finos.waltz.model.EnumValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnumValueServiceDiffblueTest {
  /**
   * Test {@link EnumValueService#findAll()}.
   *
   * <p>Method under test: {@link EnumValueService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EnumValueService.findAll()"})
  void testFindAll() {
    // Arrange
    EnumValueDao enumValueDao = mock(EnumValueDao.class);
    when(enumValueDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<EnumValue> actualFindAllResult = new EnumValueService(enumValueDao).findAll();

    // Assert
    verify(enumValueDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }
}
