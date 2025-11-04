package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.Set;
import org.finos.waltz.model.app_group.AppGroupMember;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.schema.tables.records.ApplicationGroupMemberRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertOnDuplicateSetMoreStep;
import org.jooq.InsertOnDuplicateSetStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppGroupMemberDaoDiffblueTest {
  /**
   * Method under test: {@link AppGroupMemberDao#getMembers(long)}
   */
  @Test
  void testGetMembers() throws SQLException {
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
    Set<AppGroupMember> actualMembers = (new AppGroupMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getMembers(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group_member\".\"group_id\", \"application_group_member\".\"user_id\", \"application_group_member\".\"role\" from \"application_group_member\" where \"application_group_member\".\"group_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualMembers.isEmpty());
  }

  /**
   * Method under test: {@link AppGroupMemberDao#register(long, String)}
   */
  @Test
  void testRegister() throws DataAccessException {
    // Arrange
    InsertOnDuplicateSetMoreStep<ApplicationGroupMemberRecord> insertOnDuplicateSetMoreStep = mock(
        InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep.execute()).thenReturn(1);
    InsertOnDuplicateSetStep<ApplicationGroupMemberRecord> insertOnDuplicateSetStep = mock(
        InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep);
    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);
    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetStep<ApplicationGroupMemberRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupMemberRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualRegisterResult = (new AppGroupMemberDao(dsl)).register(1L, "42");

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    assertEquals(1, actualRegisterResult);
  }

  /**
   * Method under test:
   * {@link AppGroupMemberDao#register(long, String, AppGroupMemberRole)}
   */
  @Test
  void testRegister2() throws DataAccessException {
    // Arrange
    InsertOnDuplicateSetMoreStep<ApplicationGroupMemberRecord> insertOnDuplicateSetMoreStep = mock(
        InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep.execute()).thenReturn(1);
    InsertOnDuplicateSetStep<ApplicationGroupMemberRecord> insertOnDuplicateSetStep = mock(
        InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep);
    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);
    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetStep<ApplicationGroupMemberRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupMemberRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualRegisterResult = (new AppGroupMemberDao(dsl)).register(1L, "42", AppGroupMemberRole.VIEWER);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    assertEquals(1, actualRegisterResult);
  }

  /**
   * Method under test: {@link AppGroupMemberDao#getSubscriptions(String)}
   */
  @Test
  void testGetSubscriptions() throws SQLException {
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
    Set<AppGroupMember> actualSubscriptions = (new AppGroupMemberDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getSubscriptions("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group_member\".\"group_id\", \"application_group_member\".\"user_id\", \"application_group_member\".\"role\" from \"application_group_member\" where \"application_group_member\".\"user_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualSubscriptions.isEmpty());
  }

  /**
   * Method under test: {@link AppGroupMemberDao#unregister(long, String)}
   */
  @Test
  void testUnregister() throws SQLException {
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
    boolean actualUnregisterResult = (new AppGroupMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .unregister(1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"application_group_member\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"group_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUnregisterResult);
  }

  /**
   * Method under test: {@link AppGroupMemberDao#unregister(long, String)}
   */
  @Test
  void testUnregister2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupMemberRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<ApplicationGroupMemberRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<ApplicationGroupMemberRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ApplicationGroupMemberRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualUnregisterResult = (new AppGroupMemberDao(dsl)).unregister(1L, "42");

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualUnregisterResult);
  }

  /**
   * Method under test: {@link AppGroupMemberDao#canUpdate(long, String)}
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
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualCanUpdateResult = (new AppGroupMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .canUpdate(1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select ? from \"application_group_member\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"group_id\" = ? and \"application_group_member\".\"role\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(3), eq(1L));
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
   * Method under test: {@link AppGroupMemberDao#canUpdate(long, String)}
   */
  @Test
  void testCanUpdate2() throws SQLException {
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
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualCanUpdateResult = (new AppGroupMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .canUpdate(1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select ? from \"application_group_member\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"group_id\" = ? and \"application_group_member\".\"role\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Method under test: {@link AppGroupMemberDao#canUpdate(long, String)}
   */
  @Test
  void testCanUpdate3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualCanUpdateResult = (new AppGroupMemberDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .canUpdate(1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select ? from \"application_group_member\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"group_id\" = ? and \"application_group_member\".\"role\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUpdateResult);
  }
}
