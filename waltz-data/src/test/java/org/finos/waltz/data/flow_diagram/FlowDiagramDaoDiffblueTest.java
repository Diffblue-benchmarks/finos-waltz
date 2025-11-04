package org.finos.waltz.data.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.flow_diagram.FlowDiagram;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagram;
import org.finos.waltz.schema.tables.records.FlowDiagramRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowDiagramDaoDiffblueTest {
  /**
   * Method under test: {@link FlowDiagramDao#getById(long)}
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
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    FlowDiagram actualById = (new FlowDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram\".\"id\", \"flow_diagram\".\"name\", \"flow_diagram\".\"description\", \"flow_diagram\".\"layout_data\", \"flow_diagram\".\"last_updated_at\", \"flow_diagram\".\"last_updated_by\", \"flow_diagram\".\"is_removed\", \"flow_diagram\".\"editor_role\" from \"flow_diagram\" where (\"flow_diagram\".\"id\" = ? and \"flow_diagram\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(false));
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
   * Method under test: {@link FlowDiagramDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    FlowDiagram actualById = (new FlowDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram\".\"id\", \"flow_diagram\".\"name\", \"flow_diagram\".\"description\", \"flow_diagram\".\"layout_data\", \"flow_diagram\".\"last_updated_at\", \"flow_diagram\".\"last_updated_by\", \"flow_diagram\".\"is_removed\", \"flow_diagram\".\"editor_role\" from \"flow_diagram\" where (\"flow_diagram\".\"id\" = ? and \"flow_diagram\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(false));
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(7));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(5));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    assertTrue(actualById instanceof ImmutableFlowDiagram);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.lastUpdatedBy());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.layoutData());
    assertEquals(EntityKind.FLOW_DIAGRAM, actualById.kind());
    assertTrue(actualById.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link FlowDiagramDao#updateName(long, String)}
   */
  @Test
  void testUpdateName() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualUpdateNameResult = (new FlowDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateName(1L, "Name");

    // Assert
    verify(connection).prepareStatement(
        eq("update \"flow_diagram\" set \"flow_diagram\".\"name\" = ? where \"flow_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link FlowDiagramDao#updateName(long, String)}
   */
  @Test
  void testUpdateName2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<FlowDiagramRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<FlowDiagramRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateNameResult = (new FlowDiagramDao(dsl)).updateName(1L, "Name");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link FlowDiagramDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualUpdateDescriptionResult = (new FlowDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateDescription(1L, "Des");

    // Assert
    verify(connection).prepareStatement(
        eq("update \"flow_diagram\" set \"flow_diagram\".\"description\" = ? where \"flow_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("Des"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Method under test: {@link FlowDiagramDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<FlowDiagramRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<FlowDiagramRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateDescriptionResult = (new FlowDiagramDao(dsl)).updateDescription(1L, "Des");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test: {@link FlowDiagramDao#deleteById(long, String)}
   */
  @Test
  void testDeleteById() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteByIdResult = (new FlowDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteById(1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"flow_diagram\" set \"flow_diagram\".\"is_removed\" = ?, \"flow_diagram\".\"last_updated_at\" = ?, \"flow_diagram\".\"last_updated_by\" = ? where \"flow_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement).setString(eq(3), eq("janedoe"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link FlowDiagramDao#deleteById(long, String)}
   */
  @Test
  void testDeleteById2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<FlowDiagramRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<FlowDiagramRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualDeleteByIdResult = (new FlowDiagramDao(dsl)).deleteById(1L, "janedoe");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link FlowDiagramDao#clone(long, String, String)}
   */
  @Test
  void testClone() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    ResultSet resultSet2 = mock(ResultSet.class);
    when(resultSet2.getLong(anyInt())).thenReturn(1L);
    when(resultSet2.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet2).close();
    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.executeUpdate()).thenReturn(1);
    when(preparedStatement2.getGeneratedKeys()).thenReturn(resultSet2);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement2).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement2);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Long actualCloneResult = (new FlowDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).clone(1L,
        "New Name", "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram\".\"id\", \"flow_diagram\".\"name\", \"flow_diagram\".\"description\", \"flow_diagram\".\"layout_data\", \"flow_diagram\".\"last_updated_at\", \"flow_diagram\".\"last_updated_by\", \"flow_diagram\".\"is_removed\", \"flow_diagram\".\"editor_role\" from \"flow_diagram\" where (\"flow_diagram\".\"id\" = ? and \"flow_diagram\".\"is_removed\" = ?)"));
    verify(connection).prepareStatement(eq(
        "insert into \"flow_diagram\" (\"name\", \"description\", \"layout_data\", \"last_updated_at\", \"last_updated_by\", \"is_removed\") values (?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).execute();
    verify(preparedStatement2).executeUpdate();
    verify(preparedStatement).setBoolean(eq(2), eq(false));
    verify(preparedStatement2).setBoolean(eq(6), eq(true));
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement2).setTimestamp(eq(4), isA(Timestamp.class));
    verify(resultSet2).close();
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(7));
    verify(resultSet2).getLong(eq(1));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(5));
    verify(resultSet2, atLeast(1)).next();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement2).close();
    verify(preparedStatement).close();
    verify(preparedStatement2).getGeneratedKeys();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement2).getWarnings();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    assertEquals(1L, actualCloneResult.longValue());
  }
}
