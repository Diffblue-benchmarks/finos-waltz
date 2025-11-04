package org.finos.waltz.data.survey;

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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.schema.tables.records.SurveyQuestionRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
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

class SurveyQuestionDaoDiffblueTest {
  /**
   * Method under test: {@link SurveyQuestionDao#findForTemplate(long)}
   */
  @Test
  void testFindForTemplate() throws SQLException {
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
    List<SurveyQuestion> actualFindForTemplateResult = (new SurveyQuestionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_question\".\"id\", \"survey_question\".\"survey_template_id\", \"survey_question\".\"question_text\", \"survey_question\".\"field_type\", \"survey_question\".\"section_name\", \"survey_question\".\"position\", \"survey_question\".\"is_mandatory\", \"survey_question\".\"allow_comment\", \"survey_question\".\"help_text\", \"survey_question\".\"external_id\", \"survey_question\".\"inclusion_predicate\", \"survey_question\".\"entity_qualifier_id\", \"survey_question\".\"entity_qualifier_kind\", \"survey_question\".\"parent_external_id\", \"survey_question\".\"label\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" in (select ?) order by \"survey_question\".\"position\" asc, \"survey_question\".\"question_text\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForTemplateResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyQuestionDao#findForSurveyRun(long)}
   */
  @Test
  void testFindForSurveyRun() throws SQLException {
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
    List<SurveyQuestion> actualFindForSurveyRunResult = (new SurveyQuestionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSurveyRun(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_question\".\"id\", \"survey_question\".\"survey_template_id\", \"survey_question\".\"question_text\", \"survey_question\".\"field_type\", \"survey_question\".\"section_name\", \"survey_question\".\"position\", \"survey_question\".\"is_mandatory\", \"survey_question\".\"allow_comment\", \"survey_question\".\"help_text\", \"survey_question\".\"external_id\", \"survey_question\".\"inclusion_predicate\", \"survey_question\".\"entity_qualifier_id\", \"survey_question\".\"entity_qualifier_kind\", \"survey_question\".\"parent_external_id\", \"survey_question\".\"label\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" in (select \"survey_run\".\"survey_template_id\" from \"survey_run\" where \"survey_run\".\"id\" = ?) order by \"survey_question\".\"position\" asc, \"survey_question\".\"question_text\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForSurveyRunResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyQuestionDao#findForSurveyInstance(long)}
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
    List<SurveyQuestion> actualFindForSurveyInstanceResult = (new SurveyQuestionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSurveyInstance(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_question\".\"id\", \"survey_question\".\"survey_template_id\", \"survey_question\".\"question_text\", \"survey_question\".\"field_type\", \"survey_question\".\"section_name\", \"survey_question\".\"position\", \"survey_question\".\"is_mandatory\", \"survey_question\".\"allow_comment\", \"survey_question\".\"help_text\", \"survey_question\".\"external_id\", \"survey_question\".\"inclusion_predicate\", \"survey_question\".\"entity_qualifier_id\", \"survey_question\".\"entity_qualifier_kind\", \"survey_question\".\"parent_external_id\", \"survey_question\".\"label\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" in (select \"survey_run\".\"survey_template_id\" from \"survey_run\" join \"survey_instance\" on \"survey_instance\".\"survey_run_id\" = \"survey_run\".\"id\" where \"survey_instance\".\"id\" = ?) order by \"survey_question\".\"position\" asc, \"survey_question\".\"question_text\""));
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
   * Method under test: {@link SurveyQuestionDao#create(SurveyQuestion)}
   */
  @Test
  void testCreate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult5);
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult6);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult7);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);

    // Act
    long actualCreateResult = surveyQuestionDao.create(surveyQuestion);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"survey_question\" (\"survey_template_id\", \"question_text\", \"field_type\", \"section_name\", \"position\", \"is_mandatory\", \"allow_comment\", \"help_text\", \"external_id\", \"inclusion_predicate\", \"entity_qualifier_id\", \"entity_qualifier_kind\", \"parent_external_id\", \"label\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setInt(eq(5), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  void testUpdate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult5);
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult6);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult7);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult8 = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult8);

    // Act
    int actualUpdateResult = surveyQuestionDao.update(surveyQuestion);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_question\" set \"survey_question\".\"survey_template_id\" = ?, \"survey_question\".\"question_text\" = ?, \"survey_question\".\"field_type\" = ?, \"survey_question\".\"section_name\" = ?, \"survey_question\".\"position\" = ?, \"survey_question\".\"is_mandatory\" = ?, \"survey_question\".\"allow_comment\" = ?, \"survey_question\".\"help_text\" = ?, \"survey_question\".\"external_id\" = ?, \"survey_question\".\"inclusion_predicate\" = ?, \"survey_question\".\"entity_qualifier_id\" = ?, \"survey_question\".\"entity_qualifier_kind\" = ?, \"survey_question\".\"parent_external_id\" = ?, \"survey_question\".\"label\" = ? where \"survey_question\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setInt(eq(5), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(surveyQuestion).externalId();
    verify(surveyQuestion, atLeast(1)).id();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  void testUpdate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyQuestionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyQuestionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyQuestionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Record>any())).thenReturn(updateSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyQuestionRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult5);
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult6);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult7);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult8 = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult8);

    // Act
    int actualUpdateResult = surveyQuestionDao.update(surveyQuestion);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(surveyQuestion).externalId();
    verify(surveyQuestion, atLeast(1)).id();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Record.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  void testUpdate3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyQuestionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyQuestionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyQuestionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Record>any())).thenReturn(updateSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyQuestionRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(dsl);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult4);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(surveyQuestion.qualifierEntity()).thenReturn(emptyResult);
    Optional<String> ofResult5 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult5);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult6);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult7 = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult7);

    // Act
    int actualUpdateResult = surveyQuestionDao.update(surveyQuestion);

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion, atLeast(1)).id();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Record.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#delete(long)}
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
    int actualDeleteResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).delete(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"survey_question\" where \"survey_question\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#delete(long)}
   */
  @Test
  void testDelete2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<SurveyQuestionRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<SurveyQuestionRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult = (new SurveyQuestionDao(dsl)).delete(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#delete(long)}
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
    int actualDeleteResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES))).delete(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"survey_question\" where \"survey_question\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#delete(long)}
   */
  @Test
  void testDelete4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQLITE))).delete(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from survey_question where survey_question.id = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#hasResponses(long)}
   */
  @Test
  void testHasResponses() throws SQLException {
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
    boolean actualHasResponsesResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .hasResponses(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"survey_question_response\".\"survey_instance_id\", \"survey_question_response\".\"question_id\", \"survey_question_response\".\"person_id\", \"survey_question_response\".\"comment\", \"survey_question_response\".\"last_updated_at\", \"survey_question_response\".\"string_response\", \"survey_question_response\".\"number_response\", \"survey_question_response\".\"boolean_response\", \"survey_question_response\".\"entity_response_id\", \"survey_question_response\".\"entity_response_kind\", \"survey_question_response\".\"date_response\", \"survey_question_response\".\"list_response_concat\" from \"survey_question_response\" where \"survey_question_response\".\"question_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertFalse(actualHasResponsesResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#hasResponses(long)}
   */
  @Test
  void testHasResponses2() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualHasResponsesResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .hasResponses(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"survey_question_response\".\"survey_instance_id\", \"survey_question_response\".\"question_id\", \"survey_question_response\".\"person_id\", \"survey_question_response\".\"comment\", \"survey_question_response\".\"last_updated_at\", \"survey_question_response\".\"string_response\", \"survey_question_response\".\"number_response\", \"survey_question_response\".\"boolean_response\", \"survey_question_response\".\"entity_response_id\", \"survey_question_response\".\"entity_response_kind\", \"survey_question_response\".\"date_response\", \"survey_question_response\".\"list_response_concat\" from \"survey_question_response\" where \"survey_question_response\".\"question_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasResponsesResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#hasResponses(long)}
   */
  @Test
  void testHasResponses3() throws SQLException {
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
    boolean actualHasResponsesResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .hasResponses(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"survey_question_response\".\"survey_instance_id\", \"survey_question_response\".\"question_id\", \"survey_question_response\".\"person_id\", \"survey_question_response\".\"comment\", \"survey_question_response\".\"last_updated_at\", \"survey_question_response\".\"string_response\", \"survey_question_response\".\"number_response\", \"survey_question_response\".\"boolean_response\", \"survey_question_response\".\"entity_response_id\", \"survey_question_response\".\"entity_response_kind\", \"survey_question_response\".\"date_response\", \"survey_question_response\".\"list_response_concat\" from \"survey_question_response\" where \"survey_question_response\".\"question_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasResponsesResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  void testDeleteForTemplate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForTemplateResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  void testDeleteForTemplate2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<SurveyQuestionRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<SurveyQuestionRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForTemplateResult = (new SurveyQuestionDao(dsl)).deleteForTemplate(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualDeleteForTemplateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  void testDeleteForTemplate3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForTemplateResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES)))
        .deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  void testDeleteForTemplate4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForTemplateResult = (new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .deleteForTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from survey_question where survey_question.survey_template_id = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionDao#findForIds(Set)}
   */
  @Test
  void testFindForIds() throws SQLException {
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
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<SurveyQuestion> actualFindForIdsResult = surveyQuestionDao.findForIds(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_question\".\"id\", \"survey_question\".\"survey_template_id\", \"survey_question\".\"question_text\", \"survey_question\".\"field_type\", \"survey_question\".\"section_name\", \"survey_question\".\"position\", \"survey_question\".\"is_mandatory\", \"survey_question\".\"allow_comment\", \"survey_question\".\"help_text\", \"survey_question\".\"external_id\", \"survey_question\".\"inclusion_predicate\", \"survey_question\".\"entity_qualifier_id\", \"survey_question\".\"entity_qualifier_kind\", \"survey_question\".\"parent_external_id\", \"survey_question\".\"label\" from \"survey_question\" where \"survey_question\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForIdsResult.isEmpty());
  }
}
