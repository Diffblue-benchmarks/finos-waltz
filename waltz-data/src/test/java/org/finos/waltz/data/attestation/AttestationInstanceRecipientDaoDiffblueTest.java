package org.finos.waltz.data.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AttestationInstanceRecipientDaoDiffblueTest {
  /**
   * Method under test:
   * {@link AttestationInstanceRecipientDao#create(long, String)}
   */
  @Test
  void testCreate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);

    // Act
    long actualCreateResult = (new AttestationInstanceRecipientDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .create(1L, "42");

    // Assert
    verify(connection).prepareStatement(
        eq("insert into \"attestation_instance_recipient\" (\"attestation_instance_id\", \"user_id\") values (?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("42"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceRecipientDao#findRecipientsByRunId(Long)}
   */
  @Test
  void testFindRecipientsByRunId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<String> actualFindRecipientsByRunIdResult = (new AttestationInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRecipientsByRunId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_instance_recipient\".\"user_id\" from \"attestation_instance_recipient\" join \"attestation_instance\" on \"attestation_instance\".\"id\" = \"attestation_instance_recipient\".\"attestation_instance_id\" where \"attestation_instance\".\"attestation_run_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindRecipientsByRunIdResult.size());
    assertEquals("String", actualFindRecipientsByRunIdResult.get(0));
    assertEquals("String", actualFindRecipientsByRunIdResult.get(1));
  }
}
