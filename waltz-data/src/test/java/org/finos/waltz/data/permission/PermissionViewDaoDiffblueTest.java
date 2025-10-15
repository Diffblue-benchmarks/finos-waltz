package org.finos.waltz.data.permission;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.permission.PermissionViewItem;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record17;
import org.jooq.RecordMapper;
import org.jooq.SelectField;
import org.jooq.SelectJoinPartitionByStep;
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
class PermissionViewDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PermissionViewDao permissionViewDao;

  /**
   * Test {@link PermissionViewDao#findAll()}.
   *
   * <p>Method under test: {@link PermissionViewDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PermissionViewDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetchSet(
            Mockito
                .<RecordMapper<
                        Record17<
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
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object>,
                        Object>>
                    any()))
        .thenReturn(new HashSet<>());

    SelectJoinPartitionByStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinPartitionByStep2 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectOnConditionStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep5 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep5.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep5);

    SelectOnConditionStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep6 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep6.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectOnStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep6);

    SelectJoinStep<
            Record17<
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
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectSelectStep<
            Record17<
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
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<PermissionViewItem> actualFindAllResult = permissionViewDao.findAll();

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
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectOnConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep6).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep5).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep4).on(isA(Condition.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    assertTrue(actualFindAllResult.isEmpty());
  }
}
