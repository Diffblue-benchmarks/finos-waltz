package org.finos.waltz.model.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MeasurableRatingPercentageDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingPercentage#mkMeasurableRatingPercentage(long, int)}
   */
  @Test
  void testMkMeasurableRatingPercentage() {
    // Arrange and Act
    MeasurableRatingPercentage actualMkMeasurableRatingPercentageResult = MeasurableRatingPercentage
        .mkMeasurableRatingPercentage(1L, 1);

    // Assert
    assertTrue(actualMkMeasurableRatingPercentageResult instanceof ImmutableMeasurableRatingPercentage);
    assertEquals(1, actualMkMeasurableRatingPercentageResult.percentage());
    assertEquals(1L, actualMkMeasurableRatingPercentageResult.measurableRatingId());
  }
}
