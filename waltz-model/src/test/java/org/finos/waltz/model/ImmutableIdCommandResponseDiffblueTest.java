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

class ImmutableIdCommandResponseDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableIdCommandResponse.Builder#from(IdCommandResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableIdCommandResponse.Builder builderResult = ImmutableIdCommandResponse.builder();
    IdCommandResponse instance = mock(IdCommandResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableIdCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableIdCommandResponse.Builder#from(IdCommandResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableIdCommandResponse.Builder builderResult = ImmutableIdCommandResponse.builder();
    IdCommandResponse instance = mock(IdCommandResponse.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableIdCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableIdCommandResponse.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableIdCommandResponse.Builder builderResult = ImmutableIdCommandResponse.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableIdCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableIdCommandResponse.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableIdCommandResponse.Builder builderResult = ImmutableIdCommandResponse.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableIdCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableIdCommandResponse.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableIdCommandResponse.Builder builderResult = ImmutableIdCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableIdCommandResponse.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableIdCommandResponse.Builder builderResult = ImmutableIdCommandResponse.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableIdCommandResponse#copyOf(IdCommandResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    IdCommandResponse instance = mock(IdCommandResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableIdCommandResponse actualCopyOfResult = ImmutableIdCommandResponse.copyOf(instance);

    // Assert
    verify(instance).id();
    assertEquals(ofResult, actualCopyOfResult.id());
  }

  /**
   * Method under test:
   * {@link ImmutableIdCommandResponse#copyOf(IdCommandResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    IdCommandResponse instance = mock(IdCommandResponse.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableIdCommandResponse actualCopyOfResult = ImmutableIdCommandResponse.copyOf(instance);

    // Assert
    verify(instance).id();
    Optional<Long> idResult = actualCopyOfResult.id();
    assertFalse(idResult.isPresent());
    assertSame(emptyResult, idResult);
  }

  /**
   * Method under test:
   * {@link ImmutableIdCommandResponse#fromJson(ImmutableIdCommandResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableIdCommandResponse.Json json = new ImmutableIdCommandResponse.Json();

    // Act and Assert
    Optional<Long> idResult = ImmutableIdCommandResponse.fromJson(json).id();
    assertFalse(idResult.isPresent());
    assertSame(json.id, idResult);
  }

  /**
   * Method under test:
   * {@link ImmutableIdCommandResponse#fromJson(ImmutableIdCommandResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableIdCommandResponse.Json json = new ImmutableIdCommandResponse.Json();
    json.setId(null);

    // Act and Assert
    assertFalse(ImmutableIdCommandResponse.fromJson(json).id().isPresent());
  }

  /**
   * Method under test: {@link ImmutableIdCommandResponse.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableIdCommandResponse.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableIdCommandResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertFalse((new ImmutableIdCommandResponse.Json()).id.isPresent());
  }
}
