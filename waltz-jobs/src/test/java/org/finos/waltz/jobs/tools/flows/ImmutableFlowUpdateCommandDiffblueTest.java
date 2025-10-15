package org.finos.waltz.jobs.tools.flows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.flows.ImmutableFlowUpdateCommand.Builder;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowUpdateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#action(FlowUpdateCommandType)}.
   *
   * <p>Method under test: {@link Builder#action(FlowUpdateCommandType)}
   */
  @Test
  @DisplayName("Test Builder action(FlowUpdateCommandType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.action(FlowUpdateCommandType)"})
  void testBuilderAction() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act
    Builder actualActionResult = builderResult.action(FlowUpdateCommandType.ADD);

    // Assert
    assertSame(builderResult, actualActionResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#logicalFlowId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand Builder.build()",
    "Builder Builder.logicalFlowId(Long)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualActionResult =
        ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);
    ImmutableEntityReference dataTypeRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualLogicalFlowIdResult =
        actualActionResult.dataTypeRef(dataTypeRef).logicalFlowId(1L);
    ImmutableEntityReference sourceEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSourceEntityRefResult =
        actualLogicalFlowIdResult.sourceEntityRef(sourceEntityRef);
    ImmutableEntityReference targetEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableFlowUpdateCommand actualImmutableFlowUpdateCommand =
        actualSourceEntityRefResult.targetEntityRef(targetEntityRef).build();

    // Assert
    assertEquals(1L, actualImmutableFlowUpdateCommand.logicalFlowId().longValue());
    assertEquals(FlowUpdateCommandType.ADD, actualImmutableFlowUpdateCommand.action());
    assertSame(dataTypeRef, actualImmutableFlowUpdateCommand.dataTypeRef());
    assertSame(sourceEntityRef, actualImmutableFlowUpdateCommand.sourceEntityRef());
    assertSame(targetEntityRef, actualImmutableFlowUpdateCommand.targetEntityRef());
  }

  /**
   * Test Builder {@link Builder#dataTypeRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataTypeRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder dataTypeRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeRef(EntityReference)"})
  void testBuilderDataTypeRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act
    Builder actualDataTypeRefResult = builderResult.dataTypeRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualDataTypeRefResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowUpdateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowUpdateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowUpdateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand instance =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableFlowUpdateCommand actualImmutableFlowUpdateCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowUpdateCommand);
    ImmutableFlowUpdateCommand actualImmutableFlowUpdateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowUpdateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(FlowUpdateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowUpdateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowUpdateCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(null);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand instance =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableFlowUpdateCommand actualImmutableFlowUpdateCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowUpdateCommand);
    ImmutableFlowUpdateCommand actualImmutableFlowUpdateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowUpdateCommand2);
  }

  /**
   * Test Builder {@link Builder#sourceEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sourceEntityRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder sourceEntityRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sourceEntityRef(EntityReference)"})
  void testBuilderSourceEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act
    Builder actualSourceEntityRefResult =
        builderResult.sourceEntityRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualSourceEntityRefResult);
  }

  /**
   * Test Builder {@link Builder#targetEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetEntityRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder targetEntityRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetEntityRef(EntityReference)"})
  void testBuilderTargetEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act
    Builder actualTargetEntityRefResult =
        builderResult.targetEntityRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualTargetEntityRefResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#copyOf(FlowUpdateCommand)}.
   *
   * <ul>
   *   <li>Then dataTypeRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#copyOf(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(FlowUpdateCommand); then dataTypeRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand ImmutableFlowUpdateCommand.copyOf(FlowUpdateCommand)"
  })
  void testCopyOf_thenDataTypeRefReturnImmutableEntityReference() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand instance =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableFlowUpdateCommand actualCopyOfResult = ImmutableFlowUpdateCommand.copyOf(instance);

    // Assert
    EntityReference dataTypeRefResult = actualCopyOfResult.dataTypeRef();
    assertTrue(dataTypeRefResult instanceof ImmutableEntityReference);
    EntityReference sourceEntityRefResult2 = actualCopyOfResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualCopyOfResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", dataTypeRefResult.description());
    assertEquals(1L, actualCopyOfResult.logicalFlowId().longValue());
    assertEquals(1L, dataTypeRefResult.id());
    assertEquals(FlowUpdateCommandType.ADD, actualCopyOfResult.action());
    assertEquals(EntityKind.ALL, dataTypeRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, dataTypeRefResult.entityLifecycleStatus());
    assertEquals(dataTypeRefResult, sourceEntityRefResult2);
    assertEquals(dataTypeRefResult, targetEntityRefResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}, and {@link
   * ImmutableFlowUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableFlowUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder actionResult2 = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult2 =
        actionResult2
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult2 =
        logicalFlowIdResult2.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand2 =
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableFlowUpdateCommand, immutableFlowUpdateCommand2);
    assertEquals(immutableFlowUpdateCommand.hashCode(), immutableFlowUpdateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}, and {@link
   * ImmutableFlowUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableFlowUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableFlowUpdateCommand, immutableFlowUpdateCommand);
    int expectedHashCodeResult = immutableFlowUpdateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowUpdateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder actionResult =
        ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.REMOVE);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder actionResult2 = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult2 =
        actionResult2
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult2 =
        logicalFlowIdResult2.sourceEntityRef(
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
        immutableFlowUpdateCommand,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder actionResult2 = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult2 =
        actionResult2
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult2 =
        logicalFlowIdResult2.sourceEntityRef(
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
        immutableFlowUpdateCommand,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(2L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder actionResult2 = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult2 =
        actionResult2
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult2 =
        logicalFlowIdResult2.sourceEntityRef(
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
        immutableFlowUpdateCommand,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder actionResult2 = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult2 =
        actionResult2
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult2 =
        logicalFlowIdResult2.sourceEntityRef(
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
        immutableFlowUpdateCommand,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder actionResult2 = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult2 =
        actionResult2
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult2 =
        logicalFlowIdResult2.sourceEntityRef(
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
        immutableFlowUpdateCommand,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
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
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowUpdateCommand.equals(Object)",
    "int ImmutableFlowUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
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
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableFlowUpdateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowUpdateCommand#toString()}
   *   <li>{@link ImmutableFlowUpdateCommand#action()}
   *   <li>{@link ImmutableFlowUpdateCommand#dataTypeRef()}
   *   <li>{@link ImmutableFlowUpdateCommand#logicalFlowId()}
   *   <li>{@link ImmutableFlowUpdateCommand#sourceEntityRef()}
   *   <li>{@link ImmutableFlowUpdateCommand#targetEntityRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowUpdateCommandType ImmutableFlowUpdateCommand.action()",
    "EntityReference ImmutableFlowUpdateCommand.dataTypeRef()",
    "Long ImmutableFlowUpdateCommand.logicalFlowId()",
    "EntityReference ImmutableFlowUpdateCommand.sourceEntityRef()",
    "EntityReference ImmutableFlowUpdateCommand.targetEntityRef()",
    "String ImmutableFlowUpdateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableFlowUpdateCommand.toString();
    FlowUpdateCommandType actualActionResult = immutableFlowUpdateCommand.action();
    EntityReference actualDataTypeRefResult = immutableFlowUpdateCommand.dataTypeRef();
    Long actualLogicalFlowIdResult = immutableFlowUpdateCommand.logicalFlowId();
    EntityReference actualSourceEntityRefResult = immutableFlowUpdateCommand.sourceEntityRef();
    EntityReference actualTargetEntityRefResult = immutableFlowUpdateCommand.targetEntityRef();

    // Assert
    assertTrue(actualDataTypeRefResult instanceof ImmutableEntityReference);
    assertTrue(actualSourceEntityRefResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "FlowUpdateCommand{action=ADD, sourceEntityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " targetEntityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, dataTypeRef=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, logicalFlowId=1}",
        actualToStringResult);
    assertEquals(1L, actualLogicalFlowIdResult.longValue());
    assertEquals(FlowUpdateCommandType.ADD, actualActionResult);
    assertEquals(actualDataTypeRefResult, actualSourceEntityRefResult);
    assertEquals(actualDataTypeRefResult, actualTargetEntityRefResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#withAction(FlowUpdateCommandType)}.
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#withAction(FlowUpdateCommandType)}
   */
  @Test
  @DisplayName("Test withAction(FlowUpdateCommandType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand ImmutableFlowUpdateCommand.withAction(FlowUpdateCommandType)"
  })
  void testWithAction() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableFlowUpdateCommand actualWithActionResult =
        immutableFlowUpdateCommand.withAction(FlowUpdateCommandType.ADD);

    // Assert
    assertSame(immutableFlowUpdateCommand, actualWithActionResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#withAction(FlowUpdateCommandType)}.
   *
   * <ul>
   *   <li>Then dataTypeRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#withAction(FlowUpdateCommandType)}
   */
  @Test
  @DisplayName(
      "Test withAction(FlowUpdateCommandType); then dataTypeRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand ImmutableFlowUpdateCommand.withAction(FlowUpdateCommandType)"
  })
  void testWithAction_thenDataTypeRefReturnImmutableEntityReference() {
    // Arrange
    Builder actionResult =
        ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.REMOVE);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowUpdateCommand actualWithActionResult =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withAction(FlowUpdateCommandType.ADD);

    // Assert
    EntityReference dataTypeRefResult = actualWithActionResult.dataTypeRef();
    assertTrue(dataTypeRefResult instanceof ImmutableEntityReference);
    EntityReference sourceEntityRefResult2 = actualWithActionResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualWithActionResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", dataTypeRefResult.description());
    assertEquals(1L, actualWithActionResult.logicalFlowId().longValue());
    assertEquals(1L, dataTypeRefResult.id());
    assertEquals(FlowUpdateCommandType.ADD, actualWithActionResult.action());
    assertEquals(EntityKind.ALL, dataTypeRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, dataTypeRefResult.entityLifecycleStatus());
    assertEquals(dataTypeRefResult, sourceEntityRefResult2);
    assertEquals(dataTypeRefResult, targetEntityRefResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#withDataTypeRef(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#withDataTypeRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withDataTypeRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand ImmutableFlowUpdateCommand.withDataTypeRef(EntityReference)"
  })
  void testWithDataTypeRef() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableFlowUpdateCommand actualWithDataTypeRefResult =
        immutableFlowUpdateCommand.withDataTypeRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowUpdateCommand, actualWithDataTypeRefResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#withLogicalFlowId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#withLogicalFlowId(Long)}
   */
  @Test
  @DisplayName("Test withLogicalFlowId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand ImmutableFlowUpdateCommand.withLogicalFlowId(Long)"
  })
  void testWithLogicalFlowId() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableFlowUpdateCommand actualWithLogicalFlowIdResult =
        immutableFlowUpdateCommand.withLogicalFlowId(1L);

    // Assert
    assertSame(immutableFlowUpdateCommand, actualWithLogicalFlowIdResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#withLogicalFlowId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then dataTypeRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#withLogicalFlowId(Long)}
   */
  @Test
  @DisplayName(
      "Test withLogicalFlowId(Long); when forty-two; then dataTypeRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand ImmutableFlowUpdateCommand.withLogicalFlowId(Long)"
  })
  void testWithLogicalFlowId_whenFortyTwo_thenDataTypeRefReturnImmutableEntityReference() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowUpdateCommand actualWithLogicalFlowIdResult =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withLogicalFlowId(42L);

    // Assert
    EntityReference dataTypeRefResult = actualWithLogicalFlowIdResult.dataTypeRef();
    assertTrue(dataTypeRefResult instanceof ImmutableEntityReference);
    EntityReference sourceEntityRefResult2 = actualWithLogicalFlowIdResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualWithLogicalFlowIdResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", dataTypeRefResult.description());
    assertEquals(1L, dataTypeRefResult.id());
    assertEquals(42L, actualWithLogicalFlowIdResult.logicalFlowId().longValue());
    assertEquals(FlowUpdateCommandType.ADD, actualWithLogicalFlowIdResult.action());
    assertEquals(EntityKind.ALL, dataTypeRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, dataTypeRefResult.entityLifecycleStatus());
    assertEquals(dataTypeRefResult, sourceEntityRefResult2);
    assertEquals(dataTypeRefResult, targetEntityRefResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#withSourceEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#withSourceEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withSourceEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand ImmutableFlowUpdateCommand.withSourceEntityRef(EntityReference)"
  })
  void testWithSourceEntityRef() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableFlowUpdateCommand actualWithSourceEntityRefResult =
        immutableFlowUpdateCommand.withSourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowUpdateCommand, actualWithSourceEntityRefResult);
  }

  /**
   * Test {@link ImmutableFlowUpdateCommand#withTargetEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowUpdateCommand#withTargetEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withTargetEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowUpdateCommand ImmutableFlowUpdateCommand.withTargetEntityRef(EntityReference)"
  })
  void testWithTargetEntityRef() {
    // Arrange
    Builder actionResult = ImmutableFlowUpdateCommand.builder().action(FlowUpdateCommandType.ADD);

    Builder logicalFlowIdResult =
        actionResult
            .dataTypeRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .logicalFlowId(1L);

    Builder sourceEntityRefResult =
        logicalFlowIdResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowUpdateCommand immutableFlowUpdateCommand =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableFlowUpdateCommand actualWithTargetEntityRefResult =
        immutableFlowUpdateCommand.withTargetEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowUpdateCommand, actualWithTargetEntityRefResult);
  }
}
