package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyItemDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#parentExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyItem Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.parentExternalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkTaxonomyItem actualImmutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableBulkTaxonomyItem.externalId());
    assertEquals("42", actualImmutableBulkTaxonomyItem.parentExternalId());
    assertEquals("Name", actualImmutableBulkTaxonomyItem.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableBulkTaxonomyItem.description());
    assertTrue(actualImmutableBulkTaxonomyItem.concrete());
  }

  /**
   * Test Builder {@link Builder#concrete(boolean)}.
   *
   * <p>Method under test: {@link Builder#concrete(boolean)}
   */
  @Test
  @DisplayName("Test Builder concrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.concrete(boolean)"})
  void testBuilderConcrete() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act
    Builder actualConcreteResult = builderResult.concrete(true);

    // Assert
    assertSame(builderResult, actualConcreteResult);
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    ImmutableBulkTaxonomyItem instance =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyItem actualImmutableBulkTaxonomyItem = builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    ImmutableBulkTaxonomyItem instance =
        ImmutableBulkTaxonomyItem.builder()
            .description(null)
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyItem actualImmutableBulkTaxonomyItem = builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyItem)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    ImmutableBulkTaxonomyItem instance =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyItem actualImmutableBulkTaxonomyItem = builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyItem);
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
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#copyOf(BulkTaxonomyItem)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#copyOf(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test copyOf(BulkTaxonomyItem); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.copyOf(BulkTaxonomyItem)"
  })
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableBulkTaxonomyItem instance =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act
    ImmutableBulkTaxonomyItem actualCopyOfResult = ImmutableBulkTaxonomyItem.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.parentExternalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyItem#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.equals(Object)",
    "int ImmutableBulkTaxonomyItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem2 =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyItem, immutableBulkTaxonomyItem2);
    assertEquals(immutableBulkTaxonomyItem.hashCode(), immutableBulkTaxonomyItem2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyItem#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.equals(Object)",
    "int ImmutableBulkTaxonomyItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyItem, immutableBulkTaxonomyItem);
    int expectedHashCodeResult = immutableBulkTaxonomyItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkTaxonomyItem.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.equals(Object)",
    "int ImmutableBulkTaxonomyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("Name")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyItem,
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.equals(Object)",
    "int ImmutableBulkTaxonomyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyItem,
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.equals(Object)",
    "int ImmutableBulkTaxonomyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("42")
            .parentExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyItem,
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.equals(Object)",
    "int ImmutableBulkTaxonomyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyItem,
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.equals(Object)",
    "int ImmutableBulkTaxonomyItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.equals(Object)",
    "int ImmutableBulkTaxonomyItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build(),
        "Different type to ImmutableBulkTaxonomyItem");
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code name}.
   *   <li>When {@link Json} (default constructor) ExternalId is {@code 42}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'name'; when Json (default constructor) ExternalId is '42'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.fromJson(Json)"})
  void testFromJson_givenName_whenJsonExternalIdIs42_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setExternalId("42");
    json.setName("name");

    // Act
    ImmutableBulkTaxonomyItem actualFromJsonResult = ImmutableBulkTaxonomyItem.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.externalId());
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.parentExternalId());
    assertTrue(actualFromJsonResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setDescription("The characteristics of someone or something");
    json.setExternalId("42");
    json.setName("name");

    // Act
    ImmutableBulkTaxonomyItem actualFromJsonResult = ImmutableBulkTaxonomyItem.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.externalId());
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.parentExternalId());
    assertTrue(actualFromJsonResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ParentExternalId is {@code 42}.
   *   <li>Then return parentExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ParentExternalId is '42'; then return parentExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.fromJson(Json)"})
  void testFromJson_whenJsonParentExternalIdIs42_thenReturnParentExternalIdIs42() {
    // Arrange
    Json json = new Json();
    json.setParentExternalId("42");
    json.setExternalId("42");
    json.setName("name");

    // Act
    ImmutableBulkTaxonomyItem actualFromJsonResult = ImmutableBulkTaxonomyItem.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.externalId());
    assertEquals("42", actualFromJsonResult.parentExternalId());
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertTrue(actualFromJsonResult.concrete());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyItem#toString()}
   *   <li>{@link ImmutableBulkTaxonomyItem#concrete()}
   *   <li>{@link ImmutableBulkTaxonomyItem#description()}
   *   <li>{@link ImmutableBulkTaxonomyItem#externalId()}
   *   <li>{@link ImmutableBulkTaxonomyItem#name()}
   *   <li>{@link ImmutableBulkTaxonomyItem#parentExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyItem.concrete()",
    "String ImmutableBulkTaxonomyItem.description()",
    "String ImmutableBulkTaxonomyItem.externalId()",
    "String ImmutableBulkTaxonomyItem.name()",
    "String ImmutableBulkTaxonomyItem.parentExternalId()",
    "String ImmutableBulkTaxonomyItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act
    String actualToStringResult = immutableBulkTaxonomyItem.toString();
    boolean actualConcreteResult = immutableBulkTaxonomyItem.concrete();
    String actualDescriptionResult = immutableBulkTaxonomyItem.description();
    String actualExternalIdResult = immutableBulkTaxonomyItem.externalId();
    String actualNameResult = immutableBulkTaxonomyItem.name();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals("42", immutableBulkTaxonomyItem.parentExternalId());
    assertEquals(
        "BulkTaxonomyItem{name=Name, externalId=42, parentExternalId=42, description=The characteristics of"
            + " someone or something, concrete=true}",
        actualToStringResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertTrue(actualConcreteResult);
  }

  /**
   * Test Json {@link Json#concrete()}.
   *
   * <p>Method under test: {@link Json#concrete()}
   */
  @Test
  @DisplayName("Test Json concrete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.concrete()"})
  void testJsonConcrete() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().concrete());
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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setParentExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setExternalId(String)",
    "void Json.setName(String)",
    "void Json.setParentExternalId(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setName("Name");
    actualJson.setParentExternalId("42");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("42", actualJson.parentExternalId);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertFalse(actualJson.concrete);
    assertFalse(actualJson.concreteIsSet);
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
   * Test Json {@link Json#parentExternalId()}.
   *
   * <p>Method under test: {@link Json#parentExternalId()}
   */
  @Test
  @DisplayName("Test Json parentExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.parentExternalId()"})
  void testJsonParentExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentExternalId());
  }

  /**
   * Test Json {@link Json#setConcrete(boolean)}.
   *
   * <p>Method under test: {@link Json#setConcrete(boolean)}
   */
  @Test
  @DisplayName("Test Json setConcrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setConcrete(boolean)"})
  void testJsonSetConcrete() {
    // Arrange
    Json json = new Json();

    // Act
    json.setConcrete(true);

    // Assert
    assertTrue(json.concrete);
    assertTrue(json.concreteIsSet);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withConcrete(boolean)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withConcrete(boolean)}
   */
  @Test
  @DisplayName("Test withConcrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withConcrete(boolean)"})
  void testWithConcrete() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act
    ImmutableBulkTaxonomyItem actualWithConcreteResult =
        immutableBulkTaxonomyItem.withConcrete(true);

    // Assert
    assertSame(immutableBulkTaxonomyItem, actualWithConcreteResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withConcrete(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withConcrete(boolean)}
   */
  @Test
  @DisplayName("Test withConcrete(boolean); when 'false'; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withConcrete(boolean)"})
  void testWithConcrete_whenFalse_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkTaxonomyItem actualWithConcreteResult =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build()
            .withConcrete(false);

    // Assert
    assertEquals("42", actualWithConcreteResult.externalId());
    assertEquals("42", actualWithConcreteResult.parentExternalId());
    assertEquals("Name", actualWithConcreteResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithConcreteResult.description());
    assertFalse(actualWithConcreteResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("42")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act
    ImmutableBulkTaxonomyItem actualWithDescriptionResult =
        immutableBulkTaxonomyItem.withDescription("42");

    // Assert
    assertSame(immutableBulkTaxonomyItem, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withDescription(String)"})
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableBulkTaxonomyItem actualWithDescriptionResult =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("42", actualWithDescriptionResult.externalId());
    assertEquals("42", actualWithDescriptionResult.parentExternalId());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertTrue(actualWithDescriptionResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withExternalId(String)"})
  void testWithExternalId() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("0123456789ABCDEF")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act
    ImmutableBulkTaxonomyItem actualWithExternalIdResult =
        immutableBulkTaxonomyItem.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableBulkTaxonomyItem, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withExternalId(String)"})
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableBulkTaxonomyItem actualWithExternalIdResult =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("42", actualWithExternalIdResult.parentExternalId());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertTrue(actualWithExternalIdResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("42")
            .parentExternalId("42")
            .build();

    // Act
    ImmutableBulkTaxonomyItem actualWithNameResult = immutableBulkTaxonomyItem.withName("42");

    // Assert
    assertSame(immutableBulkTaxonomyItem, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withName(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withName(String)"})
  void testWithName_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkTaxonomyItem actualWithNameResult =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.parentExternalId());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertTrue(actualWithNameResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withParentExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withParentExternalId(String)}
   */
  @Test
  @DisplayName("Test withParentExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withParentExternalId(String)"
  })
  void testWithParentExternalId() {
    // Arrange
    ImmutableBulkTaxonomyItem immutableBulkTaxonomyItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();

    // Act
    ImmutableBulkTaxonomyItem actualWithParentExternalIdResult =
        immutableBulkTaxonomyItem.withParentExternalId("42");

    // Assert
    assertSame(immutableBulkTaxonomyItem, actualWithParentExternalIdResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyItem#withParentExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyItem#withParentExternalId(String)}
   */
  @Test
  @DisplayName("Test withParentExternalId(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyItem ImmutableBulkTaxonomyItem.withParentExternalId(String)"
  })
  void testWithParentExternalId_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkTaxonomyItem actualWithParentExternalIdResult =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("Parent External Id")
            .build()
            .withParentExternalId("42");

    // Assert
    assertEquals("42", actualWithParentExternalIdResult.externalId());
    assertEquals("42", actualWithParentExternalIdResult.parentExternalId());
    assertEquals("Name", actualWithParentExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithParentExternalIdResult.description());
    assertTrue(actualWithParentExternalIdResult.concrete());
  }
}
