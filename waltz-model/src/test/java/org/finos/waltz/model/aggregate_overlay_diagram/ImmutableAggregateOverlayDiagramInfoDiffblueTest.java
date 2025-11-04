package org.finos.waltz.model.aggregate_overlay_diagram;

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

class ImmutableAggregateOverlayDiagramInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#addAllBackingEntities(Iterable)}
   */
  @Test
  void testBuilderAddAllBackingEntities() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllBackingEntities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#addBackingEntities(BackingEntity)}
   */
  @Test
  void testBuilderAddBackingEntities() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(new ImmutableBackingEntity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#addBackingEntities(BackingEntity)}
   */
  @Test
  void testBuilderAddBackingEntities2() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(element));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#addBackingEntities(BackingEntity[])}
   */
  @Test
  void testBuilderAddBackingEntities3() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(new ImmutableBackingEntity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#addBackingEntities(BackingEntity[])}
   */
  @Test
  void testBuilderAddBackingEntities4() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    ImmutableBackingEntity.Json json = new ImmutableBackingEntity.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(json));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#backingEntities(Iterable)}
   */
  @Test
  void testBuilderBackingEntities() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.backingEntities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#diagram(AggregateOverlayDiagram)}
   */
  @Test
  void testBuilderDiagram() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();

    // Act
    ImmutableAggregateOverlayDiagramInfo.Builder actualDiagramResult = builderResult.diagram(diagram);

    // Assert
    assertSame(diagram, builderResult.build().diagram());
    assertSame(builderResult, actualDiagramResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#diagram(AggregateOverlayDiagram)}
   */
  @Test
  void testBuilderDiagram2() {
    // Arrange
    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    builderResult.addBackingEntities(element);
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();

    // Act
    ImmutableAggregateOverlayDiagramInfo.Builder actualDiagramResult = builderResult.diagram(diagram);

    // Assert
    ImmutableAggregateOverlayDiagramInfo buildResult = builderResult.build();
    assertEquals(1, buildResult.backingEntities().size());
    assertSame(diagram, buildResult.diagram());
    assertSame(builderResult, actualDiagramResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#from(AggregateOverlayDiagramInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    ImmutableAggregateOverlayDiagram.Json json = new ImmutableAggregateOverlayDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableAggregateOverlayDiagramInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).backingEntities();
    verify(instance).diagram();
    assertSame(json, builderResult.build().diagram());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#from(AggregateOverlayDiagramInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagram()).thenReturn(new ImmutableAggregateOverlayDiagram.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).backingEntities();
    verify(instance).diagram();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Builder#from(AggregateOverlayDiagramInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenReturn(backingEntitySet);
    ImmutableAggregateOverlayDiagram.Json json = new ImmutableAggregateOverlayDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableAggregateOverlayDiagramInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).backingEntities();
    verify(instance).diagram();
    ImmutableAggregateOverlayDiagramInfo buildResult = builderResult.build();
    assertEquals(1, buildResult.backingEntities().size());
    assertSame(json, buildResult.diagram());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo#copyOf(AggregateOverlayDiagramInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    ImmutableAggregateOverlayDiagram.Json json = new ImmutableAggregateOverlayDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualCopyOfResult = ImmutableAggregateOverlayDiagramInfo.copyOf(instance);

    // Assert
    verify(instance).backingEntities();
    verify(instance).diagram();
    assertTrue(actualCopyOfResult.backingEntities().isEmpty());
    assertSame(json, actualCopyOfResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo#copyOf(AggregateOverlayDiagramInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenReturn(backingEntitySet);
    ImmutableAggregateOverlayDiagram.Json json = new ImmutableAggregateOverlayDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualCopyOfResult = ImmutableAggregateOverlayDiagramInfo.copyOf(instance);

    // Assert
    verify(instance).backingEntities();
    verify(instance).diagram();
    assertEquals(1, actualCopyOfResult.backingEntities().size());
    assertSame(json, actualCopyOfResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo#copyOf(AggregateOverlayDiagramInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenReturn(backingEntitySet);
    ImmutableAggregateOverlayDiagram.Json json = new ImmutableAggregateOverlayDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualCopyOfResult = ImmutableAggregateOverlayDiagramInfo.copyOf(instance);

    // Assert
    verify(instance).backingEntities();
    verify(instance).diagram();
    assertEquals(backingEntitySet, actualCopyOfResult.backingEntities());
    assertSame(json, actualCopyOfResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo#fromJson(ImmutableAggregateOverlayDiagramInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAggregateOverlayDiagramInfo.Json json = new ImmutableAggregateOverlayDiagramInfo.Json();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();
    json.setDiagram(diagram);
    json.setBackingEntities(null);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualFromJsonResult = ImmutableAggregateOverlayDiagramInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.backingEntities().isEmpty());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo#fromJson(ImmutableAggregateOverlayDiagramInfo.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<BackingEntity> backingEntities = new LinkedHashSet<>();
    backingEntities.add(new ImmutableBackingEntity.Json());

    ImmutableAggregateOverlayDiagramInfo.Json json = new ImmutableAggregateOverlayDiagramInfo.Json();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();
    json.setDiagram(diagram);
    json.setBackingEntities(backingEntities);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualFromJsonResult = ImmutableAggregateOverlayDiagramInfo.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.backingEntities().size());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo#fromJson(ImmutableAggregateOverlayDiagramInfo.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<BackingEntity> backingEntities = new LinkedHashSet<>();
    backingEntities.add(new ImmutableBackingEntity.Json());
    backingEntities.add(new ImmutableBackingEntity.Json());

    ImmutableAggregateOverlayDiagramInfo.Json json = new ImmutableAggregateOverlayDiagramInfo.Json();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();
    json.setDiagram(diagram);
    json.setBackingEntities(backingEntities);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualFromJsonResult = ImmutableAggregateOverlayDiagramInfo.fromJson(json);

    // Assert
    assertEquals(backingEntities, actualFromJsonResult.backingEntities());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Json#backingEntities()}
   */
  @Test
  void testJsonBackingEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInfo.Json()).backingEntities());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInfo.Json#diagram()}
   */
  @Test
  void testJsonDiagram() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInfo.Json()).diagram());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAggregateOverlayDiagramInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramInfo.Json actualJson = new ImmutableAggregateOverlayDiagramInfo.Json();

    // Assert
    assertNull(actualJson.diagram);
    assertTrue(actualJson.backingEntities.isEmpty());
  }
}
