package org.finos.waltz.model.shared_preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSharedPreferenceSaveCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceSaveCommand.Builder#category(String)}
   */
  @Test
  void testBuilderCategory() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand.Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category("Category"));
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceSaveCommand.Builder#from(SharedPreferenceSaveCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand.Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();
    SharedPreferenceSaveCommand instance = mock(SharedPreferenceSaveCommand.class);
    when(instance.value()).thenReturn("42");
    when(instance.category()).thenReturn("Category");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableSharedPreferenceSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).category();
    verify(instance).key();
    verify(instance).value();
    ImmutableSharedPreferenceSaveCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Category", buildResult.category());
    assertEquals("Key", buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceSaveCommand.Builder#from(SharedPreferenceSaveCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand.Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();
    SharedPreferenceSaveCommand instance = mock(SharedPreferenceSaveCommand.class);
    when(instance.value()).thenThrow(new IllegalStateException("instance"));
    when(instance.category()).thenReturn("Category");
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).category();
    verify(instance).key();
    verify(instance).value();
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceSaveCommand.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand.Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceSaveCommand.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand.Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceSaveCommand#copyOf(SharedPreferenceSaveCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SharedPreferenceSaveCommand instance = mock(SharedPreferenceSaveCommand.class);
    when(instance.value()).thenReturn("42");
    when(instance.category()).thenReturn("Category");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableSharedPreferenceSaveCommand actualCopyOfResult = ImmutableSharedPreferenceSaveCommand.copyOf(instance);

    // Assert
    verify(instance).category();
    verify(instance).key();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Category", actualCopyOfResult.category());
    assertEquals("Key", actualCopyOfResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceSaveCommand#fromJson(ImmutableSharedPreferenceSaveCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand.Json json = new ImmutableSharedPreferenceSaveCommand.Json();
    json.setKey("Json");
    json.setCategory("Json");
    json.setValue("Json");

    // Act
    ImmutableSharedPreferenceSaveCommand actualFromJsonResult = ImmutableSharedPreferenceSaveCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.category());
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceSaveCommand.Json#category()}
   */
  @Test
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSharedPreferenceSaveCommand.Json()).category());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSharedPreferenceSaveCommand.Json}
   *   <li>{@link ImmutableSharedPreferenceSaveCommand.Json#setCategory(String)}
   *   <li>{@link ImmutableSharedPreferenceSaveCommand.Json#setKey(String)}
   *   <li>{@link ImmutableSharedPreferenceSaveCommand.Json#setValue(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSharedPreferenceSaveCommand.Json actualJson = new ImmutableSharedPreferenceSaveCommand.Json();
    actualJson.setCategory("Category");
    actualJson.setKey("Key");
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals("Category", actualJson.category);
    assertEquals("Key", actualJson.key);
  }

  /**
   * Method under test: {@link ImmutableSharedPreferenceSaveCommand.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSharedPreferenceSaveCommand.Json()).key());
  }

  /**
   * Method under test: {@link ImmutableSharedPreferenceSaveCommand.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSharedPreferenceSaveCommand.Json()).value());
  }
}
