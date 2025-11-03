package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DateTimeUtilitiesDiffblueTest {
  /**
   * Test {@link DateTimeUtilities#toSqlDate(Date)} with {@code date}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toSqlDate(Date)}
   */
  @Test
  @DisplayName("Test toSqlDate(Date) with 'date'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.sql.Date DateTimeUtilities.toSqlDate(Date)"})
  void testToSqlDateWithDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toSqlDate((Date) null));
  }

  /**
   * Test {@link DateTimeUtilities#toSqlDate(LocalDate)} with {@code localDate}.
   * <p>
   * Method under test: {@link DateTimeUtilities#toSqlDate(LocalDate)}
   */
  @Test
  @DisplayName("Test toSqlDate(LocalDate) with 'localDate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.sql.Date DateTimeUtilities.toSqlDate(LocalDate)"})
  void testToSqlDateWithLocalDate() {
    // Arrange and Act
    java.sql.Date actualToSqlDateResult = DateTimeUtilities.toSqlDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualToSqlDateResult));
  }

  /**
   * Test {@link DateTimeUtilities#toSqlDate(LocalDate)} with {@code localDate}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toSqlDate(LocalDate)}
   */
  @Test
  @DisplayName("Test toSqlDate(LocalDate) with 'localDate'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.sql.Date DateTimeUtilities.toSqlDate(LocalDate)"})
  void testToSqlDateWithLocalDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toSqlDate((LocalDate) null));
  }

  /**
   * Test {@link DateTimeUtilities#toSqlTimestamp(LocalDateTime)}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd} format is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toSqlTimestamp(LocalDateTime)}
   */
  @Test
  @DisplayName("Test toSqlTimestamp(LocalDateTime); then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Timestamp DateTimeUtilities.toSqlTimestamp(LocalDateTime)"})
  void testToSqlTimestamp_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19700101() {
    // Arrange and Act
    Timestamp actualToSqlTimestampResult = DateTimeUtilities.toSqlTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualToSqlTimestampResult));
  }

  /**
   * Test {@link DateTimeUtilities#toSqlTimestamp(LocalDateTime)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toSqlTimestamp(LocalDateTime)}
   */
  @Test
  @DisplayName("Test toSqlTimestamp(LocalDateTime); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Timestamp DateTimeUtilities.toSqlTimestamp(LocalDateTime)"})
  void testToSqlTimestamp_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toSqlTimestamp(null));
  }

  /**
   * Test {@link DateTimeUtilities#toLocalDate(Date)} with {@code date}.
   * <ul>
   *   <li>Then return toString is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toLocalDate(Date)}
   */
  @Test
  @DisplayName("Test toLocalDate(Date) with 'date'; then return toString is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate DateTimeUtilities.toLocalDate(Date)"})
  void testToLocalDateWithDate_thenReturnToStringIs19700101() {
    // Arrange, Act and Assert
    assertEquals("1970-01-01",
        DateTimeUtilities
            .toLocalDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .toString());
  }

  /**
   * Test {@link DateTimeUtilities#toLocalDate(Date)} with {@code date}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toLocalDate(Date)}
   */
  @Test
  @DisplayName("Test toLocalDate(Date) with 'date'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate DateTimeUtilities.toLocalDate(Date)"})
  void testToLocalDateWithDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toLocalDate((Date) null));
  }

  /**
   * Test {@link DateTimeUtilities#toLocalDate(Timestamp)} with {@code timestamp}.
   * <ul>
   *   <li>Then return toString is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toLocalDate(Timestamp)}
   */
  @Test
  @DisplayName("Test toLocalDate(Timestamp) with 'timestamp'; then return toString is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate DateTimeUtilities.toLocalDate(Timestamp)"})
  void testToLocalDateWithTimestamp_thenReturnToStringIs19700101() {
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
   * Test {@link DateTimeUtilities#toLocalDate(Timestamp)} with {@code timestamp}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toLocalDate(Timestamp)}
   */
  @Test
  @DisplayName("Test toLocalDate(Timestamp) with 'timestamp'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate DateTimeUtilities.toLocalDate(Timestamp)"})
  void testToLocalDateWithTimestamp_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toLocalDate((Timestamp) null));
  }

  /**
   * Test {@link DateTimeUtilities#toLocalDateTime(Date)}.
   * <ul>
   *   <li>Then return toLocalTime toString is {@code 00:00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toLocalDateTime(Date)}
   */
  @Test
  @DisplayName("Test toLocalDateTime(Date); then return toLocalTime toString is '00:00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime DateTimeUtilities.toLocalDateTime(Date)"})
  void testToLocalDateTime_thenReturnToLocalTimeToStringIs0000() {
    // Arrange and Act
    LocalDateTime actualToLocalDateTimeResult = DateTimeUtilities
        .toLocalDateTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("00:00", actualToLocalDateTimeResult.toLocalTime().toString());
    assertEquals("1970-01-01", actualToLocalDateTimeResult.toLocalDate().toString());
  }

  /**
   * Test {@link DateTimeUtilities#toLocalDateTime(Date)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeUtilities#toLocalDateTime(Date)}
   */
  @Test
  @DisplayName("Test toLocalDateTime(Date); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime DateTimeUtilities.toLocalDateTime(Date)"})
  void testToLocalDateTime_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DateTimeUtilities.toLocalDateTime(null));
  }
}
