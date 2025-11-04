package org.finos.waltz.model.bookmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class BookmarkKindValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BookmarkKindValue#equals(Object)}
   *   <li>{@link BookmarkKindValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BookmarkKindValue ofResult = BookmarkKindValue.of("42");
    BookmarkKindValue ofResult2 = BookmarkKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BookmarkKindValue#equals(Object)}
   *   <li>{@link BookmarkKindValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BookmarkKindValue ofResult = BookmarkKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link BookmarkKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BookmarkKindValue ofResult = BookmarkKindValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, BookmarkKindValue.of("42"));
  }

  /**
   * Method under test: {@link BookmarkKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BookmarkKindValue.of("42"), null);
  }

  /**
   * Method under test: {@link BookmarkKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BookmarkKindValue.of("42"), "Different type to BookmarkKindValue");
  }

  /**
   * Method under test: {@link BookmarkKindValue#of(String)}
   */
  @Test
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", BookmarkKindValue.of("42").value());
  }

  /**
   * Method under test: {@link BookmarkKindValue#value()}
   */
  @Test
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", BookmarkKindValue.of("42").value());
  }
}
