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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.flow_diagram.ImmutableSaveDiagramCommand.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableSaveDiagramCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveDiagramCommandDiffblueTest {
  /**
   * Test {@link ImmutableSaveDiagramCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSaveDiagramCommand#builder()}
   *   <li>{@link ImmutableSaveDiagramCommand#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSaveDiagramCommand Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDiagramIdResult = ImmutableSaveDiagramCommand.builder()
        .description("The characteristics of someone or something")
        .diagramId(1L);
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualDiagramIdResult, actualDiagramIdResult.diagramId(diagramId));
  }

  /**
   * Test Builder {@link Builder#addAllAnnotations(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAnnotations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAnnotations(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAnnotations(Iterable)"})
  void testBuilderAddAllAnnotations_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAnnotations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllEntities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllEntities(Iterable)"})
  void testBuilderAddAllEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllOverlays(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOverlays(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOverlays(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOverlays(Iterable)"})
  void testBuilderAddAllOverlays_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOverlays(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAnnotations(FlowDiagramAnnotation)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramAnnotation.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAnnotations(FlowDiagramAnnotation)}
   */
  @Test
  @DisplayName("Test Builder addAnnotations(FlowDiagramAnnotation) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAnnotations(FlowDiagramAnnotation)"})
  void testBuilderAddAnnotationsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAnnotations(new ImmutableFlowDiagramAnnotation.Json()));
  }

  /**
   * Test Builder {@link Builder#addAnnotations(FlowDiagramAnnotation[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramAnnotation.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAnnotations(FlowDiagramAnnotation[])}
   */
  @Test
  @DisplayName("Test Builder addAnnotations(FlowDiagramAnnotation[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAnnotations(FlowDiagramAnnotation[])"})
  void testBuilderAddAnnotationsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAnnotations(new ImmutableFlowDiagramAnnotation.Json()));
  }

  /**
   * Test Builder {@link Builder#addEntities(FlowDiagramEntity)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramEntity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addEntities(FlowDiagramEntity)}
   */
  @Test
  @DisplayName("Test Builder addEntities(FlowDiagramEntity) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntities(FlowDiagramEntity)"})
  void testBuilderAddEntitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(new ImmutableFlowDiagramEntity.Json()));
  }

  /**
   * Test Builder {@link Builder#addEntities(FlowDiagramEntity[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramEntity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addEntities(FlowDiagramEntity[])}
   */
  @Test
  @DisplayName("Test Builder addEntities(FlowDiagramEntity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntities(FlowDiagramEntity[])"})
  void testBuilderAddEntitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(new ImmutableFlowDiagramEntity.Json()));
  }

  /**
   * Test Builder {@link Builder#addOverlays(FlowDiagramOverlayGroupEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramOverlayGroupEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOverlays(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  @DisplayName("Test Builder addOverlays(FlowDiagramOverlayGroupEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOverlays(FlowDiagramOverlayGroupEntry)"})
  void testBuilderAddOverlaysWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOverlays(new ImmutableFlowDiagramOverlayGroupEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#addOverlays(FlowDiagramOverlayGroupEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramOverlayGroupEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOverlays(FlowDiagramOverlayGroupEntry[])}
   */
  @Test
  @DisplayName("Test Builder addOverlays(FlowDiagramOverlayGroupEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOverlays(FlowDiagramOverlayGroupEntry[])"})
  void testBuilderAddOverlaysWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOverlays(new ImmutableFlowDiagramOverlayGroupEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#annotations(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#annotations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder annotations(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.annotations(Iterable)"})
  void testBuilderAnnotations_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.annotations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#diagramId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#diagramId(long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramId(long)"})
  void testBuilderDiagramIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Test Builder {@link Builder#diagramId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#diagramId(Optional)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramId(Optional)"})
  void testBuilderDiagramIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(diagramId));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(SaveDiagramCommand)} with {@code SaveDiagramCommand}.
   * <p>
   * Method under test: {@link Builder#from(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveDiagramCommand) with 'SaveDiagramCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveDiagramCommand)"})
  void testBuilderFromWithSaveDiagramCommand() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    List<FlowDiagramAnnotation> annotationsResult = buildResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(buildResult.overlays().isEmpty());
    assertSame(annotationsResult, buildResult.entities());
  }

  /**
   * Test Builder {@link Builder#from(SaveDiagramCommand)} with {@code SaveDiagramCommand}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveDiagramCommand) with 'SaveDiagramCommand'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveDiagramCommand)"})
  void testBuilderFromWithSaveDiagramCommand_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    List<FlowDiagramAnnotation> annotationsResult = buildResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(buildResult.overlays().isEmpty());
    assertSame(annotationsResult, buildResult.entities());
  }

  /**
   * Test Builder {@link Builder#from(SaveDiagramCommand)} with {@code SaveDiagramCommand}.
   * <ul>
   *   <li>Then builder build annotations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveDiagramCommand) with 'SaveDiagramCommand'; then builder build annotations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveDiagramCommand)"})
  void testBuilderFromWithSaveDiagramCommand_thenBuilderBuildAnnotationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    List<FlowDiagramAnnotation> annotationsResult = builderResult.build().annotations();
    assertEquals(1, annotationsResult.size());
    ImmutableSaveDiagramCommand buildResult = actualFromResult.build();
    assertTrue(buildResult.entities().isEmpty());
    assertEquals(flowDiagramAnnotationList, buildResult.annotations());
    assertSame(json, annotationsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(SaveDiagramCommand)} with {@code SaveDiagramCommand}.
   * <ul>
   *   <li>Then builder build entities size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveDiagramCommand) with 'SaveDiagramCommand'; then builder build entities size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveDiagramCommand)"})
  void testBuilderFromWithSaveDiagramCommand_thenBuilderBuildEntitiesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    List<FlowDiagramEntity> entitiesResult = builderResult.build().entities();
    assertEquals(1, entitiesResult.size());
    assertEquals(flowDiagramEntityList, actualFromResult.build().entities());
    assertSame(json, entitiesResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(SaveDiagramCommand)} with {@code SaveDiagramCommand}.
   * <ul>
   *   <li>Then return build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveDiagramCommand) with 'SaveDiagramCommand'; then return build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveDiagramCommand)"})
  void testBuilderFromWithSaveDiagramCommand_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    ImmutableSaveDiagramCommand buildResult = actualFromResult.build();
    assertNull(buildResult.description());
    assertNull(builderResult.build().description());
    List<FlowDiagramAnnotation> annotationsResult = buildResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(buildResult.overlays().isEmpty());
    assertSame(annotationsResult, buildResult.entities());
  }

  /**
   * Test Builder {@link Builder#from(SaveDiagramCommand)} with {@code SaveDiagramCommand}.
   * <ul>
   *   <li>Then return build overlays size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveDiagramCommand) with 'SaveDiagramCommand'; then return build overlays size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveDiagramCommand)"})
  void testBuilderFromWithSaveDiagramCommand_thenReturnBuildOverlaysSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).annotations();
    verify(instance).diagramId();
    verify(instance).entities();
    verify(instance).layoutData();
    verify(instance).overlays();
    assertEquals(1, actualFromResult.build().overlays().size());
    assertEquals(1, builderResult.build().overlays().size());
  }

  /**
   * Test Builder {@link Builder#from(SaveDiagramCommand)} with {@code SaveDiagramCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveDiagramCommand) with 'SaveDiagramCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveDiagramCommand)"})
  void testBuilderFromWithSaveDiagramCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
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
   * Test Builder {@link Builder#layoutData(String)}.
   * <p>
   * Method under test: {@link Builder#layoutData(String)}
   */
  @Test
  @DisplayName("Test Builder layoutData(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.layoutData(String)"})
  void testBuilderLayoutData() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.layoutData("Layout Data"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#overlays(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#overlays(Iterable)}
   */
  @Test
  @DisplayName("Test Builder overlays(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.overlays(Iterable)"})
  void testBuilderOverlays_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlays(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#annotations()}.
   * <p>
   * Method under test: {@link Json#annotations()}
   */
  @Test
  @DisplayName("Test Json annotations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.annotations()"})
  void testJsonAnnotations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).annotations());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#diagramId()}.
   * <p>
   * Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagramId());
  }

  /**
   * Test Json {@link Json#entities()}.
   * <p>
   * Method under test: {@link Json#entities()}
   */
  @Test
  @DisplayName("Test Json entities()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.entities()"})
  void testJsonEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entities());
  }

  /**
   * Test Json {@link Json#layoutData()}.
   * <p>
   * Method under test: {@link Json#layoutData()}
   */
  @Test
  @DisplayName("Test Json layoutData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.layoutData()"})
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).layoutData());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#overlays()}.
   * <p>
   * Method under test: {@link Json#overlays()}
   */
  @Test
  @DisplayName("Test Json overlays()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.overlays()"})
  void testJsonOverlays() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).overlays());
  }
}
