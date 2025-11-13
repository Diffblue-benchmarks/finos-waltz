package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.ImmutableAuthenticationResponse.Builder;
import org.finos.waltz.model.user.ImmutableAuthenticationResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAuthenticationResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#errorMessage(String)}
   *   <li>{@link Builder#waltzUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAuthenticationResponse Builder.build()",
    "Builder Builder.errorMessage(String)",
    "Builder Builder.waltzUserName(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAuthenticationResponse actualImmutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Assert
    assertEquals("An error occurred", actualImmutableAuthenticationResponse.errorMessage());
    assertEquals("janedoe", actualImmutableAuthenticationResponse.waltzUserName());
    assertTrue(actualImmutableAuthenticationResponse.success());
  }

  /**
   * Test Builder {@link Builder#from(AuthenticationResponse)}.
   *
   * <p>Method under test: {@link Builder#from(AuthenticationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AuthenticationResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AuthenticationResponse)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAuthenticationResponse.builder();
    ImmutableAuthenticationResponse instance =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAuthenticationResponse actualImmutableAuthenticationResponse = builderResult.build();
    assertEquals(instance, actualImmutableAuthenticationResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AuthenticationResponse)}.
   *
   * <p>Method under test: {@link Builder#from(AuthenticationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AuthenticationResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AuthenticationResponse)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAuthenticationResponse.builder();
    ImmutableAuthenticationResponse instance =
        ImmutableAuthenticationResponse.builder()
            .errorMessage(null)
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAuthenticationResponse actualImmutableAuthenticationResponse = builderResult.build();
    assertEquals(instance, actualImmutableAuthenticationResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AuthenticationResponse)}.
   *
   * <p>Method under test: {@link Builder#from(AuthenticationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AuthenticationResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AuthenticationResponse)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableAuthenticationResponse.builder();
    ImmutableAuthenticationResponse instance =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAuthenticationResponse actualImmutableAuthenticationResponse = builderResult.build();
    assertEquals(instance, actualImmutableAuthenticationResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#success(boolean)}.
   *
   * <p>Method under test: {@link Builder#success(boolean)}
   */
  @Test
  @DisplayName("Test Builder success(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.success(boolean)"})
  void testBuilderSuccess() {
    // Arrange
    Builder builderResult = ImmutableAuthenticationResponse.builder();

    // Act
    Builder actualSuccessResult = builderResult.success(true);

    // Assert
    ImmutableAuthenticationResponse immutableAuthenticationResponse = builderResult.build();
    assertNull(immutableAuthenticationResponse.errorMessage());
    assertNull(immutableAuthenticationResponse.waltzUserName());
    assertTrue(immutableAuthenticationResponse.success());
    assertSame(builderResult, actualSuccessResult);
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#copyOf(AuthenticationResponse)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#copyOf(AuthenticationResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AuthenticationResponse); then return errorMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAuthenticationResponse ImmutableAuthenticationResponse.copyOf(AuthenticationResponse)"
  })
  void testCopyOf_thenReturnErrorMessageIsAnErrorOccurred() {
    // Arrange
    ImmutableAuthenticationResponse instance =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act
    ImmutableAuthenticationResponse actualCopyOfResult =
        ImmutableAuthenticationResponse.copyOf(instance);

    // Assert
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals("janedoe", actualCopyOfResult.waltzUserName());
    assertTrue(actualCopyOfResult.success());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#equals(Object)}, and {@link
   * ImmutableAuthenticationResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAuthenticationResponse#equals(Object)}
   *   <li>{@link ImmutableAuthenticationResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAuthenticationResponse.equals(Object)",
    "int ImmutableAuthenticationResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build();
    ImmutableAuthenticationResponse immutableAuthenticationResponse2 =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act and Assert
    assertEquals(immutableAuthenticationResponse, immutableAuthenticationResponse2);
    assertEquals(
        immutableAuthenticationResponse.hashCode(), immutableAuthenticationResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#equals(Object)}, and {@link
   * ImmutableAuthenticationResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAuthenticationResponse#equals(Object)}
   *   <li>{@link ImmutableAuthenticationResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAuthenticationResponse.equals(Object)",
    "int ImmutableAuthenticationResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act and Assert
    assertEquals(immutableAuthenticationResponse, immutableAuthenticationResponse);
    int expectedHashCodeResult = immutableAuthenticationResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableAuthenticationResponse.hashCode());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAuthenticationResponse.equals(Object)",
    "int ImmutableAuthenticationResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("Error Message")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAuthenticationResponse,
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAuthenticationResponse.equals(Object)",
    "int ImmutableAuthenticationResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(false)
            .waltzUserName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAuthenticationResponse,
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAuthenticationResponse.equals(Object)",
    "int ImmutableAuthenticationResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("Waltz User Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAuthenticationResponse,
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAuthenticationResponse.equals(Object)",
    "int ImmutableAuthenticationResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAuthenticationResponse.equals(Object)",
    "int ImmutableAuthenticationResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build(),
        "Different type to ImmutableAuthenticationResponse");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAuthenticationResponse#toString()}
   *   <li>{@link ImmutableAuthenticationResponse#errorMessage()}
   *   <li>{@link ImmutableAuthenticationResponse#success()}
   *   <li>{@link ImmutableAuthenticationResponse#waltzUserName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAuthenticationResponse.errorMessage()",
    "boolean ImmutableAuthenticationResponse.success()",
    "String ImmutableAuthenticationResponse.toString()",
    "String ImmutableAuthenticationResponse.waltzUserName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act
    String actualToStringResult = immutableAuthenticationResponse.toString();
    String actualErrorMessageResult = immutableAuthenticationResponse.errorMessage();
    boolean actualSuccessResult = immutableAuthenticationResponse.success();

    // Assert
    assertEquals("An error occurred", actualErrorMessageResult);
    assertEquals(
        "AuthenticationResponse{success=true, waltzUserName=janedoe, errorMessage=An error occurred}",
        actualToStringResult);
    assertEquals("janedoe", immutableAuthenticationResponse.waltzUserName());
    assertTrue(actualSuccessResult);
  }

  /**
   * Test Json {@link Json#errorMessage()}.
   *
   * <p>Method under test: {@link Json#errorMessage()}
   */
  @Test
  @DisplayName("Test Json errorMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.errorMessage()"})
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errorMessage());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setErrorMessage(String)}
   *   <li>{@link Json#setWaltzUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setErrorMessage(String)",
    "void Json.setWaltzUserName(String)"
  })
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
   *
   * <p>Method under test: {@link Json#setSuccess(boolean)}
   */
  @Test
  @DisplayName("Test Json setSuccess(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#success()}
   */
  @Test
  @DisplayName("Test Json success()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.success()"})
  void testJsonSuccess() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().success());
  }

  /**
   * Test Json {@link Json#waltzUserName()}.
   *
   * <p>Method under test: {@link Json#waltzUserName()}
   */
  @Test
  @DisplayName("Test Json waltzUserName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.waltzUserName()"})
  void testJsonWaltzUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().waltzUserName());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#withErrorMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#withErrorMessage(String)}
   */
  @Test
  @DisplayName("Test withErrorMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAuthenticationResponse ImmutableAuthenticationResponse.withErrorMessage(String)"
  })
  void testWithErrorMessage() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("42")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act
    ImmutableAuthenticationResponse actualWithErrorMessageResult =
        immutableAuthenticationResponse.withErrorMessage("42");

    // Assert
    assertSame(immutableAuthenticationResponse, actualWithErrorMessageResult);
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#withErrorMessage(String)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#withErrorMessage(String)}
   */
  @Test
  @DisplayName("Test withErrorMessage(String); then return errorMessage is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAuthenticationResponse ImmutableAuthenticationResponse.withErrorMessage(String)"
  })
  void testWithErrorMessage_thenReturnErrorMessageIs42() {
    // Arrange and Act
    ImmutableAuthenticationResponse actualWithErrorMessageResult =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build()
            .withErrorMessage("42");

    // Assert
    assertEquals("42", actualWithErrorMessageResult.errorMessage());
    assertEquals("janedoe", actualWithErrorMessageResult.waltzUserName());
    assertTrue(actualWithErrorMessageResult.success());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#withSuccess(boolean)}.
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#withSuccess(boolean)}
   */
  @Test
  @DisplayName("Test withSuccess(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAuthenticationResponse ImmutableAuthenticationResponse.withSuccess(boolean)"
  })
  void testWithSuccess() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build();

    // Act
    ImmutableAuthenticationResponse actualWithSuccessResult =
        immutableAuthenticationResponse.withSuccess(true);

    // Assert
    assertSame(immutableAuthenticationResponse, actualWithSuccessResult);
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#withSuccess(boolean)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#withSuccess(boolean)}
   */
  @Test
  @DisplayName("Test withSuccess(boolean); then return errorMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAuthenticationResponse ImmutableAuthenticationResponse.withSuccess(boolean)"
  })
  void testWithSuccess_thenReturnErrorMessageIsAnErrorOccurred() {
    // Arrange and Act
    ImmutableAuthenticationResponse actualWithSuccessResult =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(false)
            .waltzUserName("janedoe")
            .build()
            .withSuccess(true);

    // Assert
    assertEquals("An error occurred", actualWithSuccessResult.errorMessage());
    assertEquals("janedoe", actualWithSuccessResult.waltzUserName());
    assertTrue(actualWithSuccessResult.success());
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#withWaltzUserName(String)}.
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#withWaltzUserName(String)}
   */
  @Test
  @DisplayName("Test withWaltzUserName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAuthenticationResponse ImmutableAuthenticationResponse.withWaltzUserName(String)"
  })
  void testWithWaltzUserName() {
    // Arrange
    ImmutableAuthenticationResponse immutableAuthenticationResponse =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("42")
            .build();

    // Act
    ImmutableAuthenticationResponse actualWithWaltzUserNameResult =
        immutableAuthenticationResponse.withWaltzUserName("42");

    // Assert
    assertSame(immutableAuthenticationResponse, actualWithWaltzUserNameResult);
  }

  /**
   * Test {@link ImmutableAuthenticationResponse#withWaltzUserName(String)}.
   *
   * <ul>
   *   <li>Then return waltzUserName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAuthenticationResponse#withWaltzUserName(String)}
   */
  @Test
  @DisplayName("Test withWaltzUserName(String); then return waltzUserName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAuthenticationResponse ImmutableAuthenticationResponse.withWaltzUserName(String)"
  })
  void testWithWaltzUserName_thenReturnWaltzUserNameIs42() {
    // Arrange and Act
    ImmutableAuthenticationResponse actualWithWaltzUserNameResult =
        ImmutableAuthenticationResponse.builder()
            .errorMessage("An error occurred")
            .success(true)
            .waltzUserName("janedoe")
            .build()
            .withWaltzUserName("42");

    // Assert
    assertEquals("42", actualWithWaltzUserNameResult.waltzUserName());
    assertEquals("An error occurred", actualWithWaltzUserNameResult.errorMessage());
    assertTrue(actualWithWaltzUserNameResult.success());
  }
}
