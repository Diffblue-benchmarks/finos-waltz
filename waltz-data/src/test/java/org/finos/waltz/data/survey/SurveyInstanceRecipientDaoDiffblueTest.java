package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.List;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.survey.SurveyInstanceRecipient;
import org.finos.waltz.model.survey.SurveyInstanceRecipientCreateCommand;
import org.finos.waltz.schema.tables.records.SurveyInstanceRecipientRecord;
import org.jooq.Condition;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyInstanceRecipientDaoDiffblueTest {
  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#isPersonInstanceRecipient(long, long)}
   */
  @Test
  void testIsPersonInstanceRecipient() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualIsPersonInstanceRecipientResult = (new SurveyInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).isPersonInstanceRecipient(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when exists (select \"survey_instance_recipient\".\"id\" from \"survey_instance_recipient\" where (\"survey_instance_recipient\".\"survey_instance_id\" = ? and \"survey_instance_recipient\".\"person_id\" = ?)) then ? else ? end"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsPersonInstanceRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#isPersonInstanceRecipient(long, long)}
   */
  @Test
  void testIsPersonInstanceRecipient2() throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any())).thenReturn(true);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsPersonInstanceRecipientResult = (new SurveyInstanceRecipientDao(dsl)).isPersonInstanceRecipient(1L,
        1L);

    // Assert
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
    verify(dsl).select(isA(SelectField.class));
    assertTrue(actualIsPersonInstanceRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#isPersonInstanceRecipient(long, long)}
   */
  @Test
  void testIsPersonInstanceRecipient3() throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any())).thenReturn(false);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsPersonInstanceRecipientResult = (new SurveyInstanceRecipientDao(dsl)).isPersonInstanceRecipient(1L,
        1L);

    // Assert
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
    verify(dsl).select(isA(SelectField.class));
    assertFalse(actualIsPersonInstanceRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#create(SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  void testCreate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = new SurveyInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    SurveyInstanceRecipientCreateCommand command = mock(SurveyInstanceRecipientCreateCommand.class);
    when(command.personId()).thenReturn(1L);
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act
    long actualCreateResult = surveyInstanceRecipientDao.create(command);

    // Assert
    verify(connection).prepareStatement(
        eq("insert into \"survey_instance_recipient\" (\"survey_instance_id\", \"person_id\") values (?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(command).personId();
    verify(command).surveyInstanceId();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}
   */
  @Test
  void testDeleteByInstanceAndPerson() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteByInstanceAndPersonResult = (new SurveyInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).deleteByInstanceAndPerson(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"survey_instance_recipient\" where (\"survey_instance_recipient\".\"survey_instance_id\" = ? and \"survey_instance_recipient\".\"person_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByInstanceAndPersonResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}
   */
  @Test
  void testDeleteByInstanceAndPerson2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyInstanceRecipientRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<SurveyInstanceRecipientRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<SurveyInstanceRecipientRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<SurveyInstanceRecipientRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteByInstanceAndPersonResult = (new SurveyInstanceRecipientDao(dsl)).deleteByInstanceAndPerson(1L,
        1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualDeleteByInstanceAndPersonResult);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#findForSurveyInstance(long)}
   */
  @Test
  void testFindForSurveyInstance() throws SQLException {
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
    List<SurveyInstanceRecipient> actualFindForSurveyInstanceResult = (new SurveyInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSurveyInstance(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance_recipient\".\"id\", \"survey_instance_recipient\".\"survey_instance_id\", \"survey_instance_recipient\".\"person_id\", \"survey_instance\".\"id\", \"survey_instance\".\"survey_run_id\", \"survey_instance\".\"entity_kind\", \"survey_instance\".\"entity_id\", \"survey_instance\".\"status\", \"survey_instance\".\"submitted_at\", \"survey_instance\".\"submitted_by\", \"survey_instance\".\"due_date\", \"survey_instance\".\"original_instance_id\", \"survey_instance\".\"approved_at\", \"survey_instance\".\"approved_by\", \"survey_instance\".\"owning_role\", \"survey_instance\".\"entity_qualifier_id\", \"survey_instance\".\"entity_qualifier_kind\", \"survey_instance\".\"name\", \"survey_instance\".\"approval_due_date\", \"survey_instance\".\"issued_on\", \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"survey_instance_recipient\" join \"survey_instance\" on \"survey_instance\".\"id\" = \"survey_instance_recipient\".\"survey_instance_id\" join \"person\" on \"person\".\"id\" = \"survey_instance_recipient\".\"person_id\" where \"survey_instance_recipient\".\"survey_instance_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#findPeopleForSurveyInstance(long)}
   */
  @Test
  void testFindPeopleForSurveyInstance() throws SQLException {
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
    List<Person> actualFindPeopleForSurveyInstanceResult = (new SurveyInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPeopleForSurveyInstance(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"survey_instance_recipient\" join \"survey_instance\" on \"survey_instance\".\"id\" = \"survey_instance_recipient\".\"survey_instance_id\" join \"person\" on \"person\".\"id\" = \"survey_instance_recipient\".\"person_id\" where \"survey_instance_recipient\".\"survey_instance_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPeopleForSurveyInstanceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#getPersonIdForRecipientId(long)}
   */
  @Test
  void testGetPersonIdForRecipientId() throws SQLException {
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
    Long actualPersonIdForRecipientId = (new SurveyInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getPersonIdForRecipientId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance_recipient\".\"person_id\" from \"survey_instance_recipient\" where \"survey_instance_recipient\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualPersonIdForRecipientId);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceRecipientDao#getPersonIdForRecipientId(long)}
   */
  @Test
  void testGetPersonIdForRecipientId2() throws SQLException {
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
    Long actualPersonIdForRecipientId = (new SurveyInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getPersonIdForRecipientId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_instance_recipient\".\"person_id\" from \"survey_instance_recipient\" where \"survey_instance_recipient\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3L, actualPersonIdForRecipientId.longValue());
  }
}
