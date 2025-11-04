package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableSaveDiagramCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSaveDiagramCommand#builder()}
   *   <li>{@link ImmutableSaveDiagramCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSaveDiagramCommand.Builder actualDiagramIdResult = ImmutableSaveDiagramCommand.builder()
        .description("The characteristics of someone or something")
        .diagramId(1L);
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualDiagramIdResult, actualDiagramIdResult.diagramId(diagramId));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addAllAnnotations(Iterable)}
   */
  @Test
  void testBuilderAddAllAnnotations() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAnnotations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addAllEntities(Iterable)}
   */
  @Test
  void testBuilderAddAllEntities() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addAllOverlays(Iterable)}
   */
  @Test
  void testBuilderAddAllOverlays() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOverlays(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addAnnotations(FlowDiagramAnnotation)}
   */
  @Test
  void testBuilderAddAnnotations() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAnnotations(new ImmutableFlowDiagramAnnotation.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addAnnotations(FlowDiagramAnnotation)}
   */
  @Test
  void testBuilderAddAnnotations2() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramAnnotation.Json element = new ImmutableFlowDiagramAnnotation.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAnnotations(element));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addAnnotations(FlowDiagramAnnotation[])}
   */
  @Test
  void testBuilderAddAnnotations3() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAnnotations(new ImmutableFlowDiagramAnnotation.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addAnnotations(FlowDiagramAnnotation[])}
   */
  @Test
  void testBuilderAddAnnotations4() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramAnnotation.Json json = new ImmutableFlowDiagramAnnotation.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAnnotations(json));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addEntities(FlowDiagramEntity)}
   */
  @Test
  void testBuilderAddEntities() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(new ImmutableFlowDiagramEntity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addEntities(FlowDiagramEntity)}
   */
  @Test
  void testBuilderAddEntities2() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramEntity.Json element = new ImmutableFlowDiagramEntity.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(element));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addEntities(FlowDiagramEntity[])}
   */
  @Test
  void testBuilderAddEntities3() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(new ImmutableFlowDiagramEntity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addEntities(FlowDiagramEntity[])}
   */
  @Test
  void testBuilderAddEntities4() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramEntity.Json json = new ImmutableFlowDiagramEntity.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(json));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addOverlays(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  void testBuilderAddOverlays() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOverlays(new ImmutableFlowDiagramOverlayGroupEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addOverlays(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  void testBuilderAddOverlays2() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramOverlayGroupEntry.Json element = new ImmutableFlowDiagramOverlayGroupEntry.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addOverlays(element));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addOverlays(FlowDiagramOverlayGroupEntry[])}
   */
  @Test
  void testBuilderAddOverlays3() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOverlays(new ImmutableFlowDiagramOverlayGroupEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#addOverlays(FlowDiagramOverlayGroupEntry[])}
   */
  @Test
  void testBuilderAddOverlays4() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramOverlayGroupEntry.Json json = new ImmutableFlowDiagramOverlayGroupEntry.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addOverlays(json));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#annotations(Iterable)}
   */
  @Test
  void testBuilderAnnotations() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.annotations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#diagramId(long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#diagramId(Optional)}
   */
  @Test
  void testBuilderDiagramId2() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(diagramId));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#diagramId(Optional)}
   */
  @Test
  void testBuilderDiagramId3() {
    // Arrange
    ImmutableFlowDiagramEntity.Json element = new ImmutableFlowDiagramEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    builderResult.addEntities(element);
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(diagramId));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#entities(Iterable)}
   */
  @Test
  void testBuilderEntities() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(SaveDiagramCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(SaveDiagramCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(SaveDiagramCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(SaveDiagramCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ArrayList<FlowDiagramAnnotation> flowDiagramAnnotationList = new ArrayList<>();
    ImmutableFlowDiagramAnnotation.Json json = new ImmutableFlowDiagramAnnotation.Json();
    flowDiagramAnnotationList.add(json);
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(flowDiagramAnnotationList);
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    List<FlowDiagramAnnotation> annotationsResult = buildResult.annotations();
    assertEquals(1, annotationsResult.size());
    assertSame(json, annotationsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(SaveDiagramCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();
    ImmutableFlowDiagramEntity.Json json = new ImmutableFlowDiagramEntity.Json();
    flowDiagramEntityList.add(json);
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(flowDiagramEntityList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    List<FlowDiagramEntity> entitiesResult = buildResult.entities();
    assertEquals(1, entitiesResult.size());
    assertSame(json, entitiesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(SaveDiagramCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.diagramId()).thenReturn(emptyResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#from(SaveDiagramCommand)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    HashSet<FlowDiagramOverlayGroupEntry> flowDiagramOverlayGroupEntrySet = new HashSet<>();
    flowDiagramOverlayGroupEntrySet.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(flowDiagramOverlayGroupEntrySet);
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.overlays().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#layoutData(String)}
   */
  @Test
  void testBuilderLayoutData() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.layoutData("Layout Data"));
  }

  /**
   * Method under test: {@link ImmutableSaveDiagramCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand.Builder#overlays(Iterable)}
   */
  @Test
  void testBuilderOverlays() {
    // Arrange
    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlays(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand actualCopyOfResult = ImmutableSaveDiagramCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualCopyOfResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(actualCopyOfResult.overlays().isEmpty());
    assertSame(annotationsResult, actualCopyOfResult.entities());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<FlowDiagramAnnotation> flowDiagramAnnotationList = new ArrayList<>();
    flowDiagramAnnotationList.add(new ImmutableFlowDiagramAnnotation.Json());
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(flowDiagramAnnotationList);
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand actualCopyOfResult = ImmutableSaveDiagramCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.entities().isEmpty());
    assertTrue(actualCopyOfResult.overlays().isEmpty());
    assertEquals(flowDiagramAnnotationList, actualCopyOfResult.annotations());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<FlowDiagramAnnotation> flowDiagramAnnotationList = new ArrayList<>();
    flowDiagramAnnotationList.add(new ImmutableFlowDiagramAnnotation.Json());
    flowDiagramAnnotationList.add(new ImmutableFlowDiagramAnnotation.Json());
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(flowDiagramAnnotationList);
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand actualCopyOfResult = ImmutableSaveDiagramCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.entities().isEmpty());
    assertTrue(actualCopyOfResult.overlays().isEmpty());
    assertEquals(flowDiagramAnnotationList, actualCopyOfResult.annotations());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();
    flowDiagramEntityList.add(new ImmutableFlowDiagramEntity.Json());
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(flowDiagramEntityList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand actualCopyOfResult = ImmutableSaveDiagramCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.annotations().isEmpty());
    assertTrue(actualCopyOfResult.overlays().isEmpty());
    assertEquals(flowDiagramEntityList, actualCopyOfResult.entities());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.diagramId()).thenReturn(emptyResult);
    when(instance.overlays()).thenReturn(new HashSet<>());
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand actualCopyOfResult = ImmutableSaveDiagramCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualCopyOfResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(actualCopyOfResult.overlays().isEmpty());
    assertSame(annotationsResult, actualCopyOfResult.entities());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<FlowDiagramOverlayGroupEntry> flowDiagramOverlayGroupEntrySet = new HashSet<>();
    flowDiagramOverlayGroupEntrySet.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(flowDiagramOverlayGroupEntrySet);
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand actualCopyOfResult = ImmutableSaveDiagramCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.overlays().size());
    List<FlowDiagramAnnotation> annotationsResult = actualCopyOfResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertSame(annotationsResult, actualCopyOfResult.entities());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    HashSet<FlowDiagramOverlayGroupEntry> flowDiagramOverlayGroupEntrySet = new HashSet<>();
    flowDiagramOverlayGroupEntrySet.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());
    flowDiagramOverlayGroupEntrySet.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());
    SaveDiagramCommand instance = mock(SaveDiagramCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.annotations()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");
    when(instance.entities()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.overlays()).thenReturn(flowDiagramOverlayGroupEntrySet);
    when(instance.layoutData()).thenReturn("Layout Data");

    // Act
    ImmutableSaveDiagramCommand actualCopyOfResult = ImmutableSaveDiagramCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualCopyOfResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertEquals(flowDiagramOverlayGroupEntrySet, actualCopyOfResult.overlays());
    assertSame(annotationsResult, actualCopyOfResult.entities());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#fromJson(ImmutableSaveDiagramCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSaveDiagramCommand.Json json = new ImmutableSaveDiagramCommand.Json();
    json.setName("layoutData");
    json.setDescription(null);
    json.setDiagramId(null);
    json.setLayoutData("Json");
    json.setEntities(null);
    json.setAnnotations(null);
    json.setOverlays(null);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.layoutData());
    assertEquals("layoutData", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualFromJsonResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(actualFromJsonResult.overlays().isEmpty());
    assertSame(annotationsResult, actualFromJsonResult.entities());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#fromJson(ImmutableSaveDiagramCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    overlays.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());

    ImmutableSaveDiagramCommand.Json json = new ImmutableSaveDiagramCommand.Json();
    json.setName("overlays element");
    json.setDescription(null);
    json.setDiagramId(null);
    json.setLayoutData("Layout Data");
    json.setEntities(null);
    json.setAnnotations(null);
    json.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json);

    // Assert
    assertEquals("Layout Data", actualFromJsonResult.layoutData());
    assertEquals("overlays element", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(1, actualFromJsonResult.overlays().size());
    List<FlowDiagramAnnotation> annotationsResult = actualFromJsonResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertSame(annotationsResult, actualFromJsonResult.entities());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveDiagramCommand#fromJson(ImmutableSaveDiagramCommand.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    overlays.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());
    overlays.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());

    ImmutableSaveDiagramCommand.Json json = new ImmutableSaveDiagramCommand.Json();
    json.setName("overlays element");
    json.setDescription(null);
    json.setDiagramId(null);
    json.setLayoutData("Layout Data");
    json.setEntities(null);
    json.setAnnotations(null);
    json.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json);

    // Assert
    assertEquals("Layout Data", actualFromJsonResult.layoutData());
    assertEquals("overlays element", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualFromJsonResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertEquals(overlays, actualFromJsonResult.overlays());
    assertSame(annotationsResult, actualFromJsonResult.entities());
  }

  /**
   * Method under test: {@link ImmutableSaveDiagramCommand.Json#annotations()}
   */
  @Test
  void testJsonAnnotations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSaveDiagramCommand.Json()).annotations());
  }

  /**
   * Method under test: {@link ImmutableSaveDiagramCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSaveDiagramCommand.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSaveDiagramCommand.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSaveDiagramCommand.Json()).diagramId());
  }

  /**
   * Method under test: {@link ImmutableSaveDiagramCommand.Json#entities()}
   */
  @Test
  void testJsonEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSaveDiagramCommand.Json()).entities());
  }

  /**
   * Method under test: {@link ImmutableSaveDiagramCommand.Json#layoutData()}
   */
  @Test
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSaveDiagramCommand.Json()).layoutData());
  }

  /**
   * Method under test: {@link ImmutableSaveDiagramCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSaveDiagramCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSaveDiagramCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSaveDiagramCommand.Json actualJson = new ImmutableSaveDiagramCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.layoutData);
    assertNull(actualJson.name);
    assertFalse(actualJson.diagramId.isPresent());
    assertTrue(actualJson.annotations.isEmpty());
    assertTrue(actualJson.entities.isEmpty());
    assertTrue(actualJson.overlays.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSaveDiagramCommand.Json#overlays()}
   */
  @Test
  void testJsonOverlays() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSaveDiagramCommand.Json()).overlays());
  }
}
