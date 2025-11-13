package org.finos.waltz.model.aggregate_overlay_diagram;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramDiffblueTest {
  /**
   * Test Builder {@link Builder#aggregatedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#aggregatedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder aggregatedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.aggregatedEntityKind(EntityKind)"})
  void testBuilderAggregatedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualAggregatedEntityKindResult = builderResult.aggregatedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAggregatedEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableAggregateOverlayDiagram.lastUpdatedBy());
    assertEquals("Layout Data", actualImmutableAggregateOverlayDiagram.layoutData());
    assertEquals("Name", actualImmutableAggregateOverlayDiagram.name());
    assertEquals("Provenance", actualImmutableAggregateOverlayDiagram.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableAggregateOverlayDiagram.description());
    assertEquals(EntityKind.ALL, actualImmutableAggregateOverlayDiagram.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualImmutableAggregateOverlayDiagram.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualImmutableAggregateOverlayDiagram.status());
    assertEquals(
        OverlayDiagramKind.WALTZ_ENTITY_OVERLAY,
        actualImmutableAggregateOverlayDiagram.diagramKind());
    assertSame(lastUpdatedAt, actualImmutableAggregateOverlayDiagram.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#diagramKind(OverlayDiagramKind)}.
   *
   * <p>Method under test: {@link Builder#diagramKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName("Test Builder diagramKind(OverlayDiagramKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramKind(OverlayDiagramKind)"})
  void testBuilderDiagramKind() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualDiagramKindResult =
        builderResult.diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    assertSame(builderResult, actualDiagramKindResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagram)} with {@code
   * AggregateOverlayDiagram}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagram) with 'AggregateOverlayDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagram)"})
  void testBuilderFromWithAggregateOverlayDiagram() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram = builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagram)} with {@code
   * AggregateOverlayDiagram}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagram) with 'AggregateOverlayDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagram)"})
  void testBuilderFromWithAggregateOverlayDiagram2() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description(null)
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram = builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram);
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram);
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram);
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram);
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram2);
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
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description(null)
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram);
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram);
    ImmutableAggregateOverlayDiagram actualImmutableAggregateOverlayDiagram2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description(null)
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#layoutData(String)}.
   *
   * <ul>
   *   <li>When {@code Layout Data}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#layoutData(String)}
   */
  @Test
  @DisplayName("Test Builder layoutData(String); when 'Layout Data'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.layoutData(String)"})
  void testBuilderLayoutData_whenLayoutData_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualLayoutDataResult = builderResult.layoutData("Layout Data");

    // Assert
    assertSame(builderResult, actualLayoutDataResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#status(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#status(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(ReleaseLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act
    Builder actualStatusResult = builderResult.status(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#copyOf(AggregateOverlayDiagram)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#copyOf(AggregateOverlayDiagram)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AggregateOverlayDiagram); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.copyOf(AggregateOverlayDiagram)"
  })
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAggregateOverlayDiagram instance =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualCopyOfResult =
        ImmutableAggregateOverlayDiagram.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualCopyOfResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagram#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram2 =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertEquals(immutableAggregateOverlayDiagram, immutableAggregateOverlayDiagram2);
    assertEquals(
        immutableAggregateOverlayDiagram.hashCode(), immutableAggregateOverlayDiagram2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagram#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertEquals(immutableAggregateOverlayDiagram, immutableAggregateOverlayDiagram);
    int expectedHashCodeResult = immutableAggregateOverlayDiagram.hashCode();
    assertEquals(expectedHashCodeResult, immutableAggregateOverlayDiagram.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ACTOR)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_STATIC_SVG_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Name")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("2020-03-01")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Name")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagram,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagram.equals(Object)",
    "int ImmutableAggregateOverlayDiagram.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build(),
        "Different type to ImmutableAggregateOverlayDiagram");
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setLayoutData("Json");
    json.setAggregatedEntityKind(EntityKind.ALL);
    json.setDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableAggregateOverlayDiagram actualFromJsonResult =
        ImmutableAggregateOverlayDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.layoutData());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualFromJsonResult.diagramKind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Id is of forty-two.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Id is of forty-two; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.fromJson(Json)"
  })
  void testFromJson_givenOfFortyTwo_whenJsonIdIsOfFortyTwo_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setLayoutData("Json");
    json.setAggregatedEntityKind(EntityKind.ALL);
    json.setDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableAggregateOverlayDiagram actualFromJsonResult =
        ImmutableAggregateOverlayDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.layoutData());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualFromJsonResult.diagramKind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.fromJson(Json)"
  })
  void testFromJson_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription(null);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setLayoutData("Json");
    json.setAggregatedEntityKind(EntityKind.ALL);
    json.setDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableAggregateOverlayDiagram actualFromJsonResult =
        ImmutableAggregateOverlayDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.layoutData());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualFromJsonResult.diagramKind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Kind is {@code null}.
   *   <li>Then return kind is {@code AGGREGATE_OVERLAY_DIAGRAM}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Kind is 'null'; then return kind is 'AGGREGATE_OVERLAY_DIAGRAM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.fromJson(Json)"
  })
  void testFromJson_whenJsonKindIsNull_thenReturnKindIsAggregateOverlayDiagram() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setLayoutData("Json");
    json.setAggregatedEntityKind(EntityKind.ALL);
    json.setDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    json.setKind(null);

    // Act
    ImmutableAggregateOverlayDiagram actualFromJsonResult =
        ImmutableAggregateOverlayDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.layoutData());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.AGGREGATE_OVERLAY_DIAGRAM, actualFromJsonResult.kind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.aggregatedEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualFromJsonResult.diagramKind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.fromJson(Json)"
  })
  void testFromJson_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance(null);
    json.setLayoutData("Json");
    json.setAggregatedEntityKind(EntityKind.ALL);
    json.setDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableAggregateOverlayDiagram actualFromJsonResult =
        ImmutableAggregateOverlayDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.layoutData());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualFromJsonResult.diagramKind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagram#aggregatedEntityKind()}
   *   <li>{@link ImmutableAggregateOverlayDiagram#description()}
   *   <li>{@link ImmutableAggregateOverlayDiagram#diagramKind()}
   *   <li>{@link ImmutableAggregateOverlayDiagram#lastUpdatedBy()}
   *   <li>{@link ImmutableAggregateOverlayDiagram#layoutData()}
   *   <li>{@link ImmutableAggregateOverlayDiagram#name()}
   *   <li>{@link ImmutableAggregateOverlayDiagram#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityKind ImmutableAggregateOverlayDiagram.aggregatedEntityKind()",
    "String ImmutableAggregateOverlayDiagram.description()",
    "OverlayDiagramKind ImmutableAggregateOverlayDiagram.diagramKind()",
    "String ImmutableAggregateOverlayDiagram.lastUpdatedBy()",
    "String ImmutableAggregateOverlayDiagram.layoutData()",
    "String ImmutableAggregateOverlayDiagram.name()",
    "ReleaseLifecycleStatus ImmutableAggregateOverlayDiagram.status()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    EntityKind actualAggregatedEntityKindResult =
        immutableAggregateOverlayDiagram.aggregatedEntityKind();
    String actualDescriptionResult = immutableAggregateOverlayDiagram.description();
    OverlayDiagramKind actualDiagramKindResult = immutableAggregateOverlayDiagram.diagramKind();
    String actualLastUpdatedByResult = immutableAggregateOverlayDiagram.lastUpdatedBy();
    String actualLayoutDataResult = immutableAggregateOverlayDiagram.layoutData();
    String actualNameResult = immutableAggregateOverlayDiagram.name();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Layout Data", actualLayoutDataResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualAggregatedEntityKindResult);
    assertEquals(ReleaseLifecycleStatus.DRAFT, immutableAggregateOverlayDiagram.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualDiagramKindResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#id()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAggregateOverlayDiagram.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#aggregatedEntityKind()}.
   *
   * <p>Method under test: {@link Json#aggregatedEntityKind()}
   */
  @Test
  @DisplayName("Test Json aggregatedEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.aggregatedEntityKind()"})
  void testJsonAggregatedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().aggregatedEntityKind());
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
   * Test Json {@link Json#diagramKind()}.
   *
   * <p>Method under test: {@link Json#diagramKind()}
   */
  @Test
  @DisplayName("Test Json diagramKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverlayDiagramKind Json.diagramKind()"})
  void testJsonDiagramKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramKind());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
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
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.layoutData);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.aggregatedEntityKind);
    assertNull(actualJson.kind);
    assertNull(actualJson.status);
    assertNull(actualJson.diagramKind);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#kind()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableAggregateOverlayDiagram.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableAggregateOverlayDiagram.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#provenance()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAggregateOverlayDiagram.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#toString()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAggregateOverlayDiagram.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AggregateOverlayDiagram{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " provenance=Provenance, layoutData=Layout Data, aggregatedEntityKind=ALL, diagramKind=WALTZ_ENTITY_OVERLAY,"
            + " status=DRAFT, kind=ALL}",
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withAggregatedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagram#withAggregatedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAggregatedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withAggregatedEntityKind(EntityKind)"
  })
  void testWithAggregatedEntityKind() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithAggregatedEntityKindResult =
        immutableAggregateOverlayDiagram.withAggregatedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithAggregatedEntityKindResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withAggregatedEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagram#withAggregatedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withAggregatedEntityKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withAggregatedEntityKind(EntityKind)"
  })
  void testWithAggregatedEntityKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithAggregatedEntityKindResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ACTOR)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .withAggregatedEntityKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithAggregatedEntityKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithAggregatedEntityKindResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithAggregatedEntityKindResult.layoutData());
    assertEquals("Name", actualWithAggregatedEntityKindResult.name());
    assertEquals("Provenance", actualWithAggregatedEntityKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithAggregatedEntityKindResult.description());
    assertEquals(EntityKind.ALL, actualWithAggregatedEntityKindResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithAggregatedEntityKindResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithAggregatedEntityKindResult.status());
    assertEquals(
        OverlayDiagramKind.WALTZ_ENTITY_OVERLAY,
        actualWithAggregatedEntityKindResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithDescriptionResult =
        immutableAggregateOverlayDiagram.withDescription("42");

    // Assert
    assertEquals(immutableAggregateOverlayDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("42")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithDescriptionResult =
        immutableAggregateOverlayDiagram.withDescription("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withDiagramKind(OverlayDiagramKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagram#withDiagramKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName("Test withDiagramKind(OverlayDiagramKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withDiagramKind(OverlayDiagramKind)"
  })
  void testWithDiagramKind() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithDiagramKindResult =
        immutableAggregateOverlayDiagram.withDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithDiagramKindResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withDiagramKind(OverlayDiagramKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagram#withDiagramKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName(
      "Test withDiagramKind(OverlayDiagramKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withDiagramKind(OverlayDiagramKind)"
  })
  void testWithDiagramKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithDiagramKindResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_STATIC_SVG_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .withDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithDiagramKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithDiagramKindResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithDiagramKindResult.layoutData());
    assertEquals("Name", actualWithDiagramKindResult.name());
    assertEquals("Provenance", actualWithDiagramKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramKindResult.description());
    assertEquals(EntityKind.ALL, actualWithDiagramKindResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithDiagramKindResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithDiagramKindResult.status());
    assertEquals(
        OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithDiagramKindResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAggregateOverlayDiagram actualWithIdResult =
        immutableAggregateOverlayDiagram.withId(optional);

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableAggregateOverlayDiagram actualWithIdResult =
        immutableAggregateOverlayDiagram.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithIdResult.layoutData());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIdResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithIdResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithIdResult =
        immutableAggregateOverlayDiagram.withId(1L);

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withId(long)"
  })
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithIdResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithIdResult.layoutData());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIdResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithIdResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithKindResult =
        immutableAggregateOverlayDiagram.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withKind(EntityKind)"
  })
  void testWithKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithKindResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithKindResult.layoutData());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithKindResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithKindResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithLastUpdatedAtResult =
        immutableAggregateOverlayDiagram.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAggregateOverlayDiagram, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithLastUpdatedByResult =
        immutableAggregateOverlayDiagram.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithLastUpdatedByResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithLastUpdatedByResult.layoutData());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithLastUpdatedByResult.status());
    assertEquals(
        OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithLastUpdatedByResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withLayoutData(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withLayoutData(String)}
   */
  @Test
  @DisplayName("Test withLayoutData(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withLayoutData(String)"
  })
  void testWithLayoutData() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("42")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithLayoutDataResult =
        immutableAggregateOverlayDiagram.withLayoutData("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithLayoutDataResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withLayoutData(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withLayoutData(String)}
   */
  @Test
  @DisplayName(
      "Test withLayoutData(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withLayoutData(String)"
  })
  void testWithLayoutData_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithLayoutDataResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .withLayoutData("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLayoutDataResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithLayoutDataResult.lastUpdatedBy());
    assertEquals("42", actualWithLayoutDataResult.layoutData());
    assertEquals("Name", actualWithLayoutDataResult.name());
    assertEquals("Provenance", actualWithLayoutDataResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLayoutDataResult.description());
    assertEquals(EntityKind.ALL, actualWithLayoutDataResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithLayoutDataResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithLayoutDataResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithLayoutDataResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("42")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithNameResult =
        immutableAggregateOverlayDiagram.withName("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withName(String)"
  })
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithNameResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Layout Data", actualWithNameResult.layoutData());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithNameResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithNameResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("42")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithProvenanceResult =
        immutableAggregateOverlayDiagram.withProvenance("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagram#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withProvenance(String)"
  })
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithProvenanceResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Layout Data", actualWithProvenanceResult.layoutData());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithProvenanceResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithProvenanceResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withStatus(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagram#withStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withStatus(ReleaseLifecycleStatus)"
  })
  void testWithStatus() {
    // Arrange
    ImmutableAggregateOverlayDiagram immutableAggregateOverlayDiagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableAggregateOverlayDiagram actualWithStatusResult =
        immutableAggregateOverlayDiagram.withStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(immutableAggregateOverlayDiagram, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagram#withStatus(ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagram#withStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(ReleaseLifecycleStatus); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagram ImmutableAggregateOverlayDiagram.withStatus(ReleaseLifecycleStatus)"
  })
  void testWithStatus_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagram actualWithStatusResult =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.ACTIVE)
            .build()
            .withStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithStatusResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithStatusResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithStatusResult.layoutData());
    assertEquals("Name", actualWithStatusResult.name());
    assertEquals("Provenance", actualWithStatusResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithStatusResult.description());
    assertEquals(EntityKind.ALL, actualWithStatusResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualWithStatusResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithStatusResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithStatusResult.diagramKind());
    assertSame(ofResult, toLocalDateResult);
  }
}
