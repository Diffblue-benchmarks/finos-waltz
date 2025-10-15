package org.finos.waltz.data.measurable_category;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Set;
import org.finos.waltz.model.measurable.MeasurableCategoryAlignment;
import org.jooq.CommonTableExpression;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record11;
import org.jooq.RecordMapper;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.WithStep;
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
class MeasurableCategoryAlignmentViewDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private MeasurableCategoryAlignmentViewDao measurableCategoryAlignmentViewDao;

  /**
   * Test {@link MeasurableCategoryAlignmentViewDao#findAlignmentsByAppSelector(Select)}.
   *
   * <p>Method under test: {@link
   * MeasurableCategoryAlignmentViewDao#findAlignmentsByAppSelector(Select)}
   */
  @Test
  @DisplayName("Test findAlignmentsByAppSelector(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(Select)"})
  void testFindAlignmentsByAppSelector() throws MappingException {
    // Arrange
    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.fetchGroups(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new HashMap<>());

    SelectOnConditionStep<
            Record11<
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
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
            Record11<
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
            Record11<
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

    SelectJoinStep<
            Record11<
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
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<
            Record11<
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

    WithStep withStep = mock(WithStep.class);
    when(withStep.select(
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

    WithStep withStep2 = mock(WithStep.class);
    when(withStep2.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep2);

    // Act
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult =
        measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(mock(Select.class));

    // Assert
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(withStep)
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
            isA(SelectField.class));
    verify(withStep2).with((CommonTableExpression[]) Mockito.any());
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
  }
}
