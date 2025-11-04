package org.finos.waltz.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableCommandResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCommandResponse#builder()}
   *   <li>{@link ImmutableCommandResponse#message(String)}
   *   <li>{@link ImmutableCommandResponse#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableCommandResponse.Builder<Command> actualBuilderResult = ImmutableCommandResponse.builder();
    ImmutableCommandResponse.Builder<Command> actualMessageResult = actualBuilderResult
        .message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    ImmutableCommandResponse.Builder<Command> actualMessageResult2 = actualMessageResult.message(message);

    // Assert
    assertSame(actualMessageResult2, actualMessageResult2.outcome(CommandOutcome.SUCCESS));
  }

  /**
   * Method under test:
   * {@link ImmutableCommandResponse.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableCommandResponse.Builder<Command> builderResult = ImmutableCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCommandResponse.Builder#from(CommandResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCommandResponse.Builder<Command> builderResult = ImmutableCommandResponse.builder();
    CommandResponse<Command> instance = mock(CommandResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(mock(Command.class));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableCommandResponse.Builder<Command> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    assertEquals(CommandOutcome.SUCCESS, actualFromResult.build().outcome());
    assertEquals(CommandOutcome.SUCCESS, builderResult.build().outcome());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCommandResponse.Builder#from(CommandResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCommandResponse.Builder<Command> builderResult = ImmutableCommandResponse.builder();
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
   * Method under test:
   * {@link ImmutableCommandResponse.Builder#from(CommandResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCommandResponse.Builder<Command> builderResult = ImmutableCommandResponse.builder();
    CommandResponse<Command> instance = mock(CommandResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(mock(Command.class));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableCommandResponse.Builder<Command> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    assertEquals(CommandOutcome.SUCCESS, actualFromResult.build().outcome());
    assertEquals(CommandOutcome.SUCCESS, builderResult.build().outcome());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCommandResponse.Builder#message(Optional)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableCommandResponse.Builder<Command> builderResult = ImmutableCommandResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Method under test:
   * {@link ImmutableCommandResponse.Builder#originalCommand(Command)}
   */
  @Test
  void testBuilderOriginalCommand() {
    // Arrange
    ImmutableCommandResponse.Builder<Command> builderResult = ImmutableCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(mock(Command.class)));
  }

  /**
   * Method under test: {@link ImmutableCommandResponse#copyOf(CommandResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CommandResponse<Command> instance = mock(CommandResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(mock(Command.class));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableCommandResponse<Command> actualCopyOfResult = ImmutableCommandResponse.copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
  }

  /**
   * Method under test: {@link ImmutableCommandResponse#copyOf(CommandResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    CommandResponse<Command> instance = mock(CommandResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(mock(Command.class));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableCommandResponse<Command> actualCopyOfResult = ImmutableCommandResponse.copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
  }

  /**
   * Method under test:
   * {@link ImmutableCommandResponse#fromJson(ImmutableCommandResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCommandResponse.Json<Command> json = new ImmutableCommandResponse.Json<>();
    json.setEntityReference(mock(EntityReference.class));
    json.setOriginalCommand(mock(Command.class));
    json.setOutcome(null);
    json.setMessage(null);

    // Act
    ImmutableCommandResponse<Command> actualFromJsonResult = ImmutableCommandResponse.fromJson(json);

    // Assert
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    Command expectedOriginalCommandResult = json.originalCommand;
    assertSame(expectedOriginalCommandResult, actualFromJsonResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutableCommandResponse#fromJson(ImmutableCommandResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableCommandResponse.Json<Command> json = new ImmutableCommandResponse.Json<>();
    json.setEntityReference(mock(EntityReference.class));
    json.setOriginalCommand(mock(Command.class));
    json.setOutcome(CommandOutcome.SUCCESS);
    json.setMessage(null);

    // Act
    ImmutableCommandResponse<Command> actualFromJsonResult = ImmutableCommandResponse.fromJson(json);

    // Assert
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    Command expectedOriginalCommandResult = json.originalCommand;
    assertSame(expectedOriginalCommandResult, actualFromJsonResult.originalCommand());
  }

  /**
   * Method under test: {@link ImmutableCommandResponse.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange
    ImmutableCommandResponse.Json<Command> json = new ImmutableCommandResponse.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entityReference());
  }

  /**
   * Method under test: {@link ImmutableCommandResponse.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange
    ImmutableCommandResponse.Json<Command> json = new ImmutableCommandResponse.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCommandResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCommandResponse.Json<Command> actualJson = new ImmutableCommandResponse.Json<>();

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.originalCommand);
    assertNull(actualJson.outcome);
    assertFalse(actualJson.message.isPresent());
  }

  /**
   * Method under test: {@link ImmutableCommandResponse.Json#originalCommand()}
   */
  @Test
  void testJsonOriginalCommand() {
    // Arrange
    ImmutableCommandResponse.Json<Command> json = new ImmutableCommandResponse.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.originalCommand());
  }

  /**
   * Method under test: {@link ImmutableCommandResponse.Json#outcome()}
   */
  @Test
  void testJsonOutcome() {
    // Arrange
    ImmutableCommandResponse.Json<Command> json = new ImmutableCommandResponse.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.outcome());
  }
}
