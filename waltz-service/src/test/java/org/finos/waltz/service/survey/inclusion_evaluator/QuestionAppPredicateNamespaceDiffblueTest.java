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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QuestionAppPredicateNamespaceDiffblueTest {
  /**
   * Test {@link QuestionAppPredicateNamespace#QuestionAppPredicateNamespace(DSLContext, EntityReference, List, Map)}.
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#QuestionAppPredicateNamespace(DSLContext, EntityReference, List, Map)}
   */
  @Test
  @DisplayName("Test new QuestionAppPredicateNamespace(DSLContext, EntityReference, List, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QuestionAppPredicateNamespace.<init>(DSLContext, EntityReference, List, Map)"})
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

  /**
   * Test {@link QuestionAppPredicateNamespace#isRetiring()}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getTimestamp(int)} return {@link Timestamp}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#isRetiring()}
   */
  @Test
  @DisplayName("Test isRetiring(); given ResultSet getTimestamp(int) return Timestamp; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.isRetiring()"})
  void testIsRetiring_givenResultSetGetTimestampReturnTimestamp_thenReturnTrue() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#isRetiring()}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#isRetiring()}
   */
  @Test
  @DisplayName("Test isRetiring(); given ResultSet next() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.isRetiring()"})
  void testIsRetiring_givenResultSetNextReturnFalse_thenReturnFalse() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getInt(int)} return one.</li>
   *   <li>Then calls {@link ResultSet#getInt(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'; given ResultSet getInt(int) return one; then calls getInt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.belongsToOrgUnit(String)"})
  void testBelongsToOrgUnitWithName_givenResultSetGetIntReturnOne_thenCallsGetInt() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'; given ResultSet next() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.belongsToOrgUnit(String)"})
  void testBelongsToOrgUnitWithName_givenResultSetNextReturnFalse_thenReturnFalse() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   * <ul>
   *   <li>Then calls {@link Statement#getUpdateCount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'; then calls getUpdateCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.belongsToOrgUnit(String)"})
  void testBelongsToOrgUnitWithName_thenCallsGetUpdateCount() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#isAppKind(String)}.
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code false}.</li>
   *   <li>Then calls {@link Statement#getUpdateCount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  @DisplayName("Test isAppKind(String); given PreparedStatement execute() return 'false'; then calls getUpdateCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.isAppKind(String)"})
  void testIsAppKind_givenPreparedStatementExecuteReturnFalse_thenCallsGetUpdateCount() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#isAppKind(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getInt(int)} return one.</li>
   *   <li>Then calls {@link ResultSet#getInt(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  @DisplayName("Test isAppKind(String); given ResultSet getInt(int) return one; then calls getInt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.isAppKind(String)"})
  void testIsAppKind_givenResultSetGetIntReturnOne_thenCallsGetInt() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#isAppKind(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#isAppKind(String)}
   */
  @Test
  @DisplayName("Test isAppKind(String); given ResultSet next() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.isAppKind(String)"})
  void testIsAppKind_givenResultSetNextReturnFalse_thenReturnFalse() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getInt(int)} return one.</li>
   *   <li>Then calls {@link ResultSet#getInt(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'; given ResultSet getInt(int) return one; then calls getInt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasLifecyclePhase(String)"})
  void testHasLifecyclePhaseWithName_givenResultSetGetIntReturnOne_thenCallsGetInt() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'; given ResultSet next() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasLifecyclePhase(String)"})
  void testHasLifecyclePhaseWithName_givenResultSetNextReturnFalse_thenReturnFalse() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   * <ul>
   *   <li>Then calls {@link Statement#getUpdateCount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'; then calls getUpdateCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasLifecyclePhase(String)"})
  void testHasLifecyclePhaseWithName_thenCallsGetUpdateCount() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#hasDataType(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getString(int)} return {@code String}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#hasDataType(String)}
   */
  @Test
  @DisplayName("Test hasDataType(String); given ResultSet getString(int) return 'String'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasDataType(String)"})
  void testHasDataType_givenResultSetGetStringReturnString_thenReturnTrue() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#hasDataType(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#hasDataType(String)}
   */
  @Test
  @DisplayName("Test hasDataType(String); given ResultSet next() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionAppPredicateNamespace.hasDataType(String)"})
  void testHasDataType_givenResultSetNextReturnFalse_thenReturnFalse() throws SQLException {
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
   * Test {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getString(int)} return {@code String}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionAppPredicateNamespace#dataTypeUsages(String)}
   */
  @Test
  @DisplayName("Test dataTypeUsages(String); given ResultSet getString(int) return 'String'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set QuestionAppPredicateNamespace.dataTypeUsages(String)"})
  void testDataTypeUsages_givenResultSetGetStringReturnString_thenReturnSizeIsOne() throws SQLException {
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
}
