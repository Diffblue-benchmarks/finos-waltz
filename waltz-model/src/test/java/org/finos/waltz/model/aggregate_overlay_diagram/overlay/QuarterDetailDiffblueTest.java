package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.Quarter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuarterDetailDiffblueTest {
  /**
   * Test {@link QuarterDetail#mkQuarterDetail(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return quarter is one.
   * </ul>
   *
   * <p>Method under test: {@link QuarterDetail#mkQuarterDetail(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test mkQuarterDetail(LocalDate); when LocalDate with '1970' and one and one; then return quarter is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QuarterDetail QuarterDetail.mkQuarterDetail(LocalDate)"})
  void testMkQuarterDetail_whenLocalDateWith1970AndOneAndOne_thenReturnQuarterIsOne() {
    // Arrange and Act
    QuarterDetail actualMkQuarterDetailResult =
        QuarterDetail.mkQuarterDetail(LocalDate.of(1970, 1, 1));

    // Assert
    assertTrue(actualMkQuarterDetailResult instanceof ImmutableQuarterDetail);
    assertEquals(1, actualMkQuarterDetailResult.quarter());
    assertEquals(1970, actualMkQuarterDetailResult.year());
    assertEquals(Quarter.Q1, actualMkQuarterDetailResult.quarterName());
  }

  /**
   * Test {@link QuarterDetail#mkQuarterDetail(LocalDate)}.
   *
   * <ul>
   *   <li>When ofEpochDay minus one.
   *   <li>Then return year is {@code 1969}.
   * </ul>
   *
   * <p>Method under test: {@link QuarterDetail#mkQuarterDetail(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test mkQuarterDetail(LocalDate); when ofEpochDay minus one; then return year is '1969'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QuarterDetail QuarterDetail.mkQuarterDetail(LocalDate)"})
  void testMkQuarterDetail_whenOfEpochDayMinusOne_thenReturnYearIs1969() {
    // Arrange and Act
    QuarterDetail actualMkQuarterDetailResult =
        QuarterDetail.mkQuarterDetail(LocalDate.ofEpochDay(-1L));

    // Assert
    assertTrue(actualMkQuarterDetailResult instanceof ImmutableQuarterDetail);
    assertEquals(1969, actualMkQuarterDetailResult.year());
    assertEquals(4, actualMkQuarterDetailResult.quarter());
    assertEquals(Quarter.Q4, actualMkQuarterDetailResult.quarterName());
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> QuarterDetail.lookupQuarter(42));
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when four; then return intValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenFour_thenReturnIntValueIsTwo() {
    // Arrange and Act
    Integer actualLookupQuarterResult = QuarterDetail.lookupQuarter(4);

    // Assert
    assertEquals(2, actualLookupQuarterResult.intValue());
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenOne_thenReturnIntValueIsOne() {
    // Arrange and Act
    Integer actualLookupQuarterResult = QuarterDetail.lookupQuarter(1);

    // Assert
    assertEquals(1, actualLookupQuarterResult.intValue());
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return intValue is three.
   * </ul>
   *
   * <p>Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when seven; then return intValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenSeven_thenReturnIntValueIsThree() {
    // Arrange and Act
    Integer actualLookupQuarterResult = QuarterDetail.lookupQuarter(7);

    // Assert
    assertEquals(3, actualLookupQuarterResult.intValue());
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when ten; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenTen_thenReturnIntValueIsFour() {
    // Arrange and Act
    Integer actualLookupQuarterResult = QuarterDetail.lookupQuarter(10);

    // Assert
    assertEquals(4, actualLookupQuarterResult.intValue());
  }
}
