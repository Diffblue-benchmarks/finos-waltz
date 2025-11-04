package org.finos.waltz.data.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.List;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserDaoDiffblueTest {
  /**
   * Method under test: {@link UserDao#getPassword(String)}
   */
  @Test
  void testGetPassword() throws SQLException {
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
    String actualPassword = (new UserDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getPassword("janedoe");

    // Assert
    verify(connection).prepareStatement(
        eq("select \"user\".\"password\" from \"user\" where lower(\"user\".\"user_name\") = lower(?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualPassword);
  }

  /**
   * Method under test: {@link UserDao#getPassword(String)}
   */
  @Test
  void testGetPassword2() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    String actualPassword = (new UserDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getPassword("janedoe");

    // Assert
    verify(connection).prepareStatement(
        eq("select \"user\".\"password\" from \"user\" where lower(\"user\".\"user_name\") = lower(?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("String", actualPassword);
  }

  /**
   * Method under test: {@link UserDao#create(String, String)}
   */
  @Test
  void testCreate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCreateResult = (new UserDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).create("janedoe",
        "Password Hash");

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"user\" (\"user_name\", \"password\") select \"t\".\"user_name\", \"t\".\"password\" from (select ? \"user_name\", ? \"password\" where not exists (select 1 \"one\" from \"user\" where \"user\".\"user_name\" = ?)) \"t\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCreateResult);
  }

  /**
   * Method under test: {@link UserDao#findAllUserNames()}
   */
  @Test
  void testFindAllUserNames() throws SQLException {
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
    List<String> actualFindAllUserNamesResult = (new UserDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAllUserNames();

    // Assert
    verify(connection).prepareStatement(eq("select \"user\".\"user_name\" from \"user\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindAllUserNamesResult.size());
    assertEquals("String", actualFindAllUserNamesResult.get(0));
    assertEquals("String", actualFindAllUserNamesResult.get(1));
  }

  /**
   * Method under test: {@link UserDao#deleteUser(String)}
   */
  @Test
  void testDeleteUser() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteUserResult = (new UserDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteUser("janedoe");

    // Assert
    verify(connection).prepareStatement(eq("delete from \"user\" where lower(\"user\".\"user_name\") = lower(?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteUserResult);
  }

  /**
   * Method under test: {@link UserDao#resetPassword(String, String)}
   */
  @Test
  void testResetPassword() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualResetPasswordResult = (new UserDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .resetPassword("janedoe", "Password Hash");

    // Assert
    verify(connection)
        .prepareStatement(eq("update \"user\" set \"user\".\"password\" = ? where \"user\".\"user_name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualResetPasswordResult);
  }
}
