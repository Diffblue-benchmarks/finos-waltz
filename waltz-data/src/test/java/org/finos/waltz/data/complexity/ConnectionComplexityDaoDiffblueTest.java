package org.finos.waltz.data.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.List;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConnectionComplexityDaoDiffblueTest {
  /**
   * Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  void testCalculateBaseline() throws SQLException {
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
    int actualCalculateBaselineResult = (new ConnectionComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).calculateBaseline();

    // Assert
    verify(connection).prepareStatement(eq(
        "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  void testCalculateBaseline2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCalculateBaselineResult = (new ConnectionComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).calculateBaseline();

    // Assert
    verify(connection).prepareStatement(eq(
        "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateBaselineResult);
  }

  /**
   * Method under test: {@link ConnectionComplexityDao#calculateBaseline(Long)}
   */
  @Test
  void testCalculateBaseline3() throws SQLException {
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
    int actualCalculateBaselineResult = (new ConnectionComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).calculateBaseline(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where app_id in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(7), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Method under test: {@link ConnectionComplexityDao#calculateBaseline(Long)}
   */
  @Test
  void testCalculateBaseline4() throws SQLException {
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
    int actualCalculateBaselineResult = (new ConnectionComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).calculateBaseline(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where app_id in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(7), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateBaselineResult);
  }

  /**
   * Method under test: {@link ConnectionComplexityDao#findCounts()}
   */
  @Test
  void testFindCounts() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    List<Tally<Long>> actualFindCountsResult = (new ConnectionComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCounts();

    // Assert
    verify(connection).prepareStatement(eq(
        "select app_id, total_connections from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindCountsResult.size());
    Tally<Long> getResult = actualFindCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<Long> getResult2 = actualFindCountsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals(1.0d, getResult.count());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ConnectionComplexityDao#findCounts(Long[])}
   */
  @Test
  void testFindCounts2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    List<Tally<Long>> actualFindCountsResult = (new ConnectionComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCounts(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select app_id, total_connections from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where app_id in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(7), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindCountsResult.size());
    Tally<Long> getResult = actualFindCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<Long> getResult2 = actualFindCountsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals(1.0d, getResult.count());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(getResult, getResult2);
  }
}
