package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ArrayUtilitiesDiffblueTest {
  /**
   * Test {@link ArrayUtilities#all(Object[], Predicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#all(Object[], Predicate)}
   */
  @Test
  @DisplayName(
      "Test all(Object[], Predicate); given 'false'; when Predicate test(Object) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayUtilities.all(Object[], Predicate)"})
  void testAll_givenFalse_whenPredicateTestReturnFalse_thenReturnFalse() {
    // Arrange
    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualAllResult = ArrayUtilities.all(new Object[] {"Ts"}, check);

    // Assert
    verify(check).test(isA(Object.class));
    assertFalse(actualAllResult);
  }

  /**
   * Test {@link ArrayUtilities#all(Object[], Predicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#all(Object[], Predicate)}
   */
  @Test
  @DisplayName(
      "Test all(Object[], Predicate); given 'true'; when Predicate test(Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayUtilities.all(Object[], Predicate)"})
  void testAll_givenTrue_whenPredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualAllResult = ArrayUtilities.all(new Object[] {"Ts"}, check);

    // Assert
    verify(check).test(isA(Object.class));
    assertTrue(actualAllResult);
  }

  /**
   * Test {@link ArrayUtilities#isEmpty(Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Arr}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#isEmpty(Object[])}
   */
  @Test
  @DisplayName("Test isEmpty(Object[]); when array of Object with 'Arr'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayUtilities.isEmpty(Object[])"})
  void testIsEmpty_whenArrayOfObjectWithArr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtilities.isEmpty(new Object[] {"Arr"}));
  }

  /**
   * Test {@link ArrayUtilities#isEmpty(Object[])}.
   *
   * <ul>
   *   <li>When empty array of {@link Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#isEmpty(Object[])}
   */
  @Test
  @DisplayName("Test isEmpty(Object[]); when empty array of Object; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayUtilities.isEmpty(Object[])"})
  void testIsEmpty_whenEmptyArrayOfObject_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtilities.isEmpty(new Object[] {}));
  }

  /**
   * Test {@link ArrayUtilities#isEmpty(Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#isEmpty(Object[])}
   */
  @Test
  @DisplayName("Test isEmpty(Object[]); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayUtilities.isEmpty(Object[])"})
  void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ArrayUtilities.isEmpty(null));
  }

  /**
   * Test {@link ArrayUtilities#sum(int[])}.
   *
   * <ul>
   *   <li>When array of {@code int} with one and zero.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#sum(int[])}
   */
  @Test
  @DisplayName("Test sum(int[]); when array of int with one and zero; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ArrayUtilities.sum(int[])"})
  void testSum_whenArrayOfIntWithOneAndZero_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, ArrayUtilities.sum(new int[] {1, 0, 1, 0}));
  }

  /**
   * Test {@link ArrayUtilities#last(Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Arr}.
   *   <li>Then return {@code Arr}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#last(Object[])}
   */
  @Test
  @DisplayName("Test last(Object[]); when array of Object with 'Arr'; then return 'Arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ArrayUtilities.last(Object[])"})
  void testLast_whenArrayOfObjectWithArr_thenReturnArr() {
    // Arrange, Act and Assert
    assertEquals("Arr", ArrayUtilities.last(new Object[] {"Arr"}));
  }

  /**
   * Test {@link ArrayUtilities#initial(Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Arr}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#initial(Object[])}
   */
  @Test
  @DisplayName(
      "Test initial(Object[]); when array of Object with 'Arr'; then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ArrayUtilities.initial(Object[])"})
  void testInitial_whenArrayOfObjectWithArr_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtilities.initial(new Object[] {"Arr"}).length);
  }

  /**
   * Test {@link ArrayUtilities#map(Object[], Function)}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code Apply}.
   *   <li>Then return first element is {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#map(Object[], Function)}
   */
  @Test
  @DisplayName(
      "Test map(Object[], Function); given 'Apply'; when Function apply(Object) return 'Apply'; then return first element is 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ArrayUtilities.map(Object[], Function)"})
  void testMap_givenApply_whenFunctionApplyReturnApply_thenReturnFirstElementIsApply() {
    // Arrange
    Function<Object, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Object[] actualMapResult = ArrayUtilities.map(new Object[] {"Arr"}, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertEquals("Apply", actualMapResult[0]);
    assertEquals(1, actualMapResult.length);
  }

  /**
   * Test {@link ArrayUtilities#idx(Object[], int, Object)}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Arr} and {@code Arr}.
   *   <li>Then return {@code Arr}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#idx(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test idx(Object[], int, Object); when array of Object with 'Arr' and 'Arr'; then return 'Arr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ArrayUtilities.idx(Object[], int, Object)"})
  void testIdx_whenArrayOfObjectWithArrAndArr_thenReturnArr() {
    // Arrange, Act and Assert
    assertEquals("Arr", ArrayUtilities.idx(new Object[] {"Arr", "Arr"}, 1, "Dflt"));
  }

  /**
   * Test {@link ArrayUtilities#idx(Object[], int, Object)}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Arr}.
   *   <li>Then return {@code Dflt}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayUtilities#idx(Object[], int, Object)}
   */
  @Test
  @DisplayName(
      "Test idx(Object[], int, Object); when array of Object with 'Arr'; then return 'Dflt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ArrayUtilities.idx(Object[], int, Object)"})
  void testIdx_whenArrayOfObjectWithArr_thenReturnDflt() {
    // Arrange, Act and Assert
    assertEquals("Dflt", ArrayUtilities.idx(new Object[] {"Arr"}, 1, "Dflt"));
  }
}
