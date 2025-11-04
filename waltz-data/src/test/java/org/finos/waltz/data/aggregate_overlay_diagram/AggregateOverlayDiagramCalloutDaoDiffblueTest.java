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
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramCallout;
import org.finos.waltz.model.aggregate_overlay_diagram.DiagramCalloutCreateCommand;
import org.finos.waltz.schema.tables.records.AggregateOverlayDiagramCalloutRecord;
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

class AggregateOverlayDiagramCalloutDaoDiffblueTest {
  /**
   * Method under test:
   * {@link AggregateOverlayDiagramCalloutDao#findByDiagramInstanceId(Long)}
   */
  @Test
  void testFindByDiagramInstanceId() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<AggregateOverlayDiagramCallout> actualFindByDiagramInstanceIdResult = (new AggregateOverlayDiagramCalloutDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByDiagramInstanceId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_callout\".\"id\", \"aggregate_overlay_diagram_callout\".\"diagram_instance_id\", \"aggregate_overlay_diagram_callout\".\"title\", \"aggregate_overlay_diagram_callout\".\"content\", \"aggregate_overlay_diagram_callout\".\"start_color\", \"aggregate_overlay_diagram_callout\".\"end_color\", \"aggregate_overlay_diagram_callout\".\"cell_external_id\" from \"aggregate_overlay_diagram_callout\" where \"aggregate_overlay_diagram_callout\".\"diagram_instance_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindByDiagramInstanceIdResult.size());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramCalloutDao#findByDiagramInstanceId(Long)}
   */
  @Test
  void testFindByDiagramInstanceId2() throws SQLException {
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
    Set<AggregateOverlayDiagramCallout> actualFindByDiagramInstanceIdResult = (new AggregateOverlayDiagramCalloutDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByDiagramInstanceId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_callout\".\"id\", \"aggregate_overlay_diagram_callout\".\"diagram_instance_id\", \"aggregate_overlay_diagram_callout\".\"title\", \"aggregate_overlay_diagram_callout\".\"content\", \"aggregate_overlay_diagram_callout\".\"start_color\", \"aggregate_overlay_diagram_callout\".\"end_color\", \"aggregate_overlay_diagram_callout\".\"cell_external_id\" from \"aggregate_overlay_diagram_callout\" where \"aggregate_overlay_diagram_callout\".\"diagram_instance_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByDiagramInstanceIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramCalloutDao#create(DiagramCalloutCreateCommand)}
   */
  @Test
  void testCreate() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<AggregateOverlayDiagramCalloutRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetStep<AggregateOverlayDiagramCalloutRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any())).thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(new AggregateOverlayDiagramCalloutRecord());
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao = new AggregateOverlayDiagramCalloutDao(dsl);
    DiagramCalloutCreateCommand createCommand = mock(DiagramCalloutCreateCommand.class);
    when(createCommand.instanceId()).thenReturn(1L);
    when(createCommand.cellExternalId()).thenReturn("42");
    when(createCommand.content()).thenReturn("Not all who wander are lost");
    when(createCommand.endColor()).thenReturn("End Color");
    when(createCommand.startColor()).thenReturn("Start Color");
    when(createCommand.title()).thenReturn("Dr");

    // Act
    int actualCreateResult = aggregateOverlayDiagramCalloutDao.create(createCommand);

    // Assert
    verify(createCommand).cellExternalId();
    verify(createCommand).content();
    verify(createCommand).endColor();
    verify(createCommand).instanceId();
    verify(createCommand).startColor();
    verify(createCommand).title();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramCalloutDao#create(DiagramCalloutCreateCommand)}
   */
  @Test
  void testCreate2() throws DataAccessException {
    // Arrange
    AggregateOverlayDiagramCalloutRecord aggregateOverlayDiagramCalloutRecord = mock(
        AggregateOverlayDiagramCalloutRecord.class);
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setCellExternalId(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setContent(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setDiagramInstanceId(Mockito.<Long>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setEndColor(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setStartColor(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setTitle(Mockito.<String>any());
    InsertSetMoreStep<AggregateOverlayDiagramCalloutRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetStep<AggregateOverlayDiagramCalloutRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any())).thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(aggregateOverlayDiagramCalloutRecord);
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao = new AggregateOverlayDiagramCalloutDao(dsl);
    DiagramCalloutCreateCommand createCommand = mock(DiagramCalloutCreateCommand.class);
    when(createCommand.instanceId()).thenReturn(1L);
    when(createCommand.cellExternalId()).thenReturn("42");
    when(createCommand.content()).thenReturn("Not all who wander are lost");
    when(createCommand.endColor()).thenReturn("End Color");
    when(createCommand.startColor()).thenReturn("Start Color");
    when(createCommand.title()).thenReturn("Dr");

    // Act
    int actualCreateResult = aggregateOverlayDiagramCalloutDao.create(createCommand);

    // Assert
    verify(createCommand).cellExternalId();
    verify(createCommand).content();
    verify(createCommand).endColor();
    verify(createCommand).instanceId();
    verify(createCommand).startColor();
    verify(createCommand).title();
    verify(aggregateOverlayDiagramCalloutRecord).setCellExternalId(eq("42"));
    verify(aggregateOverlayDiagramCalloutRecord).setContent(eq("Not all who wander are lost"));
    verify(aggregateOverlayDiagramCalloutRecord).setDiagramInstanceId(eq(1L));
    verify(aggregateOverlayDiagramCalloutRecord).setEndColor(eq("End Color"));
    verify(aggregateOverlayDiagramCalloutRecord).setStartColor(eq("Start Color"));
    verify(aggregateOverlayDiagramCalloutRecord).setTitle(eq("Dr"));
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Method under test: {@link AggregateOverlayDiagramCalloutDao#delete(long)}
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
    Integer actualDeleteResult = (new AggregateOverlayDiagramCalloutDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).delete(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("delete from \"aggregate_overlay_diagram_callout\" where \"aggregate_overlay_diagram_callout\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult.intValue());
  }
}
