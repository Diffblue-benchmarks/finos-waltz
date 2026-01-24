package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChecksDiffblueTest {
  /**
   * Test {@link Checks#checkNotNull(Object, String, Object[])}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotNull(Object, String, Object[])}
   */
  @Test
  @DisplayName("Test checkNotNull(Object, String, Object[]); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Checks.checkNotNull(Object, String, Object[])"})
  void testCheckNotNull_when42_thenReturn42() {
    // Arrange and Act
    Object actualCheckNotNullResult =
        Checks.checkNotNull("42", "Not all who wander are lost", "Args");

    // Assert
    assertEquals("42", actualCheckNotNullResult);
  }

  /**
   * Test {@link Checks#checkNotNull(Object, String, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotNull(Object, String, Object[])}
   */
  @Test
  @DisplayName(
      "Test checkNotNull(Object, String, Object[]); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Checks.checkNotNull(Object, String, Object[])"})
  void testCheckNotNull_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkNotNull(null, "Not all who wander are lost", "Args"));
  }

  /**
   * Test {@link Checks#checkAll(Collection, Predicate, String)} with {@code Collection}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Collection, Predicate, String) with 'Collection', 'Predicate', 'String'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Checks.checkAll(Collection, Predicate, String)"})
  void testCheckAllWithCollectionPredicateString_givenFalse() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkAll(ts, check, "Not all who wander are lost"));
    verify(check).test(isA(Object.class));
  }

  /**
   * Test {@link Checks#checkAll(Collection, Predicate, String)} with {@code Collection}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Collection, Predicate, String) with 'Collection', 'Predicate', 'String'; given 'true'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Checks.checkAll(Collection, Predicate, String)"})
  void testCheckAllWithCollectionPredicateString_givenTrue_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    Collection<Object> actualCheckAllResult =
        Checks.checkAll(ts, check, "Not all who wander are lost");

    // Assert
    verify(check, atLeast(1)).test(isA(Object.class));
    assertTrue(actualCheckAllResult instanceof List);
    assertEquals(2, actualCheckAllResult.size());
    assertEquals("42", ((List<Object>) actualCheckAllResult).get(0));
    assertEquals("42", ((List<Object>) actualCheckAllResult).get(1));
  }

  /**
   * Test {@link Checks#checkAll(Collection, Predicate, String)} with {@code Collection}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Collection, Predicate, String) with 'Collection', 'Predicate', 'String'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Checks.checkAll(Collection, Predicate, String)"})
  void testCheckAllWithCollectionPredicateString_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkAll(new ArrayList<>(), null, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkAll(Collection, Predicate, String)} with {@code Collection}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Collection, Predicate, String) with 'Collection', 'Predicate', 'String'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Checks.checkAll(Collection, Predicate, String)"})
  void testCheckAllWithCollectionPredicateString_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Collection<Object> actualCheckAllResult =
        Checks.checkAll(new ArrayList<>(), mock(Predicate.class), "Not all who wander are lost");

    // Assert
    assertTrue(actualCheckAllResult instanceof List);
    assertTrue(actualCheckAllResult.isEmpty());
  }

  /**
   * Test {@link Checks#checkAll(Collection, Predicate, String)} with {@code Collection}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Collection, Predicate, String) with 'Collection', 'Predicate', 'String'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Checks.checkAll(Collection, Predicate, String)"})
  void testCheckAllWithCollectionPredicateString_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Checks.checkAll(
                (Collection<Object>) null, mock(Predicate.class), "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; given 'false'; when Predicate test(Object) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_givenFalse_whenPredicateTestReturnFalse() {
    // Arrange
    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkAll(new Object[] {"Ts"}, check, "Not all who wander are lost"));
    verify(check).test(isA(Object.class));
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return first element is {@code Ts}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; given 'true'; then return first element is 'Ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_givenTrue_thenReturnFirstElementIsTs() {
    // Arrange
    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    Object[] actualCheckAllResult =
        Checks.checkAll(new Object[] {"Ts"}, check, "Not all who wander are lost");

    // Assert
    verify(check).test(isA(Object.class));
    assertEquals("Ts", actualCheckAllResult[0]);
    assertEquals(1, actualCheckAllResult.length);
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkAll(new Object[] {"Ts"}, null, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code
   * Predicate}, {@code String}.
   *
   * <ul>
   *   <li>When {@link Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName(
      "Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; when Predicate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_whenPredicate() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Checks.checkAll((Object[]) null, mock(Predicate.class), "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkTrue(boolean, String, Object[])}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkTrue(boolean, String, Object[])}
   */
  @Test
  @DisplayName(
      "Test checkTrue(boolean, String, Object[]); when 'false'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkTrue(boolean, String, Object[])"})
  void testCheckTrue_whenFalse_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkTrue(false, "Msg", "Args"));
  }

  /**
   * Test {@link Checks#checkTrue(boolean, String, Object[])}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkTrue(boolean, String, Object[])}
   */
  @Test
  @DisplayName("Test checkTrue(boolean, String, Object[]); when 'true'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkTrue(boolean, String, Object[])"})
  void testCheckTrue_whenTrue_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> Checks.checkTrue(true, "Msg", "Args"));
  }

  /**
   * Test {@link Checks#checkFalse(boolean, String)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkFalse(boolean, String)}
   */
  @Test
  @DisplayName("Test checkFalse(boolean, String); when 'false'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkFalse(boolean, String)"})
  void testCheckFalse_whenFalse_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> Checks.checkFalse(false, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkFalse(boolean, String)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkFalse(boolean, String)}
   */
  @Test
  @DisplayName("Test checkFalse(boolean, String); when 'true'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkFalse(boolean, String)"})
  void testCheckFalse_whenTrue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkFalse(true, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkOptionalIsPresent(Optional, String)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkOptionalIsPresent(Optional, String)}
   */
  @Test
  @DisplayName(
      "Test checkOptionalIsPresent(Optional, String); when empty; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Checks.checkOptionalIsPresent(Optional, String)"})
  void testCheckOptionalIsPresent_whenEmpty_thenThrowIllegalArgumentException() {
    // Arrange
    Optional<Object> optional = Optional.empty();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkOptionalIsPresent(optional, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkOptionalIsPresent(Optional, String)}.
   *
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkOptionalIsPresent(Optional, String)}
   */
  @Test
  @DisplayName(
      "Test checkOptionalIsPresent(Optional, String); when Optional with '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Checks.checkOptionalIsPresent(Optional, String)"})
  void testCheckOptionalIsPresent_whenOptionalWith42_thenReturn42() {
    // Arrange
    Optional<Object> optional = Optional.of("42");

    // Act and Assert
    assertEquals("42", Checks.checkOptionalIsPresent(optional, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Collection, String)} with {@code Collection}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotEmpty(Collection, String) with 'Collection', 'String'; given '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkNotEmpty(Collection, String)"})
  void testCheckNotEmptyWithCollectionString_given42_thenDoesNotThrow() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertDoesNotThrow(() -> Checks.checkNotEmpty(ts, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Collection, String)} with {@code Collection}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotEmpty(Collection, String) with 'Collection', 'String'; given '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkNotEmpty(Collection, String)"})
  void testCheckNotEmptyWithCollectionString_given42_thenDoesNotThrow2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertDoesNotThrow(() -> Checks.checkNotEmpty(ts, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Collection, String)} with {@code Collection}, {@code String}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotEmpty(Collection, String) with 'Collection', 'String'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkNotEmpty(Collection, String)"})
  void testCheckNotEmptyWithCollectionString_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkNotEmpty(new ArrayList<>(), "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Collection, String)} with {@code Collection}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotEmpty(Collection, String) with 'Collection', 'String'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkNotEmpty(Collection, String)"})
  void testCheckNotEmptyWithCollectionString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkNotEmpty((Collection<Object>) null, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Object[], String)} with {@code Object[]}, {@code String}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code Ts}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(Object[], String)}
   */
  @Test
  @DisplayName(
      "Test checkNotEmpty(Object[], String) with 'Object[]', 'String'; when array of Object with 'Ts'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkNotEmpty(Object[], String)"})
  void testCheckNotEmptyWithObjectString_whenArrayOfObjectWithTs_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> Checks.checkNotEmpty(new Object[] {"Ts"}, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Object[], String)} with {@code Object[]}, {@code String}.
   *
   * <ul>
   *   <li>When empty array of {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(Object[], String)}
   */
  @Test
  @DisplayName(
      "Test checkNotEmpty(Object[], String) with 'Object[]', 'String'; when empty array of Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkNotEmpty(Object[], String)"})
  void testCheckNotEmptyWithObjectString_whenEmptyArrayOfObject() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkNotEmpty(new Object[] {}, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Object[], String)} with {@code Object[]}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(Object[], String)}
   */
  @Test
  @DisplayName(
      "Test checkNotEmpty(Object[], String) with 'Object[]', 'String'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkNotEmpty(Object[], String)"})
  void testCheckNotEmptyWithObjectString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkNotEmpty((Object[]) null, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(String, String)}
   */
  @Test
  @DisplayName("Test checkNotEmpty(String, String) with 'String', 'String'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Checks.checkNotEmpty(String, String)"})
  void testCheckNotEmptyWithStringString_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Checks.checkNotEmpty("", "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkNotEmpty(String, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotEmpty(String, String) with 'String', 'String'; when 'Str'; then return 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Checks.checkNotEmpty(String, String)"})
  void testCheckNotEmptyWithStringString_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", Checks.checkNotEmpty("Str", "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#fail(String, Object[])}.
   *
   * <p>Method under test: {@link Checks#fail(String, Object[])}
   */
  @Test
  @DisplayName("Test fail(String, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.fail(String, Object[])"})
  void testFail() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.fail("Msg", "Args"));
  }

  /**
   * Test {@link Checks#mkFail(String, Object[])}.
   *
   * <p>Method under test: {@link Checks#mkFail(String, Object[])}
   */
  @Test
  @DisplayName("Test mkFail(String, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IllegalArgumentException Checks.mkFail(String, Object[])"})
  void testMkFail() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.mkFail("Msg", "Args"));
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, Supplier)} with {@code ts}, {@code messageSupplier}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, Supplier) with 'ts', 'messageSupplier'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, Supplier)"})
  void testCheckEmptyWithTsMessageSupplier_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, messageSupplier));
    verify(messageSupplier).get();
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, Supplier)} with {@code ts}, {@code messageSupplier}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, Supplier) with 'ts', 'messageSupplier'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, Supplier)"})
  void testCheckEmptyWithTsMessageSupplier_given42_whenArrayListAdd422() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, messageSupplier));
    verify(messageSupplier).get();
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, Supplier)} with {@code ts}, {@code messageSupplier}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, Supplier) with 'ts', 'messageSupplier'; given 'Get'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, Supplier)"})
  void testCheckEmptyWithTsMessageSupplier_givenGet_whenArrayList() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");

    // Act
    Checks.checkEmpty(ts, messageSupplier);

    // Assert
    verify(messageSupplier).get();
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, Supplier)} with {@code ts}, {@code messageSupplier}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, Supplier) with 'ts', 'messageSupplier'; given 'Get'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, Supplier)"})
  void testCheckEmptyWithTsMessageSupplier_givenGet_whenNull() {
    // Arrange
    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenReturn("Get");

    // Act
    Checks.checkEmpty(null, messageSupplier);

    // Assert
    verify(messageSupplier).get();
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, Supplier)} with {@code ts}, {@code messageSupplier}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, Supplier) with 'ts', 'messageSupplier'; given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, Supplier)"})
  void testCheckEmptyWithTsMessageSupplier_givenIllegalArgumentException() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    Supplier<String> messageSupplier = mock(Supplier.class);
    when(messageSupplier.get()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, messageSupplier));
    verify(messageSupplier).get();
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, String)} with {@code ts}, {@code message}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, String) with 'ts', 'message'; given '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, String)"})
  void testCheckEmptyWithTsMessage_given42_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Checks.checkEmpty(ts, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, String)} with {@code ts}, {@code message}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, String) with 'ts', 'message'; given '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, String)"})
  void testCheckEmptyWithTsMessage_given42_thenThrowIllegalArgumentException2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Checks.checkEmpty(ts, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, String)} with {@code ts}, {@code message}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, String) with 'ts', 'message'; when ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, String)"})
  void testCheckEmptyWithTsMessage_whenArrayList_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> Checks.checkEmpty(new ArrayList<>(), "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, String)} with {@code ts}, {@code message}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#checkEmpty(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test checkEmpty(Collection, String) with 'ts', 'message'; when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, String)"})
  void testCheckEmptyWithTsMessage_whenNull_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> Checks.checkEmpty(null, "Not all who wander are lost"));
  }
}
