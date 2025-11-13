package org.finos.waltz.data.datatype_decorator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.DataTypeUsageCharacteristics;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.finos.waltz.schema.tables.records.PhysicalSpecDataTypeRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.InsertOnDuplicateStep;
import org.jooq.InsertSetStep;
import org.jooq.InsertValuesStep7;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.Record7;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
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
class PhysicalSpecDecoratorDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalSpecDecoratorDao physicalSpecDecoratorDao;

  /**
   * Test {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator PhysicalSpecDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).getByEntityIdAndDataTypeId(1L, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator PhysicalSpecDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).getByEntityIdAndDataTypeId(1L, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator PhysicalSpecDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).getByEntityIdAndDataTypeId(1L, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator PhysicalSpecDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId4() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenThrow(new UnsupportedOperationException());

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
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).getByEntityIdAndDataTypeId(1L, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator PhysicalSpecDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId5() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

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
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).getByEntityIdAndDataTypeId(1L, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator PhysicalSpecDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId6() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

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
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).getByEntityIdAndDataTypeId(1L, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator PhysicalSpecDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId7() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

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
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).getByEntityIdAndDataTypeId(1L, 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator PhysicalSpecDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId8() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.getByEntityIdAndDataTypeId(1L, 1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByEntityId(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName("Test findByEntityId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findByEntityId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByEntityId(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName("Test findByEntityId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId2() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

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
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findByEntityId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByEntityId(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName("Test findByEntityId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId3() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalSpecDecoratorDao.findByEntityId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByEntityId(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName(
      "Test findByEntityId(long); given DSLContext select(SelectFieldOrAsterisk[]) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId_givenDSLContextSelectThrowUnsupportedOperationException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalSpecDecoratorDao.findByEntityId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByEntityId(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName(
      "Test findByEntityId(long); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

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

    // Act
    List<DataTypeDecorator> actualFindByEntityIdResult =
        new PhysicalSpecDecoratorDao(dsl).findByEntityId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityIdResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByEntityId(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectOnStep} {@link SelectOnStep#on(Condition)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName(
      "Test findByEntityId(long); given SelectOnStep on(Condition) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId_givenSelectOnStepOnThrowUnsupportedOperationException() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenThrow(new UnsupportedOperationException());

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
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findByEntityId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByEntityId(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName(
      "Test findByEntityId(long); given SelectSelectStep from(TableLike) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId_givenSelectSelectStepFromThrowUnsupportedOperationException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findByEntityId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByEntityId(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#select(SelectFieldOrAsterisk[])}
   *       throw {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName(
      "Test findByEntityId(long); given SelectSelectStep select(SelectFieldOrAsterisk[]) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId_givenSelectSelectStepSelectThrowUnsupportedOperationException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findByEntityId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByAppIdSelector(Select)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByAppIdSelector(Select)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByAppIdSelector(Select)"})
  void testFindByAppIdSelector() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99))
                .findByAppIdSelector(mock(Select.class)));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByFlowIdSelector(Select)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByFlowIdSelector(Select)}
   */
  @Test
  @DisplayName("Test findByFlowIdSelector(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PhysicalSpecDecoratorDao.findByFlowIdSelector(Select)"})
  void testFindByFlowIdSelector() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99))
                .findByFlowIdSelector(mock(Select.class)));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByDataTypeIdSelector(Select)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByDataTypeIdSelector(Select)}
   */
  @Test
  @DisplayName("Test findByDataTypeIdSelector(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDecoratorDao.findByDataTypeIdSelector(Select)"})
  void testFindByDataTypeIdSelector() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99))
                .findByDataTypeIdSelector(mock(Select.class)));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findByFlowIds(Collection); given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PhysicalSpecDecoratorDao.findByFlowIds(Collection)"})
  void testFindByFlowIds_givenOne_whenArrayListAddOne() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao =
        new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99));

    ArrayList<Long> flowIds = new ArrayList<>();
    flowIds.add(1L);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalSpecDecoratorDao.findByFlowIds(flowIds));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findByFlowIds(Collection); given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PhysicalSpecDecoratorDao.findByFlowIds(Collection)"})
  void testFindByFlowIds_givenZero_whenArrayListAddZero() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao =
        new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99));

    ArrayList<Long> flowIds = new ArrayList<>();
    flowIds.add(0L);
    flowIds.add(1L);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalSpecDecoratorDao.findByFlowIds(flowIds));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findByFlowIds(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PhysicalSpecDecoratorDao.findByFlowIds(Collection)"})
  void testFindByFlowIds_whenArrayList() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao =
        new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.findByFlowIds(new ArrayList<>()));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#addDecorators(Collection)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#addDecorators(Collection)}
   */
  @Test
  @DisplayName("Test addDecorators(Collection); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PhysicalSpecDecoratorDao.addDecorators(Collection)"})
  void testAddDecorators_thenReturnEmptyArrayOfInt() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao =
        new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(new int[] {}, physicalSpecDecoratorDao.addDecorators(new ArrayList<>()));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName("Test removeDataTypes(EntityReference, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenThrow(new UnsupportedOperationException());
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.removeDataTypes(null, new ArrayList<>()));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName("Test removeDataTypes(EntityReference, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes2() {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>()));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName("Test removeDataTypes(EntityReference, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes3() {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>()));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName("Test removeDataTypes(EntityReference, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new UnsupportedOperationException());

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenReturn(deleteUsingStep);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName("Test removeDataTypes(EntityReference, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes5() {
    // Arrange
    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenReturn(deleteUsingStep);
    ImmutableAppGroupEntry associatedEntityRef =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualRemoveDataTypesResult =
        physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>());

    // Assert
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DeleteUsingStep} {@link DeleteUsingStep#where(Condition)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given DeleteUsingStep where(Condition) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenDeleteUsingStepWhereThrowUnsupportedOperationException() {
    // Arrange
    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>()));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given one; when ArrayList() add one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenOne_whenArrayListAddOne_thenReturnOne() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<Long> dataTypeIds = new ArrayList<>();
    dataTypeIds.add(1L);
    dataTypeIds.add(0L);

    // Act
    int actualRemoveDataTypesResult =
        physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, dataTypeIds);

    // Assert
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given zero; when ArrayList() add zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenZero_whenArrayListAddZero_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<PhysicalSpecDataTypeRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<PhysicalSpecDataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalSpecDataTypeRecord>>any()))
        .thenReturn(deleteUsingStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<Long> dataTypeIds = new ArrayList<>();
    dataTypeIds.add(0L);

    // Act
    int actualRemoveDataTypesResult =
        physicalSpecDecoratorDao.removeDataTypes(associatedEntityRef, dataTypeIds);

    // Assert
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalSpecDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findDatatypeUsageCharacteristics(null));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalSpecDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics2() {
    // Arrange
    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findDatatypeUsageCharacteristics(null));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalSpecDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics3() {
    // Arrange
    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findDatatypeUsageCharacteristics(null));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalSpecDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics4() {
    // Arrange
    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).findDatatypeUsageCharacteristics(null));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalSpecDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics5() {
    // Arrange
    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecDecoratorDao.findDatatypeUsageCharacteristics(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalSpecDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics6() {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecDecoratorDao.findDatatypeUsageCharacteristics(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#select(SelectField, SelectField, SelectField)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDatatypeUsageCharacteristics(EntityReference); then calls select(SelectField, SelectField, SelectField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalSpecDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics_thenCallsSelect() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecDecoratorDao.findDatatypeUsageCharacteristics(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalSpecDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = new PhysicalSpecDecoratorDao(dsl);

    // Act
    List<DataTypeUsageCharacteristics> actualFindDatatypeUsageCharacteristicsResult =
        physicalSpecDecoratorDao.findDatatypeUsageCharacteristics(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    assertTrue(actualFindDatatypeUsageCharacteristicsResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#findByLogicalFlowIdSelector(Select)}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#findByLogicalFlowIdSelector(Select)}
   */
  @Test
  @DisplayName("Test findByLogicalFlowIdSelector(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PhysicalSpecDecoratorDao.findByLogicalFlowIdSelector(Select)"})
  void testFindByLogicalFlowIdSelector() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99))
                .findByLogicalFlowIdSelector(mock(Select.class)));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualRippleDataTypesToLogicalFlowsResult =
        new PhysicalSpecDecoratorDao(dsl).rippleDataTypesToLogicalFlows();

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"logical_flow_decorator\" (\"logical_flow_id\", \"decorator_entity_kind\", \"decorator_entity_id\", \"rating\", \"provenance\", \"last_updated_at\", \"last_updated_by\") select distinct \"physical_flow\".\"logical_flow_id\", ?, \"physical_spec_data_type\".\"data_type_id\", ?, ?, ?, ? from \"physical_spec_data_type\" join \"data_type\" on (\"physical_spec_data_type\".\"data_type_id\" = \"data_type\".\"id\" and \"data_type\".\"unknown\" = false and \"data_type\".\"deprecated\" = false) join \"physical_specification\" on (\"physical_spec_data_type\".\"specification_id\" = \"physical_specification\".\"id\" and \"physical_specification\".\"is_removed\" = false) join \"physical_flow\" on (\"physical_spec_data_type\".\"specification_id\" = \"physical_flow\".\"specification_id\" and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" = ?) join \"logical_flow\" on (\"physical_flow\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" = ?) left outer join \"logical_flow_decorator\" on (\"logical_flow_decorator\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow_decorator\".\"decorator_entity_id\" = \"physical_spec_data_type\".\"data_type_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) where \"logical_flow_decorator\".\"logical_flow_id\" is null");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRippleDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualRippleDataTypesToLogicalFlowsResult =
        new PhysicalSpecDecoratorDao(dsl).rippleDataTypesToLogicalFlows();

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"logical_flow_decorator\" (\"logical_flow_id\", \"decorator_entity_kind\", \"decorator_entity_id\", \"rating\", \"provenance\", \"last_updated_at\", \"last_updated_by\") select distinct \"physical_flow\".\"logical_flow_id\", cast(? as varchar), \"physical_spec_data_type\".\"data_type_id\", cast(? as varchar), cast(? as varchar), cast(? as datetime), cast(? as varchar) from \"physical_spec_data_type\" join \"data_type\" on (\"physical_spec_data_type\".\"data_type_id\" = \"data_type\".\"id\" and \"data_type\".\"unknown\" = false and \"data_type\".\"deprecated\" = false) join \"physical_specification\" on (\"physical_spec_data_type\".\"specification_id\" = \"physical_specification\".\"id\" and \"physical_specification\".\"is_removed\" = false) join \"physical_flow\" on (\"physical_spec_data_type\".\"specification_id\" = \"physical_flow\".\"specification_id\" and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" = cast(? as varchar)) join \"logical_flow\" on (\"physical_flow\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" = cast(? as varchar)) left outer join \"logical_flow_decorator\" on (\"logical_flow_decorator\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow_decorator\".\"decorator_entity_id\" = \"physical_spec_data_type\".\"data_type_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar)) where \"logical_flow_decorator\".\"logical_flow_id\" is null");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRippleDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    int actualRippleDataTypesToLogicalFlowsResult =
        new PhysicalSpecDecoratorDao(dsl).rippleDataTypesToLogicalFlows();

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"logical_flow_decorator\" (\"logical_flow_id\", \"decorator_entity_kind\", \"decorator_entity_id\", \"rating\", \"provenance\", \"last_updated_at\", \"last_updated_by\") select distinct \"physical_flow\".\"logical_flow_id\", cast(? as varchar(9)), \"physical_spec_data_type\".\"data_type_id\", cast(? as varchar(10)), cast(? as varchar(5)), cast(? as timestamp), cast(? as varchar(5)) from \"physical_spec_data_type\" join \"data_type\" on (\"physical_spec_data_type\".\"data_type_id\" = \"data_type\".\"id\" and \"data_type\".\"unknown\" = 0 and \"data_type\".\"deprecated\" = 0) join \"physical_specification\" on (\"physical_spec_data_type\".\"specification_id\" = \"physical_specification\".\"id\" and \"physical_specification\".\"is_removed\" = 0) join \"physical_flow\" on (\"physical_spec_data_type\".\"specification_id\" = \"physical_flow\".\"specification_id\" and \"physical_flow\".\"is_removed\" = 0 and \"physical_flow\".\"entity_lifecycle_status\" = cast(? as varchar(6))) join \"logical_flow\" on (\"physical_flow\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow\".\"is_removed\" = 0 and \"logical_flow\".\"entity_lifecycle_status\" = cast(? as varchar(6))) left outer join \"logical_flow_decorator\" on (\"logical_flow_decorator\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"logical_flow_decorator\".\"decorator_entity_id\" = \"physical_spec_data_type\".\"data_type_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar(9))) where \"logical_flow_decorator\".\"logical_flow_id\" is null");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRippleDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows4() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).rippleDataTypesToLogicalFlows());
    verify(dsl).insertInto(isA(Table.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows5() {
    // Arrange
    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).rippleDataTypesToLogicalFlows());
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetStep)
        .columns(
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows6() {
    // Arrange
    InsertValuesStep7<
            LogicalFlowDecoratorRecord, Object, Object, Object, Object, Object, Object, Object>
        insertValuesStep7 = mock(InsertValuesStep7.class);
    when(insertValuesStep7.select(
            Mockito.<Select<Record7<Object, Object, Object, Object, Object, Object, Object>>>any()))
        .thenThrow(new UnsupportedOperationException());

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep7);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PhysicalSpecDecoratorDao(dsl).rippleDataTypesToLogicalFlows());
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetStep)
        .columns(
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep7).select(isA(Select.class));
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}.
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows7() throws DataAccessException {
    // Arrange
    InsertOnDuplicateStep<LogicalFlowDecoratorRecord> insertOnDuplicateStep =
        mock(InsertOnDuplicateStep.class);
    when(insertOnDuplicateStep.execute()).thenThrow(new UnsupportedOperationException());

    InsertValuesStep7<
            LogicalFlowDecoratorRecord, Object, Object, Object, Object, Object, Object, Object>
        insertValuesStep7 = mock(InsertValuesStep7.class);
    when(insertValuesStep7.select(
            Mockito.<Select<Record7<Object, Object, Object, Object, Object, Object, Object>>>any()))
        .thenReturn(insertOnDuplicateStep);

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep7);
    when(dSLContext.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDecoratorDao.rippleDataTypesToLogicalFlows());
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetStep)
        .columns(
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep7).select(isA(Select.class));
    verify(insertOnDuplicateStep).execute();
  }

  /**
   * Test {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDecoratorDao#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows_thenReturnOne() throws DataAccessException {
    // Arrange
    InsertOnDuplicateStep<LogicalFlowDecoratorRecord> insertOnDuplicateStep =
        mock(InsertOnDuplicateStep.class);
    when(insertOnDuplicateStep.execute()).thenReturn(1);

    InsertValuesStep7<
            LogicalFlowDecoratorRecord, Object, Object, Object, Object, Object, Object, Object>
        insertValuesStep7 = mock(InsertValuesStep7.class);
    when(insertValuesStep7.select(
            Mockito.<Select<Record7<Object, Object, Object, Object, Object, Object, Object>>>any()))
        .thenReturn(insertOnDuplicateStep);

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep7);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualRippleDataTypesToLogicalFlowsResult =
        new PhysicalSpecDecoratorDao(dsl).rippleDataTypesToLogicalFlows();

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetStep)
        .columns(
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep7).select(isA(Select.class));
    verify(insertOnDuplicateStep).execute();
    assertEquals(1, actualRippleDataTypesToLogicalFlowsResult);
  }
}
