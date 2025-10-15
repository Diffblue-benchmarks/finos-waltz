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
import org.finos.waltz.model.survey.SurveyInstanceRecipient;
import org.finos.waltz.schema.tables.records.SurveyInstanceRecipientRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
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
class SurveyInstanceRecipientDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyInstanceRecipientDao surveyInstanceRecipientDao;

  /**
   * Test {@link SurveyInstanceRecipientDao#isPersonInstanceRecipient(long, long)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#isPersonInstanceRecipient(long, long)}
   */
  @Test
  @DisplayName("Test isPersonInstanceRecipient(long, long); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceRecipientDao.isPersonInstanceRecipient(long, long)"})
  void testIsPersonInstanceRecipient_thenReturnFalse() throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(false);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsPersonInstanceRecipientResult =
        surveyInstanceRecipientDao.isPersonInstanceRecipient(1L, 1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
    assertFalse(actualIsPersonInstanceRecipientResult);
  }

  /**
   * Test {@link SurveyInstanceRecipientDao#isPersonInstanceRecipient(long, long)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#isPersonInstanceRecipient(long, long)}
   */
  @Test
  @DisplayName("Test isPersonInstanceRecipient(long, long); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceRecipientDao.isPersonInstanceRecipient(long, long)"})
  void testIsPersonInstanceRecipient_thenReturnTrue() throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsPersonInstanceRecipientResult =
        surveyInstanceRecipientDao.isPersonInstanceRecipient(1L, 1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).fetchOne(isA(RecordMapper.class));
    assertTrue(actualIsPersonInstanceRecipientResult);
  }

  /**
   * Test {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}
   */
  @Test
  @DisplayName("Test deleteByInstanceAndPerson(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceRecipientDao.deleteByInstanceAndPerson(long, long)"})
  void testDeleteByInstanceAndPerson() throws SQLException {
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
    boolean actualDeleteByInstanceAndPersonResult =
        new SurveyInstanceRecipientDao(dsl).deleteByInstanceAndPerson(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_instance_recipient\" where (\"survey_instance_recipient\".\"survey_instance_id\" = ? and \"survey_instance_recipient\".\"person_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByInstanceAndPersonResult);
  }

  /**
   * Test {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}.
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}
   */
  @Test
  @DisplayName("Test deleteByInstanceAndPerson(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceRecipientDao.deleteByInstanceAndPerson(long, long)"})
  void testDeleteByInstanceAndPerson2() throws SQLException {
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
    boolean actualDeleteByInstanceAndPersonResult =
        new SurveyInstanceRecipientDao(dsl).deleteByInstanceAndPerson(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_instance_recipient\" where (\"survey_instance_recipient\".\"survey_instance_id\" = cast(? as bigint) and \"survey_instance_recipient\".\"person_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByInstanceAndPersonResult);
  }

  /**
   * Test {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}
   */
  @Test
  @DisplayName(
      "Test deleteByInstanceAndPerson(long, long); given DeleteConditionStep execute() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceRecipientDao.deleteByInstanceAndPerson(long, long)"})
  void testDeleteByInstanceAndPerson_givenDeleteConditionStepExecuteReturnZero()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyInstanceRecipientRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<SurveyInstanceRecipientRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyInstanceRecipientRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyInstanceRecipientRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteByInstanceAndPersonResult =
        surveyInstanceRecipientDao.deleteByInstanceAndPerson(1L, 1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualDeleteByInstanceAndPersonResult);
  }

  /**
   * Test {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#deleteByInstanceAndPerson(long, long)}
   */
  @Test
  @DisplayName("Test deleteByInstanceAndPerson(long, long); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstanceRecipientDao.deleteByInstanceAndPerson(long, long)"})
  void testDeleteByInstanceAndPerson_thenReturnTrue() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyInstanceRecipientRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<SurveyInstanceRecipientRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyInstanceRecipientRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyInstanceRecipientRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteByInstanceAndPersonResult =
        surveyInstanceRecipientDao.deleteByInstanceAndPerson(1L, 1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualDeleteByInstanceAndPersonResult);
  }

  /**
   * Test {@link SurveyInstanceRecipientDao#findForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceRecipientDao.findForSurveyInstance(long)"})
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
    List<SurveyInstanceRecipient> actualFindForSurveyInstanceResult =
        surveyInstanceRecipientDao.findForSurveyInstance(1L);

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
   * Test {@link SurveyInstanceRecipientDao#findPeopleForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#findPeopleForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findPeopleForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyInstanceRecipientDao.findPeopleForSurveyInstance(long)"})
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
        surveyInstanceRecipientDao.findPeopleForSurveyInstance(1L);

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
   * Test {@link SurveyInstanceRecipientDao#getPersonIdForRecipientId(long)}.
   *
   * <ul>
   *   <li>Then return longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#getPersonIdForRecipientId(long)}
   */
  @Test
  @DisplayName("Test getPersonIdForRecipientId(long); then return longValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SurveyInstanceRecipientDao.getPersonIdForRecipientId(long)"})
  void testGetPersonIdForRecipientId_thenReturnLongValueIsMinusOne() throws SQLException {
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
    Long actualPersonIdForRecipientId =
        new SurveyInstanceRecipientDao(dsl).getPersonIdForRecipientId(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"survey_instance_recipient\".\"person_id\" from \"survey_instance_recipient\" where \"survey_instance_recipient\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1L, actualPersonIdForRecipientId.longValue());
  }

  /**
   * Test {@link SurveyInstanceRecipientDao#getPersonIdForRecipientId(long)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceRecipientDao#getPersonIdForRecipientId(long)}
   */
  @Test
  @DisplayName("Test getPersonIdForRecipientId(long); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SurveyInstanceRecipientDao.getPersonIdForRecipientId(long)"})
  void testGetPersonIdForRecipientId_thenReturnLongValueIsOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(1L);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Long actualPersonIdForRecipientId = surveyInstanceRecipientDao.getPersonIdForRecipientId(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualPersonIdForRecipientId.longValue());
  }
}
