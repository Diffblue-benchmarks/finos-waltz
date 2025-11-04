package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SurveyRunCompletionRateDiffblueTest {
  /**
   * Method under test: {@link SurveyRunCompletionRate#mkNoData(long)}
   */
  @Test
  void testMkNoData() {
    // Arrange and Act
    SurveyRunCompletionRate actualMkNoDataResult = SurveyRunCompletionRate.mkNoData(1L);

    // Assert
    assertTrue(actualMkNoDataResult instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, actualMkNoDataResult.completedCount());
    assertEquals(0, actualMkNoDataResult.inProgressCount());
    assertEquals(0, actualMkNoDataResult.notStartedCount());
    assertEquals(0, actualMkNoDataResult.totalCount());
    assertEquals(1L, actualMkNoDataResult.surveyRunId());
  }
}
