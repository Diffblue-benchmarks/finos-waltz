package org.finos.waltz.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableDateChangeCommand;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.command.ImmutableCommandResponse.Builder;
import org.finos.waltz.model.command.ImmutableCommandResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCommandResponseDiffblueTest {
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
    "ImmutableCommandResponse Builder.build()",
    "Builder Builder.message(String)",
    "Builder Builder.outcome(CommandOutcome)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Command> actualBuilderResult = ImmutableCommandResponse.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder<Command> actualMessageResult =
        actualBuilderResult.entityReference(entityReference).message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    Builder<Command> actualMessageResult2 = actualMessageResult.message(message);
    ImmutableDateChangeCommand immutableDateChangeCommand =
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build();
    ImmutableCommandResponse<Command> actualImmutableCommandResponse =
        actualMessageResult2
            .originalCommand(immutableDateChangeCommand)
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Assert
    Command originalCommandResult = actualImmutableCommandResponse.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutableDateChangeCommand);
    assertEquals(CommandOutcome.SUCCESS, actualImmutableCommandResponse.outcome());
    assertSame(immutableDateChangeCommand, originalCommandResult);
    assertSame(entityReference, actualImmutableCommandResponse.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    // Act
    Builder<Command> actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(CommandResponse)}.
   *
   * <p>Method under test: {@link Builder#from(CommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(CommandResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommandResponse)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> builderResult2 = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> instance =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    Builder<Command> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCommandResponse<Command> actualImmutableCommandResponse = builderResult.build();
    assertEquals(instance, actualImmutableCommandResponse);
    assertSame(builderResult, actualFromResult);
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
    Builder<Command> builderResult = ImmutableCommandResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act
    Builder<Command> actualMessageResult = builderResult.message(message);

    // Assert
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link Builder#originalCommand(Command)}.
   *
   * <p>Method under test: {@link Builder#originalCommand(Command)}
   */
  @Test
  @DisplayName("Test Builder originalCommand(Command)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.originalCommand(Command)"})
  void testBuilderOriginalCommand() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    // Act
    Builder<Command> actualOriginalCommandResult =
        builderResult.originalCommand(mock(Command.class));

    // Assert
    assertSame(builderResult, actualOriginalCommandResult);
  }

  /**
   * Test {@link ImmutableCommandResponse#copyOf(CommandResponse)}.
   *
   * <ul>
   *   <li>Then originalCommand return {@link ImmutableDateChangeCommand}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#copyOf(CommandResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CommandResponse); then originalCommand return ImmutableDateChangeCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCommandResponse ImmutableCommandResponse.copyOf(CommandResponse)"})
  void testCopyOf_thenOriginalCommandReturnImmutableDateChangeCommand() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> instance =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutableCommandResponse<Command> actualCopyOfResult =
        ImmutableCommandResponse.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.originalCommand() instanceof ImmutableDateChangeCommand);
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
  }

  /**
   * Test {@link ImmutableCommandResponse#equals(Object)}, and {@link
   * ImmutableCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCommandResponse#equals(Object)}
   *   <li>{@link ImmutableCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCommandResponse.equals(Object)",
    "int ImmutableCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder<Command> builderResult2 = ImmutableCommandResponse.builder();

    Builder<Command> messageResult2 =
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
    ImmutableCommandResponse<Command> immutableCommandResponse2 =
        messageResult2
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act and Assert
    assertEquals(immutableCommandResponse, immutableCommandResponse2);
    assertEquals(immutableCommandResponse.hashCode(), immutableCommandResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableCommandResponse#equals(Object)}, and {@link
   * ImmutableCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCommandResponse#equals(Object)}
   *   <li>{@link ImmutableCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCommandResponse.equals(Object)",
    "int ImmutableCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act and Assert
    assertEquals(immutableCommandResponse, immutableCommandResponse);
    int expectedHashCodeResult = immutableCommandResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableCommandResponse.hashCode());
  }

  /**
   * Test {@link ImmutableCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCommandResponse.equals(Object)",
    "int ImmutableCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder<Command> builderResult2 = ImmutableCommandResponse.builder();

    Builder<Command> messageResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableCommandResponse,
        messageResult2
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCommandResponse.equals(Object)",
    "int ImmutableCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
            .message("Message");
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder<Command> builderResult2 = ImmutableCommandResponse.builder();

    Builder<Command> messageResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableCommandResponse,
        messageResult2
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCommandResponse.equals(Object)",
    "int ImmutableCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.now()).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    Builder<Command> builderResult2 = ImmutableCommandResponse.builder();

    Builder<Command> messageResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableCommandResponse,
        messageResult2
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCommandResponse.equals(Object)",
    "int ImmutableCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.FAILURE)
            .build();

    Builder<Command> builderResult2 = ImmutableCommandResponse.builder();

    Builder<Command> messageResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableCommandResponse,
        messageResult2
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCommandResponse.equals(Object)",
    "int ImmutableCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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

    // Act and Assert
    assertNotEquals(
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCommandResponse.equals(Object)",
    "int ImmutableCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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

    // Act and Assert
    assertNotEquals(
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build(),
        "Different type to ImmutableCommandResponse");
  }

  /**
   * Test {@link ImmutableCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) Message is of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) Message is of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCommandResponse ImmutableCommandResponse.fromJson(Json)"})
  void testFromJson_givenOfFoo_whenJsonMessageIsOfFoo() {
    // Arrange
    Json<Command> json = new Json<>();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOriginalCommand(
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());
    json.setOutcome(null);
    Optional<String> message = Optional.of("foo");
    json.setMessage(message);

    // Act
    ImmutableCommandResponse<Command> actualFromJsonResult =
        ImmutableCommandResponse.fromJson(json);

    // Assert
    Command originalCommandResult = actualFromJsonResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutableDateChangeCommand);
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    assertSame(json.originalCommand, originalCommandResult);
  }

  /**
   * Test {@link ImmutableCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code SUCCESS}.
   *   <li>When {@link Json} (default constructor) Outcome is {@code SUCCESS}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'SUCCESS'; when Json (default constructor) Outcome is 'SUCCESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCommandResponse ImmutableCommandResponse.fromJson(Json)"})
  void testFromJson_givenSuccess_whenJsonOutcomeIsSuccess() {
    // Arrange
    Json<Command> json = new Json<>();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOriginalCommand(
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());
    json.setOutcome(CommandOutcome.SUCCESS);
    json.setMessage(null);

    // Act
    ImmutableCommandResponse<Command> actualFromJsonResult =
        ImmutableCommandResponse.fromJson(json);

    // Assert
    Command originalCommandResult = actualFromJsonResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutableDateChangeCommand);
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    assertSame(json.originalCommand, originalCommandResult);
  }

  /**
   * Test {@link ImmutableCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then originalCommand return {@link ImmutableDateChangeCommand}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then originalCommand return ImmutableDateChangeCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCommandResponse ImmutableCommandResponse.fromJson(Json)"})
  void testFromJson_thenOriginalCommandReturnImmutableDateChangeCommand() {
    // Arrange
    Json<Command> json = new Json<>();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOriginalCommand(
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());
    json.setOutcome(null);
    json.setMessage(null);

    // Act
    ImmutableCommandResponse<Command> actualFromJsonResult =
        ImmutableCommandResponse.fromJson(json);

    // Assert
    Command originalCommandResult = actualFromJsonResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutableDateChangeCommand);
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    assertSame(json.originalCommand, originalCommandResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCommandResponse#entityReference()}
   *   <li>{@link ImmutableCommandResponse#outcome()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableCommandResponse.entityReference()",
    "CommandOutcome ImmutableCommandResponse.outcome()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    EntityReference actualEntityReferenceResult = immutableCommandResponse.entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(CommandOutcome.SUCCESS, immutableCommandResponse.outcome());
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
    // Arrange
    Json<Command> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entityReference());
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
    // Arrange
    Json<Command> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.message());
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
    Json<Command> actualJson = new Json<>();

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.originalCommand);
    assertNull(actualJson.outcome);
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
  @MethodsUnderTest({"Command Json.originalCommand()"})
  void testJsonOriginalCommand() {
    // Arrange
    Json<Command> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.originalCommand());
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
    // Arrange
    Json<Command> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.outcome());
  }

  /**
   * Test {@link ImmutableCommandResponse#message()}.
   *
   * <p>Method under test: {@link ImmutableCommandResponse#message()}
   */
  @Test
  @DisplayName("Test message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableCommandResponse.message()"})
  void testMessage() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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

    // Act
    Optional<String> actualMessageResult =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .message();

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.get());
    assertTrue(actualMessageResult.isPresent());
  }

  /**
   * Test {@link ImmutableCommandResponse#originalCommand()}.
   *
   * <p>Method under test: {@link ImmutableCommandResponse#originalCommand()}
   */
  @Test
  @DisplayName("Test originalCommand()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command ImmutableCommandResponse.originalCommand()"})
  void testOriginalCommand() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    LocalDate newDateVal = LocalDate.of(1970, 1, 1);

    // Act
    Command actualOriginalCommandResult =
        messageResult
            .originalCommand(ImmutableDateChangeCommand.builder().newDateVal(newDateVal).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .originalCommand();

    // Assert
    assertTrue(actualOriginalCommandResult instanceof ImmutableDateChangeCommand);
    Optional<LocalDate> newDateValResult =
        ((ImmutableDateChangeCommand) actualOriginalCommandResult).newDateVal();
    LocalDate getResult = newDateValResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(newDateValResult.isPresent());
    assertSame(newDateVal, getResult);
  }

  /**
   * Test {@link ImmutableCommandResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutableCommandResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableCommandResponse.toString()"})
  void testToString() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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

    // Act and Assert
    assertEquals(
        "CommandResponse{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " originalCommand=DateChangeCommand{newDateVal=1970-01-01}, outcome=SUCCESS, message=Not all who"
            + " wander are lost}",
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableCommandResponse#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableCommandResponse#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCommandResponse ImmutableCommandResponse.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutableCommandResponse<Command> actualWithEntityReferenceResult =
        immutableCommandResponse.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableCommandResponse, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableCommandResponse#withMessage(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableCommandResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName("Test withMessage(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCommandResponse ImmutableCommandResponse.withMessage(Optional)"})
  void testWithMessageWithOptional() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableCommandResponse<Command> actualWithMessageResult =
        immutableCommandResponse.withMessage(optional);

    // Assert
    assertTrue(actualWithMessageResult.originalCommand() instanceof ImmutableDateChangeCommand);
    EntityReference entityReferenceResult = actualWithMessageResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithMessageResult.outcome());
  }

  /**
   * Test {@link ImmutableCommandResponse#withMessage(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableCommandResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCommandResponse ImmutableCommandResponse.withMessage(String)"})
  void testWithMessageWithValue() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutableCommandResponse<Command> actualWithMessageResult =
        immutableCommandResponse.withMessage("42");

    // Assert
    assertSame(immutableCommandResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableCommandResponse#withMessage(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then originalCommand return {@link ImmutableDateChangeCommand}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#withMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withMessage(String) with 'value'; then originalCommand return ImmutableDateChangeCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCommandResponse ImmutableCommandResponse.withMessage(String)"})
  void testWithMessageWithValue_thenOriginalCommandReturnImmutableDateChangeCommand() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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

    // Act
    ImmutableCommandResponse<Command> actualWithMessageResult =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build()
            .withMessage("42");

    // Assert
    assertTrue(actualWithMessageResult.originalCommand() instanceof ImmutableDateChangeCommand);
    EntityReference entityReferenceResult = actualWithMessageResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithMessageResult.outcome());
  }

  /**
   * Test {@link ImmutableCommandResponse#withOriginalCommand(Command)}.
   *
   * <p>Method under test: {@link ImmutableCommandResponse#withOriginalCommand(Command)}
   */
  @Test
  @DisplayName("Test withOriginalCommand(Command)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCommandResponse ImmutableCommandResponse.withOriginalCommand(Command)"
  })
  void testWithOriginalCommand() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutableCommandResponse<Command> actualWithOriginalCommandResult =
        immutableCommandResponse.withOriginalCommand(
            ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());

    // Assert
    assertEquals(immutableCommandResponse, actualWithOriginalCommandResult);
  }

  /**
   * Test {@link ImmutableCommandResponse#withOutcome(CommandOutcome)}.
   *
   * <p>Method under test: {@link ImmutableCommandResponse#withOutcome(CommandOutcome)}
   */
  @Test
  @DisplayName("Test withOutcome(CommandOutcome)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCommandResponse ImmutableCommandResponse.withOutcome(CommandOutcome)"
  })
  void testWithOutcome() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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
    ImmutableCommandResponse<Command> immutableCommandResponse =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.SUCCESS)
            .build();

    // Act
    ImmutableCommandResponse<Command> actualWithOutcomeResult =
        immutableCommandResponse.withOutcome(CommandOutcome.SUCCESS);

    // Assert
    assertSame(immutableCommandResponse, actualWithOutcomeResult);
  }

  /**
   * Test {@link ImmutableCommandResponse#withOutcome(CommandOutcome)}.
   *
   * <ul>
   *   <li>Then originalCommand return {@link ImmutableDateChangeCommand}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCommandResponse#withOutcome(CommandOutcome)}
   */
  @Test
  @DisplayName(
      "Test withOutcome(CommandOutcome); then originalCommand return ImmutableDateChangeCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCommandResponse ImmutableCommandResponse.withOutcome(CommandOutcome)"
  })
  void testWithOutcome_thenOriginalCommandReturnImmutableDateChangeCommand() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    Builder<Command> messageResult =
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

    // Act
    ImmutableCommandResponse<Command> actualWithOutcomeResult =
        messageResult
            .originalCommand(
                ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build())
            .outcome(CommandOutcome.FAILURE)
            .build()
            .withOutcome(CommandOutcome.SUCCESS);

    // Assert
    assertTrue(actualWithOutcomeResult.originalCommand() instanceof ImmutableDateChangeCommand);
    EntityReference entityReferenceResult = actualWithOutcomeResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualWithOutcomeResult.outcome());
  }
}
