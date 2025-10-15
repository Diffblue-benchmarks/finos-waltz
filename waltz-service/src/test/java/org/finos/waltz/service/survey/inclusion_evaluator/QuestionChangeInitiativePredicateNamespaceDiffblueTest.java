package org.finos.waltz.service.survey.inclusion_evaluator;

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

class QuestionChangeInitiativePredicateNamespaceDiffblueTest {
  /**
   * Test {@link
   * QuestionChangeInitiativePredicateNamespace#QuestionChangeInitiativePredicateNamespace(DSLContext,
   * EntityReference, List, Map)}.
   *
   * <p>Method under test: {@link
   * QuestionChangeInitiativePredicateNamespace#QuestionChangeInitiativePredicateNamespace(DSLContext,
   * EntityReference, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new QuestionChangeInitiativePredicateNamespace(DSLContext, EntityReference, List, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuestionChangeInitiativePredicateNamespace.<init>(DSLContext, EntityReference, List, Map)"
  })
  void testNewQuestionChangeInitiativePredicateNamespace() {
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
    QuestionChangeInitiativePredicateNamespace actualQuestionChangeInitiativePredicateNamespace =
        new QuestionChangeInitiativePredicateNamespace(dsl, null, questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionChangeInitiativePredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionChangeInitiativePredicateNamespace.subjectRef);
  }

  /**
   * Test {@link
   * QuestionChangeInitiativePredicateNamespace#QuestionChangeInitiativePredicateNamespace(DSLContext,
   * EntityReference, List, Map)}.
   *
   * <p>Method under test: {@link
   * QuestionChangeInitiativePredicateNamespace#QuestionChangeInitiativePredicateNamespace(DSLContext,
   * EntityReference, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new QuestionChangeInitiativePredicateNamespace(DSLContext, EntityReference, List, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuestionChangeInitiativePredicateNamespace.<init>(DSLContext, EntityReference, List, Map)"
  })
  void testNewQuestionChangeInitiativePredicateNamespace2() {
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
    QuestionChangeInitiativePredicateNamespace actualQuestionChangeInitiativePredicateNamespace =
        new QuestionChangeInitiativePredicateNamespace(dsl, null, questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionChangeInitiativePredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionChangeInitiativePredicateNamespace.subjectRef);
  }

  /**
   * Test {@link
   * QuestionChangeInitiativePredicateNamespace#QuestionChangeInitiativePredicateNamespace(DSLContext,
   * EntityReference, List, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * QuestionChangeInitiativePredicateNamespace#QuestionChangeInitiativePredicateNamespace(DSLContext,
   * EntityReference, List, Map)}
   */
  @Test
  @DisplayName(
      "Test new QuestionChangeInitiativePredicateNamespace(DSLContext, EntityReference, List, Map); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuestionChangeInitiativePredicateNamespace.<init>(DSLContext, EntityReference, List, Map)"
  })
  void testNewQuestionChangeInitiativePredicateNamespace_whenArrayList() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    QuestionChangeInitiativePredicateNamespace actualQuestionChangeInitiativePredicateNamespace =
        new QuestionChangeInitiativePredicateNamespace(dsl, null, questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionChangeInitiativePredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionChangeInitiativePredicateNamespace.subjectRef);
  }

  /**
   * Test {@link QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)} with {@code
   * name}.
   *
   * <p>Method under test: {@link
   * QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionChangeInitiativePredicateNamespace.belongsToOrgUnit(String)"})
  void testBelongsToOrgUnitWithName() throws SQLException {
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

    QuestionChangeInitiativePredicateNamespace questionChangeInitiativePredicateNamespace =
        new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualBelongsToOrgUnitResult =
        questionChangeInitiativePredicateNamespace.belongsToOrgUnit("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"ci\".\"id\" from \"change_initiative\" \"ci\" where (\"ci\".\"id\" = cast(? as bigint) and \"ci\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = cast(? as varchar) or \"ou\".\"external_id\" = cast(? as varchar))))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualBelongsToOrgUnitResult);
  }

  /**
   * Test {@link QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)} with {@code
   * name}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionChangeInitiativePredicateNamespace.belongsToOrgUnit(String)"})
  void testBelongsToOrgUnitWithName_thenReturnTrue() throws SQLException {
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

    QuestionChangeInitiativePredicateNamespace questionChangeInitiativePredicateNamespace =
        new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualBelongsToOrgUnitResult =
        questionChangeInitiativePredicateNamespace.belongsToOrgUnit("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"ci\".\"id\" from \"change_initiative\" \"ci\" where (\"ci\".\"id\" = ? and \"ci\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = ? or \"ou\".\"external_id\" = ?)))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualBelongsToOrgUnitResult);
  }

  /**
   * Test {@link QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)} with {@code
   * name}.
   *
   * <p>Method under test: {@link
   * QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean QuestionChangeInitiativePredicateNamespace.hasLifecyclePhase(String)"
  })
  void testHasLifecyclePhaseWithName() throws SQLException {
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

    QuestionChangeInitiativePredicateNamespace questionChangeInitiativePredicateNamespace =
        new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasLifecyclePhaseResult =
        questionChangeInitiativePredicateNamespace.hasLifecyclePhase("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"change_initiative\".\"id\", \"change_initiative\".\"parent_id\", \"change_initiative\".\"external_id\", \"change_initiative\".\"name\", \"change_initiative\".\"kind\", \"change_initiative\".\"lifecycle_phase\", \"change_initiative\".\"description\", \"change_initiative\".\"last_update\", \"change_initiative\".\"start_date\", \"change_initiative\".\"end_date\", \"change_initiative\".\"provenance\", \"change_initiative\".\"organisational_unit_id\" from \"change_initiative\" where (\"change_initiative\".\"lifecycle_phase\" = cast(? as varchar) and \"change_initiative\".\"id\" = cast(? as bigint)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasLifecyclePhaseResult);
  }

  /**
   * Test {@link QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)} with {@code
   * name}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean QuestionChangeInitiativePredicateNamespace.hasLifecyclePhase(String)"
  })
  void testHasLifecyclePhaseWithName_thenReturnTrue() throws SQLException {
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

    QuestionChangeInitiativePredicateNamespace questionChangeInitiativePredicateNamespace =
        new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasLifecyclePhaseResult =
        questionChangeInitiativePredicateNamespace.hasLifecyclePhase("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"change_initiative\".\"id\", \"change_initiative\".\"parent_id\", \"change_initiative\".\"external_id\", \"change_initiative\".\"name\", \"change_initiative\".\"kind\", \"change_initiative\".\"lifecycle_phase\", \"change_initiative\".\"description\", \"change_initiative\".\"last_update\", \"change_initiative\".\"start_date\", \"change_initiative\".\"end_date\", \"change_initiative\".\"provenance\", \"change_initiative\".\"organisational_unit_id\" from \"change_initiative\" where (\"change_initiative\".\"lifecycle_phase\" = ? and \"change_initiative\".\"id\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasLifecyclePhaseResult);
  }
}
