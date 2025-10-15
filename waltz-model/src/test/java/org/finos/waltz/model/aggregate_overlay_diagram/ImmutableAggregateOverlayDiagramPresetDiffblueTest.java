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
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramPreset.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramPreset.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramPresetDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        actualIdResult
            .id(id)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableAggregateOverlayDiagramPreset.lastUpdatedBy());
    assertEquals("42", actualImmutableAggregateOverlayDiagramPreset.externalId());
    assertEquals("Filter Config", actualImmutableAggregateOverlayDiagramPreset.filterConfig());
    assertEquals("Name", actualImmutableAggregateOverlayDiagramPreset.name());
    assertEquals("Overlay Config", actualImmutableAggregateOverlayDiagramPreset.overlayConfig());
    assertEquals("Provenance", actualImmutableAggregateOverlayDiagramPreset.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableAggregateOverlayDiagramPreset.description());
    assertEquals(1L, actualImmutableAggregateOverlayDiagramPreset.diagramId().longValue());
    assertSame(lastUpdatedAt, actualImmutableAggregateOverlayDiagramPreset.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#diagramId(Long)}.
   *
   * <p>Method under test: {@link Builder#diagramId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(Long)"})
  void testBuilderDiagramId() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#filterConfig(String)}.
   *
   * <ul>
   *   <li>When {@code Filter Config}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#filterConfig(String)}
   */
  @Test
  @DisplayName("Test Builder filterConfig(String); when 'Filter Config'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.filterConfig(String)"})
  void testBuilderFilterConfig_whenFilterConfig_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act
    Builder actualFilterConfigResult = builderResult.filterConfig("Filter Config");

    // Assert
    assertSame(builderResult, actualFilterConfigResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramPreset)} with {@code
   * AggregateOverlayDiagramPreset}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagramPreset)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregateOverlayDiagramPreset) with 'AggregateOverlayDiagramPreset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramPreset)"})
  void testBuilderFromWithAggregateOverlayDiagramPreset() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramPreset)} with {@code
   * AggregateOverlayDiagramPreset}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagramPreset)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregateOverlayDiagramPreset) with 'AggregateOverlayDiagramPreset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramPreset)"})
  void testBuilderFromWithAggregateOverlayDiagramPreset2() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description(null)
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset);
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset);
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset);
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset);
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description(null)
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset);
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset);
    ImmutableAggregateOverlayDiagramPreset actualImmutableAggregateOverlayDiagramPreset2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramPreset2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();
    Optional<Long> id = Optional.of(1L);

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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#overlayConfig(String)}.
   *
   * <ul>
   *   <li>When {@code Overlay Config}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#overlayConfig(String)}
   */
  @Test
  @DisplayName("Test Builder overlayConfig(String); when 'Overlay Config'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overlayConfig(String)"})
  void testBuilderOverlayConfig_whenOverlayConfig_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramPreset.builder();

    // Act
    Builder actualOverlayConfigResult = builderResult.overlayConfig("Overlay Config");

    // Assert
    assertSame(builderResult, actualOverlayConfigResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#copyOf(AggregateOverlayDiagramPreset)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramPreset#copyOf(AggregateOverlayDiagramPreset)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AggregateOverlayDiagramPreset); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.copyOf(AggregateOverlayDiagramPreset)"
  })
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAggregateOverlayDiagramPreset instance =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualCopyOfResult =
        ImmutableAggregateOverlayDiagramPreset.copyOf(instance);

    // Assert
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
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagramPreset#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset2 =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableAggregateOverlayDiagramPreset, immutableAggregateOverlayDiagramPreset2);
    assertEquals(
        immutableAggregateOverlayDiagramPreset.hashCode(),
        immutableAggregateOverlayDiagramPreset2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagramPreset#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableAggregateOverlayDiagramPreset, immutableAggregateOverlayDiagramPreset);
    int expectedHashCodeResult = immutableAggregateOverlayDiagramPreset.hashCode();
    assertEquals(expectedHashCodeResult, immutableAggregateOverlayDiagramPreset.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(2L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("Name")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Name")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramPreset,
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramPreset.equals(Object)",
    "int ImmutableAggregateOverlayDiagramPreset.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableAggregateOverlayDiagramPreset");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#description()}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#diagramId()}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#externalId()}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#filterConfig()}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#lastUpdatedBy()}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#name()}
   *   <li>{@link ImmutableAggregateOverlayDiagramPreset#overlayConfig()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAggregateOverlayDiagramPreset.description()",
    "Long ImmutableAggregateOverlayDiagramPreset.diagramId()",
    "String ImmutableAggregateOverlayDiagramPreset.externalId()",
    "String ImmutableAggregateOverlayDiagramPreset.filterConfig()",
    "String ImmutableAggregateOverlayDiagramPreset.lastUpdatedBy()",
    "String ImmutableAggregateOverlayDiagramPreset.name()",
    "String ImmutableAggregateOverlayDiagramPreset.overlayConfig()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    String actualDescriptionResult = immutableAggregateOverlayDiagramPreset.description();
    Long actualDiagramIdResult = immutableAggregateOverlayDiagramPreset.diagramId();
    String actualExternalIdResult = immutableAggregateOverlayDiagramPreset.externalId();
    String actualFilterConfigResult = immutableAggregateOverlayDiagramPreset.filterConfig();
    String actualLastUpdatedByResult = immutableAggregateOverlayDiagramPreset.lastUpdatedBy();
    String actualNameResult = immutableAggregateOverlayDiagramPreset.name();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("42", actualExternalIdResult);
    assertEquals("Filter Config", actualFilterConfigResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Overlay Config", immutableAggregateOverlayDiagramPreset.overlayConfig());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualDiagramIdResult.longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#id()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAggregateOverlayDiagramPreset.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
  @MethodsUnderTest({"Long Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramId());
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
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#filterConfig()}.
   *
   * <p>Method under test: {@link Json#filterConfig()}
   */
  @Test
  @DisplayName("Test Json filterConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.filterConfig()"})
  void testJsonFilterConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().filterConfig());
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
   * Test Json {@link Json#overlayConfig()}.
   *
   * <p>Method under test: {@link Json#overlayConfig()}
   */
  @Test
  @DisplayName("Test Json overlayConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.overlayConfig()"})
  void testJsonOverlayConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayConfig());
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
   * Test {@link ImmutableAggregateOverlayDiagramPreset#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableAggregateOverlayDiagramPreset.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
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
   * Test {@link ImmutableAggregateOverlayDiagramPreset#provenance()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAggregateOverlayDiagramPreset.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#toString()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAggregateOverlayDiagramPreset.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AggregateOverlayDiagramPreset{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " provenance=Provenance, diagramId=1, externalId=42, overlayConfig=Overlay Config, filterConfig=Filter"
            + " Config}",
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithDescriptionResult =
        immutableAggregateOverlayDiagramPreset.withDescription("42");

    // Assert
    assertEquals(immutableAggregateOverlayDiagramPreset, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("42")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithDescriptionResult =
        immutableAggregateOverlayDiagramPreset.withDescription("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withDiagramId(Long)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withDiagramId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withDiagramId(Long)"
  })
  void testWithDiagramId() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithDiagramIdResult =
        immutableAggregateOverlayDiagramPreset.withDiagramId(1L);

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withDiagramId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withDiagramId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDiagramId(Long); when forty-two; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withDiagramId(Long)"
  })
  void testWithDiagramId_whenFortyTwo_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithDiagramIdResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .withDiagramId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithDiagramIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithDiagramIdResult.lastUpdatedBy());
    assertEquals("42", actualWithDiagramIdResult.externalId());
    assertEquals("Filter Config", actualWithDiagramIdResult.filterConfig());
    assertEquals("Name", actualWithDiagramIdResult.name());
    assertEquals("Overlay Config", actualWithDiagramIdResult.overlayConfig());
    assertEquals("Provenance", actualWithDiagramIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramIdResult.description());
    assertEquals(42L, actualWithDiagramIdResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("0123456789ABCDEF")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithExternalIdResult =
        immutableAggregateOverlayDiagramPreset.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withExternalId(String)"
  })
  void testWithExternalId_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithExternalIdResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Filter Config", actualWithExternalIdResult.filterConfig());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Overlay Config", actualWithExternalIdResult.overlayConfig());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withFilterConfig(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withFilterConfig(String)}
   */
  @Test
  @DisplayName("Test withFilterConfig(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withFilterConfig(String)"
  })
  void testWithFilterConfig() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithFilterConfigResult =
        immutableAggregateOverlayDiagramPreset.withFilterConfig("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithFilterConfigResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withFilterConfig(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withFilterConfig(String)}
   */
  @Test
  @DisplayName(
      "Test withFilterConfig(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withFilterConfig(String)"
  })
  void testWithFilterConfig_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithFilterConfigResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .withFilterConfig("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithFilterConfigResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithFilterConfigResult.lastUpdatedBy());
    assertEquals("42", actualWithFilterConfigResult.externalId());
    assertEquals("42", actualWithFilterConfigResult.filterConfig());
    assertEquals("Name", actualWithFilterConfigResult.name());
    assertEquals("Overlay Config", actualWithFilterConfigResult.overlayConfig());
    assertEquals("Provenance", actualWithFilterConfigResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithFilterConfigResult.description());
    assertEquals(1L, actualWithFilterConfigResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithIdResult =
        immutableAggregateOverlayDiagramPreset.withId(optional);

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(2L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithIdResult =
        immutableAggregateOverlayDiagramPreset.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("42", actualWithIdResult.externalId());
    assertEquals("Filter Config", actualWithIdResult.filterConfig());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Overlay Config", actualWithIdResult.overlayConfig());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithIdResult =
        immutableAggregateOverlayDiagramPreset.withId(1L);

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withId(long)"
  })
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithIdResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("42", actualWithIdResult.externalId());
    assertEquals("Filter Config", actualWithIdResult.filterConfig());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Overlay Config", actualWithIdResult.overlayConfig());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramPreset#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithLastUpdatedAtResult =
        immutableAggregateOverlayDiagramPreset.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAggregateOverlayDiagramPreset, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithLastUpdatedByResult =
        immutableAggregateOverlayDiagramPreset.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithLastUpdatedByResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.externalId());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Filter Config", actualWithLastUpdatedByResult.filterConfig());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Overlay Config", actualWithLastUpdatedByResult.overlayConfig());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1L, actualWithLastUpdatedByResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithNameResult =
        immutableAggregateOverlayDiagramPreset.withName("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withName(String)"
  })
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithNameResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Filter Config", actualWithNameResult.filterConfig());
    assertEquals("Overlay Config", actualWithNameResult.overlayConfig());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withOverlayConfig(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withOverlayConfig(String)}
   */
  @Test
  @DisplayName("Test withOverlayConfig(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withOverlayConfig(String)"
  })
  void testWithOverlayConfig() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("42")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithOverlayConfigResult =
        immutableAggregateOverlayDiagramPreset.withOverlayConfig("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithOverlayConfigResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withOverlayConfig(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withOverlayConfig(String)}
   */
  @Test
  @DisplayName(
      "Test withOverlayConfig(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withOverlayConfig(String)"
  })
  void testWithOverlayConfig_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithOverlayConfigResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .withOverlayConfig("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithOverlayConfigResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithOverlayConfigResult.lastUpdatedBy());
    assertEquals("42", actualWithOverlayConfigResult.externalId());
    assertEquals("42", actualWithOverlayConfigResult.overlayConfig());
    assertEquals("Filter Config", actualWithOverlayConfigResult.filterConfig());
    assertEquals("Name", actualWithOverlayConfigResult.name());
    assertEquals("Provenance", actualWithOverlayConfigResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithOverlayConfigResult.description());
    assertEquals(1L, actualWithOverlayConfigResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    ImmutableAggregateOverlayDiagramPreset immutableAggregateOverlayDiagramPreset =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("42")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithProvenanceResult =
        immutableAggregateOverlayDiagramPreset.withProvenance("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramPreset, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramPreset#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramPreset#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramPreset ImmutableAggregateOverlayDiagramPreset.withProvenance(String)"
  })
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAggregateOverlayDiagramPreset actualWithProvenanceResult =
        ImmutableAggregateOverlayDiagramPreset.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .filterConfig("Filter Config")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .overlayConfig("Overlay Config")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.externalId());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Filter Config", actualWithProvenanceResult.filterConfig());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals("Overlay Config", actualWithProvenanceResult.overlayConfig());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.diagramId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }
}
