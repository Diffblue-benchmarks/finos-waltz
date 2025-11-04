package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RatingResolutionErrorDiffblueTest {
  /**
   * Method under test:
   * {@link RatingResolutionError#mkError(RatingResolutionErrorCode, String)}
   */
  @Test
  void testMkError() {
    // Arrange and Act
    RatingResolutionError actualMkErrorResult = RatingResolutionError
        .mkError(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, "Not all who wander are lost");

    // Assert
    assertTrue(actualMkErrorResult instanceof ImmutableRatingResolutionError);
    assertEquals("Not all who wander are lost", actualMkErrorResult.errorMessage());
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualMkErrorResult.errorCode());
  }
}
