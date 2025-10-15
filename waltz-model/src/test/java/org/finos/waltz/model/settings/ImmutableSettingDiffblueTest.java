package org.finos.waltz.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.settings.ImmutableSetting.Builder;
import org.finos.waltz.model.settings.ImmutableSetting.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSettingDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#value(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSetting Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.value(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualValueResult =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42");
    Optional<String> value = Optional.of("foo");
    ImmutableSetting actualImmutableSetting = actualValueResult.value(value).build();

    // Assert
    assertEquals("Name", actualImmutableSetting.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableSetting.description());
    assertFalse(actualImmutableSetting.restricted());
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    ImmutableSetting instance =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSetting actualImmutableSetting = builderResult.build();
    assertEquals(instance, actualImmutableSetting);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    ImmutableSetting instance =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSetting actualImmutableSetting = builderResult.build();
    assertEquals(instance, actualImmutableSetting);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    ImmutableSetting instance =
        ImmutableSetting.builder().description(null).name("Name").value("42").build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSetting actualImmutableSetting = builderResult.build();
    assertEquals(instance, actualImmutableSetting);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableSetting immutableSetting = builderResult.build();
    assertEquals("Name", immutableSetting.name());
    assertNull(immutableSetting.description());
    assertFalse(immutableSetting.restricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Setting)} with {@code Setting}.
   *
   * <p>Method under test: {@link Builder#from(Setting)}
   */
  @Test
  @DisplayName("Test Builder from(Setting) with 'Setting'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Setting)"})
  void testBuilderFromWithSetting() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    ImmutableSetting instance =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSetting actualImmutableSetting = builderResult.build();
    assertEquals(instance, actualImmutableSetting);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Setting)} with {@code Setting}.
   *
   * <p>Method under test: {@link Builder#from(Setting)}
   */
  @Test
  @DisplayName("Test Builder from(Setting) with 'Setting'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Setting)"})
  void testBuilderFromWithSetting2() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    ImmutableSetting instance =
        ImmutableSetting.builder().description(null).name("Name").value("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSetting actualImmutableSetting = builderResult.build();
    assertEquals(instance, actualImmutableSetting);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableSetting immutableSetting = builderResult.build();
    assertEquals("Name", immutableSetting.name());
    assertNull(immutableSetting.description());
    assertFalse(immutableSetting.restricted());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#restricted(boolean)}.
   *
   * <p>Method under test: {@link Builder#restricted(boolean)}
   */
  @Test
  @DisplayName("Test Builder restricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.restricted(boolean)"})
  void testBuilderRestricted() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();

    // Act
    Builder actualRestrictedResult = builderResult.restricted(true);

    // Assert
    assertSame(builderResult, actualRestrictedResult);
  }

  /**
   * Test Builder {@link Builder#value(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#value(Optional)}
   */
  @Test
  @DisplayName("Test Builder value(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(Optional)"})
  void testBuilderValueWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    Optional<String> value = Optional.of("foo");

    // Act
    Builder actualValueResult = builderResult.value(value);

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableSetting#copyOf(Setting)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#copyOf(Setting)}
   */
  @Test
  @DisplayName("Test copyOf(Setting); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.copyOf(Setting)"})
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableSetting instance =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableSetting actualCopyOfResult = ImmutableSetting.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertFalse(actualCopyOfResult.restricted());
  }

  /**
   * Test {@link ImmutableSetting#equals(Object)}, and {@link ImmutableSetting#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSetting#equals(Object)}
   *   <li>{@link ImmutableSetting#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSetting.equals(Object)", "int ImmutableSetting.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();
    ImmutableSetting immutableSetting2 =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSetting, immutableSetting2);
    assertEquals(immutableSetting.hashCode(), immutableSetting2.hashCode());
  }

  /**
   * Test {@link ImmutableSetting#equals(Object)}, and {@link ImmutableSetting#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSetting#equals(Object)}
   *   <li>{@link ImmutableSetting#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSetting.equals(Object)", "int ImmutableSetting.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSetting, immutableSetting);
    int expectedHashCodeResult = immutableSetting.hashCode();
    assertEquals(expectedHashCodeResult, immutableSetting.hashCode());
  }

  /**
   * Test {@link ImmutableSetting#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSetting.equals(Object)", "int ImmutableSetting.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("java.lang.String")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSetting,
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSetting#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSetting.equals(Object)", "int ImmutableSetting.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSetting,
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSetting#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSetting.equals(Object)", "int ImmutableSetting.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSetting#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSetting.equals(Object)", "int ImmutableSetting.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build(),
        "Different type to ImmutableSetting");
  }

  /**
   * Test {@link ImmutableSetting#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code name}.
   *   <li>When {@link Json} (default constructor) Name is {@code name}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'name'; when Json (default constructor) Name is 'name'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.fromJson(Json)"})
  void testFromJson_givenName_whenJsonNameIsName_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("name");

    // Act
    ImmutableSetting actualFromJsonResult = ImmutableSetting.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertFalse(actualFromJsonResult.restricted());
  }

  /**
   * Test {@link ImmutableSetting#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setDescription("The characteristics of someone or something");
    json.setName("name");

    // Act
    ImmutableSetting actualFromJsonResult = ImmutableSetting.fromJson(json);

    // Assert
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals("name", actualFromJsonResult.name());
    assertFalse(actualFromJsonResult.restricted());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSetting#description()}
   *   <li>{@link ImmutableSetting#name()}
   *   <li>{@link ImmutableSetting#restricted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSetting.description()",
    "String ImmutableSetting.name()",
    "boolean ImmutableSetting.restricted()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    String actualDescriptionResult = immutableSetting.description();
    String actualNameResult = immutableSetting.name();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertFalse(immutableSetting.restricted());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.value.isPresent());
    assertFalse(actualJson.restricted);
    assertFalse(actualJson.restrictedIsSet);
  }

  /**
   * Test Json {@link Json#restricted()}.
   *
   * <p>Method under test: {@link Json#restricted()}
   */
  @Test
  @DisplayName("Test Json restricted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.restricted()"})
  void testJsonRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().restricted());
  }

  /**
   * Test Json {@link Json#setRestricted(boolean)}.
   *
   * <p>Method under test: {@link Json#setRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Json setRestricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRestricted(boolean)"})
  void testJsonSetRestricted() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRestricted(true);

    // Assert
    assertTrue(json.restricted);
    assertTrue(json.restrictedIsSet);
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
  @MethodsUnderTest({"Optional Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().value());
  }

  /**
   * Test {@link ImmutableSetting#toString()}.
   *
   * <p>Method under test: {@link ImmutableSetting#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSetting.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Setting{name=Name, value=42, restricted=false}",
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSetting#value()}.
   *
   * <p>Method under test: {@link ImmutableSetting#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSetting.value()"})
  void testValue() {
    // Arrange and Act
    Optional<String> actualValueResult =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build()
            .value();

    // Assert
    assertEquals("42", actualValueResult.get());
    assertTrue(actualValueResult.isPresent());
  }

  /**
   * Test {@link ImmutableSetting#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSetting#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableSetting actualWithDescriptionResult = immutableSetting.withDescription("42");

    // Assert
    assertEquals(immutableSetting, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSetting#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} name {@code Name} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' name 'Name' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withDescription(String)"})
  void testWithDescription_thenReturnBuilderDescription42NameNameValue42Build() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder().description("42").name("Name").value("42").build();

    // Act
    ImmutableSetting actualWithDescriptionResult = immutableSetting.withDescription("42");

    // Assert
    assertSame(immutableSetting, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSetting#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSetting#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("42")
            .value("42")
            .build();

    // Act
    ImmutableSetting actualWithNameResult = immutableSetting.withName("42");

    // Assert
    assertSame(immutableSetting, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSetting#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableSetting actualWithNameResult =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertFalse(actualWithNameResult.restricted());
  }

  /**
   * Test {@link ImmutableSetting#withRestricted(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSetting#withRestricted(boolean)}
   */
  @Test
  @DisplayName("Test withRestricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withRestricted(boolean)"})
  void testWithRestricted() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableSetting actualWithRestrictedResult = immutableSetting.withRestricted(false);

    // Assert
    assertSame(immutableSetting, actualWithRestrictedResult);
  }

  /**
   * Test {@link ImmutableSetting#withRestricted(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#withRestricted(boolean)}
   */
  @Test
  @DisplayName("Test withRestricted(boolean); when 'true'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withRestricted(boolean)"})
  void testWithRestricted_whenTrue_thenReturnName() {
    // Arrange and Act
    ImmutableSetting actualWithRestrictedResult =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build()
            .withRestricted(true);

    // Assert
    assertEquals("Name", actualWithRestrictedResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithRestrictedResult.description());
    assertTrue(actualWithRestrictedResult.restricted());
  }

  /**
   * Test {@link ImmutableSetting#withValue(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSetting#withValue(Optional)}
   */
  @Test
  @DisplayName("Test withValue(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withValue(Optional)"})
  void testWithValueWithOptional() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSetting actualWithValueResult = immutableSetting.withValue(optional);

    // Assert
    assertSame(immutableSetting, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableSetting#withValue(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#withValue(Optional)}
   */
  @Test
  @DisplayName("Test withValue(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withValue(Optional)"})
  void testWithValueWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSetting actualWithValueResult = immutableSetting.withValue(optional);

    // Assert
    assertEquals("Name", actualWithValueResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithValueResult.description());
    assertFalse(actualWithValueResult.restricted());
  }

  /**
   * Test {@link ImmutableSetting#withValue(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSetting#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withValue(String)"})
  void testWithValueWithValue() {
    // Arrange
    ImmutableSetting immutableSetting =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableSetting actualWithValueResult = immutableSetting.withValue("42");

    // Assert
    assertSame(immutableSetting, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableSetting#withValue(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetting#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String) with 'value'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetting ImmutableSetting.withValue(String)"})
  void testWithValueWithValue_thenReturnName() {
    // Arrange and Act
    ImmutableSetting actualWithValueResult =
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("value")
            .build()
            .withValue("42");

    // Assert
    assertEquals("Name", actualWithValueResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithValueResult.description());
    assertFalse(actualWithValueResult.restricted());
  }
}
