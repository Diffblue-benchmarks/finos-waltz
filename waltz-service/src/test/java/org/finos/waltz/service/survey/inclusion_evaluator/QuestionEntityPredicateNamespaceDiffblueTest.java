package org.finos.waltz.service.survey.inclusion_evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion.Builder;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QuestionEntityPredicateNamespaceDiffblueTest {
  /**
   * Test {@link QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext,
   * EntityReference, List, Map)}.
   *
   * <p>Method under test: {@link
   * QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext, EntityReference,
   * List, Map)}
   */
  @Test
  @DisplayName("Test new QuestionEntityPredicateNamespace(DSLContext, EntityReference, List, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuestionEntityPredicateNamespace.<init>(DSLContext, EntityReference, List, Map)"
  })
  void testNewQuestionEntityPredicateNamespace() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    // Act
    QuestionEntityPredicateNamespace actualQuestionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, null, questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionEntityPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionEntityPredicateNamespace.subjectRef);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext,
   * EntityReference, List, Map)}.
   *
   * <p>Method under test: {@link
   * QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext, EntityReference,
   * List, Map)}
   */
  @Test
  @DisplayName("Test new QuestionEntityPredicateNamespace(DSLContext, EntityReference, List, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuestionEntityPredicateNamespace.<init>(DSLContext, EntityReference, List, Map)"
  })
  void testNewQuestionEntityPredicateNamespace2() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);
    questions.add(
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    // Act
    QuestionEntityPredicateNamespace actualQuestionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, null, questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionEntityPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionEntityPredicateNamespace.subjectRef);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext,
   * EntityReference, List, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * QuestionEntityPredicateNamespace#QuestionEntityPredicateNamespace(DSLContext, EntityReference,
   * List, Map)}
   */
  @Test
  @DisplayName(
      "Test new QuestionEntityPredicateNamespace(DSLContext, EntityReference, List, Map); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuestionEntityPredicateNamespace.<init>(DSLContext, EntityReference, List, Map)"
  })
  void testNewQuestionEntityPredicateNamespace_whenArrayList() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    QuestionEntityPredicateNamespace actualQuestionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, null, questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionEntityPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionEntityPredicateNamespace.subjectRef);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String)} with {@code name}.
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String)"})
  void testAssessmentRatingWithName() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult = questionEntityPredicateNamespace.assessmentRating("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = cast(? as varchar) or \"assessment_definition\".\"name\" = cast(? as varchar)) and \"assessment_rating\".\"entity_kind\" = cast(? as varchar) and \"assessment_rating\".\"entity_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String)} with {@code name}.
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String)"})
  void testAssessmentRatingWithName2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult = questionEntityPredicateNamespace.assessmentRating("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = cast(? as varchar(4)) or \"assessment_definition\".\"name\" = cast(? as varchar(4))) and \"assessment_rating\".\"entity_kind\" = cast(? as varchar(3)) and \"assessment_rating\".\"entity_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)} with {@code
   * name}, {@code defaultVal}.
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String, String) with 'name', 'defaultVal'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String, String)"})
  void testAssessmentRatingWithNameDefaultVal() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult =
        questionEntityPredicateNamespace.assessmentRating("Name", "Default Val");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = cast(? as varchar) or \"assessment_definition\".\"name\" = cast(? as varchar)) and \"assessment_rating\".\"entity_kind\" = cast(? as varchar) and \"assessment_rating\".\"entity_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)} with {@code
   * name}, {@code defaultVal}.
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String, String) with 'name', 'defaultVal'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String, String)"})
  void testAssessmentRatingWithNameDefaultVal2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult =
        questionEntityPredicateNamespace.assessmentRating("Name", "Default Val");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)} with {@code
   * name}, {@code defaultVal}.
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String, String) with 'name', 'defaultVal'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String, String)"})
  void testAssessmentRatingWithNameDefaultVal3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult =
        questionEntityPredicateNamespace.assessmentRating("Name", "Default Val");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = cast(? as varchar(4)) or \"assessment_definition\".\"name\" = cast(? as varchar(4))) and \"assessment_rating\".\"entity_kind\" = cast(? as varchar(3)) and \"assessment_rating\".\"entity_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)} with {@code
   * name}, {@code defaultVal}.
   *
   * <ul>
   *   <li>Then return {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String, String) with 'name', 'defaultVal'; then return '-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String, String)"})
  void testAssessmentRatingWithNameDefaultVal_thenReturn1() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult =
        questionEntityPredicateNamespace.assessmentRating("Name", "Default Val");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)} with {@code
   * name}, {@code defaultVal}.
   *
   * <ul>
   *   <li>Then return {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String, String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String, String) with 'name', 'defaultVal'; then return '3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String, String)"})
  void testAssessmentRatingWithNameDefaultVal_thenReturn3() throws SQLException {
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
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult =
        questionEntityPredicateNamespace.assessmentRating("Name", "Default Val");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals("3", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String)}
   */
  @Test
  @DisplayName(
      "Test assessmentRating(String) with 'name'; given PreparedStatement getWarnings() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String)"})
  void testAssessmentRatingWithName_givenPreparedStatementGetWarningsReturnNull()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult = questionEntityPredicateNamespace.assessmentRating("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String) with 'name'; then return '-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String)"})
  void testAssessmentRatingWithName_thenReturn1() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult = questionEntityPredicateNamespace.assessmentRating("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#assessmentRating(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#assessmentRating(String)}
   */
  @Test
  @DisplayName("Test assessmentRating(String) with 'name'; then return '3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QuestionEntityPredicateNamespace.assessmentRating(String)"})
  void testAssessmentRatingWithName_thenReturn3() throws SQLException {
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
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    String actualAssessmentRatingResult = questionEntityPredicateNamespace.assessmentRating("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"rating_scheme_item\".\"code\" from \"assessment_definition\" join \"assessment_rating\" on \"assessment_rating\".\"assessment_definition_id\" = \"assessment_definition\".\"id\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"assessment_definition\".\"rating_scheme_id\" join \"rating_scheme_item\" on \"rating_scheme_item\".\"id\" = \"assessment_rating\".\"rating_id\" where ((\"assessment_definition\".\"external_id\" = ? or \"assessment_definition\".\"name\" = ?) and \"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals("3", actualAssessmentRatingResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  @DisplayName(
      "Test hasInvolvement(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionEntityPredicateNamespace.hasInvolvement(String)"})
  void testHasInvolvement_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasInvolvementResult = questionEntityPredicateNamespace.hasInvolvement("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(cast(? as varchar)) and \"involvement\".\"entity_id\" = cast(? as bigint) and \"involvement\".\"entity_kind\" = cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasInvolvementResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code DERBY}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  @DisplayName(
      "Test hasInvolvement(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'DERBY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionEntityPredicateNamespace.hasInvolvement(String)"})
  void testHasInvolvement_givenDefaultDSLContextWithConnectionAndDialectIsDerby()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DERBY);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasInvolvementResult = questionEntityPredicateNamespace.hasInvolvement("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 as \"one\" from SYSIBM.SYSDUMMY1 where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(cast(? as varchar(32672))) and \"involvement\".\"entity_id\" = cast(? as bigint) and \"involvement\".\"entity_kind\" = cast(? as varchar(32672))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasInvolvementResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  @DisplayName(
      "Test hasInvolvement(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionEntityPredicateNamespace.hasInvolvement(String)"})
  void testHasInvolvement_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasInvolvementResult = questionEntityPredicateNamespace.hasInvolvement("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from RDB$DATABASE where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(cast(? as varchar(4))) and \"involvement\".\"entity_id\" = cast(? as bigint) and \"involvement\".\"entity_kind\" = cast(? as varchar(3))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasInvolvementResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  @DisplayName("Test hasInvolvement(String); given PreparedStatement getWarnings() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionEntityPredicateNamespace.hasInvolvement(String)"})
  void testHasInvolvement_givenPreparedStatementGetWarningsReturnNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasInvolvementResult = questionEntityPredicateNamespace.hasInvolvement("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(?) and \"involvement\".\"entity_id\" = ? and \"involvement\".\"entity_kind\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasInvolvementResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#getResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  @DisplayName("Test hasInvolvement(String); then calls getResultSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionEntityPredicateNamespace.hasInvolvement(String)"})
  void testHasInvolvement_thenCallsGetResultSet() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasInvolvementResult = questionEntityPredicateNamespace.hasInvolvement("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(?) and \"involvement\".\"entity_id\" = ? and \"involvement\".\"entity_kind\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasInvolvementResult);
  }

  /**
   * Test {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionEntityPredicateNamespace#hasInvolvement(String)}
   */
  @Test
  @DisplayName("Test hasInvolvement(String); then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionEntityPredicateNamespace.hasInvolvement(String)"})
  void testHasInvolvement_thenCallsGetUpdateCount() throws SQLException {
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
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    QuestionEntityPredicateNamespace questionEntityPredicateNamespace =
        new QuestionEntityPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasInvolvementResult = questionEntityPredicateNamespace.hasInvolvement("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\", \"involvement_kind\".\"id\", \"involvement_kind\".\"description\", \"involvement_kind\".\"last_updated_at\", \"involvement_kind\".\"last_updated_by\", \"involvement_kind\".\"external_id\", \"involvement_kind\".\"user_selectable\", \"involvement_kind\".\"subject_kind\", \"involvement_kind\".\"name\", \"involvement_kind\".\"permitted_role\", \"involvement_kind\".\"transitive\" from \"involvement\" join \"involvement_kind\" on \"involvement\".\"kind_id\" = \"involvement_kind\".\"id\" where (lower(\"involvement_kind\".\"name\") = lower(?) and \"involvement\".\"entity_id\" = ? and \"involvement\".\"entity_kind\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasInvolvementResult);
  }
}
