package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ColumnsDiffblueTest {
  /**
   * Test {@link Columns#toOffset(String)}.
   * <p>
   * Method under test: {@link Columns#toOffset(String)}
   */
  @Test
  @DisplayName("Test toOffset(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Columns.toOffset(String)"})
  void testToOffset() {
    // Arrange, Act and Assert
    assertEquals(505, Columns.toOffset("Col"));
  }
}
