package org.finos.waltz.model.orphan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.orphan.ImmutableOrphanRelationship.Builder;
import org.finos.waltz.model.orphan.ImmutableOrphanRelationship.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOrphanRelationshipDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrphanRelationship Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableOrphanRelationship.builder();
    ImmutableEntityReference entityA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualEntityAResult = actualBuilderResult.entityA(entityA);
    ImmutableEntityReference entityB =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableOrphanRelationship actualImmutableOrphanRelationship =
        actualEntityAResult.entityB(entityB).orphanSide(OrphanSide.A).build();

    // Assert
    assertEquals(OrphanSide.A, actualImmutableOrphanRelationship.orphanSide());
    assertSame(entityA, actualImmutableOrphanRelationship.entityA());
    assertSame(entityB, actualImmutableOrphanRelationship.entityB());
  }

  /**
   * Test Builder {@link Builder#entityA(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityA(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityA(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityA(EntityReference)"})
  void testBuilderEntityA_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act
    Builder actualEntityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityAResult);
  }

  /**
   * Test Builder {@link Builder#entityB(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityB(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityB(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityB(EntityReference)"})
  void testBuilderEntityB_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act
    Builder actualEntityBResult =
        builderResult.entityB(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityBResult);
  }

  /**
   * Test Builder {@link Builder#from(OrphanRelationship)}.
   *
   * <p>Method under test: {@link Builder#from(OrphanRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(OrphanRelationship)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrphanRelationship)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder builderResult2 = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult2.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship instance =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOrphanRelationship actualImmutableOrphanRelationship = builderResult.build();
    assertEquals(instance, actualImmutableOrphanRelationship);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#orphanSide(OrphanSide)}.
   *
   * <p>Method under test: {@link Builder#orphanSide(OrphanSide)}
   */
  @Test
  @DisplayName("Test Builder orphanSide(OrphanSide)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.orphanSide(OrphanSide)"})
  void testBuilderOrphanSide() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act
    Builder actualOrphanSideResult = builderResult.orphanSide(OrphanSide.A);

    // Assert
    assertSame(builderResult, actualOrphanSideResult);
  }

  /**
   * Test {@link ImmutableOrphanRelationship#copyOf(OrphanRelationship)}.
   *
   * <ul>
   *   <li>Then entityA return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#copyOf(OrphanRelationship)}
   */
  @Test
  @DisplayName("Test copyOf(OrphanRelationship); then entityA return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrphanRelationship ImmutableOrphanRelationship.copyOf(OrphanRelationship)"
  })
  void testCopyOf_thenEntityAReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship instance =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    // Act
    ImmutableOrphanRelationship actualCopyOfResult = ImmutableOrphanRelationship.copyOf(instance);

    // Assert
    EntityReference entityAResult2 = actualCopyOfResult.entityA();
    assertTrue(entityAResult2 instanceof ImmutableEntityReference);
    EntityReference entityBResult = actualCopyOfResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityAResult2.description());
    assertEquals(1L, entityAResult2.id());
    assertEquals(EntityKind.ALL, entityAResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult2.entityLifecycleStatus());
    assertEquals(OrphanSide.A, actualCopyOfResult.orphanSide());
    assertEquals(entityAResult2, entityBResult);
  }

  /**
   * Test {@link ImmutableOrphanRelationship#equals(Object)}, and {@link
   * ImmutableOrphanRelationship#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrphanRelationship#equals(Object)}
   *   <li>{@link ImmutableOrphanRelationship#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrphanRelationship.equals(Object)",
    "int ImmutableOrphanRelationship.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    Builder builderResult2 = ImmutableOrphanRelationship.builder();

    Builder entityAResult2 =
        builderResult2.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship2 =
        entityAResult2
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    // Act and Assert
    assertEquals(immutableOrphanRelationship, immutableOrphanRelationship2);
    assertEquals(immutableOrphanRelationship.hashCode(), immutableOrphanRelationship2.hashCode());
  }

  /**
   * Test {@link ImmutableOrphanRelationship#equals(Object)}, and {@link
   * ImmutableOrphanRelationship#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrphanRelationship#equals(Object)}
   *   <li>{@link ImmutableOrphanRelationship#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrphanRelationship.equals(Object)",
    "int ImmutableOrphanRelationship.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    // Act and Assert
    assertEquals(immutableOrphanRelationship, immutableOrphanRelationship);
    int expectedHashCodeResult = immutableOrphanRelationship.hashCode();
    assertEquals(expectedHashCodeResult, immutableOrphanRelationship.hashCode());
  }

  /**
   * Test {@link ImmutableOrphanRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrphanRelationship.equals(Object)",
    "int ImmutableOrphanRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    Builder builderResult2 = ImmutableOrphanRelationship.builder();

    Builder entityAResult2 =
        builderResult2.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOrphanRelationship,
        entityAResult2
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build());
  }

  /**
   * Test {@link ImmutableOrphanRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrphanRelationship.equals(Object)",
    "int ImmutableOrphanRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    Builder builderResult2 = ImmutableOrphanRelationship.builder();

    Builder entityAResult2 =
        builderResult2.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOrphanRelationship,
        entityAResult2
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build());
  }

  /**
   * Test {@link ImmutableOrphanRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrphanRelationship.equals(Object)",
    "int ImmutableOrphanRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.B)
            .build();

    Builder builderResult2 = ImmutableOrphanRelationship.builder();

    Builder entityAResult2 =
        builderResult2.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOrphanRelationship,
        entityAResult2
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build());
  }

  /**
   * Test {@link ImmutableOrphanRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrphanRelationship.equals(Object)",
    "int ImmutableOrphanRelationship.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOrphanRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrphanRelationship.equals(Object)",
    "int ImmutableOrphanRelationship.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build(),
        "Different type to ImmutableOrphanRelationship");
  }

  /**
   * Test {@link ImmutableOrphanRelationship#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return orphanSide is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return orphanSide is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrphanRelationship ImmutableOrphanRelationship.fromJson(Json)"})
  void testFromJson_thenReturnOrphanSideIsA() {
    // Arrange
    Json json = new Json();
    json.setEntityA(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setEntityB(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOrphanSide(OrphanSide.A);

    // Act
    ImmutableOrphanRelationship actualFromJsonResult = ImmutableOrphanRelationship.fromJson(json);

    // Assert
    assertEquals(OrphanSide.A, actualFromJsonResult.orphanSide());
    EntityReference expectedEntityAResult = json.entityA;
    assertSame(expectedEntityAResult, actualFromJsonResult.entityA());
    EntityReference expectedEntityBResult = json.entityB;
    assertSame(expectedEntityBResult, actualFromJsonResult.entityB());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrphanRelationship#toString()}
   *   <li>{@link ImmutableOrphanRelationship#entityA()}
   *   <li>{@link ImmutableOrphanRelationship#entityB()}
   *   <li>{@link ImmutableOrphanRelationship#orphanSide()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableOrphanRelationship.entityA()",
    "EntityReference ImmutableOrphanRelationship.entityB()",
    "OrphanSide ImmutableOrphanRelationship.orphanSide()",
    "String ImmutableOrphanRelationship.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    // Act
    String actualToStringResult = immutableOrphanRelationship.toString();
    EntityReference actualEntityAResult = immutableOrphanRelationship.entityA();
    EntityReference actualEntityBResult = immutableOrphanRelationship.entityB();

    // Assert
    assertTrue(actualEntityAResult instanceof ImmutableEntityReference);
    assertTrue(actualEntityBResult instanceof ImmutableEntityReference);
    assertEquals(
        "OrphanRelationship{entityA=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, entityB"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, orphanSide=A}",
        actualToStringResult);
    assertEquals(OrphanSide.A, immutableOrphanRelationship.orphanSide());
    assertEquals(actualEntityAResult, actualEntityBResult);
  }

  /**
   * Test Json {@link Json#entityA()}.
   *
   * <p>Method under test: {@link Json#entityA()}
   */
  @Test
  @DisplayName("Test Json entityA()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityA()"})
  void testJsonEntityA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityA());
  }

  /**
   * Test Json {@link Json#entityB()}.
   *
   * <p>Method under test: {@link Json#entityB()}
   */
  @Test
  @DisplayName("Test Json entityB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityB()"})
  void testJsonEntityB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityB());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityA(EntityReference)}
   *   <li>{@link Json#setEntityB(EntityReference)}
   *   <li>{@link Json#setOrphanSide(OrphanSide)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setEntityA(EntityReference)",
    "void Json.setEntityB(EntityReference)",
    "void Json.setOrphanSide(OrphanSide)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    ImmutableEntityReference entityA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    actualJson.setEntityA(entityA);
    actualJson.setEntityB(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setOrphanSide(OrphanSide.A);

    // Assert
    EntityReference entityReference = actualJson.entityA;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    EntityReference entityReference2 = actualJson.entityB;
    assertTrue(entityReference2 instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(OrphanSide.A, actualJson.orphanSide);
    assertEquals(entityA, entityReference2);
  }

  /**
   * Test Json {@link Json#orphanSide()}.
   *
   * <p>Method under test: {@link Json#orphanSide()}
   */
  @Test
  @DisplayName("Test Json orphanSide()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrphanSide Json.orphanSide()"})
  void testJsonOrphanSide() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().orphanSide());
  }

  /**
   * Test {@link ImmutableOrphanRelationship#withEntityA(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#withEntityA(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityA(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrphanRelationship ImmutableOrphanRelationship.withEntityA(EntityReference)"
  })
  void testWithEntityA() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    // Act
    ImmutableOrphanRelationship actualWithEntityAResult =
        immutableOrphanRelationship.withEntityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableOrphanRelationship, actualWithEntityAResult);
  }

  /**
   * Test {@link ImmutableOrphanRelationship#withEntityB(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#withEntityB(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityB(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrphanRelationship ImmutableOrphanRelationship.withEntityB(EntityReference)"
  })
  void testWithEntityB() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    // Act
    ImmutableOrphanRelationship actualWithEntityBResult =
        immutableOrphanRelationship.withEntityB(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableOrphanRelationship, actualWithEntityBResult);
  }

  /**
   * Test {@link ImmutableOrphanRelationship#withOrphanSide(OrphanSide)}.
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#withOrphanSide(OrphanSide)}
   */
  @Test
  @DisplayName("Test withOrphanSide(OrphanSide)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrphanRelationship ImmutableOrphanRelationship.withOrphanSide(OrphanSide)"
  })
  void testWithOrphanSide() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableOrphanRelationship immutableOrphanRelationship =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.A)
            .build();

    // Act
    ImmutableOrphanRelationship actualWithOrphanSideResult =
        immutableOrphanRelationship.withOrphanSide(OrphanSide.A);

    // Assert
    assertSame(immutableOrphanRelationship, actualWithOrphanSideResult);
  }

  /**
   * Test {@link ImmutableOrphanRelationship#withOrphanSide(OrphanSide)}.
   *
   * <ul>
   *   <li>Then entityA return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrphanRelationship#withOrphanSide(OrphanSide)}
   */
  @Test
  @DisplayName("Test withOrphanSide(OrphanSide); then entityA return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrphanRelationship ImmutableOrphanRelationship.withOrphanSide(OrphanSide)"
  })
  void testWithOrphanSide_thenEntityAReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    Builder entityAResult =
        builderResult.entityA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableOrphanRelationship actualWithOrphanSideResult =
        entityAResult
            .entityB(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .orphanSide(OrphanSide.B)
            .build()
            .withOrphanSide(OrphanSide.A);

    // Assert
    EntityReference entityAResult2 = actualWithOrphanSideResult.entityA();
    assertTrue(entityAResult2 instanceof ImmutableEntityReference);
    EntityReference entityBResult = actualWithOrphanSideResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityAResult2.description());
    assertEquals(1L, entityAResult2.id());
    assertEquals(EntityKind.ALL, entityAResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult2.entityLifecycleStatus());
    assertEquals(OrphanSide.A, actualWithOrphanSideResult.orphanSide());
    assertEquals(entityAResult2, entityBResult);
  }
}
