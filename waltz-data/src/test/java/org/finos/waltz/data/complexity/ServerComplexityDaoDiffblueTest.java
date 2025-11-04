package org.finos.waltz.data.complexity;

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
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServerComplexityDaoDiffblueTest {
  /**
   * Method under test:
   * {@link ServerComplexityDao#findCountsByAssetCodes(String[])}
   */
  @Test
  void testFindCountsByAssetCodes() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<Tally<String>> actualFindCountsByAssetCodesResult = (new ServerComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCountsByAssetCodes("Asset Codes");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"asset_code\", count(*) \"server_count\" from \"server_information\" join \"server_usage\" on \"server_usage\".\"server_id\" = \"server_information\".\"id\" join \"application\" on (\"application\".\"id\" = \"server_usage\".\"entity_id\" and \"server_usage\".\"entity_kind\" = ?) where \"application\".\"asset_code\" in (?) group by \"application\".\"asset_code\" order by \"server_count\" desc"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindCountsByAssetCodesResult.size());
    Tally<String> getResult = actualFindCountsByAssetCodesResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<String> getResult2 = actualFindCountsByAssetCodesResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals("String", getResult.id());
    assertEquals(1.0d, getResult.count());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ServerComplexityDao#calculateBaseline()}
   */
  @Test
  void testCalculateBaseline() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    int actualCalculateBaselineResult = (new ServerComplexityDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .calculateBaseline();

    // Assert
    verify(connection).prepareStatement(eq(
        "select max(\"server_count\") from (select \"server_usage\".\"entity_id\", count(*) \"server_count\" from \"server_usage\" where (1 = 1 and \"server_usage\".\"entity_kind\" = ?) group by \"server_usage\".\"entity_id\") \"alias_51382369\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualCalculateBaselineResult);
  }

  /**
   * Method under test: {@link ServerComplexityDao#calculateBaseline()}
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
    int actualCalculateBaselineResult = (new ServerComplexityDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .calculateBaseline();

    // Assert
    verify(connection).prepareStatement(eq(
        "select max(\"server_count\") from (select \"server_usage\".\"entity_id\", count(*) \"server_count\" from \"server_usage\" where (1 = 1 and \"server_usage\".\"entity_kind\" = ?) group by \"server_usage\".\"entity_id\") \"alias_51382369\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateBaselineResult);
  }

  /**
   * Method under test: {@link ServerComplexityDao#findCounts()}
   */
  @Test
  void testFindCounts() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<Tally<String>> actualFindCountsResult = (new ServerComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCounts();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"asset_code\", count(*) \"server_count\" from \"server_information\" join \"server_usage\" on \"server_usage\".\"server_id\" = \"server_information\".\"id\" join \"application\" on (\"application\".\"id\" = \"server_usage\".\"entity_id\" and \"server_usage\".\"entity_kind\" = ?) where 1 = 1 group by \"application\".\"asset_code\" order by \"server_count\" desc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindCountsResult.size());
    Tally<String> getResult = actualFindCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<String> getResult2 = actualFindCountsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals("String", getResult.id());
    assertEquals(1.0d, getResult.count());
    assertEquals(getResult, getResult2);
  }
}
