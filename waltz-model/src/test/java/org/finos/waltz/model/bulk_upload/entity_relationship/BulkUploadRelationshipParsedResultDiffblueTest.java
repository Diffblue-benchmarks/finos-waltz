package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkUploadRelationshipParsedResultDiffblueTest {
  /**
   * Test {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Given {@link Json} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link Json} (default constructor).
   *   <li>Then return error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName(
      "Test mkResult(List, String); given Json (default constructor); when ArrayList() add Json (default constructor); then return error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipParsedResult BulkUploadRelationshipParsedResult.mkResult(List, String)"
  })
  void testMkResult_givenJson_whenArrayListAddJson_thenReturnErrorIsNull() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> items = new ArrayList<>();
    items.add(new Json());

    // Act
    BulkUploadRelationshipParsedResult actualMkResultResult =
        BulkUploadRelationshipParsedResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertNull(actualMkResultResult.error());
    assertEquals(items, actualMkResultResult.parsedItems());
  }

  /**
   * Test {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkUploadRelationshipParseError}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName(
      "Test mkResult(List, String); then error return ImmutableBulkUploadRelationshipParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipParsedResult BulkUploadRelationshipParsedResult.mkResult(List, String)"
  })
  void testMkResult_thenErrorReturnImmutableBulkUploadRelationshipParseError() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualMkResultResult =
        BulkUploadRelationshipParsedResult.mkResult(new ArrayList<>(), "Input");

    // Assert
    BulkUploadRelationshipParseError errorResult = actualMkResultResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualMkResultResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot parse input.", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }
}
