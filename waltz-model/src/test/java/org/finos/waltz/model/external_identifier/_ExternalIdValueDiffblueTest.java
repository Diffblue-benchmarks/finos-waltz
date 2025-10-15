package org.finos.waltz.model.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class _ExternalIdValueDiffblueTest {
  /**
   * Test {@link _ExternalIdValue#ofNullable(String)}.
   *
   * <p>Method under test: {@link _ExternalIdValue#ofNullable(String)}
   */
  @Test
  @DisplayName("Test ofNullable(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional _ExternalIdValue.ofNullable(String)"})
  void testOfNullable() {
    // Arrange and Act
    Optional<ExternalIdValue> actualOfNullableResult = _ExternalIdValue.ofNullable("Str");

    // Assert
    assertEquals("Str", actualOfNullableResult.get().value());
    assertTrue(actualOfNullableResult.isPresent());
  }

  /**
   * Test {@link _ExternalIdValue#orElse(Optional, String)}.
   *
   * <p>Method under test: {@link _ExternalIdValue#orElse(Optional, String)}
   */
  @Test
  @DisplayName("Test orElse(Optional, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String _ExternalIdValue.orElse(Optional, String)"})
  void testOrElse() {
    // Arrange
    Optional<ExternalIdValue> extId = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals("42", _ExternalIdValue.orElse(extId, "Dflt"));
  }
}
