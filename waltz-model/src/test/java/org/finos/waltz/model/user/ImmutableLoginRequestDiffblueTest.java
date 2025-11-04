package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableLoginRequestDiffblueTest {
  /**
   * Method under test: {@link ImmutableLoginRequest.Builder#from(LoginRequest)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLoginRequest.Builder builderResult = ImmutableLoginRequest.builder();
    LoginRequest instance = mock(LoginRequest.class);
    when(instance.password()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutableLoginRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).password();
    verify(instance).userName();
    ImmutableLoginRequest buildResult = builderResult.build();
    assertEquals("iloveyou", buildResult.password());
    assertEquals("janedoe", buildResult.userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLoginRequest.Builder#from(LoginRequest)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLoginRequest.Builder builderResult = ImmutableLoginRequest.builder();
    LoginRequest instance = mock(LoginRequest.class);
    when(instance.password()).thenThrow(new IllegalStateException("instance"));
    when(instance.userName()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).password();
    verify(instance).userName();
  }

  /**
   * Method under test: {@link ImmutableLoginRequest.Builder#password(String)}
   */
  @Test
  void testBuilderPassword() {
    // Arrange
    ImmutableLoginRequest.Builder builderResult = ImmutableLoginRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.password("iloveyou"));
  }

  /**
   * Method under test: {@link ImmutableLoginRequest.Builder#userName(String)}
   */
  @Test
  void testBuilderUserName() {
    // Arrange
    ImmutableLoginRequest.Builder builderResult = ImmutableLoginRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userName("janedoe"));
  }

  /**
   * Method under test: {@link ImmutableLoginRequest#copyOf(LoginRequest)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LoginRequest instance = mock(LoginRequest.class);
    when(instance.password()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutableLoginRequest actualCopyOfResult = ImmutableLoginRequest.copyOf(instance);

    // Assert
    verify(instance).password();
    verify(instance).userName();
    assertEquals("iloveyou", actualCopyOfResult.password());
    assertEquals("janedoe", actualCopyOfResult.userName());
  }

  /**
   * Method under test:
   * {@link ImmutableLoginRequest#fromJson(ImmutableLoginRequest.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLoginRequest.Json json = new ImmutableLoginRequest.Json();
    json.setUserName("Json");
    json.setPassword("Json");

    // Act
    ImmutableLoginRequest actualFromJsonResult = ImmutableLoginRequest.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.password());
    assertEquals("Json", actualFromJsonResult.userName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableLoginRequest.Json}
   *   <li>{@link ImmutableLoginRequest.Json#setPassword(String)}
   *   <li>{@link ImmutableLoginRequest.Json#setUserName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableLoginRequest.Json actualJson = new ImmutableLoginRequest.Json();
    actualJson.setPassword("iloveyou");
    actualJson.setUserName("janedoe");

    // Assert
    assertEquals("iloveyou", actualJson.password);
    assertEquals("janedoe", actualJson.userName);
  }

  /**
   * Method under test: {@link ImmutableLoginRequest.Json#password()}
   */
  @Test
  void testJsonPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLoginRequest.Json()).password());
  }

  /**
   * Method under test: {@link ImmutableLoginRequest.Json#userName()}
   */
  @Test
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLoginRequest.Json()).userName());
  }
}
