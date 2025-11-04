package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;

class DateTimeUtilitiesDiffblueTest {
  /**
   * Method under test: {@link DateTimeUtilities#toSqlDate(LocalDate)}
   */
  @Test
  void testToSqlDate() {
    // Arrange and Act
    java.sql.Date actualToSqlDateResult = DateTimeUtilities.toSqlDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualToSqlDateResult));
  }

  /**
   * Method under test: {@link DateTimeUtilities#toSqlDate(LocalDate)}
   */
  @Test
  void testToSqlDate2() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toSqlDate((LocalDate) null));
  }

  /**
   * Method under test: {@link DateTimeUtilities#toSqlDate(java.util.Date)}
   */
  @Test
  void testToSqlDate3() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toSqlDate((java.util.Date) null));
  }

  /**
   * Method under test: {@link DateTimeUtilities#toSqlDate(java.util.Date)}
   */
  @Test
  void testToSqlDate4() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    DateTimeUtilities.toSqlDate(date);

    // Assert
    verify(date).getTime();
  }

  /**
   * Method under test: {@link DateTimeUtilities#toSqlTimestamp(LocalDateTime)}
   */
  @Test
  void testToSqlTimestamp() {
    // Arrange and Act
    Timestamp actualToSqlTimestampResult = DateTimeUtilities.toSqlTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualToSqlTimestampResult));
  }

  /**
   * Method under test: {@link DateTimeUtilities#toSqlTimestamp(LocalDateTime)}
   */
  @Test
  void testToSqlTimestamp2() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toSqlTimestamp(null));
  }

  /**
   * Method under test: {@link DateTimeUtilities#toLocalDate(Timestamp)}
   */
  @Test
  void testToLocalDate() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toLocalDate((Timestamp) null));
    assertEquals("1970-01-01",
        DateTimeUtilities
            .toLocalDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .toString());
    assertNull(DateTimeUtilities.toLocalDate((Date) null));
  }

  /**
   * Method under test: {@link DateTimeUtilities#toLocalDate(Timestamp)}
   */
  @Test
  void testToLocalDate2() {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    LocalDate actualToLocalDateResult = DateTimeUtilities.toLocalDate(timestamp);

    // Assert
    verify(timestamp).toLocalDateTime();
    assertEquals("1970-01-01", actualToLocalDateResult.toString());
  }

  /**
   * Method under test: {@link DateTimeUtilities#toLocalDate(java.util.Date)}
   */
  @Test
  void testToLocalDate3() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    LocalDate actualToLocalDateResult = DateTimeUtilities.toLocalDate(date);

    // Assert
    verify(date).getTime();
    assertEquals("1970-01-01", actualToLocalDateResult.toString());
  }

  /**
   * Method under test: {@link DateTimeUtilities#toLocalDateTime(Date)}
   */
  @Test
  void testToLocalDateTime() {
    // Arrange and Act
    LocalDateTime actualToLocalDateTimeResult = DateTimeUtilities
        .toLocalDateTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("00:00", actualToLocalDateTimeResult.toLocalTime().toString());
    assertEquals("1970-01-01", actualToLocalDateTimeResult.toLocalDate().toString());
  }

  /**
   * Method under test: {@link DateTimeUtilities#toLocalDateTime(Date)}
   */
  @Test
  void testToLocalDateTime2() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toLocalDateTime(null));
  }

  /**
   * Method under test: {@link DateTimeUtilities#toLocalDateTime(java.util.Date)}
   */
  @Test
  void testToLocalDateTime3() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    LocalDateTime actualToLocalDateTimeResult = DateTimeUtilities.toLocalDateTime(date);

    // Assert
    verify(date).getTime();
    assertEquals("00:00:00.010", actualToLocalDateTimeResult.toLocalTime().toString());
    assertEquals("1970-01-01", actualToLocalDateTimeResult.toLocalDate().toString());
  }
}
