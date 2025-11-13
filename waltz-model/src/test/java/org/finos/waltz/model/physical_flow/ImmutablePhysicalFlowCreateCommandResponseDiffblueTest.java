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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommandResponse.Json;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowCreateCommandResponseDiffblueTest {
  /**
   * Test Builder {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse.Builder#build()}
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse.Builder#message(String)}
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse.Builder#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.Builder.build()",
    "ImmutablePhysicalFlowCreateCommandResponse.Builder ImmutablePhysicalFlowCreateCommandResponse.Builder.message(String)",
    "ImmutablePhysicalFlowCreateCommandResponse.Builder ImmutablePhysicalFlowCreateCommandResponse.Builder.outcome(CommandOutcome)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualBuilderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualMessageResult =
        actualBuilderResult.entityReference(entityReference).message("Not all who wander are lost");
    Optional<String> message = Optional.of("42");
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualMessageResult2 =
        actualMessageResult.message(message);
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();
    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);
    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");
    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);
    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());
    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");
    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand originalCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();
    ImmutablePhysicalFlowCreateCommandResponse actualImmutablePhysicalFlowCreateCommandResponse =
        actualMessageResult2
            .originalCommand(originalCommand)
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Assert
    assertEquals(
        CommandOutcome.SUCCESS, actualImmutablePhysicalFlowCreateCommandResponse.outcome());
    assertSame(entityReference, actualImmutablePhysicalFlowCreateCommandResponse.entityReference());
    assertSame(originalCommand, actualImmutablePhysicalFlowCreateCommandResponse.originalCommand());
  }

  /**
   * Test Builder {@link
   * ImmutablePhysicalFlowCreateCommandResponse.Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommandResponse.Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse.Builder ImmutablePhysicalFlowCreateCommandResponse.Builder.entityReference(EntityReference)"
  })
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    // Act
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualEntityReferenceResult =
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
   * Test Builder {@link
   * ImmutablePhysicalFlowCreateCommandResponse.Builder#from(PhysicalFlowCreateCommandResponse)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommandResponse.Builder#from(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowCreateCommandResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse.Builder ImmutablePhysicalFlowCreateCommandResponse.Builder.from(PhysicalFlowCreateCommandResponse)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult3 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult3
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult4 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult4
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse instance =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowCreateCommandResponse actualImmutablePhysicalFlowCreateCommandResponse =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowCreateCommandResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#message(Optional)} with
   * {@code Optional}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommandResponse.Builder#message(Optional)}
   */
  @Test
  @DisplayName("Test Builder message(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse.Builder ImmutablePhysicalFlowCreateCommandResponse.Builder.message(Optional)"
  })
  void testBuilderMessageWithOptional() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();
    Optional<String> message = Optional.of("42");

    // Act
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualMessageResult =
        builderResult.message(message);

    // Assert
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link
   * ImmutablePhysicalFlowCreateCommandResponse.Builder#originalCommand(PhysicalFlowCreateCommand)}.
   *
   * <ul>
   *   <li>When {@link ImmutablePhysicalFlowCreateCommand.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommandResponse.Builder#originalCommand(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder originalCommand(PhysicalFlowCreateCommand); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse.Builder ImmutablePhysicalFlowCreateCommandResponse.Builder.originalCommand(PhysicalFlowCreateCommand)"
  })
  void testBuilderOriginalCommand_whenJson_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    // Act
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualOriginalCommandResult =
        builderResult.originalCommand(new ImmutablePhysicalFlowCreateCommand.Json());

    // Assert
    assertSame(builderResult, actualOriginalCommandResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalFlowCreateCommandResponse#copyOf(PhysicalFlowCreateCommandResponse)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommandResponse#copyOf(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalFlowCreateCommandResponse); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.copyOf(PhysicalFlowCreateCommandResponse)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse instance =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualCopyOfResult =
        ImmutablePhysicalFlowCreateCommandResponse.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowCreateCommand originalCommandResult = actualCopyOfResult.originalCommand();
    assertTrue(originalCommandResult.flowAttributes() instanceof ImmutableFlowAttributes);
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowCreateCommand);
    assertTrue(originalCommandResult.specification() instanceof ImmutablePhysicalSpecification);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.logicalFlowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertTrue(originalCommandResult.dataTypeIds().isEmpty());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}, and {@link
   * ImmutablePhysicalFlowCreateCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult4 =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult2 =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .message("Not all who wander are lost");

    Builder builderResult5 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult5
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult6
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse2 =
        messageResult2
            .originalCommand(
                addAllDataTypeIdsResult2
                    .specification(
                        nameResult4
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalFlowCreateCommandResponse, immutablePhysicalFlowCreateCommandResponse2);
    assertEquals(
        immutablePhysicalFlowCreateCommandResponse.hashCode(),
        immutablePhysicalFlowCreateCommandResponse2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}, and {@link
   * ImmutablePhysicalFlowCreateCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalFlowCreateCommandResponse, immutablePhysicalFlowCreateCommandResponse);
    int expectedHashCodeResult = immutablePhysicalFlowCreateCommandResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowCreateCommandResponse.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult4 =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult2 =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .message("Not all who wander are lost");

    Builder builderResult5 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult5
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult6
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowCreateCommandResponse,
        messageResult2
            .originalCommand(
                addAllDataTypeIdsResult2
                    .specification(
                        nameResult4
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("By");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult4 =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult2 =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .message("Not all who wander are lost");

    Builder builderResult5 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult5
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult6
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowCreateCommandResponse,
        messageResult2
            .originalCommand(
                addAllDataTypeIdsResult2
                    .specification(
                        nameResult4
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();
    builderResult.addDataTypeIds(1L);

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand originalCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult3 =
        ImmutablePhysicalFlowCreateCommandResponse.builder();
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .message("Not all who wander are lost")
            .originalCommand(originalCommand)
            .outcome(CommandOutcome.SUCCESS)
            .build();

    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult4 =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .message("Not all who wander are lost");

    Builder builderResult5 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult5
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult6
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowCreateCommandResponse,
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult2
                    .specification(
                        nameResult4
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.FAILURE)
            .build();

    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult4 =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult2 =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .message("Not all who wander are lost");

    Builder builderResult5 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult5
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult6
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowCreateCommandResponse,
        messageResult2
            .originalCommand(
                addAllDataTypeIdsResult2
                    .specification(
                        nameResult4
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build(),
        "Different type to ImmutablePhysicalFlowCreateCommandResponse");
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return outcome is {@code SUCCESS}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return outcome is 'SUCCESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.fromJson(Json)"
  })
  void testFromJson_thenReturnOutcomeIsSuccess() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    json.setOriginalCommand(
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build());
    json.setOutcome(CommandOutcome.SUCCESS);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowCreateCommandResponse.fromJson(json);

    // Assert
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    PhysicalFlowCreateCommand expectedOriginalCommandResult = json.originalCommand;
    assertSame(expectedOriginalCommandResult, actualFromJsonResult.originalCommand());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Message is {@code null}.
   *   <li>Then return outcome is {@code SUCCESS}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Message is 'null'; then return outcome is 'SUCCESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.fromJson(Json)"
  })
  void testFromJson_whenJsonMessageIsNull_thenReturnOutcomeIsSuccess() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    json.setOriginalCommand(
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build());
    json.setOutcome(CommandOutcome.SUCCESS);
    json.setMessage(null);

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowCreateCommandResponse.fromJson(json);

    // Assert
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    PhysicalFlowCreateCommand expectedOriginalCommandResult = json.originalCommand;
    assertSame(expectedOriginalCommandResult, actualFromJsonResult.originalCommand());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Outcome is {@code null}.
   *   <li>Then return outcome is {@code SUCCESS}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Outcome is 'null'; then return outcome is 'SUCCESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.fromJson(Json)"
  })
  void testFromJson_whenJsonOutcomeIsNull_thenReturnOutcomeIsSuccess() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    json.setOriginalCommand(
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build());
    json.setOutcome(null);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowCreateCommandResponse.fromJson(json);

    // Assert
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    PhysicalFlowCreateCommand expectedOriginalCommandResult = json.originalCommand;
    assertSame(expectedOriginalCommandResult, actualFromJsonResult.originalCommand());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#entityReference()}
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#outcome()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutablePhysicalFlowCreateCommandResponse.entityReference()",
    "CommandOutcome ImmutablePhysicalFlowCreateCommandResponse.outcome()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    EntityReference actualEntityReferenceResult =
        immutablePhysicalFlowCreateCommandResponse.entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(CommandOutcome.SUCCESS, immutablePhysicalFlowCreateCommandResponse.outcome());
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
  @MethodsUnderTest({"PhysicalFlowCreateCommand Json.originalCommand()"})
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
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#message()}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#message()}
   */
  @Test
  @DisplayName("Test message(); then return get() is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlowCreateCommandResponse.message()"})
  void testMessage_thenReturnGetIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    Optional<String> actualMessageResult =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .message();

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.get());
    assertTrue(actualMessageResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#originalCommand()}.
   *
   * <ul>
   *   <li>Then flowAttributes return {@link ImmutableFlowAttributes}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#originalCommand()}
   */
  @Test
  @DisplayName("Test originalCommand(); then flowAttributes return ImmutableFlowAttributes")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommand ImmutablePhysicalFlowCreateCommandResponse.originalCommand()"
  })
  void testOriginalCommand_thenFlowAttributesReturnImmutableFlowAttributes() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    PhysicalFlowCreateCommand actualOriginalCommandResult =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .originalCommand();

    // Assert
    assertTrue(actualOriginalCommandResult.flowAttributes() instanceof ImmutableFlowAttributes);
    assertTrue(actualOriginalCommandResult instanceof ImmutablePhysicalFlowCreateCommand);
    assertTrue(
        actualOriginalCommandResult.specification() instanceof ImmutablePhysicalSpecification);
    assertEquals(1L, actualOriginalCommandResult.logicalFlowId());
    assertTrue(actualOriginalCommandResult.dataTypeIds().isEmpty());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalFlowCreateCommandResponse.toString()"})
  void testToString_thenReturnAString() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertEquals(
        "PhysicalFlowCreateCommandResponse{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, originalCommand=PhysicalFlowCreateCommand{specification=PhysicalSpecification{id=1,"
            + " isRemoved=false, externalId=42, name=Name, provenance=Provenance, lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, isReadOnly=false, owningEntity=EntityReference{kind=ALL, id=1, entityLife"
            + "cycleStatus=ACTIVE}, format=42, kind=ALL}, logicalFlowId=1, flowAttributes=FlowAttributes{externalId=42,"
            + " name=Name, transport=42, frequency=42, criticality=42, basisOffset=1}, dataTypeIds=[]}, outcome=SUCCESS,"
            + " message=Not all who wander are lost}",
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommandResponse#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualWithEntityReferenceResult =
        immutablePhysicalFlowCreateCommandResponse.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowCreateCommandResponse, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#withMessage(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName("Test withMessage(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("42");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualWithMessageResult =
        immutablePhysicalFlowCreateCommandResponse.withMessage(optional);

    // Assert
    assertSame(immutablePhysicalFlowCreateCommandResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#withMessage(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName(
      "Test withMessage(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualWithMessageResult =
        immutablePhysicalFlowCreateCommandResponse.withMessage(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithMessageResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowCreateCommand originalCommandResult = actualWithMessageResult.originalCommand();
    assertTrue(originalCommandResult.flowAttributes() instanceof ImmutableFlowAttributes);
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowCreateCommand);
    assertTrue(originalCommandResult.specification() instanceof ImmutablePhysicalSpecification);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.logicalFlowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithMessageResult.outcome());
    assertTrue(originalCommandResult.dataTypeIds().isEmpty());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#withMessage(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.withMessage(String)"
  })
  void testWithMessageWithValue() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("42");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualWithMessageResult =
        immutablePhysicalFlowCreateCommandResponse.withMessage("42");

    // Assert
    assertSame(immutablePhysicalFlowCreateCommandResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#withMessage(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommandResponse#withMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withMessage(String) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.withMessage(String)"
  })
  void testWithMessageWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualWithMessageResult =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .withMessage("42");

    // Assert
    EntityReference entityReferenceResult = actualWithMessageResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowCreateCommand originalCommandResult = actualWithMessageResult.originalCommand();
    assertTrue(originalCommandResult.flowAttributes() instanceof ImmutableFlowAttributes);
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowCreateCommand);
    assertTrue(originalCommandResult.specification() instanceof ImmutablePhysicalSpecification);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.logicalFlowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithMessageResult.outcome());
    assertTrue(originalCommandResult.dataTypeIds().isEmpty());
  }

  /**
   * Test {@link
   * ImmutablePhysicalFlowCreateCommandResponse#withOriginalCommand(PhysicalFlowCreateCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommandResponse#withOriginalCommand(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test withOriginalCommand(PhysicalFlowCreateCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.withOriginalCommand(PhysicalFlowCreateCommand)"
  })
  void testWithOriginalCommand_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder builderResult4 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult4
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult5 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult5
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand value =
        addAllDataTypeIdsResult2
            .specification(
                nameResult4
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualWithOriginalCommandResult =
        immutablePhysicalFlowCreateCommandResponse.withOriginalCommand(value);

    // Assert
    EntityReference entityReferenceResult = actualWithOriginalCommandResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithOriginalCommandResult.outcome());
    assertSame(value, actualWithOriginalCommandResult.originalCommand());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#withOutcome(CommandOutcome)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommandResponse#withOutcome(CommandOutcome)}
   */
  @Test
  @DisplayName("Test withOutcome(CommandOutcome)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommandResponse ImmutablePhysicalFlowCreateCommandResponse.withOutcome(CommandOutcome)"
  })
  void testWithOutcome() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
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
            .message("Not all who wander are lost");

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommandResponse immutablePhysicalFlowCreateCommandResponse =
        messageResult
            .originalCommand(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualWithOutcomeResult =
        immutablePhysicalFlowCreateCommandResponse.withOutcome(CommandOutcome.SUCCESS);

    // Assert
    assertSame(immutablePhysicalFlowCreateCommandResponse, actualWithOutcomeResult);
  }
}
