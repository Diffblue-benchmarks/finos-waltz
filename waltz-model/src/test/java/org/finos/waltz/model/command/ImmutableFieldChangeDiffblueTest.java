package org.finos.waltz.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.command.ImmutableFieldChange.Builder;
import org.finos.waltz.model.command.ImmutableFieldChange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFieldChangeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#newVal(Object)}
   *   <li>{@link Builder#oldVal(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFieldChange Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.newVal(Object)",
    "Builder Builder.oldVal(Object)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> actualImmutableFieldChange =
        actualBuilderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();

    // Assert
    assertEquals("New Val", actualImmutableFieldChange.newVal());
    assertEquals("Old Val", actualImmutableFieldChange.oldVal());
    assertEquals(
        "The characteristics of someone or something", actualImmutableFieldChange.description());
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFieldChange<Object> actualImmutableFieldChange = builderResult.build();
    assertEquals(instance, actualImmutableFieldChange);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom2() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance =
        builderResult2.description(null).newVal("New Val").oldVal("Old Val").build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFieldChange<Object> actualImmutableFieldChange = builderResult.build();
    assertEquals(instance, actualImmutableFieldChange);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom3() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal(null)
            .oldVal("Old Val")
            .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFieldChange<Object> actualImmutableFieldChange = builderResult.build();
    assertEquals(instance, actualImmutableFieldChange);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom4() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal(null)
            .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFieldChange<Object> actualImmutableFieldChange = builderResult.build();
    assertEquals(instance, actualImmutableFieldChange);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableFieldChange#copyOf(FieldChange)}.
   *
   * <ul>
   *   <li>Then return {@code New Val}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  @DisplayName("Test copyOf(FieldChange); then return 'New Val'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.copyOf(FieldChange)"})
  void testCopyOf_thenReturnNewVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();

    // Act
    ImmutableFieldChange<Object> actualCopyOfResult = ImmutableFieldChange.copyOf(instance);

    // Assert
    assertEquals("New Val", actualCopyOfResult.newVal());
    assertEquals("Old Val", actualCopyOfResult.oldVal());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}, and {@link ImmutableFieldChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFieldChange#equals(Object)}
   *   <li>{@link ImmutableFieldChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange2 =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();

    // Act and Assert
    assertEquals(immutableFieldChange, immutableFieldChange2);
    assertEquals(immutableFieldChange.hashCode(), immutableFieldChange2.hashCode());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}, and {@link ImmutableFieldChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFieldChange#equals(Object)}
   *   <li>{@link ImmutableFieldChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();

    // Act and Assert
    assertEquals(immutableFieldChange, immutableFieldChange);
    int expectedHashCodeResult = immutableFieldChange.hashCode();
    assertEquals(expectedHashCodeResult, immutableFieldChange.hashCode());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult.description("Description").newVal("New Val").oldVal("Old Val").build();

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult
            .description("The characteristics of someone or something")
            .newVal(42)
            .oldVal("Old Val")
            .build();

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    Builder<Object> descriptionResult =
        builderResult.description("The characteristics of someone or something");

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        descriptionResult
            .newVal(
                builderResult2
                    .description("The characteristics of someone or something")
                    .newVal("New Val")
                    .oldVal("Old Val")
                    .build())
            .oldVal("Old Val")
            .build();

    Builder<Object> builderResult3 = ImmutableFieldChange.builder();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        builderResult3
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal(42)
            .build();

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    Builder<Object> newValResult =
        builderResult.description("The characteristics of someone or something").newVal("New Val");

    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        newValResult
            .oldVal(
                builderResult2
                    .description("The characteristics of someone or something")
                    .newVal("New Val")
                    .oldVal("Old Val")
                    .build())
            .build();

    Builder<Object> builderResult3 = ImmutableFieldChange.builder();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        builderResult3
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build(),
        "Different type to ImmutableFieldChange");
  }

  /**
   * Test {@link ImmutableFieldChange#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) NewVal is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) NewVal is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonNewValIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setNewVal("Json");
    json.setOldVal("Json");
    json.setDescription("Json");

    // Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    Object object = json.oldVal;
    assertSame(object, actualFromJsonResult.newVal());
    assertSame(object, actualFromJsonResult.oldVal());
  }

  /**
   * Test {@link ImmutableFieldChange#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return newVal is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return newVal is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNewValIsNull() {
    // Arrange and Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange.fromJson(new Json<>());

    // Assert
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.oldVal());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFieldChange#toString()}
   *   <li>{@link ImmutableFieldChange#description()}
   *   <li>{@link ImmutableFieldChange#newVal()}
   *   <li>{@link ImmutableFieldChange#oldVal()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableFieldChange.description()",
    "Object ImmutableFieldChange.newVal()",
    "Object ImmutableFieldChange.oldVal()",
    "String ImmutableFieldChange.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();

    // Act
    String actualToStringResult = immutableFieldChange.toString();
    String actualDescriptionResult = immutableFieldChange.description();
    Object actualNewValResult = immutableFieldChange.newVal();

    // Assert
    assertEquals(
        "FieldChange{newVal=New Val, oldVal=Old Val, description=The characteristics of someone or something}",
        actualToStringResult);
    assertEquals("New Val", actualNewValResult);
    assertEquals("Old Val", immutableFieldChange.oldVal());
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
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setNewVal(Object)}
   *   <li>{@link Json#setOldVal(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setNewVal(Object)",
    "void Json.setOldVal(Object)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json<Object> actualJson = new Json<>();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setNewVal("New Val");
    actualJson.setOldVal("Old Val");

    // Assert
    assertEquals("New Val", actualJson.newVal);
    assertEquals("Old Val", actualJson.oldVal);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Test Json {@link Json#newVal()}.
   *
   * <p>Method under test: {@link Json#newVal()}
   */
  @Test
  @DisplayName("Test Json newVal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Json.newVal()"})
  void testJsonNewVal() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.newVal());
  }

  /**
   * Test Json {@link Json#oldVal()}.
   *
   * <p>Method under test: {@link Json#oldVal()}
   */
  @Test
  @DisplayName("Test Json oldVal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Json.oldVal()"})
  void testJsonOldVal() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.oldVal());
  }

  /**
   * Test {@link ImmutableFieldChange#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} newVal {@code New Val} oldVal {@code Old Val}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' newVal 'New Val' oldVal 'Old Val' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withDescription(String)"})
  void testWithDescription_thenReturnBuilderDescription42NewValNewValOldValOldValBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult.description("42").newVal("New Val").oldVal("Old Val").build();

    // Act
    ImmutableFieldChange<Object> actualWithDescriptionResult =
        immutableFieldChange.withDescription("42");

    // Assert
    assertSame(immutableFieldChange, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withDescription(String)"})
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    // Act
    ImmutableFieldChange<Object> actualWithDescriptionResult =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("New Val", actualWithDescriptionResult.newVal());
    assertEquals("Old Val", actualWithDescriptionResult.oldVal());
  }

  /**
   * Test {@link ImmutableFieldChange#withNewVal(Object)}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withNewVal(Object)}
   */
  @Test
  @DisplayName("Test withNewVal(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withNewVal(Object)"})
  void testWithNewVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult
            .description("The characteristics of someone or something")
            .newVal(42)
            .oldVal("Old Val")
            .build();

    // Act
    ImmutableFieldChange<Object> actualWithNewValResult = immutableFieldChange.withNewVal(42);

    // Assert
    assertSame(immutableFieldChange, actualWithNewValResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withNewVal(Object)}.
   *
   * <ul>
   *   <li>Then return {@code Old Val}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withNewVal(Object)}
   */
  @Test
  @DisplayName("Test withNewVal(Object); then return 'Old Val'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withNewVal(Object)"})
  void testWithNewVal_thenReturnOldVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    // Act
    ImmutableFieldChange<Object> actualWithNewValResult =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build()
            .withNewVal("Value");

    // Assert
    assertEquals("Old Val", actualWithNewValResult.oldVal());
    assertEquals(
        "The characteristics of someone or something", actualWithNewValResult.description());
    assertEquals("Value", actualWithNewValResult.newVal());
  }

  /**
   * Test {@link ImmutableFieldChange#withOldVal(Object)}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withOldVal(Object)}
   */
  @Test
  @DisplayName("Test withOldVal(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withOldVal(Object)"})
  void testWithOldVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> immutableFieldChange =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal(42)
            .build();

    // Act
    ImmutableFieldChange<Object> actualWithOldValResult = immutableFieldChange.withOldVal(42);

    // Assert
    assertSame(immutableFieldChange, actualWithOldValResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withOldVal(Object)}.
   *
   * <ul>
   *   <li>Then return {@code New Val}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withOldVal(Object)}
   */
  @Test
  @DisplayName("Test withOldVal(Object); then return 'New Val'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withOldVal(Object)"})
  void testWithOldVal_thenReturnNewVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    // Act
    ImmutableFieldChange<Object> actualWithOldValResult =
        builderResult
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build()
            .withOldVal("Value");

    // Assert
    assertEquals("New Val", actualWithOldValResult.newVal());
    assertEquals(
        "The characteristics of someone or something", actualWithOldValResult.description());
    assertEquals("Value", actualWithOldValResult.oldVal());
  }
}
