package org.finos.waltz.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WebExceptionDiffblueTest {
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
   *   <li>{@link WebException#WebException(String, String)}
   *   <li>{@link WebException#getCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebException.<init>(String, String)",
    "void WebException.<init>(String, String, Throwable)",
    "String WebException.getCode()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    WebException actualWebException = new WebException("Code", "An error occurred");
    String actualCode = actualWebException.getCode();

    // Assert
    assertEquals("An error occurred", actualWebException.getMessage());
    assertEquals("Code", actualCode);
    assertNull(actualWebException.getCause());
    assertEquals(0, actualWebException.getSuppressed().length);
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
   *   <li>{@link WebException#WebException(String, String, Throwable)}
   *   <li>{@link WebException#getCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebException.<init>(String, String)",
    "void WebException.<init>(String, String, Throwable)",
    "String WebException.getCode()"
  })
  void testGettersAndSetters_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WebException actualWebException = new WebException("Code", "An error occurred", cause);
    String actualCode = actualWebException.getCode();

    // Assert
    assertEquals("An error occurred", actualWebException.getMessage());
    assertEquals("Code", actualCode);
    assertEquals(0, actualWebException.getSuppressed().length);
    assertSame(cause, actualWebException.getCause());
  }
}
