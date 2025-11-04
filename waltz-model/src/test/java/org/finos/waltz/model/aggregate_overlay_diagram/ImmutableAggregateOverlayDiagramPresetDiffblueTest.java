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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramPresetDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#builder()}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#description(String)}
   *   <li>
   * {@link ImmutableAggregateOverlayDiagramPreset#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualIdResult = ImmutableAggregateOverlayDiagramPreset.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableAggregateOverlayDiagramPreset.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableAggregateOverlayDiagramPreset.Builder actualLastUpdatedAtResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#diagramId(Long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#filterConfig(String)}
   */
  @Test
  void testBuilderFilterConfig() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filterConfig("Filter Config"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
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
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(AggregateOverlayDiagramPreset)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    AggregateOverlayDiagramPreset instance = mock(AggregateOverlayDiagramPreset.class);
    when(instance.filterConfig()).thenReturn("Filter Config");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.externalId()).thenReturn("42");
    when(instance.diagramId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    ImmutableAggregateOverlayDiagramPreset buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.externalId());
    assertEquals("Filter Config", buildResult.filterConfig());
    assertEquals("Name", buildResult.name());
    assertEquals("Overlay Config", buildResult.overlayConfig());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(AggregateOverlayDiagramPreset)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    AggregateOverlayDiagramPreset instance = mock(AggregateOverlayDiagramPreset.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.externalId()).thenReturn("42");
    when(instance.diagramId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
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
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).overlayConfig();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(AggregateOverlayDiagramPreset)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    AggregateOverlayDiagramPreset instance = mock(AggregateOverlayDiagramPreset.class);
    when(instance.filterConfig()).thenReturn("Filter Config");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.externalId()).thenReturn("42");
    when(instance.diagramId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    ImmutableAggregateOverlayDiagramPreset buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.externalId());
    assertEquals("Filter Config", buildResult.filterConfig());
    assertEquals("Name", buildResult.name());
    assertEquals("Overlay Config", buildResult.overlayConfig());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#from(AggregateOverlayDiagramPreset)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    AggregateOverlayDiagramPreset instance = mock(AggregateOverlayDiagramPreset.class);
    when(instance.filterConfig()).thenReturn("Filter Config");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.externalId()).thenReturn("42");
    when(instance.diagramId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramPreset.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    ImmutableAggregateOverlayDiagramPreset buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.externalId());
    assertEquals("Filter Config", buildResult.filterConfig());
    assertEquals("Name", buildResult.name());
    assertEquals("Overlay Config", buildResult.overlayConfig());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Builder#overlayConfig(String)}
   */
  @Test
  void testBuilderOverlayConfig() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset.Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayConfig("Overlay Config"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset#copyOf(AggregateOverlayDiagramPreset)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AggregateOverlayDiagramPreset instance = mock(AggregateOverlayDiagramPreset.class);
    when(instance.filterConfig()).thenReturn("Filter Config");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.externalId()).thenReturn("42");
    when(instance.diagramId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramPreset actualCopyOfResult = ImmutableAggregateOverlayDiagramPreset.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Filter Config", actualCopyOfResult.filterConfig());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Overlay Config", actualCopyOfResult.overlayConfig());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset#copyOf(AggregateOverlayDiagramPreset)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AggregateOverlayDiagramPreset instance = mock(AggregateOverlayDiagramPreset.class);
    when(instance.filterConfig()).thenReturn("Filter Config");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.externalId()).thenReturn("42");
    when(instance.diagramId()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramPreset actualCopyOfResult = ImmutableAggregateOverlayDiagramPreset.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Filter Config", actualCopyOfResult.filterConfig());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Overlay Config", actualCopyOfResult.overlayConfig());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset#copyOf(AggregateOverlayDiagramPreset)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AggregateOverlayDiagramPreset instance = mock(AggregateOverlayDiagramPreset.class);
    when(instance.filterConfig()).thenReturn("Filter Config");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.overlayConfig()).thenReturn("Overlay Config");
    when(instance.externalId()).thenReturn("42");
    when(instance.diagramId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramPreset actualCopyOfResult = ImmutableAggregateOverlayDiagramPreset.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).filterConfig();
    verify(instance).overlayConfig();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Filter Config", actualCopyOfResult.filterConfig());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Overlay Config", actualCopyOfResult.overlayConfig());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).diagramId());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).externalId());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Json#filterConfig()}
   */
  @Test
  void testJsonFilterConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).filterConfig());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagramPreset.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagramPreset.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAggregateOverlayDiagramPreset.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramPreset.Json actualJson = new ImmutableAggregateOverlayDiagramPreset.Json();

    // Assert
    assertNull(actualJson.diagramId);
    assertNull(actualJson.description);
    assertNull(actualJson.externalId);
    assertNull(actualJson.filterConfig);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.overlayConfig);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Json#overlayConfig()}
   */
  @Test
  void testJsonOverlayConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).overlayConfig());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramPreset.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramPreset.Json()).provenance());
  }
}
