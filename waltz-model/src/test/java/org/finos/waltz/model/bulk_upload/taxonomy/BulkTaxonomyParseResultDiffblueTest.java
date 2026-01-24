package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkTaxonomyParseResultDiffblueTest {
  /**
   * Test {@link BulkTaxonomyParseResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Given {@link Json} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link Json} (default constructor).
   *   <li>Then return parsedItems is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyParseResult#mkResult(List, String)}
   */
  @Test
  @DisplayName(
      "Test mkResult(List, String); given Json (default constructor); when ArrayList() add Json (default constructor); then return parsedItems is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyParseResult.mkResult(List, String)"})
  void testMkResult_givenJson_whenArrayListAddJson_thenReturnParsedItemsIsArrayList() {
    // Arrange
    ArrayList<BulkTaxonomyItem> items = new ArrayList<>();
    items.add(new Json());

    // Act
    BulkTaxonomyParseResult actualMkResultResult = BulkTaxonomyParseResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals(items, actualMkResultResult.parsedItems());
  }

  /**
   * Test {@link BulkTaxonomyParseResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyParseResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); when ArrayList(); then return 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyParseResult.mkResult(List, String)"})
  void testMkResult_whenArrayList_thenReturnInput() {
    // Arrange and Act
    BulkTaxonomyParseResult actualMkResultResult =
        BulkTaxonomyParseResult.mkResult(new ArrayList<>(), "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }
}
