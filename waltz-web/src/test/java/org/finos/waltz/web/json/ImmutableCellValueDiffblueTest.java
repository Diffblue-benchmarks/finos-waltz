package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.web.json.ImmutableCellValue.Builder;
import org.finos.waltz.web.json.ImmutableCellValue.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCellValueDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   *   <li>{@link Builder#type(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCellValue Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.type(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCommentResult = ImmutableCellValue.builder().comment("Comment");
    Optional<String> comment = Optional.of("42");
    ImmutableCellValue actualImmutableCellValue =
        actualCommentResult.comment(comment).name("Name").type("Type").value("42").build();

    // Assert
    assertEquals("42", actualImmutableCellValue.value());
    assertEquals("Name", actualImmutableCellValue.name());
    assertEquals("Type", actualImmutableCellValue.type());
  }

  /**
   * Test Builder {@link Builder#comment(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#comment(Optional)}
   */
  @Test
  @DisplayName("Test Builder comment(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comment(Optional)"})
  void testBuilderCommentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableCellValue.builder();
    Optional<String> comment = Optional.of("42");

    // Act
    Builder actualCommentResult = builderResult.comment(comment);

    // Assert
    assertSame(builderResult, actualCommentResult);
  }

  /**
   * Test Builder {@link Builder#from(CellValue)}.
   *
   * <p>Method under test: {@link Builder#from(CellValue)}
   */
  @Test
  @DisplayName("Test Builder from(CellValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellValue)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCellValue.builder();
    ImmutableCellValue instance =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCellValue actualImmutableCellValue = builderResult.build();
    assertEquals(instance, actualImmutableCellValue);
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
    Builder builderResult = ImmutableCellValue.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
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
    Builder builderResult = ImmutableCellValue.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableCellValue#comment()}.
   *
   * <p>Method under test: {@link ImmutableCellValue#comment()}
   */
  @Test
  @DisplayName("Test comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableCellValue.comment()"})
  void testComment() {
    // Arrange and Act
    Optional<String> actualCommentResult =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build()
            .comment();

    // Assert
    assertEquals("Comment", actualCommentResult.get());
    assertTrue(actualCommentResult.isPresent());
  }

  /**
   * Test {@link ImmutableCellValue#copyOf(CellValue)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#copyOf(CellValue)}
   */
  @Test
  @DisplayName("Test copyOf(CellValue); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.copyOf(CellValue)"})
  void testCopyOf_thenReturnValueIs42() {
    // Arrange
    ImmutableCellValue instance =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build();

    // Act
    ImmutableCellValue actualCopyOfResult = ImmutableCellValue.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Type", actualCopyOfResult.type());
  }

  /**
   * Test {@link ImmutableCellValue#equals(Object)}, and {@link ImmutableCellValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellValue#equals(Object)}
   *   <li>{@link ImmutableCellValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellValue.equals(Object)",
    "int ImmutableCellValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build();
    ImmutableCellValue immutableCellValue2 =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableCellValue, immutableCellValue2);
    assertEquals(immutableCellValue.hashCode(), immutableCellValue2.hashCode());
  }

  /**
   * Test {@link ImmutableCellValue#equals(Object)}, and {@link ImmutableCellValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellValue#equals(Object)}
   *   <li>{@link ImmutableCellValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellValue.equals(Object)",
    "int ImmutableCellValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableCellValue, immutableCellValue);
    int expectedHashCodeResult = immutableCellValue.hashCode();
    assertEquals(expectedHashCodeResult, immutableCellValue.hashCode());
  }

  /**
   * Test {@link ImmutableCellValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellValue.equals(Object)",
    "int ImmutableCellValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder().comment("Type").name("Name").type("Type").value("42").build();

    // Act and Assert
    assertNotEquals(
        immutableCellValue,
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableCellValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellValue.equals(Object)",
    "int ImmutableCellValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Type")
            .type("Type")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCellValue,
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableCellValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellValue.equals(Object)",
    "int ImmutableCellValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Name")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCellValue,
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableCellValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellValue.equals(Object)",
    "int ImmutableCellValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCellValue,
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableCellValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellValue.equals(Object)",
    "int ImmutableCellValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCellValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellValue.equals(Object)",
    "int ImmutableCellValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build(),
        "Different type to ImmutableCellValue");
  }

  /**
   * Test {@link ImmutableCellValue#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Comment is {@code null}.
   *   <li>Then return type is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Comment is 'null'; then return type is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonCommentIsNull_thenReturnTypeIsJson() {
    // Arrange
    Json json = new Json();
    json.setType("Json");
    json.setName("Json");
    json.setValue("Json");
    json.setComment(null);

    // Act
    ImmutableCellValue actualFromJsonResult = ImmutableCellValue.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.type());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Test {@link ImmutableCellValue#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Type is {@code null}.
   *   <li>Then return type is {@link ApiTypes#VALCELL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Type is 'null'; then return type is VALCELL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonTypeIsNull_thenReturnTypeIsValcell() {
    // Arrange
    Json json = new Json();
    json.setType(null);
    json.setName("Json");
    json.setValue("Json");
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);

    // Act
    ImmutableCellValue actualFromJsonResult = ImmutableCellValue.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.value());
    assertEquals(ApiTypes.VALCELL, actualFromJsonResult.type());
  }

  /**
   * Test {@link ImmutableCellValue#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) Type is {@code Json}.
   *   <li>Then return type is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) Type is 'Json'; then return type is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.fromJson(Json)"})
  void testFromJson_givenOf42_whenJsonTypeIsJson_thenReturnTypeIsJson() {
    // Arrange
    Json json = new Json();
    json.setType("Json");
    json.setName("Json");
    json.setValue("Json");
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);

    // Act
    ImmutableCellValue actualFromJsonResult = ImmutableCellValue.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.type());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellValue#name()}
   *   <li>{@link ImmutableCellValue#type()}
   *   <li>{@link ImmutableCellValue#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCellValue.name()",
    "String ImmutableCellValue.type()",
    "String ImmutableCellValue.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build();

    // Act
    String actualNameResult = immutableCellValue.name();
    String actualTypeResult = immutableCellValue.type();

    // Assert
    assertEquals("42", immutableCellValue.value());
    assertEquals("Name", actualNameResult);
    assertEquals("Type", actualTypeResult);
  }

  /**
   * Test Json {@link Json#comment()}.
   *
   * <p>Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().comment());
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
    assertNull(actualJson.name);
    assertNull(actualJson.type);
    assertNull(actualJson.value);
    assertFalse(actualJson.comment.isPresent());
  }

  /**
   * Test Json {@link Json#type()}.
   *
   * <p>Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
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
   * Test {@link ImmutableCellValue#toString()}.
   *
   * <p>Method under test: {@link ImmutableCellValue#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableCellValue.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "CellValue{type=Type, name=Name, value=42, comment=Comment}",
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableCellValue#withComment(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableCellValue#withComment(Optional)}
   */
  @Test
  @DisplayName("Test withComment(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withComment(Optional)"})
  void testWithCommentWithOptional() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder().comment("42").name("Name").type("Type").value("42").build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableCellValue actualWithCommentResult = immutableCellValue.withComment(optional);

    // Assert
    assertSame(immutableCellValue, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableCellValue#withComment(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withComment(Optional)}
   */
  @Test
  @DisplayName("Test withComment(Optional) with 'optional'; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withComment(Optional)"})
  void testWithCommentWithOptional_thenReturnValueIs42() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableCellValue actualWithCommentResult = immutableCellValue.withComment(optional);

    // Assert
    assertEquals("42", actualWithCommentResult.value());
    assertEquals("Name", actualWithCommentResult.name());
    assertEquals("Type", actualWithCommentResult.type());
  }

  /**
   * Test {@link ImmutableCellValue#withComment(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return builder comment {@code 42} name {@code Name} type {@code Type} value {@code
   *       42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withComment(String)}
   */
  @Test
  @DisplayName(
      "Test withComment(String) with 'value'; then return builder comment '42' name 'Name' type 'Type' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withComment(String)"})
  void testWithCommentWithValue_thenReturnBuilderComment42NameNameTypeTypeValue42Build() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder().comment("42").name("Name").type("Type").value("42").build();

    // Act
    ImmutableCellValue actualWithCommentResult = immutableCellValue.withComment("42");

    // Assert
    assertSame(immutableCellValue, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableCellValue#withComment(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String) with 'value'; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withComment(String)"})
  void testWithCommentWithValue_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableCellValue actualWithCommentResult =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build()
            .withComment("42");

    // Assert
    assertEquals("42", actualWithCommentResult.value());
    assertEquals("Name", actualWithCommentResult.name());
    assertEquals("Type", actualWithCommentResult.type());
  }

  /**
   * Test {@link ImmutableCellValue#withName(String)}.
   *
   * <ul>
   *   <li>Then return builder comment {@code Comment} name {@code 42} type {@code Type} value
   *       {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); then return builder comment 'Comment' name '42' type 'Type' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withName(String)"})
  void testWithName_thenReturnBuilderCommentCommentName42TypeTypeValue42Build() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder().comment("Comment").name("42").type("Type").value("42").build();

    // Act
    ImmutableCellValue actualWithNameResult = immutableCellValue.withName("42");

    // Assert
    assertSame(immutableCellValue, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableCellValue#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableCellValue actualWithNameResult =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.value());
    assertEquals("Type", actualWithNameResult.type());
  }

  /**
   * Test {@link ImmutableCellValue#withType(String)}.
   *
   * <ul>
   *   <li>Then return builder comment {@code Comment} name {@code Name} type {@code 42} value
   *       {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withType(String)}
   */
  @Test
  @DisplayName(
      "Test withType(String); then return builder comment 'Comment' name 'Name' type '42' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withType(String)"})
  void testWithType_thenReturnBuilderCommentCommentNameNameType42Value42Build() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder().comment("Comment").name("Name").type("42").value("42").build();

    // Act
    ImmutableCellValue actualWithTypeResult = immutableCellValue.withType("42");

    // Assert
    assertSame(immutableCellValue, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutableCellValue#withType(String)}.
   *
   * <ul>
   *   <li>Then return type is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String); then return type is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withType(String)"})
  void testWithType_thenReturnTypeIs42() {
    // Arrange and Act
    ImmutableCellValue actualWithTypeResult =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build()
            .withType("42");

    // Assert
    assertEquals("42", actualWithTypeResult.type());
    assertEquals("42", actualWithTypeResult.value());
    assertEquals("Name", actualWithTypeResult.name());
  }

  /**
   * Test {@link ImmutableCellValue#withValue(String)}.
   *
   * <ul>
   *   <li>Then return builder comment {@code Comment} name {@code Name} type {@code Type} value
   *       {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withValue(String)}
   */
  @Test
  @DisplayName(
      "Test withValue(String); then return builder comment 'Comment' name 'Name' type 'Type' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withValue(String)"})
  void testWithValue_thenReturnBuilderCommentCommentNameNameTypeTypeValue42Build() {
    // Arrange
    ImmutableCellValue immutableCellValue =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build();

    // Act
    ImmutableCellValue actualWithValueResult = immutableCellValue.withValue("42");

    // Assert
    assertSame(immutableCellValue, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableCellValue#withValue(String)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellValue#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellValue ImmutableCellValue.withValue(String)"})
  void testWithValue_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableCellValue actualWithValueResult =
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("value")
            .build()
            .withValue("42");

    // Assert
    assertEquals("42", actualWithValueResult.value());
    assertEquals("Name", actualWithValueResult.name());
    assertEquals("Type", actualWithValueResult.type());
  }
}
