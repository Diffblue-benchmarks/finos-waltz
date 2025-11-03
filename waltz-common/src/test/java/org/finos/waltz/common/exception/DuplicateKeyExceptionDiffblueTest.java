package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DuplicateKeyExceptionDiffblueTest {
  /**
   * Test {@link DuplicateKeyException#DuplicateKeyException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DuplicateKeyException#DuplicateKeyException(String)}
   */
  @Test
  @DisplayName("Test new DuplicateKeyException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DuplicateKeyException.<init>(String)",
      "void DuplicateKeyException.<init>(String, Throwable)"})
  void testNewDuplicateKeyException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    DuplicateKeyException actualDuplicateKeyException = new DuplicateKeyException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDuplicateKeyException.getMessage());
    assertNull(actualDuplicateKeyException.getCause());
    assertEquals(0, actualDuplicateKeyException.getSuppressed().length);
  }

  /**
   * Test {@link DuplicateKeyException#DuplicateKeyException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DuplicateKeyException#DuplicateKeyException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new DuplicateKeyException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DuplicateKeyException.<init>(String)",
      "void DuplicateKeyException.<init>(String, Throwable)"})
  void testNewDuplicateKeyException_whenThrowable_thenReturnCauseIsThrowable() {
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
