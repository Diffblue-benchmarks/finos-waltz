package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SectionDiffblueTest {
  /**
   * Method under test: {@link Section#id()}
   */
  @Test
  void testId() {
    // Arrange, Act and Assert
    assertEquals(17, Section.valueOf("APP_SURVEYS").id());
  }
}
