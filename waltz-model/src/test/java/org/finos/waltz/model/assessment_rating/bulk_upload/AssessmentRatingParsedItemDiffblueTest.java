package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentRatingParsedItemDiffblueTest {
  /**
   * Test {@link AssessmentRatingParsedItem#isReadOnly()}.
   *
   * <p>Method under test: {@link AssessmentRatingParsedItem#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingParsedItem.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build()
            .isReadOnly());
  }
}
