package org.finos.waltz.service.relationship_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.rel.RelationshipKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.rel.ImmutableRelationshipKind;
import org.finos.waltz.model.rel.RelationshipKind;
import org.finos.waltz.model.rel.UpdateRelationshipKindCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RelationshipKindServiceDiffblueTest {
  /**
   * Test {@link RelationshipKindService#findRelationshipKindsBetweenEntites(EntityReference,
   * EntityReference)}.
   *
   * <p>Method under test: {@link
   * RelationshipKindService#findRelationshipKindsBetweenEntites(EntityReference, EntityReference)}
   */
  @Test
  @DisplayName("Test findRelationshipKindsBetweenEntites(EntityReference, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set RelationshipKindService.findRelationshipKindsBetweenEntites(EntityReference, EntityReference)"
  })
  void testFindRelationshipKindsBetweenEntites() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.findRelationshipKindsBetweenEntites(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<RelationshipKind> actualFindRelationshipKindsBetweenEntitesResult =
        new RelationshipKindService(relationshipKindDao)
            .findRelationshipKindsBetweenEntites(null, null);

    // Assert
    verify(relationshipKindDao).findRelationshipKindsBetweenEntites(isNull(), isNull());
    assertTrue(actualFindRelationshipKindsBetweenEntitesResult.isEmpty());
  }

  /**
   * Test {@link RelationshipKindService#findAll()}.
   *
   * <p>Method under test: {@link RelationshipKindService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection RelationshipKindService.findAll()"})
  void testFindAll() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    HashSet<RelationshipKind> relationshipKindSet = new HashSet<>();
    when(relationshipKindDao.findAll()).thenReturn(relationshipKindSet);

    // Act
    Collection<RelationshipKind> actualFindAllResult =
        new RelationshipKindService(relationshipKindDao).findAll();

    // Assert
    verify(relationshipKindDao).findAll();
    assertTrue(actualFindAllResult instanceof Set);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(relationshipKindSet, actualFindAllResult);
  }

  /**
   * Test {@link RelationshipKindService#getById(long)}.
   *
   * <p>Method under test: {@link RelationshipKindService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RelationshipKind RelationshipKindService.getById(long)"})
  void testGetById() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.getById(anyLong()))
        .thenReturn(
            ImmutableRelationshipKind.builder()
                .categoryA(1L)
                .categoryB(1L)
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kindA(EntityKind.ALL)
                .kindB(EntityKind.ALL)
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());

    // Act
    RelationshipKind actualById = new RelationshipKindService(relationshipKindDao).getById(1L);

    // Assert
    verify(relationshipKindDao).getById(1L);
    assertTrue(actualById instanceof ImmutableRelationshipKind);
    assertEquals("Code", actualById.code());
    assertEquals("Name", actualById.name());
    assertEquals("Reverse Name", actualById.reverseName());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1, actualById.position());
    assertEquals(1L, actualById.categoryA().longValue());
    assertEquals(1L, actualById.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualById.kindA());
    assertEquals(EntityKind.ALL, actualById.kindB());
    assertFalse(actualById.isReadonly());
  }

  /**
   * Test {@link RelationshipKindService#create(RelationshipKind)}.
   *
   * <ul>
   *   <li>Given {@link RelationshipKindDao} {@link RelationshipKindDao#create(RelationshipKind)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindService#create(RelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test create(RelationshipKind); given RelationshipKindDao create(RelationshipKind) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindService.create(RelationshipKind)"})
  void testCreate_givenRelationshipKindDaoCreateReturnFalse_thenReturnFalse() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.create(Mockito.<RelationshipKind>any())).thenReturn(false);

    // Act
    boolean actualCreateResult = new RelationshipKindService(relationshipKindDao).create(null);

    // Assert
    verify(relationshipKindDao).create(isNull());
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link RelationshipKindService#create(RelationshipKind)}.
   *
   * <ul>
   *   <li>Given {@link RelationshipKindDao} {@link RelationshipKindDao#create(RelationshipKind)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindService#create(RelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test create(RelationshipKind); given RelationshipKindDao create(RelationshipKind) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindService.create(RelationshipKind)"})
  void testCreate_givenRelationshipKindDaoCreateReturnTrue_thenReturnTrue() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.create(Mockito.<RelationshipKind>any())).thenReturn(true);

    // Act
    boolean actualCreateResult = new RelationshipKindService(relationshipKindDao).create(null);

    // Assert
    verify(relationshipKindDao).create(isNull());
    assertTrue(actualCreateResult);
  }

  /**
   * Test {@link RelationshipKindService#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link RelationshipKindDao} {@link RelationshipKindDao#remove(Long)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindService#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given RelationshipKindDao remove(Long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindService.remove(Long)"})
  void testRemove_givenRelationshipKindDaoRemoveReturnFalse_thenReturnFalse() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.remove(Mockito.<Long>any())).thenReturn(false);

    // Act
    boolean actualRemoveResult = new RelationshipKindService(relationshipKindDao).remove(1L);

    // Assert
    verify(relationshipKindDao).remove(1L);
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindService#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link RelationshipKindDao} {@link RelationshipKindDao#remove(Long)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindService#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given RelationshipKindDao remove(Long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindService.remove(Long)"})
  void testRemove_givenRelationshipKindDaoRemoveReturnTrue_thenReturnTrue() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.remove(Mockito.<Long>any())).thenReturn(true);

    // Act
    boolean actualRemoveResult = new RelationshipKindService(relationshipKindDao).remove(1L);

    // Assert
    verify(relationshipKindDao).remove(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindService#update(long, UpdateRelationshipKindCommand)}.
   *
   * <ul>
   *   <li>Given {@link RelationshipKindDao} {@link RelationshipKindDao#update(long,
   *       UpdateRelationshipKindCommand)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindService#update(long,
   * UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, UpdateRelationshipKindCommand); given RelationshipKindDao update(long, UpdateRelationshipKindCommand) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindService.update(long, UpdateRelationshipKindCommand)"})
  void testUpdate_givenRelationshipKindDaoUpdateReturnFalse_thenReturnFalse() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.update(anyLong(), Mockito.<UpdateRelationshipKindCommand>any()))
        .thenReturn(false);

    // Act
    boolean actualUpdateResult = new RelationshipKindService(relationshipKindDao).update(1L, null);

    // Assert
    verify(relationshipKindDao).update(eq(1L), isNull());
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link RelationshipKindService#update(long, UpdateRelationshipKindCommand)}.
   *
   * <ul>
   *   <li>Given {@link RelationshipKindDao} {@link RelationshipKindDao#update(long,
   *       UpdateRelationshipKindCommand)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindService#update(long,
   * UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, UpdateRelationshipKindCommand); given RelationshipKindDao update(long, UpdateRelationshipKindCommand) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindService.update(long, UpdateRelationshipKindCommand)"})
  void testUpdate_givenRelationshipKindDaoUpdateReturnTrue_thenReturnTrue() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.update(anyLong(), Mockito.<UpdateRelationshipKindCommand>any()))
        .thenReturn(true);

    // Act
    boolean actualUpdateResult = new RelationshipKindService(relationshipKindDao).update(1L, null);

    // Assert
    verify(relationshipKindDao).update(eq(1L), isNull());
    assertTrue(actualUpdateResult);
  }
}
