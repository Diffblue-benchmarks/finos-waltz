package org.finos.waltz.model.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MeasurableRatingPercentageDiffblueTest {
  /**
   * Test {@link MeasurableRatingPercentage#mkMeasurableRatingPercentage(long, int)}.
   *
   * <p>Method under test: {@link MeasurableRatingPercentage#mkMeasurableRatingPercentage(long,
   * int)}
   */
  @Test
  @DisplayName("Test mkMeasurableRatingPercentage(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPercentage MeasurableRatingPercentage.mkMeasurableRatingPercentage(long, int)"
  })
  void testMkMeasurableRatingPercentage() {
    // Arrange and Act
    MeasurableRatingPercentage actualMkMeasurableRatingPercentageResult =
        MeasurableRatingPercentage.mkMeasurableRatingPercentage(1L, 1);

    // Assert
    assertTrue(
        actualMkMeasurableRatingPercentageResult instanceof ImmutableMeasurableRatingPercentage);
    assertEquals(1, actualMkMeasurableRatingPercentageResult.percentage());
    assertEquals(1L, actualMkMeasurableRatingPercentageResult.measurableRatingId());
  }
}
