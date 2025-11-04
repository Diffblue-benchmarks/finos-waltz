package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SearchUtilitiesDiffblueTest {
  /**
   * Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  void testMkTerms() {
    // Arrange and Act
    List<String> actualMkTermsResult = SearchUtilities.mkTerms("Query");

    // Assert
    assertEquals(1, actualMkTermsResult.size());
    assertEquals("Query", actualMkTermsResult.get(0));
  }

  /**
   * Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  void testMkTerms2() {
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
   * Method under test: {@link SearchUtilities#mkTerms(String)}
   */
  @Test
  void testMkTerms3() {
    // Arrange and Act
    List<String> actualMkTermsResult = SearchUtilities.mkTerms("[");

    // Assert
    assertTrue(actualMkTermsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SearchUtilities#mkRelevancyComparator(Function, String)}
   */
  @Test
  void testMkRelevancyComparator() {
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

  /**
   * Method under test:
   * {@link SearchUtilities#mkRelevancyComparator(Function, String)}
   */
  @Test
  void testMkRelevancyComparator2() {
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
}
