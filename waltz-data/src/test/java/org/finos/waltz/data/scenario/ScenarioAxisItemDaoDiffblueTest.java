package org.finos.waltz.data.scenario;

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
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.AxisOrientation;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.scenario.ScenarioAxisItem;
import org.finos.waltz.schema.tables.records.ScenarioAxisItemRecord;
import org.jooq.Condition;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScenarioAxisItemDaoDiffblueTest {
  /**
   * Method under test: {@link ScenarioAxisItemDao#findForScenarioId(long)}
   */
  @Test
  void testFindForScenarioId() throws SQLException {
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
    Collection<ScenarioAxisItem> actualFindForScenarioIdResult = (new ScenarioAxisItemDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForScenarioId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"scenario_axis_item\".\"id\", \"scenario_axis_item\".\"orientation\", \"scenario_axis_item\".\"scenario_id\", \"scenario_axis_item\".\"position\", \"scenario_axis_item\".\"domain_item_kind\", \"scenario_axis_item\".\"domain_item_id\", case when \"scenario_axis_item\".\"domain_item_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"scenario_axis_item\".\"domain_item_id\") end from \"scenario_axis_item\" where \"scenario_axis_item\".\"scenario_id\" = ? order by \"scenario_axis_item\".\"position\", case when \"scenario_axis_item\".\"domain_item_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"scenario_axis_item\".\"domain_item_id\") end"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("MEASURABLE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForScenarioIdResult instanceof List);
    assertTrue(actualFindForScenarioIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemDao#remove(long, AxisOrientation, EntityReference)}
   */
  @Test
  void testRemove() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<ScenarioAxisItemRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ScenarioAxisItemRecord>>any())).thenReturn(deleteUsingStep);
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(dsl);
    EntityReference domainItem = mock(EntityReference.class);
    when(domainItem.id()).thenReturn(1L);
    when(domainItem.kind()).thenReturn(EntityKind.ALL);

    // Act
    Boolean actualRemoveResult = scenarioAxisItemDao.remove(1L, AxisOrientation.ROW, domainItem);

    // Assert
    verify(domainItem).id();
    verify(domainItem).kind();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemDao#remove(long, AxisOrientation, EntityReference)}
   */
  @Test
  void testRemove2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<ScenarioAxisItemRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<ScenarioAxisItemRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ScenarioAxisItemRecord>>any())).thenReturn(deleteUsingStep);
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(dsl);
    EntityReference domainItem = mock(EntityReference.class);
    when(domainItem.id()).thenReturn(1L);
    when(domainItem.kind()).thenReturn(EntityKind.ALL);

    // Act
    Boolean actualRemoveResult = scenarioAxisItemDao.remove(1L, AxisOrientation.ROW, domainItem);

    // Assert
    verify(domainItem).id();
    verify(domainItem).kind();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemDao#findForScenarioAndOrientation(long, AxisOrientation)}
   */
  @Test
  void testFindForScenarioAndOrientation() throws SQLException {
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
    Collection<ScenarioAxisItem> actualFindForScenarioAndOrientationResult = (new ScenarioAxisItemDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForScenarioAndOrientation(1L, AxisOrientation.ROW);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"scenario_axis_item\".\"id\", \"scenario_axis_item\".\"orientation\", \"scenario_axis_item\".\"scenario_id\", \"scenario_axis_item\".\"position\", \"scenario_axis_item\".\"domain_item_kind\", \"scenario_axis_item\".\"domain_item_id\", case when \"scenario_axis_item\".\"domain_item_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"scenario_axis_item\".\"domain_item_id\") end from \"scenario_axis_item\" where (\"scenario_axis_item\".\"scenario_id\" = ? and \"scenario_axis_item\".\"orientation\" = ?) order by \"scenario_axis_item\".\"position\", case when \"scenario_axis_item\".\"domain_item_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"scenario_axis_item\".\"domain_item_id\") end"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForScenarioAndOrientationResult instanceof List);
    assertTrue(actualFindForScenarioAndOrientationResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemDao#reorder(long, AxisOrientation, List)}
   */
  @Test
  void testReorder() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, scenarioAxisItemDao.reorder(1L, AxisOrientation.ROW, new ArrayList<>()).length);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemDao#reorder(long, AxisOrientation, List)}
   */
  @Test
  void testReorder2() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = new ScenarioAxisItemDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, scenarioAxisItemDao.reorder(1L, AxisOrientation.ROW, new ArrayList<>()).length);
  }
}
