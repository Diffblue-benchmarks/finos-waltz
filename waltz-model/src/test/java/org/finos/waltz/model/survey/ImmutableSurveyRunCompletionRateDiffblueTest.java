package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunCompletionRateDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Builder#completedCount(int)}
   */
  @Test
  void testBuilderCompletedCount() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Builder#from(SurveyRunCompletionRate)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Builder builderResult = ImmutableSurveyRunCompletionRate.builder();
    SurveyRunCompletionRate instance = mock(SurveyRunCompletionRate.class);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.completedCount()).thenReturn(3);
    when(instance.inProgressCount()).thenReturn(3);
    when(instance.notStartedCount()).thenReturn(3);

    // Act
    ImmutableSurveyRunCompletionRate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).completedCount();
    verify(instance).inProgressCount();
    verify(instance).notStartedCount();
    verify(instance).surveyRunId();
    ImmutableSurveyRunCompletionRate buildResult = builderResult.build();
    assertEquals(1L, buildResult.surveyRunId());
    assertEquals(3, buildResult.completedCount());
    assertEquals(3, buildResult.inProgressCount());
    assertEquals(3, buildResult.notStartedCount());
    assertEquals(9, buildResult.totalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Builder#inProgressCount(int)}
   */
  @Test
  void testBuilderInProgressCount() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inProgressCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Builder#notStartedCount(int)}
   */
  @Test
  void testBuilderNotStartedCount() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.notStartedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Builder#surveyRunId(long)}
   */
  @Test
  void testBuilderSurveyRunId() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act
    ImmutableSurveyRunCompletionRate.Builder actualSurveyRunIdResult = builderResult.surveyRunId(1L);

    // Assert
    ImmutableSurveyRunCompletionRate buildResult = builderResult.build();
    assertEquals(0, buildResult.completedCount());
    assertEquals(0, buildResult.inProgressCount());
    assertEquals(0, buildResult.notStartedCount());
    assertEquals(0, buildResult.totalCount());
    assertEquals(1L, buildResult.surveyRunId());
    assertSame(builderResult, actualSurveyRunIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate#copyOf(SurveyRunCompletionRate)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyRunCompletionRate instance = mock(SurveyRunCompletionRate.class);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.completedCount()).thenReturn(3);
    when(instance.inProgressCount()).thenReturn(3);
    when(instance.notStartedCount()).thenReturn(3);

    // Act
    ImmutableSurveyRunCompletionRate actualCopyOfResult = ImmutableSurveyRunCompletionRate.copyOf(instance);

    // Assert
    verify(instance).completedCount();
    verify(instance).inProgressCount();
    verify(instance).notStartedCount();
    verify(instance).surveyRunId();
    assertEquals(1L, actualCopyOfResult.surveyRunId());
    assertEquals(3, actualCopyOfResult.completedCount());
    assertEquals(3, actualCopyOfResult.inProgressCount());
    assertEquals(3, actualCopyOfResult.notStartedCount());
    assertEquals(9, actualCopyOfResult.totalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Json#completedCount()}
   */
  @Test
  void testJsonCompletedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCompletionRate.Json()).completedCount());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Json#inProgressCount()}
   */
  @Test
  void testJsonInProgressCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCompletionRate.Json()).inProgressCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyRunCompletionRate.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyRunCompletionRate.Json actualJson = new ImmutableSurveyRunCompletionRate.Json();

    // Assert
    assertEquals(0, actualJson.completedCount);
    assertEquals(0, actualJson.inProgressCount);
    assertEquals(0, actualJson.notStartedCount);
    assertEquals(0L, actualJson.surveyRunId);
    assertFalse(actualJson.completedCountIsSet);
    assertFalse(actualJson.inProgressCountIsSet);
    assertFalse(actualJson.notStartedCountIsSet);
    assertFalse(actualJson.surveyRunIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Json#notStartedCount()}
   */
  @Test
  void testJsonNotStartedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCompletionRate.Json()).notStartedCount());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Json#setCompletedCount(int)}
   */
  @Test
  void testJsonSetCompletedCount() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();

    // Act
    json.setCompletedCount(3);

    // Assert
    assertEquals(3, json.completedCount);
    assertTrue(json.completedCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Json#setInProgressCount(int)}
   */
  @Test
  void testJsonSetInProgressCount() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();

    // Act
    json.setInProgressCount(3);

    // Assert
    assertEquals(3, json.inProgressCount);
    assertTrue(json.inProgressCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Json#setNotStartedCount(int)}
   */
  @Test
  void testJsonSetNotStartedCount() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();

    // Act
    json.setNotStartedCount(3);

    // Assert
    assertEquals(3, json.notStartedCount);
    assertTrue(json.notStartedCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Json#setSurveyRunId(long)}
   */
  @Test
  void testJsonSetSurveyRunId() {
    // Arrange
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();

    // Act
    json.setSurveyRunId(1L);

    // Assert
    assertEquals(1L, json.surveyRunId);
    assertTrue(json.surveyRunIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunCompletionRate.Json#surveyRunId()}
   */
  @Test
  void testJsonSurveyRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunCompletionRate.Json()).surveyRunId());
  }

  /**
   * Method under test: {@link ImmutableSurveyRunCompletionRate.Json#totalCount()}
   */
  @Test
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRunCompletionRate.Json()).totalCount());
  }
}
