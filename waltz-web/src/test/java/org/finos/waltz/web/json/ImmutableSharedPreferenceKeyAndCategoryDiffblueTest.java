package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.web.json.ImmutableSharedPreferenceKeyAndCategory.Builder;
import org.finos.waltz.web.json.ImmutableSharedPreferenceKeyAndCategory.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSharedPreferenceKeyAndCategoryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSharedPreferenceKeyAndCategory Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSharedPreferenceKeyAndCategory actualImmutableSharedPreferenceKeyAndCategory =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build();

    // Assert
    assertEquals("Category", actualImmutableSharedPreferenceKeyAndCategory.category());
    assertEquals("Key", actualImmutableSharedPreferenceKeyAndCategory.key());
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
    Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();

    // Act
    Builder actualCategoryResult = builderResult.category("Category");

    // Assert
    assertSame(builderResult, actualCategoryResult);
  }

  /**
   * Test Builder {@link Builder#from(SharedPreferenceKeyAndCategory)}.
   *
   * <ul>
   *   <li>Then builder build is builder category {@code Category} key {@code Key} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SharedPreferenceKeyAndCategory)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SharedPreferenceKeyAndCategory); then builder build is builder category 'Category' key 'Key' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SharedPreferenceKeyAndCategory)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCategoryCategoryKeyKeyBuild() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();
    ImmutableSharedPreferenceKeyAndCategory instance =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSharedPreferenceKeyAndCategory actualImmutableSharedPreferenceKeyAndCategory =
        builderResult.build();
    assertEquals(instance, actualImmutableSharedPreferenceKeyAndCategory);
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
    Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();

    // Act
    Builder actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#copyOf(SharedPreferenceKeyAndCategory)}.
   *
   * <ul>
   *   <li>When builder category {@code Category} key {@code Key} build.
   *   <li>Then return {@code Category}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSharedPreferenceKeyAndCategory#copyOf(SharedPreferenceKeyAndCategory)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SharedPreferenceKeyAndCategory); when builder category 'Category' key 'Key' build; then return 'Category'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceKeyAndCategory ImmutableSharedPreferenceKeyAndCategory.copyOf(SharedPreferenceKeyAndCategory)"
  })
  void testCopyOf_whenBuilderCategoryCategoryKeyKeyBuild_thenReturnCategory() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory instance =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build();

    // Act
    ImmutableSharedPreferenceKeyAndCategory actualCopyOfResult =
        ImmutableSharedPreferenceKeyAndCategory.copyOf(instance);

    // Assert
    assertEquals("Category", actualCopyOfResult.category());
    assertEquals("Key", actualCopyOfResult.key());
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}, and {@link
   * ImmutableSharedPreferenceKeyAndCategory#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceKeyAndCategory.equals(Object)",
    "int ImmutableSharedPreferenceKeyAndCategory.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory immutableSharedPreferenceKeyAndCategory =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build();
    ImmutableSharedPreferenceKeyAndCategory immutableSharedPreferenceKeyAndCategory2 =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build();

    // Act and Assert
    assertEquals(immutableSharedPreferenceKeyAndCategory, immutableSharedPreferenceKeyAndCategory2);
    assertEquals(
        immutableSharedPreferenceKeyAndCategory.hashCode(),
        immutableSharedPreferenceKeyAndCategory2.hashCode());
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}, and {@link
   * ImmutableSharedPreferenceKeyAndCategory#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceKeyAndCategory.equals(Object)",
    "int ImmutableSharedPreferenceKeyAndCategory.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory immutableSharedPreferenceKeyAndCategory =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build();

    // Act and Assert
    assertEquals(immutableSharedPreferenceKeyAndCategory, immutableSharedPreferenceKeyAndCategory);
    int expectedHashCodeResult = immutableSharedPreferenceKeyAndCategory.hashCode();
    assertEquals(expectedHashCodeResult, immutableSharedPreferenceKeyAndCategory.hashCode());
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceKeyAndCategory.equals(Object)",
    "int ImmutableSharedPreferenceKeyAndCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory immutableSharedPreferenceKeyAndCategory =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Key").key("Key").build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreferenceKeyAndCategory,
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build());
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceKeyAndCategory.equals(Object)",
    "int ImmutableSharedPreferenceKeyAndCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory immutableSharedPreferenceKeyAndCategory =
        ImmutableSharedPreferenceKeyAndCategory.builder()
            .category("Category")
            .key("Category")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSharedPreferenceKeyAndCategory,
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build());
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceKeyAndCategory.equals(Object)",
    "int ImmutableSharedPreferenceKeyAndCategory.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build(),
        null);
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSharedPreferenceKeyAndCategory.equals(Object)",
    "int ImmutableSharedPreferenceKeyAndCategory.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build(),
        "Different type to ImmutableSharedPreferenceKeyAndCategory");
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Key is {@code Json}.
   *   <li>Then return category is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Key is 'Json'; then return category is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceKeyAndCategory ImmutableSharedPreferenceKeyAndCategory.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonKeyIsJson_thenReturnCategoryIsJson() {
    // Arrange
    Json json = new Json();
    json.setKey("Json");
    json.setCategory("Json");

    // Act
    ImmutableSharedPreferenceKeyAndCategory actualFromJsonResult =
        ImmutableSharedPreferenceKeyAndCategory.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.category());
    assertEquals("Json", actualFromJsonResult.key());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory#toString()}
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory#category()}
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory#key()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSharedPreferenceKeyAndCategory.category()",
    "String ImmutableSharedPreferenceKeyAndCategory.key()",
    "String ImmutableSharedPreferenceKeyAndCategory.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory immutableSharedPreferenceKeyAndCategory =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("Key").build();

    // Act
    String actualToStringResult = immutableSharedPreferenceKeyAndCategory.toString();
    String actualCategoryResult = immutableSharedPreferenceKeyAndCategory.category();

    // Assert
    assertEquals("Category", actualCategoryResult);
    assertEquals("Key", immutableSharedPreferenceKeyAndCategory.key());
    assertEquals(
        "SharedPreferenceKeyAndCategory{key=Key, category=Category}", actualToStringResult);
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
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCategory(String)",
    "void Json.setKey(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCategory("Category");
    actualJson.setKey("Key");

    // Assert
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
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#withCategory(String)}.
   *
   * <ul>
   *   <li>Given builder category {@code Category} key {@code Key} build.
   *   <li>Then return category is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#withCategory(String)}
   */
  @Test
  @DisplayName(
      "Test withCategory(String); given builder category 'Category' key 'Key' build; then return category is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceKeyAndCategory ImmutableSharedPreferenceKeyAndCategory.withCategory(String)"
  })
  void testWithCategory_givenBuilderCategoryCategoryKeyKeyBuild_thenReturnCategoryIs42() {
    // Arrange and Act
    ImmutableSharedPreferenceKeyAndCategory actualWithCategoryResult =
        ImmutableSharedPreferenceKeyAndCategory.builder()
            .category("Category")
            .key("Key")
            .build()
            .withCategory("42");

    // Assert
    assertEquals("42", actualWithCategoryResult.category());
    assertEquals("Key", actualWithCategoryResult.key());
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#withCategory(String)}.
   *
   * <ul>
   *   <li>Then return builder category {@code 42} key {@code Key} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#withCategory(String)}
   */
  @Test
  @DisplayName("Test withCategory(String); then return builder category '42' key 'Key' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceKeyAndCategory ImmutableSharedPreferenceKeyAndCategory.withCategory(String)"
  })
  void testWithCategory_thenReturnBuilderCategory42KeyKeyBuild() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory immutableSharedPreferenceKeyAndCategory =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("42").key("Key").build();

    // Act
    ImmutableSharedPreferenceKeyAndCategory actualWithCategoryResult =
        immutableSharedPreferenceKeyAndCategory.withCategory("42");

    // Assert
    assertSame(immutableSharedPreferenceKeyAndCategory, actualWithCategoryResult);
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#withKey(String)}.
   *
   * <ul>
   *   <li>Given builder category {@code Category} key {@code Key} build.
   *   <li>Then return key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#withKey(String)}
   */
  @Test
  @DisplayName(
      "Test withKey(String); given builder category 'Category' key 'Key' build; then return key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceKeyAndCategory ImmutableSharedPreferenceKeyAndCategory.withKey(String)"
  })
  void testWithKey_givenBuilderCategoryCategoryKeyKeyBuild_thenReturnKeyIs42() {
    // Arrange and Act
    ImmutableSharedPreferenceKeyAndCategory actualWithKeyResult =
        ImmutableSharedPreferenceKeyAndCategory.builder()
            .category("Category")
            .key("Key")
            .build()
            .withKey("42");

    // Assert
    assertEquals("42", actualWithKeyResult.key());
    assertEquals("Category", actualWithKeyResult.category());
  }

  /**
   * Test {@link ImmutableSharedPreferenceKeyAndCategory#withKey(String)}.
   *
   * <ul>
   *   <li>Then return builder category {@code Category} key {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSharedPreferenceKeyAndCategory#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String); then return builder category 'Category' key '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSharedPreferenceKeyAndCategory ImmutableSharedPreferenceKeyAndCategory.withKey(String)"
  })
  void testWithKey_thenReturnBuilderCategoryCategoryKey42Build() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory immutableSharedPreferenceKeyAndCategory =
        ImmutableSharedPreferenceKeyAndCategory.builder().category("Category").key("42").build();

    // Act
    ImmutableSharedPreferenceKeyAndCategory actualWithKeyResult =
        immutableSharedPreferenceKeyAndCategory.withKey("42");

    // Assert
    assertSame(immutableSharedPreferenceKeyAndCategory, actualWithKeyResult);
  }
}
