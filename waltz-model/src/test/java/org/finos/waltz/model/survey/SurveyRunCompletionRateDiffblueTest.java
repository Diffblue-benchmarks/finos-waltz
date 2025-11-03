package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyRunCompletionRateDiffblueTest {
  /**
   * Test {@link SurveyRunCompletionRate#mkNoData(long)}.
   * <p>
   * Method under test: {@link SurveyRunCompletionRate#mkNoData(long)}
   */
  @Test
  @DisplayName("Test mkNoData(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyRunCompletionRate SurveyRunCompletionRate.mkNoData(long)"})
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
