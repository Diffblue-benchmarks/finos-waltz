package org.finos.waltz.model.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MeasurableRatingPlannedDecommissionDiffblueTest {
  /**
   * Test {@link MeasurableRatingPlannedDecommission#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommission#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommission.isValid()"})
  void testIsValid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build()
            .isValid());
  }
}
