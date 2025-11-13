package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentRatingParsedResultDiffblueTest {
  /**
   * Test {@link AssessmentRatingParsedResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Given {@link Json} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link Json} (default constructor).
   *   <li>Then return parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName(
      "Test mkResult(List, String); given Json (default constructor); when ArrayList() add Json (default constructor); then return parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult AssessmentRatingParsedResult.mkResult(List, String)"
  })
  void testMkResult_givenJson_whenArrayListAddJson_thenReturnParsedItemsSizeIsOne() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> items = new ArrayList<>();
    Json json = new Json();
    items.add(json);

    // Act
    AssessmentRatingParsedResult actualMkResultResult =
        AssessmentRatingParsedResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableAssessmentRatingParsedResult);
    List<AssessmentRatingParsedItem> parsedItemsResult = actualMkResultResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
  }

  /**
   * Test {@link AssessmentRatingParsedResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>Then return parsedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); then return parsedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult AssessmentRatingParsedResult.mkResult(List, String)"
  })
  void testMkResult_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> items = new ArrayList<>();
    items.add(
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());
    items.add(
        1,
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());

    // Act
    AssessmentRatingParsedResult actualMkResultResult =
        AssessmentRatingParsedResult.mkResult(items, "Input");

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = actualMkResultResult.parsedItems();
    assertEquals(2, parsedItemsResult.size());
    AssessmentRatingParsedItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRatingParsedItem);
    AssessmentRatingParsedItem getResult2 = parsedItemsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(actualMkResultResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("42", getResult.externalId());
    assertEquals("Comment", getResult.comment());
    assertEquals("Rating Code", getResult.ratingCode());
    assertFalse(getResult.isReadOnly());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link AssessmentRatingParsedResult#mkResult(List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); when ArrayList(); then return 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult AssessmentRatingParsedResult.mkResult(List, String)"
  })
  void testMkResult_whenArrayList_thenReturnInput() {
    // Arrange and Act
    AssessmentRatingParsedResult actualMkResultResult =
        AssessmentRatingParsedResult.mkResult(new ArrayList<>(), "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }
}
