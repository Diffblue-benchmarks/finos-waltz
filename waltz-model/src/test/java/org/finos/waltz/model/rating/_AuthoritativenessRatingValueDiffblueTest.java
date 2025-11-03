package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class _AuthoritativenessRatingValueDiffblueTest {
  /**
   * Test {@link _AuthoritativenessRatingValue#ofNullable(String)}.
   * <p>
   * Method under test: {@link _AuthoritativenessRatingValue#ofNullable(String)}
   */
  @Test
  @DisplayName("Test ofNullable(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional _AuthoritativenessRatingValue.ofNullable(String)"})
  void testOfNullable() {
    // Arrange and Act
    Optional<AuthoritativenessRatingValue> actualOfNullableResult = _AuthoritativenessRatingValue.ofNullable("Str");

    // Assert
    assertEquals("Str", actualOfNullableResult.get().value());
    assertTrue(actualOfNullableResult.isPresent());
  }

  /**
   * Test {@link _AuthoritativenessRatingValue#orElse(Optional, String)}.
   * <ul>
   *   <li>When {@link AuthoritativenessRatingValue} with value is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link _AuthoritativenessRatingValue#orElse(Optional, String)}
   */
  @Test
  @DisplayName("Test orElse(Optional, String); when AuthoritativenessRatingValue with value is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String _AuthoritativenessRatingValue.orElse(Optional, String)"})
  void testOrElse_whenAuthoritativenessRatingValueWithValueIs42_thenReturn42() {
    // Arrange
    Optional<AuthoritativenessRatingValue> ratingStr = Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals("42", _AuthoritativenessRatingValue.orElse(ratingStr, "Dflt"));
  }

  /**
   * Test {@link _AuthoritativenessRatingValue#orElse(Optional, String)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return {@code Dflt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link _AuthoritativenessRatingValue#orElse(Optional, String)}
   */
  @Test
  @DisplayName("Test orElse(Optional, String); when empty; then return 'Dflt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String _AuthoritativenessRatingValue.orElse(Optional, String)"})
  void testOrElse_whenEmpty_thenReturnDflt() {
    // Arrange
    Optional<AuthoritativenessRatingValue> ratingStr = Optional.empty();

    // Act and Assert
    assertEquals("Dflt", _AuthoritativenessRatingValue.orElse(ratingStr, "Dflt"));
  }
}
