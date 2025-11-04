package org.finos.waltz.data.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation.ImmutableAllocation;
import org.finos.waltz.model.allocation.MeasurablePercentageChange;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.TransactionalRunnable;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AllocationDaoDiffblueTest {
  /**
   * Method under test:
   * {@link AllocationDao#findByMeasurableIdAndScheme(long, long)}
   */
  @Test
  void testFindByMeasurableIdAndScheme() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    List<Allocation> actualFindByMeasurableIdAndSchemeResult = (new AllocationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByMeasurableIdAndScheme(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation\".\"allocation_scheme_id\", \"allocation\".\"allocation_percentage\", \"allocation\".\"last_updated_at\", \"allocation\".\"last_updated_by\", \"allocation\".\"external_id\", \"allocation\".\"provenance\", \"allocation\".\"measurable_rating_id\", \"allocation\".\"id\" from \"allocation\" join \"measurable_rating\" on \"allocation\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where (\"measurable_rating\".\"measurable_id\" = ? and \"allocation\".\"allocation_scheme_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindByMeasurableIdAndSchemeResult.size());
    Allocation getResult = actualFindByMeasurableIdAndSchemeResult.get(0);
    assertTrue(getResult instanceof ImmutableAllocation);
    Allocation getResult2 = actualFindByMeasurableIdAndSchemeResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAllocation);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.provenance());
    assertEquals(1, getResult.percentage());
    assertEquals(1L, getResult.measurableRatingId().longValue());
    assertEquals(1L, getResult.schemeId());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link AllocationDao#findByMeasurableIdAndScheme(long, long)}
   */
  @Test
  void testFindByMeasurableIdAndScheme2() throws SQLException {
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
    List<Allocation> actualFindByMeasurableIdAndSchemeResult = (new AllocationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByMeasurableIdAndScheme(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation\".\"allocation_scheme_id\", \"allocation\".\"allocation_percentage\", \"allocation\".\"last_updated_at\", \"allocation\".\"last_updated_by\", \"allocation\".\"external_id\", \"allocation\".\"provenance\", \"allocation\".\"measurable_rating_id\", \"allocation\".\"id\" from \"allocation\" join \"measurable_rating\" on \"allocation\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where (\"measurable_rating\".\"measurable_id\" = ? and \"allocation\".\"allocation_scheme_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByMeasurableIdAndSchemeResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  void testUpdateAllocations() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.createStatement()).thenReturn(statement);
    AllocationDao allocationDao = new AllocationDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Boolean actualUpdateAllocationsResult = allocationDao.updateAllocations(1L, new ArrayList<>(), "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection, atLeast(1)).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(statement, atLeast(1)).close();
    verify(statement, atLeast(1)).executeBatch();
    verify(statement, atLeast(1)).getWarnings();
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Method under test:
   * {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  void testUpdateAllocations2() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AllocationDao allocationDao = new AllocationDao(dsl);

    // Act
    Boolean actualUpdateAllocationsResult = allocationDao.updateAllocations(1L, new ArrayList<>(), "janedoe");

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Method under test:
   * {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  void testUpdateAllocations3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AllocationDao allocationDao = new AllocationDao(dsl);
    MeasurablePercentageChange measurablePercentageChange = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange.operation()).thenReturn(Operation.ADD);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();
    changes.add(measurablePercentageChange);

    // Act
    Boolean actualUpdateAllocationsResult = allocationDao.updateAllocations(1L, changes, "janedoe");

    // Assert
    verify(measurablePercentageChange).operation();
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Method under test:
   * {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  void testUpdateAllocations4() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AllocationDao allocationDao = new AllocationDao(dsl);
    MeasurablePercentageChange measurablePercentageChange = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange.operation()).thenReturn(Operation.ADD);
    MeasurablePercentageChange measurablePercentageChange2 = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange2.operation()).thenReturn(Operation.ADD);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();
    changes.add(measurablePercentageChange2);
    changes.add(measurablePercentageChange);

    // Act
    Boolean actualUpdateAllocationsResult = allocationDao.updateAllocations(1L, changes, "janedoe");

    // Assert
    verify(measurablePercentageChange2).operation();
    verify(measurablePercentageChange).operation();
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Method under test: {@link AllocationDao#findByMeasurableRatingId(long)}
   */
  @Test
  void testFindByMeasurableRatingId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    Set<Allocation> actualFindByMeasurableRatingIdResult = (new AllocationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByMeasurableRatingId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation\".\"allocation_scheme_id\", \"allocation\".\"allocation_percentage\", \"allocation\".\"last_updated_at\", \"allocation\".\"last_updated_by\", \"allocation\".\"external_id\", \"allocation\".\"provenance\", \"allocation\".\"measurable_rating_id\", \"allocation\".\"id\" from \"allocation\" where \"allocation\".\"measurable_rating_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(1, actualFindByMeasurableRatingIdResult.size());
  }

  /**
   * Method under test: {@link AllocationDao#findByMeasurableRatingId(long)}
   */
  @Test
  void testFindByMeasurableRatingId2() throws SQLException {
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
    Set<Allocation> actualFindByMeasurableRatingIdResult = (new AllocationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByMeasurableRatingId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation\".\"allocation_scheme_id\", \"allocation\".\"allocation_percentage\", \"allocation\".\"last_updated_at\", \"allocation\".\"last_updated_by\", \"allocation\".\"external_id\", \"allocation\".\"provenance\", \"allocation\".\"measurable_rating_id\", \"allocation\".\"id\" from \"allocation\" where \"allocation\".\"measurable_rating_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByMeasurableRatingIdResult.isEmpty());
  }
}
