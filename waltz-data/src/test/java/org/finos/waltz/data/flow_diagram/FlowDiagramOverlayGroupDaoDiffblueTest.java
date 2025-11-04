package org.finos.waltz.data.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
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
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroup;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroupEntry;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroup;
import org.finos.waltz.schema.tables.records.FlowDiagramOverlayGroupEntryRecord;
import org.finos.waltz.schema.tables.records.FlowDiagramOverlayGroupRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowDiagramOverlayGroupDaoDiffblueTest {
  /**
   * Method under test: {@link FlowDiagramOverlayGroupDao#getById(Long)}
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
    FlowDiagramOverlayGroup actualById = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram_overlay_group\".\"id\", \"flow_diagram_overlay_group\".\"flow_diagram_id\", \"flow_diagram_overlay_group\".\"name\", \"flow_diagram_overlay_group\".\"description\", \"flow_diagram_overlay_group\".\"external_id\", \"flow_diagram_overlay_group\".\"is_default\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"id\" = ?"));
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
   * Method under test: {@link FlowDiagramOverlayGroupDao#getById(Long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    FlowDiagramOverlayGroup actualById = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram_overlay_group\".\"id\", \"flow_diagram_overlay_group\".\"flow_diagram_id\", \"flow_diagram_overlay_group\".\"name\", \"flow_diagram_overlay_group\".\"description\", \"flow_diagram_overlay_group\".\"external_id\", \"flow_diagram_overlay_group\".\"is_default\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualById instanceof ImmutableFlowDiagramOverlayGroup);
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.externalId());
    assertEquals(1L, actualById.diagramId().longValue());
    assertTrue(actualById.isDefault());
  }

  /**
   * Method under test: {@link FlowDiagramOverlayGroupDao#findByDiagramId(long)}
   */
  @Test
  void testFindByDiagramId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    Set<FlowDiagramOverlayGroup> actualFindByDiagramIdResult = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByDiagramId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram_overlay_group\".\"id\", \"flow_diagram_overlay_group\".\"flow_diagram_id\", \"flow_diagram_overlay_group\".\"name\", \"flow_diagram_overlay_group\".\"description\", \"flow_diagram_overlay_group\".\"external_id\", \"flow_diagram_overlay_group\".\"is_default\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"flow_diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindByDiagramIdResult.size());
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#findOverlaysByDiagramId(long)}
   */
  @Test
  void testFindOverlaysByDiagramId() throws SQLException {
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
    Set<FlowDiagramOverlayGroupEntry> actualFindOverlaysByDiagramIdResult = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOverlaysByDiagramId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_diagram_overlay_group_entry\".\"entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"flow_diagram_overlay_group_entry\".\"entity_id\") when \"flow_diagram_overlay_group_entry\".\"entity_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_diagram_overlay_group_entry\".\"entity_id\") end, \"flow_diagram_overlay_group_entry\".\"id\", \"flow_diagram_overlay_group_entry\".\"overlay_group_id\", \"flow_diagram_overlay_group_entry\".\"entity_id\", \"flow_diagram_overlay_group_entry\".\"entity_kind\", \"flow_diagram_overlay_group_entry\".\"symbol\", \"flow_diagram_overlay_group_entry\".\"fill\", \"flow_diagram_overlay_group_entry\".\"stroke\" from \"flow_diagram_overlay_group_entry\" join \"flow_diagram_overlay_group\" on \"flow_diagram_overlay_group_entry\".\"overlay_group_id\" = \"flow_diagram_overlay_group\".\"id\" where \"flow_diagram_overlay_group\".\"flow_diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindOverlaysByDiagramIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#findOverlaysByGroupId(long)}
   */
  @Test
  void testFindOverlaysByGroupId() throws SQLException {
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
    Set<FlowDiagramOverlayGroupEntry> actualFindOverlaysByGroupIdResult = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOverlaysByGroupId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram_overlay_group_entry\".\"id\", \"flow_diagram_overlay_group_entry\".\"overlay_group_id\", \"flow_diagram_overlay_group_entry\".\"entity_id\", \"flow_diagram_overlay_group_entry\".\"entity_kind\", \"flow_diagram_overlay_group_entry\".\"symbol\", \"flow_diagram_overlay_group_entry\".\"fill\", \"flow_diagram_overlay_group_entry\".\"stroke\", case when \"flow_diagram_overlay_group_entry\".\"entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"flow_diagram_overlay_group_entry\".\"entity_id\") when \"flow_diagram_overlay_group_entry\".\"entity_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_diagram_overlay_group_entry\".\"entity_id\") end from \"flow_diagram_overlay_group_entry\" where \"flow_diagram_overlay_group_entry\".\"overlay_group_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindOverlaysByGroupIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}
   */
  @Test
  void testCreate() throws DataAccessException {
    // Arrange
    InsertResultStep<FlowDiagramOverlayGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new FlowDiagramOverlayGroupRecord());
    InsertSetMoreStep<FlowDiagramOverlayGroupRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) any())).thenReturn(insertResultStep);
    InsertSetStep<FlowDiagramOverlayGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any())).thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(new FlowDiagramOverlayGroupRecord());
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = new FlowDiagramOverlayGroupDao(dsl);
    FlowDiagramOverlayGroup group = mock(FlowDiagramOverlayGroup.class);
    when(group.diagramId()).thenReturn(1L);
    when(group.description()).thenReturn("The characteristics of someone or something");
    when(group.name()).thenReturn("Name");
    when(group.externalId()).thenReturn("42");
    when(group.isDefault()).thenReturn(true);

    // Act
    Long actualCreateResult = flowDiagramOverlayGroupDao.create(group);

    // Assert
    verify(group).description();
    verify(group).name();
    verify(group).diagramId();
    verify(group).externalId();
    verify(group).isDefault();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) any());
    verify(insertSetStep).set(isA(Record.class));
    assertNull(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}
   */
  @Test
  void testCreate2() throws DataAccessException {
    // Arrange
    FlowDiagramOverlayGroupRecord flowDiagramOverlayGroupRecord = mock(FlowDiagramOverlayGroupRecord.class);
    when(flowDiagramOverlayGroupRecord.getId()).thenReturn(1L);
    InsertResultStep<FlowDiagramOverlayGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramOverlayGroupRecord);
    InsertSetMoreStep<FlowDiagramOverlayGroupRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) any())).thenReturn(insertResultStep);
    InsertSetStep<FlowDiagramOverlayGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any())).thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(new FlowDiagramOverlayGroupRecord());
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = new FlowDiagramOverlayGroupDao(dsl);
    FlowDiagramOverlayGroup group = mock(FlowDiagramOverlayGroup.class);
    when(group.diagramId()).thenReturn(1L);
    when(group.description()).thenReturn("The characteristics of someone or something");
    when(group.name()).thenReturn("Name");
    when(group.externalId()).thenReturn("42");
    when(group.isDefault()).thenReturn(true);

    // Act
    Long actualCreateResult = flowDiagramOverlayGroupDao.create(group);

    // Assert
    verify(group).description();
    verify(group).name();
    verify(group).diagramId();
    verify(group).externalId();
    verify(group).isDefault();
    verify(flowDiagramOverlayGroupRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}
   */
  @Test
  void testCreate3() throws DataAccessException {
    // Arrange
    FlowDiagramOverlayGroupRecord flowDiagramOverlayGroupRecord = mock(FlowDiagramOverlayGroupRecord.class);
    doNothing().when(flowDiagramOverlayGroupRecord).setDescription(Mockito.<String>any());
    doNothing().when(flowDiagramOverlayGroupRecord).setExternalId(Mockito.<String>any());
    doNothing().when(flowDiagramOverlayGroupRecord).setFlowDiagramId(Mockito.<Long>any());
    doNothing().when(flowDiagramOverlayGroupRecord).setIsDefault(Mockito.<Boolean>any());
    doNothing().when(flowDiagramOverlayGroupRecord).setName(Mockito.<String>any());
    FlowDiagramOverlayGroupRecord flowDiagramOverlayGroupRecord2 = mock(FlowDiagramOverlayGroupRecord.class);
    when(flowDiagramOverlayGroupRecord2.getId()).thenReturn(1L);
    InsertResultStep<FlowDiagramOverlayGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramOverlayGroupRecord2);
    InsertSetMoreStep<FlowDiagramOverlayGroupRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) any())).thenReturn(insertResultStep);
    InsertSetStep<FlowDiagramOverlayGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any())).thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any())).thenReturn(flowDiagramOverlayGroupRecord);
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = new FlowDiagramOverlayGroupDao(dsl);
    FlowDiagramOverlayGroup group = mock(FlowDiagramOverlayGroup.class);
    when(group.diagramId()).thenReturn(1L);
    when(group.description()).thenReturn("The characteristics of someone or something");
    when(group.name()).thenReturn("Name");
    when(group.externalId()).thenReturn("42");
    when(group.isDefault()).thenReturn(true);

    // Act
    Long actualCreateResult = flowDiagramOverlayGroupDao.create(group);

    // Assert
    verify(group).description();
    verify(group).name();
    verify(group).diagramId();
    verify(group).externalId();
    verify(group).isDefault();
    verify(flowDiagramOverlayGroupRecord2).getId();
    verify(flowDiagramOverlayGroupRecord).setDescription(eq("The characteristics of someone or something"));
    verify(flowDiagramOverlayGroupRecord).setExternalId(eq("42"));
    verify(flowDiagramOverlayGroupRecord).setFlowDiagramId(eq(1L));
    verify(flowDiagramOverlayGroupRecord).setIsDefault(eq(true));
    verify(flowDiagramOverlayGroupRecord).setName(eq("Name"));
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
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
    boolean actualDeleteResult = (new FlowDiagramOverlayGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .delete(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("delete from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  void testDelete2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramOverlayGroupRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<FlowDiagramOverlayGroupRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteResult = (new FlowDiagramOverlayGroupDao(dsl)).delete(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  void testDelete3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteResult = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.POSTGRES))).delete(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("delete from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  void testDelete4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteResult = (new FlowDiagramOverlayGroupDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from flow_diagram_overlay_group where flow_diagram_overlay_group.id = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  void testDeleteOverlaysForDiagram() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteOverlaysForDiagramResult = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"flow_diagram_overlay_group_entry\" where \"flow_diagram_overlay_group_entry\".\"overlay_group_id\" in (select \"flow_diagram_overlay_group\".\"id\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"flow_diagram_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  void testDeleteOverlaysForDiagram2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramOverlayGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<FlowDiagramOverlayGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<FlowDiagramOverlayGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteOverlaysForDiagramResult = (new FlowDiagramOverlayGroupDao(dsl)).deleteOverlaysForDiagram(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  void testDeleteOverlaysForDiagram3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteOverlaysForDiagramResult = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.MARIADB))).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from `flow_diagram_overlay_group_entry` where `flow_diagram_overlay_group_entry`.`overlay_group_id` in (select `flow_diagram_overlay_group`.`id` from `flow_diagram_overlay_group` where `flow_diagram_overlay_group`.`flow_diagram_id` = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  void testDeleteOverlaysForDiagram4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteOverlaysForDiagramResult = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.POSTGRES))).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"flow_diagram_overlay_group_entry\" where \"flow_diagram_overlay_group_entry\".\"overlay_group_id\" in (select \"flow_diagram_overlay_group\".\"id\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"flow_diagram_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  void testDeleteOverlaysForDiagram5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteOverlaysForDiagramResult = (new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQLITE))).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from flow_diagram_overlay_group_entry where flow_diagram_overlay_group_entry.overlay_group_id in (select flow_diagram_overlay_group.id from flow_diagram_overlay_group where flow_diagram_overlay_group.flow_diagram_id = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Method under test: {@link FlowDiagramOverlayGroupDao#createOverlays(Set)}
   */
  @Test
  void testCreateOverlays() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, flowDiagramOverlayGroupDao.createOverlays(new HashSet<>()));
  }

  /**
   * Method under test: {@link FlowDiagramOverlayGroupDao#createOverlays(Set)}
   */
  @Test
  void testCreateOverlays2() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = new FlowDiagramOverlayGroupDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, flowDiagramOverlayGroupDao.createOverlays(new HashSet<>()));
  }
}
