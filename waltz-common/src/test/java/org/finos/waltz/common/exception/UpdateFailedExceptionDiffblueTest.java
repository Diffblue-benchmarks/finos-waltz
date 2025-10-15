package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UpdateFailedExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UpdateFailedException#UpdateFailedException(String, String)}
   *   <li>{@link UpdateFailedException#getCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpdateFailedException.<init>(String, String)",
    "void UpdateFailedException.<init>(String, String, Throwable)",
    "String UpdateFailedException.getCode()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    UpdateFailedException actualUpdateFailedException =
        new UpdateFailedException("Code", "An error occurred");
    String actualCode = actualUpdateFailedException.getCode();

    // Assert
    assertEquals("An error occurred", actualUpdateFailedException.getMessage());
    assertEquals("Code", actualCode);
    assertNull(actualUpdateFailedException.getCause());
    assertEquals(0, actualUpdateFailedException.getSuppressed().length);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UpdateFailedException#UpdateFailedException(String, String, Throwable)}
   *   <li>{@link UpdateFailedException#getCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpdateFailedException.<init>(String, String)",
    "void UpdateFailedException.<init>(String, String, Throwable)",
    "String UpdateFailedException.getCode()"
  })
  void testGettersAndSetters_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UpdateFailedException actualUpdateFailedException =
        new UpdateFailedException("Code", "An error occurred", cause);
    String actualCode = actualUpdateFailedException.getCode();

    // Assert
    assertEquals("An error occurred", actualUpdateFailedException.getMessage());
    assertEquals("Code", actualCode);
    assertEquals(0, actualUpdateFailedException.getSuppressed().length);
    assertSame(cause, actualUpdateFailedException.getCause());
  }
}
