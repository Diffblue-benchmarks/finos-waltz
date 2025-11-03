package org.finos.waltz.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.command.ImmutableFieldChange.Builder;
import org.finos.waltz.model.command.ImmutableFieldChange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFieldChangeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#newVal(Object)}
   *   <li>{@link Builder#oldVal(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.newVal(Object)", "Builder Builder.oldVal(Object)"})
  void testBuilderBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();

    // Act
    ImmutableFieldChange<Object> actualBuildResult = builderResult
        .description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Assert
    assertEquals("New Val", actualBuildResult.newVal());
    assertEquals("Old Val", actualBuildResult.oldVal());
    assertEquals("The characteristics of someone or something", actualBuildResult.description());
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   * <p>
   * Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance = builderResult2.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   * <p>
   * Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom2() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance = builderResult2.description(null)
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   * <p>
   * Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom3() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance = builderResult2.description("The characteristics of someone or something")
        .newVal(null)
        .oldVal("Old Val")
        .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   * <p>
   * Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom4() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance = builderResult2.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal(null)
        .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableFieldChange#copyOf(FieldChange)}.
   * <ul>
   *   <li>Then return {@code New Val}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  @DisplayName("Test copyOf(FieldChange); then return 'New Val'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.copyOf(FieldChange)"})
  void testCopyOf_thenReturnNewVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> instance = builderResult.description("The characteristics of someone or something")
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFieldChange#equals(Object)}
   *   <li>{@link ImmutableFieldChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult2 = builderResult2
        .description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}, and {@link ImmutableFieldChange#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFieldChange#equals(Object)}
   *   <li>{@link ImmutableFieldChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("Description")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult2 = builderResult2
        .description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal(42)
        .oldVal("Old Val")
        .build();
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult2 = builderResult2
        .description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    Builder<Object> descriptionResult = builderResult.description("The characteristics of someone or something");
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult2.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();
    ImmutableFieldChange<Object> buildResult2 = descriptionResult.newVal(buildResult).oldVal("Old Val").build();
    Builder<Object> builderResult3 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult3 = builderResult3
        .description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal(42)
        .build();
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult2 = builderResult2
        .description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    Builder<Object> newValResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val");
    Builder<Object> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult2.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();
    ImmutableFieldChange<Object> buildResult2 = newValResult.oldVal(buildResult).build();
    Builder<Object> builderResult3 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult3 = builderResult3
        .description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFieldChange.equals(Object)", "int ImmutableFieldChange.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableFieldChange");
  }

  /**
   * Test {@link ImmutableFieldChange#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code Json}.</li>
   *   <li>When {@link Json} (default constructor) NewVal is {@code Json}.</li>
   *   <li>Then return newVal is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; when Json (default constructor) NewVal is 'Json'; then return newVal is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonNewValIsJson_thenReturnNewValIsJson() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setNewVal("Json");
    json.setOldVal(null);
    json.setDescription(null);

    // Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange.fromJson(json);

    // Assert
    Object newValResult = actualFromJsonResult.newVal();
    assertEquals("Json", newValResult);
    assertNull(actualFromJsonResult.oldVal());
    assertNull(actualFromJsonResult.description());
    assertSame(json.newVal, newValResult);
  }

  /**
   * Test {@link ImmutableFieldChange#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.</li>
   *   <li>Then return description is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setNewVal(null);
    json.setOldVal(null);
    json.setDescription("Json");

    // Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.oldVal());
  }

  /**
   * Test {@link ImmutableFieldChange#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) OldVal is {@code Json}.</li>
   *   <li>Then return oldVal is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) OldVal is 'Json'; then return oldVal is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonOldValIsJson_thenReturnOldValIsJson() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setNewVal(null);
    json.setOldVal("Json");
    json.setDescription(null);

    // Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange.fromJson(json);

    // Assert
    Object oldValResult = actualFromJsonResult.oldVal();
    assertEquals("Json", oldValResult);
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.description());
    assertSame(json.oldVal, oldValResult);
  }

  /**
   * Test {@link ImmutableFieldChange#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return newVal is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return newVal is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFieldChange#toString()}
   *   <li>{@link ImmutableFieldChange#description()}
   *   <li>{@link ImmutableFieldChange#newVal()}
   *   <li>{@link ImmutableFieldChange#oldVal()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableFieldChange.description()", "Object ImmutableFieldChange.newVal()",
      "Object ImmutableFieldChange.oldVal()", "String ImmutableFieldChange.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    String actualDescriptionResult = buildResult.description();
    Object actualNewValResult = buildResult.newVal();

    // Assert
    assertEquals("FieldChange{newVal=New Val, oldVal=Old Val, description=The characteristics of someone or something}",
        actualToStringResult);
    assertEquals("New Val", actualNewValResult);
    assertEquals("Old Val", buildResult.oldVal());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.description());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setNewVal(Object)}
   *   <li>{@link Json#setOldVal(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setNewVal(Object)",
      "void Json.setOldVal(Object)"})
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
   * <p>
   * Method under test: {@link Json#newVal()}
   */
  @Test
  @DisplayName("Test Json newVal()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Json.newVal()"})
  void testJsonNewVal() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.newVal());
  }

  /**
   * Test Json {@link Json#oldVal()}.
   * <p>
   * Method under test: {@link Json#oldVal()}
   */
  @Test
  @DisplayName("Test Json oldVal()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Json.oldVal()"})
  void testJsonOldVal() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.oldVal());
  }

  /**
   * Test {@link ImmutableFieldChange#withDescription(String)}.
   * <ul>
   *   <li>Then return builder description {@code 42} newVal {@code New Val} oldVal {@code Old Val} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return builder description '42' newVal 'New Val' oldVal 'Old Val' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withDescription(String)"})
  void testWithDescription_thenReturnBuilderDescription42NewValNewValOldValOldValBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("42")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withDescription("42"));
  }

  /**
   * Test {@link ImmutableFieldChange#withDescription(String)}.
   * <ul>
   *   <li>Then return description is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withDescription(String)"})
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act
    ImmutableFieldChange<Object> actualWithDescriptionResult = buildResult.withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("New Val", actualWithDescriptionResult.newVal());
    assertEquals("Old Val", actualWithDescriptionResult.oldVal());
  }

  /**
   * Test {@link ImmutableFieldChange#withNewVal(Object)}.
   * <p>
   * Method under test: {@link ImmutableFieldChange#withNewVal(Object)}
   */
  @Test
  @DisplayName("Test withNewVal(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withNewVal(Object)"})
  void testWithNewVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal(42)
        .oldVal("Old Val")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withNewVal(42));
  }

  /**
   * Test {@link ImmutableFieldChange#withNewVal(Object)}.
   * <ul>
   *   <li>Then return {@code Old Val}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#withNewVal(Object)}
   */
  @Test
  @DisplayName("Test withNewVal(Object); then return 'Old Val'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withNewVal(Object)"})
  void testWithNewVal_thenReturnOldVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act
    ImmutableFieldChange<Object> actualWithNewValResult = buildResult.withNewVal("Value");

    // Assert
    assertEquals("Old Val", actualWithNewValResult.oldVal());
    assertEquals("The characteristics of someone or something", actualWithNewValResult.description());
    assertEquals("Value", actualWithNewValResult.newVal());
  }

  /**
   * Test {@link ImmutableFieldChange#withOldVal(Object)}.
   * <p>
   * Method under test: {@link ImmutableFieldChange#withOldVal(Object)}
   */
  @Test
  @DisplayName("Test withOldVal(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withOldVal(Object)"})
  void testWithOldVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal(42)
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withOldVal(42));
  }

  /**
   * Test {@link ImmutableFieldChange#withOldVal(Object)}.
   * <ul>
   *   <li>Then return {@code New Val}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFieldChange#withOldVal(Object)}
   */
  @Test
  @DisplayName("Test withOldVal(Object); then return 'New Val'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withOldVal(Object)"})
  void testWithOldVal_thenReturnNewVal() {
    // Arrange
    Builder<Object> builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange<Object> buildResult = builderResult.description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Act
    ImmutableFieldChange<Object> actualWithOldValResult = buildResult.withOldVal("Value");

    // Assert
    assertEquals("New Val", actualWithOldValResult.newVal());
    assertEquals("The characteristics of someone or something", actualWithOldValResult.description());
    assertEquals("Value", actualWithOldValResult.oldVal());
  }
}
