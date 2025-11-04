package org.finos.waltz.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class NotAuthorizedExceptionDiffblueTest {
  /**
   * Method under test: {@link NotAuthorizedException#NotAuthorizedException()}
   */
  @Test
  void testNewNotAuthorizedException() {
    // Arrange and Act
    NotAuthorizedException actualNotAuthorizedException = new NotAuthorizedException();

    // Assert
    assertEquals("NOT_AUTHORIZED", actualNotAuthorizedException.getCode());
    assertEquals("You do not have permission to perform that operation", actualNotAuthorizedException.getMessage());
    assertNull(actualNotAuthorizedException.getCause());
    assertEquals(0, actualNotAuthorizedException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link NotAuthorizedException#NotAuthorizedException(String)}
   */
  @Test
  void testNewNotAuthorizedException2() {
    // Arrange and Act
    NotAuthorizedException actualNotAuthorizedException = new NotAuthorizedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualNotAuthorizedException.getMessage());
    assertEquals("NOT_AUTHORIZED", actualNotAuthorizedException.getCode());
    assertNull(actualNotAuthorizedException.getCause());
    assertEquals(0, actualNotAuthorizedException.getSuppressed().length);
  }
}
