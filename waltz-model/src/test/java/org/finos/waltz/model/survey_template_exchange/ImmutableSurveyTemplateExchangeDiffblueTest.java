package org.finos.waltz.model.survey_template_exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyTemplateExchange.Builder;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyTemplateExchange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateExchangeDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllQuestions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllQuestions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllQuestions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllQuestions(Iterable)"})
  void testBuilderAddAllQuestions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllQuestions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addQuestions(SurveyQuestionModel)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableSurveyQuestionModel.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addQuestions(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder addQuestions(SurveyQuestionModel) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addQuestions(SurveyQuestionModel)"})
  void testBuilderAddQuestionsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addQuestions(new ImmutableSurveyQuestionModel.Json()));
  }

  /**
   * Test Builder {@link Builder#addQuestions(SurveyQuestionModel[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableSurveyQuestionModel.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addQuestions(SurveyQuestionModel[])}
   */
  @Test
  @DisplayName("Test Builder addQuestions(SurveyQuestionModel[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addQuestions(SurveyQuestionModel[])"})
  void testBuilderAddQuestionsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addQuestions(new ImmutableSurveyQuestionModel.Json()));
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateExchange)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSurveyQuestionModel.Json} (default constructor).</li>
   *   <li>Then builder build questions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateExchange); given ArrayList() add Json (default constructor); then builder build questions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateExchange)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildQuestionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();
    surveyQuestionModelList.add(json);
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenReturn(surveyQuestionModelList);
    when(instance.template()).thenReturn(new ImmutableSurveyTemplateModel.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).questions();
    verify(instance).template();
    List<SurveyQuestionModel> questionsResult = builderResult.build().questions();
    assertEquals(1, questionsResult.size());
    assertEquals(surveyQuestionModelList, actualFromResult.build().questions());
    assertSame(json, questionsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateExchange)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build template is {@link ImmutableSurveyTemplateModel.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateExchange); given ArrayList(); then builder build template is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateExchange)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildTemplateIsJson() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenReturn(new ArrayList<>());
    ImmutableSurveyTemplateModel.Json json = new ImmutableSurveyTemplateModel.Json();
    when(instance.template()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).questions();
    verify(instance).template();
    assertSame(json, builderResult.build().template());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateExchange)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateExchange); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateExchange)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    SurveyTemplateExchange instance = mock(SurveyTemplateExchange.class);
    when(instance.questions()).thenThrow(new IllegalStateException("instance"));
    when(instance.template()).thenReturn(new ImmutableSurveyTemplateModel.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).questions();
    verify(instance).template();
  }

  /**
   * Test Builder {@link Builder#questions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#questions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder questions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.questions(Iterable)"})
  void testBuilderQuestions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#template(SurveyTemplateModel)}.
   * <ul>
   *   <li>When {@link ImmutableSurveyTemplateModel.Json} (default constructor).</li>
   *   <li>Then builder build template is {@link ImmutableSurveyTemplateModel.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#template(SurveyTemplateModel)}
   */
  @Test
  @DisplayName("Test Builder template(SurveyTemplateModel); when Json (default constructor); then builder build template is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.template(SurveyTemplateModel)"})
  void testBuilderTemplate_whenJson_thenBuilderBuildTemplateIsJson() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();

    // Act
    Builder actualTemplateResult = builderResult.template(template);

    // Assert
    assertSame(template, builderResult.build().template());
    assertSame(builderResult, actualTemplateResult);
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
    assertNull(actualJson.template);
    assertTrue(actualJson.questions.isEmpty());
  }

  /**
   * Test Json {@link Json#questions()}.
   * <p>
   * Method under test: {@link Json#questions()}
   */
  @Test
  @DisplayName("Test Json questions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.questions()"})
  void testJsonQuestions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).questions());
  }

  /**
   * Test Json {@link Json#template()}.
   * <p>
   * Method under test: {@link Json#template()}
   */
  @Test
  @DisplayName("Test Json template()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyTemplateModel Json.template()"})
  void testJsonTemplate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).template());
  }
}
