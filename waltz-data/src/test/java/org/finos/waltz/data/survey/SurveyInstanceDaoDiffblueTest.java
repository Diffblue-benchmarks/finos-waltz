package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse;
import org.finos.waltz.model.attestation.SyncRecipientsResponse;
import org.finos.waltz.model.survey.ImmutableSurveyRunCompletionRate;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.model.survey.SurveyRunCompletionRate;
import org.finos.waltz.schema.tables.records.SurveyInstanceRecord;
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

class SurveyInstanceDaoDiffblueTest {
  /**
   * Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  void testDeleteForSurveyRun() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForSurveyRunResult = (new SurveyInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteForSurveyRun(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"survey_instance\" where \"survey_instance\".\"survey_run_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSurveyRunResult);
  }

  /**
   * Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  void testDeleteForSurveyRun2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyInstanceRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<SurveyInstanceRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForSurveyRunResult = (new SurveyInstanceDao(dsl)).deleteForSurveyRun(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualDeleteForSurveyRunResult);
  }

  /**
   * Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  void testDeleteForSurveyRun3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForSurveyRunResult = (new SurveyInstanceDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES)))
        .deleteForSurveyRun(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"survey_instance\" where \"survey_instance\".\"survey_run_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSurveyRunResult);
  }

  /**
   * Method under test: {@link SurveyInstanceDao#deleteForSurveyRun(long)}
   */
  @Test
  void testDeleteForSurveyRun4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForSurveyRunResult = (new SurveyInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .deleteForSurveyRun(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from survey_instance where survey_instance.survey_run_id = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateStatus(Optional, long, SurveyInstanceStatus)}
   */
  @Test
  void testUpdateStatus() throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateStatusResult = surveyInstanceDao.updateStatus(tx, 1L, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_instance\" set \"survey_instance\".\"status\" = ? where (\"survey_instance\".\"status\" <> ? and \"survey_instance\".\"id\" = ? and \"survey_instance\".\"original_instance_id\" is null)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("NOT_STARTED"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateStatus(Optional, long, SurveyInstanceStatus)}
   */
  @Test
  void testUpdateStatus2() throws DataAccessException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(defaultDSLContext);

    // Act
    int actualUpdateStatusResult = surveyInstanceDao.updateStatus(tx, 1L, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(defaultDSLContext).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateSubmissionDueDate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateSubmissionDueDateResult = surveyInstanceDao.updateSubmissionDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection).prepareStatement(
        eq("update \"survey_instance\" set \"survey_instance\".\"due_date\" = ? where \"survey_instance\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateSubmissionDueDate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(dsl);

    // Act
    int actualUpdateSubmissionDueDateResult = surveyInstanceDao.updateSubmissionDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateSubmissionDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateSubmissionDueDate3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateSubmissionDueDateResult = (new SurveyInstanceDao(dsl)).updateSubmissionDueDate(1L, null);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateSubmissionDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}
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
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateApprovalDueDateResult = surveyInstanceDao.updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_instance\" set \"survey_instance\".\"approval_due_date\" = ? where \"survey_instance\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateApprovalDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateApprovalDueDate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(dsl);

    // Act
    int actualUpdateApprovalDueDateResult = surveyInstanceDao.updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateApprovalDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  void testUpdateApprovalDueDate3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateResult = (new SurveyInstanceDao(dsl)).updateApprovalDueDate(1L, null);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateApprovalDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  void testUpdateDueDateForSurveyRun() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateDueDateForSurveyRunResult = surveyInstanceDao.updateDueDateForSurveyRun(1L,
        LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_instance\" set \"survey_instance\".\"due_date\" = ? where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDueDateForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  void testUpdateDueDateForSurveyRun2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(dsl);

    // Act
    int actualUpdateDueDateForSurveyRunResult = surveyInstanceDao.updateDueDateForSurveyRun(1L,
        LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDueDateForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  void testUpdateDueDateForSurveyRun3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDueDateForSurveyRunResult = (new SurveyInstanceDao(dsl)).updateDueDateForSurveyRun(1L, null);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDueDateForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  void testUpdateApprovalDueDateForSurveyRun() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateApprovalDueDateForSurveyRunResult = surveyInstanceDao.updateApprovalDueDateForSurveyRun(1L,
        LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_instance\" set \"survey_instance\".\"approval_due_date\" = ? where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateApprovalDueDateForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  void testUpdateApprovalDueDateForSurveyRun2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(dsl);

    // Act
    int actualUpdateApprovalDueDateForSurveyRunResult = surveyInstanceDao.updateApprovalDueDateForSurveyRun(1L,
        LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateApprovalDueDateForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateApprovalDueDateForSurveyRun(long, LocalDate)}
   */
  @Test
  void testUpdateApprovalDueDateForSurveyRun3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateForSurveyRunResult = (new SurveyInstanceDao(dsl))
        .updateApprovalDueDateForSurveyRun(1L, null);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateApprovalDueDateForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateOwningRoleForSurveyRun(long, String)}
   */
  @Test
  void testUpdateOwningRoleForSurveyRun() throws SQLException {
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
    int actualUpdateOwningRoleForSurveyRunResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateOwningRoleForSurveyRun(1L, "Role");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_instance\" set \"survey_instance\".\"owning_role\" = ? where \"survey_instance\".\"survey_run_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("Role"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateOwningRoleForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#updateOwningRoleForSurveyRun(long, String)}
   */
  @Test
  void testUpdateOwningRoleForSurveyRun2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwningRoleForSurveyRunResult = (new SurveyInstanceDao(dsl)).updateOwningRoleForSurveyRun(1L,
        "Role");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateOwningRoleForSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#markSubmitted(Optional, long, String)}
   */
  @Test
  void testMarkSubmitted() throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualMarkSubmittedResult = surveyInstanceDao.markSubmitted(tx, 1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_instance\" set \"survey_instance\".\"status\" = ?, \"survey_instance\".\"submitted_at\" = ?, \"survey_instance\".\"submitted_by\" = ? where (\"survey_instance\".\"id\" = ? and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" in (?, ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkSubmittedResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#markSubmitted(Optional, long, String)}
   */
  @Test
  void testMarkSubmitted2() throws DataAccessException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(defaultDSLContext);

    // Act
    int actualMarkSubmittedResult = surveyInstanceDao.markSubmitted(tx, 1L, "janedoe");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(defaultDSLContext).update(isA(Table.class));
    assertEquals(1, actualMarkSubmittedResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#markApproved(Optional, long, String)}
   */
  @Test
  void testMarkApproved() throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualMarkApprovedResult = surveyInstanceDao.markApproved(tx, 1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_instance\" set \"survey_instance\".\"approved_at\" = ?, \"survey_instance\".\"approved_by\" = ?, \"survey_instance\".\"status\" = ? where (\"survey_instance\".\"id\" = ? and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(1), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkApprovedResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#markApproved(Optional, long, String)}
   */
  @Test
  void testMarkApproved2() throws DataAccessException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(defaultDSLContext);

    // Act
    int actualMarkApprovedResult = surveyInstanceDao.markApproved(tx, 1L, "janedoe");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(defaultDSLContext).update(isA(Table.class));
    assertEquals(1, actualMarkApprovedResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate, LocalDate)}
   */
  @Test
  void testReopenSurvey() throws SQLException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    int actualReopenSurveyResult = surveyInstanceDao.reopenSurvey(tx, 1L, dueDate, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_instance\" set \"survey_instance\".\"status\" = ?, \"survey_instance\".\"approved_at\" = ?, \"survey_instance\".\"approved_by\" = ?, \"survey_instance\".\"submitted_at\" = ?, \"survey_instance\".\"submitted_by\" = ?, \"survey_instance\".\"issued_on\" = ?, \"survey_instance\".\"due_date\" = ?, \"survey_instance\".\"approval_due_date\" = ? where (\"survey_instance\".\"id\" = ? and \"survey_instance\".\"original_instance_id\" is null and \"survey_instance\".\"status\" in (?, ?, ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setDate(anyInt(), isA(Date.class));
    verify(preparedStatement).setLong(eq(9), eq(1L));
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualReopenSurveyResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate, LocalDate)}
   */
  @Test
  void testReopenSurvey2() throws DataAccessException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep5);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep7 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep6);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep8 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep7);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep8);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(defaultDSLContext);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    int actualReopenSurveyResult = surveyInstanceDao.reopenSurvey(tx, 1L, dueDate, LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep8).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep7).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep6).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep5).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(defaultDSLContext).update(isA(Table.class));
    assertEquals(1, actualReopenSurveyResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#reopenSurvey(Optional, long, LocalDate, LocalDate)}
   */
  @Test
  void testReopenSurvey3() throws DataAccessException {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));
    UpdateConditionStep<SurveyInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep5);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep7 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep6);
    UpdateSetMoreStep<SurveyInstanceRecord> updateSetMoreStep8 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep7);
    UpdateSetFirstStep<SurveyInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep8);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.update(Mockito.<Table<SurveyInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    Optional<DSLContext> tx = Optional.of(defaultDSLContext);

    // Act
    int actualReopenSurveyResult = surveyInstanceDao.reopenSurvey(tx, 1L, null, LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep8).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep7).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep6).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep5).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(defaultDSLContext).update(isA(Table.class));
    assertEquals(1, actualReopenSurveyResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#getCompletionRateForSurveyRun(Long)}
   */
  @Test
  void testGetCompletionRateForSurveyRun() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SurveyRunCompletionRate actualCompletionRateForSurveyRun = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCompletionRateForSurveyRun(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCompletionRateForSurveyRun instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, actualCompletionRateForSurveyRun.completedCount());
    assertEquals(0, actualCompletionRateForSurveyRun.inProgressCount());
    assertEquals(0, actualCompletionRateForSurveyRun.notStartedCount());
    assertEquals(0, actualCompletionRateForSurveyRun.totalCount());
    assertEquals(1L, actualCompletionRateForSurveyRun.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#getCompletionRateForSurveyRun(Long)}
   */
  @Test
  void testGetCompletionRateForSurveyRun2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(0);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SurveyRunCompletionRate actualCompletionRateForSurveyRun = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCompletionRateForSurveyRun(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCompletionRateForSurveyRun instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, actualCompletionRateForSurveyRun.completedCount());
    assertEquals(0, actualCompletionRateForSurveyRun.inProgressCount());
    assertEquals(0, actualCompletionRateForSurveyRun.notStartedCount());
    assertEquals(0, actualCompletionRateForSurveyRun.totalCount());
    assertEquals(1L, actualCompletionRateForSurveyRun.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#getCompletionRateForSurveyRun(Long)}
   */
  @Test
  void testGetCompletionRateForSurveyRun3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("NOT_STARTED");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    SurveyRunCompletionRate actualCompletionRateForSurveyRun = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCompletionRateForSurveyRun(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCompletionRateForSurveyRun instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, actualCompletionRateForSurveyRun.completedCount());
    assertEquals(0, actualCompletionRateForSurveyRun.inProgressCount());
    assertEquals(1, actualCompletionRateForSurveyRun.notStartedCount());
    assertEquals(1, actualCompletionRateForSurveyRun.totalCount());
    assertEquals(1L, actualCompletionRateForSurveyRun.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#getCompletionRateForSurveyRun(Long)}
   */
  @Test
  void testGetCompletionRateForSurveyRun4() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("IN_PROGRESS");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    SurveyRunCompletionRate actualCompletionRateForSurveyRun = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCompletionRateForSurveyRun(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCompletionRateForSurveyRun instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, actualCompletionRateForSurveyRun.completedCount());
    assertEquals(0, actualCompletionRateForSurveyRun.notStartedCount());
    assertEquals(1, actualCompletionRateForSurveyRun.inProgressCount());
    assertEquals(1, actualCompletionRateForSurveyRun.totalCount());
    assertEquals(1L, actualCompletionRateForSurveyRun.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#getCompletionRateForSurveyRun(Long)}
   */
  @Test
  void testGetCompletionRateForSurveyRun5() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("COMPLETED");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    SurveyRunCompletionRate actualCompletionRateForSurveyRun = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCompletionRateForSurveyRun(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCompletionRateForSurveyRun instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, actualCompletionRateForSurveyRun.inProgressCount());
    assertEquals(0, actualCompletionRateForSurveyRun.notStartedCount());
    assertEquals(1, actualCompletionRateForSurveyRun.completedCount());
    assertEquals(1, actualCompletionRateForSurveyRun.totalCount());
    assertEquals(1L, actualCompletionRateForSurveyRun.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#getCompletionRateForSurveyRun(Long)}
   */
  @Test
  void testGetCompletionRateForSurveyRun6() throws SQLException {
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
    SurveyRunCompletionRate actualCompletionRateForSurveyRun = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCompletionRateForSurveyRun(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" = ? and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualCompletionRateForSurveyRun);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#findCompletionRateForSurveyTemplate(Long)}
   */
  @Test
  void testFindCompletionRateForSurveyTemplate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SurveyRunCompletionRate> actualFindCompletionRateForSurveyTemplateResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCompletionRateForSurveyTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" in (select \"survey_run\".\"id\" from \"survey_run\" where \"survey_run\".\"survey_template_id\" = ?) and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindCompletionRateForSurveyTemplateResult.size());
    SurveyRunCompletionRate getResult = actualFindCompletionRateForSurveyTemplateResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, getResult.completedCount());
    assertEquals(0, getResult.inProgressCount());
    assertEquals(0, getResult.notStartedCount());
    assertEquals(0, getResult.totalCount());
    assertEquals(1L, getResult.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#findCompletionRateForSurveyTemplate(Long)}
   */
  @Test
  void testFindCompletionRateForSurveyTemplate2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(0);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SurveyRunCompletionRate> actualFindCompletionRateForSurveyTemplateResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCompletionRateForSurveyTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" in (select \"survey_run\".\"id\" from \"survey_run\" where \"survey_run\".\"survey_template_id\" = ?) and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindCompletionRateForSurveyTemplateResult.size());
    SurveyRunCompletionRate getResult = actualFindCompletionRateForSurveyTemplateResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, getResult.completedCount());
    assertEquals(0, getResult.inProgressCount());
    assertEquals(0, getResult.notStartedCount());
    assertEquals(0, getResult.totalCount());
    assertEquals(1L, getResult.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#findCompletionRateForSurveyTemplate(Long)}
   */
  @Test
  void testFindCompletionRateForSurveyTemplate3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("NOT_STARTED");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<SurveyRunCompletionRate> actualFindCompletionRateForSurveyTemplateResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCompletionRateForSurveyTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" in (select \"survey_run\".\"id\" from \"survey_run\" where \"survey_run\".\"survey_template_id\" = ?) and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindCompletionRateForSurveyTemplateResult.size());
    SurveyRunCompletionRate getResult = actualFindCompletionRateForSurveyTemplateResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, getResult.completedCount());
    assertEquals(0, getResult.inProgressCount());
    assertEquals(1, getResult.notStartedCount());
    assertEquals(1, getResult.totalCount());
    assertEquals(1L, getResult.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#findCompletionRateForSurveyTemplate(Long)}
   */
  @Test
  void testFindCompletionRateForSurveyTemplate4() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("IN_PROGRESS");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<SurveyRunCompletionRate> actualFindCompletionRateForSurveyTemplateResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCompletionRateForSurveyTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" in (select \"survey_run\".\"id\" from \"survey_run\" where \"survey_run\".\"survey_template_id\" = ?) and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindCompletionRateForSurveyTemplateResult.size());
    SurveyRunCompletionRate getResult = actualFindCompletionRateForSurveyTemplateResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, getResult.completedCount());
    assertEquals(0, getResult.notStartedCount());
    assertEquals(1, getResult.inProgressCount());
    assertEquals(1, getResult.totalCount());
    assertEquals(1L, getResult.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#findCompletionRateForSurveyTemplate(Long)}
   */
  @Test
  void testFindCompletionRateForSurveyTemplate5() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("COMPLETED");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<SurveyRunCompletionRate> actualFindCompletionRateForSurveyTemplateResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCompletionRateForSurveyTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" in (select \"survey_run\".\"id\" from \"survey_run\" where \"survey_run\".\"survey_template_id\" = ?) and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindCompletionRateForSurveyTemplateResult.size());
    SurveyRunCompletionRate getResult = actualFindCompletionRateForSurveyTemplateResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyRunCompletionRate);
    assertEquals(0, getResult.inProgressCount());
    assertEquals(0, getResult.notStartedCount());
    assertEquals(1, getResult.completedCount());
    assertEquals(1, getResult.totalCount());
    assertEquals(1L, getResult.surveyRunId());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#findCompletionRateForSurveyTemplate(Long)}
   */
  @Test
  void testFindCompletionRateForSurveyTemplate6() throws SQLException {
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
    List<SurveyRunCompletionRate> actualFindCompletionRateForSurveyTemplateResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCompletionRateForSurveyTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\", count(\"survey_instance\".\"id\") \"statCount\" from \"survey_instance\" where (\"survey_instance\".\"survey_run_id\" in (select \"survey_run\".\"id\" from \"survey_run\" where \"survey_run\".\"survey_template_id\" = ?) and \"survey_instance\".\"original_instance_id\" is null) group by \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"status\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindCompletionRateForSurveyTemplateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#createInstanceRecipients(Long, Collection)}
   */
  @Test
  void testCreateInstanceRecipients() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, surveyInstanceDao.createInstanceRecipients(1L, new ArrayList<>()).length);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#createInstanceRecipients(Long, Collection)}
   */
  @Test
  void testCreateInstanceRecipients2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, surveyInstanceDao.createInstanceRecipients(1L, new ArrayList<>()).length);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#createInstanceOwners(Long, Collection)}
   */
  @Test
  void testCreateInstanceOwners() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, surveyInstanceDao.createInstanceOwners(1L, new ArrayList<>()).length);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceDao#createInstanceOwners(Long, Collection)}
   */
  @Test
  void testCreateInstanceOwners2() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, surveyInstanceDao.createInstanceOwners(1L, new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link SurveyInstanceDao#getReassignRecipientsCounts()}
   */
  @Test
  void testGetReassignRecipientsCounts() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignRecipientsCounts = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getReassignRecipientsCounts();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignRecipientsCounts instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignRecipientsCounts.recipientsCreatedCount().longValue());
    assertEquals(2L, actualReassignRecipientsCounts.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#getReassignRecipientsCounts()}
   */
  @Test
  void testGetReassignRecipientsCounts2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
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

    // Act
    SyncRecipientsResponse actualReassignRecipientsCounts = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getReassignRecipientsCounts();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignRecipientsCounts instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignRecipientsCounts.recipientsCreatedCount().longValue());
    assertEquals(2L, actualReassignRecipientsCounts.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#getReassignOwnersCounts()}
   */
  @Test
  void testGetReassignOwnersCounts() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignOwnersCounts = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getReassignOwnersCounts();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignOwnersCounts instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignOwnersCounts.recipientsCreatedCount().longValue());
    assertEquals(2L, actualReassignOwnersCounts.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#getReassignOwnersCounts()}
   */
  @Test
  void testGetReassignOwnersCounts2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
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

    // Act
    SyncRecipientsResponse actualReassignOwnersCounts = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getReassignOwnersCounts();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignOwnersCounts instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignOwnersCounts.recipientsCreatedCount().longValue());
    assertEquals(2L, actualReassignOwnersCounts.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#reassignRecipients()}
   */
  @Test
  void testReassignRecipients() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignRecipients();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignRecipientsResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignRecipientsResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignRecipientsResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#reassignRecipients()}
   */
  @Test
  void testReassignRecipients2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignRecipients();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setNull(eq(2), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignRecipientsResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignRecipientsResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignRecipientsResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#reassignRecipients()}
   */
  @Test
  void testReassignRecipients3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignRecipients();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignRecipientsResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignRecipientsResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignRecipientsResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#reassignOwners()}
   */
  @Test
  void testReassignOwners() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignOwnersResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignOwners();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignOwnersResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignOwnersResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignOwnersResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#reassignOwners()}
   */
  @Test
  void testReassignOwners2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignOwnersResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignOwners();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setNull(eq(2), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignOwnersResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignOwnersResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignOwnersResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link SurveyInstanceDao#reassignOwners()}
   */
  @Test
  void testReassignOwners3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignOwnersResult = (new SurveyInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignOwners();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignOwnersResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignOwnersResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignOwnersResult.recipientsRemovedCount().longValue());
  }
}
