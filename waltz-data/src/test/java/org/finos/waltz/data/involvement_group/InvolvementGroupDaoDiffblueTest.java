package org.finos.waltz.data.involvement_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.TransactionalRunnable;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementGroupDaoDiffblueTest {
  /**
   * Method under test:
   * {@link InvolvementGroupDao#findAllInvolvementsByGroupId(DSLContext)}
   */
  @Test
  void testFindAllInvolvementsByGroupId() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<Long, List<Long>> actualFindAllInvolvementsByGroupIdResult = InvolvementGroupDao
        .findAllInvolvementsByGroupId(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"involvement_group_entry\".\"involvement_group_id\", \"involvement_group_entry\".\"involvement_kind_id\" from \"involvement_group_entry\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindAllInvolvementsByGroupIdResult.size());
    List<Long> getResult = actualFindAllInvolvementsByGroupIdResult.get(1L);
    assertEquals(2, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
    assertEquals(1L, getResult.get(1).longValue());
  }

  /**
   * Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  void testUpdateInvolvements() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    involvementGroupDao.updateInvolvements(1L, new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(
        eq("delete from \"involvement_group_entry\" where \"involvement_group_entry\".\"involvement_group_id\" = ?"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  void testUpdateInvolvements2() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(dsl);

    // Act
    involvementGroupDao.updateInvolvements(1L, new HashSet<>());

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  void testUpdateInvolvements3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(dsl);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(1L);

    // Act
    involvementGroupDao.updateInvolvements(1L, involvementKindIds);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  void testUpdateInvolvements4() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(dsl);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(0L);
    involvementKindIds.add(1L);

    // Act
    involvementGroupDao.updateInvolvements(1L, involvementKindIds);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  void testUpdateInvolvements5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(-1L);

    // Act
    involvementGroupDao.updateInvolvements(1L, involvementKindIds);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }
}
