package org.finos.waltz.data.entity_workflow;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_workflow.EntityWorkflowTransition;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
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
class EntityWorkflowTransitionDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityWorkflowTransitionDao entityWorkflowTransitionDao;

  /**
   * Test {@link EntityWorkflowTransitionDao#findForEntityReferenceAndWorkflowId(long,
   * EntityReference)}.
   *
   * <p>Method under test: {@link
   * EntityWorkflowTransitionDao#findForEntityReferenceAndWorkflowId(long, EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntityReferenceAndWorkflowId(long, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityWorkflowTransitionDao.findForEntityReferenceAndWorkflowId(long, EntityReference)"
  })
  void testFindForEntityReferenceAndWorkflowId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<EntityWorkflowTransition> actualFindForEntityReferenceAndWorkflowIdResult =
        entityWorkflowTransitionDao.findForEntityReferenceAndWorkflowId(
            1L,
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
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityReferenceAndWorkflowIdResult.isEmpty());
  }

  /**
   * Test {@link EntityWorkflowTransitionDao#findForEntityReferenceAndWorkflowId(long,
   * EntityReference)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link EntityReference#id()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityWorkflowTransitionDao#findForEntityReferenceAndWorkflowId(long, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntityReferenceAndWorkflowId(long, EntityReference); given one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityWorkflowTransitionDao.findForEntityReferenceAndWorkflowId(long, EntityReference)"
  })
  void testFindForEntityReferenceAndWorkflowId_givenOne_thenCallsId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<EntityWorkflowTransition> actualFindForEntityReferenceAndWorkflowIdResult =
        entityWorkflowTransitionDao.findForEntityReferenceAndWorkflowId(1L, ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityReferenceAndWorkflowIdResult.isEmpty());
  }
}
