package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityReferenceDiffblueTest {
  /**
   * Test {@link EntityReference#mkRef(EntityKind, long)} with {@code kind}, {@code id}.
   * <p>
   * Method under test: {@link EntityReference#mkRef(EntityKind, long)}
   */
  @Test
  @DisplayName("Test mkRef(EntityKind, long) with 'kind', 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference EntityReference.mkRef(EntityKind, long)"})
  void testMkRefWithKindId() {
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
   * Test {@link EntityReference#mkRef(EntityKind, long, String)} with {@code kind}, {@code id}, {@code name}.
   * <p>
   * Method under test: {@link EntityReference#mkRef(EntityKind, long, String)}
   */
  @Test
  @DisplayName("Test mkRef(EntityKind, long, String) with 'kind', 'id', 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference EntityReference.mkRef(EntityKind, long, String)"})
  void testMkRefWithKindIdName() {
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
   * Test {@link EntityReference#mkRef(EntityKind, long, String, String)} with {@code kind}, {@code id}, {@code name}, {@code description}.
   * <p>
   * Method under test: {@link EntityReference#mkRef(EntityKind, long, String, String)}
   */
  @Test
  @DisplayName("Test mkRef(EntityKind, long, String, String) with 'kind', 'id', 'name', 'description'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference EntityReference.mkRef(EntityKind, long, String, String)"})
  void testMkRefWithKindIdNameDescription() {
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
   * Test {@link EntityReference#mkRef(EntityKind, long, String, String, String)} with {@code kind}, {@code id}, {@code name}, {@code description}, {@code externalId}.
   * <p>
   * Method under test: {@link EntityReference#mkRef(EntityKind, long, String, String, String)}
   */
  @Test
  @DisplayName("Test mkRef(EntityKind, long, String, String, String) with 'kind', 'id', 'name', 'description', 'externalId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference EntityReference.mkRef(EntityKind, long, String, String, String)"})
  void testMkRefWithKindIdNameDescriptionExternalId() {
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
