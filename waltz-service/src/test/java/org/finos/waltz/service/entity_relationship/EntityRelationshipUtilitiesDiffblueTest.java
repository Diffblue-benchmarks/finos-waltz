package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.RelationshipKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityRelationshipUtilitiesDiffblueTest {
  /**
   * Test {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)}
   */
  @Test
  @DisplayName("Test mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean); given 'ALL'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional EntityRelationshipUtilities.mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)"})
  void testMkEntityRelationshipKey_givenAll_thenReturnNotPresent() {
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
   * Test {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)}.
   * <ul>
   *   <li>Then {@link Optional#get()} return {@link ImmutableEntityRelationshipKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityRelationshipUtilities#mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)}
   */
  @Test
  @DisplayName("Test mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean); then get() return ImmutableEntityRelationshipKey")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional EntityRelationshipUtilities.mkEntityRelationshipKey(EntityReference, EntityReference, RelationshipKind, boolean)"})
  void testMkEntityRelationshipKey_thenGetReturnImmutableEntityRelationshipKey() {
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
