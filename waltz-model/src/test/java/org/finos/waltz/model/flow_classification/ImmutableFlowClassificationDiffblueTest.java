package org.finos.waltz.model.flow_classification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#defaultMessage(String)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#direction(FlowDirection)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#messageSeverity(MessageSeverity)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification Builder.build()",
    "Builder Builder.defaultMessage(String)",
    "Builder Builder.description(String)",
    "Builder Builder.direction(FlowDirection)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.messageSeverity(MessageSeverity)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableFlowClassification actualImmutableFlowClassification =
        actualIdResult
            .id(id)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Assert
    assertEquals("Code", actualImmutableFlowClassification.code());
    assertEquals("Color", actualImmutableFlowClassification.color());
    assertEquals("Default Message", actualImmutableFlowClassification.defaultMessage());
    assertEquals("Name", actualImmutableFlowClassification.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableFlowClassification.description());
    assertEquals(1, actualImmutableFlowClassification.position());
    assertEquals(EntityKind.ALL, actualImmutableFlowClassification.kind());
    assertEquals(FlowDirection.INBOUND, actualImmutableFlowClassification.direction());
    assertEquals(MessageSeverity.NONE, actualImmutableFlowClassification.messageSeverity());
    assertTrue(actualImmutableFlowClassification.isCustom());
    assertTrue(actualImmutableFlowClassification.userSelectable());
  }

  /**
   * Test Builder {@link Builder#code(String)}.
   *
   * <ul>
   *   <li>When {@code Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String); when 'Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode_whenCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act
    Builder actualCodeResult = builderResult.code("Code");

    // Assert
    assertSame(builderResult, actualCodeResult);
  }

  /**
   * Test Builder {@link Builder#color(String)}.
   *
   * <ul>
   *   <li>When {@code Color}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#color(String)}
   */
  @Test
  @DisplayName("Test Builder color(String); when 'Color'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.color(String)"})
  void testBuilderColor_whenColor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act
    Builder actualColorResult = builderResult.color("Color");

    // Assert
    assertSame(builderResult, actualColorResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll() {
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage(null)
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description(null)
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassification)} with {@code FlowClassification}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassification) with 'FlowClassification'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassification)"})
  void testBuilderFromWithFlowClassification4() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(false)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage(null)
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description(null)
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider4() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(false)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableFlowClassification actualImmutableFlowClassification = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassification);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
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
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isCustom(boolean)}.
   *
   * <p>Method under test: {@link Builder#isCustom(boolean)}
   */
  @Test
  @DisplayName("Test Builder isCustom(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isCustom(boolean)"})
  void testBuilderIsCustom() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act
    Builder actualIsCustomResult = builderResult.isCustom(true);

    // Assert
    assertSame(builderResult, actualIsCustomResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#userSelectable(boolean)}.
   *
   * <p>Method under test: {@link Builder#userSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Builder userSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userSelectable(boolean)"})
  void testBuilderUserSelectable() {
    // Arrange
    Builder builderResult = ImmutableFlowClassification.builder();

    // Act
    Builder actualUserSelectableResult = builderResult.userSelectable(true);

    // Assert
    assertSame(builderResult, actualUserSelectableResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#copyOf(FlowClassification)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#copyOf(FlowClassification)}
   */
  @Test
  @DisplayName("Test copyOf(FlowClassification); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.copyOf(FlowClassification)"
  })
  void testCopyOf_thenReturnCode() {
    // Arrange
    ImmutableFlowClassification instance =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualCopyOfResult = ImmutableFlowClassification.copyOf(instance);

    // Assert
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
   * Test {@link ImmutableFlowClassification#direction()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#direction()}
   */
  @Test
  @DisplayName("Test direction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowDirection ImmutableFlowClassification.direction()"})
  void testDirection() {
    // Arrange, Act and Assert
    assertEquals(
        FlowDirection.INBOUND,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .direction());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}, and {@link
   * ImmutableFlowClassification#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassification#equals(Object)}
   *   <li>{@link ImmutableFlowClassification#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();
    ImmutableFlowClassification immutableFlowClassification2 =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertEquals(immutableFlowClassification, immutableFlowClassification2);
    assertEquals(immutableFlowClassification.hashCode(), immutableFlowClassification2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}, and {@link
   * ImmutableFlowClassification#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassification#equals(Object)}
   *   <li>{@link ImmutableFlowClassification#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertEquals(immutableFlowClassification, immutableFlowClassification);
    int expectedHashCodeResult = immutableFlowClassification.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowClassification.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Name")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Name")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Name")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.OUTBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(2L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(false)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ACTOR)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.INFORMATION)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Code")
            .position(1)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(0)
            .userSelectable(true)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(false)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowClassification,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowClassification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassification.equals(Object)",
    "int ImmutableFlowClassification.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build(),
        "Different type to ImmutableFlowClassification");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassification#code()}
   *   <li>{@link ImmutableFlowClassification#color()}
   *   <li>{@link ImmutableFlowClassification#defaultMessage()}
   *   <li>{@link ImmutableFlowClassification#description()}
   *   <li>{@link ImmutableFlowClassification#isCustom()}
   *   <li>{@link ImmutableFlowClassification#name()}
   *   <li>{@link ImmutableFlowClassification#position()}
   *   <li>{@link ImmutableFlowClassification#userSelectable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableFlowClassification.code()",
    "String ImmutableFlowClassification.color()",
    "String ImmutableFlowClassification.defaultMessage()",
    "String ImmutableFlowClassification.description()",
    "boolean ImmutableFlowClassification.isCustom()",
    "String ImmutableFlowClassification.name()",
    "int ImmutableFlowClassification.position()",
    "boolean ImmutableFlowClassification.userSelectable()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    String actualCodeResult = immutableFlowClassification.code();
    String actualColorResult = immutableFlowClassification.color();
    String actualDefaultMessageResult = immutableFlowClassification.defaultMessage();
    String actualDescriptionResult = immutableFlowClassification.description();
    boolean actualIsCustomResult = immutableFlowClassification.isCustom();
    String actualNameResult = immutableFlowClassification.name();
    int actualPositionResult = immutableFlowClassification.position();

    // Assert
    assertEquals("Code", actualCodeResult);
    assertEquals("Color", actualColorResult);
    assertEquals("Default Message", actualDefaultMessageResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, actualPositionResult);
    assertTrue(actualIsCustomResult);
    assertTrue(immutableFlowClassification.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#id()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowClassification.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#code()}.
   *
   * <p>Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().code());
  }

  /**
   * Test Json {@link Json#color()}.
   *
   * <p>Method under test: {@link Json#color()}
   */
  @Test
  @DisplayName("Test Json color()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.color()"})
  void testJsonColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().color());
  }

  /**
   * Test Json {@link Json#defaultMessage()}.
   *
   * <p>Method under test: {@link Json#defaultMessage()}
   */
  @Test
  @DisplayName("Test Json defaultMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.defaultMessage()"})
  void testJsonDefaultMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().defaultMessage());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#direction()}.
   *
   * <p>Method under test: {@link Json#direction()}
   */
  @Test
  @DisplayName("Test Json direction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowDirection Json.direction()"})
  void testJsonDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().direction());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#isCustom()}.
   *
   * <p>Method under test: {@link Json#isCustom()}
   */
  @Test
  @DisplayName("Test Json isCustom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isCustom()"})
  void testJsonIsCustom() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isCustom());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#messageSeverity()}.
   *
   * <p>Method under test: {@link Json#messageSeverity()}
   */
  @Test
  @DisplayName("Test Json messageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity Json.messageSeverity()"})
  void testJsonMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().messageSeverity());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setIsCustom(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsCustom(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsCustom(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Json setUserSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#userSelectable()}
   */
  @Test
  @DisplayName("Test Json userSelectable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.userSelectable()"})
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#kind()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableFlowClassification.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableFlowClassification#messageSeverity()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#messageSeverity()}
   */
  @Test
  @DisplayName("Test messageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity ImmutableFlowClassification.messageSeverity()"})
  void testMessageSeverity() {
    // Arrange, Act and Assert
    assertEquals(
        MessageSeverity.NONE,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .messageSeverity());
  }

  /**
   * Test {@link ImmutableFlowClassification#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowClassification.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "FlowClassification{id=1, name=Name, code=Code, color=Color, position=1, isCustom=true, userSelectable=true,"
            + " direction=INBOUND, defaultMessage=Default Message, messageSeverity=NONE, kind=ALL}",
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowClassification#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowClassification.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "FlowClassification{id=1, name=Name, code=Code, color=Color, position=1, isCustom=true, userSelectable=true,"
            + " direction=INBOUND, messageSeverity=NONE, kind=ALL}",
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage(null)
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowClassification#withCode(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withCode(String)"})
  void testWithCode() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("42")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithCodeResult = immutableFlowClassification.withCode("42");

    // Assert
    assertSame(immutableFlowClassification, actualWithCodeResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withCode(String)}.
   *
   * <ul>
   *   <li>Then return code is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String); then return code is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withCode(String)"})
  void testWithCode_thenReturnCodeIs42() {
    // Arrange and Act
    ImmutableFlowClassification actualWithCodeResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withCode("42");

    // Assert
    assertEquals("42", actualWithCodeResult.code());
    assertEquals("Color", actualWithCodeResult.color());
    assertEquals("Default Message", actualWithCodeResult.defaultMessage());
    assertEquals("Name", actualWithCodeResult.name());
    assertEquals("The characteristics of someone or something", actualWithCodeResult.description());
    assertEquals(1, actualWithCodeResult.position());
    assertEquals(EntityKind.ALL, actualWithCodeResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithCodeResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithCodeResult.messageSeverity());
    assertTrue(actualWithCodeResult.isCustom());
    assertTrue(actualWithCodeResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withColor(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withColor(String)}
   */
  @Test
  @DisplayName("Test withColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withColor(String)"})
  void testWithColor() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("42")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithColorResult = immutableFlowClassification.withColor("42");

    // Assert
    assertSame(immutableFlowClassification, actualWithColorResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withColor(String)}.
   *
   * <ul>
   *   <li>Then return color is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withColor(String)}
   */
  @Test
  @DisplayName("Test withColor(String); then return color is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withColor(String)"})
  void testWithColor_thenReturnColorIs42() {
    // Arrange and Act
    ImmutableFlowClassification actualWithColorResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withColor("42");

    // Assert
    assertEquals("42", actualWithColorResult.color());
    assertEquals("Code", actualWithColorResult.code());
    assertEquals("Default Message", actualWithColorResult.defaultMessage());
    assertEquals("Name", actualWithColorResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithColorResult.description());
    assertEquals(1, actualWithColorResult.position());
    assertEquals(EntityKind.ALL, actualWithColorResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithColorResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithColorResult.messageSeverity());
    assertTrue(actualWithColorResult.isCustom());
    assertTrue(actualWithColorResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withDefaultMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withDefaultMessage(String)}
   */
  @Test
  @DisplayName("Test withDefaultMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withDefaultMessage(String)"
  })
  void testWithDefaultMessage() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("42")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithDefaultMessageResult =
        immutableFlowClassification.withDefaultMessage("42");

    // Assert
    assertSame(immutableFlowClassification, actualWithDefaultMessageResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withDefaultMessage(String)}.
   *
   * <ul>
   *   <li>Then return defaultMessage is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withDefaultMessage(String)}
   */
  @Test
  @DisplayName("Test withDefaultMessage(String); then return defaultMessage is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withDefaultMessage(String)"
  })
  void testWithDefaultMessage_thenReturnDefaultMessageIs42() {
    // Arrange and Act
    ImmutableFlowClassification actualWithDefaultMessageResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withDefaultMessage("42");

    // Assert
    assertEquals("42", actualWithDefaultMessageResult.defaultMessage());
    assertEquals("Code", actualWithDefaultMessageResult.code());
    assertEquals("Color", actualWithDefaultMessageResult.color());
    assertEquals("Name", actualWithDefaultMessageResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithDefaultMessageResult.description());
    assertEquals(1, actualWithDefaultMessageResult.position());
    assertEquals(EntityKind.ALL, actualWithDefaultMessageResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithDefaultMessageResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithDefaultMessageResult.messageSeverity());
    assertTrue(actualWithDefaultMessageResult.isCustom());
    assertTrue(actualWithDefaultMessageResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithDescriptionResult =
        immutableFlowClassification.withDescription("42");

    // Assert
    assertEquals(immutableFlowClassification, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("42")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithDescriptionResult =
        immutableFlowClassification.withDescription("42");

    // Assert
    assertSame(immutableFlowClassification, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withDirection(FlowDirection)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withDirection(FlowDirection)}
   */
  @Test
  @DisplayName("Test withDirection(FlowDirection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withDirection(FlowDirection)"
  })
  void testWithDirection() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithDirectionResult =
        immutableFlowClassification.withDirection(FlowDirection.INBOUND);

    // Assert
    assertSame(immutableFlowClassification, actualWithDirectionResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withDirection(FlowDirection)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withDirection(FlowDirection)}
   */
  @Test
  @DisplayName("Test withDirection(FlowDirection); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withDirection(FlowDirection)"
  })
  void testWithDirection_thenReturnCode() {
    // Arrange and Act
    ImmutableFlowClassification actualWithDirectionResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.OUTBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withDirection(FlowDirection.INBOUND);

    // Assert
    assertEquals("Code", actualWithDirectionResult.code());
    assertEquals("Color", actualWithDirectionResult.color());
    assertEquals("Default Message", actualWithDirectionResult.defaultMessage());
    assertEquals("Name", actualWithDirectionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithDirectionResult.description());
    assertEquals(1, actualWithDirectionResult.position());
    assertEquals(EntityKind.ALL, actualWithDirectionResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithDirectionResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithDirectionResult.messageSeverity());
    assertTrue(actualWithDirectionResult.isCustom());
    assertTrue(actualWithDirectionResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowClassification actualWithIdResult = immutableFlowClassification.withId(optional);

    // Assert
    assertSame(immutableFlowClassification, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withId(Optional)"})
  void testWithIdWithOptional_thenReturnCode() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(2L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowClassification actualWithIdResult = immutableFlowClassification.withId(optional);

    // Assert
    assertEquals("Code", actualWithIdResult.code());
    assertEquals("Color", actualWithIdResult.color());
    assertEquals("Default Message", actualWithIdResult.defaultMessage());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithIdResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithIdResult.messageSeverity());
    assertTrue(actualWithIdResult.isCustom());
    assertTrue(actualWithIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithIdResult = immutableFlowClassification.withId(1L);

    // Assert
    assertSame(immutableFlowClassification, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnCode() {
    // Arrange and Act
    ImmutableFlowClassification actualWithIdResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Code", actualWithIdResult.code());
    assertEquals("Color", actualWithIdResult.color());
    assertEquals("Default Message", actualWithIdResult.defaultMessage());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithIdResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithIdResult.messageSeverity());
    assertTrue(actualWithIdResult.isCustom());
    assertTrue(actualWithIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withIsCustom(boolean)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withIsCustom(boolean)}
   */
  @Test
  @DisplayName("Test withIsCustom(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withIsCustom(boolean)"
  })
  void testWithIsCustom() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithIsCustomResult =
        immutableFlowClassification.withIsCustom(true);

    // Assert
    assertSame(immutableFlowClassification, actualWithIsCustomResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withIsCustom(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withIsCustom(boolean)}
   */
  @Test
  @DisplayName("Test withIsCustom(boolean); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withIsCustom(boolean)"
  })
  void testWithIsCustom_thenReturnCode() {
    // Arrange and Act
    ImmutableFlowClassification actualWithIsCustomResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(false)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withIsCustom(true);

    // Assert
    assertEquals("Code", actualWithIsCustomResult.code());
    assertEquals("Color", actualWithIsCustomResult.color());
    assertEquals("Default Message", actualWithIsCustomResult.defaultMessage());
    assertEquals("Name", actualWithIsCustomResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsCustomResult.description());
    assertEquals(1, actualWithIsCustomResult.position());
    assertEquals(EntityKind.ALL, actualWithIsCustomResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithIsCustomResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithIsCustomResult.messageSeverity());
    assertTrue(actualWithIsCustomResult.isCustom());
    assertTrue(actualWithIsCustomResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithKindResult =
        immutableFlowClassification.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableFlowClassification, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withKind(EntityKind)"
  })
  void testWithKind_thenReturnCode() {
    // Arrange and Act
    ImmutableFlowClassification actualWithKindResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ACTOR)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Code", actualWithKindResult.code());
    assertEquals("Color", actualWithKindResult.color());
    assertEquals("Default Message", actualWithKindResult.defaultMessage());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1, actualWithKindResult.position());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithKindResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithKindResult.messageSeverity());
    assertTrue(actualWithKindResult.isCustom());
    assertTrue(actualWithKindResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withMessageSeverity(MessageSeverity)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withMessageSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName("Test withMessageSeverity(MessageSeverity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withMessageSeverity(MessageSeverity)"
  })
  void testWithMessageSeverity() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithMessageSeverityResult =
        immutableFlowClassification.withMessageSeverity(MessageSeverity.NONE);

    // Assert
    assertSame(immutableFlowClassification, actualWithMessageSeverityResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withMessageSeverity(MessageSeverity)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withMessageSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName("Test withMessageSeverity(MessageSeverity); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withMessageSeverity(MessageSeverity)"
  })
  void testWithMessageSeverity_thenReturnCode() {
    // Arrange and Act
    ImmutableFlowClassification actualWithMessageSeverityResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.INFORMATION)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withMessageSeverity(MessageSeverity.NONE);

    // Assert
    assertEquals("Code", actualWithMessageSeverityResult.code());
    assertEquals("Color", actualWithMessageSeverityResult.color());
    assertEquals("Default Message", actualWithMessageSeverityResult.defaultMessage());
    assertEquals("Name", actualWithMessageSeverityResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithMessageSeverityResult.description());
    assertEquals(1, actualWithMessageSeverityResult.position());
    assertEquals(EntityKind.ALL, actualWithMessageSeverityResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithMessageSeverityResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithMessageSeverityResult.messageSeverity());
    assertTrue(actualWithMessageSeverityResult.isCustom());
    assertTrue(actualWithMessageSeverityResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("42")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithNameResult = immutableFlowClassification.withName("42");

    // Assert
    assertSame(immutableFlowClassification, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableFlowClassification actualWithNameResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Code", actualWithNameResult.code());
    assertEquals("Color", actualWithNameResult.color());
    assertEquals("Default Message", actualWithNameResult.defaultMessage());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.position());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithNameResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithNameResult.messageSeverity());
    assertTrue(actualWithNameResult.isCustom());
    assertTrue(actualWithNameResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(42)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithPositionResult =
        immutableFlowClassification.withPosition(42);

    // Assert
    assertSame(immutableFlowClassification, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassification ImmutableFlowClassification.withPosition(int)"})
  void testWithPosition_thenReturnCode() {
    // Arrange and Act
    ImmutableFlowClassification actualWithPositionResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Code", actualWithPositionResult.code());
    assertEquals("Color", actualWithPositionResult.color());
    assertEquals("Default Message", actualWithPositionResult.defaultMessage());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(EntityKind.ALL, actualWithPositionResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithPositionResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithPositionResult.messageSeverity());
    assertTrue(actualWithPositionResult.isCustom());
    assertTrue(actualWithPositionResult.userSelectable());
  }

  /**
   * Test {@link ImmutableFlowClassification#withUserSelectable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test withUserSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withUserSelectable(boolean)"
  })
  void testWithUserSelectable() {
    // Arrange
    ImmutableFlowClassification immutableFlowClassification =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build();

    // Act
    ImmutableFlowClassification actualWithUserSelectableResult =
        immutableFlowClassification.withUserSelectable(true);

    // Assert
    assertSame(immutableFlowClassification, actualWithUserSelectableResult);
  }

  /**
   * Test {@link ImmutableFlowClassification#withUserSelectable(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassification#withUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test withUserSelectable(boolean); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassification ImmutableFlowClassification.withUserSelectable(boolean)"
  })
  void testWithUserSelectable_thenReturnCode() {
    // Arrange and Act
    ImmutableFlowClassification actualWithUserSelectableResult =
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(false)
            .build()
            .withUserSelectable(true);

    // Assert
    assertEquals("Code", actualWithUserSelectableResult.code());
    assertEquals("Color", actualWithUserSelectableResult.color());
    assertEquals("Default Message", actualWithUserSelectableResult.defaultMessage());
    assertEquals("Name", actualWithUserSelectableResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithUserSelectableResult.description());
    assertEquals(1, actualWithUserSelectableResult.position());
    assertEquals(EntityKind.ALL, actualWithUserSelectableResult.kind());
    assertEquals(FlowDirection.INBOUND, actualWithUserSelectableResult.direction());
    assertEquals(MessageSeverity.NONE, actualWithUserSelectableResult.messageSeverity());
    assertTrue(actualWithUserSelectableResult.isCustom());
    assertTrue(actualWithUserSelectableResult.userSelectable());
  }
}
