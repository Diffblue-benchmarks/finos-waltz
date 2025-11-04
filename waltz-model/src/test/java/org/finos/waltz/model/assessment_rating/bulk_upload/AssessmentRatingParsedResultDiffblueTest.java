package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AssessmentRatingParsedResultDiffblueTest {
  /**
   * Method under test:
   * {@link AssessmentRatingParsedResult#mkResult(List, String)}
   */
  @Test
  void testMkResult() {
    // Arrange and Act
    AssessmentRatingParsedResult actualMkResultResult = AssessmentRatingParsedResult.mkResult(new ArrayList<>(),
        "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingParsedResult#mkResult(List, String)}
   */
  @Test
  void testMkResult2() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> items = new ArrayList<>();
    items.add(new ImmutableAssessmentRatingParsedItem.Json());

    // Act
    AssessmentRatingParsedResult actualMkResultResult = AssessmentRatingParsedResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertEquals(items, actualMkResultResult.parsedItems());
  }
}
