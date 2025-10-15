package org.finos.waltz.data.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.schema.tables.records.FlowClassificationRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
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
class FlowClassificationDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private FlowClassificationDao flowClassificationDao;

  /**
   * Test {@link FlowClassificationDao#findAll()}.
   *
   * <p>Method under test: {@link FlowClassificationDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<FlowClassification> actualFindAllResult = flowClassificationDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationDao#findByIds(Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationDao#findByIds(Set)}
   */
  @Test
  @DisplayName("Test findByIds(Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationDao.findByIds(Set)"})
  void testFindByIds_givenOne_whenHashSetAddOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<Long> classificationRuleIds = new HashSet<>();
    classificationRuleIds.add(1L);

    // Act
    Set<FlowClassification> actualFindByIdsResult =
        flowClassificationDao.findByIds(classificationRuleIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationDao#findByIds(Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationDao#findByIds(Set)}
   */
  @Test
  @DisplayName("Test findByIds(Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationDao.findByIds(Set)"})
  void testFindByIds_givenZero_whenHashSetAddZero() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<Long> classificationRuleIds = new HashSet<>();
    classificationRuleIds.add(0L);
    classificationRuleIds.add(1L);

    // Act
    Set<FlowClassification> actualFindByIdsResult =
        flowClassificationDao.findByIds(classificationRuleIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationDao#findByIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationDao#findByIds(Set)}
   */
  @Test
  @DisplayName("Test findByIds(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationDao.findByIds(Set)"})
  void testFindByIds_whenHashSet() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<FlowClassification> actualFindByIdsResult =
        flowClassificationDao.findByIds(new HashSet<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationDao#remove(long)}.
   *
   * <p>Method under test: {@link FlowClassificationDao#remove(long)}
   */
  @Test
  @DisplayName("Test remove(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationDao.remove(long)"})
  void testRemove() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowClassificationRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<FlowClassificationRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.delete(Mockito.<Table<FlowClassificationRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveResult = flowClassificationDao.remove(1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveResult);
  }
}
