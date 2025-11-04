package org.finos.waltz.data.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableComplexityDaoDiffblueTest {
  /**
   * Method under test: {@link MeasurableComplexityDao#calculateBaseline()}
   */
  @Test
  void testCalculateBaseline() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBigDecimal(anyInt())).thenReturn(new BigDecimal("2.3"));
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Double actualCalculateBaselineResult = (new MeasurableComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).calculateBaseline();

    // Assert
    verify(connection).prepareStatement(eq(
        "select max(score) from (select \"measurable_rating\".\"entity_id\", sum(coalesce((? / nullif(\"entity_hierarchy\".\"level\",?)), ?)) \"score\" from \"measurable_rating\" join \"entity_hierarchy\" on \"entity_hierarchy\".\"id\" = \"measurable_rating\".\"measurable_id\" where (1 = 1 and \"entity_hierarchy\".\"kind\" = ? and \"measurable_rating\".\"entity_kind\" = ?) group by \"measurable_rating\".\"entity_id\") \"alias_44076726\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getBigDecimal(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2.3d, actualCalculateBaselineResult.doubleValue());
  }

  /**
   * Method under test: {@link MeasurableComplexityDao#calculateBaseline()}
   */
  @Test
  void testCalculateBaseline2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Double actualCalculateBaselineResult = (new MeasurableComplexityDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).calculateBaseline();

    // Assert
    verify(connection).prepareStatement(eq(
        "select max(score) from (select \"measurable_rating\".\"entity_id\", sum(coalesce((? / nullif(\"entity_hierarchy\".\"level\",?)), ?)) \"score\" from \"measurable_rating\" join \"entity_hierarchy\" on \"entity_hierarchy\".\"id\" = \"measurable_rating\".\"measurable_id\" where (1 = 1 and \"entity_hierarchy\".\"kind\" = ? and \"measurable_rating\".\"entity_kind\" = ?) group by \"measurable_rating\".\"entity_id\") \"alias_44076726\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3.0d, actualCalculateBaselineResult.doubleValue());
  }
}
