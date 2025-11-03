package org.finos.waltz.model.flow_classification_rule;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleUpdateCommand.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleUpdateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleUpdateCommandDiffblueTest {
  /**
   * Test {@link ImmutableFlowClassificationRuleUpdateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#builder()}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#description(String)}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#message(String)}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#severity(MessageSeverity)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRuleUpdateCommand Builder.build()",
      "Builder Builder.description(String)", "Builder Builder.message(String)",
      "Builder Builder.severity(MessageSeverity)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableFlowClassificationRuleUpdateCommand.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualMessageResult = actualIdResult.id(id).message("Not all who wander are lost");

    // Assert
    assertSame(actualMessageResult, actualMessageResult.severity(MessageSeverity.NONE));
  }

  /**
   * Test Builder {@link Builder#classificationId(long)}.
   * <p>
   * Method under test: {@link Builder#classificationId(long)}
   */
  @Test
  @DisplayName("Test Builder classificationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.classificationId(long)"})
  void testBuilderClassificationId() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

    // Act
    Builder actualClassificationIdResult = builderResult.classificationId(1L);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand buildResult = builderResult.build();
    assertNull(buildResult.description());
    assertNull(buildResult.message());
    assertNull(buildResult.severity());
    assertEquals(1L, buildResult.classificationId());
    assertSame(builderResult, actualClassificationIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code FlowClassificationRuleUpdateCommand}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).classificationId();
    verify(instance).message();
    verify(instance).severity();
    ImmutableFlowClassificationRuleUpdateCommand buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.classificationId());
    assertEquals(MessageSeverity.NONE, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code FlowClassificationRuleUpdateCommand}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).classificationId();
    verify(instance).message();
    verify(instance).severity();
    ImmutableFlowClassificationRuleUpdateCommand buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.classificationId());
    assertEquals(MessageSeverity.NONE, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code FlowClassificationRuleUpdateCommand}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).classificationId();
    verify(instance).message();
    verify(instance).severity();
    ImmutableFlowClassificationRuleUpdateCommand buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.message());
    assertEquals(1L, buildResult.classificationId());
    assertEquals(MessageSeverity.NONE, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code FlowClassificationRuleUpdateCommand}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand4() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).classificationId();
    verify(instance).message();
    verify(instance).severity();
    ImmutableFlowClassificationRuleUpdateCommand buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.severity());
    assertEquals(1L, buildResult.classificationId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleUpdateCommand)} with {@code FlowClassificationRuleUpdateCommand}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleUpdateCommand) with 'FlowClassificationRuleUpdateCommand'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleUpdateCommand)"})
  void testBuilderFromWithFlowClassificationRuleUpdateCommand_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).classificationId();
    verify(instance).message();
    verify(instance).severity();
    ImmutableFlowClassificationRuleUpdateCommand buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.classificationId());
    assertEquals(MessageSeverity.NONE, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Json {@link Json#classificationId()}.
   * <p>
   * Method under test: {@link Json#classificationId()}
   */
  @Test
  @DisplayName("Test Json classificationId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.classificationId()"})
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).classificationId());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.message()"})
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
    assertNull(actualJson.description);
    assertNull(actualJson.message);
    assertNull(actualJson.severity);
    assertEquals(0L, actualJson.classificationId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.classificationIdIsSet);
  }

  /**
   * Test Json {@link Json#setClassificationId(long)}.
   * <p>
   * Method under test: {@link Json#setClassificationId(long)}
   */
  @Test
  @DisplayName("Test Json setClassificationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setClassificationId(long)"})
  void testJsonSetClassificationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setClassificationId(1L);

    // Assert
    assertEquals(1L, json.classificationId);
    assertTrue(json.classificationIdIsSet);
  }

  /**
   * Test Json {@link Json#severity()}.
   * <p>
   * Method under test: {@link Json#severity()}
   */
  @Test
  @DisplayName("Test Json severity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MessageSeverity Json.severity()"})
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).severity());
  }
}
