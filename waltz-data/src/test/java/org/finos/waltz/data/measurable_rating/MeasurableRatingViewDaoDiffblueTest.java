package org.finos.waltz.data.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.Set;
import org.finos.waltz.model.measurable_rating.PrimaryRatingViewItem;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingViewDaoDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingViewDao#findPrimaryRatingsForApp(long)}
   */
  @Test
  void testFindPrimaryRatingsForApp() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<PrimaryRatingViewItem> actualFindPrimaryRatingsForAppResult = (new MeasurableRatingViewDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPrimaryRatingsForApp(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\", \"measurable_category\".\"name\", \"measurable_category\".\"description\", \"measurable\".\"id\", \"measurable\".\"name\", \"measurable\".\"description\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"color\" from \"measurable_rating\" join \"measurable\" on \"measurable\".\"id\" = \"measurable_rating\".\"measurable_id\" join \"measurable_category\" on \"measurable_category\".\"id\" = \"measurable\".\"measurable_category_id\" join \"rating_scheme_item\" on (\"measurable_rating\".\"rating\" = \"rating_scheme_item\".\"code\" and \"rating_scheme_item\".\"scheme_id\" = \"measurable_category\".\"rating_scheme_id\") where (\"measurable_rating\".\"entity_kind\" = ? and \"measurable_rating\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindPrimaryRatingsForAppResult.size());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewDao#findPrimaryRatingsForApp(long)}
   */
  @Test
  void testFindPrimaryRatingsForApp2() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<PrimaryRatingViewItem> actualFindPrimaryRatingsForAppResult = (new MeasurableRatingViewDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPrimaryRatingsForApp(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\", \"measurable_category\".\"name\", \"measurable_category\".\"description\", \"measurable\".\"id\", \"measurable\".\"name\", \"measurable\".\"description\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"color\" from \"measurable_rating\" join \"measurable\" on \"measurable\".\"id\" = \"measurable_rating\".\"measurable_id\" join \"measurable_category\" on \"measurable_category\".\"id\" = \"measurable\".\"measurable_category_id\" join \"rating_scheme_item\" on (\"measurable_rating\".\"rating\" = \"rating_scheme_item\".\"code\" and \"rating_scheme_item\".\"scheme_id\" = \"measurable_category\".\"rating_scheme_id\") where (\"measurable_rating\".\"entity_kind\" = ? and \"measurable_rating\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPrimaryRatingsForAppResult.isEmpty());
  }
}
