package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.attestation.ImmutableUserAttestationPermission.Builder;
import org.finos.waltz.model.attestation.ImmutableUserAttestationPermission.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserAttestationPermissionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#qualifierReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission Builder.build()",
    "Builder Builder.qualifierReference(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualParentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    Builder actualQualifierReferenceResult =
        actualParentKindResult.qualifierReference(qualifierReference);
    ImmutableUserAttestationPermission actualImmutableUserAttestationPermission =
        actualQualifierReferenceResult
            .qualifierReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals(EntityKind.ALL, actualImmutableUserAttestationPermission.parentKind());
    assertEquals(EntityKind.ALL, actualImmutableUserAttestationPermission.subjectKind());
    assertFalse(actualImmutableUserAttestationPermission.hasPermission());
  }

  /**
   * Test Builder {@link Builder#from(UserAttestationPermission)}.
   *
   * <p>Method under test: {@link Builder#from(UserAttestationPermission)}
   */
  @Test
  @DisplayName("Test Builder from(UserAttestationPermission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserAttestationPermission)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();

    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission instance =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUserAttestationPermission actualImmutableUserAttestationPermission =
        builderResult.build();
    assertEquals(instance, actualImmutableUserAttestationPermission);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UserAttestationPermission)}.
   *
   * <p>Method under test: {@link Builder#from(UserAttestationPermission)}
   */
  @Test
  @DisplayName("Test Builder from(UserAttestationPermission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserAttestationPermission)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();

    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableUserAttestationPermission instance =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUserAttestationPermission actualImmutableUserAttestationPermission =
        builderResult.build();
    assertEquals(instance, actualImmutableUserAttestationPermission);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#hasPermission(boolean)}.
   *
   * <p>Method under test: {@link Builder#hasPermission(boolean)}
   */
  @Test
  @DisplayName("Test Builder hasPermission(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.hasPermission(boolean)"})
  void testBuilderHasPermission() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act
    Builder actualHasPermissionResult = builderResult.hasPermission(true);

    // Assert
    assertSame(builderResult, actualHasPermissionResult);
  }

  /**
   * Test Builder {@link Builder#parentKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#parentKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder parentKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentKind(EntityKind)"})
  void testBuilderParentKind() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act
    Builder actualParentKindResult = builderResult.parentKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualParentKindResult);
  }

  /**
   * Test Builder {@link Builder#qualifierReference(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#qualifierReference(Optional)}
   */
  @Test
  @DisplayName("Test Builder qualifierReference(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.qualifierReference(Optional)"})
  void testBuilderQualifierReferenceWithOptional() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    Builder actualQualifierReferenceResult = builderResult.qualifierReference(qualifierReference);

    // Assert
    assertSame(builderResult, actualQualifierReferenceResult);
  }

  /**
   * Test Builder {@link Builder#subjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#subjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder subjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectKind(EntityKind)"})
  void testBuilderSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#copyOf(UserAttestationPermission)}.
   *
   * <ul>
   *   <li>Then return parentKind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableUserAttestationPermission#copyOf(UserAttestationPermission)}
   */
  @Test
  @DisplayName("Test copyOf(UserAttestationPermission); then return parentKind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.copyOf(UserAttestationPermission)"
  })
  void testCopyOf_thenReturnParentKindIsAll() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission instance =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act
    ImmutableUserAttestationPermission actualCopyOfResult =
        ImmutableUserAttestationPermission.copyOf(instance);

    // Assert
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertFalse(actualCopyOfResult.hasPermission());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#equals(Object)}, and {@link
   * ImmutableUserAttestationPermission#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserAttestationPermission#equals(Object)}
   *   <li>{@link ImmutableUserAttestationPermission#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAttestationPermission.equals(Object)",
    "int ImmutableUserAttestationPermission.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    Builder parentKindResult2 =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableUserAttestationPermission immutableUserAttestationPermission2 =
        parentKindResult2
            .qualifierReference(qualifierReference2)
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableUserAttestationPermission, immutableUserAttestationPermission2);
    assertEquals(
        immutableUserAttestationPermission.hashCode(),
        immutableUserAttestationPermission2.hashCode());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#equals(Object)}, and {@link
   * ImmutableUserAttestationPermission#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserAttestationPermission#equals(Object)}
   *   <li>{@link ImmutableUserAttestationPermission#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAttestationPermission.equals(Object)",
    "int ImmutableUserAttestationPermission.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act and Assert
    assertEquals(immutableUserAttestationPermission, immutableUserAttestationPermission);
    int expectedHashCodeResult = immutableUserAttestationPermission.hashCode();
    assertEquals(expectedHashCodeResult, immutableUserAttestationPermission.hashCode());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAttestationPermission.equals(Object)",
    "int ImmutableUserAttestationPermission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ACTOR);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    Builder parentKindResult2 =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableUserAttestationPermission,
        parentKindResult2
            .qualifierReference(qualifierReference2)
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAttestationPermission.equals(Object)",
    "int ImmutableUserAttestationPermission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    Builder parentKindResult2 =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableUserAttestationPermission,
        parentKindResult2
            .qualifierReference(qualifierReference2)
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAttestationPermission.equals(Object)",
    "int ImmutableUserAttestationPermission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult
            .qualifierReference(qualifierReference)
            .subjectKind(EntityKind.ACTOR)
            .build();

    Builder parentKindResult2 =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableUserAttestationPermission,
        parentKindResult2
            .qualifierReference(qualifierReference2)
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAttestationPermission.equals(Object)",
    "int ImmutableUserAttestationPermission.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build(),
        null);
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAttestationPermission.equals(Object)",
    "int ImmutableUserAttestationPermission.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build(),
        "Different type to ImmutableUserAttestationPermission");
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) ParentKind is {@code ALL}.
   *   <li>Then return parentKind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) ParentKind is 'ALL'; then return parentKind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonParentKindIsAll_thenReturnParentKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setParentKind(EntityKind.ALL);
    json.setSubjectKind(EntityKind.ALL);

    // Act
    ImmutableUserAttestationPermission actualFromJsonResult =
        ImmutableUserAttestationPermission.fromJson(json);

    // Assert
    assertEquals(EntityKind.ALL, actualFromJsonResult.parentKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertFalse(actualFromJsonResult.hasPermission());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserAttestationPermission#hasPermission()}
   *   <li>{@link ImmutableUserAttestationPermission#parentKind()}
   *   <li>{@link ImmutableUserAttestationPermission#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAttestationPermission.hasPermission()",
    "EntityKind ImmutableUserAttestationPermission.parentKind()",
    "EntityKind ImmutableUserAttestationPermission.subjectKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act
    boolean actualHasPermissionResult = immutableUserAttestationPermission.hasPermission();
    EntityKind actualParentKindResult = immutableUserAttestationPermission.parentKind();

    // Assert
    assertEquals(EntityKind.ALL, actualParentKindResult);
    assertEquals(EntityKind.ALL, immutableUserAttestationPermission.subjectKind());
    assertFalse(actualHasPermissionResult);
  }

  /**
   * Test Json {@link Json#hasPermission()}.
   *
   * <p>Method under test: {@link Json#hasPermission()}
   */
  @Test
  @DisplayName("Test Json hasPermission()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.hasPermission()"})
  void testJsonHasPermission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().hasPermission());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.parentKind);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.qualifierReference.isPresent());
    assertFalse(actualJson.hasPermission);
    assertFalse(actualJson.hasPermissionIsSet);
  }

  /**
   * Test Json {@link Json#parentKind()}.
   *
   * <p>Method under test: {@link Json#parentKind()}
   */
  @Test
  @DisplayName("Test Json parentKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.parentKind()"})
  void testJsonParentKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentKind());
  }

  /**
   * Test Json {@link Json#qualifierReference()}.
   *
   * <p>Method under test: {@link Json#qualifierReference()}
   */
  @Test
  @DisplayName("Test Json qualifierReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.qualifierReference()"})
  void testJsonQualifierReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().qualifierReference());
  }

  /**
   * Test Json {@link Json#setHasPermission(boolean)}.
   *
   * <p>Method under test: {@link Json#setHasPermission(boolean)}
   */
  @Test
  @DisplayName("Test Json setHasPermission(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setHasPermission(boolean)"})
  void testJsonSetHasPermission() {
    // Arrange
    Json json = new Json();

    // Act
    json.setHasPermission(true);

    // Assert
    assertTrue(json.hasPermission);
    assertTrue(json.hasPermissionIsSet);
  }

  /**
   * Test Json {@link Json#subjectKind()}.
   *
   * <p>Method under test: {@link Json#subjectKind()}
   */
  @Test
  @DisplayName("Test Json subjectKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.subjectKind()"})
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectKind());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#qualifierReference()}.
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#qualifierReference()}
   */
  @Test
  @DisplayName("Test qualifierReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableUserAttestationPermission.qualifierReference()"})
  void testQualifierReference() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        qualifierReference,
        parentKindResult
            .qualifierReference(qualifierReference)
            .subjectKind(EntityKind.ALL)
            .build()
            .qualifierReference());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#toString()}.
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableUserAttestationPermission.toString()"})
  void testToString() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    Optional<? extends EntityReference> qualifierReference = Optional.empty();

    // Act and Assert
    assertEquals(
        "UserAttestationPermission{subjectKind=ALL, parentKind=ALL, hasPermission=false}",
        parentKindResult
            .qualifierReference(qualifierReference)
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableUserAttestationPermission.toString()"})
  void testToString_thenReturnAString() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        "UserAttestationPermission{subjectKind=ALL, parentKind=ALL, qualifierReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, hasPermission=false}",
        parentKindResult
            .qualifierReference(qualifierReference)
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#withHasPermission(boolean)}.
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#withHasPermission(boolean)}
   */
  @Test
  @DisplayName("Test withHasPermission(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.withHasPermission(boolean)"
  })
  void testWithHasPermission() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act
    ImmutableUserAttestationPermission actualWithHasPermissionResult =
        immutableUserAttestationPermission.withHasPermission(false);

    // Assert
    assertSame(immutableUserAttestationPermission, actualWithHasPermissionResult);
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#withHasPermission(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return parentKind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#withHasPermission(boolean)}
   */
  @Test
  @DisplayName("Test withHasPermission(boolean); when 'true'; then return parentKind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.withHasPermission(boolean)"
  })
  void testWithHasPermission_whenTrue_thenReturnParentKindIsAll() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    ImmutableUserAttestationPermission actualWithHasPermissionResult =
        parentKindResult
            .qualifierReference(qualifierReference)
            .subjectKind(EntityKind.ALL)
            .build()
            .withHasPermission(true);

    // Assert
    assertEquals(EntityKind.ALL, actualWithHasPermissionResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithHasPermissionResult.subjectKind());
    assertTrue(actualWithHasPermissionResult.hasPermission());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#withParentKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#withParentKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withParentKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.withParentKind(EntityKind)"
  })
  void testWithParentKind() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act
    ImmutableUserAttestationPermission actualWithParentKindResult =
        immutableUserAttestationPermission.withParentKind(EntityKind.ALL);

    // Assert
    assertSame(immutableUserAttestationPermission, actualWithParentKindResult);
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#withParentKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return parentKind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#withParentKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withParentKind(EntityKind); then return parentKind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.withParentKind(EntityKind)"
  })
  void testWithParentKind_thenReturnParentKindIsAll() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ACTOR);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    ImmutableUserAttestationPermission actualWithParentKindResult =
        parentKindResult
            .qualifierReference(qualifierReference)
            .subjectKind(EntityKind.ALL)
            .build()
            .withParentKind(EntityKind.ALL);

    // Assert
    assertEquals(EntityKind.ALL, actualWithParentKindResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithParentKindResult.subjectKind());
    assertFalse(actualWithParentKindResult.hasPermission());
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#withQualifierReference(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableUserAttestationPermission#withQualifierReference(Optional)}
   */
  @Test
  @DisplayName("Test withQualifierReference(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.withQualifierReference(Optional)"
  })
  void testWithQualifierReferenceWithOptional() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference2);

    // Act
    ImmutableUserAttestationPermission actualWithQualifierReferenceResult =
        immutableUserAttestationPermission.withQualifierReference(optional);

    // Assert
    assertEquals(immutableUserAttestationPermission, actualWithQualifierReferenceResult);
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#withQualifierReference(EntityReference)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableUserAttestationPermission#withQualifierReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withQualifierReference(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.withQualifierReference(EntityReference)"
  })
  void testWithQualifierReferenceWithValue() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act
    ImmutableUserAttestationPermission actualWithQualifierReferenceResult =
        immutableUserAttestationPermission.withQualifierReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableUserAttestationPermission, actualWithQualifierReferenceResult);
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableUserAttestationPermission immutableUserAttestationPermission =
        parentKindResult.qualifierReference(qualifierReference).subjectKind(EntityKind.ALL).build();

    // Act
    ImmutableUserAttestationPermission actualWithSubjectKindResult =
        immutableUserAttestationPermission.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableUserAttestationPermission, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutableUserAttestationPermission#withSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return parentKind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAttestationPermission#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind); then return parentKind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAttestationPermission ImmutableUserAttestationPermission.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind_thenReturnParentKindIsAll() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    ImmutableUserAttestationPermission actualWithSubjectKindResult =
        parentKindResult
            .qualifierReference(qualifierReference)
            .subjectKind(EntityKind.ACTOR)
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
    assertFalse(actualWithSubjectKindResult.hasPermission());
  }
}
