package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EntityReferenceDiffblueTest {
  /**
   * Method under test: {@link EntityReference#mkRef(EntityKind, long)}
   */
  @Test
  void testMkRef() {
    // Arrange and Act
    EntityReference actualMkRefResult = EntityReference.mkRef(EntityKind.ALL, 1L);

    // Assert
    assertTrue(actualMkRefResult instanceof ImmutableEntityReference);
    assertNull(actualMkRefResult.description());
    assertEquals(1L, actualMkRefResult.id());
    assertEquals(EntityKind.ALL, actualMkRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualMkRefResult.entityLifecycleStatus());
  }

  /**
   * Method under test: {@link EntityReference#mkRef(EntityKind, long, String)}
   */
  @Test
  void testMkRef2() {
    // Arrange and Act
    EntityReference actualMkRefResult = EntityReference.mkRef(EntityKind.ALL, 1L, "Name");

    // Assert
    assertTrue(actualMkRefResult instanceof ImmutableEntityReference);
    assertNull(actualMkRefResult.description());
    assertEquals(1L, actualMkRefResult.id());
    assertEquals(EntityKind.ALL, actualMkRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualMkRefResult.entityLifecycleStatus());
  }

  /**
   * Method under test:
   * {@link EntityReference#mkRef(EntityKind, long, String, String)}
   */
  @Test
  void testMkRef3() {
    // Arrange and Act
    EntityReference actualMkRefResult = EntityReference.mkRef(EntityKind.ALL, 1L, "Name",
        "The characteristics of someone or something");

    // Assert
    assertTrue(actualMkRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualMkRefResult.description());
    assertEquals(1L, actualMkRefResult.id());
    assertEquals(EntityKind.ALL, actualMkRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualMkRefResult.entityLifecycleStatus());
  }

  /**
   * Method under test:
   * {@link EntityReference#mkRef(EntityKind, long, String, String, String)}
   */
  @Test
  void testMkRef4() {
    // Arrange and Act
    EntityReference actualMkRefResult = EntityReference.mkRef(EntityKind.ALL, 1L, "Name",
        "The characteristics of someone or something", "42");

    // Assert
    assertTrue(actualMkRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualMkRefResult.description());
    assertEquals(1L, actualMkRefResult.id());
    assertEquals(EntityKind.ALL, actualMkRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualMkRefResult.entityLifecycleStatus());
  }
}
