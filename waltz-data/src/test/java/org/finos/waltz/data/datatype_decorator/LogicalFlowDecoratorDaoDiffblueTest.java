package org.finos.waltz.data.datatype_decorator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.FlowDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalFlowDecoratorDaoDiffblueTest {
  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  void testGetByEntityIdAndDataTypeId() throws SQLException {
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
    DataTypeDecorator actualByEntityIdAndDataTypeId = (new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByEntityIdAndDataTypeId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByEntityIdAndDataTypeId);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  void testGetByEntityIdAndDataTypeId2() throws SQLException {
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeDecorator actualByEntityIdAndDataTypeId = (new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByEntityIdAndDataTypeId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    EntityReference entityReferenceResult = actualByEntityIdAndDataTypeId.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference decoratorEntityResult = actualByEntityIdAndDataTypeId.decoratorEntity();
    assertTrue(decoratorEntityResult instanceof ImmutableEntityReference);
    assertTrue(actualByEntityIdAndDataTypeId instanceof ImmutableDataTypeDecorator);
    LocalDateTime lastUpdatedAtResult = actualByEntityIdAndDataTypeId.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", actualByEntityIdAndDataTypeId.lastUpdatedBy());
    assertEquals("String", actualByEntityIdAndDataTypeId.provenance());
    assertNull(entityReferenceResult.description());
    assertNull(decoratorEntityResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, decoratorEntityResult.id());
    assertEquals(1L, actualByEntityIdAndDataTypeId.dataFlowId());
    assertEquals(1L, actualByEntityIdAndDataTypeId.dataTypeId());
    assertEquals(EntityKind.DATA_TYPE, decoratorEntityResult.kind());
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult.entityLifecycleStatus());
    assertTrue(actualByEntityIdAndDataTypeId.isReadonly());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}
   */
  @Test
  void testFindByFlowIds() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<DataTypeDecorator> actualFindByFlowIdsResult = logicalFlowDecoratorDao.findByFlowIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in ())"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(1, actualFindByFlowIdsResult.size());
  }

  /**
   * Method under test: {@link LogicalFlowDecoratorDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<DataTypeDecorator> actualFindAllResult = (new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindAllResult.size());
    DataTypeDecorator getResult = actualFindAllResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference decoratorEntityResult = getResult.decoratorEntity();
    assertTrue(decoratorEntityResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableDataTypeDecorator);
    DataTypeDecorator getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableDataTypeDecorator);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.provenance());
    assertNull(entityReferenceResult.description());
    assertNull(decoratorEntityResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, decoratorEntityResult.id());
    assertEquals(1L, getResult.dataFlowId());
    assertEquals(1L, getResult.dataTypeId());
    assertEquals(EntityKind.DATA_TYPE, decoratorEntityResult.kind());
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult.entityLifecycleStatus());
    assertTrue(getResult.isReadonly());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link LogicalFlowDecoratorDao#findByEntityId(long)}
   */
  @Test
  void testFindByEntityId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<DataTypeDecorator> actualFindByEntityIdResult = (new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByEntityId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where \"logical_flow_decorator\".\"logical_flow_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindByEntityIdResult.size());
    DataTypeDecorator getResult = actualFindByEntityIdResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference decoratorEntityResult = getResult.decoratorEntity();
    assertTrue(decoratorEntityResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableDataTypeDecorator);
    DataTypeDecorator getResult2 = actualFindByEntityIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableDataTypeDecorator);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.provenance());
    assertNull(entityReferenceResult.description());
    assertNull(decoratorEntityResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, decoratorEntityResult.id());
    assertEquals(1L, getResult.dataFlowId());
    assertEquals(1L, getResult.dataTypeId());
    assertEquals(EntityKind.DATA_TYPE, decoratorEntityResult.kind());
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult.entityLifecycleStatus());
    assertTrue(getResult.isReadonly());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}
   */
  @Test
  void testRemoveDataTypes() throws DataAccessException {
    // Arrange
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(deleteUsingStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    EntityReference associatedEntityRef = mock(EntityReference.class);
    when(associatedEntityRef.id()).thenReturn(1L);

    // Act
    int actualRemoveDataTypesResult = logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>());

    // Assert
    verify(associatedEntityRef).id();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}
   */
  @Test
  void testRemoveDataTypes2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(deleteUsingStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    EntityReference associatedEntityRef = mock(EntityReference.class);
    when(associatedEntityRef.id()).thenReturn(1L);

    ArrayList<Long> dataTypeIds = new ArrayList<>();
    dataTypeIds.add(-1L);

    // Act
    int actualRemoveDataTypesResult = logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, dataTypeIds);

    // Assert
    verify(associatedEntityRef).id();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}
   */
  @Test
  void testRemoveDataTypes3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(deleteUsingStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    EntityReference associatedEntityRef = mock(EntityReference.class);
    when(associatedEntityRef.id()).thenReturn(1L);

    ArrayList<Long> dataTypeIds = new ArrayList<>();
    dataTypeIds.add(1L);
    dataTypeIds.add(-1L);

    // Act
    int actualRemoveDataTypesResult = logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, dataTypeIds);

    // Assert
    verify(associatedEntityRef).id();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Method under test: {@link LogicalFlowDecoratorDao#addDecorators(Collection)}
   */
  @Test
  void testAddDecorators() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int[] actualAddDecoratorsResult = logicalFlowDecoratorDao.addDecorators(new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Method under test: {@link LogicalFlowDecoratorDao#addDecorators(Collection)}
   */
  @Test
  void testAddDecorators2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    int[] actualAddDecoratorsResult = logicalFlowDecoratorDao.addDecorators(new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Method under test: {@link LogicalFlowDecoratorDao#updateDecorators(Set)}
   */
  @Test
  void testUpdateDecorators() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, logicalFlowDecoratorDao.updateDecorators(new HashSet<>()).length);
  }

  /**
   * Method under test: {@link LogicalFlowDecoratorDao#updateDecorators(Set)}
   */
  @Test
  void testUpdateDecorators2() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, logicalFlowDecoratorDao.updateDecorators(new HashSet<>()).length);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#updateRatingsByCondition(AuthoritativenessRatingValue, Condition)}
   */
  @Test
  void testUpdateRatingsByCondition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateRatingsByConditionResult = logicalFlowDecoratorDao
        .updateRatingsByCondition(AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = ? where \"application\".\"entity_lifecycle_status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRatingsByConditionResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#updateRatingsByCondition(AuthoritativenessRatingValue, Condition)}
   */
  @Test
  void testUpdateRatingsByCondition2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowDecoratorRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<LogicalFlowDecoratorRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(updateSetFirstStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    int actualUpdateRatingsByConditionResult = logicalFlowDecoratorDao
        .updateRatingsByCondition(AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateRatingsByConditionResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#resetRatingsAndFlowClassificationRulesCondition(Condition)}
   */
  @Test
  void testResetRatingsAndFlowClassificationRulesCondition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualResetRatingsAndFlowClassificationRulesConditionResult = (new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .resetRatingsAndFlowClassificationRulesCondition(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = ?, \"logical_flow_decorator\".\"flow_classification_rule_id\" = ?, \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\" = ? where \"application\".\"entity_lifecycle_status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualResetRatingsAndFlowClassificationRulesConditionResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#resetRatingsAndFlowClassificationRulesCondition(Condition)}
   */
  @Test
  void testResetRatingsAndFlowClassificationRulesCondition2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowDecoratorRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.setNull(Mockito.<Field<Object>>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.setNull(Mockito.<Field<Object>>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<LogicalFlowDecoratorRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualResetRatingsAndFlowClassificationRulesConditionResult = (new LogicalFlowDecoratorDao(dsl))
        .resetRatingsAndFlowClassificationRulesCondition(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).setNull(isA(Field.class));
    verify(updateSetMoreStep2).setNull(isA(Field.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualResetRatingsAndFlowClassificationRulesConditionResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorDao#fetchFlowDataTypePopulation(Condition)}
   */
  @Test
  void testFetchFlowDataTypePopulation() throws SQLException {
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
    Set<FlowDataType> actualFetchFlowDataTypePopulationResult = (new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).fetchFlowDataTypePopulation(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"id\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"target_entity_kind\", coalesce(\"srcApp\".\"organisational_unit_id\", \"srcEuda\".\"organisational_unit_id\") \"srcOU\", coalesce(\"targetApp\".\"organisational_unit_id\", \"targetEuda\".\"organisational_unit_id\") \"targetOU\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"target_inbound_rating\" from \"logical_flow\" join \"logical_flow_decorator\" on (\"logical_flow_decorator\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) left outer join \"application\" \"srcApp\" on (\"srcApp\".\"id\" = \"logical_flow\".\"source_entity_id\" and \"logical_flow\".\"source_entity_kind\" = ?) left outer join \"application\" \"targetApp\" on (\"targetApp\".\"id\" = \"logical_flow\".\"target_entity_id\" and \"logical_flow\".\"target_entity_kind\" = ?) left outer join \"end_user_application\" \"srcEuda\" on (\"srcEuda\".\"id\" = \"logical_flow\".\"source_entity_id\" and \"logical_flow\".\"source_entity_kind\" = ?) left outer join \"end_user_application\" \"targetEuda\" on (\"targetEuda\".\"id\" = \"logical_flow\".\"target_entity_id\" and \"logical_flow\".\"target_entity_kind\" = ?) where (\"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" = ? and \"application\".\"entity_lifecycle_status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFetchFlowDataTypePopulationResult.isEmpty());
  }
}
