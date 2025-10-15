package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidationResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkMeasurableRatingValidationResultDiffblueTest {
  /**
   * Test {@link BulkMeasurableRatingValidationResult#removalCount()}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingValidationResult#removalCount()}
   */
  @Test
  @DisplayName("Test removalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BulkMeasurableRatingValidationResult.removalCount()"})
  void testRemovalCount() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act and Assert
    assertEquals(
        0,
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build()
            .removalCount());
  }
}
