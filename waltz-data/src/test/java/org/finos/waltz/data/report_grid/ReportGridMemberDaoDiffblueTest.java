package org.finos.waltz.data.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.Set;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.report_grid.ReportGridMember;
import org.finos.waltz.model.report_grid.ReportGridMemberCreateCommand;
import org.finos.waltz.model.report_grid.ReportGridMemberDeleteCommand;
import org.finos.waltz.model.report_grid.ReportGridMemberRole;
import org.finos.waltz.model.report_grid.ReportGridMemberUpdateRoleCommand;
import org.finos.waltz.schema.tables.records.ReportGridMemberRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportGridMemberDaoDiffblueTest {
  /**
   * Method under test: {@link ReportGridMemberDao#findByGridId(Long)}
   */
  @Test
  void testFindByGridId() throws SQLException {
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
    Set<ReportGridMember> actualFindByGridIdResult = (new ReportGridMemberDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByGridId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"report_grid_member\".\"grid_id\", \"report_grid_member\".\"user_id\", \"report_grid_member\".\"role\", \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"report_grid_member\" join \"person\" on \"person\".\"email\" = \"report_grid_member\".\"user_id\" where (\"report_grid_member\".\"grid_id\" = ? and \"person\".\"is_removed\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByGridIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}
   */
  @Test
  void testRegister() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualRegisterResult = (new ReportGridMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .register(1L, "janedoe", ReportGridMemberRole.VIEWER);

    // Assert
    verify(connection).prepareStatement(
        eq("insert into \"report_grid_member\" (\"grid_id\", \"user_id\", \"role\") values (?, ?, ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRegisterResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}
   */
  @Test
  void testRegister2() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetStep<ReportGridMemberRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualRegisterResult = (new ReportGridMemberDao(dsl)).register(1L, "janedoe", ReportGridMemberRole.VIEWER);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualRegisterResult);
  }

  /**
   * Method under test: {@link ReportGridMemberDao#canUpdate(long, String)}
   */
  @Test
  void testCanUpdate() throws SQLException {
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
    boolean actualCanUpdateResult = (new ReportGridMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .canUpdate(1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"report_grid_member\".\"grid_id\" from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = ? and \"report_grid_member\".\"user_id\" = ? and \"report_grid_member\".\"role\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertFalse(actualCanUpdateResult);
  }

  /**
   * Method under test: {@link ReportGridMemberDao#canUpdate(long, String)}
   */
  @Test
  void testCanUpdate2() throws SQLException {
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

    // Act
    boolean actualCanUpdateResult = (new ReportGridMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .canUpdate(1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"report_grid_member\".\"grid_id\" from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = ? and \"report_grid_member\".\"user_id\" = ? and \"report_grid_member\".\"role\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Method under test: {@link ReportGridMemberDao#canUpdate(long, String)}
   */
  @Test
  void testCanUpdate3() throws SQLException {
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

    // Act
    boolean actualCanUpdateResult = (new ReportGridMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .canUpdate(1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"report_grid_member\".\"grid_id\" from \"report_grid_member\" where (\"report_grid_member\".\"grid_id\" = ? and \"report_grid_member\".\"user_id\" = ? and \"report_grid_member\".\"role\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberDao#updateUserRole(long, ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  void testUpdateUserRole() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ReportGridMemberRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<ReportGridMemberRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<ReportGridMemberRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);
    ReportGridMemberUpdateRoleCommand updateCommand = mock(ReportGridMemberUpdateRoleCommand.class);
    when(updateCommand.userId()).thenReturn("42");
    when(updateCommand.role()).thenReturn(ReportGridMemberRole.VIEWER);

    // Act
    int actualUpdateUserRoleResult = reportGridMemberDao.updateUserRole(1L, updateCommand);

    // Assert
    verify(updateCommand).role();
    verify(updateCommand).userId();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateUserRoleResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}
   */
  @Test
  void testDelete() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ReportGridMemberRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<ReportGridMemberRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(deleteUsingStep);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);
    ReportGridMemberDeleteCommand command = mock(ReportGridMemberDeleteCommand.class);
    when(command.userId()).thenReturn("42");
    when(command.gridId()).thenReturn(1L);

    // Act
    boolean actualDeleteResult = reportGridMemberDao.delete(command);

    // Assert
    verify(command).gridId();
    verify(command).userId();
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)}
   */
  @Test
  void testDelete2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ReportGridMemberRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);
    DeleteUsingStep<ReportGridMemberRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(deleteUsingStep);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);
    ReportGridMemberDeleteCommand command = mock(ReportGridMemberDeleteCommand.class);
    when(command.userId()).thenReturn("42");
    when(command.gridId()).thenReturn(1L);

    // Act
    boolean actualDeleteResult = reportGridMemberDao.delete(command);

    // Assert
    verify(command).gridId();
    verify(command).userId();
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link ReportGridMemberDao#findPeopleByGridId(Long)}
   */
  @Test
  void testFindPeopleByGridId() throws SQLException {
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
    Set<Person> actualFindPeopleByGridIdResult = (new ReportGridMemberDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPeopleByGridId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"report_grid_member\" join \"person\" on \"person\".\"email\" = \"report_grid_member\".\"user_id\" where \"report_grid_member\".\"grid_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPeopleByGridIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)}
   */
  @Test
  void testUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ReportGridMemberRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);
    UpdateSetMoreStep<ReportGridMemberRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<ReportGridMemberRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<ReportGridMemberRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetStep<ReportGridMemberRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<Record>>any())).thenReturn(mock(InsertSetStep.class));
    when(dsl.insertInto(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(insertSetStep);
    when(dsl.update(Mockito.<Table<ReportGridMemberRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridMemberDao reportGridMemberDao = new ReportGridMemberDao(dsl);
    ReportGridMemberCreateCommand updateCommand = mock(ReportGridMemberCreateCommand.class);
    when(updateCommand.userId()).thenReturn("42");
    when(updateCommand.gridId()).thenReturn(1L);
    when(updateCommand.role()).thenReturn(ReportGridMemberRole.VIEWER);

    // Act
    int actualUpdateResult = reportGridMemberDao.update(updateCommand, "janedoe");

    // Assert
    verify(updateCommand, atLeast(1)).gridId();
    verify(updateCommand, atLeast(1)).role();
    verify(updateCommand, atLeast(1)).userId();
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl, atLeast(1)).insertInto(isA(Table.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateResult);
  }
}
