package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ReferenceBuilderNamespaceDiffblueTest {
  /**
   * Method under test: {@link ReferenceBuilderNamespace#assessment(String)}
   */
  @Test
  void testAssessment() {
    // Arrange and Act
    ContextVariableReference actualAssessmentResult = ReferenceBuilderNamespace.assessment("42");

    // Assert
    assertTrue(actualAssessmentResult instanceof ImmutableContextVariableReference);
    assertEquals("42", actualAssessmentResult.externalId());
    assertEquals(EntityKind.ASSESSMENT_DEFINITION, actualAssessmentResult.kind());
  }

  /**
   * Method under test:
   * {@link ReferenceBuilderNamespace#surveyQuestionResponse(String, String)}
   */
  @Test
  void testSurveyQuestionResponse() {
    // Arrange and Act
    SurveyQuestionResponseContextVariableReference actualSurveyQuestionResponseResult = ReferenceBuilderNamespace
        .surveyQuestionResponse("42", "42");

    // Assert
    assertTrue(actualSurveyQuestionResponseResult instanceof ImmutableSurveyQuestionResponseContextVariableReference);
    assertEquals("42", actualSurveyQuestionResponseResult.externalId());
    assertEquals("42", actualSurveyQuestionResponseResult.surveyExternalId());
    assertEquals(EntityKind.SURVEY_QUESTION, actualSurveyQuestionResponseResult.kind());
  }
}
