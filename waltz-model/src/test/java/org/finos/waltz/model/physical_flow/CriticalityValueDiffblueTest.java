package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class CriticalityValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CriticalityValue#equals(Object)}
   *   <li>{@link CriticalityValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CriticalityValue ofResult = CriticalityValue.of("42");
    CriticalityValue ofResult2 = CriticalityValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CriticalityValue#equals(Object)}
   *   <li>{@link CriticalityValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CriticalityValue ofResult = CriticalityValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link CriticalityValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CriticalityValue ofResult = CriticalityValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, CriticalityValue.of("42"));
  }

  /**
   * Method under test: {@link CriticalityValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CriticalityValue.of("42"), null);
  }

  /**
   * Method under test: {@link CriticalityValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CriticalityValue.of("42"), "Different type to CriticalityValue");
  }

  /**
   * Method under test: {@link CriticalityValue#of(String)}
   */
  @Test
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", CriticalityValue.of("42").value());
  }

  /**
   * Method under test: {@link CriticalityValue#value()}
   */
  @Test
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", CriticalityValue.of("42").value());
  }
}
