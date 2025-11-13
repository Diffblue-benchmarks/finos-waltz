package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentRatingOperationsDiffblueTest {
  /**
   * Test {@link AssessmentRatingOperations#isDefault()}.
   *
   * <ul>
   *   <li>Given builder ratingId one build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingOperations#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); given builder ratingId one build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingOperations.isDefault()"})
  void testIsDefault_givenBuilderRatingIdOneBuild_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImmutableAssessmentRatingOperations.builder().ratingId(1L).build().isDefault());
  }
}
