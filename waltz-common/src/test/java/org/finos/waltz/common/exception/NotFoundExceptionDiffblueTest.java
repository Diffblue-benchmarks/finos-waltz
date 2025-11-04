package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class NotFoundExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotFoundException#NotFoundException(String, String)}
   *   <li>{@link NotFoundException#getCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NotFoundException actualNotFoundException = new NotFoundException("Code", "An error occurred");

    // Assert
    assertEquals("An error occurred", actualNotFoundException.getMessage());
    assertEquals("Code", actualNotFoundException.getCode());
    assertNull(actualNotFoundException.getCause());
    assertEquals(0, actualNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link NotFoundException#NotFoundException(String, String, Object[])}
   */
  @Test
  void testNewNotFoundException() {
    // Arrange and Act
    NotFoundException actualNotFoundException = new NotFoundException("Code", "An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualNotFoundException.getLocalizedMessage());
    assertEquals("An error occurred", actualNotFoundException.getMessage());
    assertEquals("Code", actualNotFoundException.getCode());
    assertNull(actualNotFoundException.getCause());
    assertEquals(0, actualNotFoundException.getSuppressed().length);
  }
}
