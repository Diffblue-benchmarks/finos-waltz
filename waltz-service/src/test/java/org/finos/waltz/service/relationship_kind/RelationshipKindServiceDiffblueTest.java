package org.finos.waltz.service.relationship_kind;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.rel.RelationshipKindDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.rel.RelationshipKind;
import org.finos.waltz.model.rel.UpdateRelationshipKindCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RelationshipKindServiceDiffblueTest {
  /**
   * Method under test:
   * {@link RelationshipKindService#findRelationshipKindsBetweenEntites(EntityReference, EntityReference)}
   */
  @Test
  void testFindRelationshipKindsBetweenEntites() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    HashSet<RelationshipKind> relationshipKindSet = new HashSet<>();
    when(relationshipKindDao.findRelationshipKindsBetweenEntites(Mockito.<EntityReference>any(),
        Mockito.<EntityReference>any())).thenReturn(relationshipKindSet);

    // Act
    Set<RelationshipKind> actualFindRelationshipKindsBetweenEntitesResult = (new RelationshipKindService(
        relationshipKindDao)).findRelationshipKindsBetweenEntites(null, null);

    // Assert
    verify(relationshipKindDao).findRelationshipKindsBetweenEntites(isNull(), isNull());
    assertTrue(actualFindRelationshipKindsBetweenEntitesResult.isEmpty());
    assertSame(relationshipKindSet, actualFindRelationshipKindsBetweenEntitesResult);
  }

  /**
   * Method under test: {@link RelationshipKindService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    HashSet<RelationshipKind> relationshipKindSet = new HashSet<>();
    when(relationshipKindDao.findAll()).thenReturn(relationshipKindSet);

    // Act
    Collection<RelationshipKind> actualFindAllResult = (new RelationshipKindService(relationshipKindDao)).findAll();

    // Assert
    verify(relationshipKindDao).findAll();
    assertTrue(actualFindAllResult instanceof Set);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(relationshipKindSet, actualFindAllResult);
  }

  /**
   * Method under test: {@link RelationshipKindService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.getById(anyLong())).thenReturn(null);

    // Act
    RelationshipKind actualById = (new RelationshipKindService(relationshipKindDao)).getById(1L);

    // Assert
    verify(relationshipKindDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link RelationshipKindService#create(RelationshipKind)}
   */
  @Test
  void testCreate() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.create(Mockito.<RelationshipKind>any())).thenReturn(true);

    // Act
    boolean actualCreateResult = (new RelationshipKindService(relationshipKindDao)).create(null);

    // Assert
    verify(relationshipKindDao).create(isNull());
    assertTrue(actualCreateResult);
  }

  /**
   * Method under test: {@link RelationshipKindService#create(RelationshipKind)}
   */
  @Test
  void testCreate2() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.create(Mockito.<RelationshipKind>any())).thenReturn(false);

    // Act
    boolean actualCreateResult = (new RelationshipKindService(relationshipKindDao)).create(null);

    // Assert
    verify(relationshipKindDao).create(isNull());
    assertFalse(actualCreateResult);
  }

  /**
   * Method under test: {@link RelationshipKindService#remove(Long)}
   */
  @Test
  void testRemove() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.remove(Mockito.<Long>any())).thenReturn(true);

    // Act
    boolean actualRemoveResult = (new RelationshipKindService(relationshipKindDao)).remove(1L);

    // Assert
    verify(relationshipKindDao).remove(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link RelationshipKindService#remove(Long)}
   */
  @Test
  void testRemove2() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.remove(Mockito.<Long>any())).thenReturn(false);

    // Act
    boolean actualRemoveResult = (new RelationshipKindService(relationshipKindDao)).remove(1L);

    // Assert
    verify(relationshipKindDao).remove(eq(1L));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link RelationshipKindService#update(long, UpdateRelationshipKindCommand)}
   */
  @Test
  void testUpdate() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.update(anyLong(), Mockito.<UpdateRelationshipKindCommand>any())).thenReturn(true);

    // Act
    boolean actualUpdateResult = (new RelationshipKindService(relationshipKindDao)).update(1L, null);

    // Assert
    verify(relationshipKindDao).update(eq(1L), isNull());
    assertTrue(actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link RelationshipKindService#update(long, UpdateRelationshipKindCommand)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.update(anyLong(), Mockito.<UpdateRelationshipKindCommand>any())).thenReturn(false);

    // Act
    boolean actualUpdateResult = (new RelationshipKindService(relationshipKindDao)).update(1L, null);

    // Assert
    verify(relationshipKindDao).update(eq(1L), isNull());
    assertFalse(actualUpdateResult);
  }
}
