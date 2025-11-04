package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.survey.SurveyIssuanceKind;
import org.finos.waltz.model.survey.SurveyRun;
import org.finos.waltz.model.survey.SurveyRunChangeCommand;
import org.finos.waltz.model.survey.SurveyRunStatus;
import org.finos.waltz.schema.tables.records.SurveyRunRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
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

class SurveyRunDaoDiffblueTest {
  /**
   * Method under test: {@link SurveyRunDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SurveyRun actualById = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link SurveyRunDao#findForRecipient(long)}
   */
  @Test
  void testFindForRecipient() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SurveyRun> actualFindForRecipientResult = (new SurveyRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForRecipient(1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindForRecipientResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyRunDao#delete(long)}
   */
  @Test
  void testDelete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteResult = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).delete(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"survey_run\" where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#delete(long)}
   */
  @Test
  void testDelete2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyRunRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<SurveyRunRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult = (new SurveyRunDao(dsl)).delete(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#delete(long)}
   */
  @Test
  void testDelete3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteResult = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES))).delete(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"survey_run\" where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#update(long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep5);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep7 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep6);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep8 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep7);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep9 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep8);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep9);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyRunDao surveyRunDao = new SurveyRunDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(command.contactEmail()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.approvalDueDate()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.dueDate()).thenReturn(ofResult3);
    when(command.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    when(command.selectionOptions()).thenReturn(idSelectionOptions);

    // Act
    int actualUpdateResult = surveyRunDao.update(1L, command);

    // Assert
    verify(command).description();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(command).name();
    verify(command).approvalDueDate();
    verify(command).contactEmail();
    verify(command).dueDate();
    verify(command).issuanceKind();
    verify(command, atLeast(1)).selectionOptions();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#updateStatus(long, SurveyRunStatus)}
   */
  @Test
  void testUpdateStatus() throws SQLException {
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
    int actualUpdateStatusResult = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateStatus(1L, SurveyRunStatus.DRAFT);

    // Assert
    verify(connection).prepareStatement(
        eq("update \"survey_run\" set \"survey_run\".\"status\" = ? where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#updateStatus(long, SurveyRunStatus)}
   */
  @Test
  void testUpdateStatus2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateStatusResult = (new SurveyRunDao(dsl)).updateStatus(1L, SurveyRunStatus.DRAFT);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#updateDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateDueDate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateDueDateResult = surveyRunDao.updateDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection).prepareStatement(
        eq("update \"survey_run\" set \"survey_run\".\"due_date\" = ? where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDueDateResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#updateDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateDueDate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyRunDao surveyRunDao = new SurveyRunDao(dsl);

    // Act
    int actualUpdateDueDateResult = surveyRunDao.updateDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDueDateResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#updateDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateDueDate3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDueDateResult = (new SurveyRunDao(dsl)).updateDueDate(1L, null);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateApprovalDueDate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateApprovalDueDateResult = surveyRunDao.updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection).prepareStatement(
        eq("update \"survey_run\" set \"survey_run\".\"approval_due_date\" = ? where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateApprovalDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateApprovalDueDate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyRunDao surveyRunDao = new SurveyRunDao(dsl);

    // Act
    int actualUpdateApprovalDueDateResult = surveyRunDao.updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateApprovalDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateApprovalDueDate3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateResult = (new SurveyRunDao(dsl)).updateApprovalDueDate(1L, null);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateApprovalDueDateResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#issue(long)}
   */
  @Test
  void testIssue() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualIssueResult = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).issue(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_run\" set \"survey_run\".\"status\" = ?, \"survey_run\".\"issued_on\" = ? where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(2), isA(Date.class));
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ISSUED"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualIssueResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#issue(long)}
   */
  @Test
  void testIssue2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualIssueResult = (new SurveyRunDao(dsl)).issue(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualIssueResult);
  }

  /**
   * Method under test: {@link SurveyRunDao#findByTemplateId(long)}
   */
  @Test
  void testFindByTemplateId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SurveyRun> actualFindByTemplateIdResult = (new SurveyRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByTemplateId(1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyRunDao#getOwnerInvolvementGroupId(long)}
   */
  @Test
  void testGetOwnerInvolvementGroupId() throws SQLException {
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
    Long actualOwnerInvolvementGroupId = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getOwnerInvolvementGroupId(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("select \"survey_run\".\"owner_involvement_group_id\" from \"survey_run\" where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualOwnerInvolvementGroupId);
  }

  /**
   * Method under test: {@link SurveyRunDao#getOwnerInvolvementGroupId(long)}
   */
  @Test
  void testGetOwnerInvolvementGroupId2() throws SQLException {
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
    Long actualOwnerInvolvementGroupId = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getOwnerInvolvementGroupId(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("select \"survey_run\".\"owner_involvement_group_id\" from \"survey_run\" where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3L, actualOwnerInvolvementGroupId.longValue());
  }

  /**
   * Method under test: {@link SurveyRunDao#getRecipientInvolvementGroupId(long)}
   */
  @Test
  void testGetRecipientInvolvementGroupId() throws SQLException {
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
    Long actualRecipientInvolvementGroupId = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getRecipientInvolvementGroupId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_run\".\"recipient_involvement_group_id\" from \"survey_run\" where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualRecipientInvolvementGroupId);
  }

  /**
   * Method under test: {@link SurveyRunDao#getRecipientInvolvementGroupId(long)}
   */
  @Test
  void testGetRecipientInvolvementGroupId2() throws SQLException {
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
    Long actualRecipientInvolvementGroupId = (new SurveyRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getRecipientInvolvementGroupId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_run\".\"recipient_involvement_group_id\" from \"survey_run\" where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3L, actualRecipientInvolvementGroupId.longValue());
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateOwnerInvolvementGroupId() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult = (new SurveyRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateOwnerInvolvementGroupId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_run\" set \"survey_run\".\"owner_involvement_group_id\" = ? where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateOwnerInvolvementGroupId2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult = (new SurveyRunDao(dsl)).updateOwnerInvolvementGroupId(1L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateOwnerInvolvementGroupId3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult = (new SurveyRunDao(dsl)).updateOwnerInvolvementGroupId(2L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateOwnerInvolvementGroupId4() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult = (new SurveyRunDao(dsl)).updateOwnerInvolvementGroupId(3L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateOwnerInvolvementGroupId5() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult = (new SurveyRunDao(dsl)).updateOwnerInvolvementGroupId(4L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new SurveyRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateRecipientInvolvementGroupId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_run\" set \"survey_run\".\"recipient_involvement_group_id\" = ? where \"survey_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new SurveyRunDao(dsl)).updateRecipientInvolvementGroupId(1L,
        1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new SurveyRunDao(dsl)).updateRecipientInvolvementGroupId(2L,
        1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId4() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new SurveyRunDao(dsl)).updateRecipientInvolvementGroupId(3L,
        1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId5() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new SurveyRunDao(dsl)).updateRecipientInvolvementGroupId(4L,
        1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }
}
