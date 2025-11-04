package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class TransportKindValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportKindValue#equals(Object)}
   *   <li>{@link TransportKindValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportKindValue ofResult = TransportKindValue.of("42");
    TransportKindValue ofResult2 = TransportKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportKindValue#equals(Object)}
   *   <li>{@link TransportKindValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportKindValue ofResult = TransportKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link TransportKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TransportKindValue ofResult = TransportKindValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, TransportKindValue.of("42"));
  }

  /**
   * Method under test: {@link TransportKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportKindValue.of("42"), null);
  }

  /**
   * Method under test: {@link TransportKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportKindValue.of("42"), "Different type to TransportKindValue");
  }

  /**
   * Method under test: {@link TransportKindValue#of(String)}
   */
  @Test
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", TransportKindValue.of("42").value());
  }

  /**
   * Method under test: {@link TransportKindValue#value()}
   */
  @Test
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", TransportKindValue.of("42").value());
  }
}
