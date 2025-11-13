package org.finos.waltz.data.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.HashSet;
import java.util.Set;
import javax.sql.rowset.RowSetMetaDataImpl;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberCreateCommand;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberDeleteCommand;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberUpdateRoleCommand;
import org.finos.waltz.model.report_grid.ReportGridMember;
import org.finos.waltz.model.report_grid.ReportGridMemberCreateCommand;
import org.finos.waltz.model.report_grid.ReportGridMemberDeleteCommand;
import org.finos.waltz.model.report_grid.ReportGridMemberRole;
import org.finos.waltz.model.report_grid.ReportGridMemberUpdateRoleCommand;
import org.finos.waltz.schema.tables.records.ReportGridMemberRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
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
import org.jooq.tools.jdbc.DefaultResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportGridMemberDaoDiffblueTest {
  /**
   * Test {@link ReportGridMemberDao#findByGridId(Long)}.
   *
   * <p>Method under test: {@link ReportGridMemberDao#findByGridId(Long)}
   */
  @Test
  @DisplayName("Test findByGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridMemberDao.findByGridId(Long)"})
  void testFindByGridId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<ReportGridMember> actualFindByGridIdResult = new ReportGridMemberDao(dsl).findByGridId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByGridIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}
   */
  @Test
  @DisplayName(
      "Test register(long, String, ReportGridMemberRole); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberDao.register(long, String, ReportGridMemberRole)"})
  void testRegister_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    int actualRegisterResult =
        new ReportGridMemberDao(dsl).register(1L, "janedoe", ReportGridMemberRole.VIEWER);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"report_grid_member\" (\"grid_id\", \"user_id\", \"role\") values (cast(? as bigint), cast(? as varchar), cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRegisterResult);
  }

  /**
   * Test {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}
   */
  @Test
  @DisplayName(
      "Test register(long, String, ReportGridMemberRole); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberDao.register(long, String, ReportGridMemberRole)"})
  void testRegister_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    int actualRegisterResult =
        new ReportGridMemberDao(dsl).register(1L, "janedoe", ReportGridMemberRole.VIEWER);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"report_grid_member\" (\"grid_id\", \"user_id\", \"role\") values (cast(? as bigint), cast(? as varchar(7)), cast(? as varchar(6)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRegisterResult);
  }

  /**
   * Test {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}
   */
  @Test
  @DisplayName(
      "Test register(long, String, ReportGridMemberRole); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberDao.register(long, String, ReportGridMemberRole)"})
  void testRegister_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    int actualRegisterResult =
        new ReportGridMemberDao(dsl).register(1L, "janedoe", ReportGridMemberRole.VIEWER);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"report_grid_member\" (\"grid_id\", \"user_id\", \"role\") values (?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRegisterResult);
  }

  /**
   * Test {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}
   */
  @Test
  @DisplayName(
      "Test register(long, String, ReportGridMemberRole); given InsertSetMoreStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberDao.register(long, String, ReportGridMemberRole)"})
  void testRegister_givenInsertSetMoreStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetStep<ReportGridMemberRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualRegisterResult =
        new ReportGridMemberDao(dsl).register(1L, "janedoe", ReportGridMemberRole.VIEWER);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualRegisterResult);
  }

  /**
   * Test {@link ReportGridMemberDao#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#fetchExists(Select)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#canUpdate(long, String)}
   */
  @Test
  @DisplayName(
      "Test canUpdate(long, String); given DefaultDSLContext fetchExists(Select) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.canUpdate(long, String)"})
  void testCanUpdate_givenDefaultDSLContextFetchExistsReturnFalse_thenReturnFalse() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    // Act
    boolean actualCanUpdateResult = new ReportGridMemberDao(dsl).canUpdate(1L, "42");

    // Assert
    verify(dsl).fetchExists(isA(Select.class));
    assertFalse(actualCanUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberDao#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#fetchExists(Select)} return
   *       {@code true}.
   *   <li>Then calls {@link DefaultDSLContext#fetchExists(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#canUpdate(long, String)}
   */
  @Test
  @DisplayName(
      "Test canUpdate(long, String); given DefaultDSLContext fetchExists(Select) return 'true'; then calls fetchExists(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.canUpdate(long, String)"})
  void testCanUpdate_givenDefaultDSLContextFetchExistsReturnTrue_thenCallsFetchExists() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    // Act
    boolean actualCanUpdateResult = new ReportGridMemberDao(dsl).canUpdate(1L, "42");

    // Assert
    verify(dsl).fetchExists(isA(Select.class));
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberDao#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code false}.
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#canUpdate(long, String)}
   */
  @Test
  @DisplayName(
      "Test canUpdate(long, String); given PreparedStatement execute() return 'false'; then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.canUpdate(long, String)"})
  void testCanUpdate_givenPreparedStatementExecuteReturnFalse_thenCallsGetUpdateCount()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualCanUpdateResult = new ReportGridMemberDao(dsl).canUpdate(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"report_grid_member\".\"grid_id\" from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = ? and \"report_grid_member\".\"user_id\" = ? and \"report_grid_member\".\"role\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberDao#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then calls {@link PreparedStatement#getResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#canUpdate(long, String)}
   */
  @Test
  @DisplayName(
      "Test canUpdate(long, String); given PreparedStatement getResultSet() return 'null'; then calls getResultSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.canUpdate(long, String)"})
  void testCanUpdate_givenPreparedStatementGetResultSetReturnNull_thenCallsGetResultSet()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualCanUpdateResult = new ReportGridMemberDao(dsl).canUpdate(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"report_grid_member\".\"grid_id\" from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = ? and \"report_grid_member\".\"user_id\" = ? and \"report_grid_member\".\"role\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberDao#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#canUpdate(long, String)}
   */
  @Test
  @DisplayName("Test canUpdate(long, String); given 'true'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.canUpdate(long, String)"})
  void testCanUpdate_givenTrue_thenCallsClose() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualCanUpdateResult = new ReportGridMemberDao(dsl).canUpdate(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"report_grid_member\".\"grid_id\" from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = ? and \"report_grid_member\".\"user_id\" = ? and \"report_grid_member\".\"role\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertFalse(actualCanUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberDao#updateUserRole(long, ReportGridMemberUpdateRoleCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#updateUserRole(long,
   * ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  @DisplayName(
      "Test updateUserRole(long, ReportGridMemberUpdateRoleCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridMemberDao.updateUserRole(long, ReportGridMemberUpdateRoleCommand)"
  })
  void testUpdateUserRole_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
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
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    int actualUpdateUserRoleResult =
        reportGridMemberDao.updateUserRole(
            1L,
            ImmutableReportGridMemberUpdateRoleCommand.builder()
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"report_grid_member\" set \"report_grid_member\".\"role\" = cast(? as varchar) where (\"report_grid_member\".\"grid_id\" = cast(? as bigint) and \"report_grid_member\".\"user_id\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateUserRoleResult);
  }

  /**
   * Test {@link ReportGridMemberDao#updateUserRole(long, ReportGridMemberUpdateRoleCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#updateUserRole(long,
   * ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  @DisplayName(
      "Test updateUserRole(long, ReportGridMemberUpdateRoleCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridMemberDao.updateUserRole(long, ReportGridMemberUpdateRoleCommand)"
  })
  void testUpdateUserRole_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    int actualUpdateUserRoleResult =
        reportGridMemberDao.updateUserRole(
            1L,
            ImmutableReportGridMemberUpdateRoleCommand.builder()
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"report_grid_member\" set \"report_grid_member\".\"role\" = cast(? as varchar(6)) where (\"report_grid_member\".\"grid_id\" = cast(? as bigint) and \"report_grid_member\".\"user_id\" = cast(? as varchar(2)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateUserRoleResult);
  }

  /**
   * Test {@link ReportGridMemberDao#updateUserRole(long, ReportGridMemberUpdateRoleCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#updateUserRole(long,
   * ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  @DisplayName(
      "Test updateUserRole(long, ReportGridMemberUpdateRoleCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridMemberDao.updateUserRole(long, ReportGridMemberUpdateRoleCommand)"
  })
  void testUpdateUserRole_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
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
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    int actualUpdateUserRoleResult =
        reportGridMemberDao.updateUserRole(
            1L,
            ImmutableReportGridMemberUpdateRoleCommand.builder()
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"report_grid_member\" set \"report_grid_member\".\"role\" = ? where (\"report_grid_member\".\"grid_id\" = ? and \"report_grid_member\".\"user_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateUserRoleResult);
  }

  /**
   * Test {@link ReportGridMemberDao#updateUserRole(long, ReportGridMemberUpdateRoleCommand)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#updateUserRole(long,
   * ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  @DisplayName(
      "Test updateUserRole(long, ReportGridMemberUpdateRoleCommand); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridMemberDao.updateUserRole(long, ReportGridMemberUpdateRoleCommand)"
  })
  void testUpdateUserRole_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ReportGridMemberRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ReportGridMemberRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<ReportGridMemberRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    int actualUpdateUserRoleResult =
        reportGridMemberDao.updateUserRole(
            1L,
            ImmutableReportGridMemberUpdateRoleCommand.builder()
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build());

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateUserRoleResult);
  }

  /**
   * Test {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test delete(ReportGridMemberDeleteCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.delete(ReportGridMemberDeleteCommand)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    boolean actualDeleteResult =
        reportGridMemberDao.delete(
            ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = cast(? as bigint) and \"report_grid_member\".\"user_id\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test delete(ReportGridMemberDeleteCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.delete(ReportGridMemberDeleteCommand)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    boolean actualDeleteResult =
        reportGridMemberDao.delete(
            ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = cast(? as bigint) and \"report_grid_member\".\"user_id\" = cast(? as varchar(2)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test delete(ReportGridMemberDeleteCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.delete(ReportGridMemberDeleteCommand)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    boolean actualDeleteResult =
        reportGridMemberDao.delete(
            ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = ? and \"report_grid_member\".\"user_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test delete(ReportGridMemberDeleteCommand); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.delete(ReportGridMemberDeleteCommand)"})
  void testDelete_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ReportGridMemberRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<ReportGridMemberRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(deleteUsingStep);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    boolean actualDeleteResult =
        reportGridMemberDao.delete(
            ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build());

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then calls {@link DeleteUsingStep#where(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test delete(ReportGridMemberDeleteCommand); given DeleteConditionStep execute() return zero; then calls where(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberDao.delete(ReportGridMemberDeleteCommand)"})
  void testDelete_givenDeleteConditionStepExecuteReturnZero_thenCallsWhere()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ReportGridMemberRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteUsingStep<ReportGridMemberRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(deleteUsingStep);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    boolean actualDeleteResult =
        reportGridMemberDao.delete(
            ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build());

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link ReportGridMemberDao#findPeopleByGridId(Long)}.
   *
   * <p>Method under test: {@link ReportGridMemberDao#findPeopleByGridId(Long)}
   */
  @Test
  @DisplayName("Test findPeopleByGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridMemberDao.findPeopleByGridId(Long)"})
  void testFindPeopleByGridId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<Person> actualFindPeopleByGridIdResult =
        new ReportGridMemberDao(dsl).findPeopleByGridId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindPeopleByGridIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(ReportGridMemberCreateCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberDao.update(ReportGridMemberCreateCommand, String)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
      throws SQLException {
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
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    int actualUpdateResult =
        reportGridMemberDao.update(
            ImmutableReportGridMemberCreateCommand.builder()
                .gridId(1L)
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build(),
            "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(ReportGridMemberCreateCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberDao.update(ReportGridMemberCreateCommand, String)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    int actualUpdateResult =
        reportGridMemberDao.update(
            ImmutableReportGridMemberCreateCommand.builder()
                .gridId(1L)
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build(),
            "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(ReportGridMemberCreateCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberDao.update(ReportGridMemberCreateCommand, String)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
      throws SQLException {
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
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    int actualUpdateResult =
        reportGridMemberDao.update(
            ImmutableReportGridMemberCreateCommand.builder()
                .gridId(1L)
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build(),
            "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then calls {@link InsertSetMoreStep#set(Field, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(ReportGridMemberCreateCommand, String); given UpdateConditionStep execute() return zero; then calls set(Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberDao.update(ReportGridMemberCreateCommand, String)"})
  void testUpdate_givenUpdateConditionStepExecuteReturnZero_thenCallsSet()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ReportGridMemberRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<ReportGridMemberRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<ReportGridMemberRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetStep<ReportGridMemberRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<Record>>any())).thenReturn(mock(InsertSetStep.class));
    when(dsl.insertInto(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(insertSetStep);
    when(dsl.update(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);

    // Act
    int actualUpdateResult =
        reportGridMemberDao.update(
            ImmutableReportGridMemberCreateCommand.builder()
                .gridId(1L)
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build(),
            "janedoe");

    // Assert
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl, atLeast(1)).insertInto(isA(Table.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateResult);
  }
}
