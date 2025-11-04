package org.finos.waltz.data.logical_data_element;

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
import org.finos.waltz.model.logical_data_element.LogicalDataElement;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalDataElementDaoDiffblueTest {
  /**
   * Method under test: {@link LogicalDataElementDao#getById(long)}
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
    LogicalDataElement actualById = (new LogicalDataElementDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_data_element\".\"id\", \"logical_data_element\".\"external_id\", \"logical_data_element\".\"name\", \"logical_data_element\".\"description\", \"logical_data_element\".\"type\", \"logical_data_element\".\"provenance\", \"logical_data_element\".\"entity_lifecycle_status\", \"logical_data_element\".\"parent_data_type_id\" from \"logical_data_element\" where \"logical_data_element\".\"id\" = ?"));
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
   * Method under test: {@link LogicalDataElementDao#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() throws SQLException {
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
    LogicalDataElement actualByExternalId = (new LogicalDataElementDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_data_element\".\"id\", \"logical_data_element\".\"external_id\", \"logical_data_element\".\"name\", \"logical_data_element\".\"description\", \"logical_data_element\".\"type\", \"logical_data_element\".\"provenance\", \"logical_data_element\".\"entity_lifecycle_status\", \"logical_data_element\".\"parent_data_type_id\" from \"logical_data_element\" where \"logical_data_element\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByExternalId);
  }

  /**
   * Method under test: {@link LogicalDataElementDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<LogicalDataElement> actualFindAllResult = (new LogicalDataElementDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_data_element\".\"id\", \"logical_data_element\".\"external_id\", \"logical_data_element\".\"name\", \"logical_data_element\".\"description\", \"logical_data_element\".\"type\", \"logical_data_element\".\"provenance\", \"logical_data_element\".\"entity_lifecycle_status\", \"logical_data_element\".\"parent_data_type_id\" from \"logical_data_element\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }
}
