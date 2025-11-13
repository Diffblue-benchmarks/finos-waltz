package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InsufficientPrivelegeExceptionDiffblueTest {
  /**
   * Test {@link InsufficientPrivelegeException#InsufficientPrivelegeException(String)}.
   *
   * <p>Method under test: {@link
   * InsufficientPrivelegeException#InsufficientPrivelegeException(String)}
   */
  @Test
  @DisplayName("Test new InsufficientPrivelegeException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InsufficientPrivelegeException.<init>(String)"})
  void testNewInsufficientPrivelegeException() {
    // Arrange and Act
    InsufficientPrivelegeException actualInsufficientPrivelegeException =
        new InsufficientPrivelegeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInsufficientPrivelegeException.getMessage());
    assertNull(actualInsufficientPrivelegeException.getCause());
    assertEquals(0, actualInsufficientPrivelegeException.getSuppressed().length);
  }
}
