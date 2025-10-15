package org.finos.waltz.model.shared_preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreferenceSaveCommand.Builder;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreferenceSaveCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSharedPreferenceSaveCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreferenceSaveCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSharedPreferenceSaveCommand actualImmutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableSharedPreferenceSaveCommand.value());
    assertEquals("Category", actualImmutableSharedPreferenceSaveCommand.category());
    assertEquals("Key", actualImmutableSharedPreferenceSaveCommand.key());
  }

  /**
   * Test Builder {@link Builder#category(String)}.
   *
   * <ul>
   *   <li>When {@code Category}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#category(String)}
   */
  @Test
  @DisplayName("Test Builder category(String); when 'Category'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.category(String)"})
  void testBuilderCategory_whenCategory_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

    // Act
    Builder actualCategoryResult = builderResult.category("Category");

    // Assert
    assertSame(builderResult, actualCategoryResult);
  }

  /**
   * Test Builder {@link Builder#from(SharedPreferenceSaveCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder category {@code Category} key {@code Key} value {@code 42}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SharedPreferenceSaveCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SharedPreferenceSaveCommand); then builder build is builder category 'Category' key 'Key' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SharedPreferenceSaveCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCategoryCategoryKeyKeyValue42Build() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();
    ImmutableSharedPreferenceSaveCommand instance =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSharedPreferenceSaveCommand actualImmutableSharedPreferenceSaveCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSharedPreferenceSaveCommand);
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
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

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
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#copyOf(SharedPreferenceSaveCommand)}.
   *
   * <ul>
   *   <li>When builder category {@code Category} key {@code Key} value {@code 42} build.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSharedPreferenceSaveCommand#copyOf(SharedPreferenceSaveCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SharedPreferenceSaveCommand); when builder category 'Category' key 'Key' value '42' build; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceSaveCommand ImmutableSharedPreferenceSaveCommand.copyOf(SharedPreferenceSaveCommand)"
  })
  void testCopyOf_whenBuilderCategoryCategoryKeyKeyValue42Build_thenReturnValueIs42() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand instance =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreferenceSaveCommand actualCopyOfResult =
        ImmutableSharedPreferenceSaveCommand.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Category", actualCopyOfResult.category());
    assertEquals("Key", actualCopyOfResult.key());
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}, and {@link
   * ImmutableSharedPreferenceSaveCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreferenceSaveCommand#equals(Object)}
   *   <li>{@link ImmutableSharedPreferenceSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceSaveCommand.equals(Object)",
    "int ImmutableSharedPreferenceSaveCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build();
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand2 =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSharedPreferenceSaveCommand, immutableSharedPreferenceSaveCommand2);
    assertEquals(
        immutableSharedPreferenceSaveCommand.hashCode(),
        immutableSharedPreferenceSaveCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}, and {@link
   * ImmutableSharedPreferenceSaveCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreferenceSaveCommand#equals(Object)}
   *   <li>{@link ImmutableSharedPreferenceSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceSaveCommand.equals(Object)",
    "int ImmutableSharedPreferenceSaveCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSharedPreferenceSaveCommand, immutableSharedPreferenceSaveCommand);
    int expectedHashCodeResult = immutableSharedPreferenceSaveCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSharedPreferenceSaveCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceSaveCommand.equals(Object)",
    "int ImmutableSharedPreferenceSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Key")
            .key("Key")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreferenceSaveCommand,
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceSaveCommand.equals(Object)",
    "int ImmutableSharedPreferenceSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Category")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreferenceSaveCommand,
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceSaveCommand.equals(Object)",
    "int ImmutableSharedPreferenceSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("Key")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreferenceSaveCommand,
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceSaveCommand.equals(Object)",
    "int ImmutableSharedPreferenceSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceSaveCommand.equals(Object)",
    "int ImmutableSharedPreferenceSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build(),
        "Different type to ImmutableSharedPreferenceSaveCommand");
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Key is {@code Json}.
   *   <li>Then return category is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Key is 'Json'; then return category is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceSaveCommand ImmutableSharedPreferenceSaveCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonKeyIsJson_thenReturnCategoryIsJson() {
    // Arrange
    Json json = new Json();
    json.setKey("Json");
    json.setCategory("Json");
    json.setValue("Json");

    // Act
    ImmutableSharedPreferenceSaveCommand actualFromJsonResult =
        ImmutableSharedPreferenceSaveCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.category());
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreferenceSaveCommand#toString()}
   *   <li>{@link ImmutableSharedPreferenceSaveCommand#category()}
   *   <li>{@link ImmutableSharedPreferenceSaveCommand#key()}
   *   <li>{@link ImmutableSharedPreferenceSaveCommand#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSharedPreferenceSaveCommand.category()",
    "String ImmutableSharedPreferenceSaveCommand.key()",
    "String ImmutableSharedPreferenceSaveCommand.toString()",
    "String ImmutableSharedPreferenceSaveCommand.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build();

    // Act
    String actualToStringResult = immutableSharedPreferenceSaveCommand.toString();
    String actualCategoryResult = immutableSharedPreferenceSaveCommand.category();
    String actualKeyResult = immutableSharedPreferenceSaveCommand.key();

    // Assert
    assertEquals("42", immutableSharedPreferenceSaveCommand.value());
    assertEquals("Category", actualCategoryResult);
    assertEquals("Key", actualKeyResult);
    assertEquals(
        "SharedPreferenceSaveCommand{key=Key, category=Category, value=42}", actualToStringResult);
  }

  /**
   * Test Json {@link Json#category()}.
   *
   * <p>Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().category());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCategory(String)}
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
    "void Json.setCategory(String)",
    "void Json.setKey(String)",
    "void Json.setValue(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCategory("Category");
    actualJson.setKey("Key");
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals("Category", actualJson.category);
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
   * Test {@link ImmutableSharedPreferenceSaveCommand#withCategory(String)}.
   *
   * <ul>
   *   <li>Then return builder category {@code 42} key {@code Key} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#withCategory(String)}
   */
  @Test
  @DisplayName(
      "Test withCategory(String); then return builder category '42' key 'Key' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceSaveCommand ImmutableSharedPreferenceSaveCommand.withCategory(String)"
  })
  void testWithCategory_thenReturnBuilderCategory42KeyKeyValue42Build() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("42")
            .key("Key")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreferenceSaveCommand actualWithCategoryResult =
        immutableSharedPreferenceSaveCommand.withCategory("42");

    // Assert
    assertSame(immutableSharedPreferenceSaveCommand, actualWithCategoryResult);
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#withCategory(String)}.
   *
   * <ul>
   *   <li>Then return category is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#withCategory(String)}
   */
  @Test
  @DisplayName("Test withCategory(String); then return category is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceSaveCommand ImmutableSharedPreferenceSaveCommand.withCategory(String)"
  })
  void testWithCategory_thenReturnCategoryIs42() {
    // Arrange and Act
    ImmutableSharedPreferenceSaveCommand actualWithCategoryResult =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build()
            .withCategory("42");

    // Assert
    assertEquals("42", actualWithCategoryResult.category());
    assertEquals("42", actualWithCategoryResult.value());
    assertEquals("Key", actualWithCategoryResult.key());
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#withKey(String)}.
   *
   * <ul>
   *   <li>Given builder category {@code Category} key {@code Key} value {@code 42} build.
   *   <li>Then return key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#withKey(String)}
   */
  @Test
  @DisplayName(
      "Test withKey(String); given builder category 'Category' key 'Key' value '42' build; then return key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceSaveCommand ImmutableSharedPreferenceSaveCommand.withKey(String)"
  })
  void testWithKey_givenBuilderCategoryCategoryKeyKeyValue42Build_thenReturnKeyIs42() {
    // Arrange and Act
    ImmutableSharedPreferenceSaveCommand actualWithKeyResult =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build()
            .withKey("42");

    // Assert
    assertEquals("42", actualWithKeyResult.key());
    assertEquals("42", actualWithKeyResult.value());
    assertEquals("Category", actualWithKeyResult.category());
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#withKey(String)}.
   *
   * <ul>
   *   <li>Then return builder category {@code Category} key {@code 42} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#withKey(String)}
   */
  @Test
  @DisplayName(
      "Test withKey(String); then return builder category 'Category' key '42' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceSaveCommand ImmutableSharedPreferenceSaveCommand.withKey(String)"
  })
  void testWithKey_thenReturnBuilderCategoryCategoryKey42Value42Build() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("42")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreferenceSaveCommand actualWithKeyResult =
        immutableSharedPreferenceSaveCommand.withKey("42");

    // Assert
    assertSame(immutableSharedPreferenceSaveCommand, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#withValue(String)}.
   *
   * <ul>
   *   <li>Then return builder category {@code Category} key {@code Key} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#withValue(String)}
   */
  @Test
  @DisplayName(
      "Test withValue(String); then return builder category 'Category' key 'Key' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceSaveCommand ImmutableSharedPreferenceSaveCommand.withValue(String)"
  })
  void testWithValue_thenReturnBuilderCategoryCategoryKeyKeyValue42Build() {
    // Arrange
    ImmutableSharedPreferenceSaveCommand immutableSharedPreferenceSaveCommand =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("42")
            .build();

    // Act
    ImmutableSharedPreferenceSaveCommand actualWithValueResult =
        immutableSharedPreferenceSaveCommand.withValue("42");

    // Assert
    assertSame(immutableSharedPreferenceSaveCommand, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableSharedPreferenceSaveCommand#withValue(String)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceSaveCommand#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceSaveCommand ImmutableSharedPreferenceSaveCommand.withValue(String)"
  })
  void testWithValue_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableSharedPreferenceSaveCommand actualWithValueResult =
        ImmutableSharedPreferenceSaveCommand.builder()
            .category("Category")
            .key("Key")
            .value("value")
            .build()
            .withValue("42");

    // Assert
    assertEquals("42", actualWithValueResult.value());
    assertEquals("Category", actualWithValueResult.category());
    assertEquals("Key", actualWithValueResult.key());
  }
}
