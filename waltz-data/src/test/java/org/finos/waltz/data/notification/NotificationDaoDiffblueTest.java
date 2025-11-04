package org.finos.waltz.data.notification;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.List;
import org.finos.waltz.model.notification.NotificationSummary;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotificationDaoDiffblueTest {
  /**
   * Method under test: {@link NotificationDao#findNotificationsByUserId(String)}
   */
  @Test
  void testFindNotificationsByUserId() throws SQLException {
    // Arrange
    ResultSetMetaData resultSetMetaData = mock(ResultSetMetaData.class);
    when(resultSetMetaData.getPrecision(anyInt())).thenReturn(1);
    when(resultSetMetaData.getScale(anyInt())).thenReturn(1);
    when(resultSetMetaData.getColumnTypeName(anyInt())).thenReturn("Column Type Name");
    when(resultSetMetaData.getColumnLabel(anyInt())).thenReturn("Column Label");
    when(resultSetMetaData.getColumnName(anyInt())).thenReturn("Column Name");
    when(resultSetMetaData.getColumnCount()).thenReturn(3);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(resultSetMetaData);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<NotificationSummary> actualFindNotificationsByUserIdResult = (new NotificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findNotificationsByUserId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 'ATTESTATION' \"kind\", count(*) \"count\" from \"attestation_instance\" join \"attestation_instance_recipient\" on \"attestation_instance_recipient\".\"attestation_instance_id\" = \"attestation_instance\".\"id\" where (\"attestation_instance_recipient\".\"user_id\" = '42' and \"attestation_instance\".\"attested_at\" is null) union all select 'SURVEY_INSTANCE' \"kind\", count(*) \"count\" from \"survey_instance\" join \"survey_instance_recipient\" on \"survey_instance_recipient\".\"survey_instance_id\" = \"survey_instance\".\"id\" join \"person\" on \"person\".\"id\" = \"survey_instance_recipient\".\"person_id\" join \"survey_run\" on \"survey_instance\".\"survey_run_id\" = \"survey_run\".\"id\" join \"survey_template\" on \"survey_run\".\"survey_template_id\" = \"survey_template\".\"id\" where (\"person\".\"email\" = '42' and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" in ('NOT_STARTED', 'IN_PROGRESS') and \"survey_template\".\"status\" = 'ACTIVE')"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(resultSetMetaData).getColumnCount();
    verify(resultSetMetaData, atLeast(1)).getColumnLabel(anyInt());
    verify(resultSetMetaData, atLeast(1)).getColumnName(anyInt());
    verify(resultSetMetaData, atLeast(1)).getColumnTypeName(anyInt());
    verify(resultSetMetaData, atLeast(1)).getPrecision(anyInt());
    verify(resultSetMetaData, atLeast(1)).getScale(anyInt());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindNotificationsByUserIdResult.isEmpty());
  }
}
