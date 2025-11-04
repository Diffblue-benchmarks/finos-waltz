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
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.command.CommandOutcome;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowUploadCommandResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#builder()}
   *   <li>
   * {@link ImmutablePhysicalFlowUploadCommandResponse#entityReference(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#message(String)}
   *   <li>
   * {@link ImmutablePhysicalFlowUploadCommandResponse#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualMessageResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder()
        .entityReference(null)
        .message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualMessageResult2 = actualMessageResult.message(message);

    // Assert
    assertSame(actualMessageResult2, actualMessageResult2.outcome(CommandOutcome.SUCCESS));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#errors(Map)}
   */
  @Test
  void testBuilderErrors() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#errors(Map)}
   */
  @Test
  void testBuilderErrors2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.errors(entries));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#errors(Map)}
   */
  @Test
  void testBuilderErrors3() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("errors key", mock(BiFunction.class));
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.errors(entries));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(new HashMap<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(null);
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    ImmutablePhysicalFlowUploadCommandResponse buildResult = builderResult.build();
    assertNull(buildResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, buildResult.outcome());
    assertSame(json, buildResult.parsedFlow());
    assertSame(json2, buildResult.originalCommand());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(null);
    when(instance.parsedFlow()).thenReturn(new ImmutablePhysicalFlowParsed.Json());
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(new ImmutablePhysicalFlowUploadCommand.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("instance", "instance");
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(stringStringMap);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(null);
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    ImmutablePhysicalFlowUploadCommandResponse buildResult = builderResult.build();
    Map<String, String> errorsResult = buildResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals("instance", errorsResult.get("instance"));
    assertNull(buildResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, buildResult.outcome());
    assertSame(json, buildResult.parsedFlow());
    assertSame(json2, buildResult.originalCommand());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(new HashMap<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.entityReference()).thenReturn(null);
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    ImmutablePhysicalFlowUploadCommandResponse buildResult = builderResult.build();
    assertNull(buildResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, buildResult.outcome());
    assertSame(json, buildResult.parsedFlow());
    assertSame(json2, buildResult.originalCommand());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(new HashMap<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    ImmutablePhysicalFlowUploadCommandResponse buildResult = builderResult.build();
    assertEquals(CommandOutcome.SUCCESS, buildResult.outcome());
    assertSame(json, buildResult.parsedFlow());
    assertSame(json2, buildResult.originalCommand());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#message(Optional)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#message(Optional)}
   */
  @Test
  void testBuilderMessage2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    builderResult.entityReference(mock(EntityReference.class));
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#originalCommand(PhysicalFlowUploadCommand)}
   */
  @Test
  void testBuilderOriginalCommand() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(new ImmutablePhysicalFlowUploadCommand.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#originalCommand(PhysicalFlowUploadCommand)}
   */
  @Test
  void testBuilderOriginalCommand2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    builderResult.entityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(new ImmutablePhysicalFlowUploadCommand.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#parsedFlow(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderParsedFlow() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedFlow(new ImmutablePhysicalFlowParsed.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#parsedFlow(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderParsedFlow2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    builderResult.entityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parsedFlow(new ImmutablePhysicalFlowParsed.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putAllErrors(Map)}
   */
  @Test
  void testBuilderPutAllErrors() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putAllErrors(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putAllErrors(Map)}
   */
  @Test
  void testBuilderPutAllErrors2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.putAllErrors(entries));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putAllErrors(Map)}
   */
  @Test
  void testBuilderPutAllErrors3() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("errors key", mock(BiFunction.class));
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.putAllErrors(entries));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putErrors(String, String)}
   */
  @Test
  void testBuilderPutErrors() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putErrors("Key", "42"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putErrors(String, String)}
   */
  @Test
  void testBuilderPutErrors2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    builderResult.entityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.putErrors("Key", "42"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putErrors(Map.Entry)}
   */
  @Test
  void testBuilderPutErrors3() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putErrors(new AbstractMap.SimpleEntry<>("foo", "foo")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Builder#putErrors(Map.Entry)}
   */
  @Test
  void testBuilderPutErrors4() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse
        .builder();
    builderResult.entityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.putErrors(new AbstractMap.SimpleEntry<>("foo", "foo")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse#copyOf(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(new HashMap<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(null);
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualCopyOfResult = ImmutablePhysicalFlowUploadCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    assertNull(actualCopyOfResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedFlow());
    assertSame(json2, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse#copyOf(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("instance", "instance");
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(stringStringMap);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(null);
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualCopyOfResult = ImmutablePhysicalFlowUploadCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    Map<String, String> errorsResult = actualCopyOfResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals("instance", errorsResult.get("instance"));
    assertNull(actualCopyOfResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertSame(json, actualCopyOfResult.parsedFlow());
    assertSame(json2, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse#copyOf(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("originalCommand", "originalCommand");
    stringStringMap.put("instance", "instance");
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(stringStringMap);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(null);
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualCopyOfResult = ImmutablePhysicalFlowUploadCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    assertNull(actualCopyOfResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertEquals(stringStringMap, actualCopyOfResult.errors());
    assertSame(json, actualCopyOfResult.parsedFlow());
    assertSame(json2, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse#copyOf(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(new HashMap<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    when(instance.entityReference()).thenReturn(null);
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualCopyOfResult = ImmutablePhysicalFlowUploadCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    assertNull(actualCopyOfResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedFlow());
    assertSame(json2, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse#copyOf(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(new HashMap<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    when(instance.parsedFlow()).thenReturn(json);
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    ImmutablePhysicalFlowUploadCommand.Json json2 = new ImmutablePhysicalFlowUploadCommand.Json();
    when(instance.originalCommand()).thenReturn(json2);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualCopyOfResult = ImmutablePhysicalFlowUploadCommandResponse
        .copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    assertEquals(CommandOutcome.SUCCESS, actualCopyOfResult.outcome());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedFlow());
    assertSame(json2, actualCopyOfResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(ImmutablePhysicalFlowUploadCommandResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Json json = new ImmutablePhysicalFlowUploadCommandResponse.Json();
    ImmutablePhysicalFlowUploadCommand.Json originalCommand = new ImmutablePhysicalFlowUploadCommand.Json();
    json.setOriginalCommand(originalCommand);
    json.setOutcome(null);
    json.setMessage(null);
    json.setEntityReference(null);
    ImmutablePhysicalFlowParsed.Json parsedFlow = new ImmutablePhysicalFlowParsed.Json();
    json.setParsedFlow(parsedFlow);
    json.setErrors(null);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult = ImmutablePhysicalFlowUploadCommandResponse
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedFlow, actualFromJsonResult.parsedFlow());
    assertSame(originalCommand, actualFromJsonResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse#fromJson(ImmutablePhysicalFlowUploadCommandResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommandResponse.Json json = new ImmutablePhysicalFlowUploadCommandResponse.Json();
    ImmutablePhysicalFlowUploadCommand.Json originalCommand = new ImmutablePhysicalFlowUploadCommand.Json();
    json.setOriginalCommand(originalCommand);
    json.setOutcome(CommandOutcome.SUCCESS);
    json.setMessage(null);
    json.setEntityReference(null);
    ImmutablePhysicalFlowParsed.Json parsedFlow = new ImmutablePhysicalFlowParsed.Json();
    json.setParsedFlow(parsedFlow);
    json.setErrors(null);

    // Act
    ImmutablePhysicalFlowUploadCommandResponse actualFromJsonResult = ImmutablePhysicalFlowUploadCommandResponse
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.entityReference());
    assertEquals(CommandOutcome.SUCCESS, actualFromJsonResult.outcome());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedFlow, actualFromJsonResult.parsedFlow());
    assertSame(originalCommand, actualFromJsonResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommandResponse.Json()).entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Json#errors()}
   */
  @Test
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommandResponse.Json()).errors());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommandResponse.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommandResponse.Json actualJson = new ImmutablePhysicalFlowUploadCommandResponse.Json();

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.outcome);
    assertNull(actualJson.parsedFlow);
    assertNull(actualJson.originalCommand);
    assertFalse(actualJson.message.isPresent());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Json#originalCommand()}
   */
  @Test
  void testJsonOriginalCommand() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommandResponse.Json()).originalCommand());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Json#outcome()}
   */
  @Test
  void testJsonOutcome() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommandResponse.Json()).outcome());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommandResponse.Json#parsedFlow()}
   */
  @Test
  void testJsonParsedFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommandResponse.Json()).parsedFlow());
  }
}
