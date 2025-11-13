package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkMeasurableRatingParseResultDiffblueTest {
  /**
   * Test {@link BulkMeasurableRatingParseResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Given {@link Json} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link Json} (default constructor).
   *   <li>Then return parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingParseResult#mkResult(List, String)}
   */
  @Test
  @DisplayName(
      "Test mkResult(List, String); given Json (default constructor); when ArrayList() add Json (default constructor); then return parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingParseResult BulkMeasurableRatingParseResult.mkResult(List, String)"
  })
  void testMkResult_givenJson_whenArrayListAddJson_thenReturnParsedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> items = new ArrayList<>();
    Json json = new Json();
    items.add(json);

    // Act
    BulkMeasurableRatingParseResult actualMkResultResult =
        BulkMeasurableRatingParseResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkMeasurableRatingParseResult);
    List<BulkMeasurableRatingItem> parsedItemsResult = actualMkResultResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
  }

  /**
   * Test {@link BulkMeasurableRatingParseResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Then return parsedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingParseResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); then return parsedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingParseResult BulkMeasurableRatingParseResult.mkResult(List, String)"
  })
  void testMkResult_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> items = new ArrayList<>();
    items.add(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
    items.add(
        1,
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());

    // Act
    BulkMeasurableRatingParseResult actualMkResultResult =
        BulkMeasurableRatingParseResult.mkResult(items, "Input");

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = actualMkResultResult.parsedItems();
    assertEquals(2, parsedItemsResult.size());
    BulkMeasurableRatingItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkMeasurableRatingItem);
    BulkMeasurableRatingItem getResult2 = parsedItemsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(actualMkResultResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("42", getResult.taxonomyExternalId());
    assertEquals("Asset Code", getResult.assetCode());
    assertEquals("Comment", getResult.comment());
    assertEquals("Scheme", getResult.scheme());
    assertEquals('A', getResult.ratingCode());
    assertEquals(1, getResult.allocation().intValue());
    assertFalse(getResult.isPrimary());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link BulkMeasurableRatingParseResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingParseResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); when ArrayList(); then return 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingParseResult BulkMeasurableRatingParseResult.mkResult(List, String)"
  })
  void testMkResult_whenArrayList_thenReturnInput() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualMkResultResult =
        BulkMeasurableRatingParseResult.mkResult(new ArrayList<>(), "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }
}
