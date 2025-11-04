package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagram#builder()}
   *   <li>{@link ImmutableAggregateOverlayDiagram#description(String)}
   *   <li>{@link ImmutableAggregateOverlayDiagram#kind(EntityKind)}
   *   <li>{@link ImmutableAggregateOverlayDiagram#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAggregateOverlayDiagram#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagram.Builder actualIdResult = ImmutableAggregateOverlayDiagram.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableAggregateOverlayDiagram.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableAggregateOverlayDiagram.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#aggregatedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAggregatedEntityKind() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.aggregatedEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#diagramKind(OverlayDiagramKind)}
   */
  @Test
  void testBuilderDiagramKind() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(AggregateOverlayDiagram)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    AggregateOverlayDiagram instance = mock(AggregateOverlayDiagram.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aggregatedEntityKind();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    verify(instance).status();
    ImmutableAggregateOverlayDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(AggregateOverlayDiagram)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    AggregateOverlayDiagram instance = mock(AggregateOverlayDiagram.class);
    when(instance.status()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aggregatedEntityKind();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    verify(instance).status();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(AggregateOverlayDiagram)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    AggregateOverlayDiagram instance = mock(AggregateOverlayDiagram.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aggregatedEntityKind();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    verify(instance).status();
    ImmutableAggregateOverlayDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#from(AggregateOverlayDiagram)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    AggregateOverlayDiagram instance = mock(AggregateOverlayDiagram.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aggregatedEntityKind();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    verify(instance).status();
    ImmutableAggregateOverlayDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagram.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#layoutData(String)}
   */
  @Test
  void testBuilderLayoutData() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.layoutData("Layout Data"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Builder#status(ReleaseLifecycleStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableAggregateOverlayDiagram.Builder builderResult = ImmutableAggregateOverlayDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(ReleaseLifecycleStatus.DRAFT));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram#copyOf(AggregateOverlayDiagram)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AggregateOverlayDiagram instance = mock(AggregateOverlayDiagram.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagram actualCopyOfResult = ImmutableAggregateOverlayDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aggregatedEntityKind();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    verify(instance).status();
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
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram#copyOf(AggregateOverlayDiagram)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AggregateOverlayDiagram instance = mock(AggregateOverlayDiagram.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagram actualCopyOfResult = ImmutableAggregateOverlayDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aggregatedEntityKind();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    verify(instance).status();
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
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram#copyOf(AggregateOverlayDiagram)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AggregateOverlayDiagram instance = mock(AggregateOverlayDiagram.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagram actualCopyOfResult = ImmutableAggregateOverlayDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aggregatedEntityKind();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    verify(instance).status();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualCopyOfResult.diagramKind());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Json#aggregatedEntityKind()}
   */
  @Test
  void testJsonAggregatedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagram.Json()).aggregatedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagram.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Json#diagramKind()}
   */
  @Test
  void testJsonDiagramKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagram.Json()).diagramKind());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagram.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagram.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagram.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagram.Json()).kind());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagram.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagram.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagram.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagram.Json#layoutData()}
   */
  @Test
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagram.Json()).layoutData());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagram.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagram.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAggregateOverlayDiagram.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagram.Json actualJson = new ImmutableAggregateOverlayDiagram.Json();

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
   * Method under test: {@link ImmutableAggregateOverlayDiagram.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagram.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagram.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagram.Json()).status());
  }
}
