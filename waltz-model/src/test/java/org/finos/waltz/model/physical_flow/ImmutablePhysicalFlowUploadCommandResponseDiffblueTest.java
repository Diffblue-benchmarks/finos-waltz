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
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowParsed.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommandResponse.Json;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowUploadCommandResponseDiffblueTest {
  /**
   * Test Builder {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse.Builder#build()}
   *   <li>{@link
   *       ImmutablePhysicalFlowUploadCommandResponse.Builder#entityReference(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse.Builder#message(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse.Builder#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.Builder.build()",
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.entityReference(EntityReference)",
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.message(String)",
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.outcome(CommandOutcome)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualBuilderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualMessageResult =
        actualBuilderResult.entityReference(entityReference).message("Not all who wander are lost");
    Optional<String> message = Optional.of("42");
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualMessageResult2 =
        actualMessageResult.message(message);
    ImmutablePhysicalFlowUploadCommand originalCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualOutcomeResult =
        actualMessageResult2.originalCommand(originalCommand).outcome(CommandOutcome.SUCCESS);
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));
    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));
    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");
    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");
    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed parsedFlow =
        targetResult.transport(TransportKindValue.of("42")).build();
    ImmutablePhysicalFlowUploadCommandResponse actualImmutablePhysicalFlowUploadCommandResponse =
        actualOutcomeResult.parsedFlow(parsedFlow).build();

    // Assert
    assertEquals(
        CommandOutcome.SUCCESS, actualImmutablePhysicalFlowUploadCommandResponse.outcome());
    assertTrue(actualImmutablePhysicalFlowUploadCommandResponse.errors().isEmpty());
    assertSame(entityReference, actualImmutablePhysicalFlowUploadCommandResponse.entityReference());
    assertSame(parsedFlow, actualImmutablePhysicalFlowUploadCommandResponse.parsedFlow());
    assertSame(originalCommand, actualImmutablePhysicalFlowUploadCommandResponse.originalCommand());
  }

  /**
   * Test Builder {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#errors(Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#errors(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder errors(Map); given 'Key'; when HashMap() 'Key' is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.errors(Map)"
  })
  void testBuilderErrors_givenKey_whenHashMapKeyIs42_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("Key", "42");

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualErrorsResult =
        builderResult.errors(entries);

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#errors(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#errors(Map)}
   */
  @Test
  @DisplayName("Test Builder errors(Map); when HashMap(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.errors(Map)"
  })
  void testBuilderErrors_whenHashMap_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualErrorsResult =
        builderResult.errors(new HashMap<>());

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommandResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.from(PhysicalFlowUploadCommandResponse)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse instance =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowUploadCommandResponse actualImmutablePhysicalFlowUploadCommandResponse =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowUploadCommandResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}.
   *
   * <ul>
   *   <li>Given {@code instance}.
   *   <li>When builder Errors {@code instance} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalFlowUploadCommandResponse); given 'instance'; when builder Errors 'instance' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.from(PhysicalFlowUploadCommandResponse)"
  })
  void testBuilderFrom_givenInstance_whenBuilderErrorsInstanceIs42() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();
    builderResult2.putErrors("instance", "42");

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse instance =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowUploadCommandResponse actualImmutablePhysicalFlowUploadCommandResponse =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowUploadCommandResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#message(Optional)} with
   * {@code Optional}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#message(Optional)}
   */
  @Test
  @DisplayName("Test Builder message(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.message(Optional)"
  })
  void testBuilderMessageWithOptional() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();
    Optional<String> message = Optional.of("42");

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualMessageResult =
        builderResult.message(message);

    // Assert
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#originalCommand(PhysicalFlowUploadCommand)}.
   *
   * <ul>
   *   <li>When {@link ImmutablePhysicalFlowUploadCommand.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#originalCommand(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder originalCommand(PhysicalFlowUploadCommand); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.originalCommand(PhysicalFlowUploadCommand)"
  })
  void testBuilderOriginalCommand_whenJson_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualOriginalCommandResult =
        builderResult.originalCommand(new ImmutablePhysicalFlowUploadCommand.Json());

    // Assert
    assertSame(builderResult, actualOriginalCommandResult);
  }

  /**
   * Test Builder {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#parsedFlow(PhysicalFlowParsed)}.
   *
   * <ul>
   *   <li>When {@link ImmutablePhysicalFlowParsed.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#parsedFlow(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName(
      "Test Builder parsedFlow(PhysicalFlowParsed); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.parsedFlow(PhysicalFlowParsed)"
  })
  void testBuilderParsedFlow_whenJson_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualParsedFlowResult =
        builderResult.parsedFlow(new ImmutablePhysicalFlowParsed.Json());

    // Assert
    assertSame(builderResult, actualParsedFlowResult);
  }

  /**
   * Test Builder {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putAllErrors(Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#putAllErrors(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder putAllErrors(Map); given 'Key'; when HashMap() 'Key' is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.putAllErrors(Map)"
  })
  void testBuilderPutAllErrors_givenKey_whenHashMapKeyIs42_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("Key", "42");

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualPutAllErrorsResult =
        builderResult.putAllErrors(entries);

    // Assert
    assertSame(builderResult, actualPutAllErrorsResult);
  }

  /**
   * Test Builder {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putAllErrors(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#putAllErrors(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllErrors(Map); when HashMap(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.putAllErrors(Map)"
  })
  void testBuilderPutAllErrors_whenHashMap_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualPutAllErrorsResult =
        builderResult.putAllErrors(new HashMap<>());

    // Assert
    assertSame(builderResult, actualPutAllErrorsResult);
  }

  /**
   * Test Builder {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putErrors(Entry)} with
   * {@code entry}.
   *
   * <ul>
   *   <li>When {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code Key} and
   *       {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#putErrors(Entry)}
   */
  @Test
  @DisplayName(
      "Test Builder putErrors(Entry) with 'entry'; when SimpleEntry(Object, Object) with 'Key' and '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.putErrors(Entry)"
  })
  void testBuilderPutErrorsWithEntry_whenSimpleEntryWithKeyAnd42_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualPutErrorsResult =
        builderResult.putErrors(new SimpleEntry<>("Key", "42"));

    // Assert
    assertSame(builderResult, actualPutErrorsResult);
  }

  /**
   * Test Builder {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putErrors(String,
   * String)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse.Builder#putErrors(String, String)}
   */
  @Test
  @DisplayName(
      "Test Builder putErrors(String, String) with 'key', 'value'; when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse.Builder ImmutablePhysicalFlowUploadCommandResponse.Builder.putErrors(String, String)"
  })
  void testBuilderPutErrorsWithKeyValue_whenKey_thenReturnBuilder() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualPutErrorsResult =
        builderResult.putErrors("Key", "42");

    // Assert
    assertSame(builderResult, actualPutErrorsResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalFlowUploadCommandResponse#copyOf(PhysicalFlowUploadCommandResponse)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse#copyOf(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalFlowUploadCommandResponse); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.copyOf(PhysicalFlowUploadCommandResponse)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse instance =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualCopyOfResult =
        ImmutablePhysicalFlowUploadCommandResponse.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualCopyOfResult.parsedFlow() instanceof ImmutablePhysicalFlowParsed);
    assertTrue(actualCopyOfResult.originalCommand() instanceof ImmutablePhysicalFlowUploadCommand);
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertTrue(actualCopyOfResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}, and {@link
   * ImmutablePhysicalFlowUploadCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult2 =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult2 =
        messageResult2
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse2 =
        outcomeResult2
            .parsedFlow(targetResult2.transport(TransportKindValue.of("42")).build())
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalFlowUploadCommandResponse, immutablePhysicalFlowUploadCommandResponse2);
    assertEquals(
        immutablePhysicalFlowUploadCommandResponse.hashCode(),
        immutablePhysicalFlowUploadCommandResponse2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}, and {@link
   * ImmutablePhysicalFlowUploadCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalFlowUploadCommandResponse, immutablePhysicalFlowUploadCommandResponse);
    int expectedHashCodeResult = immutablePhysicalFlowUploadCommandResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowUploadCommandResponse.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder criticalityResult =
        ImmutablePhysicalFlowParsed.builder().basisOffset(1).criticality(null);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult2 =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult2 =
        messageResult2
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowUploadCommandResponse,
        outcomeResult2
            .parsedFlow(targetResult2.transport(TransportKindValue.of("42")).build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();
    builderResult.putErrors("Source", "42");

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult2 =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult2 =
        messageResult2
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowUploadCommandResponse,
        outcomeResult2
            .parsedFlow(targetResult2.transport(TransportKindValue.of("42")).build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult2 =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult2 =
        messageResult2
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowUploadCommandResponse,
        outcomeResult2
            .parsedFlow(targetResult2.transport(TransportKindValue.of("42")).build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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
            .message("Source");

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult2 =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult2 =
        messageResult2
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowUploadCommandResponse,
        outcomeResult2
            .parsedFlow(targetResult2.transport(TransportKindValue.of("42")).build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Source")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult2 =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult2 =
        messageResult2
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowUploadCommandResponse,
        outcomeResult2
            .parsedFlow(targetResult2.transport(TransportKindValue.of("42")).build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.FAILURE);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult2 =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult2 =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult2 =
        messageResult2
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowUploadCommandResponse,
        outcomeResult2
            .parsedFlow(targetResult2.transport(TransportKindValue.of("42")).build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
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
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommandResponse.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
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
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build(),
        "Different type to ImmutablePhysicalFlowUploadCommandResponse");
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code originalCommand} is {@code 42}.
   *   <li>Then return errors size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap() 'originalCommand' is '42'; then return errors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.fromJson(Json)"
  })
  void testFromJson_givenHashMapOriginalCommandIs42_thenReturnErrorsSizeIsOne() {
    // Arrange
    HashMap<String, String> errors = new HashMap<>();
    errors.put("originalCommand", "42");

    Json json = new Json();
    json.setOriginalCommand(new ImmutablePhysicalFlowUploadCommand.Json());
    json.setOutcome(CommandOutcome.SUCCESS);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);
    json.setEntityReference(null);
    json.setParsedFlow(new ImmutablePhysicalFlowParsed.Json());
    json.setErrors(errors);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommandResponse.fromJson(json);

    // Assert
    Map<String, String> errorsResult = actualFromJsonResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals("42", errorsResult.get("originalCommand"));
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code outcome} is {@code originalCommand}.
   *   <li>Then return errors is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap() 'outcome' is 'originalCommand'; then return errors is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.fromJson(Json)"
  })
  void testFromJson_givenHashMapOutcomeIsOriginalCommand_thenReturnErrorsIsHashMap() {
    // Arrange
    HashMap<String, String> errors = new HashMap<>();
    errors.put("outcome", "originalCommand");
    errors.put("originalCommand", "42");

    Json json = new Json();
    json.setOriginalCommand(new ImmutablePhysicalFlowUploadCommand.Json());
    json.setOutcome(CommandOutcome.SUCCESS);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);
    json.setEntityReference(null);
    json.setParsedFlow(new ImmutablePhysicalFlowParsed.Json());
    json.setErrors(errors);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommandResponse.fromJson(json);

    // Assert
    assertEquals(errors, actualFromJsonResult.errors());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Json} (default constructor) Message is {@code null}.
   *   <li>Then parsedFlow return {@link ImmutablePhysicalFlowParsed.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap(); when Json (default constructor) Message is 'null'; then parsedFlow return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.fromJson(Json)"
  })
  void testFromJson_givenHashMap_whenJsonMessageIsNull_thenParsedFlowReturnJson() {
    // Arrange
    Json json = new Json();
    ImmutablePhysicalFlowUploadCommand.Json originalCommand =
        new ImmutablePhysicalFlowUploadCommand.Json();
    json.setOriginalCommand(originalCommand);
    json.setOutcome(CommandOutcome.SUCCESS);
    json.setMessage(null);
    json.setEntityReference(null);
    ImmutablePhysicalFlowParsed.Json parsedFlow = new ImmutablePhysicalFlowParsed.Json();
    json.setParsedFlow(parsedFlow);
    json.setErrors(new HashMap<>());

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommandResponse.fromJson(json);

    // Assert
    PhysicalFlowParsed parsedFlowResult = actualFromJsonResult.parsedFlow();
    assertTrue(parsedFlowResult instanceof ImmutablePhysicalFlowParsed.Json);
    PhysicalFlowUploadCommand originalCommandResult = actualFromJsonResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowUploadCommand.Json);
    assertNull(actualFromJsonResult.entityReference());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedFlow, parsedFlowResult);
    assertSame(originalCommand, originalCommandResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Json} (default constructor) OriginalCommand is {@link
   *       ImmutablePhysicalFlowUploadCommand.Json} (default constructor).
   *   <li>Then parsedFlow return {@link ImmutablePhysicalFlowParsed.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap(); when Json (default constructor) OriginalCommand is Json (default constructor); then parsedFlow return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.fromJson(Json)"
  })
  void testFromJson_givenHashMap_whenJsonOriginalCommandIsJson_thenParsedFlowReturnJson() {
    // Arrange
    Json json = new Json();
    ImmutablePhysicalFlowUploadCommand.Json originalCommand =
        new ImmutablePhysicalFlowUploadCommand.Json();
    json.setOriginalCommand(originalCommand);
    json.setOutcome(CommandOutcome.SUCCESS);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);
    json.setEntityReference(null);
    ImmutablePhysicalFlowParsed.Json parsedFlow = new ImmutablePhysicalFlowParsed.Json();
    json.setParsedFlow(parsedFlow);
    json.setErrors(new HashMap<>());

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommandResponse.fromJson(json);

    // Assert
    PhysicalFlowParsed parsedFlowResult = actualFromJsonResult.parsedFlow();
    assertTrue(parsedFlowResult instanceof ImmutablePhysicalFlowParsed.Json);
    PhysicalFlowUploadCommand originalCommandResult = actualFromJsonResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowUploadCommand.Json);
    assertNull(actualFromJsonResult.entityReference());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedFlow, parsedFlowResult);
    assertSame(originalCommand, originalCommandResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Json} (default constructor) Outcome is {@code null}.
   *   <li>Then parsedFlow return {@link ImmutablePhysicalFlowParsed.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap(); when Json (default constructor) Outcome is 'null'; then parsedFlow return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.fromJson(Json)"
  })
  void testFromJson_givenHashMap_whenJsonOutcomeIsNull_thenParsedFlowReturnJson() {
    // Arrange
    Json json = new Json();
    ImmutablePhysicalFlowUploadCommand.Json originalCommand =
        new ImmutablePhysicalFlowUploadCommand.Json();
    json.setOriginalCommand(originalCommand);
    json.setOutcome(null);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);
    json.setEntityReference(null);
    ImmutablePhysicalFlowParsed.Json parsedFlow = new ImmutablePhysicalFlowParsed.Json();
    json.setParsedFlow(parsedFlow);
    json.setErrors(new HashMap<>());

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommandResponse.fromJson(json);

    // Assert
    PhysicalFlowParsed parsedFlowResult = actualFromJsonResult.parsedFlow();
    assertTrue(parsedFlowResult instanceof ImmutablePhysicalFlowParsed.Json);
    PhysicalFlowUploadCommand originalCommandResult = actualFromJsonResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowUploadCommand.Json);
    assertNull(actualFromJsonResult.entityReference());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedFlow, parsedFlowResult);
    assertSame(originalCommand, originalCommandResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutablePhysicalFlowUploadCommand.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Errors is {@code null}.
   *   <li>Then parsedFlow return {@link ImmutablePhysicalFlowParsed.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Errors is 'null'; then parsedFlow return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonErrorsIsNull_thenParsedFlowReturnJson() {
    // Arrange
    Json json = new Json();
    ImmutablePhysicalFlowUploadCommand.Json originalCommand =
        new ImmutablePhysicalFlowUploadCommand.Json();
    json.setOriginalCommand(originalCommand);
    json.setOutcome(CommandOutcome.SUCCESS);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);
    json.setEntityReference(null);
    ImmutablePhysicalFlowParsed.Json parsedFlow = new ImmutablePhysicalFlowParsed.Json();
    json.setParsedFlow(parsedFlow);
    json.setErrors(null);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommandResponse.fromJson(json);

    // Assert
    PhysicalFlowParsed parsedFlowResult = actualFromJsonResult.parsedFlow();
    assertTrue(parsedFlowResult instanceof ImmutablePhysicalFlowParsed.Json);
    PhysicalFlowUploadCommand originalCommandResult = actualFromJsonResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowUploadCommand.Json);
    assertNull(actualFromJsonResult.entityReference());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedFlow, parsedFlowResult);
    assertSame(originalCommand, originalCommandResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.fromJson(Json)"
  })
  void testFromJson_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Json json = new Json();
    json.setOriginalCommand(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
    json.setOutcome(CommandOutcome.SUCCESS);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    json.setParsedFlow(targetResult.transport(TransportKindValue.of("42")).build());
    json.setErrors(new HashMap<>());

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommandResponse.fromJson(json);

    // Assert
    EntityReference entityReferenceResult = actualFromJsonResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualFromJsonResult.parsedFlow() instanceof ImmutablePhysicalFlowParsed);
    assertTrue(
        actualFromJsonResult.originalCommand() instanceof ImmutablePhysicalFlowUploadCommand);
    assertSame(json.entityReference, entityReferenceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#entityReference()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#errors()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#outcome()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#parsedFlow()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutablePhysicalFlowUploadCommandResponse.entityReference()",
    "Map ImmutablePhysicalFlowUploadCommandResponse.errors()",
    "CommandOutcome ImmutablePhysicalFlowUploadCommandResponse.outcome()",
    "PhysicalFlowParsed ImmutablePhysicalFlowUploadCommandResponse.parsedFlow()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act
    EntityReference actualEntityReferenceResult =
        immutablePhysicalFlowUploadCommandResponse.entityReference();
    Map<String, String> actualErrorsResult = immutablePhysicalFlowUploadCommandResponse.errors();
    CommandOutcome actualOutcomeResult = immutablePhysicalFlowUploadCommandResponse.outcome();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(
        immutablePhysicalFlowUploadCommandResponse.parsedFlow()
            instanceof ImmutablePhysicalFlowParsed);
    assertEquals(CommandOutcome.SUCCESS, actualOutcomeResult);
    assertTrue(actualErrorsResult.isEmpty());
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
   * Test Json {@link Json#errors()}.
   *
   * <p>Method under test: {@link Json#errors()}
   */
  @Test
  @DisplayName("Test Json errors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Json.errors()"})
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errors());
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
    assertNull(actualJson.parsedFlow);
    assertNull(actualJson.originalCommand);
    assertFalse(actualJson.message.isPresent());
    assertTrue(actualJson.errors.isEmpty());
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
  @MethodsUnderTest({"PhysicalFlowUploadCommand Json.originalCommand()"})
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
   * Test Json {@link Json#parsedFlow()}.
   *
   * <p>Method under test: {@link Json#parsedFlow()}
   */
  @Test
  @DisplayName("Test Json parsedFlow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlowParsed Json.parsedFlow()"})
  void testJsonParsedFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parsedFlow());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#message()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#message()}
   */
  @Test
  @DisplayName("Test message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlowUploadCommandResponse.message()"})
  void testMessage() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Optional<String> actualMessageResult =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build()
            .message();

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.get());
    assertTrue(actualMessageResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#originalCommand()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#originalCommand()}
   */
  @Test
  @DisplayName("Test originalCommand()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommandResponse.originalCommand()"
  })
  void testOriginalCommand() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    PhysicalFlowUploadCommand actualOriginalCommandResult =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build()
            .originalCommand();

    // Assert
    assertTrue(actualOriginalCommandResult instanceof ImmutablePhysicalFlowUploadCommand);
    assertEquals("42", actualOriginalCommandResult.externalId());
    assertEquals("42", actualOriginalCommandResult.specExternalId());
    assertEquals("Basis Offset", actualOriginalCommandResult.basisOffset());
    assertEquals("Criticality", actualOriginalCommandResult.criticality());
    assertEquals("Data Type", actualOriginalCommandResult.dataType());
    assertEquals("Format", actualOriginalCommandResult.format());
    assertEquals("Frequency", actualOriginalCommandResult.frequency());
    assertEquals("Name", actualOriginalCommandResult.name());
    assertEquals("Owner", actualOriginalCommandResult.owner());
    assertEquals("Source", actualOriginalCommandResult.source());
    assertEquals("Spec Description", actualOriginalCommandResult.specDescription());
    assertEquals("Target", actualOriginalCommandResult.target());
    assertEquals(
        "The characteristics of someone or something", actualOriginalCommandResult.description());
    assertEquals("Transport", actualOriginalCommandResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalFlowUploadCommandResponse.toString()"})
  void testToString() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertEquals(
        "PhysicalFlowUploadCommandResponse{originalCommand=PhysicalFlowUploadCommand{source=Source, target=Target,"
            + " owner=Owner, name=Name, format=Format, specDescription=Spec Description, specExternalId=42,"
            + " basisOffset=Basis Offset, criticality=Criticality, description=The characteristics of someone or"
            + " something, externalId=42, frequency=Frequency, transport=Transport, dataType=Data Type}, outcome=SUCCESS,"
            + " message=Not all who wander are lost, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, parsedFlow=PhysicalFlowParsed{source=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " target=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, owner=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, format=42, name=Name, specDescription=Spec Description,"
            + " specExternalId=42, basisOffset=1, criticality=42, description=The characteristics of someone or"
            + " something, externalId=42, frequency=42, transport=42, dataType=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}}, errors={}}",
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualWithEntityReferenceResult =
        immutablePhysicalFlowUploadCommandResponse.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowUploadCommandResponse, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#withMessage(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName("Test withMessage(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualWithMessageResult =
        immutablePhysicalFlowUploadCommandResponse.withMessage(optional);

    // Assert
    assertSame(immutablePhysicalFlowUploadCommandResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#withMessage(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then parsedFlow dataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName(
      "Test withMessage(Optional) with 'optional'; then parsedFlow dataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional_thenParsedFlowDataTypeReturnImmutableEntityReference() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    PhysicalFlowParsed parsedFlowResult =
        immutablePhysicalFlowUploadCommandResponse.withMessage(optional).parsedFlow();
    assertTrue(parsedFlowResult.dataType() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.owner() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.source() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.target() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult instanceof ImmutablePhysicalFlowParsed);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#withMessage(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withMessage(String)"
  })
  void testWithMessageWithValue() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualWithMessageResult =
        immutablePhysicalFlowUploadCommandResponse.withMessage("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommandResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#withMessage(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then parsedFlow dataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommandResponse#withMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withMessage(String) with 'value'; then parsedFlow dataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withMessage(String)"
  })
  void testWithMessageWithValue_thenParsedFlowDataTypeReturnImmutableEntityReference() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    PhysicalFlowParsed parsedFlowResult =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build()
            .withMessage("42")
            .parsedFlow();
    assertTrue(parsedFlowResult.dataType() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.owner() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.source() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.target() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult instanceof ImmutablePhysicalFlowParsed);
  }

  /**
   * Test {@link
   * ImmutablePhysicalFlowUploadCommandResponse#withOriginalCommand(PhysicalFlowUploadCommand)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse#withOriginalCommand(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test withOriginalCommand(PhysicalFlowUploadCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withOriginalCommand(PhysicalFlowUploadCommand)"
  })
  void testWithOriginalCommand() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualWithOriginalCommandResult =
        immutablePhysicalFlowUploadCommandResponse.withOriginalCommand(
            ImmutablePhysicalFlowUploadCommand.builder()
                .basisOffset("Basis Offset")
                .criticality("Criticality")
                .dataType("Data Type")
                .description("The characteristics of someone or something")
                .externalId("42")
                .format("Format")
                .frequency("Frequency")
                .name("Name")
                .owner("Owner")
                .source("Source")
                .specDescription("Spec Description")
                .specExternalId("42")
                .target("Target")
                .transport("Transport")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowUploadCommandResponse, actualWithOriginalCommandResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#withOutcome(CommandOutcome)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse#withOutcome(CommandOutcome)}
   */
  @Test
  @DisplayName("Test withOutcome(CommandOutcome)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withOutcome(CommandOutcome)"
  })
  void testWithOutcome() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualWithOutcomeResult =
        immutablePhysicalFlowUploadCommandResponse.withOutcome(CommandOutcome.SUCCESS);

    // Assert
    assertSame(immutablePhysicalFlowUploadCommandResponse, actualWithOutcomeResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#withOutcome(CommandOutcome)}.
   *
   * <ul>
   *   <li>Then parsedFlow dataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse#withOutcome(CommandOutcome)}
   */
  @Test
  @DisplayName(
      "Test withOutcome(CommandOutcome); then parsedFlow dataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withOutcome(CommandOutcome)"
  })
  void testWithOutcome_thenParsedFlowDataTypeReturnImmutableEntityReference() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.FAILURE);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    PhysicalFlowParsed parsedFlowResult =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build()
            .withOutcome(CommandOutcome.SUCCESS)
            .parsedFlow();
    assertTrue(parsedFlowResult.dataType() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.owner() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.source() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult.target() instanceof ImmutableEntityReference);
    assertTrue(parsedFlowResult instanceof ImmutablePhysicalFlowParsed);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#withParsedFlow(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommandResponse#withParsedFlow(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test withParsedFlow(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommandResponse ImmutablePhysicalFlowUploadCommandResponse.withParsedFlow(PhysicalFlowParsed)"
  })
  void testWithParsedFlow() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowUploadCommandResponse.builder();

    ImmutablePhysicalFlowUploadCommandResponse.Builder messageResult =
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

    ImmutablePhysicalFlowUploadCommandResponse.Builder outcomeResult =
        messageResult
            .originalCommand(
                ImmutablePhysicalFlowUploadCommand.builder()
                    .basisOffset("Basis Offset")
                    .criticality("Criticality")
                    .dataType("Data Type")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .format("Format")
                    .frequency("Frequency")
                    .name("Name")
                    .owner("Owner")
                    .source("Source")
                    .specDescription("Spec Description")
                    .specExternalId("42")
                    .target("Target")
                    .transport("Transport")
                    .build())
            .outcome(CommandOutcome.SUCCESS);

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowUploadCommandResponse immutablePhysicalFlowUploadCommandResponse =
        outcomeResult
            .parsedFlow(targetResult.transport(TransportKindValue.of("42")).build())
            .build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualWithParsedFlowResult =
        immutablePhysicalFlowUploadCommandResponse.withParsedFlow(
            targetResult2.transport(TransportKindValue.of("42")).build());

    // Assert
    assertEquals(immutablePhysicalFlowUploadCommandResponse, actualWithParsedFlowResult);
  }
}
