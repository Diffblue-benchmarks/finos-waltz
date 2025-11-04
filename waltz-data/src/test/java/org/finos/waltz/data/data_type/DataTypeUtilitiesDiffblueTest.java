package org.finos.waltz.data.data_type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.datatype.DataTypeMigrationResult;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult;
import org.finos.waltz.schema.tables.records.LogicalFlowRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link DataTypeUtilities#changeParent(DSLContext, String, String)}
   */
  @Test
  void testChangeParent() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeParentResult = DataTypeUtilities.changeParent(new DefaultDSLContext(connection, SQLDialect.SQL99),
        "Child Code", "New Parent Code");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setNull(eq(2), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(eq(1), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualChangeParentResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#changeParent(DSLContext, String, String)}
   */
  @Test
  void testChangeParent2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeParentResult = DataTypeUtilities.changeParent(new DefaultDSLContext(connection, SQLDialect.SQL99),
        "Child Code", "New Parent Code");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(3L));
    verify(preparedStatement, atLeast(1)).setString(eq(1), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getUpdateCount();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(3L, actualChangeParentResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#changeParent(DSLContext, String, String)}
   */
  @Test
  void testChangeParent3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeParentResult = DataTypeUtilities.changeParent(new DefaultDSLContext(connection, SQLDialect.CUBRID),
        "Child Code", "New Parent Code");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setNull(eq(2), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(eq(1), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualChangeParentResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#getAllLogicalFlowsBySourceTargetMap(DSLContext)}
   */
  @Test
  void testGetAllLogicalFlowsBySourceTargetMap() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<Tuple2<EntityReference, EntityReference>, LogicalFlowRecord> actualAllLogicalFlowsBySourceTargetMap = DataTypeUtilities
        .getAllLogicalFlowsBySourceTargetMap(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\" from \"logical_flow\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualAllLogicalFlowsBySourceTargetMap.isEmpty());
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#getLogicalFlowToPhysicalSpecId(DSLContext)}
   */
  @Test
  void testGetLogicalFlowToPhysicalSpecId() throws SQLException {
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
    Map<Long, Set<Long>> actualLogicalFlowToPhysicalSpecId = DataTypeUtilities
        .getLogicalFlowToPhysicalSpecId(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_flow\".\"logical_flow_id\", \"physical_flow\".\"specification_id\" from \"physical_flow\" where (\"physical_flow\".\"is_removed\" = ? and \"physical_flow\".\"entity_lifecycle_status\" <> ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setString(eq(2), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualLogicalFlowToPhysicalSpecId.size());
    Set<Long> getResult = actualLogicalFlowToPhysicalSpecId.get(1L);
    assertEquals(1, getResult.size());
    assertTrue(getResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#getLogicalFlowToPhysicalSpecId(DSLContext)}
   */
  @Test
  void testGetLogicalFlowToPhysicalSpecId2() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<Long, Set<Long>> actualLogicalFlowToPhysicalSpecId = DataTypeUtilities
        .getLogicalFlowToPhysicalSpecId(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_flow\".\"logical_flow_id\", \"physical_flow\".\"specification_id\" from \"physical_flow\" where (\"physical_flow\".\"is_removed\" = ? and \"physical_flow\".\"entity_lifecycle_status\" <> ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setString(eq(2), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualLogicalFlowToPhysicalSpecId.isEmpty());
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)}
   */
  @Test
  void testMigrate() throws SQLException {
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
    DataTypeMigrationResult actualMigrateResult = DataTypeUtilities
        .migrate(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L, 1L, true);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualMigrateResult instanceof ImmutableDataTypeMigrationResult);
    assertEquals(0L, actualMigrateResult.classificationRuleCount());
    assertEquals(0L, actualMigrateResult.logicalFlowDataTypeCount());
    assertEquals(0L, actualMigrateResult.physicalSpecDataTypeCount());
    assertEquals(0L, actualMigrateResult.usageCount());
    assertFalse(actualMigrateResult.dataTypeRemoved());
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)}
   */
  @Test
  void testMigrate2() throws SQLException {
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
    DataTypeMigrationResult actualMigrateResult = DataTypeUtilities
        .migrate(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L, 1L, false);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualMigrateResult instanceof ImmutableDataTypeMigrationResult);
    assertEquals(0L, actualMigrateResult.classificationRuleCount());
    assertEquals(0L, actualMigrateResult.logicalFlowDataTypeCount());
    assertEquals(0L, actualMigrateResult.physicalSpecDataTypeCount());
    assertEquals(0L, actualMigrateResult.usageCount());
    assertFalse(actualMigrateResult.dataTypeRemoved());
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)}
   */
  @Test
  void testMigrate3() throws SQLException {
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
    DataTypeMigrationResult actualMigrateResult = DataTypeUtilities
        .migrate(new DefaultDSLContext(connection, SQLDialect.CUBRID), 1L, 1L, true);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualMigrateResult instanceof ImmutableDataTypeMigrationResult);
    assertEquals(0L, actualMigrateResult.classificationRuleCount());
    assertEquals(0L, actualMigrateResult.logicalFlowDataTypeCount());
    assertEquals(0L, actualMigrateResult.physicalSpecDataTypeCount());
    assertEquals(0L, actualMigrateResult.usageCount());
    assertFalse(actualMigrateResult.dataTypeRemoved());
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)}
   */
  @Test
  void testMigrate4() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeUtilities.migrate(new DefaultDSLContext(connection, SQLDialect.SQL99), "jane.doe@example.org", "To Code",
        true);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)}
   */
  @Test
  void testMigrate5() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeUtilities.migrate(new DefaultDSLContext(connection, SQLDialect.CUBRID), "jane.doe@example.org", "To Code",
        true);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)}
   */
  @Test
  void testMigrate6() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeUtilities.migrate(new DefaultDSLContext(connection, SQLDialect.SQL99), "jane.doe@example.org", "To Code",
        false);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long, Set)}
   */
  @Test
  void testFindLogicalFlowIdsForDataType() throws SQLException {
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    List<Long> actualFindLogicalFlowIdsForDataTypeResult = DataTypeUtilities.findLogicalFlowIdsForDataType(dsl, 1L,
        new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\" from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in () and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindLogicalFlowIdsForDataTypeResult.size());
    assertEquals(1L, actualFindLogicalFlowIdsForDataTypeResult.get(0).longValue());
    assertEquals(1L, actualFindLogicalFlowIdsForDataTypeResult.get(1).longValue());
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long, Set)}
   */
  @Test
  void testFindLogicalFlowIdsForDataType2() throws SQLException {
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    List<Long> actualFindLogicalFlowIdsForDataTypeResult = DataTypeUtilities.findLogicalFlowIdsForDataType(dsl, 1L,
        new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\" from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in () and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindLogicalFlowIdsForDataTypeResult.size());
    assertNull(actualFindLogicalFlowIdsForDataTypeResult.get(0));
    assertNull(actualFindLogicalFlowIdsForDataTypeResult.get(1));
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}
   */
  @Test
  void testDeleteLogicalFlowDecorators() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult = DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L,
        new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in () and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DATA_TYPE"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}
   */
  @Test
  void testDeleteLogicalFlowDecorators2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    ArrayList<Long> logicalFlowIds = new ArrayList<>();
    logicalFlowIds.add(1L);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult = DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L,
        logicalFlowIds);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in (?) and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(3), eq("DATA_TYPE"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}
   */
  @Test
  void testDeleteLogicalFlowDecorators3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    ArrayList<Long> logicalFlowIds = new ArrayList<>();
    logicalFlowIds.add(0L);
    logicalFlowIds.add(1L);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult = DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L,
        logicalFlowIds);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in (?, ?) and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setString(eq(4), eq("DATA_TYPE"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}
   */
  @Test
  void testDeleteLogicalFlowDecorators4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult = DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L,
        new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"logical_flow_decorator\" where (1 = 0 and \"logical_flow_decorator\".\"decorator_entity_id\" = cast(? as bigint) and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar(9)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DATA_TYPE"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}
   */
  @Test
  void testDeleteLogicalFlowDecorators5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult = DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L,
        new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"logical_flow_decorator\" where (1 = 0 and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DATA_TYPE"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}
   */
  @Test
  void testDeleteLogicalFlowDecorators6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult = DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L,
        new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from logical_flow_decorator where (logical_flow_decorator.logical_flow_id in () and logical_flow_decorator.decorator_entity_id = ? and logical_flow_decorator.decorator_entity_kind = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DATA_TYPE"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)}
   */
  @Test
  void testUpdatePhysicalFlowDecorators() throws SQLException {
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualUpdatePhysicalFlowDecoratorsResult = DataTypeUtilities.updatePhysicalFlowDecorators(dsl, 1L, 1L,
        new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualUpdatePhysicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)}
   */
  @Test
  void testUpdatePhysicalFlowDecorators2() throws SQLException {
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualUpdatePhysicalFlowDecoratorsResult = DataTypeUtilities.updatePhysicalFlowDecorators(dsl, 1L, 1L,
        new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualUpdatePhysicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}
   */
  @Test
  void testDeletePhysicalFlowDecorators() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult = DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L,
        new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"physical_spec_data_type\" where (\"physical_spec_data_type\".\"specification_id\" in () and \"physical_spec_data_type\".\"data_type_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}
   */
  @Test
  void testDeletePhysicalFlowDecorators2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Long> specIds = new HashSet<>();
    specIds.add(1L);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult = DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L, specIds);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"physical_spec_data_type\" where (\"physical_spec_data_type\".\"specification_id\" in (?) and \"physical_spec_data_type\".\"data_type_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}
   */
  @Test
  void testDeletePhysicalFlowDecorators3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Long> specIds = new HashSet<>();
    specIds.add(0L);
    specIds.add(1L);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult = DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L, specIds);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"physical_spec_data_type\" where (\"physical_spec_data_type\".\"specification_id\" in (?, ?) and \"physical_spec_data_type\".\"data_type_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}
   */
  @Test
  void testDeletePhysicalFlowDecorators4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult = DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L,
        new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"physical_spec_data_type\" where (1 = 0 and \"physical_spec_data_type\".\"data_type_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}
   */
  @Test
  void testDeletePhysicalFlowDecorators5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult = DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L,
        new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from physical_spec_data_type where (physical_spec_data_type.specification_id in () and physical_spec_data_type.data_type_id = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}
   */
  @Test
  void testChangeTitleAndDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult = DataTypeUtilities.changeTitleAndDescription(
        new DefaultDSLContext(connection, SQLDialect.SQL99), "Dr", "The characteristics of someone or something",
        "Code");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"data_type\" set \"data_type\".\"name\" = ?, \"data_type\".\"description\" = ? where \"data_type\".\"code\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}
   */
  @Test
  void testChangeTitleAndDescription2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult = DataTypeUtilities.changeTitleAndDescription(
        new DefaultDSLContext(connection, SQLDialect.FIREBIRD), "Dr", "The characteristics of someone or something",
        "Code");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"data_type\" set \"data_type\".\"name\" = cast(? as varchar(2)), \"data_type\".\"description\" = cast(? as varchar(43)) where \"data_type\".\"code\" = cast(? as varchar(4))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}
   */
  @Test
  void testChangeTitleAndDescription3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult = DataTypeUtilities.changeTitleAndDescription(
        new DefaultDSLContext(connection, SQLDialect.POSTGRES), "Dr", "The characteristics of someone or something",
        "Code");

    // Assert
    verify(connection).prepareStatement(
        eq("update \"data_type\" set \"name\" = ?, \"description\" = ? where \"data_type\".\"code\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}
   */
  @Test
  void testChangeTitleAndDescription4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult = DataTypeUtilities.changeTitleAndDescription(
        new DefaultDSLContext(connection, SQLDialect.SQLITE), "Dr", "The characteristics of someone or something",
        "Code");

    // Assert
    verify(connection).prepareStatement(eq("update data_type set name = ?, description = ? where data_type.code = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsDeprecated() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualMarkDataTypeAsDeprecatedResult = DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsDeprecated2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> codeListToBeDeprecated = new HashSet<>();
    codeListToBeDeprecated.add("DEPRECATED - ");

    // Act
    long actualMarkDataTypeAsDeprecatedResult = DataTypeUtilities.markDataTypeAsDeprecated(dsl, codeListToBeDeprecated);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsDeprecated3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> codeListToBeDeprecated = new HashSet<>();
    codeListToBeDeprecated.add("foo");
    codeListToBeDeprecated.add("DEPRECATED - ");

    // Act
    long actualMarkDataTypeAsDeprecatedResult = DataTypeUtilities.markDataTypeAsDeprecated(dsl, codeListToBeDeprecated);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsDeprecated4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    long actualMarkDataTypeAsDeprecatedResult = DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsDeprecated5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    long actualMarkDataTypeAsDeprecatedResult = DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsDeprecated6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    long actualMarkDataTypeAsDeprecatedResult = DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testUnMarkDataTypeAsDeprecated() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult = DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection).prepareStatement(
        eq("update \"data_type\" set \"data_type\".\"deprecated\" = ? where \"data_type\".\"code\" in ()"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testUnMarkDataTypeAsDeprecated2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult = DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection).prepareStatement(
        eq("update \"data_type\" set \"data_type\".\"deprecated\" = ? where \"data_type\".\"code\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setString(eq(2), eq("foo"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testUnMarkDataTypeAsDeprecated3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("42");
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult = DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection).prepareStatement(
        eq("update \"data_type\" set \"data_type\".\"deprecated\" = ? where \"data_type\".\"code\" in (?, ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testUnMarkDataTypeAsDeprecated4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult = DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"data_type\" set \"data_type\".\"deprecated\" = cast(? as boolean) where \"data_type\".\"code\" in (cast(? as varchar(3)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setString(eq(2), eq("foo"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testUnMarkDataTypeAsDeprecated5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult = DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(eq("update \"data_type\" set \"deprecated\" = ? where \"data_type\".\"code\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setString(eq(2), eq("foo"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  void testUnMarkDataTypeAsDeprecated6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult = DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection).prepareStatement(eq("update data_type set deprecated = ? where data_type.code in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setString(eq(2), eq("foo"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsConcrete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualMarkDataTypeAsConcreteResult = DataTypeUtilities.markDataTypeAsConcrete(dsl, new HashSet<>());

    // Assert
    verify(connection).prepareStatement(
        eq("update \"data_type\" set \"data_type\".\"concrete\" = ? where \"data_type\".\"code\" in ()"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsConcrete2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult = DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection).prepareStatement(
        eq("update \"data_type\" set \"data_type\".\"concrete\" = ? where \"data_type\".\"code\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setString(eq(2), eq("foo"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsConcrete3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("42");
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult = DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection).prepareStatement(
        eq("update \"data_type\" set \"data_type\".\"concrete\" = ? where \"data_type\".\"code\" in (?, ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsConcrete4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult = DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"data_type\" set \"data_type\".\"concrete\" = cast(? as boolean) where \"data_type\".\"code\" in (cast(? as varchar(3)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setString(eq(2), eq("foo"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsConcrete5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult = DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(eq("update \"data_type\" set \"concrete\" = ? where \"data_type\".\"code\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setString(eq(2), eq("foo"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  void testMarkDataTypeAsConcrete6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult = DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection).prepareStatement(eq("update data_type set concrete = ? where data_type.code in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setString(eq(2), eq("foo"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }
}
