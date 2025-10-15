package org.finos.waltz.data.legal_entity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.legal_entity.LegalEntityRelKindStat;
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipKind;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LegalEntityRelationshipKindDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private LegalEntityRelationshipKindDao legalEntityRelationshipKindDao;

  /**
   * Test {@link LegalEntityRelationshipKindDao#findAll()}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipKindDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipKindDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<LegalEntityRelationshipKind> actualFindAllResult = legalEntityRelationshipKindDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipKindDao#findUsageStats()}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipKindDao#findUsageStats()}
   */
  @Test
  @DisplayName("Test findUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipKindDao.findUsageStats()"})
  void testFindUsageStats() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);

    // Act
    Set<LegalEntityRelKindStat> actualFindUsageStatsResult =
        legalEntityRelationshipKindDao.findUsageStats();

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectOnConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindUsageStatsResult.isEmpty());
  }
}
