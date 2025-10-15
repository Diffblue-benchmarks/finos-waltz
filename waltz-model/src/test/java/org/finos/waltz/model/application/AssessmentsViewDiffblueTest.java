package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentsViewDiffblueTest {
  /**
   * Test {@link AssessmentsView#ratingSchemeItemsById()}.
   *
   * <p>Method under test: {@link AssessmentsView#ratingSchemeItemsById()}
   */
  @Test
  @DisplayName("Test ratingSchemeItemsById()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map AssessmentsView.ratingSchemeItemsById()"})
  void testRatingSchemeItemsById() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAssessmentsView.builder().build().ratingSchemeItemsById().isEmpty());
  }
}
