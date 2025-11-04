package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUserPreferenceDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUserPreference.Builder#from(UserPreference)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUserPreference.Builder builderResult = ImmutableUserPreference.builder();
    UserPreference instance = mock(UserPreference.class);
    when(instance.value()).thenReturn("42");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableUserPreference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).value();
    ImmutableUserPreference buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Key", buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUserPreference.Builder#from(UserPreference)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUserPreference.Builder builderResult = ImmutableUserPreference.builder();
    UserPreference instance = mock(UserPreference.class);
    when(instance.value()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).key();
    verify(instance).value();
  }

  /**
   * Method under test: {@link ImmutableUserPreference.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableUserPreference.Builder builderResult = ImmutableUserPreference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test: {@link ImmutableUserPreference.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableUserPreference.Builder builderResult = ImmutableUserPreference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test: {@link ImmutableUserPreference#copyOf(UserPreference)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UserPreference instance = mock(UserPreference.class);
    when(instance.value()).thenReturn("42");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableUserPreference actualCopyOfResult = ImmutableUserPreference.copyOf(instance);

    // Assert
    verify(instance).key();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Key", actualCopyOfResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableUserPreference#fromJson(ImmutableUserPreference.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUserPreference.Json json = new ImmutableUserPreference.Json();
    json.setKey("Json");
    json.setValue("Json");

    // Act
    ImmutableUserPreference actualFromJsonResult = ImmutableUserPreference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUserPreference.Json}
   *   <li>{@link ImmutableUserPreference.Json#setKey(String)}
   *   <li>{@link ImmutableUserPreference.Json#setValue(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUserPreference.Json actualJson = new ImmutableUserPreference.Json();
    actualJson.setKey("Key");
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals("Key", actualJson.key);
  }

  /**
   * Method under test: {@link ImmutableUserPreference.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserPreference.Json()).key());
  }

  /**
   * Method under test: {@link ImmutableUserPreference.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserPreference.Json()).value());
  }
}
