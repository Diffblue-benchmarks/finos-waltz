package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.ImmutableSimple.Builder;
import org.finos.waltz.model.ImmutableSimple.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSimpleDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#secret(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple Builder.build()", "Builder Builder.secret(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualSecretResult =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret");
    Optional<String> secret = Optional.of("42");

    // Assert
    assertEquals(
        "Not all who wander are lost", actualSecretResult.secret(secret).build().message());
  }

  /**
   * Test Builder {@link Builder#from(Simple)}.
   *
   * <p>Method under test: {@link Builder#from(Simple)}
   */
  @Test
  @DisplayName("Test Builder from(Simple)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Simple)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSimple.builder();
    ImmutableSimple instance =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSimple actualImmutableSimple = builderResult.build();
    assertEquals(instance, actualImmutableSimple);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#message(String)}.
   *
   * <ul>
   *   <li>Then builder build message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#message(String)}
   */
  @Test
  @DisplayName(
      "Test Builder message(String); then builder build message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.message(String)"})
  void testBuilderMessage_thenBuilderBuildMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    Builder builderResult = ImmutableSimple.builder();

    // Act
    Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link Builder#secret(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#secret(Optional)}
   */
  @Test
  @DisplayName("Test Builder secret(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.secret(Optional)"})
  void testBuilderSecretWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSimple.builder();
    Optional<String> secret = Optional.of("42");

    // Act
    Builder actualSecretResult = builderResult.secret(secret);

    // Assert
    assertSame(builderResult, actualSecretResult);
  }

  /**
   * Test {@link ImmutableSimple#copyOf(Simple)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#copyOf(Simple)}
   */
  @Test
  @DisplayName("Test copyOf(Simple); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.copyOf(Simple)"})
  void testCopyOf_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutableSimple instance =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build();

    // Act and Assert
    assertEquals("Not all who wander are lost", ImmutableSimple.copyOf(instance).message());
  }

  /**
   * Test {@link ImmutableSimple#equals(Object)}, and {@link ImmutableSimple#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSimple#equals(Object)}
   *   <li>{@link ImmutableSimple#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSimple.equals(Object)", "int ImmutableSimple.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSimple immutableSimple =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build();
    ImmutableSimple immutableSimple2 =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build();

    // Act and Assert
    assertEquals(immutableSimple, immutableSimple2);
    assertEquals(immutableSimple.hashCode(), immutableSimple2.hashCode());
  }

  /**
   * Test {@link ImmutableSimple#equals(Object)}, and {@link ImmutableSimple#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSimple#equals(Object)}
   *   <li>{@link ImmutableSimple#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSimple.equals(Object)", "int ImmutableSimple.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSimple immutableSimple =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build();

    // Act and Assert
    assertEquals(immutableSimple, immutableSimple);
    int expectedHashCodeResult = immutableSimple.hashCode();
    assertEquals(expectedHashCodeResult, immutableSimple.hashCode());
  }

  /**
   * Test {@link ImmutableSimple#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSimple.equals(Object)", "int ImmutableSimple.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSimple immutableSimple =
        ImmutableSimple.builder().message("Message").secret("Secret").build();

    // Act and Assert
    assertNotEquals(
        immutableSimple,
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build());
  }

  /**
   * Test {@link ImmutableSimple#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSimple.equals(Object)", "int ImmutableSimple.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSimple immutableSimple =
        ImmutableSimple.builder()
            .message("Not all who wander are lost")
            .secret("Not all who wander are lost")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSimple,
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build());
  }

  /**
   * Test {@link ImmutableSimple#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSimple.equals(Object)", "int ImmutableSimple.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build(),
        null);
  }

  /**
   * Test {@link ImmutableSimple#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSimple.equals(Object)", "int ImmutableSimple.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build(),
        "Different type to ImmutableSimple");
  }

  /**
   * Test {@link ImmutableSimple#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Secret is {@code null}.
   *   <li>Then return message is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Secret is 'null'; then return message is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonSecretIsNull_thenReturnMessageIsJson() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    json.setSecret(null);

    // Act
    ImmutableSimple actualFromJsonResult = ImmutableSimple.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
  }

  /**
   * Test {@link ImmutableSimple#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) Secret is of {@code 42}.
   *   <li>Then return message is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) Secret is of '42'; then return message is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.fromJson(Json)"})
  void testFromJson_givenOf42_whenJsonSecretIsOf42_thenReturnMessageIsJson() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    Optional<String> secret = Optional.of("42");
    json.setSecret(secret);

    // Act
    ImmutableSimple actualFromJsonResult = ImmutableSimple.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
  }

  /**
   * Test Json {@link Json#message()}.
   *
   * <p>Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().message());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.message);
    assertFalse(actualJson.secret.isPresent());
  }

  /**
   * Test Json {@link Json#secret()}.
   *
   * <p>Method under test: {@link Json#secret()}
   */
  @Test
  @DisplayName("Test Json secret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.secret()"})
  void testJsonSecret() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().secret());
  }

  /**
   * Test {@link ImmutableSimple#message()}.
   *
   * <p>Method under test: {@link ImmutableSimple#message()}
   */
  @Test
  @DisplayName("Test message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSimple.message()"})
  void testMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        ImmutableSimple.builder()
            .message("Not all who wander are lost")
            .secret("Secret")
            .build()
            .message());
  }

  /**
   * Test {@link ImmutableSimple#secret()}.
   *
   * <p>Method under test: {@link ImmutableSimple#secret()}
   */
  @Test
  @DisplayName("Test secret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSimple.secret()"})
  void testSecret() {
    // Arrange and Act
    Optional<String> actualSecretResult =
        ImmutableSimple.builder()
            .message("Not all who wander are lost")
            .secret("Secret")
            .build()
            .secret();

    // Assert
    assertEquals("Secret", actualSecretResult.get());
    assertTrue(actualSecretResult.isPresent());
  }

  /**
   * Test {@link ImmutableSimple#toString()}.
   *
   * <p>Method under test: {@link ImmutableSimple#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSimple.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Simple{message=Not all who wander are lost, secret=Secret}",
        ImmutableSimple.builder()
            .message("Not all who wander are lost")
            .secret("Secret")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSimple#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return builder message {@code 42} secret {@code Secret} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then return builder message '42' secret 'Secret' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.withMessage(String)"})
  void testWithMessage_thenReturnBuilderMessage42SecretSecretBuild() {
    // Arrange
    ImmutableSimple immutableSimple =
        ImmutableSimple.builder().message("42").secret("Secret").build();

    // Act
    ImmutableSimple actualWithMessageResult = immutableSimple.withMessage("42");

    // Assert
    assertSame(immutableSimple, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableSimple#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return message is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then return message is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.withMessage(String)"})
  void testWithMessage_thenReturnMessageIs42() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        ImmutableSimple.builder()
            .message("Not all who wander are lost")
            .secret("Secret")
            .build()
            .withMessage("42")
            .message());
  }

  /**
   * Test {@link ImmutableSimple#withSecret(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSimple#withSecret(Optional)}
   */
  @Test
  @DisplayName("Test withSecret(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.withSecret(Optional)"})
  void testWithSecretWithOptional() {
    // Arrange
    ImmutableSimple immutableSimple =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("42").build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSimple actualWithSecretResult = immutableSimple.withSecret(optional);

    // Assert
    assertSame(immutableSimple, actualWithSecretResult);
  }

  /**
   * Test {@link ImmutableSimple#withSecret(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#withSecret(Optional)}
   */
  @Test
  @DisplayName(
      "Test withSecret(Optional) with 'optional'; then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.withSecret(Optional)"})
  void testWithSecretWithOptional_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutableSimple immutableSimple =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("Secret").build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertEquals("Not all who wander are lost", immutableSimple.withSecret(optional).message());
  }

  /**
   * Test {@link ImmutableSimple#withSecret(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSimple#withSecret(String)}
   */
  @Test
  @DisplayName("Test withSecret(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.withSecret(String)"})
  void testWithSecretWithValue() {
    // Arrange
    ImmutableSimple immutableSimple =
        ImmutableSimple.builder().message("Not all who wander are lost").secret("42").build();

    // Act
    ImmutableSimple actualWithSecretResult = immutableSimple.withSecret("42");

    // Assert
    assertSame(immutableSimple, actualWithSecretResult);
  }

  /**
   * Test {@link ImmutableSimple#withSecret(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSimple#withSecret(String)}
   */
  @Test
  @DisplayName(
      "Test withSecret(String) with 'value'; then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSimple ImmutableSimple.withSecret(String)"})
  void testWithSecretWithValue_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        ImmutableSimple.builder()
            .message("Not all who wander are lost")
            .secret("Secret")
            .build()
            .withSecret("42")
            .message());
  }
}
