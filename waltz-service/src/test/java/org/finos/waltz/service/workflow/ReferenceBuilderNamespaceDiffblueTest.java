package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReferenceBuilderNamespaceDiffblueTest {
  /**
   * Test {@link ReferenceBuilderNamespace#assessment(String)}.
   * <p>
   * Method under test: {@link ReferenceBuilderNamespace#assessment(String)}
   */
  @Test
  @DisplayName("Test assessment(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ContextVariableReference ReferenceBuilderNamespace.assessment(String)"})
  void testAssessment() {
    // Arrange and Act
    ContextVariableReference actualAssessmentResult = ReferenceBuilderNamespace.assessment("42");

    // Assert
    assertTrue(actualAssessmentResult instanceof ImmutableContextVariableReference);
    assertEquals("42", actualAssessmentResult.externalId());
    assertEquals(EntityKind.ASSESSMENT_DEFINITION, actualAssessmentResult.kind());
  }

  /**
   * Test {@link ReferenceBuilderNamespace#surveyQuestionResponse(String, String)}.
   * <p>
   * Method under test: {@link ReferenceBuilderNamespace#surveyQuestionResponse(String, String)}
   */
  @Test
  @DisplayName("Test surveyQuestionResponse(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "SurveyQuestionResponseContextVariableReference ReferenceBuilderNamespace.surveyQuestionResponse(String, String)"})
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
