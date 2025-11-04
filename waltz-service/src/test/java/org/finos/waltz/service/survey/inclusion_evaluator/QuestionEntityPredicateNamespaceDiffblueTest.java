package org.finos.waltz.service.survey.inclusion_evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QuestionEntityPredicateNamespaceDiffblueTest {
  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#assessmentRating(String)}
   */
  @Test
  void testAssessmentRating() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    String actualAssessmentRatingResult = (new QuestionEntityPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).assessmentRating("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertNull(actualAssessmentRatingResult);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#assessmentRating(String)}
   */
  @Test
  void testAssessmentRating2() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    String actualAssessmentRatingResult = (new QuestionEntityPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).assessmentRating("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertEquals("3", actualAssessmentRatingResult);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)}
   */
  @Test
  void testAssessmentRating3() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    String actualAssessmentRatingResult = (new QuestionEntityPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).assessmentRating("Name", "Default Val");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertEquals("Default Val", actualAssessmentRatingResult);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)}
   */
  @Test
  void testAssessmentRating4() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    String actualAssessmentRatingResult = (new QuestionEntityPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).assessmentRating("Name", "Default Val");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertEquals("3", actualAssessmentRatingResult);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  void testHasInvolvement() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualHasInvolvementResult = (new QuestionEntityPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasInvolvement("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(?) and \"involvement\".\"entity_id\" = ? and \"involvement\".\"entity_kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertFalse(actualHasInvolvementResult);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  void testHasInvolvement2() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualHasInvolvementResult = (new QuestionEntityPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasInvolvement("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(?) and \"involvement\".\"entity_id\" = ? and \"involvement\".\"entity_kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertTrue(actualHasInvolvementResult);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  void testHasInvolvement3() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualHasInvolvementResult = (new QuestionEntityPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasInvolvement("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(?) and \"involvement\".\"entity_id\" = ? and \"involvement\".\"entity_kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertTrue(actualHasInvolvementResult);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext, EntityReference, List, Map)}
   */
  @Test
  void testNewQuestionEntityPredicateNamespace() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    QuestionEntityPredicateNamespace actualQuestionEntityPredicateNamespace = new QuestionEntityPredicateNamespace(dsl,
        null, questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionEntityPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionEntityPredicateNamespace.subjectRef);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext, EntityReference, List, Map)}
   */
  @Test
  void testNewQuestionEntityPredicateNamespace2() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    QuestionEntityPredicateNamespace actualQuestionEntityPredicateNamespace = new QuestionEntityPredicateNamespace(dsl,
        null, questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionEntityPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionEntityPredicateNamespace.subjectRef);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext, EntityReference, List, Map)}
   */
  @Test
  void testNewQuestionEntityPredicateNamespace3() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    QuestionEntityPredicateNamespace actualQuestionEntityPredicateNamespace = new QuestionEntityPredicateNamespace(dsl,
        null, questions, new HashMap<>());

    // Assert
    verify(surveyQuestion).externalId();
    assertTrue(actualQuestionEntityPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionEntityPredicateNamespace.subjectRef);
  }

  /**
   * Method under test:
   * {@link QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext, EntityReference, List, Map)}
   */
  @Test
  void testNewQuestionEntityPredicateNamespace4() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    SurveyQuestion surveyQuestion2 = mock(SurveyQuestion.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion2.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion2);
    questions.add(surveyQuestion);

    // Act
    QuestionEntityPredicateNamespace actualQuestionEntityPredicateNamespace = new QuestionEntityPredicateNamespace(dsl,
        null, questions, new HashMap<>());

    // Assert
    verify(surveyQuestion2).externalId();
    verify(surveyQuestion).externalId();
    assertTrue(actualQuestionEntityPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionEntityPredicateNamespace.subjectRef);
  }
}
