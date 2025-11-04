package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class AuthoritativenessRatingValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AuthoritativenessRatingValue#equals(Object)}
   *   <li>{@link AuthoritativenessRatingValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AuthoritativenessRatingValue#equals(Object)}
   *   <li>{@link AuthoritativenessRatingValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link AuthoritativenessRatingValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, AuthoritativenessRatingValue.of("42"));
  }

  /**
   * Method under test: {@link AuthoritativenessRatingValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AuthoritativenessRatingValue.of("42"), null);
  }

  /**
   * Method under test: {@link AuthoritativenessRatingValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AuthoritativenessRatingValue.of("42"), "Different type to AuthoritativenessRatingValue");
  }

  /**
   * Method under test: {@link AuthoritativenessRatingValue#of(String)}
   */
  @Test
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", AuthoritativenessRatingValue.of("42").value());
  }

  /**
   * Method under test: {@link AuthoritativenessRatingValue#value()}
   */
  @Test
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", AuthoritativenessRatingValue.of("42").value());
  }
}
