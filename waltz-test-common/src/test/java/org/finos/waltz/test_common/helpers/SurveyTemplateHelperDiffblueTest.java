package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyTemplateChangeCommand;
import org.finos.waltz.schema.tables.records.SurveyQuestionResponseRecord;
import org.finos.waltz.service.survey.SurveyQuestionService;
import org.finos.waltz.service.survey.SurveyTemplateService;
import org.jooq.DSLContext;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class SurveyTemplateHelperDiffblueTest {
  @Mock
  private SurveyQuestionService surveyQuestionService;

  @InjectMocks
  private SurveyTemplateHelper surveyTemplateHelper;

  @Mock
  private SurveyTemplateService surveyTemplateService;

  @Mock
  private DSLContext dSLContext;

  /**
   * Test {@link SurveyTemplateHelper#createTemplate(String, String)}.
   * <p>
   * Method under test: {@link SurveyTemplateHelper#createTemplate(String, String)}
   */
  @Test
  @DisplayName("Test createTemplate(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long SurveyTemplateHelper.createTemplate(String, String)"})
  void testCreateTemplate() {
    // Arrange
    when(surveyTemplateService.create(Mockito.<String>any(), Mockito.<SurveyTemplateChangeCommand>any()))
        .thenReturn(1L);

    // Act
    long actualCreateTemplateResult = surveyTemplateHelper.createTemplate("42", "Template Name");

    // Assert
    verify(surveyTemplateService).create(eq("42"), isA(SurveyTemplateChangeCommand.class));
    assertEquals(1L, actualCreateTemplateResult);
  }

  /**
   * Test {@link SurveyTemplateHelper#updateStatus(String, long, ReleaseLifecycleStatus)}.
   * <p>
   * Method under test: {@link SurveyTemplateHelper#updateStatus(String, long, ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test updateStatus(String, long, ReleaseLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SurveyTemplateHelper.updateStatus(String, long, ReleaseLifecycleStatus)"})
  void testUpdateStatus() {
    // Arrange
    when(surveyTemplateService.updateStatus(Mockito.<String>any(), anyLong(),
        Mockito.<ReleaseLifecycleStatusChangeCommand>any())).thenReturn(1);

    // Act
    surveyTemplateHelper.updateStatus("42", 1L, ReleaseLifecycleStatus.DRAFT);

    // Assert
    verify(surveyTemplateService).updateStatus(eq("42"), eq(1L), isA(ReleaseLifecycleStatusChangeCommand.class));
  }

  /**
   * Test {@link SurveyTemplateHelper#addQuestion(long)}.
   * <p>
   * Method under test: {@link SurveyTemplateHelper#addQuestion(long)}
   */
  @Test
  @DisplayName("Test addQuestion(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long SurveyTemplateHelper.addQuestion(long)"})
  void testAddQuestion() {
    // Arrange
    when(surveyQuestionService.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);

    // Act
    long actualAddQuestionResult = surveyTemplateHelper.addQuestion(1L);

    // Assert
    verify(surveyQuestionService).create(isA(SurveyQuestion.class));
    assertEquals(1L, actualAddQuestionResult);
  }

  /**
   * Test {@link SurveyTemplateHelper#addMandatoryQuestion(long)}.
   * <p>
   * Method under test: {@link SurveyTemplateHelper#addMandatoryQuestion(long)}
   */
  @Test
  @DisplayName("Test addMandatoryQuestion(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long SurveyTemplateHelper.addMandatoryQuestion(long)"})
  void testAddMandatoryQuestion() {
    // Arrange
    when(surveyQuestionService.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);

    // Act
    long actualAddMandatoryQuestionResult = surveyTemplateHelper.addMandatoryQuestion(1L);

    // Assert
    verify(surveyQuestionService).create(isA(SurveyQuestion.class));
    assertEquals(1L, actualAddMandatoryQuestionResult);
  }

  /**
   * Test {@link SurveyTemplateHelper#deleteAllSurveyTemplate()}.
   * <p>
   * Method under test: {@link SurveyTemplateHelper#deleteAllSurveyTemplate()}
   */
  @Test
  @DisplayName("Test deleteAllSurveyTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SurveyTemplateHelper.deleteAllSurveyTemplate()"})
  void testDeleteAllSurveyTemplate() throws DataAccessException {
    // Arrange
    DeleteUsingStep<SurveyQuestionResponseRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyQuestionResponseRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    surveyTemplateHelper.deleteAllSurveyTemplate();

    // Assert
    verify(dSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(deleteUsingStep, atLeast(1)).execute();
  }
}
