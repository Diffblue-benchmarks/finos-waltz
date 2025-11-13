package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.ImmutableLoginRequest.Builder;
import org.finos.waltz.model.user.ImmutableLoginRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLoginRequestDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLoginRequest Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableLoginRequest actualImmutableLoginRequest =
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build();

    // Assert
    assertEquals("iloveyou", actualImmutableLoginRequest.password());
    assertEquals("janedoe", actualImmutableLoginRequest.userName());
  }

  /**
   * Test Builder {@link Builder#from(LoginRequest)}.
   *
   * <ul>
   *   <li>Then builder build is builder password {@code iloveyou} userName {@code janedoe} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LoginRequest)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LoginRequest); then builder build is builder password 'iloveyou' userName 'janedoe' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LoginRequest)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderPasswordIloveyouUserNameJanedoeBuild() {
    // Arrange
    Builder builderResult = ImmutableLoginRequest.builder();
    ImmutableLoginRequest instance =
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLoginRequest actualImmutableLoginRequest = builderResult.build();
    assertEquals(instance, actualImmutableLoginRequest);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#password(String)}.
   *
   * <ul>
   *   <li>When {@code iloveyou}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#password(String)}
   */
  @Test
  @DisplayName("Test Builder password(String); when 'iloveyou'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.password(String)"})
  void testBuilderPassword_whenIloveyou_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLoginRequest.builder();

    // Act
    Builder actualPasswordResult = builderResult.password("iloveyou");

    // Assert
    assertSame(builderResult, actualPasswordResult);
  }

  /**
   * Test Builder {@link Builder#userName(String)}.
   *
   * <ul>
   *   <li>When {@code janedoe}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userName(String)}
   */
  @Test
  @DisplayName("Test Builder userName(String); when 'janedoe'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userName(String)"})
  void testBuilderUserName_whenJanedoe_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLoginRequest.builder();

    // Act
    Builder actualUserNameResult = builderResult.userName("janedoe");

    // Assert
    assertSame(builderResult, actualUserNameResult);
  }

  /**
   * Test {@link ImmutableLoginRequest#copyOf(LoginRequest)}.
   *
   * <ul>
   *   <li>Then return password is {@code iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#copyOf(LoginRequest)}
   */
  @Test
  @DisplayName("Test copyOf(LoginRequest); then return password is 'iloveyou'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLoginRequest ImmutableLoginRequest.copyOf(LoginRequest)"})
  void testCopyOf_thenReturnPasswordIsIloveyou() {
    // Arrange
    ImmutableLoginRequest instance =
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act
    ImmutableLoginRequest actualCopyOfResult = ImmutableLoginRequest.copyOf(instance);

    // Assert
    assertEquals("iloveyou", actualCopyOfResult.password());
    assertEquals("janedoe", actualCopyOfResult.userName());
  }

  /**
   * Test {@link ImmutableLoginRequest#equals(Object)}, and {@link
   * ImmutableLoginRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLoginRequest#equals(Object)}
   *   <li>{@link ImmutableLoginRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLoginRequest.equals(Object)",
    "int ImmutableLoginRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLoginRequest immutableLoginRequest =
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build();
    ImmutableLoginRequest immutableLoginRequest2 =
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act and Assert
    assertEquals(immutableLoginRequest, immutableLoginRequest2);
    assertEquals(immutableLoginRequest.hashCode(), immutableLoginRequest2.hashCode());
  }

  /**
   * Test {@link ImmutableLoginRequest#equals(Object)}, and {@link
   * ImmutableLoginRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLoginRequest#equals(Object)}
   *   <li>{@link ImmutableLoginRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLoginRequest.equals(Object)",
    "int ImmutableLoginRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLoginRequest immutableLoginRequest =
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act and Assert
    assertEquals(immutableLoginRequest, immutableLoginRequest);
    int expectedHashCodeResult = immutableLoginRequest.hashCode();
    assertEquals(expectedHashCodeResult, immutableLoginRequest.hashCode());
  }

  /**
   * Test {@link ImmutableLoginRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLoginRequest.equals(Object)",
    "int ImmutableLoginRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableLoginRequest immutableLoginRequest =
        ImmutableLoginRequest.builder().password("janedoe").userName("janedoe").build();

    // Act and Assert
    assertNotEquals(
        immutableLoginRequest,
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build());
  }

  /**
   * Test {@link ImmutableLoginRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLoginRequest.equals(Object)",
    "int ImmutableLoginRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLoginRequest immutableLoginRequest =
        ImmutableLoginRequest.builder().password("iloveyou").userName("iloveyou").build();

    // Act and Assert
    assertNotEquals(
        immutableLoginRequest,
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build());
  }

  /**
   * Test {@link ImmutableLoginRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLoginRequest.equals(Object)",
    "int ImmutableLoginRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build(), null);
  }

  /**
   * Test {@link ImmutableLoginRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLoginRequest.equals(Object)",
    "int ImmutableLoginRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build(),
        "Different type to ImmutableLoginRequest");
  }

  /**
   * Test {@link ImmutableLoginRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) UserName is {@code Json}.
   *   <li>Then return password is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) UserName is 'Json'; then return password is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLoginRequest ImmutableLoginRequest.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonUserNameIsJson_thenReturnPasswordIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserName("Json");
    json.setPassword("Json");

    // Act
    ImmutableLoginRequest actualFromJsonResult = ImmutableLoginRequest.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.password());
    assertEquals("Json", actualFromJsonResult.userName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLoginRequest#toString()}
   *   <li>{@link ImmutableLoginRequest#password()}
   *   <li>{@link ImmutableLoginRequest#userName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableLoginRequest.password()",
    "String ImmutableLoginRequest.toString()",
    "String ImmutableLoginRequest.userName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLoginRequest immutableLoginRequest =
        ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act
    String actualToStringResult = immutableLoginRequest.toString();
    String actualPasswordResult = immutableLoginRequest.password();

    // Assert
    assertEquals("LoginRequest{userName=janedoe, password=iloveyou}", actualToStringResult);
    assertEquals("iloveyou", actualPasswordResult);
    assertEquals("janedoe", immutableLoginRequest.userName());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setPassword(String)}
   *   <li>{@link Json#setUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setPassword(String)",
    "void Json.setUserName(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setPassword("iloveyou");
    actualJson.setUserName("janedoe");

    // Assert
    assertEquals("iloveyou", actualJson.password);
    assertEquals("janedoe", actualJson.userName);
  }

  /**
   * Test Json {@link Json#password()}.
   *
   * <p>Method under test: {@link Json#password()}
   */
  @Test
  @DisplayName("Test Json password()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.password()"})
  void testJsonPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().password());
  }

  /**
   * Test Json {@link Json#userName()}.
   *
   * <p>Method under test: {@link Json#userName()}
   */
  @Test
  @DisplayName("Test Json userName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userName()"})
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userName());
  }

  /**
   * Test {@link ImmutableLoginRequest#withPassword(String)}.
   *
   * <ul>
   *   <li>Then return builder password {@code 42} userName {@code janedoe} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#withPassword(String)}
   */
  @Test
  @DisplayName(
      "Test withPassword(String); then return builder password '42' userName 'janedoe' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLoginRequest ImmutableLoginRequest.withPassword(String)"})
  void testWithPassword_thenReturnBuilderPassword42UserNameJanedoeBuild() {
    // Arrange
    ImmutableLoginRequest immutableLoginRequest =
        ImmutableLoginRequest.builder().password("42").userName("janedoe").build();

    // Act
    ImmutableLoginRequest actualWithPasswordResult = immutableLoginRequest.withPassword("42");

    // Assert
    assertSame(immutableLoginRequest, actualWithPasswordResult);
  }

  /**
   * Test {@link ImmutableLoginRequest#withPassword(String)}.
   *
   * <ul>
   *   <li>Then return password is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#withPassword(String)}
   */
  @Test
  @DisplayName("Test withPassword(String); then return password is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLoginRequest ImmutableLoginRequest.withPassword(String)"})
  void testWithPassword_thenReturnPasswordIs42() {
    // Arrange and Act
    ImmutableLoginRequest actualWithPasswordResult =
        ImmutableLoginRequest.builder()
            .password("iloveyou")
            .userName("janedoe")
            .build()
            .withPassword("42");

    // Assert
    assertEquals("42", actualWithPasswordResult.password());
    assertEquals("janedoe", actualWithPasswordResult.userName());
  }

  /**
   * Test {@link ImmutableLoginRequest#withUserName(String)}.
   *
   * <ul>
   *   <li>Then return builder password {@code iloveyou} userName {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#withUserName(String)}
   */
  @Test
  @DisplayName(
      "Test withUserName(String); then return builder password 'iloveyou' userName '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLoginRequest ImmutableLoginRequest.withUserName(String)"})
  void testWithUserName_thenReturnBuilderPasswordIloveyouUserName42Build() {
    // Arrange
    ImmutableLoginRequest immutableLoginRequest =
        ImmutableLoginRequest.builder().password("iloveyou").userName("42").build();

    // Act
    ImmutableLoginRequest actualWithUserNameResult = immutableLoginRequest.withUserName("42");

    // Assert
    assertSame(immutableLoginRequest, actualWithUserNameResult);
  }

  /**
   * Test {@link ImmutableLoginRequest#withUserName(String)}.
   *
   * <ul>
   *   <li>Then return userName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLoginRequest#withUserName(String)}
   */
  @Test
  @DisplayName("Test withUserName(String); then return userName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLoginRequest ImmutableLoginRequest.withUserName(String)"})
  void testWithUserName_thenReturnUserNameIs42() {
    // Arrange and Act
    ImmutableLoginRequest actualWithUserNameResult =
        ImmutableLoginRequest.builder()
            .password("iloveyou")
            .userName("janedoe")
            .build()
            .withUserName("42");

    // Assert
    assertEquals("42", actualWithUserNameResult.userName());
    assertEquals("iloveyou", actualWithUserNameResult.password());
  }
}
