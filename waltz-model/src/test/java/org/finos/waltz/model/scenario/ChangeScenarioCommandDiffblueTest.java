package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChangeScenarioCommandDiffblueTest {
  /**
   * Test {@link ChangeScenarioCommand#hasRatingChanged()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeScenarioCommand#hasRatingChanged()}
   */
  @Test
  @DisplayName("Test hasRatingChanged(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChangeScenarioCommand.hasRatingChanged()"})
  void testHasRatingChanged_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .hasRatingChanged());
  }
}
