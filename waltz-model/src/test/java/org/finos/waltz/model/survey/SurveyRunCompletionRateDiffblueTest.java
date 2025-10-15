package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyRunCompletionRateDiffblueTest {
  /**
   * Test {@link SurveyRunCompletionRate#notStartedCount()}.
   *
   * <p>Method under test: {@link SurveyRunCompletionRate#notStartedCount()}
   */
  @Test
  @DisplayName("Test notStartedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunCompletionRate.notStartedCount()"})
  void testNotStartedCount() {
    // Arrange, Act and Assert
    assertEquals(
        0, ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().notStartedCount());
  }

  /**
   * Test {@link SurveyRunCompletionRate#inProgressCount()}.
   *
   * <p>Method under test: {@link SurveyRunCompletionRate#inProgressCount()}
   */
  @Test
  @DisplayName("Test inProgressCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunCompletionRate.inProgressCount()"})
  void testInProgressCount() {
    // Arrange, Act and Assert
    assertEquals(
        0, ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().inProgressCount());
  }

  /**
   * Test {@link SurveyRunCompletionRate#completedCount()}.
   *
   * <p>Method under test: {@link SurveyRunCompletionRate#completedCount()}
   */
  @Test
  @DisplayName("Test completedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunCompletionRate.completedCount()"})
  void testCompletedCount() {
    // Arrange, Act and Assert
    assertEquals(
        0, ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().completedCount());
  }

  /**
   * Test {@link SurveyRunCompletionRate#totalCount()}.
   *
   * <p>Method under test: {@link SurveyRunCompletionRate#totalCount()}
   */
  @Test
  @DisplayName("Test totalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunCompletionRate.totalCount()"})
  void testTotalCount() {
    // Arrange, Act and Assert
    assertEquals(
        0, ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().totalCount());
  }

  /**
   * Test {@link SurveyRunCompletionRate#mkNoData(long)}.
   *
   * <p>Method under test: {@link SurveyRunCompletionRate#mkNoData(long)}
   */
  @Test
  @DisplayName("Test mkNoData(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
