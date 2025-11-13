package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.permission_group.ImmutableCheckPermissionCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCheckPermissionCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#qualifierId(Long)}
   *   <li>{@link Builder#qualifierKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand Builder.build()",
    "Builder Builder.qualifierId(Long)",
    "Builder Builder.qualifierKind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualOperationResult =
        ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableEntityReference parentEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableCheckPermissionCommand actualImmutableCheckPermissionCommand =
        actualOperationResult
            .parentEntityRef(parentEntityRef)
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Assert
    assertEquals("User", actualImmutableCheckPermissionCommand.user());
    assertEquals(1L, actualImmutableCheckPermissionCommand.qualifierId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableCheckPermissionCommand.qualifierKind());
    assertEquals(EntityKind.ALL, actualImmutableCheckPermissionCommand.subjectKind());
    assertEquals(Operation.ADD, actualImmutableCheckPermissionCommand.operation());
    assertSame(parentEntityRef, actualImmutableCheckPermissionCommand.parentEntityRef());
  }

  /**
   * Test Builder {@link Builder#from(CheckPermissionCommand)}.
   *
   * <p>Method under test: {@link Builder#from(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CheckPermissionCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CheckPermissionCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand instance =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act and Assert
    ImmutableCheckPermissionCommand actualImmutableCheckPermissionCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCheckPermissionCommand);
    ImmutableCheckPermissionCommand actualImmutableCheckPermissionCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableCheckPermissionCommand2);
  }

  /**
   * Test Builder {@link Builder#from(CheckPermissionCommand)}.
   *
   * <p>Method under test: {@link Builder#from(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CheckPermissionCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CheckPermissionCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand instance =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(null)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act and Assert
    ImmutableCheckPermissionCommand actualImmutableCheckPermissionCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCheckPermissionCommand);
    ImmutableCheckPermissionCommand actualImmutableCheckPermissionCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableCheckPermissionCommand2);
  }

  /**
   * Test Builder {@link Builder#from(CheckPermissionCommand)}.
   *
   * <p>Method under test: {@link Builder#from(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CheckPermissionCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CheckPermissionCommand)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand instance =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(null)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act and Assert
    ImmutableCheckPermissionCommand actualImmutableCheckPermissionCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCheckPermissionCommand);
    ImmutableCheckPermissionCommand actualImmutableCheckPermissionCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableCheckPermissionCommand2);
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
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act
    Builder actualOperationResult = builderResult.operation(Operation.ADD);

    // Assert
    assertSame(builderResult, actualOperationResult);
  }

  /**
   * Test Builder {@link Builder#parentEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntityRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentEntityRef(EntityReference)"})
  void testBuilderParentEntityRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act
    Builder actualParentEntityRefResult =
        builderResult.parentEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualParentEntityRefResult);
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
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test Builder {@link Builder#user(String)}.
   *
   * <ul>
   *   <li>When {@code User}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#user(String)}
   */
  @Test
  @DisplayName("Test Builder user(String); when 'User'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.user(String)"})
  void testBuilderUser_whenUser_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act
    Builder actualUserResult = builderResult.user("User");

    // Assert
    assertSame(builderResult, actualUserResult);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#copyOf(CheckPermissionCommand)}.
   *
   * <ul>
   *   <li>Then parentEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#copyOf(CheckPermissionCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CheckPermissionCommand); then parentEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.copyOf(CheckPermissionCommand)"
  })
  void testCopyOf_thenParentEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand instance =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act
    ImmutableCheckPermissionCommand actualCopyOfResult =
        ImmutableCheckPermissionCommand.copyOf(instance);

    // Assert
    EntityReference parentEntityRefResult = actualCopyOfResult.parentEntityRef();
    assertTrue(parentEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", parentEntityRefResult.description());
    assertEquals("User", actualCopyOfResult.user());
    assertEquals(1L, actualCopyOfResult.qualifierId().longValue());
    assertEquals(1L, parentEntityRefResult.id());
    assertEquals(EntityKind.ALL, parentEntityRefResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.qualifierKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}, and {@link
   * ImmutableCheckPermissionCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckPermissionCommand#equals(Object)}
   *   <li>{@link ImmutableCheckPermissionCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    Builder operationResult2 = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand2 =
        operationResult2
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act and Assert
    assertEquals(immutableCheckPermissionCommand, immutableCheckPermissionCommand2);
    assertEquals(
        immutableCheckPermissionCommand.hashCode(), immutableCheckPermissionCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}, and {@link
   * ImmutableCheckPermissionCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckPermissionCommand#equals(Object)}
   *   <li>{@link ImmutableCheckPermissionCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act and Assert
    assertEquals(immutableCheckPermissionCommand, immutableCheckPermissionCommand);
    int expectedHashCodeResult = immutableCheckPermissionCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableCheckPermissionCommand.hashCode());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ATTEST);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    Builder operationResult2 = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableCheckPermissionCommand,
        operationResult2
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    Builder operationResult2 = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableCheckPermissionCommand,
        operationResult2
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(2L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    Builder operationResult2 = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableCheckPermissionCommand,
        operationResult2
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ACTOR)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    Builder operationResult2 = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableCheckPermissionCommand,
        operationResult2
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ACTOR)
            .user("User")
            .build();

    Builder operationResult2 = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableCheckPermissionCommand,
        operationResult2
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("java.lang.String")
            .build();

    Builder operationResult2 = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableCheckPermissionCommand,
        operationResult2
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckPermissionCommand.equals(Object)",
    "int ImmutableCheckPermissionCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build(),
        "Different type to ImmutableCheckPermissionCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckPermissionCommand#toString()}
   *   <li>{@link ImmutableCheckPermissionCommand#operation()}
   *   <li>{@link ImmutableCheckPermissionCommand#parentEntityRef()}
   *   <li>{@link ImmutableCheckPermissionCommand#qualifierId()}
   *   <li>{@link ImmutableCheckPermissionCommand#qualifierKind()}
   *   <li>{@link ImmutableCheckPermissionCommand#subjectKind()}
   *   <li>{@link ImmutableCheckPermissionCommand#user()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation ImmutableCheckPermissionCommand.operation()",
    "EntityReference ImmutableCheckPermissionCommand.parentEntityRef()",
    "Long ImmutableCheckPermissionCommand.qualifierId()",
    "EntityKind ImmutableCheckPermissionCommand.qualifierKind()",
    "EntityKind ImmutableCheckPermissionCommand.subjectKind()",
    "String ImmutableCheckPermissionCommand.toString()",
    "String ImmutableCheckPermissionCommand.user()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act
    String actualToStringResult = immutableCheckPermissionCommand.toString();
    Operation actualOperationResult = immutableCheckPermissionCommand.operation();
    EntityReference actualParentEntityRefResult = immutableCheckPermissionCommand.parentEntityRef();
    Long actualQualifierIdResult = immutableCheckPermissionCommand.qualifierId();
    EntityKind actualQualifierKindResult = immutableCheckPermissionCommand.qualifierKind();
    EntityKind actualSubjectKindResult = immutableCheckPermissionCommand.subjectKind();

    // Assert
    assertTrue(actualParentEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "CheckPermissionCommand{user=User, parentEntityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, operation=ADD, subjectKind=ALL, qualifierKind=ALL, qualifierId=1}",
        actualToStringResult);
    assertEquals("User", immutableCheckPermissionCommand.user());
    assertEquals(1L, actualQualifierIdResult.longValue());
    assertEquals(EntityKind.ALL, actualQualifierKindResult);
    assertEquals(EntityKind.ALL, actualSubjectKindResult);
    assertEquals(Operation.ADD, actualOperationResult);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withOperation(Operation)"
  })
  void testWithOperation() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act
    ImmutableCheckPermissionCommand actualWithOperationResult =
        immutableCheckPermissionCommand.withOperation(Operation.ADD);

    // Assert
    assertSame(immutableCheckPermissionCommand, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withOperation(Operation)}.
   *
   * <ul>
   *   <li>Then parentEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test withOperation(Operation); then parentEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withOperation(Operation)"
  })
  void testWithOperation_thenParentEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ATTEST);

    // Act
    ImmutableCheckPermissionCommand actualWithOperationResult =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build()
            .withOperation(Operation.ADD);

    // Assert
    EntityReference parentEntityRefResult = actualWithOperationResult.parentEntityRef();
    assertTrue(parentEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", parentEntityRefResult.description());
    assertEquals("User", actualWithOperationResult.user());
    assertEquals(1L, actualWithOperationResult.qualifierId().longValue());
    assertEquals(1L, parentEntityRefResult.id());
    assertEquals(EntityKind.ALL, parentEntityRefResult.kind());
    assertEquals(EntityKind.ALL, actualWithOperationResult.qualifierKind());
    assertEquals(EntityKind.ALL, actualWithOperationResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithOperationResult.operation());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withParentEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableCheckPermissionCommand#withParentEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withParentEntityRef(EntityReference)"
  })
  void testWithParentEntityRef() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act
    ImmutableCheckPermissionCommand actualWithParentEntityRefResult =
        immutableCheckPermissionCommand.withParentEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableCheckPermissionCommand, actualWithParentEntityRefResult);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withQualifierId(Long)}.
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withQualifierId(Long)}
   */
  @Test
  @DisplayName("Test withQualifierId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withQualifierId(Long)"
  })
  void testWithQualifierId() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act
    ImmutableCheckPermissionCommand actualWithQualifierIdResult =
        immutableCheckPermissionCommand.withQualifierId(1L);

    // Assert
    assertSame(immutableCheckPermissionCommand, actualWithQualifierIdResult);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withQualifierId(Long)}.
   *
   * <ul>
   *   <li>Then parentEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withQualifierId(Long)}
   */
  @Test
  @DisplayName("Test withQualifierId(Long); then parentEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withQualifierId(Long)"
  })
  void testWithQualifierId_thenParentEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act
    ImmutableCheckPermissionCommand actualWithQualifierIdResult =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build()
            .withQualifierId(42L);

    // Assert
    EntityReference parentEntityRefResult = actualWithQualifierIdResult.parentEntityRef();
    assertTrue(parentEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", parentEntityRefResult.description());
    assertEquals("User", actualWithQualifierIdResult.user());
    assertEquals(1L, parentEntityRefResult.id());
    assertEquals(42L, actualWithQualifierIdResult.qualifierId().longValue());
    assertEquals(EntityKind.ALL, parentEntityRefResult.kind());
    assertEquals(EntityKind.ALL, actualWithQualifierIdResult.qualifierKind());
    assertEquals(EntityKind.ALL, actualWithQualifierIdResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithQualifierIdResult.operation());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withQualifierKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withQualifierKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withQualifierKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withQualifierKind(EntityKind)"
  })
  void testWithQualifierKind() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act
    ImmutableCheckPermissionCommand actualWithQualifierKindResult =
        immutableCheckPermissionCommand.withQualifierKind(EntityKind.ALL);

    // Assert
    assertSame(immutableCheckPermissionCommand, actualWithQualifierKindResult);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withQualifierKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then parentEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withQualifierKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withQualifierKind(EntityKind); then parentEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withQualifierKind(EntityKind)"
  })
  void testWithQualifierKind_thenParentEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act
    ImmutableCheckPermissionCommand actualWithQualifierKindResult =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ACTOR)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build()
            .withQualifierKind(EntityKind.ALL);

    // Assert
    EntityReference parentEntityRefResult = actualWithQualifierKindResult.parentEntityRef();
    assertTrue(parentEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", parentEntityRefResult.description());
    assertEquals("User", actualWithQualifierKindResult.user());
    assertEquals(1L, actualWithQualifierKindResult.qualifierId().longValue());
    assertEquals(1L, parentEntityRefResult.id());
    assertEquals(EntityKind.ALL, parentEntityRefResult.kind());
    assertEquals(EntityKind.ALL, actualWithQualifierKindResult.qualifierKind());
    assertEquals(EntityKind.ALL, actualWithQualifierKindResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithQualifierKindResult.operation());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build();

    // Act
    ImmutableCheckPermissionCommand actualWithSubjectKindResult =
        immutableCheckPermissionCommand.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableCheckPermissionCommand, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then parentEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withSubjectKind(EntityKind); then parentEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind_thenParentEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act
    ImmutableCheckPermissionCommand actualWithSubjectKindResult =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ACTOR)
            .user("User")
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    EntityReference parentEntityRefResult = actualWithSubjectKindResult.parentEntityRef();
    assertTrue(parentEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", parentEntityRefResult.description());
    assertEquals("User", actualWithSubjectKindResult.user());
    assertEquals(1L, actualWithSubjectKindResult.qualifierId().longValue());
    assertEquals(1L, parentEntityRefResult.id());
    assertEquals(EntityKind.ALL, parentEntityRefResult.kind());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.qualifierKind());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithSubjectKindResult.operation());
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withUser(String)}.
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withUser(String)}
   */
  @Test
  @DisplayName("Test withUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withUser(String)"
  })
  void testWithUser() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);
    ImmutableCheckPermissionCommand immutableCheckPermissionCommand =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("42")
            .build();

    // Act
    ImmutableCheckPermissionCommand actualWithUserResult =
        immutableCheckPermissionCommand.withUser("42");

    // Assert
    assertSame(immutableCheckPermissionCommand, actualWithUserResult);
  }

  /**
   * Test {@link ImmutableCheckPermissionCommand#withUser(String)}.
   *
   * <ul>
   *   <li>Then parentEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckPermissionCommand#withUser(String)}
   */
  @Test
  @DisplayName("Test withUser(String); then parentEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCheckPermissionCommand ImmutableCheckPermissionCommand.withUser(String)"
  })
  void testWithUser_thenParentEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult = ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act
    ImmutableCheckPermissionCommand actualWithUserResult =
        operationResult
            .parentEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .qualifierId(1L)
            .qualifierKind(EntityKind.ALL)
            .subjectKind(EntityKind.ALL)
            .user("User")
            .build()
            .withUser("42");

    // Assert
    EntityReference parentEntityRefResult = actualWithUserResult.parentEntityRef();
    assertTrue(parentEntityRefResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithUserResult.user());
    assertEquals(
        "The characteristics of someone or something", parentEntityRefResult.description());
    assertEquals(1L, actualWithUserResult.qualifierId().longValue());
    assertEquals(1L, parentEntityRefResult.id());
    assertEquals(EntityKind.ALL, parentEntityRefResult.kind());
    assertEquals(EntityKind.ALL, actualWithUserResult.qualifierKind());
    assertEquals(EntityKind.ALL, actualWithUserResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithUserResult.operation());
  }
}
