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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QuestionAppPredicateNamespaceDiffblueTest {
  /**
   * Method under test: {@link QuestionAppPredicateNamespace#isRetiring()}
   */
  @Test
  void testIsRetiring() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualIsRetiringResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>()))
        .isRetiring();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"planned_retirement_date\" from \"application\" where (\"application\".\"id\" = ? and \"application\".\"planned_retirement_date\" is not null and (\"application\".\"actual_retirement_date\" is null or \"application\".\"actual_retirement_date\" >= current_timestamp()))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getTimestamp(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertTrue(actualIsRetiringResult);
  }

  /**
   * Method under test: {@link QuestionAppPredicateNamespace#isRetiring()}
   */
  @Test
  void testIsRetiring2() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualIsRetiringResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>()))
        .isRetiring();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"planned_retirement_date\" from \"application\" where (\"application\".\"id\" = ? and \"application\".\"planned_retirement_date\" is not null and (\"application\".\"actual_retirement_date\" is null or \"application\".\"actual_retirement_date\" >= current_timestamp()))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertFalse(actualIsRetiringResult);
  }

  /**
   * Method under test:
   * {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  void testBelongsToOrgUnit() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualBelongsToOrgUnitResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).belongsToOrgUnit("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"app\".\"id\" from \"application\" \"app\" where (\"app\".\"id\" = ? and \"app\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = ? or \"ou\".\"external_id\" = ?)))))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("Name"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertFalse(actualBelongsToOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  void testBelongsToOrgUnit2() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualBelongsToOrgUnitResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).belongsToOrgUnit("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"app\".\"id\" from \"application\" \"app\" where (\"app\".\"id\" = ? and \"app\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = ? or \"ou\".\"external_id\" = ?)))))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("Name"));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertTrue(actualBelongsToOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  void testBelongsToOrgUnit3() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualBelongsToOrgUnitResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).belongsToOrgUnit("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"app\".\"id\" from \"application\" \"app\" where (\"app\".\"id\" = ? and \"app\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = ? or \"ou\".\"external_id\" = ?)))))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertTrue(actualBelongsToOrgUnitResult);
  }

  /**
   * Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  void testIsAppKind() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualIsAppKindResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>()))
        .isAppKind("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"id\" = ? and \"application\".\"kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("Name"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertFalse(actualIsAppKindResult);
  }

  /**
   * Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  void testIsAppKind2() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualIsAppKindResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>()))
        .isAppKind("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"id\" = ? and \"application\".\"kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("Name"));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertTrue(actualIsAppKindResult);
  }

  /**
   * Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  void testIsAppKind3() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualIsAppKindResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>()))
        .isAppKind("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"id\" = ? and \"application\".\"kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertTrue(actualIsAppKindResult);
  }

  /**
   * Method under test:
   * {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  void testHasLifecyclePhase() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualHasLifecyclePhaseResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasLifecyclePhase("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"lifecycle_phase\" = ? and \"application\".\"id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("Name"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertFalse(actualHasLifecyclePhaseResult);
  }

  /**
   * Method under test:
   * {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  void testHasLifecyclePhase2() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualHasLifecyclePhaseResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasLifecyclePhase("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"lifecycle_phase\" = ? and \"application\".\"id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("Name"));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertTrue(actualHasLifecyclePhaseResult);
  }

  /**
   * Method under test:
   * {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  void testHasLifecyclePhase3() throws SQLException {
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
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualHasLifecyclePhaseResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasLifecyclePhase("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where (\"application\".\"lifecycle_phase\" = ? and \"application\".\"id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertTrue(actualHasLifecyclePhaseResult);
  }

  /**
   * Method under test: {@link QuestionAppPredicateNamespace#hasDataType(String)}
   */
  @Test
  void testHasDataType() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    boolean actualHasDataTypeResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>()))
        .hasDataType("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = ?) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = ? or \"dt\".\"name\" = ?) and \"dtu\".\"entity_id\" = ? and \"dtu\".\"entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertTrue(actualHasDataTypeResult);
  }

  /**
   * Method under test: {@link QuestionAppPredicateNamespace#hasDataType(String)}
   */
  @Test
  void testHasDataType2() throws SQLException {
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
    boolean actualHasDataTypeResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions, new HashMap<>()))
        .hasDataType("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = ?) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = ? or \"dt\".\"name\" = ?) and \"dtu\".\"entity_id\" = ? and \"dtu\".\"entity_kind\" = ?)"));
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
    assertFalse(actualHasDataTypeResult);
  }

  /**
   * Method under test:
   * {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}
   */
  @Test
  void testDataTypeUsages() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference subjectRef = mock(EntityReference.class);
    when(subjectRef.id()).thenReturn(1L);
    when(subjectRef.kind()).thenReturn(EntityKind.ALL);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    Set<String> actualDataTypeUsagesResult = (new QuestionAppPredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).dataTypeUsages("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"dtu\".\"usage_kind\" from \"data_type\" \"dt\" join \"entity_hierarchy\" \"eh\" on (\"eh\".\"ancestor_id\" = \"dt\".\"id\" and \"eh\".\"kind\" = ?) join \"data_type_usage\" \"dtu\" on \"dtu\".\"data_type_id\" = \"eh\".\"id\" where ((\"dt\".\"code\" = ? or \"dt\".\"name\" = ?) and \"dtu\".\"entity_id\" = ? and \"dtu\".\"entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    verify(subjectRef).kind();
    assertEquals(1, actualDataTypeUsagesResult.size());
    assertTrue(actualDataTypeUsagesResult.contains("String"));
  }

  /**
   * Method under test:
   * {@link QuestionAppPredicateNamespace#QuestionAppPredicateNamespace(DSLContext, EntityReference, List, Map)}
   */
  @Test
  void testNewQuestionAppPredicateNamespace() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    // Act
    QuestionAppPredicateNamespace actualQuestionAppPredicateNamespace = new QuestionAppPredicateNamespace(dsl, null,
        questions, new HashMap<>());

    // Assert
    assertTrue(actualQuestionAppPredicateNamespace.dsl instanceof DefaultDSLContext);
    assertNull(actualQuestionAppPredicateNamespace.subjectRef);
  }
}
