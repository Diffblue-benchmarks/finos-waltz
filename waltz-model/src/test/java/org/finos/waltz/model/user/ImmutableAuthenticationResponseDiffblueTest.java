package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAuthenticationResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAuthenticationResponse#builder()}
   *   <li>{@link ImmutableAuthenticationResponse#errorMessage(String)}
   *   <li>{@link ImmutableAuthenticationResponse#waltzUserName(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAuthenticationResponse.Builder actualErrorMessageResult = ImmutableAuthenticationResponse.builder()
        .errorMessage("An error occurred");

    // Assert
    assertSame(actualErrorMessageResult, actualErrorMessageResult.waltzUserName("janedoe"));
  }

  /**
   * Method under test:
   * {@link ImmutableAuthenticationResponse.Builder#from(AuthenticationResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAuthenticationResponse.Builder builderResult = ImmutableAuthenticationResponse.builder();
    AuthenticationResponse instance = mock(AuthenticationResponse.class);
    when(instance.success()).thenReturn(true);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.waltzUserName()).thenReturn("janedoe");

    // Act
    ImmutableAuthenticationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).success();
    verify(instance).waltzUserName();
    ImmutableAuthenticationResponse buildResult = builderResult.build();
    assertEquals("An error occurred", buildResult.errorMessage());
    assertEquals("janedoe", buildResult.waltzUserName());
    assertTrue(buildResult.success());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAuthenticationResponse.Builder#from(AuthenticationResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAuthenticationResponse.Builder builderResult = ImmutableAuthenticationResponse.builder();
    AuthenticationResponse instance = mock(AuthenticationResponse.class);
    when(instance.success()).thenReturn(true);
    when(instance.errorMessage()).thenReturn(null);
    when(instance.waltzUserName()).thenReturn("janedoe");

    // Act
    ImmutableAuthenticationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).success();
    verify(instance).waltzUserName();
    ImmutableAuthenticationResponse buildResult = builderResult.build();
    assertEquals("janedoe", buildResult.waltzUserName());
    assertNull(buildResult.errorMessage());
    assertTrue(buildResult.success());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAuthenticationResponse.Builder#from(AuthenticationResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAuthenticationResponse.Builder builderResult = ImmutableAuthenticationResponse.builder();
    AuthenticationResponse instance = mock(AuthenticationResponse.class);
    when(instance.success()).thenReturn(true);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.waltzUserName()).thenReturn(null);

    // Act
    ImmutableAuthenticationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).success();
    verify(instance).waltzUserName();
    ImmutableAuthenticationResponse buildResult = builderResult.build();
    assertEquals("An error occurred", buildResult.errorMessage());
    assertNull(buildResult.waltzUserName());
    assertTrue(buildResult.success());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAuthenticationResponse.Builder#success(boolean)}
   */
  @Test
  void testBuilderSuccess() {
    // Arrange
    ImmutableAuthenticationResponse.Builder builderResult = ImmutableAuthenticationResponse.builder();

    // Act
    ImmutableAuthenticationResponse.Builder actualSuccessResult = builderResult.success(true);

    // Assert
    ImmutableAuthenticationResponse buildResult = builderResult.build();
    assertNull(buildResult.errorMessage());
    assertNull(buildResult.waltzUserName());
    assertTrue(buildResult.success());
    assertSame(builderResult, actualSuccessResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAuthenticationResponse#copyOf(AuthenticationResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AuthenticationResponse instance = mock(AuthenticationResponse.class);
    when(instance.success()).thenReturn(true);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.waltzUserName()).thenReturn("janedoe");

    // Act
    ImmutableAuthenticationResponse actualCopyOfResult = ImmutableAuthenticationResponse.copyOf(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).success();
    verify(instance).waltzUserName();
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals("janedoe", actualCopyOfResult.waltzUserName());
    assertTrue(actualCopyOfResult.success());
  }

  /**
   * Method under test:
   * {@link ImmutableAuthenticationResponse.Json#errorMessage()}
   */
  @Test
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAuthenticationResponse.Json()).errorMessage());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAuthenticationResponse.Json}
   *   <li>{@link ImmutableAuthenticationResponse.Json#setErrorMessage(String)}
   *   <li>{@link ImmutableAuthenticationResponse.Json#setWaltzUserName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAuthenticationResponse.Json actualJson = new ImmutableAuthenticationResponse.Json();
    actualJson.setErrorMessage("An error occurred");
    actualJson.setWaltzUserName("janedoe");

    // Assert
    assertEquals("An error occurred", actualJson.errorMessage);
    assertEquals("janedoe", actualJson.waltzUserName);
    assertFalse(actualJson.success);
    assertFalse(actualJson.successIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAuthenticationResponse.Json#setSuccess(boolean)}
   */
  @Test
  void testJsonSetSuccess() {
    // Arrange
    ImmutableAuthenticationResponse.Json json = new ImmutableAuthenticationResponse.Json();

    // Act
    json.setSuccess(true);

    // Assert
    assertTrue(json.success);
    assertTrue(json.successIsSet);
  }

  /**
   * Method under test: {@link ImmutableAuthenticationResponse.Json#success()}
   */
  @Test
  void testJsonSuccess() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAuthenticationResponse.Json()).success());
  }

  /**
   * Method under test:
   * {@link ImmutableAuthenticationResponse.Json#waltzUserName()}
   */
  @Test
  void testJsonWaltzUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAuthenticationResponse.Json()).waltzUserName());
  }
}
