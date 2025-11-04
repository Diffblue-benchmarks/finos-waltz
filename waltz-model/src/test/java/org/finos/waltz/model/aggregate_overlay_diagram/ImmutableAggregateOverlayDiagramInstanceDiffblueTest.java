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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramInstanceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#builder()}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#description(String)}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#kind(EntityKind)}
   *   <li>
   * {@link ImmutableAggregateOverlayDiagramInstance#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualIdResult = ImmutableAggregateOverlayDiagramInstance.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableAggregateOverlayDiagramInstance.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableAggregateOverlayDiagramInstance.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#diagramId(Long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
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
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(AggregateOverlayDiagramInstance)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    AggregateOverlayDiagramInstance instance = mock(AggregateOverlayDiagramInstance.class);
    when(instance.parentEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.svg()).thenReturn("Svg");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
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
    verify(instance).kind();
    verify(instance).parentEntityReference();
    verify(instance).svg();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(AggregateOverlayDiagramInstance)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    AggregateOverlayDiagramInstance instance = mock(AggregateOverlayDiagramInstance.class);
    when(instance.parentEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.svg()).thenReturn("Svg");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
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
    verify(instance).kind();
    verify(instance).parentEntityReference();
    verify(instance).svg();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#from(AggregateOverlayDiagramInstance)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    AggregateOverlayDiagramInstance instance = mock(AggregateOverlayDiagramInstance.class);
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.svg()).thenReturn("Svg");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).kind();
    verify(instance).parentEntityReference();
    verify(instance).svg();
    ImmutableAggregateOverlayDiagramInstance buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#parentEntityReference(EntityReference)}
   */
  @Test
  void testBuilderParentEntityReference() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Builder#svg(String)}
   */
  @Test
  void testBuilderSvg() {
    // Arrange
    ImmutableAggregateOverlayDiagramInstance.Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.svg("Svg"));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance#copyOf(AggregateOverlayDiagramInstance)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AggregateOverlayDiagramInstance instance = mock(AggregateOverlayDiagramInstance.class);
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.svg()).thenReturn("Svg");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualCopyOfResult = ImmutableAggregateOverlayDiagramInstance
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).kind();
    verify(instance).parentEntityReference();
    verify(instance).svg();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance#copyOf(AggregateOverlayDiagramInstance)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AggregateOverlayDiagramInstance instance = mock(AggregateOverlayDiagramInstance.class);
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.diagramId()).thenReturn(1L);
    when(instance.svg()).thenReturn("Svg");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualCopyOfResult = ImmutableAggregateOverlayDiagramInstance
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramId();
    verify(instance).kind();
    verify(instance).parentEntityReference();
    verify(instance).svg();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).diagramId());
  }

  /**
   * Method under test: {@link ImmutableAggregateOverlayDiagramInstance.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).kind());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAggregateOverlayDiagramInstance.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramInstance.Json actualJson = new ImmutableAggregateOverlayDiagramInstance.Json();

    // Assert
    assertNull(actualJson.diagramId);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.svg);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.parentEntityReference);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#parentEntityReference()}
   */
  @Test
  void testJsonParentEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).parentEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregateOverlayDiagramInstance.Json#svg()}
   */
  @Test
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregateOverlayDiagramInstance.Json()).svg());
  }
}
