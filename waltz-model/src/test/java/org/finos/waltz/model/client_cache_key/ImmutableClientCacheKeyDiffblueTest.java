package org.finos.waltz.model.client_cache_key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ImmutableClientCacheKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableClientCacheKey#builder()}
   *   <li>{@link ImmutableClientCacheKey#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableClientCacheKey.Builder actualBuilderResult = ImmutableClientCacheKey.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableClientCacheKey.Builder#from(ClientCacheKey)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableClientCacheKey.Builder builderResult = ImmutableClientCacheKey.builder();
    ClientCacheKey instance = mock(ClientCacheKey.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.guid()).thenReturn("1234");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableClientCacheKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).guid();
    verify(instance).key();
    verify(instance).lastUpdatedAt();
    ImmutableClientCacheKey buildResult = builderResult.build();
    assertEquals("1234", buildResult.guid());
    assertEquals("Key", buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableClientCacheKey.Builder#from(ClientCacheKey)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableClientCacheKey.Builder builderResult = ImmutableClientCacheKey.builder();
    ClientCacheKey instance = mock(ClientCacheKey.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.guid()).thenReturn("1234");
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).guid();
    verify(instance).key();
    verify(instance).lastUpdatedAt();
  }

  /**
   * Method under test: {@link ImmutableClientCacheKey.Builder#guid(String)}
   */
  @Test
  void testBuilderGuid() {
    // Arrange
    ImmutableClientCacheKey.Builder builderResult = ImmutableClientCacheKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.guid("1234"));
  }

  /**
   * Method under test: {@link ImmutableClientCacheKey.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableClientCacheKey.Builder builderResult = ImmutableClientCacheKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test: {@link ImmutableClientCacheKey#copyOf(ClientCacheKey)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ClientCacheKey instance = mock(ClientCacheKey.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.guid()).thenReturn("1234");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableClientCacheKey actualCopyOfResult = ImmutableClientCacheKey.copyOf(instance);

    // Assert
    verify(instance).guid();
    verify(instance).key();
    verify(instance).lastUpdatedAt();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1234", actualCopyOfResult.guid());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Key", actualCopyOfResult.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableClientCacheKey#fromJson(ImmutableClientCacheKey.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableClientCacheKey.Json json = new ImmutableClientCacheKey.Json();
    json.setKey("Json");
    json.setGuid("Json");
    json.setLastUpdatedAt(null);

    // Act
    ImmutableClientCacheKey actualFromJsonResult = ImmutableClientCacheKey.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.guid());
    assertEquals("Json", actualFromJsonResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableClientCacheKey#fromJson(ImmutableClientCacheKey.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableClientCacheKey.Json json = new ImmutableClientCacheKey.Json();
    json.setKey("Json");
    json.setGuid("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableClientCacheKey actualFromJsonResult = ImmutableClientCacheKey.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.guid());
    assertEquals("Json", actualFromJsonResult.key());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableClientCacheKey.Json}
   *   <li>{@link ImmutableClientCacheKey.Json#setGuid(String)}
   *   <li>{@link ImmutableClientCacheKey.Json#setKey(String)}
   *   <li>{@link ImmutableClientCacheKey.Json#setLastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableClientCacheKey.Json actualJson = new ImmutableClientCacheKey.Json();
    actualJson.setGuid("1234");
    actualJson.setKey("Key");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableClientCacheKey.Json#guid()}
   */
  @Test
  void testJsonGuid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableClientCacheKey.Json()).guid());
  }

  /**
   * Method under test: {@link ImmutableClientCacheKey.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableClientCacheKey.Json()).key());
  }

  /**
   * Method under test: {@link ImmutableClientCacheKey.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableClientCacheKey.Json()).lastUpdatedAt());
  }
}
