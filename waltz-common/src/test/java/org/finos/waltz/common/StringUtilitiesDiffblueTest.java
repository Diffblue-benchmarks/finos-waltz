package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StringUtilitiesDiffblueTest {
  /**
   * Test {@link StringUtilities#isEmpty(Optional)} with {@code maybeString}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isEmpty(Optional)}
   */
  @Test
  @DisplayName("Test isEmpty(Optional) with 'maybeString'; when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(Optional)"})
  void testIsEmptyWithMaybeString_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isEmpty((Optional<String>) null));
  }

  /**
   * Test {@link StringUtilities#isEmpty(Optional)} with {@code maybeString}.
   * <ul>
   *   <li>When {@link Optional} with empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isEmpty(Optional)}
   */
  @Test
  @DisplayName("Test isEmpty(Optional) with 'maybeString'; when Optional with empty string; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(Optional)"})
  void testIsEmptyWithMaybeString_whenOptionalWithEmptyString_thenReturnTrue() {
    // Arrange
    Optional<String> maybeString = Optional.of("");

    // Act and Assert
    assertTrue(StringUtilities.isEmpty(maybeString));
  }

  /**
   * Test {@link StringUtilities#isEmpty(Optional)} with {@code maybeString}.
   * <ul>
   *   <li>When {@link Optional} with {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isEmpty(Optional)}
   */
  @Test
  @DisplayName("Test isEmpty(Optional) with 'maybeString'; when Optional with 'foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(Optional)"})
  void testIsEmptyWithMaybeString_whenOptionalWithFoo_thenReturnFalse() {
    // Arrange
    Optional<String> maybeString = Optional.of("foo");

    // Act and Assert
    assertFalse(StringUtilities.isEmpty(maybeString));
  }

  /**
   * Test {@link StringUtilities#isEmpty(String)} with {@code x}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String) with 'x'; when empty string; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(String)"})
  void testIsEmptyWithX_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isEmpty(""));
  }

  /**
   * Test {@link StringUtilities#isEmpty(String)} with {@code x}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String) with 'x'; when 'foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(String)"})
  void testIsEmptyWithX_whenFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isEmpty("foo"));
  }

  /**
   * Test {@link StringUtilities#isEmpty(String)} with {@code x}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String) with 'x'; when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isEmpty(String)"})
  void testIsEmptyWithX_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isEmpty((String) null));
  }

  /**
   * Test {@link StringUtilities#notEmpty(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#notEmpty(String)}
   */
  @Test
  @DisplayName("Test notEmpty(String); when empty string; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.notEmpty(String)"})
  void testNotEmpty_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.notEmpty(""));
  }

  /**
   * Test {@link StringUtilities#notEmpty(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#notEmpty(String)}
   */
  @Test
  @DisplayName("Test notEmpty(String); when 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.notEmpty(String)"})
  void testNotEmpty_whenFoo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.notEmpty("foo"));
  }

  /**
   * Test {@link StringUtilities#notEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#notEmpty(String)}
   */
  @Test
  @DisplayName("Test notEmpty(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.notEmpty(String)"})
  void testNotEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.notEmpty(null));
  }

  /**
   * Test {@link StringUtilities#ifEmpty(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#ifEmpty(String, String)}
   */
  @Test
  @DisplayName("Test ifEmpty(String, String); when empty string; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.ifEmpty(String, String)"})
  void testIfEmpty_whenEmptyString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.ifEmpty("", "42"));
  }

  /**
   * Test {@link StringUtilities#ifEmpty(String, String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#ifEmpty(String, String)}
   */
  @Test
  @DisplayName("Test ifEmpty(String, String); when 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.ifEmpty(String, String)"})
  void testIfEmpty_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", StringUtilities.ifEmpty("foo", "42"));
  }

  /**
   * Test {@link StringUtilities#ifEmpty(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#ifEmpty(String, String)}
   */
  @Test
  @DisplayName("Test ifEmpty(String, String); when 'null'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.ifEmpty(String, String)"})
  void testIfEmpty_whenNull_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.ifEmpty(null, "42"));
  }

  /**
   * Test {@link StringUtilities#parseLong(String, Long)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#parseLong(String, Long)}
   */
  @Test
  @DisplayName("Test parseLong(String, Long); when '42'; then return longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long StringUtilities.parseLong(String, Long)"})
  void testParseLong_when42_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, StringUtilities.parseLong("42", 1L).longValue());
  }

  /**
   * Test {@link StringUtilities#parseLong(String, Long)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#parseLong(String, Long)}
   */
  @Test
  @DisplayName("Test parseLong(String, Long); when 'Value'; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long StringUtilities.parseLong(String, Long)"})
  void testParseLong_whenValue_thenReturnLongValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1L, StringUtilities.parseLong("Value", 1L).longValue());
  }

  /**
   * Test {@link StringUtilities#parseInteger(String, Integer)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return intValue is {@link Columns#AQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#parseInteger(String, Integer)}
   */
  @Test
  @DisplayName("Test parseInteger(String, Integer); when '42'; then return intValue is AQ")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer StringUtilities.parseInteger(String, Integer)"})
  void testParseInteger_when42_thenReturnIntValueIsAq() {
    // Arrange, Act and Assert
    assertEquals(Columns.AQ, StringUtilities.parseInteger("42", 1).intValue());
  }

  /**
   * Test {@link StringUtilities#parseInteger(String, Integer)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#parseInteger(String, Integer)}
   */
  @Test
  @DisplayName("Test parseInteger(String, Integer); when 'Value'; then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer StringUtilities.parseInteger(String, Integer)"})
  void testParseInteger_whenValue_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, StringUtilities.parseInteger("Value", 1).intValue());
  }

  /**
   * Test {@link StringUtilities#isNumericLong(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  @DisplayName("Test isNumericLong(String); when '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isNumericLong(String)"})
  void testIsNumericLong_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isNumericLong("42"));
  }

  /**
   * Test {@link StringUtilities#isNumericLong(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  @DisplayName("Test isNumericLong(String); when empty string; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isNumericLong(String)"})
  void testIsNumericLong_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isNumericLong(""));
  }

  /**
   * Test {@link StringUtilities#isNumericLong(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  @DisplayName("Test isNumericLong(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isNumericLong(String)"})
  void testIsNumericLong_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isNumericLong(null));
  }

  /**
   * Test {@link StringUtilities#isNumericLong(String)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  @DisplayName("Test isNumericLong(String); when 'Value'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isNumericLong(String)"})
  void testIsNumericLong_whenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isNumericLong("Value"));
  }

  /**
   * Test {@link StringUtilities#mkSafe(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkSafe(String)}
   */
  @Test
  @DisplayName("Test mkSafe(String); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkSafe(String)"})
  void testMkSafe_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.mkSafe(null));
  }

  /**
   * Test {@link StringUtilities#mkSafe(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkSafe(String)}
   */
  @Test
  @DisplayName("Test mkSafe(String); when 'Str'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkSafe(String)"})
  void testMkSafe_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.mkSafe("Str"));
  }

  /**
   * Test {@link StringUtilities#safeTrim(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeTrim(String)}
   */
  @Test
  @DisplayName("Test safeTrim(String); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.safeTrim(String)"})
  void testSafeTrim_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.safeTrim(null));
  }

  /**
   * Test {@link StringUtilities#safeTrim(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeTrim(String)}
   */
  @Test
  @DisplayName("Test safeTrim(String); when 'Str'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.safeTrim(String)"})
  void testSafeTrim_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.safeTrim("Str"));
  }

  /**
   * Test {@link StringUtilities#limit(String, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#limit(String, int)}
   */
  @Test
  @DisplayName("Test limit(String, int); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.limit(String, int)"})
  void testLimit_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtilities.limit(null, 3));
  }

  /**
   * Test {@link StringUtilities#limit(String, int)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#limit(String, int)}
   */
  @Test
  @DisplayName("Test limit(String, int); when 'Str'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.limit(String, int)"})
  void testLimit_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.limit("Str", 3));
  }

  /**
   * Test {@link StringUtilities#length(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#length(String)}
   */
  @Test
  @DisplayName("Test length(String); when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int StringUtilities.length(String)"})
  void testLength_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, StringUtilities.length(null));
  }

  /**
   * Test {@link StringUtilities#length(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#length(String)}
   */
  @Test
  @DisplayName("Test length(String); when 'Str'; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int StringUtilities.length(String)"})
  void testLength_whenStr_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, StringUtilities.length("Str"));
  }

  /**
   * Test {@link StringUtilities#join(Collection, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  @DisplayName("Test join(Collection, String); given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42Separator42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  @DisplayName("Test join(Collection, String); given '42'; when ArrayList() add '42'; then return '42Separator42'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  @DisplayName("Test join(Collection, String); when ArrayList(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.join(Collection, String)"})
  void testJoin_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.join(new ArrayList<>(), "Separator"));
  }

  /**
   * Test {@link StringUtilities#joinUsing(Collection, Function, String)}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>Then return {@code ApplySeparatorApply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#joinUsing(Collection, Function, String)}
   */
  @Test
  @DisplayName("Test joinUsing(Collection, Function, String); given 'Apply'; then return 'ApplySeparatorApply'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code Apply}.</li>
   *   <li>Then return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#joinUsing(Collection, Function, String)}
   */
  @Test
  @DisplayName("Test joinUsing(Collection, Function, String); given 'Apply'; when Function apply(Object) return 'Apply'; then return 'Apply'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.joinUsing(Collection, Function, String)"})
  void testJoinUsing_givenApply_whenFunctionApplyReturnApply_thenReturnApply() {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");
    Function<Object, String> toStringFn = mock(Function.class);
    when(toStringFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    String actualJoinUsingResult = StringUtilities.joinUsing(values, toStringFn, "Separator");

    // Assert
    verify(toStringFn).apply(isA(Object.class));
    assertEquals("Apply", actualJoinUsingResult);
  }

  /**
   * Test {@link StringUtilities#joinUsing(Collection, Function, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#joinUsing(Collection, Function, String)}
   */
  @Test
  @DisplayName("Test joinUsing(Collection, Function, String); when ArrayList(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.joinUsing(Collection, Function, String)"})
  void testJoinUsing_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.joinUsing(new ArrayList<>(), mock(Function.class), "Separator"));
  }

  /**
   * Test {@link StringUtilities#splitThenMap(String, String, Function)}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code Apply}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  @DisplayName("Test splitThenMap(String, String, Function); given 'Apply'; when Function apply(Object) return 'Apply'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.splitThenMap(String, String, Function)"})
  void testSplitThenMap_givenApply_whenFunctionApplyReturnApply_thenReturnSizeIsOne() {
    // Arrange
    Function<String, Object> itemTransformer = mock(Function.class);
    when(itemTransformer.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    List<Object> actualSplitThenMapResult = StringUtilities.splitThenMap("Str", "Separator", itemTransformer);

    // Assert
    verify(itemTransformer).apply(eq("Str"));
    assertEquals(1, actualSplitThenMapResult.size());
    assertEquals("Apply", actualSplitThenMapResult.get(0));
  }

  /**
   * Test {@link StringUtilities#splitThenMap(String, String, Function)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  @DisplayName("Test splitThenMap(String, String, Function); when empty string; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.splitThenMap(String, String, Function)"})
  void testSplitThenMap_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult = StringUtilities.<Object>splitThenMap("", "Separator", mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#splitThenMap(String, String, Function)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  @DisplayName("Test splitThenMap(String, String, Function); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.splitThenMap(String, String, Function)"})
  void testSplitThenMap_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult = StringUtilities.<Object>splitThenMap(null, null, mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#splitThenMap(String, String, Function)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  @DisplayName("Test splitThenMap(String, String, Function); when 'Str'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.splitThenMap(String, String, Function)"})
  void testSplitThenMap_whenStr_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult = StringUtilities.<Object>splitThenMap("Str", null, mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String, String)} with {@code value}, {@code regex}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  @DisplayName("Test tokenise(String, String) with 'value', 'regex'; when '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.tokenise(String, String)"})
  void testTokeniseWithValueRegex_when42_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42", ".*");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String, String)} with {@code value}, {@code regex}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  @DisplayName("Test tokenise(String, String) with 'value', 'regex'; when empty string; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.tokenise(String, String)"})
  void testTokeniseWithValueRegex_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("", ".*");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String, String)} with {@code value}, {@code regex}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  @DisplayName("Test tokenise(String, String) with 'value', 'regex'; when empty string; then return size is two")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code value cannot be null}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  @DisplayName("Test tokenise(String, String) with 'value', 'regex'; when 'value cannot be null'; then return size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  @DisplayName("Test tokenise(String) with 'value'; when '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  @DisplayName("Test tokenise(String) with 'value'; when empty string; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.tokenise(String)"})
  void testTokeniseWithValue_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String)} with {@code value}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  @DisplayName("Test tokenise(String) with 'value'; when space; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.tokenise(String)"})
  void testTokeniseWithValue_whenSpace_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise(" ");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Test {@link StringUtilities#tokenise(String)} with {@code value}.
   * <ul>
   *   <li>When {@code value cannot be null}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  @DisplayName("Test tokenise(String) with 'value'; when 'value cannot be null'; then return size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtilities.tokenise(String)"})
  void testTokeniseWithValue_whenValueCannotBeNull_thenReturnSizeIsFour() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("value cannot be null");

    // Assert
    assertEquals(4, actualTokeniseResult.size());
    assertEquals("be", actualTokeniseResult.get(2));
    assertEquals("cannot", actualTokeniseResult.get(1));
    assertEquals("null", actualTokeniseResult.get(3));
    assertEquals("value", actualTokeniseResult.get(0));
  }

  /**
   * Test {@link StringUtilities#lower(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#lower(String)}
   */
  @Test
  @DisplayName("Test lower(String); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.lower(String)"})
  void testLower_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.lower("42"));
  }

  /**
   * Test {@link StringUtilities#upper(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#upper(String)}
   */
  @Test
  @DisplayName("Test upper(String); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.upper(String)"})
  void testUpper_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.upper("42"));
  }

  /**
   * Test {@link StringUtilities#firstChar(String, char)} with {@code str}, {@code dflt}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#firstChar(String, char)}
   */
  @Test
  @DisplayName("Test firstChar(String, char) with 'str', 'dflt'; when 'null'; then return 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char StringUtilities.firstChar(String, char)"})
  void testFirstCharWithStrDflt_whenNull_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', StringUtilities.firstChar(null, 'A'));
  }

  /**
   * Test {@link StringUtilities#firstChar(String, char)} with {@code str}, {@code dflt}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code S}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#firstChar(String, char)}
   */
  @Test
  @DisplayName("Test firstChar(String, char) with 'str', 'dflt'; when 'Str'; then return 'S'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char StringUtilities.firstChar(String, char)"})
  void testFirstCharWithStrDflt_whenStr_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals('S', StringUtilities.firstChar("Str", 'A'));
  }

  /**
   * Test {@link StringUtilities#firstChar(String)} with {@code str}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#firstChar(String)}
   */
  @Test
  @DisplayName("Test firstChar(String) with 'str'; when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional StringUtilities.firstChar(String)"})
  void testFirstCharWithStr_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Character> actualFirstCharResult = StringUtilities.firstChar(null);

    // Assert
    assertFalse(actualFirstCharResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#firstChar(String)} with {@code str}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@link Optional#get()} charValue is {@code S}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#firstChar(String)}
   */
  @Test
  @DisplayName("Test firstChar(String) with 'str'; when 'Str'; then return get() charValue is 'S'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  @DisplayName("Test toOptional(String); when empty string; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional StringUtilities.toOptional(String)"})
  void testToOptional_whenEmptyString_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualToOptionalResult = StringUtilities.toOptional("");

    // Assert
    assertFalse(actualToOptionalResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#toOptional(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  @DisplayName("Test toOptional(String); when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional StringUtilities.toOptional(String)"})
  void testToOptional_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualToOptionalResult = StringUtilities.toOptional(null);

    // Assert
    assertFalse(actualToOptionalResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#toOptional(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@link Optional#get()} is {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  @DisplayName("Test toOptional(String); when 'Str'; then return get() is 'Str'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath2() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Predicate must be provided", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath3() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath4() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/Predicate must be provided",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath5() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Predicate must be provided/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath6() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath7() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Predicate must be provided", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath8() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Predicate must be provided", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code 42/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '42/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturn42CannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("42/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code 42/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '42/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturn42CannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("42/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Array must be provided/",
        StringUtilities.mkPath("Array must be provided", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/Array must be provided",
        StringUtilities.mkPath("/", "Array must be provided", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/: Array was null/",
        StringUtilities.mkPath("Array must be provided", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/: Array was null",
        StringUtilities.mkPath("/", "Array must be provided", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Array must be provided", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Array must be provided", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Array must be provided", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/java.lang.Boolean/",
        StringUtilities.mkPath("Array must be provided", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedJavaLangBoolean2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/java.lang.Boolean",
        StringUtilities.mkPath("/", "Array must be provided", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Predicate must be provided/",
        StringUtilities.mkPath("Array must be provided", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/Predicate must be provided",
        StringUtilities.mkPath("/", "Array must be provided", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/: Predicate was null/",
        StringUtilities.mkPath("Array must be provided", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/: Predicate was null",
        StringUtilities.mkPath("/", "Array must be provided", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedThTrThead() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/</th></tr></thead>/",
        StringUtilities.mkPath("Array must be provided", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedThTrThead2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/</th></tr></thead>",
        StringUtilities.mkPath("/", "Array must be provided", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Array must be provided/",
        StringUtilities.mkPath(": Array was null", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath(": Array was null", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath(": Array was null", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Array was null/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Array was null/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", ": Array was null", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/java.lang.Boolean/",
        StringUtilities.mkPath(": Array was null", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Predicate must be provided/",
        StringUtilities.mkPath(": Array was null", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Array was null/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Array was null/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/Predicate must be provided",
        StringUtilities.mkPath("/", ": Array was null", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/: Predicate was null/",
        StringUtilities.mkPath(": Array was null", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/+/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath4() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath5() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath6() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath7() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath8() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/+/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath9() {
    // Arrange, Act and Assert
    assertEquals("/+/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath10() {
    // Arrange, Act and Assert
    assertEquals("/+/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "/+", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath42() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/42",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath422() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/42/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/Array must be provided",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Array must be provided/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/: Array was null",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/: Array was null/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/java.lang.Boolean",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathJavaLangBoolean2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/java.lang.Boolean/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathJavaLangString() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/java.lang.String",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "java.lang.String"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/: Predicate was null",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/: Predicate was null/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/Segs",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Segs/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/</th></tr></thead>",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathThTrThead2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/</th></tr></thead>/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/Array must be provided/",
        StringUtilities.mkPath("java.lang.Boolean", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /java.lang.Boolean/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/java.lang.Boolean/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/Array must be provided",
        StringUtilities.mkPath("/", "java.lang.Boolean", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/: Array was null/",
        StringUtilities.mkPath("java.lang.Boolean", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("java.lang.Boolean", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("java.lang.Boolean", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /java.lang.Boolean/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/java.lang.Boolean/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "java.lang.Boolean", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/java.lang.Boolean/",
        StringUtilities.mkPath("java.lang.Boolean", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/Predicate must be provided/",
        StringUtilities.mkPath("java.lang.Boolean", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /java.lang.Boolean/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/java.lang.Boolean/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/Predicate must be provided",
        StringUtilities.mkPath("/", "java.lang.Boolean", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code java.lang.Boolean/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.Boolean/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangBooleanPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/: Predicate was null/",
        StringUtilities.mkPath("java.lang.Boolean", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code String/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'java.lang.String/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnJavaLangStringCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("java.lang.String/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("java.lang.String", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/+", StringUtilities.mkPath("Predicate must be provided", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/+/", StringUtilities.mkPath("Predicate must be provided", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided3() {
    // Arrange, Act and Assert
    assertEquals("/+/Predicate must be provided/", StringUtilities.mkPath("/+", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided42() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/42", StringUtilities.mkPath("/", "Predicate must be provided", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Array must be provided/",
        StringUtilities.mkPath("Predicate must be provided", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/Array must be provided",
        StringUtilities.mkPath("/", "Predicate must be provided", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/: Array was null/",
        StringUtilities.mkPath("Predicate must be provided", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/: Array was null",
        StringUtilities.mkPath("/", "Predicate must be provided", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/java.lang.Boolean/",
        StringUtilities.mkPath("Predicate must be provided", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedJavaLangBoolean2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/java.lang.Boolean",
        StringUtilities.mkPath("/", "Predicate must be provided", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Predicate must be provided/",
        StringUtilities.mkPath("Predicate must be provided", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/Predicate must be provided",
        StringUtilities.mkPath("/", "Predicate must be provided", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/: Predicate was null/",
        StringUtilities.mkPath("Predicate must be provided", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/: Predicate was null",
        StringUtilities.mkPath("/", "Predicate must be provided", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedSegs() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Segs/", StringUtilities.mkPath("Predicate must be provided", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedSegs2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/Segs", StringUtilities.mkPath("/", "Predicate must be provided", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedThTrThead() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/</th></tr></thead>/",
        StringUtilities.mkPath("Predicate must be provided", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedThTrThead2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/</th></tr></thead>",
        StringUtilities.mkPath("/", "Predicate must be provided", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Array must be provided/",
        StringUtilities.mkPath(": Predicate was null", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/Array must be provided",
        StringUtilities.mkPath("/", ": Predicate was null", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/: Array was null/",
        StringUtilities.mkPath(": Predicate was null", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath(": Predicate was null", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath(": Predicate was null", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", ": Predicate was null", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/java.lang.Boolean/",
        StringUtilities.mkPath(": Predicate was null", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullJavaLangBoolean2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/java.lang.Boolean",
        StringUtilities.mkPath("/", ": Predicate was null", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Predicate must be provided/",
        StringUtilities.mkPath(": Predicate was null", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/Predicate must be provided",
        StringUtilities.mkPath("/", ": Predicate was null", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/: Predicate was null/",
        StringUtilities.mkPath(": Predicate was null", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/: Predicate was null",
        StringUtilities.mkPath("/", ": Predicate was null", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Segs/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Segs/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("Segs/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Segs/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Segs/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("Segs/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Segs/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Segs/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Segs/Predicate must be provided/", StringUtilities.mkPath("Segs", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSlashPlusSignSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+/+", StringUtilities.mkPath("/+", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSlashPlusSignSlashPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("/+/+/", StringUtilities.mkPath("/+", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '</th></tr></thead>/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/Array must be provided/",
        StringUtilities.mkPath("</th></tr></thead>", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '</th></tr></thead>/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("</th></tr></thead>", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '</th></tr></thead>/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("</th></tr></thead>", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/</th></tr></thead>/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "</th></tr></thead>", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '</th></tr></thead>/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_thenReturnThTrTheadPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/Predicate must be provided/",
        StringUtilities.mkPath("</th></tr></thead>", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code 42}.</li>
   *   <li>Then return {@code 42/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '42'; then return '42/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42And42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("42/42/", StringUtilities.mkPath("42", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code Array must be provided}.</li>
   *   <li>Then return {@code 42/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'Array must be provided'; then return '42/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndArrayMustBeProvided_thenReturn42ArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("42/Array must be provided/", StringUtilities.mkPath("42", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code : Array was null}.</li>
   *   <li>Then return {@code 42/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and ': Array was null'; then return '42/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndArrayWasNull_thenReturn42ArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("42/: Array was null/", StringUtilities.mkPath("42", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code 42/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'java.lang.Boolean'; then return '42/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndJavaLangBoolean_thenReturn42JavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("42/java.lang.Boolean/", StringUtilities.mkPath("42", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code Predicate must be provided}.</li>
   *   <li>Then return {@code 42/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'Predicate must be provided'; then return '42/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndPredicateMustBeProvided_thenReturn42PredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("42/Predicate must be provided/", StringUtilities.mkPath("42", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code 42/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and ': Predicate was null'; then return '42/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndPredicateWasNull_thenReturn42PredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("42/: Predicate was null/", StringUtilities.mkPath("42", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code Segs}.</li>
   *   <li>Then return {@code 42/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'Segs'; then return '42/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSegs_thenReturn42Segs() {
    // Arrange, Act and Assert
    assertEquals("42/Segs/", StringUtilities.mkPath("42", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code /+}.</li>
   *   <li>Then return {@code 42/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/+'; then return '42/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlashPlusSign_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42/+", StringUtilities.mkPath("42", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code /+}.</li>
   *   <li>Then return {@code 42/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/+'; then return '42/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlashPlusSign_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42/+/", StringUtilities.mkPath("42", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code /}.</li>
   *   <li>Then return {@code 42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/'; then return '42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42/", StringUtilities.mkPath("42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code /}.</li>
   *   <li>Then return {@code 42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/'; then return '42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlash_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42/", StringUtilities.mkPath("42", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code 42/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '</th></tr></thead>'; then return '42/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_when42AndThTrThead_thenReturn42ThTrThead() {
    // Arrange, Act and Assert
    assertEquals("42/</th></tr></thead>/", StringUtilities.mkPath("42", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code 42}.</li>
   *   <li>Then return {@code Array must be provided/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '42'; then return 'Array must be provided/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAnd42_thenReturnArrayMustBeProvided42() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/42/", StringUtilities.mkPath("Array must be provided", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code Segs}.</li>
   *   <li>Then return {@code Array must be provided/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and 'Segs'; then return 'Array must be provided/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSegs_thenReturnArrayMustBeProvidedSegs() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Segs/", StringUtilities.mkPath("Array must be provided", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /+}.</li>
   *   <li>Then return {@code Array must be provided/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '/+'; then return 'Array must be provided/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlashPlusSign_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/+", StringUtilities.mkPath("Array must be provided", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /+}.</li>
   *   <li>Then return {@code Array must be provided/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '/+'; then return 'Array must be provided/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlashPlusSign_thenReturnArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/+/", StringUtilities.mkPath("Array must be provided", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /}.</li>
   *   <li>Then return {@code Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '/'; then return 'Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlash_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/", StringUtilities.mkPath("Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /}.</li>
   *   <li>Then return {@code Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '/'; then return 'Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlash_thenReturnArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/", StringUtilities.mkPath("Array must be provided", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code 42}.</li>
   *   <li>Then return {@code : Array was null/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '42'; then return ': Array was null/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAnd42_thenReturnArrayWasNull42() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/42/", StringUtilities.mkPath(": Array was null", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code : Array was null}.</li>
   *   <li>Then return {@code : Array was null/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and ': Array was null'; then return ': Array was null/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndArrayWasNull_thenReturnArrayWasNullArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/: Array was null/",
        StringUtilities.mkPath(": Array was null", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code Segs}.</li>
   *   <li>Then return {@code : Array was null/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and 'Segs'; then return ': Array was null/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSegs_thenReturnArrayWasNullSegs() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Segs/", StringUtilities.mkPath(": Array was null", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code /+}.</li>
   *   <li>Then return {@code : Array was null/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '/+'; then return ': Array was null/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlashPlusSign_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/+", StringUtilities.mkPath(": Array was null", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code /+}.</li>
   *   <li>Then return {@code : Array was null/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '/+'; then return ': Array was null/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlashPlusSign_thenReturnArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/+/", StringUtilities.mkPath(": Array was null", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code /}.</li>
   *   <li>Then return {@code : Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '/'; then return ': Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlash_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/", StringUtilities.mkPath(": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code /}.</li>
   *   <li>Then return {@code : Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '/'; then return ': Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlash_thenReturnArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/", StringUtilities.mkPath(": Array was null", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code : Array was null/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '</th></tr></thead>'; then return ': Array was null/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndThTrThead_thenReturnArrayWasNullThTrThead() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/</th></tr></thead>/",
        StringUtilities.mkPath(": Array was null", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code 42}.</li>
   *   <li>Then return {@code java.lang.Boolean/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'java.lang.Boolean' and '42'; then return 'java.lang.Boolean/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAnd42_thenReturnJavaLangBoolean42() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/42/", StringUtilities.mkPath("java.lang.Boolean", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code Segs}.</li>
   *   <li>Then return {@code java.lang.Boolean/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'java.lang.Boolean' and 'Segs'; then return 'java.lang.Boolean/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSegs_thenReturnJavaLangBooleanSegs() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/Segs/", StringUtilities.mkPath("java.lang.Boolean", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code /+}.</li>
   *   <li>Then return {@code java.lang.Boolean/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'java.lang.Boolean' and '/+'; then return 'java.lang.Boolean/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSlashPlusSign_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/+", StringUtilities.mkPath("java.lang.Boolean", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code /+}.</li>
   *   <li>Then return {@code java.lang.Boolean/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'java.lang.Boolean' and '/+'; then return 'java.lang.Boolean/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSlashPlusSign_thenReturnJavaLangBoolean2() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/+/", StringUtilities.mkPath("java.lang.Boolean", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code /}.</li>
   *   <li>Then return {@code java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'java.lang.Boolean' and '/'; then return 'java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSlash_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/", StringUtilities.mkPath("java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code /}.</li>
   *   <li>Then return {@code java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'java.lang.Boolean' and '/'; then return 'java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndSlash_thenReturnJavaLangBoolean2() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/", StringUtilities.mkPath("java.lang.Boolean", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code java.lang.Boolean} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code java.lang.Boolean/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'java.lang.Boolean' and '</th></tr></thead>'; then return 'java.lang.Boolean/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenJavaLangBooleanAndThTrThead_thenReturnJavaLangBooleanThTrThead() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean/</th></tr></thead>/",
        StringUtilities.mkPath("java.lang.Boolean", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code 42}.</li>
   *   <li>Then return {@code Predicate must be provided/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Predicate must be provided' and '42'; then return 'Predicate must be provided/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAnd42_thenReturnPredicateMustBeProvided42() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/42/", StringUtilities.mkPath("Predicate must be provided", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code /}.</li>
   *   <li>Then return {@code Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Predicate must be provided' and '/'; then return 'Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAndSlash_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/", StringUtilities.mkPath("Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code /}.</li>
   *   <li>Then return {@code Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Predicate must be provided' and '/'; then return 'Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAndSlash_thenReturnPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/", StringUtilities.mkPath("Predicate must be provided", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code 42}.</li>
   *   <li>Then return {@code : Predicate was null/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '42'; then return ': Predicate was null/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAnd42_thenReturnPredicateWasNull42() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/42/", StringUtilities.mkPath(": Predicate was null", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code Segs}.</li>
   *   <li>Then return {@code : Predicate was null/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and 'Segs'; then return ': Predicate was null/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSegs_thenReturnPredicateWasNullSegs() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Segs/", StringUtilities.mkPath(": Predicate was null", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /+}.</li>
   *   <li>Then return {@code : Predicate was null/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '/+'; then return ': Predicate was null/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlashPlusSign_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/+", StringUtilities.mkPath(": Predicate was null", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /+}.</li>
   *   <li>Then return {@code : Predicate was null/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '/+'; then return ': Predicate was null/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlashPlusSign_thenReturnPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/+/", StringUtilities.mkPath(": Predicate was null", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /}.</li>
   *   <li>Then return {@code : Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '/'; then return ': Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlash_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/", StringUtilities.mkPath(": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /}.</li>
   *   <li>Then return {@code : Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '/'; then return ': Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlash_thenReturnPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/", StringUtilities.mkPath(": Predicate was null", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code : Predicate was null/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '</th></tr></thead>'; then return ': Predicate was null/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndThTrThead_thenReturnPredicateWasNullThTrThead() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/</th></tr></thead>/",
        StringUtilities.mkPath(": Predicate was null", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code 42}.</li>
   *   <li>Then return {@code Segs/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '42'; then return 'Segs/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAnd42_thenReturnSegs42() {
    // Arrange, Act and Assert
    assertEquals("Segs/42/", StringUtilities.mkPath("Segs", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code Array must be provided}.</li>
   *   <li>Then return {@code Segs/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'Array must be provided'; then return 'Segs/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndArrayMustBeProvided_thenReturnSegsArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Segs/Array must be provided/", StringUtilities.mkPath("Segs", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code : Array was null}.</li>
   *   <li>Then return {@code Segs/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and ': Array was null'; then return 'Segs/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndArrayWasNull_thenReturnSegsArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("Segs/: Array was null/", StringUtilities.mkPath("Segs", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code Segs/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'java.lang.Boolean'; then return 'Segs/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndJavaLangBoolean_thenReturnSegsJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("Segs/java.lang.Boolean/", StringUtilities.mkPath("Segs", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code Segs/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and ': Predicate was null'; then return 'Segs/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndPredicateWasNull_thenReturnSegsPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("Segs/: Predicate was null/", StringUtilities.mkPath("Segs", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code Segs}.</li>
   *   <li>Then return {@code Segs/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'Segs'; then return 'Segs/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSegs_thenReturnSegsSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/Segs/", StringUtilities.mkPath("Segs", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code /+}.</li>
   *   <li>Then return {@code Segs/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/+'; then return 'Segs/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlashPlusSign_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/+", StringUtilities.mkPath("Segs", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code /+}.</li>
   *   <li>Then return {@code Segs/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/+'; then return 'Segs/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlashPlusSign_thenReturnSegs2() {
    // Arrange, Act and Assert
    assertEquals("Segs/+/", StringUtilities.mkPath("Segs", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code /}.</li>
   *   <li>Then return {@code Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/'; then return 'Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlash_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/", StringUtilities.mkPath("Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code /}.</li>
   *   <li>Then return {@code Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/'; then return 'Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlash_thenReturnSegs2() {
    // Arrange, Act and Assert
    assertEquals("Segs/", StringUtilities.mkPath("Segs", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code Segs/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '</th></tr></thead>'; then return 'Segs/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndThTrThead_thenReturnSegsThTrThead() {
    // Arrange, Act and Assert
    assertEquals("Segs/</th></tr></thead>/", StringUtilities.mkPath("Segs", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs}.</li>
   *   <li>Then return {@code Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs'; then return 'Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs", StringUtilities.mkPath("Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/42", StringUtilities.mkPath("/", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/42/Array must be provided", StringUtilities.mkPath("/", "42", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/42/: Array was null", StringUtilities.mkPath("/", "42", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42CannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/42/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "42", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42JavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/42/java.lang.Boolean", StringUtilities.mkPath("/", "42", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42PredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/42/Predicate must be provided", StringUtilities.mkPath("/", "42", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42PredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/42/: Predicate was null", StringUtilities.mkPath("/", "42", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42Segs() {
    // Arrange, Act and Assert
    assertEquals("/42/Segs", StringUtilities.mkPath("/", "42", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/42/</th></tr></thead>", StringUtilities.mkPath("/", "42", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("/42/", StringUtilities.mkPath("/", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("/42/+", StringUtilities.mkPath("/", "42", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("/42/42", StringUtilities.mkPath("/", "42", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided", StringUtilities.mkPath("/", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/", StringUtilities.mkPath("/", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided3() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/+", StringUtilities.mkPath("/", "Array must be provided", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided42() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/42", StringUtilities.mkPath("/", "Array must be provided", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvidedSegs() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/Segs", StringUtilities.mkPath("/", "Array must be provided", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null", StringUtilities.mkPath("/", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/", StringUtilities.mkPath("/", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull3() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/+", StringUtilities.mkPath("/", ": Array was null", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull42() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/42", StringUtilities.mkPath("/", ": Array was null", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/Array must be provided",
        StringUtilities.mkPath("/", ": Array was null", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/: Array was null",
        StringUtilities.mkPath("/", ": Array was null", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/java.lang.Boolean",
        StringUtilities.mkPath("/", ": Array was null", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/: Predicate was null",
        StringUtilities.mkPath("/", ": Array was null", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullSegs() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/Segs", StringUtilities.mkPath("/", ": Array was null", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/</th></tr></thead>",
        StringUtilities.mkPath("/", ": Array was null", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean", StringUtilities.mkPath("/", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBoolean2() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/", StringUtilities.mkPath("/", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBoolean3() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/+", StringUtilities.mkPath("/", "java.lang.Boolean", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBoolean42() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/42", StringUtilities.mkPath("/", "java.lang.Boolean", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBooleanArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/: Array was null",
        StringUtilities.mkPath("/", "java.lang.Boolean", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBooleanJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/java.lang.Boolean",
        StringUtilities.mkPath("/", "java.lang.Boolean", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBooleanPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/: Predicate was null",
        StringUtilities.mkPath("/", "java.lang.Boolean", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBooleanSegs() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/Segs", StringUtilities.mkPath("/", "java.lang.Boolean", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /java.lang.Boolean/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.Boolean'; then return '/java.lang.Boolean/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangBoolean_thenReturnJavaLangBooleanThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean/</th></tr></thead>",
        StringUtilities.mkPath("/", "java.lang.Boolean", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code String}.</li>
   *   <li>Then return {@code /String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.String'; then return '/java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangString_thenReturnJavaLangString() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.String", StringUtilities.mkPath("/", "java.lang.String"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code String}.</li>
   *   <li>Then return {@code /String/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'java.lang.String'; then return '/java.lang.String/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndJavaLangString_thenReturnJavaLangString2() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.String/", StringUtilities.mkPath("/", "java.lang.String", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.</li>
   *   <li>Then return {@code /Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided", StringUtilities.mkPath("/", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.</li>
   *   <li>Then return {@code /Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/", StringUtilities.mkPath("/", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.</li>
   *   <li>Then return {@code /Predicate must be provided/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided3() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/+", StringUtilities.mkPath("/", "Predicate must be provided", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null", StringUtilities.mkPath("/", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/", StringUtilities.mkPath("/", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull3() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/+", StringUtilities.mkPath("/", ": Predicate was null", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull42() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/42", StringUtilities.mkPath("/", ": Predicate was null", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/: Array was null",
        StringUtilities.mkPath("/", ": Predicate was null", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullSegs() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/Segs", StringUtilities.mkPath("/", ": Predicate was null", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/</th></tr></thead>",
        StringUtilities.mkPath("/", ": Predicate was null", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/Segs", StringUtilities.mkPath("/", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs2() {
    // Arrange, Act and Assert
    assertEquals("/Segs/", StringUtilities.mkPath("/", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs3() {
    // Arrange, Act and Assert
    assertEquals("/Segs/+", StringUtilities.mkPath("/", "Segs", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs42() {
    // Arrange, Act and Assert
    assertEquals("/Segs/42", StringUtilities.mkPath("/", "Segs", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Segs/Array must be provided", StringUtilities.mkPath("/", "Segs", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/Segs/: Array was null", StringUtilities.mkPath("/", "Segs", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/Segs/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Segs", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/Segs/java.lang.Boolean", StringUtilities.mkPath("/", "Segs", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Segs/Predicate must be provided", StringUtilities.mkPath("/", "Segs", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/Segs/: Predicate was null", StringUtilities.mkPath("/", "Segs", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsSegs() {
    // Arrange, Act and Assert
    assertEquals("/Segs/Segs", StringUtilities.mkPath("/", "Segs", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/Segs/</th></tr></thead>", StringUtilities.mkPath("/", "Segs", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/+/42", StringUtilities.mkPath("/", "/+", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/+/Array must be provided", StringUtilities.mkPath("/", "/+", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/+/: Array was null", StringUtilities.mkPath("/", "/+", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/+/java.lang.Boolean", StringUtilities.mkPath("/", "/+", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/+/Predicate must be provided", StringUtilities.mkPath("/", "/+", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/+/: Predicate was null", StringUtilities.mkPath("/", "/+", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/+/Segs", StringUtilities.mkPath("/", "/+", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+", StringUtilities.mkPath("/", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("/+/", StringUtilities.mkPath("/", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSignSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+/+", StringUtilities.mkPath("/", "/+", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/+/</th></tr></thead>", StringUtilities.mkPath("/", "/+", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/42", StringUtilities.mkPath("/", "/", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided", StringUtilities.mkPath("/", "/", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null", StringUtilities.mkPath("/", "/", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "/", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/java.lang.Boolean", StringUtilities.mkPath("/", "/", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided", StringUtilities.mkPath("/", "/", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null", StringUtilities.mkPath("/", "/", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/Segs", StringUtilities.mkPath("/", "/", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", StringUtilities.mkPath("/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlash2() {
    // Arrange, Act and Assert
    assertEquals("/", StringUtilities.mkPath("/", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+", StringUtilities.mkPath("/", "/", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>", StringUtilities.mkPath("/", "/", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>", StringUtilities.mkPath("/", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrThead2() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/", StringUtilities.mkPath("/", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrThead3() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/+", StringUtilities.mkPath("/", "</th></tr></thead>", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrThead42() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/42", StringUtilities.mkPath("/", "</th></tr></thead>", "42"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/Array must be provided",
        StringUtilities.mkPath("/", "</th></tr></thead>", "Array must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/: Array was null",
        StringUtilities.mkPath("/", "</th></tr></thead>", ": Array was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/java.lang.Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/java.lang.Boolean",
        StringUtilities.mkPath("/", "</th></tr></thead>", "java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/Predicate must be provided",
        StringUtilities.mkPath("/", "</th></tr></thead>", "Predicate must be provided"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/: Predicate was null",
        StringUtilities.mkPath("/", "</th></tr></thead>", ": Predicate was null"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadSegs() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/Segs", StringUtilities.mkPath("/", "</th></tr></thead>", "Segs"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /</th>
   * </tr>
   * </thead>/</th>
   * </tr>
   * </thead>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '</th></tr></thead>'; then return '/</th></tr></thead>/</th></tr></thead>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndThTrThead_thenReturnThTrTheadThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/</th></tr></thead>/</th></tr></thead>",
        StringUtilities.mkPath("/", "</th></tr></thead>", "</th></tr></thead>"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code 42}.</li>
   *   <li>Then return {@code /+/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '42'; then return '/+/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAnd42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/+/42/", StringUtilities.mkPath("/+", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /+/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'Array must be provided'; then return '/+/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndArrayMustBeProvided_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/+/Array must be provided/", StringUtilities.mkPath("/+", "Array must be provided", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code : Array was null}.</li>
   *   <li>Then return {@code /+/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and ': Array was null'; then return '/+/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndArrayWasNull_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/+/: Array was null/", StringUtilities.mkPath("/+", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code /+/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'java.lang.Boolean'; then return '/+/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndJavaLangBoolean_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("/+/java.lang.Boolean/", StringUtilities.mkPath("/+", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /+/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and ': Predicate was null'; then return '/+/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndPredicateWasNull_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/+/: Predicate was null/", StringUtilities.mkPath("/+", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code Segs}.</li>
   *   <li>Then return {@code /+/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'Segs'; then return '/+/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/+/Segs/", StringUtilities.mkPath("/+", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code /}.</li>
   *   <li>Then return {@code /+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '/'; then return '/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSlash_thenReturnSlashPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("/+/", StringUtilities.mkPath("/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code /}.</li>
   *   <li>Then return {@code /+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '/'; then return '/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSlash_thenReturnSlashPlusSignSlash2() {
    // Arrange, Act and Assert
    assertEquals("/+/", StringUtilities.mkPath("/+", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code /+/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '</th></tr></thead>'; then return '/+/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndThTrThead_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("/+/</th></tr></thead>/", StringUtilities.mkPath("/+", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code 42}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and '42'; then return '</th></tr></thead>/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAnd42_thenReturnThTrThead42() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/42/", StringUtilities.mkPath("</th></tr></thead>", "42", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code : Array was null}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and ': Array was null'; then return '</th></tr></thead>/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndArrayWasNull_thenReturnThTrTheadArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/: Array was null/",
        StringUtilities.mkPath("</th></tr></thead>", ": Array was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/java.lang.Boolean/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and 'java.lang.Boolean'; then return '</th></tr></thead>/java.lang.Boolean/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndJavaLangBoolean_thenReturnThTrTheadJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/java.lang.Boolean/",
        StringUtilities.mkPath("</th></tr></thead>", "java.lang.Boolean", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and ': Predicate was null'; then return '</th></tr></thead>/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndPredicateWasNull_thenReturnThTrTheadPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/: Predicate was null/",
        StringUtilities.mkPath("</th></tr></thead>", ": Predicate was null", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code Segs}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and 'Segs'; then return '</th></tr></thead>/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSegs_thenReturnThTrTheadSegs() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/Segs/", StringUtilities.mkPath("</th></tr></thead>", "Segs", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code /+}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and '/+'; then return '</th></tr></thead>/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSlashPlusSign_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/+", StringUtilities.mkPath("</th></tr></thead>", "/+"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code /+}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and '/+'; then return '</th></tr></thead>/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSlashPlusSign_thenReturnThTrThead2() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/+/", StringUtilities.mkPath("</th></tr></thead>", "/+", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code /}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and '/'; then return '</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSlash_thenReturnThTrThead() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/", StringUtilities.mkPath("</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code /}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and '/'; then return '</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndSlash_thenReturnThTrThead2() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/", StringUtilities.mkPath("</th></tr></thead>", "/", "/"));
  }

  /**
   * Test {@link StringUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code </th>
   * </tr>
   * </thead>} and {@code </th>
   * </tr>
   * </thead>}.</li>
   *   <li>Then return {@code </th>
   * </tr>
   * </thead>/</th>
   * </tr>
   * </thead>/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '</th></tr></thead>' and '</th></tr></thead>'; then return '</th></tr></thead>/</th></tr></thead>/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.mkPath(String[])"})
  void testMkPath_whenThTrTheadAndThTrThead_thenReturnThTrTheadThTrThead() {
    // Arrange, Act and Assert
    assertEquals("</th></tr></thead>/</th></tr></thead>/",
        StringUtilities.mkPath("</th></tr></thead>", "</th></tr></thead>", "/"));
  }

  /**
   * Test {@link StringUtilities#capitalise(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  @DisplayName("Test capitalise(String); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.capitalise(String)"})
  void testCapitalise_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.capitalise(null));
  }

  /**
   * Test {@link StringUtilities#capitalise(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  @DisplayName("Test capitalise(String); when space; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.capitalise(String)"})
  void testCapitalise_whenSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.capitalise(" "));
  }

  /**
   * Test {@link StringUtilities#capitalise(String)}.
   * <ul>
   *   <li>When {@code Words Words}.</li>
   *   <li>Then return {@code Words Words}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  @DisplayName("Test capitalise(String); when 'Words Words'; then return 'Words Words'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.capitalise(String)"})
  void testCapitalise_whenWordsWords_thenReturnWordsWords() {
    // Arrange, Act and Assert
    assertEquals("Words Words", StringUtilities.capitalise("Words Words"));
  }

  /**
   * Test {@link StringUtilities#capitalise(String)}.
   * <ul>
   *   <li>When {@code Words}.</li>
   *   <li>Then return {@code Words}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  @DisplayName("Test capitalise(String); when 'Words'; then return 'Words'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.capitalise(String)"})
  void testCapitalise_whenWords_thenReturnWords() {
    // Arrange, Act and Assert
    assertEquals("Words", StringUtilities.capitalise("Words"));
  }

  /**
   * Test {@link StringUtilities#toMailbox(String, String)}.
   * <p>
   * Method under test: {@link StringUtilities#toMailbox(String, String)}
   */
  @Test
  @DisplayName("Test toMailbox(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.toMailbox(String, String)"})
  void testToMailbox() {
    // Arrange, Act and Assert
    assertEquals("Display Name <jane.doe@example.org>",
        StringUtilities.toMailbox("Display Name", "jane.doe@example.org"));
  }

  /**
   * Test {@link StringUtilities#toHtmlTable(List, Collection)}.
   * <p>
   * Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  @DisplayName("Test toHtmlTable(List, Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.toHtmlTable(List, Collection)"})
  void testToHtmlTable() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();

    // Act and Assert
    assertEquals("<table class='table table-condensed small'><thead><tr><th></th></tr></thead><tbody></tbody></table>",
        StringUtilities.toHtmlTable(headers, new ArrayList<>()));
  }

  /**
   * Test {@link StringUtilities#toHtmlTable(List, Collection)}.
   * <p>
   * Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  @DisplayName("Test toHtmlTable(List, Collection)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code </th>
   * <th>}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code </th>
   * <th>}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  @DisplayName("Test toHtmlTable(List, Collection); given '</th><th>'; when ArrayList() add '</th><th>'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.toHtmlTable(List, Collection)"})
  void testToHtmlTable_givenThTh_whenArrayListAddThTh_thenReturnAString() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();
    headers.add("</th><th>");
    headers.add("\n");

    // Act and Assert
    assertEquals("<table class='table table-condensed small'><thead><tr><th></th><th></th><th>\n"
        + "</th></tr></thead><tbody></tbody></table>", StringUtilities.toHtmlTable(headers, new ArrayList<>()));
  }

  /**
   * Test {@link StringUtilities#nullIfEmpty(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when empty string; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.nullIfEmpty(String)"})
  void testNullIfEmpty_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtilities.nullIfEmpty(""));
  }

  /**
   * Test {@link StringUtilities#nullIfEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.nullIfEmpty(String)"})
  void testNullIfEmpty_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtilities.nullIfEmpty(null));
  }

  /**
   * Test {@link StringUtilities#nullIfEmpty(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when 'Str'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtilities.nullIfEmpty(String)"})
  void testNullIfEmpty_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.nullIfEmpty("Str"));
  }

  /**
   * Test {@link StringUtilities#isDefined(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isDefined(String)}
   */
  @Test
  @DisplayName("Test isDefined(String); when empty string; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isDefined(String)"})
  void testIsDefined_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isDefined(""));
  }

  /**
   * Test {@link StringUtilities#isDefined(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isDefined(String)}
   */
  @Test
  @DisplayName("Test isDefined(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isDefined(String)"})
  void testIsDefined_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isDefined(null));
  }

  /**
   * Test {@link StringUtilities#isDefined(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#isDefined(String)}
   */
  @Test
  @DisplayName("Test isDefined(String); when 'Str'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.isDefined(String)"})
  void testIsDefined_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isDefined("Str"));
  }

  /**
   * Test {@link StringUtilities#firstNonNull(String[])}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  @DisplayName("Test firstNonNull(String[]); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional StringUtilities.firstNonNull(String[])"})
  void testFirstNonNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull();

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#firstNonNull(String[])}.
   * <ul>
   *   <li>When empty string and {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  @DisplayName("Test firstNonNull(String[]); when empty string and 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional StringUtilities.firstNonNull(String[])"})
  void testFirstNonNull_whenEmptyStringAndNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull("", null);

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#firstNonNull(String[])}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  @DisplayName("Test firstNonNull(String[]); when empty string; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional StringUtilities.firstNonNull(String[])"})
  void testFirstNonNull_whenEmptyString_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull("");

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Test {@link StringUtilities#firstNonNull(String[])}.
   * <ul>
   *   <li>When {@code Xs}.</li>
   *   <li>Then return {@link Optional#get()} is {@code Xs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  @DisplayName("Test firstNonNull(String[]); when 'Xs'; then return get() is 'Xs'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code Actual}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'Actual'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenActual_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.safeEq("Actual", "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEq(String, String)}.
   * <ul>
   *   <li>When {@code Expected}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'Expected'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenExpected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEq("Expected", "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEq(String, String)}.
   * <ul>
   *   <li>When {@code Expected}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'Expected'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenExpected_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEq("Expected", null));
  }

  /**
   * Test {@link StringUtilities#safeEq(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEq(null, "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEq(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  @DisplayName("Test safeEq(String, String); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEq(String, String)"})
  void testSafeEq_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.safeEq(null, null));
  }

  /**
   * Test {@link StringUtilities#safeEqIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code Actual}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test safeEqIgnoreCase(String, String); when 'Actual'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEqIgnoreCase(String, String)"})
  void testSafeEqIgnoreCase_whenActual_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEqIgnoreCase(null, "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEqIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code Expected}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test safeEqIgnoreCase(String, String); when 'Expected'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEqIgnoreCase(String, String)"})
  void testSafeEqIgnoreCase_whenExpected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEqIgnoreCase("Expected", "Actual"));
  }

  /**
   * Test {@link StringUtilities#safeEqIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code Expected}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test safeEqIgnoreCase(String, String); when 'Expected'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEqIgnoreCase(String, String)"})
  void testSafeEqIgnoreCase_whenExpected_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEqIgnoreCase("Expected", null));
  }

  /**
   * Test {@link StringUtilities#safeEqIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test safeEqIgnoreCase(String, String); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtilities.safeEqIgnoreCase(String, String)"})
  void testSafeEqIgnoreCase_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.safeEqIgnoreCase(null, null));
  }
}
