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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeMigrationResult;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeDaoDiffblueTest {
  /**
   * Method under test: {@link DataTypeDao#migrate(Long, Long, boolean)}
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
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeMigrationResult actualMigrateResult = (new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .migrate(1L, 1L, true);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
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
   * Method under test: {@link DataTypeDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<DataType> actualFindAllResult = (new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq("select \"data_type\".* from \"data_type\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindAllResult.size());
    DataType getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableDataType);
    DataType getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableDataType);
    assertEquals("String", getResult.code());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(EntityKind.DATA_TYPE, getResult.kind());
    assertTrue(getResult.concrete());
    assertTrue(getResult.deprecated());
    assertTrue(getResult.unknown());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link DataTypeDao#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<DataType> actualFindAllResult = (new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq("select \"data_type\".* from \"data_type\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindAllResult.size());
    DataType getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableDataType);
    DataType getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableDataType);
    assertEquals("String", getResult.code());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(EntityKind.DATA_TYPE, getResult.kind());
    assertTrue(getResult.concrete());
    assertTrue(getResult.deprecated());
    assertTrue(getResult.unknown());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link DataTypeDao#findAll()}
   */
  @Test
  void testFindAll3() throws SQLException {
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
    List<DataType> actualFindAllResult = (new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq("select \"data_type\".* from \"data_type\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link DataTypeDao#getByCode(String)}
   */
  @Test
  void testGetByCode() throws SQLException {
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
    DataType actualByCode = (new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getByCode("Code");

    // Assert
    verify(connection)
        .prepareStatement(eq("select \"data_type\".* from \"data_type\" where \"data_type\".\"code\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Code"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByCode);
  }

  /**
   * Method under test: {@link DataTypeDao#getByCode(String)}
   */
  @Test
  void testGetByCode2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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

    // Act
    DataType actualByCode = (new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getByCode("Code");

    // Assert
    verify(connection)
        .prepareStatement(eq("select \"data_type\".* from \"data_type\" where \"data_type\".\"code\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Code"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualByCode instanceof ImmutableDataType);
    assertEquals("String", actualByCode.code());
    assertEquals("String", actualByCode.description());
    assertEquals("String", actualByCode.name());
    assertEquals(EntityKind.DATA_TYPE, actualByCode.kind());
    assertTrue(actualByCode.concrete());
    assertTrue(actualByCode.deprecated());
    assertTrue(actualByCode.unknown());
  }

  /**
   * Method under test: {@link DataTypeDao#getById(long)}
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
    DataType actualById = (new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq("select \"data_type\".* from \"data_type\" where \"data_type\".\"id\" = ?"));
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
   * Method under test: {@link DataTypeDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
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
    DataType actualById = (new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq("select \"data_type\".* from \"data_type\" where \"data_type\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualById instanceof ImmutableDataType);
    assertEquals("String", actualById.code());
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.name());
    assertEquals(EntityKind.DATA_TYPE, actualById.kind());
    assertTrue(actualById.concrete());
    assertTrue(actualById.deprecated());
    assertTrue(actualById.unknown());
  }

  /**
   * Method under test: {@link DataTypeDao#findByIds(Collection)}
   */
  @Test
  void testFindByIds() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DataTypeDao dataTypeDao = new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<DataType> actualFindByIdsResult = dataTypeDao.findByIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"data_type\".\"code\", \"data_type\".\"name\", \"data_type\".\"description\", \"data_type\".\"id\", \"data_type\".\"parent_id\", \"data_type\".\"concrete\", \"data_type\".\"unknown\", \"data_type\".\"last_updated_at\", \"data_type\".\"deprecated\" from \"data_type\" where \"data_type\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindByIdsResult.size());
    DataType getResult = actualFindByIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableDataType);
    DataType getResult2 = actualFindByIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableDataType);
    assertEquals("String", getResult.code());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(EntityKind.DATA_TYPE, getResult.kind());
    assertTrue(getResult.concrete());
    assertTrue(getResult.deprecated());
    assertTrue(getResult.unknown());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link DataTypeDao#findByIds(Collection)}
   */
  @Test
  void testFindByIds2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DataTypeDao dataTypeDao = new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<DataType> actualFindByIdsResult = dataTypeDao.findByIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"data_type\".\"code\", \"data_type\".\"name\", \"data_type\".\"description\", \"data_type\".\"id\", \"data_type\".\"parent_id\", \"data_type\".\"concrete\", \"data_type\".\"unknown\", \"data_type\".\"last_updated_at\", \"data_type\".\"deprecated\" from \"data_type\" where \"data_type\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindByIdsResult.size());
    DataType getResult = actualFindByIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableDataType);
    DataType getResult2 = actualFindByIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableDataType);
    assertEquals("String", getResult.code());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(EntityKind.DATA_TYPE, getResult.kind());
    assertTrue(getResult.concrete());
    assertTrue(getResult.deprecated());
    assertTrue(getResult.unknown());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link DataTypeDao#findByParentId(long)}
   */
  @Test
  void testFindByParentId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
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
    Collection<DataType> actualFindByParentIdResult = (new DataTypeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByParentId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"data_type\".\"code\", \"data_type\".\"name\", \"data_type\".\"description\", \"data_type\".\"id\", \"data_type\".\"parent_id\", \"data_type\".\"concrete\", \"data_type\".\"unknown\", \"data_type\".\"last_updated_at\", \"data_type\".\"deprecated\" from \"data_type\" where \"data_type\".\"parent_id\" = ? order by \"data_type\".\"name\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByParentIdResult instanceof Set);
    assertEquals(1, actualFindByParentIdResult.size());
  }

  /**
   * Method under test: {@link DataTypeDao#findByParentId(long)}
   */
  @Test
  void testFindByParentId2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
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

    // Act
    Collection<DataType> actualFindByParentIdResult = (new DataTypeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByParentId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"data_type\".\"code\", \"data_type\".\"name\", \"data_type\".\"description\", \"data_type\".\"id\", \"data_type\".\"parent_id\", \"data_type\".\"concrete\", \"data_type\".\"unknown\", \"data_type\".\"last_updated_at\", \"data_type\".\"deprecated\" from \"data_type\" where \"data_type\".\"parent_id\" = ? order by \"data_type\".\"name\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(8));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByParentIdResult instanceof Set);
    assertEquals(1, actualFindByParentIdResult.size());
  }
}
