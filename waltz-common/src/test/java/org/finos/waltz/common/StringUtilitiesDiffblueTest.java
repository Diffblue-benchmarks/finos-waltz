package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.function.Function;
import org.jooq.lambda.tuple.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StringUtilitiesDiffblueTest {
  /**
   * Test {@link StringUtilities#isEmpty(Optional)} with {@code maybeString}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isEmpty(Optional)}
   */
  @Test
  @DisplayName("Test isEmpty(Optional) with 'maybeString'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(Optional)"})
  void testIsEmptyWithMaybeString_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isEmpty((Optional<String>) null));
  }

  /**
   * Test {@link StringUtilities#isEmpty(Optional)} with {@code maybeString}.
   *
   * <ul>
   *   <li>When of {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isEmpty(Optional)}
   */
  @Test
  @DisplayName("Test isEmpty(Optional) with 'maybeString'; when of '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(Optional)"})
  void testIsEmptyWithMaybeString_whenOf42_thenReturnFalse() {
    // Arrange
    Optional<String> maybeString = Optional.of("42");

    // Act and Assert
    assertFalse(StringUtilities.isEmpty(maybeString));
  }

  /**
   * Test {@link StringUtilities#isEmpty(Optional)} with {@code maybeString}.
   *
   * <ul>
   *   <li>When of empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isEmpty(Optional)}
   */
  @Test
  @DisplayName(
      "Test isEmpty(Optional) with 'maybeString'; when of empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(Optional)"})
  void testIsEmptyWithMaybeString_whenOfEmptyString_thenReturnTrue() {
    // Arrange
    Optional<String> maybeString = Optional.of("");

    // Act and Assert
    assertTrue(StringUtilities.isEmpty(maybeString));
  }

  /**
   * Test {@link StringUtilities#isEmpty(String)} with {@code x}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String) with 'x'; when empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(String)"})
  void testIsEmptyWithX_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isEmpty(""));
  }

  /**
   * Test {@link StringUtilities#isEmpty(String)} with {@code x}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String) with 'x'; when 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(String)"})
  void testIsEmptyWithX_whenFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isEmpty("foo"));
  }

  /**
   * Test {@link StringUtilities#isEmpty(String)} with {@code x}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String) with 'x'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(String)"})
  void testIsEmptyWithX_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isEmpty((String) null));
  }

  /**
   * Test {@link StringUtilities#notEmpty(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#notEmpty(String)}
   */
  @Test
  @DisplayName("Test notEmpty(String); when empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.notEmpty(String)"})
  void testNotEmpty_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.notEmpty(""));
  }

  /**
   * Test {@link StringUtilities#notEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#notEmpty(String)}
   */
  @Test
  @DisplayName("Test notEmpty(String); when 'foo'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.notEmpty(String)"})
  void testNotEmpty_whenFoo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.notEmpty("foo"));
  }

  /**
   * Test {@link StringUtilities#notEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#notEmpty(String)}
   */
  @Test
  @DisplayName("Test notEmpty(String); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.notEmpty(String)"})
  void testNotEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.notEmpty(null));
  }

  /**
   * Test {@link StringUtilities#ifEmpty(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#ifEmpty(String, String)}
   */
  @Test
  @DisplayName("Test ifEmpty(String, String); when empty string; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.ifEmpty(String, String)"})
  void testIfEmpty_whenEmptyString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.ifEmpty("", "42"));
  }

  /**
   * Test {@link StringUtilities#ifEmpty(String, String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#ifEmpty(String, String)}
   */
  @Test
  @DisplayName("Test ifEmpty(String, String); when 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.ifEmpty(String, String)"})
  void testIfEmpty_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", StringUtilities.ifEmpty("foo", "42"));
  }

  /**
   * Test {@link StringUtilities#ifEmpty(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#ifEmpty(String, String)}
   */
  @Test
  @DisplayName("Test ifEmpty(String, String); when 'null'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.ifEmpty(String, String)"})
  void testIfEmpty_whenNull_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.ifEmpty(null, "42"));
  }

  /**
   * Test {@link StringUtilities#parseLong(String, Long)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#parseLong(String, Long)}
   */
  @Test
  @DisplayName("Test parseLong(String, Long); when '42'; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long StringUtilities.parseLong(String, Long)"})
  void testParseLong_when42_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, StringUtilities.parseLong("42", 1L).longValue());
  }

  /**
   * Test {@link StringUtilities#parseLong(String, Long)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#parseLong(String, Long)}
   */
  @Test
  @DisplayName("Test parseLong(String, Long); when 'Value'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long StringUtilities.parseLong(String, Long)"})
  void testParseLong_whenValue_thenReturnLongValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1L, StringUtilities.parseLong("Value", 1L).longValue());
  }

  /**
   * Test {@link StringUtilities#parseInteger(String, Integer)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is {@link Columns#AQ}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#parseInteger(String, Integer)}
   */
  @Test
  @DisplayName("Test parseInteger(String, Integer); when '42'; then return intValue is AQ")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer StringUtilities.parseInteger(String, Integer)"})
  void testParseInteger_when42_thenReturnIntValueIsAq() {
    // Arrange, Act and Assert
    assertEquals(Columns.AQ, StringUtilities.parseInteger("42", 1).intValue());
  }

  /**
   * Test {@link StringUtilities#parseInteger(String, Integer)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#parseInteger(String, Integer)}
   */
  @Test
  @DisplayName("Test parseInteger(String, Integer); when 'Value'; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer StringUtilities.parseInteger(String, Integer)"})
  void testParseInteger_whenValue_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, StringUtilities.parseInteger("Value", 1).intValue());
  }

  /**
   * Test {@link StringUtilities#isNumericLong(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  @DisplayName("Test isNumericLong(String); when '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isNumericLong(String)"})
  void testIsNumericLong_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isNumericLong("42"));
  }

  /**
   * Test {@link StringUtilities#isNumericLong(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  @DisplayName("Test isNumericLong(String); when empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isNumericLong(String)"})
  void testIsNumericLong_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isNumericLong(""));
  }

  /**
   * Test {@link StringUtilities#isNumericLong(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  @DisplayName("Test isNumericLong(String); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isNumericLong(String)"})
  void testIsNumericLong_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isNumericLong(null));
  }

  /**
   * Test {@link StringUtilities#isNumericLong(String)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  @DisplayName("Test isNumericLong(String); when 'Value'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isNumericLong(String)"})
  void testIsNumericLong_whenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isNumericLong("Value"));
  }

  /**
   * Test {@link StringUtilities#mkSafe(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkSafe(String)}
   */
  @Test
  @DisplayName("Test mkSafe(String); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkSafe(String)"})
  void testMkSafe_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.mkSafe(null));
  }

  /**
   * Test {@link StringUtilities#mkSafe(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkSafe(String)}
   */
  @Test
  @DisplayName("Test mkSafe(String); when 'Str'; then return 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkSafe(String)"})
  void testMkSafe_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.mkSafe("Str"));
  }

  /**
   * Test {@link StringUtilities#safeTrim(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeTrim(String)}
   */
  @Test
  @DisplayName("Test safeTrim(String); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.safeTrim(String)"})
  void testSafeTrim_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.safeTrim(null));
  }

  /**
   * Test {@link StringUtilities#safeTrim(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeTrim(String)}
   */
  @Test
  @DisplayName("Test safeTrim(String); when 'Str'; then return 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.safeTrim(String)"})
  void testSafeTrim_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.safeTrim("Str"));
  }

  /**
   * Test {@link StringUtilities#limit(String, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#limit(String, int)}
   */
  @Test
  @DisplayName("Test limit(String, int); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.limit(String, int)"})
  void testLimit_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtilities.limit(null, 3));
  }

  /**
   * Test {@link StringUtilities#limit(String, int)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#limit(String, int)}
   */
  @Test
  @DisplayName("Test limit(String, int); when 'Str'; then return 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.limit(String, int)"})
  void testLimit_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.limit("Str", 3));
  }

  /**
   * Test {@link StringUtilities#length(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#length(String)}
   */
  @Test
  @DisplayName("Test length(String); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int StringUtilities.length(String)"})
  void testLength_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, StringUtilities.length(null));
  }

  /**
   * Test {@link StringUtilities#length(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#length(String)}
   */
  @Test
  @DisplayName("Test length(String); when 'Str'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int StringUtilities.length(String)"})
  void testLength_whenStr_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, StringUtilities.length("Str"));
  }

  /**
   * Test {@link StringUtilities#join(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test join(Collection, String); given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.join(Collection, String)"})
  void testJoin_given42_whenArrayListAdd42_thenReturn42() {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");

    // Act and Assert
    assertEquals("42", StringUtilities.join(values, "Separator"));
  }

  /**
   * Test {@link StringUtilities#join(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42Separator42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test join(Collection, String); given '42'; when ArrayList() add '42'; then return '42Separator42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.join(Collection, String)"})
  void testJoin_given42_whenArrayListAdd42_thenReturn42Separator42() {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");
    values.add("42");

    // Act and Assert
    assertEquals("42Separator42", StringUtilities.join(values, "Separator"));
  }

  /**
   * Test {@link StringUtilities#join(Collection, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  @DisplayName("Test join(Collection, String); when ArrayList(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.join(Collection, String)"})
  void testJoin_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.join(new ArrayList<>(), "Separator"));
  }

  /**
   * Test {@link StringUtilities#joinUsing(Collection, Function, String)}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return {@code ApplySeparatorApply}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#joinUsing(Collection, Function, String)}
   */
  @Test
  @DisplayName(
      "Test joinUsing(Collection, Function, String); given 'Apply'; then return 'ApplySeparatorApply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.joinUsing(Collection, Function, String)"})
  void testJoinUsing_givenApply_thenReturnApplySeparatorApply() {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");
    values.add("42");

    Function<Object, String> toStringFn = mock(Function.class);
    when(toStringFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    String actualJoinUsingResult = StringUtilities.joinUsing(values, toStringFn, "Separator");

    // Assert
    verify(toStringFn, atLeast(1)).apply(isA(Object.class));
    assertEquals("ApplySeparatorApply", actualJoinUsingResult);
  }

  /**
   * Test {@link StringUtilities#joinUsing(Collection, Function, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#joinUsing(Collection, Function, String)}
   */
  @Test
  @DisplayName(
      "Test joinUsing(Collection, Function, String); when ArrayList(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.joinUsing(Collection, Function, String)"})
  void testJoinUsing_whenArrayList_thenReturnEmptyString() {
    // Arrange and Act
    String actualJoinUsingResult =
        StringUtilities.joinUsing(new ArrayList<>(), mock(Function.class), "Separator");

    // Assert
    assertEquals("", actualJoinUsingResult);
  }

  /**
   * Test {@link StringUtilities#splitThenMap(String, String, Function)}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  @DisplayName(
      "Test splitThenMap(String, String, Function); given 'Apply'; when Function apply(Object) return 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.splitThenMap(String, String, Function)"})
  void testSplitThenMap_givenApply_whenFunctionApplyReturnApply_thenReturnSizeIsOne() {
    // Arrange
    Function<String, Object> itemTransformer = mock(Function.class);
    when(itemTransformer.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    List<Object> actualSplitThenMapResult =
        StringUtilities.splitThenMap("Str", "Separator", itemTransformer);

    // Assert
    verify(itemTransformer).apply("Str");
    assertEquals(1, actualSplitThenMapResult.size());
    assertEquals("Apply", actualSplitThenMapResult.get(0));
  }

  /**
   * Test {@link StringUtilities#splitThenMap(String, String, Function)}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  @DisplayName("Test splitThenMap(String, String, Function); when Function; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.splitThenMap(String, String, Function)"})
  void testSplitThenMap_whenFunction_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult =
        StringUtilities.splitThenMap("", "", mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#splitThenMap(String, String, Function)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  @DisplayName("Test splitThenMap(String, String, Function); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.splitThenMap(String, String, Function)"})
  void testSplitThenMap_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult =
        StringUtilities.splitThenMap(null, "", mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#splitThenMap(String, String, Function)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  @DisplayName("Test splitThenMap(String, String, Function); when 'Str'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.splitThenMap(String, String, Function)"})
  void testSplitThenMap_whenStr_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult =
        StringUtilities.splitThenMap("Str", "", mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String, String)} with {@code value}, {@code regex}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  @DisplayName("Test tokenise(String, String) with 'value', 'regex'; when '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.tokenise(String, String)"})
  void testTokeniseWithValueRegex_when42_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42", ".*");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String, String)} with {@code value}, {@code regex}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  @DisplayName(
      "Test tokenise(String, String) with 'value', 'regex'; when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.tokenise(String, String)"})
  void testTokeniseWithValueRegex_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("", ".*");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String, String)} with {@code value}, {@code regex}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  @DisplayName(
      "Test tokenise(String, String) with 'value', 'regex'; when empty string; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.tokenise(String, String)"})
  void testTokeniseWithValueRegex_whenEmptyString_thenReturnSizeIsTwo() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42", "");

    // Assert
    assertEquals(2, actualTokeniseResult.size());
    assertEquals("2", actualTokeniseResult.get(1));
    assertEquals("4", actualTokeniseResult.get(0));
  }

  /**
   * Test {@link StringUtilities#tokenise(String, String)} with {@code value}, {@code regex}.
   *
   * <ul>
   *   <li>When {@code value cannot be null}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  @DisplayName(
      "Test tokenise(String, String) with 'value', 'regex'; when 'value cannot be null'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.tokenise(String, String)"})
  void testTokeniseWithValueRegex_whenValueCannotBeNull_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42", "value cannot be null");

    // Assert
    assertEquals(1, actualTokeniseResult.size());
    assertEquals("42", actualTokeniseResult.get(0));
  }

  /**
   * Test {@link StringUtilities#tokenise(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  @DisplayName("Test tokenise(String) with 'value'; when '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.tokenise(String)"})
  void testTokeniseWithValue_when42_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42");

    // Assert
    assertEquals(1, actualTokeniseResult.size());
    assertEquals("42", actualTokeniseResult.get(0));
  }

  /**
   * Test {@link StringUtilities#tokenise(String)} with {@code value}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  @DisplayName("Test tokenise(String) with 'value'; when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.tokenise(String)"})
  void testTokeniseWithValue_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code foo bar}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  @DisplayName("Test tokenise(String) with 'value'; when 'foo bar'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.tokenise(String)"})
  void testTokeniseWithValue_whenFooBar_thenReturnSizeIsTwo() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("foo bar");

    // Assert
    assertEquals(2, actualTokeniseResult.size());
    assertEquals("bar", actualTokeniseResult.get(1));
    assertEquals("foo", actualTokeniseResult.get(0));
  }

  /**
   * Test {@link StringUtilities#tokenise(String)} with {@code value}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  @DisplayName("Test tokenise(String) with 'value'; when space; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StringUtilities.tokenise(String)"})
  void testTokeniseWithValue_whenSpace_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise(" ");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#lower(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#lower(String)}
   */
  @Test
  @DisplayName("Test lower(String); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.lower(String)"})
  void testLower_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.lower("42"));
  }

  /**
   * Test {@link StringUtilities#upper(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#upper(String)}
   */
  @Test
  @DisplayName("Test upper(String); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.upper(String)"})
  void testUpper_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.upper("42"));
  }

  /**
   * Test {@link StringUtilities#firstChar(String, char)} with {@code str}, {@code dflt}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#firstChar(String, char)}
   */
  @Test
  @DisplayName("Test firstChar(String, char) with 'str', 'dflt'; when 'null'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char StringUtilities.firstChar(String, char)"})
  void testFirstCharWithStrDflt_whenNull_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', StringUtilities.firstChar(null, 'A'));
  }

  /**
   * Test {@link StringUtilities#firstChar(String, char)} with {@code str}, {@code dflt}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#firstChar(String, char)}
   */
  @Test
  @DisplayName("Test firstChar(String, char) with 'str', 'dflt'; when 'Str'; then return 'S'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char StringUtilities.firstChar(String, char)"})
  void testFirstCharWithStrDflt_whenStr_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals('S', StringUtilities.firstChar("Str", 'A'));
  }

  /**
   * Test {@link StringUtilities#firstChar(String)} with {@code str}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#firstChar(String)}
   */
  @Test
  @DisplayName("Test firstChar(String) with 'str'; when 'null'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.firstChar(String)"})
  void testFirstCharWithStr_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Character> actualFirstCharResult = StringUtilities.firstChar(null);

    // Assert
    assertFalse(actualFirstCharResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#firstChar(String)} with {@code str}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@link Optional#get()} charValue is {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#firstChar(String)}
   */
  @Test
  @DisplayName("Test firstChar(String) with 'str'; when 'Str'; then return get() charValue is 'S'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.firstChar(String)"})
  void testFirstCharWithStr_whenStr_thenReturnGetCharValueIsS() {
    // Arrange and Act
    Optional<Character> actualFirstCharResult = StringUtilities.firstChar("Str");

    // Assert
    assertEquals('S', actualFirstCharResult.get().charValue());
    assertTrue(actualFirstCharResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#toOptional(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  @DisplayName("Test toOptional(String); when empty string; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.toOptional(String)"})
  void testToOptional_whenEmptyString_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualToOptionalResult = StringUtilities.toOptional("");

    // Assert
    assertFalse(actualToOptionalResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#toOptional(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  @DisplayName("Test toOptional(String); when 'null'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.toOptional(String)"})
  void testToOptional_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualToOptionalResult = StringUtilities.toOptional(null);

    // Assert
    assertFalse(actualToOptionalResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#toOptional(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@link Optional#get()} is {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  @DisplayName("Test toOptional(String); when 'Str'; then return get() is 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.toOptional(String)"})
  void testToOptional_whenStr_thenReturnGetIsStr() {
    // Arrange and Act
    Optional<String> actualToOptionalResult = StringUtilities.toOptional("Str");

    // Assert
    assertEquals("Str", actualToOptionalResult.get());
    assertTrue(actualToOptionalResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path",
            "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Predicate must be provided", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        "Predicate must be provided/Cannot convert empty or null segments to path/",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/",
            "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/Cannot convert empty or null segments to path",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath4() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", "Predicate must be provided");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/Predicate must be provided",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath5() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "Predicate must be provided", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Predicate must be provided/",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath6() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path",
            "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/+",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath7() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Predicate must be provided", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        "Predicate must be provided/Cannot convert empty or null segments to path/+",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath8() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "Predicate must be provided", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/Predicate must be provided/Cannot convert empty or null segments to path",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath9() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path",
            "/",
            "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Cannot convert empty or null segments to path",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath10() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", "Predicate must be provided");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Predicate must be provided",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code 42/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '42/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturn42CannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("42/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code 42/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '42/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturn42CannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("42/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Array must be provided/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Array must be provided", "Array must be provided", "/");

    // Assert
    assertEquals("Array must be provided/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Array must be provided/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Array must be provided", "Array must be provided");

    // Assert
    assertEquals("/Array must be provided/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Array must be provided", ": Array was null", "/");

    // Assert
    assertEquals("Array must be provided/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Array must be provided", ": Array was null");

    // Assert
    assertEquals("/Array must be provided/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/Cannot convert empty or null segments to
   *       path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Array must be provided/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Array must be provided", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        "Array must be provided/Cannot convert empty or null segments to path/",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/Cannot convert empty or null segments to
   *       path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Array must be provided/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Array must be provided", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        "Array must be provided/Cannot convert empty or null segments to path/+",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/Cannot convert empty or null segments to
   *       path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Array must be provided/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "Array must be provided", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/Array must be provided/Cannot convert empty or null segments to path",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Array must be provided/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Array must be provided", "Predicate must be provided", "/");

    // Assert
    assertEquals("Array must be provided/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Array must be provided/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Array must be provided", "Predicate must be provided");

    // Assert
    assertEquals("/Array must be provided/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Array must be provided", ": Predicate was null", "/");

    // Assert
    assertEquals("Array must be provided/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Array must be provided", ": Predicate was null");

    // Assert
    assertEquals("/Array must be provided/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Array must be provided", "</th></tr></thead>", "/");

    // Assert
    assertEquals("Array must be provided/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedThTrThead2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Array must be provided", "</th></tr></thead>");

    // Assert
    assertEquals("/Array must be provided/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Array was null", "Array must be provided", "/");

    // Assert
    assertEquals(": Array was null/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Array was null/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            ": Array was null", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        ": Array was null/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Array was null/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            ": Array was null", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        ": Array was null/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Array was null/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/: Array was null/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", ": Array was null", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/: Array was null/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Array was null", "Predicate must be provided", "/");

    // Assert
    assertEquals(": Array was null/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Array was null/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Array was null/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Array was null", "Predicate must be provided");

    // Assert
    assertEquals("/: Array was null/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Array was null", ": Predicate was null", "/");

    // Assert
    assertEquals(": Array was null/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals(
        "/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("/+/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath4() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath5() {
    // Arrange, Act and Assert
    assertEquals(
        "Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath6() {
    // Arrange, Act and Assert
    assertEquals(
        "Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath7() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath8() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/+", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath9() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("/+/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath10() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "/+", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/+/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath11() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/", "/+");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath42() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "42");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath422() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "42", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath423() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/", "42");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/Array must be
   *       provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", "Array must be provided");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/Array must be provided",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Array must be
   *       provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "Array must be provided", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Array must be provided/",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", "Array must be provided");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Array must be
   *       provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Array must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided4() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "Array must be provided", "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Array must be provided/+",
        actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", ": Array was null");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", ": Array was null", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", ": Array was null");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Array was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Array was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull4() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", ": Array was null", "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Array was null/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/java.lang.Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/java.lang.Boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathJavaLangBoolean() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", "java.lang.Boolean");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/java.lang.Boolean", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/java.lang.Boolean/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/java.lang.Boolean/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathJavaLangBoolean2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "java.lang.Boolean", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/java.lang.Boolean/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", ": Predicate was null");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", ": Predicate was null", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", ": Predicate was null");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Predicate was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Predicate was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull4() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", ": Predicate was null", "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Predicate was null/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Segs");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "Segs", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/", "Segs");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", "</th></tr></thead>");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathThTrThead2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "</th></tr></thead>", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathThTrThead3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", "</th></tr></thead>");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("java.lang.Boolean", "Array must be provided", "/");

    // Assert
    assertEquals("java.lang.Boolean/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("java.lang.Boolean", ": Array was null", "/");

    // Assert
    assertEquals("java.lang.Boolean/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'java.lang.Boolean/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "java.lang.Boolean", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        "java.lang.Boolean/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/java.lang.Boolean/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/java.lang.Boolean/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanJavaLangBoolean() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("java.lang.Boolean", "java.lang.Boolean", "/");

    // Assert
    assertEquals("java.lang.Boolean/java.lang.Boolean/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("java.lang.Boolean", "Predicate must be provided", "/");

    // Assert
    assertEquals("java.lang.Boolean/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("java.lang.Boolean", ": Predicate was null", "/");

    // Assert
    assertEquals("java.lang.Boolean/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(
        "Predicate must be provided/+", StringUtilities.mkPath("Predicate must be provided", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Predicate must be provided", "/+", "/");

    // Assert
    assertEquals("Predicate must be provided/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided3() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", "Predicate must be provided", "/");

    // Assert
    assertEquals("/+/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Predicate must be provided", "42");

    // Assert
    assertEquals("/Predicate must be provided/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Predicate must be provided/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Predicate must be provided", "Array must be provided", "/");

    // Assert
    assertEquals("Predicate must be provided/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Predicate must be provided/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Predicate must be provided", "Array must be provided");

    // Assert
    assertEquals("/Predicate must be provided/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Predicate must be provided", ": Array was null", "/");

    // Assert
    assertEquals("Predicate must be provided/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Predicate must be provided", ": Array was null");

    // Assert
    assertEquals("/Predicate must be provided/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Predicate must be provided/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Predicate must be provided", "Predicate must be provided", "/");

    // Assert
    assertEquals("Predicate must be provided/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Predicate must be provided/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Predicate must be provided", "Predicate must be provided");

    // Assert
    assertEquals("/Predicate must be provided/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Predicate must be provided/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Predicate must be provided", ": Predicate was null", "/");

    // Assert
    assertEquals("Predicate must be provided/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Predicate must be provided/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Predicate must be provided", ": Predicate was null");

    // Assert
    assertEquals("/Predicate must be provided/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Predicate must be provided", "Segs", "/");

    // Assert
    assertEquals("Predicate must be provided/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedSegs2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Predicate must be provided", "Segs");

    // Assert
    assertEquals("/Predicate must be provided/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Predicate must be provided/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Predicate must be provided", "</th></tr></thead>", "/");

    // Assert
    assertEquals("Predicate must be provided/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Predicate must be provided/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedThTrThead2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Predicate must be provided", "</th></tr></thead>");

    // Assert
    assertEquals("/Predicate must be provided/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Predicate was null", "Array must be provided", "/");

    // Assert
    assertEquals(": Predicate was null/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Predicate was null", "Array must be provided");

    // Assert
    assertEquals("/: Predicate was null/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Predicate was null", ": Array was null", "/");

    // Assert
    assertEquals(": Predicate was null/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Predicate was null/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            ": Predicate was null", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        ": Predicate was null/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Predicate was null/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            ": Predicate was null", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        ": Predicate was null/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/: Predicate was null/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", ": Predicate was null", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/: Predicate was null/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Predicate was null/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Predicate was null", "Predicate must be provided", "/");

    // Assert
    assertEquals(": Predicate was null/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/: Predicate was null/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Predicate was null", "Predicate must be provided");

    // Assert
    assertEquals("/: Predicate was null/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Predicate was null", ": Predicate was null", "/");

    // Assert
    assertEquals(": Predicate was null/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Predicate was null/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Predicate was null", ": Predicate was null");

    // Assert
    assertEquals("/: Predicate was null/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Segs/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Segs/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("Segs/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Segs/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Segs/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("Segs/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Segs/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Segs/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", "Predicate must be provided", "/");

    // Assert
    assertEquals("Segs/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSlashPlusSignSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+/+", StringUtilities.mkPath("/+", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSlashPlusSignSlashPlusSignSlash() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", "/+", "/");

    // Assert
    assertEquals("/+/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code </th> </tr> </thead>/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '</th></tr></thead>/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("</th></tr></thead>", "Array must be provided", "/");

    // Assert
    assertEquals("</th></tr></thead>/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code </th> </tr> </thead>/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '</th></tr></thead>/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "</th></tr></thead>", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        "</th></tr></thead>/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /</th> </tr> </thead>/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/</th></tr></thead>/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "/", "</th></tr></thead>", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/</th></tr></thead>/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code </th> </tr> </thead>/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '</th></tr></thead>/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(
            "</th></tr></thead>", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        "</th></tr></thead>/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code </th> </tr> </thead>/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '</th></tr></thead>/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("</th></tr></thead>", "Predicate must be provided", "/");

    // Assert
    assertEquals("</th></tr></thead>/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code 42}.
   *   <li>Then return {@code 42/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '42'; then return '42/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42And42_thenReturn4242() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", "42", "/");

    // Assert
    assertEquals("42/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code Array must be provided}.
   *   <li>Then return {@code 42/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and 'Array must be provided'; then return '42/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndArrayMustBeProvided_thenReturn42ArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", "Array must be provided", "/");

    // Assert
    assertEquals("42/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code : Array was null}.
   *   <li>Then return {@code 42/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and ': Array was null'; then return '42/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndArrayWasNull_thenReturn42ArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", ": Array was null", "/");

    // Assert
    assertEquals("42/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code Predicate must be provided}.
   *   <li>Then return {@code 42/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and 'Predicate must be provided'; then return '42/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndPredicateMustBeProvided_thenReturn42PredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", "Predicate must be provided", "/");

    // Assert
    assertEquals("42/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code : Predicate was null}.
   *   <li>Then return {@code 42/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and ': Predicate was null'; then return '42/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndPredicateWasNull_thenReturn42PredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", ": Predicate was null", "/");

    // Assert
    assertEquals("42/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code Segs}.
   *   <li>Then return {@code 42/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'Segs'; then return '42/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSegs_thenReturn42Segs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", "Segs", "/");

    // Assert
    assertEquals("42/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code /+}.
   *   <li>Then return {@code 42/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/+'; then return '42/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlashPlusSign_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42/+", StringUtilities.mkPath("42", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code /+}.
   *   <li>Then return {@code 42/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/+'; then return '42/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlashPlusSign_thenReturn422() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", "/+", "/");

    // Assert
    assertEquals("42/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code /}.
   *   <li>Then return {@code 42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/'; then return '42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42/", StringUtilities.mkPath("42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code /}.
   *   <li>Then return {@code 42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/'; then return '42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlash_thenReturn422() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", "/", "/");

    // Assert
    assertEquals("42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code 42/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and '</th></tr></thead>'; then return '42/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndThTrThead_thenReturn42ThTrThead() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("42", "</th></tr></thead>", "/");

    // Assert
    assertEquals("42/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code 42}.
   *   <li>Then return {@code Array must be provided/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '42'; then return 'Array must be provided/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAnd42_thenReturnArrayMustBeProvided42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Array must be provided", "42", "/");

    // Assert
    assertEquals("Array must be provided/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code Segs}.
   *   <li>Then return {@code Array must be provided/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and 'Segs'; then return 'Array must be provided/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSegs_thenReturnArrayMustBeProvidedSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Array must be provided", "Segs", "/");

    // Assert
    assertEquals("Array must be provided/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /+}.
   *   <li>Then return {@code Array must be provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '/+'; then return 'Array must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlashPlusSign_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(
        "Array must be provided/+", StringUtilities.mkPath("Array must be provided", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /+}.
   *   <li>Then return {@code Array must be provided/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '/+'; then return 'Array must be provided/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlashPlusSign_thenReturnArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Array must be provided", "/+", "/");

    // Assert
    assertEquals("Array must be provided/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /}.
   *   <li>Then return {@code Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '/'; then return 'Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlash_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/", StringUtilities.mkPath("Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /}.
   *   <li>Then return {@code Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '/'; then return 'Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlash_thenReturnArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Array must be provided", "/", "/");

    // Assert
    assertEquals("Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code 42}.
   *   <li>Then return {@code : Array was null/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '42'; then return ': Array was null/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAnd42_thenReturnArrayWasNull42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Array was null", "42", "/");

    // Assert
    assertEquals(": Array was null/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code : Array was null}.
   *   <li>Then return {@code : Array was null/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and ': Array was null'; then return ': Array was null/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndArrayWasNull_thenReturnArrayWasNullArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Array was null", ": Array was null", "/");

    // Assert
    assertEquals(": Array was null/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code Segs}.
   *   <li>Then return {@code : Array was null/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and 'Segs'; then return ': Array was null/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSegs_thenReturnArrayWasNullSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Array was null", "Segs", "/");

    // Assert
    assertEquals(": Array was null/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code /+}.
   *   <li>Then return {@code : Array was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '/+'; then return ': Array was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlashPlusSign_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/+", StringUtilities.mkPath(": Array was null", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code /+}.
   *   <li>Then return {@code : Array was null/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '/+'; then return ': Array was null/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlashPlusSign_thenReturnArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Array was null", "/+", "/");

    // Assert
    assertEquals(": Array was null/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code /}.
   *   <li>Then return {@code : Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '/'; then return ': Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlash_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/", StringUtilities.mkPath(": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code /}.
   *   <li>Then return {@code : Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '/'; then return ': Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlash_thenReturnArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Array was null", "/", "/");

    // Assert
    assertEquals(": Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code : Array was null/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '</th></tr></thead>'; then return ': Array was null/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndThTrThead_thenReturnArrayWasNullThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Array was null", "</th></tr></thead>", "/");

    // Assert
    assertEquals(": Array was null/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code 42}.
   *   <li>Then return {@code java.lang.Boolean/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'java.lang.Boolean' and '42'; then return 'java.lang.Boolean/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAnd42_thenReturnJavaLangBoolean42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("java.lang.Boolean", "42", "/");

    // Assert
    assertEquals("java.lang.Boolean/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code Segs}.
   *   <li>Then return {@code java.lang.Boolean/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'java.lang.Boolean' and 'Segs'; then return 'java.lang.Boolean/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSegs_thenReturnJavaLangBooleanSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("java.lang.Boolean", "Segs", "/");

    // Assert
    assertEquals("java.lang.Boolean/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code /+}.
   *   <li>Then return {@code java.lang.Boolean/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'java.lang.Boolean' and '/+'; then return 'java.lang.Boolean/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSlashPlusSign_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/+", StringUtilities.mkPath("java.lang.Boolean", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code /}.
   *   <li>Then return {@code java.lang.Boolean/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'java.lang.Boolean' and '/'; then return 'java.lang.Boolean/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSlash_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/", StringUtilities.mkPath("java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code /}.
   *   <li>Then return {@code java.lang.Boolean/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'java.lang.Boolean' and '/'; then return 'java.lang.Boolean/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSlash_thenReturnJavaLangBoolean2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("java.lang.Boolean", "/", "/");

    // Assert
    assertEquals("java.lang.Boolean/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code java.lang.Boolean/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'java.lang.Boolean' and '</th></tr></thead>'; then return 'java.lang.Boolean/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndThTrThead_thenReturnJavaLangBooleanThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("java.lang.Boolean", "</th></tr></thead>", "/");

    // Assert
    assertEquals("java.lang.Boolean/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code 42}.
   *   <li>Then return {@code Predicate must be provided/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Predicate must be provided' and '42'; then return 'Predicate must be provided/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAnd42_thenReturnPredicateMustBeProvided42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Predicate must be provided", "42", "/");

    // Assert
    assertEquals("Predicate must be provided/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code /}.
   *   <li>Then return {@code Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Predicate must be provided' and '/'; then return 'Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAndSlash_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(
        "Predicate must be provided/", StringUtilities.mkPath("Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code /}.
   *   <li>Then return {@code Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Predicate must be provided' and '/'; then return 'Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAndSlash_thenReturnPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Predicate must be provided", "/", "/");

    // Assert
    assertEquals("Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code 42}.
   *   <li>Then return {@code : Predicate was null/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '42'; then return ': Predicate was null/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAnd42_thenReturnPredicateWasNull42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Predicate was null", "42", "/");

    // Assert
    assertEquals(": Predicate was null/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code Segs}.
   *   <li>Then return {@code : Predicate was null/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and 'Segs'; then return ': Predicate was null/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSegs_thenReturnPredicateWasNullSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Predicate was null", "Segs", "/");

    // Assert
    assertEquals(": Predicate was null/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /+}.
   *   <li>Then return {@code : Predicate was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '/+'; then return ': Predicate was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlashPlusSign_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/+", StringUtilities.mkPath(": Predicate was null", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /+}.
   *   <li>Then return {@code : Predicate was null/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '/+'; then return ': Predicate was null/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlashPlusSign_thenReturnPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Predicate was null", "/+", "/");

    // Assert
    assertEquals(": Predicate was null/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /}.
   *   <li>Then return {@code : Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '/'; then return ': Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlash_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/", StringUtilities.mkPath(": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /}.
   *   <li>Then return {@code : Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '/'; then return ': Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlash_thenReturnPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath(": Predicate was null", "/", "/");

    // Assert
    assertEquals(": Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code : Predicate was null/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '</th></tr></thead>'; then return ': Predicate was null/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndThTrThead_thenReturnPredicateWasNullThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath(": Predicate was null", "</th></tr></thead>", "/");

    // Assert
    assertEquals(": Predicate was null/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code 42}.
   *   <li>Then return {@code Segs/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '42'; then return 'Segs/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAnd42_thenReturnSegs42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", "42", "/");

    // Assert
    assertEquals("Segs/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code Array must be provided}.
   *   <li>Then return {@code Segs/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Segs' and 'Array must be provided'; then return 'Segs/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndArrayMustBeProvided_thenReturnSegsArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", "Array must be provided", "/");

    // Assert
    assertEquals("Segs/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code : Array was null}.
   *   <li>Then return {@code Segs/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Segs' and ': Array was null'; then return 'Segs/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndArrayWasNull_thenReturnSegsArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", ": Array was null", "/");

    // Assert
    assertEquals("Segs/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code : Predicate was null}.
   *   <li>Then return {@code Segs/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Segs' and ': Predicate was null'; then return 'Segs/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndPredicateWasNull_thenReturnSegsPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", ": Predicate was null", "/");

    // Assert
    assertEquals("Segs/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code Segs}.
   *   <li>Then return {@code Segs/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'Segs'; then return 'Segs/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSegs_thenReturnSegsSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", "Segs", "/");

    // Assert
    assertEquals("Segs/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code /+}.
   *   <li>Then return {@code Segs/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/+'; then return 'Segs/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlashPlusSign_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/+", StringUtilities.mkPath("Segs", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code /+}.
   *   <li>Then return {@code Segs/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/+'; then return 'Segs/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlashPlusSign_thenReturnSegs2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", "/+", "/");

    // Assert
    assertEquals("Segs/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code /}.
   *   <li>Then return {@code Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/'; then return 'Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlash_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/", StringUtilities.mkPath("Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code /}.
   *   <li>Then return {@code Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/'; then return 'Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlash_thenReturnSegs2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", "/", "/");

    // Assert
    assertEquals("Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code Segs/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Segs' and '</th></tr></thead>'; then return 'Segs/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndThTrThead_thenReturnSegsThTrThead() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("Segs", "</th></tr></thead>", "/");

    // Assert
    assertEquals("Segs/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs}.
   *   <li>Then return {@code Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs'; then return 'Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs", StringUtilities.mkPath("Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/42", StringUtilities.mkPath("/", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", "Array must be provided");

    // Assert
    assertEquals("/42/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", ": Array was null");

    // Assert
    assertEquals("/42/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '42'; then return '/42/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42CannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "42", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/42/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '42'; then return '/42/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42PredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", "Predicate must be provided");

    // Assert
    assertEquals("/42/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42PredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", ": Predicate was null");

    // Assert
    assertEquals("/42/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42Segs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", "Segs");

    // Assert
    assertEquals("/42/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ThTrThead() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", "</th></tr></thead>");

    // Assert
    assertEquals("/42/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn422() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", "/");

    // Assert
    assertEquals("/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn423() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", "/+");

    // Assert
    assertEquals("/42/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn4242() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "42", "42");

    // Assert
    assertEquals("/42/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided", StringUtilities.mkPath("/", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Array must be provided", "/");

    // Assert
    assertEquals("/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided3() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Array must be provided", "/+");

    // Assert
    assertEquals("/Array must be provided/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Array must be provided", "42");

    // Assert
    assertEquals("/Array must be provided/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvidedSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Array must be provided", "Segs");

    // Assert
    assertEquals("/Array must be provided/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null", StringUtilities.mkPath("/", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Array was null", "/");

    // Assert
    assertEquals("/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull3() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Array was null", "/+");

    // Assert
    assertEquals("/: Array was null/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Array was null", "42");

    // Assert
    assertEquals("/: Array was null/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Array was null", "Array must be provided");

    // Assert
    assertEquals("/: Array was null/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Array was null", ": Array was null");

    // Assert
    assertEquals("/: Array was null/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Array was null", ": Predicate was null");

    // Assert
    assertEquals("/: Array was null/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Array was null", "Segs");

    // Assert
    assertEquals("/: Array was null/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Array was null", "</th></tr></thead>");

    // Assert
    assertEquals("/: Array was null/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.
   *   <li>Then return {@code /java.lang.Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean", StringUtilities.mkPath("/", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.
   *   <li>Then return {@code /java.lang.Boolean/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBoolean2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "java.lang.Boolean", "/");

    // Assert
    assertEquals("/java.lang.Boolean/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.
   *   <li>Then return {@code /Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(
        "/Predicate must be provided", StringUtilities.mkPath("/", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.
   *   <li>Then return {@code /Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Predicate must be provided", "/");

    // Assert
    assertEquals("/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.
   *   <li>Then return {@code /Predicate must be provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided3() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Predicate must be provided", "/+");

    // Assert
    assertEquals("/Predicate must be provided/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null", StringUtilities.mkPath("/", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Predicate was null", "/");

    // Assert
    assertEquals("/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull3() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Predicate was null", "/+");

    // Assert
    assertEquals("/: Predicate was null/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Predicate was null", "42");

    // Assert
    assertEquals("/: Predicate was null/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Predicate was null", ": Array was null");

    // Assert
    assertEquals("/: Predicate was null/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", ": Predicate was null", "Segs");

    // Assert
    assertEquals("/: Predicate was null/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", ": Predicate was null", "</th></tr></thead>");

    // Assert
    assertEquals("/: Predicate was null/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/Segs", StringUtilities.mkPath("/", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", "/");

    // Assert
    assertEquals("/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs3() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", "/+");

    // Assert
    assertEquals("/Segs/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", "42");

    // Assert
    assertEquals("/Segs/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", "Array must be provided");

    // Assert
    assertEquals("/Segs/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", ": Array was null");

    // Assert
    assertEquals("/Segs/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "Segs", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/Segs/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", "Predicate must be provided");

    // Assert
    assertEquals("/Segs/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", ": Predicate was null");

    // Assert
    assertEquals("/Segs/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", "Segs");

    // Assert
    assertEquals("/Segs/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsThTrThead() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "Segs", "</th></tr></thead>");

    // Assert
    assertEquals("/Segs/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturn42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", "42");

    // Assert
    assertEquals("/+/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", "Array must be provided");

    // Assert
    assertEquals("/+/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", ": Array was null");

    // Assert
    assertEquals("/+/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '/+'; then return '/+/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", "Predicate must be provided");

    // Assert
    assertEquals("/+/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", ": Predicate was null");

    // Assert
    assertEquals("/+/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", "Segs");

    // Assert
    assertEquals("/+/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+", StringUtilities.mkPath("/", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSignSlash() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", "/");

    // Assert
    assertEquals("/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSignSlashPlusSign() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", "/+");

    // Assert
    assertEquals("/+/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnThTrThead() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/+", "</th></tr></thead>");

    // Assert
    assertEquals("/+/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturn42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", "42");

    // Assert
    assertEquals("/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", "Array must be provided");

    // Assert
    assertEquals("/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", ": Array was null");

    // Assert
    assertEquals("/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '/'; then return '/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "/", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", "Predicate must be provided");

    // Assert
    assertEquals("/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", ": Predicate was null");

    // Assert
    assertEquals("/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", "Segs");

    // Assert
    assertEquals("/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", StringUtilities.mkPath("/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlash2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", "/");

    // Assert
    assertEquals("/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlashPlusSign() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", "/+");

    // Assert
    assertEquals("/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnThTrThead() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "/", "</th></tr></thead>");

    // Assert
    assertEquals("/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>", StringUtilities.mkPath("/", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrThead2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "</th></tr></thead>", "/");

    // Assert
    assertEquals("/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrThead3() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "</th></tr></thead>", "/+");

    // Assert
    assertEquals("/</th></tr></thead>/+", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/42}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrThead42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "</th></tr></thead>", "42");

    // Assert
    assertEquals("/</th></tr></thead>/42", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "</th></tr></thead>", "Array must be provided");

    // Assert
    assertEquals("/</th></tr></thead>/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "</th></tr></thead>", ": Array was null");

    // Assert
    assertEquals("/</th></tr></thead>/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "</th></tr></thead>", "Predicate must be provided");

    // Assert
    assertEquals("/</th></tr></thead>/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "</th></tr></thead>", ": Predicate was null");

    // Assert
    assertEquals("/</th></tr></thead>/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/", "</th></tr></thead>", "Segs");

    // Assert
    assertEquals("/</th></tr></thead>/Segs", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /</th> </tr> </thead>/</th> </tr> </thead>}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/</th></tr></thead>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("/", "</th></tr></thead>", "</th></tr></thead>");

    // Assert
    assertEquals("/</th></tr></thead>/</th></tr></thead>", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code 42}.
   *   <li>Then return {@code /+/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '42'; then return '/+/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAnd42_thenReturn42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", "42", "/");

    // Assert
    assertEquals("/+/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code Array must be provided}.
   *   <li>Then return {@code /+/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/+' and 'Array must be provided'; then return '/+/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndArrayMustBeProvided_thenReturnArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", "Array must be provided", "/");

    // Assert
    assertEquals("/+/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code : Array was null}.
   *   <li>Then return {@code /+/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/+' and ': Array was null'; then return '/+/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndArrayWasNull_thenReturnArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", ": Array was null", "/");

    // Assert
    assertEquals("/+/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code : Predicate was null}.
   *   <li>Then return {@code /+/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/+' and ': Predicate was null'; then return '/+/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndPredicateWasNull_thenReturnPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", ": Predicate was null", "/");

    // Assert
    assertEquals("/+/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code Segs}.
   *   <li>Then return {@code /+/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'Segs'; then return '/+/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSegs_thenReturnSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", "Segs", "/");

    // Assert
    assertEquals("/+/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code /}.
   *   <li>Then return {@code /+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '/'; then return '/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSlash_thenReturnSlashPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("/+/", StringUtilities.mkPath("/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code /}.
   *   <li>Then return {@code /+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '/'; then return '/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSlash_thenReturnSlashPlusSignSlash2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", "/", "/");

    // Assert
    assertEquals("/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code /+/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/+' and '</th></tr></thead>'; then return '/+/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndThTrThead_thenReturnThTrThead() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("/+", "</th></tr></thead>", "/");

    // Assert
    assertEquals("/+/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code 42}.
   *   <li>Then return {@code </th> </tr> </thead>/42/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and '42'; then return '</th></tr></thead>/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAnd42_thenReturnThTrThead42() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("</th></tr></thead>", "42", "/");

    // Assert
    assertEquals("</th></tr></thead>/42/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code : Array was null}.
   *   <li>Then return {@code </th> </tr> </thead>/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and ': Array was null'; then return '</th></tr></thead>/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndArrayWasNull_thenReturnThTrTheadArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("</th></tr></thead>", ": Array was null", "/");

    // Assert
    assertEquals("</th></tr></thead>/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code : Predicate was null}.
   *   <li>Then return {@code </th> </tr> </thead>/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and ': Predicate was null'; then return '</th></tr></thead>/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndPredicateWasNull_thenReturnThTrTheadPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("</th></tr></thead>", ": Predicate was null", "/");

    // Assert
    assertEquals("</th></tr></thead>/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code Segs}.
   *   <li>Then return {@code </th> </tr> </thead>/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and 'Segs'; then return '</th></tr></thead>/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSegs_thenReturnThTrTheadSegs() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("</th></tr></thead>", "Segs", "/");

    // Assert
    assertEquals("</th></tr></thead>/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code /+}.
   *   <li>Then return {@code </th> </tr> </thead>/+}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and '/+'; then return '</th></tr></thead>/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSlashPlusSign_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/+", StringUtilities.mkPath("</th></tr></thead>", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code /+}.
   *   <li>Then return {@code </th> </tr> </thead>/+/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and '/+'; then return '</th></tr></thead>/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSlashPlusSign_thenReturnThTrThead2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("</th></tr></thead>", "/+", "/");

    // Assert
    assertEquals("</th></tr></thead>/+/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code /}.
   *   <li>Then return {@code </th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and '/'; then return '</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSlash_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/", StringUtilities.mkPath("</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code /}.
   *   <li>Then return {@code </th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and '/'; then return '</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSlash_thenReturnThTrThead2() {
    // Arrange and Act
    String actualMkPathResult = StringUtilities.mkPath("</th></tr></thead>", "/", "/");

    // Assert
    assertEquals("</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code </th> </tr> </thead>} and {@code </th> </tr> </thead>}.
   *   <li>Then return {@code </th> </tr> </thead>/</th> </tr> </thead>/}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '</th></tr></thead>' and '</th></tr></thead>'; then return '</th></tr></thead>/</th></tr></thead>/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndThTrThead_thenReturnThTrTheadThTrThead() {
    // Arrange and Act
    String actualMkPathResult =
        StringUtilities.mkPath("</th></tr></thead>", "</th></tr></thead>", "/");

    // Assert
    assertEquals("</th></tr></thead>/</th></tr></thead>/", actualMkPathResult);
  }

  /**
   * Test {@link StringUtilities#capitalise(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  @DisplayName("Test capitalise(String); when empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.capitalise(String)"})
  void testCapitalise_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.capitalise(""));
  }

  /**
   * Test {@link StringUtilities#capitalise(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  @DisplayName("Test capitalise(String); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.capitalise(String)"})
  void testCapitalise_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.capitalise(null));
  }

  /**
   * Test {@link StringUtilities#capitalise(String)}.
   *
   * <ul>
   *   <li>When {@code Words Words}.
   *   <li>Then return {@code Words Words}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  @DisplayName("Test capitalise(String); when 'Words Words'; then return 'Words Words'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.capitalise(String)"})
  void testCapitalise_whenWordsWords_thenReturnWordsWords() {
    // Arrange, Act and Assert
    assertEquals("Words Words", StringUtilities.capitalise("Words Words"));
  }

  /**
   * Test {@link StringUtilities#capitalise(String)}.
   *
   * <ul>
   *   <li>When {@code Words}.
   *   <li>Then return {@code Words}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  @DisplayName("Test capitalise(String); when 'Words'; then return 'Words'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.capitalise(String)"})
  void testCapitalise_whenWords_thenReturnWords() {
    // Arrange, Act and Assert
    assertEquals("Words", StringUtilities.capitalise("Words"));
  }

  /**
   * Test {@link StringUtilities#toMailbox(String, String)}.
   *
   * <p>Method under test: {@link StringUtilities#toMailbox(String, String)}
   */
  @Test
  @DisplayName("Test toMailbox(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.toMailbox(String, String)"})
  void testToMailbox() {
    // Arrange, Act and Assert
    assertEquals(
        "Display Name <jane.doe@example.org>",
        StringUtilities.toMailbox("Display Name", "jane.doe@example.org"));
  }

  /**
   * Test {@link StringUtilities#toHtmlTable(List, Collection)}.
   *
   * <p>Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  @DisplayName("Test toHtmlTable(List, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.toHtmlTable(List, Collection)"})
  void testToHtmlTable() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();

    // Act and Assert
    assertEquals(
        "<table class='table table-condensed small'><thead><tr><th></th></tr></thead><tbody></tbody></table>",
        StringUtilities.toHtmlTable(headers, new ArrayList<>()));
  }

  /**
   * Test {@link StringUtilities#toHtmlTable(List, Collection)}.
   *
   * <p>Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  @DisplayName("Test toHtmlTable(List, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.toHtmlTable(List, Collection)"})
  void testToHtmlTable2() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();
    headers.add("\n");

    // Act and Assert
    assertEquals(
        "<table class='table table-condensed small'><thead><tr><th>\n</th></tr></thead><tbody></tbody></table>",
        StringUtilities.toHtmlTable(headers, new ArrayList<>()));
  }

  /**
   * Test {@link StringUtilities#toHtmlTable(List, Collection)}.
   *
   * <ul>
   *   <li>Given {@code </th> <th>}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code </th> <th>}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  @DisplayName(
      "Test toHtmlTable(List, Collection); given '</th><th>'; when ArrayList() add '</th><th>'; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.toHtmlTable(List, Collection)"})
  void testToHtmlTable_givenThTh_whenArrayListAddThTh_thenReturnAString() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();
    headers.add("</th><th>");
    headers.add("\n");

    // Act and Assert
    assertEquals(
        "<table class='table table-condensed small'><thead><tr><th></th><th></th><th>\n"
            + "</th></tr></thead><tbody></tbody></table>",
        StringUtilities.toHtmlTable(headers, new ArrayList<>()));
  }

  /**
   * Test {@link StringUtilities#toHtmlTable(List, Collection)}.
   *
   * <ul>
   *   <li>Given tuple.
   *   <li>When {@link ArrayList#ArrayList()} add tuple.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  @DisplayName(
      "Test toHtmlTable(List, Collection); given tuple; when ArrayList() add tuple; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.toHtmlTable(List, Collection)"})
  void testToHtmlTable_givenTuple_whenArrayListAddTuple_thenReturnAString() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();

    ArrayList<Tuple> rows = new ArrayList<>();
    rows.add(Tuple.tuple());

    // Act and Assert
    assertEquals(
        "<table class='table table-condensed small'><thead><tr><th></th></tr></thead><tbody><tr><td></td></tr"
            + "></tbody></table>",
        StringUtilities.toHtmlTable(headers, rows));
  }

  /**
   * Test {@link StringUtilities#toHtmlTable(List, Collection)}.
   *
   * <ul>
   *   <li>Given tuple.
   *   <li>When {@link ArrayList#ArrayList()} add tuple.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  @DisplayName(
      "Test toHtmlTable(List, Collection); given tuple; when ArrayList() add tuple; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.toHtmlTable(List, Collection)"})
  void testToHtmlTable_givenTuple_whenArrayListAddTuple_thenReturnAString2() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();

    ArrayList<Tuple> rows = new ArrayList<>();
    rows.add(Tuple.tuple());
    rows.add(Tuple.tuple());

    // Act and Assert
    assertEquals(
        "<table class='table table-condensed small'><thead><tr><th></th></tr></thead><tbody><tr><td></td></tr>"
            + "\n"
            + "<tr><td></td></tr></tbody></table>",
        StringUtilities.toHtmlTable(headers, rows));
  }

  /**
   * Test {@link StringUtilities#nullIfEmpty(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.nullIfEmpty(String)"})
  void testNullIfEmpty_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtilities.nullIfEmpty(""));
  }

  /**
   * Test {@link StringUtilities#nullIfEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.nullIfEmpty(String)"})
  void testNullIfEmpty_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtilities.nullIfEmpty(null));
  }

  /**
   * Test {@link StringUtilities#nullIfEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when 'Str'; then return 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtilities.nullIfEmpty(String)"})
  void testNullIfEmpty_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.nullIfEmpty("Str"));
  }

  /**
   * Test {@link StringUtilities#isDefined(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isDefined(String)}
   */
  @Test
  @DisplayName("Test isDefined(String); when empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isDefined(String)"})
  void testIsDefined_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isDefined(""));
  }

  /**
   * Test {@link StringUtilities#isDefined(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isDefined(String)}
   */
  @Test
  @DisplayName("Test isDefined(String); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isDefined(String)"})
  void testIsDefined_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isDefined(null));
  }

  /**
   * Test {@link StringUtilities#isDefined(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#isDefined(String)}
   */
  @Test
  @DisplayName("Test isDefined(String); when 'Str'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.isDefined(String)"})
  void testIsDefined_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isDefined("Str"));
  }

  /**
   * Test {@link StringUtilities#firstNonNull(String[])}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  @DisplayName("Test firstNonNull(String[]); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.firstNonNull(String[])"})
  void testFirstNonNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull();

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#firstNonNull(String[])}.
   *
   * <ul>
   *   <li>When empty string and {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  @DisplayName("Test firstNonNull(String[]); when empty string and 'null'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.firstNonNull(String[])"})
  void testFirstNonNull_whenEmptyStringAndNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull("", null);

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#firstNonNull(String[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  @DisplayName("Test firstNonNull(String[]); when empty string; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.firstNonNull(String[])"})
  void testFirstNonNull_whenEmptyString_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull("");

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#firstNonNull(String[])}.
   *
   * <ul>
   *   <li>When {@code Xs}.
   *   <li>Then return {@link Optional#get()} is {@code Xs}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  @DisplayName("Test firstNonNull(String[]); when 'Xs'; then return get() is 'Xs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional StringUtilities.firstNonNull(String[])"})
  void testFirstNonNull_whenXs_thenReturnGetIsXs() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull("Xs");

    // Assert
    assertEquals("Xs", actualFirstNonNullResult.get());
    assertTrue(actualFirstNonNullResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#safeEq(String, String)}.
   *
   * <ul>
   *   <li>When {@code Actual}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'Actual'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenActual_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEq(null, "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEq(String, String)}.
   *
   * <ul>
   *   <li>When {@code Expected}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'Expected'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenExpected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEq("Expected", "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEq(String, String)}.
   *
   * <ul>
   *   <li>When {@code Expected}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'Expected'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenExpected_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEq("Expected", null));
  }

  /**
   * Test {@link StringUtilities#safeEq(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.safeEq(null, null));
  }

  /**
   * Test {@link StringUtilities#safeEqIgnoreCase(String, String)}.
   *
   * <ul>
   *   <li>When {@code Actual}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test safeEqIgnoreCase(String, String); when 'Actual'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.safeEqIgnoreCase(String, String)"})
  void testSafeEqIgnoreCase_whenActual_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEqIgnoreCase(null, "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEqIgnoreCase(String, String)}.
   *
   * <ul>
   *   <li>When {@code Expected}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test safeEqIgnoreCase(String, String); when 'Expected'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.safeEqIgnoreCase(String, String)"})
  void testSafeEqIgnoreCase_whenExpected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEqIgnoreCase("Expected", "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEqIgnoreCase(String, String)}.
   *
   * <ul>
   *   <li>When {@code Expected}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test safeEqIgnoreCase(String, String); when 'Expected'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.safeEqIgnoreCase(String, String)"})
  void testSafeEqIgnoreCase_whenExpected_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEqIgnoreCase("Expected", null));
  }

  /**
   * Test {@link StringUtilities#safeEqIgnoreCase(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test safeEqIgnoreCase(String, String); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtilities.safeEqIgnoreCase(String, String)"})
  void testSafeEqIgnoreCase_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.safeEqIgnoreCase(null, null));
  }
}
