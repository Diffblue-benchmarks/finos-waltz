package org.finos.waltz.model.survey_template_exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyDropdownEntryModel.Builder;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyDropdownEntryModel.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyDropdownEntryModelDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDropdownEntryModel Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyDropdownEntryModel actualImmutableSurveyDropdownEntryModel =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build();

    // Assert
    assertEquals("42", actualImmutableSurveyDropdownEntryModel.value());
    assertEquals(1, actualImmutableSurveyDropdownEntryModel.position());
  }

  /**
   * Test Builder {@link Builder#from(SurveyDropdownEntryModel)}.
   *
   * <ul>
   *   <li>Then builder build is builder position one value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyDropdownEntryModel)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyDropdownEntryModel); then builder build is builder position one value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyDropdownEntryModel)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderPositionOneValue42Build() {
    // Arrange
    Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();
    ImmutableSurveyDropdownEntryModel instance =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyDropdownEntryModel actualImmutableSurveyDropdownEntryModel =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyDropdownEntryModel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#copyOf(SurveyDropdownEntryModel)}.
   *
   * <ul>
   *   <li>When builder position one value {@code 42} build.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyDropdownEntryModel#copyOf(SurveyDropdownEntryModel)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyDropdownEntryModel); when builder position one value '42' build; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDropdownEntryModel ImmutableSurveyDropdownEntryModel.copyOf(SurveyDropdownEntryModel)"
  })
  void testCopyOf_whenBuilderPositionOneValue42Build_thenReturnValueIs42() {
    // Arrange
    ImmutableSurveyDropdownEntryModel instance =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build();

    // Act
    ImmutableSurveyDropdownEntryModel actualCopyOfResult =
        ImmutableSurveyDropdownEntryModel.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.value());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#equals(Object)}, and {@link
   * ImmutableSurveyDropdownEntryModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyDropdownEntryModel#equals(Object)}
   *   <li>{@link ImmutableSurveyDropdownEntryModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDropdownEntryModel.equals(Object)",
    "int ImmutableSurveyDropdownEntryModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyDropdownEntryModel immutableSurveyDropdownEntryModel =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build();
    ImmutableSurveyDropdownEntryModel immutableSurveyDropdownEntryModel2 =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build();

    // Act and Assert
    assertEquals(immutableSurveyDropdownEntryModel, immutableSurveyDropdownEntryModel2);
    assertEquals(
        immutableSurveyDropdownEntryModel.hashCode(),
        immutableSurveyDropdownEntryModel2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#equals(Object)}, and {@link
   * ImmutableSurveyDropdownEntryModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyDropdownEntryModel#equals(Object)}
   *   <li>{@link ImmutableSurveyDropdownEntryModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDropdownEntryModel.equals(Object)",
    "int ImmutableSurveyDropdownEntryModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyDropdownEntryModel immutableSurveyDropdownEntryModel =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build();

    // Act and Assert
    assertEquals(immutableSurveyDropdownEntryModel, immutableSurveyDropdownEntryModel);
    int expectedHashCodeResult = immutableSurveyDropdownEntryModel.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyDropdownEntryModel.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDropdownEntryModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDropdownEntryModel.equals(Object)",
    "int ImmutableSurveyDropdownEntryModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyDropdownEntryModel immutableSurveyDropdownEntryModel =
        ImmutableSurveyDropdownEntryModel.builder().position(0).value("42").build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyDropdownEntryModel,
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build());
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDropdownEntryModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDropdownEntryModel.equals(Object)",
    "int ImmutableSurveyDropdownEntryModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyDropdownEntryModel immutableSurveyDropdownEntryModel =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("Value").build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyDropdownEntryModel,
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build());
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDropdownEntryModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDropdownEntryModel.equals(Object)",
    "int ImmutableSurveyDropdownEntryModel.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build(), null);
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDropdownEntryModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDropdownEntryModel.equals(Object)",
    "int ImmutableSurveyDropdownEntryModel.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build(),
        "Different type to ImmutableSurveyDropdownEntryModel");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyDropdownEntryModel#toString()}
   *   <li>{@link ImmutableSurveyDropdownEntryModel#position()}
   *   <li>{@link ImmutableSurveyDropdownEntryModel#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableSurveyDropdownEntryModel.position()",
    "String ImmutableSurveyDropdownEntryModel.toString()",
    "String ImmutableSurveyDropdownEntryModel.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyDropdownEntryModel immutableSurveyDropdownEntryModel =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build();

    // Act
    String actualToStringResult = immutableSurveyDropdownEntryModel.toString();
    int actualPositionResult = immutableSurveyDropdownEntryModel.position();

    // Assert
    assertEquals("42", immutableSurveyDropdownEntryModel.value());
    assertEquals("SurveyDropdownEntryModel{position=1, value=42}", actualToStringResult);
    assertEquals(1, actualPositionResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setValue(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test Json {@link Json#value()}.
   *
   * <p>Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().value());
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#withPosition(int)}.
   *
   * <ul>
   *   <li>Given builder position one value {@code 42} build.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDropdownEntryModel#withPosition(int)}
   */
  @Test
  @DisplayName(
      "Test withPosition(int); given builder position one value '42' build; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDropdownEntryModel ImmutableSurveyDropdownEntryModel.withPosition(int)"
  })
  void testWithPosition_givenBuilderPositionOneValue42Build_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableSurveyDropdownEntryModel actualWithPositionResult =
        ImmutableSurveyDropdownEntryModel.builder()
            .position(1)
            .value("42")
            .build()
            .withPosition(42);

    // Assert
    assertEquals("42", actualWithPositionResult.value());
    assertEquals(42, actualWithPositionResult.position());
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return builder position forty-two value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDropdownEntryModel#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return builder position forty-two value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDropdownEntryModel ImmutableSurveyDropdownEntryModel.withPosition(int)"
  })
  void testWithPosition_thenReturnBuilderPositionFortyTwoValue42Build() {
    // Arrange
    ImmutableSurveyDropdownEntryModel immutableSurveyDropdownEntryModel =
        ImmutableSurveyDropdownEntryModel.builder().position(42).value("42").build();

    // Act
    ImmutableSurveyDropdownEntryModel actualWithPositionResult =
        immutableSurveyDropdownEntryModel.withPosition(42);

    // Assert
    assertSame(immutableSurveyDropdownEntryModel, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#withValue(String)}.
   *
   * <ul>
   *   <li>Given builder position one value {@code value} build.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDropdownEntryModel#withValue(String)}
   */
  @Test
  @DisplayName(
      "Test withValue(String); given builder position one value 'value' build; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDropdownEntryModel ImmutableSurveyDropdownEntryModel.withValue(String)"
  })
  void testWithValue_givenBuilderPositionOneValueValueBuild_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableSurveyDropdownEntryModel actualWithValueResult =
        ImmutableSurveyDropdownEntryModel.builder()
            .position(1)
            .value("value")
            .build()
            .withValue("42");

    // Assert
    assertEquals("42", actualWithValueResult.value());
    assertEquals(1, actualWithValueResult.position());
  }

  /**
   * Test {@link ImmutableSurveyDropdownEntryModel#withValue(String)}.
   *
   * <ul>
   *   <li>Then return builder position one value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDropdownEntryModel#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then return builder position one value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDropdownEntryModel ImmutableSurveyDropdownEntryModel.withValue(String)"
  })
  void testWithValue_thenReturnBuilderPositionOneValue42Build() {
    // Arrange
    ImmutableSurveyDropdownEntryModel immutableSurveyDropdownEntryModel =
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build();

    // Act
    ImmutableSurveyDropdownEntryModel actualWithValueResult =
        immutableSurveyDropdownEntryModel.withValue("42");

    // Assert
    assertSame(immutableSurveyDropdownEntryModel, actualWithValueResult);
  }
}
