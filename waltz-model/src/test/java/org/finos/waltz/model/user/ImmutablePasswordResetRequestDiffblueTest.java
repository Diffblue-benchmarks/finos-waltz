package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.ImmutablePasswordResetRequest.Builder;
import org.finos.waltz.model.user.ImmutablePasswordResetRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePasswordResetRequestDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#currentPassword(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePasswordResetRequest Builder.build()",
    "Builder Builder.currentPassword(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutablePasswordResetRequest actualImmutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Assert
    assertEquals("iloveyou", actualImmutablePasswordResetRequest.currentPassword());
    assertEquals("iloveyou", actualImmutablePasswordResetRequest.newPassword());
    assertEquals("janedoe", actualImmutablePasswordResetRequest.userName());
  }

  /**
   * Test Builder {@link Builder#from(PasswordResetRequest)}.
   *
   * <p>Method under test: {@link Builder#from(PasswordResetRequest)}
   */
  @Test
  @DisplayName("Test Builder from(PasswordResetRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PasswordResetRequest)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePasswordResetRequest.builder();
    ImmutablePasswordResetRequest instance =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePasswordResetRequest actualImmutablePasswordResetRequest = builderResult.build();
    assertEquals(instance, actualImmutablePasswordResetRequest);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PasswordResetRequest)}.
   *
   * <p>Method under test: {@link Builder#from(PasswordResetRequest)}
   */
  @Test
  @DisplayName("Test Builder from(PasswordResetRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PasswordResetRequest)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePasswordResetRequest.builder();
    ImmutablePasswordResetRequest instance =
        ImmutablePasswordResetRequest.builder()
            .currentPassword(null)
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePasswordResetRequest actualImmutablePasswordResetRequest = builderResult.build();
    assertEquals(instance, actualImmutablePasswordResetRequest);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newPassword(String)}.
   *
   * <ul>
   *   <li>When {@code iloveyou}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#newPassword(String)}
   */
  @Test
  @DisplayName("Test Builder newPassword(String); when 'iloveyou'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newPassword(String)"})
  void testBuilderNewPassword_whenIloveyou_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePasswordResetRequest.builder();

    // Act
    Builder actualNewPasswordResult = builderResult.newPassword("iloveyou");

    // Assert
    assertSame(builderResult, actualNewPasswordResult);
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
    Builder builderResult = ImmutablePasswordResetRequest.builder();

    // Act
    Builder actualUserNameResult = builderResult.userName("janedoe");

    // Assert
    assertSame(builderResult, actualUserNameResult);
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#copyOf(PasswordResetRequest)}.
   *
   * <ul>
   *   <li>Then return currentPassword is {@code iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#copyOf(PasswordResetRequest)}
   */
  @Test
  @DisplayName("Test copyOf(PasswordResetRequest); then return currentPassword is 'iloveyou'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePasswordResetRequest ImmutablePasswordResetRequest.copyOf(PasswordResetRequest)"
  })
  void testCopyOf_thenReturnCurrentPasswordIsIloveyou() {
    // Arrange
    ImmutablePasswordResetRequest instance =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Act
    ImmutablePasswordResetRequest actualCopyOfResult =
        ImmutablePasswordResetRequest.copyOf(instance);

    // Assert
    assertEquals("iloveyou", actualCopyOfResult.currentPassword());
    assertEquals("iloveyou", actualCopyOfResult.newPassword());
    assertEquals("janedoe", actualCopyOfResult.userName());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#equals(Object)}, and {@link
   * ImmutablePasswordResetRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePasswordResetRequest#equals(Object)}
   *   <li>{@link ImmutablePasswordResetRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePasswordResetRequest.equals(Object)",
    "int ImmutablePasswordResetRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();
    ImmutablePasswordResetRequest immutablePasswordResetRequest2 =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertEquals(immutablePasswordResetRequest, immutablePasswordResetRequest2);
    assertEquals(
        immutablePasswordResetRequest.hashCode(), immutablePasswordResetRequest2.hashCode());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#equals(Object)}, and {@link
   * ImmutablePasswordResetRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePasswordResetRequest#equals(Object)}
   *   <li>{@link ImmutablePasswordResetRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePasswordResetRequest.equals(Object)",
    "int ImmutablePasswordResetRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertEquals(immutablePasswordResetRequest, immutablePasswordResetRequest);
    int expectedHashCodeResult = immutablePasswordResetRequest.hashCode();
    assertEquals(expectedHashCodeResult, immutablePasswordResetRequest.hashCode());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePasswordResetRequest.equals(Object)",
    "int ImmutablePasswordResetRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("janedoe")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePasswordResetRequest,
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePasswordResetRequest.equals(Object)",
    "int ImmutablePasswordResetRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("janedoe")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePasswordResetRequest,
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePasswordResetRequest.equals(Object)",
    "int ImmutablePasswordResetRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("iloveyou")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePasswordResetRequest,
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePasswordResetRequest.equals(Object)",
    "int ImmutablePasswordResetRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePasswordResetRequest.equals(Object)",
    "int ImmutablePasswordResetRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build(),
        "Different type to ImmutablePasswordResetRequest");
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) UserName is {@code Json}.
   *   <li>Then return currentPassword is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) UserName is 'Json'; then return currentPassword is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePasswordResetRequest ImmutablePasswordResetRequest.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonUserNameIsJson_thenReturnCurrentPasswordIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserName("Json");
    json.setCurrentPassword("Json");
    json.setNewPassword("Json");

    // Act
    ImmutablePasswordResetRequest actualFromJsonResult =
        ImmutablePasswordResetRequest.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.currentPassword());
    assertEquals("Json", actualFromJsonResult.newPassword());
    assertEquals("Json", actualFromJsonResult.userName());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) CurrentPassword is {@code null}.
   *   <li>Then return currentPassword is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) CurrentPassword is 'null'; then return currentPassword is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePasswordResetRequest ImmutablePasswordResetRequest.fromJson(Json)"})
  void testFromJson_whenJsonCurrentPasswordIsNull_thenReturnCurrentPasswordIsNull() {
    // Arrange
    Json json = new Json();
    json.setUserName("Json");
    json.setCurrentPassword(null);
    json.setNewPassword("Json");

    // Act
    ImmutablePasswordResetRequest actualFromJsonResult =
        ImmutablePasswordResetRequest.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.newPassword());
    assertEquals("Json", actualFromJsonResult.userName());
    assertNull(actualFromJsonResult.currentPassword());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePasswordResetRequest#toString()}
   *   <li>{@link ImmutablePasswordResetRequest#currentPassword()}
   *   <li>{@link ImmutablePasswordResetRequest#newPassword()}
   *   <li>{@link ImmutablePasswordResetRequest#userName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePasswordResetRequest.currentPassword()",
    "String ImmutablePasswordResetRequest.newPassword()",
    "String ImmutablePasswordResetRequest.toString()",
    "String ImmutablePasswordResetRequest.userName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Act
    String actualToStringResult = immutablePasswordResetRequest.toString();
    String actualCurrentPasswordResult = immutablePasswordResetRequest.currentPassword();
    String actualNewPasswordResult = immutablePasswordResetRequest.newPassword();

    // Assert
    assertEquals(
        "PasswordResetRequest{userName=janedoe, currentPassword=iloveyou, newPassword=iloveyou}",
        actualToStringResult);
    assertEquals("iloveyou", actualCurrentPasswordResult);
    assertEquals("iloveyou", actualNewPasswordResult);
    assertEquals("janedoe", immutablePasswordResetRequest.userName());
  }

  /**
   * Test Json {@link Json#currentPassword()}.
   *
   * <p>Method under test: {@link Json#currentPassword()}
   */
  @Test
  @DisplayName("Test Json currentPassword()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.currentPassword()"})
  void testJsonCurrentPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().currentPassword());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCurrentPassword(String)}
   *   <li>{@link Json#setNewPassword(String)}
   *   <li>{@link Json#setUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCurrentPassword(String)",
    "void Json.setNewPassword(String)",
    "void Json.setUserName(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCurrentPassword("iloveyou");
    actualJson.setNewPassword("iloveyou");
    actualJson.setUserName("janedoe");

    // Assert
    assertEquals("iloveyou", actualJson.currentPassword);
    assertEquals("iloveyou", actualJson.newPassword);
    assertEquals("janedoe", actualJson.userName);
  }

  /**
   * Test Json {@link Json#newPassword()}.
   *
   * <p>Method under test: {@link Json#newPassword()}
   */
  @Test
  @DisplayName("Test Json newPassword()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.newPassword()"})
  void testJsonNewPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newPassword());
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
   * Test {@link ImmutablePasswordResetRequest#withCurrentPassword(String)}.
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#withCurrentPassword(String)}
   */
  @Test
  @DisplayName("Test withCurrentPassword(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePasswordResetRequest ImmutablePasswordResetRequest.withCurrentPassword(String)"
  })
  void testWithCurrentPassword() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("42")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build();

    // Act
    ImmutablePasswordResetRequest actualWithCurrentPasswordResult =
        immutablePasswordResetRequest.withCurrentPassword("42");

    // Assert
    assertSame(immutablePasswordResetRequest, actualWithCurrentPasswordResult);
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#withCurrentPassword(String)}.
   *
   * <ul>
   *   <li>Then return currentPassword is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#withCurrentPassword(String)}
   */
  @Test
  @DisplayName("Test withCurrentPassword(String); then return currentPassword is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePasswordResetRequest ImmutablePasswordResetRequest.withCurrentPassword(String)"
  })
  void testWithCurrentPassword_thenReturnCurrentPasswordIs42() {
    // Arrange and Act
    ImmutablePasswordResetRequest actualWithCurrentPasswordResult =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build()
            .withCurrentPassword("42");

    // Assert
    assertEquals("42", actualWithCurrentPasswordResult.currentPassword());
    assertEquals("iloveyou", actualWithCurrentPasswordResult.newPassword());
    assertEquals("janedoe", actualWithCurrentPasswordResult.userName());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#withNewPassword(String)}.
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#withNewPassword(String)}
   */
  @Test
  @DisplayName("Test withNewPassword(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePasswordResetRequest ImmutablePasswordResetRequest.withNewPassword(String)"
  })
  void testWithNewPassword() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("42")
            .userName("janedoe")
            .build();

    // Act
    ImmutablePasswordResetRequest actualWithNewPasswordResult =
        immutablePasswordResetRequest.withNewPassword("42");

    // Assert
    assertSame(immutablePasswordResetRequest, actualWithNewPasswordResult);
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#withNewPassword(String)}.
   *
   * <ul>
   *   <li>Then return newPassword is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#withNewPassword(String)}
   */
  @Test
  @DisplayName("Test withNewPassword(String); then return newPassword is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePasswordResetRequest ImmutablePasswordResetRequest.withNewPassword(String)"
  })
  void testWithNewPassword_thenReturnNewPasswordIs42() {
    // Arrange and Act
    ImmutablePasswordResetRequest actualWithNewPasswordResult =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build()
            .withNewPassword("42");

    // Assert
    assertEquals("42", actualWithNewPasswordResult.newPassword());
    assertEquals("iloveyou", actualWithNewPasswordResult.currentPassword());
    assertEquals("janedoe", actualWithNewPasswordResult.userName());
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#withUserName(String)}.
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#withUserName(String)}
   */
  @Test
  @DisplayName("Test withUserName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePasswordResetRequest ImmutablePasswordResetRequest.withUserName(String)"
  })
  void testWithUserName() {
    // Arrange
    ImmutablePasswordResetRequest immutablePasswordResetRequest =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("42")
            .build();

    // Act
    ImmutablePasswordResetRequest actualWithUserNameResult =
        immutablePasswordResetRequest.withUserName("42");

    // Assert
    assertSame(immutablePasswordResetRequest, actualWithUserNameResult);
  }

  /**
   * Test {@link ImmutablePasswordResetRequest#withUserName(String)}.
   *
   * <ul>
   *   <li>Then return userName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePasswordResetRequest#withUserName(String)}
   */
  @Test
  @DisplayName("Test withUserName(String); then return userName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePasswordResetRequest ImmutablePasswordResetRequest.withUserName(String)"
  })
  void testWithUserName_thenReturnUserNameIs42() {
    // Arrange and Act
    ImmutablePasswordResetRequest actualWithUserNameResult =
        ImmutablePasswordResetRequest.builder()
            .currentPassword("iloveyou")
            .newPassword("iloveyou")
            .userName("janedoe")
            .build()
            .withUserName("42");

    // Assert
    assertEquals("42", actualWithUserNameResult.userName());
    assertEquals("iloveyou", actualWithUserNameResult.currentPassword());
    assertEquals("iloveyou", actualWithUserNameResult.newPassword());
  }
}
