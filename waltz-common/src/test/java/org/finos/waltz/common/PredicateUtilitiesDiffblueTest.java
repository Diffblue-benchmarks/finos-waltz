package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PredicateUtilitiesDiffblueTest {
  /**
   * Test {@link PredicateUtilities#not(Predicate)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return not test {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#not(Predicate)}
   */
  @Test
  @DisplayName(
      "Test not(Predicate); given Predicate test(Object) return 'false'; then return not test '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate PredicateUtilities.not(Predicate)"})
  void testNot_givenPredicateTestReturnFalse_thenReturnNotTest42() {
    // Arrange
    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);

    Predicate<Object> p = mock(Predicate.class);
    when(p.negate()).thenReturn(predicate);

    // Act
    Predicate<Object> actualNotResult = PredicateUtilities.not(p);
    boolean actualTestResult = actualNotResult.test("42");

    // Assert
    verify(p).negate();
    verify(predicate).test(isA(Object.class));
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link PredicateUtilities#not(Predicate)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return test {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#not(Predicate)}
   */
  @Test
  @DisplayName(
      "Test not(Predicate); given Predicate test(Object) return 'true'; then return test '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate PredicateUtilities.not(Predicate)"})
  void testNot_givenPredicateTestReturnTrue_thenReturnTest42() {
    // Arrange
    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);

    Predicate<Object> p = mock(Predicate.class);
    when(p.negate()).thenReturn(predicate);

    // Act
    Predicate<Object> actualNotResult = PredicateUtilities.not(p);
    boolean actualTestResult = actualNotResult.test("42");

    // Assert
    verify(p).negate();
    verify(predicate).test(isA(Object.class));
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link PredicateUtilities#all(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#all(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test all(Collection, Predicate) with 'Collection', 'Predicate'; given 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.all(Collection, Predicate)"})
  void testAllWithCollectionPredicate_givenFalse_thenReturnFalse() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualAllResult = PredicateUtilities.all(ts, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertFalse(actualAllResult);
  }

  /**
   * Test {@link PredicateUtilities#all(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#all(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test all(Collection, Predicate) with 'Collection', 'Predicate'; given 'true'; when Predicate test(Object) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.all(Collection, Predicate)"})
  void testAllWithCollectionPredicate_givenTrue_whenPredicateTestReturnTrue() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualAllResult = PredicateUtilities.all(ts, p);

    // Assert
    verify(p, atLeast(1)).test(isA(Object.class));
    assertTrue(actualAllResult);
  }

  /**
   * Test {@link PredicateUtilities#all(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#all(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test all(Collection, Predicate) with 'Collection', 'Predicate'; when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.all(Collection, Predicate)"})
  void testAllWithCollectionPredicate_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PredicateUtilities.all(new ArrayList<>(), mock(Predicate.class)));
  }

  /**
   * Test {@link PredicateUtilities#all(Object[], Predicate)} with {@code Object[]}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#all(Object[], Predicate)}
   */
  @Test
  @DisplayName(
      "Test all(Object[], Predicate) with 'Object[]', 'Predicate'; given 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.all(Object[], Predicate)"})
  void testAllWithObjectPredicate_givenFalse_thenReturnFalse() {
    // Arrange
    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualAllResult = PredicateUtilities.all(new Object[] {"Ts"}, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertFalse(actualAllResult);
  }

  /**
   * Test {@link PredicateUtilities#all(Object[], Predicate)} with {@code Object[]}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#all(Object[], Predicate)}
   */
  @Test
  @DisplayName(
      "Test all(Object[], Predicate) with 'Object[]', 'Predicate'; given 'true'; when Predicate test(Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.all(Object[], Predicate)"})
  void testAllWithObjectPredicate_givenTrue_whenPredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualAllResult = PredicateUtilities.all(new Object[] {"Ts"}, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertTrue(actualAllResult);
  }

  /**
   * Test {@link PredicateUtilities#any(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#any(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test any(Collection, Predicate) with 'Collection', 'Predicate'; given '42'; when ArrayList() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.any(Collection, Predicate)"})
  void testAnyWithCollectionPredicate_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualAnyResult = PredicateUtilities.any(ts, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertTrue(actualAnyResult);
  }

  /**
   * Test {@link PredicateUtilities#any(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#any(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test any(Collection, Predicate) with 'Collection', 'Predicate'; given '42'; when ArrayList() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.any(Collection, Predicate)"})
  void testAnyWithCollectionPredicate_given42_whenArrayListAdd42_thenReturnTrue2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualAnyResult = PredicateUtilities.any(ts, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertTrue(actualAnyResult);
  }

  /**
   * Test {@link PredicateUtilities#any(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#any(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test any(Collection, Predicate) with 'Collection', 'Predicate'; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.any(Collection, Predicate)"})
  void testAnyWithCollectionPredicate_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PredicateUtilities.any(new ArrayList<>(), mock(Predicate.class)));
  }

  /**
   * Test {@link PredicateUtilities#any(Object[], Predicate)} with {@code Object[]}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When array of {@link Object} with {@code Ts}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#any(Object[], Predicate)}
   */
  @Test
  @DisplayName(
      "Test any(Object[], Predicate) with 'Object[]', 'Predicate'; given 'true'; when array of Object with 'Ts'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.any(Object[], Predicate)"})
  void testAnyWithObjectPredicate_givenTrue_whenArrayOfObjectWithTs_thenReturnTrue() {
    // Arrange
    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualAnyResult = PredicateUtilities.any(new Object[] {"Ts"}, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertTrue(actualAnyResult);
  }

  /**
   * Test {@link PredicateUtilities#any(Object[], Predicate)} with {@code Object[]}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>When {@link Predicate}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#any(Object[], Predicate)}
   */
  @Test
  @DisplayName(
      "Test any(Object[], Predicate) with 'Object[]', 'Predicate'; when Predicate; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.any(Object[], Predicate)"})
  void testAnyWithObjectPredicate_whenPredicate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PredicateUtilities.any(new Object[] {}, mock(Predicate.class)));
  }

  /**
   * Test {@link PredicateUtilities#none(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#none(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test none(Collection, Predicate) with 'Collection', 'Predicate'; given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.none(Collection, Predicate)"})
  void testNoneWithCollectionPredicate_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualNoneResult = PredicateUtilities.none(ts, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertFalse(actualNoneResult);
  }

  /**
   * Test {@link PredicateUtilities#none(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#none(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test none(Collection, Predicate) with 'Collection', 'Predicate'; given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.none(Collection, Predicate)"})
  void testNoneWithCollectionPredicate_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualNoneResult = PredicateUtilities.none(ts, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertFalse(actualNoneResult);
  }

  /**
   * Test {@link PredicateUtilities#none(Collection, Predicate)} with {@code Collection}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#none(Collection, Predicate)}
   */
  @Test
  @DisplayName(
      "Test none(Collection, Predicate) with 'Collection', 'Predicate'; when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.none(Collection, Predicate)"})
  void testNoneWithCollectionPredicate_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PredicateUtilities.none(new ArrayList<>(), mock(Predicate.class)));
  }

  /**
   * Test {@link PredicateUtilities#none(Object[], Predicate)} with {@code Object[]}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When array of {@link Object} with {@code Ts}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#none(Object[], Predicate)}
   */
  @Test
  @DisplayName(
      "Test none(Object[], Predicate) with 'Object[]', 'Predicate'; given 'true'; when array of Object with 'Ts'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.none(Object[], Predicate)"})
  void testNoneWithObjectPredicate_givenTrue_whenArrayOfObjectWithTs_thenReturnFalse() {
    // Arrange
    Predicate<Object> p = mock(Predicate.class);
    when(p.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualNoneResult = PredicateUtilities.none(new Object[] {"Ts"}, p);

    // Assert
    verify(p).test(isA(Object.class));
    assertFalse(actualNoneResult);
  }

  /**
   * Test {@link PredicateUtilities#none(Object[], Predicate)} with {@code Object[]}, {@code
   * Predicate}.
   *
   * <ul>
   *   <li>When {@link Predicate}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateUtilities#none(Object[], Predicate)}
   */
  @Test
  @DisplayName(
      "Test none(Object[], Predicate) with 'Object[]', 'Predicate'; when Predicate; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateUtilities.none(Object[], Predicate)"})
  void testNoneWithObjectPredicate_whenPredicate_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PredicateUtilities.none(new Object[] {}, mock(Predicate.class)));
  }
}
