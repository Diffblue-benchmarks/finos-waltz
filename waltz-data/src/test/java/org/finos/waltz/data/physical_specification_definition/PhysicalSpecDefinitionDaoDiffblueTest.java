package org.finos.waltz.data.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.util.List;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinition;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecDefinitionDaoDiffblueTest {
  /**
   * Method under test: {@link PhysicalSpecDefinitionDao#getById(long)}
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
    PhysicalSpecDefinition actualById = (new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_spec_defn\".\"id\", \"physical_spec_defn\".\"specification_id\", \"physical_spec_defn\".\"version\", \"physical_spec_defn\".\"delimiter\", \"physical_spec_defn\".\"type\", \"physical_spec_defn\".\"provenance\", \"physical_spec_defn\".\"created_at\", \"physical_spec_defn\".\"created_by\", \"physical_spec_defn\".\"last_updated_at\", \"physical_spec_defn\".\"last_updated_by\", \"physical_spec_defn\".\"status\" from \"physical_spec_defn\" where \"physical_spec_defn\".\"id\" = ?"));
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
   * Method under test:
   * {@link PhysicalSpecDefinitionDao#findForSpecification(long)}
   */
  @Test
  void testFindForSpecification() throws SQLException {
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
    List<PhysicalSpecDefinition> actualFindForSpecificationResult = (new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSpecification(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_spec_defn\".\"id\", \"physical_spec_defn\".\"specification_id\", \"physical_spec_defn\".\"version\", \"physical_spec_defn\".\"delimiter\", \"physical_spec_defn\".\"type\", \"physical_spec_defn\".\"provenance\", \"physical_spec_defn\".\"created_at\", \"physical_spec_defn\".\"created_by\", \"physical_spec_defn\".\"last_updated_at\", \"physical_spec_defn\".\"last_updated_by\", \"physical_spec_defn\".\"status\" from \"physical_spec_defn\" where \"physical_spec_defn\".\"specification_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForSpecificationResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalSpecDefinitionDao#delete(long)}
   */
  @Test
  void testDelete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteResult = (new PhysicalSpecDefinitionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"physical_spec_defn\" where \"physical_spec_defn\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionDao#updateStatus(long, ReleaseLifecycleStatus, String)}
   */
  @Test
  void testUpdateStatus() throws SQLException {
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

    // Act
    int actualUpdateStatusResult = (new PhysicalSpecDefinitionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateStatus(1L, ReleaseLifecycleStatus.DRAFT, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_spec_defn\" set \"physical_spec_defn\".\"status\" = ?, \"physical_spec_defn\".\"last_updated_at\" = ?, \"physical_spec_defn\".\"last_updated_by\" = ? where (\"physical_spec_defn\".\"id\" = ? and \"physical_spec_defn\".\"status\" <> ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionDao#markExistingActiveAsDeprecated(long, String)}
   */
  @Test
  void testMarkExistingActiveAsDeprecated() throws SQLException {
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

    // Act
    int actualMarkExistingActiveAsDeprecatedResult = (new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).markExistingActiveAsDeprecated(1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_spec_defn\" set \"physical_spec_defn\".\"status\" = ?, \"physical_spec_defn\".\"last_updated_at\" = ?, \"physical_spec_defn\".\"last_updated_by\" = ? where (\"physical_spec_defn\".\"specification_id\" = ? and \"physical_spec_defn\".\"status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkExistingActiveAsDeprecatedResult);
  }
}
