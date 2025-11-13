package org.finos.waltz.model.physical_flow;

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
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommandResponse.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommandResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDeleteCommandResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#message(String)}
   *   <li>{@link Builder#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse Builder.build()",
    "Builder Builder.message(String)",
    "Builder Builder.outcome(CommandOutcome)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualMessageResult =
        actualBuilderResult
            .entityReference(entityReference)
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    Optional<String> message = Optional.of("42");
    Builder actualMessageResult2 = actualMessageResult.message(message);
    ImmutablePhysicalFlowDeleteCommand originalCommand =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build();
    ImmutablePhysicalFlowDeleteCommandResponse actualImmutablePhysicalFlowDeleteCommandResponse =
        actualMessageResult2
            .originalCommand(originalCommand)
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Assert
    PhysicalFlowDeleteCommand originalCommandResult =
        actualImmutablePhysicalFlowDeleteCommandResponse.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertEquals(
        CommandOutcome.SUCCESS, actualImmutablePhysicalFlowDeleteCommandResponse.outcome());
    assertTrue(actualImmutablePhysicalFlowDeleteCommandResponse.isLastPhysicalFlow());
    assertTrue(actualImmutablePhysicalFlowDeleteCommandResponse.isSpecificationUnused());
    assertSame(entityReference, actualImmutablePhysicalFlowDeleteCommandResponse.entityReference());
    assertSame(originalCommand, originalCommandResult);
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowDeleteCommandResponse)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowDeleteCommandResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowDeleteCommandResponse)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse instance =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowDeleteCommandResponse actualImmutablePhysicalFlowDeleteCommandResponse =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowDeleteCommandResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowDeleteCommandResponse)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowDeleteCommandResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowDeleteCommandResponse)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(false)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse instance =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowDeleteCommandResponse actualImmutablePhysicalFlowDeleteCommandResponse =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowDeleteCommandResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isLastPhysicalFlow(boolean)}.
   *
   * <p>Method under test: {@link Builder#isLastPhysicalFlow(boolean)}
   */
  @Test
  @DisplayName("Test Builder isLastPhysicalFlow(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isLastPhysicalFlow(boolean)"})
  void testBuilderIsLastPhysicalFlow() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    // Act
    Builder actualIsLastPhysicalFlowResult = builderResult.isLastPhysicalFlow(true);

    // Assert
    assertSame(builderResult, actualIsLastPhysicalFlowResult);
  }

  /**
   * Test Builder {@link Builder#isSpecificationUnused(boolean)}.
   *
   * <p>Method under test: {@link Builder#isSpecificationUnused(boolean)}
   */
  @Test
  @DisplayName("Test Builder isSpecificationUnused(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isSpecificationUnused(boolean)"})
  void testBuilderIsSpecificationUnused() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    // Act
    Builder actualIsSpecificationUnusedResult = builderResult.isSpecificationUnused(true);

    // Assert
    assertSame(builderResult, actualIsSpecificationUnusedResult);
  }

  /**
   * Test Builder {@link Builder#message(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#message(Optional)}
   */
  @Test
  @DisplayName("Test Builder message(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.message(Optional)"})
  void testBuilderMessageWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();
    Optional<String> message = Optional.of("42");

    // Act
    Builder actualMessageResult = builderResult.message(message);

    // Assert
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link Builder#originalCommand(PhysicalFlowDeleteCommand)}.
   *
   * <ul>
   *   <li>When {@link ImmutablePhysicalFlowDeleteCommand.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#originalCommand(PhysicalFlowDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder originalCommand(PhysicalFlowDeleteCommand); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.originalCommand(PhysicalFlowDeleteCommand)"})
  void testBuilderOriginalCommand_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    // Act
    Builder actualOriginalCommandResult =
        builderResult.originalCommand(new ImmutablePhysicalFlowDeleteCommand.Json());

    // Assert
    assertSame(builderResult, actualOriginalCommandResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#copyOf(PhysicalFlowDeleteCommandResponse)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#copyOf(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalFlowDeleteCommandResponse); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.copyOf(PhysicalFlowDeleteCommandResponse)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse instance =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualCopyOfResult =
        ImmutablePhysicalFlowDeleteCommandResponse.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowDeleteCommand originalCommandResult = actualCopyOfResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.flowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertTrue(actualCopyOfResult.isLastPhysicalFlow());
    assertTrue(actualCopyOfResult.isSpecificationUnused());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}, and {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse2 =
        messageResult2
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalFlowDeleteCommandResponse, immutablePhysicalFlowDeleteCommandResponse2);
    assertEquals(
        immutablePhysicalFlowDeleteCommandResponse.hashCode(),
        immutablePhysicalFlowDeleteCommandResponse2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}, and {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalFlowDeleteCommandResponse, immutablePhysicalFlowDeleteCommandResponse);
    int expectedHashCodeResult = immutablePhysicalFlowDeleteCommandResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowDeleteCommandResponse.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowDeleteCommandResponse,
        messageResult2
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(false)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowDeleteCommandResponse,
        messageResult2
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(false)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowDeleteCommandResponse,
        messageResult2
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Message");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowDeleteCommandResponse,
        messageResult2
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(2L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowDeleteCommandResponse,
        messageResult2
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.FAILURE)
            .build();

    Builder builderResult2 = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowDeleteCommandResponse,
        messageResult2
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build(),
        "Different type to ImmutablePhysicalFlowDeleteCommandResponse");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#entityReference()}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#isLastPhysicalFlow()}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#isSpecificationUnused()}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#outcome()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutablePhysicalFlowDeleteCommandResponse.entityReference()",
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.isLastPhysicalFlow()",
    "boolean ImmutablePhysicalFlowDeleteCommandResponse.isSpecificationUnused()",
    "CommandOutcome ImmutablePhysicalFlowDeleteCommandResponse.outcome()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    EntityReference actualEntityReferenceResult =
        immutablePhysicalFlowDeleteCommandResponse.entityReference();
    boolean actualIsLastPhysicalFlowResult =
        immutablePhysicalFlowDeleteCommandResponse.isLastPhysicalFlow();
    boolean actualIsSpecificationUnusedResult =
        immutablePhysicalFlowDeleteCommandResponse.isSpecificationUnused();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(CommandOutcome.SUCCESS, immutablePhysicalFlowDeleteCommandResponse.outcome());
    assertTrue(actualIsLastPhysicalFlowResult);
    assertTrue(actualIsSpecificationUnusedResult);
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json {@link Json#isLastPhysicalFlow()}.
   *
   * <p>Method under test: {@link Json#isLastPhysicalFlow()}
   */
  @Test
  @DisplayName("Test Json isLastPhysicalFlow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isLastPhysicalFlow()"})
  void testJsonIsLastPhysicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isLastPhysicalFlow());
  }

  /**
   * Test Json {@link Json#isSpecificationUnused()}.
   *
   * <p>Method under test: {@link Json#isSpecificationUnused()}
   */
  @Test
  @DisplayName("Test Json isSpecificationUnused()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isSpecificationUnused()"})
  void testJsonIsSpecificationUnused() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isSpecificationUnused());
  }

  /**
   * Test Json {@link Json#message()}.
   *
   * <p>Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().message());
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
    assertNull(actualJson.entityReference);
    assertNull(actualJson.outcome);
    assertNull(actualJson.originalCommand);
    assertFalse(actualJson.message.isPresent());
    assertFalse(actualJson.isLastPhysicalFlow);
    assertFalse(actualJson.isLastPhysicalFlowIsSet);
    assertFalse(actualJson.isSpecificationUnused);
    assertFalse(actualJson.isSpecificationUnusedIsSet);
  }

  /**
   * Test Json {@link Json#originalCommand()}.
   *
   * <p>Method under test: {@link Json#originalCommand()}
   */
  @Test
  @DisplayName("Test Json originalCommand()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlowDeleteCommand Json.originalCommand()"})
  void testJsonOriginalCommand() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().originalCommand());
  }

  /**
   * Test Json {@link Json#outcome()}.
   *
   * <p>Method under test: {@link Json#outcome()}
   */
  @Test
  @DisplayName("Test Json outcome()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommandOutcome Json.outcome()"})
  void testJsonOutcome() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().outcome());
  }

  /**
   * Test Json {@link Json#setIsLastPhysicalFlow(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsLastPhysicalFlow(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsLastPhysicalFlow(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsLastPhysicalFlow(boolean)"})
  void testJsonSetIsLastPhysicalFlow() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsLastPhysicalFlow(true);

    // Assert
    assertTrue(json.isLastPhysicalFlow);
    assertTrue(json.isLastPhysicalFlowIsSet);
  }

  /**
   * Test Json {@link Json#setIsSpecificationUnused(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsSpecificationUnused(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsSpecificationUnused(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsSpecificationUnused(boolean)"})
  void testJsonSetIsSpecificationUnused() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsSpecificationUnused(true);

    // Assert
    assertTrue(json.isSpecificationUnused);
    assertTrue(json.isSpecificationUnusedIsSet);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#message()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#message()}
   */
  @Test
  @DisplayName("Test message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlowDeleteCommandResponse.message()"})
  void testMessage() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act
    Optional<String> actualMessageResult =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .message();

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.get());
    assertTrue(actualMessageResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#originalCommand()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#originalCommand()}
   */
  @Test
  @DisplayName("Test originalCommand()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowDeleteCommand ImmutablePhysicalFlowDeleteCommandResponse.originalCommand()"
  })
  void testOriginalCommand() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act
    PhysicalFlowDeleteCommand actualOriginalCommandResult =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .originalCommand();

    // Assert
    assertTrue(actualOriginalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertEquals(1L, actualOriginalCommandResult.flowId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalFlowDeleteCommandResponse.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act and Assert
    assertEquals(
        "PhysicalFlowDeleteCommandResponse{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, originalCommand=PhysicalFlowDeleteCommand{flowId=1}, outcome=SUCCESS, message=Not all who"
            + " wander are lost, isSpecificationUnused=true, isLastPhysicalFlow=true}",
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithEntityReferenceResult =
        immutablePhysicalFlowDeleteCommandResponse.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowDeleteCommandResponse, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withIsLastPhysicalFlow(boolean)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withIsLastPhysicalFlow(boolean)}
   */
  @Test
  @DisplayName("Test withIsLastPhysicalFlow(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withIsLastPhysicalFlow(boolean)"
  })
  void testWithIsLastPhysicalFlow() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithIsLastPhysicalFlowResult =
        immutablePhysicalFlowDeleteCommandResponse.withIsLastPhysicalFlow(true);

    // Assert
    assertSame(immutablePhysicalFlowDeleteCommandResponse, actualWithIsLastPhysicalFlowResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withIsLastPhysicalFlow(boolean)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withIsLastPhysicalFlow(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsLastPhysicalFlow(boolean); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withIsLastPhysicalFlow(boolean)"
  })
  void testWithIsLastPhysicalFlow_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(false)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithIsLastPhysicalFlowResult =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .withIsLastPhysicalFlow(true);

    // Assert
    EntityReference entityReferenceResult = actualWithIsLastPhysicalFlowResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowDeleteCommand originalCommandResult =
        actualWithIsLastPhysicalFlowResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.flowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithIsLastPhysicalFlowResult.outcome());
    assertTrue(actualWithIsLastPhysicalFlowResult.isLastPhysicalFlow());
    assertTrue(actualWithIsLastPhysicalFlowResult.isSpecificationUnused());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withIsSpecificationUnused(boolean)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withIsSpecificationUnused(boolean)}
   */
  @Test
  @DisplayName("Test withIsSpecificationUnused(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withIsSpecificationUnused(boolean)"
  })
  void testWithIsSpecificationUnused() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithIsSpecificationUnusedResult =
        immutablePhysicalFlowDeleteCommandResponse.withIsSpecificationUnused(true);

    // Assert
    assertSame(immutablePhysicalFlowDeleteCommandResponse, actualWithIsSpecificationUnusedResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withIsSpecificationUnused(boolean)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withIsSpecificationUnused(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsSpecificationUnused(boolean); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withIsSpecificationUnused(boolean)"
  })
  void testWithIsSpecificationUnused_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(false)
            .message("Not all who wander are lost");

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithIsSpecificationUnusedResult =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .withIsSpecificationUnused(true);

    // Assert
    EntityReference entityReferenceResult = actualWithIsSpecificationUnusedResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowDeleteCommand originalCommandResult =
        actualWithIsSpecificationUnusedResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.flowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithIsSpecificationUnusedResult.outcome());
    assertTrue(actualWithIsSpecificationUnusedResult.isLastPhysicalFlow());
    assertTrue(actualWithIsSpecificationUnusedResult.isSpecificationUnused());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withMessage(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName("Test withMessage(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("42");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithMessageResult =
        immutablePhysicalFlowDeleteCommandResponse.withMessage(optional);

    // Assert
    assertSame(immutablePhysicalFlowDeleteCommandResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withMessage(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName(
      "Test withMessage(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithMessageResult =
        immutablePhysicalFlowDeleteCommandResponse.withMessage(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithMessageResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowDeleteCommand originalCommandResult = actualWithMessageResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.flowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithMessageResult.outcome());
    assertTrue(actualWithMessageResult.isLastPhysicalFlow());
    assertTrue(actualWithMessageResult.isSpecificationUnused());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withMessage(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withMessage(String)"
  })
  void testWithMessageWithValue() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("42");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithMessageResult =
        immutablePhysicalFlowDeleteCommandResponse.withMessage("42");

    // Assert
    assertSame(immutablePhysicalFlowDeleteCommandResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withMessage(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommandResponse#withMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withMessage(String) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withMessage(String)"
  })
  void testWithMessageWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithMessageResult =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .withMessage("42");

    // Assert
    EntityReference entityReferenceResult = actualWithMessageResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowDeleteCommand originalCommandResult = actualWithMessageResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.flowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithMessageResult.outcome());
    assertTrue(actualWithMessageResult.isLastPhysicalFlow());
    assertTrue(actualWithMessageResult.isSpecificationUnused());
  }

  /**
   * Test {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withOriginalCommand(PhysicalFlowDeleteCommand)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withOriginalCommand(PhysicalFlowDeleteCommand)}
   */
  @Test
  @DisplayName("Test withOriginalCommand(PhysicalFlowDeleteCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withOriginalCommand(PhysicalFlowDeleteCommand)"
  })
  void testWithOriginalCommand() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithOriginalCommandResult =
        immutablePhysicalFlowDeleteCommandResponse.withOriginalCommand(
            ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build());

    // Assert
    assertEquals(immutablePhysicalFlowDeleteCommandResponse, actualWithOriginalCommandResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withOutcome(CommandOutcome)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withOutcome(CommandOutcome)}
   */
  @Test
  @DisplayName("Test withOutcome(CommandOutcome)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withOutcome(CommandOutcome)"
  })
  void testWithOutcome() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    ImmutablePhysicalFlowDeleteCommandResponse immutablePhysicalFlowDeleteCommandResponse =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithOutcomeResult =
        immutablePhysicalFlowDeleteCommandResponse.withOutcome(CommandOutcome.SUCCESS);

    // Assert
    assertSame(immutablePhysicalFlowDeleteCommandResponse, actualWithOutcomeResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#withOutcome(CommandOutcome)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommandResponse#withOutcome(CommandOutcome)}
   */
  @Test
  @DisplayName(
      "Test withOutcome(CommandOutcome); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommandResponse ImmutablePhysicalFlowDeleteCommandResponse.withOutcome(CommandOutcome)"
  })
  void testWithOutcome_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualWithOutcomeResult =
        messageResult
            .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
            .outcome(CommandOutcome.FAILURE)
            .build()
            .withOutcome(CommandOutcome.SUCCESS);

    // Assert
    EntityReference entityReferenceResult = actualWithOutcomeResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowDeleteCommand originalCommandResult = actualWithOutcomeResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.flowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithOutcomeResult.outcome());
    assertTrue(actualWithOutcomeResult.isLastPhysicalFlow());
    assertTrue(actualWithOutcomeResult.isSpecificationUnused());
  }
}
