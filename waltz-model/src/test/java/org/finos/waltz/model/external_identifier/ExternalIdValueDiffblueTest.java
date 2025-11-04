package org.finos.waltz.model.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class ExternalIdValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExternalIdValue#equals(Object)}
   *   <li>{@link ExternalIdValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExternalIdValue ofResult = ExternalIdValue.of("42");
    ExternalIdValue ofResult2 = ExternalIdValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExternalIdValue#equals(Object)}
   *   <li>{@link ExternalIdValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExternalIdValue ofResult = ExternalIdValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link ExternalIdValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExternalIdValue ofResult = ExternalIdValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, ExternalIdValue.of("42"));
  }

  /**
   * Method under test: {@link ExternalIdValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExternalIdValue.of("42"), null);
  }

  /**
   * Method under test: {@link ExternalIdValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExternalIdValue.of("42"), "Different type to ExternalIdValue");
  }

  /**
   * Method under test: {@link ExternalIdValue#of(String)}
   */
  @Test
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", ExternalIdValue.of("42").value());
  }

  /**
   * Method under test: {@link ExternalIdValue#value()}
   */
  @Test
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", ExternalIdValue.of("42").value());
  }
}
