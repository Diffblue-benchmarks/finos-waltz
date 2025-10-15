package org.finos.waltz.data.process_diagram_entity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntity;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntityApplicationAlignment;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record12;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
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
class ProcessDiagramEntityDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ProcessDiagramEntityDao processDiagramEntityDao;

  /**
   * Test {@link ProcessDiagramEntityDao#findDiagramEntitiesById(long)}.
   *
   * <p>Method under test: {@link ProcessDiagramEntityDao#findDiagramEntitiesById(long)}
   */
  @Test
  @DisplayName("Test findDiagramEntitiesById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramEntityDao.findDiagramEntitiesById(long)"})
  void testFindDiagramEntitiesById() throws DataAccessException {
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
    Set<ProcessDiagramEntity> actualFindDiagramEntitiesByIdResult =
        processDiagramEntityDao.findDiagramEntitiesById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindDiagramEntitiesByIdResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramEntityDao#findApplicationAlignmentsByDiagramId(Long)}.
   *
   * <p>Method under test: {@link
   * ProcessDiagramEntityDao#findApplicationAlignmentsByDiagramId(Long)}
   */
  @Test
  @DisplayName("Test findApplicationAlignmentsByDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramEntityDao.findApplicationAlignmentsByDiagramId(Long)"})
  void testFindApplicationAlignmentsByDiagramId() throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito
                .<RecordMapper<
                        Record12<
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object>,
                        Object>>
                    any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectOnStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectOnStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectOnConditionStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep5 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep5.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectOnStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep5 = mock(SelectOnStep.class);
    when(selectOnStep5.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep5);

    SelectJoinStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep5);

    SelectSelectStep<
            Record12<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<ProcessDiagramEntityApplicationAlignment> actualFindApplicationAlignmentsByDiagramIdResult =
        processDiagramEntityDao.findApplicationAlignmentsByDiagramId(1L);

    // Assert
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep5).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep5).on(isA(Condition.class));
    verify(selectOnStep4).on(isA(Condition.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindApplicationAlignmentsByDiagramIdResult.isEmpty());
  }
}
