package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class ObjectUtilitiesDiffblueTest {
  /**
   * Method under test: {@link ObjectUtilities#dump(Object)}
   */
  @Test
  void testDump() {
    // Arrange, Act and Assert
    assertEquals("42", ObjectUtilities.dump("42"));
  }

  /**
   * Method under test: {@link ObjectUtilities#firstNotNull(Object[])}
   */
  @Test
  void testFirstNotNull() {
    // Arrange, Act and Assert
    assertEquals("Ts", ObjectUtilities.firstNotNull("Ts"));
  }

  /**
   * Method under test: {@link ObjectUtilities#any(Predicate, Object[])}
   */
  @Test
  void testAny() {
    // Arrange, Act and Assert
    assertFalse(ObjectUtilities.any(mock(RangeBand.class)::equals, "Ts"));
  }
}
