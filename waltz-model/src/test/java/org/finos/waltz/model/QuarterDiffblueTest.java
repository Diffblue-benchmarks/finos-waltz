package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuarterDiffblueTest {
  /**
   * Test {@link Quarter#fromInt(Integer)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code Q4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Quarter#fromInt(Integer)}
   */
  @Test
  @DisplayName("Test fromInt(Integer); when four; then return 'Q4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Quarter Quarter.fromInt(Integer)"})
  void testFromInt_whenFour_thenReturnQ4() {
    // Arrange, Act and Assert
    assertEquals(Quarter.Q4, Quarter.fromInt(4));
  }

  /**
   * Test {@link Quarter#fromInt(Integer)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code Q1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Quarter#fromInt(Integer)}
   */
  @Test
  @DisplayName("Test fromInt(Integer); when one; then return 'Q1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Quarter Quarter.fromInt(Integer)"})
  void testFromInt_whenOne_thenReturnQ1() {
    // Arrange, Act and Assert
    assertEquals(Quarter.Q1, Quarter.fromInt(1));
  }

  /**
   * Test {@link Quarter#fromInt(Integer)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code Q3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Quarter#fromInt(Integer)}
   */
  @Test
  @DisplayName("Test fromInt(Integer); when three; then return 'Q3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Quarter Quarter.fromInt(Integer)"})
  void testFromInt_whenThree_thenReturnQ3() {
    // Arrange, Act and Assert
    assertEquals(Quarter.Q3, Quarter.fromInt(3));
  }

  /**
   * Test {@link Quarter#fromInt(Integer)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code Q2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Quarter#fromInt(Integer)}
   */
  @Test
  @DisplayName("Test fromInt(Integer); when two; then return 'Q2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Quarter Quarter.fromInt(Integer)"})
  void testFromInt_whenTwo_thenReturnQ2() {
    // Arrange, Act and Assert
    assertEquals(Quarter.Q2, Quarter.fromInt(2));
  }

  /**
   * Test {@link Quarter#fromInt(Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Quarter#fromInt(Integer)}
   */
  @Test
  @DisplayName("Test fromInt(Integer); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Quarter Quarter.fromInt(Integer)"})
  void testFromInt_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Quarter.fromInt(0));
  }
}
