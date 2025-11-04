package org.finos.waltz.data.change_unit;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeUnitDaoDiffblueTest {
  /**
   * Method under test: {@link ChangeUnitDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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
    ChangeUnit actualById = (new ChangeUnitDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"change_unit\".\"id\", \"change_unit\".\"change_set_id\", \"change_unit\".\"subject_entity_kind\", \"change_unit\".\"subject_entity_id\", \"change_unit\".\"subject_initial_status\", \"change_unit\".\"action\", \"change_unit\".\"execution_status\", \"change_unit\".\"name\", \"change_unit\".\"description\", \"change_unit\".\"last_updated_at\", \"change_unit\".\"last_updated_by\", \"change_unit\".\"external_id\", \"change_unit\".\"provenance\" from \"change_unit\" where \"change_unit\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link ChangeUnitDao#findByChangeSetId(long)}
   */
  @Test
  void testFindByChangeSetId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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
    List<ChangeUnit> actualFindByChangeSetIdResult = (new ChangeUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByChangeSetId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"change_unit\".\"id\", \"change_unit\".\"change_set_id\", \"change_unit\".\"subject_entity_kind\", \"change_unit\".\"subject_entity_id\", \"change_unit\".\"subject_initial_status\", \"change_unit\".\"action\", \"change_unit\".\"execution_status\", \"change_unit\".\"name\", \"change_unit\".\"description\", \"change_unit\".\"last_updated_at\", \"change_unit\".\"last_updated_by\", \"change_unit\".\"external_id\", \"change_unit\".\"provenance\" from \"change_unit\" where \"change_unit\".\"change_set_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByChangeSetIdResult.isEmpty());
  }
}
