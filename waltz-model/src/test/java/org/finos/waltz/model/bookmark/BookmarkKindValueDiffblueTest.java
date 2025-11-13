package org.finos.waltz.model.bookmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BookmarkKindValueDiffblueTest {
  /**
   * Test {@link BookmarkKindValue#equals(Object)}, and {@link BookmarkKindValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BookmarkKindValue#equals(Object)}
   *   <li>{@link BookmarkKindValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BookmarkKindValue.equals(Object)",
    "int BookmarkKindValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BookmarkKindValue ofResult = BookmarkKindValue.of("42");
    BookmarkKindValue ofResult2 = BookmarkKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link BookmarkKindValue#equals(Object)}, and {@link BookmarkKindValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BookmarkKindValue#equals(Object)}
   *   <li>{@link BookmarkKindValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BookmarkKindValue.equals(Object)",
    "int BookmarkKindValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BookmarkKindValue ofResult = BookmarkKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link BookmarkKindValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BookmarkKindValue.equals(Object)",
    "int BookmarkKindValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BookmarkKindValue.of("42"), 1);
  }

  /**
   * Test {@link BookmarkKindValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BookmarkKindValue.equals(Object)",
    "int BookmarkKindValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BookmarkKindValue ofResult = BookmarkKindValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, BookmarkKindValue.of("42"));
  }

  /**
   * Test {@link BookmarkKindValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BookmarkKindValue.equals(Object)",
    "int BookmarkKindValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BookmarkKindValue.of("42"), null);
  }

  /**
   * Test {@link BookmarkKindValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BookmarkKindValue.equals(Object)",
    "int BookmarkKindValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BookmarkKindValue.of("42"), "Different type to BookmarkKindValue");
  }

  /**
   * Test {@link BookmarkKindValue#of(String)}.
   *
   * <p>Method under test: {@link BookmarkKindValue#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BookmarkKindValue BookmarkKindValue.of(String)"})
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", BookmarkKindValue.of("42").value());
  }

  /**
   * Test {@link BookmarkKindValue#value()}.
   *
   * <p>Method under test: {@link BookmarkKindValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BookmarkKindValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", BookmarkKindValue.of("42").value());
  }
}
