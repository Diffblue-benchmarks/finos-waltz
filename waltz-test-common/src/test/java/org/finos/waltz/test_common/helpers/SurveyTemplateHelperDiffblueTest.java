package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class SurveyTemplateHelperDiffblueTest {
  /**
   * Method under test:
   * {@link SurveyTemplateHelper#createTemplate(String, String)}
   */
  @Test
  void testCreateTemplate() {
    // Arrange
    SurveyTemplateService surveyTemplateService = mock(SurveyTemplateService.class);
    when(surveyTemplateService.create(Mockito.<String>any(), Mockito.<SurveyTemplateChangeCommand>any()))
        .thenReturn(1L);
    SurveyTemplateHelper surveyTemplateHelper = new SurveyTemplateHelper();
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyTemplateService", surveyTemplateService);
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyQuestionService", mock(SurveyQuestionService.class));
    ReflectionTestUtils.setField(surveyTemplateHelper, "dsl", mock(DSLContext.class));

    // Act
    long actualCreateTemplateResult = surveyTemplateHelper.createTemplate("42", "Template Name");

    // Assert
    verify(surveyTemplateService).create(eq("42"), isA(SurveyTemplateChangeCommand.class));
    assertEquals(1L, actualCreateTemplateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateHelper#updateStatus(String, long, ReleaseLifecycleStatus)}
   */
  @Test
  void testUpdateStatus() {
    // Arrange
    SurveyTemplateService surveyTemplateService = mock(SurveyTemplateService.class);
    when(surveyTemplateService.updateStatus(Mockito.<String>any(), anyLong(),
        Mockito.<ReleaseLifecycleStatusChangeCommand>any())).thenReturn(1);
    SurveyTemplateHelper surveyTemplateHelper = new SurveyTemplateHelper();
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyTemplateService", surveyTemplateService);
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyQuestionService", mock(SurveyQuestionService.class));
    ReflectionTestUtils.setField(surveyTemplateHelper, "dsl", mock(DSLContext.class));

    // Act
    surveyTemplateHelper.updateStatus("42", 1L, ReleaseLifecycleStatus.DRAFT);

    // Assert
    verify(surveyTemplateService).updateStatus(eq("42"), eq(1L), isA(ReleaseLifecycleStatusChangeCommand.class));
  }

  /**
   * Method under test: {@link SurveyTemplateHelper#addQuestion(long)}
   */
  @Test
  void testAddQuestion() {
    // Arrange
    SurveyTemplateHelper surveyTemplateHelper = new SurveyTemplateHelper();
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyTemplateService", mock(SurveyTemplateService.class));
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyQuestionService", surveyQuestionService);
    ReflectionTestUtils.setField(surveyTemplateHelper, "dsl", mock(DSLContext.class));

    // Act
    long actualAddQuestionResult = surveyTemplateHelper.addQuestion(1L);

    // Assert
    verify(surveyQuestionService).create(isA(SurveyQuestion.class));
    assertEquals(1L, actualAddQuestionResult);
  }

  /**
   * Method under test: {@link SurveyTemplateHelper#addMandatoryQuestion(long)}
   */
  @Test
  void testAddMandatoryQuestion() {
    // Arrange
    SurveyTemplateHelper surveyTemplateHelper = new SurveyTemplateHelper();
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyTemplateService", mock(SurveyTemplateService.class));
    SurveyQuestionService surveyQuestionService = mock(SurveyQuestionService.class);
    when(surveyQuestionService.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyQuestionService", surveyQuestionService);
    ReflectionTestUtils.setField(surveyTemplateHelper, "dsl", mock(DSLContext.class));

    // Act
    long actualAddMandatoryQuestionResult = surveyTemplateHelper.addMandatoryQuestion(1L);

    // Assert
    verify(surveyQuestionService).create(isA(SurveyQuestion.class));
    assertEquals(1L, actualAddMandatoryQuestionResult);
  }

  /**
   * Method under test: {@link SurveyTemplateHelper#deleteAllSurveyTemplate()}
   */
  @Test
  void testDeleteAllSurveyTemplate() throws DataAccessException {
    // Arrange
    SurveyTemplateHelper surveyTemplateHelper = new SurveyTemplateHelper();
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyTemplateService", mock(SurveyTemplateService.class));
    ReflectionTestUtils.setField(surveyTemplateHelper, "surveyQuestionService", mock(SurveyQuestionService.class));
    DeleteUsingStep<SurveyQuestionResponseRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.deleteFrom(Mockito.<Table<SurveyQuestionResponseRecord>>any())).thenReturn(deleteUsingStep);
    ReflectionTestUtils.setField(surveyTemplateHelper, "dsl", dslContext);

    // Act
    surveyTemplateHelper.deleteAllSurveyTemplate();

    // Assert
    verify(dslContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(deleteUsingStep, atLeast(1)).execute();
  }
}
