package org.finos.waltz.data.scheduled_job;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.scheduled_job.JobKey;
import org.finos.waltz.model.scheduled_job.JobLifecycleStatus;
import org.finos.waltz.schema.tables.records.SettingsRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScheduledJobDaoDiffblueTest {
  /**
   * Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  void testIsJobRunnable() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualIsJobRunnableResult = (new ScheduledJobDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertFalse(actualIsJobRunnableResult);
  }

  /**
   * Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  void testIsJobRunnable2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualIsJobRunnableResult = (new ScheduledJobDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsJobRunnableResult);
  }

  /**
   * Method under test: {@link ScheduledJobDao#isJobRunnable(JobKey)}
   */
  @Test
  void testIsJobRunnable3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualIsJobRunnableResult = (new ScheduledJobDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .isJobRunnable(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsJobRunnableResult);
  }

  /**
   * Method under test: {@link ScheduledJobDao#markJobAsRunning(JobKey)}
   */
  @Test
  void testMarkJobAsRunning() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualMarkJobAsRunningResult = (new ScheduledJobDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .markJobAsRunning(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"settings\" set \"settings\".\"value\" = ? where (\"settings\".\"name\" = ? and \"settings\".\"value\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualMarkJobAsRunningResult);
  }

  /**
   * Method under test: {@link ScheduledJobDao#markJobAsRunning(JobKey)}
   */
  @Test
  void testMarkJobAsRunning2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SettingsRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<SettingsRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SettingsRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetFirstStep<SettingsRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SettingsRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualMarkJobAsRunningResult = (new ScheduledJobDao(dsl))
        .markJobAsRunning(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualMarkJobAsRunningResult);
  }

  /**
   * Method under test:
   * {@link ScheduledJobDao#updateJobStatus(JobKey, JobLifecycleStatus)}
   */
  @Test
  void testUpdateJobStatus() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    (new ScheduledJobDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateJobStatus(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE, JobLifecycleStatus.RUNNABLE);

    // Assert
    verify(connection)
        .prepareStatement(eq("update \"settings\" set \"settings\".\"value\" = ? where \"settings\".\"name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link ScheduledJobDao#updateJobStatus(JobKey, JobLifecycleStatus)}
   */
  @Test
  void testUpdateJobStatus2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SettingsRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SettingsRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SettingsRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SettingsRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    (new ScheduledJobDao(dsl)).updateJobStatus(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE, JobLifecycleStatus.RUNNABLE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  void testAnyJobsRunning() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    ScheduledJobDao scheduledJobDao = new ScheduledJobDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" in () and \"settings\".\"value\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("RUNNING"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertFalse(actualAnyJobsRunningResult);
  }

  /**
   * Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  void testAnyJobsRunning2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    ScheduledJobDao scheduledJobDao = new ScheduledJobDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" in () and \"settings\".\"value\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("RUNNING"));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualAnyJobsRunningResult);
  }

  /**
   * Method under test: {@link ScheduledJobDao#anyJobsRunning(Set)}
   */
  @Test
  void testAnyJobsRunning3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    ScheduledJobDao scheduledJobDao = new ScheduledJobDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualAnyJobsRunningResult = scheduledJobDao.anyJobsRunning(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"settings\".\"name\" from \"settings\" where (\"settings\".\"name\" in () and \"settings\".\"value\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("RUNNING"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualAnyJobsRunningResult);
  }
}
