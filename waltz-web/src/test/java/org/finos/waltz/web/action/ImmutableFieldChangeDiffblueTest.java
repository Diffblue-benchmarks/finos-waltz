package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableFieldChangeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFieldChange#builder()}
   *   <li>{@link ImmutableFieldChange#current(String)}
   *   <li>{@link ImmutableFieldChange#original(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFieldChange.Builder actualCurrentResult = ImmutableFieldChange.builder().current("Current");
    Optional<String> current = Optional.of("foo");
    ImmutableFieldChange.Builder actualOriginalResult = actualCurrentResult.current(current).original("Original");
    Optional<String> original = Optional.of("foo");

    // Assert
    assertSame(actualOriginalResult, actualOriginalResult.original(original));
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#current(Optional)}
   */
  @Test
  void testBuilderCurrent() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();
    Optional<String> current = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.current(current));
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#dirty(boolean)}
   */
  @Test
  void testBuilderDirty() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dirty(true));
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#from(FieldChange)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.current()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.original()).thenReturn(ofResult2);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFieldChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    ImmutableFieldChange buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertTrue(buildResult.dirty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#from(FieldChange)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#from(FieldChange)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.current()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.original()).thenReturn(ofResult);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFieldChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    ImmutableFieldChange buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertTrue(buildResult.dirty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#from(FieldChange)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.current()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.original()).thenReturn(emptyResult);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFieldChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    ImmutableFieldChange buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertTrue(buildResult.dirty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#original(Optional)}
   */
  @Test
  void testBuilderOriginal() {
    // Arrange
    ImmutableFieldChange.Builder builderResult = ImmutableFieldChange.builder();
    Optional<String> original = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.original(original));
  }

  /**
   * Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.current()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.original()).thenReturn(ofResult2);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFieldChange actualCopyOfResult = ImmutableFieldChange.copyOf(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertTrue(actualCopyOfResult.dirty());
  }

  /**
   * Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.current()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.original()).thenReturn(ofResult);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFieldChange actualCopyOfResult = ImmutableFieldChange.copyOf(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertTrue(actualCopyOfResult.dirty());
  }

  /**
   * Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.current()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.original()).thenReturn(emptyResult);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFieldChange actualCopyOfResult = ImmutableFieldChange.copyOf(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertTrue(actualCopyOfResult.dirty());
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#current()}
   */
  @Test
  void testJsonCurrent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFieldChange.Json()).current());
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#dirty()}
   */
  @Test
  void testJsonDirty() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFieldChange.Json()).dirty());
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFieldChange.Json()).key());
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFieldChange.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFieldChange.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFieldChange.Json actualJson = new ImmutableFieldChange.Json();

    // Assert
    assertNull(actualJson.key);
    assertNull(actualJson.name);
    assertFalse(actualJson.current.isPresent());
    assertFalse(actualJson.original.isPresent());
    assertFalse(actualJson.dirty);
    assertFalse(actualJson.dirtyIsSet);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#original()}
   */
  @Test
  void testJsonOriginal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFieldChange.Json()).original());
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#setDirty(boolean)}
   */
  @Test
  void testJsonSetDirty() {
    // Arrange
    ImmutableFieldChange.Json json = new ImmutableFieldChange.Json();

    // Act
    json.setDirty(true);

    // Assert
    assertTrue(json.dirty);
    assertTrue(json.dirtyIsSet);
  }
}
