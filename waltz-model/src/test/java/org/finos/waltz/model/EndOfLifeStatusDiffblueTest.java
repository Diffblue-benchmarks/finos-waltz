package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EndOfLifeStatusDiffblueTest {
  /**
   * Test {@link EndOfLifeStatus#calculateEndOfLifeStatus(Date)}.
   *
   * <ul>
   *   <li>When from now atStartOfDay atZone {@link ZoneOffset#UTC} toInstant.
   * </ul>
   *
   * <p>Method under test: {@link EndOfLifeStatus#calculateEndOfLifeStatus(Date)}
   */
  @Test
  @DisplayName(
      "Test calculateEndOfLifeStatus(Date); when from now atStartOfDay atZone UTC toInstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EndOfLifeStatus EndOfLifeStatus.calculateEndOfLifeStatus(Date)"})
  void testCalculateEndOfLifeStatus_whenFromNowAtStartOfDayAtZoneUtcToInstant() {
    // Arrange, Act and Assert
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE,
        EndOfLifeStatus.calculateEndOfLifeStatus(
            Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test {@link EndOfLifeStatus#calculateEndOfLifeStatus(Date)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code NOT_END_OF_LIFE}.
   * </ul>
   *
   * <p>Method under test: {@link EndOfLifeStatus#calculateEndOfLifeStatus(Date)}
   */
  @Test
  @DisplayName("Test calculateEndOfLifeStatus(Date); when 'null'; then return 'NOT_END_OF_LIFE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EndOfLifeStatus EndOfLifeStatus.calculateEndOfLifeStatus(Date)"})
  void testCalculateEndOfLifeStatus_whenNull_thenReturnNotEndOfLife() {
    // Arrange, Act and Assert
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, EndOfLifeStatus.calculateEndOfLifeStatus(null));
  }
}
