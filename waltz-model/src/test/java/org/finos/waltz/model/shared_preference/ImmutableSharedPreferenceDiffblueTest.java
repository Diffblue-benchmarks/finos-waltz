package org.finos.waltz.model.shared_preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.LastUpdatedProvider;
import org.junit.jupiter.api.Test;

class ImmutableSharedPreferenceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSharedPreference#builder()}
   *   <li>{@link ImmutableSharedPreference#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSharedPreference.Builder actualBuilderResult = ImmutableSharedPreference.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableSharedPreference.Builder#category(String)}
   */
  @Test
  void testBuilderCategory() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category("Category"));
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreference.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableSharedPreference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreference.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreference.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreference.Builder#from(SharedPreference)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();
    SharedPreference instance = mock(SharedPreference.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.key()).thenReturn("Key");
    when(instance.value()).thenReturn("42");
    when(instance.category()).thenReturn("Category");

    // Act
    ImmutableSharedPreference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).category();
    verify(instance).key();
    verify(instance).value();
    ImmutableSharedPreference buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.value());
    assertEquals("Category", buildResult.category());
    assertEquals("Key", buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreference.Builder#from(SharedPreference)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();
    SharedPreference instance = mock(SharedPreference.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.key()).thenReturn("Key");
    when(instance.value()).thenReturn("42");
    when(instance.category()).thenReturn("Category");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).category();
    verify(instance).key();
    verify(instance).value();
  }

  /**
   * Method under test: {@link ImmutableSharedPreference.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreference.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableSharedPreference.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableSharedPreference.Builder builderResult = ImmutableSharedPreference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test: {@link ImmutableSharedPreference#copyOf(SharedPreference)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SharedPreference instance = mock(SharedPreference.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.key()).thenReturn("Key");
    when(instance.value()).thenReturn("42");
    when(instance.category()).thenReturn("Category");

    // Act
    ImmutableSharedPreference actualCopyOfResult = ImmutableSharedPreference.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).category();
    verify(instance).key();
    verify(instance).value();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Category", actualCopyOfResult.category());
    assertEquals("Key", actualCopyOfResult.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreference#fromJson(ImmutableSharedPreference.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSharedPreference.Json json = new ImmutableSharedPreference.Json();
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setKey("Json");
    json.setCategory("Json");
    json.setValue("Json");

    // Act
    ImmutableSharedPreference actualFromJsonResult = ImmutableSharedPreference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.category());
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreference#fromJson(ImmutableSharedPreference.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableSharedPreference.Json json = new ImmutableSharedPreference.Json();
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setKey("Json");
    json.setCategory("Json");
    json.setValue("Json");

    // Act
    ImmutableSharedPreference actualFromJsonResult = ImmutableSharedPreference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.category());
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.value());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableSharedPreference.Json#category()}
   */
  @Test
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSharedPreference.Json()).category());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSharedPreference.Json}
   *   <li>{@link ImmutableSharedPreference.Json#setCategory(String)}
   *   <li>{@link ImmutableSharedPreference.Json#setKey(String)}
   *   <li>{@link ImmutableSharedPreference.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableSharedPreference.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableSharedPreference.Json#setValue(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSharedPreference.Json actualJson = new ImmutableSharedPreference.Json();
    actualJson.setCategory("Category");
    actualJson.setKey("Key");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setValue("42");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableSharedPreference.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSharedPreference.Json()).key());
  }

  /**
   * Method under test: {@link ImmutableSharedPreference.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSharedPreference.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableSharedPreference.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSharedPreference.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableSharedPreference.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSharedPreference.Json()).value());
  }
}
