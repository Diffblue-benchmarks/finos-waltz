package org.finos.waltz.data.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.data_flow_decorator.DataTypeDirectionKey;
import org.finos.waltz.model.data_flow_decorator.DecoratorRatingSummary;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.Row;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinPartitionByStep;
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
import org.jooq.exception.MappingException;
import org.jooq.impl.DefaultDSLContext;
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
class LogicalFlowDecoratorSummaryDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao;

  /**
   * Test {@link LogicalFlowDecoratorSummaryDao#summarizeForAll()}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorSummaryDao#summarizeForAll()}
   */
  @Test
  @DisplayName("Test summarizeForAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDecoratorSummaryDao.summarizeForAll()"})
  void testSummarizeForAll() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy(Mockito.<Collection<GroupField>>any()))
        .thenReturn(selectHavingStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<String>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep2);

    // Act
    List<DecoratorRatingSummary> actualSummarizeForAllResult =
        logicalFlowDecoratorSummaryDao.summarizeForAll();

    // Assert
    verify(dSLContext, atLeast(1)).renderInlined(Mockito.<QueryPart>any());
    verify(dSLContext).select(isA(Collection.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy(isA(Collection.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on("Render Inlined");
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualSummarizeForAllResult.isEmpty());
  }

  /**
   * Test {@link
   * LogicalFlowDecoratorSummaryDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorSummaryDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}
   */
  @Test
  @DisplayName("Test updateRatingsByCondition(AuthoritativenessRatingValue, Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorSummaryDao.updateRatingsByCondition(AuthoritativenessRatingValue, Condition)"
  })
  void testUpdateRatingsByCondition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao =
        new LogicalFlowDecoratorSummaryDao(dsl);

    // Act
    int actualUpdateRatingsByConditionResult =
        logicalFlowDecoratorSummaryDao.updateRatingsByCondition(
            AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = ? where \"application\".\"entity_lifecycle_status\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRatingsByConditionResult);
  }

  /**
   * Test {@link
   * LogicalFlowDecoratorSummaryDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorSummaryDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}
   */
  @Test
  @DisplayName("Test updateRatingsByCondition(AuthoritativenessRatingValue, Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorSummaryDao.updateRatingsByCondition(AuthoritativenessRatingValue, Condition)"
  })
  void testUpdateRatingsByCondition2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao =
        new LogicalFlowDecoratorSummaryDao(dsl);

    // Act
    int actualUpdateRatingsByConditionResult =
        logicalFlowDecoratorSummaryDao.updateRatingsByCondition(
            AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = cast(? as varchar) where \"application\".\"entity_lifecycle_status\" = cast(? as varchar)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRatingsByConditionResult);
  }

  /**
   * Test {@link
   * LogicalFlowDecoratorSummaryDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorSummaryDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}
   */
  @Test
  @DisplayName(
      "Test updateRatingsByCondition(AuthoritativenessRatingValue, Condition); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorSummaryDao.updateRatingsByCondition(AuthoritativenessRatingValue, Condition)"
  })
  void testUpdateRatingsByCondition_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowDecoratorRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<LogicalFlowDecoratorRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRatingsByConditionResult =
        logicalFlowDecoratorSummaryDao.updateRatingsByCondition(
            AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateRatingsByConditionResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorSummaryDao#logicalFlowIdsByTypeAndDirection(Select)}.
   *
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#or(Condition)} return {@link Condition}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorSummaryDao#logicalFlowIdsByTypeAndDirection(Select)}
   */
  @Test
  @DisplayName(
      "Test logicalFlowIdsByTypeAndDirection(Select); given Condition or(Condition) return Condition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LogicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(Select)"})
  void testLogicalFlowIdsByTypeAndDirection_givenConditionOrReturnCondition()
      throws MappingException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

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
    when(condition.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    Condition condition2 = mock(Condition.class);
    when(condition2.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(condition2.or(Mockito.<Condition>any())).thenReturn(condition);

    Field<Object> field = mock(Field.class);
    when(field.eq(Mockito.<Field<Object>>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.isNotNull()).thenReturn(condition2);

    Row row = mock(Row.class);
    when(row.field(anyInt(), Mockito.<Class<Object>>any())).thenReturn(field);

    TableImpl<Record1<Long>> tableImpl = mock(TableImpl.class);
    when(tableImpl.fieldsRow()).thenReturn(row);

    Select<Record1<Long>> selector = mock(Select.class);
    when(selector.asTable(Mockito.<String>any())).thenReturn(tableImpl);

    // Act
    Map<DataTypeDirectionKey, List<Long>> actualLogicalFlowIdsByTypeAndDirectionResult =
        logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(selector);

    // Assert
    verify(condition2).and(isA(Condition.class));
    verify(condition).and(isA(Condition.class));
    verify(condition2).or(isA(Condition.class));
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(field, atLeast(1)).eq(Mockito.<Field<Object>>any());
    verify(field, atLeast(1)).isNotNull();
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(row, atLeast(1)).field(eq(0), isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    verify(selector, atLeast(1)).asTable(Mockito.<String>any());
    verify(tableImpl, atLeast(1)).fieldsRow();
    assertTrue(actualLogicalFlowIdsByTypeAndDirectionResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorSummaryDao#logicalFlowIdsByTypeAndDirection(Select)}.
   *
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#or(Condition)} return {@link
   *       ApplicationDao#IS_ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorSummaryDao#logicalFlowIdsByTypeAndDirection(Select)}
   */
  @Test
  @DisplayName(
      "Test logicalFlowIdsByTypeAndDirection(Select); given Condition or(Condition) return IS_ACTIVE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LogicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(Select)"})
  void testLogicalFlowIdsByTypeAndDirection_givenConditionOrReturnIs_active()
      throws MappingException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

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
    when(condition.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(condition.or(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    Field<Object> field = mock(Field.class);
    when(field.eq(Mockito.<Field<Object>>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.isNotNull()).thenReturn(condition);

    Row row = mock(Row.class);
    when(row.field(anyInt(), Mockito.<Class<Object>>any())).thenReturn(field);

    TableImpl<Record1<Long>> tableImpl = mock(TableImpl.class);
    when(tableImpl.fieldsRow()).thenReturn(row);

    Select<Record1<Long>> selector = mock(Select.class);
    when(selector.asTable(Mockito.<String>any())).thenReturn(tableImpl);

    // Act
    Map<DataTypeDirectionKey, List<Long>> actualLogicalFlowIdsByTypeAndDirectionResult =
        logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(selector);

    // Assert
    verify(condition).and(isA(Condition.class));
    verify(condition).or(isA(Condition.class));
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(field, atLeast(1)).eq(Mockito.<Field<Object>>any());
    verify(field, atLeast(1)).isNotNull();
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(row, atLeast(1)).field(eq(0), isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    verify(selector, atLeast(1)).asTable(Mockito.<String>any());
    verify(tableImpl, atLeast(1)).fieldsRow();
    assertTrue(actualLogicalFlowIdsByTypeAndDirectionResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorSummaryDao#logicalFlowIdsByTypeAndDirection(Select)}.
   *
   * <ul>
   *   <li>Given {@link Field} {@link Field#isNotNull()} return {@link ApplicationDao#IS_ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorSummaryDao#logicalFlowIdsByTypeAndDirection(Select)}
   */
  @Test
  @DisplayName(
      "Test logicalFlowIdsByTypeAndDirection(Select); given Field isNotNull() return IS_ACTIVE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LogicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(Select)"})
  void testLogicalFlowIdsByTypeAndDirection_givenFieldIsNotNullReturnIs_active()
      throws MappingException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

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
    when(field.eq(Mockito.<Field<Object>>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.isNotNull()).thenReturn(ApplicationDao.IS_ACTIVE);

    Row row = mock(Row.class);
    when(row.field(anyInt(), Mockito.<Class<Object>>any())).thenReturn(field);

    TableImpl<Record1<Long>> tableImpl = mock(TableImpl.class);
    when(tableImpl.fieldsRow()).thenReturn(row);

    Select<Record1<Long>> selector = mock(Select.class);
    when(selector.asTable(Mockito.<String>any())).thenReturn(tableImpl);

    // Act
    Map<DataTypeDirectionKey, List<Long>> actualLogicalFlowIdsByTypeAndDirectionResult =
        logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(selector);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(field, atLeast(1)).eq(Mockito.<Field<Object>>any());
    verify(field, atLeast(1)).isNotNull();
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(row, atLeast(1)).field(eq(0), isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    verify(selector, atLeast(1)).asTable(Mockito.<String>any());
    verify(tableImpl, atLeast(1)).fieldsRow();
    assertTrue(actualLogicalFlowIdsByTypeAndDirectionResult.isEmpty());
  }
}
