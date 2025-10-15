package org.finos.waltz.data.scenario;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.AxisOrientation;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.scenario.CloneScenarioCommand;
import org.finos.waltz.model.scenario.ImmutableCloneScenarioCommand;
import org.finos.waltz.model.scenario.ScenarioAxisItem;
import org.finos.waltz.schema.tables.records.ScenarioAxisItemRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertOnDuplicateStep;
import org.jooq.InsertValuesStep5;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSeekStep2;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
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
class ScenarioAxisItemDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ScenarioAxisItemDao scenarioAxisItemDao;

  /**
   * Test {@link ScenarioAxisItemDao#findForScenarioId(long)}.
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#findForScenarioId(long)}
   */
  @Test
  @DisplayName("Test findForScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ScenarioAxisItemDao.findForScenarioId(long)"})
  void testFindForScenarioId() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Collection<ScenarioAxisItem> actualFindForScenarioIdResult =
        scenarioAxisItemDao.findForScenarioId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForScenarioIdResult instanceof List);
    assertTrue(actualFindForScenarioIdResult.isEmpty());
    assertSame(objectList, actualFindForScenarioIdResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#cloneItems(CloneScenarioCommand, Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#cloneItems(CloneScenarioCommand, Long)}
   */
  @Test
  @DisplayName(
      "Test cloneItems(CloneScenarioCommand, Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScenarioAxisItemDao.cloneItems(CloneScenarioCommand, Long)"})
  void testCloneItems_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(dsl);

    // Act
    int actualCloneItemsResult =
        scenarioAxisItemDao.cloneItems(
            ImmutableCloneScenarioCommand.builder()
                .newName("New Name")
                .scenarioId(1L)
                .userId("42")
                .build(),
            1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"scenario_axis_item\" (\"scenario_id\", \"domain_item_id\", \"domain_item_kind\", \"orientation\", \"position\") select cast(? as bigint), \"scenario_axis_item\".\"domain_item_id\", \"scenario_axis_item\".\"domain_item_kind\", \"scenario_axis_item\".\"orientation\", \"scenario_axis_item\".\"position\" from \"scenario_axis_item\" where \"scenario_axis_item\".\"scenario_id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCloneItemsResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#cloneItems(CloneScenarioCommand, Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#cloneItems(CloneScenarioCommand, Long)}
   */
  @Test
  @DisplayName(
      "Test cloneItems(CloneScenarioCommand, Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScenarioAxisItemDao.cloneItems(CloneScenarioCommand, Long)"})
  void testCloneItems_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(dsl);

    // Act
    int actualCloneItemsResult =
        scenarioAxisItemDao.cloneItems(
            ImmutableCloneScenarioCommand.builder()
                .newName("New Name")
                .scenarioId(1L)
                .userId("42")
                .build(),
            1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"scenario_axis_item\" (\"scenario_id\", \"domain_item_id\", \"domain_item_kind\", \"orientation\", \"position\") select ?, \"scenario_axis_item\".\"domain_item_id\", \"scenario_axis_item\".\"domain_item_kind\", \"scenario_axis_item\".\"orientation\", \"scenario_axis_item\".\"position\" from \"scenario_axis_item\" where \"scenario_axis_item\".\"scenario_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCloneItemsResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#cloneItems(CloneScenarioCommand, Long)}.
   *
   * <ul>
   *   <li>Given {@link InsertOnDuplicateStep} {@link InsertOnDuplicateStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#cloneItems(CloneScenarioCommand, Long)}
   */
  @Test
  @DisplayName(
      "Test cloneItems(CloneScenarioCommand, Long); given InsertOnDuplicateStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScenarioAxisItemDao.cloneItems(CloneScenarioCommand, Long)"})
  void testCloneItems_givenInsertOnDuplicateStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    InsertOnDuplicateStep<Record> insertOnDuplicateStep = mock(InsertOnDuplicateStep.class);
    when(insertOnDuplicateStep.execute()).thenReturn(1);

    InsertValuesStep5<Record, Object, Object, Object, Object, Object> insertValuesStep5 =
        mock(InsertValuesStep5.class);
    when(insertValuesStep5.select(
            Mockito.<Select<Record5<Object, Object, Object, Object, Object>>>any()))
        .thenReturn(insertOnDuplicateStep);
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep5);

    // Act
    int actualCloneItemsResult =
        scenarioAxisItemDao.cloneItems(
            ImmutableCloneScenarioCommand.builder()
                .newName("New Name")
                .scenarioId(1L)
                .userId("42")
                .build(),
            1L);

    // Assert
    verify(dSLContext)
        .insertInto(
            isA(Table.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep5).select(isA(Select.class));
    verify(insertOnDuplicateStep).execute();
    assertEquals(1, actualCloneItemsResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#remove(long, AxisOrientation, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#remove(long, AxisOrientation,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(long, AxisOrientation, EntityReference); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioAxisItemDao.remove(long, AxisOrientation, EntityReference)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(dsl);

    // Act
    Boolean actualRemoveResult =
        scenarioAxisItemDao.remove(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"scenario_axis_item\" where (\"scenario_axis_item\".\"scenario_id\" = cast(? as bigint) and \"scenario_axis_item\".\"orientation\" = cast(? as varchar) and \"scenario_axis_item\".\"domain_item_kind\" = cast(? as varchar) and \"scenario_axis_item\".\"domain_item_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#remove(long, AxisOrientation, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#remove(long, AxisOrientation,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(long, AxisOrientation, EntityReference); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioAxisItemDao.remove(long, AxisOrientation, EntityReference)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(dsl);

    // Act
    Boolean actualRemoveResult =
        scenarioAxisItemDao.remove(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"scenario_axis_item\" where (\"scenario_axis_item\".\"scenario_id\" = ? and \"scenario_axis_item\".\"orientation\" = ? and \"scenario_axis_item\".\"domain_item_kind\" = ? and \"scenario_axis_item\".\"domain_item_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#remove(long, AxisOrientation, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#remove(long, AxisOrientation,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(long, AxisOrientation, EntityReference); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioAxisItemDao.remove(long, AxisOrientation, EntityReference)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<ScenarioAxisItemRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    when(dSLContext.deleteFrom(Mockito.<Table<ScenarioAxisItemRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    Boolean actualRemoveResult =
        scenarioAxisItemDao.remove(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#remove(long, AxisOrientation, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#remove(long, AxisOrientation,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(long, AxisOrientation, EntityReference); given DeleteConditionStep execute() return zero; then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioAxisItemDao.remove(long, AxisOrientation, EntityReference)"})
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenCallsDeleteFrom()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<ScenarioAxisItemRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    when(dSLContext.deleteFrom(Mockito.<Table<ScenarioAxisItemRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    Boolean actualRemoveResult =
        scenarioAxisItemDao.remove(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#findForScenarioAndOrientation(long, AxisOrientation)}.
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#findForScenarioAndOrientation(long,
   * AxisOrientation)}
   */
  @Test
  @DisplayName("Test findForScenarioAndOrientation(long, AxisOrientation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ScenarioAxisItemDao.findForScenarioAndOrientation(long, AxisOrientation)"
  })
  void testFindForScenarioAndOrientation() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Collection<ScenarioAxisItem> actualFindForScenarioAndOrientationResult =
        scenarioAxisItemDao.findForScenarioAndOrientation(1L, AxisOrientation.ROW);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForScenarioAndOrientationResult instanceof List);
    assertTrue(actualFindForScenarioAndOrientationResult.isEmpty());
    assertSame(objectList, actualFindForScenarioAndOrientationResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#reorder(long, AxisOrientation, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#reorder(long, AxisOrientation, List)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, AxisOrientation, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ScenarioAxisItemDao.reorder(long, AxisOrientation, List)"})
  void testReorder_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(dsl);

    ArrayList<Long> orderedIds = new ArrayList<>();
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);

    // Act
    int[] actualReorderResult = scenarioAxisItemDao.reorder(1L, AxisOrientation.ROW, orderedIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"scenario_axis_item\" set \"scenario_axis_item\".\"position\" = cast(? as int) where \"scenario_axis_item\".\"id\" = cast(? as bigint)");
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).setInt(eq(1), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualReorderResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#reorder(long, AxisOrientation, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#reorder(long, AxisOrientation, List)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, AxisOrientation, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ScenarioAxisItemDao.reorder(long, AxisOrientation, List)"})
  void testReorder_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(dsl);

    ArrayList<Long> orderedIds = new ArrayList<>();
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);
    orderedIds.add(1L);

    // Act
    int[] actualReorderResult = scenarioAxisItemDao.reorder(1L, AxisOrientation.ROW, orderedIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"scenario_axis_item\" set \"scenario_axis_item\".\"position\" = ? where \"scenario_axis_item\".\"id\" = ?");
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).setInt(eq(1), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualReorderResult);
  }

  /**
   * Test {@link ScenarioAxisItemDao#reorder(long, AxisOrientation, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemDao#reorder(long, AxisOrientation, List)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, AxisOrientation, List); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ScenarioAxisItemDao.reorder(long, AxisOrientation, List)"})
  void testReorder_givenDefaultDSLContextWithDialectIsSql99_thenReturnEmptyArrayOfInt() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao =
        new ScenarioAxisItemDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(
        new int[] {}, scenarioAxisItemDao.reorder(1L, AxisOrientation.ROW, new ArrayList<>()));
  }
}
