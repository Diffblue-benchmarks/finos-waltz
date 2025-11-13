package org.finos.waltz.model.permission_group;

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
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.permission_group.ImmutablePermission.Builder;
import org.finos.waltz.model.permission_group.ImmutablePermission.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePermissionDiffblueTest {
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
    "ImmutablePermission Builder.build()",
    "Builder Builder.qualifierReference(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualParentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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
    Builder actualQualifierReferenceResult2 =
        actualQualifierReferenceResult.qualifierReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRequiredInvolvementsResult requiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();
    ImmutablePermission actualImmutablePermission =
        actualQualifierReferenceResult2
            .requiredInvolvementsResult(requiredInvolvementsResult)
            .subjectKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals(EntityKind.ALL, actualImmutablePermission.parentKind());
    assertEquals(EntityKind.ALL, actualImmutablePermission.subjectKind());
    assertEquals(Operation.ADD, actualImmutablePermission.operation());
    assertSame(requiredInvolvementsResult, actualImmutablePermission.requiredInvolvementsResult());
  }

  /**
   * Test Builder {@link Builder#from(Permission)}.
   *
   * <p>Method under test: {@link Builder#from(Permission)}
   */
  @Test
  @DisplayName("Test Builder from(Permission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Permission)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePermission.builder();

    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission instance =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePermission actualImmutablePermission = builderResult.build();
    assertEquals(instance, actualImmutablePermission);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Permission)}.
   *
   * <p>Method under test: {@link Builder#from(Permission)}
   */
  @Test
  @DisplayName("Test Builder from(Permission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Permission)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePermission.builder();

    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    Optional<? extends EntityReference> qualifierReference = Optional.empty();

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission instance =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePermission actualImmutablePermission = builderResult.build();
    assertEquals(instance, actualImmutablePermission);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   *
   * <p>Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutablePermission.builder();

    // Act
    Builder actualOperationResult = builderResult.operation(Operation.ADD);

    // Assert
    assertSame(builderResult, actualOperationResult);
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
    Builder builderResult = ImmutablePermission.builder();

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
    Builder builderResult = ImmutablePermission.builder();
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
   * Test Builder {@link Builder#requiredInvolvementsResult(RequiredInvolvementsResult)}.
   *
   * <ul>
   *   <li>When {@link ImmutableRequiredInvolvementsResult.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#requiredInvolvementsResult(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName(
      "Test Builder requiredInvolvementsResult(RequiredInvolvementsResult); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.requiredInvolvementsResult(RequiredInvolvementsResult)"})
  void testBuilderRequiredInvolvementsResult_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePermission.builder();

    // Act
    Builder actualRequiredInvolvementsResultResult =
        builderResult.requiredInvolvementsResult(new ImmutableRequiredInvolvementsResult.Json());

    // Assert
    assertSame(builderResult, actualRequiredInvolvementsResultResult);
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
    Builder builderResult = ImmutablePermission.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test {@link ImmutablePermission#copyOf(Permission)}.
   *
   * <p>Method under test: {@link ImmutablePermission#copyOf(Permission)}
   */
  @Test
  @DisplayName("Test copyOf(Permission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.copyOf(Permission)"})
  void testCopyOf() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission instance =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutablePermission actualCopyOfResult = ImmutablePermission.copyOf(instance);

    // Assert
    RequiredInvolvementsResult requiredInvolvementsResultResult =
        actualCopyOfResult.requiredInvolvementsResult();
    assertTrue(requiredInvolvementsResultResult instanceof ImmutableRequiredInvolvementsResult);
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertTrue(requiredInvolvementsResultResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(requiredInvolvementsResultResult.areAllUsersAllowed());
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}, and {@link ImmutablePermission#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePermission#equals(Object)}
   *   <li>{@link ImmutablePermission#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult2 = parentKindResult2.qualifierReference(qualifierReference2);
    ImmutablePermission immutablePermission2 =
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutablePermission, immutablePermission2);
    assertEquals(immutablePermission.hashCode(), immutablePermission2.hashCode());
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}, and {@link ImmutablePermission#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePermission#equals(Object)}
   *   <li>{@link ImmutablePermission#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutablePermission, immutablePermission);
    int expectedHashCodeResult = immutablePermission.hashCode();
    assertEquals(expectedHashCodeResult, immutablePermission.hashCode());
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ATTEST).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult2 = parentKindResult2.qualifierReference(qualifierReference2);

    // Act and Assert
    assertNotEquals(
        immutablePermission,
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ACTOR);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult2 = parentKindResult2.qualifierReference(qualifierReference2);

    // Act and Assert
    assertNotEquals(
        immutablePermission,
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult2 = parentKindResult2.qualifierReference(qualifierReference2);

    // Act and Assert
    assertNotEquals(
        immutablePermission,
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult =
        ImmutableRequiredInvolvementsResult.builder();
    builderResult.addRequiredInvolvementKindIds(1L);
    ImmutableRequiredInvolvementsResult requiredInvolvementsResult =
        builderResult.areAllUsersAllowed(true).build();

    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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
    ImmutablePermission immutablePermission =
        parentKindResult
            .qualifierReference(qualifierReference)
            .requiredInvolvementsResult(requiredInvolvementsResult)
            .subjectKind(EntityKind.ALL)
            .build();

    Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult2.qualifierReference(qualifierReference2);

    // Act and Assert
    assertNotEquals(
        immutablePermission,
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ACTOR)
            .build();

    Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult2 = parentKindResult2.qualifierReference(qualifierReference2);

    // Act and Assert
    assertNotEquals(
        immutablePermission,
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);

    // Act and Assert
    assertNotEquals(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePermission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermission.equals(Object)",
    "int ImmutablePermission.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);

    // Act and Assert
    assertNotEquals(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutablePermission");
  }

  /**
   * Test {@link ImmutablePermission#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parentKind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parentKind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.fromJson(Json)"})
  void testFromJson_thenReturnParentKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setOperation(Operation.ADD);
    json.setParentKind(EntityKind.ALL);
    json.setSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    json.setQualifierReference(qualifierReference);
    ImmutableRequiredInvolvementsResult.Json requiredInvolvementsResult =
        new ImmutableRequiredInvolvementsResult.Json();
    json.setRequiredInvolvementsResult(requiredInvolvementsResult);

    // Act
    ImmutablePermission actualFromJsonResult = ImmutablePermission.fromJson(json);

    // Assert
    assertEquals(EntityKind.ALL, actualFromJsonResult.parentKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    assertSame(requiredInvolvementsResult, actualFromJsonResult.requiredInvolvementsResult());
  }

  /**
   * Test {@link ImmutablePermission#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) QualifierReference is {@code null}.
   *   <li>Then return parentKind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermission#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) QualifierReference is 'null'; then return parentKind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.fromJson(Json)"})
  void testFromJson_whenJsonQualifierReferenceIsNull_thenReturnParentKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setOperation(Operation.ADD);
    json.setParentKind(EntityKind.ALL);
    json.setSubjectKind(EntityKind.ALL);
    json.setQualifierReference(null);
    ImmutableRequiredInvolvementsResult.Json requiredInvolvementsResult =
        new ImmutableRequiredInvolvementsResult.Json();
    json.setRequiredInvolvementsResult(requiredInvolvementsResult);

    // Act
    ImmutablePermission actualFromJsonResult = ImmutablePermission.fromJson(json);

    // Assert
    assertEquals(EntityKind.ALL, actualFromJsonResult.parentKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    assertSame(requiredInvolvementsResult, actualFromJsonResult.requiredInvolvementsResult());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePermission#operation()}
   *   <li>{@link ImmutablePermission#parentKind()}
   *   <li>{@link ImmutablePermission#requiredInvolvementsResult()}
   *   <li>{@link ImmutablePermission#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation ImmutablePermission.operation()",
    "EntityKind ImmutablePermission.parentKind()",
    "RequiredInvolvementsResult ImmutablePermission.requiredInvolvementsResult()",
    "EntityKind ImmutablePermission.subjectKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Operation actualOperationResult = immutablePermission.operation();
    EntityKind actualParentKindResult = immutablePermission.parentKind();
    RequiredInvolvementsResult actualRequiredInvolvementsResultResult =
        immutablePermission.requiredInvolvementsResult();

    // Assert
    assertTrue(
        actualRequiredInvolvementsResultResult instanceof ImmutableRequiredInvolvementsResult);
    assertEquals(EntityKind.ALL, actualParentKindResult);
    assertEquals(EntityKind.ALL, immutablePermission.subjectKind());
    assertEquals(Operation.ADD, actualOperationResult);
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
    assertNull(actualJson.operation);
    assertNull(actualJson.requiredInvolvementsResult);
    assertFalse(actualJson.qualifierReference.isPresent());
  }

  /**
   * Test Json {@link Json#operation()}.
   *
   * <p>Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operation());
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
   * Test Json {@link Json#requiredInvolvementsResult()}.
   *
   * <p>Method under test: {@link Json#requiredInvolvementsResult()}
   */
  @Test
  @DisplayName("Test Json requiredInvolvementsResult()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequiredInvolvementsResult Json.requiredInvolvementsResult()"})
  void testJsonRequiredInvolvementsResult() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().requiredInvolvementsResult());
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
   * Test {@link ImmutablePermission#qualifierReference()}.
   *
   * <p>Method under test: {@link ImmutablePermission#qualifierReference()}
   */
  @Test
  @DisplayName("Test qualifierReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePermission.qualifierReference()"})
  void testQualifierReference() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);

    // Act and Assert
    assertEquals(
        qualifierReference,
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build()
            .qualifierReference());
  }

  /**
   * Test {@link ImmutablePermission#toString()}.
   *
   * <p>Method under test: {@link ImmutablePermission#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutablePermission.toString()"})
  void testToString() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);

    // Act and Assert
    assertEquals(
        "Permission{operation=ADD, parentKind=ALL, subjectKind=ALL, qualifierReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, requiredInvolvementsResult=RequiredInvolvementsResult"
            + "{areAllUsersAllowed=true, requiredInvolvementKindIds=[]}}",
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePermission#toString()}.
   *
   * <p>Method under test: {@link ImmutablePermission#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutablePermission.toString()"})
  void testToString2() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    Optional<? extends EntityReference> qualifierReference = Optional.empty();

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);

    // Act and Assert
    assertEquals(
        "Permission{operation=ADD, parentKind=ALL, subjectKind=ALL, requiredInvolvementsResult=RequiredInvolv"
            + "ementsResult{areAllUsersAllowed=true, requiredInvolvementKindIds=[]}}",
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePermission#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutablePermission#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.withOperation(Operation)"})
  void testWithOperation() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutablePermission actualWithOperationResult =
        immutablePermission.withOperation(Operation.ADD);

    // Assert
    assertSame(immutablePermission, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutablePermission#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutablePermission#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.withOperation(Operation)"})
  void testWithOperation2() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ATTEST).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);

    // Act
    ImmutablePermission actualWithOperationResult =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build()
            .withOperation(Operation.ADD);

    // Assert
    RequiredInvolvementsResult requiredInvolvementsResultResult =
        actualWithOperationResult.requiredInvolvementsResult();
    assertTrue(requiredInvolvementsResultResult instanceof ImmutableRequiredInvolvementsResult);
    assertEquals(EntityKind.ALL, actualWithOperationResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithOperationResult.subjectKind());
    assertEquals(Operation.ADD, actualWithOperationResult.operation());
    assertTrue(requiredInvolvementsResultResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(requiredInvolvementsResultResult.areAllUsersAllowed());
  }

  /**
   * Test {@link ImmutablePermission#withParentKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutablePermission#withParentKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withParentKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.withParentKind(EntityKind)"})
  void testWithParentKind() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutablePermission actualWithParentKindResult =
        immutablePermission.withParentKind(EntityKind.ALL);

    // Assert
    assertSame(immutablePermission, actualWithParentKindResult);
  }

  /**
   * Test {@link ImmutablePermission#withParentKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutablePermission#withParentKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withParentKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.withParentKind(EntityKind)"})
  void testWithParentKind2() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ACTOR);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);

    // Act
    ImmutablePermission actualWithParentKindResult =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build()
            .withParentKind(EntityKind.ALL);

    // Assert
    RequiredInvolvementsResult requiredInvolvementsResultResult =
        actualWithParentKindResult.requiredInvolvementsResult();
    assertTrue(requiredInvolvementsResultResult instanceof ImmutableRequiredInvolvementsResult);
    assertEquals(EntityKind.ALL, actualWithParentKindResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithParentKindResult.subjectKind());
    assertEquals(Operation.ADD, actualWithParentKindResult.operation());
    assertTrue(requiredInvolvementsResultResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(requiredInvolvementsResultResult.areAllUsersAllowed());
  }

  /**
   * Test {@link ImmutablePermission#withQualifierReference(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePermission#withQualifierReference(Optional)}
   */
  @Test
  @DisplayName("Test withQualifierReference(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.withQualifierReference(Optional)"})
  void testWithQualifierReferenceWithOptional() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();
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
    ImmutablePermission actualWithQualifierReferenceResult =
        immutablePermission.withQualifierReference(optional);

    // Assert
    assertEquals(immutablePermission, actualWithQualifierReferenceResult);
  }

  /**
   * Test {@link ImmutablePermission#withQualifierReference(EntityReference)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePermission#withQualifierReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withQualifierReference(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermission ImmutablePermission.withQualifierReference(EntityReference)"
  })
  void testWithQualifierReferenceWithValue() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutablePermission actualWithQualifierReferenceResult =
        immutablePermission.withQualifierReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePermission, actualWithQualifierReferenceResult);
  }

  /**
   * Test {@link ImmutablePermission#withRequiredInvolvementsResult(RequiredInvolvementsResult)}.
   *
   * <p>Method under test: {@link
   * ImmutablePermission#withRequiredInvolvementsResult(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName("Test withRequiredInvolvementsResult(RequiredInvolvementsResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermission ImmutablePermission.withRequiredInvolvementsResult(RequiredInvolvementsResult)"
  })
  void testWithRequiredInvolvementsResult() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutablePermission actualWithRequiredInvolvementsResultResult =
        immutablePermission.withRequiredInvolvementsResult(
            ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());

    // Assert
    assertEquals(immutablePermission, actualWithRequiredInvolvementsResultResult);
  }

  /**
   * Test {@link ImmutablePermission#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutablePermission#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.withSubjectKind(EntityKind)"})
  void testWithSubjectKind() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    ImmutablePermission immutablePermission =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutablePermission actualWithSubjectKindResult =
        immutablePermission.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutablePermission, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutablePermission#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutablePermission#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermission ImmutablePermission.withSubjectKind(EntityKind)"})
  void testWithSubjectKind2() {
    // Arrange
    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);

    // Act
    ImmutablePermission actualWithSubjectKindResult =
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ACTOR)
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    RequiredInvolvementsResult requiredInvolvementsResultResult =
        actualWithSubjectKindResult.requiredInvolvementsResult();
    assertTrue(requiredInvolvementsResultResult instanceof ImmutableRequiredInvolvementsResult);
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
    assertEquals(Operation.ADD, actualWithSubjectKindResult.operation());
    assertTrue(requiredInvolvementsResultResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(requiredInvolvementsResultResult.areAllUsersAllowed());
  }
}
