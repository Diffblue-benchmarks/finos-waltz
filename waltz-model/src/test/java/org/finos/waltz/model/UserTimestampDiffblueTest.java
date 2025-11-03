package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * <p>
   * Method under test: {@link UserTimestamp#mkForUser(String)}
   */
  @Test
  @DisplayName("Test mkForUser(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserTimestamp UserTimestamp.mkForUser(String)"})
  void testMkForUserWithString() {
    // Arrange and Act
    UserTimestamp actualMkForUserResult = UserTimestamp.mkForUser("janedoe");

    // Assert
    assertTrue(actualMkForUserResult instanceof ImmutableUserTimestamp);
    assertEquals("janedoe", actualMkForUserResult.by());
  }

  /**
   * Test {@link UserTimestamp#mkForUser(String, LocalDateTime)} with {@code String}, {@code LocalDateTime}.
   * <p>
   * Method under test: {@link UserTimestamp#mkForUser(String, LocalDateTime)}
   */
  @Test
  @DisplayName("Test mkForUser(String, LocalDateTime) with 'String', 'LocalDateTime'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserTimestamp UserTimestamp.mkForUser(String, LocalDateTime)"})
  void testMkForUserWithStringLocalDateTime() {
    // Arrange
    LocalDateTime at = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    UserTimestamp actualMkForUserResult = UserTimestamp.mkForUser("janedoe", at);

    // Assert
    assertTrue(actualMkForUserResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("1970-01-01", simpleDateFormat.format(actualMkForUserResult.atTimestamp()));
    assertEquals("janedoe", actualMkForUserResult.by());
    assertSame(at, actualMkForUserResult.at());
  }

  /**
   * Test {@link UserTimestamp#mkForUser(String, Timestamp)} with {@code String}, {@code Timestamp}.
   * <p>
   * Method under test: {@link UserTimestamp#mkForUser(String, Timestamp)}
   */
  @Test
  @DisplayName("Test mkForUser(String, Timestamp) with 'String', 'Timestamp'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserTimestamp UserTimestamp.mkForUser(String, Timestamp)"})
  void testMkForUserWithStringTimestamp() {
    // Arrange
    Timestamp at = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(at.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());

    // Act
    UserTimestamp actualMkForUserResult = UserTimestamp.mkForUser("janedoe", at);

    // Assert
    verify(at).toLocalDateTime();
    assertTrue(actualMkForUserResult instanceof ImmutableUserTimestamp);
    LocalDateTime atResult = actualMkForUserResult.at();
    assertEquals("00:00", atResult.toLocalTime().toString());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("1970-01-01", simpleDateFormat.format(actualMkForUserResult.atTimestamp()));
    LocalDate toLocalDateResult = atResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("janedoe", actualMkForUserResult.by());
    assertSame(ofResult, toLocalDateResult);
  }
}
