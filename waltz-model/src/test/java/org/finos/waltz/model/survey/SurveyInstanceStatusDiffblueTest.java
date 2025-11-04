package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SurveyInstanceStatusDiffblueTest {
  /**
   * Method under test: {@link SurveyInstanceStatus#prettyName()}
   */
  @Test
  void testPrettyName() {
    // Arrange, Act and Assert
    assertEquals("Not Started", SurveyInstanceStatus.valueOf("NOT_STARTED").prettyName());
  }
}
