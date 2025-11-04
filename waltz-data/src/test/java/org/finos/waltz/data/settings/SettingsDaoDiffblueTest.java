package org.finos.waltz.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.model.settings.Setting;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SettingsDaoDiffblueTest {
  /**
   * Method under test: {@link SettingsDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    Collection<Setting> actualFindAllResult = (new SettingsDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"settings\".\"name\", \"settings\".\"value\", \"settings\".\"restricted\", \"settings\".\"description\" from \"settings\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(3));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult instanceof List);
    assertEquals(2, actualFindAllResult.size());
    Setting getResult = ((List<Setting>) actualFindAllResult).get(0);
    assertTrue(getResult instanceof ImmutableSetting);
    Setting getResult2 = ((List<Setting>) actualFindAllResult).get(1);
    assertTrue(getResult2 instanceof ImmutableSetting);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertTrue(getResult.restricted());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SettingsDao#findAll()}
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
    Collection<Setting> actualFindAllResult = (new SettingsDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"settings\".\"name\", \"settings\".\"value\", \"settings\".\"restricted\", \"settings\".\"description\" from \"settings\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link SettingsDao#getByName(String)}
   */
  @Test
  void testGetByName() throws SQLException {
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
    Setting actualByName = (new SettingsDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getByName("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"settings\".\"name\", \"settings\".\"value\", \"settings\".\"restricted\", \"settings\".\"description\" from \"settings\" where \"settings\".\"name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Name"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByName);
  }

  /**
   * Method under test: {@link SettingsDao#getByName(String)}
   */
  @Test
  void testGetByName2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    Setting actualByName = (new SettingsDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getByName("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"settings\".\"name\", \"settings\".\"value\", \"settings\".\"restricted\", \"settings\".\"description\" from \"settings\" where \"settings\".\"name\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Name"));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(3));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualByName instanceof ImmutableSetting);
    assertEquals("String", actualByName.description());
    assertEquals("String", actualByName.name());
    assertTrue(actualByName.restricted());
  }

  /**
   * Method under test: {@link SettingsDao#indexByPrefix(String)}
   */
  @Test
  void testIndexByPrefix() throws SQLException {
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
    Map<String, String> actualIndexByPrefixResult = (new SettingsDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).indexByPrefix("Prefix");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"settings\".\"name\", \"settings\".\"value\" from \"settings\" where (\"settings\".\"name\" like (replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%') escape '!' and \"settings\".\"restricted\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Prefix"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIndexByPrefixResult.isEmpty());
  }

  /**
   * Method under test: {@link SettingsDao#indexByPrefix(String)}
   */
  @Test
  void testIndexByPrefix2() throws SQLException {
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
    Map<String, String> actualIndexByPrefixResult = (new SettingsDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).indexByPrefix("Prefix");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"settings\".\"name\", \"settings\".\"value\" from \"settings\" where (\"settings\".\"name\" like (replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%') escape '!' and \"settings\".\"restricted\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Prefix"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualIndexByPrefixResult.size());
    assertEquals("String", actualIndexByPrefixResult.get("String"));
  }
}
