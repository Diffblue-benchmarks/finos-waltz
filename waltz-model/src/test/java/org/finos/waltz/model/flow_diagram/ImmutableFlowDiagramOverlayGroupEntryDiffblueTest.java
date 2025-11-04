package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramOverlayGroupEntryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#fill(String)}
   */
  @Test
  void testBuilderFill() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fill("Fill"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableFlowDiagramOverlayGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableFlowDiagramOverlayGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#from(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    FlowDiagramOverlayGroupEntry instance = mock(FlowDiagramOverlayGroupEntry.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.stroke()).thenReturn("Stroke");
    when(instance.fill()).thenReturn("Fill");
    when(instance.overlayGroupId()).thenReturn(1L);
    when(instance.symbol()).thenReturn("Symbol");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).entityReference();
    verify(instance).fill();
    verify(instance).overlayGroupId();
    verify(instance).stroke();
    verify(instance).symbol();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#from(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    FlowDiagramOverlayGroupEntry instance = mock(FlowDiagramOverlayGroupEntry.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.stroke()).thenReturn("Stroke");
    when(instance.fill()).thenReturn("Fill");
    when(instance.overlayGroupId()).thenReturn(1L);
    when(instance.symbol()).thenReturn("Symbol");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableFlowDiagramOverlayGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).entityReference();
    verify(instance).fill();
    verify(instance).overlayGroupId();
    verify(instance).stroke();
    verify(instance).symbol();
    ImmutableFlowDiagramOverlayGroupEntry buildResult = builderResult.build();
    assertEquals("Fill", buildResult.fill());
    assertEquals("Stroke", buildResult.stroke());
    assertEquals("Symbol", buildResult.symbol());
    assertEquals(1L, buildResult.overlayGroupId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#overlayGroupId(Long)}
   */
  @Test
  void testBuilderOverlayGroupId() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayGroupId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#stroke(String)}
   */
  @Test
  void testBuilderStroke() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.stroke("Stroke"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Builder#symbol(String)}
   */
  @Test
  void testBuilderSymbol() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.symbol("Symbol"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry#copyOf(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowDiagramOverlayGroupEntry instance = mock(FlowDiagramOverlayGroupEntry.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.stroke()).thenReturn("Stroke");
    when(instance.fill()).thenReturn("Fill");
    when(instance.overlayGroupId()).thenReturn(1L);
    when(instance.symbol()).thenReturn("Symbol");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualCopyOfResult = ImmutableFlowDiagramOverlayGroupEntry.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).entityReference();
    verify(instance).fill();
    verify(instance).overlayGroupId();
    verify(instance).stroke();
    verify(instance).symbol();
    assertEquals("Fill", actualCopyOfResult.fill());
    assertEquals("Stroke", actualCopyOfResult.stroke());
    assertEquals("Symbol", actualCopyOfResult.symbol());
    assertEquals(1L, actualCopyOfResult.overlayGroupId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry#fromJson(ImmutableFlowDiagramOverlayGroupEntry.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableFlowDiagramOverlayGroupEntry.Json json = new ImmutableFlowDiagramOverlayGroupEntry.Json();
    json.setId(null);
    json.setOverlayGroupId(1L);
    json.setEntityReference(mock(EntityReference.class));
    json.setSymbol("Json");
    json.setFill("Json");
    json.setStroke("Json");

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualFromJsonResult = ImmutableFlowDiagramOverlayGroupEntry.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.fill());
    assertEquals("Json", actualFromJsonResult.stroke());
    assertEquals("Json", actualFromJsonResult.symbol());
    assertEquals(1L, actualFromJsonResult.overlayGroupId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowDiagramOverlayGroupEntry.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry.Json#fill()}
   */
  @Test
  void testJsonFill() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramOverlayGroupEntry.Json()).fill());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramOverlayGroupEntry.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowDiagramOverlayGroupEntry.Json actualJson = new ImmutableFlowDiagramOverlayGroupEntry.Json();

    // Assert
    assertNull(actualJson.overlayGroupId);
    assertNull(actualJson.fill);
    assertNull(actualJson.stroke);
    assertNull(actualJson.symbol);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Json#overlayGroupId()}
   */
  @Test
  void testJsonOverlayGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowDiagramOverlayGroupEntry.Json()).overlayGroupId());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Json#stroke()}
   */
  @Test
  void testJsonStroke() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowDiagramOverlayGroupEntry.Json()).stroke());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroupEntry.Json#symbol()}
   */
  @Test
  void testJsonSymbol() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowDiagramOverlayGroupEntry.Json()).symbol());
  }
}
