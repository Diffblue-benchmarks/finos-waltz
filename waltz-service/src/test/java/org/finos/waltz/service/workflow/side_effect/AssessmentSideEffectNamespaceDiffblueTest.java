package org.finos.waltz.service.workflow.side_effect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AssessmentSideEffectNamespaceDiffblueTest {
  /**
   * Method under test:
   * {@link AssessmentSideEffectNamespace#update(String, String)}
   */
  @Test
  void testUpdate() {
    // Arrange and Act
    ImmutableAssessmentRatingUpdateSideEffect actualUpdateResult = AssessmentSideEffectNamespace.update("42", "42");

    // Assert
    assertEquals("42", actualUpdateResult.assessmentDefinitionExternalId());
    assertEquals("42", actualUpdateResult.ratingSchemeItemExternalId());
  }
}
