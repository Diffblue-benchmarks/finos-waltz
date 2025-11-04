package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramCalloutDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#content(String)}
   */
  @Test
  void testBuilderContent() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.content("Not all who wander are lost"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#diagramInstanceId(Long)}
   */
  @Test
  void testBuilderDiagramInstanceId() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramInstanceId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#endColor(String)}
   */
  @Test
  void testBuilderEndColor() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.endColor("End Color"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAggregateOverlayDiagramCallout.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAggregateOverlayDiagramCallout.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#from(AggregateOverlayDiagramCallout)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    AggregateOverlayDiagramCallout instance = mock(AggregateOverlayDiagramCallout.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.diagramInstanceId()).thenReturn(1L);
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.cellExternalId()).thenReturn("42");
    when(instance.endColor()).thenReturn("End Color");
    when(instance.title()).thenReturn("Dr");

    // Act
    ImmutableAggregateOverlayDiagramCallout.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).diagramInstanceId();
    verify(instance).endColor();
    verify(instance).startColor();
    verify(instance).title();
    ImmutableAggregateOverlayDiagramCallout buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals("Dr", buildResult.title());
    assertEquals("End Color", buildResult.endColor());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertEquals("Start Color", buildResult.startColor());
    assertEquals(1L, buildResult.diagramInstanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#from(AggregateOverlayDiagramCallout)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    AggregateOverlayDiagramCallout instance = mock(AggregateOverlayDiagramCallout.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagramInstanceId()).thenReturn(1L);
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.cellExternalId()).thenReturn("42");
    when(instance.endColor()).thenReturn("End Color");
    when(instance.title()).thenReturn("Dr");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).diagramInstanceId();
    verify(instance).endColor();
    verify(instance).startColor();
    verify(instance).title();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#from(AggregateOverlayDiagramCallout)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    AggregateOverlayDiagramCallout instance = mock(AggregateOverlayDiagramCallout.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.diagramInstanceId()).thenReturn(1L);
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.cellExternalId()).thenReturn("42");
    when(instance.endColor()).thenReturn("End Color");
    when(instance.title()).thenReturn("Dr");

    // Act
    ImmutableAggregateOverlayDiagramCallout.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).diagramInstanceId();
    verify(instance).endColor();
    verify(instance).startColor();
    verify(instance).title();
    ImmutableAggregateOverlayDiagramCallout buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals("Dr", buildResult.title());
    assertEquals("End Color", buildResult.endColor());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertEquals("Start Color", buildResult.startColor());
    assertEquals(1L, buildResult.diagramInstanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#startColor(String)}
   */
  @Test
  void testBuilderStartColor() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.startColor("Start Color"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Builder#title(String)}
   */
  @Test
  void testBuilderTitle() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout.Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.title("Dr"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout#copyOf(AggregateOverlayDiagramCallout)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AggregateOverlayDiagramCallout instance = mock(AggregateOverlayDiagramCallout.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.diagramInstanceId()).thenReturn(1L);
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.cellExternalId()).thenReturn("42");
    when(instance.endColor()).thenReturn("End Color");
    when(instance.title()).thenReturn("Dr");

    // Act
    ImmutableAggregateOverlayDiagramCallout actualCopyOfResult = ImmutableAggregateOverlayDiagramCallout
        .copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).diagramInstanceId();
    verify(instance).endColor();
    verify(instance).startColor();
    verify(instance).title();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("End Color", actualCopyOfResult.endColor());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertEquals("Start Color", actualCopyOfResult.startColor());
    assertEquals(1L, actualCopyOfResult.diagramInstanceId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout#copyOf(AggregateOverlayDiagramCallout)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AggregateOverlayDiagramCallout instance = mock(AggregateOverlayDiagramCallout.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.diagramInstanceId()).thenReturn(1L);
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.cellExternalId()).thenReturn("42");
    when(instance.endColor()).thenReturn("End Color");
    when(instance.title()).thenReturn("Dr");

    // Act
    ImmutableAggregateOverlayDiagramCallout actualCopyOfResult = ImmutableAggregateOverlayDiagramCallout
        .copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).diagramInstanceId();
    verify(instance).endColor();
    verify(instance).startColor();
    verify(instance).title();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("End Color", actualCopyOfResult.endColor());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertEquals("Start Color", actualCopyOfResult.startColor());
    assertEquals(1L, actualCopyOfResult.diagramInstanceId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramCallout.Json()).cellExternalId());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Json#content()}
   */
  @Test
  void testJsonContent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramCallout.Json()).content());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Json#diagramInstanceId()}
   */
  @Test
  void testJsonDiagramInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramCallout.Json()).diagramInstanceId());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Json#endColor()}
   */
  @Test
  void testJsonEndColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramCallout.Json()).endColor());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagramCallout.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagramCallout.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAggregateOverlayDiagramCallout.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramCallout.Json actualJson = new ImmutableAggregateOverlayDiagramCallout.Json();

    // Assert
    assertNull(actualJson.diagramInstanceId);
    assertNull(actualJson.cellExternalId);
    assertNull(actualJson.content);
    assertNull(actualJson.endColor);
    assertNull(actualJson.startColor);
    assertNull(actualJson.title);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Json#startColor()}
   */
  @Test
  void testJsonStartColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramCallout.Json()).startColor());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramCallout.Json#title()}
   */
  @Test
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramCallout.Json()).title());
  }
}
