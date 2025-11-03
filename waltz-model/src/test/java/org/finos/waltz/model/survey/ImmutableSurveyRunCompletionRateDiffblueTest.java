package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyRunCompletionRate.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunCompletionRate.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunCompletionRateDiffblueTest {
  /**
   * Test Builder {@link Builder#completedCount(int)}.
   * <p>
   * Method under test: {@link Builder#completedCount(int)}
   */
  @Test
  @DisplayName("Test Builder completedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.completedCount(int)"})
  void testBuilderCompletedCount() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completedCount(3));
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunCompletionRate)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build surveyRunId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyRunCompletionRate)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunCompletionRate); given one; then builder build surveyRunId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyRunCompletionRate)"})
  void testBuilderFrom_givenOne_thenBuilderBuildSurveyRunIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();
    SurveyRunCompletionRate instance = mock(SurveyRunCompletionRate.class);
    when(instance.surveyRunId()).thenReturn(1L);
    when(instance.completedCount()).thenReturn(3);
    when(instance.inProgressCount()).thenReturn(3);
    when(instance.notStartedCount()).thenReturn(3);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#inProgressCount(int)}.
   * <p>
   * Method under test: {@link Builder#inProgressCount(int)}
   */
  @Test
  @DisplayName("Test Builder inProgressCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inProgressCount(int)"})
  void testBuilderInProgressCount() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inProgressCount(3));
  }

  /**
   * Test Builder {@link Builder#notStartedCount(int)}.
   * <p>
   * Method under test: {@link Builder#notStartedCount(int)}
   */
  @Test
  @DisplayName("Test Builder notStartedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.notStartedCount(int)"})
  void testBuilderNotStartedCount() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.notStartedCount(3));
  }

  /**
   * Test Builder {@link Builder#surveyRunId(long)}.
   * <p>
   * Method under test: {@link Builder#surveyRunId(long)}
   */
  @Test
  @DisplayName("Test Builder surveyRunId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyRunId(long)"})
  void testBuilderSurveyRunId() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act
    Builder actualSurveyRunIdResult = builderResult.surveyRunId(1L);

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
   * Test Json {@link Json#completedCount()}.
   * <p>
   * Method under test: {@link Json#completedCount()}
   */
  @Test
  @DisplayName("Test Json completedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.completedCount()"})
  void testJsonCompletedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).completedCount());
  }

  /**
   * Test Json {@link Json#inProgressCount()}.
   * <p>
   * Method under test: {@link Json#inProgressCount()}
   */
  @Test
  @DisplayName("Test Json inProgressCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.inProgressCount()"})
  void testJsonInProgressCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inProgressCount());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#notStartedCount()}.
   * <p>
   * Method under test: {@link Json#notStartedCount()}
   */
  @Test
  @DisplayName("Test Json notStartedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.notStartedCount()"})
  void testJsonNotStartedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).notStartedCount());
  }

  /**
   * Test Json {@link Json#setCompletedCount(int)}.
   * <p>
   * Method under test: {@link Json#setCompletedCount(int)}
   */
  @Test
  @DisplayName("Test Json setCompletedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCompletedCount(int)"})
  void testJsonSetCompletedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCompletedCount(3);

    // Assert
    assertEquals(3, json.completedCount);
    assertTrue(json.completedCountIsSet);
  }

  /**
   * Test Json {@link Json#setInProgressCount(int)}.
   * <p>
   * Method under test: {@link Json#setInProgressCount(int)}
   */
  @Test
  @DisplayName("Test Json setInProgressCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setInProgressCount(int)"})
  void testJsonSetInProgressCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setInProgressCount(3);

    // Assert
    assertEquals(3, json.inProgressCount);
    assertTrue(json.inProgressCountIsSet);
  }

  /**
   * Test Json {@link Json#setNotStartedCount(int)}.
   * <p>
   * Method under test: {@link Json#setNotStartedCount(int)}
   */
  @Test
  @DisplayName("Test Json setNotStartedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setNotStartedCount(int)"})
  void testJsonSetNotStartedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setNotStartedCount(3);

    // Assert
    assertEquals(3, json.notStartedCount);
    assertTrue(json.notStartedCountIsSet);
  }

  /**
   * Test Json {@link Json#setSurveyRunId(long)}.
   * <p>
   * Method under test: {@link Json#setSurveyRunId(long)}
   */
  @Test
  @DisplayName("Test Json setSurveyRunId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSurveyRunId(long)"})
  void testJsonSetSurveyRunId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSurveyRunId(1L);

    // Assert
    assertEquals(1L, json.surveyRunId);
    assertTrue(json.surveyRunIdIsSet);
  }

  /**
   * Test Json {@link Json#surveyRunId()}.
   * <p>
   * Method under test: {@link Json#surveyRunId()}
   */
  @Test
  @DisplayName("Test Json surveyRunId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.surveyRunId()"})
  void testJsonSurveyRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyRunId());
  }

  /**
   * Test Json {@link Json#totalCount()}.
   * <p>
   * Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).totalCount());
  }
}
