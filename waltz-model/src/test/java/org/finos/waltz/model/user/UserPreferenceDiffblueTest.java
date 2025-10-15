package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserPreferenceDiffblueTest {
  /**
   * Test {@link UserPreference#mkPref(String, String)}.
   *
   * <p>Method under test: {@link UserPreference#mkPref(String, String)}
   */
  @Test
  @DisplayName("Test mkPref(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserPreference UserPreference.mkPref(String, String)"})
  void testMkPref() {
    // Arrange and Act
    UserPreference actualMkPrefResult = UserPreference.mkPref("Key", "42");

    // Assert
    assertTrue(actualMkPrefResult instanceof ImmutableUserPreference);
    assertEquals("42", actualMkPrefResult.value());
    assertEquals("Key", actualMkPrefResult.key());
  }
}
