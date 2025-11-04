package org.finos.waltz.data.access_log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.accesslog.AccessLog;
import org.finos.waltz.model.accesslog.AccessTime;
import org.finos.waltz.model.accesslog.ImmutableAccessLog;
import org.finos.waltz.model.accesslog.ImmutableAccessTime;
import org.finos.waltz.schema.tables.records.AccessLogRecord;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AccessLogDaoDiffblueTest {
  /**
   * Method under test: {@link AccessLogDao#write(AccessLog)}
   */
  @Test
  void testWrite() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    InsertSetStep<AccessLogRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep4);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AccessLogRecord>>any())).thenReturn(insertSetStep);
    AccessLogDao accessLogDao = new AccessLogDao(dsl);
    AccessLog logEntry = mock(AccessLog.class);
    when(logEntry.params()).thenReturn("Params");
    when(logEntry.state()).thenReturn("MD");
    when(logEntry.userId()).thenReturn("42");
    when(logEntry.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    int actualWriteResult = accessLogDao.write(logEntry);

    // Assert
    verify(logEntry).createdAt();
    verify(logEntry).params();
    verify(logEntry).state();
    verify(logEntry).userId();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualWriteResult);
  }

  /**
   * Method under test: {@link AccessLogDao#findForUserId(String, Optional)}
   */
  @Test
  void testFindForUserId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    AccessLogDao accessLogDao = new AccessLogDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    Optional<Integer> limit = Optional.<Integer>of(1);

    // Act
    List<AccessLog> actualFindForUserIdResult = accessLogDao.findForUserId("42", limit);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"access_log\".\"id\", \"access_log\".\"user_id\", \"access_log\".\"state\", \"access_log\".\"params\", \"access_log\".\"created_at\" from \"access_log\" where lower(\"access_log\".\"user_id\") = lower(?) order by \"access_log\".\"created_at\" desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(5));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindForUserIdResult.size());
    AccessLog getResult = actualFindForUserIdResult.get(0);
    assertTrue(getResult instanceof ImmutableAccessLog);
    AccessLog getResult2 = actualFindForUserIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAccessLog);
    LocalDateTime createdAtResult = getResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.params());
    assertEquals("String", getResult.state());
    assertEquals("String", getResult.userId());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link AccessLogDao#findForUserId(String, Optional)}
   */
  @Test
  void testFindForUserId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(0);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    AccessLogDao accessLogDao = new AccessLogDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    Optional<Integer> limit = Optional.<Integer>of(1);

    // Act
    List<AccessLog> actualFindForUserIdResult = accessLogDao.findForUserId("42", limit);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"access_log\".\"id\", \"access_log\".\"user_id\", \"access_log\".\"state\", \"access_log\".\"params\", \"access_log\".\"created_at\" from \"access_log\" where lower(\"access_log\".\"user_id\") = lower(?) order by \"access_log\".\"created_at\" desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(5));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindForUserIdResult.size());
    AccessLog getResult = actualFindForUserIdResult.get(0);
    assertTrue(getResult instanceof ImmutableAccessLog);
    AccessLog getResult2 = actualFindForUserIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAccessLog);
    LocalDateTime createdAtResult = getResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.params());
    assertEquals("String", getResult.state());
    assertEquals("String", getResult.userId());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link AccessLogDao#findActiveUsersSince(LocalDateTime)}
   */
  @Test
  void testFindActiveUsersSince() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
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
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AccessLogDao accessLogDao = new AccessLogDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<AccessTime> actualFindActiveUsersSinceResult = accessLogDao
        .findActiveUsersSince(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"access_log\".\"user_id\", max(\"access_log\".\"created_at\") \"created_at\" from \"access_log\" where \"access_log\".\"created_at\" >= ? group by \"access_log\".\"user_id\" order by \"created_at\" desc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setTimestamp(eq(1), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).getTimestamp(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindActiveUsersSinceResult.size());
    AccessTime getResult = actualFindActiveUsersSinceResult.get(0);
    assertTrue(getResult instanceof ImmutableAccessTime);
    AccessTime getResult2 = actualFindActiveUsersSinceResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAccessTime);
    LocalDateTime createdAtResult = getResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.userId());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }
}
