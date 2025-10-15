package org.finos.waltz.service.survey.inclusion_evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QuestionAppPredicateNamespaceDiffblueTest {
  /**
   * Test {@link QuestionAppPredicateNamespace#QuestionAppPredicateNamespace(DSLContext,
   * EntityReference, List, Map)}.
   *
   * <p>Method under test: {@link
   * QuestionAppPredicateNamespace#QuestionAppPredicateNamespace(DSLContext, EntityReference, List,
   * Map)}
   */
  @Test
  @DisplayName("Test new QuestionAppPredicateNamespace(DSLContext, EntityReference, List, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QuestionAppPredicateNamespace.<init>(DSLContext, EntityReference, List, Map)"
  })
  void testNewQuestionAppPredicateNamespace() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
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

    // Act
    QuestionAppPredicateNamespace actualQuestionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Assert
    EntityReference entityReference = actualQuestionAppPredicateNamespace.subjectRef;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertTrue(actualQuestionAppPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.belongsToOrgUnit(String)"})
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualBelongsToOrgUnitResult = questionAppPredicateNamespace.belongsToOrgUnit("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"app\".\"id\" from \"application\" \"app\" where (\"app\".\"id\" = cast(? as bigint) and \"app\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = cast(? as varchar) or \"ou\".\"external_id\" = cast(? as varchar))))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualBelongsToOrgUnitResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.belongsToOrgUnit(String)"})
  void testBelongsToOrgUnitWithName2() throws SQLException {
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualBelongsToOrgUnitResult = questionAppPredicateNamespace.belongsToOrgUnit("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from RDB$DATABASE where exists (select \"app\".\"id\" from \"application\" \"app\" where (\"app\".\"id\" = cast(? as bigint) and \"app\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = cast(? as varchar(4)) or \"ou\".\"external_id\" = cast(? as varchar(4)))))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualBelongsToOrgUnitResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.belongsToOrgUnit(String)"})
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualBelongsToOrgUnitResult = questionAppPredicateNamespace.belongsToOrgUnit("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"app\".\"id\" from \"application\" \"app\" where (\"app\".\"id\" = ? and \"app\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = ? or \"ou\".\"external_id\" = ?)))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualBelongsToOrgUnitResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#isAppKind(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  @DisplayName(
      "Test isAppKind(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.isAppKind(String)"})
  void testIsAppKind_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualIsAppKindResult = questionAppPredicateNamespace.isAppKind("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"id\" = cast(? as bigint) and \"application\".\"kind\" = cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsAppKindResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#isAppKind(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  @DisplayName(
      "Test isAppKind(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.isAppKind(String)"})
  void testIsAppKind_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualIsAppKindResult = questionAppPredicateNamespace.isAppKind("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from RDB$DATABASE where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"id\" = cast(? as bigint) and \"application\".\"kind\" = cast(? as varchar(4))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsAppKindResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#isAppKind(String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  @DisplayName(
      "Test isAppKind(String); given PreparedStatement getResultSet() return 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.isAppKind(String)"})
  void testIsAppKind_givenPreparedStatementGetResultSetReturnNull_thenReturnTrue()
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualIsAppKindResult = questionAppPredicateNamespace.isAppKind("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"id\" = ? and \"application\".\"kind\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsAppKindResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasLifecyclePhase(String)"})
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasLifecyclePhaseResult = questionAppPredicateNamespace.hasLifecyclePhase("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"lifecycle_phase\" = cast(? as varchar) and \"application\".\"id\" = cast(? as bigint)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasLifecyclePhaseResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasLifecyclePhase(String)"})
  void testHasLifecyclePhaseWithName2() throws SQLException {
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasLifecyclePhaseResult = questionAppPredicateNamespace.hasLifecyclePhase("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from RDB$DATABASE where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"lifecycle_phase\" = cast(? as varchar(4)) and \"application\".\"id\" = cast(? as bigint)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasLifecyclePhaseResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasLifecyclePhase(String)"})
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasLifecyclePhaseResult = questionAppPredicateNamespace.hasLifecyclePhase("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"lifecycle_phase\" = ? and \"application\".\"id\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasLifecyclePhaseResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#hasDataType(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#hasDataType(String)}
   */
  @Test
  @DisplayName(
      "Test hasDataType(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasDataType(String)"})
  void testHasDataType_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasDataTypeResult = questionAppPredicateNamespace.hasDataType("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = cast(? as varchar)) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = cast(? as varchar) or \"dt\".\"name\" = cast(? as varchar)) and \"dtu\".\"entity_id\" = cast(? as bigint) and \"dtu\".\"entity_kind\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasDataTypeResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#hasDataType(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#hasDataType(String)}
   */
  @Test
  @DisplayName(
      "Test hasDataType(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasDataType(String)"})
  void testHasDataType_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasDataTypeResult = questionAppPredicateNamespace.hasDataType("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = cast(? as varchar(9))) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = cast(? as varchar(4)) or \"dt\".\"name\" = cast(? as varchar(4))) and \"dtu\".\"entity_id\" = cast(? as bigint) and \"dtu\".\"entity_kind\" = cast(? as varchar(3)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasDataTypeResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#hasDataType(String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#hasDataType(String)}
   */
  @Test
  @DisplayName(
      "Test hasDataType(String); given PreparedStatement getResultSet() return 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasDataType(String)"})
  void testHasDataType_givenPreparedStatementGetResultSetReturnNull_thenReturnTrue()
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    boolean actualHasDataTypeResult = questionAppPredicateNamespace.hasDataType("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = ?) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = ? or \"dt\".\"name\" = ?) and \"dtu\".\"entity_id\" = ? and \"dtu\".\"entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasDataTypeResult);
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}
   */
  @Test
  @DisplayName(
      "Test dataTypeUsages(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set QuestionAppPredicateNamespace.dataTypeUsages(String)"})
  void testDataTypeUsages_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    Set<String> actualDataTypeUsagesResult = questionAppPredicateNamespace.dataTypeUsages("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = cast(? as varchar)) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = cast(? as varchar) or \"dt\".\"name\" = cast(? as varchar)) and \"dtu\".\"entity_id\" = cast(? as bigint) and \"dtu\".\"entity_kind\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualDataTypeUsagesResult.size());
    assertTrue(actualDataTypeUsagesResult.contains("-1"));
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}
   */
  @Test
  @DisplayName(
      "Test dataTypeUsages(String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set QuestionAppPredicateNamespace.dataTypeUsages(String)"})
  void testDataTypeUsages_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    Set<String> actualDataTypeUsagesResult = questionAppPredicateNamespace.dataTypeUsages("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = cast(? as varchar(9))) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = cast(? as varchar(4)) or \"dt\".\"name\" = cast(? as varchar(4))) and \"dtu\".\"entity_id\" = cast(? as bigint) and \"dtu\".\"entity_kind\" = cast(? as varchar(3)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualDataTypeUsagesResult.size());
    assertTrue(actualDataTypeUsagesResult.contains("-1"));
  }

  /**
   * Test {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}
   */
  @Test
  @DisplayName("Test dataTypeUsages(String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set QuestionAppPredicateNamespace.dataTypeUsages(String)"})
  void testDataTypeUsages_thenReturnSizeIsOne() throws SQLException {
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

    QuestionAppPredicateNamespace questionAppPredicateNamespace =
        new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>());

    // Act
    Set<String> actualDataTypeUsagesResult = questionAppPredicateNamespace.dataTypeUsages("Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = ?) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = ? or \"dt\".\"name\" = ?) and \"dtu\".\"entity_id\" = ? and \"dtu\".\"entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualDataTypeUsagesResult.size());
    assertTrue(actualDataTypeUsagesResult.contains("-1"));
  }
}
