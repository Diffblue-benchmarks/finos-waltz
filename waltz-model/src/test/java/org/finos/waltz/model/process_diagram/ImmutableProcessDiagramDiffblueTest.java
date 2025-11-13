package org.finos.waltz.model.process_diagram;

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
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagram.Builder;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagram.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#layoutData(String)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagram Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.layoutData(String)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualExternalIdResult =
        ImmutableProcessDiagram.builder()
            .createdAt(createdAt)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualLayoutDataResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data");
    Optional<String> layoutData = Optional.of("42");
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        actualLayoutDataResult.layoutData(layoutData).name("Name").provenance("Provenance").build();

    // Assert
    assertEquals("2020-03-01", actualImmutableProcessDiagram.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualImmutableProcessDiagram.createdBy());
    assertEquals("Name", actualImmutableProcessDiagram.name());
    assertEquals("Provenance", actualImmutableProcessDiagram.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableProcessDiagram.description());
    assertEquals(EntityKind.ALL, actualImmutableProcessDiagram.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualImmutableProcessDiagram.diagramKind());
    assertSame(createdAt, actualImmutableProcessDiagram.createdAt());
    assertSame(lastUpdatedAt, actualImmutableProcessDiagram.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   *
   * <ul>
   *   <li>When {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName(
      "Test Builder createdBy(String); when 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy_whenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    // Act
    Builder actualCreatedByResult = builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertSame(builderResult, actualCreatedByResult);
  }

  /**
   * Test Builder {@link Builder#diagramKind(ProcessDiagramKind)}.
   *
   * <p>Method under test: {@link Builder#diagramKind(ProcessDiagramKind)}
   */
  @Test
  @DisplayName("Test Builder diagramKind(ProcessDiagramKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramKind(ProcessDiagramKind)"})
  void testBuilderDiagramKind() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    // Act
    Builder actualDiagramKindResult = builderResult.diagramKind(ProcessDiagramKind.WALTZ_SPARX);

    // Assert
    assertSame(builderResult, actualDiagramKindResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((CreatedProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException());
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_givenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
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
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
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
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description(null)
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
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
    Builder builderResult = ImmutableProcessDiagram.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagram)} with {@code ProcessDiagram}.
   *
   * <p>Method under test: {@link Builder#from(ProcessDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagram) with 'ProcessDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagram)"})
  void testBuilderFromWithProcessDiagram() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagram)} with {@code ProcessDiagram}.
   *
   * <p>Method under test: {@link Builder#from(ProcessDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagram) with 'ProcessDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagram)"})
  void testBuilderFromWithProcessDiagram2() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description(null)
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableProcessDiagram actualImmutableProcessDiagram =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableProcessDiagram);
    ImmutableProcessDiagram actualImmutableProcessDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagram2);
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
    Builder builderResult = ImmutableProcessDiagram.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
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
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
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
    Builder builderResult = ImmutableProcessDiagram.builder();

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
    Builder builderResult = ImmutableProcessDiagram.builder();
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
    Builder builderResult = ImmutableProcessDiagram.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#layoutData(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#layoutData(Optional)}
   */
  @Test
  @DisplayName("Test Builder layoutData(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.layoutData(Optional)"})
  void testBuilderLayoutDataWithOptional() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagram.builder();
    Optional<String> layoutData = Optional.of("42");

    // Act
    Builder actualLayoutDataResult = builderResult.layoutData(layoutData);

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
    Builder builderResult = ImmutableProcessDiagram.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#copyOf(ProcessDiagram)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#copyOf(ProcessDiagram)}
   */
  @Test
  @DisplayName("Test copyOf(ProcessDiagram); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.copyOf(ProcessDiagram)"})
  void testCopyOf_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    ImmutableProcessDiagram instance =
        ImmutableProcessDiagram.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualCopyOfResult = ImmutableProcessDiagram.copyOf(instance);

    // Assert
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
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Test {@link ImmutableProcessDiagram#createdAt()}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableProcessDiagram.createdAt()"})
  void testCreatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualCreatedAtResult =
        ImmutableProcessDiagram.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}, and {@link
   * ImmutableProcessDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagram#equals(Object)}
   *   <li>{@link ImmutableProcessDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();
    ImmutableProcessDiagram immutableProcessDiagram2 =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableProcessDiagram, immutableProcessDiagram2);
    assertEquals(immutableProcessDiagram.hashCode(), immutableProcessDiagram2.hashCode());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}, and {@link
   * ImmutableProcessDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagram#equals(Object)}
   *   <li>{@link ImmutableProcessDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableProcessDiagram, immutableProcessDiagram);
    int expectedHashCodeResult = immutableProcessDiagram.hashCode();
    assertEquals(expectedHashCodeResult, immutableProcessDiagram.hashCode());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Name")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Name")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Provenance")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagram,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableProcessDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagram.equals(Object)",
    "int ImmutableProcessDiagram.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableProcessDiagram");
  }

  /**
   * Test {@link ImmutableProcessDiagram#externalId()}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableProcessDiagram.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableProcessDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setDiagramKind(ProcessDiagramKind.WALTZ_SPARX);
    Optional<String> layoutData = Optional.of("42");
    json.setLayoutData(layoutData);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableProcessDiagram actualFromJsonResult = ImmutableProcessDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) CreatedAt is {@code null}.
   *   <li>Then return createdBy is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) CreatedAt is 'null'; then return createdBy is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonCreatedAtIsNull_thenReturnCreatedByIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setCreatedAt(null);
    json.setCreatedBy("Json");
    json.setDiagramKind(ProcessDiagramKind.WALTZ_SPARX);
    Optional<String> layoutData = Optional.of("42");
    json.setLayoutData(layoutData);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableProcessDiagram actualFromJsonResult = ImmutableProcessDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualFromJsonResult.diagramKind());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Test {@link ImmutableProcessDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Id is of forty-two.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Id is of forty-two; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonIdIsOfFortyTwo_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setDiagramKind(ProcessDiagramKind.WALTZ_SPARX);
    Optional<String> layoutData = Optional.of("42");
    json.setLayoutData(layoutData);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableProcessDiagram actualFromJsonResult = ImmutableProcessDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Kind is {@code null}.
   *   <li>Then return kind is {@code PROCESS_DIAGRAM}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Kind is 'null'; then return kind is 'PROCESS_DIAGRAM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonKindIsNull_thenReturnKindIsProcessDiagram() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setDiagramKind(ProcessDiagramKind.WALTZ_SPARX);
    Optional<String> layoutData = Optional.of("42");
    json.setLayoutData(layoutData);
    json.setKind(null);

    // Act
    ImmutableProcessDiagram actualFromJsonResult = ImmutableProcessDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.PROCESS_DIAGRAM, actualFromJsonResult.kind());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.fromJson(Json)"})
  void testFromJson_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setDescription(null);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setDiagramKind(ProcessDiagramKind.WALTZ_SPARX);
    Optional<String> layoutData = Optional.of("42");
    json.setLayoutData(layoutData);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableProcessDiagram actualFromJsonResult = ImmutableProcessDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ExternalId is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.fromJson(Json)"})
  void testFromJson_whenJsonExternalIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setExternalId(null);
    json.setProvenance("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setDiagramKind(ProcessDiagramKind.WALTZ_SPARX);
    Optional<String> layoutData = Optional.of("42");
    json.setLayoutData(layoutData);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableProcessDiagram actualFromJsonResult = ImmutableProcessDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) LayoutData is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) LayoutData is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.fromJson(Json)"})
  void testFromJson_whenJsonLayoutDataIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setDiagramKind(ProcessDiagramKind.WALTZ_SPARX);
    json.setLayoutData(null);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableProcessDiagram actualFromJsonResult = ImmutableProcessDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.fromJson(Json)"})
  void testFromJson_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance(null);
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setDiagramKind(ProcessDiagramKind.WALTZ_SPARX);
    Optional<String> layoutData = Optional.of("42");
    json.setLayoutData(layoutData);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableProcessDiagram actualFromJsonResult = ImmutableProcessDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagram#createdBy()}
   *   <li>{@link ImmutableProcessDiagram#description()}
   *   <li>{@link ImmutableProcessDiagram#diagramKind()}
   *   <li>{@link ImmutableProcessDiagram#lastUpdatedBy()}
   *   <li>{@link ImmutableProcessDiagram#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableProcessDiagram.createdBy()",
    "String ImmutableProcessDiagram.description()",
    "ProcessDiagramKind ImmutableProcessDiagram.diagramKind()",
    "String ImmutableProcessDiagram.lastUpdatedBy()",
    "String ImmutableProcessDiagram.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    String actualCreatedByResult = immutableProcessDiagram.createdBy();
    String actualDescriptionResult = immutableProcessDiagram.description();
    ProcessDiagramKind actualDiagramKindResult = immutableProcessDiagram.diagramKind();
    String actualLastUpdatedByResult = immutableProcessDiagram.lastUpdatedBy();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedByResult);
    assertEquals("Name", immutableProcessDiagram.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualDiagramKindResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#id()}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableProcessDiagram.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   *
   * <p>Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdAt());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   *
   * <p>Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdBy());
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
  @MethodsUnderTest({"ProcessDiagramKind Json.diagramKind()"})
  void testJsonDiagramKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramKind());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
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
  @MethodsUnderTest({"Optional Json.layoutData()"})
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
   * Test {@link ImmutableProcessDiagram#kind()}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableProcessDiagram.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableProcessDiagram#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableProcessDiagram.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#layoutData()}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#layoutData()}
   */
  @Test
  @DisplayName("Test layoutData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableProcessDiagram.layoutData()"})
  void testLayoutData() {
    // Arrange and Act
    Optional<String> actualLayoutDataResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .layoutData();

    // Assert
    assertEquals("Layout Data", actualLayoutDataResult.get());
    assertTrue(actualLayoutDataResult.isPresent());
  }

  /**
   * Test {@link ImmutableProcessDiagram#provenance()}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableProcessDiagram.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableProcessDiagram#toString()}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableProcessDiagram.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ProcessDiagram{id=1, name=Name, externalId=42, provenance=Provenance, lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, createdAt=1970-01-01T00:00, createdBy=Jan 1, 2020 8:00am GMT+0100,"
            + " diagramKind=WALTZ_SPARX, layoutData=Layout Data, kind=ALL}",
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagram ImmutableProcessDiagram.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithCreatedAtResult =
        immutableProcessDiagram.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableProcessDiagram, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withCreatedBy(String)"})
  void testWithCreatedBy() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("42")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithCreatedByResult = immutableProcessDiagram.withCreatedBy("42");

    // Assert
    assertSame(immutableProcessDiagram, actualWithCreatedByResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withCreatedBy(String)"})
  void testWithCreatedBy_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutableProcessDiagram actualWithCreatedByResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withCreatedBy("42");

    // Assert
    LocalDateTime createdAtResult = actualWithCreatedByResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithCreatedByResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithDescriptionResult =
        immutableProcessDiagram.withDescription("42");

    // Assert
    assertEquals(immutableProcessDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("42")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithDescriptionResult =
        immutableProcessDiagram.withDescription("42");

    // Assert
    assertSame(immutableProcessDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withDiagramKind(ProcessDiagramKind)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withDiagramKind(ProcessDiagramKind)}
   */
  @Test
  @DisplayName("Test withDiagramKind(ProcessDiagramKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagram ImmutableProcessDiagram.withDiagramKind(ProcessDiagramKind)"
  })
  void testWithDiagramKind() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithDiagramKindResult =
        immutableProcessDiagram.withDiagramKind(ProcessDiagramKind.WALTZ_SPARX);

    // Assert
    assertSame(immutableProcessDiagram, actualWithDiagramKindResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableProcessDiagram actualWithExternalIdResult =
        immutableProcessDiagram.withExternalId(optional);

    // Assert
    assertSame(immutableProcessDiagram, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("External Id")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableProcessDiagram actualWithExternalIdResult =
        immutableProcessDiagram.withExternalId(optional);

    // Assert
    LocalDateTime createdAtResult = actualWithExternalIdResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithExternalIdResult =
        immutableProcessDiagram.withExternalId("42");

    // Assert
    assertSame(immutableProcessDiagram, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutableProcessDiagram actualWithExternalIdResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime createdAtResult = actualWithExternalIdResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableProcessDiagram actualWithIdResult = immutableProcessDiagram.withId(optional);

    // Assert
    assertSame(immutableProcessDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withId(Optional)"})
  void testWithIdWithOptional_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableProcessDiagram actualWithIdResult = immutableProcessDiagram.withId(optional);

    // Assert
    LocalDateTime createdAtResult = actualWithIdResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithIdResult = immutableProcessDiagram.withId(1L);

    // Assert
    assertSame(immutableProcessDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutableProcessDiagram actualWithIdResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    LocalDateTime createdAtResult = actualWithIdResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithKindResult = immutableProcessDiagram.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableProcessDiagram, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withKind(EntityKind)"})
  void testWithKind_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutableProcessDiagram actualWithKindResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    LocalDateTime createdAtResult = actualWithKindResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithKindResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagram ImmutableProcessDiagram.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithLastUpdatedAtResult =
        immutableProcessDiagram.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableProcessDiagram, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithLastUpdatedByResult =
        immutableProcessDiagram.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableProcessDiagram, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutableProcessDiagram actualWithLastUpdatedByResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime createdAtResult = actualWithLastUpdatedByResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withLayoutData(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withLayoutData(Optional)}
   */
  @Test
  @DisplayName("Test withLayoutData(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withLayoutData(Optional)"})
  void testWithLayoutDataWithOptional() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("42")
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableProcessDiagram actualWithLayoutDataResult =
        immutableProcessDiagram.withLayoutData(optional);

    // Assert
    assertSame(immutableProcessDiagram, actualWithLayoutDataResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withLayoutData(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withLayoutData(Optional)}
   */
  @Test
  @DisplayName(
      "Test withLayoutData(Optional) with 'optional'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withLayoutData(Optional)"})
  void testWithLayoutDataWithOptional_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableProcessDiagram actualWithLayoutDataResult =
        immutableProcessDiagram.withLayoutData(optional);

    // Assert
    LocalDateTime createdAtResult = actualWithLayoutDataResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithLayoutDataResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withLayoutData(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withLayoutData(String)}
   */
  @Test
  @DisplayName("Test withLayoutData(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withLayoutData(String)"})
  void testWithLayoutDataWithValue() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("42")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithLayoutDataResult =
        immutableProcessDiagram.withLayoutData("42");

    // Assert
    assertSame(immutableProcessDiagram, actualWithLayoutDataResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withLayoutData(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withLayoutData(String)}
   */
  @Test
  @DisplayName(
      "Test withLayoutData(String) with 'value'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withLayoutData(String)"})
  void testWithLayoutDataWithValue_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutableProcessDiagram actualWithLayoutDataResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withLayoutData("42");

    // Assert
    LocalDateTime createdAtResult = actualWithLayoutDataResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithLayoutDataResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("42")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableProcessDiagram actualWithNameResult = immutableProcessDiagram.withName("42");

    // Assert
    assertSame(immutableProcessDiagram, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withName(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withName(String)"})
  void testWithName_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutableProcessDiagram actualWithNameResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withName("42");

    // Assert
    LocalDateTime createdAtResult = actualWithNameResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableProcessDiagram#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableProcessDiagram immutableProcessDiagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("42")
            .build();

    // Act
    ImmutableProcessDiagram actualWithProvenanceResult =
        immutableProcessDiagram.withProvenance("42");

    // Assert
    assertSame(immutableProcessDiagram, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableProcessDiagram#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagram#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagram ImmutableProcessDiagram.withProvenance(String)"})
  void testWithProvenance_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutableProcessDiagram actualWithProvenanceResult =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime createdAtResult = actualWithProvenanceResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }
}
