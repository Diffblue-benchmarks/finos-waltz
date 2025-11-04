package org.finos.waltz.data.logical_flow;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.schema.tables.records.LogicalFlowRecord;
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

class LogicalFlowDaoDiffblueTest {
  /**
   * Method under test: {@link LogicalFlowDao#getByFlowExternalId(String)}
   */
  @Test
  void testGetByFlowExternalId() throws SQLException {
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
    LogicalFlow actualByFlowExternalId = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByFlowExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where \"logical_flow\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByFlowExternalId);
  }

  /**
   * Method under test: {@link LogicalFlowDao#findBySourcesAndTargets(List)}
   */
  @Test
  void testFindBySourcesAndTargets() {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertTrue(logicalFlowDao.findBySourcesAndTargets(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link LogicalFlowDao#findBySourcesAndTargets(List)}
   */
  @Test
  void testFindBySourcesAndTargets2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertTrue(logicalFlowDao.findBySourcesAndTargets(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDao#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  void testFindUpstreamFlowsForEntityReferences() throws SQLException {
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
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult = logicalFlowDao
        .findUpstreamFlowsForEntityReferences(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where (1 = 0 and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
  }

  /**
   * Method under test: {@link LogicalFlowDao#removeFlow(Long, String)}
   */
  @Test
  void testRemoveFlow() throws SQLException {
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
    int actualRemoveFlowResult = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .removeFlow(1L, "User");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"logical_flow\" set \"logical_flow\".\"entity_lifecycle_status\" = ?, \"logical_flow\".\"is_removed\" = ?, \"logical_flow\".\"last_updated_at\" = ?, \"logical_flow\".\"last_updated_by\" = ? where \"logical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(true));
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowDao#removeFlow(Long, String)}
   */
  @Test
  void testRemoveFlow2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualRemoveFlowResult = (new LogicalFlowDao(dsl)).removeFlow(1L, "User");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowDao#addFlows(Set, String)}
   */
  @Test
  void testAddFlows() throws SQLException {
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
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<LogicalFlow> actualAddFlowsResult = logicalFlowDao.addFlows(new HashSet<>(), "User");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where 1 = 0"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualAddFlowsResult.isEmpty());
  }

  /**
   * Method under test: {@link LogicalFlowDao#restoreFlow(long, String)}
   */
  @Test
  void testRestoreFlow() throws SQLException {
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
    boolean actualRestoreFlowResult = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .restoreFlow(1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"logical_flow\" set \"logical_flow\".\"entity_lifecycle_status\" = ?, \"logical_flow\".\"is_removed\" = ?, \"logical_flow\".\"last_updated_by\" = ?, \"logical_flow\".\"last_updated_at\" = ? where \"logical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(false));
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRestoreFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowDao#restoreFlow(long, String)}
   */
  @Test
  void testRestoreFlow2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualRestoreFlowResult = (new LogicalFlowDao(dsl)).restoreFlow(1L, "janedoe");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualRestoreFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowDao#getByFlowId(long)}
   */
  @Test
  void testGetByFlowId() throws SQLException {
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
    LogicalFlow actualByFlowId = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByFlowId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where \"logical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(13), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByFlowId);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDao#updateReadOnly(long, boolean, String)}
   */
  @Test
  void testUpdateReadOnly() throws SQLException {
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
    long actualUpdateReadOnlyResult = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateReadOnly(1L, true, "User");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"logical_flow\" set \"logical_flow\".\"is_readonly\" = ?, \"logical_flow\".\"last_updated_at\" = ?, \"logical_flow\".\"last_updated_by\" = ? where \"logical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement).setString(eq(3), eq("User"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUpdateReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDao#updateReadOnly(long, boolean, String)}
   */
  @Test
  void testUpdateReadOnly2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    long actualUpdateReadOnlyResult = (new LogicalFlowDao(dsl)).updateReadOnly(1L, true, "User");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1L, actualUpdateReadOnlyResult);
  }

  /**
   * Method under test: {@link LogicalFlowDao#findAllActive()}
   */
  @Test
  void testFindAllActive() throws SQLException {
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
    List<LogicalFlow> actualFindAllActiveResult = (new LogicalFlowDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAllActive();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where \"logical_flow\".\"entity_lifecycle_status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllActiveResult.isEmpty());
  }

  /**
   * Method under test: {@link LogicalFlowDao#findActiveByFlowIds(Collection)}
   */
  @Test
  void testFindActiveByFlowIds() throws SQLException {
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
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<LogicalFlow> actualFindActiveByFlowIdsResult = logicalFlowDao.findActiveByFlowIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where (\"logical_flow\".\"id\" in () and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link LogicalFlowDao#findAllByFlowIds(Collection)}
   */
  @Test
  void testFindAllByFlowIds() throws SQLException {
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
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<LogicalFlow> actualFindAllByFlowIdsResult = logicalFlowDao.findAllByFlowIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where (\"logical_flow\".\"id\" in () and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link LogicalFlowDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Integer actualCleanupOrphansResult = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult.intValue());
  }

  /**
   * Method under test: {@link LogicalFlowDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Integer actualCleanupOrphansResult = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult.intValue());
  }

  /**
   * Method under test: {@link LogicalFlowDao#cleanupSelfReferencingFlows()}
   */
  @Test
  void testCleanupSelfReferencingFlows() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupSelfReferencingFlowsResult = (new LogicalFlowDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).cleanupSelfReferencingFlows();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupSelfReferencingFlowsResult);
  }

  /**
   * Method under test: {@link LogicalFlowDao#cleanupSelfReferencingFlows()}
   */
  @Test
  void testCleanupSelfReferencingFlows2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupSelfReferencingFlowsResult = (new LogicalFlowDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).cleanupSelfReferencingFlows();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupSelfReferencingFlowsResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}
   */
  @Test
  void testCalculateAmendedFlowOperations() throws SQLException {
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
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    HashSet<Operation> operationsForFlow = new HashSet<>();

    // Act
    Set<Operation> actualCalculateAmendedFlowOperationsResult = logicalFlowDao
        .calculateAmendedFlowOperations(operationsForFlow, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCalculateAmendedFlowOperationsResult.isEmpty());
    assertSame(operationsForFlow, actualCalculateAmendedFlowOperationsResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}
   */
  @Test
  void testCalculateAmendedFlowOperations2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedFlowOperationsResult = logicalFlowDao
        .calculateAmendedFlowOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedFlowOperationsResult.size());
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Method under test:
   * {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}
   */
  @Test
  void testCalculateAmendedFlowOperations3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedFlowOperationsResult = logicalFlowDao
        .calculateAmendedFlowOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedFlowOperationsResult.size());
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.UPDATE));
  }
}
