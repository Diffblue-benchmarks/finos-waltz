package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientUpdateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientUpdateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceRecipientUpdateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceRecipientUpdateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientUpdateCommand
        actualImmutableSurveyInstanceRecipientUpdateCommand =
            ImmutableSurveyInstanceRecipientUpdateCommand.builder()
                .instanceRecipientId(1L)
                .personId(1L)
                .surveyInstanceId(1L)
                .build();

    // Assert
    assertEquals(
        1L, actualImmutableSurveyInstanceRecipientUpdateCommand.instanceRecipientId().longValue());
    assertEquals(1L, actualImmutableSurveyInstanceRecipientUpdateCommand.personId().longValue());
    assertEquals(
        1L, actualImmutableSurveyInstanceRecipientUpdateCommand.surveyInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceRecipientUpdateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceRecipientUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceRecipientUpdateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceRecipientUpdateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand.builder();
    ImmutableSurveyInstanceRecipientUpdateCommand instance =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceRecipientUpdateCommand
        actualImmutableSurveyInstanceRecipientUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#instanceRecipientId(Long)}.
   *
   * <p>Method under test: {@link Builder#instanceRecipientId(Long)}
   */
  @Test
  @DisplayName("Test Builder instanceRecipientId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.instanceRecipientId(Long)"})
  void testBuilderInstanceRecipientId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand.builder();

    // Act
    Builder actualInstanceRecipientIdResult = builderResult.instanceRecipientId(1L);

    // Assert
    assertSame(builderResult, actualInstanceRecipientIdResult);
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
    Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand.builder();

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
    Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand.builder();

    // Act
    Builder actualSurveyInstanceIdResult = builderResult.surveyInstanceId(1L);

    // Assert
    assertSame(builderResult, actualSurveyInstanceIdResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceRecipientUpdateCommand#copyOf(SurveyInstanceRecipientUpdateCommand)}.
   *
   * <ul>
   *   <li>Then return instanceRecipientId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientUpdateCommand#copyOf(SurveyInstanceRecipientUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceRecipientUpdateCommand); then return instanceRecipientId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientUpdateCommand ImmutableSurveyInstanceRecipientUpdateCommand.copyOf(SurveyInstanceRecipientUpdateCommand)"
  })
  void testCopyOf_thenReturnInstanceRecipientIdLongValueIsOne() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand instance =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualCopyOfResult =
        ImmutableSurveyInstanceRecipientUpdateCommand.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.instanceRecipientId().longValue());
    assertEquals(1L, actualCopyOfResult.personId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceRecipientUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceRecipientUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientUpdateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand2 =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceRecipientUpdateCommand,
        immutableSurveyInstanceRecipientUpdateCommand2);
    assertEquals(
        immutableSurveyInstanceRecipientUpdateCommand.hashCode(),
        immutableSurveyInstanceRecipientUpdateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceRecipientUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceRecipientUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientUpdateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceRecipientUpdateCommand,
        immutableSurveyInstanceRecipientUpdateCommand);
    int expectedHashCodeResult = immutableSurveyInstanceRecipientUpdateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceRecipientUpdateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientUpdateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(2L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientUpdateCommand,
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientUpdateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(2L)
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientUpdateCommand,
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientUpdateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientUpdateCommand,
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientUpdateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientUpdateCommand.equals(Object)",
    "int ImmutableSurveyInstanceRecipientUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build(),
        "Different type to ImmutableSurveyInstanceRecipientUpdateCommand");
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return instanceRecipientId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return instanceRecipientId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientUpdateCommand ImmutableSurveyInstanceRecipientUpdateCommand.fromJson(Json)"
  })
  void testFromJson_thenReturnInstanceRecipientIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setInstanceRecipientId(1L);
    json.setSurveyInstanceId(1L);
    json.setPersonId(1L);

    // Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualFromJsonResult =
        ImmutableSurveyInstanceRecipientUpdateCommand.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.instanceRecipientId().longValue());
    assertEquals(1L, actualFromJsonResult.personId().longValue());
    assertEquals(1L, actualFromJsonResult.surveyInstanceId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientUpdateCommand#toString()}
   *   <li>{@link ImmutableSurveyInstanceRecipientUpdateCommand#instanceRecipientId()}
   *   <li>{@link ImmutableSurveyInstanceRecipientUpdateCommand#personId()}
   *   <li>{@link ImmutableSurveyInstanceRecipientUpdateCommand#surveyInstanceId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableSurveyInstanceRecipientUpdateCommand.instanceRecipientId()",
    "Long ImmutableSurveyInstanceRecipientUpdateCommand.personId()",
    "Long ImmutableSurveyInstanceRecipientUpdateCommand.surveyInstanceId()",
    "String ImmutableSurveyInstanceRecipientUpdateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    String actualToStringResult = immutableSurveyInstanceRecipientUpdateCommand.toString();
    Long actualInstanceRecipientIdResult =
        immutableSurveyInstanceRecipientUpdateCommand.instanceRecipientId();
    Long actualPersonIdResult = immutableSurveyInstanceRecipientUpdateCommand.personId();
    Long actualSurveyInstanceIdResult =
        immutableSurveyInstanceRecipientUpdateCommand.surveyInstanceId();

    // Assert
    assertEquals(
        "SurveyInstanceRecipientUpdateCommand{instanceRecipientId=1, surveyInstanceId=1, personId=1}",
        actualToStringResult);
    assertEquals(1L, actualInstanceRecipientIdResult.longValue());
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
   *   <li>{@link Json#setInstanceRecipientId(Long)}
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
    "void Json.setInstanceRecipientId(Long)",
    "void Json.setPersonId(Long)",
    "void Json.setSurveyInstanceId(Long)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setInstanceRecipientId(1L);
    actualJson.setPersonId(1L);
    actualJson.setSurveyInstanceId(1L);

    // Assert
    assertEquals(1L, actualJson.instanceRecipientId.longValue());
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
  }

  /**
   * Test Json {@link Json#instanceRecipientId()}.
   *
   * <p>Method under test: {@link Json#instanceRecipientId()}
   */
  @Test
  @DisplayName("Test Json instanceRecipientId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.instanceRecipientId()"})
  void testJsonInstanceRecipientId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().instanceRecipientId());
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
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#withInstanceRecipientId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientUpdateCommand#withInstanceRecipientId(Long)}
   */
  @Test
  @DisplayName("Test withInstanceRecipientId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientUpdateCommand ImmutableSurveyInstanceRecipientUpdateCommand.withInstanceRecipientId(Long)"
  })
  void testWithInstanceRecipientId() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualWithInstanceRecipientIdResult =
        immutableSurveyInstanceRecipientUpdateCommand.withInstanceRecipientId(1L);

    // Assert
    assertSame(immutableSurveyInstanceRecipientUpdateCommand, actualWithInstanceRecipientIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#withInstanceRecipientId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return personId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientUpdateCommand#withInstanceRecipientId(Long)}
   */
  @Test
  @DisplayName(
      "Test withInstanceRecipientId(Long); when forty-two; then return personId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientUpdateCommand ImmutableSurveyInstanceRecipientUpdateCommand.withInstanceRecipientId(Long)"
  })
  void testWithInstanceRecipientId_whenFortyTwo_thenReturnPersonIdLongValueIsOne() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualWithInstanceRecipientIdResult =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build()
            .withInstanceRecipientId(42L);

    // Assert
    assertEquals(1L, actualWithInstanceRecipientIdResult.personId().longValue());
    assertEquals(1L, actualWithInstanceRecipientIdResult.surveyInstanceId().longValue());
    assertEquals(42L, actualWithInstanceRecipientIdResult.instanceRecipientId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#withPersonId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientUpdateCommand#withPersonId(Long)}
   */
  @Test
  @DisplayName("Test withPersonId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientUpdateCommand ImmutableSurveyInstanceRecipientUpdateCommand.withPersonId(Long)"
  })
  void testWithPersonId() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualWithPersonIdResult =
        immutableSurveyInstanceRecipientUpdateCommand.withPersonId(1L);

    // Assert
    assertSame(immutableSurveyInstanceRecipientUpdateCommand, actualWithPersonIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#withPersonId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return instanceRecipientId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientUpdateCommand#withPersonId(Long)}
   */
  @Test
  @DisplayName(
      "Test withPersonId(Long); when forty-two; then return instanceRecipientId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientUpdateCommand ImmutableSurveyInstanceRecipientUpdateCommand.withPersonId(Long)"
  })
  void testWithPersonId_whenFortyTwo_thenReturnInstanceRecipientIdLongValueIsOne() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualWithPersonIdResult =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build()
            .withPersonId(42L);

    // Assert
    assertEquals(1L, actualWithPersonIdResult.instanceRecipientId().longValue());
    assertEquals(1L, actualWithPersonIdResult.surveyInstanceId().longValue());
    assertEquals(42L, actualWithPersonIdResult.personId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#withSurveyInstanceId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientUpdateCommand#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientUpdateCommand ImmutableSurveyInstanceRecipientUpdateCommand.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand immutableSurveyInstanceRecipientUpdateCommand =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualWithSurveyInstanceIdResult =
        immutableSurveyInstanceRecipientUpdateCommand.withSurveyInstanceId(1L);

    // Assert
    assertSame(immutableSurveyInstanceRecipientUpdateCommand, actualWithSurveyInstanceIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientUpdateCommand#withSurveyInstanceId(Long)}.
   *
   * <ul>
   *   <li>Then return instanceRecipientId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientUpdateCommand#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyInstanceId(Long); then return instanceRecipientId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientUpdateCommand ImmutableSurveyInstanceRecipientUpdateCommand.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId_thenReturnInstanceRecipientIdLongValueIsOne() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualWithSurveyInstanceIdResult =
        ImmutableSurveyInstanceRecipientUpdateCommand.builder()
            .instanceRecipientId(1L)
            .personId(1L)
            .surveyInstanceId(1L)
            .build()
            .withSurveyInstanceId(42L);

    // Assert
    assertEquals(1L, actualWithSurveyInstanceIdResult.instanceRecipientId().longValue());
    assertEquals(1L, actualWithSurveyInstanceIdResult.personId().longValue());
    assertEquals(42L, actualWithSurveyInstanceIdResult.surveyInstanceId().longValue());
  }
}
