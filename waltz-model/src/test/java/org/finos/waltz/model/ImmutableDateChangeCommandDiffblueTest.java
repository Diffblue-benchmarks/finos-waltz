package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableDateChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDateChangeCommand.Builder#from(DateChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDateChangeCommand.Builder builderResult = ImmutableDateChangeCommand.builder();
    DateChangeCommand instance = mock(DateChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDateVal()).thenReturn(ofResult);

    // Act
    ImmutableDateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newDateVal();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeCommand.Builder#from(DateChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDateChangeCommand.Builder builderResult = ImmutableDateChangeCommand.builder();
    DateChangeCommand instance = mock(DateChangeCommand.class);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newDateVal()).thenReturn(emptyResult);

    // Act
    ImmutableDateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newDateVal();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeCommand#copyOf(DateChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DateChangeCommand instance = mock(DateChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDateVal()).thenReturn(ofResult);

    // Act
    ImmutableDateChangeCommand actualCopyOfResult = ImmutableDateChangeCommand.copyOf(instance);

    // Assert
    verify(instance).newDateVal();
    assertEquals(ofResult, actualCopyOfResult.newDateVal());
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeCommand#copyOf(DateChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    DateChangeCommand instance = mock(DateChangeCommand.class);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newDateVal()).thenReturn(emptyResult);

    // Act
    ImmutableDateChangeCommand actualCopyOfResult = ImmutableDateChangeCommand.copyOf(instance);

    // Assert
    verify(instance).newDateVal();
    Optional<LocalDate> newDateValResult = actualCopyOfResult.newDateVal();
    assertFalse(newDateValResult.isPresent());
    assertSame(emptyResult, newDateValResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeCommand#fromJson(ImmutableDateChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDateChangeCommand.Json json = new ImmutableDateChangeCommand.Json();

    // Act and Assert
    Optional<LocalDate> newDateValResult = ImmutableDateChangeCommand.fromJson(json).newDateVal();
    assertFalse(newDateValResult.isPresent());
    assertSame(json.newDateVal, newDateValResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeCommand#fromJson(ImmutableDateChangeCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableDateChangeCommand.Json json = new ImmutableDateChangeCommand.Json();
    json.setNewDateVal(null);

    // Act and Assert
    assertFalse(ImmutableDateChangeCommand.fromJson(json).newDateVal().isPresent());
  }

  /**
   * Method under test: {@link ImmutableDateChangeCommand.Json#newDateVal()}
   */
  @Test
  void testJsonNewDateVal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateChangeCommand.Json()).newDateVal());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDateChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertFalse((new ImmutableDateChangeCommand.Json()).newDateVal.isPresent());
  }
}
