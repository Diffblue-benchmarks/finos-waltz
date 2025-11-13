package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.entity_relationship.ImmutableUpdateEntityRelationshipParams.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableUpdateEntityRelationshipParams.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateEntityRelationshipParamsDiffblueTest {
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
    "ImmutableUpdateEntityRelationshipParams Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUpdateEntityRelationshipParams actualImmutableUpdateEntityRelationshipParams =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();

    // Assert
    assertEquals(
        "Relationship Kind", actualImmutableUpdateEntityRelationshipParams.relationshipKind());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableUpdateEntityRelationshipParams.description());
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
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    ImmutableUpdateEntityRelationshipParams instance =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableUpdateEntityRelationshipParams actualImmutableUpdateEntityRelationshipParams =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateEntityRelationshipParams);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

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
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateEntityRelationshipParams)} with {@code
   * UpdateEntityRelationshipParams}.
   *
   * <p>Method under test: {@link Builder#from(UpdateEntityRelationshipParams)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateEntityRelationshipParams) with 'UpdateEntityRelationshipParams'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateEntityRelationshipParams)"})
  void testBuilderFromWithUpdateEntityRelationshipParams() {
    // Arrange
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    ImmutableUpdateEntityRelationshipParams instance =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateEntityRelationshipParams actualImmutableUpdateEntityRelationshipParams =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateEntityRelationshipParams);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateEntityRelationshipParams)} with {@code
   * UpdateEntityRelationshipParams}.
   *
   * <p>Method under test: {@link Builder#from(UpdateEntityRelationshipParams)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateEntityRelationshipParams) with 'UpdateEntityRelationshipParams'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateEntityRelationshipParams)"})
  void testBuilderFromWithUpdateEntityRelationshipParams2() {
    // Arrange
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    ImmutableUpdateEntityRelationshipParams instance =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description(null)
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateEntityRelationshipParams actualImmutableUpdateEntityRelationshipParams =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateEntityRelationshipParams);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#relationshipKind(String)}.
   *
   * <ul>
   *   <li>Then builder build relationshipKind is {@code Relationship Kind}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#relationshipKind(String)}
   */
  @Test
  @DisplayName(
      "Test Builder relationshipKind(String); then builder build relationshipKind is 'Relationship Kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationshipKind(String)"})
  void testBuilderRelationshipKind_thenBuilderBuildRelationshipKindIsRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();

    // Act
    Builder actualRelationshipKindResult = builderResult.relationshipKind("Relationship Kind");

    // Assert
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams =
        builderResult.build();
    assertEquals("Relationship Kind", immutableUpdateEntityRelationshipParams.relationshipKind());
    assertNull(immutableUpdateEntityRelationshipParams.description());
    assertSame(builderResult, actualRelationshipKindResult);
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#copyOf(UpdateEntityRelationshipParams)}.
   *
   * <ul>
   *   <li>Then return {@code Relationship Kind}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableUpdateEntityRelationshipParams#copyOf(UpdateEntityRelationshipParams)}
   */
  @Test
  @DisplayName("Test copyOf(UpdateEntityRelationshipParams); then return 'Relationship Kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateEntityRelationshipParams ImmutableUpdateEntityRelationshipParams.copyOf(UpdateEntityRelationshipParams)"
  })
  void testCopyOf_thenReturnRelationshipKind() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams instance =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    ImmutableUpdateEntityRelationshipParams actualCopyOfResult =
        ImmutableUpdateEntityRelationshipParams.copyOf(instance);

    // Assert
    assertEquals("Relationship Kind", actualCopyOfResult.relationshipKind());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#equals(Object)}, and {@link
   * ImmutableUpdateEntityRelationshipParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#equals(Object)}
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateEntityRelationshipParams.equals(Object)",
    "int ImmutableUpdateEntityRelationshipParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams2 =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();

    // Act and Assert
    assertEquals(immutableUpdateEntityRelationshipParams, immutableUpdateEntityRelationshipParams2);
    assertEquals(
        immutableUpdateEntityRelationshipParams.hashCode(),
        immutableUpdateEntityRelationshipParams2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#equals(Object)}, and {@link
   * ImmutableUpdateEntityRelationshipParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#equals(Object)}
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateEntityRelationshipParams.equals(Object)",
    "int ImmutableUpdateEntityRelationshipParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();

    // Act and Assert
    assertEquals(immutableUpdateEntityRelationshipParams, immutableUpdateEntityRelationshipParams);
    int expectedHashCodeResult = immutableUpdateEntityRelationshipParams.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateEntityRelationshipParams.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateEntityRelationshipParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateEntityRelationshipParams.equals(Object)",
    "int ImmutableUpdateEntityRelationshipParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("java.lang.String")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateEntityRelationshipParams,
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build());
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateEntityRelationshipParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateEntityRelationshipParams.equals(Object)",
    "int ImmutableUpdateEntityRelationshipParams.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateEntityRelationshipParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateEntityRelationshipParams.equals(Object)",
    "int ImmutableUpdateEntityRelationshipParams.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build(),
        "Different type to ImmutableUpdateEntityRelationshipParams");
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateEntityRelationshipParams#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateEntityRelationshipParams ImmutableUpdateEntityRelationshipParams.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setDescription("Json");
    json.setRelationshipKind("Json");

    // Act
    ImmutableUpdateEntityRelationshipParams actualFromJsonResult =
        ImmutableUpdateEntityRelationshipParams.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.relationshipKind());
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateEntityRelationshipParams#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateEntityRelationshipParams ImmutableUpdateEntityRelationshipParams.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setDescription(null);
    json.setRelationshipKind("Json");

    // Act
    ImmutableUpdateEntityRelationshipParams actualFromJsonResult =
        ImmutableUpdateEntityRelationshipParams.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.relationshipKind());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#toString()}
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#description()}
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#relationshipKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUpdateEntityRelationshipParams.description()",
    "String ImmutableUpdateEntityRelationshipParams.relationshipKind()",
    "String ImmutableUpdateEntityRelationshipParams.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    String actualToStringResult = immutableUpdateEntityRelationshipParams.toString();
    String actualDescriptionResult = immutableUpdateEntityRelationshipParams.description();

    // Assert
    assertEquals("Relationship Kind", immutableUpdateEntityRelationshipParams.relationshipKind());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(
        "UpdateEntityRelationshipParams{relationshipKind=Relationship Kind}", actualToStringResult);
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
   *   <li>{@link Json#setRelationshipKind(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setRelationshipKind(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setRelationshipKind("Relationship Kind");

    // Assert
    assertEquals("Relationship Kind", actualJson.relationshipKind);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Test Json {@link Json#relationshipKind()}.
   *
   * <p>Method under test: {@link Json#relationshipKind()}
   */
  @Test
  @DisplayName("Test Json relationshipKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.relationshipKind()"})
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relationshipKind());
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableUpdateEntityRelationshipParams#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateEntityRelationshipParams ImmutableUpdateEntityRelationshipParams.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    ImmutableUpdateEntityRelationshipParams actualWithDescriptionResult =
        immutableUpdateEntityRelationshipParams.withDescription("42");

    // Assert
    assertEquals(immutableUpdateEntityRelationshipParams, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableUpdateEntityRelationshipParams#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateEntityRelationshipParams ImmutableUpdateEntityRelationshipParams.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("42")
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    ImmutableUpdateEntityRelationshipParams actualWithDescriptionResult =
        immutableUpdateEntityRelationshipParams.withDescription("42");

    // Assert
    assertSame(immutableUpdateEntityRelationshipParams, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#withRelationshipKind(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateEntityRelationshipParams#withRelationshipKind(String)}
   */
  @Test
  @DisplayName("Test withRelationshipKind(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateEntityRelationshipParams ImmutableUpdateEntityRelationshipParams.withRelationshipKind(String)"
  })
  void testWithRelationshipKind() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams immutableUpdateEntityRelationshipParams =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("42")
            .build();

    // Act
    ImmutableUpdateEntityRelationshipParams actualWithRelationshipKindResult =
        immutableUpdateEntityRelationshipParams.withRelationshipKind("42");

    // Assert
    assertSame(immutableUpdateEntityRelationshipParams, actualWithRelationshipKindResult);
  }

  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#withRelationshipKind(String)}.
   *
   * <ul>
   *   <li>Then return relationshipKind is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableUpdateEntityRelationshipParams#withRelationshipKind(String)}
   */
  @Test
  @DisplayName("Test withRelationshipKind(String); then return relationshipKind is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateEntityRelationshipParams ImmutableUpdateEntityRelationshipParams.withRelationshipKind(String)"
  })
  void testWithRelationshipKind_thenReturnRelationshipKindIs42() {
    // Arrange and Act
    ImmutableUpdateEntityRelationshipParams actualWithRelationshipKindResult =
        ImmutableUpdateEntityRelationshipParams.builder()
            .description("The characteristics of someone or something")
            .relationshipKind("Relationship Kind")
            .build()
            .withRelationshipKind("42");

    // Assert
    assertEquals("42", actualWithRelationshipKindResult.relationshipKind());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRelationshipKindResult.description());
  }
}
