package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramPresetCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#builder()}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableOverlayDiagramPresetCreateCommand.Builder actualBuilderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#diagramId(Long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#filterConfig(String)}
   */
  @Test
  void testBuilderFilterConfig() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filterConfig("Filter Config"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableOverlayDiagramPresetCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableOverlayDiagramPresetCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramPresetCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#from(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();
    OverlayDiagramPresetCreateCommand instance = mock(OverlayDiagramPresetCreateCommand.class);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.filterConfig()).thenReturn("Filter Config");
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramPresetCreateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#from(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();
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
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#from(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();
    OverlayDiagramPresetCreateCommand instance = mock(OverlayDiagramPresetCreateCommand.class);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.filterConfig()).thenReturn("Filter Config");
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.description()).thenReturn(null);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramPresetCreateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Builder#overlayConfig(String)}
   */
  @Test
  void testBuilderOverlayConfig() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Builder builderResult = ImmutableOverlayDiagramPresetCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayConfig("Overlay Config"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand#copyOf(OverlayDiagramPresetCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OverlayDiagramPresetCreateCommand instance = mock(OverlayDiagramPresetCreateCommand.class);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.filterConfig()).thenReturn("Filter Config");
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualCopyOfResult = ImmutableOverlayDiagramPresetCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Filter Config", actualCopyOfResult.filterConfig());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Overlay Config", actualCopyOfResult.overlayConfig());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand#fromJson(ImmutableOverlayDiagramPresetCreateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOverlayDiagramPresetCreateCommand.Json json = new ImmutableOverlayDiagramPresetCreateCommand.Json();
    json.setName("Json");
    json.setDescription(null);
    json.setDiagramId(1L);
    json.setExternalId("Json");
    json.setOverlayConfig("Json");
    json.setFilterConfig("Json");

    // Act
    ImmutableOverlayDiagramPresetCreateCommand actualFromJsonResult = ImmutableOverlayDiagramPresetCreateCommand
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.filterConfig());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.overlayConfig());
    assertNull(actualFromJsonResult.description());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramPresetCreateCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramPresetCreateCommand.Json()).diagramId());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramPresetCreateCommand.Json()).externalId());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#filterConfig()}
   */
  @Test
  void testJsonFilterConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramPresetCreateCommand.Json()).filterConfig());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json}
   *   <li>
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#setDescription(String)}
   *   <li>
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#setDiagramId(Long)}
   *   <li>
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#setExternalId(String)}
   *   <li>
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#setFilterConfig(String)}
   *   <li>{@link ImmutableOverlayDiagramPresetCreateCommand.Json#setName(String)}
   *   <li>
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#setOverlayConfig(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableOverlayDiagramPresetCreateCommand.Json actualJson = new ImmutableOverlayDiagramPresetCreateCommand.Json();
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
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramPresetCreateCommand.Json()).name());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramPresetCreateCommand.Json#overlayConfig()}
   */
  @Test
  void testJsonOverlayConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramPresetCreateCommand.Json()).overlayConfig());
  }
}
