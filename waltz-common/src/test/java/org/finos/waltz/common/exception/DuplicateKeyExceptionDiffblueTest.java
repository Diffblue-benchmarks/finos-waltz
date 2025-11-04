package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class DuplicateKeyExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link DuplicateKeyException#DuplicateKeyException(String)}
   */
  @Test
  void testNewDuplicateKeyException() {
    // Arrange and Act
    DuplicateKeyException actualDuplicateKeyException = new DuplicateKeyException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDuplicateKeyException.getMessage());
    assertNull(actualDuplicateKeyException.getCause());
    assertEquals(0, actualDuplicateKeyException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link DuplicateKeyException#DuplicateKeyException(String, Throwable)}
   */
  @Test
  void testNewDuplicateKeyException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DuplicateKeyException actualDuplicateKeyException = new DuplicateKeyException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDuplicateKeyException.getMessage());
    assertEquals(0, actualDuplicateKeyException.getSuppressed().length);
    assertSame(cause, actualDuplicateKeyException.getCause());
  }
}
