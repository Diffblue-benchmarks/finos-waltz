package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ImmutableUserTimestampDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUserTimestamp#builder()}
   *   <li>{@link ImmutableUserTimestamp#at(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableUserTimestamp.Builder actualBuilderResult = ImmutableUserTimestamp.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.at(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableUserTimestamp.Builder#by(String)}
   */
  @Test
  void testBuilderBy() {
    // Arrange
    ImmutableUserTimestamp.Builder builderResult = ImmutableUserTimestamp.builder();

    // Act
    ImmutableUserTimestamp.Builder actualByResult = builderResult.by("By");

    // Assert
    assertEquals("By", actualByResult.build().by());
    assertEquals("By", builderResult.build().by());
    assertSame(builderResult, actualByResult);
  }

  /**
   * Method under test: {@link ImmutableUserTimestamp.Builder#from(UserTimestamp)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUserTimestamp.Builder builderResult = ImmutableUserTimestamp.builder();
    UserTimestamp instance = mock(UserTimestamp.class);
    when(instance.by()).thenReturn("By");
    when(instance.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableUserTimestamp.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).at();
    verify(instance).by();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ImmutableUserTimestamp buildResult = builderResult.build();
    assertEquals("1970-01-01", simpleDateFormat.format(buildResult.atTimestamp()));
    assertEquals("By", buildResult.by());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableUserTimestamp.Builder#from(UserTimestamp)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUserTimestamp.Builder builderResult = ImmutableUserTimestamp.builder();
    UserTimestamp instance = mock(UserTimestamp.class);
    when(instance.by()).thenThrow(new IllegalStateException("instance"));
    when(instance.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).at();
    verify(instance).by();
  }

  /**
   * Method under test: {@link ImmutableUserTimestamp#copyOf(UserTimestamp)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UserTimestamp instance = mock(UserTimestamp.class);
    when(instance.by()).thenReturn("By");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.at()).thenReturn(ofResult.atStartOfDay());

    // Act
    ImmutableUserTimestamp actualCopyOfResult = ImmutableUserTimestamp.copyOf(instance);

    // Assert
    verify(instance).at();
    verify(instance).by();
    LocalDateTime atResult = actualCopyOfResult.at();
    assertEquals("00:00", atResult.toLocalTime().toString());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("1970-01-01", simpleDateFormat.format(actualCopyOfResult.atTimestamp()));
    LocalDate toLocalDateResult = atResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("By", actualCopyOfResult.by());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUserTimestamp#fromJson(ImmutableUserTimestamp.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUserTimestamp.Json json = new ImmutableUserTimestamp.Json();
    json.setAt(null);
    json.setBy("Json");

    // Act and Assert
    assertEquals("Json", ImmutableUserTimestamp.fromJson(json).by());
  }

  /**
   * Method under test:
   * {@link ImmutableUserTimestamp#fromJson(ImmutableUserTimestamp.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableUserTimestamp.Json json = new ImmutableUserTimestamp.Json();
    json.setAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setBy("Json");

    // Act
    ImmutableUserTimestamp actualFromJsonResult = ImmutableUserTimestamp.fromJson(json);

    // Assert
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("1970-01-01", simpleDateFormat.format(actualFromJsonResult.atTimestamp()));
    assertEquals("Json", actualFromJsonResult.by());
    LocalDateTime expectedAtResult = json.at;
    assertSame(expectedAtResult, actualFromJsonResult.at());
  }

  /**
   * Method under test: {@link ImmutableUserTimestamp.Json#at()}
   */
  @Test
  void testJsonAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserTimestamp.Json()).at());
  }

  /**
   * Method under test: {@link ImmutableUserTimestamp.Json#atTimestamp()}
   */
  @Test
  void testJsonAtTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserTimestamp.Json()).atTimestamp());
  }

  /**
   * Method under test: {@link ImmutableUserTimestamp.Json#by()}
   */
  @Test
  void testJsonBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserTimestamp.Json()).by());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUserTimestamp.Json}
   *   <li>{@link ImmutableUserTimestamp.Json#setAt(LocalDateTime)}
   *   <li>{@link ImmutableUserTimestamp.Json#setBy(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUserTimestamp.Json actualJson = new ImmutableUserTimestamp.Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setAt(ofResult.atStartOfDay());
    actualJson.setBy("By");

    // Assert
    LocalDateTime localDateTime = actualJson.at;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }
}
