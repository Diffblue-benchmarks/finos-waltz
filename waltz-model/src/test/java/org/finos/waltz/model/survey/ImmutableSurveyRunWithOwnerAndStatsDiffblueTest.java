package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunWithOwnerAndStatsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#builder()}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats#owner(Person)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyRunWithOwnerAndStats.Builder actualBuilderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.owner(null));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Builder#completionRateStats(SurveyRunCompletionRate)}
   */
  @Test
  void testBuilderCompletionRateStats() {
    // Arrange
    ImmutableSurveyRunWithOwnerAndStats.Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completionRateStats(new ImmutableSurveyRunCompletionRate.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Builder#completionRateStats(SurveyRunCompletionRate)}
   */
  @Test
  void testBuilderCompletionRateStats2() {
    // Arrange
    ImmutableSurveyRunWithOwnerAndStats.Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    builderResult.owner(mock(Person.class));

    // Act and Assert
    assertSame(builderResult, builderResult.completionRateStats(new ImmutableSurveyRunCompletionRate.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Builder#from(SurveyRunWithOwnerAndStats)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyRunWithOwnerAndStats.Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    SurveyRunWithOwnerAndStats instance = mock(SurveyRunWithOwnerAndStats.class);
    when(instance.owner()).thenReturn(null);
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();
    when(instance.completionRateStats()).thenReturn(json);
    ImmutableSurveyRun.Json json2 = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json2);

    // Act
    ImmutableSurveyRunWithOwnerAndStats.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Builder#from(SurveyRunWithOwnerAndStats)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyRunWithOwnerAndStats.Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    SurveyRunWithOwnerAndStats instance = mock(SurveyRunWithOwnerAndStats.class);
    when(instance.owner()).thenThrow(new IllegalStateException("instance"));
    when(instance.surveyRun()).thenReturn(new ImmutableSurveyRun.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).owner();
    verify(instance).surveyRun();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Builder#from(SurveyRunWithOwnerAndStats)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyRunWithOwnerAndStats.Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    SurveyRunWithOwnerAndStats instance = mock(SurveyRunWithOwnerAndStats.class);
    when(instance.owner()).thenReturn(mock(Person.class));
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();
    when(instance.completionRateStats()).thenReturn(json);
    ImmutableSurveyRun.Json json2 = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json2);

    // Act
    ImmutableSurveyRunWithOwnerAndStats.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Builder#surveyRun(SurveyRun)}
   */
  @Test
  void testBuilderSurveyRun() {
    // Arrange
    ImmutableSurveyRunWithOwnerAndStats.Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRun(new ImmutableSurveyRun.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Builder#surveyRun(SurveyRun)}
   */
  @Test
  void testBuilderSurveyRun2() {
    // Arrange
    ImmutableSurveyRunWithOwnerAndStats.Builder builderResult = ImmutableSurveyRunWithOwnerAndStats.builder();
    builderResult.owner(mock(Person.class));

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRun(new ImmutableSurveyRun.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats#copyOf(SurveyRunWithOwnerAndStats)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyRunWithOwnerAndStats instance = mock(SurveyRunWithOwnerAndStats.class);
    when(instance.owner()).thenReturn(null);
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();
    when(instance.completionRateStats()).thenReturn(json);
    ImmutableSurveyRun.Json json2 = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json2);

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualCopyOfResult = ImmutableSurveyRunWithOwnerAndStats.copyOf(instance);

    // Assert
    verify(instance).completionRateStats();
    verify(instance).owner();
    verify(instance).surveyRun();
    assertNull(actualCopyOfResult.owner());
    assertSame(json2, actualCopyOfResult.surveyRun());
    assertSame(json, actualCopyOfResult.completionRateStats());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats#copyOf(SurveyRunWithOwnerAndStats)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyRunWithOwnerAndStats instance = mock(SurveyRunWithOwnerAndStats.class);
    when(instance.owner()).thenReturn(mock(Person.class));
    ImmutableSurveyRunCompletionRate.Json json = new ImmutableSurveyRunCompletionRate.Json();
    when(instance.completionRateStats()).thenReturn(json);
    ImmutableSurveyRun.Json json2 = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json2);

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualCopyOfResult = ImmutableSurveyRunWithOwnerAndStats.copyOf(instance);

    // Assert
    verify(instance).completionRateStats();
    verify(instance).owner();
    verify(instance).surveyRun();
    assertSame(json2, actualCopyOfResult.surveyRun());
    assertSame(json, actualCopyOfResult.completionRateStats());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats#fromJson(ImmutableSurveyRunWithOwnerAndStats.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyRunWithOwnerAndStats.Json json = new ImmutableSurveyRunWithOwnerAndStats.Json();
    ImmutableSurveyRun.Json surveyRun = new ImmutableSurveyRun.Json();
    json.setSurveyRun(surveyRun);
    json.setOwner(null);
    ImmutableSurveyRunCompletionRate.Json completionRateStats = new ImmutableSurveyRunCompletionRate.Json();
    json.setCompletionRateStats(completionRateStats);

    // Act
    ImmutableSurveyRunWithOwnerAndStats actualFromJsonResult = ImmutableSurveyRunWithOwnerAndStats.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.owner());
    assertSame(surveyRun, actualFromJsonResult.surveyRun());
    assertSame(completionRateStats, actualFromJsonResult.completionRateStats());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Json#completionRateStats()}
   */
  @Test
  void testJsonCompletionRateStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunWithOwnerAndStats.Json()).completionRateStats());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyRunWithOwnerAndStats.Json}
   *   <li>
   * {@link ImmutableSurveyRunWithOwnerAndStats.Json#setCompletionRateStats(SurveyRunCompletionRate)}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats.Json#setOwner(Person)}
   *   <li>{@link ImmutableSurveyRunWithOwnerAndStats.Json#setSurveyRun(SurveyRun)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyRunWithOwnerAndStats.Json actualJson = new ImmutableSurveyRunWithOwnerAndStats.Json();
    actualJson.setCompletionRateStats(new ImmutableSurveyRunCompletionRate.Json());
    actualJson.setOwner(null);
    actualJson.setSurveyRun(new ImmutableSurveyRun.Json());

    // Assert
    assertFalse(((ImmutableSurveyRun.Json) actualJson.surveyRun).id.isPresent());
    assertTrue(((ImmutableSurveyRun.Json) actualJson.surveyRun).involvementKindIds.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSurveyRunWithOwnerAndStats.Json#owner()}
   */
  @Test
  void testJsonOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyRunWithOwnerAndStats.Json()).owner());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunWithOwnerAndStats.Json#surveyRun()}
   */
  @Test
  void testJsonSurveyRun() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunWithOwnerAndStats.Json()).surveyRun());
  }
}
