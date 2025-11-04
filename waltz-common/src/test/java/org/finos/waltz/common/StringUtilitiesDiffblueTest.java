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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StringUtilitiesDiffblueTest {
  /**
   * Method under test: {@link StringUtilities#isEmpty(String)}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.isEmpty("foo"));
    assertTrue(StringUtilities.isEmpty((String) null));
    assertTrue(StringUtilities.isEmpty(""));
    assertTrue(StringUtilities.isEmpty((Optional<String>) null));
  }

  /**
   * Method under test: {@link StringUtilities#isEmpty(Optional)}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    Optional<String> maybeString = Optional.of("foo");

    // Act and Assert
    assertFalse(StringUtilities.isEmpty(maybeString));
  }

  /**
   * Method under test: {@link StringUtilities#isEmpty(Optional)}
   */
  @Test
  void testIsEmpty3() {
    // Arrange
    Optional<String> maybeString = Optional.of("");

    // Act and Assert
    assertTrue(StringUtilities.isEmpty(maybeString));
  }

  /**
   * Method under test: {@link StringUtilities#notEmpty(String)}
   */
  @Test
  void testNotEmpty() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.notEmpty("foo"));
    assertFalse(StringUtilities.notEmpty(null));
    assertFalse(StringUtilities.notEmpty(""));
  }

  /**
   * Method under test: {@link StringUtilities#ifEmpty(String, String)}
   */
  @Test
  void testIfEmpty() {
    // Arrange, Act and Assert
    assertEquals("foo", StringUtilities.ifEmpty("foo", "42"));
    assertEquals("42", StringUtilities.ifEmpty(null, "42"));
    assertEquals("42", StringUtilities.ifEmpty("", "42"));
  }

  /**
   * Method under test: {@link StringUtilities#parseLong(String, Long)}
   */
  @Test
  void testParseLong() {
    // Arrange, Act and Assert
    assertEquals(42L, StringUtilities.parseLong("42", 1L).longValue());
    assertEquals(1L, StringUtilities.parseLong("Value", 1L).longValue());
  }

  /**
   * Method under test: {@link StringUtilities#parseInteger(String, Integer)}
   */
  @Test
  void testParseInteger() {
    // Arrange, Act and Assert
    assertEquals(Columns.AQ, StringUtilities.parseInteger("42", 1).intValue());
    assertEquals(1, StringUtilities.parseInteger("Value", 1).intValue());
  }

  /**
   * Method under test: {@link StringUtilities#isNumericLong(String)}
   */
  @Test
  void testIsNumericLong() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isNumericLong("42"));
    assertFalse(StringUtilities.isNumericLong(null));
    assertFalse(StringUtilities.isNumericLong("Value"));
    assertFalse(StringUtilities.isNumericLong(""));
  }

  /**
   * Method under test: {@link StringUtilities#mkSafe(String)}
   */
  @Test
  void testMkSafe() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.mkSafe("Str"));
    assertEquals("", StringUtilities.mkSafe(null));
  }

  /**
   * Method under test: {@link StringUtilities#safeTrim(String)}
   */
  @Test
  void testSafeTrim() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.safeTrim("Str"));
    assertEquals("", StringUtilities.safeTrim(null));
  }

  /**
   * Method under test: {@link StringUtilities#limit(String, int)}
   */
  @Test
  void testLimit() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.limit("Str", 3));
    assertNull(StringUtilities.limit(null, 3));
  }

  /**
   * Method under test: {@link StringUtilities#length(String)}
   */
  @Test
  void testLength() {
    // Arrange, Act and Assert
    assertEquals(3, StringUtilities.length("Str"));
    assertEquals(0, StringUtilities.length(null));
  }

  /**
   * Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  void testJoin() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.join(new ArrayList<>(), "Separator"));
  }

  /**
   * Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  void testJoin2() {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");

    // Act and Assert
    assertEquals("42", StringUtilities.join(values, "Separator"));
  }

  /**
   * Method under test: {@link StringUtilities#join(Collection, String)}
   */
  @Test
  void testJoin3() {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");
    values.add("42");

    // Act and Assert
    assertEquals("42Separator42", StringUtilities.join(values, "Separator"));
  }

  /**
   * Method under test:
   * {@link StringUtilities#joinUsing(Collection, Function, String)}
   */
  @Test
  void testJoinUsing() {
    // Arrange, Act and Assert
    assertEquals("", StringUtilities.joinUsing(new ArrayList<>(), mock(Function.class), "Separator"));
  }

  /**
   * Method under test:
   * {@link StringUtilities#joinUsing(Collection, Function, String)}
   */
  @Test
  void testJoinUsing2() {
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
   * Method under test:
   * {@link StringUtilities#joinUsing(Collection, Function, String)}
   */
  @Test
  void testJoinUsing3() {
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
   * Method under test:
   * {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  void testSplitThenMap() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult = StringUtilities.<Object>splitThenMap(null, null, mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  void testSplitThenMap2() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult = StringUtilities.<Object>splitThenMap("Str", null, mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  void testSplitThenMap3() {
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
   * Method under test:
   * {@link StringUtilities#splitThenMap(String, String, Function)}
   */
  @Test
  void testSplitThenMap4() {
    // Arrange and Act
    List<Object> actualSplitThenMapResult = StringUtilities.<Object>splitThenMap("", "Separator", mock(Function.class));

    // Assert
    assertTrue(actualSplitThenMapResult.isEmpty());
  }

  /**
   * Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  void testTokenise() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42");

    // Assert
    assertEquals(1, actualTokeniseResult.size());
    assertEquals("42", actualTokeniseResult.get(0));
  }

  /**
   * Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  void testTokenise2() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise(" ");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  void testTokenise3() {
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
   * Method under test: {@link StringUtilities#tokenise(String)}
   */
  @Test
  void testTokenise4() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  void testTokenise5() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42", ".*");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  void testTokenise6() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("", ".*");

    // Assert
    assertTrue(actualTokeniseResult.isEmpty());
  }

  /**
   * Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  void testTokenise7() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42", "value cannot be null");

    // Assert
    assertEquals(1, actualTokeniseResult.size());
    assertEquals("42", actualTokeniseResult.get(0));
  }

  /**
   * Method under test: {@link StringUtilities#tokenise(String, String)}
   */
  @Test
  void testTokenise8() {
    // Arrange and Act
    List<String> actualTokeniseResult = StringUtilities.tokenise("42", "");

    // Assert
    assertEquals(2, actualTokeniseResult.size());
    assertEquals("2", actualTokeniseResult.get(1));
    assertEquals("4", actualTokeniseResult.get(0));
  }

  /**
   * Method under test: {@link StringUtilities#lower(String)}
   */
  @Test
  void testLower() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.lower("42"));
  }

  /**
   * Method under test: {@link StringUtilities#upper(String)}
   */
  @Test
  void testUpper() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtilities.upper("42"));
  }

  /**
   * Method under test: {@link StringUtilities#firstChar(String)}
   */
  @Test
  void testFirstChar() {
    // Arrange and Act
    Optional<Character> actualFirstCharResult = StringUtilities.firstChar("Str");

    // Assert
    assertEquals('S', actualFirstCharResult.get().charValue());
    assertTrue(actualFirstCharResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#firstChar(String)}
   */
  @Test
  void testFirstChar2() {
    // Arrange and Act
    Optional<Character> actualFirstCharResult = StringUtilities.firstChar(null);

    // Assert
    assertFalse(actualFirstCharResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#firstChar(String, char)}
   */
  @Test
  void testFirstChar3() {
    // Arrange, Act and Assert
    assertEquals('S', StringUtilities.firstChar("Str", 'A'));
  }

  /**
   * Method under test: {@link StringUtilities#firstChar(String, char)}
   */
  @Test
  void testFirstChar4() {
    // Arrange, Act and Assert
    assertEquals('A', StringUtilities.firstChar(null, 'A'));
  }

  /**
   * Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  void testToOptional() {
    // Arrange and Act
    Optional<String> actualToOptionalResult = StringUtilities.toOptional("Str");

    // Assert
    assertEquals("Str", actualToOptionalResult.get());
    assertTrue(actualToOptionalResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  void testToOptional2() {
    // Arrange and Act
    Optional<String> actualToOptionalResult = StringUtilities.toOptional(null);

    // Assert
    assertFalse(actualToOptionalResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#toOptional(String)}
   */
  @Test
  void testToOptional3() {
    // Arrange and Act
    Optional<String> actualToOptionalResult = StringUtilities.toOptional("");

    // Assert
    assertFalse(actualToOptionalResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#mkPath(String[])}
   */
  @Test
  void testMkPath() {
    // Arrange, Act and Assert
    assertEquals("Segs", StringUtilities.mkPath("Segs"));
    assertEquals("/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path"));
    assertEquals("/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/"));
    assertEquals("/", StringUtilities.mkPath("/", "/"));
    assertEquals("/: Array was null", StringUtilities.mkPath("/", ": Array was null"));
    assertEquals("/: Predicate was null", StringUtilities.mkPath("/", ": Predicate was null"));
    assertEquals("/Array must be provided", StringUtilities.mkPath("/", "Array must be provided"));
    assertEquals("/Predicate must be provided", StringUtilities.mkPath("/", "Predicate must be provided"));
    assertEquals("/Segs", StringUtilities.mkPath("/", "Segs"));
    assertEquals("/42", StringUtilities.mkPath("/", "42"));
    assertEquals("/+", StringUtilities.mkPath("/", "/+"));
    assertEquals("/</th></tr></thead>", StringUtilities.mkPath("/", "</th></tr></thead>"));
    assertEquals("/java.lang.Boolean", StringUtilities.mkPath("/", "java.lang.Boolean"));
    assertEquals("Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path", "/"));
    assertEquals(": Array was null/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath(": Array was null", "Cannot convert empty or null segments to path", "/"));
    assertEquals(": Predicate was null/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath(": Predicate was null", "Cannot convert empty or null segments to path", "/"));
    assertEquals("Array must be provided/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Array must be provided", "Cannot convert empty or null segments to path", "/"));
    assertEquals("Predicate must be provided/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Predicate must be provided", "Cannot convert empty or null segments to path", "/"));
    assertEquals("Segs/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/"));
    assertEquals("42/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/"));
    assertEquals("/+/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/"));
    assertEquals("</th></tr></thead>/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("</th></tr></thead>", "Cannot convert empty or null segments to path", "/"));
    assertEquals("java.lang.Boolean/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("java.lang.Boolean", "Cannot convert empty or null segments to path", "/"));
    assertEquals("/", StringUtilities.mkPath("/", "/", "/"));
    assertEquals("/: Array was null/", StringUtilities.mkPath("/", ": Array was null", "/"));
    assertEquals("/: Predicate was null/", StringUtilities.mkPath("/", ": Predicate was null", "/"));
    assertEquals("/Array must be provided/", StringUtilities.mkPath("/", "Array must be provided", "/"));
    assertEquals("/Predicate must be provided/", StringUtilities.mkPath("/", "Predicate must be provided", "/"));
    assertEquals("/Segs/", StringUtilities.mkPath("/", "Segs", "/"));
    assertEquals("/42/", StringUtilities.mkPath("/", "42", "/"));
    assertEquals("/+/", StringUtilities.mkPath("/", "/+", "/"));
    assertEquals("/</th></tr></thead>/", StringUtilities.mkPath("/", "</th></tr></thead>", "/"));
    assertEquals("/java.lang.Boolean/", StringUtilities.mkPath("/", "java.lang.Boolean", "/"));
    assertEquals("/Cannot convert empty or null segments to path/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path"));
    assertEquals("/Cannot convert empty or null segments to path/: Array was null",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", ": Array was null"));
    assertEquals("/Cannot convert empty or null segments to path/: Predicate was null",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", ": Predicate was null"));
    assertEquals("/Cannot convert empty or null segments to path/Array must be provided",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Array must be provided"));
    assertEquals("/Cannot convert empty or null segments to path/Predicate must be provided",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Predicate must be provided"));
    assertEquals("/Cannot convert empty or null segments to path/Segs",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Segs"));
    assertEquals("/Cannot convert empty or null segments to path/42",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "42"));
    assertEquals("/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("/Cannot convert empty or null segments to path/</th></tr></thead>",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "</th></tr></thead>"));
    assertEquals("/Cannot convert empty or null segments to path/java.lang.Boolean",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "java.lang.Boolean"));
    assertEquals("/java.lang.String", StringUtilities.mkPath("/", "java.lang.String"));
    assertEquals("Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/"));
    assertEquals(": Array was null/", StringUtilities.mkPath(": Array was null", "/"));
    assertEquals(": Predicate was null/", StringUtilities.mkPath(": Predicate was null", "/"));
    assertEquals("Array must be provided/", StringUtilities.mkPath("Array must be provided", "/"));
    assertEquals("Predicate must be provided/", StringUtilities.mkPath("Predicate must be provided", "/"));
    assertEquals("Segs/", StringUtilities.mkPath("Segs", "/"));
    assertEquals("42/", StringUtilities.mkPath("42", "/"));
    assertEquals("/+/", StringUtilities.mkPath("/+", "/"));
    assertEquals("</th></tr></thead>/", StringUtilities.mkPath("</th></tr></thead>", "/"));
    assertEquals("java.lang.Boolean/", StringUtilities.mkPath("java.lang.Boolean", "/"));
    assertEquals("Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/+"));
    assertEquals(": Array was null/+", StringUtilities.mkPath(": Array was null", "/+"));
    assertEquals(": Predicate was null/+", StringUtilities.mkPath(": Predicate was null", "/+"));
    assertEquals("Array must be provided/+", StringUtilities.mkPath("Array must be provided", "/+"));
    assertEquals("Predicate must be provided/+", StringUtilities.mkPath("Predicate must be provided", "/+"));
    assertEquals("Segs/+", StringUtilities.mkPath("Segs", "/+"));
    assertEquals("42/+", StringUtilities.mkPath("42", "/+"));
    assertEquals("/+/+", StringUtilities.mkPath("/+", "/+"));
    assertEquals("</th></tr></thead>/+", StringUtilities.mkPath("</th></tr></thead>", "/+"));
    assertEquals("java.lang.Boolean/+", StringUtilities.mkPath("java.lang.Boolean", "/+"));
    assertEquals("java.lang.String/Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("java.lang.String", "Cannot convert empty or null segments to path", "/"));
    assertEquals("Cannot convert empty or null segments to path/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/", "/"));
    assertEquals("Cannot convert empty or null segments to path/: Array was null/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", ": Array was null", "/"));
    assertEquals("Cannot convert empty or null segments to path/: Predicate was null/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", ": Predicate was null", "/"));
    assertEquals("Cannot convert empty or null segments to path/Array must be provided/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "Array must be provided", "/"));
    assertEquals("Cannot convert empty or null segments to path/Predicate must be provided/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "Predicate must be provided", "/"));
    assertEquals("Cannot convert empty or null segments to path/Segs/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "Segs", "/"));
    assertEquals("Cannot convert empty or null segments to path/42/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "42", "/"));
    assertEquals("Cannot convert empty or null segments to path/+/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "/+", "/"));
    assertEquals("Cannot convert empty or null segments to path/</th></tr></thead>/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "</th></tr></thead>", "/"));
    assertEquals("Cannot convert empty or null segments to path/java.lang.Boolean/",
        StringUtilities.mkPath("Cannot convert empty or null segments to path", "java.lang.Boolean", "/"));
    assertEquals("Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path", "/+"));
    assertEquals(": Array was null/", StringUtilities.mkPath(": Array was null", "/", "/"));
    assertEquals(": Array was null/: Array was null/",
        StringUtilities.mkPath(": Array was null", ": Array was null", "/"));
    assertEquals(": Array was null/: Predicate was null/",
        StringUtilities.mkPath(": Array was null", ": Predicate was null", "/"));
    assertEquals(": Array was null/Array must be provided/",
        StringUtilities.mkPath(": Array was null", "Array must be provided", "/"));
    assertEquals(": Array was null/Predicate must be provided/",
        StringUtilities.mkPath(": Array was null", "Predicate must be provided", "/"));
    assertEquals(": Array was null/Segs/", StringUtilities.mkPath(": Array was null", "Segs", "/"));
    assertEquals(": Array was null/42/", StringUtilities.mkPath(": Array was null", "42", "/"));
    assertEquals(": Array was null/+/", StringUtilities.mkPath(": Array was null", "/+", "/"));
    assertEquals(": Array was null/</th></tr></thead>/",
        StringUtilities.mkPath(": Array was null", "</th></tr></thead>", "/"));
    assertEquals(": Array was null/java.lang.Boolean/",
        StringUtilities.mkPath(": Array was null", "java.lang.Boolean", "/"));
    assertEquals(": Array was null/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath(": Array was null", "Cannot convert empty or null segments to path", "/+"));
    assertEquals(": Predicate was null/", StringUtilities.mkPath(": Predicate was null", "/", "/"));
    assertEquals(": Predicate was null/: Array was null/",
        StringUtilities.mkPath(": Predicate was null", ": Array was null", "/"));
    assertEquals(": Predicate was null/: Predicate was null/",
        StringUtilities.mkPath(": Predicate was null", ": Predicate was null", "/"));
    assertEquals(": Predicate was null/Array must be provided/",
        StringUtilities.mkPath(": Predicate was null", "Array must be provided", "/"));
    assertEquals(": Predicate was null/Predicate must be provided/",
        StringUtilities.mkPath(": Predicate was null", "Predicate must be provided", "/"));
    assertEquals(": Predicate was null/Segs/", StringUtilities.mkPath(": Predicate was null", "Segs", "/"));
    assertEquals(": Predicate was null/42/", StringUtilities.mkPath(": Predicate was null", "42", "/"));
    assertEquals(": Predicate was null/+/", StringUtilities.mkPath(": Predicate was null", "/+", "/"));
    assertEquals(": Predicate was null/</th></tr></thead>/",
        StringUtilities.mkPath(": Predicate was null", "</th></tr></thead>", "/"));
    assertEquals(": Predicate was null/java.lang.Boolean/",
        StringUtilities.mkPath(": Predicate was null", "java.lang.Boolean", "/"));
    assertEquals(": Predicate was null/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath(": Predicate was null", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("Array must be provided/", StringUtilities.mkPath("Array must be provided", "/", "/"));
    assertEquals("Array must be provided/: Array was null/",
        StringUtilities.mkPath("Array must be provided", ": Array was null", "/"));
    assertEquals("Array must be provided/: Predicate was null/",
        StringUtilities.mkPath("Array must be provided", ": Predicate was null", "/"));
    assertEquals("Array must be provided/Array must be provided/",
        StringUtilities.mkPath("Array must be provided", "Array must be provided", "/"));
    assertEquals("Array must be provided/Predicate must be provided/",
        StringUtilities.mkPath("Array must be provided", "Predicate must be provided", "/"));
    assertEquals("Array must be provided/Segs/", StringUtilities.mkPath("Array must be provided", "Segs", "/"));
    assertEquals("Array must be provided/42/", StringUtilities.mkPath("Array must be provided", "42", "/"));
    assertEquals("Array must be provided/+/", StringUtilities.mkPath("Array must be provided", "/+", "/"));
    assertEquals("Array must be provided/</th></tr></thead>/",
        StringUtilities.mkPath("Array must be provided", "</th></tr></thead>", "/"));
    assertEquals("Array must be provided/java.lang.Boolean/",
        StringUtilities.mkPath("Array must be provided", "java.lang.Boolean", "/"));
    assertEquals("Array must be provided/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Array must be provided", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("Predicate must be provided/", StringUtilities.mkPath("Predicate must be provided", "/", "/"));
    assertEquals("Predicate must be provided/: Array was null/",
        StringUtilities.mkPath("Predicate must be provided", ": Array was null", "/"));
    assertEquals("Predicate must be provided/: Predicate was null/",
        StringUtilities.mkPath("Predicate must be provided", ": Predicate was null", "/"));
    assertEquals("Predicate must be provided/Array must be provided/",
        StringUtilities.mkPath("Predicate must be provided", "Array must be provided", "/"));
    assertEquals("Predicate must be provided/Predicate must be provided/",
        StringUtilities.mkPath("Predicate must be provided", "Predicate must be provided", "/"));
    assertEquals("Predicate must be provided/Segs/", StringUtilities.mkPath("Predicate must be provided", "Segs", "/"));
    assertEquals("Predicate must be provided/42/", StringUtilities.mkPath("Predicate must be provided", "42", "/"));
    assertEquals("Predicate must be provided/+/", StringUtilities.mkPath("Predicate must be provided", "/+", "/"));
    assertEquals("Predicate must be provided/</th></tr></thead>/",
        StringUtilities.mkPath("Predicate must be provided", "</th></tr></thead>", "/"));
    assertEquals("Predicate must be provided/java.lang.Boolean/",
        StringUtilities.mkPath("Predicate must be provided", "java.lang.Boolean", "/"));
    assertEquals("Predicate must be provided/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Predicate must be provided", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("Segs/", StringUtilities.mkPath("Segs", "/", "/"));
    assertEquals("Segs/: Array was null/", StringUtilities.mkPath("Segs", ": Array was null", "/"));
    assertEquals("Segs/: Predicate was null/", StringUtilities.mkPath("Segs", ": Predicate was null", "/"));
    assertEquals("Segs/Array must be provided/", StringUtilities.mkPath("Segs", "Array must be provided", "/"));
    assertEquals("Segs/Predicate must be provided/", StringUtilities.mkPath("Segs", "Predicate must be provided", "/"));
    assertEquals("Segs/Segs/", StringUtilities.mkPath("Segs", "Segs", "/"));
    assertEquals("Segs/42/", StringUtilities.mkPath("Segs", "42", "/"));
    assertEquals("Segs/</th></tr></thead>/", StringUtilities.mkPath("Segs", "</th></tr></thead>", "/"));
    assertEquals("Segs/+/", StringUtilities.mkPath("Segs", "/+", "/"));
    assertEquals("Segs/java.lang.Boolean/", StringUtilities.mkPath("Segs", "java.lang.Boolean", "/"));
    assertEquals("Segs/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("42/", StringUtilities.mkPath("42", "/", "/"));
    assertEquals("42/: Array was null/", StringUtilities.mkPath("42", ": Array was null", "/"));
    assertEquals("42/: Predicate was null/", StringUtilities.mkPath("42", ": Predicate was null", "/"));
    assertEquals("42/Array must be provided/", StringUtilities.mkPath("42", "Array must be provided", "/"));
    assertEquals("42/Predicate must be provided/", StringUtilities.mkPath("42", "Predicate must be provided", "/"));
    assertEquals("42/Segs/", StringUtilities.mkPath("42", "Segs", "/"));
    assertEquals("42/42/", StringUtilities.mkPath("42", "42", "/"));
    assertEquals("42/</th></tr></thead>/", StringUtilities.mkPath("42", "</th></tr></thead>", "/"));
    assertEquals("42/+/", StringUtilities.mkPath("42", "/+", "/"));
    assertEquals("42/java.lang.Boolean/", StringUtilities.mkPath("42", "java.lang.Boolean", "/"));
    assertEquals("42/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("/+/", StringUtilities.mkPath("/+", "/", "/"));
    assertEquals("/+/: Array was null/", StringUtilities.mkPath("/+", ": Array was null", "/"));
    assertEquals("/+/: Predicate was null/", StringUtilities.mkPath("/+", ": Predicate was null", "/"));
    assertEquals("/+/Array must be provided/", StringUtilities.mkPath("/+", "Array must be provided", "/"));
    assertEquals("/+/Predicate must be provided/", StringUtilities.mkPath("/+", "Predicate must be provided", "/"));
    assertEquals("/+/Segs/", StringUtilities.mkPath("/+", "Segs", "/"));
    assertEquals("/+/42/", StringUtilities.mkPath("/+", "42", "/"));
    assertEquals("/+/+/", StringUtilities.mkPath("/+", "/+", "/"));
    assertEquals("/+/</th></tr></thead>/", StringUtilities.mkPath("/+", "</th></tr></thead>", "/"));
    assertEquals("/+/java.lang.Boolean/", StringUtilities.mkPath("/+", "java.lang.Boolean", "/"));
    assertEquals("/+/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("</th></tr></thead>/", StringUtilities.mkPath("</th></tr></thead>", "/", "/"));
    assertEquals("</th></tr></thead>/: Array was null/",
        StringUtilities.mkPath("</th></tr></thead>", ": Array was null", "/"));
    assertEquals("</th></tr></thead>/: Predicate was null/",
        StringUtilities.mkPath("</th></tr></thead>", ": Predicate was null", "/"));
    assertEquals("</th></tr></thead>/Array must be provided/",
        StringUtilities.mkPath("</th></tr></thead>", "Array must be provided", "/"));
    assertEquals("</th></tr></thead>/Predicate must be provided/",
        StringUtilities.mkPath("</th></tr></thead>", "Predicate must be provided", "/"));
    assertEquals("</th></tr></thead>/Segs/", StringUtilities.mkPath("</th></tr></thead>", "Segs", "/"));
    assertEquals("</th></tr></thead>/42/", StringUtilities.mkPath("</th></tr></thead>", "42", "/"));
    assertEquals("</th></tr></thead>/</th></tr></thead>/",
        StringUtilities.mkPath("</th></tr></thead>", "</th></tr></thead>", "/"));
    assertEquals("</th></tr></thead>/+/", StringUtilities.mkPath("</th></tr></thead>", "/+", "/"));
    assertEquals("</th></tr></thead>/java.lang.Boolean/",
        StringUtilities.mkPath("</th></tr></thead>", "java.lang.Boolean", "/"));
    assertEquals("</th></tr></thead>/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("</th></tr></thead>", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("java.lang.Boolean/", StringUtilities.mkPath("java.lang.Boolean", "/", "/"));
    assertEquals("java.lang.Boolean/: Array was null/",
        StringUtilities.mkPath("java.lang.Boolean", ": Array was null", "/"));
    assertEquals("java.lang.Boolean/: Predicate was null/",
        StringUtilities.mkPath("java.lang.Boolean", ": Predicate was null", "/"));
    assertEquals("java.lang.Boolean/Array must be provided/",
        StringUtilities.mkPath("java.lang.Boolean", "Array must be provided", "/"));
    assertEquals("java.lang.Boolean/Predicate must be provided/",
        StringUtilities.mkPath("java.lang.Boolean", "Predicate must be provided", "/"));
    assertEquals("java.lang.Boolean/Segs/", StringUtilities.mkPath("java.lang.Boolean", "Segs", "/"));
    assertEquals("java.lang.Boolean/42/", StringUtilities.mkPath("java.lang.Boolean", "42", "/"));
    assertEquals("java.lang.Boolean/java.lang.Boolean/",
        StringUtilities.mkPath("java.lang.Boolean", "java.lang.Boolean", "/"));
    assertEquals("java.lang.Boolean/</th></tr></thead>/",
        StringUtilities.mkPath("java.lang.Boolean", "</th></tr></thead>", "/"));
    assertEquals("java.lang.Boolean/+/", StringUtilities.mkPath("java.lang.Boolean", "/+", "/"));
    assertEquals("java.lang.Boolean/Cannot convert empty or null segments to path/+",
        StringUtilities.mkPath("java.lang.Boolean", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("/java.lang.String/", StringUtilities.mkPath("/", "java.lang.String", "/"));
    assertEquals("/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "/", "Cannot convert empty or null segments to path"));
    assertEquals("/: Array was null", StringUtilities.mkPath("/", "/", ": Array was null"));
    assertEquals("/: Predicate was null", StringUtilities.mkPath("/", "/", ": Predicate was null"));
    assertEquals("/Array must be provided", StringUtilities.mkPath("/", "/", "Array must be provided"));
    assertEquals("/Predicate must be provided", StringUtilities.mkPath("/", "/", "Predicate must be provided"));
    assertEquals("/Segs", StringUtilities.mkPath("/", "/", "Segs"));
    assertEquals("/42", StringUtilities.mkPath("/", "/", "42"));
    assertEquals("/+", StringUtilities.mkPath("/", "/", "/+"));
    assertEquals("/</th></tr></thead>", StringUtilities.mkPath("/", "/", "</th></tr></thead>"));
    assertEquals("/java.lang.Boolean", StringUtilities.mkPath("/", "/", "java.lang.Boolean"));
    assertEquals("/: Array was null/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", ": Array was null", "Cannot convert empty or null segments to path"));
    assertEquals("/: Array was null/: Array was null",
        StringUtilities.mkPath("/", ": Array was null", ": Array was null"));
    assertEquals("/: Array was null/: Predicate was null",
        StringUtilities.mkPath("/", ": Array was null", ": Predicate was null"));
    assertEquals("/: Array was null/Array must be provided",
        StringUtilities.mkPath("/", ": Array was null", "Array must be provided"));
    assertEquals("/: Array was null/Predicate must be provided",
        StringUtilities.mkPath("/", ": Array was null", "Predicate must be provided"));
    assertEquals("/: Array was null/Segs", StringUtilities.mkPath("/", ": Array was null", "Segs"));
    assertEquals("/: Array was null/42", StringUtilities.mkPath("/", ": Array was null", "42"));
    assertEquals("/: Array was null/+", StringUtilities.mkPath("/", ": Array was null", "/+"));
    assertEquals("/: Array was null/</th></tr></thead>",
        StringUtilities.mkPath("/", ": Array was null", "</th></tr></thead>"));
    assertEquals("/: Array was null/java.lang.Boolean",
        StringUtilities.mkPath("/", ": Array was null", "java.lang.Boolean"));
    assertEquals("/: Predicate was null/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", ": Predicate was null", "Cannot convert empty or null segments to path"));
    assertEquals("/: Predicate was null/: Array was null",
        StringUtilities.mkPath("/", ": Predicate was null", ": Array was null"));
    assertEquals("/: Predicate was null/: Predicate was null",
        StringUtilities.mkPath("/", ": Predicate was null", ": Predicate was null"));
    assertEquals("/: Predicate was null/Array must be provided",
        StringUtilities.mkPath("/", ": Predicate was null", "Array must be provided"));
    assertEquals("/: Predicate was null/Predicate must be provided",
        StringUtilities.mkPath("/", ": Predicate was null", "Predicate must be provided"));
    assertEquals("/: Predicate was null/Segs", StringUtilities.mkPath("/", ": Predicate was null", "Segs"));
    assertEquals("/: Predicate was null/42", StringUtilities.mkPath("/", ": Predicate was null", "42"));
    assertEquals("/: Predicate was null/+", StringUtilities.mkPath("/", ": Predicate was null", "/+"));
    assertEquals("/: Predicate was null/</th></tr></thead>",
        StringUtilities.mkPath("/", ": Predicate was null", "</th></tr></thead>"));
    assertEquals("/: Predicate was null/java.lang.Boolean",
        StringUtilities.mkPath("/", ": Predicate was null", "java.lang.Boolean"));
    assertEquals("/Array must be provided/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Array must be provided", "Cannot convert empty or null segments to path"));
    assertEquals("/Array must be provided/: Array was null",
        StringUtilities.mkPath("/", "Array must be provided", ": Array was null"));
    assertEquals("/Array must be provided/: Predicate was null",
        StringUtilities.mkPath("/", "Array must be provided", ": Predicate was null"));
    assertEquals("/Array must be provided/Array must be provided",
        StringUtilities.mkPath("/", "Array must be provided", "Array must be provided"));
    assertEquals("/Array must be provided/Predicate must be provided",
        StringUtilities.mkPath("/", "Array must be provided", "Predicate must be provided"));
    assertEquals("/Array must be provided/Segs", StringUtilities.mkPath("/", "Array must be provided", "Segs"));
    assertEquals("/Array must be provided/42", StringUtilities.mkPath("/", "Array must be provided", "42"));
    assertEquals("/Array must be provided/+", StringUtilities.mkPath("/", "Array must be provided", "/+"));
    assertEquals("/Array must be provided/</th></tr></thead>",
        StringUtilities.mkPath("/", "Array must be provided", "</th></tr></thead>"));
    assertEquals("/Array must be provided/java.lang.Boolean",
        StringUtilities.mkPath("/", "Array must be provided", "java.lang.Boolean"));
    assertEquals("/Predicate must be provided/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Predicate must be provided", "Cannot convert empty or null segments to path"));
    assertEquals("/Predicate must be provided/: Array was null",
        StringUtilities.mkPath("/", "Predicate must be provided", ": Array was null"));
    assertEquals("/Predicate must be provided/: Predicate was null",
        StringUtilities.mkPath("/", "Predicate must be provided", ": Predicate was null"));
    assertEquals("/Predicate must be provided/Array must be provided",
        StringUtilities.mkPath("/", "Predicate must be provided", "Array must be provided"));
    assertEquals("/Predicate must be provided/Predicate must be provided",
        StringUtilities.mkPath("/", "Predicate must be provided", "Predicate must be provided"));
    assertEquals("/Predicate must be provided/Segs", StringUtilities.mkPath("/", "Predicate must be provided", "Segs"));
    assertEquals("/Predicate must be provided/42", StringUtilities.mkPath("/", "Predicate must be provided", "42"));
    assertEquals("/Predicate must be provided/+", StringUtilities.mkPath("/", "Predicate must be provided", "/+"));
    assertEquals("/Predicate must be provided/</th></tr></thead>",
        StringUtilities.mkPath("/", "Predicate must be provided", "</th></tr></thead>"));
    assertEquals("/Predicate must be provided/java.lang.Boolean",
        StringUtilities.mkPath("/", "Predicate must be provided", "java.lang.Boolean"));
    assertEquals("/Segs/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "Segs", "Cannot convert empty or null segments to path"));
    assertEquals("/Segs/: Array was null", StringUtilities.mkPath("/", "Segs", ": Array was null"));
    assertEquals("/Segs/: Predicate was null", StringUtilities.mkPath("/", "Segs", ": Predicate was null"));
    assertEquals("/Segs/Array must be provided", StringUtilities.mkPath("/", "Segs", "Array must be provided"));
    assertEquals("/Segs/Predicate must be provided", StringUtilities.mkPath("/", "Segs", "Predicate must be provided"));
    assertEquals("/Segs/Segs", StringUtilities.mkPath("/", "Segs", "Segs"));
    assertEquals("/Segs/42", StringUtilities.mkPath("/", "Segs", "42"));
    assertEquals("/Segs/</th></tr></thead>", StringUtilities.mkPath("/", "Segs", "</th></tr></thead>"));
    assertEquals("/Segs/+", StringUtilities.mkPath("/", "Segs", "/+"));
    assertEquals("/Segs/java.lang.Boolean", StringUtilities.mkPath("/", "Segs", "java.lang.Boolean"));
    assertEquals("/42/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "42", "Cannot convert empty or null segments to path"));
    assertEquals("/42/: Array was null", StringUtilities.mkPath("/", "42", ": Array was null"));
    assertEquals("/42/: Predicate was null", StringUtilities.mkPath("/", "42", ": Predicate was null"));
    assertEquals("/42/Array must be provided", StringUtilities.mkPath("/", "42", "Array must be provided"));
    assertEquals("/42/Predicate must be provided", StringUtilities.mkPath("/", "42", "Predicate must be provided"));
    assertEquals("/42/Segs", StringUtilities.mkPath("/", "42", "Segs"));
    assertEquals("/42/42", StringUtilities.mkPath("/", "42", "42"));
    assertEquals("/42/</th></tr></thead>", StringUtilities.mkPath("/", "42", "</th></tr></thead>"));
    assertEquals("/42/+", StringUtilities.mkPath("/", "42", "/+"));
    assertEquals("/42/java.lang.Boolean", StringUtilities.mkPath("/", "42", "java.lang.Boolean"));
    assertEquals("/+/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "/+", "Cannot convert empty or null segments to path"));
    assertEquals("/+/: Array was null", StringUtilities.mkPath("/", "/+", ": Array was null"));
    assertEquals("/+/: Predicate was null", StringUtilities.mkPath("/", "/+", ": Predicate was null"));
    assertEquals("/+/Array must be provided", StringUtilities.mkPath("/", "/+", "Array must be provided"));
    assertEquals("/+/Predicate must be provided", StringUtilities.mkPath("/", "/+", "Predicate must be provided"));
    assertEquals("/+/Segs", StringUtilities.mkPath("/", "/+", "Segs"));
    assertEquals("/+/42", StringUtilities.mkPath("/", "/+", "42"));
    assertEquals("/+/+", StringUtilities.mkPath("/", "/+", "/+"));
    assertEquals("/+/</th></tr></thead>", StringUtilities.mkPath("/", "/+", "</th></tr></thead>"));
    assertEquals("/+/java.lang.Boolean", StringUtilities.mkPath("/", "/+", "java.lang.Boolean"));
    assertEquals("/</th></tr></thead>/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "</th></tr></thead>", "Cannot convert empty or null segments to path"));
    assertEquals("/</th></tr></thead>/: Array was null",
        StringUtilities.mkPath("/", "</th></tr></thead>", ": Array was null"));
    assertEquals("/</th></tr></thead>/: Predicate was null",
        StringUtilities.mkPath("/", "</th></tr></thead>", ": Predicate was null"));
    assertEquals("/</th></tr></thead>/Array must be provided",
        StringUtilities.mkPath("/", "</th></tr></thead>", "Array must be provided"));
    assertEquals("/</th></tr></thead>/Predicate must be provided",
        StringUtilities.mkPath("/", "</th></tr></thead>", "Predicate must be provided"));
    assertEquals("/</th></tr></thead>/Segs", StringUtilities.mkPath("/", "</th></tr></thead>", "Segs"));
    assertEquals("/</th></tr></thead>/42", StringUtilities.mkPath("/", "</th></tr></thead>", "42"));
    assertEquals("/</th></tr></thead>/</th></tr></thead>",
        StringUtilities.mkPath("/", "</th></tr></thead>", "</th></tr></thead>"));
    assertEquals("/</th></tr></thead>/+", StringUtilities.mkPath("/", "</th></tr></thead>", "/+"));
    assertEquals("/</th></tr></thead>/java.lang.Boolean",
        StringUtilities.mkPath("/", "</th></tr></thead>", "java.lang.Boolean"));
    assertEquals("/java.lang.Boolean/Cannot convert empty or null segments to path",
        StringUtilities.mkPath("/", "java.lang.Boolean", "Cannot convert empty or null segments to path"));
    assertEquals("/java.lang.Boolean/: Array was null",
        StringUtilities.mkPath("/", "java.lang.Boolean", ": Array was null"));
    assertEquals("/java.lang.Boolean/: Predicate was null",
        StringUtilities.mkPath("/", "java.lang.Boolean", ": Predicate was null"));
    assertEquals("/java.lang.Boolean/Array must be provided",
        StringUtilities.mkPath("/", "java.lang.Boolean", "Array must be provided"));
    assertEquals("/java.lang.Boolean/Predicate must be provided",
        StringUtilities.mkPath("/", "java.lang.Boolean", "Predicate must be provided"));
    assertEquals("/java.lang.Boolean/Segs", StringUtilities.mkPath("/", "java.lang.Boolean", "Segs"));
    assertEquals("/java.lang.Boolean/42", StringUtilities.mkPath("/", "java.lang.Boolean", "42"));
    assertEquals("/java.lang.Boolean/java.lang.Boolean",
        StringUtilities.mkPath("/", "java.lang.Boolean", "java.lang.Boolean"));
    assertEquals("/java.lang.Boolean/</th></tr></thead>",
        StringUtilities.mkPath("/", "java.lang.Boolean", "</th></tr></thead>"));
    assertEquals("/java.lang.Boolean/+", StringUtilities.mkPath("/", "java.lang.Boolean", "/+"));
    assertEquals("/Cannot convert empty or null segments to path/java.lang.String",
        StringUtilities.mkPath("/", "Cannot convert empty or null segments to path", "java.lang.String"));
  }

  /**
   * Method under test: {@link StringUtilities#capitalise(String)}
   */
  @Test
  void testCapitalise() {
    // Arrange, Act and Assert
    assertEquals("Words", StringUtilities.capitalise("Words"));
    assertEquals("", StringUtilities.capitalise(null));
    assertEquals("", StringUtilities.capitalise(" "));
    assertEquals("Words Words", StringUtilities.capitalise("Words Words"));
  }

  /**
   * Method under test: {@link StringUtilities#sanitizeCharacters(String)}
   */
  @Test
  void testSanitizeCharacters() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.sanitizeCharacters("Str"));
    assertNull(StringUtilities.sanitizeCharacters(null));
    assertEquals("\"", StringUtilities.sanitizeCharacters("“"));
    assertEquals("'", StringUtilities.sanitizeCharacters("‘"));
    assertEquals("", StringUtilities.sanitizeCharacters("​"));
    assertEquals("\"", StringUtilities.sanitizeCharacters("â€œ"));
    assertEquals("\"", StringUtilities.sanitizeCharacters("â€"));
    assertEquals("'", StringUtilities.sanitizeCharacters("â€™"));
    assertEquals(" ", StringUtilities.sanitizeCharacters(" "));
    assertEquals("&", StringUtilities.sanitizeCharacters("&amp;"));
    assertEquals("[-----]", StringUtilities.sanitizeCharacters("[‐–—-]"));
    assertEquals("[\"\"]", StringUtilities.sanitizeCharacters("[”“]"));
    assertEquals("['']", StringUtilities.sanitizeCharacters("[’‘]"));
    assertEquals("-\"", StringUtilities.sanitizeCharacters("-“"));
    assertEquals("-'", StringUtilities.sanitizeCharacters("-‘"));
    assertEquals("-", StringUtilities.sanitizeCharacters("-​"));
    assertEquals("-\"", StringUtilities.sanitizeCharacters("-â€œ"));
    assertEquals("-\"", StringUtilities.sanitizeCharacters("-â€"));
    assertEquals("-'", StringUtilities.sanitizeCharacters("-â€™"));
    assertEquals("- ", StringUtilities.sanitizeCharacters("- "));
    assertEquals("-&", StringUtilities.sanitizeCharacters("-&amp;"));
    assertEquals("-[-----]", StringUtilities.sanitizeCharacters("-[‐–—-]"));
    assertEquals("-[\"\"]", StringUtilities.sanitizeCharacters("-[”“]"));
    assertEquals("-['']", StringUtilities.sanitizeCharacters("-[’‘]"));
    assertEquals("\"-", StringUtilities.sanitizeCharacters("“-"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("““"));
    assertEquals("\"'", StringUtilities.sanitizeCharacters("“‘"));
    assertEquals("\"", StringUtilities.sanitizeCharacters("“​"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("“â€œ"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("“â€"));
    assertEquals("\"Str", StringUtilities.sanitizeCharacters("“Str"));
    assertEquals("\"'", StringUtilities.sanitizeCharacters("“â€™"));
    assertEquals("\"42", StringUtilities.sanitizeCharacters("“42"));
    assertEquals("\" ", StringUtilities.sanitizeCharacters("“ "));
    assertEquals("\"</th></tr></thead>", StringUtilities.sanitizeCharacters("“</th></tr></thead>"));
    assertEquals("\"&", StringUtilities.sanitizeCharacters("“&amp;"));
    assertEquals("\"java.lang.Boolean", StringUtilities.sanitizeCharacters("“java.lang.Boolean"));
    assertEquals("\"[-----]", StringUtilities.sanitizeCharacters("“[‐–—-]"));
    assertEquals("\"java.lang.String", StringUtilities.sanitizeCharacters("“java.lang.String"));
    assertEquals("\"[\"\"]", StringUtilities.sanitizeCharacters("“[”“]"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("“\""));
    assertEquals("\"['']", StringUtilities.sanitizeCharacters("“[’‘]"));
    assertEquals("'-", StringUtilities.sanitizeCharacters("‘-"));
    assertEquals("'\"", StringUtilities.sanitizeCharacters("‘“"));
    assertEquals("''", StringUtilities.sanitizeCharacters("‘‘"));
    assertEquals("'", StringUtilities.sanitizeCharacters("‘​"));
    assertEquals("'\"", StringUtilities.sanitizeCharacters("‘â€œ"));
    assertEquals("'\"", StringUtilities.sanitizeCharacters("‘â€"));
    assertEquals("'Str", StringUtilities.sanitizeCharacters("‘Str"));
    assertEquals("''", StringUtilities.sanitizeCharacters("‘â€™"));
    assertEquals("'42", StringUtilities.sanitizeCharacters("‘42"));
    assertEquals("' ", StringUtilities.sanitizeCharacters("‘ "));
    assertEquals("'</th></tr></thead>", StringUtilities.sanitizeCharacters("‘</th></tr></thead>"));
    assertEquals("'&", StringUtilities.sanitizeCharacters("‘&amp;"));
    assertEquals("'java.lang.Boolean", StringUtilities.sanitizeCharacters("‘java.lang.Boolean"));
    assertEquals("'[-----]", StringUtilities.sanitizeCharacters("‘[‐–—-]"));
    assertEquals("'java.lang.String", StringUtilities.sanitizeCharacters("‘java.lang.String"));
    assertEquals("'[\"\"]", StringUtilities.sanitizeCharacters("‘[”“]"));
    assertEquals("'['']", StringUtilities.sanitizeCharacters("‘[’‘]"));
    assertEquals("-", StringUtilities.sanitizeCharacters("​-"));
    assertEquals("\"", StringUtilities.sanitizeCharacters("​“"));
    assertEquals("'", StringUtilities.sanitizeCharacters("​‘"));
    assertEquals("", StringUtilities.sanitizeCharacters("​​"));
    assertEquals("\"", StringUtilities.sanitizeCharacters("​â€œ"));
    assertEquals("\"", StringUtilities.sanitizeCharacters("​â€"));
    assertEquals("Str", StringUtilities.sanitizeCharacters("​Str"));
    assertEquals("'", StringUtilities.sanitizeCharacters("​â€™"));
    assertEquals("42", StringUtilities.sanitizeCharacters("​42"));
    assertEquals(" ", StringUtilities.sanitizeCharacters("​ "));
    assertEquals("</th></tr></thead>", StringUtilities.sanitizeCharacters("​</th></tr></thead>"));
    assertEquals("&", StringUtilities.sanitizeCharacters("​&amp;"));
    assertEquals("java.lang.Boolean", StringUtilities.sanitizeCharacters("​java.lang.Boolean"));
    assertEquals("[-----]", StringUtilities.sanitizeCharacters("​[‐–—-]"));
    assertEquals("java.lang.String", StringUtilities.sanitizeCharacters("​java.lang.String"));
    assertEquals("[\"\"]", StringUtilities.sanitizeCharacters("​[”“]"));
    assertEquals("['']", StringUtilities.sanitizeCharacters("​[’‘]"));
    assertEquals("\"-", StringUtilities.sanitizeCharacters("â€œ-"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("â€œ“"));
    assertEquals("\"'", StringUtilities.sanitizeCharacters("â€œ‘"));
    assertEquals("\"", StringUtilities.sanitizeCharacters("â€œ​"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("â€œâ€œ"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("â€œâ€"));
    assertEquals("\"Str", StringUtilities.sanitizeCharacters("â€œStr"));
    assertEquals("\"'", StringUtilities.sanitizeCharacters("â€œâ€™"));
    assertEquals("\"42", StringUtilities.sanitizeCharacters("â€œ42"));
    assertEquals("\" ", StringUtilities.sanitizeCharacters("â€œ "));
    assertEquals("\"</th></tr></thead>", StringUtilities.sanitizeCharacters("â€œ</th></tr></thead>"));
    assertEquals("\"&", StringUtilities.sanitizeCharacters("â€œ&amp;"));
    assertEquals("\"java.lang.Boolean", StringUtilities.sanitizeCharacters("â€œjava.lang.Boolean"));
    assertEquals("\"[-----]", StringUtilities.sanitizeCharacters("â€œ[‐–—-]"));
    assertEquals("\"java.lang.String", StringUtilities.sanitizeCharacters("â€œjava.lang.String"));
    assertEquals("\"[\"\"]", StringUtilities.sanitizeCharacters("â€œ[”“]"));
    assertEquals("\"['']", StringUtilities.sanitizeCharacters("â€œ[’‘]"));
    assertEquals("\"-", StringUtilities.sanitizeCharacters("â€-"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("â€“"));
    assertEquals("\"'", StringUtilities.sanitizeCharacters("â€‘"));
    assertEquals("\"", StringUtilities.sanitizeCharacters("â€​"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("â€â€œ"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("â€â€"));
    assertEquals("\"Str", StringUtilities.sanitizeCharacters("â€Str"));
    assertEquals("\"'", StringUtilities.sanitizeCharacters("â€â€™"));
    assertEquals("\"42", StringUtilities.sanitizeCharacters("â€42"));
    assertEquals("\" ", StringUtilities.sanitizeCharacters("â€ "));
    assertEquals("\"</th></tr></thead>", StringUtilities.sanitizeCharacters("â€</th></tr></thead>"));
    assertEquals("\"&", StringUtilities.sanitizeCharacters("â€&amp;"));
    assertEquals("\"java.lang.Boolean", StringUtilities.sanitizeCharacters("â€java.lang.Boolean"));
    assertEquals("\"[-----]", StringUtilities.sanitizeCharacters("â€[‐–—-]"));
    assertEquals("\"java.lang.String", StringUtilities.sanitizeCharacters("â€java.lang.String"));
    assertEquals("\"[\"\"]", StringUtilities.sanitizeCharacters("â€[”“]"));
    assertEquals("\"['']", StringUtilities.sanitizeCharacters("â€[’‘]"));
    assertEquals("Str\"", StringUtilities.sanitizeCharacters("Str“"));
    assertEquals("Str'", StringUtilities.sanitizeCharacters("Str‘"));
    assertEquals("Str", StringUtilities.sanitizeCharacters("Str​"));
    assertEquals("Str\"", StringUtilities.sanitizeCharacters("Strâ€œ"));
    assertEquals("Str\"", StringUtilities.sanitizeCharacters("Strâ€"));
    assertEquals("Str'", StringUtilities.sanitizeCharacters("Strâ€™"));
    assertEquals("Str ", StringUtilities.sanitizeCharacters("Str "));
    assertEquals("Str&", StringUtilities.sanitizeCharacters("Str&amp;"));
    assertEquals("Str[-----]", StringUtilities.sanitizeCharacters("Str[‐–—-]"));
    assertEquals("Str[\"\"]", StringUtilities.sanitizeCharacters("Str[”“]"));
    assertEquals("Str['']", StringUtilities.sanitizeCharacters("Str[’‘]"));
    assertEquals("'-", StringUtilities.sanitizeCharacters("â€™-"));
    assertEquals("'\"", StringUtilities.sanitizeCharacters("â€™“"));
    assertEquals("''", StringUtilities.sanitizeCharacters("â€™‘"));
    assertEquals("'", StringUtilities.sanitizeCharacters("â€™​"));
    assertEquals("'\"", StringUtilities.sanitizeCharacters("â€™â€œ"));
    assertEquals("'\"", StringUtilities.sanitizeCharacters("â€™â€"));
    assertEquals("'Str", StringUtilities.sanitizeCharacters("â€™Str"));
    assertEquals("''", StringUtilities.sanitizeCharacters("â€™â€™"));
    assertEquals("'42", StringUtilities.sanitizeCharacters("â€™42"));
    assertEquals("' ", StringUtilities.sanitizeCharacters("â€™ "));
    assertEquals("'</th></tr></thead>", StringUtilities.sanitizeCharacters("â€™</th></tr></thead>"));
    assertEquals("'&", StringUtilities.sanitizeCharacters("â€™&amp;"));
    assertEquals("'java.lang.Boolean", StringUtilities.sanitizeCharacters("â€™java.lang.Boolean"));
    assertEquals("'[-----]", StringUtilities.sanitizeCharacters("â€™[‐–—-]"));
    assertEquals("'java.lang.String", StringUtilities.sanitizeCharacters("â€™java.lang.String"));
    assertEquals("'[\"\"]", StringUtilities.sanitizeCharacters("â€™[”“]"));
    assertEquals("'['']", StringUtilities.sanitizeCharacters("â€™[’‘]"));
    assertEquals("42\"", StringUtilities.sanitizeCharacters("42“"));
    assertEquals("42'", StringUtilities.sanitizeCharacters("42‘"));
    assertEquals("42", StringUtilities.sanitizeCharacters("42​"));
    assertEquals("42\"", StringUtilities.sanitizeCharacters("42â€œ"));
    assertEquals("42\"", StringUtilities.sanitizeCharacters("42â€"));
    assertEquals("42'", StringUtilities.sanitizeCharacters("42â€™"));
    assertEquals("42 ", StringUtilities.sanitizeCharacters("42 "));
    assertEquals("42&", StringUtilities.sanitizeCharacters("42&amp;"));
    assertEquals("42[-----]", StringUtilities.sanitizeCharacters("42[‐–—-]"));
    assertEquals("42[\"\"]", StringUtilities.sanitizeCharacters("42[”“]"));
    assertEquals("42['']", StringUtilities.sanitizeCharacters("42[’‘]"));
    assertEquals(" -", StringUtilities.sanitizeCharacters(" -"));
    assertEquals(" \"", StringUtilities.sanitizeCharacters(" “"));
    assertEquals(" '", StringUtilities.sanitizeCharacters(" ‘"));
    assertEquals(" ", StringUtilities.sanitizeCharacters(" ​"));
    assertEquals(" \"", StringUtilities.sanitizeCharacters(" â€œ"));
    assertEquals(" \"", StringUtilities.sanitizeCharacters(" â€"));
    assertEquals(" Str", StringUtilities.sanitizeCharacters(" Str"));
    assertEquals(" '", StringUtilities.sanitizeCharacters(" â€™"));
    assertEquals(" 42", StringUtilities.sanitizeCharacters(" 42"));
    assertEquals("  ", StringUtilities.sanitizeCharacters("  "));
    assertEquals(" </th></tr></thead>", StringUtilities.sanitizeCharacters(" </th></tr></thead>"));
    assertEquals(" &", StringUtilities.sanitizeCharacters(" &amp;"));
    assertEquals(" java.lang.Boolean", StringUtilities.sanitizeCharacters(" java.lang.Boolean"));
    assertEquals(" [-----]", StringUtilities.sanitizeCharacters(" [‐–—-]"));
    assertEquals(" java.lang.String", StringUtilities.sanitizeCharacters(" java.lang.String"));
    assertEquals(" [\"\"]", StringUtilities.sanitizeCharacters(" [”“]"));
    assertEquals(" ['']", StringUtilities.sanitizeCharacters(" [’‘]"));
    assertEquals("</th></tr></thead>\"", StringUtilities.sanitizeCharacters("</th></tr></thead>“"));
    assertEquals("</th></tr></thead>'", StringUtilities.sanitizeCharacters("</th></tr></thead>‘"));
    assertEquals("</th></tr></thead>", StringUtilities.sanitizeCharacters("</th></tr></thead>​"));
    assertEquals("</th></tr></thead>\"", StringUtilities.sanitizeCharacters("</th></tr></thead>â€œ"));
    assertEquals("</th></tr></thead>\"", StringUtilities.sanitizeCharacters("</th></tr></thead>â€"));
    assertEquals("</th></tr></thead>'", StringUtilities.sanitizeCharacters("</th></tr></thead>â€™"));
    assertEquals("</th></tr></thead> ", StringUtilities.sanitizeCharacters("</th></tr></thead> "));
    assertEquals("</th></tr></thead>&", StringUtilities.sanitizeCharacters("</th></tr></thead>&amp;"));
    assertEquals("</th></tr></thead>[-----]", StringUtilities.sanitizeCharacters("</th></tr></thead>[‐–—-]"));
    assertEquals("</th></tr></thead>[\"\"]", StringUtilities.sanitizeCharacters("</th></tr></thead>[”“]"));
    assertEquals("</th></tr></thead>['']", StringUtilities.sanitizeCharacters("</th></tr></thead>[’‘]"));
    assertEquals("&-", StringUtilities.sanitizeCharacters("&amp;-"));
    assertEquals("&\"", StringUtilities.sanitizeCharacters("&amp;“"));
    assertEquals("&'", StringUtilities.sanitizeCharacters("&amp;‘"));
    assertEquals("&", StringUtilities.sanitizeCharacters("&amp;​"));
    assertEquals("&\"", StringUtilities.sanitizeCharacters("&amp;â€œ"));
    assertEquals("&\"", StringUtilities.sanitizeCharacters("&amp;â€"));
    assertEquals("&Str", StringUtilities.sanitizeCharacters("&amp;Str"));
    assertEquals("&'", StringUtilities.sanitizeCharacters("&amp;â€™"));
    assertEquals("&42", StringUtilities.sanitizeCharacters("&amp;42"));
    assertEquals("& ", StringUtilities.sanitizeCharacters("&amp; "));
    assertEquals("&</th></tr></thead>", StringUtilities.sanitizeCharacters("&amp;</th></tr></thead>"));
    assertEquals("&&", StringUtilities.sanitizeCharacters("&amp;&amp;"));
    assertEquals("&java.lang.Boolean", StringUtilities.sanitizeCharacters("&amp;java.lang.Boolean"));
    assertEquals("&[-----]", StringUtilities.sanitizeCharacters("&amp;[‐–—-]"));
    assertEquals("&java.lang.String", StringUtilities.sanitizeCharacters("&amp;java.lang.String"));
    assertEquals("&[\"\"]", StringUtilities.sanitizeCharacters("&amp;[”“]"));
    assertEquals("&['']", StringUtilities.sanitizeCharacters("&amp;[’‘]"));
    assertEquals("java.lang.Boolean\"", StringUtilities.sanitizeCharacters("java.lang.Boolean“"));
    assertEquals("java.lang.Boolean'", StringUtilities.sanitizeCharacters("java.lang.Boolean‘"));
    assertEquals("java.lang.Boolean", StringUtilities.sanitizeCharacters("java.lang.Boolean​"));
    assertEquals("java.lang.Boolean\"", StringUtilities.sanitizeCharacters("java.lang.Booleanâ€œ"));
    assertEquals("java.lang.Boolean\"", StringUtilities.sanitizeCharacters("java.lang.Booleanâ€"));
    assertEquals("java.lang.Boolean'", StringUtilities.sanitizeCharacters("java.lang.Booleanâ€™"));
    assertEquals("java.lang.Boolean ", StringUtilities.sanitizeCharacters("java.lang.Boolean "));
    assertEquals("java.lang.Boolean&", StringUtilities.sanitizeCharacters("java.lang.Boolean&amp;"));
    assertEquals("java.lang.Boolean[-----]", StringUtilities.sanitizeCharacters("java.lang.Boolean[‐–—-]"));
    assertEquals("java.lang.Boolean[\"\"]", StringUtilities.sanitizeCharacters("java.lang.Boolean[”“]"));
    assertEquals("java.lang.Boolean['']", StringUtilities.sanitizeCharacters("java.lang.Boolean[’‘]"));
    assertEquals("[-----]-", StringUtilities.sanitizeCharacters("[‐–—-]-"));
    assertEquals("[-----]\"", StringUtilities.sanitizeCharacters("[‐–—-]“"));
    assertEquals("[-----]'", StringUtilities.sanitizeCharacters("[‐–—-]‘"));
    assertEquals("[-----]", StringUtilities.sanitizeCharacters("[‐–—-]​"));
    assertEquals("[-----]\"", StringUtilities.sanitizeCharacters("[‐–—-]â€œ"));
    assertEquals("[-----]\"", StringUtilities.sanitizeCharacters("[‐–—-]â€"));
    assertEquals("[-----]Str", StringUtilities.sanitizeCharacters("[‐–—-]Str"));
    assertEquals("[-----]'", StringUtilities.sanitizeCharacters("[‐–—-]â€™"));
    assertEquals("[-----]42", StringUtilities.sanitizeCharacters("[‐–—-]42"));
    assertEquals("[-----] ", StringUtilities.sanitizeCharacters("[‐–—-] "));
    assertEquals("[-----]</th></tr></thead>", StringUtilities.sanitizeCharacters("[‐–—-]</th></tr></thead>"));
    assertEquals("[-----]&", StringUtilities.sanitizeCharacters("[‐–—-]&amp;"));
    assertEquals("[-----]java.lang.Boolean", StringUtilities.sanitizeCharacters("[‐–—-]java.lang.Boolean"));
    assertEquals("[-----][-----]", StringUtilities.sanitizeCharacters("[‐–—-][‐–—-]"));
    assertEquals("[-----]java.lang.String", StringUtilities.sanitizeCharacters("[‐–—-]java.lang.String"));
    assertEquals("[-----][\"\"]", StringUtilities.sanitizeCharacters("[‐–—-][”“]"));
    assertEquals("[-----]\"", StringUtilities.sanitizeCharacters("[‐–—-]\""));
    assertEquals("[-----]['']", StringUtilities.sanitizeCharacters("[‐–—-][’‘]"));
    assertEquals("java.lang.String\"", StringUtilities.sanitizeCharacters("java.lang.String“"));
    assertEquals("java.lang.String'", StringUtilities.sanitizeCharacters("java.lang.String‘"));
    assertEquals("java.lang.String", StringUtilities.sanitizeCharacters("java.lang.String​"));
    assertEquals("java.lang.String\"", StringUtilities.sanitizeCharacters("java.lang.Stringâ€œ"));
    assertEquals("java.lang.String\"", StringUtilities.sanitizeCharacters("java.lang.Stringâ€"));
    assertEquals("java.lang.String'", StringUtilities.sanitizeCharacters("java.lang.Stringâ€™"));
    assertEquals("java.lang.String ", StringUtilities.sanitizeCharacters("java.lang.String "));
    assertEquals("java.lang.String&", StringUtilities.sanitizeCharacters("java.lang.String&amp;"));
    assertEquals("java.lang.String[-----]", StringUtilities.sanitizeCharacters("java.lang.String[‐–—-]"));
    assertEquals("java.lang.String[\"\"]", StringUtilities.sanitizeCharacters("java.lang.String[”“]"));
    assertEquals("java.lang.String['']", StringUtilities.sanitizeCharacters("java.lang.String[’‘]"));
    assertEquals("[\"\"]-", StringUtilities.sanitizeCharacters("[”“]-"));
    assertEquals("[\"\"]\"", StringUtilities.sanitizeCharacters("[”“]“"));
    assertEquals("[\"\"]'", StringUtilities.sanitizeCharacters("[”“]‘"));
    assertEquals("[\"\"]", StringUtilities.sanitizeCharacters("[”“]​"));
    assertEquals("[\"\"]\"", StringUtilities.sanitizeCharacters("[”“]â€œ"));
    assertEquals("[\"\"]\"", StringUtilities.sanitizeCharacters("[”“]â€"));
    assertEquals("[\"\"]Str", StringUtilities.sanitizeCharacters("[”“]Str"));
    assertEquals("[\"\"]'", StringUtilities.sanitizeCharacters("[”“]â€™"));
    assertEquals("[\"\"]42", StringUtilities.sanitizeCharacters("[”“]42"));
    assertEquals("[\"\"] ", StringUtilities.sanitizeCharacters("[”“] "));
    assertEquals("[\"\"]</th></tr></thead>", StringUtilities.sanitizeCharacters("[”“]</th></tr></thead>"));
    assertEquals("[\"\"]&", StringUtilities.sanitizeCharacters("[”“]&amp;"));
    assertEquals("[\"\"]java.lang.Boolean", StringUtilities.sanitizeCharacters("[”“]java.lang.Boolean"));
    assertEquals("[\"\"][-----]", StringUtilities.sanitizeCharacters("[”“][‐–—-]"));
    assertEquals("[\"\"]java.lang.String", StringUtilities.sanitizeCharacters("[”“]java.lang.String"));
    assertEquals("[\"\"][\"\"]", StringUtilities.sanitizeCharacters("[”“][”“]"));
    assertEquals("[\"\"]\"", StringUtilities.sanitizeCharacters("[”“]\""));
    assertEquals("[\"\"]['']", StringUtilities.sanitizeCharacters("[”“][’‘]"));
    assertEquals("\"\"", StringUtilities.sanitizeCharacters("\"“"));
  }

  /**
   * Method under test: {@link StringUtilities#toMailbox(String, String)}
   */
  @Test
  void testToMailbox() {
    // Arrange, Act and Assert
    assertEquals("Display Name <jane.doe@example.org>",
        StringUtilities.toMailbox("Display Name", "jane.doe@example.org"));
  }

  /**
   * Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  void testToHtmlTable() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();

    // Act and Assert
    assertEquals("<table class='table table-condensed small'><thead><tr><th></th></tr></thead><tbody></tbody></table>",
        StringUtilities.toHtmlTable(headers, new ArrayList<>()));
  }

  /**
   * Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
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
   * Method under test: {@link StringUtilities#toHtmlTable(List, Collection)}
   */
  @Test
  void testToHtmlTable3() {
    // Arrange
    ArrayList<String> headers = new ArrayList<>();
    headers.add("</th><th>");
    headers.add("\n");

    // Act and Assert
    assertEquals("<table class='table table-condensed small'><thead><tr><th></th><th></th><th>\n"
        + "</th></tr></thead><tbody></tbody></table>", StringUtilities.toHtmlTable(headers, new ArrayList<>()));
  }

  /**
   * Method under test: {@link StringUtilities#nullIfEmpty(String)}
   */
  @Test
  void testNullIfEmpty() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtilities.nullIfEmpty("Str"));
    assertNull(StringUtilities.nullIfEmpty(null));
    assertNull(StringUtilities.nullIfEmpty(""));
  }

  /**
   * Method under test: {@link StringUtilities#isDefined(String)}
   */
  @Test
  void testIsDefined() {
    // Arrange, Act and Assert
    assertTrue(StringUtilities.isDefined("Str"));
    assertFalse(StringUtilities.isDefined(null));
    assertFalse(StringUtilities.isDefined(""));
  }

  /**
   * Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  void testFirstNonNull() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull("Xs");

    // Assert
    assertEquals("Xs", actualFirstNonNullResult.get());
    assertTrue(actualFirstNonNullResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  void testFirstNonNull2() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull("");

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  void testFirstNonNull3() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull();

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#firstNonNull(String[])}
   */
  @Test
  void testFirstNonNull4() {
    // Arrange and Act
    Optional<String> actualFirstNonNullResult = StringUtilities.firstNonNull("", null);

    // Assert
    assertFalse(actualFirstNonNullResult.isPresent());
  }

  /**
   * Method under test: {@link StringUtilities#safeEq(String, String)}
   */
  @Test
  void testSafeEq() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEq("Expected", "Actual"));
    assertTrue(StringUtilities.safeEq("Actual", "Actual"));
    assertFalse(StringUtilities.safeEq(null, "Actual"));
    assertFalse(StringUtilities.safeEq("Expected", null));
    assertTrue(StringUtilities.safeEq(null, null));
  }

  /**
   * Method under test: {@link StringUtilities#safeEqIgnoreCase(String, String)}
   */
  @Test
  void testSafeEqIgnoreCase() {
    // Arrange, Act and Assert
    assertFalse(StringUtilities.safeEqIgnoreCase("Expected", "Actual"));
    assertTrue(StringUtilities.safeEqIgnoreCase(null, null));
    assertFalse(StringUtilities.safeEqIgnoreCase(null, "Actual"));
    assertFalse(StringUtilities.safeEqIgnoreCase("Expected", null));
  }

  /**
   * Method under test: {@link StringUtilities#mkExternalId(String)}
   */
  @Test
  void testMkExternalId() {
    // Arrange, Act and Assert
    assertEquals("STR", StringUtilities.mkExternalId("Str"));
    assertEquals("", StringUtilities.mkExternalId(null));
    assertEquals("_", StringUtilities.mkExternalId("-"));
    assertEquals("\"", StringUtilities.mkExternalId("“"));
    assertEquals("'", StringUtilities.mkExternalId("‘"));
    assertEquals("", StringUtilities.mkExternalId("​"));
    assertEquals("\"", StringUtilities.mkExternalId("â€œ"));
    assertEquals("\"", StringUtilities.mkExternalId("â€"));
    assertEquals("'", StringUtilities.mkExternalId("â€™"));
    assertEquals("_", StringUtilities.mkExternalId(" "));
    assertEquals("<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("</th></tr></thead>"));
    assertEquals("_AND_", StringUtilities.mkExternalId("&amp;"));
    assertEquals("JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("java.lang.Boolean"));
    assertEquals("JAVA_LANG_STRING", StringUtilities.mkExternalId("java.lang.String"));
    assertEquals("[_]", StringUtilities.mkExternalId("[‐–—-]"));
    assertEquals("_", StringUtilities.mkExternalId("--"));
    assertEquals("_\"", StringUtilities.mkExternalId("-“"));
    assertEquals("_'", StringUtilities.mkExternalId("-‘"));
    assertEquals("_", StringUtilities.mkExternalId("-​"));
    assertEquals("_\"", StringUtilities.mkExternalId("-â€œ"));
    assertEquals("_\"", StringUtilities.mkExternalId("-â€"));
    assertEquals("_STR", StringUtilities.mkExternalId("-Str"));
    assertEquals("_'", StringUtilities.mkExternalId("-â€™"));
    assertEquals("_42", StringUtilities.mkExternalId("-42"));
    assertEquals("_", StringUtilities.mkExternalId("- "));
    assertEquals("_<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("-</th></tr></thead>"));
    assertEquals("_AND_", StringUtilities.mkExternalId("-&amp;"));
    assertEquals("_JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("-java.lang.Boolean"));
    assertEquals("_JAVA_LANG_STRING", StringUtilities.mkExternalId("-java.lang.String"));
    assertEquals("_", StringUtilities.mkExternalId("-_"));
    assertEquals("_[_]", StringUtilities.mkExternalId("-[‐–—-]"));
    assertEquals("\"_", StringUtilities.mkExternalId("“-"));
    assertEquals("\"\"", StringUtilities.mkExternalId("““"));
    assertEquals("\"'", StringUtilities.mkExternalId("“‘"));
    assertEquals("\"", StringUtilities.mkExternalId("“​"));
    assertEquals("\"\"", StringUtilities.mkExternalId("“â€œ"));
    assertEquals("\"\"", StringUtilities.mkExternalId("“â€"));
    assertEquals("\"STR", StringUtilities.mkExternalId("“Str"));
    assertEquals("\"'", StringUtilities.mkExternalId("“â€™"));
    assertEquals("\"42", StringUtilities.mkExternalId("“42"));
    assertEquals("\"_", StringUtilities.mkExternalId("“ "));
    assertEquals("\"<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("“</th></tr></thead>"));
    assertEquals("\"_AND_", StringUtilities.mkExternalId("“&amp;"));
    assertEquals("\"JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("“java.lang.Boolean"));
    assertEquals("\"_AND_", StringUtilities.mkExternalId("“&"));
    assertEquals("\"JAVA_LANG_STRING", StringUtilities.mkExternalId("“java.lang.String"));
    assertEquals("\"_", StringUtilities.mkExternalId("“ "));
    assertEquals("\"_", StringUtilities.mkExternalId("“_"));
    assertEquals("\"[_]", StringUtilities.mkExternalId("“[‐–—-]"));
    assertEquals("'_", StringUtilities.mkExternalId("‘-"));
    assertEquals("'\"", StringUtilities.mkExternalId("‘“"));
    assertEquals("''", StringUtilities.mkExternalId("‘‘"));
    assertEquals("'", StringUtilities.mkExternalId("‘​"));
    assertEquals("'\"", StringUtilities.mkExternalId("‘â€œ"));
    assertEquals("'\"", StringUtilities.mkExternalId("‘â€"));
    assertEquals("'STR", StringUtilities.mkExternalId("‘Str"));
    assertEquals("''", StringUtilities.mkExternalId("‘â€™"));
    assertEquals("'42", StringUtilities.mkExternalId("‘42"));
    assertEquals("'_", StringUtilities.mkExternalId("‘ "));
    assertEquals("'<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("‘</th></tr></thead>"));
    assertEquals("'_AND_", StringUtilities.mkExternalId("‘&amp;"));
    assertEquals("'JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("‘java.lang.Boolean"));
    assertEquals("'_AND_", StringUtilities.mkExternalId("‘&"));
    assertEquals("'JAVA_LANG_STRING", StringUtilities.mkExternalId("‘java.lang.String"));
    assertEquals("'_", StringUtilities.mkExternalId("‘ "));
    assertEquals("'_", StringUtilities.mkExternalId("‘_"));
    assertEquals("'[_]", StringUtilities.mkExternalId("‘[‐–—-]"));
    assertEquals("_", StringUtilities.mkExternalId("​-"));
    assertEquals("\"", StringUtilities.mkExternalId("​“"));
    assertEquals("'", StringUtilities.mkExternalId("​‘"));
    assertEquals("", StringUtilities.mkExternalId("​​"));
    assertEquals("\"", StringUtilities.mkExternalId("​â€œ"));
    assertEquals("\"", StringUtilities.mkExternalId("​â€"));
    assertEquals("STR", StringUtilities.mkExternalId("​Str"));
    assertEquals("'", StringUtilities.mkExternalId("​â€™"));
    assertEquals("42", StringUtilities.mkExternalId("​42"));
    assertEquals("_", StringUtilities.mkExternalId("​ "));
    assertEquals("<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("​</th></tr></thead>"));
    assertEquals("_AND_", StringUtilities.mkExternalId("​&amp;"));
    assertEquals("JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("​java.lang.Boolean"));
    assertEquals("_AND_", StringUtilities.mkExternalId("​&"));
    assertEquals("JAVA_LANG_STRING", StringUtilities.mkExternalId("​java.lang.String"));
    assertEquals("_", StringUtilities.mkExternalId("​ "));
    assertEquals("_", StringUtilities.mkExternalId("​_"));
    assertEquals("[_]", StringUtilities.mkExternalId("​[‐–—-]"));
    assertEquals("\"_", StringUtilities.mkExternalId("â€œ-"));
    assertEquals("\"\"", StringUtilities.mkExternalId("â€œ“"));
    assertEquals("\"'", StringUtilities.mkExternalId("â€œ‘"));
    assertEquals("\"", StringUtilities.mkExternalId("â€œ​"));
    assertEquals("\"\"", StringUtilities.mkExternalId("â€œâ€œ"));
    assertEquals("\"\"", StringUtilities.mkExternalId("â€œâ€"));
    assertEquals("\"STR", StringUtilities.mkExternalId("â€œStr"));
    assertEquals("\"'", StringUtilities.mkExternalId("â€œâ€™"));
    assertEquals("\"42", StringUtilities.mkExternalId("â€œ42"));
    assertEquals("\"_", StringUtilities.mkExternalId("â€œ "));
    assertEquals("\"<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("â€œ</th></tr></thead>"));
    assertEquals("\"_AND_", StringUtilities.mkExternalId("â€œ&amp;"));
    assertEquals("\"JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("â€œjava.lang.Boolean"));
    assertEquals("\"_AND_", StringUtilities.mkExternalId("â€œ&"));
    assertEquals("\"JAVA_LANG_STRING", StringUtilities.mkExternalId("â€œjava.lang.String"));
    assertEquals("\"_", StringUtilities.mkExternalId("â€œ "));
    assertEquals("\"_", StringUtilities.mkExternalId("â€œ_"));
    assertEquals("\"[_]", StringUtilities.mkExternalId("â€œ[‐–—-]"));
    assertEquals("\"_", StringUtilities.mkExternalId("â€-"));
    assertEquals("\"\"", StringUtilities.mkExternalId("â€“"));
    assertEquals("\"'", StringUtilities.mkExternalId("â€‘"));
    assertEquals("\"", StringUtilities.mkExternalId("â€​"));
    assertEquals("\"\"", StringUtilities.mkExternalId("â€â€œ"));
    assertEquals("\"\"", StringUtilities.mkExternalId("â€â€"));
    assertEquals("\"STR", StringUtilities.mkExternalId("â€Str"));
    assertEquals("\"'", StringUtilities.mkExternalId("â€â€™"));
    assertEquals("\"42", StringUtilities.mkExternalId("â€42"));
    assertEquals("\"_", StringUtilities.mkExternalId("â€ "));
    assertEquals("\"<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("â€</th></tr></thead>"));
    assertEquals("\"_AND_", StringUtilities.mkExternalId("â€&amp;"));
    assertEquals("\"JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("â€java.lang.Boolean"));
    assertEquals("\"_AND_", StringUtilities.mkExternalId("â€&"));
    assertEquals("\"JAVA_LANG_STRING", StringUtilities.mkExternalId("â€java.lang.String"));
    assertEquals("\"_", StringUtilities.mkExternalId("â€ "));
    assertEquals("\"_", StringUtilities.mkExternalId("â€_"));
    assertEquals("\"[_]", StringUtilities.mkExternalId("â€[‐–—-]"));
    assertEquals("STR_", StringUtilities.mkExternalId("Str-"));
    assertEquals("STR\"", StringUtilities.mkExternalId("Str“"));
    assertEquals("STR'", StringUtilities.mkExternalId("Str‘"));
    assertEquals("STR", StringUtilities.mkExternalId("Str​"));
    assertEquals("STR\"", StringUtilities.mkExternalId("Strâ€œ"));
    assertEquals("STR\"", StringUtilities.mkExternalId("Strâ€"));
    assertEquals("STR'", StringUtilities.mkExternalId("Strâ€™"));
    assertEquals("STR_", StringUtilities.mkExternalId("Str "));
    assertEquals("STR<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("Str</th></tr></thead>"));
    assertEquals("STR_AND_", StringUtilities.mkExternalId("Str&amp;"));
    assertEquals("STRJAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("Strjava.lang.Boolean"));
    assertEquals("STRJAVA_LANG_STRING", StringUtilities.mkExternalId("Strjava.lang.String"));
    assertEquals("STR[_]", StringUtilities.mkExternalId("Str[‐–—-]"));
    assertEquals("'_", StringUtilities.mkExternalId("â€™-"));
    assertEquals("'\"", StringUtilities.mkExternalId("â€™“"));
    assertEquals("''", StringUtilities.mkExternalId("â€™‘"));
    assertEquals("'", StringUtilities.mkExternalId("â€™​"));
    assertEquals("'\"", StringUtilities.mkExternalId("â€™â€œ"));
    assertEquals("'\"", StringUtilities.mkExternalId("â€™â€"));
    assertEquals("'STR", StringUtilities.mkExternalId("â€™Str"));
    assertEquals("''", StringUtilities.mkExternalId("â€™â€™"));
    assertEquals("'42", StringUtilities.mkExternalId("â€™42"));
    assertEquals("'_", StringUtilities.mkExternalId("â€™ "));
    assertEquals("'<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("â€™</th></tr></thead>"));
    assertEquals("'_AND_", StringUtilities.mkExternalId("â€™&amp;"));
    assertEquals("'JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("â€™java.lang.Boolean"));
    assertEquals("'_AND_", StringUtilities.mkExternalId("â€™&"));
    assertEquals("'JAVA_LANG_STRING", StringUtilities.mkExternalId("â€™java.lang.String"));
    assertEquals("'_", StringUtilities.mkExternalId("â€™ "));
    assertEquals("'_", StringUtilities.mkExternalId("â€™_"));
    assertEquals("'[_]", StringUtilities.mkExternalId("â€™[‐–—-]"));
    assertEquals("42_", StringUtilities.mkExternalId("42-"));
    assertEquals("42\"", StringUtilities.mkExternalId("42“"));
    assertEquals("42'", StringUtilities.mkExternalId("42‘"));
    assertEquals("42", StringUtilities.mkExternalId("42​"));
    assertEquals("42\"", StringUtilities.mkExternalId("42â€œ"));
    assertEquals("42\"", StringUtilities.mkExternalId("42â€"));
    assertEquals("42'", StringUtilities.mkExternalId("42â€™"));
    assertEquals("42_", StringUtilities.mkExternalId("42 "));
    assertEquals("42<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("42</th></tr></thead>"));
    assertEquals("42_AND_", StringUtilities.mkExternalId("42&amp;"));
    assertEquals("42JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("42java.lang.Boolean"));
    assertEquals("42JAVA_LANG_STRING", StringUtilities.mkExternalId("42java.lang.String"));
    assertEquals("42[_]", StringUtilities.mkExternalId("42[‐–—-]"));
    assertEquals("_", StringUtilities.mkExternalId(" -"));
    assertEquals("_\"", StringUtilities.mkExternalId(" “"));
    assertEquals("_'", StringUtilities.mkExternalId(" ‘"));
    assertEquals("_", StringUtilities.mkExternalId(" ​"));
    assertEquals("_\"", StringUtilities.mkExternalId(" â€œ"));
    assertEquals("_\"", StringUtilities.mkExternalId(" â€"));
    assertEquals("_STR", StringUtilities.mkExternalId(" Str"));
    assertEquals("_'", StringUtilities.mkExternalId(" â€™"));
    assertEquals("_42", StringUtilities.mkExternalId(" 42"));
    assertEquals("_", StringUtilities.mkExternalId("  "));
    assertEquals("_<_TH><_TR><_THEAD>", StringUtilities.mkExternalId(" </th></tr></thead>"));
    assertEquals("_AND_", StringUtilities.mkExternalId(" &amp;"));
    assertEquals("_JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId(" java.lang.Boolean"));
    assertEquals("_AND_", StringUtilities.mkExternalId(" &"));
    assertEquals("_JAVA_LANG_STRING", StringUtilities.mkExternalId(" java.lang.String"));
    assertEquals("_", StringUtilities.mkExternalId("  "));
    assertEquals("_", StringUtilities.mkExternalId(" _"));
    assertEquals("_[_]", StringUtilities.mkExternalId(" [‐–—-]"));
    assertEquals("<_TH><_TR><_THEAD>_", StringUtilities.mkExternalId("</th></tr></thead>-"));
    assertEquals("<_TH><_TR><_THEAD>\"", StringUtilities.mkExternalId("</th></tr></thead>“"));
    assertEquals("<_TH><_TR><_THEAD>'", StringUtilities.mkExternalId("</th></tr></thead>‘"));
    assertEquals("<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("</th></tr></thead>​"));
    assertEquals("<_TH><_TR><_THEAD>\"", StringUtilities.mkExternalId("</th></tr></thead>â€œ"));
    assertEquals("<_TH><_TR><_THEAD>\"", StringUtilities.mkExternalId("</th></tr></thead>â€"));
    assertEquals("<_TH><_TR><_THEAD>STR", StringUtilities.mkExternalId("</th></tr></thead>Str"));
    assertEquals("<_TH><_TR><_THEAD>'", StringUtilities.mkExternalId("</th></tr></thead>â€™"));
    assertEquals("<_TH><_TR><_THEAD>42", StringUtilities.mkExternalId("</th></tr></thead>42"));
    assertEquals("<_TH><_TR><_THEAD>_", StringUtilities.mkExternalId("</th></tr></thead> "));
    assertEquals("<_TH><_TR><_THEAD><_TH><_TR><_THEAD>",
        StringUtilities.mkExternalId("</th></tr></thead></th></tr></thead>"));
    assertEquals("<_TH><_TR><_THEAD>_AND_", StringUtilities.mkExternalId("</th></tr></thead>&amp;"));
    assertEquals("<_TH><_TR><_THEAD>JAVA_LANG_BOOLEAN",
        StringUtilities.mkExternalId("</th></tr></thead>java.lang.Boolean"));
    assertEquals("<_TH><_TR><_THEAD>JAVA_LANG_STRING",
        StringUtilities.mkExternalId("</th></tr></thead>java.lang.String"));
    assertEquals("<_TH><_TR><_THEAD>_", StringUtilities.mkExternalId("</th></tr></thead>_"));
    assertEquals("<_TH><_TR><_THEAD>[_]", StringUtilities.mkExternalId("</th></tr></thead>[‐–—-]"));
    assertEquals("_AND_", StringUtilities.mkExternalId("&amp;-"));
    assertEquals("_AND_\"", StringUtilities.mkExternalId("&amp;“"));
    assertEquals("_AND_'", StringUtilities.mkExternalId("&amp;‘"));
    assertEquals("_AND_", StringUtilities.mkExternalId("&amp;​"));
    assertEquals("_AND_\"", StringUtilities.mkExternalId("&amp;â€œ"));
    assertEquals("_AND_\"", StringUtilities.mkExternalId("&amp;â€"));
    assertEquals("_AND_STR", StringUtilities.mkExternalId("&amp;Str"));
    assertEquals("_AND_'", StringUtilities.mkExternalId("&amp;â€™"));
    assertEquals("_AND_42", StringUtilities.mkExternalId("&amp;42"));
    assertEquals("_AND_", StringUtilities.mkExternalId("&amp; "));
    assertEquals("_AND_<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("&amp;</th></tr></thead>"));
    assertEquals("_AND_AND_", StringUtilities.mkExternalId("&amp;&amp;"));
    assertEquals("_AND_JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("&amp;java.lang.Boolean"));
    assertEquals("_AND_AND_", StringUtilities.mkExternalId("&amp;&"));
    assertEquals("_AND_JAVA_LANG_STRING", StringUtilities.mkExternalId("&amp;java.lang.String"));
    assertEquals("_AND_", StringUtilities.mkExternalId("&amp;_"));
    assertEquals("_AND_[_]", StringUtilities.mkExternalId("&amp;[‐–—-]"));
    assertEquals("JAVA_LANG_BOOLEAN_", StringUtilities.mkExternalId("java.lang.Boolean-"));
    assertEquals("JAVA_LANG_BOOLEAN\"", StringUtilities.mkExternalId("java.lang.Boolean“"));
    assertEquals("JAVA_LANG_BOOLEAN'", StringUtilities.mkExternalId("java.lang.Boolean‘"));
    assertEquals("JAVA_LANG_BOOLEAN", StringUtilities.mkExternalId("java.lang.Boolean​"));
    assertEquals("JAVA_LANG_BOOLEAN\"", StringUtilities.mkExternalId("java.lang.Booleanâ€œ"));
    assertEquals("JAVA_LANG_BOOLEAN\"", StringUtilities.mkExternalId("java.lang.Booleanâ€"));
    assertEquals("JAVA_LANG_BOOLEANSTR", StringUtilities.mkExternalId("java.lang.BooleanStr"));
    assertEquals("JAVA_LANG_BOOLEAN'", StringUtilities.mkExternalId("java.lang.Booleanâ€™"));
    assertEquals("JAVA_LANG_BOOLEAN42", StringUtilities.mkExternalId("java.lang.Boolean42"));
    assertEquals("JAVA_LANG_BOOLEAN_", StringUtilities.mkExternalId("java.lang.Boolean "));
    assertEquals("JAVA_LANG_BOOLEAN<_TH><_TR><_THEAD>",
        StringUtilities.mkExternalId("java.lang.Boolean</th></tr></thead>"));
    assertEquals("JAVA_LANG_BOOLEAN_AND_", StringUtilities.mkExternalId("java.lang.Boolean&amp;"));
    assertEquals("JAVA_LANG_BOOLEANJAVA_LANG_BOOLEAN",
        StringUtilities.mkExternalId("java.lang.Booleanjava.lang.Boolean"));
    assertEquals("JAVA_LANG_BOOLEANJAVA_LANG_STRING",
        StringUtilities.mkExternalId("java.lang.Booleanjava.lang.String"));
    assertEquals("JAVA_LANG_BOOLEAN_", StringUtilities.mkExternalId("java.lang.Boolean_"));
    assertEquals("JAVA_LANG_BOOLEAN[_]", StringUtilities.mkExternalId("java.lang.Boolean[‐–—-]"));
    assertEquals("_AND_\"", StringUtilities.mkExternalId("&“"));
    assertEquals("_AND_'", StringUtilities.mkExternalId("&‘"));
    assertEquals("_AND_", StringUtilities.mkExternalId("&​"));
    assertEquals("_AND_\"", StringUtilities.mkExternalId("&â€œ"));
    assertEquals("_AND_\"", StringUtilities.mkExternalId("&â€"));
    assertEquals("_AND_'", StringUtilities.mkExternalId("&â€™"));
    assertEquals("_AND_", StringUtilities.mkExternalId("& "));
    assertEquals("_AND_AND_", StringUtilities.mkExternalId("&&amp;"));
    assertEquals("_AND_[_]", StringUtilities.mkExternalId("&[‐–—-]"));
    assertEquals("JAVA_LANG_STRING_", StringUtilities.mkExternalId("java.lang.String-"));
    assertEquals("JAVA_LANG_STRING\"", StringUtilities.mkExternalId("java.lang.String“"));
    assertEquals("JAVA_LANG_STRING'", StringUtilities.mkExternalId("java.lang.String‘"));
    assertEquals("JAVA_LANG_STRING", StringUtilities.mkExternalId("java.lang.String​"));
    assertEquals("JAVA_LANG_STRING\"", StringUtilities.mkExternalId("java.lang.Stringâ€œ"));
    assertEquals("JAVA_LANG_STRING\"", StringUtilities.mkExternalId("java.lang.Stringâ€"));
    assertEquals("JAVA_LANG_STRINGSTR", StringUtilities.mkExternalId("java.lang.StringStr"));
    assertEquals("JAVA_LANG_STRING'", StringUtilities.mkExternalId("java.lang.Stringâ€™"));
    assertEquals("JAVA_LANG_STRING42", StringUtilities.mkExternalId("java.lang.String42"));
    assertEquals("JAVA_LANG_STRING_", StringUtilities.mkExternalId("java.lang.String "));
    assertEquals("JAVA_LANG_STRING<_TH><_TR><_THEAD>",
        StringUtilities.mkExternalId("java.lang.String</th></tr></thead>"));
    assertEquals("JAVA_LANG_STRING_AND_", StringUtilities.mkExternalId("java.lang.String&amp;"));
    assertEquals("JAVA_LANG_STRINGJAVA_LANG_BOOLEAN",
        StringUtilities.mkExternalId("java.lang.Stringjava.lang.Boolean"));
    assertEquals("JAVA_LANG_STRINGJAVA_LANG_STRING", StringUtilities.mkExternalId("java.lang.Stringjava.lang.String"));
    assertEquals("JAVA_LANG_STRING_", StringUtilities.mkExternalId("java.lang.String_"));
    assertEquals("JAVA_LANG_STRING[_]", StringUtilities.mkExternalId("java.lang.String[‐–—-]"));
    assertEquals("_\"", StringUtilities.mkExternalId(" “"));
    assertEquals("_'", StringUtilities.mkExternalId(" ‘"));
    assertEquals("_", StringUtilities.mkExternalId(" ​"));
    assertEquals("_\"", StringUtilities.mkExternalId(" â€œ"));
    assertEquals("_\"", StringUtilities.mkExternalId(" â€"));
    assertEquals("_'", StringUtilities.mkExternalId(" â€™"));
    assertEquals("_", StringUtilities.mkExternalId("  "));
    assertEquals("_[_]", StringUtilities.mkExternalId(" [‐–—-]"));
    assertEquals("_", StringUtilities.mkExternalId("_-"));
    assertEquals("_\"", StringUtilities.mkExternalId("_“"));
    assertEquals("_'", StringUtilities.mkExternalId("_‘"));
    assertEquals("_", StringUtilities.mkExternalId("_​"));
    assertEquals("_\"", StringUtilities.mkExternalId("_â€œ"));
    assertEquals("_\"", StringUtilities.mkExternalId("_â€"));
    assertEquals("_'", StringUtilities.mkExternalId("_â€™"));
    assertEquals("_", StringUtilities.mkExternalId("_ "));
    assertEquals("_<_TH><_TR><_THEAD>", StringUtilities.mkExternalId("_</th></tr></thead>"));
    assertEquals("_AND_", StringUtilities.mkExternalId("_&amp;"));
  }
}
