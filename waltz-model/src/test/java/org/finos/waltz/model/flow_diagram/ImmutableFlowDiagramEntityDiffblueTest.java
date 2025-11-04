package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramEntityDiffblueTest {
  /**
   * Method under test: {@link ImmutableFlowDiagramEntity.Builder#diagramId(long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableFlowDiagramEntity.Builder builderResult = ImmutableFlowDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity.Builder#diagramId(Optional)}
   */
  @Test
  void testBuilderDiagramId2() {
    // Arrange
    ImmutableFlowDiagramEntity.Builder builderResult = ImmutableFlowDiagramEntity.builder();
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(diagramId));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableFlowDiagramEntity.Builder builderResult = ImmutableFlowDiagramEntity.builder();
    EntityReference entityReference = mock(EntityReference.class);

    // Act
    ImmutableFlowDiagramEntity.Builder actualEntityReferenceResult = builderResult.entityReference(entityReference);

    // Assert
    ImmutableFlowDiagramEntity buildResult = builderResult.build();
    assertFalse(buildResult.isNotable());
    assertSame(builderResult, actualEntityReferenceResult);
    assertSame(entityReference, buildResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity.Builder#from(FlowDiagramEntity)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowDiagramEntity.Builder builderResult = ImmutableFlowDiagramEntity.builder();
    FlowDiagramEntity instance = mock(FlowDiagramEntity.class);
    when(instance.isNotable()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDiagramEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).isNotable();
    assertTrue(actualFromResult.build().isNotable());
    assertTrue(builderResult.build().isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity.Builder#isNotable(boolean)}
   */
  @Test
  void testBuilderIsNotable() {
    // Arrange
    ImmutableFlowDiagramEntity.Builder builderResult = ImmutableFlowDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isNotable(true));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity#copyOf(FlowDiagramEntity)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowDiagramEntity instance = mock(FlowDiagramEntity.class);
    when(instance.isNotable()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDiagramEntity actualCopyOfResult = ImmutableFlowDiagramEntity.copyOf(instance);

    // Assert
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).isNotable();
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity#copyOf(FlowDiagramEntity)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FlowDiagramEntity instance = mock(FlowDiagramEntity.class);
    when(instance.isNotable()).thenReturn(false);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDiagramEntity actualCopyOfResult = ImmutableFlowDiagramEntity.copyOf(instance);

    // Assert
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).isNotable();
    assertFalse(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity#fromJson(ImmutableFlowDiagramEntity.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableFlowDiagramEntity.Json json = new ImmutableFlowDiagramEntity.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableFlowDiagramEntity actualFromJsonResult = ImmutableFlowDiagramEntity.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.isNotable());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramEntity.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramEntity.Json()).diagramId());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramEntity.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramEntity.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramEntity.Json#isNotable()}
   */
  @Test
  void testJsonIsNotable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramEntity.Json()).isNotable());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowDiagramEntity.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowDiagramEntity.Json actualJson = new ImmutableFlowDiagramEntity.Json();

    // Assert
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.diagramId.isPresent());
    assertFalse(actualJson.isNotable);
    assertFalse(actualJson.isNotableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity.Json#setIsNotable(boolean)}
   */
  @Test
  void testJsonSetIsNotable() {
    // Arrange
    ImmutableFlowDiagramEntity.Json json = new ImmutableFlowDiagramEntity.Json();

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramEntity.Json#setIsNotable(boolean)}
   */
  @Test
  void testJsonSetIsNotable2() {
    // Arrange
    ImmutableFlowDiagramEntity.Json json = new ImmutableFlowDiagramEntity.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }
}
