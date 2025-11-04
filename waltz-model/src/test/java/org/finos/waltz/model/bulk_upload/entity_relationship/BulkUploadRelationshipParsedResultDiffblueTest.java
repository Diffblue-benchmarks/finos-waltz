package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BulkUploadRelationshipParsedResultDiffblueTest {
  /**
   * Method under test:
   * {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}
   */
  @Test
  void testMkResult() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualMkResultResult = BulkUploadRelationshipParsedResult
        .mkResult(new ArrayList<>(), "Input");

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualMkResultResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualMkResultResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot parse input.", errorResult.message());
    assertEquals("Input", actualMkResultResult.input());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}
   */
  @Test
  void testMkResult2() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> items = new ArrayList<>();
    items.add(new ImmutableBulkUploadRelationshipItem.Json());

    // Act
    BulkUploadRelationshipParsedResult actualMkResultResult = BulkUploadRelationshipParsedResult.mkResult(items,
        "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertEquals(items, actualMkResultResult.parsedItems());
  }
}
