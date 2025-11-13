package org.finos.waltz.data.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.measurable_rating.PrimaryRatingViewItem;
import org.jooq.Condition;
import org.jooq.Record9;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingViewDaoDiffblueTest {
  /**
   * Test {@link MeasurableRatingViewDao#findPrimaryRatingsForApp(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingViewDao#findPrimaryRatingsForApp(long)}
   */
  @Test
  @DisplayName("Test findPrimaryRatingsForApp(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingViewDao.findPrimaryRatingsForApp(long)"})
  void testFindPrimaryRatingsForApp() throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito
                .<RecordMapper<
                        Record9<
                            Object, Object, Object, Object, Object, Object, Object, Object, Object>,
                        Object>>
                    any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<
            Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<
            Record9<Object, Object, Object, Object, Object, Object, Object, Object, Object>>
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
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
    Set<PrimaryRatingViewItem> actualFindPrimaryRatingsForAppResult =
        new MeasurableRatingViewDao(dsl).findPrimaryRatingsForApp(1L);

    // Assert
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    assertTrue(actualFindPrimaryRatingsForAppResult.isEmpty());
  }
}
