package org.finos.waltz.service.system_version;

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
import java.util.List;
import org.finos.waltz.model.system_version.ImmutableSystemVersionInfo;
import org.finos.waltz.model.system_version.SystemVersionInfo;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SystemVersionServiceDiffblueTest {
  /**
   * Method under test: {@link SystemVersionService#getVersionInfo()}
   */
  @Test
  void testGetVersionInfo() throws SQLException {
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
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SystemVersionInfo actualVersionInfo = (new SystemVersionService(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getVersionInfo();

    // Assert
    verify(connection).prepareStatement(eq(
        "with \"raw\"(\"filename\", \"rn\") as (select \"databasechangelog\".\"filename\", row_number() over (partition by \"databasechangelog\".\"filename\" order by \"databasechangelog\".\"dateexecuted\") from \"databasechangelog\" order by \"databasechangelog\".\"dateexecuted\" desc) select filename from \"raw\" where rn = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualVersionInfo instanceof ImmutableSystemVersionInfo);
    List<String> databaseVersionsResult = actualVersionInfo.databaseVersions();
    assertEquals(2, databaseVersionsResult.size());
    assertEquals("String", databaseVersionsResult.get(0));
    assertEquals("String", databaseVersionsResult.get(1));
    assertEquals("null - null - null", actualVersionInfo.packageVersion());
  }

  /**
   * Method under test: {@link SystemVersionService#getVersionInfo()}
   */
  @Test
  void testGetVersionInfo2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SystemVersionInfo actualVersionInfo = (new SystemVersionService(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getVersionInfo();

    // Assert
    verify(connection).prepareStatement(eq(
        "with \"raw\"(\"filename\", \"rn\") as (select \"databasechangelog\".\"filename\", row_number() over (partition by \"databasechangelog\".\"filename\" order by \"databasechangelog\".\"dateexecuted\") from \"databasechangelog\" order by \"databasechangelog\".\"dateexecuted\" desc) select filename from \"raw\" where rn = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualVersionInfo instanceof ImmutableSystemVersionInfo);
    assertEquals("null - null - null", actualVersionInfo.packageVersion());
    assertTrue(actualVersionInfo.databaseVersions().isEmpty());
  }

  /**
   * Method under test: {@link SystemVersionService#getVersionInfo()}
   */
  @Test
  void testGetVersionInfo3() throws SQLException {
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
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SystemVersionInfo actualVersionInfo = (new SystemVersionService(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getVersionInfo();

    // Assert
    verify(connection).prepareStatement(eq(
        "with \"raw\"(\"filename\", \"rn\") as (select \"databasechangelog\".\"filename\", row_number() over (partition by \"databasechangelog\".\"filename\" order by \"databasechangelog\".\"dateexecuted\") from \"databasechangelog\" order by \"databasechangelog\".\"dateexecuted\" desc) select filename from \"raw\" where rn = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualVersionInfo instanceof ImmutableSystemVersionInfo);
    List<String> databaseVersionsResult = actualVersionInfo.databaseVersions();
    assertEquals(1, databaseVersionsResult.size());
    assertEquals("String", databaseVersionsResult.get(0));
    assertEquals("null - null - null", actualVersionInfo.packageVersion());
  }
}
