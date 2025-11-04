package org.finos.waltz.data.report_grid;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.model.report_grid.ReportGridCell;
import org.finos.waltz.model.report_grid.ReportGridColumnDefinitionsUpdateCommand;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridInfo;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.finos.waltz.model.report_grid.ReportGridUpdateCommand;
import org.finos.waltz.schema.tables.records.ReportGridRecord;
import org.jooq.Condition;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TransactionalRunnable;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;

class ReportGridDaoDiffblueTest {
  /**
   * Method under test: {@link ReportGridDao#findAllDefinitions()}
   */
  @Test
  void testFindAllDefinitions() throws SQLException {
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
    Set<ReportGridDefinition> actualFindAllDefinitionsResult = (new ReportGridDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAllDefinitions();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllDefinitionsResult.isEmpty());
  }

  /**
   * Method under test: {@link ReportGridDao#findGridDefinitionsForUser(String)}
   */
  @Test
  void testFindGridDefinitionsForUser() throws SQLException {
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
    Set<ReportGridDefinition> actualFindGridDefinitionsForUserResult = (new ReportGridDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findGridDefinitionsForUser("janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" left outer join \"report_grid_member\" on \"rg\".\"id\" = \"report_grid_member\".\"grid_id\" where (\"rg\".\"kind\" = ? or \"report_grid_member\".\"user_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindGridDefinitionsForUserResult.isEmpty());
  }

  /**
   * Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  void testFindGridInfoForUser() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenThrow(new DataIntegrityViolationException("name"));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class,
        () -> (new ReportGridDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).findGridInfoForUser("janedoe"));
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" left outer join \"report_grid_member\" on \"rg\".\"id\" = \"report_grid_member\".\"grid_id\" where (\"rg\".\"kind\" = ? or \"report_grid_member\".\"user_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
  }

  /**
   * Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  void testFindGridInfoForUser2() throws SQLException {
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
    Set<ReportGridInfo> actualFindGridInfoForUserResult = (new ReportGridDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findGridInfoForUser("janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" left outer join \"report_grid_member\" on \"rg\".\"id\" = \"report_grid_member\".\"grid_id\" where (\"rg\".\"kind\" = ? or \"report_grid_member\".\"user_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindGridInfoForUserResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  void testFindCellDataByGridId() throws SQLException {
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
    Set<ReportGridCell> actualFindCellDataByGridIdResult = (new ReportGridDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCellDataByGridId(1L, null);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" where \"rg\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindCellDataByGridIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}
   */
  @Test
  void testFindCellDataByGridExternalId() throws SQLException {
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
    Set<ReportGridCell> actualFindCellDataByGridExternalIdResult = (new ReportGridDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCellDataByGridExternalId("42", null);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" where \"rg\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindCellDataByGridExternalIdResult.isEmpty());
  }

  /**
   * Method under test: {@link ReportGridDao#getGridDefinitionById(long)}
   */
  @Test
  void testGetGridDefinitionById() throws SQLException {
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
    ReportGridDefinition actualGridDefinitionById = (new ReportGridDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getGridDefinitionById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" where \"rg\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualGridDefinitionById);
  }

  /**
   * Method under test: {@link ReportGridDao#getGridInfoById(long)}
   */
  @Test
  void testGetGridInfoById() throws SQLException {
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
    ReportGridInfo actualGridInfoById = (new ReportGridDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getGridInfoById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" where \"rg\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualGridInfoById);
  }

  /**
   * Method under test:
   * {@link ReportGridDao#getGridDefinitionByExternalId(String)}
   */
  @Test
  void testGetGridDefinitionByExternalId() throws SQLException {
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
    ReportGridDefinition actualGridDefinitionByExternalId = (new ReportGridDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getGridDefinitionByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" where \"rg\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualGridDefinitionByExternalId);
  }

  /**
   * Method under test:
   * {@link ReportGridDao#updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  void testUpdateColumnDefinitions() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    (new ReportGridDao(dsl)).updateColumnDefinitions(1L, null);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ReportGridRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep5);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.description()).thenReturn("The characteristics of someone or something");
    when(updateCommand.name()).thenReturn("Name");
    when(updateCommand.kind()).thenReturn(ReportGridKind.PUBLIC);

    // Act
    long actualUpdateResult = reportGridDao.update(1L, updateCommand, "janedoe");

    // Assert
    verify(updateCommand).description();
    verify(updateCommand).kind();
    verify(updateCommand).name();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1L, actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testUpdate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ReportGridRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new DataIntegrityViolationException("Msg"));
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep5);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.description()).thenReturn("The characteristics of someone or something");
    when(updateCommand.name()).thenReturn("Name");
    when(updateCommand.kind()).thenReturn(ReportGridKind.PUBLIC);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.update(1L, updateCommand, "janedoe"));
    verify(updateCommand).description();
    verify(updateCommand).kind();
    verify(updateCommand).name();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test: {@link ReportGridDao#findDefinitionsForOwner(String)}
   */
  @Test
  void testFindDefinitionsForOwner() throws SQLException {
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
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerResult = (new ReportGridDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findDefinitionsForOwner("janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rg\".\"id\", \"rg\".\"name\", \"rg\".\"description\", \"rg\".\"last_updated_at\", \"rg\".\"last_updated_by\", \"rg\".\"provenance\", \"rg\".\"external_id\", \"rg\".\"kind\", \"rg\".\"subject_kind\" from \"report_grid\" \"rg\" join \"report_grid_member\" on \"rg\".\"id\" = \"report_grid_member\".\"grid_id\" where (\"report_grid_member\".\"user_id\" = ? and \"report_grid_member\".\"role\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindDefinitionsForOwnerResult.isEmpty());
  }

  /**
   * Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  void testRemove() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRemoveResult = (new ReportGridDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).remove(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"report_grid\" where \"report_grid\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  void testRemove2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ReportGridRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<ReportGridRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ReportGridRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = (new ReportGridDao(dsl)).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  void testRemove3() {
    // Arrange
    DeleteUsingStep<ReportGridRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenThrow(new DataIntegrityViolationException("Msg"));
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ReportGridRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> (new ReportGridDao(dsl)).remove(1L));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector, Collection)}
   */
  @Test
  void testFetchMeasurableHierarchyData() {
    // Arrange
    ReportGridDao reportGridDao = new ReportGridDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertTrue(reportGridDao.fetchMeasurableHierarchyData(null, new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector, Collection)}
   */
  @Test
  void testFetchMeasurableHierarchyData2() {
    // Arrange
    ReportGridDao reportGridDao = new ReportGridDao(new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertTrue(reportGridDao.fetchMeasurableHierarchyData(null, new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector, Collection)}
   */
  @Test
  void testFetchMeasurableHierarchyData3() {
    // Arrange
    ReportGridDao reportGridDao = new ReportGridDao(new DefaultDSLContext(SQLDialect.SQL99));
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.columnEntityId()).thenReturn(1L);
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition2 = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition2.columnEntityId()).thenReturn(1L);
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition3 = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition3.columnEntityId())
        .thenThrow(new UnsupportedOperationException("xs cannot be null"));

    ArrayList<ReportGridFixedColumnDefinition> cols = new ArrayList<>();
    cols.add(reportGridFixedColumnDefinition3);
    cols.add(reportGridFixedColumnDefinition2);
    cols.add(reportGridFixedColumnDefinition);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> reportGridDao.fetchMeasurableHierarchyData(null, cols));
    verify(reportGridFixedColumnDefinition3).columnEntityId();
  }
}
