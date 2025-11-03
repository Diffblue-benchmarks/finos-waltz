package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test {@link ImmutableOverlayDiagramPresetCreateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#builder()}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableOverlayDiagramPresetCreateCommand Builder.build()",
      "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#diagramId(Long)}.
   * <p>
   * Method under test: {@link Builder#diagramId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramId(Long)"})
  void testBuilderDiagramId() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   * <p>
   * Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Test Builder {@link Builder#filterConfig(String)}.
   * <p>
   * Method under test: {@link Builder#filterConfig(String)}
   */
  @Test
  @DisplayName("Test Builder filterConfig(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.filterConfig(String)"})
  void testBuilderFilterConfig() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filterConfig("Filter Config"));
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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
   * Test Builder {@link Builder#from(OverlayDiagramPresetCreateCommand)} with {@code OverlayDiagramPresetCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramPresetCreateCommand) with 'OverlayDiagramPresetCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramPresetCreateCommand)"})
  void testBuilderFromWithOverlayDiagramPresetCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    OverlayDiagramPresetCreateCommand instance = mock(OverlayDiagramPresetCreateCommand.class);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.filterConfig()).thenReturn("Filter Config");
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    ImmutableOverlayDiagramPresetCreateCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Filter Config", buildResult.filterConfig());
    assertEquals("Name", buildResult.name());
    assertEquals("Overlay Config", buildResult.overlayConfig());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramPresetCreateCommand)} with {@code OverlayDiagramPresetCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramPresetCreateCommand) with 'OverlayDiagramPresetCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramPresetCreateCommand)"})
  void testBuilderFromWithOverlayDiagramPresetCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    OverlayDiagramPresetCreateCommand instance = mock(OverlayDiagramPresetCreateCommand.class);
    when(instance.diagramId()).thenThrow(new IllegalStateException("instance"));
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).overlayConfig();
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramPresetCreateCommand)} with {@code OverlayDiagramPresetCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramPresetCreateCommand) with 'OverlayDiagramPresetCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramPresetCreateCommand)"})
  void testBuilderFromWithOverlayDiagramPresetCreateCommand3() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();
    OverlayDiagramPresetCreateCommand instance = mock(OverlayDiagramPresetCreateCommand.class);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.filterConfig()).thenReturn("Filter Config");
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.description()).thenReturn(null);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    ImmutableOverlayDiagramPresetCreateCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Filter Config", buildResult.filterConfig());
    assertEquals("Name", buildResult.name());
    assertEquals("Overlay Config", buildResult.overlayConfig());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#overlayConfig(String)}.
   * <p>
   * Method under test: {@link Builder#overlayConfig(String)}
   */
  @Test
  @DisplayName("Test Builder overlayConfig(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.overlayConfig(String)"})
  void testBuilderOverlayConfig() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayConfig("Overlay Config"));
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
   * Test Json {@link Json#diagramId()}.
   * <p>
   * Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagramId());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#filterConfig()}.
   * <p>
   * Method under test: {@link Json#filterConfig()}
   */
  @Test
  @DisplayName("Test Json filterConfig()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.filterConfig()"})
  void testJsonFilterConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).filterConfig());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setDiagramId(Long)",
      "void Json.setExternalId(String)", "void Json.setFilterConfig(String)", "void Json.setName(String)",
      "void Json.setOverlayConfig(String)"})
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
   * Test Json {@link Json#overlayConfig()}.
   * <p>
   * Method under test: {@link Json#overlayConfig()}
   */
  @Test
  @DisplayName("Test Json overlayConfig()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.overlayConfig()"})
  void testJsonOverlayConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).overlayConfig());
  }
}
