package org.finos.waltz.service.entity_workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.entity_workflow.EntityWorkflowDefinitionDao;
import org.finos.waltz.data.entity_workflow.EntityWorkflowStateDao;
import org.finos.waltz.data.entity_workflow.EntityWorkflowTransitionDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_workflow.EntityWorkflowDefinition;
import org.finos.waltz.model.entity_workflow.EntityWorkflowState;
import org.finos.waltz.model.entity_workflow.EntityWorkflowTransition;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowState;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowState.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityWorkflowServiceDiffblueTest {
  @Mock private EntityWorkflowDefinitionDao entityWorkflowDefinitionDao;

  @InjectMocks private EntityWorkflowService entityWorkflowService;

  @Mock private EntityWorkflowStateDao entityWorkflowStateDao;

  @Mock private EntityWorkflowTransitionDao entityWorkflowTransitionDao;

  /**
   * Test {@link EntityWorkflowService#findAllDefinitions()}.
   *
   * <p>Method under test: {@link EntityWorkflowService#findAllDefinitions()}
   */
  @Test
  @DisplayName("Test findAllDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityWorkflowService.findAllDefinitions()"})
  void testFindAllDefinitions() {
    // Arrange
    when(entityWorkflowDefinitionDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<EntityWorkflowDefinition> actualFindAllDefinitionsResult =
        entityWorkflowService.findAllDefinitions();

    // Assert
    verify(entityWorkflowDefinitionDao).findAll();
    assertTrue(actualFindAllDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link EntityWorkflowService#getStateForEntityReferenceAndWorkflowId(long,
   * EntityReference)}.
   *
   * <p>Method under test: {@link
   * EntityWorkflowService#getStateForEntityReferenceAndWorkflowId(long, EntityReference)}
   */
  @Test
  @DisplayName("Test getStateForEntityReferenceAndWorkflowId(long, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityWorkflowState EntityWorkflowService.getStateForEntityReferenceAndWorkflowId(long, EntityReference)"
  })
  void testGetStateForEntityReferenceAndWorkflowId() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityWorkflowStateDao.getByEntityReferenceAndWorkflowId(
            anyLong(), Mockito.<EntityReference>any()))
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
    EntityWorkflowState actualStateForEntityReferenceAndWorkflowId =
        entityWorkflowService.getStateForEntityReferenceAndWorkflowId(1L, ref);

    // Assert
    verify(entityWorkflowStateDao)
        .getByEntityReferenceAndWorkflowId(eq(1L), isA(EntityReference.class));
    EntityReference entityReferenceResult =
        actualStateForEntityReferenceAndWorkflowId.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualStateForEntityReferenceAndWorkflowId instanceof ImmutableEntityWorkflowState);
    LocalDateTime lastUpdatedAtResult = actualStateForEntityReferenceAndWorkflowId.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualStateForEntityReferenceAndWorkflowId.lastUpdatedBy());
    assertEquals("MD", actualStateForEntityReferenceAndWorkflowId.state());
    assertEquals("Provenance", actualStateForEntityReferenceAndWorkflowId.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualStateForEntityReferenceAndWorkflowId.description());
    assertEquals(1L, actualStateForEntityReferenceAndWorkflowId.workflowId());
    assertEquals(ref, entityReferenceResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityWorkflowService#findTransitionsForEntityReferenceAndWorkflowId(long,
   * EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityWorkflowService#findTransitionsForEntityReferenceAndWorkflowId(long, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findTransitionsForEntityReferenceAndWorkflowId(long, EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityWorkflowService.findTransitionsForEntityReferenceAndWorkflowId(long, EntityReference)"
  })
  void testFindTransitionsForEntityReferenceAndWorkflowId_thenReturnEmpty() {
    // Arrange
    when(entityWorkflowTransitionDao.findForEntityReferenceAndWorkflowId(
            anyLong(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityWorkflowTransition> actualFindTransitionsForEntityReferenceAndWorkflowIdResult =
        entityWorkflowService.findTransitionsForEntityReferenceAndWorkflowId(
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
    verify(entityWorkflowTransitionDao)
        .findForEntityReferenceAndWorkflowId(eq(1L), isA(EntityReference.class));
    assertTrue(actualFindTransitionsForEntityReferenceAndWorkflowIdResult.isEmpty());
  }
}
