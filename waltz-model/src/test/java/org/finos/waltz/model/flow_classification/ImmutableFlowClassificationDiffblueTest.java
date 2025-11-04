package org.finos.waltz.model.flow_classification;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassification#builder()}
   *   <li>{@link ImmutableFlowClassification#defaultMessage(String)}
   *   <li>{@link ImmutableFlowClassification#description(String)}
   *   <li>{@link ImmutableFlowClassification#direction(FlowDirection)}
   *   <li>{@link ImmutableFlowClassification#kind(EntityKind)}
   *   <li>{@link ImmutableFlowClassification#messageSeverity(MessageSeverity)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowClassification.Builder actualIdResult = ImmutableFlowClassification.builder()
        .defaultMessage("Default Message")
        .description("The characteristics of someone or something")
        .direction(FlowDirection.INBOUND)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableFlowClassification.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);

    // Assert
    assertSame(actualKindResult, actualKindResult.messageSeverity(MessageSeverity.NONE));
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Builder#code(String)}
   */
  @Test
  void testBuilderCode() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Builder#color(String)}
   */
  @Test
  void testBuilderColor() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.color("Color"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(FlowClassification)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn("Default Message");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    ImmutableFlowClassification buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Color", buildResult.color());
    assertEquals("Default Message", buildResult.defaultMessage());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(FlowDirection.INBOUND, buildResult.direction());
    assertEquals(MessageSeverity.NONE, buildResult.messageSeverity());
    assertTrue(buildResult.isCustom());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(FlowClassification)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(FlowClassification)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    ImmutableFlowClassification buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.defaultMessage());
    assertEquals(1, buildResult.position());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(FlowDirection.INBOUND, buildResult.direction());
    assertEquals(MessageSeverity.NONE, buildResult.messageSeverity());
    assertTrue(buildResult.isCustom());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(FlowClassification)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn("Default Message");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    ImmutableFlowClassification buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Color", buildResult.color());
    assertEquals("Default Message", buildResult.defaultMessage());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(FlowDirection.INBOUND, buildResult.direction());
    assertEquals(MessageSeverity.NONE, buildResult.messageSeverity());
    assertTrue(buildResult.isCustom());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#from(FlowClassification)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn("Default Message");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn(null);
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    ImmutableFlowClassification buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Color", buildResult.color());
    assertEquals("Default Message", buildResult.defaultMessage());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(FlowDirection.INBOUND, buildResult.direction());
    assertEquals(MessageSeverity.NONE, buildResult.messageSeverity());
    assertTrue(buildResult.isCustom());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#isCustom(boolean)}
   */
  @Test
  void testBuilderIsCustom() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isCustom(true));
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Builder#userSelectable(boolean)}
   */
  @Test
  void testBuilderUserSelectable() {
    // Arrange
    ImmutableFlowClassification.Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userSelectable(true));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification#copyOf(FlowClassification)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn("Default Message");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification actualCopyOfResult = ImmutableFlowClassification.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Default Message", actualCopyOfResult.defaultMessage());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(FlowDirection.INBOUND, actualCopyOfResult.direction());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertTrue(actualCopyOfResult.isCustom());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification#copyOf(FlowClassification)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(false);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn("Default Message");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification actualCopyOfResult = ImmutableFlowClassification.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Default Message", actualCopyOfResult.defaultMessage());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(FlowDirection.INBOUND, actualCopyOfResult.direction());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertFalse(actualCopyOfResult.isCustom());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification#copyOf(FlowClassification)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification actualCopyOfResult = ImmutableFlowClassification.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.defaultMessage());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(FlowDirection.INBOUND, actualCopyOfResult.direction());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertTrue(actualCopyOfResult.isCustom());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification#copyOf(FlowClassification)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn("Default Message");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification actualCopyOfResult = ImmutableFlowClassification.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Default Message", actualCopyOfResult.defaultMessage());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(FlowDirection.INBOUND, actualCopyOfResult.direction());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertTrue(actualCopyOfResult.isCustom());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification#copyOf(FlowClassification)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    FlowClassification instance = mock(FlowClassification.class);
    when(instance.isCustom()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.defaultMessage()).thenReturn("Default Message");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.direction()).thenReturn(FlowDirection.INBOUND);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.color()).thenReturn("Color");
    when(instance.description()).thenReturn(null);
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowClassification actualCopyOfResult = ImmutableFlowClassification.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).code();
    verify(instance).color();
    verify(instance).defaultMessage();
    verify(instance).direction();
    verify(instance).isCustom();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).position();
    verify(instance).userSelectable();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Default Message", actualCopyOfResult.defaultMessage());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(FlowDirection.INBOUND, actualCopyOfResult.direction());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertTrue(actualCopyOfResult.isCustom());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#code()}
   */
  @Test
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).code());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#color()}
   */
  @Test
  void testJsonColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).color());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#defaultMessage()}
   */
  @Test
  void testJsonDefaultMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).defaultMessage());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#direction()}
   */
  @Test
  void testJsonDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).direction());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#isCustom()}
   */
  @Test
  void testJsonIsCustom() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).isCustom());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#messageSeverity()}
   */
  @Test
  void testJsonMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).messageSeverity());
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowClassification.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowClassification.Json actualJson = new ImmutableFlowClassification.Json();

    // Assert
    assertNull(actualJson.code);
    assertNull(actualJson.color);
    assertNull(actualJson.defaultMessage);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.kind);
    assertNull(actualJson.direction);
    assertNull(actualJson.messageSeverity);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isCustom);
    assertFalse(actualJson.isCustomIsSet);
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.userSelectable);
    assertFalse(actualJson.userSelectableIsSet);
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Json#setIsCustom(boolean)}
   */
  @Test
  void testJsonSetIsCustom() {
    // Arrange
    ImmutableFlowClassification.Json json = new ImmutableFlowClassification.Json();

    // Act
    json.setIsCustom(true);

    // Assert
    assertTrue(json.isCustom);
    assertTrue(json.isCustomIsSet);
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableFlowClassification.Json json = new ImmutableFlowClassification.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassification.Json#setUserSelectable(boolean)}
   */
  @Test
  void testJsonSetUserSelectable() {
    // Arrange
    ImmutableFlowClassification.Json json = new ImmutableFlowClassification.Json();

    // Act
    json.setUserSelectable(true);

    // Assert
    assertTrue(json.userSelectable);
    assertTrue(json.userSelectableIsSet);
  }

  /**
   * Method under test: {@link ImmutableFlowClassification.Json#userSelectable()}
   */
  @Test
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassification.Json()).userSelectable());
  }
}
