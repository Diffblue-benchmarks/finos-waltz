package org.finos.waltz.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class WebExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WebException#WebException(String, String)}
   *   <li>{@link WebException#getCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    WebException actualWebException = new WebException("Code", "An error occurred");

    // Assert
    assertEquals("An error occurred", actualWebException.getMessage());
    assertEquals("Code", actualWebException.getCode());
    assertNull(actualWebException.getCause());
    assertEquals(0, actualWebException.getSuppressed().length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WebException#WebException(String, String, Throwable)}
   *   <li>{@link WebException#getCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebException actualWebException = new WebException("Code", "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualWebException.getMessage());
    assertEquals("Code", actualWebException.getCode());
    assertEquals(0, actualWebException.getSuppressed().length);
    assertSame(cause, actualWebException.getCause());
  }
}
