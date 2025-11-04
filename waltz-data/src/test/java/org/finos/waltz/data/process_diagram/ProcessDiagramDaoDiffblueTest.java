package org.finos.waltz.data.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagram;
import org.finos.waltz.model.process_diagram.ProcessDiagram;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntity;
import org.finos.waltz.model.process_diagram.ProcessDiagramKind;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProcessDiagramDaoDiffblueTest {
  /**
   * Method under test: {@link ProcessDiagramDao#getDiagramById(long)}
   */
  @Test
  void testGetDiagramById() throws SQLException {
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
    ProcessDiagram actualDiagramById = (new ProcessDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getDiagramById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualDiagramById);
  }

  /**
   * Method under test: {@link ProcessDiagramDao#getDiagramById(long)}
   */
  @Test
  void testGetDiagramById2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    ProcessDiagram actualDiagramById = (new ProcessDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getDiagramById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualDiagramById instanceof ImmutableProcessDiagram);
    LocalDateTime createdAtResult = actualDiagramById.createdAt();
    assertEquals("00:00:00.010", createdAtResult.toLocalTime().toString());
    LocalDateTime lastUpdatedAtResult = actualDiagramById.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", actualDiagramById.createdBy());
    assertEquals("String", actualDiagramById.description());
    assertEquals("String", actualDiagramById.lastUpdatedBy());
    assertEquals("String", actualDiagramById.name());
    assertEquals("String", actualDiagramById.provenance());
    assertEquals(EntityKind.PROCESS_DIAGRAM, actualDiagramById.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualDiagramById.diagramKind());
  }

  /**
   * Method under test: {@link ProcessDiagramDao#getDiagramById(long)}
   */
  @Test
  void testGetDiagramById3() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("WALTZ_SPARX");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    ProcessDiagram actualDiagramById = (new ProcessDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getDiagramById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualDiagramById instanceof ImmutableProcessDiagram);
    LocalDateTime createdAtResult = actualDiagramById.createdAt();
    assertEquals("00:00:00.010", createdAtResult.toLocalTime().toString());
    LocalDateTime lastUpdatedAtResult = actualDiagramById.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("WALTZ_SPARX", actualDiagramById.createdBy());
    assertEquals("WALTZ_SPARX", actualDiagramById.description());
    assertEquals("WALTZ_SPARX", actualDiagramById.lastUpdatedBy());
    assertEquals("WALTZ_SPARX", actualDiagramById.name());
    assertEquals("WALTZ_SPARX", actualDiagramById.provenance());
    assertEquals(EntityKind.PROCESS_DIAGRAM, actualDiagramById.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualDiagramById.diagramKind());
  }

  /**
   * Method under test: {@link ProcessDiagramDao#getDiagramByExternalId(String)}
   */
  @Test
  void testGetDiagramByExternalId() throws SQLException {
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
    ProcessDiagram actualDiagramByExternalId = (new ProcessDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getDiagramByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualDiagramByExternalId);
  }

  /**
   * Method under test: {@link ProcessDiagramDao#getDiagramByExternalId(String)}
   */
  @Test
  void testGetDiagramByExternalId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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
    ProcessDiagram actualDiagramByExternalId = (new ProcessDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getDiagramByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualDiagramByExternalId instanceof ImmutableProcessDiagram);
    LocalDateTime createdAtResult = actualDiagramByExternalId.createdAt();
    assertEquals("00:00:00.010", createdAtResult.toLocalTime().toString());
    LocalDateTime lastUpdatedAtResult = actualDiagramByExternalId.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", actualDiagramByExternalId.createdBy());
    assertEquals("String", actualDiagramByExternalId.description());
    assertEquals("String", actualDiagramByExternalId.lastUpdatedBy());
    assertEquals("String", actualDiagramByExternalId.name());
    assertEquals("String", actualDiagramByExternalId.provenance());
    assertEquals(EntityKind.PROCESS_DIAGRAM, actualDiagramByExternalId.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualDiagramByExternalId.diagramKind());
  }

  /**
   * Method under test: {@link ProcessDiagramDao#getDiagramByExternalId(String)}
   */
  @Test
  void testGetDiagramByExternalId3() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("WALTZ_SPARX");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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
    ProcessDiagram actualDiagramByExternalId = (new ProcessDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getDiagramByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualDiagramByExternalId instanceof ImmutableProcessDiagram);
    LocalDateTime createdAtResult = actualDiagramByExternalId.createdAt();
    assertEquals("00:00:00.010", createdAtResult.toLocalTime().toString());
    LocalDateTime lastUpdatedAtResult = actualDiagramByExternalId.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.createdBy());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.description());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.lastUpdatedBy());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.name());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.provenance());
    assertEquals(EntityKind.PROCESS_DIAGRAM, actualDiagramByExternalId.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualDiagramByExternalId.diagramKind());
  }

  /**
   * Method under test: {@link ProcessDiagramDao#findDiagramEntitiesById(long)}
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
    Set<ProcessDiagramEntity> actualFindDiagramEntitiesByIdResult = (new ProcessDiagramDao(
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
}
