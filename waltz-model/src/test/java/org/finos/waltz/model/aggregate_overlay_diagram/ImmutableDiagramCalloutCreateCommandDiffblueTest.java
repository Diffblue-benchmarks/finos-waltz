package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableDiagramCalloutCreateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand.Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Builder#content(String)}
   */
  @Test
  void testBuilderContent() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand.Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.content("Not all who wander are lost"));
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Builder#endColor(String)}
   */
  @Test
  void testBuilderEndColor() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand.Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.endColor("End Color"));
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Builder#from(DiagramCalloutCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand.Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();
    DiagramCalloutCreateCommand instance = mock(DiagramCalloutCreateCommand.class);
    when(instance.endColor()).thenReturn("End Color");
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.title()).thenReturn("Dr");
    when(instance.instanceId()).thenReturn(1L);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableDiagramCalloutCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).endColor();
    verify(instance).instanceId();
    verify(instance).startColor();
    verify(instance).title();
    ImmutableDiagramCalloutCreateCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals("Dr", buildResult.title());
    assertEquals("End Color", buildResult.endColor());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertEquals("Start Color", buildResult.startColor());
    assertEquals(1L, buildResult.instanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Builder#from(DiagramCalloutCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand.Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();
    DiagramCalloutCreateCommand instance = mock(DiagramCalloutCreateCommand.class);
    when(instance.endColor()).thenThrow(new IllegalStateException("instance"));
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.title()).thenReturn("Dr");
    when(instance.instanceId()).thenReturn(1L);
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).endColor();
    verify(instance).instanceId();
    verify(instance).startColor();
    verify(instance).title();
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Builder#instanceId(Long)}
   */
  @Test
  void testBuilderInstanceId() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand.Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instanceId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Builder#startColor(String)}
   */
  @Test
  void testBuilderStartColor() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand.Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.startColor("Start Color"));
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Builder#title(String)}
   */
  @Test
  void testBuilderTitle() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand.Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.title("Dr"));
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand#copyOf(DiagramCalloutCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DiagramCalloutCreateCommand instance = mock(DiagramCalloutCreateCommand.class);
    when(instance.endColor()).thenReturn("End Color");
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.title()).thenReturn("Dr");
    when(instance.instanceId()).thenReturn(1L);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableDiagramCalloutCreateCommand actualCopyOfResult = ImmutableDiagramCalloutCreateCommand.copyOf(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).endColor();
    verify(instance).instanceId();
    verify(instance).startColor();
    verify(instance).title();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("End Color", actualCopyOfResult.endColor());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertEquals("Start Color", actualCopyOfResult.startColor());
    assertEquals(1L, actualCopyOfResult.instanceId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDiagramCalloutCreateCommand.Json()).cellExternalId());
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Json#content()}
   */
  @Test
  void testJsonContent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDiagramCalloutCreateCommand.Json()).content());
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Json#endColor()}
   */
  @Test
  void testJsonEndColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDiagramCalloutCreateCommand.Json()).endColor());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDiagramCalloutCreateCommand.Json}
   *   <li>
   * {@link ImmutableDiagramCalloutCreateCommand.Json#setCellExternalId(String)}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand.Json#setContent(String)}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand.Json#setEndColor(String)}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand.Json#setInstanceId(Long)}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand.Json#setStartColor(String)}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand.Json#setTitle(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDiagramCalloutCreateCommand.Json actualJson = new ImmutableDiagramCalloutCreateCommand.Json();
    actualJson.setCellExternalId("42");
    actualJson.setContent("Not all who wander are lost");
    actualJson.setEndColor("End Color");
    actualJson.setInstanceId(1L);
    actualJson.setStartColor("Start Color");
    actualJson.setTitle("Dr");

    // Assert
    assertEquals(1L, actualJson.instanceId.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Json#instanceId()}
   */
  @Test
  void testJsonInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDiagramCalloutCreateCommand.Json()).instanceId());
  }

  /**
   * Method under test:
   * {@link ImmutableDiagramCalloutCreateCommand.Json#startColor()}
   */
  @Test
  void testJsonStartColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDiagramCalloutCreateCommand.Json()).startColor());
  }

  /**
   * Method under test: {@link ImmutableDiagramCalloutCreateCommand.Json#title()}
   */
  @Test
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDiagramCalloutCreateCommand.Json()).title());
  }
}
