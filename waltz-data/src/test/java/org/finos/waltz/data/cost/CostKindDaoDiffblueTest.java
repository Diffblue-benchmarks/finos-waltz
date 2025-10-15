package org.finos.waltz.data.cost;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.cost.CostKindWithYears;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.MappingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CostKindDaoDiffblueTest {
  @InjectMocks private CostKindDao costKindDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link CostKindDao#findAll()}.
   *
   * <p>Method under test: {@link CostKindDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostKindDao.findAll()"})
  void testFindAll() throws MappingException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetchGroups(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    // Act
    Set<CostKindWithYears> actualFindAllResult = costKindDao.findAll();

    // Assert
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link CostKindDao#findCostKindsBySubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link CostKindDao#findCostKindsBySubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findCostKindsBySubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostKindDao.findCostKindsBySubjectKind(EntityKind)"})
  void testFindCostKindsBySubjectKind() throws MappingException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetchGroups(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    // Act
    Set<CostKindWithYears> actualFindCostKindsBySubjectKindResult =
        costKindDao.findCostKindsBySubjectKind(EntityKind.ALL);

    // Assert
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindCostKindsBySubjectKindResult.isEmpty());
  }
}
