package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.BackingEntity;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.jooq.SQLDialect;
import org.jooq.TransactionalRunnable;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramDaoDiffblueTest {
  /**
   * Method under test: {@link AggregateOverlayDiagramDao#getById(Long)}
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
    AggregateOverlayDiagram actualById = (new AggregateOverlayDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram\".\"id\", \"aggregate_overlay_diagram\".\"name\", \"aggregate_overlay_diagram\".\"description\", \"aggregate_overlay_diagram\".\"layout_data\", \"aggregate_overlay_diagram\".\"last_updated_at\", \"aggregate_overlay_diagram\".\"last_updated_by\", \"aggregate_overlay_diagram\".\"provenance\", \"aggregate_overlay_diagram\".\"aggregated_entity_kind\", \"aggregate_overlay_diagram\".\"diagram_kind\", \"aggregate_overlay_diagram\".\"status\" from \"aggregate_overlay_diagram\" where \"aggregate_overlay_diagram\".\"id\" = ?"));
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
   * Method under test: {@link AggregateOverlayDiagramDao#findAll()}
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
    Set<AggregateOverlayDiagram> actualFindAllResult = (new AggregateOverlayDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram\".\"id\", \"aggregate_overlay_diagram\".\"name\", \"aggregate_overlay_diagram\".\"description\", \"aggregate_overlay_diagram\".\"layout_data\", \"aggregate_overlay_diagram\".\"last_updated_at\", \"aggregate_overlay_diagram\".\"last_updated_by\", \"aggregate_overlay_diagram\".\"provenance\", \"aggregate_overlay_diagram\".\"aggregated_entity_kind\", \"aggregate_overlay_diagram\".\"diagram_kind\", \"aggregate_overlay_diagram\".\"status\" from \"aggregate_overlay_diagram\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramDao#findByKind(OverlayDiagramKind)}
   */
  @Test
  void testFindByKind() throws SQLException {
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
    Set<AggregateOverlayDiagram> actualFindByKindResult = (new AggregateOverlayDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram\".\"id\", \"aggregate_overlay_diagram\".\"name\", \"aggregate_overlay_diagram\".\"description\", \"aggregate_overlay_diagram\".\"layout_data\", \"aggregate_overlay_diagram\".\"last_updated_at\", \"aggregate_overlay_diagram\".\"last_updated_by\", \"aggregate_overlay_diagram\".\"provenance\", \"aggregate_overlay_diagram\".\"aggregated_entity_kind\", \"aggregate_overlay_diagram\".\"diagram_kind\", \"aggregate_overlay_diagram\".\"status\" from \"aggregate_overlay_diagram\" where \"aggregate_overlay_diagram\".\"diagram_kind\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("WALTZ_ENTITY_OVERLAY"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramDao#findBackingEntities(Long)}
   */
  @Test
  void testFindBackingEntities() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<BackingEntity> actualFindBackingEntitiesResult = (new AggregateOverlayDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findBackingEntities(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_cell_data\".\"cell_external_id\", \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\", \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\", case when \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") when \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") when \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") when \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\" = ? then (select \"person\".\"display_name\" from \"person\" where \"person\".\"id\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") end \"entity_name\" from \"aggregate_overlay_diagram_cell_data\" where \"aggregate_overlay_diagram_cell_data\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindBackingEntitiesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}
   */
  @Test
  void testUpdateBackingEntities() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    aggregateOverlayDiagramDao.updateBackingEntities(1L, new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"aggregate_overlay_diagram_cell_data\" where \"aggregate_overlay_diagram_cell_data\".\"diagram_id\" = ?"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}
   */
  @Test
  void testUpdateBackingEntities2() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    // Act
    aggregateOverlayDiagramDao.updateBackingEntities(1L, new HashSet<>());

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}
   */
  @Test
  void testUpdateBackingEntities3() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    HashSet<BackingEntity> backingEntities = new HashSet<>();
    backingEntities.add(mock(BackingEntity.class));

    // Act
    aggregateOverlayDiagramDao.updateBackingEntities(1L, backingEntities);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}
   */
  @Test
  void testUpdateBackingEntities4() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    HashSet<BackingEntity> backingEntities = new HashSet<>();
    backingEntities.add(mock(BackingEntity.class));
    backingEntities.add(mock(BackingEntity.class));

    // Act
    aggregateOverlayDiagramDao.updateBackingEntities(1L, backingEntities);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }
}
