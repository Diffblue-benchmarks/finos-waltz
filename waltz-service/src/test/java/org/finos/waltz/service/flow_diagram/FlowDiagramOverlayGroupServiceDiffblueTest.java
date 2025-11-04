package org.finos.waltz.service.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.flow_diagram.FlowDiagramOverlayGroupDao;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroup;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroupEntry;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowDiagramOverlayGroupServiceDiffblueTest {
  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#findByDiagramId(long)}
   */
  @Test
  void testFindByDiagramId() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    HashSet<FlowDiagramOverlayGroup> flowDiagramOverlayGroupSet = new HashSet<>();
    when(flowDiagramOverlayGroupDao.findByDiagramId(anyLong())).thenReturn(flowDiagramOverlayGroupSet);

    // Act
    Set<FlowDiagramOverlayGroup> actualFindByDiagramIdResult = (new FlowDiagramOverlayGroupService(
        flowDiagramOverlayGroupDao)).findByDiagramId(1L);

    // Assert
    verify(flowDiagramOverlayGroupDao).findByDiagramId(eq(1L));
    assertTrue(actualFindByDiagramIdResult.isEmpty());
    assertSame(flowDiagramOverlayGroupSet, actualFindByDiagramIdResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#findOverlaysByDiagramId(long)}
   */
  @Test
  void testFindOverlaysByDiagramId() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    HashSet<FlowDiagramOverlayGroupEntry> flowDiagramOverlayGroupEntrySet = new HashSet<>();
    when(flowDiagramOverlayGroupDao.findOverlaysByDiagramId(anyLong())).thenReturn(flowDiagramOverlayGroupEntrySet);

    // Act
    Set<FlowDiagramOverlayGroupEntry> actualFindOverlaysByDiagramIdResult = (new FlowDiagramOverlayGroupService(
        flowDiagramOverlayGroupDao)).findOverlaysByDiagramId(1L);

    // Assert
    verify(flowDiagramOverlayGroupDao).findOverlaysByDiagramId(eq(1L));
    assertTrue(actualFindOverlaysByDiagramIdResult.isEmpty());
    assertSame(flowDiagramOverlayGroupEntrySet, actualFindOverlaysByDiagramIdResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#create(FlowDiagramOverlayGroup, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.create(Mockito.<FlowDiagramOverlayGroup>any())).thenReturn(1L);

    // Act
    Long actualCreateResult = (new FlowDiagramOverlayGroupService(flowDiagramOverlayGroupDao)).create(null, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).create(isNull());
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#delete(Long, String)}
   */
  @Test
  void testDelete() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.delete(Mockito.<Long>any())).thenReturn(true);

    // Act
    boolean actualDeleteResult = (new FlowDiagramOverlayGroupService(flowDiagramOverlayGroupDao)).delete(1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).delete(eq(1L));
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#delete(Long, String)}
   */
  @Test
  void testDelete2() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.delete(Mockito.<Long>any())).thenReturn(false);

    // Act
    boolean actualDeleteResult = (new FlowDiagramOverlayGroupService(flowDiagramOverlayGroupDao)).delete(1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).delete(eq(1L));
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set, String)}
   */
  @Test
  void testUpdateOverlaysForDiagram() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(Mockito.<Set<FlowDiagramOverlayGroupEntry>>any())).thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService = new FlowDiagramOverlayGroupService(
        flowDiagramOverlayGroupDao);

    // Act
    int actualUpdateOverlaysForDiagramResult = flowDiagramOverlayGroupService.updateOverlaysForDiagram(1L,
        new HashSet<>(), "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(eq(1L));
    assertEquals(1, actualUpdateOverlaysForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set, String)}
   */
  @Test
  void testUpdateOverlaysForDiagram2() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(Mockito.<Set<FlowDiagramOverlayGroupEntry>>any())).thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService = new FlowDiagramOverlayGroupService(
        flowDiagramOverlayGroupDao);

    HashSet<FlowDiagramOverlayGroupEntry> overlays = new HashSet<>();
    overlays.add(mock(FlowDiagramOverlayGroupEntry.class));

    // Act
    int actualUpdateOverlaysForDiagramResult = flowDiagramOverlayGroupService.updateOverlaysForDiagram(1L, overlays,
        "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(eq(1L));
    assertEquals(1, actualUpdateOverlaysForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set, String)}
   */
  @Test
  void testUpdateOverlaysForDiagram3() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(Mockito.<Set<FlowDiagramOverlayGroupEntry>>any())).thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService = new FlowDiagramOverlayGroupService(
        flowDiagramOverlayGroupDao);

    HashSet<FlowDiagramOverlayGroupEntry> overlays = new HashSet<>();
    overlays.add(mock(FlowDiagramOverlayGroupEntry.class));
    overlays.add(mock(FlowDiagramOverlayGroupEntry.class));

    // Act
    int actualUpdateOverlaysForDiagramResult = flowDiagramOverlayGroupService.updateOverlaysForDiagram(1L, overlays,
        "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(eq(1L));
    assertEquals(1, actualUpdateOverlaysForDiagramResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramOverlayGroupService#clone(long, long, String)}
   */
  @Test
  void testClone() {
    // Arrange
    FlowDiagramOverlayGroup flowDiagramOverlayGroup = mock(FlowDiagramOverlayGroup.class);
    when(flowDiagramOverlayGroup.diagramId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(flowDiagramOverlayGroup.id()).thenReturn(ofResult);
    when(flowDiagramOverlayGroup.isDefault()).thenReturn(true);
    when(flowDiagramOverlayGroup.description()).thenReturn("The characteristics of someone or something");
    when(flowDiagramOverlayGroup.externalId()).thenReturn("42");
    when(flowDiagramOverlayGroup.name()).thenReturn("Name");
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(Mockito.<Set<FlowDiagramOverlayGroupEntry>>any())).thenReturn(1);
    when(flowDiagramOverlayGroupDao.create(Mockito.<FlowDiagramOverlayGroup>any())).thenReturn(1L);
    when(flowDiagramOverlayGroupDao.findOverlaysByGroupId(anyLong())).thenReturn(new HashSet<>());
    when(flowDiagramOverlayGroupDao.getById(Mockito.<Long>any())).thenReturn(flowDiagramOverlayGroup);

    // Act
    Long actualCloneResult = (new FlowDiagramOverlayGroupService(flowDiagramOverlayGroupDao)).clone(1L, 1L, "janedoe");

    // Assert
    verify(flowDiagramOverlayGroupDao).create(isA(FlowDiagramOverlayGroup.class));
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).findOverlaysByGroupId(eq(1L));
    verify(flowDiagramOverlayGroupDao).getById(eq(1L));
    verify(flowDiagramOverlayGroup).description();
    verify(flowDiagramOverlayGroup).id();
    verify(flowDiagramOverlayGroup).name();
    verify(flowDiagramOverlayGroup).diagramId();
    verify(flowDiagramOverlayGroup).externalId();
    verify(flowDiagramOverlayGroup).isDefault();
    assertEquals(1L, actualCloneResult.longValue());
  }
}
