package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataTypeUsageCharacteristicsDiffblueTest {
  /**
   * Test {@link DataTypeUsageCharacteristics#isRemovable()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageCharacteristics#isRemovable()}
   */
  @Test
  @DisplayName("Test isRemovable(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageCharacteristics.isRemovable()"})
  void testIsRemovable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build()
            .isRemovable());
  }
}
