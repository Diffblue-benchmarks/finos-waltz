package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableEntryDiffblueTest {
  /**
   * Method under test: {@link ImmutableEntry.Builder#from(Entry)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntry.Builder<Object, Object> builderResult = ImmutableEntry.builder();
    Entry<Object, Object> instance = mock(Entry.class);
    when(instance.value()).thenReturn("Value");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableEntry.Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).value();
    ImmutableEntry<Object, Object> buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Value", buildResult.value());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntry.Builder#from(Entry)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntry.Builder<Object, Object> builderResult = ImmutableEntry.builder();
    Entry<Object, Object> instance = mock(Entry.class);
    when(instance.value()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).key();
    verify(instance).value();
  }

  /**
   * Method under test: {@link ImmutableEntry.Builder#key(Object)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableEntry.Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test: {@link ImmutableEntry.Builder#value(Object)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableEntry.Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("Value"));
  }

  /**
   * Method under test: {@link ImmutableEntry#copyOf(Entry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Entry<Object, Object> instance = mock(Entry.class);
    when(instance.value()).thenReturn("Value");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableEntry<Object, Object> actualCopyOfResult = ImmutableEntry.copyOf(instance);

    // Assert
    verify(instance).key();
    verify(instance).value();
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Value", actualCopyOfResult.value());
  }

  /**
   * Method under test: {@link ImmutableEntry#fromJson(ImmutableEntry.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntry.Json<Object, Object> json = new ImmutableEntry.Json<>();
    json.setKey("Json");
    json.setValue("Json");

    // Act
    ImmutableEntry<Object, Object> actualFromJsonResult = ImmutableEntry.fromJson(json);

    // Assert
    Object keyResult = actualFromJsonResult.key();
    assertEquals("Json", keyResult);
    Object object = json.value;
    assertSame(object, keyResult);
    assertSame(object, actualFromJsonResult.value());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableEntry.Json}
   *   <li>{@link ImmutableEntry.Json#setKey(Object)}
   *   <li>{@link ImmutableEntry.Json#setValue(Object)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntry.Json<Object, Object> actualJson = new ImmutableEntry.Json<>();
    actualJson.setKey("Key");
    actualJson.setValue("Value");

    // Assert
    assertEquals("Key", actualJson.key);
    assertEquals("Value", actualJson.value);
  }

  /**
   * Method under test: {@link ImmutableEntry.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange
    ImmutableEntry.Json<Object, Object> json = new ImmutableEntry.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.key());
  }

  /**
   * Method under test: {@link ImmutableEntry.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange
    ImmutableEntry.Json<Object, Object> json = new ImmutableEntry.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.value());
  }
}
