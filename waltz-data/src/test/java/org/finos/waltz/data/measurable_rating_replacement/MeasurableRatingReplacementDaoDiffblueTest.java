package org.finos.waltz.data.measurable_rating_replacement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.schema.tables.records.MeasurableRatingReplacementRecord;
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
import org.jooq.SelectJoinPartitionByStep;
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
class MeasurableRatingReplacementDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private MeasurableRatingReplacementDao measurableRatingReplacementDao;

  /**
   * Test {@link MeasurableRatingReplacementDao#fetchByDecommissionId(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementDao#fetchByDecommissionId(Long)}
   */
  @Test
  @DisplayName("Test fetchByDecommissionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingReplacementDao.fetchByDecommissionId(Long)"})
  void testFetchByDecommissionId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<MeasurableRatingReplacement> actualFetchByDecommissionIdResult =
        measurableRatingReplacementDao.fetchByDecommissionId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFetchByDecommissionIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingReplacementDao#fetchByEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingReplacementDao#fetchByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test fetchByEntityRef(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingReplacementDao.fetchByEntityRef(EntityReference)"})
  void testFetchByEntityRef_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<MeasurableRatingReplacement> actualFetchByEntityRefResult =
        measurableRatingReplacementDao.fetchByEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFetchByEntityRefResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingReplacementDao#remove(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingReplacementDao#remove(long, long)}
   */
  @Test
  @DisplayName(
      "Test remove(long, long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingReplacementDao.remove(long, long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DeleteConditionStep<MeasurableRatingReplacementRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<MeasurableRatingReplacementRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<MeasurableRatingReplacementRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingReplacementRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualRemoveResult = measurableRatingReplacementDao.remove(1L, 1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingReplacementDao#remove(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingReplacementDao#remove(long, long)}
   */
  @Test
  @DisplayName(
      "Test remove(long, long); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingReplacementDao.remove(long, long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DeleteConditionStep<MeasurableRatingReplacementRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<MeasurableRatingReplacementRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<MeasurableRatingReplacementRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingReplacementRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualRemoveResult = measurableRatingReplacementDao.remove(1L, 1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingReplacementDao#calculateAmendedReplacementOperations(Set, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementDao#calculateAmendedReplacementOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedReplacementOperations(Set, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementDao.calculateAmendedReplacementOperations(Set, long, String)"
  })
  void testCalculateAmendedReplacementOperations() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(true);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Set<Operation> actualCalculateAmendedReplacementOperationsResult =
        measurableRatingReplacementDao.calculateAmendedReplacementOperations(
            new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertEquals(3, actualCalculateAmendedReplacementOperationsResult.size());
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link MeasurableRatingReplacementDao#calculateAmendedReplacementOperations(Set, long,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementDao#calculateAmendedReplacementOperations(Set, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedReplacementOperations(Set, long, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementDao.calculateAmendedReplacementOperations(Set, long, String)"
  })
  void testCalculateAmendedReplacementOperations_thenCallsPrepareStatement() throws SQLException {
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
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        new MeasurableRatingReplacementDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedReplacementOperationsResult =
        measurableRatingReplacementDao.calculateAmendedReplacementOperations(
            new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"user_role\".\"role\" from \"measurable_category\" left outer join \"user_role\" on (\"user_role\".\"role\" = \"measurable_category\".\"rating_editor_role\" and \"user_role\".\"user_name\" = ?) where \"measurable_category\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "janedoe");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedReplacementOperationsResult.size());
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link MeasurableRatingReplacementDao#calculateAmendedReplacementOperations(Set, long,
   * String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementDao#calculateAmendedReplacementOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedReplacementOperations(Set, long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementDao.calculateAmendedReplacementOperations(Set, long, String)"
  })
  void testCalculateAmendedReplacementOperations_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(false);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Set<Operation> actualCalculateAmendedReplacementOperationsResult =
        measurableRatingReplacementDao.calculateAmendedReplacementOperations(
            new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualCalculateAmendedReplacementOperationsResult.isEmpty());
  }
}
