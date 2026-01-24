package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserTimestampDiffblueTest {
  /**
   * Test {@link UserTimestamp#mkForUser(String)} with {@code String}.
   *
   * <p>Method under test: {@link UserTimestamp#mkForUser(String)}
   */
  @Test
  @DisplayName("Test mkForUser(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserTimestamp UserTimestamp.mkForUser(String)"})
  void testMkForUserWithString() {
    // Arrange and Act
    UserTimestamp actualMkForUserResult = UserTimestamp.mkForUser("janedoe");

    // Assert
    assertTrue(actualMkForUserResult instanceof ImmutableUserTimestamp);
    assertEquals("janedoe", actualMkForUserResult.by());
  }

  /**
   * Test {@link UserTimestamp#mkForUser(String, LocalDateTime)} with {@code String}, {@code
   * LocalDateTime}.
   *
   * <p>Method under test: {@link UserTimestamp#mkForUser(String, LocalDateTime)}
   */
  @Test
  @DisplayName("Test mkForUser(String, LocalDateTime) with 'String', 'LocalDateTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserTimestamp UserTimestamp.mkForUser(String, LocalDateTime)"})
  void testMkForUserWithStringLocalDateTime() {
    // Arrange
    LocalDateTime at = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    UserTimestamp actualMkForUserResult = UserTimestamp.mkForUser("janedoe", at);

    // Assert
    assertTrue(actualMkForUserResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(actualMkForUserResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("janedoe", actualMkForUserResult.by());
    assertSame(at, actualMkForUserResult.at());
  }

  /**
   * Test {@link UserTimestamp#mkForUser(String, Timestamp)} with {@code String}, {@code Timestamp}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableUserTimestamp}.
   * </ul>
   *
   * <p>Method under test: {@link UserTimestamp#mkForUser(String, Timestamp)}
   */
  @Test
  @DisplayName(
      "Test mkForUser(String, Timestamp) with 'String', 'Timestamp'; then return ImmutableUserTimestamp")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserTimestamp UserTimestamp.mkForUser(String, Timestamp)"})
  void testMkForUserWithStringTimestamp_thenReturnImmutableUserTimestamp() {
    // Arrange and Act
    UserTimestamp actualMkForUserResult = UserTimestamp.mkForUser("janedoe", new Timestamp(1L));

    // Assert
    assertTrue(actualMkForUserResult instanceof ImmutableUserTimestamp);
    assertEquals("janedoe", actualMkForUserResult.by());
  }
}
