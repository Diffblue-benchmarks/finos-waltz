package org.finos.waltz.model.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class _ExternalIdValueDiffblueTest {
  /**
   * Method under test: {@link _ExternalIdValue#ofNullable(String)}
   */
  @Test
  void testOfNullable() {
    // Arrange and Act
    Optional<ExternalIdValue> actualOfNullableResult = _ExternalIdValue.ofNullable("Str");

    // Assert
    assertEquals("Str", actualOfNullableResult.get().value());
    assertTrue(actualOfNullableResult.isPresent());
  }

  /**
   * Method under test: {@link _ExternalIdValue#orElse(Optional, String)}
   */
  @Test
  void testOrElse() {
    // Arrange
    Optional<ExternalIdValue> extId = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals("42", _ExternalIdValue.orElse(extId, "Dflt"));
  }
}
