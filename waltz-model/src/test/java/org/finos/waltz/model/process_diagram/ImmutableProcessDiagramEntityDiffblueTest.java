package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramEntityDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity.Builder#diagramId(Long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableProcessDiagramEntity.Builder builderResult = ImmutableProcessDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableProcessDiagramEntity.Builder builderResult = ImmutableProcessDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity.Builder#from(ProcessDiagramEntity)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableProcessDiagramEntity.Builder builderResult = ImmutableProcessDiagramEntity.builder();
    ProcessDiagramEntity instance = mock(ProcessDiagramEntity.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableProcessDiagramEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).isNotable();
    ImmutableProcessDiagramEntity buildResult = builderResult.build();
    assertEquals(1L, buildResult.diagramId().longValue());
    assertTrue(buildResult.isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity.Builder#isNotable(boolean)}
   */
  @Test
  void testBuilderIsNotable() {
    // Arrange
    ImmutableProcessDiagramEntity.Builder builderResult = ImmutableProcessDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isNotable(true));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity#copyOf(ProcessDiagramEntity)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ProcessDiagramEntity instance = mock(ProcessDiagramEntity.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableProcessDiagramEntity actualCopyOfResult = ImmutableProcessDiagramEntity.copyOf(instance);

    // Assert
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).isNotable();
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity#copyOf(ProcessDiagramEntity)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ProcessDiagramEntity instance = mock(ProcessDiagramEntity.class);
    when(instance.isNotable()).thenReturn(false);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableProcessDiagramEntity actualCopyOfResult = ImmutableProcessDiagramEntity.copyOf(instance);

    // Assert
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).isNotable();
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertFalse(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity#fromJson(ImmutableProcessDiagramEntity.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableProcessDiagramEntity.Json json = new ImmutableProcessDiagramEntity.Json();
    json.setEntityReference(mock(EntityReference.class));
    json.setDiagramId(1L);

    // Act
    ImmutableProcessDiagramEntity actualFromJsonResult = ImmutableProcessDiagramEntity.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    assertFalse(actualFromJsonResult.isNotable());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagramEntity.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagramEntity.Json()).diagramId());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableProcessDiagramEntity.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableProcessDiagramEntity.Json}
   *   <li>{@link ImmutableProcessDiagramEntity.Json#setDiagramId(Long)}
   *   <li>
   * {@link ImmutableProcessDiagramEntity.Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableProcessDiagramEntity.Json actualJson = new ImmutableProcessDiagramEntity.Json();
    actualJson.setDiagramId(1L);
    actualJson.setEntityReference(null);

    // Assert
    assertEquals(1L, actualJson.diagramId.longValue());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagramEntity.Json#isNotable()}
   */
  @Test
  void testJsonIsNotable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagramEntity.Json()).isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity.Json#setIsNotable(boolean)}
   */
  @Test
  void testJsonSetIsNotable() {
    // Arrange
    ImmutableProcessDiagramEntity.Json json = new ImmutableProcessDiagramEntity.Json();

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntity.Json#setIsNotable(boolean)}
   */
  @Test
  void testJsonSetIsNotable2() {
    // Arrange
    ImmutableProcessDiagramEntity.Json json = new ImmutableProcessDiagramEntity.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }
}
