package org.finos.waltz.data.survey;

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
import org.finos.waltz.model.survey.SurveyInstanceActionQueueItem;
import org.finos.waltz.model.survey.SurveyInstanceActionStatus;
import org.finos.waltz.schema.tables.records.SurveyInstanceActionQueueRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
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

class SurveyInstanceActionQueueDaoDiffblueTest {
  /**
   * Method under test: {@link SurveyInstanceActionQueueDao#findPendingActions()}
   */
  @Test
  void testFindPendingActions() throws SQLException {
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
    List<SurveyInstanceActionQueueItem> actualFindPendingActionsResult = (new SurveyInstanceActionQueueDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPendingActions();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance_action_queue\".\"id\", \"survey_instance_action_queue\".\"action\", \"survey_instance_action_queue\".\"survey_instance_id\", \"survey_instance_action_queue\".\"action_params\", \"survey_instance_action_queue\".\"initial_state\", \"survey_instance_action_queue\".\"submitted_at\", \"survey_instance_action_queue\".\"submitted_by\", \"survey_instance_action_queue\".\"actioned_at\", \"survey_instance_action_queue\".\"status\", \"survey_instance_action_queue\".\"message\", \"survey_instance_action_queue\".\"provenance\" from \"survey_instance_action_queue\" where \"survey_instance_action_queue\".\"status\" = ? order by \"survey_instance_action_queue\".\"submitted_at\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("PENDING"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPendingActionsResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyInstanceActionQueueDao#getById(long)}
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
    SurveyInstanceActionQueueItem actualById = (new SurveyInstanceActionQueueDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance_action_queue\".\"id\", \"survey_instance_action_queue\".\"action\", \"survey_instance_action_queue\".\"survey_instance_id\", \"survey_instance_action_queue\".\"action_params\", \"survey_instance_action_queue\".\"initial_state\", \"survey_instance_action_queue\".\"submitted_at\", \"survey_instance_action_queue\".\"submitted_by\", \"survey_instance_action_queue\".\"actioned_at\", \"survey_instance_action_queue\".\"status\", \"survey_instance_action_queue\".\"message\", \"survey_instance_action_queue\".\"provenance\" from \"survey_instance_action_queue\" where \"survey_instance_action_queue\".\"id\" = ?"));
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
   * {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)}
   */
  @Test
  void testUpdateActionStatus() throws SQLException {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = new SurveyInstanceActionQueueDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> surveyInstanceActionQueueDao.updateActionStatus(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L,
            SurveyInstanceActionStatus.PENDING, "Msg"));
    verify(connection).prepareStatement(eq(
        "update \"survey_instance_action_queue\" set \"survey_instance_action_queue\".\"actioned_at\" = ?, \"survey_instance_action_queue\".\"status\" = ?, \"survey_instance_action_queue\".\"message\" = ? where (\"survey_instance_action_queue\".\"id\" = ? and \"survey_instance_action_queue\".\"status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(1), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceActionQueueDao#updateActionStatus(DSLContext, Long, SurveyInstanceActionStatus, String)}
   */
  @Test
  void testUpdateActionStatus2() throws DataAccessException {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = new SurveyInstanceActionQueueDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    UpdateConditionStep<SurveyInstanceActionQueueRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    surveyInstanceActionQueueDao.updateActionStatus(tx, 1L, SurveyInstanceActionStatus.PENDING, "Msg");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(tx).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext, Long)}
   */
  @Test
  void testMarkActionInProgress() throws SQLException {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = new SurveyInstanceActionQueueDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> surveyInstanceActionQueueDao
        .markActionInProgress(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L));
    verify(connection).prepareStatement(eq(
        "update \"survey_instance_action_queue\" set \"survey_instance_action_queue\".\"status\" = ? where (\"survey_instance_action_queue\".\"id\" = ? and \"survey_instance_action_queue\".\"status\" = ? and not exists (select \"survey_instance_action_queue\".\"id\" from \"survey_instance_action_queue\" where \"survey_instance_action_queue\".\"status\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link SurveyInstanceActionQueueDao#markActionInProgress(DSLContext, Long)}
   */
  @Test
  void testMarkActionInProgress2() throws DataAccessException {
    // Arrange
    SurveyInstanceActionQueueDao surveyInstanceActionQueueDao = new SurveyInstanceActionQueueDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    UpdateConditionStep<SurveyInstanceActionQueueRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyInstanceActionQueueRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyInstanceActionQueueRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.update(Mockito.<Table<SurveyInstanceActionQueueRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    surveyInstanceActionQueueDao.markActionInProgress(tx, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(tx).update(isA(Table.class));
  }
}
