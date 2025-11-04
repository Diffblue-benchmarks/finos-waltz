package org.finos.waltz.data.data_type_usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.data_type_usage.DataTypeUsage;
import org.finos.waltz.model.usage_info.UsageInfo;
import org.finos.waltz.model.usage_info.UsageKind;
import org.finos.waltz.schema.tables.records.DataTypeUsageRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.TransactionalRunnable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeUsageDaoDiffblueTest {
  /**
   * Method under test: {@link DataTypeUsageDao#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity() throws SQLException {
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
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<DataTypeUsage> actualFindForEntityResult = dataTypeUsageDao.findForEntity(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"data_type_usage\".\"entity_kind\", \"data_type_usage\".\"entity_id\", \"data_type_usage\".\"usage_kind\", \"data_type_usage\".\"description\", \"data_type_usage\".\"provenance\", \"data_type_usage\".\"is_selected\", \"data_type_usage\".\"data_type_id\" from \"data_type_usage\" where (\"data_type_usage\".\"entity_kind\" = ? and \"data_type_usage\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  void testFindForEntityAndDataType() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new UnsupportedOperationException("ref cannot be null"));
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeUsageDao.findForEntityAndDataType(ref, 1L));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  void testFindForEntityAndDataType2() throws SQLException {
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
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<DataTypeUsage> actualFindForEntityAndDataTypeResult = dataTypeUsageDao.findForEntityAndDataType(ref, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"data_type_usage\".\"entity_kind\", \"data_type_usage\".\"entity_id\", \"data_type_usage\".\"usage_kind\", \"data_type_usage\".\"description\", \"data_type_usage\".\"provenance\", \"data_type_usage\".\"is_selected\", \"data_type_usage\".\"data_type_id\" from \"data_type_usage\" where (\"data_type_usage\".\"entity_kind\" = ? and \"data_type_usage\".\"entity_id\" = ? and \"data_type_usage\".\"data_type_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindForEntityAndDataTypeResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#insertUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testInsertUsageInfo() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);

    // Act and Assert
    assertEquals(0, dataTypeUsageDao.insertUsageInfo(ref, 1L, new ArrayList<>()).length);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#insertUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testInsertUsageInfo2() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(mock(DSLContext.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    UsageInfo usageInfo = mock(UsageInfo.class);
    when(usageInfo.description()).thenThrow(new UnsupportedOperationException("ref cannot be null"));
    when(usageInfo.kind()).thenReturn(UsageKind.CONSUMER);

    ArrayList<UsageInfo> inserts = new ArrayList<>();
    inserts.add(usageInfo);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeUsageDao.insertUsageInfo(ref, 1L, inserts));
    verify(ref).id();
    verify(ref).kind();
    verify(usageInfo).description();
    verify(usageInfo).kind();
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testDeleteUsageInfo() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new UnsupportedOperationException("ref cannot be null"));
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testDeleteUsageInfo2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"data_type_usage\" where (\"data_type_usage\".\"entity_kind\" = ? and \"data_type_usage\".\"entity_id\" = ? and \"data_type_usage\".\"data_type_id\" = ? and \"data_type_usage\".\"usage_kind\" in ())"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertEquals(0, actualDeleteUsageInfoResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testDeleteUsageInfo3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>());

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteUsageInfoResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testDeleteUsageInfo4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    ArrayList<UsageKind> deletes = new ArrayList<>();
    deletes.add(UsageKind.CONSUMER);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, deletes);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteUsageInfoResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testDeleteUsageInfo5() throws DataAccessException {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    ArrayList<UsageKind> deletes = new ArrayList<>();
    deletes.add(UsageKind.DISTRIBUTOR);
    deletes.add(UsageKind.CONSUMER);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, deletes);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteUsageInfoResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#updateUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testUpdateUsageInfo() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);

    // Act and Assert
    assertEquals(0, dataTypeUsageDao.updateUsageInfo(ref, 1L, new ArrayList<>()).length);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#updateUsageInfo(EntityReference, Long, List)}
   */
  @Test
  void testUpdateUsageInfo2() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(mock(DSLContext.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    UsageInfo usageInfo = mock(UsageInfo.class);
    when(usageInfo.description()).thenThrow(new UnsupportedOperationException("ref cannot be null"));
    when(usageInfo.kind()).thenReturn(UsageKind.CONSUMER);

    ArrayList<UsageInfo> updates = new ArrayList<>();
    updates.add(usageInfo);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeUsageDao.updateUsageInfo(ref, 1L, updates));
    verify(ref).id();
    verify(ref).kind();
    verify(usageInfo).description();
    verify(usageInfo).kind();
  }

  /**
   * Method under test: {@link DataTypeUsageDao#recalculateForAllApplications()}
   */
  @Test
  void testRecalculateForAllApplications() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRecalculateForAllApplicationsResult = (new DataTypeUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).recalculateForAllApplications();

    // Assert
    verify(connection, atLeast(1)).commit();
    verify(connection, atLeast(1)).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualRecalculateForAllApplicationsResult);
  }

  /**
   * Method under test: {@link DataTypeUsageDao#recalculateForAllApplications()}
   */
  @Test
  void testRecalculateForAllApplications2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(false);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRecalculateForAllApplicationsResult = (new DataTypeUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).recalculateForAllApplications();

    // Assert
    verify(connection, atLeast(1)).commit();
    verify(connection, atLeast(1)).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualRecalculateForAllApplicationsResult);
  }

  /**
   * Method under test: {@link DataTypeUsageDao#recalculateForAllApplications()}
   */
  @Test
  void testRecalculateForAllApplications3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRecalculateForAllApplicationsResult = (new DataTypeUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).recalculateForAllApplications();

    // Assert
    verify(connection, atLeast(1)).commit();
    verify(connection, atLeast(1)).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualRecalculateForAllApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#recalculateForAppIdSelector(Select)}
   */
  @Test
  void testRecalculateForAppIdSelector() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    boolean actualRecalculateForAppIdSelectorResult = (new DataTypeUsageDao(dsl))
        .recalculateForAppIdSelector(mock(Select.class));

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualRecalculateForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageDao#recalculateForIdSelector(EntityKind, Select)}
   */
  @Test
  void testRecalculateForIdSelector() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    boolean actualRecalculateForIdSelectorResult = (new DataTypeUsageDao(dsl)).recalculateForIdSelector(EntityKind.ALL,
        mock(Select.class));

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualRecalculateForIdSelectorResult);
  }
}
