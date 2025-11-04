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
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramAnnotationDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Builder#annotationId(String)}
   */
  @Test
  void testBuilderAnnotationId() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.annotationId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Builder#diagramId(long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Builder#diagramId(Optional)}
   */
  @Test
  void testBuilderDiagramId2() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(diagramId));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Builder#from(FlowDiagramAnnotation)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    FlowDiagramAnnotation instance = mock(FlowDiagramAnnotation.class);
    when(instance.diagramId()).thenThrow(new IllegalStateException("instance"));
    when(instance.annotationId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).annotationId();
    verify(instance).diagramId();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Builder#from(FlowDiagramAnnotation)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    FlowDiagramAnnotation instance = mock(FlowDiagramAnnotation.class);
    when(instance.note()).thenReturn("Note");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.annotationId()).thenReturn("42");

    // Act
    ImmutableFlowDiagramAnnotation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).annotationId();
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).note();
    ImmutableFlowDiagramAnnotation buildResult = builderResult.build();
    assertEquals("42", buildResult.annotationId());
    assertEquals("Note", buildResult.note());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Builder#from(FlowDiagramAnnotation)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    FlowDiagramAnnotation instance = mock(FlowDiagramAnnotation.class);
    when(instance.note()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.annotationId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).annotationId();
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).note();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Builder#note(String)}
   */
  @Test
  void testBuilderNote() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.note("Note"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation#copyOf(FlowDiagramAnnotation)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowDiagramAnnotation instance = mock(FlowDiagramAnnotation.class);
    when(instance.note()).thenReturn("Note");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.annotationId()).thenReturn("42");

    // Act
    ImmutableFlowDiagramAnnotation actualCopyOfResult = ImmutableFlowDiagramAnnotation.copyOf(instance);

    // Assert
    verify(instance).annotationId();
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).note();
    assertEquals("42", actualCopyOfResult.annotationId());
    assertEquals("Note", actualCopyOfResult.note());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation#fromJson(ImmutableFlowDiagramAnnotation.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableFlowDiagramAnnotation.Json json = new ImmutableFlowDiagramAnnotation.Json();
    json.setNote("Note");
    json.setAnnotationId("42");
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableFlowDiagramAnnotation actualFromJsonResult = ImmutableFlowDiagramAnnotation.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.annotationId());
    assertEquals("Note", actualFromJsonResult.note());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramAnnotation.Json#annotationId()}
   */
  @Test
  void testJsonAnnotationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramAnnotation.Json()).annotationId());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramAnnotation.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramAnnotation.Json()).diagramId());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramAnnotation.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowDiagramAnnotation.Json()).entityReference());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowDiagramAnnotation.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowDiagramAnnotation.Json actualJson = new ImmutableFlowDiagramAnnotation.Json();

    // Assert
    assertNull(actualJson.annotationId);
    assertNull(actualJson.note);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.diagramId.isPresent());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramAnnotation.Json#note()}
   */
  @Test
  void testJsonNote() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramAnnotation.Json()).note());
  }
}
