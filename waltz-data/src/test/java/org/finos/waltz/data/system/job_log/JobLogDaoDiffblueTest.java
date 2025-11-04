package org.finos.waltz.data.system.job_log;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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
import java.util.List;
import org.finos.waltz.model.system.job_log.JobLog;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobLogDaoDiffblueTest {
  /**
   * Method under test: {@link JobLogDao#findLatestSuccessful()}
   */
  @Test
  void testFindLatestSuccessful() throws SQLException {
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
    List<JobLog> actualFindLatestSuccessfulResult = (new JobLogDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findLatestSuccessful();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"system_job_log\".\"name\", \"system_job_log\".\"entity_kind\", max(\"system_job_log\".\"start\") \"start\" from \"system_job_log\" where \"system_job_log\".\"status\" = ? group by \"system_job_log\".\"name\", \"system_job_log\".\"entity_kind\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("SUCCESS"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindLatestSuccessfulResult.isEmpty());
  }
}
