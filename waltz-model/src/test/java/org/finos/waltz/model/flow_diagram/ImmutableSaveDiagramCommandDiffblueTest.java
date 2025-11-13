package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.flow_diagram.ImmutableSaveDiagramCommand.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableSaveDiagramCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveDiagramCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAnnotations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAnnotations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAnnotations(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAnnotations(Iterable)"})
  void testBuilderAddAllAnnotations_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddAllAnnotationsResult = builderResult.addAllAnnotations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAnnotationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllEntities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntities(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEntities(Iterable)"})
  void testBuilderAddAllEntities_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddAllEntitiesResult = builderResult.addAllEntities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addAllOverlays(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOverlays(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOverlays(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOverlays(Iterable)"})
  void testBuilderAddAllOverlays_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddAllOverlaysResult = builderResult.addAllOverlays(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllOverlaysResult);
  }

  /**
   * Test Builder {@link Builder#addAnnotations(FlowDiagramAnnotation)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramAnnotation.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAnnotations(FlowDiagramAnnotation)}
   */
  @Test
  @DisplayName(
      "Test Builder addAnnotations(FlowDiagramAnnotation) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAnnotations(FlowDiagramAnnotation)"})
  void testBuilderAddAnnotationsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddAnnotationsResult =
        builderResult.addAnnotations(new ImmutableFlowDiagramAnnotation.Json());

    // Assert
    assertSame(builderResult, actualAddAnnotationsResult);
  }

  /**
   * Test Builder {@link Builder#addAnnotations(FlowDiagramAnnotation[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addAnnotations(FlowDiagramAnnotation[])}
   */
  @Test
  @DisplayName("Test Builder addAnnotations(FlowDiagramAnnotation[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAnnotations(FlowDiagramAnnotation[])"})
  void testBuilderAddAnnotationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddAnnotationsResult =
        builderResult.addAnnotations(new ImmutableFlowDiagramAnnotation.Json());

    // Assert
    assertSame(builderResult, actualAddAnnotationsResult);
  }

  /**
   * Test Builder {@link Builder#addEntities(FlowDiagramEntity)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramEntity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addEntities(FlowDiagramEntity)}
   */
  @Test
  @DisplayName(
      "Test Builder addEntities(FlowDiagramEntity) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntities(FlowDiagramEntity)"})
  void testBuilderAddEntitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddEntitiesResult =
        builderResult.addEntities(new ImmutableFlowDiagramEntity.Json());

    // Assert
    assertSame(builderResult, actualAddEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addEntities(FlowDiagramEntity[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addEntities(FlowDiagramEntity[])}
   */
  @Test
  @DisplayName("Test Builder addEntities(FlowDiagramEntity[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntities(FlowDiagramEntity[])"})
  void testBuilderAddEntitiesWithElements() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddEntitiesResult =
        builderResult.addEntities(new ImmutableFlowDiagramEntity.Json());

    // Assert
    assertSame(builderResult, actualAddEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addOverlays(FlowDiagramOverlayGroupEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableFlowDiagramOverlayGroupEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOverlays(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addOverlays(FlowDiagramOverlayGroupEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOverlays(FlowDiagramOverlayGroupEntry)"})
  void testBuilderAddOverlaysWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddOverlaysResult =
        builderResult.addOverlays(new ImmutableFlowDiagramOverlayGroupEntry.Json());

    // Assert
    assertSame(builderResult, actualAddOverlaysResult);
  }

  /**
   * Test Builder {@link Builder#addOverlays(FlowDiagramOverlayGroupEntry[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addOverlays(FlowDiagramOverlayGroupEntry[])}
   */
  @Test
  @DisplayName("Test Builder addOverlays(FlowDiagramOverlayGroupEntry[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOverlays(FlowDiagramOverlayGroupEntry[])"})
  void testBuilderAddOverlaysWithElements() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAddOverlaysResult =
        builderResult.addOverlays(new ImmutableFlowDiagramOverlayGroupEntry.Json());

    // Assert
    assertSame(builderResult, actualAddOverlaysResult);
  }

  /**
   * Test Builder {@link Builder#annotations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#annotations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder annotations(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.annotations(Iterable)"})
  void testBuilderAnnotations_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualAnnotationsResult = builderResult.annotations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAnnotationsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDiagramIdResult =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L);
    Optional<Long> diagramId = Optional.of(42L);
    ImmutableSaveDiagramCommand actualImmutableSaveDiagramCommand =
        actualDiagramIdResult.diagramId(diagramId).layoutData("Layout Data").name("Name").build();

    // Assert
    assertEquals("Layout Data", actualImmutableSaveDiagramCommand.layoutData());
    assertEquals("Name", actualImmutableSaveDiagramCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSaveDiagramCommand.description());
    assertTrue(actualImmutableSaveDiagramCommand.annotations().isEmpty());
    assertTrue(actualImmutableSaveDiagramCommand.overlays().isEmpty());
  }

  /**
   * Test Builder {@link Builder#diagramId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#diagramId(long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(long)"})
  void testBuilderDiagramIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#diagramId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#diagramId(Optional)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(Optional)"})
  void testBuilderDiagramIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    Optional<Long> diagramId = Optional.of(42L);

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(diagramId);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntities_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualEntitiesResult = builderResult.entities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    ImmutableSaveDiagramCommand instance =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableSaveDiagramCommand actualImmutableSaveDiagramCommand =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableSaveDiagramCommand);
    ImmutableSaveDiagramCommand actualImmutableSaveDiagramCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSaveDiagramCommand2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
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
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    ImmutableSaveDiagramCommand instance =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableSaveDiagramCommand actualImmutableSaveDiagramCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSaveDiagramCommand);
    ImmutableSaveDiagramCommand actualImmutableSaveDiagramCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSaveDiagramCommand2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(SaveDiagramCommand)} with {@code SaveDiagramCommand}.
   *
   * <p>Method under test: {@link Builder#from(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveDiagramCommand) with 'SaveDiagramCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveDiagramCommand)"})
  void testBuilderFromWithSaveDiagramCommand() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();
    ImmutableSaveDiagramCommand instance =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSaveDiagramCommand actualImmutableSaveDiagramCommand = builderResult.build();
    assertEquals(instance, actualImmutableSaveDiagramCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#layoutData(String)}.
   *
   * <p>Method under test: {@link Builder#layoutData(String)}
   */
  @Test
  @DisplayName("Test Builder layoutData(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.layoutData(String)"})
  void testBuilderLayoutData() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualLayoutDataResult = builderResult.layoutData("Layout Data");

    // Assert
    assertSame(builderResult, actualLayoutDataResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#overlays(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#overlays(Iterable)}
   */
  @Test
  @DisplayName("Test Builder overlays(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overlays(Iterable)"})
  void testBuilderOverlays_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    // Act
    Builder actualOverlaysResult = builderResult.overlays(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOverlaysResult);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Layout Data}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#copyOf(SaveDiagramCommand)}
   */
  @Test
  @DisplayName("Test copyOf(SaveDiagramCommand); then return 'Layout Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.copyOf(SaveDiagramCommand)"
  })
  void testCopyOf_thenReturnLayoutData() {
    // Arrange
    ImmutableSaveDiagramCommand instance =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableSaveDiagramCommand actualCopyOfResult = ImmutableSaveDiagramCommand.copyOf(instance);

    // Assert
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualCopyOfResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(actualCopyOfResult.overlays().isEmpty());
    assertSame(annotationsResult, actualCopyOfResult.entities());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#diagramId()}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#diagramId()}
   */
  @Test
  @DisplayName("Test diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSaveDiagramCommand.diagramId()"})
  void testDiagramId() {
    // Arrange and Act
    Optional<Long> actualDiagramIdResult =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .diagramId();

    // Assert
    assertEquals(1L, actualDiagramIdResult.get().longValue());
    assertTrue(actualDiagramIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#equals(Object)}, and {@link
   * ImmutableSaveDiagramCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveDiagramCommand#equals(Object)}
   *   <li>{@link ImmutableSaveDiagramCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveDiagramCommand.equals(Object)",
    "int ImmutableSaveDiagramCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand2 =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableSaveDiagramCommand, immutableSaveDiagramCommand2);
    assertEquals(immutableSaveDiagramCommand.hashCode(), immutableSaveDiagramCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#equals(Object)}, and {@link
   * ImmutableSaveDiagramCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveDiagramCommand#equals(Object)}
   *   <li>{@link ImmutableSaveDiagramCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveDiagramCommand.equals(Object)",
    "int ImmutableSaveDiagramCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableSaveDiagramCommand, immutableSaveDiagramCommand);
    int expectedHashCodeResult = immutableSaveDiagramCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSaveDiagramCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveDiagramCommand.equals(Object)",
    "int ImmutableSaveDiagramCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramEntity.Builder diagramIdResult =
        ImmutableFlowDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        builderResult
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSaveDiagramCommand,
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveDiagramCommand.equals(Object)",
    "int ImmutableSaveDiagramCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramAnnotation.Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    builderResult.addAnnotations(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        builderResult
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSaveDiagramCommand,
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveDiagramCommand.equals(Object)",
    "int ImmutableSaveDiagramCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult2 =
        ImmutableFlowDiagramOverlayGroupEntry.builder();
    builderResult.addOverlays(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        builderResult
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSaveDiagramCommand,
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveDiagramCommand.equals(Object)",
    "int ImmutableSaveDiagramCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveDiagramCommand.equals(Object)",
    "int ImmutableSaveDiagramCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build(),
        "Different type to ImmutableSaveDiagramCommand");
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableFlowDiagramAnnotation.Json}
   *       (default constructor).
   *   <li>Then return entities first {@link ImmutableFlowDiagramEntity.Json#diagramId} is {@link
   *       ImmutableFlowDiagramOverlayGroupEntry.Json} (default constructor) {@link
   *       ImmutableFlowDiagramOverlayGroupEntry.Json#id}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return entities first diagramId is Json (default constructor) id")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnEntitiesFirstDiagramIdIsJsonId() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();
    entities.add(new ImmutableFlowDiagramEntity.Json());

    ArrayList<FlowDiagramAnnotation> annotations = new ArrayList<>();
    annotations.add(new ImmutableFlowDiagramAnnotation.Json());

    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    ImmutableFlowDiagramOverlayGroupEntry.Json json =
        new ImmutableFlowDiagramOverlayGroupEntry.Json();
    overlays.add(json);

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json2.setDiagramId(diagramId);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(annotations);
    json2.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(1, entitiesResult.size());
    FlowDiagramEntity getResult = entitiesResult.get(0);
    assertTrue(getResult instanceof ImmutableFlowDiagramEntity.Json);
    assertSame(json.id, ((ImmutableFlowDiagramEntity.Json) getResult).diagramId);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return annotations Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return annotations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_givenArrayList_thenReturnAnnotationsEmpty() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();
    ImmutableFlowDiagramEntity.Json json = new ImmutableFlowDiagramEntity.Json();
    entities.add(json);

    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    overlays.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json2.setDiagramId(diagramId);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(new ArrayList<>());
    json2.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(1, entitiesResult.size());
    assertTrue(actualFromJsonResult.annotations().isEmpty());
    assertSame(json, entitiesResult.get(0));
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Overlays is {@link HashSet#HashSet()}.
   *   <li>Then return overlays Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Overlays is HashSet(); then return overlays Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonOverlaysIsHashSet_thenReturnOverlaysEmpty() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();
    entities.add(new ImmutableFlowDiagramEntity.Json());

    ArrayList<FlowDiagramAnnotation> annotations = new ArrayList<>();
    ImmutableFlowDiagramAnnotation.Json json = new ImmutableFlowDiagramAnnotation.Json();
    annotations.add(json);

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json2.setDiagramId(diagramId);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(annotations);
    json2.setOverlays(new HashSet<>());

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(1, entitiesResult.size());
    FlowDiagramEntity getResult = entitiesResult.get(0);
    assertTrue(getResult instanceof ImmutableFlowDiagramEntity.Json);
    assertTrue(actualFromJsonResult.overlays().isEmpty());
    assertSame(json.diagramId, ((ImmutableFlowDiagramEntity.Json) getResult).diagramId);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Annotations is {@code null}.
   *   <li>Then return annotations Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Annotations is 'null'; then return annotations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonAnnotationsIsNull_thenReturnAnnotationsEmpty() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();
    ImmutableFlowDiagramEntity.Json json = new ImmutableFlowDiagramEntity.Json();
    entities.add(json);

    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    overlays.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json2.setDiagramId(diagramId);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(null);
    json2.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(1, entitiesResult.size());
    assertTrue(actualFromJsonResult.annotations().isEmpty());
    assertSame(json, entitiesResult.get(0));
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();
    entities.add(new ImmutableFlowDiagramEntity.Json());

    ArrayList<FlowDiagramAnnotation> annotations = new ArrayList<>();
    annotations.add(new ImmutableFlowDiagramAnnotation.Json());

    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    ImmutableFlowDiagramOverlayGroupEntry.Json json =
        new ImmutableFlowDiagramOverlayGroupEntry.Json();
    overlays.add(json);

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription(null);
    Optional<Long> diagramId = Optional.of(42L);
    json2.setDiagramId(diagramId);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(annotations);
    json2.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(1, entitiesResult.size());
    FlowDiagramEntity getResult = entitiesResult.get(0);
    assertTrue(getResult instanceof ImmutableFlowDiagramEntity.Json);
    assertNull(actualFromJsonResult.description());
    assertSame(json.id, ((ImmutableFlowDiagramEntity.Json) getResult).diagramId);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Entities is {@code null}.
   *   <li>Then return entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Entities is 'null'; then return entities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonEntitiesIsNull_thenReturnEntitiesEmpty() {
    // Arrange
    ArrayList<FlowDiagramAnnotation> annotations = new ArrayList<>();
    annotations.add(new ImmutableFlowDiagramAnnotation.Json());

    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    overlays.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());

    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json.setDiagramId(diagramId);
    json.setLayoutData("Json");
    json.setEntities(null);
    json.setAnnotations(annotations);
    json.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.entities().isEmpty());
    assertEquals(annotations, actualFromJsonResult.annotations());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Overlays is {@code null}.
   *   <li>Then return overlays Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Overlays is 'null'; then return overlays Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonOverlaysIsNull_thenReturnOverlaysEmpty() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();
    entities.add(new ImmutableFlowDiagramEntity.Json());

    ArrayList<FlowDiagramAnnotation> annotations = new ArrayList<>();
    ImmutableFlowDiagramAnnotation.Json json = new ImmutableFlowDiagramAnnotation.Json();
    annotations.add(json);

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json2.setDiagramId(diagramId);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(annotations);
    json2.setOverlays(null);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(1, entitiesResult.size());
    FlowDiagramEntity getResult = entitiesResult.get(0);
    assertTrue(getResult instanceof ImmutableFlowDiagramEntity.Json);
    assertTrue(actualFromJsonResult.overlays().isEmpty());
    assertSame(json.diagramId, ((ImmutableFlowDiagramEntity.Json) getResult).diagramId);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return entities size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return entities size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_thenReturnEntitiesSizeIsTwo() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();

    ImmutableFlowDiagramEntity.Builder diagramIdResult =
        ImmutableFlowDiagramEntity.builder().diagramId(1L);
    entities.add(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableFlowDiagramEntity.Json json = new ImmutableFlowDiagramEntity.Json();
    entities.add(json);

    ArrayList<FlowDiagramAnnotation> annotations = new ArrayList<>();
    annotations.add(new ImmutableFlowDiagramAnnotation.Json());

    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    overlays.add(new ImmutableFlowDiagramOverlayGroupEntry.Json());

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json2.setDiagramId(diagramId);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(annotations);
    json2.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(2, entitiesResult.size());
    FlowDiagramEntity getResult = entitiesResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableFlowDiagramEntity);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(getResult.isNotable());
    assertSame(json, entitiesResult.get(1));
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return overlays size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return overlays size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_thenReturnOverlaysSizeIsTwo() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();
    entities.add(new ImmutableFlowDiagramEntity.Json());

    ArrayList<FlowDiagramAnnotation> annotations = new ArrayList<>();
    annotations.add(new ImmutableFlowDiagramAnnotation.Json());

    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();

    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult =
        ImmutableFlowDiagramOverlayGroupEntry.builder();
    overlays.add(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
    ImmutableFlowDiagramOverlayGroupEntry.Json json =
        new ImmutableFlowDiagramOverlayGroupEntry.Json();
    overlays.add(json);

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json2.setDiagramId(diagramId);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(annotations);
    json2.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(1, entitiesResult.size());
    FlowDiagramEntity getResult = entitiesResult.get(0);
    assertTrue(getResult instanceof ImmutableFlowDiagramEntity.Json);
    assertEquals(2, actualFromJsonResult.overlays().size());
    assertSame(json.id, ((ImmutableFlowDiagramEntity.Json) getResult).diagramId);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) DiagramId is {@code null}.
   *   <li>Then return entities first {@link ImmutableFlowDiagramEntity.Json#diagramId} is {@link
   *       ImmutableFlowDiagramOverlayGroupEntry.Json} (default constructor) {@link
   *       ImmutableFlowDiagramOverlayGroupEntry.Json#id}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) DiagramId is 'null'; then return entities first diagramId is Json (default constructor) id")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.fromJson(Json)"})
  void testFromJson_whenJsonDiagramIdIsNull_thenReturnEntitiesFirstDiagramIdIsJsonId() {
    // Arrange
    ArrayList<FlowDiagramEntity> entities = new ArrayList<>();
    entities.add(new ImmutableFlowDiagramEntity.Json());

    ArrayList<FlowDiagramAnnotation> annotations = new ArrayList<>();
    annotations.add(new ImmutableFlowDiagramAnnotation.Json());

    LinkedHashSet<FlowDiagramOverlayGroupEntry> overlays = new LinkedHashSet<>();
    ImmutableFlowDiagramOverlayGroupEntry.Json json =
        new ImmutableFlowDiagramOverlayGroupEntry.Json();
    overlays.add(json);

    Json json2 = new Json();
    json2.setName("Json");
    json2.setDescription("Json");
    json2.setDiagramId(null);
    json2.setLayoutData("Json");
    json2.setEntities(entities);
    json2.setAnnotations(annotations);
    json2.setOverlays(overlays);

    // Act
    ImmutableSaveDiagramCommand actualFromJsonResult = ImmutableSaveDiagramCommand.fromJson(json2);

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualFromJsonResult.entities();
    assertEquals(1, entitiesResult.size());
    FlowDiagramEntity getResult = entitiesResult.get(0);
    assertTrue(getResult instanceof ImmutableFlowDiagramEntity.Json);
    assertSame(json.id, ((ImmutableFlowDiagramEntity.Json) getResult).diagramId);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveDiagramCommand#annotations()}
   *   <li>{@link ImmutableSaveDiagramCommand#description()}
   *   <li>{@link ImmutableSaveDiagramCommand#entities()}
   *   <li>{@link ImmutableSaveDiagramCommand#layoutData()}
   *   <li>{@link ImmutableSaveDiagramCommand#name()}
   *   <li>{@link ImmutableSaveDiagramCommand#overlays()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableSaveDiagramCommand.annotations()",
    "String ImmutableSaveDiagramCommand.description()",
    "List ImmutableSaveDiagramCommand.entities()",
    "String ImmutableSaveDiagramCommand.layoutData()",
    "String ImmutableSaveDiagramCommand.name()",
    "Set ImmutableSaveDiagramCommand.overlays()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    List<FlowDiagramAnnotation> actualAnnotationsResult = immutableSaveDiagramCommand.annotations();
    String actualDescriptionResult = immutableSaveDiagramCommand.description();
    List<FlowDiagramEntity> actualEntitiesResult = immutableSaveDiagramCommand.entities();
    String actualLayoutDataResult = immutableSaveDiagramCommand.layoutData();
    String actualNameResult = immutableSaveDiagramCommand.name();
    Set<FlowDiagramOverlayGroupEntry> actualOverlaysResult = immutableSaveDiagramCommand.overlays();

    // Assert
    assertEquals("Layout Data", actualLayoutDataResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertTrue(actualAnnotationsResult.isEmpty());
    assertTrue(actualOverlaysResult.isEmpty());
    assertSame(actualAnnotationsResult, actualEntitiesResult);
  }

  /**
   * Test Json {@link Json#annotations()}.
   *
   * <p>Method under test: {@link Json#annotations()}
   */
  @Test
  @DisplayName("Test Json annotations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.annotations()"})
  void testJsonAnnotations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().annotations());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#diagramId()}.
   *
   * <p>Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramId());
  }

  /**
   * Test Json {@link Json#entities()}.
   *
   * <p>Method under test: {@link Json#entities()}
   */
  @Test
  @DisplayName("Test Json entities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.entities()"})
  void testJsonEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entities());
  }

  /**
   * Test Json {@link Json#layoutData()}.
   *
   * <p>Method under test: {@link Json#layoutData()}
   */
  @Test
  @DisplayName("Test Json layoutData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.layoutData()"})
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().layoutData());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#overlays()}
   */
  @Test
  @DisplayName("Test Json overlays()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.overlays()"})
  void testJsonOverlays() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlays());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSaveDiagramCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SaveDiagramCommand{name=Name, diagramId=1, layoutData=Layout Data, entities=[], annotations=[],"
            + " overlays=[]}",
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withAnnotations(FlowDiagramAnnotation[])} with {@code
   * FlowDiagramAnnotation[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveDiagramCommand#withAnnotations(FlowDiagramAnnotation[])}
   */
  @Test
  @DisplayName("Test withAnnotations(FlowDiagramAnnotation[]) with 'FlowDiagramAnnotation[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withAnnotations(FlowDiagramAnnotation[])"
  })
  void testWithAnnotationsWithFlowDiagramAnnotation() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    ImmutableFlowDiagramAnnotation.Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act
    ImmutableSaveDiagramCommand actualWithAnnotationsResult =
        immutableSaveDiagramCommand.withAnnotations(
            diagramIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .note("Note")
                .build());

    // Assert
    List<FlowDiagramAnnotation> annotationsResult = actualWithAnnotationsResult.annotations();
    assertEquals(1, annotationsResult.size());
    FlowDiagramAnnotation getResult = annotationsResult.get(0);
    assertTrue(getResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableFlowDiagramAnnotation);
    assertEquals("42", getResult.annotationId());
    assertEquals("Layout Data", actualWithAnnotationsResult.layoutData());
    assertEquals("Name", actualWithAnnotationsResult.name());
    assertEquals("Note", getResult.note());
    assertEquals(
        "The characteristics of someone or something", actualWithAnnotationsResult.description());
    assertTrue(actualWithAnnotationsResult.entities().isEmpty());
    assertTrue(actualWithAnnotationsResult.overlays().isEmpty());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableSaveDiagramCommand actualWithDescriptionResult =
        immutableSaveDiagramCommand.withDescription("42");

    // Assert
    assertEquals(immutableSaveDiagramCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("42")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableSaveDiagramCommand actualWithDescriptionResult =
        immutableSaveDiagramCommand.withDescription("42");

    // Assert
    assertSame(immutableSaveDiagramCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withDiagramId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#withDiagramId(Optional)}
   */
  @Test
  @DisplayName("Test withDiagramId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withDiagramId(Optional)"
  })
  void testWithDiagramIdWithOptional() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableSaveDiagramCommand actualWithDiagramIdResult =
        immutableSaveDiagramCommand.withDiagramId(optional);

    // Assert
    assertEquals("Layout Data", actualWithDiagramIdResult.layoutData());
    assertEquals("Name", actualWithDiagramIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramIdResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualWithDiagramIdResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(actualWithDiagramIdResult.overlays().isEmpty());
    assertSame(annotationsResult, actualWithDiagramIdResult.entities());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withDiagramId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#withDiagramId(long)}
   */
  @Test
  @DisplayName("Test withDiagramId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withDiagramId(long)"})
  void testWithDiagramIdWithValue() {
    // Arrange and Act
    ImmutableSaveDiagramCommand actualWithDiagramIdResult =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withDiagramId(42L);

    // Assert
    assertEquals("Layout Data", actualWithDiagramIdResult.layoutData());
    assertEquals("Name", actualWithDiagramIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramIdResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualWithDiagramIdResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(actualWithDiagramIdResult.overlays().isEmpty());
    assertSame(annotationsResult, actualWithDiagramIdResult.entities());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withEntities(FlowDiagramEntity[])} with {@code
   * FlowDiagramEntity[]}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#withEntities(FlowDiagramEntity[])}
   */
  @Test
  @DisplayName("Test withEntities(FlowDiagramEntity[]) with 'FlowDiagramEntity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withEntities(FlowDiagramEntity[])"
  })
  void testWithEntitiesWithFlowDiagramEntity() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    ImmutableFlowDiagramEntity.Builder diagramIdResult =
        ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act
    ImmutableSaveDiagramCommand actualWithEntitiesResult =
        immutableSaveDiagramCommand.withEntities(
            diagramIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Assert
    List<FlowDiagramEntity> entitiesResult = actualWithEntitiesResult.entities();
    assertEquals(1, entitiesResult.size());
    FlowDiagramEntity getResult = entitiesResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableFlowDiagramEntity);
    assertEquals("Layout Data", actualWithEntitiesResult.layoutData());
    assertEquals("Name", actualWithEntitiesResult.name());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithEntitiesResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(getResult.isNotable());
    assertTrue(actualWithEntitiesResult.annotations().isEmpty());
    assertTrue(actualWithEntitiesResult.overlays().isEmpty());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withLayoutData(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#withLayoutData(String)}
   */
  @Test
  @DisplayName("Test withLayoutData(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withLayoutData(String)"
  })
  void testWithLayoutData() {
    // Arrange and Act
    ImmutableSaveDiagramCommand actualWithLayoutDataResult =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withLayoutData("42");

    // Assert
    assertEquals("42", actualWithLayoutDataResult.layoutData());
    assertEquals("Name", actualWithLayoutDataResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithLayoutDataResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualWithLayoutDataResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(actualWithLayoutDataResult.overlays().isEmpty());
    assertSame(annotationsResult, actualWithLayoutDataResult.entities());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveDiagramCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withName(String)"})
  void testWithName() {
    // Arrange and Act
    ImmutableSaveDiagramCommand actualWithNameResult =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Layout Data", actualWithNameResult.layoutData());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    List<FlowDiagramAnnotation> annotationsResult = actualWithNameResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertTrue(actualWithNameResult.overlays().isEmpty());
    assertSame(annotationsResult, actualWithNameResult.entities());
  }

  /**
   * Test {@link ImmutableSaveDiagramCommand#withOverlays(FlowDiagramOverlayGroupEntry[])} with
   * {@code FlowDiagramOverlayGroupEntry[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveDiagramCommand#withOverlays(FlowDiagramOverlayGroupEntry[])}
   */
  @Test
  @DisplayName(
      "Test withOverlays(FlowDiagramOverlayGroupEntry[]) with 'FlowDiagramOverlayGroupEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveDiagramCommand ImmutableSaveDiagramCommand.withOverlays(FlowDiagramOverlayGroupEntry[])"
  })
  void testWithOverlaysWithFlowDiagramOverlayGroupEntry() {
    // Arrange
    ImmutableSaveDiagramCommand immutableSaveDiagramCommand =
        ImmutableSaveDiagramCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    ImmutableFlowDiagramOverlayGroupEntry.Builder builderResult =
        ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    ImmutableSaveDiagramCommand actualWithOverlaysResult =
        immutableSaveDiagramCommand.withOverlays(
            builderResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .fill("Fill")
                .id(1L)
                .overlayGroupId(1L)
                .stroke("Stroke")
                .symbol("Symbol")
                .build());

    // Assert
    assertEquals("Layout Data", actualWithOverlaysResult.layoutData());
    assertEquals("Name", actualWithOverlaysResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithOverlaysResult.description());
    assertEquals(1, actualWithOverlaysResult.overlays().size());
    List<FlowDiagramAnnotation> annotationsResult = actualWithOverlaysResult.annotations();
    assertTrue(annotationsResult.isEmpty());
    assertSame(annotationsResult, actualWithOverlaysResult.entities());
  }
}
