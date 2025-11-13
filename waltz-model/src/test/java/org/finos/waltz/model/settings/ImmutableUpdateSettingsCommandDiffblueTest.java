package org.finos.waltz.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.settings.ImmutableUpdateSettingsCommand.Builder;
import org.finos.waltz.model.settings.ImmutableUpdateSettingsCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateSettingsCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUpdateSettingsCommand actualImmutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableUpdateSettingsCommand.value());
    assertEquals("Name", actualImmutableUpdateSettingsCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableUpdateSettingsCommand.description());
  }

  /**
   * Test Builder {@link Builder#from(UpdateSettingsCommand)}.
   *
   * <p>Method under test: {@link Builder#from(UpdateSettingsCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateSettingsCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateSettingsCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableUpdateSettingsCommand.builder();
    ImmutableUpdateSettingsCommand instance =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateSettingsCommand actualImmutableUpdateSettingsCommand = builderResult.build();
    assertEquals(instance, actualImmutableUpdateSettingsCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateSettingsCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder description {@code null} name {@code Name} value {@code 42}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateSettingsCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateSettingsCommand); then builder build is builder description 'null' name 'Name' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateSettingsCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderDescriptionNullNameNameValue42Build() {
    // Arrange
    Builder builderResult = ImmutableUpdateSettingsCommand.builder();
    ImmutableUpdateSettingsCommand instance =
        ImmutableUpdateSettingsCommand.builder().description(null).name("Name").value("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateSettingsCommand actualImmutableUpdateSettingsCommand = builderResult.build();
    assertEquals(instance, actualImmutableUpdateSettingsCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateSettingsCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
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
    Builder builderResult = ImmutableUpdateSettingsCommand.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#copyOf(UpdateSettingsCommand)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#copyOf(UpdateSettingsCommand)}
   */
  @Test
  @DisplayName("Test copyOf(UpdateSettingsCommand); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.copyOf(UpdateSettingsCommand)"
  })
  void testCopyOf_thenReturnValueIs42() {
    // Arrange
    ImmutableUpdateSettingsCommand instance =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableUpdateSettingsCommand actualCopyOfResult =
        ImmutableUpdateSettingsCommand.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#equals(Object)}, and {@link
   * ImmutableUpdateSettingsCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateSettingsCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateSettingsCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateSettingsCommand.equals(Object)",
    "int ImmutableUpdateSettingsCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand2 =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableUpdateSettingsCommand, immutableUpdateSettingsCommand2);
    assertEquals(
        immutableUpdateSettingsCommand.hashCode(), immutableUpdateSettingsCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#equals(Object)}, and {@link
   * ImmutableUpdateSettingsCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateSettingsCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateSettingsCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateSettingsCommand.equals(Object)",
    "int ImmutableUpdateSettingsCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableUpdateSettingsCommand, immutableUpdateSettingsCommand);
    int expectedHashCodeResult = immutableUpdateSettingsCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateSettingsCommand.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateSettingsCommand.equals(Object)",
    "int ImmutableUpdateSettingsCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("Name")
            .name("Name")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateSettingsCommand,
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateSettingsCommand.equals(Object)",
    "int ImmutableUpdateSettingsCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("42")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateSettingsCommand,
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateSettingsCommand.equals(Object)",
    "int ImmutableUpdateSettingsCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateSettingsCommand,
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateSettingsCommand.equals(Object)",
    "int ImmutableUpdateSettingsCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateSettingsCommand.equals(Object)",
    "int ImmutableUpdateSettingsCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build(),
        "Different type to ImmutableUpdateSettingsCommand");
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Name is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonNameIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setValue("Json");
    json.setDescription("Json");

    // Act
    ImmutableUpdateSettingsCommand actualFromJsonResult =
        ImmutableUpdateSettingsCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setValue("Json");
    json.setDescription(null);

    // Act
    ImmutableUpdateSettingsCommand actualFromJsonResult =
        ImmutableUpdateSettingsCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.value());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateSettingsCommand#toString()}
   *   <li>{@link ImmutableUpdateSettingsCommand#description()}
   *   <li>{@link ImmutableUpdateSettingsCommand#name()}
   *   <li>{@link ImmutableUpdateSettingsCommand#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUpdateSettingsCommand.description()",
    "String ImmutableUpdateSettingsCommand.name()",
    "String ImmutableUpdateSettingsCommand.toString()",
    "String ImmutableUpdateSettingsCommand.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    String actualToStringResult = immutableUpdateSettingsCommand.toString();
    String actualDescriptionResult = immutableUpdateSettingsCommand.description();
    String actualNameResult = immutableUpdateSettingsCommand.name();

    // Assert
    assertEquals("42", immutableUpdateSettingsCommand.value());
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(
        "UpdateSettingsCommand{name=Name, value=42, description=The characteristics of someone or something}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setName(String)",
    "void Json.setValue(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setName("Name");
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
   * Test {@link ImmutableUpdateSettingsCommand#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} name {@code Name} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' name 'Name' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.withDescription(String)"
  })
  void testWithDescription_thenReturnBuilderDescription42NameNameValue42Build() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder().description("42").name("Name").value("42").build();

    // Act
    ImmutableUpdateSettingsCommand actualWithDescriptionResult =
        immutableUpdateSettingsCommand.withDescription("42");

    // Assert
    assertSame(immutableUpdateSettingsCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.withDescription(String)"
  })
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableUpdateSettingsCommand actualWithDescriptionResult =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("42", actualWithDescriptionResult.value());
    assertEquals("Name", actualWithDescriptionResult.name());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("42")
            .value("42")
            .build();

    // Act
    ImmutableUpdateSettingsCommand actualWithNameResult =
        immutableUpdateSettingsCommand.withName("42");

    // Assert
    assertSame(immutableUpdateSettingsCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableUpdateSettingsCommand actualWithNameResult =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.value());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#withValue(String)}.
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.withValue(String)"
  })
  void testWithValue() {
    // Arrange
    ImmutableUpdateSettingsCommand immutableUpdateSettingsCommand =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableUpdateSettingsCommand actualWithValueResult =
        immutableUpdateSettingsCommand.withValue("42");

    // Assert
    assertSame(immutableUpdateSettingsCommand, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableUpdateSettingsCommand#withValue(String)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateSettingsCommand#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand.withValue(String)"
  })
  void testWithValue_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableUpdateSettingsCommand actualWithValueResult =
        ImmutableUpdateSettingsCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("value")
            .build()
            .withValue("42");

    // Assert
    assertEquals("42", actualWithValueResult.value());
    assertEquals("Name", actualWithValueResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithValueResult.description());
  }
}
