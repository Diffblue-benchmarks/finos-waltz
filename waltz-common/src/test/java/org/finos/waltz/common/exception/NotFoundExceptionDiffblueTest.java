package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotFoundExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotFoundException#NotFoundException(String, String)}
   *   <li>{@link NotFoundException#getCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotFoundException.<init>(String, String)", "String NotFoundException.getCode()"})
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
   * Test {@link NotFoundException#NotFoundException(String, String, Object[])}.
   * <p>
   * Method under test: {@link NotFoundException#NotFoundException(String, String, Object[])}
   */
  @Test
  @DisplayName("Test new NotFoundException(String, String, Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotFoundException.<init>(String, String, Object[])"})
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
