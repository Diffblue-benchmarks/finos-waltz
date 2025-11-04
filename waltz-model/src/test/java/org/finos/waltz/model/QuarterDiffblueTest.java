package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class QuarterDiffblueTest {
  /**
   * Method under test: {@link Quarter#fromInt(Integer)}
   */
  @Test
  void testFromInt() {
    // Arrange, Act and Assert
    assertEquals(Quarter.Q1, Quarter.fromInt(1));
    assertEquals(Quarter.Q2, Quarter.fromInt(2));
    assertEquals(Quarter.Q3, Quarter.fromInt(3));
    assertEquals(Quarter.Q4, Quarter.fromInt(4));
    assertThrows(IllegalArgumentException.class, () -> Quarter.fromInt(0));
  }
}
