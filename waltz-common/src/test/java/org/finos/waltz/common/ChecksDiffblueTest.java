package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
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
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkNotNull(Object, String, Object[])}
   */
  @Test
  @DisplayName("Test checkNotNull(Object, String, Object[]); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Checks.checkNotNull(Object, String, Object[])"})
  void testCheckNotNull_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", Checks.checkNotNull("42", "Not all who wander are lost", "Args"));
  }

  /**
   * Test {@link Checks#checkNotNull(Object, String, Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkNotNull(Object, String, Object[])}
   */
  @Test
  @DisplayName("Test checkNotNull(Object, String, Object[]); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Checks.checkNotNull(Object, String, Object[])"})
  void testCheckNotNull_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkNotNull(null, "Not all who wander are lost", "Args"));
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code Predicate}, {@code String}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return first element is {@code Ts}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName("Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; given 'true'; then return first element is 'Ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_givenTrue_thenReturnFirstElementIsTs() {
    // Arrange
    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    Object[] actualCheckAllResult = Checks.checkAll(new Object[]{"Ts"}, check, "Not all who wander are lost");

    // Assert
    verify(check).test(isA(Object.class));
    assertEquals("Ts", actualCheckAllResult[0]);
    assertEquals(1, actualCheckAllResult.length);
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code Predicate}, {@code String}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName("Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0,
        Checks.checkAll(new Object[]{}, mock(RangeBand.class)::equals, "Not all who wander are lost").length);
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code Predicate}, {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName("Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll((Object[]) null, null, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code Predicate}, {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName("Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll(new Object[]{"Ts"}, null, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkAll(Object[], Predicate, String)} with {@code Object[]}, {@code Predicate}, {@code String}.
   * <ul>
   *   <li>When {@link RangeBand}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  @DisplayName("Test checkAll(Object[], Predicate, String) with 'Object[]', 'Predicate', 'String'; when RangeBand")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] Checks.checkAll(Object[], Predicate, String)"})
  void testCheckAllWithObjectPredicateString_whenRangeBand() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll(new Object[]{"Ts"}, mock(RangeBand.class)::equals, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkTrue(boolean, String, Object[])}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkTrue(boolean, String, Object[])}
   */
  @Test
  @DisplayName("Test checkTrue(boolean, String, Object[]); when 'false'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.checkTrue(boolean, String, Object[])"})
  void testCheckTrue_whenFalse_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkTrue(false, "Msg", "Args"));
  }

  /**
   * Test {@link Checks#checkFalse(boolean, String)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkFalse(boolean, String)}
   */
  @Test
  @DisplayName("Test checkFalse(boolean, String); when 'true'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.checkFalse(boolean, String)"})
  void testCheckFalse_whenTrue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkFalse(true, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkOptionalIsPresent(Optional, String)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkOptionalIsPresent(Optional, String)}
   */
  @Test
  @DisplayName("Test checkOptionalIsPresent(Optional, String); when empty; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Checks.checkOptionalIsPresent(Optional, String)"})
  void testCheckOptionalIsPresent_whenEmpty_thenThrowIllegalArgumentException() {
    // Arrange
    Optional<Object> optional = Optional.empty();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkOptionalIsPresent(optional, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkOptionalIsPresent(Optional, String)}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkOptionalIsPresent(Optional, String)}
   */
  @Test
  @DisplayName("Test checkOptionalIsPresent(Optional, String); when Optional with '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Checks.checkOptionalIsPresent(Optional, String)"})
  void testCheckOptionalIsPresent_whenOptionalWith42_thenReturn42() {
    // Arrange
    Optional<Object> optional = Optional.of("42");

    // Act and Assert
    assertEquals("42", Checks.checkOptionalIsPresent(optional, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Object[], String)} with {@code Object[]}, {@code String}.
   * <ul>
   *   <li>When empty array of {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkNotEmpty(Object[], String)}
   */
  @Test
  @DisplayName("Test checkNotEmpty(Object[], String) with 'Object[]', 'String'; when empty array of Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.checkNotEmpty(Object[], String)"})
  void testCheckNotEmptyWithObjectString_whenEmptyArrayOfObject() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkNotEmpty(new Object[]{}, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkNotEmpty(Object[], String)} with {@code Object[]}, {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkNotEmpty(Object[], String)}
   */
  @Test
  @DisplayName("Test checkNotEmpty(Object[], String) with 'Object[]', 'String'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.checkNotEmpty(Object[], String)"})
  void testCheckNotEmptyWithObjectString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkNotEmpty((Object[]) null, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#fail(String, Object[])}.
   * <p>
   * Method under test: {@link Checks#fail(String, Object[])}
   */
  @Test
  @DisplayName("Test fail(String, Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.fail(String, Object[])"})
  void testFail() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.fail("Msg", "Args"));
  }

  /**
   * Test {@link Checks#mkFail(String, Object[])}.
   * <p>
   * Method under test: {@link Checks#mkFail(String, Object[])}
   */
  @Test
  @DisplayName("Test mkFail(String, Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IllegalArgumentException Checks.mkFail(String, Object[])"})
  void testMkFail() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.mkFail("Msg", "Args"));
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, Supplier)} with {@code ts}, {@code messageSupplier}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  @DisplayName("Test checkEmpty(Collection, Supplier) with 'ts', 'messageSupplier'; given '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, Supplier)"})
  void testCheckEmptyWithTsMessageSupplier_given42_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, mock(RangeBand.class)::toString));
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, Supplier)} with {@code ts}, {@code messageSupplier}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  @DisplayName("Test checkEmpty(Collection, Supplier) with 'ts', 'messageSupplier'; given '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, Supplier)"})
  void testCheckEmptyWithTsMessageSupplier_given42_thenThrowIllegalArgumentException2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, mock(RangeBand.class)::toString));
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, String)} with {@code ts}, {@code message}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkEmpty(Collection, String)}
   */
  @Test
  @DisplayName("Test checkEmpty(Collection, String) with 'ts', 'message'; given '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, String)"})
  void testCheckEmptyWithTsMessage_given42_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, "Not all who wander are lost"));
  }

  /**
   * Test {@link Checks#checkEmpty(Collection, String)} with {@code ts}, {@code message}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checks#checkEmpty(Collection, String)}
   */
  @Test
  @DisplayName("Test checkEmpty(Collection, String) with 'ts', 'message'; given '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Checks.checkEmpty(Collection, String)"})
  void testCheckEmptyWithTsMessage_given42_thenThrowIllegalArgumentException2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, "Not all who wander are lost"));
  }
}
