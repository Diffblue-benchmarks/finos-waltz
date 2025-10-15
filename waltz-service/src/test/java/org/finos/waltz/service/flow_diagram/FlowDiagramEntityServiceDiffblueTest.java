package org.finos.waltz.service.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.flow_diagram.FlowDiagramEntityDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.flow_diagram.FlowDiagramEntity;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlowDiagramEntityServiceDiffblueTest {
  @Mock private FlowDiagramEntityDao flowDiagramEntityDao;

  @InjectMocks private FlowDiagramEntityService flowDiagramEntityService;

  /**
   * Test {@link FlowDiagramEntityService#findByDiagramId(long)}.
   *
   * <p>Method under test: {@link FlowDiagramEntityService#findByDiagramId(long)}
   */
  @Test
  @DisplayName("Test findByDiagramId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramEntityService.findByDiagramId(long)"})
  void testFindByDiagramId() {
    // Arrange
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<FlowDiagramEntity> actualFindByDiagramIdResult =
        flowDiagramEntityService.findByDiagramId(1L);

    // Assert
    verify(flowDiagramEntityDao).findForDiagram(1L);
    assertTrue(actualFindByDiagramIdResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramEntityService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramEntityService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    when(flowDiagramEntityDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FlowDiagramEntity> actualFindByEntityReferenceResult =
        flowDiagramEntityService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(flowDiagramEntityDao).findForEntity(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramEntityService#findForEntitySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowDiagramEntityService#findForEntitySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForEntitySelector(IdSelectionOptions); given EXACT; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramEntityService.findForEntitySelector(IdSelectionOptions)"})
  void testFindForEntitySelector_givenExact_thenReturnEmpty() {
    // Arrange
    when(flowDiagramEntityDao.findForEntitySelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<FlowDiagramEntity> actualFindForEntitySelectorResult =
        flowDiagramEntityService.findForEntitySelector(options);

    // Assert
    verify(flowDiagramEntityDao).findForEntitySelector(eq(EntityKind.ALL), isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindForEntitySelectorResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramEntityService#findForDiagramSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowDiagramEntityService#findForDiagramSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForDiagramSelector(IdSelectionOptions); given EXACT; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramEntityService.findForDiagramSelector(IdSelectionOptions)"})
  void testFindForDiagramSelector_givenExact_thenReturnEmpty() {
    // Arrange
    when(flowDiagramEntityDao.findForDiagramSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<FlowDiagramEntity> actualFindForDiagramSelectorResult =
        flowDiagramEntityService.findForDiagramSelector(options);

    // Assert
    verify(flowDiagramEntityDao).findForDiagramSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindForDiagramSelectorResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramEntityService#removeRelationship(long, EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityService#removeRelationship(long,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test removeRelationship(long, EntityReference); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramEntityService.removeRelationship(long, EntityReference)"})
  void testRemoveRelationship_thenReturnFalse() {
    // Arrange
    when(flowDiagramEntityDao.deleteEntityForDiagram(anyLong(), Mockito.<EntityReference>any()))
        .thenReturn(false);

    // Act
    boolean actualRemoveRelationshipResult = flowDiagramEntityService.removeRelationship(1L, null);

    // Assert
    verify(flowDiagramEntityDao).deleteEntityForDiagram(eq(1L), isNull());
    assertFalse(actualRemoveRelationshipResult);
  }

  /**
   * Test {@link FlowDiagramEntityService#removeRelationship(long, EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityService#removeRelationship(long,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test removeRelationship(long, EntityReference); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramEntityService.removeRelationship(long, EntityReference)"})
  void testRemoveRelationship_thenReturnTrue() {
    // Arrange
    when(flowDiagramEntityDao.deleteEntityForDiagram(anyLong(), Mockito.<EntityReference>any()))
        .thenReturn(true);

    // Act
    boolean actualRemoveRelationshipResult = flowDiagramEntityService.removeRelationship(1L, null);

    // Assert
    verify(flowDiagramEntityDao).deleteEntityForDiagram(eq(1L), isNull());
    assertTrue(actualRemoveRelationshipResult);
  }

  /**
   * Test {@link FlowDiagramEntityService#addRelationship(long, EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityService#addRelationship(long, EntityReference)}
   */
  @Test
  @DisplayName("Test addRelationship(long, EntityReference); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramEntityService.addRelationship(long, EntityReference)"})
  void testAddRelationship_thenReturnFalse() {
    // Arrange
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {-2, -1, 1, -1});

    // Act
    boolean actualAddRelationshipResult =
        flowDiagramEntityService.addRelationship(
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
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    assertFalse(actualAddRelationshipResult);
  }

  /**
   * Test {@link FlowDiagramEntityService#addRelationship(long, EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityService#addRelationship(long, EntityReference)}
   */
  @Test
  @DisplayName("Test addRelationship(long, EntityReference); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramEntityService.addRelationship(long, EntityReference)"})
  void testAddRelationship_thenReturnTrue() {
    // Arrange
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    // Act
    boolean actualAddRelationshipResult =
        flowDiagramEntityService.addRelationship(
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
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    assertTrue(actualAddRelationshipResult);
  }

  /**
   * Test {@link FlowDiagramEntityService#deleteForEntitySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowDiagramEntityService#deleteForEntitySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteForEntitySelector(IdSelectionOptions); given EXACT; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramEntityService.deleteForEntitySelector(IdSelectionOptions)"})
  void testDeleteForEntitySelector_givenExact_thenReturnOne() {
    // Arrange
    when(flowDiagramEntityDao.deleteForGenericEntitySelector(Mockito.<GenericSelector>any()))
        .thenReturn(1);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteForEntitySelectorResult =
        flowDiagramEntityService.deleteForEntitySelector(options);

    // Assert
    verify(flowDiagramEntityDao).deleteForGenericEntitySelector(isA(GenericSelector.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertEquals(1, actualDeleteForEntitySelectorResult);
  }
}
