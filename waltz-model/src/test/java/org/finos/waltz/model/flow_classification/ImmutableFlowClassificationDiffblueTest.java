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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification.Builder;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationDiffblueTest {
  /**
   * Test {@link ImmutableFlowClassification#builder()}.
   * <p>
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
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassification Builder.build()", "Builder Builder.defaultMessage(String)",
      "Builder Builder.description(String)", "Builder Builder.direction(FlowDirection)",
      "Builder Builder.kind(EntityKind)", "Builder Builder.messageSeverity(MessageSeverity)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableFlowClassification.builder()
        .defaultMessage("Default Message")
        .description("The characteristics of someone or something")
        .direction(FlowDirection.INBOUND)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);

    // Assert
    assertSame(actualKindResult, actualKindResult.messageSeverity(MessageSeverity.NONE));
  }

  /**
   * Test Builder {@link Builder#code(String)}.
   * <p>
   * Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Test Builder {@link Builder#color(String)}.
   * <p>
   * Method under test: {@link Builder#color(String)}
   */
  @Test
  @DisplayName("Test Builder color(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.color(String)"})
  void testBuilderColor() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.color("Color"));
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
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder builderResult = ImmutableFlowClassification.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   * <p>
   * Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   * <ul>
   *   <li>Then builder build defaultMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'; then builder build defaultMessage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification_thenBuilderBuildDefaultMessageIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder builderResult = ImmutableFlowClassification.builder();
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
    Builder builderResult = ImmutableFlowClassification.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableFlowClassification.builder();

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
    Builder builderResult = ImmutableFlowClassification.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isCustom(boolean)}.
   * <p>
   * Method under test: {@link Builder#isCustom(boolean)}
   */
  @Test
  @DisplayName("Test Builder isCustom(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isCustom(boolean)"})
  void testBuilderIsCustom() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isCustom(true));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#userSelectable(boolean)}.
   * <p>
   * Method under test: {@link Builder#userSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Builder userSelectable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userSelectable(boolean)"})
  void testBuilderUserSelectable() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userSelectable(true));
  }

  /**
   * Test Json {@link Json#code()}.
   * <p>
   * Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).code());
  }

  /**
   * Test Json {@link Json#color()}.
   * <p>
   * Method under test: {@link Json#color()}
   */
  @Test
  @DisplayName("Test Json color()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.color()"})
  void testJsonColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).color());
  }

  /**
   * Test Json {@link Json#defaultMessage()}.
   * <p>
   * Method under test: {@link Json#defaultMessage()}
   */
  @Test
  @DisplayName("Test Json defaultMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.defaultMessage()"})
  void testJsonDefaultMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).defaultMessage());
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
   * Test Json {@link Json#direction()}.
   * <p>
   * Method under test: {@link Json#direction()}
   */
  @Test
  @DisplayName("Test Json direction()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowDirection Json.direction()"})
  void testJsonDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).direction());
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
   * Test Json {@link Json#isCustom()}.
   * <p>
   * Method under test: {@link Json#isCustom()}
   */
  @Test
  @DisplayName("Test Json isCustom()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isCustom()"})
  void testJsonIsCustom() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isCustom());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#messageSeverity()}.
   * <p>
   * Method under test: {@link Json#messageSeverity()}
   */
  @Test
  @DisplayName("Test Json messageSeverity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MessageSeverity Json.messageSeverity()"})
  void testJsonMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).messageSeverity());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
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
   * Test Json {@link Json#position()}.
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test Json {@link Json#setIsCustom(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsCustom(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsCustom(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsCustom(boolean)"})
  void testJsonSetIsCustom() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsCustom(true);

    // Assert
    assertTrue(json.isCustom);
    assertTrue(json.isCustomIsSet);
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   * <p>
   * Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test Json {@link Json#setUserSelectable(boolean)}.
   * <p>
   * Method under test: {@link Json#setUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Json setUserSelectable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setUserSelectable(boolean)"})
  void testJsonSetUserSelectable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setUserSelectable(true);

    // Assert
    assertTrue(json.userSelectable);
    assertTrue(json.userSelectableIsSet);
  }

  /**
   * Test Json {@link Json#userSelectable()}.
   * <p>
   * Method under test: {@link Json#userSelectable()}
   */
  @Test
  @DisplayName("Test Json userSelectable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.userSelectable()"})
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userSelectable());
  }
}
