package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.entity_relationship.Directionality;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.RelationshipKind;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityRelationshipServiceDiffblueTest {
  /**
   * Method under test: {@link EntityRelationshipService#getById(Long)}
   */
  @Test
  void testGetById() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.getById(Mockito.<Long>any())).thenReturn(null);

    // Act
    EntityRelationship actualById = (new EntityRelationshipService(entityRelationshipDao)).getById(1L);

    // Assert
    verify(entityRelationshipDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.ANY, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity2() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    entityRelationshipList.add(mock(EntityRelationship.class));
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.ANY, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertEquals(1, actualFindForEntityResult.size());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity3() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    entityRelationshipList.add(mock(EntityRelationship.class));
    entityRelationshipList.add(mock(EntityRelationship.class));
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.ANY, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertEquals(entityRelationshipList, actualFindForEntityResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity4() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity5() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.TARGET, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity6() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    ArrayList<RelationshipKind> relationshipKinds = new ArrayList<>();
    relationshipKinds.add(RelationshipKind.HAS);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.ANY, relationshipKinds);

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity7() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    ArrayList<RelationshipKind> relationshipKinds = new ArrayList<>();
    relationshipKinds.add(RelationshipKind.DEPRECATES);
    relationshipKinds.add(RelationshipKind.HAS);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.ANY, relationshipKinds);

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity8() {
    // Arrange
    EntityRelationship entityRelationship = mock(EntityRelationship.class);
    when(entityRelationship.a()).thenReturn(mock(EntityReference.class));

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    entityRelationshipList.add(entityRelationship);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    verify(entityRelationship).a();
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}
   */
  @Test
  void testFindForEntity9() {
    // Arrange
    EntityRelationship entityRelationship = mock(EntityRelationship.class);
    when(entityRelationship.b()).thenReturn(mock(EntityReference.class));

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    entityRelationshipList.add(entityRelationship);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult = entityRelationshipService.findForEntity(null,
        Directionality.TARGET, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    verify(entityRelationship).b();
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#removeRelationship(EntityRelationshipKey)}
   */
  @Test
  void testRemoveRelationship() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    // Act
    Boolean actualRemoveRelationshipResult = (new EntityRelationshipService(entityRelationshipDao))
        .removeRelationship(null);

    // Assert
    verify(entityRelationshipDao).remove(isNull());
    assertTrue(actualRemoveRelationshipResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#removeRelationship(EntityRelationshipKey)}
   */
  @Test
  void testRemoveRelationship2() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(false);

    // Act
    Boolean actualRemoveRelationshipResult = (new EntityRelationshipService(entityRelationshipDao))
        .removeRelationship(null);

    // Assert
    verify(entityRelationshipDao).remove(isNull());
    assertFalse(actualRemoveRelationshipResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#createRelationship(EntityRelationship)}
   */
  @Test
  void testCreateRelationship() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);

    // Act
    Boolean actualCreateRelationshipResult = (new EntityRelationshipService(entityRelationshipDao))
        .createRelationship(null);

    // Assert
    verify(entityRelationshipDao).create(isNull());
    assertTrue(actualCreateRelationshipResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#createRelationship(EntityRelationship)}
   */
  @Test
  void testCreateRelationship2() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(false);

    // Act
    Boolean actualCreateRelationshipResult = (new EntityRelationshipService(entityRelationshipDao))
        .createRelationship(null);

    // Assert
    verify(entityRelationshipDao).create(isNull());
    assertFalse(actualCreateRelationshipResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  void testFindForGenericEntitySelector() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(entityRelationshipDao.findForGenericEntitySelector(Mockito.<GenericSelector>any()))
        .thenReturn(entityRelationshipList);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<EntityRelationship> actualFindForGenericEntitySelectorResult = entityRelationshipService
        .findForGenericEntitySelector(selectionOptions);

    // Assert
    verify(entityRelationshipDao).findForGenericEntitySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindForGenericEntitySelectorResult instanceof List);
    assertTrue(actualFindForGenericEntitySelectorResult.isEmpty());
    assertSame(entityRelationshipList, actualFindForGenericEntitySelectorResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#findForGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  void testFindForGenericEntitySelector2() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(entityRelationshipDao.findForGenericEntitySelector(Mockito.<GenericSelector>any()))
        .thenReturn(entityRelationshipList);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<EntityRelationship> actualFindForGenericEntitySelectorResult = entityRelationshipService
        .findForGenericEntitySelector(selectionOptions);

    // Assert
    verify(entityRelationshipDao).findForGenericEntitySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions, atLeast(1)).scope();
    assertTrue(actualFindForGenericEntitySelectorResult instanceof List);
    assertTrue(actualFindForGenericEntitySelectorResult.isEmpty());
    assertSame(entityRelationshipList, actualFindForGenericEntitySelectorResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#deleteForGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteForGenericEntitySelector() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.deleteForGenericEntitySelector(Mockito.<GenericSelector>any())).thenReturn(1);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(entityRelationshipDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteForGenericEntitySelectorResult = entityRelationshipService
        .deleteForGenericEntitySelector(selectionOptions);

    // Assert
    verify(entityRelationshipDao).deleteForGenericEntitySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteForGenericEntitySelectorResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#migrateEntityRelationships(EntityReference, EntityReference, String)}
   */
  @Test
  void testMigrateEntityRelationships() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    doNothing().when(entityRelationshipDao)
        .migrateEntityRelationships(Mockito.<EntityReference>any(), Mockito.<EntityReference>any(),
            Mockito.<String>any());

    // Act
    (new EntityRelationshipService(entityRelationshipDao)).migrateEntityRelationships(null, null, "42");

    // Assert
    verify(entityRelationshipDao).migrateEntityRelationships(isNull(), isNull(), eq("42"));
  }

  /**
   * Method under test:
   * {@link EntityRelationshipService#getEntityRelationshipsByKind(RelationshipKind)}
   */
  @Test
  void testGetEntityRelationshipsByKind() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(entityRelationshipDao.getEntityRelationshipsByKind(Mockito.<org.finos.waltz.model.rel.RelationshipKind>any()))
        .thenReturn(entityRelationshipList);

    // Act
    Collection<EntityRelationship> actualEntityRelationshipsByKind = (new EntityRelationshipService(
        entityRelationshipDao)).getEntityRelationshipsByKind(null);

    // Assert
    verify(entityRelationshipDao).getEntityRelationshipsByKind(isNull());
    assertTrue(actualEntityRelationshipsByKind instanceof List);
    assertTrue(actualEntityRelationshipsByKind.isEmpty());
    assertSame(entityRelationshipList, actualEntityRelationshipsByKind);
  }
}
