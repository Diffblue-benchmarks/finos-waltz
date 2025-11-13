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
import org.finos.waltz.model.ImmutableWebError.Builder;
import org.finos.waltz.model.ImmutableWebError.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableWebErrorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#id(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError Builder.build()", "Builder Builder.id(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult = ImmutableWebError.builder().id("42");
    Optional<String> id = Optional.of("42");

    // Assert
    assertEquals(
        "Not all who wander are lost",
        actualIdResult.id(id).message("Not all who wander are lost").build().message());
  }

  /**
   * Test Builder {@link Builder#from(WebError)}.
   *
   * <ul>
   *   <li>Then builder build is builder id {@code 42} message {@code Not all who wander are lost}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(WebError)}
   */
  @Test
  @DisplayName(
      "Test Builder from(WebError); then builder build is builder id '42' message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WebError)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderId42MessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    Builder builderResult = ImmutableWebError.builder();
    ImmutableWebError instance =
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableWebError actualImmutableWebError = builderResult.build();
    assertEquals(instance, actualImmutableWebError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableWebError.builder();
    Optional<String> id = Optional.of("42");

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableWebError.builder();

    // Act
    Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test {@link ImmutableWebError#copyOf(WebError)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#copyOf(WebError)}
   */
  @Test
  @DisplayName("Test copyOf(WebError); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.copyOf(WebError)"})
  void testCopyOf_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutableWebError instance =
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build();

    // Act and Assert
    assertEquals("Not all who wander are lost", ImmutableWebError.copyOf(instance).message());
  }

  /**
   * Test {@link ImmutableWebError#equals(Object)}, and {@link ImmutableWebError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableWebError#equals(Object)}
   *   <li>{@link ImmutableWebError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWebError.equals(Object)",
    "int ImmutableWebError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableWebError immutableWebError =
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build();
    ImmutableWebError immutableWebError2 =
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build();

    // Act and Assert
    assertEquals(immutableWebError, immutableWebError2);
    assertEquals(immutableWebError.hashCode(), immutableWebError2.hashCode());
  }

  /**
   * Test {@link ImmutableWebError#equals(Object)}, and {@link ImmutableWebError#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableWebError#equals(Object)}
   *   <li>{@link ImmutableWebError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWebError.equals(Object)",
    "int ImmutableWebError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableWebError immutableWebError =
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build();

    // Act and Assert
    assertEquals(immutableWebError, immutableWebError);
    int expectedHashCodeResult = immutableWebError.hashCode();
    assertEquals(expectedHashCodeResult, immutableWebError.hashCode());
  }

  /**
   * Test {@link ImmutableWebError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWebError.equals(Object)",
    "int ImmutableWebError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableWebError immutableWebError =
        ImmutableWebError.builder()
            .id("Not all who wander are lost")
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableWebError,
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build());
  }

  /**
   * Test {@link ImmutableWebError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWebError.equals(Object)",
    "int ImmutableWebError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableWebError immutableWebError =
        ImmutableWebError.builder().id("42").message("Message").build();

    // Act and Assert
    assertNotEquals(
        immutableWebError,
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build());
  }

  /**
   * Test {@link ImmutableWebError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWebError.equals(Object)",
    "int ImmutableWebError.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build(), null);
  }

  /**
   * Test {@link ImmutableWebError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWebError.equals(Object)",
    "int ImmutableWebError.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build(),
        "Different type to ImmutableWebError");
  }

  /**
   * Test {@link ImmutableWebError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return message is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return message is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnMessageIsJson() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    json.setId(null);

    // Act
    ImmutableWebError actualFromJsonResult = ImmutableWebError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
  }

  /**
   * Test {@link ImmutableWebError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) Id is of {@code 42}.
   *   <li>Then return message is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) Id is of '42'; then return message is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.fromJson(Json)"})
  void testFromJson_givenOf42_whenJsonIdIsOf42_thenReturnMessageIsJson() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    Optional<String> id = Optional.of("42");
    json.setId(id);

    // Act
    ImmutableWebError actualFromJsonResult = ImmutableWebError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
  }

  /**
   * Test {@link ImmutableWebError#id()}.
   *
   * <p>Method under test: {@link ImmutableWebError#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableWebError.id()"})
  void testId() {
    // Arrange and Act
    Optional<String> actualIdResult =
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build().id();

    // Assert
    assertEquals("42", actualIdResult.get());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
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
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test {@link ImmutableWebError#message()}.
   *
   * <p>Method under test: {@link ImmutableWebError#message()}
   */
  @Test
  @DisplayName("Test message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableWebError.message()"})
  void testMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        ImmutableWebError.builder()
            .id("42")
            .message("Not all who wander are lost")
            .build()
            .message());
  }

  /**
   * Test {@link ImmutableWebError#toString()}.
   *
   * <p>Method under test: {@link ImmutableWebError#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableWebError.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "WebError{message=Not all who wander are lost, id=42}",
        ImmutableWebError.builder()
            .id("42")
            .message("Not all who wander are lost")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableWebError#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return builder id {@code 42} message {@code Not all who wander are lost} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return builder id '42' message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.withId(Optional)"})
  void testWithIdWithOptional_thenReturnBuilderId42MessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    ImmutableWebError immutableWebError =
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableWebError actualWithIdResult = immutableWebError.withId(optional);

    // Assert
    assertSame(immutableWebError, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableWebError#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.withId(Optional)"})
  void testWithIdWithOptional_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutableWebError immutableWebError =
        ImmutableWebError.builder().id("Id").message("Not all who wander are lost").build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertEquals("Not all who wander are lost", immutableWebError.withId(optional).message());
  }

  /**
   * Test {@link ImmutableWebError#withId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return builder id {@code 42} message {@code Not all who wander are lost} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#withId(String)}
   */
  @Test
  @DisplayName(
      "Test withId(String) with 'value'; then return builder id '42' message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.withId(String)"})
  void testWithIdWithValue_thenReturnBuilderId42MessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    ImmutableWebError immutableWebError =
        ImmutableWebError.builder().id("42").message("Not all who wander are lost").build();

    // Act
    ImmutableWebError actualWithIdResult = immutableWebError.withId("42");

    // Assert
    assertSame(immutableWebError, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableWebError#withId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#withId(String)}
   */
  @Test
  @DisplayName(
      "Test withId(String) with 'value'; then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.withId(String)"})
  void testWithIdWithValue_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        ImmutableWebError.builder()
            .id("id")
            .message("Not all who wander are lost")
            .build()
            .withId("42")
            .message());
  }

  /**
   * Test {@link ImmutableWebError#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return builder id {@code 42} message {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then return builder id '42' message '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.withMessage(String)"})
  void testWithMessage_thenReturnBuilderId42Message42Build() {
    // Arrange
    ImmutableWebError immutableWebError =
        ImmutableWebError.builder().id("42").message("42").build();

    // Act
    ImmutableWebError actualWithMessageResult = immutableWebError.withMessage("42");

    // Assert
    assertSame(immutableWebError, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableWebError#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return message is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWebError#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then return message is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWebError ImmutableWebError.withMessage(String)"})
  void testWithMessage_thenReturnMessageIs42() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        ImmutableWebError.builder()
            .id("42")
            .message("Not all who wander are lost")
            .build()
            .withMessage("42")
            .message());
  }
}
