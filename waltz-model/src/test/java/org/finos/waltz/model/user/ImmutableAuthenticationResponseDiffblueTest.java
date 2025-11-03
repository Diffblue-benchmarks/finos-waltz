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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.ImmutableAuthenticationResponse.Builder;
import org.finos.waltz.model.user.ImmutableAuthenticationResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAuthenticationResponseDiffblueTest {
  /**
   * Test {@link ImmutableAuthenticationResponse#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAuthenticationResponse#builder()}
   *   <li>{@link ImmutableAuthenticationResponse#errorMessage(String)}
   *   <li>{@link ImmutableAuthenticationResponse#waltzUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAuthenticationResponse Builder.build()", "Builder Builder.errorMessage(String)",
      "Builder Builder.waltzUserName(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualErrorMessageResult = ImmutableAuthenticationResponse.builder().errorMessage("An error occurred");

    // Assert
    assertSame(actualErrorMessageResult, actualErrorMessageResult.waltzUserName("janedoe"));
  }

  /**
   * Test Builder {@link Builder#from(AuthenticationResponse)}.
   * <ul>
   *   <li>Then builder build errorMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AuthenticationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AuthenticationResponse); then builder build errorMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AuthenticationResponse)"})
  void testBuilderFrom_thenBuilderBuildErrorMessageIsAnErrorOccurred() {
    // Arrange
    Builder builderResult = ImmutableAuthenticationResponse.builder();
    AuthenticationResponse instance = mock(AuthenticationResponse.class);
    when(instance.success()).thenReturn(true);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.waltzUserName()).thenReturn("janedoe");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(AuthenticationResponse)}.
   * <ul>
   *   <li>Then builder build errorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AuthenticationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AuthenticationResponse); then builder build errorMessage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AuthenticationResponse)"})
  void testBuilderFrom_thenBuilderBuildErrorMessageIsNull() {
    // Arrange
    Builder builderResult = ImmutableAuthenticationResponse.builder();
    AuthenticationResponse instance = mock(AuthenticationResponse.class);
    when(instance.success()).thenReturn(true);
    when(instance.errorMessage()).thenReturn(null);
    when(instance.waltzUserName()).thenReturn("janedoe");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(AuthenticationResponse)}.
   * <ul>
   *   <li>Then builder build waltzUserName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AuthenticationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AuthenticationResponse); then builder build waltzUserName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AuthenticationResponse)"})
  void testBuilderFrom_thenBuilderBuildWaltzUserNameIsNull() {
    // Arrange
    Builder builderResult = ImmutableAuthenticationResponse.builder();
    AuthenticationResponse instance = mock(AuthenticationResponse.class);
    when(instance.success()).thenReturn(true);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.waltzUserName()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#success(boolean)}.
   * <p>
   * Method under test: {@link Builder#success(boolean)}
   */
  @Test
  @DisplayName("Test Builder success(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.success(boolean)"})
  void testBuilderSuccess() {
    // Arrange
    Builder builderResult = ImmutableAuthenticationResponse.builder();

    // Act
    Builder actualSuccessResult = builderResult.success(true);

    // Assert
    ImmutableAuthenticationResponse buildResult = builderResult.build();
    assertNull(buildResult.errorMessage());
    assertNull(buildResult.waltzUserName());
    assertTrue(buildResult.success());
    assertSame(builderResult, actualSuccessResult);
  }

  /**
   * Test Json {@link Json#errorMessage()}.
   * <p>
   * Method under test: {@link Json#errorMessage()}
   */
  @Test
  @DisplayName("Test Json errorMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.errorMessage()"})
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errorMessage());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setErrorMessage(String)}
   *   <li>{@link Json#setWaltzUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setErrorMessage(String)", "void Json.setWaltzUserName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setErrorMessage("An error occurred");
    actualJson.setWaltzUserName("janedoe");

    // Assert
    assertEquals("An error occurred", actualJson.errorMessage);
    assertEquals("janedoe", actualJson.waltzUserName);
    assertFalse(actualJson.success);
    assertFalse(actualJson.successIsSet);
  }

  /**
   * Test Json {@link Json#setSuccess(boolean)}.
   * <p>
   * Method under test: {@link Json#setSuccess(boolean)}
   */
  @Test
  @DisplayName("Test Json setSuccess(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSuccess(boolean)"})
  void testJsonSetSuccess() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSuccess(true);

    // Assert
    assertTrue(json.success);
    assertTrue(json.successIsSet);
  }

  /**
   * Test Json {@link Json#success()}.
   * <p>
   * Method under test: {@link Json#success()}
   */
  @Test
  @DisplayName("Test Json success()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.success()"})
  void testJsonSuccess() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).success());
  }

  /**
   * Test Json {@link Json#waltzUserName()}.
   * <p>
   * Method under test: {@link Json#waltzUserName()}
   */
  @Test
  @DisplayName("Test Json waltzUserName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.waltzUserName()"})
  void testJsonWaltzUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).waltzUserName());
  }
}
