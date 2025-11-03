package org.finos.waltz.service.survey.inclusion_evaluator;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.ArrayList;
import java.util.HashMap;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QuestionChangeInitiativePredicateNamespaceDiffblueTest {
  /**
   * Test {@link QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getInt(int)} return one.</li>
   *   <li>Then calls {@link ResultSet#getInt(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'; given ResultSet getInt(int) return one; then calls getInt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionChangeInitiativePredicateNamespace.belongsToOrgUnit(String)"})
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
    boolean actualBelongsToOrgUnitResult = (new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).belongsToOrgUnit("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"ci\".\"id\" from \"change_initiative\" \"ci\" where (\"ci\".\"id\" = ? and \"ci\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = ? or \"ou\".\"external_id\" = ?)))))"));
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
   * Test {@link QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'; given ResultSet next() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionChangeInitiativePredicateNamespace.belongsToOrgUnit(String)"})
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
    boolean actualBelongsToOrgUnitResult = (new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).belongsToOrgUnit("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"ci\".\"id\" from \"change_initiative\" \"ci\" where (\"ci\".\"id\" = ? and \"ci\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = ? or \"ou\".\"external_id\" = ?)))))"));
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
   * Test {@link QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)} with {@code name}.
   * <ul>
   *   <li>Then calls {@link Statement#getUpdateCount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionChangeInitiativePredicateNamespace#belongsToOrgUnit(String)}
   */
  @Test
  @DisplayName("Test belongsToOrgUnit(String) with 'name'; then calls getUpdateCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionChangeInitiativePredicateNamespace.belongsToOrgUnit(String)"})
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
    boolean actualBelongsToOrgUnitResult = (new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).belongsToOrgUnit("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"ci\".\"id\" from \"change_initiative\" \"ci\" where (\"ci\".\"id\" = ? and \"ci\".\"organisational_unit_id\" in (select distinct \"eh\".\"id\" from \"entity_hierarchy\" \"eh\" where \"eh\".\"ancestor_id\" = (select \"ou\".\"id\" from \"organisational_unit\" \"ou\" where (\"ou\".\"name\" = ? or \"ou\".\"external_id\" = ?)))))"));
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
   * Test {@link QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getInt(int)} return one.</li>
   *   <li>Then calls {@link ResultSet#getInt(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'; given ResultSet getInt(int) return one; then calls getInt(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionChangeInitiativePredicateNamespace.hasLifecyclePhase(String)"})
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
    boolean actualHasLifecyclePhaseResult = (new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasLifecyclePhase("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"change_initiative\".\"id\", \"change_initiative\".\"parent_id\", \"change_initiative\".\"external_id\", \"change_initiative\".\"name\", \"change_initiative\".\"kind\", \"change_initiative\".\"lifecycle_phase\", \"change_initiative\".\"description\", \"change_initiative\".\"last_update\", \"change_initiative\".\"start_date\", \"change_initiative\".\"end_date\", \"change_initiative\".\"provenance\", \"change_initiative\".\"organisational_unit_id\" from \"change_initiative\" where (\"change_initiative\".\"lifecycle_phase\" = ? and \"change_initiative\".\"id\" = ?))"));
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
   * Test {@link QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'; given ResultSet next() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionChangeInitiativePredicateNamespace.hasLifecyclePhase(String)"})
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
    boolean actualHasLifecyclePhaseResult = (new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasLifecyclePhase("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"change_initiative\".\"id\", \"change_initiative\".\"parent_id\", \"change_initiative\".\"external_id\", \"change_initiative\".\"name\", \"change_initiative\".\"kind\", \"change_initiative\".\"lifecycle_phase\", \"change_initiative\".\"description\", \"change_initiative\".\"last_update\", \"change_initiative\".\"start_date\", \"change_initiative\".\"end_date\", \"change_initiative\".\"provenance\", \"change_initiative\".\"organisational_unit_id\" from \"change_initiative\" where (\"change_initiative\".\"lifecycle_phase\" = ? and \"change_initiative\".\"id\" = ?))"));
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
   * Test {@link QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)} with {@code name}.
   * <ul>
   *   <li>Then calls {@link Statement#getUpdateCount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QuestionChangeInitiativePredicateNamespace#hasLifecyclePhase(String)}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String) with 'name'; then calls getUpdateCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QuestionChangeInitiativePredicateNamespace.hasLifecyclePhase(String)"})
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
    boolean actualHasLifecyclePhaseResult = (new QuestionChangeInitiativePredicateNamespace(dsl, subjectRef, questions,
        new HashMap<>())).hasLifecyclePhase("Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"change_initiative\".\"id\", \"change_initiative\".\"parent_id\", \"change_initiative\".\"external_id\", \"change_initiative\".\"name\", \"change_initiative\".\"kind\", \"change_initiative\".\"lifecycle_phase\", \"change_initiative\".\"description\", \"change_initiative\".\"last_update\", \"change_initiative\".\"start_date\", \"change_initiative\".\"end_date\", \"change_initiative\".\"provenance\", \"change_initiative\".\"organisational_unit_id\" from \"change_initiative\" where (\"change_initiative\".\"lifecycle_phase\" = ? and \"change_initiative\".\"id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("Name"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(subjectRef).id();
    assertTrue(actualHasLifecyclePhaseResult);
  }
}
