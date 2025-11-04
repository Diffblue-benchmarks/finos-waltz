package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#from(SurveyInstanceInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();
    SurveyInstanceInfo instance = mock(SurveyInstanceInfo.class);
    when(instance.surveyTemplateRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.surveyRun()).thenReturn(new ImmutableSurveyRun.Json());
    when(instance.surveyInstance()).thenReturn(new ImmutableSurveyInstance.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).surveyInstance();
    verify(instance).surveyRun();
    verify(instance).surveyTemplateRef();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#from(SurveyInstanceInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();
    SurveyInstanceInfo instance = mock(SurveyInstanceInfo.class);
    when(instance.historicalVersionsCount()).thenReturn(3);
    when(instance.surveyTemplateRef()).thenReturn(mock(EntityReference.class));
    ImmutableSurveyRun.Json json = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json);
    ImmutableSurveyInstance.Json json2 = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json2);

    // Act
    ImmutableSurveyInstanceInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).historicalVersionsCount();
    verify(instance).surveyInstance();
    verify(instance).surveyRun();
    verify(instance).surveyTemplateRef();
    ImmutableSurveyInstanceInfo buildResult = builderResult.build();
    assertEquals(3, buildResult.historicalVersionsCount().intValue());
    assertSame(json2, buildResult.surveyInstance());
    assertSame(json, buildResult.surveyRun());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#from(SurveyInstanceInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();
    SurveyInstanceInfo instance = mock(SurveyInstanceInfo.class);
    when(instance.historicalVersionsCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.surveyTemplateRef()).thenReturn(mock(EntityReference.class));
    when(instance.surveyRun()).thenReturn(new ImmutableSurveyRun.Json());
    when(instance.surveyInstance()).thenReturn(new ImmutableSurveyInstance.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).historicalVersionsCount();
    verify(instance).surveyInstance();
    verify(instance).surveyRun();
    verify(instance).surveyTemplateRef();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#historicalVersionsCount(Integer)}
   */
  @Test
  void testBuilderHistoricalVersionsCount() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.historicalVersionsCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  void testBuilderSurveyInstance() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstance(new ImmutableSurveyInstance.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  void testBuilderSurveyInstance2() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    ImmutableSurveyInstance.Json surveyInstance = new ImmutableSurveyInstance.Json();
    surveyInstance.setSurveyEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstance(surveyInstance));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#surveyRun(SurveyRun)}
   */
  @Test
  void testBuilderSurveyRun() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRun(new ImmutableSurveyRun.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#surveyRun(SurveyRun)}
   */
  @Test
  void testBuilderSurveyRun2() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    ImmutableSurveyRun.Json surveyRun = new ImmutableSurveyRun.Json();
    surveyRun.setSelectionOptions(mock(IdSelectionOptions.class));

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRun(surveyRun));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Builder#surveyTemplateRef(EntityReference)}
   */
  @Test
  void testBuilderSurveyTemplateRef() {
    // Arrange
    ImmutableSurveyInstanceInfo.Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo#copyOf(SurveyInstanceInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceInfo instance = mock(SurveyInstanceInfo.class);
    when(instance.historicalVersionsCount()).thenReturn(3);
    when(instance.surveyTemplateRef()).thenReturn(mock(EntityReference.class));
    ImmutableSurveyRun.Json json = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json);
    ImmutableSurveyInstance.Json json2 = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json2);

    // Act
    ImmutableSurveyInstanceInfo actualCopyOfResult = ImmutableSurveyInstanceInfo.copyOf(instance);

    // Assert
    verify(instance).historicalVersionsCount();
    verify(instance).surveyInstance();
    verify(instance).surveyRun();
    verify(instance).surveyTemplateRef();
    assertEquals(3, actualCopyOfResult.historicalVersionsCount().intValue());
    assertSame(json2, actualCopyOfResult.surveyInstance());
    assertSame(json, actualCopyOfResult.surveyRun());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo#fromJson(ImmutableSurveyInstanceInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceInfo.Json json = new ImmutableSurveyInstanceInfo.Json();
    ImmutableSurveyInstance.Json surveyInstance = new ImmutableSurveyInstance.Json();
    json.setSurveyInstance(surveyInstance);
    ImmutableSurveyRun.Json surveyRun = new ImmutableSurveyRun.Json();
    json.setSurveyRun(surveyRun);
    json.setSurveyTemplateRef(mock(EntityReference.class));
    json.setHistoricalVersionsCount(1);

    // Act
    ImmutableSurveyInstanceInfo actualFromJsonResult = ImmutableSurveyInstanceInfo.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.historicalVersionsCount().intValue());
    assertSame(surveyInstance, actualFromJsonResult.surveyInstance());
    assertSame(surveyRun, actualFromJsonResult.surveyRun());
    EntityReference expectedSurveyTemplateRefResult = json.surveyTemplateRef;
    assertSame(expectedSurveyTemplateRefResult, actualFromJsonResult.surveyTemplateRef());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyInstanceInfo.Json}
   *   <li>
   * {@link ImmutableSurveyInstanceInfo.Json#setHistoricalVersionsCount(Integer)}
   *   <li>
   * {@link ImmutableSurveyInstanceInfo.Json#setSurveyInstance(SurveyInstance)}
   *   <li>{@link ImmutableSurveyInstanceInfo.Json#setSurveyRun(SurveyRun)}
   *   <li>
   * {@link ImmutableSurveyInstanceInfo.Json#setSurveyTemplateRef(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyInstanceInfo.Json actualJson = new ImmutableSurveyInstanceInfo.Json();
    actualJson.setHistoricalVersionsCount(3);
    actualJson.setSurveyInstance(new ImmutableSurveyInstance.Json());
    actualJson.setSurveyRun(new ImmutableSurveyRun.Json());
    actualJson.setSurveyTemplateRef(null);

    // Assert
    assertEquals(3, actualJson.historicalVersionsCount.intValue());
    assertFalse(((ImmutableSurveyInstance.Json) actualJson.surveyInstance).id.isPresent());
    assertTrue(((ImmutableSurveyRun.Json) actualJson.surveyRun).involvementKindIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Json#historicalVersionsCount()}
   */
  @Test
  void testJsonHistoricalVersionsCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceInfo.Json()).historicalVersionsCount());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceInfo.Json#surveyInstance()}
   */
  @Test
  void testJsonSurveyInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceInfo.Json()).surveyInstance());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceInfo.Json#surveyRun()}
   */
  @Test
  void testJsonSurveyRun() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceInfo.Json()).surveyRun());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceInfo.Json#surveyTemplateRef()}
   */
  @Test
  void testJsonSurveyTemplateRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceInfo.Json()).surveyTemplateRef());
  }
}
