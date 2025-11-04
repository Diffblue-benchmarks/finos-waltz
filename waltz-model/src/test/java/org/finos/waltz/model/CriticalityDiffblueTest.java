package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class CriticalityDiffblueTest {
  /**
   * Method under test: {@link Criticality#parse(String, Function)}
   */
  @Test
  void testParse() {
    // Arrange, Act and Assert
    assertEquals(Criticality.LOW, Criticality.parse("LOW", Criticality::valueOf));
  }
}
