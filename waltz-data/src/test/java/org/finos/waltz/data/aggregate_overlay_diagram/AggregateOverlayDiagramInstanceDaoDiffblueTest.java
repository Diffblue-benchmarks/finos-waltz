package org.finos.waltz.data.aggregate_overlay_diagram;

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
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramInstance;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramInstanceCreateCommand;
import org.finos.waltz.schema.tables.records.AggregateOverlayDiagramInstanceRecord;
import org.jooq.DSLContext;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramInstanceDaoDiffblueTest {
  /**
   * Method under test: {@link AggregateOverlayDiagramInstanceDao#findAll()}
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<AggregateOverlayDiagramInstance> actualFindAllResult = (new AggregateOverlayDiagramInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_instance\".\"id\", \"aggregate_overlay_diagram_instance\".\"diagram_id\", \"aggregate_overlay_diagram_instance\".\"name\", \"aggregate_overlay_diagram_instance\".\"description\", \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\", \"aggregate_overlay_diagram_instance\".\"parent_entity_id\", \"aggregate_overlay_diagram_instance\".\"svg\", \"aggregate_overlay_diagram_instance\".\"last_updated_at\", \"aggregate_overlay_diagram_instance\".\"last_updated_by\", \"aggregate_overlay_diagram_instance\".\"provenance\", \"aggregate_overlay_diagram_instance\".\"snapshot_data\", case when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"person\".\"display_name\" from \"person\" where \"person\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") end \"entity_name\" from \"aggregate_overlay_diagram_instance\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link AggregateOverlayDiagramInstanceDao#getById(Long)}
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AggregateOverlayDiagramInstance actualById = (new AggregateOverlayDiagramInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_instance\".\"id\", \"aggregate_overlay_diagram_instance\".\"diagram_id\", \"aggregate_overlay_diagram_instance\".\"name\", \"aggregate_overlay_diagram_instance\".\"description\", \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\", \"aggregate_overlay_diagram_instance\".\"parent_entity_id\", \"aggregate_overlay_diagram_instance\".\"svg\", \"aggregate_overlay_diagram_instance\".\"last_updated_at\", \"aggregate_overlay_diagram_instance\".\"last_updated_by\", \"aggregate_overlay_diagram_instance\".\"provenance\", \"aggregate_overlay_diagram_instance\".\"snapshot_data\", case when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"person\".\"display_name\" from \"person\" where \"person\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") end \"entity_name\" from \"aggregate_overlay_diagram_instance\" where \"aggregate_overlay_diagram_instance\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
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
   * {@link AggregateOverlayDiagramInstanceDao#findByDiagramId(Long)}
   */
  @Test
  void testFindByDiagramId() throws SQLException {
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
    Set<AggregateOverlayDiagramInstance> actualFindByDiagramIdResult = (new AggregateOverlayDiagramInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByDiagramId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_instance\".\"id\", \"aggregate_overlay_diagram_instance\".\"diagram_id\", \"aggregate_overlay_diagram_instance\".\"name\", \"aggregate_overlay_diagram_instance\".\"description\", \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\", \"aggregate_overlay_diagram_instance\".\"parent_entity_id\", \"aggregate_overlay_diagram_instance\".\"svg\", \"aggregate_overlay_diagram_instance\".\"last_updated_at\", \"aggregate_overlay_diagram_instance\".\"last_updated_by\", \"aggregate_overlay_diagram_instance\".\"provenance\", \"aggregate_overlay_diagram_instance\".\"snapshot_data\", case when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"person\".\"display_name\" from \"person\" where \"person\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") end \"entity_name\" from \"aggregate_overlay_diagram_instance\" where \"aggregate_overlay_diagram_instance\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByDiagramIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand, String)}
   */
  @Test
  void testCreateInstance() throws DataAccessException {
    // Arrange
    AggregateOverlayDiagramInstanceRecord aggregateOverlayDiagramInstanceRecord = mock(
        AggregateOverlayDiagramInstanceRecord.class);
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setParentEntityId(Mockito.<Long>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setParentEntityKind(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setProvenance(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setSvg(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setDescription(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setDiagramId(Mockito.<Long>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setName(Mockito.<String>any());
    InsertSetMoreStep<AggregateOverlayDiagramInstanceRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetStep<AggregateOverlayDiagramInstanceRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramInstanceRecord>>any())).thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramInstanceRecord>>any()))
        .thenReturn(aggregateOverlayDiagramInstanceRecord);
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao = new AggregateOverlayDiagramInstanceDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    OverlayDiagramInstanceCreateCommand createCommand = mock(OverlayDiagramInstanceCreateCommand.class);
    when(createCommand.svg()).thenReturn("Svg");
    when(createCommand.diagramId()).thenReturn(1L);
    when(createCommand.description()).thenReturn("The characteristics of someone or something");
    when(createCommand.name()).thenReturn("Name");
    when(createCommand.parentEntityReference()).thenReturn(entityReference);

    // Act
    int actualCreateInstanceResult = aggregateOverlayDiagramInstanceDao.createInstance(createCommand, "janedoe");

    // Assert
    verify(createCommand).description();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(createCommand).name();
    verify(createCommand).diagramId();
    verify(createCommand, atLeast(1)).parentEntityReference();
    verify(createCommand).svg();
    verify(aggregateOverlayDiagramInstanceRecord).setDescription(eq("The characteristics of someone or something"));
    verify(aggregateOverlayDiagramInstanceRecord).setDiagramId(eq(1L));
    verify(aggregateOverlayDiagramInstanceRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(aggregateOverlayDiagramInstanceRecord).setLastUpdatedBy(eq("janedoe"));
    verify(aggregateOverlayDiagramInstanceRecord).setName(eq("Name"));
    verify(aggregateOverlayDiagramInstanceRecord).setParentEntityId(eq(1L));
    verify(aggregateOverlayDiagramInstanceRecord).setParentEntityKind(eq("ALL"));
    verify(aggregateOverlayDiagramInstanceRecord).setProvenance(eq("waltz"));
    verify(aggregateOverlayDiagramInstanceRecord).setSvg(eq("Svg"));
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateInstanceResult);
  }
}
