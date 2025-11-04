package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class UserPreferenceDiffblueTest {
  /**
   * Method under test: {@link UserPreference#mkPref(String, String)}
   */
  @Test
  void testMkPref() {
    // Arrange and Act
    UserPreference actualMkPrefResult = UserPreference.mkPref("Key", "42");

    // Assert
    assertTrue(actualMkPrefResult instanceof ImmutableUserPreference);
    assertEquals("42", actualMkPrefResult.value());
    assertEquals("Key", actualMkPrefResult.key());
  }
}
