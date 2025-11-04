package org.finos.waltz.data.measurable_rating_replacement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingReplacementDaoDiffblueTest {
  /**
   * Method under test: {@link MeasurableRatingReplacementDao#getById(Long)}
   */
  @Test
  void testGetById() throws SQLException {
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
    MeasurableRatingReplacement actualById = (new MeasurableRatingReplacementDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating_replacement\".\"id\", \"measurable_rating_replacement\".\"decommission_id\", \"measurable_rating_replacement\".\"planned_commission_date\", \"measurable_rating_replacement\".\"entity_id\", \"measurable_rating_replacement\".\"entity_kind\", \"measurable_rating_replacement\".\"created_by\", \"measurable_rating_replacement\".\"created_at\", \"measurable_rating_replacement\".\"updated_by\", \"measurable_rating_replacement\".\"updated_at\", case when \"measurable_rating_replacement\".\"entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"measurable_rating_replacement\".\"entity_id\") end from \"measurable_rating_replacement\" where \"measurable_rating_replacement\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementDao#fetchByDecommissionId(Long)}
   */
  @Test
  void testFetchByDecommissionId() throws SQLException {
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
    Set<MeasurableRatingReplacement> actualFetchByDecommissionIdResult = (new MeasurableRatingReplacementDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).fetchByDecommissionId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating_replacement\".\"id\", \"measurable_rating_replacement\".\"decommission_id\", \"measurable_rating_replacement\".\"planned_commission_date\", \"measurable_rating_replacement\".\"entity_id\", \"measurable_rating_replacement\".\"entity_kind\", \"measurable_rating_replacement\".\"created_by\", \"measurable_rating_replacement\".\"created_at\", \"measurable_rating_replacement\".\"updated_by\", \"measurable_rating_replacement\".\"updated_at\", case when \"measurable_rating_replacement\".\"entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"measurable_rating_replacement\".\"entity_id\") end from \"measurable_rating_replacement\" where \"measurable_rating_replacement\".\"decommission_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFetchByDecommissionIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementDao#calculateAmendedReplacementOperations(Set, long, String)}
   */
  @Test
  void testCalculateAmendedReplacementOperations() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = new MeasurableRatingReplacementDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedReplacementOperationsResult = measurableRatingReplacementDao
        .calculateAmendedReplacementOperations(new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user_role\".\"role\" from \"measurable_category\" left outer join \"user_role\" on (\"user_role\".\"role\" = \"measurable_category\".\"rating_editor_role\" and \"user_role\".\"user_name\" = ?) where \"measurable_category\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedReplacementOperationsResult.size());
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementDao#calculateAmendedReplacementOperations(Set, long, String)}
   */
  @Test
  void testCalculateAmendedReplacementOperations2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = new MeasurableRatingReplacementDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedReplacementOperationsResult = measurableRatingReplacementDao
        .calculateAmendedReplacementOperations(new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user_role\".\"role\" from \"measurable_category\" left outer join \"user_role\" on (\"user_role\".\"role\" = \"measurable_category\".\"rating_editor_role\" and \"user_role\".\"user_name\" = ?) where \"measurable_category\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedReplacementOperationsResult.size());
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.UPDATE));
  }
}
