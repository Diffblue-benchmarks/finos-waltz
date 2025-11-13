package org.finos.waltz.data.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.common.exception.ModifyingReadOnlyRecordException;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.command.DateFieldChange;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionInfo;
import org.finos.waltz.schema.tables.records.MeasurableRatingPlannedDecommissionRecord;
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
class MeasurableRatingPlannedDecommissionDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks
  private MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao;

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext,
   * long)}
   */
  @Test
  @DisplayName("Test checkIfReadOnly(DSLContext, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(DSLContext, long)"
  })
  void testCheckIfReadOnly() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DefaultDSLContext myDsl = mock(DefaultDSLContext.class);
    when(myDsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(myDsl, 1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(myDsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext,
   * long)}
   */
  @Test
  @DisplayName("Test checkIfReadOnly(DSLContext, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(DSLContext, long)"
  })
  void testCheckIfReadOnly2() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext myDsl = mock(DefaultDSLContext.class);
    when(myDsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(myDsl, 1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(myDsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext,
   * long)}
   */
  @Test
  @DisplayName("Test checkIfReadOnly(DSLContext, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(DSLContext, long)"
  })
  void testCheckIfReadOnly3() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext myDsl = mock(DefaultDSLContext.class);
    when(myDsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(myDsl, 1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(myDsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext,
   * long)}
   */
  @Test
  @DisplayName("Test checkIfReadOnly(DSLContext, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(DSLContext, long)"
  })
  void testCheckIfReadOnly4() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(dSLContext, 1L));
    verify(dSLContext).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext,
   * long)}
   */
  @Test
  @DisplayName("Test checkIfReadOnly(DSLContext, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(DSLContext, long)"
  })
  void testCheckIfReadOnly5() {
    // Arrange
    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(dSLContext, 1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext,
   * long)}
   */
  @Test
  @DisplayName("Test checkIfReadOnly(DSLContext, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(DSLContext, long)"
  })
  void testCheckIfReadOnly6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(dSLContext, 1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(Field)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext,
   * long)}
   */
  @Test
  @DisplayName(
      "Test checkIfReadOnly(DSLContext, long); given SelectConditionStep fetchOne(Field) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(DSLContext, long)"
  })
  void testCheckIfReadOnly_givenSelectConditionStepFetchOneReturnFalse()
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

    DefaultDSLContext myDsl = mock(DefaultDSLContext.class);
    when(myDsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(myDsl, 1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(myDsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext, long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(Field)} return
   *       {@code true}.
   *   <li>Then calls {@link SelectConditionStep#fetchOne(Field)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#checkIfReadOnly(DSLContext,
   * long)}
   */
  @Test
  @DisplayName(
      "Test checkIfReadOnly(DSLContext, long); given SelectConditionStep fetchOne(Field) return 'true'; then calls fetchOne(Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(DSLContext, long)"
  })
  void testCheckIfReadOnly_givenSelectConditionStepFetchOneReturnTrue_thenCallsFetchOne()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(true);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext myDsl = mock(DefaultDSLContext.class);
    when(myDsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> MeasurableRatingPlannedDecommissionDao.checkIfReadOnly(myDsl, 1L));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(myDsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById4() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById5() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById6() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById7() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById8() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById9() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById10() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

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

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> measurableRatingPlannedDecommissionDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById11() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> measurableRatingPlannedDecommissionDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableMeasurableRatingPlannedDecommission}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); then return ImmutableMeasurableRatingPlannedDecommission")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getById(Long)"
  })
  void testGetById_thenReturnImmutableMeasurableRatingPlannedDecommission()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    MeasurableRatingPlannedDecommission actualById =
        new MeasurableRatingPlannedDecommissionDao(dsl).getById(1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualById instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualById.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualById.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualById.createdBy());
    assertEquals(1L, actualById.id().longValue());
    assertEquals(1L, actualById.measurableRatingId().longValue());
    assertTrue(actualById.isValid());
    assertSame(ofResult, actualById.createdAt().toLocalDate());
    assertSame(ofResult2, actualById.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable4() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable5() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable6() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable7() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable8() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable9() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByEntityAndMeasurable(null, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByEntityAndMeasurable(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityAndMeasurable(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(EntityReference, long)"
  })
  void testGetByEntityAndMeasurable10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act
    MeasurableRatingPlannedDecommission actualByEntityAndMeasurable =
        measurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualByEntityAndMeasurable instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualByEntityAndMeasurable.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualByEntityAndMeasurable.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualByEntityAndMeasurable.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualByEntityAndMeasurable.createdBy());
    assertEquals(1L, actualByEntityAndMeasurable.id().longValue());
    assertEquals(1L, actualByEntityAndMeasurable.measurableRatingId().longValue());
    assertTrue(actualByEntityAndMeasurable.isValid());
    assertSame(ofResult, actualByEntityAndMeasurable.createdAt().toLocalDate());
    assertSame(ofResult2, actualByEntityAndMeasurable.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef4() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef5() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef6() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef7() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef8() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef9() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef10() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.findByEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef11() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.findByEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingPlannedDecommissionDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act
    Set<MeasurableRatingPlannedDecommission> actualFindByEntityRefResult =
        measurableRatingPlannedDecommissionDao.findByEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityRefResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef5() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef6() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef7() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef8() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef9() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

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

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef10() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

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

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef11() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

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

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).findByReplacingEntityRef(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef12() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

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

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.findByReplacingEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef13() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

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

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.findByReplacingEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef14() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

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

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.findByReplacingEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#findByReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReplacingEntityRef(EntityReference); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionDao.findByReplacingEntityRef(EntityReference)"
  })
  void testFindByReplacingEntityRef_thenReturnSet() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    HashSet<Object> objectSet = new HashSet<>();
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectSet);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

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

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act
    Collection<MeasurableRatingPlannedDecommissionInfo> actualFindByReplacingEntityRefResult =
        measurableRatingPlannedDecommissionDao.findByReplacingEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByReplacingEntityRefResult instanceof Set);
    assertTrue(actualFindByReplacingEntityRefResult.isEmpty());
    assertSame(objectSet, actualFindByReplacingEntityRefResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave2() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave3() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave7() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave8() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave9() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave11() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave12() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(Field)} return
   *       {@code true}.
   *   <li>Then calls {@link SelectConditionStep#fetchOne(Field)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(long, DateFieldChange, String); given SelectConditionStep fetchOne(Field) return 'true'; then calls fetchOne(Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave_givenSelectConditionStepFetchOneReturnTrue_thenCallsFetchOne()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(true);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#save(long, DateFieldChange,
   * String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String); then calls fetchOne()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple2 MeasurableRatingPlannedDecommissionDao.save(long, DateFieldChange, String)"
  })
  void testSave_thenCallsFetchOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.fetchOne()).thenReturn(null);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.newRecord(Mockito.<Table<MeasurableRatingPlannedDecommissionRecord>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).save(1L, null, "janedoe"));
    verify(selectConditionStep2).fetchOne();
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName("Test remove(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName("Test remove(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove2() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName("Test remove(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove3() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName("Test remove(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove4() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName("Test remove(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove5() throws DataAccessException {
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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<MeasurableRatingPlannedDecommissionRecord>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName("Test remove(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove6() throws DataAccessException {
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

    DeleteUsingStep<MeasurableRatingPlannedDecommissionRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<MeasurableRatingPlannedDecommissionRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName("Test remove(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove7() throws DataAccessException {
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

    DeleteConditionStep<MeasurableRatingPlannedDecommissionRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute())
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DeleteUsingStep<MeasurableRatingPlannedDecommissionRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<MeasurableRatingPlannedDecommissionRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
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

    DeleteConditionStep<MeasurableRatingPlannedDecommissionRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<MeasurableRatingPlannedDecommissionRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<MeasurableRatingPlannedDecommissionRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualRemoveResult = new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(dsl).select(isA(SelectField.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
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

    DeleteConditionStep<MeasurableRatingPlannedDecommissionRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteUsingStep<MeasurableRatingPlannedDecommissionRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<MeasurableRatingPlannedDecommissionRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualRemoveResult = new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(dsl).select(isA(SelectField.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(Field)} return
   *       {@code true}.
   *   <li>Then calls {@link SelectConditionStep#fetchOne(Field)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given SelectConditionStep fetchOne(Field) return 'true'; then calls fetchOne(Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove_givenSelectConditionStepFetchOneReturnTrue_thenCallsFetchOne()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(true);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).remove(1L));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#select(SelectField)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionDao#remove(Long)}
   */
  @Test
  @DisplayName("Test remove(Long); then calls select(SelectField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingPlannedDecommissionDao.remove(Long)"})
  void testRemove_thenCallsSelect() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> measurableRatingPlannedDecommissionDao.remove(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedDecommOperations(Set, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
                new HashSet<>(), 1L, "janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedDecommOperations(Set, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations2() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
                new HashSet<>(), 1L, "janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedDecommOperations(Set, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations3() {
    // Arrange
    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
                new HashSet<>(), 1L, "janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedDecommOperations(Set, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations4() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
                new HashSet<>(), 1L, "janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedDecommOperations(Set, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations5() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
                new HashSet<>(), 1L, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedDecommOperations(Set, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

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

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () ->
            measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
                new HashSet<>(), 1L, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(RecordMapper)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedDecommOperations(Set, long, String); given SelectConditionStep fetchOne(RecordMapper) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations_givenSelectConditionStepFetchOneReturnTrue()
      throws DataAccessException {
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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedDecommOperationsResult =
        measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
            new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
    assertEquals(3, actualCalculateAmendedDecommOperationsResult.size());
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedDecommOperations(Set, long, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations_thenCallsPrepareStatement() throws SQLException {
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
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedDecommOperationsResult =
        measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
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
    assertEquals(3, actualCalculateAmendedDecommOperationsResult.size());
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedDecommOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long,
   * String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#calculateAmendedDecommOperations(Set, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedDecommOperations(Set, long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(Set, long, String)"
  })
  void testCalculateAmendedDecommOperations_thenReturnEmpty() throws DataAccessException {
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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        new MeasurableRatingPlannedDecommissionDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedDecommOperationsResult =
        measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
            new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
    assertTrue(actualCalculateAmendedDecommOperationsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId4() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId5() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId6() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId7() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId8() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId9() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    MeasurableRatingPlannedDecommission actualByMeasurableRatingId =
        new MeasurableRatingPlannedDecommissionDao(dsl).getByMeasurableRatingId(1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualByMeasurableRatingId instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualByMeasurableRatingId.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualByMeasurableRatingId.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualByMeasurableRatingId.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualByMeasurableRatingId.createdBy());
    assertEquals(1L, actualByMeasurableRatingId.id().longValue());
    assertEquals(1L, actualByMeasurableRatingId.measurableRatingId().longValue());
    assertTrue(actualByMeasurableRatingId.isValid());
    assertSame(ofResult, actualByMeasurableRatingId.createdAt().toLocalDate());
    assertSame(ofResult2, actualByMeasurableRatingId.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId11() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

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

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> measurableRatingPlannedDecommissionDao.getByMeasurableRatingId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionDao#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId12() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        ModifyingReadOnlyRecordException.class,
        () -> measurableRatingPlannedDecommissionDao.getByMeasurableRatingId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }
}
