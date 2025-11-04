package org.finos.waltz.data.roadmap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.List;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.roadmap.Roadmap;
import org.finos.waltz.schema.tables.records.RoadmapRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RoadmapDaoDiffblueTest {
  /**
   * Method under test: {@link RoadmapDao#getById(long)}
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
    Roadmap actualById = (new RoadmapDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"roadmap\".\"row_type_kind\" = ? then (select \"measurable_category\".\"name\" from \"measurable_category\" where \"measurable_category\".\"id\" = \"roadmap\".\"row_type_id\") end \"rowTypeName\", case when \"roadmap\".\"column_type_kind\" = ? then (select \"measurable_category\".\"name\" from \"measurable_category\" where \"measurable_category\".\"id\" = \"roadmap\".\"column_type_id\") end \"colTypeName\", \"roadmap\".\"id\", \"roadmap\".\"name\", \"roadmap\".\"description\", \"roadmap\".\"row_type_kind\", \"roadmap\".\"rating_scheme_id\", \"roadmap\".\"row_type_id\", \"roadmap\".\"column_type_kind\", \"roadmap\".\"column_type_id\", \"roadmap\".\"last_updated_at\", \"roadmap\".\"last_updated_by\", \"roadmap\".\"entity_lifecycle_status\" from \"roadmap\" where \"roadmap\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("MEASURABLE_CATEGORY"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link RoadmapDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
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
    Collection<Roadmap> actualFindAllResult = (new RoadmapDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"roadmap\".\"row_type_kind\" = ? then (select \"measurable_category\".\"name\" from \"measurable_category\" where \"measurable_category\".\"id\" = \"roadmap\".\"row_type_id\") end \"rowTypeName\", case when \"roadmap\".\"column_type_kind\" = ? then (select \"measurable_category\".\"name\" from \"measurable_category\" where \"measurable_category\".\"id\" = \"roadmap\".\"column_type_id\") end \"colTypeName\", \"roadmap\".\"id\", \"roadmap\".\"name\", \"roadmap\".\"description\", \"roadmap\".\"row_type_kind\", \"roadmap\".\"rating_scheme_id\", \"roadmap\".\"row_type_id\", \"roadmap\".\"column_type_kind\", \"roadmap\".\"column_type_id\", \"roadmap\".\"last_updated_at\", \"roadmap\".\"last_updated_by\", \"roadmap\".\"entity_lifecycle_status\" from \"roadmap\" order by \"roadmap\".\"name\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("MEASURABLE_CATEGORY"));
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
   * Method under test: {@link RoadmapDao#findAllActive()}
   */
  @Test
  void testFindAllActive() throws SQLException {
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
    Collection<Roadmap> actualFindAllActiveResult = (new RoadmapDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAllActive();

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"roadmap\".\"row_type_kind\" = ? then (select \"measurable_category\".\"name\" from \"measurable_category\" where \"measurable_category\".\"id\" = \"roadmap\".\"row_type_id\") end \"rowTypeName\", case when \"roadmap\".\"column_type_kind\" = ? then (select \"measurable_category\".\"name\" from \"measurable_category\" where \"measurable_category\".\"id\" = \"roadmap\".\"column_type_id\") end \"colTypeName\", \"roadmap\".\"id\", \"roadmap\".\"name\", \"roadmap\".\"description\", \"roadmap\".\"row_type_kind\", \"roadmap\".\"rating_scheme_id\", \"roadmap\".\"row_type_id\", \"roadmap\".\"column_type_kind\", \"roadmap\".\"column_type_id\", \"roadmap\".\"last_updated_at\", \"roadmap\".\"last_updated_by\", \"roadmap\".\"entity_lifecycle_status\" from \"roadmap\" where \"roadmap\".\"entity_lifecycle_status\" = ? order by \"roadmap\".\"name\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllActiveResult instanceof List);
    assertTrue(actualFindAllActiveResult.isEmpty());
  }

  /**
   * Method under test: {@link RoadmapDao#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualUpdateDescriptionResult = (new RoadmapDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateDescription(1L, "42", "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"roadmap\" set \"roadmap\".\"description\" = ?, \"roadmap\".\"last_updated_at\" = ?, \"roadmap\".\"last_updated_by\" = ? where \"roadmap\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Method under test: {@link RoadmapDao#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateDescriptionResult = (new RoadmapDao(dsl)).updateDescription(1L, "42", "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test: {@link RoadmapDao#updateName(long, String, String)}
   */
  @Test
  void testUpdateName() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualUpdateNameResult = (new RoadmapDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateName(1L, "42", "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"roadmap\" set \"roadmap\".\"name\" = ?, \"roadmap\".\"last_updated_at\" = ?, \"roadmap\".\"last_updated_by\" = ? where \"roadmap\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link RoadmapDao#updateName(long, String, String)}
   */
  @Test
  void testUpdateName2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateNameResult = (new RoadmapDao(dsl)).updateName(1L, "42", "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test:
   * {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateLifecycleStatus() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualUpdateLifecycleStatusResult = (new RoadmapDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"roadmap\" set \"roadmap\".\"entity_lifecycle_status\" = ?, \"roadmap\".\"last_updated_at\" = ?, \"roadmap\".\"last_updated_by\" = ? where \"roadmap\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateLifecycleStatusResult);
  }

  /**
   * Method under test:
   * {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateLifecycleStatus2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateLifecycleStatusResult = (new RoadmapDao(dsl)).updateLifecycleStatus(1L,
        EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateLifecycleStatusResult);
  }
}
