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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommandResponse.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommandResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowUploadCommandResponseDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalFlowUploadCommandResponse#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#builder()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#entityReference(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#message(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommandResponse#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalFlowUploadCommandResponse Builder.build()",
      "Builder Builder.entityReference(EntityReference)", "Builder Builder.message(String)",
      "Builder Builder.outcome(CommandOutcome)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualMessageResult = ImmutablePhysicalFlowUploadCommandResponse.builder()
        .entityReference(null)
        .message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    Builder actualMessageResult2 = actualMessageResult.message(message);

    // Assert
    assertSame(actualMessageResult2, actualMessageResult2.outcome(CommandOutcome.SUCCESS));
  }

  /**
   * Test Builder {@link Builder#errors(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#errors(Map)}
   */
  @Test
  @DisplayName("Test Builder errors(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errors(Map)"})
  void testBuilderErrors_givenFoo_whenHashMapFooIsFoo_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.errors(entries));
  }

  /**
   * Test Builder {@link Builder#errors(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#errors(Map)}
   */
  @Test
  @DisplayName("Test Builder errors(Map); when HashMap(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errors(Map)"})
  void testBuilderErrors_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommandResponse)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommandResponse); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommandResponse)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommandResponse)}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommandResponse); given EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommandResponse)"})
  void testBuilderFrom_givenEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommandResponse)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code instance} is {@code instance}.</li>
   *   <li>Then return build errors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommandResponse); given HashMap() 'instance' is 'instance'; then return build errors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommandResponse)"})
  void testBuilderFrom_givenHashMapInstanceIsInstance_thenReturnBuildErrorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("instance", "instance");
    PhysicalFlowUploadCommandResponse instance = mock(PhysicalFlowUploadCommandResponse.class);
    when(instance.errors()).thenReturn(stringStringMap);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(null);
    when(instance.parsedFlow()).thenReturn(new ImmutablePhysicalFlowParsed.Json());
    when(instance.outcome()).thenReturn(CommandOutcome.SUCCESS);
    when(instance.originalCommand()).thenReturn(new ImmutablePhysicalFlowUploadCommand.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).originalCommand();
    verify(instance).outcome();
    verify(instance).entityReference();
    verify(instance).errors();
    verify(instance).parsedFlow();
    Map<String, String> errorsResult = actualFromResult.build().errors();
    assertEquals(1, errorsResult.size());
    assertEquals("instance", errorsResult.get("instance"));
    Map<String, String> errorsResult2 = builderResult.build().errors();
    assertEquals(1, errorsResult2.size());
    assertEquals("instance", errorsResult2.get("instance"));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommandResponse)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then builder build entityReference is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommandResponse); given HashMap(); then builder build entityReference is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommandResponse)"})
  void testBuilderFrom_givenHashMap_thenBuilderBuildEntityReferenceIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommandResponse)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommandResponse); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommandResponse)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();
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
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Test Builder {@link Builder#originalCommand(PhysicalFlowUploadCommand)}.
   * <ul>
   *   <li>When {@link ImmutablePhysicalFlowUploadCommand.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#originalCommand(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder originalCommand(PhysicalFlowUploadCommand); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.originalCommand(PhysicalFlowUploadCommand)"})
  void testBuilderOriginalCommand_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(new ImmutablePhysicalFlowUploadCommand.Json()));
  }

  /**
   * Test Builder {@link Builder#parsedFlow(PhysicalFlowParsed)}.
   * <ul>
   *   <li>When {@link ImmutablePhysicalFlowParsed.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parsedFlow(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder parsedFlow(PhysicalFlowParsed); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parsedFlow(PhysicalFlowParsed)"})
  void testBuilderParsedFlow_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedFlow(new ImmutablePhysicalFlowParsed.Json()));
  }

  /**
   * Test Builder {@link Builder#putAllErrors(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putAllErrors(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllErrors(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putAllErrors(Map)"})
  void testBuilderPutAllErrors_givenFoo_whenHashMapFooIsFoo_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.putAllErrors(entries));
  }

  /**
   * Test Builder {@link Builder#putAllErrors(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putAllErrors(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllErrors(Map); when HashMap(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putAllErrors(Map)"})
  void testBuilderPutAllErrors_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putAllErrors(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#putErrors(Entry)} with {@code entry}.
   * <ul>
   *   <li>When {@link SimpleEntry#SimpleEntry(Object, Object)} with {@code foo} and {@code foo}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putErrors(Entry)}
   */
  @Test
  @DisplayName("Test Builder putErrors(Entry) with 'entry'; when SimpleEntry(Object, Object) with 'foo' and 'foo'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putErrors(Entry)"})
  void testBuilderPutErrorsWithEntry_whenSimpleEntryWithFooAndFoo_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putErrors(new SimpleEntry<>("foo", "foo")));
  }

  /**
   * Test Builder {@link Builder#putErrors(String, String)} with {@code key}, {@code value}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putErrors(String, String)}
   */
  @Test
  @DisplayName("Test Builder putErrors(String, String) with 'key', 'value'; when 'Key'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putErrors(String, String)"})
  void testBuilderPutErrorsWithKeyValue_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putErrors("Key", "42"));
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
   * Test Json {@link Json#errors()}.
   * <p>
   * Method under test: {@link Json#errors()}
   */
  @Test
  @DisplayName("Test Json errors()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map Json.errors()"})
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errors());
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
    assertNull(actualJson.parsedFlow);
    assertNull(actualJson.originalCommand);
    assertFalse(actualJson.message.isPresent());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Test Json {@link Json#originalCommand()}.
   * <p>
   * Method under test: {@link Json#originalCommand()}
   */
  @Test
  @DisplayName("Test Json originalCommand()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalFlowUploadCommand Json.originalCommand()"})
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

  /**
   * Test Json {@link Json#parsedFlow()}.
   * <p>
   * Method under test: {@link Json#parsedFlow()}
   */
  @Test
  @DisplayName("Test Json parsedFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalFlowParsed Json.parsedFlow()"})
  void testJsonParsedFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parsedFlow());
  }
}
