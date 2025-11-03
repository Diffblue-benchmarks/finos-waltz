package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.survey.ImmutableSurveyRunWithOwnerAndStats.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunWithOwnerAndStats.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunWithOwnerAndStatsDiffblueTest {
  /**
   * Test {@link ImmutableSurveyRunWithOwnerAndStats#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#builder()}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#owner(Person)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyRunWithOwnerAndStats Builder.build()", "Builder Builder.owner(Person)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.owner(null));
  }

  /**
   * Test Builder {@link Builder#completionRateStats(SurveyRunCompletionRate)}.
   * <ul>
   *   <li>When {@link ImmutableSurveyRunCompletionRate.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#completionRateStats(SurveyRunCompletionRate)}
   */
  @Test
  @DisplayName("Test Builder completionRateStats(SurveyRunCompletionRate); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.completionRateStats(SurveyRunCompletionRate)"})
  void testBuilderCompletionRateStats_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completionRateStats(new ImmutableSurveyRunCompletionRate.Json()));
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunWithOwnerAndStats)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then builder build owner is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyRunWithOwnerAndStats)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunWithOwnerAndStats); given 'null'; then builder build owner is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyRunWithOwnerAndStats)"})
  void testBuilderFrom_givenNull_thenBuilderBuildOwnerIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    SurveyRunWithOwnerAndStats instance = mock(SurveyRunWithOwnerAndStats.class);
    when(instance.owner()).thenReturn(null);
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();
    when(instance.completionRateStats()).thenReturn(json);
    ImmutableSurveyRun.Json json2 = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).completionRateStats();
    verify(instance).owner();
    verify(instance).surveyRun();
    ImmutableSurveyRunWithOwnerAndStats buildResult = builderResult.build();
    assertNull(buildResult.owner());
    assertSame(json2, buildResult.surveyRun());
    assertSame(json, buildResult.completionRateStats());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunWithOwnerAndStats)}.
   * <ul>
   *   <li>Given {@link Person}.</li>
   *   <li>When {@link SurveyRunWithOwnerAndStats} {@link SurveyRunWithOwnerAndStats#owner()} return {@link Person}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyRunWithOwnerAndStats)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunWithOwnerAndStats); given Person; when SurveyRunWithOwnerAndStats owner() return Person")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyRunWithOwnerAndStats)"})
  void testBuilderFrom_givenPerson_whenSurveyRunWithOwnerAndStatsOwnerReturnPerson() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    SurveyRunWithOwnerAndStats instance = mock(SurveyRunWithOwnerAndStats.class);
    when(instance.owner()).thenReturn(mock(Person.class));
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();
    when(instance.completionRateStats()).thenReturn(json);
    ImmutableSurveyRun.Json json2 = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).completionRateStats();
    verify(instance).owner();
    verify(instance).surveyRun();
    ImmutableSurveyRunWithOwnerAndStats buildResult = builderResult.build();
    assertSame(json2, buildResult.surveyRun());
    assertSame(json, buildResult.completionRateStats());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunWithOwnerAndStats)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyRunWithOwnerAndStats)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunWithOwnerAndStats); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyRunWithOwnerAndStats)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    SurveyRunWithOwnerAndStats instance = mock(SurveyRunWithOwnerAndStats.class);
    when(instance.owner()).thenThrow(new IllegalStateException("instance"));
    when(instance.surveyRun()).thenReturn(new ImmutableSurveyRun.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).owner();
    verify(instance).surveyRun();
  }

  /**
   * Test Builder {@link Builder#surveyRun(SurveyRun)}.
   * <ul>
   *   <li>When {@link ImmutableSurveyRun.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#surveyRun(SurveyRun)}
   */
  @Test
  @DisplayName("Test Builder surveyRun(SurveyRun); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyRun(SurveyRun)"})
  void testBuilderSurveyRun_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRun(new ImmutableSurveyRun.Json()));
  }

  /**
   * Test Json {@link Json#completionRateStats()}.
   * <p>
   * Method under test: {@link Json#completionRateStats()}
   */
  @Test
  @DisplayName("Test Json completionRateStats()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyRunCompletionRate Json.completionRateStats()"})
  void testJsonCompletionRateStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).completionRateStats());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCompletionRateStats(SurveyRunCompletionRate)}
   *   <li>{@link Json#setOwner(Person)}
   *   <li>{@link Json#setSurveyRun(SurveyRun)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCompletionRateStats(SurveyRunCompletionRate)",
      "void Json.setOwner(Person)", "void Json.setSurveyRun(SurveyRun)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCompletionRateStats(new ImmutableSurveyRunCompletionRate.Json());
    actualJson.setOwner(null);
    actualJson.setSurveyRun(new ImmutableSurveyRun.Json());

    // Assert
    assertFalse(((ImmutableSurveyRun.Json) actualJson.surveyRun).id.isPresent());
    assertTrue(((ImmutableSurveyRun.Json) actualJson.surveyRun).involvementKindIds.isEmpty());
  }

  /**
   * Test Json {@link Json#owner()}.
   * <p>
   * Method under test: {@link Json#owner()}
   */
  @Test
  @DisplayName("Test Json owner()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person Json.owner()"})
  void testJsonOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).owner());
  }

  /**
   * Test Json {@link Json#surveyRun()}.
   * <p>
   * Method under test: {@link Json#surveyRun()}
   */
  @Test
  @DisplayName("Test Json surveyRun()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyRun Json.surveyRun()"})
  void testJsonSurveyRun() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyRun());
  }
}
