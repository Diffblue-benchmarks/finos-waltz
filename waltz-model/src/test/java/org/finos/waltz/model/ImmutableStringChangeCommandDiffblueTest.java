package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableStringChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableStringChangeCommand.Builder#from(StringChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableStringChangeCommand.Builder builderResult = ImmutableStringChangeCommand.builder();
    StringChangeCommand instance = mock(StringChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.newStringVal()).thenReturn(ofResult);

    // Act
    ImmutableStringChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newStringVal();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableStringChangeCommand.Builder#from(StringChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableStringChangeCommand.Builder builderResult = ImmutableStringChangeCommand.builder();
    StringChangeCommand instance = mock(StringChangeCommand.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.newStringVal()).thenReturn(emptyResult);

    // Act
    ImmutableStringChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newStringVal();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableStringChangeCommand.Builder#newStringVal(Optional)}
   */
  @Test
  void testBuilderNewStringVal() {
    // Arrange
    ImmutableStringChangeCommand.Builder builderResult = ImmutableStringChangeCommand.builder();
    Optional<String> newStringVal = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.newStringVal(newStringVal));
  }

  /**
   * Method under test:
   * {@link ImmutableStringChangeCommand#copyOf(StringChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    StringChangeCommand instance = mock(StringChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.newStringVal()).thenReturn(ofResult);

    // Act
    ImmutableStringChangeCommand actualCopyOfResult = ImmutableStringChangeCommand.copyOf(instance);

    // Assert
    verify(instance).newStringVal();
    assertEquals(ofResult, actualCopyOfResult.newStringVal());
  }

  /**
   * Method under test:
   * {@link ImmutableStringChangeCommand#copyOf(StringChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    StringChangeCommand instance = mock(StringChangeCommand.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.newStringVal()).thenReturn(emptyResult);

    // Act
    ImmutableStringChangeCommand actualCopyOfResult = ImmutableStringChangeCommand.copyOf(instance);

    // Assert
    verify(instance).newStringVal();
    Optional<String> newStringValResult = actualCopyOfResult.newStringVal();
    assertFalse(newStringValResult.isPresent());
    assertSame(emptyResult, newStringValResult);
  }

  /**
   * Method under test:
   * {@link ImmutableStringChangeCommand#fromJson(ImmutableStringChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableStringChangeCommand.Json json = new ImmutableStringChangeCommand.Json();

    // Act and Assert
    Optional<String> newStringValResult = ImmutableStringChangeCommand.fromJson(json).newStringVal();
    assertFalse(newStringValResult.isPresent());
    assertSame(json.newStringVal, newStringValResult);
  }

  /**
   * Method under test:
   * {@link ImmutableStringChangeCommand#fromJson(ImmutableStringChangeCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableStringChangeCommand.Json json = new ImmutableStringChangeCommand.Json();
    json.setNewStringVal(null);

    // Act and Assert
    assertFalse(ImmutableStringChangeCommand.fromJson(json).newStringVal().isPresent());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableStringChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertFalse((new ImmutableStringChangeCommand.Json()).newStringVal.isPresent());
  }

  /**
   * Method under test: {@link ImmutableStringChangeCommand.Json#newStringVal()}
   */
  @Test
  void testJsonNewStringVal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStringChangeCommand.Json()).newStringVal());
  }
}
