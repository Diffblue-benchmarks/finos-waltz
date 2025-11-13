package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RangeBandDiffblueTest {
  /**
   * Test {@link RangeBand#RangeBand(Comparable, Comparable)}.
   *
   * <ul>
   *   <li>When {@code CONSTANT_ASCENT}.
   *   <li>Then return High is {@code CONSTANT_ASCENT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#RangeBand(Comparable, Comparable)}
   */
  @Test
  @DisplayName(
      "Test new RangeBand(Comparable, Comparable); when 'CONSTANT_ASCENT'; then return High is 'CONSTANT_ASCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeBand.<init>(Comparable, Comparable)"})
  void testNewRangeBand_whenConstantAscent_thenReturnHighIsConstantAscent() {
    // Arrange and Act
    RangeBand<BaselineResizeBehavior> actualRangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Assert
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualRangeBand.getHigh());
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualRangeBand.getLow());
  }

  /**
   * Test {@link RangeBand#RangeBand(Comparable, Comparable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return High is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#RangeBand(Comparable, Comparable)}
   */
  @Test
  @DisplayName(
      "Test new RangeBand(Comparable, Comparable); when 'null'; then return High is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeBand.<init>(Comparable, Comparable)"})
  void testNewRangeBand_whenNull_thenReturnHighIsNull() {
    // Arrange and Act
    RangeBand<BaselineResizeBehavior> actualRangeBand =
        new RangeBand<>(BaselineResizeBehavior.CONSTANT_ASCENT, null);

    // Assert
    assertNull(actualRangeBand.getHigh());
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualRangeBand.getLow());
  }

  /**
   * Test {@link RangeBand#RangeBand(Comparable, Comparable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Low is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#RangeBand(Comparable, Comparable)}
   */
  @Test
  @DisplayName("Test new RangeBand(Comparable, Comparable); when 'null'; then return Low is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeBand.<init>(Comparable, Comparable)"})
  void testNewRangeBand_whenNull_thenReturnLowIsNull() {
    // Arrange and Act
    RangeBand<BaselineResizeBehavior> actualRangeBand =
        new RangeBand<>(null, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Assert
    assertNull(actualRangeBand.getLow());
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualRangeBand.getHigh());
  }

  /**
   * Test {@link RangeBand#contains(Comparable)}.
   *
   * <ul>
   *   <li>Given {@link RangeBand#RangeBand(Comparable, Comparable)} with low is {@code
   *       CONSTANT_ASCENT} and high is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#contains(Comparable)}
   */
  @Test
  @DisplayName(
      "Test contains(Comparable); given RangeBand(Comparable, Comparable) with low is 'CONSTANT_ASCENT' and high is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.contains(Comparable)"})
  void testContains_givenRangeBandWithLowIsConstantAscentAndHighIsNull_thenReturnTrue() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(BaselineResizeBehavior.CONSTANT_ASCENT, null);

    // Act and Assert
    assertTrue(rangeBand.contains(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#contains(Comparable)}.
   *
   * <ul>
   *   <li>Given {@link RangeBand#RangeBand(Comparable, Comparable)} with low is {@code
   *       CONSTANT_DESCENT} and high is {@code CONSTANT_DESCENT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#contains(Comparable)}
   */
  @Test
  @DisplayName(
      "Test contains(Comparable); given RangeBand(Comparable, Comparable) with low is 'CONSTANT_DESCENT' and high is 'CONSTANT_DESCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.contains(Comparable)"})
  void testContains_givenRangeBandWithLowIsConstantDescentAndHighIsConstantDescent() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_DESCENT, BaselineResizeBehavior.CONSTANT_DESCENT);

    // Act and Assert
    assertFalse(rangeBand.contains(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#contains(Comparable)}.
   *
   * <ul>
   *   <li>Given {@link RangeBand#RangeBand(Comparable, Comparable)} with low is {@code
   *       CONSTANT_DESCENT} and high is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#contains(Comparable)}
   */
  @Test
  @DisplayName(
      "Test contains(Comparable); given RangeBand(Comparable, Comparable) with low is 'CONSTANT_DESCENT' and high is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.contains(Comparable)"})
  void testContains_givenRangeBandWithLowIsConstantDescentAndHighIsNull_thenReturnFalse() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(BaselineResizeBehavior.CONSTANT_DESCENT, null);

    // Act and Assert
    assertFalse(rangeBand.contains(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#contains(Comparable)}.
   *
   * <ul>
   *   <li>Given {@link RangeBand#RangeBand(Comparable, Comparable)} with low is {@code null} and
   *       high is {@code CONSTANT_ASCENT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#contains(Comparable)}
   */
  @Test
  @DisplayName(
      "Test contains(Comparable); given RangeBand(Comparable, Comparable) with low is 'null' and high is 'CONSTANT_ASCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.contains(Comparable)"})
  void testContains_givenRangeBandWithLowIsNullAndHighIsConstantAscent() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(null, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertFalse(rangeBand.contains(BaselineResizeBehavior.CONSTANT_DESCENT));
  }

  /**
   * Test {@link RangeBand#contains(Comparable)}.
   *
   * <ul>
   *   <li>Given {@link RangeBand#RangeBand(Comparable, Comparable)} with low is {@code null} and
   *       high is {@code CONSTANT_ASCENT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#contains(Comparable)}
   */
  @Test
  @DisplayName(
      "Test contains(Comparable); given RangeBand(Comparable, Comparable) with low is 'null' and high is 'CONSTANT_ASCENT'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.contains(Comparable)"})
  void testContains_givenRangeBandWithLowIsNullAndHighIsConstantAscent_thenReturnTrue() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(null, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertTrue(rangeBand.contains(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#contains(Comparable)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#contains(Comparable)}
   */
  @Test
  @DisplayName("Test contains(Comparable); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.contains(Comparable)"})
  void testContains_thenReturnTrue() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertTrue(rangeBand.contains(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#contains(Comparable)}.
   *
   * <ul>
   *   <li>When {@code CONSTANT_DESCENT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#contains(Comparable)}
   */
  @Test
  @DisplayName("Test contains(Comparable); when 'CONSTANT_DESCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.contains(Comparable)"})
  void testContains_whenConstantDescent() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertFalse(rangeBand.contains(BaselineResizeBehavior.CONSTANT_DESCENT));
  }

  /**
   * Test {@link RangeBand#test(Comparable)} with {@code BaselineResizeBehavior}.
   *
   * <p>Method under test: {@link RangeBand#test(Comparable)}
   */
  @Test
  @DisplayName("Test test(Comparable) with 'BaselineResizeBehavior'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.test(Comparable)"})
  void testTestWithBaselineResizeBehavior() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(BaselineResizeBehavior.CONSTANT_ASCENT, null);

    // Act and Assert
    assertTrue(rangeBand.test(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#test(Comparable)} with {@code BaselineResizeBehavior}.
   *
   * <p>Method under test: {@link RangeBand#test(Comparable)}
   */
  @Test
  @DisplayName("Test test(Comparable) with 'BaselineResizeBehavior'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.test(Comparable)"})
  void testTestWithBaselineResizeBehavior2() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(null, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertTrue(rangeBand.test(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#test(Comparable)} with {@code BaselineResizeBehavior}.
   *
   * <p>Method under test: {@link RangeBand#test(Comparable)}
   */
  @Test
  @DisplayName("Test test(Comparable) with 'BaselineResizeBehavior'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.test(Comparable)"})
  void testTestWithBaselineResizeBehavior3() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(BaselineResizeBehavior.CONSTANT_DESCENT, null);

    // Act and Assert
    assertFalse(rangeBand.test(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#test(Comparable)} with {@code BaselineResizeBehavior}.
   *
   * <p>Method under test: {@link RangeBand#test(Comparable)}
   */
  @Test
  @DisplayName("Test test(Comparable) with 'BaselineResizeBehavior'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.test(Comparable)"})
  void testTestWithBaselineResizeBehavior4() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(null, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertFalse(rangeBand.test(BaselineResizeBehavior.CONSTANT_DESCENT));
  }

  /**
   * Test {@link RangeBand#test(Comparable)} with {@code BaselineResizeBehavior}.
   *
   * <p>Method under test: {@link RangeBand#test(Comparable)}
   */
  @Test
  @DisplayName("Test test(Comparable) with 'BaselineResizeBehavior'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.test(Comparable)"})
  void testTestWithBaselineResizeBehavior5() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_DESCENT, BaselineResizeBehavior.CONSTANT_DESCENT);

    // Act and Assert
    assertFalse(rangeBand.test(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#test(Comparable)} with {@code BaselineResizeBehavior}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#test(Comparable)}
   */
  @Test
  @DisplayName("Test test(Comparable) with 'BaselineResizeBehavior'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.test(Comparable)"})
  void testTestWithBaselineResizeBehavior_thenReturnTrue() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertTrue(rangeBand.test(BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#test(Comparable)} with {@code BaselineResizeBehavior}.
   *
   * <ul>
   *   <li>When {@code CONSTANT_DESCENT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#test(Comparable)}
   */
  @Test
  @DisplayName("Test test(Comparable) with 'BaselineResizeBehavior'; when 'CONSTANT_DESCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.test(Comparable)"})
  void testTestWithBaselineResizeBehavior_whenConstantDescent() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertFalse(rangeBand.test(BaselineResizeBehavior.CONSTANT_DESCENT));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RangeBand#getHigh()}
   *   <li>{@link RangeBand#getLow()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparable RangeBand.getHigh()", "Comparable RangeBand.getLow()"})
  void testGettersAndSetters() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualHigh = rangeBand.getHigh();

    // Assert
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualHigh);
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, rangeBand.getLow());
  }

  /**
   * Test {@link RangeBand#equals(Object)}, and {@link RangeBand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RangeBand#equals(Object)}
   *   <li>{@link RangeBand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.equals(Object)", "int RangeBand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);
    RangeBand<BaselineResizeBehavior> rangeBand2 =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertEquals(rangeBand, rangeBand2);
    assertEquals(rangeBand.hashCode(), rangeBand2.hashCode());
  }

  /**
   * Test {@link RangeBand#equals(Object)}, and {@link RangeBand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RangeBand#equals(Object)}
   *   <li>{@link RangeBand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.equals(Object)", "int RangeBand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertEquals(rangeBand, rangeBand);
    int expectedHashCodeResult = rangeBand.hashCode();
    assertEquals(expectedHashCodeResult, rangeBand.hashCode());
  }

  /**
   * Test {@link RangeBand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.equals(Object)", "int RangeBand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(null, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertNotEquals(
        rangeBand,
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.equals(Object)", "int RangeBand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_DESCENT, BaselineResizeBehavior.CONSTANT_DESCENT);

    // Act and Assert
    assertNotEquals(
        rangeBand,
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT));
  }

  /**
   * Test {@link RangeBand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.equals(Object)", "int RangeBand.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertNotEquals(rangeBand, null);
  }

  /**
   * Test {@link RangeBand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeBand.equals(Object)", "int RangeBand.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertNotEquals(rangeBand, "Different type to RangeBand");
  }

  /**
   * Test {@link RangeBand#toString()}.
   *
   * <ul>
   *   <li>Then return {@code CONSTANT_ASCENT - *}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'CONSTANT_ASCENT - *'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeBand.toString()"})
  void testToString_thenReturnConstantAscent() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(BaselineResizeBehavior.CONSTANT_ASCENT, null);

    // Act and Assert
    assertEquals("CONSTANT_ASCENT - *", rangeBand.toString());
  }

  /**
   * Test {@link RangeBand#toString()}.
   *
   * <ul>
   *   <li>Then return {@code * - CONSTANT_ASCENT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '* - CONSTANT_ASCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeBand.toString()"})
  void testToString_thenReturnConstantAscent2() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(null, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertEquals("* - CONSTANT_ASCENT", rangeBand.toString());
  }

  /**
   * Test {@link RangeBand#toString()}.
   *
   * <ul>
   *   <li>Then return {@code CONSTANT_ASCENT - CONSTANT_ASCENT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeBand#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'CONSTANT_ASCENT - CONSTANT_ASCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeBand.toString()"})
  void testToString_thenReturnConstantAscentConstantAscent() {
    // Arrange
    RangeBand<BaselineResizeBehavior> rangeBand =
        new RangeBand<>(
            BaselineResizeBehavior.CONSTANT_ASCENT, BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act and Assert
    assertEquals("CONSTANT_ASCENT - CONSTANT_ASCENT", rangeBand.toString());
  }
}
