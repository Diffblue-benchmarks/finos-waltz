package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.Quarter;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableQuarterDetail.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableQuarterDetail.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableQuarterDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableQuarterDetail actualImmutableQuarterDetail =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build();

    // Assert
    assertEquals(1, actualImmutableQuarterDetail.quarter());
    assertEquals(1, actualImmutableQuarterDetail.year());
    assertEquals(Quarter.Q1, actualImmutableQuarterDetail.quarterName());
  }

  /**
   * Test Builder {@link Builder#from(QuarterDetail)}.
   *
   * <ul>
   *   <li>Then builder build is builder quarter one year one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(QuarterDetail)}
   */
  @Test
  @DisplayName(
      "Test Builder from(QuarterDetail); then builder build is builder quarter one year one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(QuarterDetail)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderQuarterOneYearOneBuild() {
    // Arrange
    Builder builderResult = ImmutableQuarterDetail.builder();
    ImmutableQuarterDetail instance = ImmutableQuarterDetail.builder().quarter(1).year(1).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableQuarterDetail actualImmutableQuarterDetail = builderResult.build();
    assertEquals(instance, actualImmutableQuarterDetail);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#quarter(int)}.
   *
   * <p>Method under test: {@link Builder#quarter(int)}
   */
  @Test
  @DisplayName("Test Builder quarter(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.quarter(int)"})
  void testBuilderQuarter() {
    // Arrange
    Builder builderResult = ImmutableQuarterDetail.builder();

    // Act
    Builder actualQuarterResult = builderResult.quarter(1);

    // Assert
    assertSame(builderResult, actualQuarterResult);
  }

  /**
   * Test Builder {@link Builder#year(int)}.
   *
   * <p>Method under test: {@link Builder#year(int)}
   */
  @Test
  @DisplayName("Test Builder year(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.year(int)"})
  void testBuilderYear() {
    // Arrange
    Builder builderResult = ImmutableQuarterDetail.builder();

    // Act
    Builder actualYearResult = builderResult.year(1);

    // Assert
    assertSame(builderResult, actualYearResult);
  }

  /**
   * Test {@link ImmutableQuarterDetail#copyOf(QuarterDetail)}.
   *
   * <ul>
   *   <li>When builder quarter one year one build.
   *   <li>Then return quarter is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#copyOf(QuarterDetail)}
   */
  @Test
  @DisplayName(
      "Test copyOf(QuarterDetail); when builder quarter one year one build; then return quarter is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.copyOf(QuarterDetail)"})
  void testCopyOf_whenBuilderQuarterOneYearOneBuild_thenReturnQuarterIsOne() {
    // Arrange
    ImmutableQuarterDetail instance = ImmutableQuarterDetail.builder().quarter(1).year(1).build();

    // Act
    ImmutableQuarterDetail actualCopyOfResult = ImmutableQuarterDetail.copyOf(instance);

    // Assert
    assertEquals(1, actualCopyOfResult.quarter());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(Quarter.Q1, actualCopyOfResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#equals(Object)}, and {@link
   * ImmutableQuarterDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableQuarterDetail#equals(Object)}
   *   <li>{@link ImmutableQuarterDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableQuarterDetail.equals(Object)",
    "int ImmutableQuarterDetail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableQuarterDetail immutableQuarterDetail =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build();
    ImmutableQuarterDetail immutableQuarterDetail2 =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build();

    // Act and Assert
    assertEquals(immutableQuarterDetail, immutableQuarterDetail2);
    assertEquals(immutableQuarterDetail.hashCode(), immutableQuarterDetail2.hashCode());
  }

  /**
   * Test {@link ImmutableQuarterDetail#equals(Object)}, and {@link
   * ImmutableQuarterDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableQuarterDetail#equals(Object)}
   *   <li>{@link ImmutableQuarterDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableQuarterDetail.equals(Object)",
    "int ImmutableQuarterDetail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableQuarterDetail immutableQuarterDetail =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build();

    // Act and Assert
    assertEquals(immutableQuarterDetail, immutableQuarterDetail);
    int expectedHashCodeResult = immutableQuarterDetail.hashCode();
    assertEquals(expectedHashCodeResult, immutableQuarterDetail.hashCode());
  }

  /**
   * Test {@link ImmutableQuarterDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableQuarterDetail.equals(Object)",
    "int ImmutableQuarterDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableQuarterDetail immutableQuarterDetail =
        ImmutableQuarterDetail.builder().quarter(1).year(-8095).build();

    // Act and Assert
    assertNotEquals(
        immutableQuarterDetail, ImmutableQuarterDetail.builder().quarter(1).year(1).build());
  }

  /**
   * Test {@link ImmutableQuarterDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableQuarterDetail.equals(Object)",
    "int ImmutableQuarterDetail.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableQuarterDetail.builder().quarter(1).year(1).build(), null);
  }

  /**
   * Test {@link ImmutableQuarterDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableQuarterDetail.equals(Object)",
    "int ImmutableQuarterDetail.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableQuarterDetail.builder().quarter(1).year(1).build(),
        "Different type to ImmutableQuarterDetail");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableQuarterDetail#toString()}
   *   <li>{@link ImmutableQuarterDetail#quarter()}
   *   <li>{@link ImmutableQuarterDetail#year()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableQuarterDetail.quarter()",
    "java.lang.String ImmutableQuarterDetail.toString()",
    "int ImmutableQuarterDetail.year()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableQuarterDetail immutableQuarterDetail =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build();

    // Act
    immutableQuarterDetail.toString();
    int actualQuarterResult = immutableQuarterDetail.quarter();

    // Assert
    assertEquals(1, actualQuarterResult);
    assertEquals(1, immutableQuarterDetail.year());
  }

  /**
   * Test Json {@link Json#additionalQuarters()}.
   *
   * <p>Method under test: {@link Json#additionalQuarters()}
   */
  @Test
  @DisplayName("Test Json additionalQuarters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.additionalQuarters()"})
  void testJsonAdditionalQuarters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().additionalQuarters());
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
    assertEquals(0, actualJson.quarter);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.quarterIsSet);
    assertFalse(actualJson.yearIsSet);
  }

  /**
   * Test Json {@link Json#quarter()}.
   *
   * <p>Method under test: {@link Json#quarter()}
   */
  @Test
  @DisplayName("Test Json quarter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.quarter()"})
  void testJsonQuarter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().quarter());
  }

  /**
   * Test Json {@link Json#quarterName()}.
   *
   * <p>Method under test: {@link Json#quarterName()}
   */
  @Test
  @DisplayName("Test Json quarterName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quarter Json.quarterName()"})
  void testJsonQuarterName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().quarterName());
  }

  /**
   * Test Json {@link Json#setQuarter(int)}.
   *
   * <p>Method under test: {@link Json#setQuarter(int)}
   */
  @Test
  @DisplayName("Test Json setQuarter(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setQuarter(int)"})
  void testJsonSetQuarter() {
    // Arrange
    Json json = new Json();

    // Act
    json.setQuarter(1);

    // Assert
    assertEquals(1, json.quarter);
    assertTrue(json.quarterIsSet);
  }

  /**
   * Test Json {@link Json#setYear(int)}.
   *
   * <p>Method under test: {@link Json#setYear(int)}
   */
  @Test
  @DisplayName("Test Json setYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setYear(int)"})
  void testJsonSetYear() {
    // Arrange
    Json json = new Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Test Json {@link Json#year()}.
   *
   * <p>Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().year());
  }

  /**
   * Test {@link ImmutableQuarterDetail#quarterName()}.
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#quarterName()}
   */
  @Test
  @DisplayName("Test quarterName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quarter ImmutableQuarterDetail.quarterName()"})
  void testQuarterName() {
    // Arrange, Act and Assert
    assertEquals(
        Quarter.Q1, ImmutableQuarterDetail.builder().quarter(1).year(1).build().quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withQuarter(int)}.
   *
   * <ul>
   *   <li>Given builder quarter two year one build.
   *   <li>Then return quarter is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withQuarter(int)}
   */
  @Test
  @DisplayName(
      "Test withQuarter(int); given builder quarter two year one build; then return quarter is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withQuarter(int)"})
  void testWithQuarter_givenBuilderQuarterTwoYearOneBuild_thenReturnQuarterIsOne() {
    // Arrange and Act
    ImmutableQuarterDetail actualWithQuarterResult =
        ImmutableQuarterDetail.builder().quarter(2).year(1).build().withQuarter(1);

    // Assert
    assertEquals(1, actualWithQuarterResult.quarter());
    assertEquals(1, actualWithQuarterResult.year());
    assertEquals(Quarter.Q1, actualWithQuarterResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withQuarter(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return quarter is four.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withQuarter(int)}
   */
  @Test
  @DisplayName("Test withQuarter(int); when four; then return quarter is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withQuarter(int)"})
  void testWithQuarter_whenFour_thenReturnQuarterIsFour() {
    // Arrange and Act
    ImmutableQuarterDetail actualWithQuarterResult =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build().withQuarter(4);

    // Assert
    assertEquals(1, actualWithQuarterResult.year());
    assertEquals(4, actualWithQuarterResult.quarter());
    assertEquals(Quarter.Q4, actualWithQuarterResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withQuarter(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder quarter one year one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withQuarter(int)}
   */
  @Test
  @DisplayName("Test withQuarter(int); when one; then return builder quarter one year one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withQuarter(int)"})
  void testWithQuarter_whenOne_thenReturnBuilderQuarterOneYearOneBuild() {
    // Arrange
    ImmutableQuarterDetail immutableQuarterDetail =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build();

    // Act
    ImmutableQuarterDetail actualWithQuarterResult = immutableQuarterDetail.withQuarter(1);

    // Assert
    assertSame(immutableQuarterDetail, actualWithQuarterResult);
  }

  /**
   * Test {@link ImmutableQuarterDetail#withQuarter(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return quarter is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withQuarter(int)}
   */
  @Test
  @DisplayName("Test withQuarter(int); when three; then return quarter is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withQuarter(int)"})
  void testWithQuarter_whenThree_thenReturnQuarterIsThree() {
    // Arrange and Act
    ImmutableQuarterDetail actualWithQuarterResult =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build().withQuarter(3);

    // Assert
    assertEquals(1, actualWithQuarterResult.year());
    assertEquals(3, actualWithQuarterResult.quarter());
    assertEquals(Quarter.Q3, actualWithQuarterResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withQuarter(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return quarter is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withQuarter(int)}
   */
  @Test
  @DisplayName("Test withQuarter(int); when two; then return quarter is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withQuarter(int)"})
  void testWithQuarter_whenTwo_thenReturnQuarterIsTwo() {
    // Arrange and Act
    ImmutableQuarterDetail actualWithQuarterResult =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build().withQuarter(2);

    // Assert
    assertEquals(1, actualWithQuarterResult.year());
    assertEquals(2, actualWithQuarterResult.quarter());
    assertEquals(Quarter.Q2, actualWithQuarterResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withYear(int)}.
   *
   * <ul>
   *   <li>Given builder quarter four year one build.
   *   <li>Then return quarter is four.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withYear(int)}
   */
  @Test
  @DisplayName(
      "Test withYear(int); given builder quarter four year one build; then return quarter is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withYear(int)"})
  void testWithYear_givenBuilderQuarterFourYearOneBuild_thenReturnQuarterIsFour() {
    // Arrange and Act
    ImmutableQuarterDetail actualWithYearResult =
        ImmutableQuarterDetail.builder().quarter(4).year(1).build().withYear(42);

    // Assert
    assertEquals(4, actualWithYearResult.quarter());
    assertEquals(42, actualWithYearResult.year());
    assertEquals(Quarter.Q4, actualWithYearResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withYear(int)}.
   *
   * <ul>
   *   <li>Given builder quarter one year one build.
   *   <li>Then return quarter is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withYear(int)}
   */
  @Test
  @DisplayName(
      "Test withYear(int); given builder quarter one year one build; then return quarter is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withYear(int)"})
  void testWithYear_givenBuilderQuarterOneYearOneBuild_thenReturnQuarterIsOne() {
    // Arrange and Act
    ImmutableQuarterDetail actualWithYearResult =
        ImmutableQuarterDetail.builder().quarter(1).year(1).build().withYear(42);

    // Assert
    assertEquals(1, actualWithYearResult.quarter());
    assertEquals(42, actualWithYearResult.year());
    assertEquals(Quarter.Q1, actualWithYearResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withYear(int)}.
   *
   * <ul>
   *   <li>Given builder quarter three year one build.
   *   <li>Then return quarter is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withYear(int)}
   */
  @Test
  @DisplayName(
      "Test withYear(int); given builder quarter three year one build; then return quarter is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withYear(int)"})
  void testWithYear_givenBuilderQuarterThreeYearOneBuild_thenReturnQuarterIsThree() {
    // Arrange and Act
    ImmutableQuarterDetail actualWithYearResult =
        ImmutableQuarterDetail.builder().quarter(3).year(1).build().withYear(42);

    // Assert
    assertEquals(3, actualWithYearResult.quarter());
    assertEquals(42, actualWithYearResult.year());
    assertEquals(Quarter.Q3, actualWithYearResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withYear(int)}.
   *
   * <ul>
   *   <li>Given builder quarter two year one build.
   *   <li>Then return quarter is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withYear(int)}
   */
  @Test
  @DisplayName(
      "Test withYear(int); given builder quarter two year one build; then return quarter is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withYear(int)"})
  void testWithYear_givenBuilderQuarterTwoYearOneBuild_thenReturnQuarterIsTwo() {
    // Arrange and Act
    ImmutableQuarterDetail actualWithYearResult =
        ImmutableQuarterDetail.builder().quarter(2).year(1).build().withYear(42);

    // Assert
    assertEquals(2, actualWithYearResult.quarter());
    assertEquals(42, actualWithYearResult.year());
    assertEquals(Quarter.Q2, actualWithYearResult.quarterName());
  }

  /**
   * Test {@link ImmutableQuarterDetail#withYear(int)}.
   *
   * <ul>
   *   <li>Then return builder quarter one year forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableQuarterDetail#withYear(int)}
   */
  @Test
  @DisplayName("Test withYear(int); then return builder quarter one year forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableQuarterDetail ImmutableQuarterDetail.withYear(int)"})
  void testWithYear_thenReturnBuilderQuarterOneYearFortyTwoBuild() {
    // Arrange
    ImmutableQuarterDetail immutableQuarterDetail =
        ImmutableQuarterDetail.builder().quarter(1).year(42).build();

    // Act
    ImmutableQuarterDetail actualWithYearResult = immutableQuarterDetail.withYear(42);

    // Assert
    assertSame(immutableQuarterDetail, actualWithYearResult);
  }
}
