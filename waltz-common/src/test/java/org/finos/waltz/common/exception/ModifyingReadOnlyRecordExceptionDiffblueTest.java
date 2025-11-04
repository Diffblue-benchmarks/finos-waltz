package org.finos.waltz.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ModifyingReadOnlyRecordExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ModifyingReadOnlyRecordException#ModifyingReadOnlyRecordException(String, String)}
   *   <li>{@link ModifyingReadOnlyRecordException#getCode()}
   * </ul>
   */
  @Test
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
   * Method under test:
   * {@link ModifyingReadOnlyRecordException#ModifyingReadOnlyRecordException(String, String, Object[])}
   */
  @Test
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
