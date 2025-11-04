package org.finos.waltz.model.application;

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

class ImmutableAppRegistrationResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppRegistrationResponse#builder()}
   *   <li>{@link ImmutableAppRegistrationResponse#message(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAppRegistrationResponse.Builder actualIdResult = ImmutableAppRegistrationResponse.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableAppRegistrationResponse.Builder actualMessageResult = actualIdResult.id(id)
        .message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");

    // Assert
    assertSame(actualMessageResult, actualMessageResult.message(message));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse.Builder#from(AppRegistrationResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppRegistrationResponse.Builder builderResult = ImmutableAppRegistrationResponse.builder();
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult2);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    ImmutableAppRegistrationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    ImmutableAppRegistrationResponse buildResult = builderResult.build();
    assertTrue(buildResult.registered());
    assertSame(json, buildResult.originalRequest());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse.Builder#from(AppRegistrationResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppRegistrationResponse.Builder builderResult = ImmutableAppRegistrationResponse.builder();
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    ImmutableAppRegistrationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    ImmutableAppRegistrationResponse buildResult = builderResult.build();
    assertFalse(buildResult.registered());
    assertSame(json, buildResult.originalRequest());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse.Builder#from(AppRegistrationResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAppRegistrationResponse.Builder builderResult = ImmutableAppRegistrationResponse.builder();
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    ImmutableAppRegistrationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    ImmutableAppRegistrationResponse buildResult = builderResult.build();
    assertTrue(buildResult.registered());
    assertSame(json, buildResult.originalRequest());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationResponse.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAppRegistrationResponse.Builder builderResult = ImmutableAppRegistrationResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAppRegistrationResponse.Builder builderResult = ImmutableAppRegistrationResponse.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse.Builder#message(Optional)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableAppRegistrationResponse.Builder builderResult = ImmutableAppRegistrationResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse.Builder#originalRequest(AppRegistrationRequest)}
   */
  @Test
  void testBuilderOriginalRequest() {
    // Arrange
    ImmutableAppRegistrationResponse.Builder builderResult = ImmutableAppRegistrationResponse.builder();
    ImmutableAppRegistrationRequest.Json originalRequest = new ImmutableAppRegistrationRequest.Json();

    // Act
    ImmutableAppRegistrationResponse.Builder actualOriginalRequestResult = builderResult
        .originalRequest(originalRequest);

    // Assert
    ImmutableAppRegistrationResponse buildResult = builderResult.build();
    assertFalse(buildResult.registered());
    assertSame(originalRequest, buildResult.originalRequest());
    assertSame(builderResult, actualOriginalRequestResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse#copyOf(AppRegistrationResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult2);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    ImmutableAppRegistrationResponse actualCopyOfResult = ImmutableAppRegistrationResponse.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    assertTrue(actualCopyOfResult.registered());
    assertSame(json, actualCopyOfResult.originalRequest());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse#copyOf(AppRegistrationResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    ImmutableAppRegistrationResponse actualCopyOfResult = ImmutableAppRegistrationResponse.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    assertFalse(actualCopyOfResult.registered());
    assertSame(json, actualCopyOfResult.originalRequest());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse#copyOf(AppRegistrationResponse)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    ImmutableAppRegistrationResponse actualCopyOfResult = ImmutableAppRegistrationResponse.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    assertTrue(actualCopyOfResult.registered());
    assertSame(json, actualCopyOfResult.originalRequest());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse#fromJson(ImmutableAppRegistrationResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppRegistrationResponse.Json json = new ImmutableAppRegistrationResponse.Json();
    json.setId(null);
    json.setMessage(null);
    ImmutableAppRegistrationRequest.Json originalRequest = new ImmutableAppRegistrationRequest.Json();
    json.setOriginalRequest(originalRequest);

    // Act
    ImmutableAppRegistrationResponse actualFromJsonResult = ImmutableAppRegistrationResponse.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.registered());
    assertSame(originalRequest, actualFromJsonResult.originalRequest());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse#fromJson(ImmutableAppRegistrationResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAppRegistrationResponse.Json json = new ImmutableAppRegistrationResponse.Json();
    Optional<Long> id = Optional.<Long>of(1L);
    json.setId(id);
    json.setMessage(null);
    ImmutableAppRegistrationRequest.Json originalRequest = new ImmutableAppRegistrationRequest.Json();
    json.setOriginalRequest(originalRequest);

    // Act
    ImmutableAppRegistrationResponse actualFromJsonResult = ImmutableAppRegistrationResponse.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.registered());
    assertSame(originalRequest, actualFromJsonResult.originalRequest());
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationResponse.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationResponse.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationResponse.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationResponse.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppRegistrationResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAppRegistrationResponse.Json actualJson = new ImmutableAppRegistrationResponse.Json();

    // Assert
    assertNull(actualJson.originalRequest);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.message.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationResponse.Json#originalRequest()}
   */
  @Test
  void testJsonOriginalRequest() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppRegistrationResponse.Json()).originalRequest());
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationResponse.Json#registered()}
   */
  @Test
  void testJsonRegistered() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationResponse.Json()).registered());
  }
}
