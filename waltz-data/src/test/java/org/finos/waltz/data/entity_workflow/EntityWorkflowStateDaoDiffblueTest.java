package org.finos.waltz.data.entity_workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_workflow.EntityWorkflowState;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowState;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowState.Builder;
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
class EntityWorkflowStateDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityWorkflowStateDao entityWorkflowStateDao;

  /**
   * Test {@link EntityWorkflowStateDao#getByEntityReferenceAndWorkflowId(long, EntityReference)}.
   *
   * <p>Method under test: {@link EntityWorkflowStateDao#getByEntityReferenceAndWorkflowId(long,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test getByEntityReferenceAndWorkflowId(long, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityWorkflowState EntityWorkflowStateDao.getByEntityReferenceAndWorkflowId(long, EntityReference)"
  })
  void testGetByEntityReferenceAndWorkflowId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .state("MD")
                .workflowId(1L)
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EntityWorkflowStateDao entityWorkflowStateDao = new EntityWorkflowStateDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    EntityWorkflowState actualByEntityReferenceAndWorkflowId =
        entityWorkflowStateDao.getByEntityReferenceAndWorkflowId(1L, ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    EntityReference entityReferenceResult = actualByEntityReferenceAndWorkflowId.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualByEntityReferenceAndWorkflowId instanceof ImmutableEntityWorkflowState);
    assertEquals("2020-03-01", actualByEntityReferenceAndWorkflowId.lastUpdatedBy());
    assertEquals("MD", actualByEntityReferenceAndWorkflowId.state());
    assertEquals("Provenance", actualByEntityReferenceAndWorkflowId.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualByEntityReferenceAndWorkflowId.description());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualByEntityReferenceAndWorkflowId.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualByEntityReferenceAndWorkflowId.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link EntityWorkflowStateDao#getByEntityReferenceAndWorkflowId(long, EntityReference)}.
   *
   * <p>Method under test: {@link EntityWorkflowStateDao#getByEntityReferenceAndWorkflowId(long,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test getByEntityReferenceAndWorkflowId(long, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityWorkflowState EntityWorkflowStateDao.getByEntityReferenceAndWorkflowId(long, EntityReference)"
  })
  void testGetByEntityReferenceAndWorkflowId2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .state("MD")
                .workflowId(1L)
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    EntityWorkflowState actualByEntityReferenceAndWorkflowId =
        entityWorkflowStateDao.getByEntityReferenceAndWorkflowId(1L, ref);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    EntityReference entityReferenceResult = actualByEntityReferenceAndWorkflowId.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualByEntityReferenceAndWorkflowId instanceof ImmutableEntityWorkflowState);
    LocalDateTime lastUpdatedAtResult = actualByEntityReferenceAndWorkflowId.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualByEntityReferenceAndWorkflowId.lastUpdatedBy());
    assertEquals("MD", actualByEntityReferenceAndWorkflowId.state());
    assertEquals("Provenance", actualByEntityReferenceAndWorkflowId.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualByEntityReferenceAndWorkflowId.description());
    assertEquals(1L, actualByEntityReferenceAndWorkflowId.workflowId());
    assertEquals(ref, entityReferenceResult);
    assertSame(ofResult, toLocalDateResult);
  }
}
