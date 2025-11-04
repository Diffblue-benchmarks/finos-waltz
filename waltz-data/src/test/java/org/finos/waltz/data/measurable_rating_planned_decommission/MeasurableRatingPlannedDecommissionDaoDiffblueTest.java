package org.finos.waltz.data.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.finos.waltz.common.exception.ModifyingReadOnlyRecordException;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.command.DateFieldChange;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingPlannedDecommissionDaoDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}
   */
  @Test
  void testCheckIfReadOnly() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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

    // Act and Assert
    assertThrows(ModifyingReadOnlyRecordException.class, () -> MeasurableRatingPlannedDecommissionDao
        .checkIfReadOnly(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L));
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating\".\"is_readonly\" from \"measurable_rating\" join \"measurable_rating_planned_decommission\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating_planned_decommission\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
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
    MeasurableRatingPlannedDecommission actualById = (new MeasurableRatingPlannedDecommissionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating_planned_decommission\".\"id\", \"measurable_rating_planned_decommission\".\"planned_decommission_date\", \"measurable_rating_planned_decommission\".\"created_by\", \"measurable_rating_planned_decommission\".\"created_at\", \"measurable_rating_planned_decommission\".\"updated_by\", \"measurable_rating_planned_decommission\".\"updated_at\", \"measurable_rating_planned_decommission\".\"measurable_rating_id\", coalesce(\"application\".\"actual_retirement_date\", \"application\".\"planned_retirement_date\") from \"measurable_rating_planned_decommission\" join \"measurable_rating\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" join \"measurable\" on \"measurable_rating\".\"measurable_id\" = \"measurable\".\"id\" left outer join \"application\" on (\"measurable_rating\".\"entity_id\" = \"application\".\"id\" and \"measurable_rating\".\"entity_kind\" = ?) where \"measurable_rating_planned_decommission\".\"id\" = ?"));
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
   * {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}
   */
  @Test
  void testSave() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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

    // Act and Assert
    assertThrows(ModifyingReadOnlyRecordException.class,
        () -> (new MeasurableRatingPlannedDecommissionDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).save(1L,
            null, "janedoe"));
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating\".\"is_readonly\" from \"measurable_rating\" where \"measurable_rating\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  void testRemove() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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

    // Act and Assert
    assertThrows(ModifyingReadOnlyRecordException.class,
        () -> (new MeasurableRatingPlannedDecommissionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .remove(1L));
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating\".\"is_readonly\" from \"measurable_rating\" join \"measurable_rating_planned_decommission\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating_planned_decommission\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  void testCalculateAmendedDecommOperations() throws SQLException {
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
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = new MeasurableRatingPlannedDecommissionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedDecommOperationsResult = measurableRatingPlannedDecommissionDao
        .calculateAmendedDecommOperations(new HashSet<>(), 1L, "janedoe");

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
    assertEquals(3, actualCalculateAmendedDecommOperationsResult.size());
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  void testCalculateAmendedDecommOperations2() throws SQLException {
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
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = new MeasurableRatingPlannedDecommissionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedDecommOperationsResult = measurableRatingPlannedDecommissionDao
        .calculateAmendedDecommOperations(new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"user_role\".\"role\" from \"measurable_category\" left outer join \"user_role\" on (\"user_role\".\"role\" = \"measurable_category\".\"rating_editor_role\" and \"user_role\".\"user_name\" = ?) where \"measurable_category\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedDecommOperationsResult.size());
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  void testGetByMeasurableRatingId() throws SQLException {
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
    MeasurableRatingPlannedDecommission actualByMeasurableRatingId = (new MeasurableRatingPlannedDecommissionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByMeasurableRatingId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating_planned_decommission\".\"id\", \"measurable_rating_planned_decommission\".\"planned_decommission_date\", \"measurable_rating_planned_decommission\".\"created_by\", \"measurable_rating_planned_decommission\".\"created_at\", \"measurable_rating_planned_decommission\".\"updated_by\", \"measurable_rating_planned_decommission\".\"updated_at\", \"measurable_rating_planned_decommission\".\"measurable_rating_id\", coalesce(\"application\".\"actual_retirement_date\", \"application\".\"planned_retirement_date\") from \"measurable_rating_planned_decommission\" join \"measurable_rating\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" join \"measurable\" on \"measurable_rating\".\"measurable_id\" = \"measurable\".\"id\" left outer join \"application\" on (\"measurable_rating\".\"entity_id\" = \"application\".\"id\" and \"measurable_rating\".\"entity_kind\" = ?) where \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByMeasurableRatingId);
  }
}
