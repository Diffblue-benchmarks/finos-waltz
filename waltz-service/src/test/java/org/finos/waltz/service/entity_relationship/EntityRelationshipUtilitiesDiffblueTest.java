package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.RelationshipKind;
import org.junit.jupiter.api.Test;

class EntityRelationshipUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)}
   */
  @Test
  void testMkEntityRelationshipKey() {
    // Arrange
    EntityReference entityA = mock(EntityReference.class);
    when(entityA.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityB = mock(EntityReference.class);
    when(entityB.kind()).thenReturn(EntityKind.ALL);

    // Act
    Optional<EntityRelationshipKey> actualMkEntityRelationshipKeyResult = EntityRelationshipUtilities
        .mkEntityRelationshipKey(entityA, entityB, RelationshipKind.HAS, true);

    // Assert
    verify(entityA, atLeast(1)).kind();
    verify(entityB, atLeast(1)).kind();
    assertFalse(actualMkEntityRelationshipKeyResult.isPresent());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)}
   */
  @Test
  void testMkEntityRelationshipKey2() {
    // Arrange
    EntityReference entityA = mock(EntityReference.class);
    EntityReference entityB = mock(EntityReference.class);

    // Act
    Optional<EntityRelationshipKey> actualMkEntityRelationshipKeyResult = EntityRelationshipUtilities
        .mkEntityRelationshipKey(entityA, entityB, RelationshipKind.HAS, false);

    // Assert
    EntityRelationshipKey getResult = actualMkEntityRelationshipKeyResult.get();
    assertTrue(getResult instanceof ImmutableEntityRelationshipKey);
    assertEquals("HAS", getResult.relationshipKind());
    assertTrue(actualMkEntityRelationshipKeyResult.isPresent());
    assertSame(entityA, getResult.a());
    assertSame(entityB, getResult.b());
  }
}
