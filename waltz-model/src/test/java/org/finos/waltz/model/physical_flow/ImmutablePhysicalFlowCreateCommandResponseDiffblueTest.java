package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommandResponse.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommandResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowCreateCommandResponseDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalFlowCreateCommandResponse#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#builder()}
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#message(String)}
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalFlowCreateCommandResponse Builder.build()", "Builder Builder.message(String)",
      "Builder Builder.outcome(CommandOutcome)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualMessageResult = ImmutablePhysicalFlowCreateCommandResponse.builder()
        .message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    Builder actualMessageResult2 = actualMessageResult.message(message);

    // Assert
    assertSame(actualMessageResult2, actualMessageResult2.outcome(CommandOutcome.SUCCESS));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowCreateCommandResponse)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowCreateCommandResponse); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowCreateCommandResponse)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse.builder();
    PhysicalFlowCreateCommandResponse instance = mock(PhysicalFlowCreateCommandResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    ImmutablePhysicalFlowCreateCommandResponse buildResult = builderResult.build();
    assertEquals(CommandOutcome.SUCCESS, buildResult.outcome());
    assertSame(json, buildResult.originalCommand());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowCreateCommandResponse)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then builder build outcome is {@code SUCCESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowCreateCommandResponse); given Optional with 'foo'; then builder build outcome is 'SUCCESS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowCreateCommandResponse)"})
  void testBuilderFrom_givenOptionalWithFoo_thenBuilderBuildOutcomeIsSuccess() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse.builder();
    PhysicalFlowCreateCommandResponse instance = mock(PhysicalFlowCreateCommandResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    ImmutablePhysicalFlowCreateCommandResponse buildResult = builderResult.build();
    assertEquals(CommandOutcome.SUCCESS, buildResult.outcome());
    assertSame(json, buildResult.originalCommand());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowCreateCommandResponse)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowCreateCommandResponse); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowCreateCommandResponse)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse.builder();
    PhysicalFlowCreateCommandResponse instance = mock(PhysicalFlowCreateCommandResponse.class);
    when(instance.message()).thenThrow(new IllegalStateException("instance"));
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(new ImmutablePhysicalFlowCreateCommand.Json());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
  }

  /**
   * Test Builder {@link Builder#message(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#message(Optional)}
   */
  @Test
  @DisplayName("Test Builder message(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.message(Optional)"})
  void testBuilderMessageWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Test Builder {@link Builder#originalCommand(PhysicalFlowCreateCommand)}.
   * <ul>
   *   <li>When {@link ImmutablePhysicalFlowCreateCommand.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#originalCommand(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder originalCommand(PhysicalFlowCreateCommand); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.originalCommand(PhysicalFlowCreateCommand)"})
  void testBuilderOriginalCommand_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(new ImmutablePhysicalFlowCreateCommand.Json()));
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).message());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#originalCommand()}
   */
  @Test
  @DisplayName("Test Json originalCommand()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalFlowCreateCommand Json.originalCommand()"})
  void testJsonOriginalCommand() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).originalCommand());
  }

  /**
   * Test Json {@link Json#outcome()}.
   * <p>
   * Method under test: {@link Json#outcome()}
   */
  @Test
  @DisplayName("Test Json outcome()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommandOutcome Json.outcome()"})
  void testJsonOutcome() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).outcome());
  }
}
