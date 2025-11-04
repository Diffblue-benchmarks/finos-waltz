package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ColumnsDiffblueTest {
  /**
   * Method under test: {@link Columns#toOffset(String)}
   */
  @Test
  void testToOffset() {
    // Arrange, Act and Assert
    assertEquals(505, Columns.toOffset("Col"));
  }
}
