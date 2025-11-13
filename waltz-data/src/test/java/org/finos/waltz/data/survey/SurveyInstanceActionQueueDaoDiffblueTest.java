package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionParams;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionQueueItem;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionQueueItem.Builder;
import org.finos.waltz.model.survey.SurveyInstanceAction;
import org.finos.waltz.model.survey.SurveyInstanceActionParams;
import org.finos.waltz.model.survey.SurveyInstanceActionQueueItem;
import org.finos.waltz.model.survey.SurveyInstanceActionStatus;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.schema.tables.records.SurveyInstanceActionQueueRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSeekStep1;
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
class SurveyInstanceActionQueueDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyInstanceActionQueueDao surveyInstanceActionQueueDao;

  /**
   * Test {@link SurveyInstanceActionQueueDao#findPendingActions()}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#findPendingActions()}
   */
  @Test
  @DisplayName(
      "Test findPendingActions(); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceActionQueueDao.findPendingActions()"})
  void testFindPendingActions_givenDSLContextSelectThrowIllegalStateException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> surveyInstanceActionQueueDao.findPendingActions());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#findPendingActions()}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#orderBy(OrderField)} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#findPendingActions()}
   */
  @Test
  @DisplayName(
      "Test findPendingActions(); given SelectConditionStep orderBy(OrderField) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceActionQueueDao.findPendingActions()"})
  void testFindPendingActions_givenSelectConditionStepOrderByThrowIllegalStateException() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenThrow(new IllegalStateException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> surveyInstanceActionQueueDao.findPendingActions());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#findPendingActions()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#findPendingActions()}
   */
  @Test
  @DisplayName(
      "Test findPendingActions(); given SelectJoinStep where(Condition) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceActionQueueDao.findPendingActions()"})
  void testFindPendingActions_givenSelectJoinStepWhereThrowIllegalStateException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalStateException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new SurveyInstanceActionQueueDao(dsl).findPendingActions());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#findPendingActions()}.
   *
   * <ul>
   *   <li>Given {@link SelectSeekStep1} {@link SelectSeekStep1#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#findPendingActions()}
   */
  @Test
  @DisplayName(
      "Test findPendingActions(); given SelectSeekStep1 fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceActionQueueDao.findPendingActions()"})
  void testFindPendingActions_givenSelectSeekStep1FetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyInstanceActionQueueItem> actualFindPendingActionsResult =
        new SurveyInstanceActionQueueDao(dsl).findPendingActions();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindPendingActionsResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#findPendingActions()}.
   *
   * <ul>
   *   <li>Given {@link SelectSeekStep1} {@link SelectSeekStep1#fetch(RecordMapper)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#findPendingActions()}
   */
  @Test
  @DisplayName(
      "Test findPendingActions(); given SelectSeekStep1 fetch(RecordMapper) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceActionQueueDao.findPendingActions()"})
  void testFindPendingActions_givenSelectSeekStep1FetchThrowIllegalStateException()
      throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalStateException());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> surveyInstanceActionQueueDao.findPendingActions());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#findPendingActions()}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#findPendingActions()}
   */
  @Test
  @DisplayName(
      "Test findPendingActions(); given SelectSelectStep from(TableLike) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceActionQueueDao.findPendingActions()"})
  void testFindPendingActions_givenSelectSelectStepFromThrowIllegalStateException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new IllegalStateException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new SurveyInstanceActionQueueDao(dsl).findPendingActions());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceActionQueueItem SurveyInstanceActionQueueDao.getById(long)"})
  void testGetById_givenDSLContextSelectThrowIllegalStateException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> surveyInstanceActionQueueDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(RecordMapper)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectConditionStep fetchOne(RecordMapper) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceActionQueueItem SurveyInstanceActionQueueDao.getById(long)"})
  void testGetById_givenSelectConditionStepFetchOneThrowIllegalStateException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalStateException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> surveyInstanceActionQueueDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link SelectJoinStep#where(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectJoinStep where(Condition) throw IllegalStateException(); then calls where(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceActionQueueItem SurveyInstanceActionQueueDao.getById(long)"})
  void testGetById_givenSelectJoinStepWhereThrowIllegalStateException_thenCallsWhere() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalStateException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new SurveyInstanceActionQueueDao(dsl).getById(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectSelectStep from(TableLike) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceActionQueueItem SurveyInstanceActionQueueDao.getById(long)"})
  void testGetById_givenSelectSelectStepFromThrowIllegalStateException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new IllegalStateException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new SurveyInstanceActionQueueDao(dsl).getById(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSurveyInstanceActionQueueItem}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutableSurveyInstanceActionQueueItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceActionQueueItem SurveyInstanceActionQueueDao.getById(long)"})
  void testGetById_thenReturnImmutableSurveyInstanceActionQueueItem() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            actionResult
                .actionParams(actionParams)
                .actionedAt(ofResult.atStartOfDay())
                .id(1L)
                .initialState(SurveyInstanceStatus.NOT_STARTED)
                .message("Not all who wander are lost")
                .provenance("Provenance")
                .status(SurveyInstanceActionStatus.PENDING)
                .submittedAt(ofResult2.atStartOfDay())
                .submittedBy("Submitted By")
                .surveyInstanceId(1L)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    SurveyInstanceActionQueueItem actualById = new SurveyInstanceActionQueueDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableSurveyInstanceActionQueueItem);
    assertEquals("Not all who wander are lost", actualById.message());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("Submitted By", actualById.submittedBy());
    assertEquals(1L, actualById.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualById.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, actualById.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualById.initialState());
    assertSame(ofResult, actualById.actionedAt().toLocalDate());
    assertSame(ofResult2, actualById.submittedAt().toLocalDate());
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#update(Table)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String); given DSLContext update(Table) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceActionQueueDao.updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)"
  })
  void testUpdateActionStatus_givenDSLContextUpdateThrowIllegalStateException() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            surveyInstanceActionQueueDao.updateActionStatus(
                dSLContext, 1L, SurveyInstanceActionStatus.PENDING, "Msg"));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then calls {@link UpdateConditionStep#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String); given UpdateConditionStep execute() return one; then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceActionQueueDao.updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)"
  })
  void testUpdateActionStatus_givenUpdateConditionStepExecuteReturnOne_thenCallsExecute()
      throws DataAccessException {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    UpdateConditionStep<SurveyInstanceActionQueueRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep2 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep3 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    surveyInstanceActionQueueDao.updateActionStatus(
        tx, 1L, SurveyInstanceActionStatus.PENDING, "Msg");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String); given UpdateConditionStep execute() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceActionQueueDao.updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)"
  })
  void testUpdateActionStatus_givenUpdateConditionStepExecuteThrowIllegalStateException()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceActionQueueRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new IllegalStateException());

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep2 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep3 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            surveyInstanceActionQueueDao.updateActionStatus(
                dSLContext, 1L, SurveyInstanceActionStatus.PENDING, "Msg"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String); given UpdateSetFirstStep set(Field, Object) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceActionQueueDao.updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)"
  })
  void testUpdateActionStatus_givenUpdateSetFirstStepSetThrowIllegalStateException() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            surveyInstanceActionQueueDao.updateActionStatus(
                tx, 1L, SurveyInstanceActionStatus.PENDING, "Msg"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String); given UpdateSetMoreStep set(Field, Object) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceActionQueueDao.updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)"
  })
  void testUpdateActionStatus_givenUpdateSetMoreStepSetThrowIllegalStateException() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            surveyInstanceActionQueueDao.updateActionStatus(
                tx, 1L, SurveyInstanceActionStatus.PENDING, "Msg"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String); given UpdateSetMoreStep set(Field, Object) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceActionQueueDao.updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)"
  })
  void testUpdateActionStatus_givenUpdateSetMoreStepSetThrowIllegalStateException2() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep2 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            surveyInstanceActionQueueDao.updateActionStatus(
                tx, 1L, SurveyInstanceActionStatus.PENDING, "Msg"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#where(Condition)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String); given UpdateSetMoreStep where(Condition) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceActionQueueDao.updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)"
  })
  void testUpdateActionStatus_givenUpdateSetMoreStepWhereThrowIllegalStateException() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenThrow(new IllegalStateException());

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep2 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep3 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            surveyInstanceActionQueueDao.updateActionStatus(
                tx, 1L, SurveyInstanceActionStatus.PENDING, "Msg"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long,
   * SurveyInstanceActionStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceActionQueueDao.updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)"
  })
  void testUpdateActionStatus_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            surveyInstanceActionQueueDao.updateActionStatus(
                new DefaultDSLContext(connection, SQLDialect.SQL99),
                1L,
                SurveyInstanceActionStatus.PENDING,
                "Msg"));
    verify(connection)
        .prepareStatement(
            "update \"survey_instance_action_queue\" set \"survey_instance_action_queue\".\"actioned_at\" = ?, \"survey_instance_action_queue\".\"status\" = ?, \"survey_instance_action_queue\".\"message\" = ? where (\"survey_instance_action_queue\".\"id\" = ? and \"survey_instance_action_queue\".\"status\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(1), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext, Long)}.
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext,
   * Long)}
   */
  @Test
  @DisplayName("Test markActionInProgress(DSLContext, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueDao.markActionInProgress(DSLContext, Long)"})
  void testMarkActionInProgress() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceActionQueueRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new IllegalStateException());

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> surveyInstanceActionQueueDao.markActionInProgress(dSLContext, 1L));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext, Long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#update(Table)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext,
   * Long)}
   */
  @Test
  @DisplayName(
      "Test markActionInProgress(DSLContext, Long); given DSLContext update(Table) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueDao.markActionInProgress(DSLContext, Long)"})
  void testMarkActionInProgress_givenDSLContextUpdateThrowIllegalStateException() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> surveyInstanceActionQueueDao.markActionInProgress(dSLContext, 1L));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext, Long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext,
   * Long)}
   */
  @Test
  @DisplayName(
      "Test markActionInProgress(DSLContext, Long); given UpdateConditionStep execute() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueDao.markActionInProgress(DSLContext, Long)"})
  void testMarkActionInProgress_givenUpdateConditionStepExecuteReturnOne()
      throws DataAccessException {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    UpdateConditionStep<SurveyInstanceActionQueueRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    surveyInstanceActionQueueDao.markActionInProgress(tx, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext, Long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext,
   * Long)}
   */
  @Test
  @DisplayName(
      "Test markActionInProgress(DSLContext, Long); given UpdateSetFirstStep set(Field, Object) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueDao.markActionInProgress(DSLContext, Long)"})
  void testMarkActionInProgress_givenUpdateSetFirstStepSetThrowIllegalStateException() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> surveyInstanceActionQueueDao.markActionInProgress(tx, 1L));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext, Long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#where(Condition)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext,
   * Long)}
   */
  @Test
  @DisplayName(
      "Test markActionInProgress(DSLContext, Long); given UpdateSetMoreStep where(Condition) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueDao.markActionInProgress(DSLContext, Long)"})
  void testMarkActionInProgress_givenUpdateSetMoreStepWhereThrowIllegalStateException() {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenThrow(new IllegalStateException());

    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> surveyInstanceActionQueueDao.markActionInProgress(tx, 1L));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Test {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext,
   * Long)}
   */
  @Test
  @DisplayName("Test markActionInProgress(DSLContext, Long); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyInstanceActionQueueDao.markActionInProgress(DSLContext, Long)"})
  void testMarkActionInProgress_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao =
        new SurveyInstanceActionQueueDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            surveyInstanceActionQueueDao.markActionInProgress(
                new DefaultDSLContext(connection, SQLDialect.SQL99), 1L));
    verify(connection)
        .prepareStatement(
            "update \"survey_instance_action_queue\" set \"survey_instance_action_queue\".\"status\" = ? where (\"survey_instance_action_queue\".\"id\" = ? and \"survey_instance_action_queue\".\"status\" = ? and not exists (select \"survey_instance_action_queue\".\"id\" from \"survey_instance_action_queue\" where \"survey_instance_action_queue\".\"status\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }
}
