package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BulkTaxonomyParseResultDiffblueTest {
  /**
   * Method under test: {@link BulkTaxonomyParseResult#mkResult(List, String)}
   */
  @Test
  void testMkResult() {
    // Arrange and Act
    BulkTaxonomyParseResult actualMkResultResult = BulkTaxonomyParseResult.mkResult(new ArrayList<>(), "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }

  /**
   * Method under test: {@link BulkTaxonomyParseResult#mkResult(List, String)}
   */
  @Test
  void testMkResult2() {
    // Arrange
    ArrayList<BulkTaxonomyItem> items = new ArrayList<>();
    items.add(new ImmutableBulkTaxonomyItem.Json());

    // Act
    BulkTaxonomyParseResult actualMkResultResult = BulkTaxonomyParseResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertEquals(items, actualMkResultResult.parsedItems());
  }
}
