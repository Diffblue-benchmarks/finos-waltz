package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionDropdownEntry;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.finos.waltz.schema.tables.records.SurveyQuestionDropdownEntryRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TransactionalRunnable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyQuestionDropdownEntryDaoDiffblueTest {
  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#findForQuestion(long)}
   */
  @Test
  void testFindForQuestion() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForQuestionResult = (new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForQuestion(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_question_dropdown_entry\".\"id\", \"survey_question_dropdown_entry\".\"question_id\", \"survey_question_dropdown_entry\".\"value\", \"survey_question_dropdown_entry\".\"position\" from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" = ? order by \"survey_question_dropdown_entry\".\"position\" asc, \"survey_question_dropdown_entry\".\"value\" asc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(4));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindForQuestionResult.size());
    SurveyQuestionDropdownEntry getResult = actualFindForQuestionResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestionDropdownEntry);
    SurveyQuestionDropdownEntry getResult2 = actualFindForQuestionResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSurveyQuestionDropdownEntry);
    assertEquals("String", getResult.value());
    assertEquals(1, getResult.position());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, new ArrayList<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" = ?"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, new ArrayList<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" = cast(? as bigint)"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(dsl);

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, new ArrayList<>());

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries4() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(dsl);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(mock(SurveyQuestionDropdownEntry.class));

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries5() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(dsl);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(mock(SurveyQuestionDropdownEntry.class));
    entries.add(mock(SurveyQuestionDropdownEntry.class));

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.questionId()).thenReturn(ofResult2);
    when(surveyQuestionDropdownEntry.value()).thenReturn("42");

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(surveyQuestionDropdownEntry);

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("42"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(surveyQuestionDropdownEntry).id();
    verify(surveyQuestionDropdownEntry).position();
    verify(surveyQuestionDropdownEntry).questionId();
    verify(surveyQuestionDropdownEntry).value();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries7() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.CUBRID));
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.questionId()).thenReturn(ofResult2);
    when(surveyQuestionDropdownEntry.value()).thenReturn("42");

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(surveyQuestionDropdownEntry);

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("42"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(surveyQuestionDropdownEntry).id();
    verify(surveyQuestionDropdownEntry).position();
    verify(surveyQuestionDropdownEntry).questionId();
    verify(surveyQuestionDropdownEntry).value();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries8() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.questionId()).thenReturn(ofResult2);
    when(surveyQuestionDropdownEntry.value()).thenReturn("42");

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(surveyQuestionDropdownEntry);

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(2L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(2L));
    verify(preparedStatement).setString(eq(2), eq("42"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(surveyQuestionDropdownEntry).id();
    verify(surveyQuestionDropdownEntry).position();
    verify(surveyQuestionDropdownEntry).questionId();
    verify(surveyQuestionDropdownEntry).value();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  void testSaveEntries9() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.questionId()).thenReturn(ofResult2);
    when(surveyQuestionDropdownEntry.value()).thenReturn("42");
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry2 = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry2.position()).thenReturn(1);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry2.id()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry2.questionId()).thenReturn(ofResult4);
    when(surveyQuestionDropdownEntry2.value()).thenReturn("42");

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(surveyQuestionDropdownEntry2);
    entries.add(surveyQuestionDropdownEntry);

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(eq(3), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(eq(2), eq("42"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(surveyQuestionDropdownEntry2).id();
    verify(surveyQuestionDropdownEntry).id();
    verify(surveyQuestionDropdownEntry2).position();
    verify(surveyQuestionDropdownEntry).position();
    verify(surveyQuestionDropdownEntry2).questionId();
    verify(surveyQuestionDropdownEntry).questionId();
    verify(surveyQuestionDropdownEntry2).value();
    verify(surveyQuestionDropdownEntry).value();
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#findForSurveyInstance(long)}
   */
  @Test
  void testFindForSurveyInstance() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyInstanceResult = (new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSurveyInstance(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_question_dropdown_entry\".\"id\", \"survey_question_dropdown_entry\".\"question_id\", \"survey_question_dropdown_entry\".\"value\", \"survey_question_dropdown_entry\".\"position\" from \"survey_question_dropdown_entry\" join \"survey_question\" on \"survey_question\".\"id\" = \"survey_question_dropdown_entry\".\"question_id\" join \"survey_template\" on \"survey_template\".\"id\" = \"survey_question\".\"survey_template_id\" join \"survey_run\" on \"survey_run\".\"survey_template_id\" = \"survey_template\".\"id\" join \"survey_instance\" on \"survey_instance\".\"survey_run_id\" = \"survey_run\".\"id\" where \"survey_instance\".\"id\" = ? order by \"survey_question_dropdown_entry\".\"position\" asc, \"survey_question_dropdown_entry\".\"value\" asc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(4));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindForSurveyInstanceResult.size());
    SurveyQuestionDropdownEntry getResult = actualFindForSurveyInstanceResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestionDropdownEntry);
    SurveyQuestionDropdownEntry getResult2 = actualFindForSurveyInstanceResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSurveyQuestionDropdownEntry);
    assertEquals("String", getResult.value());
    assertEquals(1, getResult.position());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#findForSurveyTemplate(long)}
   */
  @Test
  void testFindForSurveyTemplate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyTemplateResult = (new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSurveyTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_question_dropdown_entry\".\"id\", \"survey_question_dropdown_entry\".\"question_id\", \"survey_question_dropdown_entry\".\"value\", \"survey_question_dropdown_entry\".\"position\" from \"survey_question_dropdown_entry\" join \"survey_question\" on \"survey_question\".\"id\" = \"survey_question_dropdown_entry\".\"question_id\" where \"survey_question\".\"survey_template_id\" = ? order by \"survey_question_dropdown_entry\".\"position\" asc, \"survey_question_dropdown_entry\".\"value\" asc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(4));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindForSurveyTemplateResult.size());
    SurveyQuestionDropdownEntry getResult = actualFindForSurveyTemplateResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestionDropdownEntry);
    SurveyQuestionDropdownEntry getResult2 = actualFindForSurveyTemplateResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSurveyQuestionDropdownEntry);
    assertEquals("String", getResult.value());
    assertEquals(1, getResult.position());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
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
    int actualDeleteForTemplateResult = (new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).deleteForTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" in (select \"survey_question\".\"id\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  void testDeleteForTemplate2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionDropdownEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<SurveyQuestionDropdownEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<SurveyQuestionDropdownEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForTemplateResult = (new SurveyQuestionDropdownEntryDao(dsl)).deleteForTemplate(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualDeleteForTemplateResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
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
    int actualDeleteForTemplateResult = (new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.MARIADB))).deleteForTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from `survey_question_dropdown_entry` where `survey_question_dropdown_entry`.`question_id` in (select `survey_question`.`id` from `survey_question` where `survey_question`.`survey_template_id` = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
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
    int actualDeleteForTemplateResult = (new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.POSTGRES))).deleteForTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" in (select \"survey_question\".\"id\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  void testDeleteForTemplate5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForTemplateResult = (new SurveyQuestionDropdownEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQLITE))).deleteForTemplate(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from survey_question_dropdown_entry where survey_question_dropdown_entry.question_id in (select survey_question.id from survey_question where survey_question.survey_template_id = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }
}
