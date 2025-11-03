package org.finos.waltz.model.command;

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
import org.finos.waltz.model.command.ImmutableCommandResponse.Builder;
import org.finos.waltz.model.command.ImmutableCommandResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCommandResponseDiffblueTest {
  /**
   * Test {@link ImmutableCommandResponse#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCommandResponse#builder()}
   *   <li>{@link ImmutableCommandResponse#message(String)}
   *   <li>{@link ImmutableCommandResponse#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCommandResponse Builder.build()", "Builder Builder.message(String)",
      "Builder Builder.outcome(CommandOutcome)"})
  void testBuilder() {
    // Arrange and Act
    Builder<Command> actualBuilderResult = ImmutableCommandResponse.builder();
    Builder<Command> actualMessageResult = actualBuilderResult.message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    Builder<Command> actualMessageResult2 = actualMessageResult.message(message);

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
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(CommandResponse)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link CommandResponse} {@link AbstractCommandResponse#message()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(CommandResponse); given empty; when CommandResponse message() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommandResponse)"})
  void testBuilderFrom_givenEmpty_whenCommandResponseMessageReturnEmpty() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();
    CommandResponse<Command> instance = mock(CommandResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(mock(Command.class));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder<Command> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    assertEquals(CommandOutcome.SUCCESS, builderResult.build().outcome());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CommandResponse)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(CommandResponse); given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommandResponse)"})
  void testBuilderFrom_givenOptionalWithFoo() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();
    CommandResponse<Command> instance = mock(CommandResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(mock(Command.class));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder<Command> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    assertEquals(CommandOutcome.SUCCESS, builderResult.build().outcome());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CommandResponse)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(CommandResponse); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommandResponse)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();
    CommandResponse<Command> instance = mock(CommandResponse.class);
    when(instance.message()).thenThrow(new IllegalStateException("instance"));
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(mock(Command.class));
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
    Builder<Command> builderResult = ImmutableCommandResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Test Builder {@link Builder#originalCommand(Command)}.
   * <p>
   * Method under test: {@link Builder#originalCommand(Command)}
   */
  @Test
  @DisplayName("Test Builder originalCommand(Command)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.originalCommand(Command)"})
  void testBuilderOriginalCommand() {
    // Arrange
    Builder<Command> builderResult = ImmutableCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(mock(Command.class)));
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
    // Arrange
    Json<Command> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entityReference());
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
    // Arrange
    Json<Command> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.message());
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
    Json<Command> actualJson = new Json<>();

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.originalCommand);
    assertNull(actualJson.outcome);
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
  @MethodsUnderTest({"Command Json.originalCommand()"})
  void testJsonOriginalCommand() {
    // Arrange
    Json<Command> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.originalCommand());
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
    // Arrange
    Json<Command> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.outcome());
  }
}
