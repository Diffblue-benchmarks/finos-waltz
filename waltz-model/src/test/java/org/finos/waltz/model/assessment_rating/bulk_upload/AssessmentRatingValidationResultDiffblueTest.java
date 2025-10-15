package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidationResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentRatingValidationResultDiffblueTest {
  /**
   * Test {@link AssessmentRatingValidationResult#removalCount()}.
   *
   * <p>Method under test: {@link AssessmentRatingValidationResult#removalCount()}
   */
  @Test
  @DisplayName("Test removalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingValidationResult.removalCount()"})
  void testRemovalCount() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act and Assert
    assertEquals(
        0,
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build()
            .removalCount());
  }
}
