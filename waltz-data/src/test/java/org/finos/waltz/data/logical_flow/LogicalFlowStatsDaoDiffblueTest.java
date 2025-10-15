package org.finos.waltz.data.logical_flow;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.finos.waltz.model.tally.TallyPack;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.QueryPart;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.Row;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.MappingException;
import org.jooq.impl.TableImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogicalFlowStatsDaoDiffblueTest {
  @Mock private DBExecutorPoolInterface dBExecutorPoolInterface;

  @Mock private DSLContext dSLContext;

  @InjectMocks private LogicalFlowStatsDao logicalFlowStatsDao;

  /**
   * Test {@link LogicalFlowStatsDao#tallyDataTypesByAppIdSelector(Select)}.
   *
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#and(Condition)} return {@link Condition}.
   *   <li>Then calls {@link Condition#and(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowStatsDao#tallyDataTypesByAppIdSelector(Select)}
   */
  @Test
  @DisplayName(
      "Test tallyDataTypesByAppIdSelector(Select); given Condition and(Condition) return Condition; then calls and(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowStatsDao.tallyDataTypesByAppIdSelector(Select)"})
  void testTallyDataTypesByAppIdSelector_givenConditionAndReturnCondition_thenCallsAnd()
      throws MappingException {
    // Arrange
    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetchGroups(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);

    Condition condition2 = mock(Condition.class);
    when(condition2.and(Mockito.<Condition>any())).thenReturn(condition);

    Condition condition3 = mock(Condition.class);
    when(condition3.and(Mockito.<Condition>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);
    when(condition3.or(Mockito.<Condition>any())).thenReturn(condition2);

    Field<Object> field = mock(Field.class);
    when(field.eq(Mockito.<Field<Object>>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);
    when(field.isNotNull()).thenReturn(condition3);

    Row row = mock(Row.class);
    when(row.field(anyInt(), Mockito.<Class<Object>>any())).thenReturn(field);

    TableImpl<Record1<Long>> tableImpl = mock(TableImpl.class);
    when(tableImpl.fieldsRow()).thenReturn(row);

    Select<Record1<Long>> appIdSelector = mock(Select.class);
    when(appIdSelector.asTable(Mockito.<String>any())).thenReturn(tableImpl);

    // Act
    List<TallyPack<String>> actualTallyDataTypesByAppIdSelectorResult =
        logicalFlowStatsDao.tallyDataTypesByAppIdSelector(appIdSelector);

    // Assert
    verify(condition3).and(isA(Condition.class));
    verify(condition2).and(isA(Condition.class));
    verify(condition).and(isA(Condition.class));
    verify(condition3).or(isA(Condition.class));
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(field, atLeast(1)).eq(Mockito.<Field<Object>>any());
    verify(field, atLeast(1)).isNotNull();
    verify(selectHavingStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(row, atLeast(1)).field(eq(0), isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    verify(appIdSelector, atLeast(1)).asTable(Mockito.<String>any());
    verify(tableImpl, atLeast(1)).fieldsRow();
    assertTrue(actualTallyDataTypesByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowStatsDao#tallyDataTypesByAppIdSelector(Select)}.
   *
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#or(Condition)} return {@link Condition}.
   *   <li>Then calls {@link Condition#and(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowStatsDao#tallyDataTypesByAppIdSelector(Select)}
   */
  @Test
  @DisplayName(
      "Test tallyDataTypesByAppIdSelector(Select); given Condition or(Condition) return Condition; then calls and(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowStatsDao.tallyDataTypesByAppIdSelector(Select)"})
  void testTallyDataTypesByAppIdSelector_givenConditionOrReturnCondition_thenCallsAnd()
      throws MappingException {
    // Arrange
    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetchGroups(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);

    Condition condition2 = mock(Condition.class);
    when(condition2.and(Mockito.<Condition>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);
    when(condition2.or(Mockito.<Condition>any())).thenReturn(condition);

    Field<Object> field = mock(Field.class);
    when(field.eq(Mockito.<Field<Object>>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);
    when(field.isNotNull()).thenReturn(condition2);

    Row row = mock(Row.class);
    when(row.field(anyInt(), Mockito.<Class<Object>>any())).thenReturn(field);

    TableImpl<Record1<Long>> tableImpl = mock(TableImpl.class);
    when(tableImpl.fieldsRow()).thenReturn(row);

    Select<Record1<Long>> appIdSelector = mock(Select.class);
    when(appIdSelector.asTable(Mockito.<String>any())).thenReturn(tableImpl);

    // Act
    List<TallyPack<String>> actualTallyDataTypesByAppIdSelectorResult =
        logicalFlowStatsDao.tallyDataTypesByAppIdSelector(appIdSelector);

    // Assert
    verify(condition2).and(isA(Condition.class));
    verify(condition).and(isA(Condition.class));
    verify(condition2).or(isA(Condition.class));
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(field, atLeast(1)).eq(Mockito.<Field<Object>>any());
    verify(field, atLeast(1)).isNotNull();
    verify(selectHavingStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(row, atLeast(1)).field(eq(0), isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    verify(appIdSelector, atLeast(1)).asTable(Mockito.<String>any());
    verify(tableImpl, atLeast(1)).fieldsRow();
    assertTrue(actualTallyDataTypesByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowStatsDao#tallyDataTypesByAppIdSelector(Select)}.
   *
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#or(Condition)} return {@link
   *       LogicalFlowDao#LOGICAL_NOT_REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowStatsDao#tallyDataTypesByAppIdSelector(Select)}
   */
  @Test
  @DisplayName(
      "Test tallyDataTypesByAppIdSelector(Select); given Condition or(Condition) return LOGICAL_NOT_REMOVED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowStatsDao.tallyDataTypesByAppIdSelector(Select)"})
  void testTallyDataTypesByAppIdSelector_givenConditionOrReturnLogical_not_removed()
      throws MappingException {
    // Arrange
    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetchGroups(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);
    when(condition.or(Mockito.<Condition>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);

    Field<Object> field = mock(Field.class);
    when(field.eq(Mockito.<Field<Object>>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);
    when(field.isNotNull()).thenReturn(condition);

    Row row = mock(Row.class);
    when(row.field(anyInt(), Mockito.<Class<Object>>any())).thenReturn(field);

    TableImpl<Record1<Long>> tableImpl = mock(TableImpl.class);
    when(tableImpl.fieldsRow()).thenReturn(row);

    Select<Record1<Long>> appIdSelector = mock(Select.class);
    when(appIdSelector.asTable(Mockito.<String>any())).thenReturn(tableImpl);

    // Act
    List<TallyPack<String>> actualTallyDataTypesByAppIdSelectorResult =
        logicalFlowStatsDao.tallyDataTypesByAppIdSelector(appIdSelector);

    // Assert
    verify(condition).and(isA(Condition.class));
    verify(condition).or(isA(Condition.class));
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(field, atLeast(1)).eq(Mockito.<Field<Object>>any());
    verify(field, atLeast(1)).isNotNull();
    verify(selectHavingStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(row, atLeast(1)).field(eq(0), isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    verify(appIdSelector, atLeast(1)).asTable(Mockito.<String>any());
    verify(tableImpl, atLeast(1)).fieldsRow();
    assertTrue(actualTallyDataTypesByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowStatsDao#tallyDataTypesByAppIdSelector(Select)}.
   *
   * <ul>
   *   <li>Given {@link Field} {@link Field#isNotNull()} return {@link
   *       LogicalFlowDao#LOGICAL_NOT_REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowStatsDao#tallyDataTypesByAppIdSelector(Select)}
   */
  @Test
  @DisplayName(
      "Test tallyDataTypesByAppIdSelector(Select); given Field isNotNull() return LOGICAL_NOT_REMOVED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowStatsDao.tallyDataTypesByAppIdSelector(Select)"})
  void testTallyDataTypesByAppIdSelector_givenFieldIsNotNullReturnLogical_not_removed()
      throws MappingException {
    // Arrange
    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetchGroups(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    Field<Object> field = mock(Field.class);
    when(field.eq(Mockito.<Field<Object>>any())).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);
    when(field.isNotNull()).thenReturn(LogicalFlowDao.LOGICAL_NOT_REMOVED);

    Row row = mock(Row.class);
    when(row.field(anyInt(), Mockito.<Class<Object>>any())).thenReturn(field);

    TableImpl<Record1<Long>> tableImpl = mock(TableImpl.class);
    when(tableImpl.fieldsRow()).thenReturn(row);

    Select<Record1<Long>> appIdSelector = mock(Select.class);
    when(appIdSelector.asTable(Mockito.<String>any())).thenReturn(tableImpl);

    // Act
    List<TallyPack<String>> actualTallyDataTypesByAppIdSelectorResult =
        logicalFlowStatsDao.tallyDataTypesByAppIdSelector(appIdSelector);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(field, atLeast(1)).eq(Mockito.<Field<Object>>any());
    verify(field, atLeast(1)).isNotNull();
    verify(selectHavingStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(row, atLeast(1)).field(eq(0), isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    verify(appIdSelector, atLeast(1)).asTable(Mockito.<String>any());
    verify(tableImpl, atLeast(1)).fieldsRow();
    assertTrue(actualTallyDataTypesByAppIdSelectorResult.isEmpty());
  }
}
