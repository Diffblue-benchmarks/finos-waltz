package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DurationDiffblueTest {
  /**
   * Method under test: {@link Duration#numDays()}
   */
  @Test
  void testNumDays() {
    // Arrange, Act and Assert
    assertEquals(1, Duration.valueOf("DAY").numDays());
  }
}
