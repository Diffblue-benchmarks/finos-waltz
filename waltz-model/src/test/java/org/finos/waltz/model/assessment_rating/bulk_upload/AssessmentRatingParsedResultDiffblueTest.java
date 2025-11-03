package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Json} (default constructor).</li>
   *   <li>Then return parsedItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); given Json (default constructor); when ArrayList() add Json (default constructor); then return parsedItems is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult AssessmentRatingParsedResult.mkResult(List, String)"})
  void testMkResult_givenJson_whenArrayListAddJson_thenReturnParsedItemsIsArrayList() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> items = new ArrayList<>();
    items.add(new Json());

    // Act
    AssessmentRatingParsedResult actualMkResultResult = AssessmentRatingParsedResult.mkResult(items, "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals(items, actualMkResultResult.parsedItems());
  }

  /**
   * Test {@link AssessmentRatingParsedResult#mkResult(List, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingParsedResult#mkResult(List, String)}
   */
  @Test
  @DisplayName("Test mkResult(List, String); when ArrayList(); then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult AssessmentRatingParsedResult.mkResult(List, String)"})
  void testMkResult_whenArrayList_thenReturnInput() {
    // Arrange and Act
    AssessmentRatingParsedResult actualMkResultResult = AssessmentRatingParsedResult.mkResult(new ArrayList<>(),
        "Input");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Input", actualMkResultResult.input());
    assertNull(actualMkResultResult.error());
    assertTrue(actualMkResultResult.parsedItems().isEmpty());
  }
}
