package org.finos.waltz.data.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.flow_diagram.FlowDiagramEntity;
import org.finos.waltz.schema.tables.records.FlowDiagramEntityRecord;
import org.jooq.Condition;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowDiagramEntityDaoDiffblueTest {
  /**
   * Method under test: {@link FlowDiagramEntityDao#findForDiagram(long)}
   */
  @Test
  void testFindForDiagram() throws SQLException {
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
    List<FlowDiagramEntity> actualFindForDiagramResult = (new FlowDiagramEntityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"fde\".\"diagram_id\", \"fde\".\"entity_id\", \"fde\".\"entity_kind\", \"fde\".\"is_notable\", case when \"fde\".\"entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"logical_flow\" where \"logical_flow\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"physical_flow\".\"name\" from \"physical_flow\" where \"physical_flow\".\"id\" = \"fde\".\"entity_id\") end, case when \"fde\".\"entity_kind\" = ? then (select \"application\".\"entity_lifecycle_status\" from \"application\" where \"application\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"actor\" where \"actor\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"change_initiative\" where \"change_initiative\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"data_type\" where \"data_type\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"end_user_application\" where \"end_user_application\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"logical_flow\".\"entity_lifecycle_status\" from \"logical_flow\" where \"logical_flow\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"measurable\".\"entity_lifecycle_status\" from \"measurable\" where \"measurable\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"physical_flow\".\"entity_lifecycle_status\" from \"physical_flow\" where \"physical_flow\".\"id\" = \"fde\".\"entity_id\") end from \"flow_diagram_entity\" \"fde\" where \"fde\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(22), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForDiagramResult.isEmpty());
  }

  /**
   * Method under test: {@link FlowDiagramEntityDao#createEntities(List)}
   */
  @Test
  void testCreateEntities() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, flowDiagramEntityDao.createEntities(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link FlowDiagramEntityDao#createEntities(List)}
   */
  @Test
  void testCreateEntities2() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, flowDiagramEntityDao.createEntities(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link FlowDiagramEntityDao#deleteForDiagram(long)}
   */
  @Test
  void testDeleteForDiagram() throws SQLException {
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
    int actualDeleteForDiagramResult = (new FlowDiagramEntityDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"flow_diagram_entity\" where (\"flow_diagram_entity\".\"diagram_id\" = ? and \"flow_diagram_entity\".\"entity_kind\" not in (?, ?, ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForDiagramResult);
  }

  /**
   * Method under test: {@link FlowDiagramEntityDao#deleteForDiagram(long)}
   */
  @Test
  void testDeleteForDiagram2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<FlowDiagramEntityRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<FlowDiagramEntityRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForDiagramResult = (new FlowDiagramEntityDao(dsl)).deleteForDiagram(1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualDeleteForDiagramResult);
  }

  /**
   * Method under test: {@link FlowDiagramEntityDao#deleteForDiagram(long)}
   */
  @Test
  void testDeleteForDiagram3() throws SQLException {
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
    int actualDeleteForDiagramResult = (new FlowDiagramEntityDao(
        new DefaultDSLContext(connection, SQLDialect.POSTGRES))).deleteForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"flow_diagram_entity\" where (\"flow_diagram_entity\".\"diagram_id\" = ? and \"flow_diagram_entity\".\"entity_kind\" not in (?, ?, ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityDao#deleteEntityForDiagram(long, EntityReference)}
   */
  @Test
  void testDeleteEntityForDiagram() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteUsingStep<FlowDiagramEntityRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<FlowDiagramEntityRecord>>any())).thenReturn(deleteUsingStep);
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDeleteEntityForDiagramResult = flowDiagramEntityDao.deleteEntityForDiagram(1L, entityReference);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualDeleteEntityForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityDao#deleteEntityForDiagram(long, EntityReference)}
   */
  @Test
  void testDeleteEntityForDiagram2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteUsingStep<FlowDiagramEntityRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<FlowDiagramEntityRecord>>any())).thenReturn(deleteUsingStep);
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDeleteEntityForDiagramResult = flowDiagramEntityDao.deleteEntityForDiagram(1L, entityReference);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertFalse(actualDeleteEntityForDiagramResult);
  }

  /**
   * Method under test: {@link FlowDiagramEntityDao#clone(long, Long)}
   */
  @Test
  void testClone() throws SQLException {
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
    (new FlowDiagramEntityDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).clone(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"fde\".\"diagram_id\", \"fde\".\"entity_id\", \"fde\".\"entity_kind\", \"fde\".\"is_notable\", case when \"fde\".\"entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"logical_flow\" where \"logical_flow\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"physical_flow\".\"name\" from \"physical_flow\" where \"physical_flow\".\"id\" = \"fde\".\"entity_id\") end, case when \"fde\".\"entity_kind\" = ? then (select \"application\".\"entity_lifecycle_status\" from \"application\" where \"application\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"actor\" where \"actor\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"change_initiative\" where \"change_initiative\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"data_type\" where \"data_type\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select ? from \"end_user_application\" where \"end_user_application\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"logical_flow\".\"entity_lifecycle_status\" from \"logical_flow\" where \"logical_flow\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"measurable\".\"entity_lifecycle_status\" from \"measurable\" where \"measurable\".\"id\" = \"fde\".\"entity_id\") when \"fde\".\"entity_kind\" = ? then (select \"physical_flow\".\"entity_lifecycle_status\" from \"physical_flow\" where \"physical_flow\".\"id\" = \"fde\".\"entity_id\") end from \"flow_diagram_entity\" \"fde\" where \"fde\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(22), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }
}
