package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class SurveyQuestionResponseContextVariableReferenceDiffblueTest {
  /**
   * Method under test:
   * {@link SurveyQuestionResponseContextVariableReference#mkVarRef(String, String)}
   */
  @Test
  void testMkVarRef() {
    // Arrange and Act
    SurveyQuestionResponseContextVariableReference actualMkVarRefResult = SurveyQuestionResponseContextVariableReference
        .mkVarRef("42", "42");

    // Assert
    assertTrue(actualMkVarRefResult instanceof ImmutableSurveyQuestionResponseContextVariableReference);
    assertEquals("42", actualMkVarRefResult.externalId());
    assertEquals("42", actualMkVarRefResult.surveyExternalId());
    assertEquals(EntityKind.SURVEY_QUESTION, actualMkVarRefResult.kind());
  }
}
