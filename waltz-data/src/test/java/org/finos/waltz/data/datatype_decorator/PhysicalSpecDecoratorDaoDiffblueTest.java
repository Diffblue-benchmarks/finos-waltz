package org.finos.waltz.data.datatype_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.finos.waltz.schema.tables.records.PhysicalSpecDataTypeRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertOnDuplicateStep;
import org.jooq.InsertSetStep;
import org.jooq.InsertValuesStep7;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecDecoratorDaoDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeDecorator actualByEntityIdAndDataTypeId = (new PhysicalSpecDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByEntityIdAndDataTypeId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_spec_data_type\".\"specification_id\", \"physical_spec_data_type\".\"data_type_id\", \"physical_spec_data_type\".\"provenance\", \"physical_spec_data_type\".\"last_updated_at\", \"physical_spec_data_type\".\"last_updated_by\", \"physical_spec_data_type\".\"is_readonly\", \"data_type\".\"name\" from \"physical_spec_data_type\" join \"data_type\" on \"physical_spec_data_type\".\"data_type_id\" = \"data_type\".\"id\" where (\"physical_spec_data_type\".\"specification_id\" = ? and \"physical_spec_data_type\".\"data_type_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
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
   * {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  void testGetByEntityIdAndDataTypeId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeDecorator actualByEntityIdAndDataTypeId = (new PhysicalSpecDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByEntityIdAndDataTypeId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_spec_data_type\".\"specification_id\", \"physical_spec_data_type\".\"data_type_id\", \"physical_spec_data_type\".\"provenance\", \"physical_spec_data_type\".\"last_updated_at\", \"physical_spec_data_type\".\"last_updated_by\", \"physical_spec_data_type\".\"is_readonly\", \"data_type\".\"name\" from \"physical_spec_data_type\" join \"data_type\" on \"physical_spec_data_type\".\"data_type_id\" = \"data_type\".\"id\" where (\"physical_spec_data_type\".\"specification_id\" = ? and \"physical_spec_data_type\".\"data_type_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).getTime();
    EntityReference entityReferenceResult = actualByEntityIdAndDataTypeId.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference decoratorEntityResult = actualByEntityIdAndDataTypeId.decoratorEntity();
    assertTrue(decoratorEntityResult instanceof ImmutableEntityReference);
    assertTrue(actualByEntityIdAndDataTypeId instanceof ImmutableDataTypeDecorator);
    LocalDateTime lastUpdatedAtResult = actualByEntityIdAndDataTypeId.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", actualByEntityIdAndDataTypeId.lastUpdatedBy());
    assertEquals("String", actualByEntityIdAndDataTypeId.provenance());
    assertNull(entityReferenceResult.description());
    assertNull(decoratorEntityResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, decoratorEntityResult.id());
    assertEquals(1L, actualByEntityIdAndDataTypeId.dataFlowId());
    assertEquals(1L, actualByEntityIdAndDataTypeId.dataTypeId());
    assertEquals(EntityKind.DATA_TYPE, decoratorEntityResult.kind());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult.entityLifecycleStatus());
    assertTrue(actualByEntityIdAndDataTypeId.isReadonly());
  }

  /**
   * Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  void testFindByEntityId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<DataTypeDecorator> actualFindByEntityIdResult = (new PhysicalSpecDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByEntityId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_spec_data_type\".\"specification_id\", \"physical_spec_data_type\".\"data_type_id\", \"physical_spec_data_type\".\"provenance\", \"physical_spec_data_type\".\"last_updated_at\", \"physical_spec_data_type\".\"last_updated_by\", \"physical_spec_data_type\".\"is_readonly\", \"data_type\".\"name\" from \"physical_spec_data_type\" join \"data_type\" on \"physical_spec_data_type\".\"data_type_id\" = \"data_type\".\"id\" where \"physical_spec_data_type\".\"specification_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
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
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.provenance());
    assertNull(entityReferenceResult.description());
    assertNull(decoratorEntityResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, decoratorEntityResult.id());
    assertEquals(1L, getResult.dataFlowId());
    assertEquals(1L, getResult.dataTypeId());
    assertEquals(EntityKind.DATA_TYPE, decoratorEntityResult.kind());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult.entityLifecycleStatus());
    assertTrue(getResult.isReadonly());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#findByAppIdSelector(Select)}
   */
  @Test
  void testFindByAppIdSelector() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)))
            .findByAppIdSelector(mock(Select.class)));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#findByFlowIdSelector(Select)}
   */
  @Test
  void testFindByFlowIdSelector() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)))
            .findByFlowIdSelector(mock(Select.class)));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#findByDataTypeIdSelector(Select)}
   */
  @Test
  void testFindByDataTypeIdSelector() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)))
            .findByDataTypeIdSelector(mock(Select.class)));
  }

  /**
   * Method under test: {@link PhysicalSpecDecoratorDao#findByFlowIds(Collection)}
   */
  @Test
  void testFindByFlowIds() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(
        new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> physicalSpecDecoratorDao.findByFlowIds(new ArrayList<>()));
  }

  /**
   * Method under test: {@link PhysicalSpecDecoratorDao#addDecorators(Collection)}
   */
  @Test
  void testAddDecorators() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(
        new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, physicalSpecDecoratorDao.addDecorators(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link PhysicalSpecDecoratorDao#addDecorators(Collection)}
   */
  @Test
  void testAddDecorators2() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, physicalSpecDecoratorDao.addDecorators(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link PhysicalSpecDecoratorDao#addDecorators(Collection)}
   */
  @Test
  void testAddDecorators3() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(mock(DSLContext.class));
    DataTypeDecorator dataTypeDecorator = mock(DataTypeDecorator.class);
    when(dataTypeDecorator.entityReference()).thenReturn(null);
    DataTypeDecorator dataTypeDecorator2 = mock(DataTypeDecorator.class);
    when(dataTypeDecorator2.entityReference()).thenReturn(null);
    DataTypeDecorator dataTypeDecorator3 = mock(DataTypeDecorator.class);
    when(dataTypeDecorator3.entityReference())
        .thenThrow(new UnsupportedOperationException("specificationDataTypes cannot be null"));

    ArrayList<DataTypeDecorator> specificationDataTypes = new ArrayList<>();
    specificationDataTypes.add(dataTypeDecorator3);
    specificationDataTypes.add(dataTypeDecorator2);
    specificationDataTypes.add(dataTypeDecorator);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.addDecorators(specificationDataTypes));
    verify(dataTypeDecorator3).entityReference();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}
   */
  @Test
  void testRemoveDataTypes() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.removeDataTypes(null, new ArrayList<>()));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}
   */
  @Test
  void testRemoveDataTypes2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any())).thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    EntityReference associatedEntityRef = mock(EntityReference.class);
    when(associatedEntityRef.id()).thenReturn(1L);

    // Act
    int actualRemoveDataTypesResult = physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>());

    // Assert
    verify(associatedEntityRef).id();
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}
   */
  @Test
  void testRemoveDataTypes3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any())).thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    EntityReference associatedEntityRef = mock(EntityReference.class);
    when(associatedEntityRef.id()).thenReturn(1L);

    ArrayList<Long> dataTypeIds = new ArrayList<>();
    dataTypeIds.add(0L);

    // Act
    int actualRemoveDataTypesResult = physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, dataTypeIds);

    // Assert
    verify(associatedEntityRef).id();
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}
   */
  @Test
  void testRemoveDataTypes4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any())).thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    EntityReference associatedEntityRef = mock(EntityReference.class);
    when(associatedEntityRef.id()).thenReturn(1L);

    ArrayList<Long> dataTypeIds = new ArrayList<>();
    dataTypeIds.add(1L);
    dataTypeIds.add(0L);

    // Act
    int actualRemoveDataTypesResult = physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, dataTypeIds);

    // Assert
    verify(associatedEntityRef).id();
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#findByLogicalFlowIdSelector(Select)}
   */
  @Test
  void testFindByLogicalFlowIdSelector() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)))
            .findByLogicalFlowIdSelector(mock(Select.class)));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  void testRippleDataTypesToLogicalFlows() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualRippleDataTypesToLogicalFlowsResult = (new PhysicalSpecDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).rippleDataTypesToLogicalFlows();

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"logical_flow_decorator\" (\"logical_flow_id\", \"decorator_entity_kind\", \"decorator_entity_id\", \"rating\", \"provenance\", \"last_updated_at\", \"last_updated_by\") select distinct \"physical_flow\".\"logical_flow_id\", ?, \"physical_spec_data_type\".\"data_type_id\", ?, ?, ?, ? from \"physical_spec_data_type\" join \"data_type\" on (\"physical_spec_data_type\".\"data_type_id\" = \"data_type\".\"id\" and \"data_type\".\"unknown\" = false and \"data_type\".\"deprecated\" = false) join \"physical_specification\" on (\"physical_spec_data_type\".\"specification_id\" = \"physical_specification\".\"id\" and \"physical_specification\".\"is_removed\" = false) join \"physical_flow\" on (\"physical_spec_data_type\".\"specification_id\" = \"physical_flow\".\"specification_id\" and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" = ?) join \"logical_flow\" on (\"physical_flow\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" = ?) left outer join \"logical_flow_decorator\" on (\"logical_flow_decorator\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow_decorator\".\"decorator_entity_id\" = \"physical_spec_data_type\".\"data_type_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) where \"logical_flow_decorator\".\"logical_flow_id\" is null"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRippleDataTypesToLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  void testRippleDataTypesToLogicalFlows2() throws DataAccessException {
    // Arrange
    InsertOnDuplicateStep<LogicalFlowDecoratorRecord> insertOnDuplicateStep = mock(InsertOnDuplicateStep.class);
    when(insertOnDuplicateStep.execute()).thenReturn(1);
    InsertValuesStep7<LogicalFlowDecoratorRecord, Object, Object, Object, Object, Object, Object, Object> insertValuesStep7 = mock(
        InsertValuesStep7.class);
    when(insertValuesStep7
        .select(Mockito.<Select<Record7<Object, Object, Object, Object, Object, Object, Object>>>any()))
            .thenReturn(insertOnDuplicateStep);
    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any())).thenReturn(insertValuesStep7);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualRippleDataTypesToLogicalFlowsResult = (new PhysicalSpecDecoratorDao(dsl)).rippleDataTypesToLogicalFlows();

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetStep).columns(isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class), isA(Field.class), isA(Field.class));
    verify(insertValuesStep7).select(isA(Select.class));
    verify(insertOnDuplicateStep).execute();
    assertEquals(1, actualRippleDataTypesToLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  void testRippleDataTypesToLogicalFlows3() {
    // Arrange
    InsertValuesStep7<LogicalFlowDecoratorRecord, Object, Object, Object, Object, Object, Object, Object> insertValuesStep7 = mock(
        InsertValuesStep7.class);
    when(insertValuesStep7
        .select(Mockito.<Select<Record7<Object, Object, Object, Object, Object, Object, Object>>>any()))
            .thenThrow(new UnsupportedOperationException("waltz"));
    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any())).thenReturn(insertValuesStep7);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(insertSetStep);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecDecoratorDao(dsl)).rippleDataTypesToLogicalFlows());
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetStep).columns(isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class), isA(Field.class), isA(Field.class));
    verify(insertValuesStep7).select(isA(Select.class));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  void testRippleDataTypesToLogicalFlows4() {
    // Arrange
    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any())).thenThrow(new UnsupportedOperationException("waltz"));
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(insertSetStep);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecDecoratorDao(dsl)).rippleDataTypesToLogicalFlows());
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetStep).columns(isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class), isA(Field.class), isA(Field.class));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  void testRippleDataTypesToLogicalFlows5() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenThrow(new UnsupportedOperationException("waltz"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecDecoratorDao(dsl)).rippleDataTypesToLogicalFlows());
    verify(dsl).insertInto(isA(Table.class));
  }
}
