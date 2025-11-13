package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.ImmutableUserRegistrationRequest.Builder;
import org.finos.waltz.model.user.ImmutableUserRegistrationRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserRegistrationRequestDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserRegistrationRequest Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUserRegistrationRequest actualImmutableUserRegistrationRequest =
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build();

    // Assert
    assertEquals("iloveyou", actualImmutableUserRegistrationRequest.password());
    assertEquals("janedoe", actualImmutableUserRegistrationRequest.userName());
  }

  /**
   * Test Builder {@link Builder#from(UserRegistrationRequest)}.
   *
   * <ul>
   *   <li>Then builder build is builder password {@code iloveyou} userName {@code janedoe} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UserRegistrationRequest)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UserRegistrationRequest); then builder build is builder password 'iloveyou' userName 'janedoe' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserRegistrationRequest)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderPasswordIloveyouUserNameJanedoeBuild() {
    // Arrange
    Builder builderResult = ImmutableUserRegistrationRequest.builder();
    ImmutableUserRegistrationRequest instance =
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUserRegistrationRequest actualImmutableUserRegistrationRequest = builderResult.build();
    assertEquals(instance, actualImmutableUserRegistrationRequest);
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
    Builder builderResult = ImmutableUserRegistrationRequest.builder();

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
    Builder builderResult = ImmutableUserRegistrationRequest.builder();

    // Act
    Builder actualUserNameResult = builderResult.userName("janedoe");

    // Assert
    assertSame(builderResult, actualUserNameResult);
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#copyOf(UserRegistrationRequest)}.
   *
   * <ul>
   *   <li>Then return password is {@code iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#copyOf(UserRegistrationRequest)}
   */
  @Test
  @DisplayName("Test copyOf(UserRegistrationRequest); then return password is 'iloveyou'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserRegistrationRequest ImmutableUserRegistrationRequest.copyOf(UserRegistrationRequest)"
  })
  void testCopyOf_thenReturnPasswordIsIloveyou() {
    // Arrange
    ImmutableUserRegistrationRequest instance =
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act
    ImmutableUserRegistrationRequest actualCopyOfResult =
        ImmutableUserRegistrationRequest.copyOf(instance);

    // Assert
    assertEquals("iloveyou", actualCopyOfResult.password());
    assertEquals("janedoe", actualCopyOfResult.userName());
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#equals(Object)}, and {@link
   * ImmutableUserRegistrationRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserRegistrationRequest#equals(Object)}
   *   <li>{@link ImmutableUserRegistrationRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserRegistrationRequest.equals(Object)",
    "int ImmutableUserRegistrationRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUserRegistrationRequest immutableUserRegistrationRequest =
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build();
    ImmutableUserRegistrationRequest immutableUserRegistrationRequest2 =
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act and Assert
    assertEquals(immutableUserRegistrationRequest, immutableUserRegistrationRequest2);
    assertEquals(
        immutableUserRegistrationRequest.hashCode(), immutableUserRegistrationRequest2.hashCode());
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#equals(Object)}, and {@link
   * ImmutableUserRegistrationRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserRegistrationRequest#equals(Object)}
   *   <li>{@link ImmutableUserRegistrationRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserRegistrationRequest.equals(Object)",
    "int ImmutableUserRegistrationRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUserRegistrationRequest immutableUserRegistrationRequest =
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act and Assert
    assertEquals(immutableUserRegistrationRequest, immutableUserRegistrationRequest);
    int expectedHashCodeResult = immutableUserRegistrationRequest.hashCode();
    assertEquals(expectedHashCodeResult, immutableUserRegistrationRequest.hashCode());
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserRegistrationRequest.equals(Object)",
    "int ImmutableUserRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUserRegistrationRequest immutableUserRegistrationRequest =
        ImmutableUserRegistrationRequest.builder().password("janedoe").userName("janedoe").build();

    // Act and Assert
    assertNotEquals(
        immutableUserRegistrationRequest,
        ImmutableUserRegistrationRequest.builder()
            .password("iloveyou")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserRegistrationRequest.equals(Object)",
    "int ImmutableUserRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUserRegistrationRequest immutableUserRegistrationRequest =
        ImmutableUserRegistrationRequest.builder()
            .password("iloveyou")
            .userName("iloveyou")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUserRegistrationRequest,
        ImmutableUserRegistrationRequest.builder()
            .password("iloveyou")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserRegistrationRequest.equals(Object)",
    "int ImmutableUserRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build(),
        null);
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserRegistrationRequest.equals(Object)",
    "int ImmutableUserRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build(),
        "Different type to ImmutableUserRegistrationRequest");
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) UserName is {@code Json}.
   *   <li>Then return password is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) UserName is 'Json'; then return password is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserRegistrationRequest ImmutableUserRegistrationRequest.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonUserNameIsJson_thenReturnPasswordIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserName("Json");
    json.setPassword("Json");

    // Act
    ImmutableUserRegistrationRequest actualFromJsonResult =
        ImmutableUserRegistrationRequest.fromJson(json);

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
   *   <li>{@link ImmutableUserRegistrationRequest#toString()}
   *   <li>{@link ImmutableUserRegistrationRequest#password()}
   *   <li>{@link ImmutableUserRegistrationRequest#userName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUserRegistrationRequest.password()",
    "String ImmutableUserRegistrationRequest.toString()",
    "String ImmutableUserRegistrationRequest.userName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUserRegistrationRequest immutableUserRegistrationRequest =
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("janedoe").build();

    // Act
    String actualToStringResult = immutableUserRegistrationRequest.toString();
    String actualPasswordResult = immutableUserRegistrationRequest.password();

    // Assert
    assertEquals(
        "UserRegistrationRequest{userName=janedoe, password=iloveyou}", actualToStringResult);
    assertEquals("iloveyou", actualPasswordResult);
    assertEquals("janedoe", immutableUserRegistrationRequest.userName());
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
   * Test {@link ImmutableUserRegistrationRequest#withPassword(String)}.
   *
   * <ul>
   *   <li>Then return builder password {@code 42} userName {@code janedoe} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#withPassword(String)}
   */
  @Test
  @DisplayName(
      "Test withPassword(String); then return builder password '42' userName 'janedoe' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserRegistrationRequest ImmutableUserRegistrationRequest.withPassword(String)"
  })
  void testWithPassword_thenReturnBuilderPassword42UserNameJanedoeBuild() {
    // Arrange
    ImmutableUserRegistrationRequest immutableUserRegistrationRequest =
        ImmutableUserRegistrationRequest.builder().password("42").userName("janedoe").build();

    // Act
    ImmutableUserRegistrationRequest actualWithPasswordResult =
        immutableUserRegistrationRequest.withPassword("42");

    // Assert
    assertSame(immutableUserRegistrationRequest, actualWithPasswordResult);
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#withPassword(String)}.
   *
   * <ul>
   *   <li>Then return password is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#withPassword(String)}
   */
  @Test
  @DisplayName("Test withPassword(String); then return password is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserRegistrationRequest ImmutableUserRegistrationRequest.withPassword(String)"
  })
  void testWithPassword_thenReturnPasswordIs42() {
    // Arrange and Act
    ImmutableUserRegistrationRequest actualWithPasswordResult =
        ImmutableUserRegistrationRequest.builder()
            .password("iloveyou")
            .userName("janedoe")
            .build()
            .withPassword("42");

    // Assert
    assertEquals("42", actualWithPasswordResult.password());
    assertEquals("janedoe", actualWithPasswordResult.userName());
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#withUserName(String)}.
   *
   * <ul>
   *   <li>Then return builder password {@code iloveyou} userName {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#withUserName(String)}
   */
  @Test
  @DisplayName(
      "Test withUserName(String); then return builder password 'iloveyou' userName '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserRegistrationRequest ImmutableUserRegistrationRequest.withUserName(String)"
  })
  void testWithUserName_thenReturnBuilderPasswordIloveyouUserName42Build() {
    // Arrange
    ImmutableUserRegistrationRequest immutableUserRegistrationRequest =
        ImmutableUserRegistrationRequest.builder().password("iloveyou").userName("42").build();

    // Act
    ImmutableUserRegistrationRequest actualWithUserNameResult =
        immutableUserRegistrationRequest.withUserName("42");

    // Assert
    assertSame(immutableUserRegistrationRequest, actualWithUserNameResult);
  }

  /**
   * Test {@link ImmutableUserRegistrationRequest#withUserName(String)}.
   *
   * <ul>
   *   <li>Then return userName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserRegistrationRequest#withUserName(String)}
   */
  @Test
  @DisplayName("Test withUserName(String); then return userName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserRegistrationRequest ImmutableUserRegistrationRequest.withUserName(String)"
  })
  void testWithUserName_thenReturnUserNameIs42() {
    // Arrange and Act
    ImmutableUserRegistrationRequest actualWithUserNameResult =
        ImmutableUserRegistrationRequest.builder()
            .password("iloveyou")
            .userName("janedoe")
            .build()
            .withUserName("42");

    // Assert
    assertEquals("42", actualWithUserNameResult.userName());
    assertEquals("iloveyou", actualWithUserNameResult.password());
  }
}
