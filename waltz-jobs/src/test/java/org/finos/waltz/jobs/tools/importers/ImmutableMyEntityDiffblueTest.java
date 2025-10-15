package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.ImmutableMyEntity.Builder;
import org.finos.waltz.jobs.tools.importers.ImmutableMyEntity.Json;
import org.finos.waltz.jobs.tools.importers.ImporterExperiment.MyEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMyEntityDiffblueTest {
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
  @MethodsUnderTest({"ImmutableMyEntity Builder.build()", "Builder Builder.description(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableMyEntity actualImmutableMyEntity =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build();

    // Assert
    assertEquals("42", actualImmutableMyEntity.externalId());
    assertEquals("Name", actualImmutableMyEntity.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableMyEntity.description());
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
    Builder builderResult = ImmutableMyEntity.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(MyEntity)}.
   *
   * <p>Method under test: {@link Builder#from(MyEntity)}
   */
  @Test
  @DisplayName("Test Builder from(MyEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MyEntity)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMyEntity.builder();
    ImmutableMyEntity instance =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMyEntity actualImmutableMyEntity = builderResult.build();
    assertEquals(instance, actualImmutableMyEntity);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MyEntity)}.
   *
   * <p>Method under test: {@link Builder#from(MyEntity)}
   */
  @Test
  @DisplayName("Test Builder from(MyEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MyEntity)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableMyEntity.builder();
    ImmutableMyEntity instance =
        ImmutableMyEntity.builder().description(null).externalId("42").name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMyEntity actualImmutableMyEntity = builderResult.build();
    assertEquals(instance, actualImmutableMyEntity);
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
    Builder builderResult = ImmutableMyEntity.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableMyEntity#copyOf(MyEntity)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#copyOf(MyEntity)}
   */
  @Test
  @DisplayName("Test copyOf(MyEntity); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.copyOf(MyEntity)"})
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableMyEntity instance =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build();

    // Act
    ImmutableMyEntity actualCopyOfResult = ImmutableMyEntity.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableMyEntity#equals(Object)}, and {@link ImmutableMyEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMyEntity#equals(Object)}
   *   <li>{@link ImmutableMyEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMyEntity.equals(Object)",
    "int ImmutableMyEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build();
    ImmutableMyEntity immutableMyEntity2 =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableMyEntity, immutableMyEntity2);
    assertEquals(immutableMyEntity.hashCode(), immutableMyEntity2.hashCode());
  }

  /**
   * Test {@link ImmutableMyEntity#equals(Object)}, and {@link ImmutableMyEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMyEntity#equals(Object)}
   *   <li>{@link ImmutableMyEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMyEntity.equals(Object)",
    "int ImmutableMyEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableMyEntity, immutableMyEntity);
    int expectedHashCodeResult = immutableMyEntity.hashCode();
    assertEquals(expectedHashCodeResult, immutableMyEntity.hashCode());
  }

  /**
   * Test {@link ImmutableMyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMyEntity.equals(Object)",
    "int ImmutableMyEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder().description("Name").externalId("42").name("Name").build();

    // Act and Assert
    assertNotEquals(
        immutableMyEntity,
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableMyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMyEntity.equals(Object)",
    "int ImmutableMyEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMyEntity,
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableMyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMyEntity.equals(Object)",
    "int ImmutableMyEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMyEntity,
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableMyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMyEntity.equals(Object)",
    "int ImmutableMyEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMyEntity.equals(Object)",
    "int ImmutableMyEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build(),
        "Different type to ImmutableMyEntity");
  }

  /**
   * Test {@link ImmutableMyEntity#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setExternalId("Json");
    json.setDescription("Json");

    // Act
    ImmutableMyEntity actualFromJsonResult = ImmutableMyEntity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test {@link ImmutableMyEntity#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Name is 'Json'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonNameIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setExternalId("Json");
    json.setDescription(null);

    // Act
    ImmutableMyEntity actualFromJsonResult = ImmutableMyEntity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMyEntity#toString()}
   *   <li>{@link ImmutableMyEntity#description()}
   *   <li>{@link ImmutableMyEntity#externalId()}
   *   <li>{@link ImmutableMyEntity#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableMyEntity.description()",
    "String ImmutableMyEntity.externalId()",
    "String ImmutableMyEntity.name()",
    "String ImmutableMyEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build();

    // Act
    String actualToStringResult = immutableMyEntity.toString();
    String actualDescriptionResult = immutableMyEntity.description();
    String actualExternalIdResult = immutableMyEntity.externalId();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals(
        "MyEntity{name=Name, externalId=42, description=The characteristics of someone or something}",
        actualToStringResult);
    assertEquals("Name", immutableMyEntity.name());
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
    "void Json.setName(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setName("Name");

    // Assert
    assertEquals("42", actualJson.externalId);
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
   * Test {@link ImmutableMyEntity#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} externalId {@code 42} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' externalId '42' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.withDescription(String)"})
  void testWithDescription_thenReturnBuilderDescription42ExternalId42NameNameBuild() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder().description("42").externalId("42").name("Name").build();

    // Act
    ImmutableMyEntity actualWithDescriptionResult = immutableMyEntity.withDescription("42");

    // Assert
    assertSame(immutableMyEntity, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMyEntity#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.withDescription(String)"})
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableMyEntity actualWithDescriptionResult =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("42", actualWithDescriptionResult.externalId());
    assertEquals("Name", actualWithDescriptionResult.name());
  }

  /**
   * Test {@link ImmutableMyEntity#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableMyEntity#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.withExternalId(String)"})
  void testWithExternalId() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("0123456789ABCDEF")
            .name("Name")
            .build();

    // Act
    ImmutableMyEntity actualWithExternalIdResult =
        immutableMyEntity.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableMyEntity, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableMyEntity#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.withExternalId(String)"})
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableMyEntity actualWithExternalIdResult =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
  }

  /**
   * Test {@link ImmutableMyEntity#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableMyEntity#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableMyEntity immutableMyEntity =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("42")
            .build();

    // Act
    ImmutableMyEntity actualWithNameResult = immutableMyEntity.withName("42");

    // Assert
    assertSame(immutableMyEntity, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableMyEntity#withName(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMyEntity#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMyEntity ImmutableMyEntity.withName(String)"})
  void testWithName_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableMyEntity actualWithNameResult =
        ImmutableMyEntity.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
  }
}
