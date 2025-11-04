package org.finos.waltz.data.shared_preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreference;
import org.finos.waltz.model.shared_preference.SharedPreference;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SharedPreferenceDaoDiffblueTest {
  /**
   * Method under test: {@link SharedPreferenceDao#getPreference(String, String)}
   */
  @Test
  void testGetPreference() throws SQLException {
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
    SharedPreference actualPreference = (new SharedPreferenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getPreference("Key", "Category");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"shared_preference\".\"key\", \"shared_preference\".\"category\", \"shared_preference\".\"value\", \"shared_preference\".\"last_updated_at\", \"shared_preference\".\"last_updated_by\" from \"shared_preference\" where (\"shared_preference\".\"category\" = ? and \"shared_preference\".\"key\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualPreference);
  }

  /**
   * Method under test: {@link SharedPreferenceDao#getPreference(String, String)}
   */
  @Test
  void testGetPreference2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
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
    SharedPreference actualPreference = (new SharedPreferenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getPreference("Key", "Category");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"shared_preference\".\"key\", \"shared_preference\".\"category\", \"shared_preference\".\"value\", \"shared_preference\".\"last_updated_at\", \"shared_preference\".\"last_updated_by\" from \"shared_preference\" where (\"shared_preference\".\"category\" = ? and \"shared_preference\".\"key\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    assertTrue(actualPreference instanceof ImmutableSharedPreference);
    LocalDateTime lastUpdatedAtResult = actualPreference.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", actualPreference.lastUpdatedBy());
    assertEquals("String", actualPreference.category());
    assertEquals("String", actualPreference.key());
    assertEquals("String", actualPreference.value());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link SharedPreferenceDao#findPreferencesByCategory(String)}
   */
  @Test
  void testFindPreferencesByCategory() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SharedPreference> actualFindPreferencesByCategoryResult = (new SharedPreferenceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPreferencesByCategory("Category");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"shared_preference\".\"key\", \"shared_preference\".\"category\", \"shared_preference\".\"value\", \"shared_preference\".\"last_updated_at\", \"shared_preference\".\"last_updated_by\" from \"shared_preference\" where \"shared_preference\".\"category\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Category"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindPreferencesByCategoryResult.size());
    SharedPreference getResult = actualFindPreferencesByCategoryResult.get(0);
    assertTrue(getResult instanceof ImmutableSharedPreference);
    SharedPreference getResult2 = actualFindPreferencesByCategoryResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSharedPreference);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.category());
    assertEquals("String", getResult.key());
    assertEquals("String", getResult.value());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link SharedPreferenceDao#findPreferencesByCategory(String)}
   */
  @Test
  void testFindPreferencesByCategory2() throws SQLException {
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
    List<SharedPreference> actualFindPreferencesByCategoryResult = (new SharedPreferenceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPreferencesByCategory("Category");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"shared_preference\".\"key\", \"shared_preference\".\"category\", \"shared_preference\".\"value\", \"shared_preference\".\"last_updated_at\", \"shared_preference\".\"last_updated_by\" from \"shared_preference\" where \"shared_preference\".\"category\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Category"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPreferencesByCategoryResult.isEmpty());
  }
}
