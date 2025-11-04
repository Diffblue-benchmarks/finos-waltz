package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EntityKindDiffblueTest {
  /**
   * Method under test: {@link EntityKind#prettyName()}
   */
  @Test
  void testPrettyName() {
    // Arrange, Act and Assert
    assertEquals("All", EntityKind.valueOf("ALL").prettyName());
  }
}
