package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.ImmutableUserPreference.Builder;
import org.finos.waltz.model.user.ImmutableUserPreference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserPreferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserPreference Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUserPreference actualImmutableUserPreference =
        ImmutableUserPreference.builder().key("Key").value("42").build();

    // Assert
    assertEquals("42", actualImmutableUserPreference.value());
    assertEquals("Key", actualImmutableUserPreference.key());
  }

  /**
   * Test Builder {@link Builder#from(UserPreference)}.
   *
   * <ul>
   *   <li>Then builder build is builder key {@code Key} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UserPreference)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UserPreference); then builder build is builder key 'Key' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserPreference)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderKeyKeyValue42Build() {
    // Arrange
    Builder builderResult = ImmutableUserPreference.builder();
    ImmutableUserPreference instance =
        ImmutableUserPreference.builder().key("Key").value("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUserPreference actualImmutableUserPreference = builderResult.build();
    assertEquals(instance, actualImmutableUserPreference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String); when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUserPreference.builder();

    // Act
    Builder actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
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
    Builder builderResult = ImmutableUserPreference.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableUserPreference#copyOf(UserPreference)}.
   *
   * <ul>
   *   <li>When builder key {@code Key} value {@code 42} build.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#copyOf(UserPreference)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UserPreference); when builder key 'Key' value '42' build; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserPreference ImmutableUserPreference.copyOf(UserPreference)"})
  void testCopyOf_whenBuilderKeyKeyValue42Build_thenReturnValueIs42() {
    // Arrange
    ImmutableUserPreference instance =
        ImmutableUserPreference.builder().key("Key").value("42").build();

    // Act
    ImmutableUserPreference actualCopyOfResult = ImmutableUserPreference.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Key", actualCopyOfResult.key());
  }

  /**
   * Test {@link ImmutableUserPreference#equals(Object)}, and {@link
   * ImmutableUserPreference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserPreference#equals(Object)}
   *   <li>{@link ImmutableUserPreference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserPreference.equals(Object)",
    "int ImmutableUserPreference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUserPreference immutableUserPreference =
        ImmutableUserPreference.builder().key("Key").value("42").build();
    ImmutableUserPreference immutableUserPreference2 =
        ImmutableUserPreference.builder().key("Key").value("42").build();

    // Act and Assert
    assertEquals(immutableUserPreference, immutableUserPreference2);
    assertEquals(immutableUserPreference.hashCode(), immutableUserPreference2.hashCode());
  }

  /**
   * Test {@link ImmutableUserPreference#equals(Object)}, and {@link
   * ImmutableUserPreference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserPreference#equals(Object)}
   *   <li>{@link ImmutableUserPreference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserPreference.equals(Object)",
    "int ImmutableUserPreference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUserPreference immutableUserPreference =
        ImmutableUserPreference.builder().key("Key").value("42").build();

    // Act and Assert
    assertEquals(immutableUserPreference, immutableUserPreference);
    int expectedHashCodeResult = immutableUserPreference.hashCode();
    assertEquals(expectedHashCodeResult, immutableUserPreference.hashCode());
  }

  /**
   * Test {@link ImmutableUserPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserPreference.equals(Object)",
    "int ImmutableUserPreference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUserPreference immutableUserPreference =
        ImmutableUserPreference.builder().key("42").value("42").build();

    // Act and Assert
    assertNotEquals(
        immutableUserPreference, ImmutableUserPreference.builder().key("Key").value("42").build());
  }

  /**
   * Test {@link ImmutableUserPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserPreference.equals(Object)",
    "int ImmutableUserPreference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUserPreference immutableUserPreference =
        ImmutableUserPreference.builder().key("Key").value("Key").build();

    // Act and Assert
    assertNotEquals(
        immutableUserPreference, ImmutableUserPreference.builder().key("Key").value("42").build());
  }

  /**
   * Test {@link ImmutableUserPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserPreference.equals(Object)",
    "int ImmutableUserPreference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableUserPreference.builder().key("Key").value("42").build(), null);
  }

  /**
   * Test {@link ImmutableUserPreference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserPreference.equals(Object)",
    "int ImmutableUserPreference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUserPreference.builder().key("Key").value("42").build(),
        "Different type to ImmutableUserPreference");
  }

  /**
   * Test {@link ImmutableUserPreference#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Key is {@code Json}.
   *   <li>Then return key is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Key is 'Json'; then return key is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserPreference ImmutableUserPreference.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonKeyIsJson_thenReturnKeyIsJson() {
    // Arrange
    Json json = new Json();
    json.setKey("Json");
    json.setValue("Json");

    // Act
    ImmutableUserPreference actualFromJsonResult = ImmutableUserPreference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserPreference#toString()}
   *   <li>{@link ImmutableUserPreference#key()}
   *   <li>{@link ImmutableUserPreference#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUserPreference.key()",
    "String ImmutableUserPreference.toString()",
    "String ImmutableUserPreference.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUserPreference immutableUserPreference =
        ImmutableUserPreference.builder().key("Key").value("42").build();

    // Act
    String actualToStringResult = immutableUserPreference.toString();
    String actualKeyResult = immutableUserPreference.key();

    // Assert
    assertEquals("42", immutableUserPreference.value());
    assertEquals("Key", actualKeyResult);
    assertEquals("UserPreference{key=Key, value=42}", actualToStringResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setKey(String)}
   *   <li>{@link Json#setValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setKey(String)",
    "void Json.setValue(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setKey("Key");
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals("Key", actualJson.key);
  }

  /**
   * Test Json {@link Json#key()}.
   *
   * <p>Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().key());
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
   * Test {@link ImmutableUserPreference#withKey(String)}.
   *
   * <ul>
   *   <li>Given builder key {@code 42} value {@code 42} build.
   *   <li>Then return builder key {@code 42} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#withKey(String)}
   */
  @Test
  @DisplayName(
      "Test withKey(String); given builder key '42' value '42' build; then return builder key '42' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserPreference ImmutableUserPreference.withKey(String)"})
  void testWithKey_givenBuilderKey42Value42Build_thenReturnBuilderKey42Value42Build() {
    // Arrange
    ImmutableUserPreference immutableUserPreference =
        ImmutableUserPreference.builder().key("42").value("42").build();

    // Act
    ImmutableUserPreference actualWithKeyResult = immutableUserPreference.withKey("42");

    // Assert
    assertSame(immutableUserPreference, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableUserPreference#withKey(String)}.
   *
   * <ul>
   *   <li>Given builder key {@code Key} value {@code 42} build.
   *   <li>Then return key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#withKey(String)}
   */
  @Test
  @DisplayName(
      "Test withKey(String); given builder key 'Key' value '42' build; then return key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserPreference ImmutableUserPreference.withKey(String)"})
  void testWithKey_givenBuilderKeyKeyValue42Build_thenReturnKeyIs42() {
    // Arrange and Act
    ImmutableUserPreference actualWithKeyResult =
        ImmutableUserPreference.builder().key("Key").value("42").build().withKey("42");

    // Assert
    assertEquals("42", actualWithKeyResult.key());
    assertEquals("42", actualWithKeyResult.value());
  }

  /**
   * Test {@link ImmutableUserPreference#withValue(String)}.
   *
   * <ul>
   *   <li>Given builder key {@code Key} value {@code 42} build.
   *   <li>Then return builder key {@code Key} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#withValue(String)}
   */
  @Test
  @DisplayName(
      "Test withValue(String); given builder key 'Key' value '42' build; then return builder key 'Key' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserPreference ImmutableUserPreference.withValue(String)"})
  void testWithValue_givenBuilderKeyKeyValue42Build_thenReturnBuilderKeyKeyValue42Build() {
    // Arrange
    ImmutableUserPreference immutableUserPreference =
        ImmutableUserPreference.builder().key("Key").value("42").build();

    // Act
    ImmutableUserPreference actualWithValueResult = immutableUserPreference.withValue("42");

    // Assert
    assertSame(immutableUserPreference, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableUserPreference#withValue(String)}.
   *
   * <ul>
   *   <li>Given builder key {@code Key} value {@code value} build.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserPreference#withValue(String)}
   */
  @Test
  @DisplayName(
      "Test withValue(String); given builder key 'Key' value 'value' build; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserPreference ImmutableUserPreference.withValue(String)"})
  void testWithValue_givenBuilderKeyKeyValueValueBuild_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableUserPreference actualWithValueResult =
        ImmutableUserPreference.builder().key("Key").value("value").build().withValue("42");

    // Assert
    assertEquals("42", actualWithValueResult.value());
    assertEquals("Key", actualWithValueResult.key());
  }
}
