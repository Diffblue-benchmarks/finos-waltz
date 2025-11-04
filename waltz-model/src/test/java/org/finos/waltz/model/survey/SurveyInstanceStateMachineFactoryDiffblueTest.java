package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SurveyInstanceStateMachineFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link SurveyInstanceStateMachineFactory#simple(SurveyInstanceStatus)}
   */
  @Test
  void testSimple() {
    // Arrange, Act and Assert
    assertEquals(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateMachineFactory.simple(SurveyInstanceStatus.NOT_STARTED).getCurrent());
  }
}
