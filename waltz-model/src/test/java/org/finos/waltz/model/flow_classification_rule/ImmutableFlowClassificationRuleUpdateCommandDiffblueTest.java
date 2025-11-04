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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.MessageSeverity;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleUpdateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#builder()}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#description(String)}
   *   <li>{@link ImmutableFlowClassificationRuleUpdateCommand#message(String)}
   *   <li>
   * {@link ImmutableFlowClassificationRuleUpdateCommand#severity(MessageSeverity)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualIdResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualMessageResult = actualIdResult.id(id)
        .message("Not all who wander are lost");

    // Assert
    assertSame(actualMessageResult, actualMessageResult.severity(MessageSeverity.NONE));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#classificationId(long)}
   */
  @Test
  void testBuilderClassificationId() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualClassificationIdResult = builderResult
        .classificationId(1L);

    // Assert
    ImmutableFlowClassificationRuleUpdateCommand buildResult = builderResult.build();
    assertNull(buildResult.description());
    assertNull(buildResult.message());
    assertNull(buildResult.severity());
    assertEquals(1L, buildResult.classificationId());
    assertSame(builderResult, actualClassificationIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#from(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(null);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Builder builderResult = ImmutableFlowClassificationRuleUpdateCommand
        .builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand#copyOf(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualCopyOfResult = ImmutableFlowClassificationRuleUpdateCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).classificationId();
    verify(instance).message();
    verify(instance).severity();
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.severity());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand#copyOf(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FlowClassificationRuleUpdateCommand instance = mock(FlowClassificationRuleUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.classificationId()).thenReturn(1L);
    when(instance.severity()).thenReturn(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleUpdateCommand actualCopyOfResult = ImmutableFlowClassificationRuleUpdateCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).classificationId();
    verify(instance).message();
    verify(instance).severity();
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.classificationId());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.severity());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Json#classificationId()}
   */
  @Test
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleUpdateCommand.Json()).classificationId());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleUpdateCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleUpdateCommand.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleUpdateCommand.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowClassificationRuleUpdateCommand.Json actualJson = new ImmutableFlowClassificationRuleUpdateCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.message);
    assertNull(actualJson.severity);
    assertEquals(0L, actualJson.classificationId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.classificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Json#setClassificationId(long)}
   */
  @Test
  void testJsonSetClassificationId() {
    // Arrange
    ImmutableFlowClassificationRuleUpdateCommand.Json json = new ImmutableFlowClassificationRuleUpdateCommand.Json();

    // Act
    json.setClassificationId(1L);

    // Assert
    assertEquals(1L, json.classificationId);
    assertTrue(json.classificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRuleUpdateCommand.Json#severity()}
   */
  @Test
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRuleUpdateCommand.Json()).severity());
  }
}
