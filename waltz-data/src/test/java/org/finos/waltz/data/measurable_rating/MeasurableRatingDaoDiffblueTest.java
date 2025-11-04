package org.finos.waltz.data.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.tables.records.MeasurableRatingRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TransactionalCallable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingDaoDiffblueTest {
  /**
   * Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(new DefaultDSLContext(SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findForEntity(ref));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity2() throws SQLException {
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
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<MeasurableRating> actualFindForEntityResult = measurableRatingDao.findForEntity(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\", \"measurable_rating\".\"measurable_id\", \"measurable_rating\".\"rating\", \"measurable_rating\".\"description\", \"measurable_rating\".\"last_updated_at\", \"measurable_rating\".\"last_updated_by\", \"measurable_rating\".\"provenance\", \"measurable_rating\".\"is_readonly\", \"measurable_rating\".\"is_primary\", \"measurable_rating\".\"id\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_name\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"entity_lifecycle_status\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_lifecycle_status\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"description\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"description\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"description\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"description\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_description\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_ext_id\" from \"measurable_rating\" where (\"measurable_rating\".\"entity_kind\" = ? and \"measurable_rating\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(21), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test: {@link MeasurableRatingDao#getById(long)}
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
    MeasurableRating actualById = (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\", \"measurable_rating\".\"measurable_id\", \"measurable_rating\".\"rating\", \"measurable_rating\".\"description\", \"measurable_rating\".\"last_updated_at\", \"measurable_rating\".\"last_updated_by\", \"measurable_rating\".\"provenance\", \"measurable_rating\".\"is_readonly\", \"measurable_rating\".\"is_primary\", \"measurable_rating\".\"id\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_name\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"entity_lifecycle_status\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_lifecycle_status\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"description\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"description\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"description\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"description\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_description\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_ext_id\" from \"measurable_rating\" where \"measurable_rating\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(20), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  void testGetByDecommId() throws SQLException {
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
    MeasurableRating actualByDecommId = (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByDecommId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\", \"measurable_rating\".\"measurable_id\", \"measurable_rating\".\"rating\", \"measurable_rating\".\"description\", \"measurable_rating\".\"last_updated_at\", \"measurable_rating\".\"last_updated_by\", \"measurable_rating\".\"provenance\", \"measurable_rating\".\"is_readonly\", \"measurable_rating\".\"is_primary\", \"measurable_rating\".\"id\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_name\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"entity_lifecycle_status\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_lifecycle_status\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"description\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"description\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"description\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"description\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_description\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_ext_id\" from \"measurable_rating\" join \"measurable_rating_planned_decommission\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating_planned_decommission\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(20), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByDecommId);
  }

  /**
   * Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  void testFindByCategory() throws SQLException {
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
    Collection<MeasurableRating> actualFindByCategoryResult = (new MeasurableRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByCategory(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\", \"measurable_rating\".\"measurable_id\", \"measurable_rating\".\"rating\", \"measurable_rating\".\"description\", \"measurable_rating\".\"last_updated_at\", \"measurable_rating\".\"last_updated_by\", \"measurable_rating\".\"provenance\", \"measurable_rating\".\"is_readonly\", \"measurable_rating\".\"is_primary\", \"measurable_rating\".\"id\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_name\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"entity_lifecycle_status\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select ? from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_lifecycle_status\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"description\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"description\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"description\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"description\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_description\", case when \"measurable_rating\".\"entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"measurable_rating\".\"entity_id\") when \"measurable_rating\".\"entity_kind\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"measurable_rating\".\"entity_id\") end \"entity_ext_id\" from \"measurable_rating\" join \"measurable\" on \"measurable_rating\".\"measurable_id\" = \"measurable\".\"id\" where \"measurable\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(20), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByCategoryResult instanceof List);
    assertTrue(actualFindByCategoryResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  void testTallyByMeasurableCategoryId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    List<Tally<Long>> actualTallyByMeasurableCategoryIdResult = (new MeasurableRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).tallyByMeasurableCategoryId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_rating\".\"measurable_id\", count(*) from \"measurable_rating\" join \"measurable\" on \"measurable\".\"id\" = \"measurable_rating\".\"measurable_id\" join \"application\" on (\"application\".\"id\" = \"measurable_rating\".\"entity_id\" and \"measurable_rating\".\"entity_kind\" = ?) where (\"measurable\".\"measurable_category_id\" = ? and \"application\".\"entity_lifecycle_status\" <> ?) group by \"measurable_rating\".\"measurable_id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualTallyByMeasurableCategoryIdResult.size());
    Tally<Long> getResult = actualTallyByMeasurableCategoryIdResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<Long> getResult2 = actualTallyByMeasurableCategoryIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals(1.0d, getResult.count());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  void testRemoveForCategory() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> (new MeasurableRatingDao(dsl)).removeForCategory(null, 1L));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  void testRemoveForCategory2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any())).thenReturn(deleteUsingStep);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualRemoveForCategoryResult = measurableRatingDao.removeForCategory(ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveForCategoryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  void testRemoveForCategory3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new NotFoundException("Code", "An error occurred"));
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any())).thenReturn(deleteUsingStep);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.removeForCategory(ref, 1L));
    verify(ref).id();
    verify(ref).kind();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}
   */
  @Test
  void testCalculateAmendedAllocationOperations() throws SQLException {
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
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    HashSet<Operation> operationsForAllocation = new HashSet<>();

    // Act
    Set<Operation> actualCalculateAmendedAllocationOperationsResult = measurableRatingDao
        .calculateAmendedAllocationOperations(operationsForAllocation, 1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"measurable_category\" join \"user_role\" on (\"user_role\".\"role\" = \"measurable_category\".\"rating_editor_role\" and \"user_role\".\"user_name\" = ?) where \"measurable_category\".\"id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCalculateAmendedAllocationOperationsResult.isEmpty());
    assertSame(operationsForAllocation, actualCalculateAmendedAllocationOperationsResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}
   */
  @Test
  void testCalculateAmendedAllocationOperations2() throws SQLException {
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedAllocationOperationsResult = measurableRatingDao
        .calculateAmendedAllocationOperations(new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"measurable_category\" join \"user_role\" on (\"user_role\".\"role\" = \"measurable_category\".\"rating_editor_role\" and \"user_role\".\"user_name\" = ?) where \"measurable_category\".\"id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedAllocationOperationsResult.size());
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}
   */
  @Test
  void testCalculateAmendedAllocationOperations3() throws SQLException {
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
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedAllocationOperationsResult = measurableRatingDao
        .calculateAmendedAllocationOperations(new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"measurable_category\" join \"user_role\" on (\"user_role\".\"role\" = \"measurable_category\".\"rating_editor_role\" and \"user_role\".\"user_name\" = ?) where \"measurable_category\".\"id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedAllocationOperationsResult.size());
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  void testMigrateRatings() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).migrateRatings(1L, 1L, "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(eq(1), eq(4));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(6), Mockito.<Timestamp>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getUpdateCount();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  void testMigrateRatings2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(0);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).migrateRatings(1L, 1L, "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(eq(1), eq(4));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getUpdateCount();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  void testMigrateRatings3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.CUBRID))).migrateRatings(1L, 1L, "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(eq(1), eq(4));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(6), Mockito.<Timestamp>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getUpdateCount();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  void testMigrateRatings4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new MeasurableRatingDao(mock(DSLContext.class))).migrateRatings(1L, null, "42"));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}
   */
  @Test
  void testGetSharedRatingsCount() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(3);
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

    // Act
    int actualSharedRatingsCount = (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getSharedRatingsCount(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating\" where \"measurable_rating\".\"measurable_id\" = ? intersect select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating\" where \"measurable_rating\".\"measurable_id\" = ?) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}
   */
  @Test
  void testGetSharedRatingsCount2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualSharedRatingsCount = (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getSharedRatingsCount(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating\" where \"measurable_rating\".\"measurable_id\" = ? intersect select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating\" where \"measurable_rating\".\"measurable_id\" = ?) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}
   */
  @Test
  void testGetSharedDecommsCount() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(3);
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

    // Act
    int actualSharedDecommsCount = (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getSharedDecommsCount(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating_planned_decommission\" join \"measurable_rating\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating\".\"measurable_id\" = ? intersect select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating_planned_decommission\" join \"measurable_rating\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating\".\"measurable_id\" = ?) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}
   */
  @Test
  void testGetSharedDecommsCount2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualSharedDecommsCount = (new MeasurableRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getSharedDecommsCount(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating_planned_decommission\" join \"measurable_rating\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating\".\"measurable_id\" = ? intersect select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating_planned_decommission\" join \"measurable_rating\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating\".\"measurable_id\" = ?) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(true);

    // Act
    boolean actualSaveRatingIsPrimaryResult = (new MeasurableRatingDao(dsl)).saveRatingIsPrimary(null, 1L, true,
        "janedoe");

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary2() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(false);

    // Act
    boolean actualSaveRatingIsPrimaryResult = (new MeasurableRatingDao(dsl)).saveRatingIsPrimary(null, 1L, true,
        "janedoe");

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertFalse(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingDescription() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(true);

    // Act
    boolean actualSaveRatingDescriptionResult = (new MeasurableRatingDao(dsl)).saveRatingDescription(null, 1L,
        "The characteristics of someone or something", "janedoe");

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertTrue(actualSaveRatingDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingDescription2() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(false);

    // Act
    boolean actualSaveRatingDescriptionResult = (new MeasurableRatingDao(dsl)).saveRatingDescription(null, 1L,
        "The characteristics of someone or something", "janedoe");

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertFalse(actualSaveRatingDescriptionResult);
  }
}
