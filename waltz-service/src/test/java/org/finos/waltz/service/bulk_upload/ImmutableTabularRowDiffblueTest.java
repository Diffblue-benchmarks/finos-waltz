package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.bulk_upload.ImmutableTabularRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTabularRowDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTabularRow Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(10, ImmutableTabularRow.builder().rowNumber(10).values("42").build().rowNumber());
  }

  /**
   * Test Builder {@link Builder#from(TabularRow)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build is builder rowNumber ten values {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(TabularRow)}
   */
  @Test
  @DisplayName(
      "Test Builder from(TabularRow); when '42'; then builder build is builder rowNumber ten values '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TabularRow)"})
  void testBuilderFrom_when42_thenBuilderBuildIsBuilderRowNumberTenValues42Build() {
    // Arrange
    Builder builderResult = ImmutableTabularRow.builder();
    ImmutableTabularRow instance = ImmutableTabularRow.builder().rowNumber(10).values("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTabularRow actualImmutableTabularRow = builderResult.build();
    assertEquals(instance, actualImmutableTabularRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rowNumber(int)}.
   *
   * <p>Method under test: {@link Builder#rowNumber(int)}
   */
  @Test
  @DisplayName("Test Builder rowNumber(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rowNumber(int)"})
  void testBuilderRowNumber() {
    // Arrange
    Builder builderResult = ImmutableTabularRow.builder();

    // Act
    Builder actualRowNumberResult = builderResult.rowNumber(10);

    // Assert
    assertSame(builderResult, actualRowNumberResult);
  }

  /**
   * Test Builder {@link Builder#values(String[])}.
   *
   * <p>Method under test: {@link Builder#values(String[])}
   */
  @Test
  @DisplayName("Test Builder values(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.values(String[])"})
  void testBuilderValues() {
    // Arrange
    Builder builderResult = ImmutableTabularRow.builder();

    // Act
    Builder actualValuesResult = builderResult.values("42");

    // Assert
    assertSame(builderResult, actualValuesResult);
  }

  /**
   * Test {@link ImmutableTabularRow#copyOf(TabularRow)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return rowNumber is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTabularRow#copyOf(TabularRow)}
   */
  @Test
  @DisplayName("Test copyOf(TabularRow); when '42'; then return rowNumber is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTabularRow ImmutableTabularRow.copyOf(TabularRow)"})
  void testCopyOf_when42_thenReturnRowNumberIsTen() {
    // Arrange
    ImmutableTabularRow instance = ImmutableTabularRow.builder().rowNumber(10).values("42").build();

    // Act and Assert
    assertEquals(10, ImmutableTabularRow.copyOf(instance).rowNumber());
  }

  /**
   * Test {@link ImmutableTabularRow#equals(Object)}, and {@link ImmutableTabularRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTabularRow#equals(Object)}
   *   <li>{@link ImmutableTabularRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTabularRow.equals(Object)",
    "int ImmutableTabularRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableTabularRow immutableTabularRow =
        ImmutableTabularRow.builder().rowNumber(10).values("42").build();
    ImmutableTabularRow immutableTabularRow2 =
        ImmutableTabularRow.builder().rowNumber(10).values("42").build();

    // Act and Assert
    assertEquals(immutableTabularRow, immutableTabularRow2);
    assertEquals(immutableTabularRow.hashCode(), immutableTabularRow2.hashCode());
  }

  /**
   * Test {@link ImmutableTabularRow#equals(Object)}, and {@link ImmutableTabularRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTabularRow#equals(Object)}
   *   <li>{@link ImmutableTabularRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTabularRow.equals(Object)",
    "int ImmutableTabularRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableTabularRow immutableTabularRow =
        ImmutableTabularRow.builder().rowNumber(10).values("42").build();

    // Act and Assert
    assertEquals(immutableTabularRow, immutableTabularRow);
    int expectedHashCodeResult = immutableTabularRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableTabularRow.hashCode());
  }

  /**
   * Test {@link ImmutableTabularRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTabularRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTabularRow.equals(Object)",
    "int ImmutableTabularRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableTabularRow immutableTabularRow =
        ImmutableTabularRow.builder().rowNumber(1).values("42").build();

    // Act and Assert
    assertNotEquals(
        immutableTabularRow, ImmutableTabularRow.builder().rowNumber(10).values("42").build());
  }

  /**
   * Test {@link ImmutableTabularRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTabularRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTabularRow.equals(Object)",
    "int ImmutableTabularRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableTabularRow immutableTabularRow =
        ImmutableTabularRow.builder().rowNumber(10).values("Values").build();

    // Act and Assert
    assertNotEquals(
        immutableTabularRow, ImmutableTabularRow.builder().rowNumber(10).values("42").build());
  }

  /**
   * Test {@link ImmutableTabularRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTabularRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTabularRow.equals(Object)",
    "int ImmutableTabularRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableTabularRow.builder().rowNumber(10).values("42").build(), null);
  }

  /**
   * Test {@link ImmutableTabularRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTabularRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTabularRow.equals(Object)",
    "int ImmutableTabularRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTabularRow.builder().rowNumber(10).values("42").build(),
        "Different type to ImmutableTabularRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTabularRow#toString()}
   *   <li>{@link ImmutableTabularRow#rowNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableTabularRow.rowNumber()",
    "String ImmutableTabularRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableTabularRow immutableTabularRow =
        ImmutableTabularRow.builder().rowNumber(10).values("42").build();

    // Act
    String actualToStringResult = immutableTabularRow.toString();

    // Assert
    assertEquals("TabularRow{rowNumber=10, values=[42]}", actualToStringResult);
    assertEquals(10, immutableTabularRow.rowNumber());
  }

  /**
   * Test {@link ImmutableTabularRow#values()}.
   *
   * <p>Method under test: {@link ImmutableTabularRow#values()}
   */
  @Test
  @DisplayName("Test values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ImmutableTabularRow.values()"})
  void testValues() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {"42"},
        ImmutableTabularRow.builder().rowNumber(10).values("42").build().values());
  }

  /**
   * Test {@link ImmutableTabularRow#withRowNumber(int)}.
   *
   * <ul>
   *   <li>Then return builder rowNumber forty-two values {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTabularRow#withRowNumber(int)}
   */
  @Test
  @DisplayName("Test withRowNumber(int); then return builder rowNumber forty-two values '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTabularRow ImmutableTabularRow.withRowNumber(int)"})
  void testWithRowNumber_thenReturnBuilderRowNumberFortyTwoValues42Build() {
    // Arrange
    ImmutableTabularRow immutableTabularRow =
        ImmutableTabularRow.builder().rowNumber(42).values("42").build();

    // Act
    ImmutableTabularRow actualWithRowNumberResult = immutableTabularRow.withRowNumber(42);

    // Assert
    assertSame(immutableTabularRow, actualWithRowNumberResult);
  }

  /**
   * Test {@link ImmutableTabularRow#withRowNumber(int)}.
   *
   * <ul>
   *   <li>Then return rowNumber is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTabularRow#withRowNumber(int)}
   */
  @Test
  @DisplayName("Test withRowNumber(int); then return rowNumber is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTabularRow ImmutableTabularRow.withRowNumber(int)"})
  void testWithRowNumber_thenReturnRowNumberIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42,
        ImmutableTabularRow.builder()
            .rowNumber(10)
            .values("42")
            .build()
            .withRowNumber(42)
            .rowNumber());
  }

  /**
   * Test {@link ImmutableTabularRow#withValues(String[])}.
   *
   * <p>Method under test: {@link ImmutableTabularRow#withValues(String[])}
   */
  @Test
  @DisplayName("Test withValues(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTabularRow ImmutableTabularRow.withValues(String[])"})
  void testWithValues() {
    // Arrange, Act and Assert
    assertEquals(
        10,
        ImmutableTabularRow.builder()
            .rowNumber(10)
            .values("42")
            .build()
            .withValues("Elements")
            .rowNumber());
  }
}
