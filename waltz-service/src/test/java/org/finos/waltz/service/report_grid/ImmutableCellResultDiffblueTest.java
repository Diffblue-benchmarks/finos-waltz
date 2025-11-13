package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.report_grid.ImmutableCellResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCellResultDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCellResult actualImmutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableCellResult.value());
    assertEquals("Option Code", actualImmutableCellResult.optionCode());
    assertEquals("Option Text", actualImmutableCellResult.optionText());
  }

  /**
   * Test Builder {@link Builder#from(CellResult)}.
   *
   * <p>Method under test: {@link Builder#from(CellResult)}
   */
  @Test
  @DisplayName("Test Builder from(CellResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCellResult.builder();
    ImmutableCellResult instance =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCellResult actualImmutableCellResult = builderResult.build();
    assertEquals(instance, actualImmutableCellResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#optionCode(String)}.
   *
   * <ul>
   *   <li>When {@code Option Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#optionCode(String)}
   */
  @Test
  @DisplayName("Test Builder optionCode(String); when 'Option Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.optionCode(String)"})
  void testBuilderOptionCode_whenOptionCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellResult.builder();

    // Act
    Builder actualOptionCodeResult = builderResult.optionCode("Option Code");

    // Assert
    assertSame(builderResult, actualOptionCodeResult);
  }

  /**
   * Test Builder {@link Builder#optionText(String)}.
   *
   * <ul>
   *   <li>When {@code Option Text}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#optionText(String)}
   */
  @Test
  @DisplayName("Test Builder optionText(String); when 'Option Text'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.optionText(String)"})
  void testBuilderOptionText_whenOptionText_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellResult.builder();

    // Act
    Builder actualOptionTextResult = builderResult.optionText("Option Text");

    // Assert
    assertSame(builderResult, actualOptionTextResult);
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
    Builder builderResult = ImmutableCellResult.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableCellResult#copyOf(CellResult)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#copyOf(CellResult)}
   */
  @Test
  @DisplayName("Test copyOf(CellResult); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellResult ImmutableCellResult.copyOf(CellResult)"})
  void testCopyOf_thenReturnValueIs42() {
    // Arrange
    ImmutableCellResult instance =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build();

    // Act
    ImmutableCellResult actualCopyOfResult = ImmutableCellResult.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Option Code", actualCopyOfResult.optionCode());
    assertEquals("Option Text", actualCopyOfResult.optionText());
  }

  /**
   * Test {@link ImmutableCellResult#equals(Object)}, and {@link ImmutableCellResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellResult#equals(Object)}
   *   <li>{@link ImmutableCellResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellResult.equals(Object)",
    "int ImmutableCellResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build();
    ImmutableCellResult immutableCellResult2 =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableCellResult, immutableCellResult2);
    assertEquals(immutableCellResult.hashCode(), immutableCellResult2.hashCode());
  }

  /**
   * Test {@link ImmutableCellResult#equals(Object)}, and {@link ImmutableCellResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellResult#equals(Object)}
   *   <li>{@link ImmutableCellResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellResult.equals(Object)",
    "int ImmutableCellResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableCellResult, immutableCellResult);
    int expectedHashCodeResult = immutableCellResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableCellResult.hashCode());
  }

  /**
   * Test {@link ImmutableCellResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellResult.equals(Object)",
    "int ImmutableCellResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("42")
            .optionText("Option Text")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCellResult,
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableCellResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellResult.equals(Object)",
    "int ImmutableCellResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("42")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCellResult,
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableCellResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellResult.equals(Object)",
    "int ImmutableCellResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("Option Code")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCellResult,
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableCellResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellResult.equals(Object)",
    "int ImmutableCellResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCellResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellResult.equals(Object)",
    "int ImmutableCellResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build(),
        "Different type to ImmutableCellResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellResult#toString()}
   *   <li>{@link ImmutableCellResult#optionCode()}
   *   <li>{@link ImmutableCellResult#optionText()}
   *   <li>{@link ImmutableCellResult#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCellResult.optionCode()",
    "String ImmutableCellResult.optionText()",
    "String ImmutableCellResult.toString()",
    "String ImmutableCellResult.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build();

    // Act
    String actualToStringResult = immutableCellResult.toString();
    String actualOptionCodeResult = immutableCellResult.optionCode();
    String actualOptionTextResult = immutableCellResult.optionText();

    // Assert
    assertEquals("42", immutableCellResult.value());
    assertEquals(
        "CellResult{value=42, optionCode=Option Code, optionText=Option Text}",
        actualToStringResult);
    assertEquals("Option Code", actualOptionCodeResult);
    assertEquals("Option Text", actualOptionTextResult);
  }

  /**
   * Test {@link ImmutableCellResult#withOptionCode(String)}.
   *
   * <ul>
   *   <li>Then return builder optionCode {@code 42} optionText {@code Option Text} value {@code 42}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#withOptionCode(String)}
   */
  @Test
  @DisplayName(
      "Test withOptionCode(String); then return builder optionCode '42' optionText 'Option Text' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellResult ImmutableCellResult.withOptionCode(String)"})
  void testWithOptionCode_thenReturnBuilderOptionCode42OptionTextOptionTextValue42Build() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("42")
            .optionText("Option Text")
            .value("42")
            .build();

    // Act
    ImmutableCellResult actualWithOptionCodeResult = immutableCellResult.withOptionCode("42");

    // Assert
    assertSame(immutableCellResult, actualWithOptionCodeResult);
  }

  /**
   * Test {@link ImmutableCellResult#withOptionCode(String)}.
   *
   * <ul>
   *   <li>Then return optionCode is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#withOptionCode(String)}
   */
  @Test
  @DisplayName("Test withOptionCode(String); then return optionCode is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellResult ImmutableCellResult.withOptionCode(String)"})
  void testWithOptionCode_thenReturnOptionCodeIs42() {
    // Arrange and Act
    ImmutableCellResult actualWithOptionCodeResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build()
            .withOptionCode("42");

    // Assert
    assertEquals("42", actualWithOptionCodeResult.optionCode());
    assertEquals("42", actualWithOptionCodeResult.value());
    assertEquals("Option Text", actualWithOptionCodeResult.optionText());
  }

  /**
   * Test {@link ImmutableCellResult#withOptionText(String)}.
   *
   * <ul>
   *   <li>Then return builder optionCode {@code Option Code} optionText {@code 42} value {@code 42}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#withOptionText(String)}
   */
  @Test
  @DisplayName(
      "Test withOptionText(String); then return builder optionCode 'Option Code' optionText '42' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellResult ImmutableCellResult.withOptionText(String)"})
  void testWithOptionText_thenReturnBuilderOptionCodeOptionCodeOptionText42Value42Build() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("42")
            .value("42")
            .build();

    // Act
    ImmutableCellResult actualWithOptionTextResult = immutableCellResult.withOptionText("42");

    // Assert
    assertSame(immutableCellResult, actualWithOptionTextResult);
  }

  /**
   * Test {@link ImmutableCellResult#withOptionText(String)}.
   *
   * <ul>
   *   <li>Then return optionText is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#withOptionText(String)}
   */
  @Test
  @DisplayName("Test withOptionText(String); then return optionText is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellResult ImmutableCellResult.withOptionText(String)"})
  void testWithOptionText_thenReturnOptionTextIs42() {
    // Arrange and Act
    ImmutableCellResult actualWithOptionTextResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build()
            .withOptionText("42");

    // Assert
    assertEquals("42", actualWithOptionTextResult.optionText());
    assertEquals("42", actualWithOptionTextResult.value());
    assertEquals("Option Code", actualWithOptionTextResult.optionCode());
  }

  /**
   * Test {@link ImmutableCellResult#withValue(String)}.
   *
   * <p>Method under test: {@link ImmutableCellResult#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellResult ImmutableCellResult.withValue(String)"})
  void testWithValue() {
    // Arrange
    ImmutableCellResult immutableCellResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("42")
            .build();

    // Act
    ImmutableCellResult actualWithValueResult = immutableCellResult.withValue("42");

    // Assert
    assertSame(immutableCellResult, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableCellResult#withValue(String)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellResult#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellResult ImmutableCellResult.withValue(String)"})
  void testWithValue_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableCellResult actualWithValueResult =
        ImmutableCellResult.builder()
            .optionCode("Option Code")
            .optionText("Option Text")
            .value("value")
            .build()
            .withValue("42");

    // Assert
    assertEquals("42", actualWithValueResult.value());
    assertEquals("Option Code", actualWithValueResult.optionCode());
    assertEquals("Option Text", actualWithValueResult.optionText());
  }
}
