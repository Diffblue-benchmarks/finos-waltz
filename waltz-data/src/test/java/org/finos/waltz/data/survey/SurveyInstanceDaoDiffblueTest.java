package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.survey.SurveyInstance;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.schema.tables.records.SurveyInstanceRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyInstanceDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyInstanceDao surveyInstanceDao;

  /**
   * Test {@link SurveyInstanceDao#findForRecipient(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForRecipient(long)}
   */
  @Test
  @DisplayName("Test findForRecipient(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForRecipient(long)"})
  void testFindForRecipient() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForRecipientResult = surveyInstanceDao.findForRecipient(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForRecipientResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#findForSurveyRun(long)} with {@code surveyRunId}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForSurveyRun(long)}
   */
  @Test
  @DisplayName("Test findForSurveyRun(long) with 'surveyRunId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForSurveyRun(long)"})
  void testFindForSurveyRunWithSurveyRunId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForSurveyRunResult = surveyInstanceDao.findForSurveyRun(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyRunResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#findForSurveyRun(long, SurveyInstanceStatus[])} with {@code
   * surveyRunId}, {@code statuses}.
   *
   * <ul>
   *   <li>When {@code NOT_STARTED}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForSurveyRun(long, SurveyInstanceStatus[])}
   */
  @Test
  @DisplayName(
      "Test findForSurveyRun(long, SurveyInstanceStatus[]) with 'surveyRunId', 'statuses'; when 'NOT_STARTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForSurveyRun(long, SurveyInstanceStatus[])"})
  void testFindForSurveyRunWithSurveyRunIdStatuses_whenNotStarted() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForSurveyRunResult =
        surveyInstanceDao.findForSurveyRun(1L, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyRunResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#findForSurveyRun(long, SurveyInstanceStatus[])} with {@code
   * surveyRunId}, {@code statuses}.
   *
   * <ul>
   *   <li>When {@code NOT_STARTED} and {@code IN_PROGRESS}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForSurveyRun(long, SurveyInstanceStatus[])}
   */
  @Test
  @DisplayName(
      "Test findForSurveyRun(long, SurveyInstanceStatus[]) with 'surveyRunId', 'statuses'; when 'NOT_STARTED' and 'IN_PROGRESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForSurveyRun(long, SurveyInstanceStatus[])"})
  void testFindForSurveyRunWithSurveyRunIdStatuses_whenNotStartedAndInProgress()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForSurveyRunResult =
        surveyInstanceDao.findForSurveyRun(
            1L, SurveyInstanceStatus.NOT_STARTED, SurveyInstanceStatus.IN_PROGRESS);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyRunResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#findForSurveyRun(long, SurveyInstanceStatus[])} with {@code
   * surveyRunId}, {@code statuses}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForSurveyRun(long, SurveyInstanceStatus[])}
   */
  @Test
  @DisplayName(
      "Test findForSurveyRun(long, SurveyInstanceStatus[]) with 'surveyRunId', 'statuses'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForSurveyRun(long, SurveyInstanceStatus[])"})
  void testFindForSurveyRunWithSurveyRunIdStatuses_whenOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForSurveyRunResult =
        surveyInstanceDao.findForSurveyRun(1L, new SurveyInstanceStatus[] {});

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyRunResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#findForSurveyTemplate(long, SurveyInstanceStatus[])}.
   *
   * <ul>
   *   <li>When {@code NOT_STARTED}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForSurveyTemplate(long,
   * SurveyInstanceStatus[])}
   */
  @Test
  @DisplayName("Test findForSurveyTemplate(long, SurveyInstanceStatus[]); when 'NOT_STARTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForSurveyTemplate(long, SurveyInstanceStatus[])"})
  void testFindForSurveyTemplate_whenNotStarted() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForSurveyTemplateResult =
        surveyInstanceDao.findForSurveyTemplate(1L, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).join(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#findForSurveyTemplate(long, SurveyInstanceStatus[])}.
   *
   * <ul>
   *   <li>When {@code NOT_STARTED} and {@code IN_PROGRESS}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForSurveyTemplate(long,
   * SurveyInstanceStatus[])}
   */
  @Test
  @DisplayName(
      "Test findForSurveyTemplate(long, SurveyInstanceStatus[]); when 'NOT_STARTED' and 'IN_PROGRESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForSurveyTemplate(long, SurveyInstanceStatus[])"})
  void testFindForSurveyTemplate_whenNotStartedAndInProgress() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForSurveyTemplateResult =
        surveyInstanceDao.findForSurveyTemplate(
            1L, SurveyInstanceStatus.NOT_STARTED, SurveyInstanceStatus.IN_PROGRESS);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).join(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#findForSurveyTemplate(long, SurveyInstanceStatus[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForSurveyTemplate(long,
   * SurveyInstanceStatus[])}
   */
  @Test
  @DisplayName("Test findForSurveyTemplate(long, SurveyInstanceStatus[]); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForSurveyTemplate(long, SurveyInstanceStatus[])"})
  void testFindForSurveyTemplate_whenOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForSurveyTemplateResult =
        surveyInstanceDao.findForSurveyTemplate(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).join(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#deleteForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  @DisplayName(
      "Test deleteForSurveyRun(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.deleteForSurveyRun(long)"})
  void testDeleteForSurveyRun_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualDeleteForSurveyRunResult = new SurveyInstanceDao(dsl).deleteForSurveyRun(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_instance\" where \"survey_instance\".\"survey_run_id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#deleteForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  @DisplayName(
      "Test deleteForSurveyRun(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.deleteForSurveyRun(long)"})
  void testDeleteForSurveyRun_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    int actualDeleteForSurveyRunResult = new SurveyInstanceDao(dsl).deleteForSurveyRun(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_instance\" where \"survey_instance\".\"survey_run_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#deleteForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  @DisplayName(
      "Test deleteForSurveyRun(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.deleteForSurveyRun(long)"})
  void testDeleteForSurveyRun_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteForSurveyRunResult = new SurveyInstanceDao(dsl).deleteForSurveyRun(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_instance\" where \"survey_instance\".\"survey_run_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#deleteForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  @DisplayName(
      "Test deleteForSurveyRun(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.deleteForSurveyRun(long)"})
  void testDeleteForSurveyRun_givenDefaultDSLContextWithConnectionAndDialectIsSqlite()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    int actualDeleteForSurveyRunResult = new SurveyInstanceDao(dsl).deleteForSurveyRun(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from survey_instance where survey_instance.survey_run_id = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#deleteForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  @DisplayName(
      "Test deleteForSurveyRun(long); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.deleteForSurveyRun(long)"})
  void testDeleteForSurveyRun_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyInstanceRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<SurveyInstanceRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.delete(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForSurveyRunResult = surveyInstanceDao.deleteForSurveyRun(1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateStatus(Optional, long, SurveyInstanceStatus)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateStatus(Optional, long,
   * SurveyInstanceStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, long, SurveyInstanceStatus); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateStatus(Optional, long, SurveyInstanceStatus)"})
  void testUpdateStatus_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    // Act
    int actualUpdateStatusResult =
        surveyInstanceDao.updateStatus(tx, 1L, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateStatus(Optional, long, SurveyInstanceStatus)}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateStatus(Optional, long,
   * SurveyInstanceStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, long, SurveyInstanceStatus); when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateStatus(Optional, long, SurveyInstanceStatus)"})
  void testUpdateStatus_whenOfDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    int actualUpdateStatusResult =
        surveyInstanceDao.updateStatus(tx, 1L, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"status\" = cast(? as varchar) where (\"survey_instance\".\"status\" <> cast(? as varchar) and \"survey_instance\".\"id\" = cast(? as bigint) and \"survey_instance\".\"original_instance_id\" is null)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("NOT_STARTED"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateStatus(Optional, long, SurveyInstanceStatus)}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateStatus(Optional, long,
   * SurveyInstanceStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(Optional, long, SurveyInstanceStatus); when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateStatus(Optional, long, SurveyInstanceStatus)"})
  void testUpdateStatus_whenOfDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateStatusResult =
        surveyInstanceDao.updateStatus(tx, 1L, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"status\" = ? where (\"survey_instance\".\"status\" <> ? and \"survey_instance\".\"id\" = ? and \"survey_instance\".\"original_instance_id\" is null)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("NOT_STARTED"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateSubmissionDueDate(long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateSubmissionDueDate(long, LocalDate)"})
  void testUpdateSubmissionDueDate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateSubmissionDueDateResult =
        new SurveyInstanceDao(dsl).updateSubmissionDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"due_date\" = ? where \"survey_instance\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateSubmissionDueDate(long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateSubmissionDueDate(long, LocalDate)"})
  void testUpdateSubmissionDueDate2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateSubmissionDueDateResult =
        new SurveyInstanceDao(dsl).updateSubmissionDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"due_date\" = cast(? as date) where \"survey_instance\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateSubmissionDueDate(long, LocalDate); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateSubmissionDueDate(long, LocalDate)"})
  void testUpdateSubmissionDueDate_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateSubmissionDueDateResult =
        surveyInstanceDao.updateSubmissionDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateSubmissionDueDate(long, LocalDate); when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateSubmissionDueDate(long, LocalDate)"})
  void testUpdateSubmissionDueDate_whenNull_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateSubmissionDueDateResult = surveyInstanceDao.updateSubmissionDueDate(1L, null);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateApprovalDueDate(long, LocalDate); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateApprovalDueDate(long, LocalDate)"})
  void testUpdateApprovalDueDate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateApprovalDueDateResult =
        new SurveyInstanceDao(dsl).updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"approval_due_date\" = cast(? as date) where \"survey_instance\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateApprovalDueDate(long, LocalDate); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateApprovalDueDate(long, LocalDate)"})
  void testUpdateApprovalDueDate_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateApprovalDueDateResult =
        new SurveyInstanceDao(dsl).updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"approval_due_date\" = ? where \"survey_instance\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateApprovalDueDate(long, LocalDate); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateApprovalDueDate(long, LocalDate)"})
  void testUpdateApprovalDueDate_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateResult =
        surveyInstanceDao.updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDate(long, LocalDate); when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateApprovalDueDate(long, LocalDate)"})
  void testUpdateApprovalDueDate_whenNull_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateResult = surveyInstanceDao.updateApprovalDueDate(1L, null);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateDueDateForSurveyRun(long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateDueDateForSurveyRun(long, LocalDate)"})
  void testUpdateDueDateForSurveyRun() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateDueDateForSurveyRunResult =
        new SurveyInstanceDao(dsl).updateDueDateForSurveyRun(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"due_date\" = ? where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDueDateForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateDueDateForSurveyRun(long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateDueDateForSurveyRun(long, LocalDate)"})
  void testUpdateDueDateForSurveyRun2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateDueDateForSurveyRunResult =
        new SurveyInstanceDao(dsl).updateDueDateForSurveyRun(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"due_date\" = cast(? as date) where (\"survey_instance\".\"survey_run_id\" = cast(? as bigint) and \"survey_instance\".\"original_instance_id\" is null)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDueDateForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateDueDateForSurveyRun(long, LocalDate); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateDueDateForSurveyRun(long, LocalDate)"})
  void testUpdateDueDateForSurveyRun_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDueDateForSurveyRunResult =
        surveyInstanceDao.updateDueDateForSurveyRun(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateDueDateForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateDueDateForSurveyRun(long, LocalDate); when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateDueDateForSurveyRun(long, LocalDate)"})
  void testUpdateDueDateForSurveyRun_whenNull_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDueDateForSurveyRunResult =
        surveyInstanceDao.updateDueDateForSurveyRun(1L, null);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateDueDateForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDateForSurveyRun(long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateApprovalDueDateForSurveyRun(long, LocalDate)"})
  void testUpdateApprovalDueDateForSurveyRun() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateApprovalDueDateForSurveyRunResult =
        new SurveyInstanceDao(dsl).updateApprovalDueDateForSurveyRun(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"approval_due_date\" = ? where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateApprovalDueDateForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long, LocalDate)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDateForSurveyRun(long, LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateApprovalDueDateForSurveyRun(long, LocalDate)"})
  void testUpdateApprovalDueDateForSurveyRun2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateApprovalDueDateForSurveyRunResult =
        new SurveyInstanceDao(dsl).updateApprovalDueDateForSurveyRun(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"approval_due_date\" = cast(? as date) where (\"survey_instance\".\"survey_run_id\" = cast(? as bigint) and \"survey_instance\".\"original_instance_id\" is null)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateApprovalDueDateForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long, LocalDate)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long,
   * LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDateForSurveyRun(long, LocalDate); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateApprovalDueDateForSurveyRun(long, LocalDate)"})
  void testUpdateApprovalDueDateForSurveyRun_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateForSurveyRunResult =
        surveyInstanceDao.updateApprovalDueDateForSurveyRun(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateApprovalDueDateForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long, LocalDate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long,
   * LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateApprovalDueDateForSurveyRun(long, LocalDate); when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateApprovalDueDateForSurveyRun(long, LocalDate)"})
  void testUpdateApprovalDueDateForSurveyRun_whenNull_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateForSurveyRunResult =
        surveyInstanceDao.updateApprovalDueDateForSurveyRun(1L, null);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateApprovalDueDateForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateOwningRoleForSurveyRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateOwningRoleForSurveyRun(long, String)}
   */
  @Test
  @DisplayName("Test updateOwningRoleForSurveyRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateOwningRoleForSurveyRun(long, String)"})
  void testUpdateOwningRoleForSurveyRun() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateOwningRoleForSurveyRunResult =
        new SurveyInstanceDao(dsl).updateOwningRoleForSurveyRun(1L, "Role");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"owning_role\" = ? where \"survey_instance\".\"survey_run_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Role");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateOwningRoleForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateOwningRoleForSurveyRun(long, String)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateOwningRoleForSurveyRun(long, String)}
   */
  @Test
  @DisplayName("Test updateOwningRoleForSurveyRun(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateOwningRoleForSurveyRun(long, String)"})
  void testUpdateOwningRoleForSurveyRun2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateOwningRoleForSurveyRunResult =
        new SurveyInstanceDao(dsl).updateOwningRoleForSurveyRun(1L, "Role");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"owning_role\" = cast(? as varchar) where \"survey_instance\".\"survey_run_id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Role");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateOwningRoleForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#updateOwningRoleForSurveyRun(long, String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#updateOwningRoleForSurveyRun(long, String)}
   */
  @Test
  @DisplayName("Test updateOwningRoleForSurveyRun(long, String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.updateOwningRoleForSurveyRun(long, String)"})
  void testUpdateOwningRoleForSurveyRun_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwningRoleForSurveyRunResult =
        surveyInstanceDao.updateOwningRoleForSurveyRun(1L, "Role");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateOwningRoleForSurveyRunResult);
  }

  /**
   * Test {@link SurveyInstanceDao#markSubmitted(Optional, long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#markSubmitted(Optional, long, String)}
   */
  @Test
  @DisplayName(
      "Test markSubmitted(Optional, long, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.markSubmitted(Optional, long, String)"})
  void testMarkSubmitted_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    // Act
    int actualMarkSubmittedResult = surveyInstanceDao.markSubmitted(tx, 1L, "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualMarkSubmittedResult);
  }

  /**
   * Test {@link SurveyInstanceDao#markSubmitted(Optional, long, String)}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#markSubmitted(Optional, long, String)}
   */
  @Test
  @DisplayName(
      "Test markSubmitted(Optional, long, String); when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.markSubmitted(Optional, long, String)"})
  void testMarkSubmitted_whenOfDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    int actualMarkSubmittedResult = surveyInstanceDao.markSubmitted(tx, 1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"status\" = cast(? as varchar), \"survey_instance\".\"submitted_at\" = cast(? as datetime), \"survey_instance\".\"submitted_by\" = cast(? as varchar) where (\"survey_instance\".\"id\" = cast(? as bigint) and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" in (cast(? as varchar), cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkSubmittedResult);
  }

  /**
   * Test {@link SurveyInstanceDao#markSubmitted(Optional, long, String)}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#markSubmitted(Optional, long, String)}
   */
  @Test
  @DisplayName(
      "Test markSubmitted(Optional, long, String); when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.markSubmitted(Optional, long, String)"})
  void testMarkSubmitted_whenOfDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualMarkSubmittedResult = surveyInstanceDao.markSubmitted(tx, 1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"status\" = ?, \"survey_instance\".\"submitted_at\" = ?, \"survey_instance\".\"submitted_by\" = ? where (\"survey_instance\".\"id\" = ? and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" in (?, ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkSubmittedResult);
  }

  /**
   * Test {@link SurveyInstanceDao#markApproved(Optional, long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#markApproved(Optional, long, String)}
   */
  @Test
  @DisplayName(
      "Test markApproved(Optional, long, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.markApproved(Optional, long, String)"})
  void testMarkApproved_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    // Act
    int actualMarkApprovedResult = surveyInstanceDao.markApproved(tx, 1L, "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualMarkApprovedResult);
  }

  /**
   * Test {@link SurveyInstanceDao#markApproved(Optional, long, String)}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#markApproved(Optional, long, String)}
   */
  @Test
  @DisplayName(
      "Test markApproved(Optional, long, String); when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.markApproved(Optional, long, String)"})
  void testMarkApproved_whenOfDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    int actualMarkApprovedResult = surveyInstanceDao.markApproved(tx, 1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"approved_at\" = cast(? as datetime), \"survey_instance\".\"approved_by\" = cast(? as varchar), \"survey_instance\".\"status\" = cast(? as varchar) where (\"survey_instance\".\"id\" = cast(? as bigint) and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(1), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkApprovedResult);
  }

  /**
   * Test {@link SurveyInstanceDao#markApproved(Optional, long, String)}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#markApproved(Optional, long, String)}
   */
  @Test
  @DisplayName(
      "Test markApproved(Optional, long, String); when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.markApproved(Optional, long, String)"})
  void testMarkApproved_whenOfDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualMarkApprovedResult = surveyInstanceDao.markApproved(tx, 1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"approved_at\" = ?, \"survey_instance\".\"approved_by\" = ?, \"survey_instance\".\"status\" = ? where (\"survey_instance\".\"id\" = ? and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(1), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkApprovedResult);
  }

  /**
   * Test {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate,
   * LocalDate)}
   */
  @Test
  @DisplayName(
      "Test reopenSurvey(Optional, long, LocalDate, LocalDate); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.reopenSurvey(Optional, long, LocalDate, LocalDate)"})
  void testReopenSurvey_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep7 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep8 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep7);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep8);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    // Act
    int actualReopenSurveyResult =
        surveyInstanceDao.reopenSurvey(tx, 1L, LocalDate.of(1970, 1, 1), LocalDate.of(1970, 1, 1));

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep8).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep7).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep6).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep5).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualReopenSurveyResult);
  }

  /**
   * Test {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate,
   * LocalDate)}
   */
  @Test
  @DisplayName(
      "Test reopenSurvey(Optional, long, LocalDate, LocalDate); given UpdateConditionStep execute() return one; when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.reopenSurvey(Optional, long, LocalDate, LocalDate)"})
  void testReopenSurvey_givenUpdateConditionStepExecuteReturnOne_whenNull_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep7 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);

    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep8 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep7);

    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep8);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any()))
        .thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    // Act
    int actualReopenSurveyResult =
        surveyInstanceDao.reopenSurvey(tx, 1L, null, LocalDate.of(1970, 1, 1));

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep8).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep7).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep6).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep5).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualReopenSurveyResult);
  }

  /**
   * Test {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate, LocalDate)}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate,
   * LocalDate)}
   */
  @Test
  @DisplayName(
      "Test reopenSurvey(Optional, long, LocalDate, LocalDate); when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.reopenSurvey(Optional, long, LocalDate, LocalDate)"})
  void testReopenSurvey_whenOfDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    int actualReopenSurveyResult =
        surveyInstanceDao.reopenSurvey(tx, 1L, LocalDate.of(1970, 1, 1), LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"status\" = cast(? as varchar), \"survey_instance\".\"approved_at\" = cast(? as datetime), \"survey_instance\".\"approved_by\" = cast(? as varchar), \"survey_instance\".\"submitted_at\" = cast(? as datetime), \"survey_instance\".\"submitted_by\" = cast(? as varchar), \"survey_instance\".\"issued_on\" = cast(? as date), \"survey_instance\".\"due_date\" = cast(? as date), \"survey_instance\".\"approval_due_date\" = cast(? as date) where (\"survey_instance\".\"id\" = cast(? as bigint) and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" in (cast(? as varchar), cast(? as varchar), cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setDate(anyInt(), isA(Date.class));
    verify(preparedStatement).setLong(9, 1L);
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualReopenSurveyResult);
  }

  /**
   * Test {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate, LocalDate)}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate,
   * LocalDate)}
   */
  @Test
  @DisplayName(
      "Test reopenSurvey(Optional, long, LocalDate, LocalDate); when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyInstanceDao.reopenSurvey(Optional, long, LocalDate, LocalDate)"})
  void testReopenSurvey_whenOfDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualReopenSurveyResult =
        surveyInstanceDao.reopenSurvey(tx, 1L, LocalDate.of(1970, 1, 1), LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_instance\" set \"survey_instance\".\"status\" = ?, \"survey_instance\".\"approved_at\" = ?, \"survey_instance\".\"approved_by\" = ?, \"survey_instance\".\"submitted_at\" = ?, \"survey_instance\".\"submitted_by\" = ?, \"survey_instance\".\"issued_on\" = ?, \"survey_instance\".\"due_date\" = ?, \"survey_instance\".\"approval_due_date\" = ? where (\"survey_instance\".\"id\" = ? and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" in (?, ?, ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setDate(anyInt(), isA(Date.class));
    verify(preparedStatement).setLong(9, 1L);
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualReopenSurveyResult);
  }

  /**
   * Test {@link SurveyInstanceDao#findPreviousVersionsForInstance(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#findPreviousVersionsForInstance(long)}
   */
  @Test
  @DisplayName("Test findPreviousVersionsForInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceDao.findPreviousVersionsForInstance(long)"})
  void testFindPreviousVersionsForInstance() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<SurveyInstance> actualFindPreviousVersionsForInstanceResult =
        surveyInstanceDao.findPreviousVersionsForInstance(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindPreviousVersionsForInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#findVersionsForInstance(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#findVersionsForInstance(long)}
   */
  @Test
  @DisplayName("Test findVersionsForInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceDao.findVersionsForInstance(long)"})
  void testFindVersionsForInstance() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<SurveyInstance> actualFindVersionsForInstanceResult =
        surveyInstanceDao.findVersionsForInstance(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).or(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindVersionsForInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceDao#createInstanceRecipients(Long, Collection)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#createInstanceRecipients(Long, Collection)}
   */
  @Test
  @DisplayName("Test createInstanceRecipients(Long, Collection); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] SurveyInstanceDao.createInstanceRecipients(Long, Collection)"})
  void testCreateInstanceRecipients_thenReturnEmptyArrayOfInt() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(
        new int[] {}, surveyInstanceDao.createInstanceRecipients(1L, new ArrayList<>()));
  }

  /**
   * Test {@link SurveyInstanceDao#createInstanceOwners(Long, Collection)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceDao#createInstanceOwners(Long, Collection)}
   */
  @Test
  @DisplayName("Test createInstanceOwners(Long, Collection); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] SurveyInstanceDao.createInstanceOwners(Long, Collection)"})
  void testCreateInstanceOwners_thenReturnEmptyArrayOfInt() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao =
        new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(new int[] {}, surveyInstanceDao.createInstanceOwners(1L, new ArrayList<>()));
  }

  /**
   * Test {@link SurveyInstanceDao#findForOwner(Long)}.
   *
   * <p>Method under test: {@link SurveyInstanceDao#findForOwner(Long)}
   */
  @Test
  @DisplayName("Test findForOwner(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyInstanceDao.findForOwner(Long)"})
  void testFindForOwner() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<SurveyInstance> actualFindForOwnerResult = surveyInstanceDao.findForOwner(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForOwnerResult.isEmpty());
  }
}
