package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class UpdateFailedExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateFailedException#UpdateFailedException(String, String)}
   *   <li>{@link UpdateFailedException#getCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UpdateFailedException actualUpdateFailedException = new UpdateFailedException("Code", "An error occurred");

    // Assert
    assertEquals("An error occurred", actualUpdateFailedException.getMessage());
    assertEquals("Code", actualUpdateFailedException.getCode());
    assertNull(actualUpdateFailedException.getCause());
    assertEquals(0, actualUpdateFailedException.getSuppressed().length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link UpdateFailedException#UpdateFailedException(String, String, Throwable)}
   *   <li>{@link UpdateFailedException#getCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UpdateFailedException actualUpdateFailedException = new UpdateFailedException("Code", "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUpdateFailedException.getMessage());
    assertEquals("Code", actualUpdateFailedException.getCode());
    assertEquals(0, actualUpdateFailedException.getSuppressed().length);
    assertSame(cause, actualUpdateFailedException.getCause());
  }
}
