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
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommandResponse.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommandResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDeleteCommandResponseDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommandResponse#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#builder()}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#message(String)}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommandResponse#outcome(CommandOutcome)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalFlowDeleteCommandResponse Builder.build()", "Builder Builder.message(String)",
      "Builder Builder.outcome(CommandOutcome)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualMessageResult = ImmutablePhysicalFlowDeleteCommandResponse.builder()
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
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowDeleteCommandResponse)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowDeleteCommandResponse); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowDeleteCommandResponse)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(PhysicalFlowDeleteCommandResponse)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then builder build outcome is {@code SUCCESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowDeleteCommandResponse); given Optional with 'foo'; then builder build outcome is 'SUCCESS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowDeleteCommandResponse)"})
  void testBuilderFrom_givenOptionalWithFoo_thenBuilderBuildOutcomeIsSuccess() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(PhysicalFlowDeleteCommandResponse)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowDeleteCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowDeleteCommandResponse); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowDeleteCommandResponse)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();
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
   * Test Builder {@link Builder#isLastPhysicalFlow(boolean)}.
   * <p>
   * Method under test: {@link Builder#isLastPhysicalFlow(boolean)}
   */
  @Test
  @DisplayName("Test Builder isLastPhysicalFlow(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isLastPhysicalFlow(boolean)"})
  void testBuilderIsLastPhysicalFlow() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isLastPhysicalFlow(true));
  }

  /**
   * Test Builder {@link Builder#isSpecificationUnused(boolean)}.
   * <p>
   * Method under test: {@link Builder#isSpecificationUnused(boolean)}
   */
  @Test
  @DisplayName("Test Builder isSpecificationUnused(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isSpecificationUnused(boolean)"})
  void testBuilderIsSpecificationUnused() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isSpecificationUnused(true));
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
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Test Builder {@link Builder#originalCommand(PhysicalFlowDeleteCommand)}.
   * <ul>
   *   <li>When {@link ImmutablePhysicalFlowDeleteCommand.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#originalCommand(PhysicalFlowDeleteCommand)}
   */
  @Test
  @DisplayName("Test Builder originalCommand(PhysicalFlowDeleteCommand); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.originalCommand(PhysicalFlowDeleteCommand)"})
  void testBuilderOriginalCommand_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommandResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.originalCommand(new ImmutablePhysicalFlowDeleteCommand.Json()));
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
   * Test Json {@link Json#isLastPhysicalFlow()}.
   * <p>
   * Method under test: {@link Json#isLastPhysicalFlow()}
   */
  @Test
  @DisplayName("Test Json isLastPhysicalFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isLastPhysicalFlow()"})
  void testJsonIsLastPhysicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isLastPhysicalFlow());
  }

  /**
   * Test Json {@link Json#isSpecificationUnused()}.
   * <p>
   * Method under test: {@link Json#isSpecificationUnused()}
   */
  @Test
  @DisplayName("Test Json isSpecificationUnused()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isSpecificationUnused()"})
  void testJsonIsSpecificationUnused() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isSpecificationUnused());
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
    assertFalse(actualJson.isLastPhysicalFlow);
    assertFalse(actualJson.isLastPhysicalFlowIsSet);
    assertFalse(actualJson.isSpecificationUnused);
    assertFalse(actualJson.isSpecificationUnusedIsSet);
  }

  /**
   * Test Json {@link Json#originalCommand()}.
   * <p>
   * Method under test: {@link Json#originalCommand()}
   */
  @Test
  @DisplayName("Test Json originalCommand()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalFlowDeleteCommand Json.originalCommand()"})
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
   * Test Json {@link Json#setIsLastPhysicalFlow(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsLastPhysicalFlow(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsLastPhysicalFlow(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsLastPhysicalFlow(boolean)"})
  void testJsonSetIsLastPhysicalFlow() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsLastPhysicalFlow(true);

    // Assert
    assertTrue(json.isLastPhysicalFlow);
    assertTrue(json.isLastPhysicalFlowIsSet);
  }

  /**
   * Test Json {@link Json#setIsSpecificationUnused(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsSpecificationUnused(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsSpecificationUnused(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsSpecificationUnused(boolean)"})
  void testJsonSetIsSpecificationUnused() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsSpecificationUnused(true);

    // Assert
    assertTrue(json.isSpecificationUnused);
    assertTrue(json.isSpecificationUnusedIsSet);
  }
}
