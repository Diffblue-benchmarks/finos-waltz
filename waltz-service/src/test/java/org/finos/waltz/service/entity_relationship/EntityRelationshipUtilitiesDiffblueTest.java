package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.RelationshipKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityRelationshipUtilitiesDiffblueTest {
  /**
   * Test {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference,
   * EntityReference, RelationshipKind, boolean)}.
   *
   * <p>Method under test: {@link
   * EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference,
   * RelationshipKind, boolean)}
   */
  @Test
  @DisplayName(
      "Test mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional EntityRelationshipUtilities.mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)"
  })
  void testMkEntityRelationshipKey() {
    // Arrange
    ImmutableEntityReference entityA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAppGroupEntry entityB =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Optional<EntityRelationshipKey> actualMkEntityRelationshipKeyResult =
        EntityRelationshipUtilities.mkEntityRelationshipKey(
            entityA, entityB, RelationshipKind.HAS, true);

    // Assert
    assertFalse(actualMkEntityRelationshipKeyResult.isPresent());
  }

  /**
   * Test {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference,
   * EntityReference, RelationshipKind, boolean)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} return {@link ImmutableEntityRelationshipKey}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference,
   * RelationshipKind, boolean)}
   */
  @Test
  @DisplayName(
      "Test mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean); then get() return ImmutableEntityRelationshipKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional EntityRelationshipUtilities.mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)"
  })
  void testMkEntityRelationshipKey_thenGetReturnImmutableEntityRelationshipKey() {
    // Arrange
    ImmutableEntityReference entityA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference entityB =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Optional<EntityRelationshipKey> actualMkEntityRelationshipKeyResult =
        EntityRelationshipUtilities.mkEntityRelationshipKey(
            entityA, entityB, RelationshipKind.HAS, false);

    // Assert
    EntityRelationshipKey getResult = actualMkEntityRelationshipKeyResult.get();
    assertTrue(getResult instanceof ImmutableEntityRelationshipKey);
    assertEquals("HAS", getResult.relationshipKind());
    assertTrue(actualMkEntityRelationshipKeyResult.isPresent());
    assertSame(entityA, getResult.a());
    assertSame(entityB, getResult.b());
  }

  /**
   * Test {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference,
   * EntityReference, RelationshipKind, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference,
   * RelationshipKind, boolean)}
   */
  @Test
  @DisplayName(
      "Test mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean); when 'true'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional EntityRelationshipUtilities.mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)"
  })
  void testMkEntityRelationshipKey_whenTrue_thenReturnNotPresent() {
    // Arrange
    ImmutableEntityReference entityA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference entityB =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Optional<EntityRelationshipKey> actualMkEntityRelationshipKeyResult =
        EntityRelationshipUtilities.mkEntityRelationshipKey(
            entityA, entityB, RelationshipKind.HAS, true);

    // Assert
    assertFalse(actualMkEntityRelationshipKeyResult.isPresent());
  }
}
