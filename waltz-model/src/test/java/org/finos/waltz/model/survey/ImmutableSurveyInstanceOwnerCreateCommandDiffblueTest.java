package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwnerCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwnerCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceOwnerCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceOwnerCreateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceOwnerCreateCommand actualImmutableSurveyInstanceOwnerCreateCommand =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Assert
    assertEquals(1L, actualImmutableSurveyInstanceOwnerCreateCommand.personId().longValue());
    assertEquals(
        1L, actualImmutableSurveyInstanceOwnerCreateCommand.surveyInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder personId one surveyInstanceId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceOwnerCreateCommand); then builder build is builder personId one surveyInstanceId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwnerCreateCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderPersonIdOneSurveyInstanceIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand.builder();
    ImmutableSurveyInstanceOwnerCreateCommand instance =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceOwnerCreateCommand actualImmutableSurveyInstanceOwnerCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceOwnerCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#personId(Long)}.
   *
   * <p>Method under test: {@link Builder#personId(Long)}
   */
  @Test
  @DisplayName("Test Builder personId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.personId(Long)"})
  void testBuilderPersonId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand.builder();

    // Act
    Builder actualPersonIdResult = builderResult.personId(1L);

    // Assert
    assertSame(builderResult, actualPersonIdResult);
  }

  /**
   * Test Builder {@link Builder#surveyInstanceId(Long)}.
   *
   * <p>Method under test: {@link Builder#surveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyInstanceId(Long)"})
  void testBuilderSurveyInstanceId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand.builder();

    // Act
    Builder actualSurveyInstanceIdResult = builderResult.surveyInstanceId(1L);

    // Assert
    assertSame(builderResult, actualSurveyInstanceIdResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceOwnerCreateCommand#copyOf(SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Then return personId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceOwnerCreateCommand#copyOf(SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceOwnerCreateCommand); then return personId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwnerCreateCommand ImmutableSurveyInstanceOwnerCreateCommand.copyOf(SurveyInstanceOwnerCreateCommand)"
  })
  void testCopyOf_thenReturnPersonIdLongValueIsOne() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand instance =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceOwnerCreateCommand actualCopyOfResult =
        ImmutableSurveyInstanceOwnerCreateCommand.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.personId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceOwnerCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceOwnerCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwnerCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwnerCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand immutableSurveyInstanceOwnerCreateCommand =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();
    ImmutableSurveyInstanceOwnerCreateCommand immutableSurveyInstanceOwnerCreateCommand2 =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceOwnerCreateCommand, immutableSurveyInstanceOwnerCreateCommand2);
    assertEquals(
        immutableSurveyInstanceOwnerCreateCommand.hashCode(),
        immutableSurveyInstanceOwnerCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceOwnerCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceOwnerCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwnerCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwnerCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand immutableSurveyInstanceOwnerCreateCommand =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceOwnerCreateCommand, immutableSurveyInstanceOwnerCreateCommand);
    int expectedHashCodeResult = immutableSurveyInstanceOwnerCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceOwnerCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwnerCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwnerCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand immutableSurveyInstanceOwnerCreateCommand =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(2L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceOwnerCreateCommand,
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwnerCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwnerCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand immutableSurveyInstanceOwnerCreateCommand =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceOwnerCreateCommand,
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwnerCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwnerCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwnerCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwnerCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwnerCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build(),
        "Different type to ImmutableSurveyInstanceOwnerCreateCommand");
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SurveyInstanceId is one.
   *   <li>Then return personId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwnerCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SurveyInstanceId is one; then return personId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwnerCreateCommand ImmutableSurveyInstanceOwnerCreateCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonSurveyInstanceIdIsOne_thenReturnPersonIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setSurveyInstanceId(1L);
    json.setPersonId(1L);

    // Act
    ImmutableSurveyInstanceOwnerCreateCommand actualFromJsonResult =
        ImmutableSurveyInstanceOwnerCreateCommand.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.personId().longValue());
    assertEquals(1L, actualFromJsonResult.surveyInstanceId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwnerCreateCommand#toString()}
   *   <li>{@link ImmutableSurveyInstanceOwnerCreateCommand#personId()}
   *   <li>{@link ImmutableSurveyInstanceOwnerCreateCommand#surveyInstanceId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableSurveyInstanceOwnerCreateCommand.personId()",
    "Long ImmutableSurveyInstanceOwnerCreateCommand.surveyInstanceId()",
    "String ImmutableSurveyInstanceOwnerCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand immutableSurveyInstanceOwnerCreateCommand =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    String actualToStringResult = immutableSurveyInstanceOwnerCreateCommand.toString();
    Long actualPersonIdResult = immutableSurveyInstanceOwnerCreateCommand.personId();
    Long actualSurveyInstanceIdResult =
        immutableSurveyInstanceOwnerCreateCommand.surveyInstanceId();

    // Assert
    assertEquals(
        "SurveyInstanceOwnerCreateCommand{surveyInstanceId=1, personId=1}", actualToStringResult);
    assertEquals(1L, actualPersonIdResult.longValue());
    assertEquals(1L, actualSurveyInstanceIdResult.longValue());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setPersonId(Long)}
   *   <li>{@link Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setPersonId(Long)",
    "void Json.setSurveyInstanceId(Long)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setPersonId(1L);
    actualJson.setSurveyInstanceId(1L);

    // Assert
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
  }

  /**
   * Test Json {@link Json#personId()}.
   *
   * <p>Method under test: {@link Json#personId()}
   */
  @Test
  @DisplayName("Test Json personId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.personId()"})
  void testJsonPersonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().personId());
  }

  /**
   * Test Json {@link Json#surveyInstanceId()}.
   *
   * <p>Method under test: {@link Json#surveyInstanceId()}
   */
  @Test
  @DisplayName("Test Json surveyInstanceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.surveyInstanceId()"})
  void testJsonSurveyInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyInstanceId());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#withPersonId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return surveyInstanceId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwnerCreateCommand#withPersonId(Long)}
   */
  @Test
  @DisplayName(
      "Test withPersonId(Long); when forty-two; then return surveyInstanceId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwnerCreateCommand ImmutableSurveyInstanceOwnerCreateCommand.withPersonId(Long)"
  })
  void testWithPersonId_whenFortyTwo_thenReturnSurveyInstanceIdLongValueIsOne() {
    // Arrange and Act
    ImmutableSurveyInstanceOwnerCreateCommand actualWithPersonIdResult =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build()
            .withPersonId(42L);

    // Assert
    assertEquals(1L, actualWithPersonIdResult.surveyInstanceId().longValue());
    assertEquals(42L, actualWithPersonIdResult.personId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#withPersonId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder personId one surveyInstanceId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwnerCreateCommand#withPersonId(Long)}
   */
  @Test
  @DisplayName(
      "Test withPersonId(Long); when one; then return builder personId one surveyInstanceId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwnerCreateCommand ImmutableSurveyInstanceOwnerCreateCommand.withPersonId(Long)"
  })
  void testWithPersonId_whenOne_thenReturnBuilderPersonIdOneSurveyInstanceIdOneBuild() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand immutableSurveyInstanceOwnerCreateCommand =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceOwnerCreateCommand actualWithPersonIdResult =
        immutableSurveyInstanceOwnerCreateCommand.withPersonId(1L);

    // Assert
    assertSame(immutableSurveyInstanceOwnerCreateCommand, actualWithPersonIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#withSurveyInstanceId(Long)}.
   *
   * <ul>
   *   <li>Then return builder personId one surveyInstanceId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceOwnerCreateCommand#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName(
      "Test withSurveyInstanceId(Long); then return builder personId one surveyInstanceId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwnerCreateCommand ImmutableSurveyInstanceOwnerCreateCommand.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId_thenReturnBuilderPersonIdOneSurveyInstanceIdOneBuild() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand immutableSurveyInstanceOwnerCreateCommand =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceOwnerCreateCommand actualWithSurveyInstanceIdResult =
        immutableSurveyInstanceOwnerCreateCommand.withSurveyInstanceId(1L);

    // Assert
    assertSame(immutableSurveyInstanceOwnerCreateCommand, actualWithSurveyInstanceIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwnerCreateCommand#withSurveyInstanceId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return personId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceOwnerCreateCommand#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName(
      "Test withSurveyInstanceId(Long); when forty-two; then return personId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwnerCreateCommand ImmutableSurveyInstanceOwnerCreateCommand.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId_whenFortyTwo_thenReturnPersonIdLongValueIsOne() {
    // Arrange and Act
    ImmutableSurveyInstanceOwnerCreateCommand actualWithSurveyInstanceIdResult =
        ImmutableSurveyInstanceOwnerCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build()
            .withSurveyInstanceId(42L);

    // Assert
    assertEquals(1L, actualWithSurveyInstanceIdResult.personId().longValue());
    assertEquals(42L, actualWithSurveyInstanceIdResult.surveyInstanceId().longValue());
  }
}
