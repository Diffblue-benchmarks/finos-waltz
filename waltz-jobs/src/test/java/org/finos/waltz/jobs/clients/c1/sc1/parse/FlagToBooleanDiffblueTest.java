package org.finos.waltz.jobs.clients.c1.sc1.parse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FlagToBooleanDiffblueTest {
  /**
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("foo"));
    assertTrue(FlagToBoolean.apply("x"));
    assertFalse(FlagToBoolean.apply("foo foo"));
    assertFalse(FlagToBoolean.apply("foo x"));
    assertFalse(FlagToBoolean.apply("foo 42"));
    assertFalse(FlagToBoolean.apply("x foo"));
    assertFalse(FlagToBoolean.apply("x x"));
    assertFalse(FlagToBoolean.apply("x 42"));
    assertFalse(FlagToBoolean.apply("42 foo"));
    assertFalse(FlagToBoolean.apply("42 x"));
    assertFalse(FlagToBoolean.apply("42 42"));
  }
}
