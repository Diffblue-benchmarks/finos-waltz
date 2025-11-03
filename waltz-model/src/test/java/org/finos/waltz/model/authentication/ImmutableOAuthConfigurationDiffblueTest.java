package org.finos.waltz.model.authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.authentication.ImmutableOAuthConfiguration.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOAuthConfigurationDiffblueTest {
  /**
   * Test Builder {@link Builder#codeVerifier(String)}.
   * <p>
   * Method under test: {@link Builder#codeVerifier(String)}
   */
  @Test
  @DisplayName("Test Builder codeVerifier(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.codeVerifier(String)"})
  void testBuilderCodeVerifier() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.codeVerifier("Code Verifier"));
  }

  /**
   * Test Builder {@link Builder#from(OAuthConfiguration)}.
   * <ul>
   *   <li>Given {@code Redirect Uri}.</li>
   *   <li>Then builder build codeVerifier is {@code Code Verifier}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OAuthConfiguration)}
   */
  @Test
  @DisplayName("Test Builder from(OAuthConfiguration); given 'Redirect Uri'; then builder build codeVerifier is 'Code Verifier'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OAuthConfiguration)"})
  void testBuilderFrom_givenRedirectUri_thenBuilderBuildCodeVerifierIsCodeVerifier() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();
    OAuthConfiguration instance = mock(OAuthConfiguration.class);
    when(instance.redirectUri()).thenReturn("Redirect Uri");
    when(instance.codeVerifier()).thenReturn("Code Verifier");
    when(instance.userInfoUrl()).thenReturn("https://example.org/example");
    when(instance.tokenUrl()).thenReturn("https://example.org/example");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).codeVerifier();
    verify(instance).redirectUri();
    verify(instance).tokenUrl();
    verify(instance).userInfoUrl();
    ImmutableOAuthConfiguration buildResult = builderResult.build();
    assertEquals("Code Verifier", buildResult.codeVerifier());
    assertEquals("Redirect Uri", buildResult.redirectUri());
    assertEquals("https://example.org/example", buildResult.tokenUrl());
    assertEquals("https://example.org/example", buildResult.userInfoUrl());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OAuthConfiguration)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OAuthConfiguration)}
   */
  @Test
  @DisplayName("Test Builder from(OAuthConfiguration); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OAuthConfiguration)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();
    OAuthConfiguration instance = mock(OAuthConfiguration.class);
    when(instance.redirectUri()).thenThrow(new IllegalStateException("instance"));
    when(instance.codeVerifier()).thenReturn("Code Verifier");
    when(instance.userInfoUrl()).thenReturn("https://example.org/example");
    when(instance.tokenUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).codeVerifier();
    verify(instance).redirectUri();
    verify(instance).tokenUrl();
    verify(instance).userInfoUrl();
  }

  /**
   * Test Builder {@link Builder#redirectUri(String)}.
   * <p>
   * Method under test: {@link Builder#redirectUri(String)}
   */
  @Test
  @DisplayName("Test Builder redirectUri(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.redirectUri(String)"})
  void testBuilderRedirectUri() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.redirectUri("Redirect Uri"));
  }

  /**
   * Test Builder {@link Builder#tokenUrl(String)}.
   * <p>
   * Method under test: {@link Builder#tokenUrl(String)}
   */
  @Test
  @DisplayName("Test Builder tokenUrl(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.tokenUrl(String)"})
  void testBuilderTokenUrl() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tokenUrl("https://example.org/example"));
  }

  /**
   * Test Builder {@link Builder#userInfoUrl(String)}.
   * <p>
   * Method under test: {@link Builder#userInfoUrl(String)}
   */
  @Test
  @DisplayName("Test Builder userInfoUrl(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userInfoUrl(String)"})
  void testBuilderUserInfoUrl() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userInfoUrl("https://example.org/example"));
  }
}
