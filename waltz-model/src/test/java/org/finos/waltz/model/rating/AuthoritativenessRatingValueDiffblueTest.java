package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuthoritativenessRatingValueDiffblueTest {
  /**
   * Test {@link AuthoritativenessRatingValue#equals(Object)}, and {@link
   * AuthoritativenessRatingValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuthoritativenessRatingValue#equals(Object)}
   *   <li>{@link AuthoritativenessRatingValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AuthoritativenessRatingValue.equals(Object)",
    "int AuthoritativenessRatingValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link AuthoritativenessRatingValue#equals(Object)}, and {@link
   * AuthoritativenessRatingValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuthoritativenessRatingValue#equals(Object)}
   *   <li>{@link AuthoritativenessRatingValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AuthoritativenessRatingValue.equals(Object)",
    "int AuthoritativenessRatingValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link AuthoritativenessRatingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuthoritativenessRatingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AuthoritativenessRatingValue.equals(Object)",
    "int AuthoritativenessRatingValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AuthoritativenessRatingValue.of("42"), 1);
  }

  /**
   * Test {@link AuthoritativenessRatingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuthoritativenessRatingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AuthoritativenessRatingValue.equals(Object)",
    "int AuthoritativenessRatingValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, AuthoritativenessRatingValue.of("42"));
  }

  /**
   * Test {@link AuthoritativenessRatingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuthoritativenessRatingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AuthoritativenessRatingValue.equals(Object)",
    "int AuthoritativenessRatingValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AuthoritativenessRatingValue.of("42"), null);
  }

  /**
   * Test {@link AuthoritativenessRatingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuthoritativenessRatingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AuthoritativenessRatingValue.equals(Object)",
    "int AuthoritativenessRatingValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AuthoritativenessRatingValue.of("42"), "Different type to AuthoritativenessRatingValue");
  }

  /**
   * Test {@link AuthoritativenessRatingValue#of(String)}.
   *
   * <p>Method under test: {@link AuthoritativenessRatingValue#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AuthoritativenessRatingValue AuthoritativenessRatingValue.of(String)"})
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", AuthoritativenessRatingValue.of("42").value());
  }

  /**
   * Test {@link AuthoritativenessRatingValue#value()}.
   *
   * <p>Method under test: {@link AuthoritativenessRatingValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AuthoritativenessRatingValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", AuthoritativenessRatingValue.of("42").value());
  }
}
