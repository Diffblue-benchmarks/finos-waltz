package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SearchUtilitiesDiffblueTest {
  /**
   * Test {@link SearchUtilities#mkTerms(String)}.
   *
   * <ul>
   *   <li>When {@code 42[}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  @DisplayName("Test mkTerms(String); when '42['; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SearchUtilities.mkTerms(String)"})
  void testMkTerms_when42_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualMkTermsResult = SearchUtilities.mkTerms("42[");

    // Assert
    assertTrue(actualMkTermsResult.isEmpty());
  }

  /**
   * Test {@link SearchUtilities#mkTerms(String)}.
   *
   * <ul>
   *   <li>When {@code [}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  @DisplayName("Test mkTerms(String); when '['; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SearchUtilities.mkTerms(String)"})
  void testMkTerms_whenLeftSquareBracket_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualMkTermsResult = SearchUtilities.mkTerms("[");

    // Assert
    assertTrue(actualMkTermsResult.isEmpty());
  }

  /**
   * Test {@link SearchUtilities#mkTerms(String)}.
   *
   * <ul>
   *   <li>When {@code query cannot be null}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  @DisplayName("Test mkTerms(String); when 'query cannot be null'; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SearchUtilities.mkTerms(String)"})
  void testMkTerms_whenQueryCannotBeNull_thenReturnSizeIsFour() {
    // Arrange and Act
    List<String> actualMkTermsResult = SearchUtilities.mkTerms("query cannot be null");

    // Assert
    assertEquals(4, actualMkTermsResult.size());
    assertEquals("be", actualMkTermsResult.get(2));
    assertEquals("cannot", actualMkTermsResult.get(1));
    assertEquals("null", actualMkTermsResult.get(3));
    assertEquals("query", actualMkTermsResult.get(0));
  }

  /**
   * Test {@link SearchUtilities#mkTerms(String)}.
   *
   * <ul>
   *   <li>When {@code Query}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  @DisplayName("Test mkTerms(String); when 'Query'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SearchUtilities.mkTerms(String)"})
  void testMkTerms_whenQuery_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualMkTermsResult = SearchUtilities.mkTerms("Query");

    // Assert
    assertEquals(1, actualMkTermsResult.size());
    assertEquals("Query", actualMkTermsResult.get(0));
  }

  /**
   * Test {@link SearchUtilities#mkRelevancyComparator(Function, String)}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return compare {@code 42} and {@code 42} is zero.
   * </ul>
   *
   * <p>Method under test: {@link SearchUtilities#mkRelevancyComparator(Function, String)}
   */
  @Test
  @DisplayName(
      "Test mkRelevancyComparator(Function, String); given 'Apply'; then return compare '42' and '42' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparator SearchUtilities.mkRelevancyComparator(Function, String)"})
  void testMkRelevancyComparator_givenApply_thenReturnCompare42And42IsZero() {
    // Arrange
    Function<Object, String> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Comparator<Object> actualMkRelevancyComparatorResult =
        SearchUtilities.mkRelevancyComparator(extractor, "Term");
    int actualCompareResult = actualMkRelevancyComparatorResult.compare("42", "42");

    // Assert
    verify(extractor, atLeast(1)).apply(isA(Object.class));
    assertEquals(0, actualCompareResult);
  }

  /**
   * Test {@link SearchUtilities#mkRelevancyComparator(Function, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return compare {@code 42} and {@code 42} is zero.
   * </ul>
   *
   * <p>Method under test: {@link SearchUtilities#mkRelevancyComparator(Function, String)}
   */
  @Test
  @DisplayName(
      "Test mkRelevancyComparator(Function, String); when empty string; then return compare '42' and '42' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Comparator SearchUtilities.mkRelevancyComparator(Function, String)"})
  void testMkRelevancyComparator_whenEmptyString_thenReturnCompare42And42IsZero() {
    // Arrange
    Function<Object, String> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Comparator<Object> actualMkRelevancyComparatorResult =
        SearchUtilities.mkRelevancyComparator(extractor, "");
    int actualCompareResult = actualMkRelevancyComparatorResult.compare("42", "42");

    // Assert
    verify(extractor, atLeast(1)).apply(isA(Object.class));
    assertEquals(0, actualCompareResult);
  }
}
