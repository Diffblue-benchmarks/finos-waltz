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

class ImmutableSimpleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSimple#builder()}
   *   <li>{@link ImmutableSimple#secret(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSimple.Builder actualSecretResult = ImmutableSimple.builder().secret("Secret");
    Optional<String> secret = Optional.of("foo");

    // Assert
    assertSame(actualSecretResult, actualSecretResult.secret(secret));
  }

  /**
   * Method under test: {@link ImmutableSimple.Builder#from(Simple)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSimple.Builder builderResult = ImmutableSimple.builder();
    Simple instance = mock(Simple.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.secret()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableSimple.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).secret();
    assertEquals("Not all who wander are lost", actualFromResult.build().message());
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSimple.Builder#from(Simple)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSimple.Builder builderResult = ImmutableSimple.builder();
    Simple instance = mock(Simple.class);
    when(instance.secret()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).message();
    verify(instance).secret();
  }

  /**
   * Method under test: {@link ImmutableSimple.Builder#from(Simple)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSimple.Builder builderResult = ImmutableSimple.builder();
    Simple instance = mock(Simple.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.secret()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableSimple.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).secret();
    assertEquals("Not all who wander are lost", actualFromResult.build().message());
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSimple.Builder#message(String)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableSimple.Builder builderResult = ImmutableSimple.builder();

    // Act
    ImmutableSimple.Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.build().message());
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Method under test: {@link ImmutableSimple.Builder#secret(Optional)}
   */
  @Test
  void testBuilderSecret() {
    // Arrange
    ImmutableSimple.Builder builderResult = ImmutableSimple.builder();
    Optional<String> secret = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.secret(secret));
  }

  /**
   * Method under test: {@link ImmutableSimple#copyOf(Simple)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Simple instance = mock(Simple.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.secret()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableSimple actualCopyOfResult = ImmutableSimple.copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).secret();
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
  }

  /**
   * Method under test: {@link ImmutableSimple#copyOf(Simple)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Simple instance = mock(Simple.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.secret()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableSimple actualCopyOfResult = ImmutableSimple.copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).secret();
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
  }

  /**
   * Method under test: {@link ImmutableSimple#fromJson(ImmutableSimple.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSimple.Json json = new ImmutableSimple.Json();
    json.setMessage("Json");
    json.setSecret(null);

    // Act and Assert
    assertEquals("Json", ImmutableSimple.fromJson(json).message());
  }

  /**
   * Method under test: {@link ImmutableSimple.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSimple.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSimple.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSimple.Json actualJson = new ImmutableSimple.Json();

    // Assert
    assertNull(actualJson.message);
    assertFalse(actualJson.secret.isPresent());
  }

  /**
   * Method under test: {@link ImmutableSimple.Json#secret()}
   */
  @Test
  void testJsonSecret() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSimple.Json()).secret());
  }
}
