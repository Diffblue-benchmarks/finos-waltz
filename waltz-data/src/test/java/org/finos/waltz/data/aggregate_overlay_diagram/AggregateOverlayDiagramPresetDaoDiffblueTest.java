package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramPreset;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramPresetCreateCommand;
import org.finos.waltz.schema.tables.records.AggregateOverlayDiagramPresetRecord;
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

class AggregateOverlayDiagramPresetDaoDiffblueTest {
  /**
   * Method under test:
   * {@link AggregateOverlayDiagramPresetDao#findPresetsForDiagram(Long)}
   */
  @Test
  void testFindPresetsForDiagram() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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
    Set<AggregateOverlayDiagramPreset> actualFindPresetsForDiagramResult = (new AggregateOverlayDiagramPresetDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPresetsForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_preset\".\"id\", \"aggregate_overlay_diagram_preset\".\"diagram_id\", \"aggregate_overlay_diagram_preset\".\"name\", \"aggregate_overlay_diagram_preset\".\"description\", \"aggregate_overlay_diagram_preset\".\"external_id\", \"aggregate_overlay_diagram_preset\".\"overlay_config\", \"aggregate_overlay_diagram_preset\".\"filter_config\", \"aggregate_overlay_diagram_preset\".\"last_updated_at\", \"aggregate_overlay_diagram_preset\".\"last_updated_by\", \"aggregate_overlay_diagram_preset\".\"provenance\" from \"aggregate_overlay_diagram_preset\" where \"aggregate_overlay_diagram_preset\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(1, actualFindPresetsForDiagramResult.size());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramPresetDao#findPresetsForDiagram(Long)}
   */
  @Test
  void testFindPresetsForDiagram2() throws SQLException {
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
    Set<AggregateOverlayDiagramPreset> actualFindPresetsForDiagramResult = (new AggregateOverlayDiagramPresetDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPresetsForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_preset\".\"id\", \"aggregate_overlay_diagram_preset\".\"diagram_id\", \"aggregate_overlay_diagram_preset\".\"name\", \"aggregate_overlay_diagram_preset\".\"description\", \"aggregate_overlay_diagram_preset\".\"external_id\", \"aggregate_overlay_diagram_preset\".\"overlay_config\", \"aggregate_overlay_diagram_preset\".\"filter_config\", \"aggregate_overlay_diagram_preset\".\"last_updated_at\", \"aggregate_overlay_diagram_preset\".\"last_updated_by\", \"aggregate_overlay_diagram_preset\".\"provenance\" from \"aggregate_overlay_diagram_preset\" where \"aggregate_overlay_diagram_preset\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPresetsForDiagramResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramPresetDao#create(OverlayDiagramPresetCreateCommand, String)}
   */
  @Test
  void testCreate() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<AggregateOverlayDiagramPresetRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetStep<AggregateOverlayDiagramPresetRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramPresetRecord>>any())).thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramPresetRecord>>any()))
        .thenReturn(new AggregateOverlayDiagramPresetRecord());
    AggregateOverlayDiagramPresetDao aggregateOverlayDiagramPresetDao = new AggregateOverlayDiagramPresetDao(dsl);
    OverlayDiagramPresetCreateCommand createCommand = mock(OverlayDiagramPresetCreateCommand.class);
    when(createCommand.diagramId()).thenReturn(1L);
    when(createCommand.description()).thenReturn("The characteristics of someone or something");
    when(createCommand.name()).thenReturn("Name");
    when(createCommand.externalId()).thenReturn("42");
    when(createCommand.filterConfig()).thenReturn("Filter Config");
    when(createCommand.overlayConfig()).thenReturn("Overlay Config");

    // Act
    int actualCreateResult = aggregateOverlayDiagramPresetDao.create(createCommand, "janedoe");

    // Assert
    verify(createCommand).description();
    verify(createCommand).name();
    verify(createCommand).diagramId();
    verify(createCommand).externalId();
    verify(createCommand).filterConfig();
    verify(createCommand).overlayConfig();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramPresetDao#create(OverlayDiagramPresetCreateCommand, String)}
   */
  @Test
  void testCreate2() throws DataAccessException {
    // Arrange
    AggregateOverlayDiagramPresetRecord aggregateOverlayDiagramPresetRecord = mock(
        AggregateOverlayDiagramPresetRecord.class);
    doNothing().when(aggregateOverlayDiagramPresetRecord).setDescription(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setDiagramId(Mockito.<Long>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setExternalId(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setFilterConfig(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setName(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setOverlayConfig(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setProvenance(Mockito.<String>any());
    InsertSetMoreStep<AggregateOverlayDiagramPresetRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetStep<AggregateOverlayDiagramPresetRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramPresetRecord>>any())).thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramPresetRecord>>any()))
        .thenReturn(aggregateOverlayDiagramPresetRecord);
    AggregateOverlayDiagramPresetDao aggregateOverlayDiagramPresetDao = new AggregateOverlayDiagramPresetDao(dsl);
    OverlayDiagramPresetCreateCommand createCommand = mock(OverlayDiagramPresetCreateCommand.class);
    when(createCommand.diagramId()).thenReturn(1L);
    when(createCommand.description()).thenReturn("The characteristics of someone or something");
    when(createCommand.name()).thenReturn("Name");
    when(createCommand.externalId()).thenReturn("42");
    when(createCommand.filterConfig()).thenReturn("Filter Config");
    when(createCommand.overlayConfig()).thenReturn("Overlay Config");

    // Act
    int actualCreateResult = aggregateOverlayDiagramPresetDao.create(createCommand, "janedoe");

    // Assert
    verify(createCommand).description();
    verify(createCommand).name();
    verify(createCommand).diagramId();
    verify(createCommand).externalId();
    verify(createCommand).filterConfig();
    verify(createCommand).overlayConfig();
    verify(aggregateOverlayDiagramPresetRecord).setDescription(eq("The characteristics of someone or something"));
    verify(aggregateOverlayDiagramPresetRecord).setDiagramId(eq(1L));
    verify(aggregateOverlayDiagramPresetRecord).setExternalId(eq("42"));
    verify(aggregateOverlayDiagramPresetRecord).setFilterConfig(eq("Filter Config"));
    verify(aggregateOverlayDiagramPresetRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(aggregateOverlayDiagramPresetRecord).setLastUpdatedBy(eq("janedoe"));
    verify(aggregateOverlayDiagramPresetRecord).setName(eq("Name"));
    verify(aggregateOverlayDiagramPresetRecord).setOverlayConfig(eq("Overlay Config"));
    verify(aggregateOverlayDiagramPresetRecord).setProvenance(eq("waltz"));
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }
}
