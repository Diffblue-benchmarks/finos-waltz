package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
   *   <li>Then return parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName(
      "Test mkResult(List, String); given Json (default constructor); when ArrayList() add Json (default constructor); then return parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipParsedResult BulkUploadRelationshipParsedResult.mkResult(List, String)"
  })
  void testMkResult_givenJson_whenArrayListAddJson_thenReturnParsedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> items = new ArrayList<>();
    Json json = new Json();
    items.add(json);

    // Act
    BulkUploadRelationshipParsedResult actualMkResultResult =
        BulkUploadRelationshipParsedResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    List<BulkUploadRelationshipItem> parsedItemsResult = actualMkResultResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
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

  /**
   * Test {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Then return parsedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); then return parsedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipParsedResult BulkUploadRelationshipParsedResult.mkResult(List, String)"
  })
  void testMkResult_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> items = new ArrayList<>();
    items.add(
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());
    items.add(
        1,
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());

    // Act
    BulkUploadRelationshipParsedResult actualMkResultResult =
        BulkUploadRelationshipParsedResult.mkResult(items, "Input");

    // Assert
    List<BulkUploadRelationshipItem> parsedItemsResult = actualMkResultResult.parsedItems();
    assertEquals(2, parsedItemsResult.size());
    BulkUploadRelationshipItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUploadRelationshipItem);
    BulkUploadRelationshipItem getResult2 = parsedItemsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertTrue(actualMkResultResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("42", getResult.sourceExternalId());
    assertEquals("42", getResult.targetExternalId());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(getResult, getResult2);
  }
}
