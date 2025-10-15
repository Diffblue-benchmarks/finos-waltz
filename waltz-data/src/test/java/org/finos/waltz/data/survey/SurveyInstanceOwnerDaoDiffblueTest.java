package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.List;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwnerCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceOwner;
import org.finos.waltz.model.survey.SurveyInstanceOwnerCreateCommand;
import org.finos.waltz.schema.tables.records.SurveyInstanceOwnerRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertReturningStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyInstanceOwnerDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyInstanceOwnerDao surveyInstanceOwnerDao;

  /**
   * Test {@link SurveyInstanceOwnerDao#isPersonInstanceOwner(long, long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#fetchOne(RecordMapper)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#isPersonInstanceOwner(long, long)}
   */
  @Test
  @DisplayName(
      "Test isPersonInstanceOwner(long, long); given SelectSelectStep fetchOne(RecordMapper) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceOwnerDao.isPersonInstanceOwner(long, long)"})
  void testIsPersonInstanceOwner_givenSelectSelectStepFetchOneReturnTrue_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsPersonInstanceOwnerResult =
        surveyInstanceOwnerDao.isPersonInstanceOwner(1L, 1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
    assertTrue(actualIsPersonInstanceOwnerResult);
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#isPersonInstanceOwner(long, long)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#isPersonInstanceOwner(long, long)}
   */
  @Test
  @DisplayName("Test isPersonInstanceOwner(long, long); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceOwnerDao.isPersonInstanceOwner(long, long)"})
  void testIsPersonInstanceOwner_thenReturnFalse() throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(false);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsPersonInstanceOwnerResult =
        surveyInstanceOwnerDao.isPersonInstanceOwner(1L, 1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
    assertFalse(actualIsPersonInstanceOwnerResult);
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#create(SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#newRecord(Table)} return {@link
   *       SurveyInstanceOwnerRecord#SurveyInstanceOwnerRecord()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#create(SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test create(SurveyInstanceOwnerCreateCommand); given DSLContext newRecord(Table) return SurveyInstanceOwnerRecord(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyInstanceOwnerDao.create(SurveyInstanceOwnerCreateCommand)"})
  void testCreate_givenDSLContextNewRecordReturnSurveyInstanceOwnerRecord_thenReturnOne()
      throws DataAccessException {
    // Arrange
    InsertResultStep<SurveyInstanceOwnerRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.execute()).thenReturn(1);

    InsertReturningStep<SurveyInstanceOwnerRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<SurveyInstanceOwnerRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetStep<SurveyInstanceOwnerRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<SurveyInstanceOwnerRecord>>any()))
        .thenReturn(insertSetStep);
    when(dSLContext.newRecord(Mockito.<Table<SurveyInstanceOwnerRecord>>any()))
        .thenReturn(new SurveyInstanceOwnerRecord());

    // Act
    long actualCreateResult =
        surveyInstanceOwnerDao.create(
            ImmutableSurveyInstanceOwnerCreateCommand.builder()
                .personId(1L)
                .surveyInstanceId(1L)
                .build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(dSLContext).newRecord(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertReturningStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    verify(insertResultStep).execute();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#create(SurveyInstanceOwnerCreateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceOwnerRecord#setPersonId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#create(SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName("Test create(SurveyInstanceOwnerCreateCommand); then calls setPersonId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyInstanceOwnerDao.create(SurveyInstanceOwnerCreateCommand)"})
  void testCreate_thenCallsSetPersonId() throws DataAccessException {
    // Arrange
    SurveyInstanceOwnerRecord surveyInstanceOwnerRecord = mock(SurveyInstanceOwnerRecord.class);
    doNothing().when(surveyInstanceOwnerRecord).setPersonId(Mockito.<Long>any());
    doNothing().when(surveyInstanceOwnerRecord).setSurveyInstanceId(Mockito.<Long>any());

    InsertResultStep<SurveyInstanceOwnerRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.execute()).thenReturn(1);

    InsertReturningStep<SurveyInstanceOwnerRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<SurveyInstanceOwnerRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetStep<SurveyInstanceOwnerRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<SurveyInstanceOwnerRecord>>any()))
        .thenReturn(insertSetStep);
    when(dSLContext.newRecord(Mockito.<Table<SurveyInstanceOwnerRecord>>any()))
        .thenReturn(surveyInstanceOwnerRecord);

    // Act
    long actualCreateResult =
        surveyInstanceOwnerDao.create(
            ImmutableSurveyInstanceOwnerCreateCommand.builder()
                .personId(1L)
                .surveyInstanceId(1L)
                .build());

    // Assert
    verify(surveyInstanceOwnerRecord).setPersonId(1L);
    verify(surveyInstanceOwnerRecord).setSurveyInstanceId(1L);
    verify(dSLContext).insertInto(isA(Table.class));
    verify(dSLContext).newRecord(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertReturningStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    verify(insertResultStep).execute();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#delete(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#delete(long, long)}
   */
  @Test
  @DisplayName(
      "Test delete(long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceOwnerDao.delete(long, long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    boolean actualDeleteResult = new SurveyInstanceOwnerDao(dsl).delete(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_instance_owner\" where (\"survey_instance_owner\".\"person_id\" = cast(? as bigint) and \"survey_instance_owner\".\"survey_instance_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#delete(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#delete(long, long)}
   */
  @Test
  @DisplayName(
      "Test delete(long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceOwnerDao.delete(long, long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    boolean actualDeleteResult = new SurveyInstanceOwnerDao(dsl).delete(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_instance_owner\" where (\"survey_instance_owner\".\"person_id\" = ? and \"survey_instance_owner\".\"survey_instance_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#delete(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#delete(long, long)}
   */
  @Test
  @DisplayName(
      "Test delete(long, long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceOwnerDao.delete(long, long)"})
  void testDelete_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyInstanceOwnerRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<SurveyInstanceOwnerRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyInstanceOwnerRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyInstanceOwnerRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteResult = surveyInstanceOwnerDao.delete(1L, 1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#delete(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#delete(long, long)}
   */
  @Test
  @DisplayName(
      "Test delete(long, long); given DeleteConditionStep execute() return zero; then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceOwnerDao.delete(long, long)"})
  void testDelete_givenDeleteConditionStepExecuteReturnZero_thenCallsDeleteFrom()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyInstanceOwnerRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<SurveyInstanceOwnerRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyInstanceOwnerRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyInstanceOwnerRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteResult = surveyInstanceOwnerDao.delete(1L, 1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#findForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceOwnerDao.findForSurveyInstance(long)"})
  void testFindForSurveyInstance() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<SurveyInstanceOwner> actualFindForSurveyInstanceResult =
        surveyInstanceOwnerDao.findForSurveyInstance(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#findPeopleForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#findPeopleForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findPeopleForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceOwnerDao.findPeopleForSurveyInstance(long)"})
  void testFindPeopleForSurveyInstance() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindPeopleForSurveyInstanceResult =
        surveyInstanceOwnerDao.findPeopleForSurveyInstance(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindPeopleForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#getPersonIdForOwnerId(long)}.
   *
   * <ul>
   *   <li>Then return longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#getPersonIdForOwnerId(long)}
   */
  @Test
  @DisplayName("Test getPersonIdForOwnerId(long); then return longValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SurveyInstanceOwnerDao.getPersonIdForOwnerId(long)"})
  void testGetPersonIdForOwnerId_thenReturnLongValueIsMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    Long actualPersonIdForOwnerId = new SurveyInstanceOwnerDao(dsl).getPersonIdForOwnerId(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"survey_instance_owner\".\"person_id\" from \"survey_instance_owner\" where \"survey_instance_owner\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1L, actualPersonIdForOwnerId.longValue());
  }

  /**
   * Test {@link SurveyInstanceOwnerDao#getPersonIdForOwnerId(long)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceOwnerDao#getPersonIdForOwnerId(long)}
   */
  @Test
  @DisplayName("Test getPersonIdForOwnerId(long); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SurveyInstanceOwnerDao.getPersonIdForOwnerId(long)"})
  void testGetPersonIdForOwnerId_thenReturnLongValueIsOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(1L);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Long actualPersonIdForOwnerId = surveyInstanceOwnerDao.getPersonIdForOwnerId(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualPersonIdForOwnerId.longValue());
  }
}
