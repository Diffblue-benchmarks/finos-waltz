package org.finos.waltz.model.authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableOAuthConfigurationDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableOAuthConfiguration.Builder#codeVerifier(String)}
   */
  @Test
  void testBuilderCodeVerifier() {
    // Arrange
    ImmutableOAuthConfiguration.Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.codeVerifier("Code Verifier"));
  }

  /**
   * Method under test:
   * {@link ImmutableOAuthConfiguration.Builder#from(OAuthConfiguration)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOAuthConfiguration.Builder builderResult = ImmutableOAuthConfiguration.builder();
    OAuthConfiguration instance = mock(OAuthConfiguration.class);
    when(instance.redirectUri()).thenReturn("Redirect Uri");
    when(instance.codeVerifier()).thenReturn("Code Verifier");
    when(instance.userInfoUrl()).thenReturn("https://example.org/example");
    when(instance.tokenUrl()).thenReturn("https://example.org/example");

    // Act
    ImmutableOAuthConfiguration.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableOAuthConfiguration.Builder#from(OAuthConfiguration)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOAuthConfiguration.Builder builderResult = ImmutableOAuthConfiguration.builder();
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
   * Method under test:
   * {@link ImmutableOAuthConfiguration.Builder#redirectUri(String)}
   */
  @Test
  void testBuilderRedirectUri() {
    // Arrange
    ImmutableOAuthConfiguration.Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.redirectUri("Redirect Uri"));
  }

  /**
   * Method under test:
   * {@link ImmutableOAuthConfiguration.Builder#tokenUrl(String)}
   */
  @Test
  void testBuilderTokenUrl() {
    // Arrange
    ImmutableOAuthConfiguration.Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tokenUrl("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link ImmutableOAuthConfiguration.Builder#userInfoUrl(String)}
   */
  @Test
  void testBuilderUserInfoUrl() {
    // Arrange
    ImmutableOAuthConfiguration.Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userInfoUrl("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link ImmutableOAuthConfiguration#copyOf(OAuthConfiguration)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OAuthConfiguration instance = mock(OAuthConfiguration.class);
    when(instance.redirectUri()).thenReturn("Redirect Uri");
    when(instance.codeVerifier()).thenReturn("Code Verifier");
    when(instance.userInfoUrl()).thenReturn("https://example.org/example");
    when(instance.tokenUrl()).thenReturn("https://example.org/example");

    // Act
    ImmutableOAuthConfiguration actualCopyOfResult = ImmutableOAuthConfiguration.copyOf(instance);

    // Assert
    verify(instance).codeVerifier();
    verify(instance).redirectUri();
    verify(instance).tokenUrl();
    verify(instance).userInfoUrl();
    assertEquals("Code Verifier", actualCopyOfResult.codeVerifier());
    assertEquals("Redirect Uri", actualCopyOfResult.redirectUri());
    assertEquals("https://example.org/example", actualCopyOfResult.tokenUrl());
    assertEquals("https://example.org/example", actualCopyOfResult.userInfoUrl());
  }
}
