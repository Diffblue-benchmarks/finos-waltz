package org.finos.waltz.data.process_diagram_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.Set;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntity;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntityApplicationAlignment;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProcessDiagramEntityDaoDiffblueTest {
  /**
   * Method under test:
   * {@link ProcessDiagramEntityDao#findDiagramEntitiesById(long)}
   */
  @Test
  void testFindDiagramEntitiesById() throws SQLException {
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
    Set<ProcessDiagramEntity> actualFindDiagramEntitiesByIdResult = (new ProcessDiagramEntityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findDiagramEntitiesById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram_entity\".\"diagram_id\", \"process_diagram_entity\".\"entity_id\", \"process_diagram_entity\".\"entity_kind\", \"process_diagram_entity\".\"is_notable\" from \"process_diagram_entity\" where \"process_diagram_entity\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindDiagramEntitiesByIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ProcessDiagramEntityDao#findApplicationAlignmentsByDiagramId(Long)}
   */
  @Test
  void testFindApplicationAlignmentsByDiagramId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<ProcessDiagramEntityApplicationAlignment> actualFindApplicationAlignmentsByDiagramIdResult = (new ProcessDiagramEntityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findApplicationAlignmentsByDiagramId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"parent_measurable\".\"id\", \"parent_measurable\".\"name\", \"parent_measurable\".\"description\", \"parent_measurable\".\"external_id\", \"child_measurable\".\"id\", \"child_measurable\".\"name\", \"child_measurable\".\"description\", \"child_measurable\".\"external_id\", \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\" from \"process_diagram_entity\" join \"entity_hierarchy\" on (\"process_diagram_entity\".\"entity_id\" = \"entity_hierarchy\".\"ancestor_id\" and \"entity_hierarchy\".\"kind\" = ? and \"process_diagram_entity\".\"entity_kind\" = ?) join \"measurable\" \"parent_measurable\" on \"process_diagram_entity\".\"entity_id\" = \"parent_measurable\".\"id\" join \"measurable\" \"child_measurable\" on \"entity_hierarchy\".\"id\" = \"child_measurable\".\"id\" join \"measurable_rating\" on \"child_measurable\".\"id\" = \"measurable_rating\".\"measurable_id\" join \"application\" on (\"measurable_rating\".\"entity_id\" = \"application\".\"id\" and \"measurable_rating\".\"entity_kind\" = ?) where (\"process_diagram_entity\".\"diagram_id\" = ? and \"application\".\"entity_lifecycle_status\" <> ? and \"application\".\"is_removed\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindApplicationAlignmentsByDiagramIdResult.size());
  }
}
