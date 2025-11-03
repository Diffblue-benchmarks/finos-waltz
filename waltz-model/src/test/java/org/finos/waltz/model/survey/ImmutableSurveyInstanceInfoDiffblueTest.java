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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceInfo.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SurveyInstanceInfo)}.
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();
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
   * Test Builder {@link Builder#from(SurveyInstanceInfo)}.
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();
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
   * Test Builder {@link Builder#from(SurveyInstanceInfo)}.
   * <ul>
   *   <li>Then builder build historicalVersionsCount intValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceInfo); then builder build historicalVersionsCount intValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceInfo)"})
  void testBuilderFrom_thenBuilderBuildHistoricalVersionsCountIntValueIsThree() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();
    SurveyInstanceInfo instance = mock(SurveyInstanceInfo.class);
    when(instance.historicalVersionsCount()).thenReturn(3);
    when(instance.surveyTemplateRef()).thenReturn(mock(EntityReference.class));
    ImmutableSurveyRun.Json json = new ImmutableSurveyRun.Json();
    when(instance.surveyRun()).thenReturn(json);
    ImmutableSurveyInstance.Json json2 = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#historicalVersionsCount(Integer)}.
   * <p>
   * Method under test: {@link Builder#historicalVersionsCount(Integer)}
   */
  @Test
  @DisplayName("Test Builder historicalVersionsCount(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.historicalVersionsCount(Integer)"})
  void testBuilderHistoricalVersionsCount() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.historicalVersionsCount(3));
  }

  /**
   * Test Builder {@link Builder#surveyInstance(SurveyInstance)}.
   * <ul>
   *   <li>When {@link ImmutableSurveyInstance.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder surveyInstance(SurveyInstance); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyInstance(SurveyInstance)"})
  void testBuilderSurveyInstance_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstance(new ImmutableSurveyInstance.Json()));
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
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyRun(new ImmutableSurveyRun.Json()));
  }

  /**
   * Test Builder {@link Builder#surveyTemplateRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#surveyTemplateRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder surveyTemplateRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyTemplateRef(EntityReference)"})
  void testBuilderSurveyTemplateRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateRef(mock(EntityReference.class)));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setHistoricalVersionsCount(Integer)}
   *   <li>{@link Json#setSurveyInstance(SurveyInstance)}
   *   <li>{@link Json#setSurveyRun(SurveyRun)}
   *   <li>{@link Json#setSurveyTemplateRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setHistoricalVersionsCount(Integer)",
      "void Json.setSurveyInstance(SurveyInstance)", "void Json.setSurveyRun(SurveyRun)",
      "void Json.setSurveyTemplateRef(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#historicalVersionsCount()}.
   * <p>
   * Method under test: {@link Json#historicalVersionsCount()}
   */
  @Test
  @DisplayName("Test Json historicalVersionsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.historicalVersionsCount()"})
  void testJsonHistoricalVersionsCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).historicalVersionsCount());
  }

  /**
   * Test Json {@link Json#surveyInstance()}.
   * <p>
   * Method under test: {@link Json#surveyInstance()}
   */
  @Test
  @DisplayName("Test Json surveyInstance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyInstance Json.surveyInstance()"})
  void testJsonSurveyInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyInstance());
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

  /**
   * Test Json {@link Json#surveyTemplateRef()}.
   * <p>
   * Method under test: {@link Json#surveyTemplateRef()}
   */
  @Test
  @DisplayName("Test Json surveyTemplateRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.surveyTemplateRef()"})
  void testJsonSurveyTemplateRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyTemplateRef());
  }
}
