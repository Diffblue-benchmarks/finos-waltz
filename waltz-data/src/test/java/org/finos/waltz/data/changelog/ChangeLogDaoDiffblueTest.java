package org.finos.waltz.data.changelog;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.tally.ImmutableOrderedTally;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.OrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Batch;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeLogDaoDiffblueTest {
  /**
   * Method under test:
   * {@link ChangeLogDao#mkUnattestedChangesQuery(EntityReference)}
   */
  @Test
  void testMkUnattestedChangesQuery() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    ChangeLogDao.mkUnattestedChangesQuery(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test: {@link ChangeLogDao#getContributionLeaderBoard(int)}
   */
  @Test
  void testGetContributionLeaderBoard() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    List<OrderedTally<String>> actualContributionLeaderBoard = (new ChangeLogDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getContributionLeaderBoard(1);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"change_log\".\"user_id\", count(\"change_log\".\"user_id\") \"count\", row_number() over (order by count(\"change_log\".\"user_id\") desc) from \"change_log\" where (1 = 1) group by \"change_log\".\"user_id\" order by count desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualContributionLeaderBoard.size());
    OrderedTally<String> getResult = actualContributionLeaderBoard.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    OrderedTally<String> getResult2 = actualContributionLeaderBoard.get(1);
    assertTrue(getResult2 instanceof ImmutableOrderedTally);
    assertEquals("String", getResult.id());
    assertEquals(1, getResult.index());
    assertEquals(1.0d, getResult.count());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ChangeLogDao#getRankingOfContributors()}
   */
  @Test
  void testGetRankingOfContributors() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    List<OrderedTally<String>> actualRankingOfContributors = (new ChangeLogDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getRankingOfContributors();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"change_log\".\"user_id\", count(\"change_log\".\"user_id\") \"count\", row_number() over (order by count(\"change_log\".\"user_id\") desc) from \"change_log\" where (1 = 1) group by \"change_log\".\"user_id\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualRankingOfContributors.size());
    OrderedTally<String> getResult = actualRankingOfContributors.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    OrderedTally<String> getResult2 = actualRankingOfContributors.get(1);
    assertTrue(getResult2 instanceof ImmutableOrderedTally);
    assertEquals("String", getResult.id());
    assertEquals(1, getResult.index());
    assertEquals(1.0d, getResult.count());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ChangeLogDao#getContributionScoresForUsers(List)}
   */
  @Test
  void testGetContributionScoresForUsers() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Tally<String>> actualContributionScoresForUsers = changeLogDao
        .getContributionScoresForUsers(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"change_log\".\"user_id\", count(\"change_log\".\"user_id\") \"count\" from \"change_log\" where (\"change_log\".\"user_id\" in ()) group by \"change_log\".\"user_id\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualContributionScoresForUsers.size());
    Tally<String> getResult = actualContributionScoresForUsers.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<String> getResult2 = actualContributionScoresForUsers.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals("String", getResult.id());
    assertEquals(1.0d, getResult.count());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ChangeLogDao#write(Collection)}
   */
  @Test
  void testWrite() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int[] actualWriteResult = changeLogDao.write(new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualWriteResult);
  }

  /**
   * Method under test: {@link ChangeLogDao#write(Collection)}
   */
  @Test
  void testWrite2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    ChangeLogDao changeLogDao = new ChangeLogDao(dsl);

    // Act
    int[] actualWriteResult = changeLogDao.write(new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualWriteResult);
  }
}
