package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionDropdownEntry;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.finos.waltz.schema.tables.records.SurveyQuestionDropdownEntryRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSeekStep2;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalRunnable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyQuestionDropdownEntryDaoDiffblueTest {
  /**
   * Test {@link SurveyQuestionDropdownEntryDao#findForQuestion(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#findForQuestion(long)}
   */
  @Test
  @DisplayName("Test findForQuestion(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionDropdownEntryDao.findForQuestion(long)"})
  void testFindForQuestion() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForQuestionResult =
        new SurveyQuestionDropdownEntryDao(dsl).findForQuestion(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForQuestionResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transaction(TransactionalRunnable)} does
   *       nothing.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, Collection); given DSLContext transaction(TransactionalRunnable) does nothing; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionDropdownEntryDao.saveEntries(long, Collection)"})
  void testSaveEntries_givenDSLContextTransactionDoesNothing_thenCallsTransaction() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        new SurveyQuestionDropdownEntryDao(dsl);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionDropdownEntryDao.saveEntries(long, Collection)"})
  void testSaveEntries_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        new SurveyQuestionDropdownEntryDao(dsl);

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, new ArrayList<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" = cast(? as bigint)");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionDropdownEntryDao.saveEntries(long, Collection)"})
  void testSaveEntries_givenDefaultDSLContextWithConnectionAndDialectIsCubrid2()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        new SurveyQuestionDropdownEntryDao(dsl);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(3, 1);
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement).setString(2, "42");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionDropdownEntryDao.saveEntries(long, Collection)"})
  void testSaveEntries_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        new SurveyQuestionDropdownEntryDao(dsl);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(3, 1);
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement).setString(2, "42");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionDropdownEntryDao.saveEntries(long, Collection)"})
  void testSaveEntries_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        new SurveyQuestionDropdownEntryDao(dsl);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(3, 1);
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement).setString(2, "42");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionDropdownEntryDao.saveEntries(long, Collection)"})
  void testSaveEntries_givenDefaultDSLContextWithConnectionAndDialectIsSql99_whenTwo()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        new SurveyQuestionDropdownEntryDao(dsl);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(2L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(3, 1);
    verify(preparedStatement, atLeast(1)).setLong(1, 2L);
    verify(preparedStatement).setString(2, "42");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionDropdownEntryDao.saveEntries(long, Collection)"})
  void testSaveEntries_givenDefaultDSLContextWithConnectionAndDialectIsSql992()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        new SurveyQuestionDropdownEntryDao(dsl);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, entries);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(3, 1);
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(2, "42");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#saveEntries(long, Collection)}
   */
  @Test
  @DisplayName("Test saveEntries(long, Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SurveyQuestionDropdownEntryDao.saveEntries(long, Collection)"})
  void testSaveEntries_whenArrayList() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        new SurveyQuestionDropdownEntryDao(dsl);

    // Act
    surveyQuestionDropdownEntryDao.saveEntries(1L, new ArrayList<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" = ?");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#findForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionDropdownEntryDao.findForSurveyInstance(long)"})
  void testFindForSurveyInstance() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectOnStep<Record> selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyInstanceResult =
        new SurveyQuestionDropdownEntryDao(dsl).findForSurveyInstance(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep4).on(isA(Condition.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#findForSurveyTemplate(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#findForSurveyTemplate(long)}
   */
  @Test
  @DisplayName("Test findForSurveyTemplate(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionDropdownEntryDao.findForSurveyTemplate(long)"})
  void testFindForSurveyTemplate() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyTemplateResult =
        new SurveyQuestionDropdownEntryDao(dsl).findForSurveyTemplate(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDropdownEntryDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualDeleteForTemplateResult =
        new SurveyQuestionDropdownEntryDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" in (select \"survey_question\".\"id\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDropdownEntryDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsMariadb()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);

    // Act
    int actualDeleteForTemplateResult =
        new SurveyQuestionDropdownEntryDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from `survey_question_dropdown_entry` where `survey_question_dropdown_entry`.`question_id` in (select `survey_question`.`id` from `survey_question` where `survey_question`.`survey_template_id` = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDropdownEntryDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    int actualDeleteForTemplateResult =
        new SurveyQuestionDropdownEntryDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" in (select \"survey_question\".\"id\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDropdownEntryDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteForTemplateResult =
        new SurveyQuestionDropdownEntryDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" in (select \"survey_question\".\"id\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDropdownEntryDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsSqlite()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    int actualDeleteForTemplateResult =
        new SurveyQuestionDropdownEntryDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from survey_question_dropdown_entry where survey_question_dropdown_entry.question_id in (select survey_question.id from survey_question where survey_question.survey_template_id = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDropdownEntryDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionDropdownEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<SurveyQuestionDropdownEntryRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<SurveyQuestionDropdownEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForTemplateResult =
        new SurveyQuestionDropdownEntryDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given PreparedStatement getWarnings() return 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDropdownEntryDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenPreparedStatementGetWarningsReturnNull_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteForTemplateResult =
        new SurveyQuestionDropdownEntryDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question_dropdown_entry\" where \"survey_question_dropdown_entry\".\"question_id\" in (select \"survey_question\".\"id\" from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }
}
