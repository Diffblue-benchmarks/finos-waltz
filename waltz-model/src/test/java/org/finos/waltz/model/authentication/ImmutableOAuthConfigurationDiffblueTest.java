package org.finos.waltz.model.authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.authentication.ImmutableOAuthConfiguration.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOAuthConfigurationDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOAuthConfiguration Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOAuthConfiguration actualImmutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Assert
    assertEquals("Code Verifier", actualImmutableOAuthConfiguration.codeVerifier());
    assertEquals("Redirect Uri", actualImmutableOAuthConfiguration.redirectUri());
    assertEquals("https://example.org/example", actualImmutableOAuthConfiguration.tokenUrl());
    assertEquals("https://example.org/example", actualImmutableOAuthConfiguration.userInfoUrl());
  }

  /**
   * Test Builder {@link Builder#codeVerifier(String)}.
   *
   * <ul>
   *   <li>When {@code Code Verifier}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#codeVerifier(String)}
   */
  @Test
  @DisplayName("Test Builder codeVerifier(String); when 'Code Verifier'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.codeVerifier(String)"})
  void testBuilderCodeVerifier_whenCodeVerifier_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act
    Builder actualCodeVerifierResult = builderResult.codeVerifier("Code Verifier");

    // Assert
    assertSame(builderResult, actualCodeVerifierResult);
  }

  /**
   * Test Builder {@link Builder#from(OAuthConfiguration)}.
   *
   * <p>Method under test: {@link Builder#from(OAuthConfiguration)}
   */
  @Test
  @DisplayName("Test Builder from(OAuthConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OAuthConfiguration)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();
    ImmutableOAuthConfiguration instance =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOAuthConfiguration actualImmutableOAuthConfiguration = builderResult.build();
    assertEquals(instance, actualImmutableOAuthConfiguration);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#redirectUri(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect Uri}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#redirectUri(String)}
   */
  @Test
  @DisplayName("Test Builder redirectUri(String); when 'Redirect Uri'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.redirectUri(String)"})
  void testBuilderRedirectUri_whenRedirectUri_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act
    Builder actualRedirectUriResult = builderResult.redirectUri("Redirect Uri");

    // Assert
    assertSame(builderResult, actualRedirectUriResult);
  }

  /**
   * Test Builder {@link Builder#tokenUrl(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#tokenUrl(String)}
   */
  @Test
  @DisplayName(
      "Test Builder tokenUrl(String); when 'https://example.org/example'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.tokenUrl(String)"})
  void testBuilderTokenUrl_whenHttpsExampleOrgExample_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act
    Builder actualTokenUrlResult = builderResult.tokenUrl("https://example.org/example");

    // Assert
    assertSame(builderResult, actualTokenUrlResult);
  }

  /**
   * Test Builder {@link Builder#userInfoUrl(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userInfoUrl(String)}
   */
  @Test
  @DisplayName(
      "Test Builder userInfoUrl(String); when 'https://example.org/example'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userInfoUrl(String)"})
  void testBuilderUserInfoUrl_whenHttpsExampleOrgExample_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOAuthConfiguration.builder();

    // Act
    Builder actualUserInfoUrlResult = builderResult.userInfoUrl("https://example.org/example");

    // Assert
    assertSame(builderResult, actualUserInfoUrlResult);
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#copyOf(OAuthConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@code Code Verifier}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#copyOf(OAuthConfiguration)}
   */
  @Test
  @DisplayName("Test copyOf(OAuthConfiguration); then return 'Code Verifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.copyOf(OAuthConfiguration)"
  })
  void testCopyOf_thenReturnCodeVerifier() {
    // Arrange
    ImmutableOAuthConfiguration instance =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act
    ImmutableOAuthConfiguration actualCopyOfResult = ImmutableOAuthConfiguration.copyOf(instance);

    // Assert
    assertEquals("Code Verifier", actualCopyOfResult.codeVerifier());
    assertEquals("Redirect Uri", actualCopyOfResult.redirectUri());
    assertEquals("https://example.org/example", actualCopyOfResult.tokenUrl());
    assertEquals("https://example.org/example", actualCopyOfResult.userInfoUrl());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#equals(Object)}, and {@link
   * ImmutableOAuthConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOAuthConfiguration#equals(Object)}
   *   <li>{@link ImmutableOAuthConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOAuthConfiguration.equals(Object)",
    "int ImmutableOAuthConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();
    ImmutableOAuthConfiguration immutableOAuthConfiguration2 =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(immutableOAuthConfiguration, immutableOAuthConfiguration2);
    assertEquals(immutableOAuthConfiguration.hashCode(), immutableOAuthConfiguration2.hashCode());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#equals(Object)}, and {@link
   * ImmutableOAuthConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOAuthConfiguration#equals(Object)}
   *   <li>{@link ImmutableOAuthConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOAuthConfiguration.equals(Object)",
    "int ImmutableOAuthConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(immutableOAuthConfiguration, immutableOAuthConfiguration);
    int expectedHashCodeResult = immutableOAuthConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, immutableOAuthConfiguration.hashCode());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOAuthConfiguration.equals(Object)",
    "int ImmutableOAuthConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("https://example.org/example")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOAuthConfiguration,
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOAuthConfiguration.equals(Object)",
    "int ImmutableOAuthConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("https://example.org/example")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOAuthConfiguration,
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOAuthConfiguration.equals(Object)",
    "int ImmutableOAuthConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("ABC123")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOAuthConfiguration,
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOAuthConfiguration.equals(Object)",
    "int ImmutableOAuthConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("Code Verifier")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOAuthConfiguration,
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOAuthConfiguration.equals(Object)",
    "int ImmutableOAuthConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOAuthConfiguration.equals(Object)",
    "int ImmutableOAuthConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build(),
        "Different type to ImmutableOAuthConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOAuthConfiguration#toString()}
   *   <li>{@link ImmutableOAuthConfiguration#codeVerifier()}
   *   <li>{@link ImmutableOAuthConfiguration#redirectUri()}
   *   <li>{@link ImmutableOAuthConfiguration#tokenUrl()}
   *   <li>{@link ImmutableOAuthConfiguration#userInfoUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableOAuthConfiguration.codeVerifier()",
    "String ImmutableOAuthConfiguration.redirectUri()",
    "String ImmutableOAuthConfiguration.toString()",
    "String ImmutableOAuthConfiguration.tokenUrl()",
    "String ImmutableOAuthConfiguration.userInfoUrl()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act
    String actualToStringResult = immutableOAuthConfiguration.toString();
    String actualCodeVerifierResult = immutableOAuthConfiguration.codeVerifier();
    String actualRedirectUriResult = immutableOAuthConfiguration.redirectUri();
    String actualTokenUrlResult = immutableOAuthConfiguration.tokenUrl();

    // Assert
    assertEquals("Code Verifier", actualCodeVerifierResult);
    assertEquals(
        "OAuthConfiguration{tokenUrl=https://example.org/example, userInfoUrl=https://example.org/example,"
            + " codeVerifier=Code Verifier, redirectUri=Redirect Uri}",
        actualToStringResult);
    assertEquals("Redirect Uri", actualRedirectUriResult);
    assertEquals("https://example.org/example", actualTokenUrlResult);
    assertEquals("https://example.org/example", immutableOAuthConfiguration.userInfoUrl());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#withCodeVerifier(String)}.
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#withCodeVerifier(String)}
   */
  @Test
  @DisplayName("Test withCodeVerifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.withCodeVerifier(String)"
  })
  void testWithCodeVerifier() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("42")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act
    ImmutableOAuthConfiguration actualWithCodeVerifierResult =
        immutableOAuthConfiguration.withCodeVerifier("42");

    // Assert
    assertSame(immutableOAuthConfiguration, actualWithCodeVerifierResult);
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#withCodeVerifier(String)}.
   *
   * <ul>
   *   <li>Then return codeVerifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#withCodeVerifier(String)}
   */
  @Test
  @DisplayName("Test withCodeVerifier(String); then return codeVerifier is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.withCodeVerifier(String)"
  })
  void testWithCodeVerifier_thenReturnCodeVerifierIs42() {
    // Arrange and Act
    ImmutableOAuthConfiguration actualWithCodeVerifierResult =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build()
            .withCodeVerifier("42");

    // Assert
    assertEquals("42", actualWithCodeVerifierResult.codeVerifier());
    assertEquals("Redirect Uri", actualWithCodeVerifierResult.redirectUri());
    assertEquals("https://example.org/example", actualWithCodeVerifierResult.tokenUrl());
    assertEquals("https://example.org/example", actualWithCodeVerifierResult.userInfoUrl());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#withRedirectUri(String)}.
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#withRedirectUri(String)}
   */
  @Test
  @DisplayName("Test withRedirectUri(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.withRedirectUri(String)"
  })
  void testWithRedirectUri() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("42")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act
    ImmutableOAuthConfiguration actualWithRedirectUriResult =
        immutableOAuthConfiguration.withRedirectUri("42");

    // Assert
    assertSame(immutableOAuthConfiguration, actualWithRedirectUriResult);
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#withRedirectUri(String)}.
   *
   * <ul>
   *   <li>Then return redirectUri is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#withRedirectUri(String)}
   */
  @Test
  @DisplayName("Test withRedirectUri(String); then return redirectUri is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.withRedirectUri(String)"
  })
  void testWithRedirectUri_thenReturnRedirectUriIs42() {
    // Arrange and Act
    ImmutableOAuthConfiguration actualWithRedirectUriResult =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build()
            .withRedirectUri("42");

    // Assert
    assertEquals("42", actualWithRedirectUriResult.redirectUri());
    assertEquals("Code Verifier", actualWithRedirectUriResult.codeVerifier());
    assertEquals("https://example.org/example", actualWithRedirectUriResult.tokenUrl());
    assertEquals("https://example.org/example", actualWithRedirectUriResult.userInfoUrl());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#withTokenUrl(String)}.
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#withTokenUrl(String)}
   */
  @Test
  @DisplayName("Test withTokenUrl(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.withTokenUrl(String)"
  })
  void testWithTokenUrl() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act
    ImmutableOAuthConfiguration actualWithTokenUrlResult =
        immutableOAuthConfiguration.withTokenUrl("https://example.org/example");

    // Assert
    assertSame(immutableOAuthConfiguration, actualWithTokenUrlResult);
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#withTokenUrl(String)}.
   *
   * <ul>
   *   <li>Then return {@code Code Verifier}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#withTokenUrl(String)}
   */
  @Test
  @DisplayName("Test withTokenUrl(String); then return 'Code Verifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.withTokenUrl(String)"
  })
  void testWithTokenUrl_thenReturnCodeVerifier() {
    // Arrange and Act
    ImmutableOAuthConfiguration actualWithTokenUrlResult =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("ABC123")
            .userInfoUrl("https://example.org/example")
            .build()
            .withTokenUrl("https://example.org/example");

    // Assert
    assertEquals("Code Verifier", actualWithTokenUrlResult.codeVerifier());
    assertEquals("Redirect Uri", actualWithTokenUrlResult.redirectUri());
    assertEquals("https://example.org/example", actualWithTokenUrlResult.tokenUrl());
    assertEquals("https://example.org/example", actualWithTokenUrlResult.userInfoUrl());
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#withUserInfoUrl(String)}.
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#withUserInfoUrl(String)}
   */
  @Test
  @DisplayName("Test withUserInfoUrl(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.withUserInfoUrl(String)"
  })
  void testWithUserInfoUrl() {
    // Arrange
    ImmutableOAuthConfiguration immutableOAuthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    // Act
    ImmutableOAuthConfiguration actualWithUserInfoUrlResult =
        immutableOAuthConfiguration.withUserInfoUrl("https://example.org/example");

    // Assert
    assertSame(immutableOAuthConfiguration, actualWithUserInfoUrlResult);
  }

  /**
   * Test {@link ImmutableOAuthConfiguration#withUserInfoUrl(String)}.
   *
   * <ul>
   *   <li>Then return {@code Code Verifier}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOAuthConfiguration#withUserInfoUrl(String)}
   */
  @Test
  @DisplayName("Test withUserInfoUrl(String); then return 'Code Verifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOAuthConfiguration ImmutableOAuthConfiguration.withUserInfoUrl(String)"
  })
  void testWithUserInfoUrl_thenReturnCodeVerifier() {
    // Arrange and Act
    ImmutableOAuthConfiguration actualWithUserInfoUrlResult =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("userInfoUrl")
            .build()
            .withUserInfoUrl("https://example.org/example");

    // Assert
    assertEquals("Code Verifier", actualWithUserInfoUrlResult.codeVerifier());
    assertEquals("Redirect Uri", actualWithUserInfoUrlResult.redirectUri());
    assertEquals("https://example.org/example", actualWithUserInfoUrlResult.tokenUrl());
    assertEquals("https://example.org/example", actualWithUserInfoUrlResult.userInfoUrl());
  }
}
