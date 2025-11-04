package org.finos.waltz.model.survey_template_exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateExchangeDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#addAllQuestions(Iterable)}
   */
  @Test
  void testBuilderAddAllQuestions() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllQuestions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#addQuestions(SurveyQuestionModel)}
   */
  @Test
  void testBuilderAddQuestions() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addQuestions(new ImmutableSurveyQuestionModel.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#addQuestions(SurveyQuestionModel)}
   */
  @Test
  void testBuilderAddQuestions2() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    ImmutableSurveyQuestionModel.Json element = new ImmutableSurveyQuestionModel.Json();
    element.setQualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addQuestions(element));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#addQuestions(SurveyQuestionModel[])}
   */
  @Test
  void testBuilderAddQuestions3() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addQuestions(new ImmutableSurveyQuestionModel.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#addQuestions(SurveyQuestionModel[])}
   */
  @Test
  void testBuilderAddQuestions4() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();
    json.setQualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addQuestions(json));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#from(SurveyTemplateExchange)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenReturn(new ArrayList<>());
    ImmutableSurveyTemplateModel.Json json = new ImmutableSurveyTemplateModel.Json();
    when(instance.template()).thenReturn(json);

    // Act
    ImmutableSurveyTemplateExchange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).questions();
    verify(instance).template();
    assertSame(json, builderResult.build().template());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#from(SurveyTemplateExchange)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenThrow(new IllegalStateException("instance"));
    when(instance.template()).thenReturn(new ImmutableSurveyTemplateModel.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).questions();
    verify(instance).template();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#from(SurveyTemplateExchange)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();
    surveyQuestionModelList.add(json);
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenReturn(surveyQuestionModelList);
    ImmutableSurveyTemplateModel.Json json2 = new ImmutableSurveyTemplateModel.Json();
    when(instance.template()).thenReturn(json2);

    // Act
    ImmutableSurveyTemplateExchange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).questions();
    verify(instance).template();
    ImmutableSurveyTemplateExchange buildResult = builderResult.build();
    List<SurveyQuestionModel> questionsResult = buildResult.questions();
    assertEquals(1, questionsResult.size());
    assertSame(json, questionsResult.get(0));
    assertSame(json2, buildResult.template());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#questions(Iterable)}
   */
  @Test
  void testBuilderQuestions() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#template(SurveyTemplateModel)}
   */
  @Test
  void testBuilderTemplate() {
    // Arrange
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();

    // Act
    ImmutableSurveyTemplateExchange.Builder actualTemplateResult = builderResult.template(template);

    // Assert
    assertSame(template, builderResult.build().template());
    assertSame(builderResult, actualTemplateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange.Builder#template(SurveyTemplateModel)}
   */
  @Test
  void testBuilderTemplate2() {
    // Arrange
    ImmutableSurveyQuestionModel.Json element = new ImmutableSurveyQuestionModel.Json();
    element.setQualifierEntity(mock(EntityReference.class));
    ImmutableSurveyTemplateExchange.Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    builderResult.addQuestions(element);
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();

    // Act
    ImmutableSurveyTemplateExchange.Builder actualTemplateResult = builderResult.template(template);

    // Assert
    ImmutableSurveyTemplateExchange buildResult = builderResult.build();
    List<SurveyQuestionModel> questionsResult = buildResult.questions();
    assertEquals(1, questionsResult.size());
    assertSame(element, questionsResult.get(0));
    assertSame(template, buildResult.template());
    assertSame(builderResult, actualTemplateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange#copyOf(SurveyTemplateExchange)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenReturn(new ArrayList<>());
    ImmutableSurveyTemplateModel.Json json = new ImmutableSurveyTemplateModel.Json();
    when(instance.template()).thenReturn(json);

    // Act
    ImmutableSurveyTemplateExchange actualCopyOfResult = ImmutableSurveyTemplateExchange.copyOf(instance);

    // Assert
    verify(instance).questions();
    verify(instance).template();
    assertTrue(actualCopyOfResult.questions().isEmpty());
    assertSame(json, actualCopyOfResult.template());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange#copyOf(SurveyTemplateExchange)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();
    surveyQuestionModelList.add(new ImmutableSurveyQuestionModel.Json());
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenReturn(surveyQuestionModelList);
    ImmutableSurveyTemplateModel.Json json = new ImmutableSurveyTemplateModel.Json();
    when(instance.template()).thenReturn(json);

    // Act
    ImmutableSurveyTemplateExchange actualCopyOfResult = ImmutableSurveyTemplateExchange.copyOf(instance);

    // Assert
    verify(instance).questions();
    verify(instance).template();
    assertEquals(surveyQuestionModelList, actualCopyOfResult.questions());
    assertSame(json, actualCopyOfResult.template());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange#copyOf(SurveyTemplateExchange)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();
    surveyQuestionModelList.add(new ImmutableSurveyQuestionModel.Json());
    surveyQuestionModelList.add(new ImmutableSurveyQuestionModel.Json());
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenReturn(surveyQuestionModelList);
    ImmutableSurveyTemplateModel.Json json = new ImmutableSurveyTemplateModel.Json();
    when(instance.template()).thenReturn(json);

    // Act
    ImmutableSurveyTemplateExchange actualCopyOfResult = ImmutableSurveyTemplateExchange.copyOf(instance);

    // Assert
    verify(instance).questions();
    verify(instance).template();
    assertEquals(surveyQuestionModelList, actualCopyOfResult.questions());
    assertSame(json, actualCopyOfResult.template());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange#fromJson(ImmutableSurveyTemplateExchange.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyTemplateExchange.Json json = new ImmutableSurveyTemplateExchange.Json();
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();
    json.setTemplate(template);
    json.setQuestions(null);

    // Act
    ImmutableSurveyTemplateExchange actualFromJsonResult = ImmutableSurveyTemplateExchange.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.questions().isEmpty());
    assertSame(template, actualFromJsonResult.template());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange#fromJson(ImmutableSurveyTemplateExchange.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<SurveyQuestionModel> questions = new ArrayList<>();
    questions.add(new ImmutableSurveyQuestionModel.Json());

    ImmutableSurveyTemplateExchange.Json json = new ImmutableSurveyTemplateExchange.Json();
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();
    json.setTemplate(template);
    json.setQuestions(questions);

    // Act
    ImmutableSurveyTemplateExchange actualFromJsonResult = ImmutableSurveyTemplateExchange.fromJson(json);

    // Assert
    assertEquals(questions, actualFromJsonResult.questions());
    assertSame(template, actualFromJsonResult.template());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateExchange#fromJson(ImmutableSurveyTemplateExchange.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<SurveyQuestionModel> questions = new ArrayList<>();
    questions.add(new ImmutableSurveyQuestionModel.Json());
    questions.add(new ImmutableSurveyQuestionModel.Json());

    ImmutableSurveyTemplateExchange.Json json = new ImmutableSurveyTemplateExchange.Json();
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();
    json.setTemplate(template);
    json.setQuestions(questions);

    // Act
    ImmutableSurveyTemplateExchange actualFromJsonResult = ImmutableSurveyTemplateExchange.fromJson(json);

    // Assert
    assertEquals(questions, actualFromJsonResult.questions());
    assertSame(template, actualFromJsonResult.template());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyTemplateExchange.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyTemplateExchange.Json actualJson = new ImmutableSurveyTemplateExchange.Json();

    // Assert
    assertNull(actualJson.template);
    assertTrue(actualJson.questions.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateExchange.Json#questions()}
   */
  @Test
  void testJsonQuestions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplateExchange.Json()).questions());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateExchange.Json#template()}
   */
  @Test
  void testJsonTemplate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplateExchange.Json()).template());
  }
}
