package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * <ul>
   *   <li>When {@code [}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  @DisplayName("Test mkTerms(String); when '['; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SearchUtilities.mkTerms(String)"})
  void testMkTerms_whenLeftSquareBracket_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualMkTermsResult = SearchUtilities.mkTerms("[");

    // Assert
    assertTrue(actualMkTermsResult.isEmpty());
  }

  /**
   * Test {@link SearchUtilities#mkTerms(String)}.
   * <ul>
   *   <li>When {@code query cannot be null}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  @DisplayName("Test mkTerms(String); when 'query cannot be null'; then return size is four")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code Query}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  @DisplayName("Test mkTerms(String); when 'Query'; then return size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUtilities#mkRelevancyComparator(Function, String)}
   */
  @Test
  @DisplayName("Test mkRelevancyComparator(Function, String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Comparator SearchUtilities.mkRelevancyComparator(Function, String)"})
  void testMkRelevancyComparator_whenEmptyString() {
    // Arrange
    Function<Object, String> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Comparator<Object> actualMkRelevancyComparatorResult = SearchUtilities.mkRelevancyComparator(extractor, "");
    int actualCompareResult = actualMkRelevancyComparatorResult.compare("42", "42");

    // Assert
    verify(extractor, atLeast(1)).apply(isA(Object.class));
    assertEquals(0, actualCompareResult);
  }

  /**
   * Test {@link SearchUtilities#mkRelevancyComparator(Function, String)}.
   * <ul>
   *   <li>When {@code Term}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUtilities#mkRelevancyComparator(Function, String)}
   */
  @Test
  @DisplayName("Test mkRelevancyComparator(Function, String); when 'Term'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Comparator SearchUtilities.mkRelevancyComparator(Function, String)"})
  void testMkRelevancyComparator_whenTerm() {
    // Arrange
    Function<Object, String> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Comparator<Object> actualMkRelevancyComparatorResult = SearchUtilities.mkRelevancyComparator(extractor, "Term");
    int actualCompareResult = actualMkRelevancyComparatorResult.compare("42", "42");

    // Assert
    verify(extractor, atLeast(1)).apply(isA(Object.class));
    assertEquals(0, actualCompareResult);
  }
}
