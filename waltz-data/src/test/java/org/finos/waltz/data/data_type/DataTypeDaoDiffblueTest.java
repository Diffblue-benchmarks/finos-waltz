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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeMigrationResult;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeDaoDiffblueTest {
  /**
   * Test {@link DataTypeDao#migrate(Long, Long, boolean)}.
   * <ul>
   *   <li>Then return {@link ImmutableDataTypeMigrationResult}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataTypeDao#migrate(Long, Long, boolean)}
   */
  @Test
  @DisplayName("Test migrate(Long, Long, boolean); then return ImmutableDataTypeMigrationResult")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataTypeMigrationResult DataTypeDao.migrate(Long, Long, boolean)"})
  void testMigrate_thenReturnImmutableDataTypeMigrationResult() throws SQLException {
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
   * Test {@link DataTypeDao#getByCode(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBoolean(int)} return {@code true}.</li>
   *   <li>Then return {@link ImmutableDataType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataTypeDao#getByCode(String)}
   */
  @Test
  @DisplayName("Test getByCode(String); given ResultSet getBoolean(int) return 'true'; then return ImmutableDataType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType DataTypeDao.getByCode(String)"})
  void testGetByCode_givenResultSetGetBooleanReturnTrue_thenReturnImmutableDataType() throws SQLException {
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
   * Test {@link DataTypeDao#getByCode(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>When {@code Code}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataTypeDao#getByCode(String)}
   */
  @Test
  @DisplayName("Test getByCode(String); given ResultSet next() return 'false'; when 'Code'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType DataTypeDao.getByCode(String)"})
  void testGetByCode_givenResultSetNextReturnFalse_whenCode_thenReturnNull() throws SQLException {
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
   * Test {@link DataTypeDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBoolean(int)} return {@code true}.</li>
   *   <li>Then return {@link ImmutableDataType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataTypeDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet getBoolean(int) return 'true'; then return ImmutableDataType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType DataTypeDao.getById(long)"})
  void testGetById_givenResultSetGetBooleanReturnTrue_thenReturnImmutableDataType() throws SQLException {
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
    DataTypeDao dataTypeDao = new DataTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    DataType actualById = dataTypeDao.getById(1L);

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
    assertTrue(dataTypeDao.findAll().isEmpty());
    assertTrue(actualById.concrete());
    assertTrue(actualById.deprecated());
    assertTrue(actualById.unknown());
  }
}
