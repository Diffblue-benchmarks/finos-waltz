package org.finos.waltz.service.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.flow_diagram.FlowDiagramEntityDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.flow_diagram.FlowDiagramEntity;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowDiagramEntityServiceDiffblueTest {
  /**
   * Method under test: {@link FlowDiagramEntityService#findByDiagramId(long)}
   */
  @Test
  void testFindByDiagramId() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(flowDiagramEntityList);

    // Act
    List<FlowDiagramEntity> actualFindByDiagramIdResult = (new FlowDiagramEntityService(flowDiagramEntityDao))
        .findByDiagramId(1L);

    // Assert
    verify(flowDiagramEntityDao).findForDiagram(eq(1L));
    assertTrue(actualFindByDiagramIdResult.isEmpty());
    assertSame(flowDiagramEntityList, actualFindByDiagramIdResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();
    when(flowDiagramEntityDao.findForEntity(Mockito.<EntityReference>any())).thenReturn(flowDiagramEntityList);

    // Act
    List<FlowDiagramEntity> actualFindByEntityReferenceResult = (new FlowDiagramEntityService(flowDiagramEntityDao))
        .findByEntityReference(mock(EntityReference.class));

    // Assert
    verify(flowDiagramEntityDao).findForEntity(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(flowDiagramEntityList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityService#findForEntitySelector(IdSelectionOptions)}
   */
  @Test
  void testFindForEntitySelector() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();
    when(flowDiagramEntityDao.findForEntitySelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(flowDiagramEntityList);
    FlowDiagramEntityService flowDiagramEntityService = new FlowDiagramEntityService(flowDiagramEntityDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<FlowDiagramEntity> actualFindForEntitySelectorResult = flowDiagramEntityService.findForEntitySelector(options);

    // Assert
    verify(flowDiagramEntityDao).findForEntitySelector(eq(EntityKind.ALL), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindForEntitySelectorResult.isEmpty());
    assertSame(flowDiagramEntityList, actualFindForEntitySelectorResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityService#findForDiagramSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForDiagramSelector() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();
    when(flowDiagramEntityDao.findForDiagramSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(flowDiagramEntityList);
    FlowDiagramEntityService flowDiagramEntityService = new FlowDiagramEntityService(flowDiagramEntityDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<FlowDiagramEntity> actualFindForDiagramSelectorResult = flowDiagramEntityService
        .findForDiagramSelector(options);

    // Assert
    verify(flowDiagramEntityDao).findForDiagramSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindForDiagramSelectorResult.isEmpty());
    assertSame(flowDiagramEntityList, actualFindForDiagramSelectorResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityService#removeRelationship(long, EntityReference)}
   */
  @Test
  void testRemoveRelationship() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteEntityForDiagram(anyLong(), Mockito.<EntityReference>any())).thenReturn(true);

    // Act
    boolean actualRemoveRelationshipResult = (new FlowDiagramEntityService(flowDiagramEntityDao)).removeRelationship(1L,
        null);

    // Assert
    verify(flowDiagramEntityDao).deleteEntityForDiagram(eq(1L), isNull());
    assertTrue(actualRemoveRelationshipResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityService#removeRelationship(long, EntityReference)}
   */
  @Test
  void testRemoveRelationship2() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteEntityForDiagram(anyLong(), Mockito.<EntityReference>any())).thenReturn(false);

    // Act
    boolean actualRemoveRelationshipResult = (new FlowDiagramEntityService(flowDiagramEntityDao)).removeRelationship(1L,
        null);

    // Assert
    verify(flowDiagramEntityDao).deleteEntityForDiagram(eq(1L), isNull());
    assertFalse(actualRemoveRelationshipResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityService#addRelationship(long, EntityReference)}
   */
  @Test
  void testAddRelationship() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});

    // Act
    boolean actualAddRelationshipResult = (new FlowDiagramEntityService(flowDiagramEntityDao)).addRelationship(1L,
        mock(EntityReference.class));

    // Assert
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    assertTrue(actualAddRelationshipResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityService#addRelationship(long, EntityReference)}
   */
  @Test
  void testAddRelationship2() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[]{-2, -1, 1, -1});

    // Act
    boolean actualAddRelationshipResult = (new FlowDiagramEntityService(flowDiagramEntityDao)).addRelationship(1L,
        mock(EntityReference.class));

    // Assert
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    assertFalse(actualAddRelationshipResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramEntityService#deleteForEntitySelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteForEntitySelector() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForGenericEntitySelector(Mockito.<GenericSelector>any())).thenReturn(1);
    FlowDiagramEntityService flowDiagramEntityService = new FlowDiagramEntityService(flowDiagramEntityDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteForEntitySelectorResult = flowDiagramEntityService.deleteForEntitySelector(options);

    // Assert
    verify(flowDiagramEntityDao).deleteForGenericEntitySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertEquals(1, actualDeleteForEntitySelectorResult);
  }
}
