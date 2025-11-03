package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ModifyingReadOnlyRecordExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModifyingReadOnlyRecordException#ModifyingReadOnlyRecordException(String, String)}
   *   <li>{@link ModifyingReadOnlyRecordException#getCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ModifyingReadOnlyRecordException.<init>(String, String)",
      "String ModifyingReadOnlyRecordException.getCode()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ModifyingReadOnlyRecordException actualModifyingReadOnlyRecordException = new ModifyingReadOnlyRecordException(
        "Code", "An error occurred");

    // Assert
    assertEquals("An error occurred", actualModifyingReadOnlyRecordException.getMessage());
    assertEquals("Code", actualModifyingReadOnlyRecordException.getCode());
    assertNull(actualModifyingReadOnlyRecordException.getCause());
    assertEquals(0, actualModifyingReadOnlyRecordException.getSuppressed().length);
  }

  /**
   * Test {@link ModifyingReadOnlyRecordException#ModifyingReadOnlyRecordException(String, String, Object[])}.
   * <p>
   * Method under test: {@link ModifyingReadOnlyRecordException#ModifyingReadOnlyRecordException(String, String, Object[])}
   */
  @Test
  @DisplayName("Test new ModifyingReadOnlyRecordException(String, String, Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ModifyingReadOnlyRecordException.<init>(String, String, Object[])"})
  void testNewModifyingReadOnlyRecordException() {
    // Arrange and Act
    ModifyingReadOnlyRecordException actualModifyingReadOnlyRecordException = new ModifyingReadOnlyRecordException(
        "Code", "An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualModifyingReadOnlyRecordException.getLocalizedMessage());
    assertEquals("An error occurred", actualModifyingReadOnlyRecordException.getMessage());
    assertEquals("Code", actualModifyingReadOnlyRecordException.getCode());
    assertNull(actualModifyingReadOnlyRecordException.getCause());
    assertEquals(0, actualModifyingReadOnlyRecordException.getSuppressed().length);
  }
}
