package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.Quarter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuarterDetailDiffblueTest {
  /**
   * Test {@link QuarterDetail#mkQuarterDetail(LocalDate)}.
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.</li>
   *   <li>Then return quarter is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuarterDetail#mkQuarterDetail(LocalDate)}
   */
  @Test
  @DisplayName("Test mkQuarterDetail(LocalDate); when LocalDate with '1970' and one and one; then return quarter is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"QuarterDetail QuarterDetail.mkQuarterDetail(LocalDate)"})
  void testMkQuarterDetail_whenLocalDateWith1970AndOneAndOne_thenReturnQuarterIsOne() {
    // Arrange and Act
    QuarterDetail actualMkQuarterDetailResult = QuarterDetail.mkQuarterDetail(LocalDate.of(1970, 1, 1));

    // Assert
    assertTrue(actualMkQuarterDetailResult instanceof ImmutableQuarterDetail);
    assertEquals(1, actualMkQuarterDetailResult.quarter());
    assertEquals(1970, actualMkQuarterDetailResult.year());
    assertEquals(Quarter.Q1, actualMkQuarterDetailResult.quarterName());
  }

  /**
   * Test {@link QuarterDetail#mkQuarterDetail(LocalDate)}.
   * <ul>
   *   <li>When now.</li>
   *   <li>Then return {@link ImmutableQuarterDetail}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuarterDetail#mkQuarterDetail(LocalDate)}
   */
  @Test
  @DisplayName("Test mkQuarterDetail(LocalDate); when now; then return ImmutableQuarterDetail")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"QuarterDetail QuarterDetail.mkQuarterDetail(LocalDate)"})
  void testMkQuarterDetail_whenNow_thenReturnImmutableQuarterDetail() {
    // Arrange, Act and Assert
    assertTrue(QuarterDetail.mkQuarterDetail(LocalDate.now()) instanceof ImmutableQuarterDetail);
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when forty-two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> QuarterDetail.lookupQuarter(42));
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return intValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when four; then return intValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenFour_thenReturnIntValueIsTwo() {
    // Arrange, Act and Assert
    assertEquals(2, QuarterDetail.lookupQuarter(4).intValue());
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when one; then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenOne_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, QuarterDetail.lookupQuarter(1).intValue());
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return intValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when seven; then return intValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenSeven_thenReturnIntValueIsThree() {
    // Arrange, Act and Assert
    assertEquals(3, QuarterDetail.lookupQuarter(7).intValue());
  }

  /**
   * Test {@link QuarterDetail#lookupQuarter(int)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return intValue is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  @DisplayName("Test lookupQuarter(int); when ten; then return intValue is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer QuarterDetail.lookupQuarter(int)"})
  void testLookupQuarter_whenTen_thenReturnIntValueIsFour() {
    // Arrange, Act and Assert
    assertEquals(4, QuarterDetail.lookupQuarter(10).intValue());
  }
}
