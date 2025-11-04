package org.finos.waltz.model.process_diagram;

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
import java.time.LocalTime;
import java.util.Optional;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableProcessDiagram#builder()}
   *   <li>{@link ImmutableProcessDiagram#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableProcessDiagram#description(String)}
   *   <li>{@link ImmutableProcessDiagram#externalId(String)}
   *   <li>{@link ImmutableProcessDiagram#kind(EntityKind)}
   *   <li>{@link ImmutableProcessDiagram#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableProcessDiagram#layoutData(String)}
   *   <li>{@link ImmutableProcessDiagram#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableProcessDiagram.Builder actualBuilderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram.Builder actualExternalIdResult = actualBuilderResult
        .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableProcessDiagram.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableProcessDiagram.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableProcessDiagram.Builder actualLayoutDataResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .layoutData("Layout Data");
    Optional<String> layoutData = Optional.of("foo");
    ImmutableProcessDiagram.Builder actualLayoutDataResult2 = actualLayoutDataResult.layoutData(layoutData);

    // Assert
    assertSame(actualLayoutDataResult2, actualLayoutDataResult2.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#diagramKind(ProcessDiagramKind)}
   */
  @Test
  void testBuilderDiagramKind() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramKind(ProcessDiagramKind.WALTZ_SPARX));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ProcessDiagram)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.layoutData()).thenReturn(ofResult2);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableProcessDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ProcessDiagram)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ProcessDiagram instance = mock(ProcessDiagram.class);
    when(instance.layoutData()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).layoutData();
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ProcessDiagram)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.layoutData()).thenReturn(ofResult);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableProcessDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ProcessDiagram)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.layoutData()).thenReturn(emptyResult);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableProcessDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ProcessDiagram)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.layoutData()).thenReturn(ofResult2);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableProcessDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#from(ProcessDiagram)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.layoutData()).thenReturn(ofResult2);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableProcessDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagram.Builder#layoutData(Optional)}
   */
  @Test
  void testBuilderLayoutData() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();
    Optional<String> layoutData = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.layoutData(layoutData));
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableProcessDiagram.Builder builderResult = ImmutableProcessDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram#copyOf(ProcessDiagram)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.layoutData()).thenReturn(ofResult2);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram actualCopyOfResult = ImmutableProcessDiagram.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualCopyOfResult.diagramKind());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult5, toLocalDateResult);
    assertSame(ofResult3, toLocalDateResult2);
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram#copyOf(ProcessDiagram)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.layoutData()).thenReturn(ofResult);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram actualCopyOfResult = ImmutableProcessDiagram.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualCopyOfResult.diagramKind());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram#copyOf(ProcessDiagram)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.layoutData()).thenReturn(emptyResult);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram actualCopyOfResult = ImmutableProcessDiagram.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualCopyOfResult.diagramKind());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram#copyOf(ProcessDiagram)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.layoutData()).thenReturn(ofResult2);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram actualCopyOfResult = ImmutableProcessDiagram.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualCopyOfResult.diagramKind());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult3, toLocalDateResult2);
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram#copyOf(ProcessDiagram)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ProcessDiagram instance = mock(ProcessDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.layoutData()).thenReturn(ofResult2);
    when(instance.diagramKind()).thenReturn(ProcessDiagramKind.WALTZ_SPARX);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableProcessDiagram actualCopyOfResult = ImmutableProcessDiagram.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).diagramKind();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualCopyOfResult.diagramKind());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult5, toLocalDateResult);
    assertSame(ofResult3, toLocalDateResult2);
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).createdAt());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#createdBy()}
   */
  @Test
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).createdBy());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#diagramKind()}
   */
  @Test
  void testJsonDiagramKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).diagramKind());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#layoutData()}
   */
  @Test
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).layoutData());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableProcessDiagram.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableProcessDiagram.Json actualJson = new ImmutableProcessDiagram.Json();

    // Assert
    assertNull(actualJson.createdBy);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.diagramKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.layoutData.isPresent());
  }

  /**
   * Method under test: {@link ImmutableProcessDiagram.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableProcessDiagram.Json()).provenance());
  }
}
