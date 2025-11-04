package org.finos.waltz.model.physical_flow;

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
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowCreateCommandResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#builder()}
   *   <li>{@link ImmutablePhysicalFlowCreateCommandResponse#message(String)}
   *   <li>
   * {@link ImmutablePhysicalFlowCreateCommandResponse#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualMessageResult = ImmutablePhysicalFlowCreateCommandResponse
        .builder()
        .message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualMessageResult2 = actualMessageResult.message(message);

    // Assert
    assertSame(actualMessageResult2, actualMessageResult2.outcome(CommandOutcome.SUCCESS));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#from(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse
        .builder();
    PhysicalFlowCreateCommandResponse instance = mock(PhysicalFlowCreateCommandResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#from(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse
        .builder();
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
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#from(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse
        .builder();
    PhysicalFlowCreateCommandResponse instance = mock(PhysicalFlowCreateCommandResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowCreateCommandResponse.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#message(Optional)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse
        .builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#originalCommand(PhysicalFlowCreateCommand)}
   */
  @Test
  void testBuilderOriginalCommand() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(new ImmutablePhysicalFlowCreateCommand.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Builder#originalCommand(PhysicalFlowCreateCommand)}
   */
  @Test
  void testBuilderOriginalCommand2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult = ImmutablePhysicalFlowCreateCommandResponse
        .builder();

    ImmutablePhysicalFlowCreateCommand.Json originalCommand = new ImmutablePhysicalFlowCreateCommand.Json();
    originalCommand.setSpecification(mock(PhysicalSpecification.class));

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(originalCommand));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse#copyOf(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowCreateCommandResponse instance = mock(PhysicalFlowCreateCommandResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualCopyOfResult = ImmutablePhysicalFlowCreateCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertSame(json, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse#copyOf(PhysicalFlowCreateCommandResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalFlowCreateCommandResponse instance = mock(PhysicalFlowCreateCommandResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualCopyOfResult = ImmutablePhysicalFlowCreateCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertSame(json, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse#fromJson(ImmutablePhysicalFlowCreateCommandResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Json json = new ImmutablePhysicalFlowCreateCommandResponse.Json();
    json.setEntityReference(mock(EntityReference.class));
    ImmutablePhysicalFlowCreateCommand.Json originalCommand = new ImmutablePhysicalFlowCreateCommand.Json();
    json.setOriginalCommand(originalCommand);
    json.setOutcome(null);
    json.setMessage(null);

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualFromJsonResult = ImmutablePhysicalFlowCreateCommandResponse
        .fromJson(json);

    // Assert
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    assertSame(originalCommand, actualFromJsonResult.originalCommand());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse#fromJson(ImmutablePhysicalFlowCreateCommandResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommandResponse.Json json = new ImmutablePhysicalFlowCreateCommandResponse.Json();
    json.setEntityReference(mock(EntityReference.class));
    ImmutablePhysicalFlowCreateCommand.Json originalCommand = new ImmutablePhysicalFlowCreateCommand.Json();
    json.setOriginalCommand(originalCommand);
    json.setOutcome(CommandOutcome.SUCCESS);
    json.setMessage(null);

    // Act
    ImmutablePhysicalFlowCreateCommandResponse actualFromJsonResult = ImmutablePhysicalFlowCreateCommandResponse
        .fromJson(json);

    // Assert
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    assertSame(originalCommand, actualFromJsonResult.originalCommand());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowCreateCommandResponse.Json()).entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowCreateCommandResponse.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlowCreateCommandResponse.Json actualJson = new ImmutablePhysicalFlowCreateCommandResponse.Json();

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.outcome);
    assertNull(actualJson.originalCommand);
    assertFalse(actualJson.message.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Json#originalCommand()}
   */
  @Test
  void testJsonOriginalCommand() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowCreateCommandResponse.Json()).originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommandResponse.Json#outcome()}
   */
  @Test
  void testJsonOutcome() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowCreateCommandResponse.Json()).outcome());
  }
}
