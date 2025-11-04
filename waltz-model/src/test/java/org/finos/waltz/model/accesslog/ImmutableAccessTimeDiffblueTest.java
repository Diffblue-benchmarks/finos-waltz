package org.finos.waltz.model.accesslog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ImmutableAccessTimeDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAccessTime.Builder#createdAt(LocalDateTime)}
   */
  @Test
  void testBuilderCreatedAt() {
    // Arrange
    ImmutableAccessTime.Builder builderResult = ImmutableAccessTime.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableAccessTime.Builder#from(AccessTime)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAccessTime.Builder builderResult = ImmutableAccessTime.builder();
    AccessTime instance = mock(AccessTime.class);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.userId()).thenReturn("42");

    // Act
    ImmutableAccessTime.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).userId();
    assertEquals("42", builderResult.build().userId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAccessTime.Builder#from(AccessTime)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAccessTime.Builder builderResult = ImmutableAccessTime.builder();
    AccessTime instance = mock(AccessTime.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).userId();
  }

  /**
   * Method under test: {@link ImmutableAccessTime.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableAccessTime.Builder builderResult = ImmutableAccessTime.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test: {@link ImmutableAccessTime#copyOf(AccessTime)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AccessTime instance = mock(AccessTime.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.userId()).thenReturn("42");

    // Act
    ImmutableAccessTime actualCopyOfResult = ImmutableAccessTime.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).userId();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.userId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAccessTime#fromJson(ImmutableAccessTime.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAccessTime.Json json = new ImmutableAccessTime.Json();
    json.setUserId("Json");
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableAccessTime actualFromJsonResult = ImmutableAccessTime.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
  }

  /**
   * Method under test: {@link ImmutableAccessTime.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAccessTime.Json()).createdAt());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableAccessTime.Json}
   *   <li>{@link ImmutableAccessTime.Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAccessTime.Json#setUserId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAccessTime.Json actualJson = new ImmutableAccessTime.Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setUserId("42");

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAccessTime.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAccessTime.Json()).userId());
  }
}
