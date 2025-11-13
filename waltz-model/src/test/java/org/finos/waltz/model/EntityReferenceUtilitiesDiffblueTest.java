package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.model.ImmutableEntityReference.Json;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityReferenceUtilitiesDiffblueTest {
  /**
   * Test {@link EntityReferenceUtilities#pretty(EntityReference)}.
   *
   * <p>Method under test: {@link EntityReferenceUtilities#pretty(EntityReference)}
   */
  @Test
  @DisplayName("Test pretty(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityReferenceUtilities.pretty(EntityReference)"})
  void testPretty() {
    // Arrange
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals("Name [ALL/1]", EntityReferenceUtilities.pretty(ref));
  }

  /**
   * Test {@link EntityReferenceUtilities#pretty(EntityReference)}.
   *
   * <p>Method under test: {@link EntityReferenceUtilities#pretty(EntityReference)}
   */
  @Test
  @DisplayName("Test pretty(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityReferenceUtilities.pretty(EntityReference)"})
  void testPretty2() {
    // Arrange
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals("Name [ALL/1]", EntityReferenceUtilities.pretty(ref));
  }

  /**
   * Test {@link EntityReferenceUtilities#safeName(EntityReference)}.
   *
   * <p>Method under test: {@link EntityReferenceUtilities#safeName(EntityReference)}
   */
  @Test
  @DisplayName("Test safeName(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityReferenceUtilities.safeName(EntityReference)"})
  void testSafeName() {
    // Arrange
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals("Name [1]", EntityReferenceUtilities.safeName(ref));
  }

  /**
   * Test {@link EntityReferenceUtilities#safeName(EntityReference)}.
   *
   * <p>Method under test: {@link EntityReferenceUtilities#safeName(EntityReference)}
   */
  @Test
  @DisplayName("Test safeName(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityReferenceUtilities.safeName(EntityReference)"})
  void testSafeName2() {
    // Arrange
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals("Name [1]", EntityReferenceUtilities.safeName(ref));
  }

  /**
   * Test {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}.
   *
   * <p>Method under test: {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  @DisplayName("Test sameRef(Optional, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityReferenceUtilities.sameRef(Optional, EntityReference)"})
  void testSameRef() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> refA = Optional.of(immutableEntityReference);
    ImmutableEntityReference refB =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    boolean actualSameRefResult = EntityReferenceUtilities.sameRef(refA, refB);

    // Assert
    assertFalse(actualSameRefResult);
  }

  /**
   * Test {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}.
   *
   * <p>Method under test: {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  @DisplayName("Test sameRef(Optional, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityReferenceUtilities.sameRef(Optional, EntityReference)"})
  void testSameRef2() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> refA = Optional.of(immutableEntityReference);
    ImmutableEntityReference refB =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    boolean actualSameRefResult = EntityReferenceUtilities.sameRef(refA, refB);

    // Assert
    assertFalse(actualSameRefResult);
  }

  /**
   * Test {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}.
   *
   * <p>Method under test: {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  @DisplayName("Test sameRef(Optional, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityReferenceUtilities.sameRef(Optional, EntityReference)"})
  void testSameRef3() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build();
    Optional<EntityReference> refA = Optional.of(immutableEntityReference);
    ImmutableEntityReference refB =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    boolean actualSameRefResult = EntityReferenceUtilities.sameRef(refA, refB);

    // Assert
    assertFalse(actualSameRefResult);
  }

  /**
   * Test {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  @DisplayName("Test sameRef(Optional, EntityReference); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityReferenceUtilities.sameRef(Optional, EntityReference)"})
  void testSameRef_thenReturnTrue() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> refA = Optional.of(immutableEntityReference);
    ImmutableEntityReference refB =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    boolean actualSameRefResult = EntityReferenceUtilities.sameRef(refA, refB);

    // Assert
    assertTrue(actualSameRefResult);
  }

  /**
   * Test {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test sameRef(Optional, EntityReference); when Json (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityReferenceUtilities.sameRef(Optional, EntityReference)"})
  void testSameRef_whenJson_thenReturnFalse() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> refA = Optional.of(immutableEntityReference);

    // Act and Assert
    assertFalse(EntityReferenceUtilities.sameRef(refA, new Json()));
  }

  /**
   * Test {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  @DisplayName("Test sameRef(Optional, EntityReference); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityReferenceUtilities.sameRef(Optional, EntityReference)"})
  void testSameRef_whenNull_thenReturnFalse() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> refA = Optional.of(immutableEntityReference);

    // Act and Assert
    assertFalse(EntityReferenceUtilities.sameRef(refA, null));
  }

  /**
   * Test {@link EntityReferenceUtilities#indexById(Collection)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceUtilities#indexById(Collection)}
   */
  @Test
  @DisplayName("Test indexById(Collection); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityReferenceUtilities.indexById(Collection)"})
  void testIndexById_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    Map<Long, EntityReference> actualIndexByIdResult = EntityReferenceUtilities.indexById(refs);

    // Assert
    assertEquals(1, actualIndexByIdResult.size());
    EntityReference getResult = actualIndexByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }

  /**
   * Test {@link EntityReferenceUtilities#indexById(Collection)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceUtilities#indexById(Collection)}
   */
  @Test
  @DisplayName("Test indexById(Collection); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityReferenceUtilities.indexById(Collection)"})
  void testIndexById_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    Map<Long, EntityReference> actualIndexByIdResult = EntityReferenceUtilities.indexById(refs);

    // Assert
    assertEquals(1, actualIndexByIdResult.size());
    EntityReference getResult = actualIndexByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }

  /**
   * Test {@link EntityReferenceUtilities#indexById(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceUtilities#indexById(Collection)}
   */
  @Test
  @DisplayName("Test indexById(Collection); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityReferenceUtilities.indexById(Collection)"})
  void testIndexById_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Long, EntityReference> actualIndexByIdResult =
        EntityReferenceUtilities.indexById(new ArrayList<>());

    // Assert
    assertTrue(actualIndexByIdResult.isEmpty());
  }
}
