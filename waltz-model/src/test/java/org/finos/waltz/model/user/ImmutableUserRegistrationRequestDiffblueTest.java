package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUserRegistrationRequestDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUserRegistrationRequest.Builder#from(UserRegistrationRequest)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUserRegistrationRequest.Builder builderResult = ImmutableUserRegistrationRequest.builder();
    UserRegistrationRequest instance = mock(UserRegistrationRequest.class);
    when(instance.password()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutableUserRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).password();
    verify(instance).userName();
    ImmutableUserRegistrationRequest buildResult = builderResult.build();
    assertEquals("iloveyou", buildResult.password());
    assertEquals("janedoe", buildResult.userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUserRegistrationRequest.Builder#from(UserRegistrationRequest)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUserRegistrationRequest.Builder builderResult = ImmutableUserRegistrationRequest.builder();
    UserRegistrationRequest instance = mock(UserRegistrationRequest.class);
    when(instance.password()).thenThrow(new IllegalStateException("instance"));
    when(instance.userName()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).password();
    verify(instance).userName();
  }

  /**
   * Method under test:
   * {@link ImmutableUserRegistrationRequest.Builder#password(String)}
   */
  @Test
  void testBuilderPassword() {
    // Arrange
    ImmutableUserRegistrationRequest.Builder builderResult = ImmutableUserRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.password("iloveyou"));
  }

  /**
   * Method under test:
   * {@link ImmutableUserRegistrationRequest.Builder#userName(String)}
   */
  @Test
  void testBuilderUserName() {
    // Arrange
    ImmutableUserRegistrationRequest.Builder builderResult = ImmutableUserRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userName("janedoe"));
  }

  /**
   * Method under test:
   * {@link ImmutableUserRegistrationRequest#copyOf(UserRegistrationRequest)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UserRegistrationRequest instance = mock(UserRegistrationRequest.class);
    when(instance.password()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutableUserRegistrationRequest actualCopyOfResult = ImmutableUserRegistrationRequest.copyOf(instance);

    // Assert
    verify(instance).password();
    verify(instance).userName();
    assertEquals("iloveyou", actualCopyOfResult.password());
    assertEquals("janedoe", actualCopyOfResult.userName());
  }

  /**
   * Method under test:
   * {@link ImmutableUserRegistrationRequest#fromJson(ImmutableUserRegistrationRequest.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUserRegistrationRequest.Json json = new ImmutableUserRegistrationRequest.Json();
    json.setUserName("Json");
    json.setPassword("Json");

    // Act
    ImmutableUserRegistrationRequest actualFromJsonResult = ImmutableUserRegistrationRequest.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.password());
    assertEquals("Json", actualFromJsonResult.userName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUserRegistrationRequest.Json}
   *   <li>{@link ImmutableUserRegistrationRequest.Json#setPassword(String)}
   *   <li>{@link ImmutableUserRegistrationRequest.Json#setUserName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUserRegistrationRequest.Json actualJson = new ImmutableUserRegistrationRequest.Json();
    actualJson.setPassword("iloveyou");
    actualJson.setUserName("janedoe");

    // Assert
    assertEquals("iloveyou", actualJson.password);
    assertEquals("janedoe", actualJson.userName);
  }

  /**
   * Method under test: {@link ImmutableUserRegistrationRequest.Json#password()}
   */
  @Test
  void testJsonPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserRegistrationRequest.Json()).password());
  }

  /**
   * Method under test: {@link ImmutableUserRegistrationRequest.Json#userName()}
   */
  @Test
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserRegistrationRequest.Json()).userName());
  }
}
