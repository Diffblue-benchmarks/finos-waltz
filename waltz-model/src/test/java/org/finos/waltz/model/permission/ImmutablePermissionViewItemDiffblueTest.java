package org.finos.waltz.model.permission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.permission.ImmutablePermissionViewItem.Builder;
import org.finos.waltz.model.permission.ImmutablePermissionViewItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePermissionViewItemDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#qualifier(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem Builder.build()",
    "Builder Builder.qualifier(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePermissionViewItem.builder();
    ImmutableEntityReference involvementGroup =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualInvolvementGroupResult = actualBuilderResult.involvementGroup(involvementGroup);
    ImmutableEntityReference involvementKind =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualParentKindResult =
        actualInvolvementGroupResult
            .involvementKind(involvementKind)
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);
    ImmutableEntityReference permissionGroup =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualPermissionGroupResult = actualParentKindResult.permissionGroup(permissionGroup);
    ImmutableEntityReference qualifier =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutablePermissionViewItem actualImmutablePermissionViewItem =
        actualPermissionGroupResult.qualifier(qualifier).subjectKind(EntityKind.ALL).build();

    // Assert
    assertEquals(EntityKind.ALL, actualImmutablePermissionViewItem.parentKind());
    assertEquals(EntityKind.ALL, actualImmutablePermissionViewItem.subjectKind());
    assertEquals(Operation.ADD, actualImmutablePermissionViewItem.operation());
    assertSame(involvementGroup, actualImmutablePermissionViewItem.involvementGroup());
    assertSame(involvementKind, actualImmutablePermissionViewItem.involvementKind());
    assertSame(permissionGroup, actualImmutablePermissionViewItem.permissionGroup());
    assertSame(qualifier, actualImmutablePermissionViewItem.qualifier());
  }

  /**
   * Test Builder {@link Builder#from(PermissionViewItem)}.
   *
   * <p>Method under test: {@link Builder#from(PermissionViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PermissionViewItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PermissionViewItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem instance =
        permissionGroupResult
            .qualifier(
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

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePermissionViewItem actualImmutablePermissionViewItem = builderResult.build();
    assertEquals(instance, actualImmutablePermissionViewItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#involvementGroup(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#involvementGroup(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder involvementGroup(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementGroup(EntityReference)"})
  void testBuilderInvolvementGroup_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act
    Builder actualInvolvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualInvolvementGroupResult);
  }

  /**
   * Test Builder {@link Builder#involvementKind(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#involvementKind(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder involvementKind(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementKind(EntityReference)"})
  void testBuilderInvolvementKind_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act
    Builder actualInvolvementKindResult =
        builderResult.involvementKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualInvolvementKindResult);
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
    Builder builderResult = ImmutablePermissionViewItem.builder();

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
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act
    Builder actualParentKindResult = builderResult.parentKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualParentKindResult);
  }

  /**
   * Test Builder {@link Builder#permissionGroup(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#permissionGroup(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder permissionGroup(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.permissionGroup(EntityReference)"})
  void testBuilderPermissionGroup_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act
    Builder actualPermissionGroupResult =
        builderResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualPermissionGroupResult);
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
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#copyOf(PermissionViewItem)}.
   *
   * <ul>
   *   <li>Then involvementGroup return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#copyOf(PermissionViewItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PermissionViewItem); then involvementGroup return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.copyOf(PermissionViewItem)"
  })
  void testCopyOf_thenInvolvementGroupReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem instance =
        permissionGroupResult
            .qualifier(
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

    // Act
    ImmutablePermissionViewItem actualCopyOfResult = ImmutablePermissionViewItem.copyOf(instance);

    // Assert
    EntityReference involvementGroupResult2 = actualCopyOfResult.involvementGroup();
    assertTrue(involvementGroupResult2 instanceof ImmutableEntityReference);
    EntityReference involvementKindResult = actualCopyOfResult.involvementKind();
    assertTrue(involvementKindResult instanceof ImmutableEntityReference);
    EntityReference permissionGroupResult2 = actualCopyOfResult.permissionGroup();
    assertTrue(permissionGroupResult2 instanceof ImmutableEntityReference);
    EntityReference qualifierResult = actualCopyOfResult.qualifier();
    assertTrue(qualifierResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", involvementGroupResult2.description());
    assertEquals(1L, involvementGroupResult2.id());
    assertEquals(EntityKind.ALL, involvementGroupResult2.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, involvementGroupResult2.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertEquals(involvementGroupResult2, involvementKindResult);
    assertEquals(involvementGroupResult2, permissionGroupResult2);
    assertEquals(involvementGroupResult2, qualifierResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}, and {@link
   * ImmutablePermissionViewItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePermissionViewItem#equals(Object)}
   *   <li>{@link ImmutablePermissionViewItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult2 =
        involvementGroupResult2
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult2 =
        parentKindResult2.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem2 =
        permissionGroupResult2
            .qualifier(
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

    // Act and Assert
    assertEquals(immutablePermissionViewItem, immutablePermissionViewItem2);
    assertEquals(immutablePermissionViewItem.hashCode(), immutablePermissionViewItem2.hashCode());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}, and {@link
   * ImmutablePermissionViewItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePermissionViewItem#equals(Object)}
   *   <li>{@link ImmutablePermissionViewItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act and Assert
    assertEquals(immutablePermissionViewItem, immutablePermissionViewItem);
    int expectedHashCodeResult = immutablePermissionViewItem.hashCode();
    assertEquals(expectedHashCodeResult, immutablePermissionViewItem.hashCode());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult2 =
        involvementGroupResult2
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult2 =
        parentKindResult2.permissionGroup(
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
        immutablePermissionViewItem,
        permissionGroupResult2
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult2 =
        involvementGroupResult2
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult2 =
        parentKindResult2.permissionGroup(
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
        immutablePermissionViewItem,
        permissionGroupResult2
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ATTEST)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult2 =
        involvementGroupResult2
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult2 =
        parentKindResult2.permissionGroup(
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
        immutablePermissionViewItem,
        permissionGroupResult2
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ACTOR);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult2 =
        involvementGroupResult2
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult2 =
        parentKindResult2.permissionGroup(
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
        immutablePermissionViewItem,
        permissionGroupResult2
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult2 =
        involvementGroupResult2
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult2 =
        parentKindResult2.permissionGroup(
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
        immutablePermissionViewItem,
        permissionGroupResult2
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build();

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult2 =
        involvementGroupResult2
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult2 =
        parentKindResult2.permissionGroup(
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
        immutablePermissionViewItem,
        permissionGroupResult2
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ACTOR)
            .build();

    Builder builderResult2 = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult2 =
        involvementGroupResult2
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult2 =
        parentKindResult2.permissionGroup(
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
        immutablePermissionViewItem,
        permissionGroupResult2
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
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
        permissionGroupResult
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePermissionViewItem.equals(Object)",
    "int ImmutablePermissionViewItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
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
        permissionGroupResult
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutablePermissionViewItem");
  }

  /**
   * Test {@link ImmutablePermissionViewItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Qualifier is {@code null}.
   *   <li>Then return qualifier is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Qualifier is 'null'; then return qualifier is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermissionViewItem ImmutablePermissionViewItem.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonQualifierIsNull_thenReturnQualifierIsNull() {
    // Arrange
    Json json = new Json();
    json.setParentKind(EntityKind.ALL);
    json.setSubjectKind(EntityKind.ALL);
    json.setQualifier(null);
    json.setOperation(Operation.ADD);
    json.setInvolvementGroup(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setPermissionGroup(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setInvolvementKind(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePermissionViewItem actualFromJsonResult = ImmutablePermissionViewItem.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.qualifier());
    assertEquals(EntityKind.ALL, actualFromJsonResult.parentKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    EntityReference expectedInvolvementGroupResult = json.involvementGroup;
    assertSame(expectedInvolvementGroupResult, actualFromJsonResult.involvementGroup());
    EntityReference expectedInvolvementKindResult = json.involvementKind;
    assertSame(expectedInvolvementKindResult, actualFromJsonResult.involvementKind());
    EntityReference expectedPermissionGroupResult = json.permissionGroup;
    assertSame(expectedPermissionGroupResult, actualFromJsonResult.permissionGroup());
  }

  /**
   * Test {@link ImmutablePermissionViewItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return qualifier is {@link Json} (default constructor) {@link Json#qualifier}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return qualifier is Json (default constructor) qualifier")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePermissionViewItem ImmutablePermissionViewItem.fromJson(Json)"})
  void testFromJson_thenReturnQualifierIsJsonQualifier() {
    // Arrange
    Json json = new Json();
    json.setParentKind(EntityKind.ALL);
    json.setSubjectKind(EntityKind.ALL);
    json.setQualifier(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOperation(Operation.ADD);
    json.setInvolvementGroup(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setPermissionGroup(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setInvolvementKind(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePermissionViewItem actualFromJsonResult = ImmutablePermissionViewItem.fromJson(json);

    // Assert
    EntityReference expectedQualifierResult = json.qualifier;
    assertSame(expectedQualifierResult, actualFromJsonResult.qualifier());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePermissionViewItem#toString()}
   *   <li>{@link ImmutablePermissionViewItem#involvementGroup()}
   *   <li>{@link ImmutablePermissionViewItem#involvementKind()}
   *   <li>{@link ImmutablePermissionViewItem#operation()}
   *   <li>{@link ImmutablePermissionViewItem#parentKind()}
   *   <li>{@link ImmutablePermissionViewItem#permissionGroup()}
   *   <li>{@link ImmutablePermissionViewItem#qualifier()}
   *   <li>{@link ImmutablePermissionViewItem#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutablePermissionViewItem.involvementGroup()",
    "EntityReference ImmutablePermissionViewItem.involvementKind()",
    "Operation ImmutablePermissionViewItem.operation()",
    "EntityKind ImmutablePermissionViewItem.parentKind()",
    "EntityReference ImmutablePermissionViewItem.permissionGroup()",
    "EntityReference ImmutablePermissionViewItem.qualifier()",
    "EntityKind ImmutablePermissionViewItem.subjectKind()",
    "String ImmutablePermissionViewItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act
    String actualToStringResult = immutablePermissionViewItem.toString();
    EntityReference actualInvolvementGroupResult = immutablePermissionViewItem.involvementGroup();
    EntityReference actualInvolvementKindResult = immutablePermissionViewItem.involvementKind();
    Operation actualOperationResult = immutablePermissionViewItem.operation();
    EntityKind actualParentKindResult = immutablePermissionViewItem.parentKind();
    EntityReference actualPermissionGroupResult = immutablePermissionViewItem.permissionGroup();
    EntityReference actualQualifierResult = immutablePermissionViewItem.qualifier();

    // Assert
    assertTrue(actualInvolvementGroupResult instanceof ImmutableEntityReference);
    assertTrue(actualInvolvementKindResult instanceof ImmutableEntityReference);
    assertTrue(actualPermissionGroupResult instanceof ImmutableEntityReference);
    assertTrue(actualQualifierResult instanceof ImmutableEntityReference);
    assertEquals(
        "PermissionViewItem{parentKind=ALL, subjectKind=ALL, qualifier=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, operation=ADD, involvementGroup=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, permissionGroup=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, involvementKind=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        actualToStringResult);
    assertEquals(EntityKind.ALL, actualParentKindResult);
    assertEquals(EntityKind.ALL, immutablePermissionViewItem.subjectKind());
    assertEquals(Operation.ADD, actualOperationResult);
    assertEquals(actualInvolvementGroupResult, actualInvolvementKindResult);
    assertEquals(actualInvolvementGroupResult, actualPermissionGroupResult);
    assertEquals(actualInvolvementGroupResult, actualQualifierResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setInvolvementGroup(EntityReference)}
   *   <li>{@link Json#setInvolvementKind(EntityReference)}
   *   <li>{@link Json#setOperation(Operation)}
   *   <li>{@link Json#setParentKind(EntityKind)}
   *   <li>{@link Json#setPermissionGroup(EntityReference)}
   *   <li>{@link Json#setQualifier(EntityReference)}
   *   <li>{@link Json#setSubjectKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setInvolvementGroup(EntityReference)",
    "void Json.setInvolvementKind(EntityReference)",
    "void Json.setOperation(Operation)",
    "void Json.setParentKind(EntityKind)",
    "void Json.setPermissionGroup(EntityReference)",
    "void Json.setQualifier(EntityReference)",
    "void Json.setSubjectKind(EntityKind)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    ImmutableEntityReference involvementGroup =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    actualJson.setInvolvementGroup(involvementGroup);
    actualJson.setInvolvementKind(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setOperation(Operation.ADD);
    actualJson.setParentKind(EntityKind.ALL);
    actualJson.setPermissionGroup(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setQualifier(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setSubjectKind(EntityKind.ALL);

    // Assert
    EntityReference entityReference = actualJson.involvementGroup;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    EntityReference entityReference2 = actualJson.involvementKind;
    assertTrue(entityReference2 instanceof ImmutableEntityReference);
    EntityReference entityReference3 = actualJson.permissionGroup;
    assertTrue(entityReference3 instanceof ImmutableEntityReference);
    EntityReference entityReference4 = actualJson.qualifier;
    assertTrue(entityReference4 instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityKind.ALL, actualJson.parentKind);
    assertEquals(EntityKind.ALL, actualJson.subjectKind);
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualJson.operation);
    assertEquals(involvementGroup, entityReference2);
    assertEquals(involvementGroup, entityReference3);
    assertEquals(involvementGroup, entityReference4);
  }

  /**
   * Test Json {@link Json#involvementGroup()}.
   *
   * <p>Method under test: {@link Json#involvementGroup()}
   */
  @Test
  @DisplayName("Test Json involvementGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.involvementGroup()"})
  void testJsonInvolvementGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().involvementGroup());
  }

  /**
   * Test Json {@link Json#involvementKind()}.
   *
   * <p>Method under test: {@link Json#involvementKind()}
   */
  @Test
  @DisplayName("Test Json involvementKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.involvementKind()"})
  void testJsonInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().involvementKind());
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
   * Test Json {@link Json#permissionGroup()}.
   *
   * <p>Method under test: {@link Json#permissionGroup()}
   */
  @Test
  @DisplayName("Test Json permissionGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.permissionGroup()"})
  void testJsonPermissionGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().permissionGroup());
  }

  /**
   * Test Json {@link Json#qualifier()}.
   *
   * <p>Method under test: {@link Json#qualifier()}
   */
  @Test
  @DisplayName("Test Json qualifier()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.qualifier()"})
  void testJsonQualifier() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().qualifier());
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
   * Test {@link ImmutablePermissionViewItem#withInvolvementGroup(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withInvolvementGroup(EntityReference)}
   */
  @Test
  @DisplayName("Test withInvolvementGroup(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withInvolvementGroup(EntityReference)"
  })
  void testWithInvolvementGroup() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act
    ImmutablePermissionViewItem actualWithInvolvementGroupResult =
        immutablePermissionViewItem.withInvolvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePermissionViewItem, actualWithInvolvementGroupResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withInvolvementKind(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withInvolvementKind(EntityReference)}
   */
  @Test
  @DisplayName("Test withInvolvementKind(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withInvolvementKind(EntityReference)"
  })
  void testWithInvolvementKind() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act
    ImmutablePermissionViewItem actualWithInvolvementKindResult =
        immutablePermissionViewItem.withInvolvementKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePermissionViewItem, actualWithInvolvementKindResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withOperation(Operation)"
  })
  void testWithOperation() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act
    ImmutablePermissionViewItem actualWithOperationResult =
        immutablePermissionViewItem.withOperation(Operation.ADD);

    // Assert
    assertSame(immutablePermissionViewItem, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withOperation(Operation)}.
   *
   * <ul>
   *   <li>Then involvementGroup return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test withOperation(Operation); then involvementGroup return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withOperation(Operation)"
  })
  void testWithOperation_thenInvolvementGroupReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ATTEST)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePermissionViewItem actualWithOperationResult =
        permissionGroupResult
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build()
            .withOperation(Operation.ADD);

    // Assert
    EntityReference involvementGroupResult2 = actualWithOperationResult.involvementGroup();
    assertTrue(involvementGroupResult2 instanceof ImmutableEntityReference);
    EntityReference involvementKindResult = actualWithOperationResult.involvementKind();
    assertTrue(involvementKindResult instanceof ImmutableEntityReference);
    EntityReference permissionGroupResult2 = actualWithOperationResult.permissionGroup();
    assertTrue(permissionGroupResult2 instanceof ImmutableEntityReference);
    EntityReference qualifierResult = actualWithOperationResult.qualifier();
    assertTrue(qualifierResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", involvementGroupResult2.description());
    assertEquals(1L, involvementGroupResult2.id());
    assertEquals(EntityKind.ALL, involvementGroupResult2.kind());
    assertEquals(EntityKind.ALL, actualWithOperationResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithOperationResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, involvementGroupResult2.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithOperationResult.operation());
    assertEquals(involvementGroupResult2, involvementKindResult);
    assertEquals(involvementGroupResult2, permissionGroupResult2);
    assertEquals(involvementGroupResult2, qualifierResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withParentKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withParentKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withParentKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withParentKind(EntityKind)"
  })
  void testWithParentKind() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act
    ImmutablePermissionViewItem actualWithParentKindResult =
        immutablePermissionViewItem.withParentKind(EntityKind.ALL);

    // Assert
    assertSame(immutablePermissionViewItem, actualWithParentKindResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withParentKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then involvementGroup return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withParentKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withParentKind(EntityKind); then involvementGroup return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withParentKind(EntityKind)"
  })
  void testWithParentKind_thenInvolvementGroupReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ACTOR);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePermissionViewItem actualWithParentKindResult =
        permissionGroupResult
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ALL)
            .build()
            .withParentKind(EntityKind.ALL);

    // Assert
    EntityReference involvementGroupResult2 = actualWithParentKindResult.involvementGroup();
    assertTrue(involvementGroupResult2 instanceof ImmutableEntityReference);
    EntityReference involvementKindResult = actualWithParentKindResult.involvementKind();
    assertTrue(involvementKindResult instanceof ImmutableEntityReference);
    EntityReference permissionGroupResult2 = actualWithParentKindResult.permissionGroup();
    assertTrue(permissionGroupResult2 instanceof ImmutableEntityReference);
    EntityReference qualifierResult = actualWithParentKindResult.qualifier();
    assertTrue(qualifierResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", involvementGroupResult2.description());
    assertEquals(1L, involvementGroupResult2.id());
    assertEquals(EntityKind.ALL, involvementGroupResult2.kind());
    assertEquals(EntityKind.ALL, actualWithParentKindResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithParentKindResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, involvementGroupResult2.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithParentKindResult.operation());
    assertEquals(involvementGroupResult2, involvementKindResult);
    assertEquals(involvementGroupResult2, permissionGroupResult2);
    assertEquals(involvementGroupResult2, qualifierResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withPermissionGroup(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withPermissionGroup(EntityReference)}
   */
  @Test
  @DisplayName("Test withPermissionGroup(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withPermissionGroup(EntityReference)"
  })
  void testWithPermissionGroup() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act
    ImmutablePermissionViewItem actualWithPermissionGroupResult =
        immutablePermissionViewItem.withPermissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePermissionViewItem, actualWithPermissionGroupResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withQualifier(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withQualifier(EntityReference)}
   */
  @Test
  @DisplayName("Test withQualifier(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withQualifier(EntityReference)"
  })
  void testWithQualifier() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act
    ImmutablePermissionViewItem actualWithQualifierResult =
        immutablePermissionViewItem.withQualifier(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePermissionViewItem, actualWithQualifierResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePermissionViewItem immutablePermissionViewItem =
        permissionGroupResult
            .qualifier(
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

    // Act
    ImmutablePermissionViewItem actualWithSubjectKindResult =
        immutablePermissionViewItem.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutablePermissionViewItem, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutablePermissionViewItem#withSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then involvementGroup return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePermissionViewItem#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withSubjectKind(EntityKind); then involvementGroup return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePermissionViewItem ImmutablePermissionViewItem.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind_thenInvolvementGroupReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parentKindResult =
        involvementGroupResult
            .involvementKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .parentKind(EntityKind.ALL);

    Builder permissionGroupResult =
        parentKindResult.permissionGroup(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePermissionViewItem actualWithSubjectKindResult =
        permissionGroupResult
            .qualifier(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectKind(EntityKind.ACTOR)
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    EntityReference involvementGroupResult2 = actualWithSubjectKindResult.involvementGroup();
    assertTrue(involvementGroupResult2 instanceof ImmutableEntityReference);
    EntityReference involvementKindResult = actualWithSubjectKindResult.involvementKind();
    assertTrue(involvementKindResult instanceof ImmutableEntityReference);
    EntityReference permissionGroupResult2 = actualWithSubjectKindResult.permissionGroup();
    assertTrue(permissionGroupResult2 instanceof ImmutableEntityReference);
    EntityReference qualifierResult = actualWithSubjectKindResult.qualifier();
    assertTrue(qualifierResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", involvementGroupResult2.description());
    assertEquals(1L, involvementGroupResult2.id());
    assertEquals(EntityKind.ALL, involvementGroupResult2.kind());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.parentKind());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, involvementGroupResult2.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithSubjectKindResult.operation());
    assertEquals(involvementGroupResult2, involvementKindResult);
    assertEquals(involvementGroupResult2, permissionGroupResult2);
    assertEquals(involvementGroupResult2, qualifierResult);
  }
}
