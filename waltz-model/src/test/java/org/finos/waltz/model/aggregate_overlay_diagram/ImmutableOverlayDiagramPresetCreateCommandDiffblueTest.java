package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramPresetCreateCommand.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramPresetCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramPresetCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOverlayDiagramPresetCreateCommand actualImmutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Assert
    assertEquals("42", actualImmutableOverlayDiagramPresetCreateCommand.externalId());
    assertEquals("Filter Config", actualImmutableOverlayDiagramPresetCreateCommand.filterConfig());
    assertEquals("Name", actualImmutableOverlayDiagramPresetCreateCommand.name());
    assertEquals(
        "Overlay Config", actualImmutableOverlayDiagramPresetCreateCommand.overlayConfig());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableOverlayDiagramPresetCreateCommand.description());
    assertEquals(1L, actualImmutableOverlayDiagramPresetCreateCommand.diagramId().longValue());
  }

  /**
   * Test Builder {@link Builder#diagramId(Long)}.
   *
   * <p>Method under test: {@link Builder#diagramId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(Long)"})
  void testBuilderDiagramId() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#filterConfig(String)}.
   *
   * <ul>
   *   <li>When {@code Filter Config}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#filterConfig(String)}
   */
  @Test
  @DisplayName("Test Builder filterConfig(String); when 'Filter Config'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.filterConfig(String)"})
  void testBuilderFilterConfig_whenFilterConfig_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act
    Builder actualFilterConfigResult = builderResult.filterConfig("Filter Config");

    // Assert
    assertSame(builderResult, actualFilterConfigResult);
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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    ImmutableOverlayDiagramPresetCreateCommand instance =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableOverlayDiagramPresetCreateCommand actualImmutableOverlayDiagramPresetCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramPresetCreateCommand);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    ImmutableOverlayDiagramPresetCreateCommand instance =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableOverlayDiagramPresetCreateCommand actualImmutableOverlayDiagramPresetCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramPresetCreateCommand);
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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    ImmutableOverlayDiagramPresetCreateCommand instance =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description(null)
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableOverlayDiagramPresetCreateCommand actualImmutableOverlayDiagramPresetCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramPresetCreateCommand);
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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramPresetCreateCommand)} with {@code
   * OverlayDiagramPresetCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramPresetCreateCommand) with 'OverlayDiagramPresetCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramPresetCreateCommand)"})
  void testBuilderFromWithOverlayDiagramPresetCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    ImmutableOverlayDiagramPresetCreateCommand instance =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramPresetCreateCommand actualImmutableOverlayDiagramPresetCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramPresetCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramPresetCreateCommand)} with {@code
   * OverlayDiagramPresetCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramPresetCreateCommand) with 'OverlayDiagramPresetCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramPresetCreateCommand)"})
  void testBuilderFromWithOverlayDiagramPresetCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    ImmutableOverlayDiagramPresetCreateCommand instance =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description(null)
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramPresetCreateCommand actualImmutableOverlayDiagramPresetCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramPresetCreateCommand);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#overlayConfig(String)}.
   *
   * <ul>
   *   <li>When {@code Overlay Config}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#overlayConfig(String)}
   */
  @Test
  @DisplayName("Test Builder overlayConfig(String); when 'Overlay Config'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overlayConfig(String)"})
  void testBuilderOverlayConfig_whenOverlayConfig_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act
    Builder actualOverlayConfigResult = builderResult.overlayConfig("Overlay Config");

    // Assert
    assertSame(builderResult, actualOverlayConfigResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramPresetCreateCommand#copyOf(OverlayDiagramPresetCreateCommand)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramPresetCreateCommand#copyOf(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(OverlayDiagramPresetCreateCommand); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.copyOf(OverlayDiagramPresetCreateCommand)"
  })
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand instance =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualCopyOfResult =
        ImmutableOverlayDiagramPresetCreateCommand.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Filter Config", actualCopyOfResult.filterConfig());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Overlay Config", actualCopyOfResult.overlayConfig());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}, and {@link
   * ImmutableOverlayDiagramPresetCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand2 =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramPresetCreateCommand, immutableOverlayDiagramPresetCreateCommand2);
    assertEquals(
        immutableOverlayDiagramPresetCreateCommand.hashCode(),
        immutableOverlayDiagramPresetCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}, and {@link
   * ImmutableOverlayDiagramPresetCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramPresetCreateCommand, immutableOverlayDiagramPresetCreateCommand);
    int expectedHashCodeResult = immutableOverlayDiagramPresetCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramPresetCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(2L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramPresetCreateCommand,
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("Name")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramPresetCreateCommand,
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Name")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramPresetCreateCommand,
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("42")
            .overlayConfig("Overlay Config")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramPresetCreateCommand,
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramPresetCreateCommand,
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramPresetCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramPresetCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build(),
        "Different type to ImmutableOverlayDiagramPresetCreateCommand");
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    json.setDiagramId(1L);
    json.setExternalId("Json");
    json.setOverlayConfig("Json");
    json.setFilterConfig("Json");

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualFromJsonResult =
        ImmutableOverlayDiagramPresetCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.filterConfig());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.overlayConfig());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    json.setDiagramId(1L);
    json.setExternalId("Json");
    json.setOverlayConfig("Json");
    json.setFilterConfig("Json");

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualFromJsonResult =
        ImmutableOverlayDiagramPresetCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.filterConfig());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.overlayConfig());
    assertNull(actualFromJsonResult.description());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#toString()}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#description()}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#diagramId()}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#externalId()}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#filterConfig()}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#name()}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#overlayConfig()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableOverlayDiagramPresetCreateCommand.description()",
    "Long ImmutableOverlayDiagramPresetCreateCommand.diagramId()",
    "String ImmutableOverlayDiagramPresetCreateCommand.externalId()",
    "String ImmutableOverlayDiagramPresetCreateCommand.filterConfig()",
    "String ImmutableOverlayDiagramPresetCreateCommand.name()",
    "String ImmutableOverlayDiagramPresetCreateCommand.overlayConfig()",
    "String ImmutableOverlayDiagramPresetCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramPresetCreateCommand.toString();
    String actualDescriptionResult = immutableOverlayDiagramPresetCreateCommand.description();
    Long actualDiagramIdResult = immutableOverlayDiagramPresetCreateCommand.diagramId();
    String actualExternalIdResult = immutableOverlayDiagramPresetCreateCommand.externalId();
    String actualFilterConfigResult = immutableOverlayDiagramPresetCreateCommand.filterConfig();
    String actualNameResult = immutableOverlayDiagramPresetCreateCommand.name();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals("Filter Config", actualFilterConfigResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Overlay Config", immutableOverlayDiagramPresetCreateCommand.overlayConfig());
    assertEquals(
        "OverlayDiagramPresetCreateCommand{name=Name, diagramId=1, externalId=42, overlayConfig=Overlay Config,"
            + " filterConfig=Filter Config}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualDiagramIdResult.longValue());
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
   * Test Json {@link Json#diagramId()}.
   *
   * <p>Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramId());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#filterConfig()}.
   *
   * <p>Method under test: {@link Json#filterConfig()}
   */
  @Test
  @DisplayName("Test Json filterConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.filterConfig()"})
  void testJsonFilterConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().filterConfig());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setDiagramId(Long)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setFilterConfig(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setOverlayConfig(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setDiagramId(Long)",
    "void Json.setExternalId(String)",
    "void Json.setFilterConfig(String)",
    "void Json.setName(String)",
    "void Json.setOverlayConfig(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setDiagramId(1L);
    actualJson.setExternalId("42");
    actualJson.setFilterConfig("Filter Config");
    actualJson.setName("Name");
    actualJson.setOverlayConfig("Overlay Config");

    // Assert
    assertEquals(1L, actualJson.diagramId.longValue());
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
   * Test Json {@link Json#overlayConfig()}.
   *
   * <p>Method under test: {@link Json#overlayConfig()}
   */
  @Test
  @DisplayName("Test Json overlayConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.overlayConfig()"})
  void testJsonOverlayConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayConfig());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramPresetCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithDescriptionResult =
        immutableOverlayDiagramPresetCreateCommand.withDescription("42");

    // Assert
    assertEquals(immutableOverlayDiagramPresetCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramPresetCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("42")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithDescriptionResult =
        immutableOverlayDiagramPresetCreateCommand.withDescription("42");

    // Assert
    assertSame(immutableOverlayDiagramPresetCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withDiagramId(Long)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#withDiagramId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withDiagramId(Long)"
  })
  void testWithDiagramId() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithDiagramIdResult =
        immutableOverlayDiagramPresetCreateCommand.withDiagramId(1L);

    // Assert
    assertSame(immutableOverlayDiagramPresetCreateCommand, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withDiagramId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#withDiagramId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramId(Long); when forty-two; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withDiagramId(Long)"
  })
  void testWithDiagramId_whenFortyTwo_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithDiagramIdResult =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build()
            .withDiagramId(42L);

    // Assert
    assertEquals("42", actualWithDiagramIdResult.externalId());
    assertEquals("Filter Config", actualWithDiagramIdResult.filterConfig());
    assertEquals("Name", actualWithDiagramIdResult.name());
    assertEquals("Overlay Config", actualWithDiagramIdResult.overlayConfig());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramIdResult.description());
    assertEquals(42L, actualWithDiagramIdResult.diagramId().longValue());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("0123456789ABCDEF")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithExternalIdResult =
        immutableOverlayDiagramPresetCreateCommand.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableOverlayDiagramPresetCreateCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withExternalId(String)"
  })
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithExternalIdResult =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("Filter Config", actualWithExternalIdResult.filterConfig());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Overlay Config", actualWithExternalIdResult.overlayConfig());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.diagramId().longValue());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withFilterConfig(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramPresetCreateCommand#withFilterConfig(String)}
   */
  @Test
  @DisplayName("Test withFilterConfig(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withFilterConfig(String)"
  })
  void testWithFilterConfig() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("42")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithFilterConfigResult =
        immutableOverlayDiagramPresetCreateCommand.withFilterConfig("42");

    // Assert
    assertSame(immutableOverlayDiagramPresetCreateCommand, actualWithFilterConfigResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withFilterConfig(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramPresetCreateCommand#withFilterConfig(String)}
   */
  @Test
  @DisplayName("Test withFilterConfig(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withFilterConfig(String)"
  })
  void testWithFilterConfig_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithFilterConfigResult =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build()
            .withFilterConfig("42");

    // Assert
    assertEquals("42", actualWithFilterConfigResult.externalId());
    assertEquals("42", actualWithFilterConfigResult.filterConfig());
    assertEquals("Name", actualWithFilterConfigResult.name());
    assertEquals("Overlay Config", actualWithFilterConfigResult.overlayConfig());
    assertEquals(
        "The characteristics of someone or something", actualWithFilterConfigResult.description());
    assertEquals(1L, actualWithFilterConfigResult.diagramId().longValue());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("42")
            .overlayConfig("Overlay Config")
            .build();

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithNameResult =
        immutableOverlayDiagramPresetCreateCommand.withName("42");

    // Assert
    assertSame(immutableOverlayDiagramPresetCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramPresetCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withName(String)"
  })
  void testWithName_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithNameResult =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Filter Config", actualWithNameResult.filterConfig());
    assertEquals("Overlay Config", actualWithNameResult.overlayConfig());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.diagramId().longValue());
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withOverlayConfig(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramPresetCreateCommand#withOverlayConfig(String)}
   */
  @Test
  @DisplayName("Test withOverlayConfig(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withOverlayConfig(String)"
  })
  void testWithOverlayConfig() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand immutableOverlayDiagramPresetCreateCommand =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("42")
            .build();

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithOverlayConfigResult =
        immutableOverlayDiagramPresetCreateCommand.withOverlayConfig("42");

    // Assert
    assertSame(immutableOverlayDiagramPresetCreateCommand, actualWithOverlayConfigResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#withOverlayConfig(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramPresetCreateCommand#withOverlayConfig(String)}
   */
  @Test
  @DisplayName("Test withOverlayConfig(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramPresetCreateCommand ImmutableOverlayDiagramPresetCreateCommand.withOverlayConfig(String)"
  })
  void testWithOverlayConfig_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableOverlayDiagramPresetCreateCommand actualWithOverlayConfigResult =
        ImmutableOverlayDiagramPresetCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .name("Name")
            .overlayConfig("Overlay Config")
            .build()
            .withOverlayConfig("42");

    // Assert
    assertEquals("42", actualWithOverlayConfigResult.externalId());
    assertEquals("42", actualWithOverlayConfigResult.overlayConfig());
    assertEquals("Filter Config", actualWithOverlayConfigResult.filterConfig());
    assertEquals("Name", actualWithOverlayConfigResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithOverlayConfigResult.description());
    assertEquals(1L, actualWithOverlayConfigResult.diagramId().longValue());
  }
}
