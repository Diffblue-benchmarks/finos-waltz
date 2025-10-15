package org.finos.waltz.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotAuthorizedExceptionDiffblueTest {
  /**
   * Test {@link NotAuthorizedException#NotAuthorizedException()}.
   *
   * <p>Method under test: {@link NotAuthorizedException#NotAuthorizedException()}
   */
  @Test
  @DisplayName("Test new NotAuthorizedException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotAuthorizedException.<init>()",
    "void NotAuthorizedException.<init>(String)"
  })
  void testNewNotAuthorizedException() {
    // Arrange and Act
    NotAuthorizedException actualNotAuthorizedException = new NotAuthorizedException();

    // Assert
    assertEquals("NOT_AUTHORIZED", actualNotAuthorizedException.getCode());
    assertEquals(
        "You do not have permission to perform that operation",
        actualNotAuthorizedException.getMessage());
    assertNull(actualNotAuthorizedException.getCause());
    assertEquals(0, actualNotAuthorizedException.getSuppressed().length);
  }

  /**
   * Test {@link NotAuthorizedException#NotAuthorizedException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link NotAuthorizedException#NotAuthorizedException(String)}
   */
  @Test
  @DisplayName(
      "Test new NotAuthorizedException(String); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotAuthorizedException.<init>()",
    "void NotAuthorizedException.<init>(String)"
  })
  void testNewNotAuthorizedException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    NotAuthorizedException actualNotAuthorizedException =
        new NotAuthorizedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualNotAuthorizedException.getMessage());
    assertEquals("NOT_AUTHORIZED", actualNotAuthorizedException.getCode());
    assertNull(actualNotAuthorizedException.getCause());
    assertEquals(0, actualNotAuthorizedException.getSuppressed().length);
  }
}
