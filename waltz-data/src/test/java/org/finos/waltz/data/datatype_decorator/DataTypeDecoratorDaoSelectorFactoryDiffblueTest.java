package org.finos.waltz.data.datatype_decorator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataTypeDecoratorDaoSelectorFactoryDiffblueTest {
  @InjectMocks private DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory;

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
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> dataTypeDecoratorDaoSelectorFactory.getDao(EntityKind.ALL));
  }
}
