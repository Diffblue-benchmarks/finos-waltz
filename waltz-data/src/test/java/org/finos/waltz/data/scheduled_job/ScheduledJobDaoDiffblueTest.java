package org.finos.waltz.data.scheduled_job;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.util.HashSet;
import java.util.Set;
import javax.sql.rowset.RowSetMetaDataImpl;
import org.finos.waltz.model.scheduled_job.JobKey;
import org.finos.waltz.model.scheduled_job.JobLifecycleStatus;
import org.finos.waltz.schema.tables.records.SettingsRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.tools.jdbc.DefaultResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScheduledJobDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ScheduledJobDao scheduledJobDao;

  /**
   * Test {@link ScheduledJobDao#isJobRunnable(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code false}.
   *   <li>Then calls {@link DSLContext#fetchExists(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  @DisplayName(
      "Test isJobRunnable(JobKey); given DSLContext fetchExists(Select) return 'false'; then calls fetchExists(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.isJobRunnable(JobKey)"})
  void testIsJobRunnable_givenDSLContextFetchExistsReturnFalse_thenCallsFetchExists()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    // Act
    boolean actualIsJobRunnableResult =
        scheduledJobDao.isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertFalse(actualIsJobRunnableResult);
  }

  /**
   * Test {@link ScheduledJobDao#isJobRunnable(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   *   <li>Then calls {@link DSLContext#fetchExists(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  @DisplayName(
      "Test isJobRunnable(JobKey); given DSLContext fetchExists(Select) return 'true'; then calls fetchExists(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.isJobRunnable(JobKey)"})
  void testIsJobRunnable_givenDSLContextFetchExistsReturnTrue_thenCallsFetchExists()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    // Act
    boolean actualIsJobRunnableResult =
        scheduledJobDao.isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualIsJobRunnableResult);
  }

  /**
   * Test {@link ScheduledJobDao#isJobRunnable(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  @DisplayName(
      "Test isJobRunnable(JobKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.isJobRunnable(JobKey)"})
  void testIsJobRunnable_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualIsJobRunnableResult =
        new ScheduledJobDao(dsl).isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = cast(? as varchar) and \"settings\".\"value\" = cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertFalse(actualIsJobRunnableResult);
  }

  /**
   * Test {@link ScheduledJobDao#isJobRunnable(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  @DisplayName(
      "Test isJobRunnable(JobKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.isJobRunnable(JobKey)"})
  void testIsJobRunnable_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    boolean actualIsJobRunnableResult =
        new ScheduledJobDao(dsl).isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from RDB$DATABASE where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = cast(? as varchar(35)) and \"settings\".\"value\" = cast(? as varchar(8))))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertFalse(actualIsJobRunnableResult);
  }

  /**
   * Test {@link ScheduledJobDao#isJobRunnable(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  @DisplayName(
      "Test isJobRunnable(JobKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.isJobRunnable(JobKey)"})
  void testIsJobRunnable_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    boolean actualIsJobRunnableResult =
        new ScheduledJobDao(dsl).isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 as \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertFalse(actualIsJobRunnableResult);
  }

  /**
   * Test {@link ScheduledJobDao#isJobRunnable(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  @DisplayName(
      "Test isJobRunnable(JobKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.isJobRunnable(JobKey)"})
  void testIsJobRunnable_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualIsJobRunnableResult =
        new ScheduledJobDao(dsl).isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertFalse(actualIsJobRunnableResult);
  }

  /**
   * Test {@link ScheduledJobDao#isJobRunnable(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultResultSet} {@link DefaultResultSet#wasNull()} return {@code true}.
   *   <li>Then calls {@link DefaultResultSet#getInt(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  @DisplayName(
      "Test isJobRunnable(JobKey); given DefaultResultSet wasNull() return 'true'; then calls getInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.isJobRunnable(JobKey)"})
  void testIsJobRunnable_givenDefaultResultSetWasNullReturnTrue_thenCallsGetInt()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.wasNull()).thenReturn(true);
    when(defaultResultSet.getInt(anyInt())).thenReturn(0);
    when(defaultResultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualIsJobRunnableResult =
        new ScheduledJobDao(dsl).isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getInt(1);
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet, atLeast(1)).next();
    verify(defaultResultSet).wasNull();
    assertTrue(actualIsJobRunnableResult);
  }

  /**
   * Test {@link ScheduledJobDao#isJobRunnable(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  @DisplayName(
      "Test isJobRunnable(JobKey); given PreparedStatement getResultSet() return 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.isJobRunnable(JobKey)"})
  void testIsJobRunnable_givenPreparedStatementGetResultSetReturnNull_thenReturnTrue()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualIsJobRunnableResult =
        new ScheduledJobDao(dsl).isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsJobRunnableResult);
  }

  /**
   * Test {@link ScheduledJobDao#markJobAsRunning(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#markJobAsRunning(JobKey)}
   */
  @Test
  @DisplayName(
      "Test markJobAsRunning(JobKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.markJobAsRunning(JobKey)"})
  void testMarkJobAsRunning_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualMarkJobAsRunningResult =
        new ScheduledJobDao(dsl).markJobAsRunning(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"settings\" set \"settings\".\"value\" = cast(? as varchar) where (\"settings\".\"name\" = cast(? as varchar) and \"settings\".\"value\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualMarkJobAsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#markJobAsRunning(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#markJobAsRunning(JobKey)}
   */
  @Test
  @DisplayName(
      "Test markJobAsRunning(JobKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.markJobAsRunning(JobKey)"})
  void testMarkJobAsRunning_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    boolean actualMarkJobAsRunningResult =
        new ScheduledJobDao(dsl).markJobAsRunning(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"settings\" set \"settings\".\"value\" = cast(? as varchar(7)) where (\"settings\".\"name\" = cast(? as varchar(35)) and \"settings\".\"value\" = cast(? as varchar(8)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualMarkJobAsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#markJobAsRunning(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#markJobAsRunning(JobKey)}
   */
  @Test
  @DisplayName(
      "Test markJobAsRunning(JobKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.markJobAsRunning(JobKey)"})
  void testMarkJobAsRunning_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualMarkJobAsRunningResult =
        new ScheduledJobDao(dsl).markJobAsRunning(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"settings\" set \"settings\".\"value\" = ? where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualMarkJobAsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#markJobAsRunning(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#markJobAsRunning(JobKey)}
   */
  @Test
  @DisplayName(
      "Test markJobAsRunning(JobKey); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.markJobAsRunning(JobKey)"})
  void testMarkJobAsRunning_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SettingsRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<SettingsRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SettingsRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<SettingsRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SettingsRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualMarkJobAsRunningResult =
        scheduledJobDao.markJobAsRunning(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualMarkJobAsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#markJobAsRunning(JobKey)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#markJobAsRunning(JobKey)}
   */
  @Test
  @DisplayName(
      "Test markJobAsRunning(JobKey); given UpdateConditionStep execute() return zero; then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.markJobAsRunning(JobKey)"})
  void testMarkJobAsRunning_givenUpdateConditionStepExecuteReturnZero_thenCallsUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SettingsRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateConditionStep<SettingsRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SettingsRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<SettingsRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SettingsRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualMarkJobAsRunningResult =
        scheduledJobDao.markJobAsRunning(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualMarkJobAsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#updateJobStatus(JobKey, JobLifecycleStatus)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#updateJobStatus(JobKey, JobLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test updateJobStatus(JobKey, JobLifecycleStatus); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledJobDao.updateJobStatus(JobKey, JobLifecycleStatus)"})
  void testUpdateJobStatus_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    new ScheduledJobDao(dsl)
        .updateJobStatus(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE, JobLifecycleStatus.RUNNABLE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"settings\" set \"settings\".\"value\" = cast(? as varchar) where \"settings\".\"name\" = cast(? as varchar)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link ScheduledJobDao#updateJobStatus(JobKey, JobLifecycleStatus)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#updateJobStatus(JobKey, JobLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test updateJobStatus(JobKey, JobLifecycleStatus); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledJobDao.updateJobStatus(JobKey, JobLifecycleStatus)"})
  void testUpdateJobStatus_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    new ScheduledJobDao(dsl)
        .updateJobStatus(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE, JobLifecycleStatus.RUNNABLE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"settings\" set \"settings\".\"value\" = ? where \"settings\".\"name\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link ScheduledJobDao#updateJobStatus(JobKey, JobLifecycleStatus)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#updateJobStatus(JobKey, JobLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test updateJobStatus(JobKey, JobLifecycleStatus); given UpdateConditionStep execute() return one; then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledJobDao.updateJobStatus(JobKey, JobLifecycleStatus)"})
  void testUpdateJobStatus_givenUpdateConditionStepExecuteReturnOne_thenCallsUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SettingsRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SettingsRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SettingsRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SettingsRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    scheduledJobDao.updateJobStatus(
        JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE, JobLifecycleStatus.RUNNABLE);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ScheduledJobDao#anyJobsRunning(Set)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  @DisplayName(
      "Test anyJobsRunning(Set); given DSLContext fetchExists(Select) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.anyJobsRunning(Set)"})
  void testAnyJobsRunning_givenDSLContextFetchExistsReturnFalse_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(new HashSet<>());

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertFalse(actualAnyJobsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#anyJobsRunning(Set)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  @DisplayName(
      "Test anyJobsRunning(Set); given DSLContext fetchExists(Select) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.anyJobsRunning(Set)"})
  void testAnyJobsRunning_givenDSLContextFetchExistsReturnTrue_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(new HashSet<>());

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualAnyJobsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#anyJobsRunning(Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  @DisplayName(
      "Test anyJobsRunning(Set); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.anyJobsRunning(Set)"})
  void testAnyJobsRunning_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ScheduledJobDao scheduledJobDao = new ScheduledJobDao(dsl);

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"settings\".\"name\" from \"settings\" where (1 = 0 and \"settings\".\"value\" = cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "RUNNING");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertFalse(actualAnyJobsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#anyJobsRunning(Set)}.
   *
   * <ul>
   *   <li>Given {@code HIERARCHY_REBUILD_CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  @DisplayName("Test anyJobsRunning(Set); given 'HIERARCHY_REBUILD_CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.anyJobsRunning(Set)"})
  void testAnyJobsRunning_givenHierarchyRebuildChangeInitiative() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    HashSet<JobKey> jobKeys = new HashSet<>();
    jobKeys.add(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(jobKeys);

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualAnyJobsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#anyJobsRunning(Set)}.
   *
   * <ul>
   *   <li>Given {@code HIERARCHY_REBUILD_DATA_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  @DisplayName("Test anyJobsRunning(Set); given 'HIERARCHY_REBUILD_DATA_TYPE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.anyJobsRunning(Set)"})
  void testAnyJobsRunning_givenHierarchyRebuildDataType() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    HashSet<JobKey> jobKeys = new HashSet<>();
    jobKeys.add(JobKey.HIERARCHY_REBUILD_DATA_TYPE);
    jobKeys.add(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(jobKeys);

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualAnyJobsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#anyJobsRunning(Set)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  @DisplayName("Test anyJobsRunning(Set); given PreparedStatement getResultSet() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.anyJobsRunning(Set)"})
  void testAnyJobsRunning_givenPreparedStatementGetResultSetReturnNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ScheduledJobDao scheduledJobDao = new ScheduledJobDao(dsl);

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" in () and \"settings\".\"value\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "RUNNING");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualAnyJobsRunningResult);
  }

  /**
   * Test {@link ScheduledJobDao#anyJobsRunning(Set)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  @DisplayName("Test anyJobsRunning(Set); given 'true'; when HashSet(); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledJobDao.anyJobsRunning(Set)"})
  void testAnyJobsRunning_givenTrue_whenHashSet_thenCallsClose() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ScheduledJobDao scheduledJobDao = new ScheduledJobDao(dsl);

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" in () and \"settings\".\"value\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "RUNNING");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertFalse(actualAnyJobsRunningResult);
  }
}
