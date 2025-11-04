package org.finos.waltz.data.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.user.ImmutableUserPreference;
import org.finos.waltz.model.user.UserPreference;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserPreferenceDaoDiffblueTest {
  /**
   * Method under test: {@link UserPreferenceDao#getPreferencesForUser(String)}
   */
  @Test
  void testGetPreferencesForUser() throws SQLException {
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
    List<UserPreference> actualPreferencesForUser = (new UserPreferenceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getPreferencesForUser("janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user_preference\".\"key\", \"user_preference\".\"value\", \"user_preference\".\"user_name\" from \"user_preference\" where \"user_preference\".\"user_name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualPreferencesForUser.size());
    UserPreference getResult = actualPreferencesForUser.get(0);
    assertTrue(getResult instanceof ImmutableUserPreference);
    UserPreference getResult2 = actualPreferencesForUser.get(1);
    assertTrue(getResult2 instanceof ImmutableUserPreference);
    assertEquals("String", getResult.key());
    assertEquals("String", getResult.value());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link UserPreferenceDao#getPreferencesForUser(String)}
   */
  @Test
  void testGetPreferencesForUser2() throws SQLException {
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
    List<UserPreference> actualPreferencesForUser = (new UserPreferenceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getPreferencesForUser("janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user_preference\".\"key\", \"user_preference\".\"value\", \"user_preference\".\"user_name\" from \"user_preference\" where \"user_preference\".\"user_name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualPreferencesForUser.isEmpty());
  }

  /**
   * Method under test:
   * {@link UserPreferenceDao#savePreferencesForUser(String, List)}
   */
  @Test
  void testSavePreferencesForUser() throws SQLException {
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
    UserPreferenceDao userPreferenceDao = new UserPreferenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualSavePreferencesForUserResult = userPreferenceDao.savePreferencesForUser("janedoe", new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user_preference\".\"key\", \"user_preference\".\"value\", \"user_preference\".\"user_name\" from \"user_preference\" where \"user_preference\".\"user_name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualSavePreferencesForUserResult);
  }

  /**
   * Method under test:
   * {@link UserPreferenceDao#savePreferencesForUser(String, List)}
   */
  @Test
  void testSavePreferencesForUser2() throws SQLException {
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
    UserPreferenceDao userPreferenceDao = new UserPreferenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualSavePreferencesForUserResult = userPreferenceDao.savePreferencesForUser("janedoe", new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user_preference\".\"key\", \"user_preference\".\"value\", \"user_preference\".\"user_name\" from \"user_preference\" where \"user_preference\".\"user_name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualSavePreferencesForUserResult);
  }

  /**
   * Method under test: {@link UserPreferenceDao#clearPreferencesForUser(String)}
   */
  @Test
  void testClearPreferencesForUser() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    (new UserPreferenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).clearPreferencesForUser("janedoe");

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"user_preference\" where \"user_preference\".\"user_name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }
}
