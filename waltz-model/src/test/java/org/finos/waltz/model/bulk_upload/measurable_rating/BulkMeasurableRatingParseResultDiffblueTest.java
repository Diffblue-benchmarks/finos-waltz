package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BulkMeasurableRatingParseResultDiffblueTest {
  /**
   * Method under test:
   * {@link BulkMeasurableRatingParseResult#mkResult(List, String)}
   */
  @Test
  void testMkResult() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualMkResultResult = BulkMeasurableRatingParseResult.mkResult(new ArrayList<>(),
        "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingParseResult#mkResult(List, String)}
   */
  @Test
  void testMkResult2() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> items = new ArrayList<>();
    items.add(new ImmutableBulkMeasurableRatingItem.Json());

    // Act
    BulkMeasurableRatingParseResult actualMkResultResult = BulkMeasurableRatingParseResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertEquals(items, actualMkResultResult.parsedItems());
  }
}
