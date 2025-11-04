package org.finos.waltz.data.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.user.User;
import org.finos.waltz.schema.tables.records.UserRoleRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserRoleDaoDiffblueTest {
  /**
   * Method under test: {@link UserRoleDao#getUserRoles(String)}
   */
  @Test
  void testGetUserRoles() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    Set<String> actualUserRoles = (new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getUserRoles("janedoe");

    // Assert
    verify(connection).prepareStatement(
        eq("select \"user_role\".\"role\" from \"user_role\" where lower(\"user_role\".\"user_name\") = lower(?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualUserRoles.size());
    assertTrue(actualUserRoles.contains("String"));
  }

  /**
   * Method under test: {@link UserRoleDao#findAllUsers()}
   */
  @Test
  void testFindAllUsers() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    Set<User> actualFindAllUsersResult = (new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAllUsers();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user\".\"user_name\", \"user_role\".\"role\" from \"user\" join \"user_role\" on \"user\".\"user_name\" = \"user_role\".\"user_name\" join \"role\" on \"role\".\"key\" = \"user_role\".\"role\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindAllUsersResult.size());
  }

  /**
   * Method under test: {@link UserRoleDao#findAllUsers()}
   */
  @Test
  void testFindAllUsers2() throws SQLException {
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
    Set<User> actualFindAllUsersResult = (new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAllUsers();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user\".\"user_name\", \"user_role\".\"role\" from \"user\" join \"user_role\" on \"user\".\"user_name\" = \"user_role\".\"user_name\" join \"role\" on \"role\".\"key\" = \"user_role\".\"role\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllUsersResult.isEmpty());
  }

  /**
   * Method under test: {@link UserRoleDao#findAllUsers()}
   */
  @Test
  void testFindAllUsers3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    Set<User> actualFindAllUsersResult = (new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAllUsers();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user\".\"user_name\", \"user_role\".\"role\" from \"user\" join \"user_role\" on \"user\".\"user_name\" = \"user_role\".\"user_name\" join \"role\" on \"role\".\"key\" = \"user_role\".\"role\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindAllUsersResult.size());
  }

  /**
   * Method under test: {@link UserRoleDao#findUsersForRole(Long)}
   */
  @Test
  void testFindUsersForRole() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    Set<User> actualFindUsersForRoleResult = (new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findUsersForRole(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user\".\"user_name\", \"user_role\".\"role\" from \"user\" join \"user_role\" on \"user\".\"user_name\" = \"user_role\".\"user_name\" join \"role\" on \"role\".\"key\" = \"user_role\".\"role\" where \"role\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindUsersForRoleResult.size());
  }

  /**
   * Method under test: {@link UserRoleDao#findUsersForRole(Long)}
   */
  @Test
  void testFindUsersForRole2() throws SQLException {
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
    Set<User> actualFindUsersForRoleResult = (new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findUsersForRole(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user\".\"user_name\", \"user_role\".\"role\" from \"user\" join \"user_role\" on \"user\".\"user_name\" = \"user_role\".\"user_name\" join \"role\" on \"role\".\"key\" = \"user_role\".\"role\" where \"role\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindUsersForRoleResult.isEmpty());
  }

  /**
   * Method under test: {@link UserRoleDao#findUsersForRole(Long)}
   */
  @Test
  void testFindUsersForRole3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    Set<User> actualFindUsersForRoleResult = (new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findUsersForRole(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user\".\"user_name\", \"user_role\".\"role\" from \"user\" join \"user_role\" on \"user\".\"user_name\" = \"user_role\".\"user_name\" join \"role\" on \"role\".\"key\" = \"user_role\".\"role\" where \"role\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindUsersForRoleResult.size());
  }

  /**
   * Method under test: {@link UserRoleDao#updateRoles(String, Set)}
   */
  @Test
  void testUpdateRoles() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.createStatement()).thenReturn(statement);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    UserRoleDao userRoleDao = new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateRolesResult = userRoleDao.updateRoles("janedoe", new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(statement).close();
    verify(preparedStatement, atLeast(1)).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(statement).getWarnings();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualUpdateRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#updateRoles(String, Set)}
   */
  @Test
  void testUpdateRoles2() throws SQLException {
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
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.createStatement()).thenReturn(statement);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    UserRoleDao userRoleDao = new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateRolesResult = userRoleDao.updateRoles("janedoe", new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(statement).close();
    verify(preparedStatement, atLeast(1)).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(statement).getWarnings();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualUpdateRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#addRoles(Set)}
   */
  @Test
  void testAddRoles() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    UserRoleDao userRoleDao = new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualAddRolesResult = userRoleDao.addRoles(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq(
        "select \"user_role\".\"user_name\", \"user_role\".\"role\" from \"user_role\" where \"user_role\".\"user_name\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(statement).getWarnings();
    assertEquals(0, actualAddRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#addRoles(Set)}
   */
  @Test
  void testAddRoles2() throws SQLException {
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
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    UserRoleDao userRoleDao = new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualAddRolesResult = userRoleDao.addRoles(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq(
        "select \"user_role\".\"user_name\", \"user_role\".\"role\" from \"user_role\" where \"user_role\".\"user_name\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(statement).getWarnings();
    assertEquals(0, actualAddRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  void testRemoveRoles() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    UserRoleDao userRoleDao = new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  void testRemoveRoles2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    UserRoleDao userRoleDao = new UserRoleDao(dsl);

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  void testRemoveRoles3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DeleteConditionStep<UserRoleRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any())).thenReturn(mock(DeleteConditionStep.class));
    DeleteUsingStep<UserRoleRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<UserRoleRecord>>any())).thenReturn(deleteUsingStep);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    UserRoleDao userRoleDao = new UserRoleDao(dsl);

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(new Tuple2<>("V1", "V2"));

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(usersAndRolesToUpdate);

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  void testRemoveRoles4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DeleteConditionStep<UserRoleRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any())).thenReturn(mock(DeleteConditionStep.class));
    DeleteUsingStep<UserRoleRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<UserRoleRecord>>any())).thenReturn(deleteUsingStep);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    UserRoleDao userRoleDao = new UserRoleDao(dsl);
    Tuple2<String, String> tuple2 = mock(Tuple2.class);
    when(tuple2.v1()).thenReturn("V1");
    when(tuple2.v2()).thenReturn("V2");

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(new Tuple2<>("V1", "V2"));
    usersAndRolesToUpdate.add(tuple2);

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(usersAndRolesToUpdate);

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl, atLeast(1)).deleteFrom(isA(Table.class));
    verify(deleteConditionStep, atLeast(1)).and(isA(Condition.class));
    verify(deleteUsingStep, atLeast(1)).where(isA(Condition.class));
    verify(tuple2).v1();
    verify(tuple2).v2();
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#replaceRoles(Set)}
   */
  @Test
  void testReplaceRoles() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.createStatement()).thenReturn(statement);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    UserRoleDao userRoleDao = new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualReplaceRolesResult = userRoleDao.replaceRoles(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(statement).close();
    verify(preparedStatement, atLeast(1)).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(statement).getWarnings();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualReplaceRolesResult);
  }

  /**
   * Method under test: {@link UserRoleDao#replaceRoles(Set)}
   */
  @Test
  void testReplaceRoles2() throws SQLException {
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
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    when(connection.createStatement()).thenReturn(statement);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    UserRoleDao userRoleDao = new UserRoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualReplaceRolesResult = userRoleDao.replaceRoles(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(statement).close();
    verify(preparedStatement, atLeast(1)).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(statement).getWarnings();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualReplaceRolesResult);
  }
}
