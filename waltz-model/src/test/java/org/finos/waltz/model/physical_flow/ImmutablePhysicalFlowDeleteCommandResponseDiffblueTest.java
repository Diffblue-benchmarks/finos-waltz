package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.command.CommandOutcome;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDeleteCommandResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#builder()}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#message(String)}
   *   <li>
   * {@link ImmutablePhysicalFlowDeleteCommandResponse#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalFlowDeleteCommandResponse.Builder actualMessageResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder()
        .message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    ImmutablePhysicalFlowDeleteCommandResponse.Builder actualMessageResult2 = actualMessageResult.message(message);

    // Assert
    assertSame(actualMessageResult2, actualMessageResult2.outcome(CommandOutcome.SUCCESS));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Builder#from(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder();
    PhysicalFlowDeleteCommandResponse instance = mock(PhysicalFlowDeleteCommandResponse.class);
    when(instance.isLastPhysicalFlow()).thenReturn(true);
    when(instance.isSpecificationUnused()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowDeleteCommand.Json json = new ImmutablePhysicalFlowDeleteCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).isLastPhysicalFlow();
    verify(instance).isSpecificationUnused();
    ImmutablePhysicalFlowDeleteCommandResponse buildResult = builderResult.build();
    assertEquals(CommandOutcome.SUCCESS, buildResult.outcome());
    assertTrue(buildResult.isLastPhysicalFlow());
    assertTrue(buildResult.isSpecificationUnused());
    assertSame(json, buildResult.originalCommand());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Builder#from(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder();
    PhysicalFlowDeleteCommandResponse instance = mock(PhysicalFlowDeleteCommandResponse.class);
    when(instance.message()).thenThrow(new IllegalStateException("instance"));
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(new ImmutablePhysicalFlowDeleteCommand.Json());
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
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Builder#from(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder();
    PhysicalFlowDeleteCommandResponse instance = mock(PhysicalFlowDeleteCommandResponse.class);
    when(instance.isLastPhysicalFlow()).thenReturn(true);
    when(instance.isSpecificationUnused()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowDeleteCommand.Json json = new ImmutablePhysicalFlowDeleteCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).isLastPhysicalFlow();
    verify(instance).isSpecificationUnused();
    ImmutablePhysicalFlowDeleteCommandResponse buildResult = builderResult.build();
    assertEquals(CommandOutcome.SUCCESS, buildResult.outcome());
    assertTrue(buildResult.isLastPhysicalFlow());
    assertTrue(buildResult.isSpecificationUnused());
    assertSame(json, buildResult.originalCommand());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Builder#isLastPhysicalFlow(boolean)}
   */
  @Test
  void testBuilderIsLastPhysicalFlow() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isLastPhysicalFlow(true));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Builder#isSpecificationUnused(boolean)}
   */
  @Test
  void testBuilderIsSpecificationUnused() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isSpecificationUnused(true));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Builder#message(Optional)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Builder#originalCommand(PhysicalFlowDeleteCommand)}
   */
  @Test
  void testBuilderOriginalCommand() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(new ImmutablePhysicalFlowDeleteCommand.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse#copyOf(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowDeleteCommandResponse instance = mock(PhysicalFlowDeleteCommandResponse.class);
    when(instance.isLastPhysicalFlow()).thenReturn(true);
    when(instance.isSpecificationUnused()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowDeleteCommand.Json json = new ImmutablePhysicalFlowDeleteCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualCopyOfResult = ImmutablePhysicalFlowDeleteCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).isLastPhysicalFlow();
    verify(instance).isSpecificationUnused();
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertTrue(actualCopyOfResult.isLastPhysicalFlow());
    assertTrue(actualCopyOfResult.isSpecificationUnused());
    assertSame(json, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse#copyOf(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalFlowDeleteCommandResponse instance = mock(PhysicalFlowDeleteCommandResponse.class);
    when(instance.isLastPhysicalFlow()).thenReturn(false);
    when(instance.isSpecificationUnused()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowDeleteCommand.Json json = new ImmutablePhysicalFlowDeleteCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualCopyOfResult = ImmutablePhysicalFlowDeleteCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).isLastPhysicalFlow();
    verify(instance).isSpecificationUnused();
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertFalse(actualCopyOfResult.isLastPhysicalFlow());
    assertTrue(actualCopyOfResult.isSpecificationUnused());
    assertSame(json, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse#copyOf(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    PhysicalFlowDeleteCommandResponse instance = mock(PhysicalFlowDeleteCommandResponse.class);
    when(instance.isLastPhysicalFlow()).thenReturn(true);
    when(instance.isSpecificationUnused()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowDeleteCommand.Json json = new ImmutablePhysicalFlowDeleteCommand.Json();
    when(instance.originalCommand()).thenReturn(json);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowDeleteCommandResponse actualCopyOfResult = ImmutablePhysicalFlowDeleteCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).isLastPhysicalFlow();
    verify(instance).isSpecificationUnused();
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertTrue(actualCopyOfResult.isLastPhysicalFlow());
    assertTrue(actualCopyOfResult.isSpecificationUnused());
    assertSame(json, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowDeleteCommandResponse.Json()).entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#isLastPhysicalFlow()}
   */
  @Test
  void testJsonIsLastPhysicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowDeleteCommandResponse.Json()).isLastPhysicalFlow());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#isSpecificationUnused()}
   */
  @Test
  void testJsonIsSpecificationUnused() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowDeleteCommandResponse.Json()).isSpecificationUnused());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowDeleteCommandResponse.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlowDeleteCommandResponse.Json actualJson = new ImmutablePhysicalFlowDeleteCommandResponse.Json();

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
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#originalCommand()}
   */
  @Test
  void testJsonOriginalCommand() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowDeleteCommandResponse.Json()).originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#outcome()}
   */
  @Test
  void testJsonOutcome() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowDeleteCommandResponse.Json()).outcome());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#setIsLastPhysicalFlow(boolean)}
   */
  @Test
  void testJsonSetIsLastPhysicalFlow() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Json json = new ImmutablePhysicalFlowDeleteCommandResponse.Json();

    // Act
    json.setIsLastPhysicalFlow(true);

    // Assert
    assertTrue(json.isLastPhysicalFlow);
    assertTrue(json.isLastPhysicalFlowIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#setIsLastPhysicalFlow(boolean)}
   */
  @Test
  void testJsonSetIsLastPhysicalFlow2() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Json json = new ImmutablePhysicalFlowDeleteCommandResponse.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsLastPhysicalFlow(true);

    // Assert
    assertTrue(json.isLastPhysicalFlow);
    assertTrue(json.isLastPhysicalFlowIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#setIsSpecificationUnused(boolean)}
   */
  @Test
  void testJsonSetIsSpecificationUnused() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Json json = new ImmutablePhysicalFlowDeleteCommandResponse.Json();

    // Act
    json.setIsSpecificationUnused(true);

    // Assert
    assertTrue(json.isSpecificationUnused);
    assertTrue(json.isSpecificationUnusedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommandResponse.Json#setIsSpecificationUnused(boolean)}
   */
  @Test
  void testJsonSetIsSpecificationUnused2() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommandResponse.Json json = new ImmutablePhysicalFlowDeleteCommandResponse.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsSpecificationUnused(true);

    // Assert
    assertTrue(json.isSpecificationUnused);
    assertTrue(json.isSpecificationUnusedIsSet);
  }
}
