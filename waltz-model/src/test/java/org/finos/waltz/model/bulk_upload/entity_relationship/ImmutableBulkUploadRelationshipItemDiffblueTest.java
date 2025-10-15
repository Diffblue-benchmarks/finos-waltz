package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipItem.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipItemDiffblueTest {
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
    "ImmutableBulkUploadRelationshipItem Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipItem actualImmutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableBulkUploadRelationshipItem.sourceExternalId());
    assertEquals("42", actualImmutableBulkUploadRelationshipItem.targetExternalId());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableBulkUploadRelationshipItem.description());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();
    ImmutableBulkUploadRelationshipItem instance =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadRelationshipItem actualImmutableBulkUploadRelationshipItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();
    ImmutableBulkUploadRelationshipItem instance =
        ImmutableBulkUploadRelationshipItem.builder()
            .description(null)
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadRelationshipItem actualImmutableBulkUploadRelationshipItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#sourceExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sourceExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder sourceExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sourceExternalId(String)"})
  void testBuilderSourceExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();

    // Act
    Builder actualSourceExternalIdResult = builderResult.sourceExternalId("42");

    // Assert
    assertSame(builderResult, actualSourceExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#targetExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder targetExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetExternalId(String)"})
  void testBuilderTargetExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();

    // Act
    Builder actualTargetExternalIdResult = builderResult.targetExternalId("42");

    // Assert
    assertSame(builderResult, actualTargetExternalIdResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#copyOf(BulkUploadRelationshipItem)}.
   *
   * <ul>
   *   <li>Then return sourceExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipItem#copyOf(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test copyOf(BulkUploadRelationshipItem); then return sourceExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.copyOf(BulkUploadRelationshipItem)"
  })
  void testCopyOf_thenReturnSourceExternalIdIs42() {
    // Arrange
    ImmutableBulkUploadRelationshipItem instance =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act
    ImmutableBulkUploadRelationshipItem actualCopyOfResult =
        ImmutableBulkUploadRelationshipItem.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.sourceExternalId());
    assertEquals("42", actualCopyOfResult.targetExternalId());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipItem#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem2 =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act and Assert
    assertEquals(immutableBulkUploadRelationshipItem, immutableBulkUploadRelationshipItem2);
    assertEquals(
        immutableBulkUploadRelationshipItem.hashCode(),
        immutableBulkUploadRelationshipItem2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipItem#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act and Assert
    assertEquals(immutableBulkUploadRelationshipItem, immutableBulkUploadRelationshipItem);
    int expectedHashCodeResult = immutableBulkUploadRelationshipItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkUploadRelationshipItem.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("42")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipItem,
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("Source External Id")
            .targetExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipItem,
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("Target External Id")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipItem,
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build(),
        "Different type to ImmutableBulkUploadRelationshipItem");
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setSourceExternalId("Json");
    json.setTargetExternalId("Json");
    json.setDescription("Json");

    // Act
    ImmutableBulkUploadRelationshipItem actualFromJsonResult =
        ImmutableBulkUploadRelationshipItem.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.sourceExternalId());
    assertEquals("Json", actualFromJsonResult.targetExternalId());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SourceExternalId is {@code Json}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SourceExternalId is 'Json'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.fromJson(Json)"
  })
  void testFromJson_whenJsonSourceExternalIdIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setSourceExternalId("Json");
    json.setTargetExternalId("Json");
    json.setDescription(null);

    // Act
    ImmutableBulkUploadRelationshipItem actualFromJsonResult =
        ImmutableBulkUploadRelationshipItem.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.sourceExternalId());
    assertEquals("Json", actualFromJsonResult.targetExternalId());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipItem#toString()}
   *   <li>{@link ImmutableBulkUploadRelationshipItem#description()}
   *   <li>{@link ImmutableBulkUploadRelationshipItem#sourceExternalId()}
   *   <li>{@link ImmutableBulkUploadRelationshipItem#targetExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBulkUploadRelationshipItem.description()",
    "String ImmutableBulkUploadRelationshipItem.sourceExternalId()",
    "String ImmutableBulkUploadRelationshipItem.targetExternalId()",
    "String ImmutableBulkUploadRelationshipItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act
    String actualToStringResult = immutableBulkUploadRelationshipItem.toString();
    String actualDescriptionResult = immutableBulkUploadRelationshipItem.description();
    String actualSourceExternalIdResult = immutableBulkUploadRelationshipItem.sourceExternalId();

    // Assert
    assertEquals("42", actualSourceExternalIdResult);
    assertEquals("42", immutableBulkUploadRelationshipItem.targetExternalId());
    assertEquals(
        "BulkUploadRelationshipItem{sourceExternalId=42, targetExternalId=42, description=The characteristics"
            + " of someone or something}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
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
   *   <li>{@link Json#setSourceExternalId(String)}
   *   <li>{@link Json#setTargetExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setSourceExternalId(String)",
    "void Json.setTargetExternalId(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setSourceExternalId("42");
    actualJson.setTargetExternalId("42");

    // Assert
    assertEquals("42", actualJson.sourceExternalId);
    assertEquals("42", actualJson.targetExternalId);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Test Json {@link Json#sourceExternalId()}.
   *
   * <p>Method under test: {@link Json#sourceExternalId()}
   */
  @Test
  @DisplayName("Test Json sourceExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.sourceExternalId()"})
  void testJsonSourceExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sourceExternalId());
  }

  /**
   * Test Json {@link Json#targetExternalId()}.
   *
   * <p>Method under test: {@link Json#targetExternalId()}
   */
  @Test
  @DisplayName("Test Json targetExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.targetExternalId()"})
  void testJsonTargetExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetExternalId());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("42")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act
    ImmutableBulkUploadRelationshipItem actualWithDescriptionResult =
        immutableBulkUploadRelationshipItem.withDescription("42");

    // Assert
    assertSame(immutableBulkUploadRelationshipItem, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.withDescription(String)"
  })
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipItem actualWithDescriptionResult =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("42", actualWithDescriptionResult.sourceExternalId());
    assertEquals("42", actualWithDescriptionResult.targetExternalId());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#withSourceExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#withSourceExternalId(String)}
   */
  @Test
  @DisplayName("Test withSourceExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.withSourceExternalId(String)"
  })
  void testWithSourceExternalId() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act
    ImmutableBulkUploadRelationshipItem actualWithSourceExternalIdResult =
        immutableBulkUploadRelationshipItem.withSourceExternalId("42");

    // Assert
    assertSame(immutableBulkUploadRelationshipItem, actualWithSourceExternalIdResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#withSourceExternalId(String)}.
   *
   * <ul>
   *   <li>Then return sourceExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#withSourceExternalId(String)}
   */
  @Test
  @DisplayName("Test withSourceExternalId(String); then return sourceExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.withSourceExternalId(String)"
  })
  void testWithSourceExternalId_thenReturnSourceExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipItem actualWithSourceExternalIdResult =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("sourceExternalId")
            .targetExternalId("42")
            .build()
            .withSourceExternalId("42");

    // Assert
    assertEquals("42", actualWithSourceExternalIdResult.sourceExternalId());
    assertEquals("42", actualWithSourceExternalIdResult.targetExternalId());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSourceExternalIdResult.description());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#withTargetExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#withTargetExternalId(String)}
   */
  @Test
  @DisplayName("Test withTargetExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.withTargetExternalId(String)"
  })
  void testWithTargetExternalId() {
    // Arrange
    ImmutableBulkUploadRelationshipItem immutableBulkUploadRelationshipItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();

    // Act
    ImmutableBulkUploadRelationshipItem actualWithTargetExternalIdResult =
        immutableBulkUploadRelationshipItem.withTargetExternalId("42");

    // Assert
    assertSame(immutableBulkUploadRelationshipItem, actualWithTargetExternalIdResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#withTargetExternalId(String)}.
   *
   * <ul>
   *   <li>Then return sourceExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipItem#withTargetExternalId(String)}
   */
  @Test
  @DisplayName("Test withTargetExternalId(String); then return sourceExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipItem ImmutableBulkUploadRelationshipItem.withTargetExternalId(String)"
  })
  void testWithTargetExternalId_thenReturnSourceExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipItem actualWithTargetExternalIdResult =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("targetExternalId")
            .build()
            .withTargetExternalId("42");

    // Assert
    assertEquals("42", actualWithTargetExternalIdResult.sourceExternalId());
    assertEquals("42", actualWithTargetExternalIdResult.targetExternalId());
    assertEquals(
        "The characteristics of someone or something",
        actualWithTargetExternalIdResult.description());
  }
}
