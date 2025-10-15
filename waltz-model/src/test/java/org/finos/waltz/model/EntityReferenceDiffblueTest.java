package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityReferenceDiffblueTest {
  /**
   * Test {@link EntityReference#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link EntityReference#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus EntityReference.entityLifecycleStatus()"})
  void testEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .entityLifecycleStatus());
  }

  /**
   * Test {@link EntityReference#mkRef(EntityKind, long)} with {@code kind}, {@code id}.
   *
   * <p>Method under test: {@link EntityReference#mkRef(EntityKind, long)}
   */
  @Test
  @DisplayName("Test mkRef(EntityKind, long) with 'kind', 'id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link EntityReference#mkRef(EntityKind, long, String)} with {@code kind}, {@code id},
   * {@code name}.
   *
   * <p>Method under test: {@link EntityReference#mkRef(EntityKind, long, String)}
   */
  @Test
  @DisplayName("Test mkRef(EntityKind, long, String) with 'kind', 'id', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link EntityReference#mkRef(EntityKind, long, String, String)} with {@code kind}, {@code
   * id}, {@code name}, {@code description}.
   *
   * <p>Method under test: {@link EntityReference#mkRef(EntityKind, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test mkRef(EntityKind, long, String, String) with 'kind', 'id', 'name', 'description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference EntityReference.mkRef(EntityKind, long, String, String)"})
  void testMkRefWithKindIdNameDescription() {
    // Arrange and Act
    EntityReference actualMkRefResult =
        EntityReference.mkRef(
            EntityKind.ALL, 1L, "Name", "The characteristics of someone or something");

    // Assert
    assertTrue(actualMkRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualMkRefResult.description());
    assertEquals(1L, actualMkRefResult.id());
    assertEquals(EntityKind.ALL, actualMkRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualMkRefResult.entityLifecycleStatus());
  }

  /**
   * Test {@link EntityReference#mkRef(EntityKind, long, String, String, String)} with {@code kind},
   * {@code id}, {@code name}, {@code description}, {@code externalId}.
   *
   * <p>Method under test: {@link EntityReference#mkRef(EntityKind, long, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test mkRef(EntityKind, long, String, String, String) with 'kind', 'id', 'name', 'description', 'externalId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference EntityReference.mkRef(EntityKind, long, String, String, String)"
  })
  void testMkRefWithKindIdNameDescriptionExternalId() {
    // Arrange and Act
    EntityReference actualMkRefResult =
        EntityReference.mkRef(
            EntityKind.ALL, 1L, "Name", "The characteristics of someone or something", "42");

    // Assert
    assertTrue(actualMkRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualMkRefResult.description());
    assertEquals(1L, actualMkRefResult.id());
    assertEquals(EntityKind.ALL, actualMkRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualMkRefResult.entityLifecycleStatus());
  }
}
