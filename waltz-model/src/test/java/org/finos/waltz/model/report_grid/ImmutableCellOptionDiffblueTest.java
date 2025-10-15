package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableCellOption.Builder;
import org.finos.waltz.model.report_grid.ImmutableCellOption.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCellOptionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellOption Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCellOption actualImmutableCellOption =
        ImmutableCellOption.builder().code("Code").text("Text").build();

    // Assert
    assertEquals("Code", actualImmutableCellOption.code());
    assertEquals("Text", actualImmutableCellOption.text());
  }

  /**
   * Test Builder {@link Builder#code(String)}.
   *
   * <ul>
   *   <li>When {@code Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String); when 'Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode_whenCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellOption.builder();

    // Act
    Builder actualCodeResult = builderResult.code("Code");

    // Assert
    assertSame(builderResult, actualCodeResult);
  }

  /**
   * Test Builder {@link Builder#from(CellOption)}.
   *
   * <ul>
   *   <li>Then builder build is builder code {@code Code} text {@code Text} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellOption)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellOption); then builder build is builder code 'Code' text 'Text' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellOption)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCodeCodeTextTextBuild() {
    // Arrange
    Builder builderResult = ImmutableCellOption.builder();
    ImmutableCellOption instance = ImmutableCellOption.builder().code("Code").text("Text").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCellOption actualImmutableCellOption = builderResult.build();
    assertEquals(instance, actualImmutableCellOption);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#text(String)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#text(String)}
   */
  @Test
  @DisplayName("Test Builder text(String); when 'Text'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.text(String)"})
  void testBuilderText_whenText_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellOption.builder();

    // Act
    Builder actualTextResult = builderResult.text("Text");

    // Assert
    assertSame(builderResult, actualTextResult);
  }

  /**
   * Test {@link ImmutableCellOption#copyOf(CellOption)}.
   *
   * <ul>
   *   <li>When builder code {@code Code} text {@code Text} build.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#copyOf(CellOption)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CellOption); when builder code 'Code' text 'Text' build; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellOption ImmutableCellOption.copyOf(CellOption)"})
  void testCopyOf_whenBuilderCodeCodeTextTextBuild_thenReturnCode() {
    // Arrange
    ImmutableCellOption instance = ImmutableCellOption.builder().code("Code").text("Text").build();

    // Act
    ImmutableCellOption actualCopyOfResult = ImmutableCellOption.copyOf(instance);

    // Assert
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Text", actualCopyOfResult.text());
  }

  /**
   * Test {@link ImmutableCellOption#equals(Object)}, and {@link ImmutableCellOption#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellOption#equals(Object)}
   *   <li>{@link ImmutableCellOption#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellOption.equals(Object)",
    "int ImmutableCellOption.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCellOption immutableCellOption =
        ImmutableCellOption.builder().code("Code").text("Text").build();
    ImmutableCellOption immutableCellOption2 =
        ImmutableCellOption.builder().code("Code").text("Text").build();

    // Act and Assert
    assertEquals(immutableCellOption, immutableCellOption2);
    assertEquals(immutableCellOption.hashCode(), immutableCellOption2.hashCode());
  }

  /**
   * Test {@link ImmutableCellOption#equals(Object)}, and {@link ImmutableCellOption#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellOption#equals(Object)}
   *   <li>{@link ImmutableCellOption#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellOption.equals(Object)",
    "int ImmutableCellOption.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCellOption immutableCellOption =
        ImmutableCellOption.builder().code("Code").text("Text").build();

    // Act and Assert
    assertEquals(immutableCellOption, immutableCellOption);
    int expectedHashCodeResult = immutableCellOption.hashCode();
    assertEquals(expectedHashCodeResult, immutableCellOption.hashCode());
  }

  /**
   * Test {@link ImmutableCellOption#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellOption.equals(Object)",
    "int ImmutableCellOption.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCellOption immutableCellOption =
        ImmutableCellOption.builder().code("Text").text("Text").build();

    // Act and Assert
    assertNotEquals(
        immutableCellOption, ImmutableCellOption.builder().code("Code").text("Text").build());
  }

  /**
   * Test {@link ImmutableCellOption#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellOption.equals(Object)",
    "int ImmutableCellOption.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCellOption immutableCellOption =
        ImmutableCellOption.builder().code("Code").text("Code").build();

    // Act and Assert
    assertNotEquals(
        immutableCellOption, ImmutableCellOption.builder().code("Code").text("Text").build());
  }

  /**
   * Test {@link ImmutableCellOption#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellOption.equals(Object)",
    "int ImmutableCellOption.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableCellOption.builder().code("Code").text("Text").build(), null);
  }

  /**
   * Test {@link ImmutableCellOption#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellOption.equals(Object)",
    "int ImmutableCellOption.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCellOption.builder().code("Code").text("Text").build(),
        "Different type to ImmutableCellOption");
  }

  /**
   * Test {@link ImmutableCellOption#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Text is {@code Json}.
   *   <li>Then return code is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Text is 'Json'; then return code is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellOption ImmutableCellOption.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonTextIsJson_thenReturnCodeIsJson() {
    // Arrange
    Json json = new Json();
    json.setText("Json");
    json.setCode("Json");

    // Act
    ImmutableCellOption actualFromJsonResult = ImmutableCellOption.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.code());
    assertEquals("Json", actualFromJsonResult.text());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellOption#toString()}
   *   <li>{@link ImmutableCellOption#code()}
   *   <li>{@link ImmutableCellOption#text()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCellOption.code()",
    "String ImmutableCellOption.text()",
    "String ImmutableCellOption.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCellOption immutableCellOption =
        ImmutableCellOption.builder().code("Code").text("Text").build();

    // Act
    String actualToStringResult = immutableCellOption.toString();
    String actualCodeResult = immutableCellOption.code();

    // Assert
    assertEquals("CellOption{text=Text, code=Code}", actualToStringResult);
    assertEquals("Code", actualCodeResult);
    assertEquals("Text", immutableCellOption.text());
  }

  /**
   * Test Json {@link Json#code()}.
   *
   * <p>Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().code());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCode(String)}
   *   <li>{@link Json#setText(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCode(String)",
    "void Json.setText(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCode("Code");
    actualJson.setText("Text");

    // Assert
    assertEquals("Code", actualJson.code);
    assertEquals("Text", actualJson.text);
  }

  /**
   * Test Json {@link Json#text()}.
   *
   * <p>Method under test: {@link Json#text()}
   */
  @Test
  @DisplayName("Test Json text()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.text()"})
  void testJsonText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().text());
  }

  /**
   * Test {@link ImmutableCellOption#withCode(String)}.
   *
   * <ul>
   *   <li>Given builder code {@code Code} text {@code Text} build.
   *   <li>Then return code is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#withCode(String)}
   */
  @Test
  @DisplayName(
      "Test withCode(String); given builder code 'Code' text 'Text' build; then return code is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellOption ImmutableCellOption.withCode(String)"})
  void testWithCode_givenBuilderCodeCodeTextTextBuild_thenReturnCodeIs42() {
    // Arrange and Act
    ImmutableCellOption actualWithCodeResult =
        ImmutableCellOption.builder().code("Code").text("Text").build().withCode("42");

    // Assert
    assertEquals("42", actualWithCodeResult.code());
    assertEquals("Text", actualWithCodeResult.text());
  }

  /**
   * Test {@link ImmutableCellOption#withCode(String)}.
   *
   * <ul>
   *   <li>Then return builder code {@code 42} text {@code Text} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String); then return builder code '42' text 'Text' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellOption ImmutableCellOption.withCode(String)"})
  void testWithCode_thenReturnBuilderCode42TextTextBuild() {
    // Arrange
    ImmutableCellOption immutableCellOption =
        ImmutableCellOption.builder().code("42").text("Text").build();

    // Act
    ImmutableCellOption actualWithCodeResult = immutableCellOption.withCode("42");

    // Assert
    assertSame(immutableCellOption, actualWithCodeResult);
  }

  /**
   * Test {@link ImmutableCellOption#withText(String)}.
   *
   * <ul>
   *   <li>Given builder code {@code Code} text {@code Text} build.
   *   <li>Then return text is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#withText(String)}
   */
  @Test
  @DisplayName(
      "Test withText(String); given builder code 'Code' text 'Text' build; then return text is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellOption ImmutableCellOption.withText(String)"})
  void testWithText_givenBuilderCodeCodeTextTextBuild_thenReturnTextIs42() {
    // Arrange and Act
    ImmutableCellOption actualWithTextResult =
        ImmutableCellOption.builder().code("Code").text("Text").build().withText("42");

    // Assert
    assertEquals("42", actualWithTextResult.text());
    assertEquals("Code", actualWithTextResult.code());
  }

  /**
   * Test {@link ImmutableCellOption#withText(String)}.
   *
   * <ul>
   *   <li>Then return builder code {@code Code} text {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellOption#withText(String)}
   */
  @Test
  @DisplayName("Test withText(String); then return builder code 'Code' text '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellOption ImmutableCellOption.withText(String)"})
  void testWithText_thenReturnBuilderCodeCodeText42Build() {
    // Arrange
    ImmutableCellOption immutableCellOption =
        ImmutableCellOption.builder().code("Code").text("42").build();

    // Act
    ImmutableCellOption actualWithTextResult = immutableCellOption.withText("42");

    // Assert
    assertSame(immutableCellOption, actualWithTextResult);
  }
}
