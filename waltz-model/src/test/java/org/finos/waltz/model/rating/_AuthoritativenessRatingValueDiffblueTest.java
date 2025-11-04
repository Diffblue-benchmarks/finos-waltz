package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class _AuthoritativenessRatingValueDiffblueTest {
  /**
   * Method under test: {@link _AuthoritativenessRatingValue#ofNullable(String)}
   */
  @Test
  void testOfNullable() {
    // Arrange and Act
    Optional<AuthoritativenessRatingValue> actualOfNullableResult = _AuthoritativenessRatingValue.ofNullable("Str");

    // Assert
    assertEquals("Str", actualOfNullableResult.get().value());
    assertTrue(actualOfNullableResult.isPresent());
  }

  /**
   * Method under test:
   * {@link _AuthoritativenessRatingValue#orElse(Optional, String)}
   */
  @Test
  void testOrElse() {
    // Arrange
    Optional<AuthoritativenessRatingValue> ratingStr = Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals("42", _AuthoritativenessRatingValue.orElse(ratingStr, "Dflt"));
  }

  /**
   * Method under test:
   * {@link _AuthoritativenessRatingValue#orElse(Optional, String)}
   */
  @Test
  void testOrElse2() {
    // Arrange
    Optional<AuthoritativenessRatingValue> ratingStr = Optional.empty();

    // Act and Assert
    assertEquals("Dflt", _AuthoritativenessRatingValue.orElse(ratingStr, "Dflt"));
  }
}
