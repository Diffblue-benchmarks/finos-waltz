package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceRecipientCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceRecipientCreateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientCreateCommand
        actualImmutableSurveyInstanceRecipientCreateCommand =
            ImmutableSurveyInstanceRecipientCreateCommand.builder()
                .personId(1L)
                .surveyInstanceId(1L)
                .build();

    // Assert
    assertEquals(1L, actualImmutableSurveyInstanceRecipientCreateCommand.personId().longValue());
    assertEquals(
        1L, actualImmutableSurveyInstanceRecipientCreateCommand.surveyInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceRecipientCreateCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder personId one surveyInstanceId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceRecipientCreateCommand); then builder build is builder personId one surveyInstanceId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceRecipientCreateCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderPersonIdOneSurveyInstanceIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientCreateCommand.builder();
    ImmutableSurveyInstanceRecipientCreateCommand instance =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceRecipientCreateCommand
        actualImmutableSurveyInstanceRecipientCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientCreateCommand);
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
    Builder builderResult = ImmutableSurveyInstanceRecipientCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyInstanceRecipientCreateCommand.builder();

    // Act
    Builder actualSurveyInstanceIdResult = builderResult.surveyInstanceId(1L);

    // Assert
    assertSame(builderResult, actualSurveyInstanceIdResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceRecipientCreateCommand#copyOf(SurveyInstanceRecipientCreateCommand)}.
   *
   * <ul>
   *   <li>Then return personId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientCreateCommand#copyOf(SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceRecipientCreateCommand); then return personId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientCreateCommand ImmutableSurveyInstanceRecipientCreateCommand.copyOf(SurveyInstanceRecipientCreateCommand)"
  })
  void testCopyOf_thenReturnPersonIdLongValueIsOne() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand instance =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceRecipientCreateCommand actualCopyOfResult =
        ImmutableSurveyInstanceRecipientCreateCommand.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.personId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceRecipientCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceRecipientCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand immutableSurveyInstanceRecipientCreateCommand =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();
    ImmutableSurveyInstanceRecipientCreateCommand immutableSurveyInstanceRecipientCreateCommand2 =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceRecipientCreateCommand,
        immutableSurveyInstanceRecipientCreateCommand2);
    assertEquals(
        immutableSurveyInstanceRecipientCreateCommand.hashCode(),
        immutableSurveyInstanceRecipientCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceRecipientCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceRecipientCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand immutableSurveyInstanceRecipientCreateCommand =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceRecipientCreateCommand,
        immutableSurveyInstanceRecipientCreateCommand);
    int expectedHashCodeResult = immutableSurveyInstanceRecipientCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceRecipientCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand immutableSurveyInstanceRecipientCreateCommand =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(2L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientCreateCommand,
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand immutableSurveyInstanceRecipientCreateCommand =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientCreateCommand,
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build(),
        "Different type to ImmutableSurveyInstanceRecipientCreateCommand");
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SurveyInstanceId is one.
   *   <li>Then return personId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SurveyInstanceId is one; then return personId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientCreateCommand ImmutableSurveyInstanceRecipientCreateCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonSurveyInstanceIdIsOne_thenReturnPersonIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setSurveyInstanceId(1L);
    json.setPersonId(1L);

    // Act
    ImmutableSurveyInstanceRecipientCreateCommand actualFromJsonResult =
        ImmutableSurveyInstanceRecipientCreateCommand.fromJson(json);

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
   *   <li>{@link ImmutableSurveyInstanceRecipientCreateCommand#toString()}
   *   <li>{@link ImmutableSurveyInstanceRecipientCreateCommand#personId()}
   *   <li>{@link ImmutableSurveyInstanceRecipientCreateCommand#surveyInstanceId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableSurveyInstanceRecipientCreateCommand.personId()",
    "Long ImmutableSurveyInstanceRecipientCreateCommand.surveyInstanceId()",
    "String ImmutableSurveyInstanceRecipientCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand immutableSurveyInstanceRecipientCreateCommand =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    String actualToStringResult = immutableSurveyInstanceRecipientCreateCommand.toString();
    Long actualPersonIdResult = immutableSurveyInstanceRecipientCreateCommand.personId();
    Long actualSurveyInstanceIdResult =
        immutableSurveyInstanceRecipientCreateCommand.surveyInstanceId();

    // Assert
    assertEquals(
        "SurveyInstanceRecipientCreateCommand{surveyInstanceId=1, personId=1}",
        actualToStringResult);
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
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#withPersonId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return surveyInstanceId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientCreateCommand#withPersonId(Long)}
   */
  @Test
  @DisplayName(
      "Test withPersonId(Long); when forty-two; then return surveyInstanceId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientCreateCommand ImmutableSurveyInstanceRecipientCreateCommand.withPersonId(Long)"
  })
  void testWithPersonId_whenFortyTwo_thenReturnSurveyInstanceIdLongValueIsOne() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientCreateCommand actualWithPersonIdResult =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build()
            .withPersonId(42L);

    // Assert
    assertEquals(1L, actualWithPersonIdResult.surveyInstanceId().longValue());
    assertEquals(42L, actualWithPersonIdResult.personId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#withPersonId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder personId one surveyInstanceId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientCreateCommand#withPersonId(Long)}
   */
  @Test
  @DisplayName(
      "Test withPersonId(Long); when one; then return builder personId one surveyInstanceId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientCreateCommand ImmutableSurveyInstanceRecipientCreateCommand.withPersonId(Long)"
  })
  void testWithPersonId_whenOne_thenReturnBuilderPersonIdOneSurveyInstanceIdOneBuild() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand immutableSurveyInstanceRecipientCreateCommand =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceRecipientCreateCommand actualWithPersonIdResult =
        immutableSurveyInstanceRecipientCreateCommand.withPersonId(1L);

    // Assert
    assertSame(immutableSurveyInstanceRecipientCreateCommand, actualWithPersonIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#withSurveyInstanceId(Long)}.
   *
   * <ul>
   *   <li>Then return builder personId one surveyInstanceId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientCreateCommand#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName(
      "Test withSurveyInstanceId(Long); then return builder personId one surveyInstanceId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientCreateCommand ImmutableSurveyInstanceRecipientCreateCommand.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId_thenReturnBuilderPersonIdOneSurveyInstanceIdOneBuild() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand immutableSurveyInstanceRecipientCreateCommand =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceRecipientCreateCommand actualWithSurveyInstanceIdResult =
        immutableSurveyInstanceRecipientCreateCommand.withSurveyInstanceId(1L);

    // Assert
    assertSame(immutableSurveyInstanceRecipientCreateCommand, actualWithSurveyInstanceIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientCreateCommand#withSurveyInstanceId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return personId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientCreateCommand#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName(
      "Test withSurveyInstanceId(Long); when forty-two; then return personId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientCreateCommand ImmutableSurveyInstanceRecipientCreateCommand.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId_whenFortyTwo_thenReturnPersonIdLongValueIsOne() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientCreateCommand actualWithSurveyInstanceIdResult =
        ImmutableSurveyInstanceRecipientCreateCommand.builder()
            .personId(1L)
            .surveyInstanceId(1L)
            .build()
            .withSurveyInstanceId(42L);

    // Assert
    assertEquals(1L, actualWithSurveyInstanceIdResult.personId().longValue());
    assertEquals(42L, actualWithSurveyInstanceIdResult.surveyInstanceId().longValue());
  }
}
