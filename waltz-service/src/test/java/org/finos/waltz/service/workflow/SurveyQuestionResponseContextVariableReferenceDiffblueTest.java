package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyQuestionResponseContextVariableReferenceDiffblueTest {
  /**
   * Test {@link SurveyQuestionResponseContextVariableReference#mkVarRef(String, String)} with {@code surveyExternalId}, {@code externalId}.
   * <p>
   * Method under test: {@link SurveyQuestionResponseContextVariableReference#mkVarRef(String, String)}
   */
  @Test
  @DisplayName("Test mkVarRef(String, String) with 'surveyExternalId', 'externalId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "SurveyQuestionResponseContextVariableReference SurveyQuestionResponseContextVariableReference.mkVarRef(String, String)"})
  void testMkVarRefWithSurveyExternalIdExternalId() {
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
