package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramInstanceCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#builder()}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableOverlayDiagramInstanceCreateCommand.Builder actualBuilderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#diagramId(Long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#from(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();
    OverlayDiagramInstanceCreateCommand instance = mock(OverlayDiagramInstanceCreateCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#from(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();
    OverlayDiagramInstanceCreateCommand instance = mock(OverlayDiagramInstanceCreateCommand.class);
    when(instance.svg()).thenReturn("Svg");
    when(instance.diagramId()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).parentEntityReference();
    verify(instance).svg();
    ImmutableOverlayDiagramInstanceCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#from(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();
    OverlayDiagramInstanceCreateCommand instance = mock(OverlayDiagramInstanceCreateCommand.class);
    when(instance.svg()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagramId()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).parentEntityReference();
    verify(instance).svg();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#parentEntityReference(EntityReference)}
   */
  @Test
  void testBuilderParentEntityReference() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Builder#svg(String)}
   */
  @Test
  void testBuilderSvg() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.svg("Svg"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand#copyOf(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OverlayDiagramInstanceCreateCommand instance = mock(OverlayDiagramInstanceCreateCommand.class);
    when(instance.svg()).thenReturn("Svg");
    when(instance.diagramId()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualCopyOfResult = ImmutableOverlayDiagramInstanceCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).parentEntityReference();
    verify(instance).svg();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand#fromJson(ImmutableOverlayDiagramInstanceCreateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOverlayDiagramInstanceCreateCommand.Json json = new ImmutableOverlayDiagramInstanceCreateCommand.Json();
    json.setName("Json");
    json.setDescription(null);
    json.setDiagramId(1L);
    json.setParentEntityReference(mock(EntityReference.class));
    json.setSvg("Json");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualFromJsonResult = ImmutableOverlayDiagramInstanceCreateCommand
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertNull(actualFromJsonResult.description());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramInstanceCreateCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramInstanceCreateCommand.Json()).diagramId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json}
   *   <li>
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json#setDescription(String)}
   *   <li>
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json#setDiagramId(Long)}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand.Json#setName(String)}
   *   <li>
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json#setParentEntityReference(EntityReference)}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand.Json#setSvg(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableOverlayDiagramInstanceCreateCommand.Json actualJson = new ImmutableOverlayDiagramInstanceCreateCommand.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setDiagramId(1L);
    actualJson.setName("Name");
    actualJson.setParentEntityReference(null);
    actualJson.setSvg("Svg");

    // Assert
    assertEquals(1L, actualJson.diagramId.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramInstanceCreateCommand.Json()).name());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json#parentEntityReference()}
   */
  @Test
  void testJsonParentEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramInstanceCreateCommand.Json()).parentEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramInstanceCreateCommand.Json#svg()}
   */
  @Test
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramInstanceCreateCommand.Json()).svg());
  }
}
