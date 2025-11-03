package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstanceStateMachineFactoryDiffblueTest {
  /**
   * Test {@link SurveyInstanceStateMachineFactory#simple(SurveyInstanceStatus)} with {@code SurveyInstanceStatus}.
   * <p>
   * Method under test: {@link SurveyInstanceStateMachineFactory#simple(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName("Test simple(SurveyInstanceStatus) with 'SurveyInstanceStatus'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.waltz.model.survey.SurveyInstanceStateMachine SurveyInstanceStateMachineFactory.simple(SurveyInstanceStatus)"})
  void testSimpleWithSurveyInstanceStatus() {
    // Arrange, Act and Assert
    assertEquals(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateMachineFactory.simple(SurveyInstanceStatus.NOT_STARTED).getCurrent());
  }
}
