package org.finos.waltz.data.client_cache_key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.util.List;
import org.finos.waltz.model.client_cache_key.ClientCacheKey;
import org.finos.waltz.model.client_cache_key.ImmutableClientCacheKey;
import org.jooq.Field;
import org.jooq.InsertOnDuplicateSetMoreStep;
import org.jooq.InsertOnDuplicateSetStep;
import org.jooq.InsertValuesStep3;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientCacheKeyDaoDiffblueTest {
  /**
   * Method under test: {@link ClientCacheKeyDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    List<ClientCacheKey> actualFindAllResult = (new ClientCacheKeyDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"client_cache_key\".\"key\", \"client_cache_key\".\"guid\", \"client_cache_key\".\"last_updated_at\" from \"client_cache_key\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindAllResult.size());
    ClientCacheKey getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableClientCacheKey);
    ClientCacheKey getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableClientCacheKey);
    assertEquals("String", getResult.guid());
    assertEquals("String", getResult.key());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ClientCacheKeyDao#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
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
    List<ClientCacheKey> actualFindAllResult = (new ClientCacheKeyDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"client_cache_key\".\"key\", \"client_cache_key\".\"guid\", \"client_cache_key\".\"last_updated_at\" from \"client_cache_key\""));
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
   * Method under test: {@link ClientCacheKeyDao#getByKey(String)}
   */
  @Test
  void testGetByKey() throws SQLException {
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
    ClientCacheKey actualByKey = (new ClientCacheKeyDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByKey("Key");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"client_cache_key\".\"key\", \"client_cache_key\".\"guid\", \"client_cache_key\".\"last_updated_at\" from \"client_cache_key\" where \"client_cache_key\".\"key\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Key"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByKey);
  }

  /**
   * Method under test: {@link ClientCacheKeyDao#getByKey(String)}
   */
  @Test
  void testGetByKey2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    ClientCacheKey actualByKey = (new ClientCacheKeyDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByKey("Key");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"client_cache_key\".\"key\", \"client_cache_key\".\"guid\", \"client_cache_key\".\"last_updated_at\" from \"client_cache_key\" where \"client_cache_key\".\"key\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Key"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    assertTrue(actualByKey instanceof ImmutableClientCacheKey);
    assertEquals("String", actualByKey.guid());
    assertEquals("String", actualByKey.key());
  }

  /**
   * Method under test: {@link ClientCacheKeyDao#createOrUpdate(String, String)}
   */
  @Test
  void testCreateOrUpdate() throws DataAccessException {
    // Arrange
    InsertOnDuplicateSetMoreStep<Record> insertOnDuplicateSetMoreStep = mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep.execute()).thenReturn(1);
    InsertOnDuplicateSetMoreStep<Record> insertOnDuplicateSetMoreStep2 = mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep);
    InsertOnDuplicateSetStep<Record> insertOnDuplicateSetStep = mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep2);
    InsertValuesStep3<Record, Object, Object, Object> insertValuesStep3 = mock(InsertValuesStep3.class);
    when(insertValuesStep3.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);
    InsertValuesStep3<Record, Object, Object, Object> insertValuesStep32 = mock(InsertValuesStep3.class);
    when(insertValuesStep32.values(Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(insertValuesStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<Record>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any())).thenReturn(insertValuesStep32);

    // Act
    boolean actualCreateOrUpdateResult = (new ClientCacheKeyDao(dsl)).createOrUpdate("Key", "1234");

    // Assert
    verify(insertOnDuplicateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertValuesStep3).onDuplicateKeyUpdate();
    verify(insertValuesStep32).values(isA(Object.class), isA(Object.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    verify(dsl).insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class));
    assertTrue(actualCreateOrUpdateResult);
  }

  /**
   * Method under test: {@link ClientCacheKeyDao#createOrUpdate(String, String)}
   */
  @Test
  void testCreateOrUpdate2() throws DataAccessException {
    // Arrange
    InsertOnDuplicateSetMoreStep<Record> insertOnDuplicateSetMoreStep = mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep.execute()).thenReturn(0);
    InsertOnDuplicateSetMoreStep<Record> insertOnDuplicateSetMoreStep2 = mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep);
    InsertOnDuplicateSetStep<Record> insertOnDuplicateSetStep = mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep2);
    InsertValuesStep3<Record, Object, Object, Object> insertValuesStep3 = mock(InsertValuesStep3.class);
    when(insertValuesStep3.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);
    InsertValuesStep3<Record, Object, Object, Object> insertValuesStep32 = mock(InsertValuesStep3.class);
    when(insertValuesStep32.values(Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(insertValuesStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<Record>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any())).thenReturn(insertValuesStep32);

    // Act
    boolean actualCreateOrUpdateResult = (new ClientCacheKeyDao(dsl)).createOrUpdate("Key", "1234");

    // Assert
    verify(insertOnDuplicateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertValuesStep3).onDuplicateKeyUpdate();
    verify(insertValuesStep32).values(isA(Object.class), isA(Object.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    verify(dsl).insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class));
    assertFalse(actualCreateOrUpdateResult);
  }
}
