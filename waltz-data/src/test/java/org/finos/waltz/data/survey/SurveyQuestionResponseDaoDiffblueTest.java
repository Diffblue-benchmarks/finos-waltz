package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.math.BigDecimal;
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
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.CopySurveyResponsesCommand;
import org.finos.waltz.model.survey.SurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.SurveyQuestionResponse;
import org.finos.waltz.schema.tables.records.SurveyQuestionResponseRecord;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TransactionalCallable;
import org.jooq.TransactionalRunnable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyQuestionResponseDaoDiffblueTest {
  /**
   * Method under test: {@link SurveyQuestionResponseDao#findForInstance(long)}
   */
  @Test
  void testFindForInstance() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn(null);
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
    List<SurveyInstanceQuestionResponse> actualFindForInstanceResult = (new SurveyQuestionResponseDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForInstance(1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getInt(eq(4));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindForInstanceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  void testDeletePreviousResponse() {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao = new SurveyQuestionResponseDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, surveyQuestionResponseDao.deletePreviousResponse(tx, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link SurveyQuestionResponseDao#deletePreviousResponse(Optional, List)}
   */
  @Test
  void testDeletePreviousResponse2() {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao = new SurveyQuestionResponseDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, surveyQuestionResponseDao.deletePreviousResponse(tx, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link SurveyQuestionResponseDao#saveResponse(SurveyInstanceQuestionResponse)}
   */
  @Test
  void testSaveResponse() throws SQLException {
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
    doNothing().when(preparedStatement).setBigDecimal(anyInt(), Mockito.<BigDecimal>any());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionResponseDao surveyQuestionResponseDao = new SurveyQuestionResponseDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<List<EntityReference>> ofResult2 = Optional.of(new ArrayList<>());
    when(surveyQuestionResponse.entityListResponse()).thenReturn(ofResult2);
    when(surveyQuestionResponse.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(surveyQuestionResponse.booleanResponse()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestionResponse.comment()).thenReturn(ofResult4);
    Optional<LocalDate> ofResult5 = Optional.of(LocalDate.of(1970, 1, 1));
    when(surveyQuestionResponse.dateResponse()).thenReturn(ofResult5);
    when(surveyQuestionResponse.entityResponse()).thenReturn(ofResult);
    Optional<List<String>> ofResult6 = Optional.of(new ArrayList<>());
    when(surveyQuestionResponse.listResponse()).thenReturn(ofResult6);
    Optional<Double> ofResult7 = Optional.<Double>of(10.0d);
    when(surveyQuestionResponse.numberResponse()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(surveyQuestionResponse.stringResponse()).thenReturn(ofResult8);
    SurveyInstanceQuestionResponse response = mock(SurveyInstanceQuestionResponse.class);
    when(response.personId()).thenReturn(1L);
    when(response.surveyInstanceId()).thenReturn(1L);
    when(response.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(response.questionResponse()).thenReturn(surveyQuestionResponse);

    // Act
    surveyQuestionResponseDao.saveResponse(response);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setBigDecimal(eq(7), isA(BigDecimal.class));
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setDate(eq(11), isA(Date.class));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(eq(12), eq(12));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(response).lastUpdatedAt();
    verify(response).personId();
    verify(response, atLeast(1)).questionResponse();
    verify(response, atLeast(1)).surveyInstanceId();
    verify(surveyQuestionResponse).booleanResponse();
    verify(surveyQuestionResponse).comment();
    verify(surveyQuestionResponse).dateResponse();
    verify(surveyQuestionResponse).entityListResponse();
    verify(surveyQuestionResponse).entityResponse();
    verify(surveyQuestionResponse, atLeast(1)).listResponse();
    verify(surveyQuestionResponse).numberResponse();
    verify(surveyQuestionResponse, atLeast(1)).questionId();
    verify(surveyQuestionResponse).stringResponse();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionResponseDao#saveResponse(SurveyInstanceQuestionResponse)}
   */
  @Test
  void testSaveResponse2() throws SQLException {
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
    doNothing().when(preparedStatement).setBigDecimal(anyInt(), Mockito.<BigDecimal>any());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionResponseDao surveyQuestionResponseDao = new SurveyQuestionResponseDao(
        new DefaultDSLContext(connection, SQLDialect.CUBRID));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<List<EntityReference>> ofResult2 = Optional.of(new ArrayList<>());
    when(surveyQuestionResponse.entityListResponse()).thenReturn(ofResult2);
    when(surveyQuestionResponse.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(surveyQuestionResponse.booleanResponse()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestionResponse.comment()).thenReturn(ofResult4);
    Optional<LocalDate> ofResult5 = Optional.of(LocalDate.of(1970, 1, 1));
    when(surveyQuestionResponse.dateResponse()).thenReturn(ofResult5);
    when(surveyQuestionResponse.entityResponse()).thenReturn(ofResult);
    Optional<List<String>> ofResult6 = Optional.of(new ArrayList<>());
    when(surveyQuestionResponse.listResponse()).thenReturn(ofResult6);
    Optional<Double> ofResult7 = Optional.<Double>of(10.0d);
    when(surveyQuestionResponse.numberResponse()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(surveyQuestionResponse.stringResponse()).thenReturn(ofResult8);
    SurveyInstanceQuestionResponse response = mock(SurveyInstanceQuestionResponse.class);
    when(response.personId()).thenReturn(1L);
    when(response.surveyInstanceId()).thenReturn(1L);
    when(response.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(response.questionResponse()).thenReturn(surveyQuestionResponse);

    // Act
    surveyQuestionResponseDao.saveResponse(response);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setBigDecimal(eq(7), isA(BigDecimal.class));
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setDate(eq(11), isA(Date.class));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(eq(12), eq(12));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(response).lastUpdatedAt();
    verify(response).personId();
    verify(response, atLeast(1)).questionResponse();
    verify(response, atLeast(1)).surveyInstanceId();
    verify(surveyQuestionResponse).booleanResponse();
    verify(surveyQuestionResponse).comment();
    verify(surveyQuestionResponse).dateResponse();
    verify(surveyQuestionResponse).entityListResponse();
    verify(surveyQuestionResponse).entityResponse();
    verify(surveyQuestionResponse, atLeast(1)).listResponse();
    verify(surveyQuestionResponse).numberResponse();
    verify(surveyQuestionResponse, atLeast(1)).questionId();
    verify(surveyQuestionResponse).stringResponse();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionResponseDao#saveResponse(SurveyInstanceQuestionResponse)}
   */
  @Test
  void testSaveResponse3() throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any())).thenReturn(true);
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    when(dsl.newRecord(Mockito.<Table<SurveyQuestionResponseRecord>>any()))
        .thenReturn(new SurveyQuestionResponseRecord());
    SurveyQuestionResponseDao surveyQuestionResponseDao = new SurveyQuestionResponseDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    when(surveyQuestionResponse.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult2 = Optional.of(true);
    when(surveyQuestionResponse.booleanResponse()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestionResponse.comment()).thenReturn(ofResult3);
    Optional<LocalDate> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1));
    when(surveyQuestionResponse.dateResponse()).thenReturn(ofResult4);
    when(surveyQuestionResponse.entityResponse()).thenReturn(ofResult);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(surveyQuestionResponse.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(surveyQuestionResponse.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestionResponse.stringResponse()).thenReturn(ofResult7);
    SurveyInstanceQuestionResponse response = mock(SurveyInstanceQuestionResponse.class);
    when(response.personId()).thenReturn(1L);
    when(response.surveyInstanceId()).thenReturn(1L);
    when(response.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(response.questionResponse()).thenReturn(surveyQuestionResponse);

    // Act
    surveyQuestionResponseDao.saveResponse(response);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(response).lastUpdatedAt();
    verify(response).personId();
    verify(response, atLeast(1)).questionResponse();
    verify(response, atLeast(1)).surveyInstanceId();
    verify(surveyQuestionResponse).booleanResponse();
    verify(surveyQuestionResponse).comment();
    verify(surveyQuestionResponse).dateResponse();
    verify(surveyQuestionResponse).entityResponse();
    verify(surveyQuestionResponse).listResponse();
    verify(surveyQuestionResponse).numberResponse();
    verify(surveyQuestionResponse, atLeast(1)).questionId();
    verify(surveyQuestionResponse).stringResponse();
    verify(dsl).newRecord(isA(Table.class));
    verify(dsl).select(isA(SelectField.class));
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
  }

  /**
   * Method under test:
   * {@link SurveyQuestionResponseDao#saveResponse(SurveyInstanceQuestionResponse)}
   */
  @Test
  void testSaveResponse4() throws DataAccessException {
    // Arrange
    SurveyQuestionResponseRecord surveyQuestionResponseRecord = mock(SurveyQuestionResponseRecord.class);
    doNothing().when(surveyQuestionResponseRecord).setBooleanResponse(Mockito.<Boolean>any());
    doNothing().when(surveyQuestionResponseRecord).setComment(Mockito.<String>any());
    doNothing().when(surveyQuestionResponseRecord).setDateResponse(Mockito.<Date>any());
    doNothing().when(surveyQuestionResponseRecord).setEntityResponseId(Mockito.<Long>any());
    doNothing().when(surveyQuestionResponseRecord).setEntityResponseKind(Mockito.<String>any());
    doNothing().when(surveyQuestionResponseRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(surveyQuestionResponseRecord).setListResponseConcat(Mockito.<String>any());
    doNothing().when(surveyQuestionResponseRecord).setNumberResponse(Mockito.<BigDecimal>any());
    doNothing().when(surveyQuestionResponseRecord).setPersonId(Mockito.<Long>any());
    doNothing().when(surveyQuestionResponseRecord).setQuestionId(Mockito.<Long>any());
    doNothing().when(surveyQuestionResponseRecord).setStringResponse(Mockito.<String>any());
    doNothing().when(surveyQuestionResponseRecord).setSurveyInstanceId(Mockito.<Long>any());
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any())).thenReturn(true);
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    when(dsl.newRecord(Mockito.<Table<SurveyQuestionResponseRecord>>any())).thenReturn(surveyQuestionResponseRecord);
    SurveyQuestionResponseDao surveyQuestionResponseDao = new SurveyQuestionResponseDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    when(surveyQuestionResponse.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult2 = Optional.of(true);
    when(surveyQuestionResponse.booleanResponse()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestionResponse.comment()).thenReturn(ofResult3);
    Optional<LocalDate> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1));
    when(surveyQuestionResponse.dateResponse()).thenReturn(ofResult4);
    when(surveyQuestionResponse.entityResponse()).thenReturn(ofResult);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(surveyQuestionResponse.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(surveyQuestionResponse.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestionResponse.stringResponse()).thenReturn(ofResult7);
    SurveyInstanceQuestionResponse response = mock(SurveyInstanceQuestionResponse.class);
    when(response.personId()).thenReturn(1L);
    when(response.surveyInstanceId()).thenReturn(1L);
    when(response.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(response.questionResponse()).thenReturn(surveyQuestionResponse);

    // Act
    surveyQuestionResponseDao.saveResponse(response);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(response).lastUpdatedAt();
    verify(response).personId();
    verify(response, atLeast(1)).questionResponse();
    verify(response, atLeast(1)).surveyInstanceId();
    verify(surveyQuestionResponse).booleanResponse();
    verify(surveyQuestionResponse).comment();
    verify(surveyQuestionResponse).dateResponse();
    verify(surveyQuestionResponse).entityResponse();
    verify(surveyQuestionResponse).listResponse();
    verify(surveyQuestionResponse).numberResponse();
    verify(surveyQuestionResponse, atLeast(1)).questionId();
    verify(surveyQuestionResponse).stringResponse();
    verify(surveyQuestionResponseRecord).setBooleanResponse(eq(true));
    verify(surveyQuestionResponseRecord).setComment(eq("foo"));
    verify(surveyQuestionResponseRecord).setDateResponse(isA(Date.class));
    verify(surveyQuestionResponseRecord).setEntityResponseId(eq(1L));
    verify(surveyQuestionResponseRecord).setEntityResponseKind(eq("ALL"));
    verify(surveyQuestionResponseRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(surveyQuestionResponseRecord).setListResponseConcat(isNull());
    verify(surveyQuestionResponseRecord).setNumberResponse(isA(BigDecimal.class));
    verify(surveyQuestionResponseRecord).setPersonId(eq(1L));
    verify(surveyQuestionResponseRecord).setQuestionId(eq(1L));
    verify(surveyQuestionResponseRecord).setStringResponse(eq("foo"));
    verify(surveyQuestionResponseRecord).setSurveyInstanceId(eq(1L));
    verify(dsl).newRecord(isA(Table.class));
    verify(dsl).select(isA(SelectField.class));
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
  }

  /**
   * Method under test:
   * {@link SurveyQuestionResponseDao#cloneResponses(Optional, long, long)}
   */
  @Test
  void testCloneResponses() throws SQLException {
    // Arrange
    SurveyQuestionResponseDao surveyQuestionResponseDao = new SurveyQuestionResponseDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    surveyQuestionResponseDao.cloneResponses(tx, 1L, 1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(eq(4), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getInt(eq(4));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionResponseDao#copyResponses(Long, CopySurveyResponsesCommand, Long)}
   */
  @Test
  void testCopyResponses() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualCopyResponsesResult = (new SurveyQuestionResponseDao(dsl)).copyResponses(1L, null, 1L);

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualCopyResponsesResult);
  }
}
