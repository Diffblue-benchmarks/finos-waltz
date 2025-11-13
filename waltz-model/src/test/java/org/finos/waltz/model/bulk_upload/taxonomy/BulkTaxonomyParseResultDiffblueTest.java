package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
   *   <li>Then return parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyParseResult#mkResult(List, String)}
   */
  @Test
  @DisplayName(
      "Test mkResult(List, String); given Json (default constructor); when ArrayList() add Json (default constructor); then return parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyParseResult.mkResult(List, String)"})
  void testMkResult_givenJson_whenArrayListAddJson_thenReturnParsedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkTaxonomyItem> items = new ArrayList<>();
    Json json = new Json();
    items.add(json);

    // Act
    BulkTaxonomyParseResult actualMkResultResult = BulkTaxonomyParseResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableBulkTaxonomyParseResult);
    List<BulkTaxonomyItem> parsedItemsResult = actualMkResultResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
  }

  /**
   * Test {@link BulkTaxonomyParseResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Then return parsedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyParseResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); then return parsedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyParseResult.mkResult(List, String)"})
  void testMkResult_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkTaxonomyItem> items = new ArrayList<>();
    items.add(
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());
    items.add(
        1,
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());

    // Act
    BulkTaxonomyParseResult actualMkResultResult = BulkTaxonomyParseResult.mkResult(items, "Input");

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = actualMkResultResult.parsedItems();
    assertEquals(2, parsedItemsResult.size());
    BulkTaxonomyItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkTaxonomyItem);
    BulkTaxonomyItem getResult2 = parsedItemsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableBulkTaxonomyItem);
    assertTrue(actualMkResultResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("42", getResult.externalId());
    assertEquals("42", getResult.parentExternalId());
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
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
