package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableWebErrorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableWebError#builder()}
   *   <li>{@link ImmutableWebError#id(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableWebError.Builder actualIdResult = ImmutableWebError.builder().id("42");
    Optional<String> id = Optional.of("foo");

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableWebError.Builder#from(WebError)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableWebError.Builder builderResult = ImmutableWebError.builder();
    WebError instance = mock(WebError.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableWebError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    assertEquals("Not all who wander are lost", actualFromResult.build().message());
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableWebError.Builder#from(WebError)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableWebError.Builder builderResult = ImmutableWebError.builder();
    WebError instance = mock(WebError.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).message();
  }

  /**
   * Method under test: {@link ImmutableWebError.Builder#from(WebError)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableWebError.Builder builderResult = ImmutableWebError.builder();
    WebError instance = mock(WebError.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableWebError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    assertEquals("Not all who wander are lost", actualFromResult.build().message());
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableWebError.Builder#id(Optional)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableWebError.Builder builderResult = ImmutableWebError.builder();
    Optional<String> id = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableWebError.Builder#message(String)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableWebError.Builder builderResult = ImmutableWebError.builder();

    // Act
    ImmutableWebError.Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.build().message());
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Method under test: {@link ImmutableWebError#copyOf(WebError)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    WebError instance = mock(WebError.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableWebError actualCopyOfResult = ImmutableWebError.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
  }

  /**
   * Method under test: {@link ImmutableWebError#copyOf(WebError)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    WebError instance = mock(WebError.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableWebError actualCopyOfResult = ImmutableWebError.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
  }

  /**
   * Method under test: {@link ImmutableWebError#fromJson(ImmutableWebError.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableWebError.Json json = new ImmutableWebError.Json();
    json.setMessage("Json");
    json.setId(null);

    // Act and Assert
    assertEquals("Json", ImmutableWebError.fromJson(json).message());
  }

  /**
   * Method under test: {@link ImmutableWebError.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableWebError.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableWebError.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableWebError.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableWebError.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableWebError.Json actualJson = new ImmutableWebError.Json();

    // Assert
    assertNull(actualJson.message);
    assertFalse(actualJson.id.isPresent());
  }
}
