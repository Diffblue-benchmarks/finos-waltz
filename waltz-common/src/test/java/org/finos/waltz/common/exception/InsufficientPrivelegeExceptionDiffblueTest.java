package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class InsufficientPrivelegeExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link InsufficientPrivelegeException#InsufficientPrivelegeException(String)}
   */
  @Test
  void testNewInsufficientPrivelegeException() {
    // Arrange and Act
    InsufficientPrivelegeException actualInsufficientPrivelegeException = new InsufficientPrivelegeException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualInsufficientPrivelegeException.getMessage());
    assertNull(actualInsufficientPrivelegeException.getCause());
    assertEquals(0, actualInsufficientPrivelegeException.getSuppressed().length);
  }
}
