package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RatingResolutionErrorDiffblueTest {
  /**
   * Test {@link RatingResolutionError#mkError(RatingResolutionErrorCode, String)}.
   *
   * <p>Method under test: {@link RatingResolutionError#mkError(RatingResolutionErrorCode, String)}
   */
  @Test
  @DisplayName("Test mkError(RatingResolutionErrorCode, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RatingResolutionError RatingResolutionError.mkError(RatingResolutionErrorCode, String)"
  })
  void testMkError() {
    // Arrange and Act
    RatingResolutionError actualMkErrorResult =
        RatingResolutionError.mkError(
            RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, "Not all who wander are lost");

    // Assert
    assertTrue(actualMkErrorResult instanceof ImmutableRatingResolutionError);
    assertEquals("Not all who wander are lost", actualMkErrorResult.errorMessage());
    assertEquals(
        RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualMkErrorResult.errorCode());
  }
}
