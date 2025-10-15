package org.finos.waltz.service.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.flow_diagram.FlowDiagramOverlayGroupDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroup;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroupEntry;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroup;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroupEntry;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroupEntry.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlowDiagramOverlayGroupServiceDiffblueTest {
  @Mock private FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao;

  @InjectMocks private FlowDiagramOverlayGroupService flowDiagramOverlayGroupService;

  /**
   * Test {@link FlowDiagramOverlayGroupService#findByDiagramId(long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#findByDiagramId(long)}
   */
  @Test
  @DisplayName("Test findByDiagramId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowDiagramOverlayGroupService.findByDiagramId(long)"})
  void testFindByDiagramId() {
    // Arrange
    when(flowDiagramOverlayGroupDao.findByDiagramId(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<FlowDiagramOverlayGroup> actualFindByDiagramIdResult =
        flowDiagramOverlayGroupService.findByDiagramId(1L);

    // Assert
    verify(flowDiagramOverlayGroupDao).findByDiagramId(1L);
    assertTrue(actualFindByDiagramIdResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#findOverlaysByDiagramId(long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#findOverlaysByDiagramId(long)}
   */
  @Test
  @DisplayName("Test findOverlaysByDiagramId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowDiagramOverlayGroupService.findOverlaysByDiagramId(long)"})
  void testFindOverlaysByDiagramId() {
    // Arrange
    when(flowDiagramOverlayGroupDao.findOverlaysByDiagramId(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<FlowDiagramOverlayGroupEntry> actualFindOverlaysByDiagramIdResult =
        flowDiagramOverlayGroupService.findOverlaysByDiagramId(1L);

    // Assert
    verify(flowDiagramOverlayGroupDao).findOverlaysByDiagramId(1L);
    assertTrue(actualFindOverlaysByDiagramIdResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#create(FlowDiagramOverlayGroup, String)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#create(FlowDiagramOverlayGroup,
   * String)}
   */
  @Test
  @DisplayName("Test create(FlowDiagramOverlayGroup, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramOverlayGroupService.create(FlowDiagramOverlayGroup, String)"})
  void testCreate() {
    // Arrange
    when(flowDiagramOverlayGroupDao.create(Mockito.<FlowDiagramOverlayGroup>any())).thenReturn(1L);

    // Act
    Long actualCreateResult = flowDiagramOverlayGroupService.create(null, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).create(isNull());
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#delete(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramOverlayGroupDao} {@link FlowDiagramOverlayGroupDao#delete(Long)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#delete(Long, String)}
   */
  @Test
  @DisplayName(
      "Test delete(Long, String); given FlowDiagramOverlayGroupDao delete(Long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupService.delete(Long, String)"})
  void testDelete_givenFlowDiagramOverlayGroupDaoDeleteReturnFalse_thenReturnFalse() {
    // Arrange
    when(flowDiagramOverlayGroupDao.delete(Mockito.<Long>any())).thenReturn(false);

    // Act
    boolean actualDeleteResult = flowDiagramOverlayGroupService.delete(1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).delete(1L);
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#delete(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramOverlayGroupDao} {@link FlowDiagramOverlayGroupDao#delete(Long)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#delete(Long, String)}
   */
  @Test
  @DisplayName(
      "Test delete(Long, String); given FlowDiagramOverlayGroupDao delete(Long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupService.delete(Long, String)"})
  void testDelete_givenFlowDiagramOverlayGroupDaoDeleteReturnTrue_thenReturnTrue() {
    // Arrange
    when(flowDiagramOverlayGroupDao.delete(Mockito.<Long>any())).thenReturn(true);

    // Act
    boolean actualDeleteResult = flowDiagramOverlayGroupService.delete(1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).delete(1L);
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set, String)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set,
   * String)}
   */
  @Test
  @DisplayName("Test updateOverlaysForDiagram(Long, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowDiagramOverlayGroupService.updateOverlaysForDiagram(Long, Set, String)"
  })
  void testUpdateOverlaysForDiagram() {
    // Arrange
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);

    HashSet<FlowDiagramOverlayGroupEntry> overlays = new HashSet<>();

    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    overlays.add(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());

    // Act
    int actualUpdateOverlaysForDiagramResult =
        flowDiagramOverlayGroupService.updateOverlaysForDiagram(1L, overlays, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(1L);
    assertEquals(1, actualUpdateOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set, String)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set,
   * String)}
   */
  @Test
  @DisplayName("Test updateOverlaysForDiagram(Long, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowDiagramOverlayGroupService.updateOverlaysForDiagram(Long, Set, String)"
  })
  void testUpdateOverlaysForDiagram2() {
    // Arrange
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);

    HashSet<FlowDiagramOverlayGroupEntry> overlays = new HashSet<>();

    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    overlays.add(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();
    overlays.add(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());

    // Act
    int actualUpdateOverlaysForDiagramResult =
        flowDiagramOverlayGroupService.updateOverlaysForDiagram(1L, overlays, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(1L);
    assertEquals(1, actualUpdateOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set,
   * String)}
   */
  @Test
  @DisplayName("Test updateOverlaysForDiagram(Long, Set, String); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowDiagramOverlayGroupService.updateOverlaysForDiagram(Long, Set, String)"
  })
  void testUpdateOverlaysForDiagram_whenHashSet() {
    // Arrange
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);

    // Act
    int actualUpdateOverlaysForDiagramResult =
        flowDiagramOverlayGroupService.updateOverlaysForDiagram(1L, new HashSet<>(), "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(1L);
    assertEquals(1, actualUpdateOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#clone(long, long, String)} with {@code long}, {@code
   * long}, {@code String}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#clone(long, long, String)}
   */
  @Test
  @DisplayName("Test clone(long, long, String) with 'long', 'long', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramOverlayGroupService.clone(long, long, String)"})
  void testCloneWithLongLongString() {
    // Arrange
    HashSet<FlowDiagramOverlayGroupEntry> flowDiagramOverlayGroupEntrySet = new HashSet<>();

    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    flowDiagramOverlayGroupEntrySet.add(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.create(Mockito.<FlowDiagramOverlayGroup>any())).thenReturn(1L);
    when(flowDiagramOverlayGroupDao.findOverlaysByGroupId(anyLong()))
        .thenReturn(flowDiagramOverlayGroupEntrySet);
    when(flowDiagramOverlayGroupDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableFlowDiagramOverlayGroup.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build());

    // Act
    Long actualCloneResult = flowDiagramOverlayGroupService.clone(1L, 1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).create(isA(FlowDiagramOverlayGroup.class));
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).findOverlaysByGroupId(1L);
    verify(flowDiagramOverlayGroupDao).getById(1L);
    assertEquals(1L, actualCloneResult.longValue());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#clone(long, long, String)} with {@code long}, {@code
   * long}, {@code String}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#clone(long, long, String)}
   */
  @Test
  @DisplayName("Test clone(long, long, String) with 'long', 'long', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramOverlayGroupService.clone(long, long, String)"})
  void testCloneWithLongLongString2() {
    // Arrange
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.create(Mockito.<FlowDiagramOverlayGroup>any())).thenReturn(1L);
    when(flowDiagramOverlayGroupDao.findOverlaysByGroupId(anyLong())).thenReturn(new HashSet<>());
    when(flowDiagramOverlayGroupDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableFlowDiagramOverlayGroup.builder()
                .description("The characteristics of someone or something")
                .diagramId(2L)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build());

    // Act
    Long actualCloneResult = flowDiagramOverlayGroupService.clone(1L, 1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).create(isA(FlowDiagramOverlayGroup.class));
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).findOverlaysByGroupId(1L);
    verify(flowDiagramOverlayGroupDao).getById(1L);
    assertEquals(1L, actualCloneResult.longValue());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#clone(long, long, String)} with {@code long}, {@code
   * long}, {@code String}.
   *
   * <ul>
   *   <li>Then return longValue is {@code 5381}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#clone(long, long, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, long, String) with 'long', 'long', 'String'; then return longValue is '5381'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramOverlayGroupService.clone(long, long, String)"})
  void testCloneWithLongLongString_thenReturnLongValueIs5381() {
    // Arrange
    HashSet<FlowDiagramOverlayGroupEntry> flowDiagramOverlayGroupEntrySet = new HashSet<>();

    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    flowDiagramOverlayGroupEntrySet.add(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.create(Mockito.<FlowDiagramOverlayGroup>any()))
        .thenReturn(5381L);
    when(flowDiagramOverlayGroupDao.findOverlaysByGroupId(anyLong()))
        .thenReturn(flowDiagramOverlayGroupEntrySet);
    when(flowDiagramOverlayGroupDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableFlowDiagramOverlayGroup.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build());

    // Act
    Long actualCloneResult = flowDiagramOverlayGroupService.clone(1L, 1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).create(isA(FlowDiagramOverlayGroup.class));
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).findOverlaysByGroupId(1L);
    verify(flowDiagramOverlayGroupDao).getById(1L);
    assertEquals(5381L, actualCloneResult.longValue());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupService#clone(long, long, String)} with {@code long}, {@code
   * long}, {@code String}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupService#clone(long, long, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, long, String) with 'long', 'long', 'String'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramOverlayGroupService.clone(long, long, String)"})
  void testCloneWithLongLongString_thenReturnLongValueIsOne() {
    // Arrange
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.create(Mockito.<FlowDiagramOverlayGroup>any())).thenReturn(1L);
    when(flowDiagramOverlayGroupDao.findOverlaysByGroupId(anyLong())).thenReturn(new HashSet<>());
    when(flowDiagramOverlayGroupDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableFlowDiagramOverlayGroup.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build());

    // Act
    Long actualCloneResult = flowDiagramOverlayGroupService.clone(1L, 1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).create(isA(FlowDiagramOverlayGroup.class));
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).findOverlaysByGroupId(1L);
    verify(flowDiagramOverlayGroupDao).getById(1L);
    assertEquals(1L, actualCloneResult.longValue());
  }
}
