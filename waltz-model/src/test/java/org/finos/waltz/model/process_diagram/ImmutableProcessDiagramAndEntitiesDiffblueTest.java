package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramAndEntitiesDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#addAllEntities(Iterable)}
   */
  @Test
  void testBuilderAddAllEntities() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#addEntities(ProcessDiagramEntity)}
   */
  @Test
  void testBuilderAddEntities() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(new ImmutableProcessDiagramEntity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#addEntities(ProcessDiagramEntity)}
   */
  @Test
  void testBuilderAddEntities2() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    ImmutableProcessDiagramEntity.Json element = new ImmutableProcessDiagramEntity.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(element));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#addEntities(ProcessDiagramEntity[])}
   */
  @Test
  void testBuilderAddEntities3() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(new ImmutableProcessDiagramEntity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#addEntities(ProcessDiagramEntity[])}
   */
  @Test
  void testBuilderAddEntities4() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    ImmutableProcessDiagramEntity.Json json = new ImmutableProcessDiagramEntity.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(json));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#diagram(ProcessDiagram)}
   */
  @Test
  void testBuilderDiagram() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();

    // Act
    ImmutableProcessDiagramAndEntities.Builder actualDiagramResult = builderResult.diagram(diagram);

    // Assert
    assertSame(diagram, builderResult.build().diagram());
    assertSame(builderResult, actualDiagramResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#diagram(ProcessDiagram)}
   */
  @Test
  void testBuilderDiagram2() {
    // Arrange
    ImmutableProcessDiagramEntity.Json element = new ImmutableProcessDiagramEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    builderResult.addEntities(element);
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();

    // Act
    ImmutableProcessDiagramAndEntities.Builder actualDiagramResult = builderResult.diagram(diagram);

    // Assert
    ImmutableProcessDiagramAndEntities buildResult = builderResult.build();
    assertEquals(1, buildResult.entities().size());
    assertSame(diagram, buildResult.diagram());
    assertSame(builderResult, actualDiagramResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#entities(Iterable)}
   */
  @Test
  void testBuilderEntities() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#from(ProcessDiagramAndEntities)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenReturn(new HashSet<>());
    ImmutableProcessDiagram.Json json = new ImmutableProcessDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableProcessDiagramAndEntities.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).diagram();
    verify(instance).entities();
    assertSame(json, builderResult.build().diagram());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#from(ProcessDiagramAndEntities)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagram()).thenReturn(new ImmutableProcessDiagram.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).diagram();
    verify(instance).entities();
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities.Builder#from(ProcessDiagramAndEntities)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    HashSet<ProcessDiagramEntity> processDiagramEntitySet = new HashSet<>();
    processDiagramEntitySet.add(new ImmutableProcessDiagramEntity.Json());
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenReturn(processDiagramEntitySet);
    ImmutableProcessDiagram.Json json = new ImmutableProcessDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableProcessDiagramAndEntities.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).diagram();
    verify(instance).entities();
    ImmutableProcessDiagramAndEntities buildResult = builderResult.build();
    assertEquals(1, buildResult.entities().size());
    assertSame(json, buildResult.diagram());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities#copyOf(ProcessDiagramAndEntities)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenReturn(new HashSet<>());
    ImmutableProcessDiagram.Json json = new ImmutableProcessDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableProcessDiagramAndEntities actualCopyOfResult = ImmutableProcessDiagramAndEntities.copyOf(instance);

    // Assert
    verify(instance).diagram();
    verify(instance).entities();
    assertTrue(actualCopyOfResult.entities().isEmpty());
    assertSame(json, actualCopyOfResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities#copyOf(ProcessDiagramAndEntities)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ProcessDiagramEntity> processDiagramEntitySet = new HashSet<>();
    processDiagramEntitySet.add(new ImmutableProcessDiagramEntity.Json());
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenReturn(processDiagramEntitySet);
    ImmutableProcessDiagram.Json json = new ImmutableProcessDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableProcessDiagramAndEntities actualCopyOfResult = ImmutableProcessDiagramAndEntities.copyOf(instance);

    // Assert
    verify(instance).diagram();
    verify(instance).entities();
    assertEquals(1, actualCopyOfResult.entities().size());
    assertSame(json, actualCopyOfResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities#copyOf(ProcessDiagramAndEntities)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<ProcessDiagramEntity> processDiagramEntitySet = new HashSet<>();
    processDiagramEntitySet.add(new ImmutableProcessDiagramEntity.Json());
    processDiagramEntitySet.add(new ImmutableProcessDiagramEntity.Json());
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenReturn(processDiagramEntitySet);
    ImmutableProcessDiagram.Json json = new ImmutableProcessDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableProcessDiagramAndEntities actualCopyOfResult = ImmutableProcessDiagramAndEntities.copyOf(instance);

    // Assert
    verify(instance).diagram();
    verify(instance).entities();
    assertEquals(processDiagramEntitySet, actualCopyOfResult.entities());
    assertSame(json, actualCopyOfResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities#fromJson(ImmutableProcessDiagramAndEntities.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableProcessDiagramAndEntities.Json json = new ImmutableProcessDiagramAndEntities.Json();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();
    json.setDiagram(diagram);
    json.setEntities(null);

    // Act
    ImmutableProcessDiagramAndEntities actualFromJsonResult = ImmutableProcessDiagramAndEntities.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.entities().isEmpty());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities#fromJson(ImmutableProcessDiagramAndEntities.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<ProcessDiagramEntity> entities = new LinkedHashSet<>();
    entities.add(new ImmutableProcessDiagramEntity.Json());

    ImmutableProcessDiagramAndEntities.Json json = new ImmutableProcessDiagramAndEntities.Json();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();
    json.setDiagram(diagram);
    json.setEntities(entities);

    // Act
    ImmutableProcessDiagramAndEntities actualFromJsonResult = ImmutableProcessDiagramAndEntities.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.entities().size());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramAndEntities#fromJson(ImmutableProcessDiagramAndEntities.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<ProcessDiagramEntity> entities = new LinkedHashSet<>();
    entities.add(new ImmutableProcessDiagramEntity.Json());
    entities.add(new ImmutableProcessDiagramEntity.Json());

    ImmutableProcessDiagramAndEntities.Json json = new ImmutableProcessDiagramAndEntities.Json();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();
    json.setDiagram(diagram);
    json.setEntities(entities);

    // Act
    ImmutableProcessDiagramAndEntities actualFromJsonResult = ImmutableProcessDiagramAndEntities.fromJson(json);

    // Assert
    assertEquals(entities, actualFromJsonResult.entities());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagramAndEntities.Json#diagram()}
   */
  @Test
  void testJsonDiagram() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagramAndEntities.Json()).diagram());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagramAndEntities.Json#entities()}
   */
  @Test
  void testJsonEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagramAndEntities.Json()).entities());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableProcessDiagramAndEntities.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableProcessDiagramAndEntities.Json actualJson = new ImmutableProcessDiagramAndEntities.Json();

    // Assert
    assertNull(actualJson.diagram);
    assertTrue(actualJson.entities.isEmpty());
  }
}
