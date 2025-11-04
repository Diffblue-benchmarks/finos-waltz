package org.finos.waltz.data.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKindCreateCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindUsageStat;
import org.finos.waltz.schema.tables.records.InvolvementKindRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.NoDataFoundException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementKindDaoDiffblueTest {
  /**
   * Method under test: {@link InvolvementKindDao#findAll()}
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<InvolvementKind> actualFindAllResult = (new InvolvementKindDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"inv_kind\".\"id\", \"inv_kind\".\"description\", \"inv_kind\".\"last_updated_at\", \"inv_kind\".\"last_updated_by\", \"inv_kind\".\"external_id\", \"inv_kind\".\"user_selectable\", \"inv_kind\".\"subject_kind\", \"inv_kind\".\"name\", \"inv_kind\".\"permitted_role\", \"inv_kind\".\"transitive\" from \"involvement_kind\" \"inv_kind\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link InvolvementKindDao#getById(long)}
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    InvolvementKind actualById = (new InvolvementKindDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement_kind\" where \"involvement_kind\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
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
   * {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(SQLDialect.SQL99));
    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.permittedRole()).thenThrow(new IllegalStateException("command cannot be null"));
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    when(command.subjectKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> involvementKindDao.create(command, "janedoe"));
    verify(command).description();
    verify(command).name();
    verify(command).permittedRole();
    verify(command).subjectKind();
  }

  /**
   * Method under test:
   * {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  void testCreate2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    when(command.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    Long actualCreateResult = involvementKindDao.create(command, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"involvement_kind\" (\"description\", \"last_updated_at\", \"last_updated_by\", \"external_id\", \"subject_kind\", \"name\", \"permitted_role\") values (?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).name();
    verify(command).permittedRole();
    verify(command).subjectKind();
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test:
   * {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  void testCreate3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    when(command.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    Long actualCreateResult = involvementKindDao.create(command, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"involvement_kind\" (\"description\", \"last_updated_at\", \"last_updated_by\", \"external_id\", \"subject_kind\", \"name\", \"permitted_role\") values (?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).name();
    verify(command).permittedRole();
    verify(command).subjectKind();
    assertNull(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link InvolvementKindDao#findKeyInvolvementKindsByEntityKind(EntityKind)}
   */
  @Test
  void testFindKeyInvolvementKindsByEntityKind() throws SQLException {
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
    List<InvolvementKind> actualFindKeyInvolvementKindsByEntityKindResult = (new InvolvementKindDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"inv_kind\".\"id\", \"inv_kind\".\"description\", \"inv_kind\".\"last_updated_at\", \"inv_kind\".\"last_updated_by\", \"inv_kind\".\"external_id\", \"inv_kind\".\"user_selectable\", \"inv_kind\".\"subject_kind\", \"inv_kind\".\"name\", \"inv_kind\".\"permitted_role\", \"inv_kind\".\"transitive\" from \"involvement_kind\" \"inv_kind\" where \"inv_kind\".\"id\" in (select distinct \"key_involvement_kind\".\"involvement_kind_id\" from \"key_involvement_kind\" where \"key_involvement_kind\".\"entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindKeyInvolvementKindsByEntityKindResult.isEmpty());
  }

  /**
   * Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  void testDeleteIfNotUsed() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteIfNotUsedResult = (new InvolvementKindDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteIfNotUsed(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"involvement_kind\" where (\"involvement_kind\".\"id\" = ? and not exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\" from \"involvement\" where \"involvement\".\"kind_id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteIfNotUsedResult);
  }

  /**
   * Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  void testDeleteIfNotUsed2() throws SQLException {
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
    boolean actualDeleteIfNotUsedResult = (new InvolvementKindDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteIfNotUsed(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"involvement_kind\" where (\"involvement_kind\".\"id\" = ? and not exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\" from \"involvement\" where \"involvement\".\"kind_id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualDeleteIfNotUsedResult);
  }

  /**
   * Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  void testDeleteIfNotUsed3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteIfNotUsedResult = (new InvolvementKindDao(dsl)).deleteIfNotUsed(1L);

    // Assert
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualDeleteIfNotUsedResult);
  }

  /**
   * Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  void testDeleteIfNotUsed4() {
    // Arrange
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any())).thenThrow(new NoDataFoundException("An error occurred"));
    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> (new InvolvementKindDao(dsl)).deleteIfNotUsed(1L));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  void testLoadUsageStats() throws SQLException {
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
    Set<InvolvementKindUsageStat> actualLoadUsageStatsResult = (new InvolvementKindDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).loadUsageStats();

    // Assert
    verify(connection).prepareStatement(eq(
        "with \"user_stats\" as (select \"involvement_kind\".\"id\", \"involvement\".\"entity_kind\", \"person\".\"is_removed\", count(distinct \"involvement\".\"employee_id\") \"person_count\" from \"involvement\" join \"involvement_kind\" on \"involvement_kind\".\"id\" = \"involvement\".\"kind_id\" join \"person\" on \"person\".\"employee_id\" = \"involvement\".\"employee_id\" group by \"involvement_kind\".\"id\", \"involvement\".\"entity_kind\", \"person\".\"is_removed\") select \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\", \"user_stats\".\"entity_kind\", \"user_stats\".\"is_removed\", \"user_stats\".\"person_count\" from \"involvement_kind\" left outer join \"user_stats\" on \"user_stats\".\"id\" = \"involvement_kind\".\"id\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualLoadUsageStatsResult.isEmpty());
  }

  /**
   * Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() throws SQLException {
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

    // Act and Assert
    assertThrows(NoDataFoundException.class,
        () -> (new InvolvementKindDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getByExternalId("42"));
    verify(connection).prepareStatement(eq(
        "select \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement_kind\" where \"involvement_kind\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }
}
