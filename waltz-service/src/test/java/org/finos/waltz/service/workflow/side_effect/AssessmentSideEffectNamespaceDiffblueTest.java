package org.finos.waltz.service.workflow.side_effect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentSideEffectNamespaceDiffblueTest {
  /**
   * Test {@link AssessmentSideEffectNamespace#update(String, String)}.
   *
   * <p>Method under test: {@link AssessmentSideEffectNamespace#update(String, String)}
   */
  @Test
  @DisplayName("Test update(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingUpdateSideEffect AssessmentSideEffectNamespace.update(String, String)"
  })
  void testUpdate() {
    // Arrange and Act
    ImmutableAssessmentRatingUpdateSideEffect actualUpdateResult =
        AssessmentSideEffectNamespace.update("42", "42");

    // Assert
    assertEquals("42", actualUpdateResult.assessmentDefinitionExternalId());
    assertEquals("42", actualUpdateResult.ratingSchemeItemExternalId());
  }
}
