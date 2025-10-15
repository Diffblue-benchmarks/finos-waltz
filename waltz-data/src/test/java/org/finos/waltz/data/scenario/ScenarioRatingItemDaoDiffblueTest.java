package org.finos.waltz.data.scenario;

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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.scenario.ChangeScenarioCommand;
import org.finos.waltz.model.scenario.CloneScenarioCommand;
import org.finos.waltz.model.scenario.ImmutableChangeScenarioCommand;
import org.finos.waltz.model.scenario.ImmutableCloneScenarioCommand;
import org.finos.waltz.model.scenario.ScenarioRatingItem;
import org.finos.waltz.schema.tables.records.ScenarioRatingItemRecord;
import org.finos.waltz.schema.tables.records.ScenarioRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertOnDuplicateStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.InsertValuesStep11;
import org.jooq.Record;
import org.jooq.Record11;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
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
class ScenarioRatingItemDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ScenarioRatingItemDao scenarioRatingItemDao;

  /**
   * Test {@link ScenarioRatingItemDao#findForScenarioId(long)}.
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#findForScenarioId(long)}
   */
  @Test
  @DisplayName("Test findForScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ScenarioRatingItemDao.findForScenarioId(long)"})
  void testFindForScenarioId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<ScenarioRatingItem> actualFindForScenarioIdResult =
        scenarioRatingItemDao.findForScenarioId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForScenarioIdResult instanceof List);
    assertTrue(actualFindForScenarioIdResult.isEmpty());
    assertSame(objectList, actualFindForScenarioIdResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#cloneItems(CloneScenarioCommand, Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#cloneItems(CloneScenarioCommand, Long)}
   */
  @Test
  @DisplayName(
      "Test cloneItems(CloneScenarioCommand, Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScenarioRatingItemDao.cloneItems(CloneScenarioCommand, Long)"})
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
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    int actualCloneItemsResult =
        scenarioRatingItemDao.cloneItems(
            ImmutableCloneScenarioCommand.builder()
                .newName("New Name")
                .scenarioId(1L)
                .userId("42")
                .build(),
            1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"scenario_rating_item\" (\"scenario_id\", \"domain_item_id\", \"domain_item_kind\", \"rating\", \"row_id\", \"row_kind\", \"column_id\", \"column_kind\", \"description\", \"last_updated_at\", \"last_updated_by\") select cast(? as bigint), \"scenario_rating_item\".\"domain_item_id\", \"scenario_rating_item\".\"domain_item_kind\", \"scenario_rating_item\".\"rating\", \"scenario_rating_item\".\"row_id\", \"scenario_rating_item\".\"row_kind\", \"scenario_rating_item\".\"column_id\", \"scenario_rating_item\".\"column_kind\", \"scenario_rating_item\".\"description\", \"scenario_rating_item\".\"last_updated_at\", \"scenario_rating_item\".\"last_updated_by\" from \"scenario_rating_item\" where \"scenario_rating_item\".\"scenario_id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCloneItemsResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#cloneItems(CloneScenarioCommand, Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#cloneItems(CloneScenarioCommand, Long)}
   */
  @Test
  @DisplayName(
      "Test cloneItems(CloneScenarioCommand, Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScenarioRatingItemDao.cloneItems(CloneScenarioCommand, Long)"})
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
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    int actualCloneItemsResult =
        scenarioRatingItemDao.cloneItems(
            ImmutableCloneScenarioCommand.builder()
                .newName("New Name")
                .scenarioId(1L)
                .userId("42")
                .build(),
            1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"scenario_rating_item\" (\"scenario_id\", \"domain_item_id\", \"domain_item_kind\", \"rating\", \"row_id\", \"row_kind\", \"column_id\", \"column_kind\", \"description\", \"last_updated_at\", \"last_updated_by\") select ?, \"scenario_rating_item\".\"domain_item_id\", \"scenario_rating_item\".\"domain_item_kind\", \"scenario_rating_item\".\"rating\", \"scenario_rating_item\".\"row_id\", \"scenario_rating_item\".\"row_kind\", \"scenario_rating_item\".\"column_id\", \"scenario_rating_item\".\"column_kind\", \"scenario_rating_item\".\"description\", \"scenario_rating_item\".\"last_updated_at\", \"scenario_rating_item\".\"last_updated_by\" from \"scenario_rating_item\" where \"scenario_rating_item\".\"scenario_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCloneItemsResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#cloneItems(CloneScenarioCommand, Long)}.
   *
   * <ul>
   *   <li>Given {@link InsertOnDuplicateStep} {@link InsertOnDuplicateStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#cloneItems(CloneScenarioCommand, Long)}
   */
  @Test
  @DisplayName(
      "Test cloneItems(CloneScenarioCommand, Long); given InsertOnDuplicateStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScenarioRatingItemDao.cloneItems(CloneScenarioCommand, Long)"})
  void testCloneItems_givenInsertOnDuplicateStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    InsertOnDuplicateStep<Record> insertOnDuplicateStep = mock(InsertOnDuplicateStep.class);
    when(insertOnDuplicateStep.execute()).thenReturn(1);

    InsertValuesStep11<
            Record,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        insertValuesStep11 = mock(InsertValuesStep11.class);
    when(insertValuesStep11.select(
            Mockito
                .<Select<
                        Record11<
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object>>>
                    any()))
        .thenReturn(insertOnDuplicateStep);
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep11);

    // Act
    int actualCloneItemsResult =
        scenarioRatingItemDao.cloneItems(
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
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep11).select(isA(Select.class));
    verify(insertOnDuplicateStep).execute();
    assertEquals(1, actualCloneItemsResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#remove(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#remove(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test remove(ChangeScenarioCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.remove(ChangeScenarioCommand, String)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    boolean actualRemoveResult =
        scenarioRatingItemDao.remove(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"scenario_rating_item\" where (\"scenario_rating_item\".\"domain_item_id\" = cast(? as bigint) and \"scenario_rating_item\".\"scenario_id\" = cast(? as bigint) and \"scenario_rating_item\".\"row_id\" = cast(? as bigint) and \"scenario_rating_item\".\"column_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#remove(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#remove(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test remove(ChangeScenarioCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.remove(ChangeScenarioCommand, String)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    boolean actualRemoveResult =
        scenarioRatingItemDao.remove(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"scenario_rating_item\" where (\"scenario_rating_item\".\"domain_item_id\" = ? and \"scenario_rating_item\".\"scenario_id\" = ? and \"scenario_rating_item\".\"row_id\" = ? and \"scenario_rating_item\".\"column_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#remove(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#remove(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test remove(ChangeScenarioCommand, String); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.remove(ChangeScenarioCommand, String)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ScenarioRatingItemRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<ScenarioRatingItemRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);
    when(dSLContext.deleteFrom(Mockito.<Table<ScenarioRatingItemRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult =
        scenarioRatingItemDao.remove(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).update(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test add(ChangeScenarioCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.add(ChangeScenarioCommand, String)"})
  void testAdd_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    boolean actualAddResult =
        scenarioRatingItemDao.add(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"scenario_rating_item\" (\"scenario_id\", \"domain_item_id\", \"domain_item_kind\", \"column_id\", \"column_kind\", \"row_id\", \"row_kind\", \"rating\", \"description\", \"last_updated_at\", \"last_updated_by\") values (cast(? as bigint), cast(? as bigint), cast(? as varchar), cast(? as bigint), cast(? as varchar), cast(? as bigint), cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as datetime), cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(10), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test add(ChangeScenarioCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.add(ChangeScenarioCommand, String)"})
  void testAdd_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    boolean actualAddResult =
        scenarioRatingItemDao.add(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"scenario_rating_item\" (\"scenario_id\", \"domain_item_id\", \"domain_item_kind\", \"column_id\", \"column_kind\", \"row_id\", \"row_kind\", \"rating\", \"description\", \"last_updated_at\", \"last_updated_by\") values (cast(? as bigint), cast(? as bigint), cast(? as varchar(11)), cast(? as bigint), cast(? as varchar(10)), cast(? as bigint), cast(? as varchar(10)), cast(? as varchar(6)), cast(? as varchar(4000)), cast(? as timestamp), cast(? as varchar(2)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(10), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test add(ChangeScenarioCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.add(ChangeScenarioCommand, String)"})
  void testAdd_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    boolean actualAddResult =
        scenarioRatingItemDao.add(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"scenario_rating_item\" (\"scenario_id\", \"domain_item_id\", \"domain_item_kind\", \"column_id\", \"column_kind\", \"row_id\", \"row_kind\", \"rating\", \"description\", \"last_updated_at\", \"last_updated_by\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(10), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test add(ChangeScenarioCommand, String); given InsertSetMoreStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.add(ChangeScenarioCommand, String)"})
  void testAdd_givenInsertSetMoreStepExecuteReturnOne_thenReturnTrue() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);

    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep11 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep11.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep10);

    InsertSetStep<ScenarioRatingItemRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep11);

    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);
    when(dSLContext.insertInto(Mockito.<Table<ScenarioRatingItemRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    boolean actualAddResult =
        scenarioRatingItemDao.add(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(dSLContext).update(isA(Table.class));
    verify(insertSetMoreStep11).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(ChangeScenarioCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.updateRating(ChangeScenarioCommand, String)"})
  void testUpdateRating_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemDao.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"scenario_rating_item\" set \"scenario_rating_item\".\"rating\" = cast(? as varchar), \"scenario_rating_item\".\"description\" = cast(? as varchar), \"scenario_rating_item\".\"last_updated_by\" = cast(? as varchar), \"scenario_rating_item\".\"last_updated_at\" = cast(? as datetime) where (\"scenario_rating_item\".\"domain_item_id\" = cast(? as bigint) and \"scenario_rating_item\".\"scenario_id\" = cast(? as bigint) and \"scenario_rating_item\".\"row_id\" = cast(? as bigint) and \"scenario_rating_item\".\"column_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateRatingResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(ChangeScenarioCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.updateRating(ChangeScenarioCommand, String)"})
  void testUpdateRating_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemDao.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"scenario_rating_item\" set \"scenario_rating_item\".\"rating\" = cast(? as varchar(6)), \"scenario_rating_item\".\"description\" = cast(? as varchar(7)), \"scenario_rating_item\".\"last_updated_by\" = cast(? as varchar(2)), \"scenario_rating_item\".\"last_updated_at\" = cast(? as timestamp) where (\"scenario_rating_item\".\"domain_item_id\" = cast(? as bigint) and \"scenario_rating_item\".\"scenario_id\" = cast(? as bigint) and \"scenario_rating_item\".\"row_id\" = cast(? as bigint) and \"scenario_rating_item\".\"column_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateRatingResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(ChangeScenarioCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.updateRating(ChangeScenarioCommand, String)"})
  void testUpdateRating_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemDao.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"scenario_rating_item\" set \"scenario_rating_item\".\"rating\" = ?, \"scenario_rating_item\".\"description\" = ?, \"scenario_rating_item\".\"last_updated_by\" = ?, \"scenario_rating_item\".\"last_updated_at\" = ? where (\"scenario_rating_item\".\"domain_item_id\" = ? and \"scenario_rating_item\".\"scenario_id\" = ? and \"scenario_rating_item\".\"row_id\" = ? and \"scenario_rating_item\".\"column_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateRatingResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(ChangeScenarioCommand, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.updateRating(ChangeScenarioCommand, String)"})
  void testUpdateRating_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRatingItemRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateConditionStep<ScenarioRatingItemRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<ScenarioRatingItemRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<ScenarioRatingItemRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemDao.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(dSLContext, atLeast(1)).update(Mockito.<Table<Record>>any());
    verify(updateConditionStep2).execute();
    verify(updateConditionStep).execute();
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetFirstStep, atLeast(1)).set(Mockito.<Field<Object>>any(), Mockito.<Object>any());
    verify(updateSetMoreStep4, atLeast(1)).set(Mockito.<Field<Object>>any(), Mockito.<Object>any());
    verify(updateSetMoreStep3).where(isA(Condition.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateRatingResult);
  }

  /**
   * Test {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(ChangeScenarioCommand, String); given UpdateConditionStep execute() return zero; then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemDao.updateRating(ChangeScenarioCommand, String)"})
  void testUpdateRating_givenUpdateConditionStepExecuteReturnZero_thenCallsUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRatingItemRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<ScenarioRatingItemRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<ScenarioRatingItemRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemDao.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateRatingResult);
  }
}
